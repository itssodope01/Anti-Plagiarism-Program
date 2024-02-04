package compare;
public class code2 {
    public static int subtract(int a, int b) {
        return a - b;
    }
    public static double divide(double a, double b) {
            return a / b;
    }
    public static void main(String[] args) {
        int result = subtract(10, 4);
        System.out.println("Subtraction Result: " + result);
        try {
            double divisionResult = divide(8.0, 2.0);
            System.out.println("Division Result: " + divisionResult);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}