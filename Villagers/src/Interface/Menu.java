package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Menu extends JPanel{
	//Resolução da tela
	final static int SCREEN_WIDTH = Intro.SCREEN_WIDTH;
	final static int SCREEN_HEIGHT = Intro.SCREEN_HEIGHT;

	public Menu(){	
		//Panel
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));	
		this.setBackground(Color.black);
		this.setLayout(null);
		
		//Configurações botão jogar
		JButton botaoJogar = new JButton("Jogar");	
		botaoJogar.setIcon(new ImageIcon("images//start.png"));
		botaoJogar.setBounds(SCREEN_WIDTH-500, 175, 400, 100);		
		botaoJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Botão jogar em construção");
				System.out.println("Botao jogar sendo pressionado");
				//Janela.cl.show(Janela.panelBase, "intro");		
			}
		});
		this.add(botaoJogar);
		
		//Configurações botão Opções
		JButton botaoOpcoes = new JButton("Opcoes");
		botaoOpcoes.setIcon(new ImageIcon("images//start.png"));
		botaoOpcoes.setBounds(SCREEN_WIDTH-500, 300, 400, 100);
		
		botaoOpcoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botao opções sendo pressionado");
				Janela.cl.show(Janela.panelBase, "animacao");
			}
		});
		this.add(botaoOpcoes);
		
		//Configurações botão sair
		JButton botaoSair = new JButton("Sair");		
		botaoSair.setIcon(new ImageIcon("images//start.png"));
		botaoSair.setBounds(SCREEN_WIDTH-500, 425, 400, 100);
		
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Botão sair em construção");
				System.out.println("Botao sair sendo pressionado");
				Intro.clip.stop();
				Exe.janela.dispose();
			}
		});
		this.add(botaoSair);
		this.setVisible(true);

	}	

	@Override
	public void paint(Graphics g) {
		super.paint(g);

	}
}