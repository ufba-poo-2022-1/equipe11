package fases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import Interface.Intro;
import cenários.Caminhos;
import cenários.Menina;
import cenários.Player;

public class Cena02 extends JPanel implements ActionListener, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Resolução da tela
	final static int SCREEN_WIDTH = Intro.SCREEN_WIDTH;
	final static int SCREEN_HEIGHT = Intro.SCREEN_HEIGHT;
		
	//Timer ajustes, delay define intervalo(ms) em que ações são percebidas
	Timer timer;
	int delay = 10; 
	
	//Inicializando player
	Player player = new Player(0,0);
	
	//Inicializar menina
	Menina menina = new Menina(1,200,200);

	//Selecionar o caminho trocando o parâmetro de Caminhos.
	Caminhos caminhos = new Caminhos(1);
		
	public Cena02(){ 
		
		//Inicialização do painel	
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
				
		//Timer iniciado
		timer = new Timer(delay, this);
		timer.start();
		
		//Parâmetros para detecção do teclado
		requestFocusInWindow();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
	}
	
	public void paint(Graphics g) {
		requestFocusInWindow();
		super.paint(g);
		
		caminhos.draw(g);
		menina.draw(g);
		player.draw(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		player.x = player.x + player.velx;
		player.y = player.y + player.vely;
		player.personagemDelay += 1;
        if(player.personagemDelay > (player.TrocaPosição*2)) {
        	player.personagemDelay = 0;
        }

        repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			System.out.println("key W Pressed");
			player.w = true;
			player.up();
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			System.out.println("key S Pressed");
			player.s =  true;
			player.down();
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			System.out.println("key A Pressed");
			player.a = true;
			player.left();
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			System.out.println("key D Pressed");
			player.d = true;
			player.right();
		}		
	}
	
	public void keyTyped(KeyEvent e) {}
	
	public void keyReleased(KeyEvent e) {
		//iguala zero aqui para parar o movimento quanto soltar o botao
		if (e.getKeyCode() == KeyEvent.VK_W) {
			System.out.println("key W Realeased");
			player.w = false;
			player.vely = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			System.out.println("key S Realeased");
			player.s = false;
			player.vely = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			System.out.println("key A Realeased");
			player.a = false;
			player.velx = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			System.out.println("key D Realeased");
			player.d = false;
			player.velx = 0;
		}

		if(player.w == true & player.s == false) {
			player.up();
		}
		else if(player.w == false & player.s == true) {
			player.down();
		}
		
		if(player.a == true & player.d == false) {
			player.left();
		}
		else if(player.a == false & player.d == true) {
			player.right();
		}
	}


	
	
}
