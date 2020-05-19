package Homework6;

import java.util.Scanner;



public class Homework6Main {
    static int menuOptionNumber;                 //глобална променлива за избиране на цифра от менютата
    static int length;                          //глобална променлива за дължина на масива
    int[] seriesOfNumbersArray = new int[0];   //нов масив, използван за записване на растящите/намаляващите/равните поредици
                                                //елементи от задачите с числен масив
    static int[] arrayOfNumberUserElements = new int[0];      //default инициализация на масива с числа
    static String[] arrayOfLetterUserElements = new String[0];      //default инициализация на string масива


    /**
     * @author Martin Petrov
     * main метод
     */
    public static void main(String[] args) {
        printMainMenu();
    }



    /**
     * @author Martin Petrov
     * Метод за принтиране към конзолата на главното меню
     */
    public static void printMainMenu() {
        Scanner userChoice = new Scanner(System.in);
        System.out.println("Main menu");
        System.out.println("----------------------");
        System.out.println("01. Work with array of numbers");
        System.out.println("02. Work with array of letters");
        System.out.println("03. Exit the program");

        System.out.println(" ");
        System.out.println("Please choose one of the menu options: ");
        menuOptionNumber = userChoice.nextInt();
        do {
            if (menuOptionNumber < 1 | menuOptionNumber > 3) {
                System.out.println("Incorrect number input, please try again! ");
                menuOptionNumber = userChoice.nextInt();
            }
        } while (menuOptionNumber < 1 | menuOptionNumber > 3);

        switch (menuOptionNumber) {
            case 1:
                defineNumberArray();
                do {
                    printNumbersSubMenu();
                } while (menuOptionNumber != 7);
                break;

            case 2:
                defineLetterArray();
                do {
                    printLettersSubMenu();
                } while (menuOptionNumber != 7);
                break;

            case 3:
                exitProgram();
                break;

            default:
                System.err.println("Incorrect option chosen, please try again!");
                break;
        }
    }




    /**
     * @author Martin Petrov
     * Метод за принтиране не подменюто за обработка на числен масив
     */
    public static void printNumbersSubMenu() {
        System.out.println("Choose what you would like to do with your array: ");
        System.out.println("------------------------------------------------------");
        System.out.println("01. Print only the simple numbers to the console ");
        System.out.println("02. Print the most common element of the array ");
        System.out.println("03. Print the longest series of growing elements from the array ");
        System.out.println("04. Print the longest series of declining elements from the array ");
        System.out.println("05. Print the longest series of equal elements from the array");
        System.out.println("06. Print a series of numbers, which sum is equal to a randomly generated number ");
        System.out.println("07. Go back to the main menu");

        Scanner userInput = new Scanner(System.in);
        menuOptionNumber = userInput.nextInt();
        if (menuOptionNumber == 1) {
            printOnlySimpleNumbers();
        }
        if (menuOptionNumber == 2) {
            printMostCommonNumber();
        }
        if (menuOptionNumber == 3) {
            printLongestGrowingSeriesOfNumbers();
        }
        if (menuOptionNumber == 4) {
            printLongestDecreasingSeriesOfNumbers();
        }
        if (menuOptionNumber == 5) {
            printLongestSeriesOfEqualNumbers();
        }
        if (menuOptionNumber == 6) {
            getArrayNumberSumEqualToRandom();
        }
        if (menuOptionNumber == 7) {
            goBackToMainMenu();
        }
    }




