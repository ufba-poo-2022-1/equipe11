package cenarios;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Velho {
	
	Image VelhoDireita01;
	String VelhoDireita01Path = "images//Velho//parado//velho_right1.png";
	Image VelhoDireita02;
	String VelhoDireita02Path = "images//Velho//parado//velho_right2.png";
	
	public Image VelhoEsquerda01;
	String VelhoEsquerda01Path = "images//Velho//parado//velho_left1.png";
	Image VelhoEsquerda02;
	String VelhoEsquerda02Path = "images//Velho//parado//velho_left2.png";
	
	
	public Image VelhoAdaga01;
	String VelhoAdaga01Path = "images//Velho//entregaAdaga//velho-sword1.png";
	Image VelhoAdaga02;
	String VelhoAdaga02Path = "images//Velho//entregaAdaga//velho-sword2.png";
	Image VelhoAdaga03;
	String VelhoAdaga03Path = "images//Velho//entregaAdaga//velho-sword3.png";
	
	//Posição inicial do Velho
	public int x;
	public int y;
	public boolean orientacaoVelho = false, proximo = false;
	public boolean adaga = false, entregaAdaga = false;
	
	static int fontSize = 20;
	public int contador = 0;
    static Font f = new Font("Comic Sans MS", Font.BOLD, fontSize);
    public String Frase = "";
	
	public static boolean dialogV = false;
	
	//Parametrizacao animação personagem
	public int personagemDelay = 0;
	//Intervalo de tempo entre frames da animacao do personagem
	//Cada unidade multiplica o delay (TrocaPosicao = delay * unidade)
	public int TrocaPosicao = 20;


	//Parâmetros x e y para definir posição inicial
	public Velho(int x ,int y) {
		this.x = x;
		this.y = y;
		
		//Menina normal
		VelhoDireita01 = new ImageIcon(VelhoDireita01Path).getImage();
		VelhoDireita02 = new ImageIcon(VelhoDireita02Path).getImage();
		VelhoEsquerda01 = new ImageIcon(VelhoEsquerda01Path).getImage();
		VelhoEsquerda02 = new ImageIcon(VelhoEsquerda02Path).getImage();
		
		VelhoAdaga01 = new ImageIcon(VelhoAdaga01Path).getImage();
		VelhoAdaga02 = new ImageIcon(VelhoAdaga02Path).getImage();
		VelhoAdaga03 = new ImageIcon(VelhoAdaga03Path).getImage();
	}
	
	public void proximidade(Player player, Velho velho) {
		//Algoritmo de checar proximidade
		if((player.x >= velho.x - 150 && player.x <= velho.x + 150) &&
				(player.y >= velho.y - 150 && player.y <= velho.y +150)) {
			velho.proximo = true;
		}
		else {
			velho.proximo = false;	
		}
	}
	
	public void animacao(Player player, Velho velho) {
		//Animacao Velho
	    velho.personagemDelay += 1;
	    if(velho.personagemDelay > (velho.TrocaPosicao*2)) {
	    	velho.personagemDelay = 0;
	    }
	    if(player.x > velho.x) {
	    	velho.orientacaoVelho = true;
	    }
	    else {
	    	velho.orientacaoVelho = false;
	    }
	}
	
	public void colisao(Player player, Velho velho) {
		//Algoritmo de colisão com a menina.
		if (player.x >= velho.x - velho.VelhoEsquerda01.getWidth(null)/2 && 
				(player.y >= velho.y - velho.VelhoEsquerda01.getHeight(null)*0.7 && 
				player.y <= velho.y + velho.VelhoEsquerda01.getHeight(null)*0.7 ) &&
				player.x <= velho.x) {
			
			player.x = player.x - player.velMax;
		}

		else if (player.x <= velho.x + velho.VelhoEsquerda01.getWidth(null)/2 && 
				(player.y >= velho.y - velho.VelhoEsquerda01.getHeight(null)*0.7 &&
				player.y <= velho.y + velho.VelhoEsquerda01.getHeight(null)*0.7 ) &&
				player.x >= velho.x) {
			
			player.x = player.x + player.velMax;
		}

		if (player.y >= velho.y - velho.VelhoEsquerda01.getHeight(null)*0.7 - player.velMax &&
				(player.x >= velho.x - velho.VelhoEsquerda01.getWidth(null)/2 && 
				player.x <= velho.x + velho.VelhoEsquerda01.getWidth(null)/2) &&
				player.y <= velho.y) {
			player.y = player.y - player.velMax;
		}
			
		else if (player.y <= velho.y + velho.VelhoEsquerda01.getHeight(null)*0.7+ player.velMax &&
				(player.x >= velho.x - velho.VelhoEsquerda01.getWidth(null)/2 && 
				player.x <= velho.x + velho.VelhoEsquerda01.getWidth(null)/2) &&
				player.y >= velho.y) {
			player.y = player.y + player.velMax;
		}
	}
	
	public void draw(Graphics g) {
		if(entregaAdaga) {
			if (personagemDelay <= TrocaPosicao*2/5) {
				g.drawImage(VelhoAdaga01, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*4/5)) {
				g.drawImage(VelhoAdaga02, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*6/5)) {
				g.drawImage(VelhoAdaga02, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*8/5)) {
				g.drawImage(VelhoAdaga02, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*10/5)) {
				g.drawImage(VelhoAdaga03, x, y, null);
				entregaAdaga = false;
				adaga = true;
			}
		}
		else if(adaga) {
			g.drawImage(VelhoAdaga03, x, y, null);
		}
		else {
			if(orientacaoVelho) {
				if (personagemDelay <= TrocaPosicao) {
					g.drawImage(VelhoDireita01, x, y, null);
				}
				else if (personagemDelay <= (TrocaPosicao*2)) {
					g.drawImage(VelhoDireita02, x, y, null);
				}
			}
			else {
				if (personagemDelay <= TrocaPosicao) {
					g.drawImage(VelhoEsquerda01, x, y, null);
				}
				else if (personagemDelay <= (TrocaPosicao*2)) {
					g.drawImage(VelhoEsquerda02, x, y, null);
				}
				
			}
		}		
		
	}

}
