package ad211.dovbyshev;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Scanner scanMenu = new Scanner(System.in);

        int menu;
        while (true){
            System.out.println("\n\n1. Parts 1-4 (input 1 string)\n2. Part 5 (input 2 strings)\n3. Exit");
            menu = scanMenu.nextInt();

            switch(menu){
                case 1:
                    System.out.print("Enter string: ");
                    String string = input.nextLine();

                    System.out.println("1. Ends with ed?: " + isEndsWithEd(string));
                    System.out.println("2. Sum of the numbers: " + getSumOfNumbers(string));
                    System.out.println("3. Length of the longest block: " + getTheLongestBlock(string));
                    System.out.println("4. Separate words: ");
                    separateWords(string);
                    break;
                case 2:
                    System.out.print("\n\nEnter the first string: ");
                    String firstString = input.nextLine();
                    System.out.print("Enter the second string: ");
                    String secondString = input.nextLine();

                    System.out.println("\nResult: " + connectTwoStrings(firstString, secondString));
                    break;
                case 3:
                    System.out.print("\nClosing the program...");
                    System.exit(0);
                default:
                    System.out.print("\nNon-existent menu number");
            }
        }
    }

    static boolean isEndsWithEd(String string) {
        return string.endsWith("ed");
    }

    static int getSumOfNumbers(String string){
        int sum = 0;

        char[] charArray = string.toCharArray();
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                int num = Integer.parseInt(String.valueOf(c));
                sum += num;
            }
        }
        return sum;
    }

    static int getTheLongestBlock(String string){
        int index = 0;
        int max = 0;

        char[] charArray = string.toCharArray();
        for (int i = 1; i < charArray.length; i++){
            if (charArray[i] == charArray[i - 1]) {
                index++;
                if (max < index) {
                    max = index;
                }
            }
            else {
                index = 0;
            }
        }
        return max + 1;
    }

    static void separateWords(String string){
        char[] charArray = string.toCharArray();
        for (char word : charArray) {
            System.out.print(word);
            if (word == ' ')
                System.out.println();
        }
    }

    static String connectTwoStrings(String firstString, String secondString) {
        String result;
        StringBuilder doString = new StringBuilder();
        for (int i = 0; i < firstString.length() && i < secondString.length(); i++) {
            doString.append(firstString.charAt(i));
            doString.append(secondString.charAt(i));
        }
        result = doString.toString();

        if (firstString.length() > secondString.length()) {
            result += firstString.substring(secondString.length());
        }
        else if (firstString.length() < secondString.length()) {
            result += secondString.substring(firstString.length());
        }
        return result;
    }
}
