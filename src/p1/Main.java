package p1;

public class Main {


    public static void main(String[] args) {
        //System.out.println(fib(5));
        rueckwaertszaehler(4);
    }


    public static int fib(int i){
        if (i == 1 || i == 2) {
        return 1;
        }
        else return fib(i-1)+fib(i-2);
    }
    public static int fib2(int z){
        int[] array = new int[z+1];
        array[1] = 1;
        array[2] = 1;
        int result = 1;
        for (int i = 3; i <= z; i++) {
            array[i] = array[i-1]+array[i-2];
        }
        return array[z];
    }
    public static void rueckwaertszaehler(int n){
        System.out.println(n);
        if (n == 0){
            return;
        }
        else {
            rueckwaertszaehler(n-1);
        }
    }

    public static int[] ourSort(int[] a, int n){
        if (n == 1) return a;
        int x = a[n];
        ourSort(a, n-1);
        int j = n-1;
        while(j>0 && a[j] < x){
            a[j+1] = a[j];
            j--;
        }
        a[j+1] = x;
        return a;
    }


    public static void insertionSort(int[] a){
        int n = a.length;
        int x;
        int j;
        for (int i = 2; i <= n; i++) { //1. Elem sortiert, start bei n = 2
            j = i-1;
            x = a[i];
            while (j>0 && a[j]>x){
                a[j+1] = a[j];
                j--;

            }
            a[j+1] = x;
        }

    }
}
//safe irgendwo Fehler, untested;
