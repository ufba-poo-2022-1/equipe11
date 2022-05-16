package cenários;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

import Interface.Intro;

public class Cena02 extends JPanel implements ActionListener, KeyListener{
	//Resolução da tela
	final static int SCREEN_WIDTH = Intro.SCREEN_WIDTH;
	final static int SCREEN_HEIGHT = Intro.SCREEN_HEIGHT;
		
	//Timer ajustes, delay define intervalo(ms) em que ações são percebidas
	Timer timer;
	int delay = 10; 
	
	//Parametrização animação personagem
	int personagemDelay = 0;
	//Intervalo de tempo entre frames da animação do personagem
	//Cada unidade multiplica o delay (TrocaPosição = delay * unidade)
	int TrocaPosição = 15;
	
	//Imagens e seus caminhos
	//Player parado
	Image parado01;
	String pathParado01 = "images//player//parado//player_parado1.png";
	Image parado02;
	String pathParado02 = "images//player//parado//player_parado2.png";
	
	//Player andando para direita
	Image direita01;
	String pathDireita01 = "images//player//direita//player_andando_right1.png";
	Image direita02;
	String pathDireita02 = "images//player//direita//player_andando_right2.png";
	Image direita03;
	String pathDireita03 = "images//player//direita//player_andando_right3.png";
	Image direita04;
	String pathDireita04 = "images//player//direita//player_andando_right4.png";
	
	//Player andando para esquerda
	Image esquerda01;
	String pathEsquerda01 = "images//player//esquerda//player_andando_left1.png";
	Image esquerda02;
	String pathEsquerda02 = "images//player//esquerda//player_andando_left2.png";
	Image esquerda03;
	String pathEsquerda03 = "images//player//esquerda//player_andando_left3.png";
	Image esquerda04;
	String pathEsquerda04 = "images//player//esquerda//player_andando_left4.png";
	
	
	//Parâmetros para movimentação, velocidade inicial e posição inicial
	public static int x = 0, y = 0, velx = 0, vely = 0;
	boolean w = false, s = false, a = false, d = false;
		
	public Cena02(){ 
		
		//Inicialização do painel	
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		parado01 = new ImageIcon(pathParado01).getImage();
		parado02 = new ImageIcon(pathParado02).getImage();
		direita01 = new ImageIcon(pathDireita01).getImage();
		direita02 = new ImageIcon(pathDireita02).getImage();
		direita03 = new ImageIcon(pathDireita03).getImage();
		direita04 = new ImageIcon(pathDireita04).getImage();
		esquerda01 = new ImageIcon(pathEsquerda01).getImage();
		esquerda02 = new ImageIcon(pathEsquerda02).getImage();
		esquerda03 = new ImageIcon(pathEsquerda03).getImage();
		esquerda04 = new ImageIcon(pathEsquerda04).getImage();
		
		
		//Timer iniciado
		timer = new Timer(delay, this);
		timer.start();
		
		//Parâmetros para detecção do teclado
		requestFocusInWindow();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		requestFocusInWindow();
		Graphics2D cena022D = (Graphics2D) g;
		super.paintComponent(cena022D);
		
		if (w == true & d == true | s == true & d == true | d == true) {
			if (personagemDelay <= TrocaPosição/2) {
				cena022D.drawImage(direita01, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosição)) {
				cena022D.drawImage(direita02, x, y, null);
			}
			else if (personagemDelay <= TrocaPosição*3/2) {
				cena022D.drawImage(direita03, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosição*2)) {
				cena022D.drawImage(direita04, x, y, null);
			}	
		}
		
		else if (w == true & a == true | s == true & a == true | a == true) {
			if (personagemDelay <= TrocaPosição/2) {
				cena022D.drawImage(esquerda01, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosição)) {
				cena022D.drawImage(esquerda02, x, y, null);
			}
			else if (personagemDelay <= TrocaPosição*3/2) {
				cena022D.drawImage(esquerda03, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosição*2)) {
				cena022D.drawImage(esquerda04, x, y, null);
			}	
		}
		
		else if (w == true | s == true) {
			if (personagemDelay <= TrocaPosição/2) {
				cena022D.drawImage(direita01, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosição)) {
				cena022D.drawImage(direita02, x, y, null);
			}
			else if (personagemDelay <= TrocaPosição*3/2) {
				cena022D.drawImage(direita03, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosição*2)) {
				cena022D.drawImage(direita04, x, y, null);
			}	
		}
		
		else {	
			if (personagemDelay <= TrocaPosição) {
				cena022D.drawImage(parado01, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosição*2)) {
				cena022D.drawImage(parado02, x, y, null);
			}					
		}
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		x = x + velx;
		y = y + vely;
		personagemDelay += 1;
		if(personagemDelay > (TrocaPosição*2)) {
			personagemDelay = 0;
		}

		repaint();
	}
	
	public void up() {
		vely = -4;		
	}
	
	public void down() {
		vely = 4;		
	}
	
	public void left() {		
		velx = -4;
	}
	
	public void right() {		
		velx = 4;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			System.out.println("key W Pressed");
			w = true;
			up();
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			System.out.println("key S Pressed");
			s =  true;
			down();
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			System.out.println("key A Pressed");
			a = true;
			left();
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			System.out.println("key D Pressed");
			d = true;
			right();
		}		
	}
	
	public void keyTyped(KeyEvent e) {}
	
	public void keyReleased(KeyEvent e) {
		//iguala zero aqui para parar o movimento quanto soltar o botao
		if (e.getKeyCode() == KeyEvent.VK_W) {
			System.out.println("key W Realeased");
			w = false;
			vely = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			System.out.println("key S Realeased");
			s = false;
			vely = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			System.out.println("key A Realeased");
			a = false;
			velx = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			System.out.println("key D Realeased");
			d = false;
			velx = 0;
		}
		
		if(w == true & s == false) {
			up();
		}
		else if(w == false & s == true) {
			down();
		}
		
		if(a == true & d == false) {
			left();
		}
		else if(a == false & d == true) {
			right();
		}
	}
}
