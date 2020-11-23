
class ProposedCombination extends Combination{

    public ProposedCombination() {
        super();
	}

	public void read() {
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
