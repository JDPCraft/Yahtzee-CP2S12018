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
    }

    public Die[] getDice() {
        return dice;
    }

    public int getScore() {
        return score;
    }

    private void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    //method takeTurn that will contain all of the aspects of a player's turn.
    public void takeTurn() {

        Scanner reRoll = new Scanner(System.in); //scanner used to ask the player if they want to re-roll the dice
        // after an initial or previous roll on their current turn.
        Scanner chose1 = new Scanner(System.in);
        Scanner chose2 = new Scanner(System.in);

        boolean[] heldDie = new boolean[5];
        Arrays.fill(heldDie, false);

        int rollNumber = 0; //initializes a variable i that keeps track of the number of the times the dice were rolled.

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

            if (rollNumber < 2) {
                do {
                    System.out.print("Would you like to roll again? ");
                    String reRollDice = reRoll.nextLine();

                    int choice = 0;
                    if (reRollDice.equalsIgnoreCase("yes")) {

                        Arrays.fill(heldDie, false);

                        rollNumber = rollNumber + 1; //increases roll count by 1. If i=1 then it is now the second roll, and if i=2
                        // then it is now the third roll.

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

                        }
                    }
                } while (!answeredCorrectly)/*||if(rollNumber<2)*/;}
            else{rollNumber++;}
        }
        System.out.println("placeholder text for when choosing what category to score roll under.");
        System.out.println("1=Aces\n2=Twos\n3=Threes\n4=Fours\n5=Fives\n6=Sixes.");
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