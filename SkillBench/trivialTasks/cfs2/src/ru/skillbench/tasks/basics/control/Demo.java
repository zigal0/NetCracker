package ru.skillbench.tasks.basics.control;

public class Demo {
    public static void main(String[] args) {
        ControlFlowStatements2Impl cfs2i = new ControlFlowStatements2Impl();
        System.out.println(cfs2i.getFunctionValue(0));
        System.out.println(cfs2i.getFunctionValue(3));
        System.out.println(cfs2i.decodeMark(3));
        double[][] res = cfs2i.initArray();
        for (double[] col : res) {
            for (double i : col) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println(cfs2i.getMaxValue(res));
        System.out.println(cfs2i.calculateSportsman(5));
    }
}
