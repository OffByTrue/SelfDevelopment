import java.util.Random;
import java.util.Scanner;

class Main{
    public static void main(String[] A) {
        int guessCount = 0,guess=0,randomNumber;
        Random rand = new Random();

        java.util.Scanner input = new java.util.Scanner(System.in);
        randomNumber = rand.nextInt(100)+1;
        while(guess != randomNumber){
            System.out.println("guess a number between 1 and 100");
            System.out.print((guessCount+1)+" guess: ");
            guess = input.nextInt();
            guessCount++;
            if(guess == randomNumber)   System.out.println("you guessed it");
            else if (guess < randomNumber)  System.out.println("too low");
            else if (guess > randomNumber)  System.out.println("too high");
            else System.out.println("invalid input");
        }

        System.out.println("you guessed it in "+guessCount+" tries");
    }
}