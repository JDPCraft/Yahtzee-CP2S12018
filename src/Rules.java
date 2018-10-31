import java.lang.reflect.WildcardType;

public class Rules {

    private boolean[] Scoring;
    private int totalScore;
    private int[] categoryScore;
    private boolean[] categoryCheck;
    private Player player;


    // Player class holds a play from its class, then will grab this.player to be specifice to correctly grabbing the right player
    // categoryCheck is a new 13 array list, the index is 0-12 however, but we have the program set all to false.
    public Rules(Player player) {
        this.player = player;
        categoryCheck = new boolean[13];


/*      For later on

        // length i is starting at 0, Category 1 would be 0, and so on.
        for (int i = 0; i < categoryCheck.length;i++) {
            // Counting up to .length = [13]
            // Since i less than, will start 0-12, i is not <= so we -1 from regular categories to match them
            // When returned false and not true, then the category is available for this.player to use
            categoryCheck[i] = false;
        }
*/


            //Creating categoryScore to 13 new int's 0-12 in index form
            // We use I as an index just to replicate a for () for temp use in this method
            categoryScore = new int[13];
            for (int i = 0; i < categoryScore.length; i++) {
                categoryScore[i] = 0;
            }

    }




    // This is getting the chose category and checking it
    // pValue is temporary there choice every time chose is chosen, since its not in index form were -1 to make sure it selects 0-12
    // As long as they chose categories 1-6 this will recognise certain number for the category
    // checkUpper is making sure a number equals that ruled number and getting how many dice values equal up to it
    // Now were setting the score for chosen category and making it there score which is sumDice that holds the score
    // We check that category off by turning it true so it is not re usable

    public boolean checkCategoryInput(Die [] dice, int chose) {
        if (!checkCategory(chose)) {

            switch (chose) {
                //case 1 is Aces
                case (1):
                case (2):
                case (3):
                case (4):
                case (5):
                case (6):
                    if (checkUpper(dice, chose)) {
                        categoryScore[chose - 1] = sumDice(dice, chose);
                        categoryCheck[chose - 1] = true;
                    }
                    else{
                        categoryScore[chose - 1] = 0;
                        categoryCheck[chose - 1] = true;
                    }
                    //System.out.println(categoryCheck[chose - 1]);
                    return categoryCheck[chose - 1];


                //case 7 is ThreeOfAKind
                case (7):
                    //test print lines were for testing.
                    /*System.out.println("Test 7");*/
                    System.out.println(checkMatch(dice, 3));
                    return checkMatch(dice, 3);


                //case 8 is FourOfAKind
                case (8):
                    //test print lines were for testing.
                    /* System.out.println("Test 8");*/
                    System.out.println(checkMatch(dice, 4));
                    return checkMatch(dice, 4);


                //case 9 is SmallStraight
                case (9):
                    //test print lines were for testing.
                     System.out.println("Test 9");
                     return true;


                //case 10 is LargeStraight
                case (10):
                    //test print lines were for testing.
                     System.out.println("Test 10");
                    return true;

                //case 11 is FullHouse
                case (11):
                    //test print lines were for testing.
                    /* System.out.println("Test 11");*/
                    if (checkMatch(dice, 3) &&
                            checkMatch(dice, 2)) {
                        System.out.println("this works.");
                        return true;
                    }
                    //not sure if i need the !checkMatch(5)
                    break;

                //case 12 is Yahtzee
                case (12):
                    //test print lines were for testing.
                    /* System.out.println("Test 12");*/
                    System.out.println(checkMatch(dice, 5));
                    return checkMatch(dice, 5);
//case 12 crashes the game, not good.

                //case 13 is Chance
                case (13):
                    sumDice(dice, chose);
                    System.out.println(sumDice(dice, chose));
                    return true;
                //test print lines were for testing.
              /*  System.out.println("Test 13"); */


                default:
                    System.out.println("Invalid number or faulty code.");
                    break;
            }
//            if (chose < 7 && chose > 0) {
//                if (checkUpper(player.getDice(), chose)) {
//                    categoryScore[chose - 1] = sumDice(player.getDice(), chose);
//                    categoryCheck[chose - 1] = true;
//                    return true;
//                }
//            } else {
//
//
//                //todo lowersection
//                return true;
//            }

        } else {
            return false;
        }

        return false;

    }

    //This goes throw each dice, so it will loop 5 times checking each value and setting it
    // as long as certain values match up will count them as score but is depended on the category that's selected.

    private boolean checkUpper(Die[] dice, int value) {
        for (Die mFaceValue: dice) {
            if (mFaceValue.getFaceValue() == value) {
                return true;
            }}
        return false;
    }

    private boolean checkLower(Die[] dice, int value) {
        for(int i=0;i<(dice.length-2);i++){
            if((dice[i]==dice[i+1]&&dice[i+1]==dice[i+2]&&dice[i]==dice[i+2])){
        return true;
    }
            else{
        return false;}
}
        return false;
                }

//                private boolean checkMatch(Die[] dice, int value) {
//                    if (dice[]) {
//                        return true;
//                    }
//                    else {
//                        return false;
//                    }
//                }

