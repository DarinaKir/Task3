import java.util.Random;
import java.util.Scanner;
public class Exercise9 {
    public static void main(String[] args) {
        Random random = new Random();
        int code = codeRaffle();
        int level = chooseLevel();
        int severalAttempts = 0;
        if (level==4){
            severalAttempts = random.nextInt(21)+5;
        }else {
            severalAttempts = 20 - (5*(level-1));
        }
        do {
            if (level!=4){
                System.out.println("You have " +severalAttempts+ " attempts.");
            }
            int guess = guessingAbsorption();
            int accurateGuesses = amountAccurateGuesses(code, guess);
            if (accurateGuesses == 4) {
                break;
            }
            int partialGuesses = 0;
            boolean isNeedAFine = false;
            for (int i = guess; i > 0 ; i/=10) {
                if (isDigitExist(i%10,code)){
                    partialGuesses++;
                }
                if (!isNeedAFine){
                    isNeedAFine= (isDigitExist(i%10,i/10));
                }
            }
            if (isNeedAFine) {
                System.out.println("The guess is wrong. There is a typed number that repeats itself - you received a fine of 2 attempts.");
                severalAttempts-=2;
                continue;
            }
            partialGuesses = partialGuesses-accurateGuesses;
            System.out.println(accurateGuesses+" digits were accurately guessed and "+partialGuesses+" digits were partially guessed.");
            severalAttempts--;
        }while (severalAttempts>0);
        if (severalAttempts <= 0){
            System.out.println("You lost ... The code is: "+code);
        }else {
            System.out.println("You win !!!");
        }
    }

    public static int codeRaffle (){
        Random random = new Random();
        int code = 0;
        int randomNumber = 0;
        for (int i = 0; i < 4; i++) {
            do {
                randomNumber = random.nextInt(6)+1;
            }while (isDigitExist(randomNumber,code));
            code = (code*10) + randomNumber;
        }
        return code;
    }

    public static boolean isDigitExist (int digit, int number){
        boolean isExist = false;
        while (number>0 && !isExist){
            isExist = (digit==(number%10));
            number = number/10;
        }
        return isExist;
    }

    public static int guessingAbsorption (){
        Scanner scanner = new Scanner(System.in);
        int guess = 0;
        boolean chekGuess = false;
        System.out.println("Type your guess (4-digit code, each ranging from 1-6):");
        while (!chekGuess){
            guess = scanner.nextInt();
            chekGuess = true;
            if (guess>9999 || guess<1000){
                System.out.println("The amount of numbers is incorrect. Type your guess again (4-digit code):");
                chekGuess = false;
                continue;
            }
            for (int i = guess; i > 0; i=i/10) {
                if (i%10>6 || i%10<1){
                    System.out.println("There is a digit that is not in the appropriate range. Type your guess again (each digit in the range 1-6):");
                    chekGuess = false;
                    break;
                }
            }
        }
        return guess;
    }

    public static int chooseLevel (){
        Scanner scanner = new Scanner(System.in);
        int chosenLevel = 0;
        System.out.println("Hello ! Your goal in this game - to guess the code.");
        System.out.println("The code has 4 digits that are different from each other, with each digit in the range 1-6.");
        System.out.println("(Note that if you type the same number more than once in one guess - you will be fined in 2 attempts).");
        System.out.println("You will be given several attempts depending on the stage you choose:");
        do{
            System.out.println("1 - Easy track: 20 opportunities");
            System.out.println("2 - Medium track: 15 opportunities");
            System.out.println("3 - Hard track: 10 opportunities");
            System.out.println("4 - Surprising Track: The number of attempts will be random (in the range of 5-25) and will not be printed per player at any point in the game.");
            System.out.println("Type which level you choose:");
            chosenLevel = scanner.nextInt();
            if (chosenLevel>4 || chosenLevel<1){
                System.out.println("The level you typed - does not exist.");
            }
        }while (chosenLevel>4 || chosenLevel<1);
        return chosenLevel;
    }

    public static int amountAccurateGuesses (int code, int guess){
        int amount = 0;
        for (int i = code; i >0; i=i/10) {
            if (i%10==guess%10) {
                amount++;
            }
            guess/=10;
        }
        return amount;
    }
}