    /**
     * @author Martin Petrov
     * Метод за принтиране на подменюто на string масив
     */
    public static void printLettersSubMenu() {
        System.out.println("Choose what you would like to do with your array: ");
        System.out.println("------------------------------------------------------");
        System.out.println("01. Reverse the characters of each word in the array ");
        System.out.println("02. Print the number of repeating characters for each word in the array ");
        System.out.println("03. Print the length of each word in the array ");
        System.out.println("04. Print the number of repeating words in the array ");
        System.out.println("05. Go back to the main menu");

        Scanner userInput = new Scanner(System.in);
        menuOptionNumber = userInput.nextInt();
        if (menuOptionNumber == 1) {
            printArrayWordsInReverse();
        }
        if (menuOptionNumber == 2) {
            //printDoubledLettersInWords();
            System.out.println("Operation unavailable");
        }
        if (menuOptionNumber == 3) {
            countNumberOfLetters();
        }
        if (menuOptionNumber == 4) {
            countAllRepeatingWords();
        }
        if (menuOptionNumber == 5) {
            goBackToMainMenu();
        }
    }




    /**
     * @author Martin Petrov
     * метод за дефиниране и инициализиране на string масив
     */
    public static void defineLetterArray() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please input how many words you would like to operate with: ");
        length = userInput.nextInt();
        arrayOfLetterUserElements = new String[length];

