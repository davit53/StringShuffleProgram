/* Author: Davit Najaryan
Date: April 26, 2022
Description: This program will ask the user for three strings and it will check if the third inputed string is a shuffle of the first two strings.
            The third string will be a mix of the characters of the first two strings in alphabetical/preserving order.
            The program will also loop if the user desires to do so.
*/
 
import java.util.*;
 
public class StringShuffle{
 
    /*
    Separate pieces of code using enum so it is more convenient to read and understand different sections
    Return them back to main void to be executed
    */
 
    enum PlayerMode {
        Single,
        Multi,
        None,
        Test
    }
   
    public static void main(String[] args){
       
        //Decleration of Variables
        Scanner input = new Scanner(System.in);
        Random random = new Random();
 
        //Randomize Ending message
        int randomChoice;
        String randomEnding = "";
 
        randomChoice = random.nextInt(3);
 
        if (randomChoice == 0){
 
            randomEnding = "Hope you had a great time playing! See you next time :)";
 
        }
        else if (randomChoice == 1){
 
            randomEnding = "Wow, you played so well! Hope to see you next time! Goodbye :)";
 
        }
        else {
 
            randomEnding = "I can tell you are improving! Come back for more later! Goodbye :)";
 
        }
 
        //Check players chosen gamemode and redirect to corresponding function
        PlayerMode playerMode = introduction(input);
 
        if(playerMode == PlayerMode.Single) {
           
            singleplayer(input, randomEnding);
           
 
        }
        else if (playerMode == PlayerMode.Multi){
 
            multiplayer(input, randomEnding);
 
        }
        else if(playerMode == PlayerMode.Test){
 
            runTests();
 
        }
 
       
 
    }
 
