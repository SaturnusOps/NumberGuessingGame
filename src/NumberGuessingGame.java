import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame
{
    static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to play a game? (yes/no):");
        String PlayaGame = scanner.nextLine();

        if (PlayaGame.equals("no")) {
            System.out.println("Maybe next time");
        }
        else {
            boolean Understood = false;
            while (!Understood){
                System.out.println("The Game is a Number Guessing Game. \n I choose a number between 0 and 100. \n You just have to guess it \n Did You understand? (yes/no):");
                String UnderstoodAnswer = scanner.nextLine();
                if (UnderstoodAnswer.equals("yes")) {
                    Understood = true;
                }
            }

            System.out.println("Choose a difficulty (easy/medium/hard):");
            String difficultySet = scanner.nextLine();
            if (difficultySet.equals("medium")) {
                System.out.println("You have 10 Attempts");
            }
            else if (difficultySet.equals("hard")){
                System.out.println("You have 8 Attempts");
            }

            Random random = new Random();
            int Number = random.nextInt(100) +1;
            int LowNumRange = 1 , HighNumRange = 100;
            boolean NumberGuessed = false;
            int Attempts = 1;
            while (!NumberGuessed){
                System.out.println("Enter a Number (" + LowNumRange + "/" + HighNumRange + "):");
                int GuessedNum = scanner.nextInt();
                if (GuessedNum == Number) {
                    System.out.println("You guessed correctly! \nThe Number was " + Number );
                    System.out.println("You got it in " + Attempts + " attempts");
                    NumberGuessed = true;
                }
                else {
                    Attempts = Attempts +1;
                    if (difficultySet.equals("medium") && Attempts >= 10){
                        NumberGuessed = true;
                        System.out.println("You ran out of Attempts\n You Lose");
                        System.out.println("The Number was " + Number);
                    }
                    else if (difficultySet.equals("hard") && Attempts >= 8) {
                        NumberGuessed = true;
                        System.out.println("You ran out of Attempts\n You Lose");
                        System.out.println("The Number was " + Number);
                    }
                    if (GuessedNum > LowNumRange && GuessedNum < Number){
                        LowNumRange = GuessedNum;
                    }
                    else if (GuessedNum > Number && GuessedNum < HighNumRange ) {
                        HighNumRange = GuessedNum;
                    }
                }
            }
        }
    }
}