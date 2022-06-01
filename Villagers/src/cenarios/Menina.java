package cenarios;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Menina {
	
	Image MeninaDireita01;
	String MeninaDireita01Path = "images//Menina//michica_parada_2.png";
	Image MeninaDireita02;
	String MeninaDireita02Path = "images//Menina//michica_parada_3.png";
	
	public Image MeninaEsquerda01;
	String MeninaEsquerda01Path = "images//Menina//michica_parada_left2.png";
	Image MeninaEsquerda02;
	String MeninaEsquerda02Path = "images//Menina//michica_parada_left3.png";
	
	//Posição inicial da menina
	public int x;
	public int y;
	public boolean orientacaoMenina = false, proxima = false;
	
	//Parametrizacao animação personagem
	public int personagemDelay = 0;
	//Intervalo de tempo entre frames da animacao do personagem
	//Cada unidade multiplica o delay (TrocaPosicao = delay * unidade)
	public int TrocaPosicao = 15;
	
	int estado;
	//Estado 1 para menina normal, 2 para endiabrada, maluca, surtada
	//Parâmetros x e y para definir posição inicial
	public Menina(int estado, int x ,int y) {
		this.estado = estado;
		this.x = x;
		this.y = y;
		
		//Menina normal
		MeninaDireita01 = new ImageIcon(MeninaDireita01Path).getImage();
		MeninaDireita02 = new ImageIcon(MeninaDireita02Path).getImage();
		MeninaEsquerda01 = new ImageIcon(MeninaEsquerda01Path).getImage();
		MeninaEsquerda02 = new ImageIcon(MeninaEsquerda02Path).getImage();
	}
	
	public void colisao(Player player, Menina menina) {
		//Algoritmo de colisão com a menina.
		if (player.x >= menina.x - menina.MeninaEsquerda01.getWidth(null)/2 && 
				(player.y >= menina.y - menina.MeninaEsquerda01.getHeight(null)*0.7 && 
				player.y <= menina.y + menina.MeninaEsquerda01.getHeight(null)*0.7 ) &&
				player.x <= menina.x) {
			
			player.x = player.x - player.velMax;
		}

		else if (player.x <= menina.x + menina.MeninaEsquerda01.getWidth(null)/2 && 
				(player.y >= menina.y - menina.MeninaEsquerda01.getHeight(null)*0.7 &&
				player.y <= menina.y + menina.MeninaEsquerda01.getHeight(null)*0.7 ) &&
				player.x >= menina.x) {
			
			player.x = player.x + player.velMax;
		}

		if (player.y >= menina.y - menina.MeninaEsquerda01.getHeight(null)*0.7 - player.velMax &&
				(player.x >= menina.x - menina.MeninaEsquerda01.getWidth(null)/2 && 
				player.x <= menina.x + menina.MeninaEsquerda01.getWidth(null)/2) &&
				player.y <= menina.y) {
			player.y = player.y - player.velMax;
		}
			
		else if (player.y <= menina.y + menina.MeninaEsquerda01.getHeight(null)*0.7+ player.velMax &&
				(player.x >= menina.x - menina.MeninaEsquerda01.getWidth(null)/2 && 
				player.x <= menina.x + menina.MeninaEsquerda01.getWidth(null)/2) &&
				player.y >= menina.y) {
			player.y = player.y + player.velMax;
		}
	}
	
	public void draw(Graphics g) {
		if(orientacaoMenina) {
			if (personagemDelay <= TrocaPosicao) {
				g.drawImage(MeninaDireita01, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*2)) {
				g.drawImage(MeninaDireita02, x, y, null);
			}
		}
		else {
			if (personagemDelay <= TrocaPosicao) {
				g.drawImage(MeninaEsquerda01, x, y, null);
			}
			else if (personagemDelay <= (TrocaPosicao*2)) {
				g.drawImage(MeninaEsquerda02, x, y, null);
			}
			
		}
		
	}

}
