package compare;
public class code1 {
    public static int add(int a, int b) {
        return a + b;
    }
    public static int multiply(int a, int b) {
        return a * b;
    }
    public static void main(String[] args) {
        int result = add(5, 7);
        System.out.println("Addition Result: " + result);
        result = multiply(3, 4);
        System.out.println("Multiplication Result: " + result);
    }
}