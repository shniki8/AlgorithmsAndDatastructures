package p6;

public class Main {
    public static void main(String[] args) {
    int[] test = {0,1,2,3,4,5,6,7,8,9};
    int[] test2 = {0,1,2,3,4,5,6,7,8,9};

    //zirkulation(test, test.length-1);
    //zirkulationLsg(test2, test2.length-1);
    //System.out.println(compareArrays(test, test2));
    //printArray(test);
    //printArray(test2);
    //int[] aktienVerlauf = {7,1,5,3,6,4};
    //System.out.println(aktienHandelBesser(aktienVerlauf));
    int[] berg = {1,2,3,1,2,4,1,2};
    System.out.println(findeIrgendeinenPeak(berg,0,berg.length-1));

    }
    public static int binSearch(int[] a,int p, int r, int x){ // ab index 0 jetzt aber
        int q = (int)(p + r)/2;
        if (x == a[q]) return q;
        else {
            if (x<a[q]){
                return binSearch(a,p,q,x);
            }else {
                return binSearch(a,q+1,r,x);
            }

        }
    }

    public static int binSearchMuster(int[] a,int p, int r, int x){
        if (p == r) return p;
        else {
            int q = (int)(p+r)/2;
            if (x<= a[q]) return binSearchMuster(a,p,q,x);
            else return binSearchMuster(a,q+1,r,x);
        }
    }
    public static void zirkulation(int[] a, int n){ //ab index 1, ist ja eh call by reference
        int temp = a[n];
        for (int i = n; i >=2 ; i--) {
            a[i] = a[i-1];
        }
        a[1]=temp;
    }
    public static void zirkulationLsg( int[] a, int n){
        int last = a[n];
        for (int i = n-1; i >= 1 ; i--) {
            a[i+1] = a[i];
        }
        a[1] = last;
    }

    public static boolean compareArrays(int[] a, int[] b){
        if (a.length!=b.length) return false;
        else{
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) return false;
            }
            return true;
        }
    }
    public static void printArray(int[] a){ //ab index 1
        System.out.print(" { ");
        for (int i = 1; i < a.length ; i++) {
            System.out.print(a[i] + " ");
            if (i != a.length) System.out.print(", ");
        }
        System.out.print(" } ");
        System.out.println();
    }
    //extraaufgaben
    public static int aktienHandel(int[] a){
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            int aktuell = 0;
            for (int j = i+1; j < a.length; j++) {
                if (a[i] < a[j]){
                    aktuell = a[j]-a[i];
                    if (max<aktuell){ max = aktuell;}
                }
            }
        }
        return max;
    }
    public static int aktienHandelBesser(int[] a){
        int max = 0;
        int buy = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            int x = a[i]-buy;
            if (a[i]<buy) {
                buy = a[i];
            }
            else if (x > 0) {
                if (max<x){
                    max = x;
                }
            }
        }
        return max;
    }
    public static int aktienHandelnochBesser(int[] a) {
        int maxGewinn = 0;
        int minPreis = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            minPreis = Math.min(minPreis, a[i]);
            maxGewinn = Math.max(maxGewinn, a[i] - minPreis);
        }
        return maxGewinn;
    }
    public static int findeIrgendeinenPeak(int[] a, int p, int r){
        if (p == r) return p;
        else{
            int q = (int)(p+r)/2;
            if (a[q] > a[q+1]){
                return findeIrgendeinenPeak(a,p,q);
            }
            else{
                return findeIrgendeinenPeak(a, q+1, r);
            }
        }

    }
}
