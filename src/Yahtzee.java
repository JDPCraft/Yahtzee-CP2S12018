import java.util.InputMismatchException;
import java.util.Scanner;
public class Yahtzee {
    public static void main(String[] args){

        System.out.println("Welcome to Yahtzee!\n");

        // Ask for number of players and their names
        boolean legalPlayerNum = false;
        Player players[];
        int totalPlayers = 1;
        while(!legalPlayerNum) {
            totalPlayers = promptPlayerNum();
            if(totalPlayers>=1&&totalPlayers<=1000){legalPlayerNum=true;}
            else{System.out.println("Please enter a number between 1 and 1000.");}
        }
        players = new Player[totalPlayers];
        for(int i=0;i<totalPlayers;i++){
            players[i] = new Player(promptString("What is Player "+(i+1)+"'s name?"));
        }
        System.out.println();

        // Gameplay loop
        for(int turns=0;turns<13;turns++){ // While anyone is playing, allow players to take their turn only if they are playing
            for(int p=0;p<totalPlayers;p++){
                players[p].takeTurn();
            }
        }

        // Display final scores and declare the winner
        System.out.println("- Final Scores -");
        printFinalScores(players);
        System.out.println("\n"+getWinnerName(players)+" wins!");
    }

    // ------------------------------------------------------------------------------------------------------ //

    private static int promptPlayerNum() throws InputMismatchException{
        System.out.print("How many players are there?" +" ");
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

    private static String promptString(String prompt){
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt+" ");
        return sc.nextLine();
    }

    private static void printFinalScores(Player players[]){
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore() + " pts.");
        }
    }

    private static String getWinnerName(Player players[]){
        int winner = 0; // Replaced if "Player 0" does not win
        for(int i=0;i<players.length;i++){
            if(players[i].getScore() > players[winner].getScore()){winner = i;}
        }
        return players[winner].getName();
    }
}
