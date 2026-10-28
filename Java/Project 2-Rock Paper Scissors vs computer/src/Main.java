import java.util.Random;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        int score[] = {0,0};

        // 1 = rock, 2 = paper, 3 = scissors
        Random random = new Random();

        while(true) {
            System.out.println("Score: "+score[0]+" - "+score[1]);
            System.out.println("1- Rock\n2- Paper\n3- Scissors");
            System.out.print("Enter your choice: ");
            Scanner input = new Scanner(System.in);
            int userChoice = input.nextInt();
            if(userChoice == 0 || userChoice == -1) {
                System.out.println("Exiting...");
                return;
            }
            if (userChoice < 1 || userChoice > 3) {
                System.out.println("Invalid input");
                continue;
            }
            int compChoice= random.nextInt(3);
            System.out.println("Computer chose: " + Pick(compChoice)+"\n You Chose: "+Pick(userChoice));
            if(userChoice == compChoice) {
                System.out.println("It's a tie!");
            }
            else if((userChoice == 1 && compChoice == 2) || (userChoice == 2 && compChoice == 3) || (userChoice == 3 && compChoice == 1)) {
                System.out.println("You won!");
                score[0]++;
            }
            else {
                System.out.println("You lost!");
                score[1]++;
            }
        }
    }
    public static String Pick(int Pick) {
        if(Pick == 1) {
            return "Rock";
        }
        else if(Pick == 2) {
            return "Paper";
        }
        else {
            return "Scissors";
        }
    }
}