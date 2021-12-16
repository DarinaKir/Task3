import java.util.Scanner;
public class Exercise5 {
    public static final int AMOUNT_CHARS_TO_REPLACE = 2;
    public static void main(String[] args) {
        System.out.println(changeCharsAccordingToFrequencies());
    }

    public static int amountCharInString (String someString, char someChar){
        int counter = 0;
        for (int i = 0; i < someString.length(); i++) {
            if (someChar == someString.charAt(i)){
                counter++;
            }
        }
        return counter;
    }

    public static String changeCharsAccordingToFrequencies (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type something : ");
        String typedString = scanner.nextLine();
        String replacedString = "";
        if (typedString.length()-amountCharInString(typedString,' ') > 1){
            char [] highestFrequencyChars = new char[AMOUNT_CHARS_TO_REPLACE];
            for (int i = 0; i < typedString.length(); i++) {
                if (typedString.charAt(i) != ' ' && typedString.charAt(i) != highestFrequencyChars[0] && typedString.charAt(i) != highestFrequencyChars[1]){
                    if (amountCharInString(typedString,highestFrequencyChars[0]) < amountCharInString(typedString,typedString.charAt(i))){
                        highestFrequencyChars[1]=highestFrequencyChars[0];
                        highestFrequencyChars[0] = typedString.charAt(i);
                    }else if (amountCharInString(typedString,highestFrequencyChars[1]) < amountCharInString(typedString,typedString.charAt(i))){
                        highestFrequencyChars[1] = typedString.charAt(i);
                    }
                }
            }
            for (int i = 0; i < typedString.length(); i++) {
                char charToAdd = typedString.charAt(i);
                for (int j = 0; j < highestFrequencyChars.length; j++) {
                    if (charToAdd == highestFrequencyChars[j]){
                        charToAdd = highestFrequencyChars[(j-1)*-1];
                        break;
                    }
                }
                replacedString+=charToAdd;
            }
        }else replacedString = typedString;
        return replacedString;
    }
}
