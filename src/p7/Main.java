package p7;

public class Main {
    public static void main(String[] args) {
        //int a = 99999999, b = 99999999;
        //System.out.println(multSchulmethode(a,b,6));

    }
    public static long multSchulmethode(int a, int b, int n){
        long l = 0;
        String s = String.valueOf(b);
        for (int i = 0; i < n; i++) {
            l += a*Character.getNumericValue(s.charAt(i))*Math.pow(10,i);
        }
        return l;
    }
    public static int[][] matrixMult(int[][] m, int[][] n){ // nxn
        int[][] result = new int[m.length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                int sum = 0;
                for (int k = 0; k < m.length; k++) {
                    sum += m[i][k] * n[k][j];
                    result[i][j] = sum;
                }
            }
        }
        return result;
    }
}