        for (int i = 0; i < length; i++) {
            System.out.println("Please enter word number " + i + " of your array: ");
            String userWord = userInput.next();
            arrayOfLetterUserElements[i] = userWord;
        }
        System.out.print("Your word array is: ");
        for (int i = 0; i < length; i++) {
            System.out.print(arrayOfLetterUserElements[i] + " , ");
        }
    }




    /**
     * @author Martin Petrov
     * метод за дефиниране и инициализиране на числен масив
     */
    public static void defineNumberArray() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please input how many numbers you would like to operate with: ");
        length = userInput.nextInt();
        arrayOfNumberUserElements = new int[length];

        for (int i = 0; i < length; i++) {
            System.out.println("Please enter element number " + i + " of your array: ");
            int userElement = userInput.nextInt();
            do {
                if (userElement < 0 | userElement > 10000) {
                    System.out.println("Please enter a number bigger than 0 and less than 10 000");
                    userElement = userInput.nextInt();
                }
            } while (userElement < 0 | userElement > 10000);
            arrayOfNumberUserElements[i] = userElement;
        }
        System.out.print("Your element array is: ");
        for (int i = 0; i < length; i++) {
            System.out.print(arrayOfNumberUserElements[i] + " , ");
        }
    }



    /**
     * @author Martin Petrov
     * метод за терминиране на програмата
     */
    //main-menu option 3
    public static void exitProgram() {
        System.exit(0);
    }



    /**
     * @author Martin Petrov
     * метод за задача 1 от обработка на числен масив
     */
    //task 1 for number array
    public static void printOnlySimpleNumbers() {
        System.out.println("The simple numbers in your array are: ");
        for (int i = 0; i < length; i++) {
            if (arrayOfNumberUserElements[i] > 1 & arrayOfNumberUserElements[i] % 2 != 0 | arrayOfNumberUserElements[i] == 2) {
                System.out.print(arrayOfNumberUserElements[i] + " , ");
            }
        }
    }



    /**
     * @author Martin Petrov
     * метод за задача 2 от обработка на числен масив
     */
    //task 2 for number array
    public static void printMostCommonNumber() {
        int temp;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 1; j--) {
                if (arrayOfNumberUserElements[j - 1] > arrayOfNumberUserElements[j]) {
                    temp = arrayOfNumberUserElements[j - 1];
                    arrayOfNumberUserElements[j - 1] = arrayOfNumberUserElements[j];
                    arrayOfNumberUserElements[j] = temp;
                }
            }

        }

        int previousElement = arrayOfNumberUserElements[0];
        int commonElement = arrayOfNumberUserElements[0];
        int numberOfElementEncounters = 1;
        int maxNumberOfElementEncounters = 1;

        for (int i = 1; i < length; i++) {
            if (arrayOfNumberUserElements[i] == previousElement) {
                numberOfElementEncounters++;
            } else {
                if (numberOfElementEncounters > maxNumberOfElementEncounters) {
                    commonElement = arrayOfNumberUserElements[i - 1];
                    maxNumberOfElementEncounters = numberOfElementEncounters;
                }
                previousElement = arrayOfNumberUserElements[i];
                numberOfElementEncounters = 1;
            }
        }

        System.out.println("The most common element of the array is: ");
        if (numberOfElementEncounters > maxNumberOfElementEncounters) {
            System.out.println(arrayOfNumberUserElements[length - 1]);
        } else {
            System.out.println(commonElement);
        }

    }



    /**
     * @author Martin Petrov
     * метод за задача 3 от обработка на числен масив
     */
    //task 3 for number array
    public static void printLongestGrowingSeriesOfNumbers() {
        int arrayTraverseStartPosition = 0;
        int arrayTraverseFinalPosition = 0;
        int updatedStartPosition = 0;
        int updatedEndPosition = 0;

        System.out.println("The biggest increasing sequence of numbers in the array is: ");
        for (int i = 1; i < length; ++i) {
            if (arrayOfNumberUserElements[i] <= arrayOfNumberUserElements[i - 1]) {
                if (arrayTraverseFinalPosition - arrayTraverseStartPosition > updatedEndPosition - updatedStartPosition) {
                    updatedEndPosition = arrayTraverseFinalPosition;
                    updatedStartPosition = arrayTraverseStartPosition;
                }
                arrayTraverseStartPosition = i;
                arrayTraverseFinalPosition = i;
            } else {
                arrayTraverseFinalPosition = i;
            }
        }

        int[] seriesOfNumbersArray = new int[updatedEndPosition - updatedStartPosition + 1];
        for (int i = updatedStartPosition; i <= updatedEndPosition; ++i) {
            seriesOfNumbersArray[i - updatedStartPosition] = arrayOfNumberUserElements[i];
        }

        for (int i = 0; i < seriesOfNumbersArray.length; i++) {
            System.out.print(seriesOfNumbersArray[i] + " , ");
        }

    }



    /**
     * @author Martin Petrov
     * метод за задача 4 от обработка на числен масив
     */
    //task 4 for number array
    public static void printLongestDecreasingSeriesOfNumbers() {
        int arrayTraverseStartPosition = 0;
        int arrayTraverseFinalPosition = 0;
        int updatedStartPosition = 0;
        int updatedEndPosition = 0;

        System.out.println("The biggest decreasing sequence of numbers in the array is: ");
        for (int i = 1; i < length; ++i) {
            if (arrayOfNumberUserElements[i] > arrayOfNumberUserElements[i - 1]) {
                if (arrayTraverseFinalPosition - arrayTraverseStartPosition > updatedEndPosition - updatedStartPosition) {
                    updatedEndPosition = arrayTraverseFinalPosition;
                    updatedStartPosition = arrayTraverseStartPosition;
                }
                arrayTraverseStartPosition = i;
                arrayTraverseFinalPosition = i;
            } else {
                arrayTraverseFinalPosition = i;
            }
        }

        int[] seriesOfNumbersArray = new int[updatedEndPosition - updatedStartPosition + 1];
        for (int i = updatedStartPosition; i <= updatedEndPosition; ++i) {
            seriesOfNumbersArray[i - updatedStartPosition] = arrayOfNumberUserElements[i];
        }

        for (int i = 0; i < seriesOfNumbersArray.length; i++) {
            System.out.print(seriesOfNumbersArray[i] + " , ");
        }

    }



    /**
     * @author Martin Petrov
     * метод за задача 5 от обработка на числен масив
     */
    //task 5 for number array
    public static void printLongestSeriesOfEqualNumbers() {
        int arrayTraverseStartPosition = 0;
        int arrayTraverseFinalPosition = 0;
        int updatedStartPosition = 0;
        int updatedEndPosition = 0;

        System.out.println("The biggest sequence of equal numbers in the array is: ");
        for (int i = 1; i < length; ++i) {
            if (arrayOfNumberUserElements[i] == arrayOfNumberUserElements[i - 1]) {
                if (arrayTraverseFinalPosition - arrayTraverseStartPosition > updatedEndPosition - updatedStartPosition) {
                    updatedEndPosition = arrayTraverseFinalPosition;
                    updatedStartPosition = arrayTraverseStartPosition;
                }
                arrayTraverseStartPosition = i;
                arrayTraverseFinalPosition = i;
            } else {
                arrayTraverseFinalPosition = i;
            }
        }

        int[] seriesOfNumbersArray = new int[updatedEndPosition - updatedStartPosition + 1];
        for (int i = updatedStartPosition; i <= updatedEndPosition; ++i) {
            seriesOfNumbersArray[i - updatedStartPosition] = arrayOfNumberUserElements[i];
        }

        for (int i = 0; i < seriesOfNumbersArray.length; i++) {
            System.out.print(seriesOfNumbersArray[i] + " , ");
        }

    }

    /**
     * @author Martin Petrov
     * не се справих с тази задача, но поне да се принтира някакво съобщение в конзолата
     */
        //task 6 for number array
        public static void getArrayNumberSumEqualToRandom () {
            System.out.println("Operation unavailable");
        }




    /**
     * @author Martin Petrov
     * метод за задача 1 от обработка на string масив
     */
        //task 1 (word array)
        public static void printArrayWordsInReverse () {
            for (int i = 0; i < length; i++) {
                String temp = arrayOfLetterUserElements[i];
                String newReversedWord = "";

                for (int j = arrayOfLetterUserElements[i].length() - 1; j >= 0; j--) {
                    newReversedWord += temp.charAt(j);
                }
                System.out.print("The reversed word number " + i + " is: ");
                System.out.println(newReversedWord + ", ");
            }
        }



    /**
     * @author Martin Petrov
     * метод за задача 3 от обработка на string масив
     */
        //task 3 for word array
        public static void countNumberOfLetters () {
            for (int i = 0; i < length; i++) {
                System.out.print("The length of word " + i + " is: ");
                System.out.println(arrayOfLetterUserElements[i].length() + " , ");
            }
        }



    /**
     * @author Martin Petrov
     * не се справих с тази задача, но поне да се принтира някакво съобщение в конзолата
     */
        //task 4 for word array
        public static void countAllRepeatingWords () {
            System.out.println("Operation unavailable");
        }


    /**
     * @author Martin Petrov
     * метод използван и от двете подменюта за връщане към главното меню
     */
        //submenu option 5 for both number and word arrays
        public static void goBackToMainMenu () {
            printMainMenu();
        }
    }



