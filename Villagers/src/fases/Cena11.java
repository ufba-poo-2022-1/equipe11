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
import dialogos.Caixa;

public class Cena11 extends JPanel implements ActionListener, KeyListener{
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
	Player player = new Player(670,600, "Direita");

	//Selecionar o caminho trocando o parâmetro de Caminhos.
	Caminhos caminhos = new Caminhos(10);
	
	Decorativos decorativos = new Decorativos(0, 300, 400);
	Decorativos decorativos2 = new Decorativos(0, 400, 300);
	Decorativos decorativos3 = new Decorativos(0, 300, 400);
	Decorativos decorativos4 = new Decorativos(0, 0, 300);
	Decorativos decorativos5 = new Decorativos(0, 100, 200);
	Decorativos decorativos6 = new Decorativos(0, 650, 300);
	Decorativos decorativos7 = new Decorativos(0, 300, 100);
	Decorativos decorativos8 = new Decorativos(0, 400, 650);
	Decorativos decorativos9 = new Decorativos(0, 900, 200);
	Decorativos decorativos10 = new Decorativos(0, 800, 650);
	Decorativos decorativos11 = new Decorativos(0, 500, 450);
	Decorativos decorativos12 = new Decorativos(0, 1200, 650);
	Decorativos decorativos13 = new Decorativos(0, 800, 350);
	Decorativos decorativos14 = new Decorativos(0, 1200, 100);
	Decorativos decorativos15 = new Decorativos(0, 1100, 400);
	Decorativos decorativos16 = new Decorativos(1, 1250, 400);
	
	Caixa caixa = new Caixa();
	
	public Cena11(){ 
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
		decorativos8.draw(g);
		decorativos9.draw(g);
		decorativos10.draw(g);
		decorativos11.draw(g);
		decorativos12.draw(g);
		decorativos13.draw(g);
		decorativos14.draw(g);
		decorativos15.draw(g);
		decorativos16.draw(g);
		
		player.draw(g);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		player.animacao(player);
		player.colisaoTotalTela(player);
		
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
	
	public void passagemDeCaminho() {
        if(player.x > 1219) {
        	Janela.batalha.timer.start();
        	Janela.cena11.timer.stop();
        	Janela.getIntro().clip.stop();
        	Janela.getIntro().playAudio(Janela.getIntro().batalha1, 0);
            Janela.cl.show(Janela.panelBase, "batalha");
        }/*
            else if(player.y > 610) {
        	Janela.cena10.timer.start();
        	Janela.cena11.timer.stop();
        	Janela.cl.show(Janela.panelBase, "cena11");
        }*/

	}		
}