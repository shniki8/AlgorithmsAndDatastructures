package p6;


public class Main {
    public static void main(String[] args) {
    //int[] test = {0,1,2,3,4,5,6,7,8,9};
    //int[] test2 = {0,1,2,3,4,5,6,7,8,9};
    //zirkulation(test, test.length-1);
    //zirkulationLsg(test2, test2.length-1);
    //System.out.println(compareArrays(test, test2));
    //printArray(test);
    //printArray(test2);
    //int[] aktienVerlauf = {7,1,5,3,6,4};
    //System.out.println(aktienHandelBesser(aktienVerlauf));
    //int[] berg = {1,2,3,1,2,4,1,2};
    //System.out.println(findeIrgendeinenPeak(berg,0,berg.length-1));
    //int[] summeOderSo = {2,7,11,19};
    //System.out.println(summenRaetsel(summeOderSo,30));
    //Tuple<Integer> t = new Tuple<>(1,69);
    //System.out.println(t);
        int[] werSuchetDerFindet = {5, 7, 7, 8, 8, 8, 10};
        System.out.println(suchProblem(werSuchetDerFindet,0,werSuchetDerFindet.length-1,10));
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
    public static boolean summenRaetsel(int[] a, int x){
        int left = 0,right = a.length-1;
        int y;
        for (int i = 0; i < a.length; i++) {
            y = a[left] + a[right];
            if (x == y) return true;
            else if(y>x) right = right-1;
            else left = left+1;
        }
        return  false;
    }
    public static Tuple<Integer> suchProblem(int[] a, int p, int r, int x){
        int min = sucheLinks(a,p,r,x);
        int max = sucheRechts(a,p,r,x);
        return new Tuple<Integer>(min,max);
    }
    private static int sucheLinks(int[] a, int p, int r, int x) {
        if (p > r) {
            return -1;
        }
        int q = (p+r)/2;
        if (a[q] == x) {
            if (q == 0 || a[q-1] != x) {
                return q;
            } else {
                return sucheLinks(a,p,q-1,x);
            }
        }
        else if (a[q] > x) {
            return sucheLinks(a,p,q-1,x);
        }
        else {
            return sucheLinks(a,q+1,r,x);
        }
    }
    private static int sucheRechts(int[] a, int p, int r, int x) {
        if (p > r) return -1;

        int q = (p + r) / 2;

        if (a[q] == x) {
            if (q == a.length - 1 || a[q + 1] != x) {
                return q;
            } else {
                return sucheRechts(a, q + 1, r, x);
            }
        }
        else if (a[q] > x) {
            return sucheRechts(a, p, q - 1, x);
        }
        else {
            return sucheRechts(a, q + 1, r, x);
        }
    }


}
