

public class Result {

    private static final int BLACK = 1;
    private static final int WHITE = 0;
    private int[] results;

    public Result() {
        this.results = new int[] { -1, -1, -1, -1 };
    }

	public void verify(SecretCombination secretCombination, ProposedCombination proposedCombination) {
        for (int i = 0; i < secretCombination.colors.length; i++) {
            Color currentGoal = secretCombination.colors[i];
            for (int j = 0; j < proposedCombination.colors.length; j++) {
                if (proposedCombination.colors[j].equals(currentGoal)) {
                    if (i == j) {
                        this.addBlackBall(i); 
                        break;
                    } 
                    else {
                        this.addWhiteBall(i); 
                    }                   
                }
            }
        }
    }

    private void addBlackBall(int position) {
        this.results[position] = BLACK;
    }

	private void addWhiteBall(int position) {
        this.results[position] = WHITE;
    }

    public boolean isWinner() {
        Console console = new Console();
        if (this.numberOfHints(BLACK) == 4) {
            console.out("You've won!!! ;-)\n");
            return true;
        }
        return false;
	}

	public int numberOfBlacks() {
		return numberOfHints(BLACK);
	}

	public int numberOfWhites() {
		return numberOfHints(WHITE);
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
}
