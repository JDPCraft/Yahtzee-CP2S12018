class Rules {


    private int[] categoryScore;
    private boolean[] categoryCheck;

    // Player class holds a play from its class, then will grab this.player to be specifice to correctly grabbing the right player
    // categoryCheck is a new 13 array list, the index is 0-12 however, but we have the program set all to false.
    Rules() {
        categoryCheck = new boolean[13];

        //Creating categoryScore to 13 new int's 0-12 in index form
        // We use i as an index just to replicate a for () for temp use in this method
        categoryScore = new int[13];

    }

    // This is getting the sc category and checking it
    // pValue is temporary there choice every time chose is chosen, since its not in index form were -1 to make sure it selects 0-12
    // As long as they chose categories 1-6 this will recognise certain number for the category
    // checkUpper is making sure a number equals that rolled number and getting how many dice values equal up to it
    // Now were setting the score for chosen category and making it there score which is sumDice that holds the score
    // We check that category off by turning it true so it is not re usable


    void scoreCategory(Die[] dice, int chose) { // Sets scores (maybe)
        if ((!checkCategory(chose)) || chose == 12) { // Disallow already previously scored categories to be scored again with the exception of Yahtzees.

            // Cases 1-6 are Aces, Twos, etc
            // Cases 7-13 are the other categories

            if(chose>0 && chose<7){ // Deal with cases 1-6 since they're all handled the same
                if (checkUpper(dice, chose)) {
                    categoryScore[chose - 1] = sumDice(dice, chose);
                }
            }

            switch (chose) { // Switch for 7-13 since they're all handled differently

                //case 7 is ThreeOfAKind
                case (7):
                    if(getMatch(dice,3)!=-1){categoryScore[chose - 1] = getMatch(dice,3)*3;} // Gets the faceValue with three instances, multiplies by 3 to get the score
                    break;

                //case 8 is FourOfAKind
                case (8):
                    if(getMatch(dice,4)!=-1){categoryScore[chose - 1] = getMatch(dice,4)*4;} // Gets the faceValue with four instances, multiplies by 4 to get the score
                    break;

                //case 9 is SmallStraight
                case (9):
                    categoryScore[chose - 1] = scoreStraight(false,dice);
                    System.out.println("SS: "+scoreStraight(false,dice));
                    break;

                //case 10 is LargeStraight
                case (10):
                    categoryScore[chose - 1] = scoreStraight(true,dice);
                    System.out.println("LS: "+scoreStraight(true,dice));
                    break;

                //case 11 is FullHouse
                case (11):
                    if (checkFullHouse(dice)) {
                        categoryScore[chose - 1] = 25;
                    }
                    break;

                //case 12 is Yahtzee
                case (12):
                    if(getMatch(dice,5)!=-1){
                        if(!categoryCheck[chose-1]){categoryScore[chose - 1]= 50;} // First Yahtzee score is 50 the first time
                        else{categoryScore[chose - 1]+= 100;} // Add 100 bonus points for subsequent Yahtzees
                    }
                    break;

                //case 13 is Chance
                case (13):
                    categoryScore[chose - 1] = sumDice(dice); // Chance adds up all dice values, not just those of specific faceValues
                    break;
            }
            categoryCheck[chose - 1] = true;
        }
        if(chose<1||chose>13){
            throw new IllegalArgumentException("Invalid Category: "+chose); // Crash because this shouldn't happen
        }
    }

    private boolean checkUpper(Die[] dice, int value) {
        for (Die mFaceValue : dice) {
            if (mFaceValue.getFaceValue() == value) {
                return true;
            }
        }
        return false;
    }


    private int getMatch(Die[] dice, int numberOfDice) { // multipurpose "of a kind" function that returns what number has the matches, -1 if none

        for(int i=0;i<5;i++){ // Test how many matches each faceValue of Die i has
            int matches = 0;
            for(int j=0;j<5;j++){
                if(dice[i].getFaceValue()==dice[j].getFaceValue()){matches++;} // Goes through each die faceValue and tests how many times it equals a die in the array, counting itself
            }
            if(matches >= numberOfDice){return dice[i].getFaceValue();} // Match quota met!
        }
        return -1; // No matches found
    }

    private boolean getSpecificMatch(Die[] dice, int faceValue, int numberOfDice) { // Check for a specific chain of numbers, like a yahtzee of threes, or a four-of-a-kind of sixes.
        int matches = 0;
        for(int i=0;i<5;i++){
            if(dice[i].getFaceValue()==faceValue){matches++;} // Goes through each die faceValue and tests how many times it equals a die in the array, counting itself
        }
        // Exact match!
        return matches == numberOfDice;
    }

    private boolean checkFullHouse(Die[] dice) {
        boolean hasShortSegment = false;
        boolean hasLongSegment = false;
        for(int i=1;i<=6;i++) { // Check for the small segment, iterating to all of the possible two-of-a-kinds
            if(getSpecificMatch(dice,i,2)){hasShortSegment=true;}
        }
        for(int i=1;i<=6;i++) { // Check for the large segment, iterating to all of the possible three-of-a-kinds
            if(getSpecificMatch(dice,i,3)){hasLongSegment=true;}
        }
        return hasShortSegment&&hasLongSegment; // If we have both segments, then we have a full house!
    }



    // Just to clarify if the category is available for use, if it's false
    // the return value may look switched but default was set to check as long as its default it can be used.
    boolean checkCategory(int pValue) {
        if (pValue < 1 || pValue > 13) {
            return false;
        } else {
            return categoryCheck[pValue-1];
        }
    }

    int getCategoryScore(int pValue) {
        if (pValue < 1 || pValue > 13) {
            return 0;
        } else {
            return categoryScore[pValue-1];
        }
    }


    private int sumDice(Die[] dice){
        int subTotal = 0;

        // facevalue is getting the dice now
        for (Die die : dice) {
            subTotal += die.getFaceValue();

        }
        return subTotal;
    }

    private int sumDice(Die[] dice, int value){


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
            }}return subTotal;}

    // Methods for straight scoring only

    private static int scoreStraight(boolean large, Die[] dice){
        boolean scored;
        if(large){ // Large straight
            for(int ofs = 0;ofs < 2; ofs++) { // Large straights have two possible sets of integers to look for
                scored = true;
                for (int i = 1+ofs; i <= 5+ofs; i++) {
                    if (inDice(dice, i)) { // Check for the existence of iterated numbers
                        scored = false;
                    }
                }
                if(scored){return 40;}
            }
        }
        else{ // Small straight
            for(int ofs = 0;ofs < 3; ofs++) { // Small straights have three possible sets of integers to look for
                scored = true;
                for (int i = 1+ofs; i <= 4+ofs; i++) {
                    if (inDice(dice, i)) { // Check for the existence of iterated numbers
                        scored = false;
                    }
                }
                if(scored){return 30;}
            }
        }
        return 0;
    }

    // Check for the existence of a certain faceValue in the dice array
    private static boolean inDice(Die[] dice, int query){
        for (Die aDice : dice) {
            if (aDice.getFaceValue() == query) {
                return false;
            }

        }
        return true;
    }

    // End of methods used for straight scoring only

    int getTotalScore(){
        int subTotal=0;
        for (int aCategoryScore : categoryScore) {
            subTotal += aCategoryScore;
        }
        return subTotal;
    }

}