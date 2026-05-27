package p2;

public class Main {
    public static void main(String[] args) {
        System.out.println(fakultaet(3));
    }
    public static int fakultaet(int n){
        if (n == 1 || n == 0) return 1;
        return n * fakultaet(n-1);
    } // seems to work.
    public static int sumArray(int[] a){
        int sum = 0;
        for (int i = 1; i <= a.length; i++) { // in der VL ab 1
            sum += a[i];
        }
        return sum;
    }
    public static int sumArrayR(int[] a, int n){
        if(n==1) return a[n];
        else return a[n] + sumArrayR(a, n-1);
    }
    public static int methodeMitK(int[] a, int m){
        int k = 0;
        int total = 0;
        for (int i = 0; i <=a.length ; i++) {
            if (total + a[i] <= m){
                k++;                //Index gesucht!
                total = total+ a[i];
            }else break;
        }
        return k;
    }
}
