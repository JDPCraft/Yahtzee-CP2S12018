import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

class Player {

    //initializes variables
    private String name;
    private int score;
    private Die[] dice;
    private Rules rules;
    private Scanner sc = new Scanner(System.in); // Scanner used for everything


    //initializes constructors, getters, setters, and the array that holds the dice.
    Player(String name) {
        this.name = name;
        dice = new Die[5];
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Die();
        }
        rules = new Rules();
    }

    int getScore() {
        return score;
    }

    String getName() {
        return this.name;
    }

    void takeTurn() {

        boolean[] heldDie = new boolean[5];
        int rollNumber = 0; //initializes a variable i that keeps track of the number of the times the dice were rolled.


        String playersTurnPhrase = getName() + "'s turn.";
        System.out.println(playersTurnPhrase); //returns the name of the player who's turn it is
        for (int i = 0; i < playersTurnPhrase.length(); i++) {System.out.print("‾");}
        printScoreCard();

        while (rollNumber <= 2) {

            for (int d = 0; d < dice.length; d++) {
                if (!heldDie[d]) {dice[d].rollDie();}
            }

            System.out.println("\n"+getName() + " rolled: ");
            printDice(dice);
            System.out.println();


            boolean answeredCorrectly = false; //initializes answeredCorrectly to false. this is used to ask the player
            // if they would like to re-roll, but it will keep them here unless they answer yes or no.

            if (rollNumber < 2) {
                do {
                    System.out.print("Would you like to roll again? ");
                    String reRollDice = sc.nextLine();

                    if (reRollDice.equalsIgnoreCase("yes")) {

                        Arrays.fill(heldDie, false);
                        rollNumber = rollNumber + 1; //increases roll count by 1. If i=1 then it is now the second roll, and if i=2
                        // then it is now the third roll.

                        int[] desiredHeldDice = new int[1];
                        desiredHeldDice[0] = -1; // Initialize array to loop state (resized later)
                        while (desiredHeldDice[0] == -1) {
                            desiredHeldDice = promptDiceList();
                            for (int h = 1; h < 6; h++) {
                                if (inIntArr(h, desiredHeldDice)) {
                                    heldDie[h - 1] = true;
                                }
                            }
                        }
                        answeredCorrectly = true; //releases the user from the answeredCorrectly 'loop'

                    } else if (reRollDice.equalsIgnoreCase("no")) {
                        rollNumber = 3; //sets the roll count to 3,
                        answeredCorrectly = true; //releases the user from the answeredCorrectly 'loop'
                    }
                } while (!answeredCorrectly);}
            else{rollNumber++;}
        }

        rules.checkBonuses(dice); // Allow Yahtzee and Upper Bonuses to be scored
        promptCategory(); // Prompt the user to choose a category and score that roll for them

        //below line is supposed to call the instance of the Rules class that the current player has, and then
        //calculate the score of the roll before starting the next player's turn.

        int prevScore = score;
        score = rules.getTotalScore();
        System.out.println("Current Score: "+score+" (+"+(score-prevScore)+")"); // Print the score, and how many points the player gained during that turn
        System.out.println();
    }

    private void listCategories() { // List available categories
        for (int index = 1; index <= 13; index++) {
            if (!rules.checkCategory(index)) { // Show categories if they haven't been used yet
                System.out.print(index+": "+getCategoryName(index)+"    "); // Spacing like this may need to be adjusted
            }
        }
        System.out.println();
    }

    private static void printDice(Die[] dice){ // List the dice - graphical dice have been scrapped
        for(int i=0;i<5;i++){System.out.print(dice[i].getFaceValue()+" ");}
    }

    private static int promptCategoryID() throws InputMismatchException {
        System.out.print("Please choose a category to score under. ");
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

    private static int[] promptDiceList() throws InputMismatchException{
        System.out.print("Which dice would you like to set aside? (Separated by commas. Dice are ordered 1-5.) ");
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

    private static String fetchParam(String str, int index){ // Get a set parameter from a formatted input, like "1,2,3"
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

    private static boolean inIntArr(int query,int[] arr){ // Searches for an integer in an array
        for (int anArr : arr) {
            if (anArr == query) {
                return true;
            }
        }
        return false;

    }

    private void promptCategory(){ // Prompts for AND scores in the category
        int choice = 0;
        boolean valid = false;
        while (!valid) {
            System.out.println();
            listCategories();
            choice = promptCategoryID();
            valid = ((choice >= 1 && choice <= 13) && !rules.checkCategory(choice));
            if (!valid) {System.out.println("The category you've picked has been used or is an invalid number.");}
        }
        rules.scoreCategory(dice,choice); // Score in the category
        printScoreCard();
    }

    private static String getCategoryName(int categoryID){ // Returns a category's name
        switch(categoryID){
            case 1: return "Aces";
            case 2: return "Twos";
            case 3: return "Threes";
            case 4: return "Fours";
            case 5: return "Fives";
            case 6: return "Sixes";
            case 7: return "3 of a Kind";
            case 8: return "4 of a Kind";
            case 9: return "Small Straight";
            case 10: return "Large Straight";
            case 11: return "Full House";
            case 12: return "Yahtzee";
            case 13: return "Chance";
        }
        throw new IllegalArgumentException("Expected number 1-13, got "+categoryID);
    }

    private void printScoreCard(){  // Print the scores of previously scored categories
        System.out.println("\n"+name+"'s Scorecard:");
        boolean empty = true;
        for (int x = 1; x <= 13; x++) {
            if(rules.checkCategory(x)){System.out.print(getCategoryName(x)+": " + rules.getCategoryScore(x)+" pts.   ");empty=false;}
        }
        if(rules.getBonusPoints()>0){System.out.print("Bonus: "+rules.getBonusPoints()+" pts.");} // No need to factor into emptiness because a bonus on the first turn is impossible
        if(empty){System.out.print("No scores yet.");}
        System.out.println();
    }
}
