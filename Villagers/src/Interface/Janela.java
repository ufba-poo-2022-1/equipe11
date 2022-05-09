package Interface;

import javax.swing.*;
import java.awt.*;

public class Janela extends JFrame implements Runnable {		
		static CardLayout cl = new CardLayout();
		static JPanel panelBase = new JPanel();
		static Menu menu = new Menu();
		static Intro intro = new Intro();
		static animacao animacao = new animacao();
		
		String TituloJanela = "The Villager's Journey";
		
	Janela(){
		panelBase.setLayout(cl);
		panelBase.add(intro, "intro");		
		panelBase.add(menu, "menu");
		panelBase.add(animacao, "animacao");
		cl.show(panelBase, "intro");
		
		this.setTitle(TituloJanela);		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(panelBase);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(Intro.wait);
			
			//Exibir menu			
			cl.show(panelBase, "menu");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}