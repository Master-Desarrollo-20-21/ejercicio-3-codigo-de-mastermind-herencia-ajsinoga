
class ProposedCombination extends Combination{

    public ProposedCombination() {
        super();
        this.make();
	}

	private void make() {
        String proposal;
		Console console = new Console();		
        do {
            proposal = console.readString("Propose a combination: ");
		} while (!super.isValid(proposal)); 
        
        for (int i = 0; i < proposal.length(); i++) {
            this.colors[i] = Color.valueOf(proposal.charAt(i));						            
        }    
    }
}
