import java.util.Scanner;
public class Exercise8 {
    public static void main(String[] args) {
        System.out.println(mostCommonSubString(receptionOfStrings()));
    }
    public static String [] addToArray (String [] stringArray, String stringToAdd){
        String [] newArray = new String[stringArray.length+1];
        for (int i = 0; i < stringArray.length; i++) {
            newArray[i] = stringArray[i];
        }
        newArray[newArray.length-1] = stringToAdd;
        return newArray;
    }

    public static String [] receptionOfStrings (){
        Scanner scanner = new Scanner(System.in);
        String [] stringArray = new String[0];
        System.out.println("Type a string (not less than 4 characters) :");
        String typedString = scanner.nextLine();
        while (typedString.length()>3){
            stringArray = addToArray(stringArray,typedString);
            System.out.println("Type another string (if you want to stop type a string less than 4 characters) :");
            typedString = scanner.nextLine();
        }
        return stringArray;
    }

    public static String [] createSubStrings (String originalString){
        String [] subStringArray = new String[0];
        for (int i = 0; i < originalString.length()-1; i++) {
            String subString = "" + originalString.charAt(i);
            for (int j = i+1; j < originalString.length(); j++) {
                subString += originalString.charAt(j);
                subStringArray = addToArray(subStringArray,subString);
            }
        }
        return subStringArray;
    }

    public static int amountOfSubString (String [] stringArray, String subString, int index){
        int amount =0;
        for (int i = index; i < stringArray.length; i++) {
            String [] subStringArray = createSubStrings(stringArray[i]);
            for (int j = 0; j < subStringArray.length; j++) {
                if (areStringsEqual(subString,subStringArray[j])){
                    amount++;
                }
            }
        }
        return amount;
    }

    public static boolean areStringsEqual (String firstString, String secondString){
        boolean isEqual= (firstString.length()==secondString.length());
        for (int i = 0; i < firstString.length() && isEqual; i++) {
            isEqual = (firstString.charAt(i)==secondString.charAt(i));
        }
        return isEqual;
    }

    public static String mostCommonSubString (String [] stringArray){
        String mostSubString = "---";
        if (stringArray.length>0){
            mostSubString = createSubStrings(stringArray[0])[0];
            int maxAmountSubString = amountOfSubString(stringArray,mostSubString,0);
            for (int i = 0; i < stringArray.length; i++) {
                String [] subStringArray = createSubStrings(stringArray[i]);
                for (int j = 0; j < subStringArray.length; j++) {
                    int currentStringAmount = amountOfSubString(stringArray,subStringArray[j],i);
                    if (!(areStringsEqual(mostSubString,subStringArray[j])) && (maxAmountSubString < currentStringAmount  || (maxAmountSubString == currentStringAmount && mostSubString.length()<subStringArray[j].length()))){
                        maxAmountSubString = currentStringAmount;
                        mostSubString = subStringArray[j];
                    }
                }
            }
            if (maxAmountSubString == 1){
                mostSubString = "There is no sub-string that repeats more than once.";
            }
        }

        return mostSubString;
    }
}
