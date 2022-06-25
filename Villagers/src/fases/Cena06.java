package fases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import Interface.Exe;
import Interface.Intro;
import Interface.Janela;
import cenarios.BotaoE;
import cenarios.Caminhos;
import cenarios.Decorativos;
import cenarios.Menina;
import cenarios.Player;
import cenarios.Velho;

public class Cena06 extends JPanel implements ActionListener, KeyListener{
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
	Player player = new Player(15,320, "Direita");
	
	//Inicializar menina
	Menina menina = new Menina(545,440);

	//Selecionar o caminho trocando o parâmetro de Caminhos.
	Caminhos caminhos = new Caminhos(5);
	
	//Inicializar velho
	Velho velho = new Velho(660, 439);
	
	//Inicializar botao
	BotaoE botao = new BotaoE(menina.x +40, menina.y - 50);
	
	Decorativos decorativos = new Decorativos(6, 100, 220);
	Decorativos decorativos2 = new Decorativos(10, 988, 160);
	Decorativos decorativos3 = new Decorativos(11, 720, 163);
	Decorativos decorativos4 = new Decorativos(7, 550, 210);
	Decorativos decorativos5 = new Decorativos(13, 290, 161);
	Decorativos decorativos6 = new Decorativos(0, 1220, 317);
	Decorativos decorativos7 = new Decorativos(4, 1255, 268);
	Decorativos decorativos16 = new Decorativos(1, 1250, 218);
	
	public Cena06(){ 
		//
		//Inicialização do painel	
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		
		//Timer iniciado
		timer = new Timer(delay, this);
		//timer.start();
		
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
		decorativos.draw(g);
		decorativos2.draw(g);
		decorativos3.draw(g);
		decorativos4.draw(g);
		decorativos5.draw(g);
		decorativos6.draw(g);
		decorativos7.draw(g);
		decorativos16.draw(g);
		
		menina.draw(g);
		velho.draw(g);
		
		player.draw(g);
		

		if(menina.proxima) {
			botao.draw(g);			
		}	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		botao.animacao(botao);
		
		player.animacao(player);
		player.colisaoTotalTela(player);
		
		velho.colisao(player, velho);
		velho.animacao(player, velho);
		
		menina.proximidade(player, menina);
		menina.colisao(player, menina);
		menina.animacao(player, menina);
		
		decorativos.colisaoD(player, decorativos16, 01);
		passagemDeCaminho();
        
		repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			player.w = true;
			player.up();
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			player.s =  true;
			player.down();
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			player.a = true;
			player.left();
			
			player.daux = false;
			player.aaux = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			player.d = true;
			player.right();
		
			player.aaux = false;
			player.daux = true;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_E) {
			if(menina.proxima) {
				System.out.println("Botao E pressionado proximo a menina.");
				Exe.janela.cl.show(Exe.janela.panelBase, "menu");
				player.x = 0;
				player.y = 500;
			}
			else {
				System.out.println("Botao E pressionado longe da menina.");
			}
			
		}
	}
		
	
	
	
	public void keyTyped(KeyEvent e) {}
	
	public void keyReleased(KeyEvent e) {
		//iguala zero aqui para parar o movimento quanto soltar o botao
		if (e.getKeyCode() == KeyEvent.VK_W) {
			player.w = false;
			player.vely = 0;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_S) {
			player.s = false;
			player.vely = 0;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_A) {
			player.a = false;
			player.velx = 0;
			
			player.direita = false;
			
			if(player.d) {
				player.daux = true;
			}
			player.aaux = false;
			
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			player.d = false;
			player.velx = 0;
			
			player.direita = true;
			
			if(player.a) {
				player.aaux = true;
			}
			player.daux = false;
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

	//Muda de cena ao chegar no fim do caminho.
	 public void passagemDeCaminho() {
	        if(player.x > 1219 && player.y == 320) {
	            Janela.cl.show(Janela.panelBase, "cena07");
	        }
	            else if(player.x < 3) {
	        	Janela.cl.show(Janela.panelBase, "cena05");
	        }
	
	 }	
	
	
}
