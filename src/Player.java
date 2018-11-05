//import java.util.InputMismatchException;
//import java.util.Scanner;
//import java.util.Arrays;
//
//public class Player {
//
//    //initializes variables
//    private String name;
//    private int score;
//    private Die[] dice;
//
//    private Rules rules;
//    //   private boolean diceHeld;
//    //   private int finalScore;
//    Scanner chose = new Scanner(System.in);
//
//
//    //initializes constructors, getters, setters, and the array that holds the dice.
//    public Player(String name) {
//        this.name = name;
//        dice = new Die[5];
//        for (int i = 0; i < dice.length; i++) {
//            dice[i] = new Die();
//
//
//            //need to have each Player Object hold it's own score so that when all 13 rounds are over for each player,
//            // a winner can be calculated and declared.
//        }
//        rules = new Rules(this);
//
//        /*for(Die die: dice){
//            die.
//        }*/
//    }
//
//    public Die[] getDice() {
//        return dice;
//    }
//
//
//    //   public Player(int finalScore) {this.finalScore = finalScore;}
//
//    public int getScore() {
//        return score;
//    }
//
//    private void setScore(int score) {
//        this.score = score;
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//
// /*   public boolean getDiceHeld() {
//        return diceHeld;
//    } */
//
// /*   public void setDiceHeld(boolean diceHeld) {
//        this.diceHeld = diceHeld;
//    } */
//
////getFinalScore is no longer needed
//    // public int getFinalScore() {return this.finalScore;}
//
//    //method takeTurn that will contain all of the aspects of a player's turn.
////  public int takeTurn(int i) {
//    public void takeTurn() {
//
//        Scanner reRoll = new Scanner(System.in); //scanner used to ask the player if they want to re-roll the dice
//        // after an initial or previous roll on their current turn.
//        Scanner chose1 = new Scanner(System.in);
//        Scanner chose2 = new Scanner(System.in);
//        //code TODO in next build of player class
//        //ask the player after rolling which dice they would like to set aside by having them type a number 1 through 5
//        // where each number corresponds to a dice, and then asks them if they want to set aside another dice to allow
//        // them to set aside more than just one dice, but set it up so they can't set aside they same dice more than
//        // once to avoid potential errors? Then set up a for loop so that when the player next rolls, it only re-rolls
//        // the dice that they didn't set aside. (We could make variables called dice(dice #) re-roll which would be
//        // boolean variables initially initialized as false, then change them to true if the player wants to re-roll
//        // that certain dice, but set any of them that are true back to false after the roll.)
//
//
//        boolean[] heldDie = new boolean[5];
//        Arrays.fill(heldDie, false);
//
//
//   /* private boolean[] getHeldDie(boolean [] pHeldDie) {
//        return pHeldDie;
//            } */
//
//
//        //array to hold 5 dice is needed
//
//        // int[] Die = new int[5];
//
//        /*Die die1 = new Die();
//        Die die2 = new Die();
//        Die die3 = new Die();
//        Die die4 = new Die();
//        Die die5 = new Die();*/
//
//
//        int rollNumber = 0; //initializes a variable i that keeps track of the number of the times the dice were rolled.
//        // if (rollNumber<2) { //should not ask player if they want to roll again after last roll.
//        //System.out.println("i initial:"+i);
//
//
//        String playersTurnPhrase = "It is now player " + getName() + "'s turn.";
//        System.out.println(playersTurnPhrase); //returns the name of the player who's
//        // turn it is
//        for (int i = 0; i < playersTurnPhrase.length(); i++) {
//            System.out.print("_");
//
//        }
//        System.out.println();
//
//
//        while (rollNumber <= 2) {
//
//            for (int d = 0; d < dice.length; d++) {
//                if (!heldDie[d]) {
//                    dice[d].rollDie();
//                } else {
//                    continue;
//                }
//            }
//
//            System.out.println("\n" + getName() + " rolled: ");
//            // printDice(dice); (Temporarily disabled for incompatibility issues)
//            printDice2(dice); // Temporary fix
//            System.out.println();
//
//
//            boolean answeredCorrectly = false; //initializes answeredCorrectly to false. this is used to ask the player
//            // if they would like to re-roll, but it will keep them here unless they answer yes or no.
////            if (rollNumber==2) {
////                answeredCorrectly = true;
////            }
////if (rollNumber<2) {
////    answeredCorrectly = false;
////}
////else {
////    answeredCorrectly = true;
////}
//            //need to figure out how to solve the two bugs that cause confusion within the user interface during a turn.
//            if (rollNumber < 2) do {
//                System.out.print("Would you like to roll again? ");
//                String reRollDice = reRoll.nextLine();
//
//                if (reRollDice.equalsIgnoreCase("yes")) {
//
//                    Arrays.fill(heldDie, false);
//
//                    //System.out.println("i inside of do before i increments by one:"+rollNumber);
////         if (rollNumber<2) {
//                    rollNumber = rollNumber + 1; //increases roll count by 1. If i=1 then it is now the second roll, and if i=2
//                    // then it is now the third roll.
////         }
////         else {
////             //answeredCorrectly = true;
////         }
//                    //System.out.println("i inside of do after i increments by one:"+rollNumber);
//
//            /*int desiredHeldDie = -1;
//            while(desiredHeldDie>5||desiredHeldDie<1){
//                desiredHeldDie=promptInt("How many dice would you like to set aside? (This is amount of dice, not the " +
//                        "dice themselves.");
//            }
//
//            for (int h = 1; h < (desiredHeldDie + 1); h++) {
//                int hold2=-1;
//                while(hold2>5||hold2<1){
//                hold2 = promptInt("[Die "+h+"] Which dice would you like to set aside? (This is the actual dice, not the " +
//                        "amount of dice you want to set aside.");
//                }
//
//                heldDie[hold2 - 1] = true;
//            }*/
//
//                    int[] desiredHeldDice = new int[1];
//                    desiredHeldDice[0] = -1; // Initialize array to loop state (resized later)
//                    while (desiredHeldDice[0] == -1) {
//                        desiredHeldDice = promptIntList("Which dice would you like to set aside? (Separated by commas. Dice are ordered 1-5.)");
//                        for (int h = 1; h < 6; h++) {
//                            if (inIntArr(h, desiredHeldDice)) {
//                                heldDie[h - 1] = true;
//                            }
//                        }
//                    }
//
//
//                    answeredCorrectly = true; //releases the user from the answeredCorrectly 'loop'
//
//                } else if (reRollDice.equalsIgnoreCase("no")) {
//                    rollNumber = 3; //sets the roll count to 3,
//                    answeredCorrectly = true; //releases the user from the answeredCorrectly 'loop'
//
//
//                    //currently, the code gets stuck and prevents the player from progressing (or in case of FullHouse
//                    // or others that print text for testing values, keeps printing the text and would crash the
//                    // computer if the game is not terminated.)
//                }
//            }
//
//
//        }
//    }
//
//     while(!answeredCorrectly)/*||if(rollNumber<2)*/;
//    else{ rollNumber++; }
//
//
////The Player class got royaly messed up during the merging, how.
//
//        System.out.println("placeholder text for when choosing what category to score roll under.");
//        int chose = 0;
//
// while (chose < 1 || chose > 13){
//        System.out.println("Please choose one of the following categories.");
//        CategoryUse();
//
//
//        // System.out.println("1=Aces\n2=Twos\n3=Threes\n4=Fours\n5=Fives\n6=Sixes\n7=3OfAKind\n8=4OfAKind\n9=SmallStraight\n10=LargeStraight\n11=FullHouse\n12=Yahtzee\n13=Chance");
//        chose=chose1.nextInt();
//        }
//public void CategoryUse(){
//        for(int index=1;index<=13;index++){
//
//        if(!rules.checkCategory(index)){
//
//        String display=(index)+"= ";
//        switch(index){
//        case 1:
//        display+="Aces";
//        break;
//        case 2:
//        display+="Twos";
//        break;
//        case 3:
//        display+="Threes";
//        break;
//        case 4:
//        display+="Fours";
//        break;
//        case 5:
//        display+="Fives";
//        break;
//        case 6:
//        display+="Sixes";
//        break;
//        case 7:
//        display+="ThreeOfAKind";
//        break;
//        case 8:
//        display+="FourOfAKind";
//        break;
//        case 9:
//        display+="SmallStraight";
//        break;
//        case 10:
//        display+="LargeStraight";
//        break;
//        case 11:
//        display+="FullHouse";
//        break;
//        case 12:
//        display+="Yahtzee";
//        break;
//        case 13:
//        display+="Chance";
//        break;
//        }
//        System.out.println(display);
//
//        if(!rules.checkCategory(chose)){
//        rules.checkCategoryInput(dice,chose);
//        }else{
//        System.out.println("You have previously selected that category and currently have a score of ");
//        chose=0;
//        }
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        for(int x=1;x<=13;x++){
//        System.out.println("Category check for "+x+" is "+(rules.checkCategory(x)));
//        }
//        System.out.println();
//        System.out.println();
//        System.out.println();
//
//
//        System.out.println("placeholder text for when choosing what category to score roll under.");
//        System.out.println("1=Aces\n2=Twos\n3=Threes\n4=Fours\n5=Fives\n6=Sixes.");
//        //below line is supposed to call the instance of the Rules class that the current player has, and then
//        //calculate the score of the roll before starting the next player's turn.
////rules.checkCategory();
//        // System.out.println("i at end of loop:"+rollNumber);
//        System.out.println();
//        }
////need to call up the Rules class to calculate the score for the round
//// return getScore();
//
//private static void printDice2(Die[]dice){
//        for(int i=0;i<5;i++){System.out.print(dice[i].getFaceValue()+" ");}
//        }
//
//private static void printDice(Die[]dice){ // Prints graphical representation of dice in a row
//
//        String[]printRows=new String[5]; // We need rows because we want the dice to be all in a row.
//        Arrays.fill(printRows,""); // Init. array
//        for(int i=0;i<5;i++){
//        int faceVal=dice[i].getFaceValue(); // Stored so we don't need to keep calling the method
//        if(faceVal<1||faceVal>6){printRows[2]+="[!]";} // No graphical representation of the faceValue found
//
//            /* ___________________________________________________________________________________________________________
//              |In order to compress the code, I've thought of a way to make all of the dice in the same five lines.       |
//              |The presence of a dot on a point on the die can be expressed as a boolean value.                           |
//              |We can use this to our advantage by creating a method that returns either a space or a dot.                |
//              |Some dots on the die are shared between different faces, creating different conditions for them to appear. |
//               ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾ */
//
//        // - Text Dice Creation -
//        //printRows[0]+="---"+faceVal+"--- "; // DEBUG (it works!)
//        //printRows[0]+=" ______  ";
//        printRows[1]+=boolDot(faceVal!=1)+"   "+boolDot(faceVal>3)+"     ";
//        printRows[2]+=boolDot(faceVal==6)+" "+boolDot(faceVal%2==1)+" "+boolDot(faceVal==6)+"     ";
//        printRows[3]+=boolDot(faceVal>3)+"   "+boolDot(faceVal>1)+"     ";
//        //printRows[4]+=" ‾‾‾‾‾‾‾‾  ";
//        }
//        for(int i=0;i<5;i++){
//        System.out.println(printRows[i]);
//        }
//        }
//
//private static String boolDot(boolean condition){ // If the condition is true, return a "dot" to be put on the die.
//        if(condition){return"●";}else{return" ";}
//        }
//
//// promptInt also checks for invalid inputs
//private static int promptInt(String prompt)throws InputMismatchException{
//        Scanner sc=new Scanner(System.in);
//        int output;
//        try{
//        output=sc.nextInt();
//        }
//        catch(InputMismatchException e){
//        output=-1; // Set the output to -1 if an error is found
//        }
//
//        return output;
//        }
//
//private static int[]promptIntList(String prompt)throws InputMismatchException{
//        System.out.print(prompt+" ");
//        Scanner sc=new Scanner(System.in);
//        String input=sc.nextLine();
//        int items=1;
//        for(int i=0;i<input.length();i++){if(input.substring(i,i+1).equals(",")){items++;}} // Count up the number of items in the list
//        int[]output=new int[items];
//        for(int i=0;i<items;i++){
//        try{output[i]=Integer.parseInt(fetchParam(input,i));} // Error checking
//        catch(Exception e){Arrays.fill(output,-1);return output;}
//        }
//        return output;
//        }
//
//private static String fetchParam(String str,int index){
//        int currentIndex=0;
//        int lastDelimPos=-1;
//        int i;
//        for(i=0;i<str.length();i++){
//        if(str.substring(i,i+1).equals(",")){
//        if(currentIndex==index){return str.substring(lastDelimPos+1,i);}
//        currentIndex++;
//        lastDelimPos=i;
//        }
//        }
//        return str.substring(lastDelimPos+1,i);
//        }
//
//private static boolean inIntArr(int query,int[]arr){
//        for(int i=0;i<arr.length;i++){
//        if(arr[i]==query){return true;}
//        }
//        return false;
//
//        }
//
//        }
//
//        }

//lines 1-393 had gotten really messed up when merging the code, so that's why it's all commented out.
//lines 398-769 is basically lines 1-400, but fixed and without all of the errors.

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class Player {

    //initializes variables
    private String name;
    private int score;
    private Die[] dice;

    private Rules rules;
    //   private boolean diceHeld;
    //   private int finalScore;
    Scanner chose = new Scanner(System.in);

    //initializes constructors, getters, setters, and the array that holds the dice.
    public Player(String name) {
        this.name = name;
        dice = new Die[5];
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Die();

            //need to have each Player Object hold it's own score so that when all 13 rounds are over for each player,
            // a winner can be calculated and declared.
        }
        rules = new Rules(this);

        /*for(Die die: dice){
            die.
        }*/
    }

    public Die[] getDice() {
        return dice;
    }

    //   public Player(int finalScore) {this.finalScore = finalScore;}

    public int getScore() {
        return score;
    }

    private void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

 /*   public boolean getDiceHeld() {
        return diceHeld;
    } */

 /*   public void setDiceHeld(boolean diceHeld) {
        this.diceHeld = diceHeld;
    } */

//getFinalScore is no longer needed
    // public int getFinalScore() {return this.finalScore;}

    //method takeTurn that will contain all of the aspects of a player's turn.
//  public int takeTurn(int i) {
    public void takeTurn() {

        Scanner reRoll = new Scanner(System.in); //scanner used to ask the player if they want to re-roll the dice
        // after an initial or previous roll on their current turn.
        Scanner chose1 = new Scanner(System.in);
        Scanner chose2 = new Scanner(System.in);
        //code TODO in next build of player class
        //ask the player after rolling which dice they would like to set aside by having them type a number 1 through 5
        // where each number corresponds to a dice, and then asks them if they want to set aside another dice to allow
        // them to set aside more than just one dice, but set it up so they can't set aside they same dice more than
        // once to avoid potential errors? Then set up a for loop so that when the player next rolls, it only re-rolls
        // the dice that they didn't set aside. (We could make variables called dice(dice #) re-roll which would be
        // boolean variables initially initialized as false, then change them to true if the player wants to re-roll
        // that certain dice, but set any of them that are true back to false after the roll.)

        boolean[] heldDie = new boolean[5];
        Arrays.fill(heldDie, false);

   /* private boolean[] getHeldDie(boolean [] pHeldDie) {
        return pHeldDie;
            } */

        //array to hold 5 dice is needed

        // int[] Die = new int[5];

        /*Die die1 = new Die();
        Die die2 = new Die();
        Die die3 = new Die();
        Die die4 = new Die();
        Die die5 = new Die();*/

        int rollNumber = 0; //initializes a variable i that keeps track of the number of the times the dice were rolled.
        // if (rollNumber<2) { //should not ask player if they want to roll again after last roll.
        //System.out.println("i initial:"+i);

        String playersTurnPhrase = "It is now player " + getName() + "'s turn.";
        System.out.println(playersTurnPhrase); //returns the name of the player who's
        // turn it is
        for (int i = 0; i < playersTurnPhrase.length(); i++) {
            System.out.print("_");

        }
        System.out.println();

        while (rollNumber <= 2) {

            for (int d = 0; d < dice.length; d++) {
                if (!heldDie[d]) {
                    dice[d].rollDie();
                } else {
                    continue;
                }
            }

            System.out.println("\n" + getName() + " rolled: ");
            // printDice(dice); (Temporarily disabled for incompatibility issues)
            printDice2(dice); // Temporary fix
            System.out.println();

            boolean answeredCorrectly = false; //initializes answeredCorrectly to false. this is used to ask the player
            // if they would like to re-roll, but it will keep them here unless they answer yes or no.
//            if (rollNumber==2) {
//                answeredCorrectly = true;
//            }
//if (rollNumber<2) {
//    answeredCorrectly = false;
//}
//else {
//    answeredCorrectly = true;
//}
            //need to figure out how to solve the two bugs that cause confusion within the user interface during a turn.
            if (rollNumber < 2) {
                do {
                    System.out.print("Would you like to roll again? ");
                    String reRollDice = reRoll.nextLine();

                    int choice = 0;
                    if (reRollDice.equalsIgnoreCase("yes")) {

                        Arrays.fill(heldDie, false);

                        //System.out.println("i inside of do before i increments by one:"+rollNumber);
//         if (rollNumber<2) {
                        rollNumber = rollNumber + 1; //increases roll count by 1. If i=1 then it is now the second roll, and if i=2
                        // then it is now the third roll.
//         }
//         else {
//             //answeredCorrectly = true;
//         }
                        //System.out.println("i inside of do after i increments by one:"+rollNumber);

            /*int desiredHeldDie = -1;
            while(desiredHeldDie>5||desiredHeldDie<1){
                desiredHeldDie=promptInt("How many dice would you like to set aside? (This is amount of dice, not the " +
                        "dice themselves.");
            }

            for (int h = 1; h < (desiredHeldDie + 1); h++) {
                int hold2=-1;
                while(hold2>5||hold2<1){
                hold2 = promptInt("[Die "+h+"] Which dice would you like to set aside? (This is the actual dice, not the " +
                        "amount of dice you want to set aside.");
                }

                heldDie[hold2 - 1] = true;
            }*/

                        int[] desiredHeldDice = new int[1];
                        desiredHeldDice[0] = -1; // Initialize array to loop state (resized later)
                        while (desiredHeldDice[0] == -1) {
                            desiredHeldDice = promptIntList("Which dice would you like to set aside? (Separated by commas. Dice are ordered 1-5.)");
                            for (int h = 1; h < 6; h++) {
                                if (inIntArr(h, desiredHeldDice)) {
                                    heldDie[h - 1] = true;
                                }
                            }
                        }

                        System.out.println("placeholder text for when choosing what category to score roll under.");
                        choice = 0;

                        answeredCorrectly = true; //releases the user from the answeredCorrectly 'loop'

                    } else if (reRollDice.equalsIgnoreCase("no")) {
                        rollNumber = 3; //sets the roll count to 3,
                        answeredCorrectly = true; //releases the user from the answeredCorrectly 'loop'

                        while (choice < 1 || choice > 13) {
                            System.out.println("Please choose one of the following categories.");
                            CategoryUse();

                            // System.out.println("1=Aces\n2=Twos\n3=Threes\n4=Fours\n5=Fives\n6=Sixes\n7=3OfAKind\n8=4OfAKind\n9=SmallStraight\n10=LargeStraight\n11=FullHouse\n12=Yahtzee\n13=Chance");
                            choice = chose.nextInt();

                            if (!rules.checkCategory(choice)) {
                                rules.checkCategoryInput(dice, choice);
                            } else {
                                System.out.println("You have previously selected that category and currently have a score of ");
                                choice = 0;
                            }
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            for (int x = 1; x <= 13; x++) {
                                System.out.println("Category check for " + x + " is " + (rules.checkCategory(x)));
                            }
                            System.out.println();
                            System.out.println();
                            System.out.println();

                            //currently, the code gets stuck and prevents the player from progressing (or in case of FullHouse
                            // or others that print text for testing values, keeps printing the text and would crash the
                            // computer if the game is not terminated.)
                        }
                    }
                } while (!answeredCorrectly)/*||if(rollNumber<2)*/;}
            else{rollNumber++;}
        }
        System.out.println("placeholder text for when choosing what category to score roll under.");
        System.out.println("1=Aces\n2=Twos\n3=Threes\n4=Fours\n5=Fives\n6=Sixes.");
        //below line is supposed to call the instance of the Rules class that the current player has, and then
        //calculate the score of the roll before starting the next player's turn.
//rules.checkCategory();
        // System.out.println("i at end of loop:"+rollNumber);
        System.out.println();
    }
//need to call up the Rules class to calculate the score for the round
    // return getScore();

    public void CategoryUse() {
        for (int index = 1; index <= 13; index++) {

            if (!rules.checkCategory(index)) {

                String display = (index) + "= ";
                switch (index) {
                    case 1:
                        display += "Aces";
                        break;
                    case 2:
                        display += "Twos";
                        break;
                    case 3:
                        display += "Threes";
                        break;
                    case 4:
                        display += "Fours";
                        break;
                    case 5:
                        display += "Fives";
                        break;
                    case 6:
                        display += "Sixes";
                        break;
                    case 7:
                        display += "3OfAKind";
                        break;
                    case 8:
                        display += "4OfAKind";
                        break;
                    case 9:
                        display += "SmallStraight";
                        break;
                    case 10:
                        display += "LargeStraight";
                        break;
                    case 11:
                        display += "FullHouse";
                        break;
                    case 12:
                        display += "Yahtzee";
                        break;
                    case 13:
                        display += "Chance";
                        break;
                }
                System.out.println(display);
            }
        }}

    private static void printDice2(Die[] dice){
        for(int i=0;i<5;i++){System.out.print(dice[i].getFaceValue()+" ");}
    }

    private static void printDice(Die[] dice){ // Prints graphical representation of dice in a row

        String[] printRows = new String[5]; // We need rows because we want the dice to be all in a row.
        Arrays.fill(printRows,""); // Init. array
        for(int i=0;i<5;i++) {
            int faceVal = dice[i].getFaceValue(); // Stored so we don't need to keep calling the method
            if(faceVal<1||faceVal>6){printRows[2]+="[!]";} // No graphical representation of the faceValue found

            /* ___________________________________________________________________________________________________________
              |In order to compress the code, I've thought of a way to make all of the dice in the same five lines.       |
              |The presence of a dot on a point on the die can be expressed as a boolean value.                           |
              |We can use this to our advantage by creating a method that returns either a space or a dot.                |
              |Some dots on the die are shared between different faces, creating different conditions for them to appear. |
               ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾ */

            // - Text Dice Creation -
            //printRows[0]+="---"+faceVal+"--- "; // DEBUG (it works!)
            //printRows[0]+=" ______  ";
            printRows[1]+=boolDot(faceVal!=1)+"   "+boolDot(faceVal>3)+"     ";
            printRows[2]+=boolDot(faceVal==6)+" "+boolDot(faceVal%2==1)+" "+boolDot(faceVal==6)+"     ";
            printRows[3]+=boolDot(faceVal>3)+"   "+boolDot(faceVal>1)+"     ";
            //printRows[4]+=" ‾‾‾‾‾‾‾‾  ";
        }
        for(int i=0;i<5;i++){
            System.out.println(printRows[i]);
        }
    }

    private static String boolDot(boolean condition){ // If the condition is true, return a "dot" to be put on the die.
        if(condition){return "●";} else{return " ";}
    }

    // promptInt also checks for invalid inputs
    private static int promptInt(String prompt) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        int output;
        try{
            output = sc.nextInt();
        }
        catch (InputMismatchException e){
            output = -1; // Set the output to -1 if an error is found
        }

        return output;
    }

    private static int[] promptIntList(String prompt) throws InputMismatchException{
        System.out.print(prompt+" ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int items = 1;
        for(int i=0;i<input.length();i++){if(input.substring(i,i+1).equals(",")){items++;}} // Count up the number of items in the list
        int[] output = new int[items];
        for(int i=0;i<items;i++){
            try{output[i]=Integer.parseInt(fetchParam(input,i));} // Error checking
            catch(Exception e){Arrays.fill(output,-1);return output;}
        }
        return output;
    }

    private static String fetchParam(String str, int index){
        int currentIndex = 0;
        int lastDelimPos = -1;
        int i;
        for(i=0;i<str.length();i++){
            if(str.substring(i,i+1).equals(",")){
                if(currentIndex==index){return str.substring(lastDelimPos+1,i);}
                currentIndex++;
                lastDelimPos=i;
            }
        }
        return str.substring(lastDelimPos+1,i);
    }

    private static boolean inIntArr(int query,int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==query){return true;}
        }
        return false;

    }

}