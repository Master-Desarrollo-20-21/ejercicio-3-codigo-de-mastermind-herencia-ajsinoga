import java.util.Random;

class SecretCombination extends Combination {

    private final Color[] ALLOWEDCOLORS = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.PINK, Color.ORANGE}; 

	public SecretCombination() {
        super();
        this.autoGenerate();
    }

    private void autoGenerate() {
        String proposal = "";        
        Color candidate;      
        do {                
            candidate = getCandidateColor();            
            if (isUnique(candidate, proposal)) {
                proposal = proposal + candidate.getColor();
            }                
        } while (!this.isValid(proposal));

        this.saveCombination(proposal);
    }
    
    private Color getCandidateColor() {
        Random random = new Random(); 
        return ALLOWEDCOLORS[random.nextInt(6)];
    }

    private boolean isUnique(Color candidate, String proposal) {
        for (int i = 0; proposal.length() > 0 && i < proposal.length(); i++) {
            if (candidate.getColor() == proposal.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid(String proposal) {
        return proposal.length() == this.size();
    }

    public String show() {
        return "xxxx";
    }

    public String showDecrypted() {
        return super.show();
    }
}
