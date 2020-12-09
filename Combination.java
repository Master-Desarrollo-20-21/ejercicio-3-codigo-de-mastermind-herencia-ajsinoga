
abstract class Combination {

    private static final int NUMBEROFCOLORS = 4;
    protected Color[] colors;

	public Combination() {
        colors = new Color[NUMBEROFCOLORS];
    }

    public static int size() {
        return NUMBEROFCOLORS;
    }
    
    public String show () {
        String combination = "";
        for (int i = 0; i < NUMBEROFCOLORS; i++) {
            combination += colors[i].getColor();						            
        }
        return combination;
    }

    public void propose() {
        String proposal;		
        do {
            proposal = this.generate();            
        } while (!this.isValid(proposal)); 
        
        this.saveCombination(proposal);
    }

    public abstract String generate();

    public void saveCombination(String proposal) {
        for (int i = 0; i < NUMBEROFCOLORS; i++) {
            this.colors[i] = Color.valueOf(proposal.charAt(i));
        }
    }    

	public boolean isValid(String proposal) {
        if (!this.isValidLength(proposal.length())) {
            return false;
        }
        if (!this.areValidColors(proposal)) {
            return false;
        }
        return true;
	}

    private boolean isValidLength(int length) {
        Console console = new Console();
        if (length != NUMBEROFCOLORS) {
            console.out("Wrong proposed combination length\n");
            return false;
        }
        return true;
    }

    private boolean areValidColors(String proposal) {
        Console console = new Console();
        for (char color: proposal.toCharArray()) {
            if (Color.valueOf(color) == null) {
                console.out("Wrong colors, they must be: rbygop\n");
                return false;
            }
        }
        return true;
    }

    // public boolean compareColorAtPosition(Combination combination, int position)
    // {
    //     return this.colors[position] == combination.colors[position];
    // }
}
