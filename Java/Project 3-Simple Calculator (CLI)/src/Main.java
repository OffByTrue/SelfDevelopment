import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int again =0;
        while(again==0) {
            System.out.println("Enter two numbers");
            double a = input.nextDouble();
            double b = input.nextDouble();
            System.out.println("Enter operation");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulus");
            switch (input.nextInt()) {
                case 1:
                    System.out.println("Result: " + add(a, b));
                    break;
                case 2:
                    System.out.println("Result: " + sub(a, b));
                    break;
                case 3:
                    System.out.println("Result: " + mul(a, b));
                    break;
                case 4:
                    try {
                        System.out.println("Result: " + div(a, b));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Result: " + mod(a, b));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid operation");
            }
            System.out.print("Do you want to continue? (y/n): ");
            again = (input.next().charAt(0)=='y')? 0:-1;
        }

    }
    static double add(double a, double b) {return a+b;}
    static double sub(double a,double b){return a-b;}
    static double mul(double a, double b){return a*b;}
    static double div(double a,double b)throws Exception{
        if(a==0 || b==0) throw new Exception("Division by zero is not allowed");
        return a/b;
    }
    static double mod(double a,double b)throws Exception{
        if(a==0 || b==0) throw new Exception("Undefined: Division by zero is not allowed");
        return a%b;
    }
}