import java.util.Scanner;
public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = -1;
        do {
            System.out.println("Enter a (positive) number :");
            number = scanner.nextInt();
        }while (number<0);
        System.out.println("The factors of the number : ");
        int [] factorsArray = createFactorsArray(number);
        if (factorsArray.length>0){
            for (int i = 0; i < factorsArray.length; i++) {
                System.out.print(factorsArray[i] + " ");
                if (i != factorsArray.length - 1) {
                    System.out.print("* ");
                }
            }
        }else {
            System.out.print("---");
        }
    }
    public static int numberOfFactors (int number){
        int amountOfFactors = 1;
        if (number == 1 || number==0) amountOfFactors= 0;
        for (int i = 2; i < number; i++) {
            if (isPrimeNumber(i) && number%i==0){
                amountOfFactors = 1+numberOfFactors(number/i);
                break;
            }
        }
        return amountOfFactors;
    }
    public static boolean isPrimeNumber (int number){
        boolean isPrime = true;
        for (int i = 2; i < number && isPrime; i++) {
            isPrime = (number%i!=0);
        }
        return isPrime;
    }

    public static int [] createFactorsArray (int number){
        int [] factorsArray = new int[numberOfFactors(number)];
        for (int i = 0; i < factorsArray.length; i++) {
            for (int j = 2; j <= number; j++) {
                if (isPrimeNumber(j) && number%j==0){
                    factorsArray[i]=j;
                    number=number/j;
                    break;
                }
            }
        }
        return factorsArray;
    }
}
