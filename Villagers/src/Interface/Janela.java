package Interface;

import javax.swing.*;
import fases.Cena02;

import java.awt.*;

public class Janela extends JFrame{		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		//Card Layout
		static CardLayout cl = new CardLayout();
		static JPanel panelBase = new JPanel();
		
		//Cenas a serem inseridas na janela
		static Menu menu = new Menu();
		static Intro intro = new Intro();
		static animacao animacao = new animacao();
		static Cena02 cena02 = new Cena02();
		
		String TituloJanela = "The Villager's Journey";
		
	Janela(){
		panelBase.setLayout(cl);
		panelBase.add(intro, "intro");		
		panelBase.add(menu, "menu");
		panelBase.add(animacao, "animacao");
		panelBase.add(cena02, "cena02");
		cl.show(panelBase, "intro");
		
		this.setTitle(TituloJanela);		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(panelBase);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}