    /*
    Welcome and Explanation of the program to the user
    */
    public static PlayerMode introduction(Scanner input)  {
 
        String next = "";
   
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\tWelcome to the Shuffle Shuttle!");
        System.out.print("\t\t\t\t\t------------------------------- (press anything to continue) ");
        next = input.nextLine();
        System.out.println("In this program, you can input two strings and try to mix them together to get the correct mixed string.");
        System.out.println("The correct mixed string needs to be in a preserving order of the characters from each string.");
        System.out.println("You may run the program and mix strings as many times as you desire!");
        System.out.print("Throughout the program, whenever you see (continue) press anything to continue (continue) ");
        next = input.nextLine();
        System.out.println("\nThe program is accessible in two modes! Singleplayer and Multiplayer.");
        System.out.println("In the multiplayer mode, the computer will generate two strings and you will try to mix them to get the correct answer.");
        System.out.print("In the singleplayer mode, you will be the one who generates the first two strings. (continue) ");
        next = input.nextLine();
        System.out.println("\t\t\t\t\t\t  ----------");
        System.out.println("\t\t\t\t\t\t  GOOD LUCK!");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
 
        //Declaration of Variables
       
        String checkExample;
        String chooseMode;
        String code = "1234";
 
        String yes = "1"; //Assign values to "1" and "2" to make it easier to check later
        String no = "2";
 

 
        //Check which mode the user wants to play
       
        System.out.println("Please enter the number of the correspoding gamemode you would like to play:");
        System.out.println("[1] Singleplayer");
        System.out.println("[2] Multiplayer");
        chooseMode = input.nextLine();
       
        PlayerMode playerMode = PlayerMode.Single;
 
        while (chooseMode != yes || chooseMode != no){
            if (chooseMode.equals(yes) || chooseMode.equalsIgnoreCase("singleplayer")){
       
                System.out.println("\nYou have selected singleplayer! (continue) ");
                next = input.nextLine();
                playerMode = PlayerMode.Single;
                break;
       
            }
            else if (chooseMode.equals(no) || chooseMode.equalsIgnoreCase("multiplayer")){
       
                System.out.println("\nYou have selected multiplayer! (continue) ");
                next = input.nextLine();
                playerMode = PlayerMode.Multi;
                break;
            }
            else if(chooseMode.equals("3")){
 
                System.out.println("\nLooks like you found the SECRET option!");
                System.out.println("This is meant purely for the developer to test out the code!");
                System.out.println("If you are a developer please enter the code.");
                System.out.println("If the code is invalid the program will detect that it is not a developer and will end the program! (continue) ");
                next = input.nextLine();
                System.out.println("Please enter the secret code:");
                code = input.nextLine();
                if (code.equals("1234")){
 
                    System.out.println("\n------------Correct Code! Welcome to testing------------ (continue)");
                    next = input.nextLine();
                    playerMode = PlayerMode.Test;
                    break;
 
                }
               
                else {
 
                    System.out.println("\nWrong code! Looks like you are not a developer.");
                    System.out.println("------------Please wait while we reset the code------------ (continue) \n");
                    next = input.nextLine();
                    System.out.println("Please enter the number of the correspoding gamemode you would like to play:");
                    System.out.println("[1] Singleplayer");
                    System.out.println("[2] Multiplayer");
                    chooseMode = input.nextLine();
 
                }
 
            }
            else {
 
                System.out.println("Please select a valid gamemode: ");
                System.out.println("[1] Singleplayer");
                System.out.println("[2] Multiplayer");
                chooseMode = input.nextLine();
 
            }
        }
       
        //Check if user wants an example
       
        System.out.println("\nBefore we begin, would you like an example of a properly mixed string?");
        System.out.println("Please enter the corresponding number: ");
        System.out.println("[1] Yes");
        System.out.println("[2] No");
 
        checkExample = input.nextLine();
       
 
        if (checkExample.equals(yes) || checkExample.equalsIgnoreCase("yes")){
 
            System.out.println("\nHere is an example: ");
            System.out.println("First string: 'abc'");
            System.out.println("Second string: '2345'");
            System.out.println("A VALID shuffle would be: 'ab23c45'");
            System.out.println("An INVALID shuffle would be: 'ba5c324'");
            System.out.println("\nNow that we got that clear, let's start the game!");
 
        }
        else if (checkExample.equals(no) || checkExample.equalsIgnoreCase("no")){
 
            System.out.println("\nLooks like we are very confident! Very well then, let's begin :)");
 
        }
        else {
 
            while (checkExample != yes || checkExample != no){ //Loop until user inputs 1 for accepting example or 2 for denying example
 
                System.out.println("\nError, please enter a valid number.");
                System.out.println("[1] Yes, show me an example!");
                System.out.println("[2] No, thank you.");
                checkExample = input.nextLine();
 
                    if (checkExample.equals(yes)){
 
                        System.out.println("\nHere is an example: ");
                        System.out.println("First string: 'abc'");
                        System.out.println("Second string: '2345'");
                        System.out.println("A VALID shuffle would be: 'ab23c45'");
                        System.out.println("An INVALID shuffle would be: 'ba5c324'");
                        System.out.println("\nNow that we got that clear, lets start the game!");
                        break;
 
                    }
                    else if (checkExample.equals(no)){
 
                        System.out.println("\nLooks like we are very confident! Very well then, let's begin :)");
                        break;
 
                    }
            }
 
        }
 
 
        return playerMode;
    }
 
    /*
    Singleplayer Gamemode
    */
 
