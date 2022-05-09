package Interface;

import javax.swing.SwingUtilities;

public class Exe {

	public static Janela janela;

	public static void main(String[] args) {
		janela = new Janela();
		Thread gameThread = new Thread(janela);
		gameThread.run();
	} 

}
