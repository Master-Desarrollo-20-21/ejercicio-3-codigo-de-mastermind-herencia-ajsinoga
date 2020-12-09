class Mastermind {

    private final int NUM_MAX_ATTEMPTS = 10;
    private int attempts;
    private SecretCombination secretCombination;
    private ProposedCombination[] proposedCombinations;
    private Result[] results;    

    public Mastermind(){
        this.attempts = 0;
        this.secretCombination = new SecretCombination();
        this.proposedCombinations = new ProposedCombination[NUM_MAX_ATTEMPTS];
        this.results = new Result[NUM_MAX_ATTEMPTS];
    }

    public void play() {             
        this.showTittle();
        do {
            this.proposedCombinations[this.attempts] = new ProposedCombination();
            this.proposedCombinations[this.attempts].propose();
            this.results[this.attempts] = new Result();
            this.results[this.attempts].verify(this.secretCombination, this.proposedCombinations[attempts]);            
            this.attempts++;
            this.showResult();
        } while (!this.isComplete(attempts) && !this.results[this.attempts-1].isWinner());

        if (this.isComplete(attempts)) {
            this.showLostMessage();
        }
        else {
            this.showWinMessage();
        }
    }

    private void showTittle() {
        Console console = new Console();
        console.out("\n ----- MASTERMIND -----\n" + this.attempts + " attemps(s):\n" + this.secretCombination.show() + "\n");
    }

    private void showResult() {
        Console console = new Console();
        console.out((this.attempts) + " attemps(s):\n" + this.secretCombination.show() + "\n");
        for (int i = 0; i < this.attempts; i++) {
            console.out(this.proposedCombinations[i].show()  + " --> " 
                        + this.results[i].numberOfBlacks() + " blacks and " + this.results[i].numberOfWhites() + " whites\n");
        }
    }

    private boolean isComplete(int attempts) {
        return attempts == NUM_MAX_ATTEMPTS;
    }

    private void showLostMessage() {
        Console console = new Console();
        console.out("You've lost!!! :-(\n");
        console.out("Secrete combination was: " + this.secretCombination.showDecrypted() + "\n");
    }

    private void showWinMessage() {
        Console console = new Console();
        console.out("You've won!!! ;-)\n");
    }

    private boolean isResumed() {
        String answer;
        Console console = new Console();
        do {
            answer = console.readString("RESUME? (y/n): ");
        } while (!answer.equals("y") && !answer.equals("n"));

        return answer.equals("y");
    }

    public static void main(String args[]) {
        Mastermind game;
        do {                       
            game = new Mastermind();
            game.play();
        } while (game.isResumed());
    }
}