    public static void singleplayer(Scanner input, String randomEnding){
 
        //Declaration of Variables
 
        String stringOne, stringTwo, stringMix;
 
        String repeat = "";
        String one = "1";
        String two = "2";
       
        //User Input
 
 
            System.out.println("Please enter the first string: ");
            stringOne = input.nextLine();
   
   
            System.out.println("Please enter the second string: ");
            stringTwo = input.nextLine();
   
           
            System.out.println("Great! Now, enter the third string that is the mix of the first two: ");
            stringMix = input.nextLine();
 
            checkAnswer(stringOne, stringTwo, stringMix);
 
            System.out.println("\nWould you like to play again? Enter the corresponding number:  ");
            System.out.println("[1] Yes (Play again)");
            System.out.println("[2] No (Exit)");
            repeat = input.nextLine();
 
            while (repeat.equals("1") || repeat != "1" || repeat != "2"){ //Check if user wants to play again
 
                if (repeat.equals("1")) {
 
                    System.out.println("Please enter the first string: ");
                    stringOne = input.nextLine();
           
           
                    System.out.println("Please enter the second string: ");
                    stringTwo = input.nextLine();
           
               
                    System.out.println("Great! Now, enter the third string that is the mix of the first two: ");
                    stringMix = input.nextLine();
 
                    //Check if answer is correct and display correspoding message
                    checkAnswer(stringOne, stringTwo, stringMix);
 
                    System.out.println("\nWould you like to play again? Enter the corresponding number:  ");
                    System.out.println("[1] Yes (Play again)");
                    System.out.println("[2] No (Exit)");
                    repeat = input.nextLine();
 
                }
                else if (repeat.equals("2")){
 
                    System.out.println("\n*****************************************************");
                    System.out.println(randomEnding); //Randomized Ending Message
                    System.out.println("*****************************************************");
                    break;
 
                }
                else {
 
                    while (repeat.equals(one) == false && repeat.equals(two) == false) {
 
                    System.out.println("\nPlease input a valid number.");
                    System.out.println("Would you like to play again? Enter the corresponding number:  ");
                    System.out.println("[1] Yes");
                    System.out.println("[2] No");
                    repeat = input.nextLine();
 
                    }
 
                }
 
            }
       
    }
 
    /*
    Multiplayer Gamemode
    */
 