/**
 * @author Martin Petrov
 *опит за решение на задача 2 от string масива
 */
//task 2 word arrays attempt
//public static void printDoubledLettersInWords(){
//int numberOfLetterRepetitions=0;
//for (int i=0; i<length; i++){
//String temp = arrayOfLetterUserElements[i];
//if (temp.charAt(i)==temp.charAt(i+1)){
//numberOfLetterRepetitions++;
// }
//System.out.println("The number of repeated elements in word " + i + " is: ");
//System.out.print(numberOfLetterRepetitions);
//}



/**
 * @author Martin Petrov
 *опит за решение на задача 4 от string масива
 */
    //task 4 word arrays attempt
    //public static void countAllRepeatingWords(){
        //String temp = " ";
        //for(int i=0; i<length; i++){
            //temp = arrayOfLetterUserElements[i].toLowerCase();
            //arrayOfLetterUserElements[i]=temp;
        //}

        //int numberOfWordRepetitions=0;
        //for(int i=1; i<length; i++) {
            //for (int j = 0; j < length; j++) {
                //if (temp.equals(arrayOfLetterUserElements[j])) {
                //    numberOfWordRepetitions++;
                //}
            //}
       // }
        //System.out.println("The number of times words are repeated in the array is: " + numberOfWordRepetitions