    private boolean checkMatch(Die[] dice, int numberOfDice) {
        switch (numberOfDice) {
            case 2:
                for (int i = 0; i < (dice.length - 3); i++) {
                    if ((dice[i] == dice[i + 1])) {
                        categoryScore[11] = 20; //20 is a test value
                    //    checkLowerSector[11] = true;
                    }
                }
                break;

            case 3:
                for (int i = 0; i < (dice.length - 2); i++) {
                    if ((dice[i] == dice[i + 1] && dice[i + 1] == dice[i + 2] && dice[i] == dice[i + 2])) {
                        categoryScore[7] = 30; //30 is a test value
                    //    checkLowerSector[7] = true;
                    }
                }
                break;

            case 4:
                for (int i = 0; i < (dice.length - 1); i++) {
                    if ((dice[i] == dice[i + 1] && dice[i + 1] == dice[i + 2] && dice[i] == dice[i + 2] && dice[i] == dice[i + 3] && dice[i + 1] == dice[i + 3] && dice[i + 2] == dice[i + 3])) {
                        //1 to 2, 2 to 3, 1 to 3, 1 to 4, --2 to 4--, --3 to 4--
                        categoryScore[8] = 40; //40 is a test value
                    //    checkLowerSector[8] = true;
                    }
                }
                break;

            case 5:
                for (int i = 0; i < (dice.length); i++) {
                    if ((dice[i] == dice[i + 1] && dice[i + 1] == dice[i + 2] && dice[i] == dice[i + 2] && dice[i] == dice[i + 3] && dice[i + 1] == dice[i + 3] && dice[i + 2] == dice[i + 3] && dice[i] == dice[i + 4] && dice[i + 1] == dice[i + 4] && dice[i + 2] == dice[i + 4] && dice[i + 3] == dice[i + 4])) {
                        //1 to 2, 2 to 3, 1 to 3, 1 to 4, --2 to 4--, --3 to 4--
                        categoryScore[12] = 50; //50 is a test value
                    //    checkLowerSector[12] = true;
                    }
                }
                break;
        }
        return true;
    }









        /*
        for (Die mFaceValue: dice) {
            if (mFaceValue.getFaceValue() == value) {
                return true;
            }}
        return false;
    }*/

//    private boolean presetCheckCategoryLower(Die[] dice, int value) {
//        for (int i=0; i <= 6; i++) {
//
//            boolean[] checkingLowerSection = new boolean[7];
//            int[] matchLowerSection = new int[7];
//
//
//            for (Die mFaceValue: dice) {
//                if (mFaceValue.getFaceValue() ==)
//                    value = matchLowerSection[i];
//
//            if (checkingLowerSection[i] == true) {
//
//                checkingLowerSection[i] =
//                }
//            }
//            }
//
//        }


    // Just to clarify if the category is available for use, if false it is
    // the return value may look switched but default was set to check as long as its default it can be used.
    public boolean checkCategory(int pValue) {
        int fixedNumber;
        if (pValue < 1 || pValue > 13) {
            return false;
        } else {
            return categoryCheck[pValue-1];
        }



    }




    public int sumDice(Die[] dice, int value){


        // The subtotal will be 0, until returned with the new faceValue
        // We want to grab all dice and check them as well, not only score them
        int subTotal = 0;

        // facevalue is getting the dice now
        for(Die die: dice){
            int facevalue = die.getFaceValue();

            // If facevalue equals to the value then subtotal will be returnable as long as there is a matched int
            if(facevalue == value){


                // subTotal will be greater or equals to faceValue then
                subTotal += facevalue;
            }
        }


        // subTotal is switched from 0 to the new score of the 5 dices
        return subTotal;


    }


    /*// Back to category check, when a category is checked by a successful method, we will return it to true.
    public int checkScore(int[] dice) {


        // Now getting this. (certain category, looks into each one until it finds categoryCheck[0-12]
        // Will check the score if 0 return the dice to the player and either end or next turn created by Player
        for (int i = 0; i < this.categoryCheck.length; i++) {


            // if category is false categoryCheck[i=false]      { return dice; to player
            if (categoryCheck[i]) {


                // Now giving the player the dice back since they cant do anything with it
                return dice;


                // This is part 1 of 2 of checking, with this part were grabbing the dice for whichever upper/lower section they selected
                // Once it goes throughout the code for the upper/lower sectioned game rules code, and if they scored an actual score
                // Then we will flip the category from false to true for the selection they chose


                // ------ This section still needs tweaked and fixed a little ------
            } else if (checkUpper()) {


                // Category check is now switched to true
                categoryCheck[0] = true;


                // Category Score is done in the part 2 of 2, which is called checkDie

                // Doing the same thing as checkUpper but for checking checkTwos die requirements
                // Will be done during beta
            }

            }}
            return dice;

        }
*/



    // Getting int[0-12] and a new value to add up the (sub) total, not initial score (These are where the 5 dices are placed and checked)





    //Checking the real score from the dice values
   /*  public void checkDieRealScore (Die[] dice){


        // Created new diceValue now is this.players score, then getting the score to return to diceValue
        int NewDvalue = this.player.setScore();
        int diceValue = this.player.getScore();

        // now checking part 2 of 2 of upper section and lower later, getting the dice score which whatever value is needed
        for(int i = 1; i<=6;i++){
        if (checkUpper(dice, i)) {


            //Trying to get the 5 dice and
            diceValue += sumDice(dice,i);
            // diceValue now equals the amount of dices that equalled a one, so 1-5, and this score will be set into the categoryScore[0] later

            //New
            //NewDvalue += totalDice()



        }
        }

        this.player.setScore(diceValue);

        // Gets the new diceValue depending on which check method was chosen and how many dice landed or scored that

    }*/


        // mFaceValue is a temporary hold for holding class Die's Die array



    //Lower section will be worked on during beta


        // Grabbing how many dices rolled on that number
    // Will be different for lower section
    public void calculatePlayerScore(){
        int subtotal = 0;
        for(int value: categoryScore){
            subtotal += value;
        }
        totalScore = subtotal;

    }




    // Just returning the total score from each category score

    public boolean[] getScoring() {
        return Scoring;
    }
    public int getTotalScore() {
        return totalScore;

    }

}

