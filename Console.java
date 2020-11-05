

public class Console {

	public String readString(String string) {
        System.out.print(string);
        return System.console().readLine();
	}

}
