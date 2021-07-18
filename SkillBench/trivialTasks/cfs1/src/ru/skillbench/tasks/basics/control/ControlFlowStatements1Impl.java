package ru.skillbench.tasks.basics.control;

public class ControlFlowStatements1Impl implements ControlFlowStatements1 {
    @Override
    public float getFunctionValue(float x) {
        float f;
        if (x > 0) {
            f = (float) (2 * Math.sin(x));
        } else {
            f = 6 - x;
        }
        return f;
    }

    @Override
    public String decodeWeekday(int weekday) {
        switch (weekday) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                return "Error";
        }
    }

    @Override
    public int[][] initArray() {
        int[][] res = new int[8][5];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                res[i][j] = i * j;
            }
        }
        return res;
    }

    @Override
    public int getMinValue(int[][] array) {
        int minValue = array[0][0];
        for (int[] col : array) {
            for (int num : col) {
                if (minValue > num) {
                    minValue = num;
                }
            }
        }
        return minValue;
    }

    @Override
    public BankDeposit calculateBankDeposit(double P) {
        BankDeposit bankDeposit = new BankDeposit();
        bankDeposit.amount = 1000;
        do {
            bankDeposit.years++;
            bankDeposit.amount += (bankDeposit.amount / 100) * P;
        } while (bankDeposit.amount < 5000);
        return bankDeposit;
    }
}
