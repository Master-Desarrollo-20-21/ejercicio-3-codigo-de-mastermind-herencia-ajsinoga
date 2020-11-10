import java.util.Random;

class SecretCombination extends Combination {


	public SecretCombination() {
        super();
        this.autoGenerate();
        //this.showUnepcrytp();
    }

    private void autoGenerate() {
        Random random = new Random();
        String colors = "rgbypo";
        int[] positions = new int[4];
        int numberOfColors = 0;
        int position = 0;           
        for(int i = 0; i < this.colors.length; i++) {            
            do {
                position = random.nextInt(6);
                if (!this.colorAlreadySelected(position, numberOfColors, positions)) {
                    this.colors[i] = Color.valueOf(colors.charAt(position));
                    positions[numberOfColors] = position;
                    numberOfColors++;
                    break;
                }
            } while (numberOfColors < 4);
        } 
    }
    
    private boolean colorAlreadySelected(int position, int numberOfColors, int[] positions) {
        for (int i = 0; i < numberOfColors; i++) {
            if (positions[i] == position) {
                return true;
            }
        }
        return false;
    }

    public void show() {
        Console console = new Console();
        console.out("xxxx");
    }

    private void showUnepcrytp() {
        super.show();
    }
}
