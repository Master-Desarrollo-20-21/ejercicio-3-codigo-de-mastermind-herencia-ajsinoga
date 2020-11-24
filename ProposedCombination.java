
class ProposedCombination extends Combination{

    public ProposedCombination() {
        super();
	}

	public void propose() {
        String proposal;
		Console console = new Console();		
        do {
            proposal = console.readString("Propose a combination: ");
        } while (!this.isValid(proposal)); 
        
        this.saveCombination(proposal);
    }
}
