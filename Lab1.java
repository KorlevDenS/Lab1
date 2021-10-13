public class Lab1 {
    static long[] a;
    static  float[] x;

    public static void main(String[] args) {
        a = makeArrayFromAtoB(7,19);
        x = makeArrayOfAmount(15);
        printResults();
    }

    public static long[] makeArrayFromAtoB(long from, long to){
        int count = (int) ((to/2 + to % 2) - (from - 1)/2 + (from - 1) % 2);
        long[] array = new long[count];
        for (int i = 0; i < count; i++) {
            array[i] = to;
            to -= 2;
        }
        return array;
    }

    public static float[] makeArrayOfAmount(int amount) {
        float[] array = new float[amount];
        for (int i = 0; i < amount; i++) {
            array[i] = getRandomNumber();
        }
        return array;
    }

    public static float getRandomNumber() {
        float rand;
        rand = (float) (Math.random() * 10 - 2);
        return rand;
    }

    public static double[][] makeMatrix(int m, int n){
        double[][] matrix = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = getAnswer(a[i], x[j]);
            }
        }
        return matrix;
    }

    public static double getAnswer(long i, float j){
        double X;
        if (i == 17) {
            X = formula1(j);
        } else {
            if ((i == 7) || (i == 15) || (i == 19)) {
                X = formula2(j);
            } else {
                X = formula3(j);
            }
        }
        return X;
    }

    public static double formula1(double X) {
        double degree, number, result;
        number = (3 * Math.cos(Math.sin(X)))/(1 - Math.sin(Math.log(Math.abs(X))));
        degree = Math.log(Math.pow((Math.abs(X)/(2 * Math.PI)), 2));
        result = Math.pow(number, degree);
        return result;
    }

    public static double formula2(double X) {
        double result;
        result = Math.cos(Math.cbrt(X/(double) 3));
        return result;
    }

    public static double formula3(double X) {
        double number, degree, result;
        number = (Math.atan(Math.E * Math.cbrt(-Math.acos(Math.E*(X + 3) + 1))))/(double) 4;
        degree = (2 / (double)3)/(3/(double)4 - Math.cbrt(Math.pow(X,X)));
        result = Math.pow(number, degree);
        return result;
    }

    public static void printResults() {
        double[][] a = makeMatrix(7, 15);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.printf("%.2f", a[i][j]);
                System.out.print(" ");
            }
        }

    }

}
