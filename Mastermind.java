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
        this.showInfo(this.secretCombination);
        do {
            this.proposedCombinations[this.attempts] = new ProposedCombination();
            this.proposedCombinations[this.attempts].read();
            this.results[this.attempts] = new Result();
            this.results[this.attempts].verify(this.secretCombination, this.proposedCombinations[attempts]);
            this.results[this.attempts].show(attempts, this.secretCombination, this.proposedCombinations);
            this.attempts++;
        } while (!this.isComplete(attempts) && !this.results[this.attempts-1].isWinner());
    }

    private void showInfo(SecretCombination secretCombination) {
        Console console = new Console();
        console.out("\n ----- MASTERMIND -----\n" + "0 attemps(s):\n" + secretCombination.show() + "\n");
    }

    private boolean isComplete(int attempts) {
        Console console = new Console();
        if (attempts > 9) {
            console.out("You've lost!!! :-(\n");
            console.out("Secrete combination was: " + this.secretCombination.showUnepcrytp() + "\n");
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