    public static PlayerMode multiplayer(Scanner input, String randomEnding){
 
        PlayerMode playerMode = PlayerMode.Multi;
 
        //Decelration of Variables
 
        Random rand = new Random();
 
        String repeat;
 
        do{
 
        //Reset Variables
        int randomLimitOne = 0, randomLimitTwo = 0,         // | Length of strings                                              | //
        numberOfCharOne = 0, numberOfCharTwo = 0,           // | Varaibales to increment value until string length is reached   | //
        charOrIntOne = 0, charOrIntTwo = 0,                 // | Randomly decide if integer or charcater is generated           | //
        randomizedNumberOne = 0, randomizedNumberTwo = 0;   // | Store the randomly generated integer/charcater                 | //
       
        String stringOne = "", stringTwo = "", stringMix, level;
 
        //Choose Level
        System.out.println("\nYou will now choose a level!");
        System.out.println("******************************************************************");
        System.out.println("Level 1 will have randomly generated strings up to 4 characters");
        System.out.println("Level 2 will have randomly generated strings up to 6 characters.");
        System.out.println("Level 3 will have randomly generated strings up to 8 characters.");
        System.out.println("Please input a number corresponding to the level.");
        System.out.println("******************************************************************");
 
        System.out.println("\n[1] Level 1");
        System.out.println("[2] Level 2");
        System.out.println("[3] Level 3");
        level = input.nextLine();
 
 
        while (level != "1" || level != "2" || level != "3") {
            if (level.equals("1")){
 
                System.out.println("You have selected level one. Here we go!");
 
                /*
                Here we are going to generate two random strings
                The two strings consits of a random number of charcaters up to 4
                The charcaters are a randomly generated mix of integers and letters
                */
                randomLimitOne = rand.nextInt(3) + 2;
                randomLimitTwo = rand.nextInt(3) + 2;
 
                System.out.print("\nThe first computer-generated string is: ");
                while(numberOfCharOne < randomLimitOne) {
 
                    charOrIntOne = rand.nextInt(2) + 1;
 
                    if (charOrIntOne == 1){
 
                        char randomizedCharacterOne = (char) (rand.nextInt(26) + 'a');
                        stringOne = stringOne + randomizedCharacterOne;
                        System.out.print(randomizedCharacterOne);
 
                    }
                    else {
 
                        randomizedNumberOne = rand.nextInt(9) + 1;
                        stringOne = stringOne + randomizedNumberOne;
                        System.out.print(randomizedNumberOne);
 
                    }
 
 
                    numberOfCharOne++;
 
                }
 
                System.out.print("\nThe second computer-generated string is: ");
                while (numberOfCharTwo < randomLimitTwo){
 
                    charOrIntTwo = rand.nextInt(2) + 1;
 
                    if (charOrIntTwo == 1){
 
                        char randomizedCharacterTwo = (char) (rand.nextInt(26) + 'a');
                        stringTwo = stringTwo + randomizedCharacterTwo;
                        System.out.print(randomizedCharacterTwo);
 
                    }
                    else {
 
                        randomizedNumberTwo = rand.nextInt(9) + 1;
                        stringTwo = stringTwo + randomizedNumberTwo;
                        System.out.print(randomizedNumberTwo);
 
                    }
 
                    numberOfCharTwo++;
 
                }
 
                break;
 
            }
 
            else if (level.equals("2")){
 
                System.out.println("You have selected level two. Here we go!");
 
                /*
                Random number of charcaters up to 6
                */
                randomLimitOne = rand.nextInt(4) + 3;
                randomLimitTwo = rand.nextInt(4) + 3;
 
                System.out.print("\nThe first computer-generated string is: ");
                while(numberOfCharOne < randomLimitOne) {
 
                    charOrIntOne = rand.nextInt(2) + 1;
 
                    if (charOrIntOne == 1){
 
                        char randomizedCharacterOne = (char) (rand.nextInt(26) + 'a');
                        stringOne = stringOne + randomizedCharacterOne;
                        System.out.print(randomizedCharacterOne);
 
                    }
                    else {
 
                        randomizedNumberOne = rand.nextInt(9) + 1;
                        stringOne = stringOne + randomizedNumberOne;
                        System.out.print(randomizedNumberOne);
 
                    }
 
 
                    numberOfCharOne++;
 
                }
 
                System.out.print("\nThe second computer-generated string is: ");
                while (numberOfCharTwo < randomLimitTwo){
 
                    charOrIntTwo = rand.nextInt(2) + 1;
 
                    if (charOrIntTwo == 1){
 
                        char randomizedCharacterTwo = (char) (rand.nextInt(26) + 'a');
                        stringTwo = stringTwo + randomizedCharacterTwo;
                        System.out.print(randomizedCharacterTwo);
 
                    }
                    else {
 
                        randomizedNumberTwo = rand.nextInt(9) + 1;
                        stringTwo = stringTwo + randomizedNumberTwo;
                        System.out.print(randomizedNumberTwo);
 
                    }
 
                    numberOfCharTwo++;
 
                }
 
                break;
 
            }
            else if (level.equals( "3")){
 
                System.out.println("You have selected level three. Looks like you are up for a challenge!");
 
                /*
                Random number of charcaters up to 8
                */
                randomLimitOne = rand.nextInt(4) + 5;
                randomLimitTwo = rand.nextInt(4) + 5;
 
                System.out.print("\nThe first computer-generated string is: ");
                while(numberOfCharOne < randomLimitOne) {
 
                    charOrIntOne = rand.nextInt(2) + 1;
 
                    if (charOrIntOne == 1){
 
                        char randomizedCharacterOne = (char) (rand.nextInt(26) + 'a');
                        stringOne = stringOne + randomizedCharacterOne;
                        System.out.print(randomizedCharacterOne);
 
                    }
                    else {
 
                        randomizedNumberOne = rand.nextInt(9) + 1;
                        stringOne = stringOne + randomizedNumberOne;
                        System.out.print(randomizedNumberOne);
 
                    }
 
 
                    numberOfCharOne++;
 
                }
 
                System.out.print("\nThe second computer-generated string is: ");
                while (numberOfCharTwo < randomLimitTwo){
 
                    charOrIntTwo = rand.nextInt(2) + 1;
 
                    if (charOrIntTwo == 1){
 
                        char randomizedCharacterTwo = (char) (rand.nextInt(26) + 'a');
                        stringTwo = stringTwo + randomizedCharacterTwo;
                        System.out.print(randomizedCharacterTwo);
 
                    }
                    else {
 
                        randomizedNumberTwo = rand.nextInt(9) + 1;
                        stringTwo = stringTwo + randomizedNumberTwo;
                        System.out.print(randomizedNumberTwo);
 
                    }
 
                    numberOfCharTwo++;
 
                }
 
                break;
 
            }
            else{
 
                System.out.println("Please input a valid level: ");
                System.out.println("\n[1] Level 1 (Easy)");
                System.out.println("[2] Level 2 (Medium)");
                System.out.println("[3] Level 3 (Hard)");
                level = input.nextLine();
 
            }
 
        }
 
 
 
        System.out.println("\nPlease enter the third string that is the mix of the first two:");
        stringMix = input.nextLine();
 
        //Check if answer is correct and display correspoding message
        checkAnswer(stringOne, stringTwo, stringMix);
 
        System.out.println("\nWould you like to play again? Please Input the correspoding number: ");
        System.out.println("[1] Yes");
        System.out.println("[2] No"); /////////////////////////////////////
        repeat = input.nextLine();
 
        } while (repeat.equals("1"));
 
       
 
        System.out.println("\n*****************************************************");
        System.out.println(randomEnding); //Randomized Ending Message
        System.out.println("*****************************************************");
 
 
        return playerMode;
 
    }
 
