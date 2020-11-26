import java.util.Random;

class SecretCombination extends Combination {

    private final Color[] ALLOWEDCOLORS = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.PINK, Color.ORANGE}; 

	public SecretCombination() {
        super();        
    }

    @Override
    public String generate() {
        String proposal = "";        
        Color candidate;      
        do {                
            candidate = getCandidate();            
            if (isUnique(candidate, proposal)) {
                proposal = proposal + candidate.getColor();
            }                
        } while (proposal.length() != this.size());

        return proposal;
    }
    
    private Color getCandidate() {
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

    public String show() {
        return "xxxx";
    }

    public String showDecrypted() {
        return super.show();
    }
}
