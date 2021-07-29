package ru.skillbench.tasks.javaapi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeNodeImpl implements TreeNode {

    private TreeNode parent;
    private List<TreeNode> children;
    private boolean expanded;
    private Object data;

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public TreeNode getRoot() {
        if (parent == null) {
            return null;
        }
        TreeNode currentTreeNode = parent;
        TreeNode result = parent;
        while (currentTreeNode != null) {
            result = currentTreeNode;
            currentTreeNode = currentTreeNode.getParent();
        }
        return result;
    }

    @Override
    public boolean isLeaf() {
        return children == null || children.size() == 0;
    }

    @Override
    public int getChildCount() {
        if (children == null) {
            return 0;
        }
        return children.size();
    }

    @Override
    public Iterator<TreeNode> getChildrenIterator() {
        if (children == null) {
            return null;
        }
        return children.iterator();
    }

    @Override
    public void addChild(TreeNode child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        child.setParent(this);
        children.add(child);
    }

    @Override
    public boolean removeChild(TreeNode child) {
        int index = children.indexOf(child);
        if (index == -1) {
            return false;
        }
        TreeNode removed = children.remove(index);
        removed.setParent(null);
        return true;
    }

    @Override
    public boolean isExpanded() {
        return expanded;
    }

    @Override
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
        if (children != null && children.size() != 0) {
            for (TreeNode child : children) {
                child.setExpanded(expanded);
            }
        }
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String getTreePath() {
        StringBuilder result = new StringBuilder(dataCheck(this.getData()));
        TreeNode currentTreeNode = parent;
        while (currentTreeNode != null) {
            result.insert(0, "->").insert(0, dataCheck(currentTreeNode.getData()));
            currentTreeNode = currentTreeNode.getParent();
        }
        return result.toString();
    }

    private String dataCheck(Object data) {
        if (data == null) {
            return "empty";
        }
        return data.toString();
    }

    @Override
    public TreeNode findParent(Object data) {
        TreeNode currentTreeNode = this;
        if (data == null) {
            while (currentTreeNode != null && currentTreeNode.getData() != null) {
                currentTreeNode = currentTreeNode.getParent();
            }
        } else {
            while (currentTreeNode != null && !data.equals(currentTreeNode.getData())) {
                currentTreeNode = currentTreeNode.getParent();
            }
        }
        return currentTreeNode;
    }

    @Override
    public TreeNode findChild(Object data) {
        if (isLeaf() || children.size() == 0) {
            return null;
        }
        TreeNode result;
        for (TreeNode item : children) {
            if (data == null) {
                if (item.getData() == null) {
                    return item;
                }
                result = item.findChild(null);
            } else {
                if (data.equals(item.getData())) {
                    return item;
                }
                result = item.findChild(data);
            }
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}
