package p2;

import java.io.PipedOutputStream;

public class Main {
    public static void main(String[] args) {
        //System.out.println(fakultaet(3));
        int[] a = {0,2,3,4,5,6,7,8}; // 35, da Index bei 1 beginnen soll
        System.out.println(sumArray(a));
        System.out.println(sumArrayR(a,a.length-1)); //length-1 muss jeweils übergeben werden damit die indizes mit den Vorgaben der VL uebereinstimmen (Start bei 1, etc.)
        System.out.println(methodeMitK(a, a.length-1));
        System.out.println(komischeSummenformel(69));
        System.out.println(durchschnitt(a, a.length-1));

    }
    public static int fakultaet(int n){
        if (n == 1 || n == 0) return 1;
        return n * fakultaet(n-1);
    } // seems to work.
    public static int sumArray(int[] a){
        int sum = 0;
        for (int i = 1; i < a.length; i++) { // in der VL ab 1
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
        for (int i = 1; i < a.length ; i++) {
            if (total + a[i] <= m){
                k++;                //Index gesucht!
                total = total+ a[i];
            }else break;
        }
        return k;
    }
    public static double komischeSummenformel(int n){
        if (n == 1) return 1;
        else return ((double) 1 /(n*n)) + komischeSummenformel(n-1);
    }

    public static double durchschnitt(int[] a, int n){
        return (double) sum(a, n) / count(a, n);
    }
    public static int sum(int[] a, int n){
        if (n == 1) return a[n];
        else return a[n] + sum(a, n-1);
    }
    public static int count(int[] a, int n){
        if (n==1) return 1;
        else return 1 + count(a, n-1);
    }
    public static int potenz(int a, int b){
        if (b==1) return a;
        else return a*potenz(a, b-1);
    }
    public static double binom(int n, int k){
        if (k==1) return n;
        if (k==0) return 1;
        return binom(n-1,k-1) + binom(n-1,k);
    }

}
