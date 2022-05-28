package cenários;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Player extends JPanel  {
	//Parametrização animação personagem
	public int personagemDelay = 0;
	//Intervalo de tempo entre frames da animação do personagem
	//Cada unidade multiplica o delay (TrocaPosição = delay * unidade)
	public int TrocaPosição = 15;
	
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
	public int x;
	public int y;
	public int velx = 0;
	public int vely = 0;
	public boolean w = false, s = false, a = false, d = false;
	
	//Parâmetros x e y para definir posição inicial
	public Player(int x, int y) {
		
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

	public void draw(Graphics g) {
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
}