    /*
    Function to check if mixed string is correct
    */
    public static boolean findString(String bigString, String smallString){
 
 
        int i = 0;
        int j = 0;
        boolean found = false;
 
        while(j < bigString.length()){
 
            if (smallString.charAt(i) == bigString.charAt(j)){
               
                i++;
 
                if (i >= smallString.length()){
 
                    found = true;
                    break;
 
                }
 
            }
 
            j++;
 
        }
 
        return found;
 
    }
 
 
    /*
    Function for displaying if answer is correct or false
    */
 
    public static boolean checkAnswer(String stringOne, String stringTwo, String stringMix){
 
        boolean correct = false;
 
        int check = stringOne.length() + stringTwo.length();
 
            if (check > stringMix.length()){
 
                correct = false;
                System.out.println("\nWrong answer, better luck next time!");
 
            }
            else if (check < stringMix.length()){
 
                correct = false;
                System.out.println("\nWrong answer, better luck next time!");
 
            }
            else {
 
                if (findString(stringMix, stringOne) == true && findString(stringMix, stringTwo) == true){
 
                    correct = true;
                    System.out.println("\nGreat job! That is the correct answer!");
               
                }
                else {
               
                    correct = false;
                    System.out.println("\nWrong answer, better luck next time!");
               
                }
 
            }
 
        return correct;
 
    }
 
    /*
    Automated Testing for Various Cases
    */
 
    public static void testCorrectCase(String stringOne, String stringTwo, String stringMix){
 
        if (checkAnswer(stringOne, stringTwo, stringMix) == false){
 
            System.out.println("String 1: ");
            System.out.println(stringOne);
 
            System.out.println("String 2: ");
            System.out.println(stringTwo);
 
            System.out.println("String Mix: ");
            System.out.println(stringMix);
 
            System.out.println("\n----------------------------Test for correct case failed----------------------------------");
 
        }
 
    }
 
    public static void testWrongCase(String stringOne, String stringTwo, String stringMix){
 
        if (checkAnswer(stringOne, stringTwo, stringMix) == true){
 
            System.out.println("String 1: ");
            System.out.println(stringOne);
 
            System.out.println("String 2: ");
            System.out.println(stringTwo);
 
            System.out.println("String Mix: ");
            System.out.println(stringMix);
 
            System.out.println("\n--------------------------Test for wrong case failed-------------------------------");
 
        }
 
    }
 
    public static void runTests(){
 
        //Supposed to be correct
        testCorrectCase("111","222","121212");
        testCorrectCase("abc", "123", "ab12c3");
        testCorrectCase("a ", "bc", "a bc");
        testCorrectCase(" a", "bc", "b ac");
        testCorrectCase("@@##~~))/n", "zzzzzz!", "@@##~~))/nzzzzzz!");
 
        //Supposed to be wrong
        testWrongCase(" ", " ", " ");

 
    }
 
}
