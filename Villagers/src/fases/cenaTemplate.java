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

public class cenaTemplate extends JPanel implements ActionListener, KeyListener{
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
    Player player = new Player(0,0, "Direita");
    
    //Inicializar menina
    Menina menina = new Menina(1,200,200);

    //Selecionar o caminho trocando o parâmetro de Caminhos.
    Caminhos caminhos = new Caminhos(4);

            
    public cenaTemplate(){ 
        //
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
    	//Algoritmo Movimentação e animação player
        player.x = player.x + player.velx;
        player.y = player.y + player.vely;
        player.personagemDelay += 1;
        if(player.personagemDelay > (player.TrocaPosição*2)) {
            player.personagemDelay = 0;
        }
        
      //Algoritmo para menina olhar em direção ao player
        if(player.x > menina.x) {
            menina.orientacaoMenina = true;
        }
        else {
            menina.orientacaoMenina = false;
        }
        
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


    
    
}


