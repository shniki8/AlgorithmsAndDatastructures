package p2;

public class Main {
    public static void main(String[] args) {
        System.out.println(fakultaet(3));
    }
    public static int fakultaet(int n){
        if (n == 1 || n == 0) return 1;
        return n * fakultaet(n-1);
    } // seems to work.


}
