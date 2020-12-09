

public class Result {

    private int blacks;
    private int whites;

    public Result() {        
        this.blacks = 0;
        this.whites = 0;
    }

	public void verify(SecretCombination secretCombination, ProposedCombination proposedCombination) {
        for (int i = 0; i < Combination.size(); i++) {
            Color currentGoal = secretCombination.colors[i];
            for (int j = 0; j < Combination.size(); j++) {
                if (proposedCombination.colors[j] == currentGoal) {
                    if (i == j) {
                        this.blacks++; 
                        break;
                    } 
                    else {
                        this.whites++; 
                    }                   
                }
            }
        }
    }

    public boolean isWinner() {
        return this.blacks == Combination.size();
	}

	public int numberOfBlacks() {
		return this.blacks;
	}

	public int numberOfWhites() {
		return this.whites;
    }    
}
