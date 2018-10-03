import java.util.Scanner;

public class Player {

    //initializes variables
    private String name;
    private int score;
    private boolean isPlaying;
    Die[] dice;
 //   private int finalScore;

    //initializes constructors, getters, setters, and the array that holds the dice.
    public Player(String name) {
        this.name = name;
        dice = new Die[5];

        /*for(Die die: dice){
            die.
        }*/
    }

    public Die[] getDice() {
        return dice;
    }

    public void setDice(Die[] dice) {
        this.dice = dice;
    }

    public Player(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

 //   public Player(int finalScore) {this.finalScore = finalScore;}

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return this.name;
    }
    public boolean getIsPlaying() {
        return this.isPlaying;
    }

    //getFinalScore is no longer needed
   // public int getFinalScore() {return this.finalScore;}

    //method takeTurn that will contain all of the aspects of a player's turn.
//  public int takeTurn(int i) {
    public int takeTurn() {

        Scanner reRoll = new Scanner(System.in); //scanner used to ask the player if they want to re-roll the dice after
        // an initial or previous roll on their current turn.

        //code TODO in next build of player class
        //ask the player after rolling which dice they would like to set aside by having them type a number 1 through 5
        // where each number corresponds to a dice, and then asks them if they want to set aside another dice to allow
        // them to set aside more than just one dice, but set it up so they can't set aside they same dice more than
        // once to avoid potential errors? Then set up a for loop so that when the player next rolls, it only re-rolls
        // the dice that they didn't set aside. (We could make variables called dice(dice #) re-roll which would be
        // boolean variables initially initialized as false, then change them to true if the player wants to re-roll
        // that certain dice, but set any of them that are true back to false after the roll.)



        //array to hold 5 dice is needed

       // int[] Die = new int[5];

        /*Die die1 = new Die();
        Die die2 = new Die();
        Die die3 = new Die();
        Die die4 = new Die();
        Die die5 = new Die();*/

        int i=0; //initializes a variable i that keeps track of the number of the times the dice were rolled.

            System.out.println("It is now player " + getName() + "'s turn."); //returns the name of the player who's
        // turn it is

        while(i<=2) { //while the variable i is less than or equal to 2 (i=0 is the first/initial roll.), return the
            // dice value for all five dice that the player rolled.

            System.out.println("You Rolled: " + dice[0].getFaceValue() + " " + dice[1].getFaceValue() + " " +
                    dice[2].getFaceValue() + " " + dice[3].getFaceValue() + " " + dice[4].getFaceValue());

            System.out.println(" ");

            boolean answeredCorrectly = false; //initializes answeredCorrectly to false. this is used to ask the player
            // if they would like to re-roll, but it will keep them here unless they answer yes or no.

            do {
                System.out.println("Would you like to roll again?");
                String reRollDice = reRoll.nextLine();

                if (reRollDice.equalsIgnoreCase("yes")) {
                   i = i + 1; //increases roll count by 1. If i=1 then it is now the second roll, and if i=2 then it is
                    // now the third roll.
                    answeredCorrectly = true; //releases the user from the answeredCorrectly 'loop'
                }
                else if (reRollDice.equalsIgnoreCase("no")) {
                    i = 3; //sets the roll count to 3,
                    answeredCorrectly=true; //releases the user from the answeredCorrectly 'loop'
                } else {
                    answeredCorrectly = false;
                }
            } while(!answeredCorrectly);

        }

        return getScore();

        }

    }