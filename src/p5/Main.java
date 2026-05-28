package p5;

public class Main {
    public static void main(String[] args) {

    }
    public static int fib2(int n){ //assume index 0 is unuesed
        int[] a = new int[n+1];
        a[1] = 1;
        a[2] = 1;
        for (int i = 3; i < n; i++) {
            a[i] = a[i-1] + a[i-2];
        }
    return a[n];
    }
}
