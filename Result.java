

public class Result {

    private static final int BLACK = 1;
    private static final int WHITE = 0;
    private int[] results;

    public Result() {
        this.results = new int[] { -1, -1, -1, -1 };
    }

	public void check(SecretCombination secretCombination, ProposedCombination proposedCombination) {
        for (int i = 0; i < secretCombination.colors.length; i++) {
            Color goal = secretCombination.colors[i];
            for (int j = 0; j < proposedCombination.colors.length; j++) {
                if (proposedCombination.colors[j] == goal) {
                    if (i == j) {
                        this.results[i] = 1;
                        break;
                    } 
                    else {
                        this.results[i] = 0;
                    }                   
                }
            }
        }
	}

	public boolean isWinner() {
        Console console = new Console();
        if (this.numberOfHints(BLACK) == 4) {
            console.out("You've won!!! ;-)\n");
            return true;
        }
        return false;
	}

    private int numberOfHints(int color) {
        int result = 0;
        for (int i = 0; i < results.length; i++) {
            if (results[i] == color) {
                result++;
            }
        }
        return result;
    }

	public void show(int attempts, SecretCombination secretCombination, ProposedCombination[] proposedCombinations) {
        Console console = new Console();
        console.out((attempts + 1) + " attemps(s):\n" + secretCombination.show() + "\n" + proposedCombinations[attempts].show() 
                    + " --> " + this.numberOfHints(BLACK) + " blacks and " + this.numberOfHints(WHITE) + " whites\n");
	}
}
