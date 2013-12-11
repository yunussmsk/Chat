import javax.swing.*;

public class Main {
	public static void main(String args[]) {
		
		Chat me = new Chat("Yunus");
		Chat fr = new Chat("Camara");
		
		me.other = fr;
		fr.other = me;
		
		me.setVisible(true);
		fr.setVisible(true);
		
	}
}
