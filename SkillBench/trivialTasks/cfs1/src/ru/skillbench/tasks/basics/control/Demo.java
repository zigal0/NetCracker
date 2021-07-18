package ru.skillbench.tasks.basics.control;

public class Demo {
    public static void main(String[] args) {
        ControlFlowStatements1Impl cfs1i = new ControlFlowStatements1Impl();
        System.out.println(cfs1i.getFunctionValue(6));
        System.out.println(cfs1i.getFunctionValue(-5));
        System.out.println(cfs1i.decodeWeekday(5));
        int[][] res = cfs1i.initArray();
        for (int[] col : res) {
            for (int i : col) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        res[2][3] = -3;
        System.out.println(cfs1i.getMinValue(res));
        System.out.println(cfs1i.calculateBankDeposit(5));
    }
}
