package p6;
import Master.Tuple;

import java.util.Arrays;

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
    //int[] werSuchetDerFindet = {5, 7, 7, 8, 8, 8, 10};
    //System.out.println(suchProblem(werSuchetDerFindet,0,werSuchetDerFindet.length-1,10));
    //int[] mehrheit = {2, 2, 1, 1, 1, 2, 2, 9, 9, 9};
    //System.out.println(mehrheit(mehrheit));
        int[][] t = {{1,3}, {2,6}, {3,5},{8,10},{15,18}};
        t = termine(t);
        System.out.println(Arrays.deepToString(t));

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

        int q = (p+r)/2;

        if (a[q] == x) {
            if (q == a.length-1 || a[q+1] != x) {
                return q;
            } else {
                return sucheRechts(a,q+1,r,x);
            }
        }
        else if (a[q] > x) {
            return sucheRechts(a,p,q-1,x);
        }
        else {
            return sucheRechts(a,q+1,r,x);
        }
    }

    public static int mehrheit(int[] a){
        int number = a[0];
        int count = 1;
        if (a.length == 1) return a[0];
        else{
            for (int i = 0; i < a.length; i++) {
                if (a[i] != number) count--;
                else count++;
                if (count == 0) {
                    number = a[i];
                    count = 1;
                }
            }
        }
        return number;
    }

    public static int[][] termine(int[][] a ){
        //DEAD CODE
        /*
        int[] firstNums = new int[a.length];
        for (int i = 0; i < firstNums.length; i++) {
            firstNums[i] = a[i][0];
        }
        Arrays.sort(firstNums);
        int[][] b = new int[a.length][2];
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (firstNums[i] == a[j][0])
                    b[c] = a[j];
                c++;
            }

            b[i] = a[i]; //Arrays.copyOf(a[i],2);
            */
        Arrays.sort(a, (b, c) -> Integer.compare(b[0], c[0]));
        System.out.println(Arrays.deepToString(a));
        int[][] b = new int[a.length][a[0].length];
        b[0][0] = a[0][0];
        b[0][1] = a[0][1];
        int index = 0;
        for (int i = 1; i < a.length; i++) {
            if (b[index][1] >= a[i][0]){
                if (b[index][1] < a[i][1] ){
                    b[index][1] = a[i][1];
                }
            }
            else {
                index++;
                b[index][0] = a[i][0];
                b[index][1] = a[i][1];
            }
        }
        return Arrays.copyOf(b, index + 1); // damit keine (0,0) elemente am Ende stehen
        }
        public static int groessteTeilsummme(int[] a){
        int max = -Integer.MAX_VALUE;
        int sum = 0;
        int l,r;
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    sum = 0;
                    for (int k = 0; k < a.length; k++) {
                        sum += a[i];
                        if (sum>max){
                            max = sum;
                            l = i;
                            r = j;
                        }
                    }
                }
            }
            return max; //eigentlich auch l und r, also der Bereich aber kb
        }
    }
