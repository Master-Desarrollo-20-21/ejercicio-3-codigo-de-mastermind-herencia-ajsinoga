class Mastermind {

    private SecretCombination secretCombination;
    private ProposedCombination[] proposedCombinations;
    private Result[] results;
    private int attempts;

    public Mastermind(){
        this.attempts = 0;
        this.secretCombination = new SecretCombination();
        this.proposedCombinations = new ProposedCombination[10];
        this.results = new Result[10];
    }

    public void play() {  
        this.showTittle();      
        do {
            this.proposedCombinations[this.attempts] = new ProposedCombination();
            this.proposedCombinations[this.attempts].propose();
            this.results[this.attempts] = new Result();
            this.results[this.attempts].verify(this.secretCombination, this.proposedCombinations[attempts]);
            this.showResult(this.results[this.attempts]);
            this.attempts++;
        } while (!this.isComplete(attempts) && !this.results[this.attempts-1].isWinner());
    }

    private void showTittle() {
        Console console = new Console();
        console.out("\n ----- MASTERMIND -----\n" + this.attempts + " attemps(s):\n" + this.secretCombination.show() + "\n");
    }

    private void showResult(Result proposal) {
        Console console = new Console();
        console.out((this.attempts + 1) + " attemps(s):\n" + this.secretCombination.show() + "\n" + this.proposedCombinations[this.attempts].show() 
                    + " --> " + proposal.numberOfBlacks() + " blacks and " + proposal.numberOfWhites() + " whites\n");
    }

    private boolean isComplete(int attempts) {
        Console console = new Console();
        if (attempts > 9) {
            console.out("You've lost!!! :-(\n");
            console.out("Secrete combination was: " + this.secretCombination.showUnencrypted() + "\n");
            return true;
        }
        return false;
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