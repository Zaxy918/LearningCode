public class Overload {
    public static void main(String[] args) {
        int a = 1, b = 2;
        int c = Overload.add(a, b);
        System.out.println(c);
    }
    public static int add(int a, int b){
        return a + b;
    }
    public static double add(double a, double b){
        return a + b;
    }
    /*
    
    public static double add(int a, int b){
        return a + b;
    }

    This is not an overload.This is an error.The return value can't distinguish two function.
     */
}
