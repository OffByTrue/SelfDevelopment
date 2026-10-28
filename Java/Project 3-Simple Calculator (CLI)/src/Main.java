import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true) {
//            if(input.nextInt() == -1) break;   REQUEST FOR NEXT CALC Check
            System.out.println("Enter two numbers");
            int a = input.nextInt();
            int b = input.nextInt();
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
        }
    }
    static double add(int a, int b) {return a+b;}
    static double sub(int a,int b){return a-b;}
    static double mul(int a, int b){return a*b;}
    static double div(int a,int b)throws Exception{
        if(a==0 || b==0) throw new Exception("Division by zero is not allowed");
        return a/b;
    }
    static double mod(int a,int b)throws Exception{
        if(a==0 || b==0) throw new Exception("Undefined: Division by zero is not allowed");
        return a%b;
    }
}