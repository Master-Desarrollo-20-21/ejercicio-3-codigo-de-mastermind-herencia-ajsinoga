
class ProposedCombination extends Combination{

    public ProposedCombination() {
        super();
	}

    @Override
    public String generate() {
        Console console = new Console();
        return console.readString("Propose a combination: ");
    }
}
