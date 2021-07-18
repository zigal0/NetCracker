package ru.skillbench.tasks.basics.control;

public class ControlFlowStatements2Impl implements ControlFlowStatements2 {
    @Override
    public int getFunctionValue(int x) {
        int f;
        if (x < -2 || x > 2) {
            f = 2 * x;
        } else {
            f = -3 * x;
        }
        return f;
    }

    @Override
    public String decodeMark(int mark) {
        switch (mark) {
            case 1:
                return "Fail";
            case 2:
                return "Poor";
            case 3:
                return "Satisfactory";
            case 4:
                return "Good";
            case 5:
                return "Excellent";
            default:
                return "Error";
        }
    }

    @Override
    public double[][] initArray() {
        double[][] res = new double[5][8];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = Math.pow(i, 4) - Math.sqrt(j);
            }
        }
        return res;
    }

    @Override
    public double getMaxValue(double[][] array) {
        double maxValue = array[0][0];
        for (double[] col : array) {
            for (double num : col) {
                if (maxValue < num) {
                    maxValue = num;
                }
            }
        }
        return maxValue;
    }

    @Override
    public Sportsman calculateSportsman(float P) {
        float distanceByDay = 10;
        Sportsman sportsman = new Sportsman();
        do {
            sportsman.addDay(distanceByDay);
            distanceByDay += distanceByDay / 100 * P;
        } while (sportsman.getTotalDistance() < 200);
        return sportsman;
    }
}
