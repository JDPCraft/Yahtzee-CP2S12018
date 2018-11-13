class Die {
    private int faceValue;

    Die(){ // Die constructor
        rollDie(); // Automatically roll die upon creation
    }
    
    void rollDie(){
        this.faceValue = (int)(Math.floor(Math.random()*6)+1); // Randomize Die's faceValue
    }

    int getFaceValue() { // use [objectName].getFaceValue in code to get the Die's value
        return this.faceValue;
    }
}

