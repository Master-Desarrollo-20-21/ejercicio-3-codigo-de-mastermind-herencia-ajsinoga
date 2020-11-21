
abstract class Combination {

    protected Color[] colors;

	public Combination() {
        colors = new Color[4];
    }
    
    public String show () {
        String combination = "";
        for (int i = 0; i < this.colors.length; i++) {
            combination += colors[i].getColor();						            
        }
        return combination;
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
        if (length != this.colors.length) {
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
}
