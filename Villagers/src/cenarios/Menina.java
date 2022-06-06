package cenarios;

import java.awt.Color;
import java.awt.Font;
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
	public static int x;
	public static int y;
	public boolean orientacaoMenina = false;
	public static boolean proxima = false;
	
	static int fontSize = 20;
	public static int contador = 0;
    static Font f = new Font("Comic Sans MS", Font.BOLD, fontSize);
    public static String Frase = "";
    static String Letras = "Pressione [E]";
    
    public static boolean dialogM = false;
	
	//Parametrizacao animação personagem
	public static int personagemDelay = 0;
	//Intervalo de tempo entre frames da animacao do personagem
	//Cada unidade multiplica o delay (TrocaPosicao = delay * unidade)
	public static int TrocaPosicao = 15;
	
	//Estado 1 para menina normal, 2 para endiabrada, maluca, surtada
	int estado;
	
	
	//Parâmetros x e y para definir posição inicial
	public Menina(int estado, int x ,int y) {
		this.estado = estado;
		Menina.x = x;
		Menina.y = y;
		
		//Menina normal
		MeninaDireita01 = new ImageIcon(MeninaDireita01Path).getImage();
		MeninaDireita02 = new ImageIcon(MeninaDireita02Path).getImage();
		MeninaEsquerda01 = new ImageIcon(MeninaEsquerda01Path).getImage();
		MeninaEsquerda02 = new ImageIcon(MeninaEsquerda02Path).getImage();
	}
		
	
	public void colisao(Player player, Menina menina) {
		//Algoritmo de colisão com a menina.
		if (player.x >= Menina.x - menina.MeninaEsquerda01.getWidth(null)/2 && 
				(player.y >= Menina.y - menina.MeninaEsquerda01.getHeight(null)*0.7 && 
				player.y <= Menina.y + menina.MeninaEsquerda01.getHeight(null)*0.7 ) &&
				player.x <= Menina.x) {
			
			player.x = player.x - player.velMax;
		}

		else if (player.x <= Menina.x + menina.MeninaEsquerda01.getWidth(null)/2 && 
				(player.y >= Menina.y - menina.MeninaEsquerda01.getHeight(null)*0.7 &&
				player.y <= Menina.y + menina.MeninaEsquerda01.getHeight(null)*0.7 ) &&
				player.x >= Menina.x) {
			 
			player.x = player.x + player.velMax;
		}

		if (player.y >= Menina.y - menina.MeninaEsquerda01.getHeight(null)*0.7 - player.velMax &&
				(player.x >= Menina.x - menina.MeninaEsquerda01.getWidth(null)/2 && 
				player.x <= Menina.x + menina.MeninaEsquerda01.getWidth(null)/2) &&
				player.y <= Menina.y) {
			player.y = player.y - player.velMax;
		}
			
		else if (player.y <= Menina.y + menina.MeninaEsquerda01.getHeight(null)*0.7+ player.velMax &&
				(player.x >= Menina.x - menina.MeninaEsquerda01.getWidth(null)/2 && 
				player.x <= Menina.x + menina.MeninaEsquerda01.getWidth(null)/2) &&
				player.y >= Menina.y) {
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
   public static void Suporte(Graphics g, int x, int y) {
	 //Imprimir frase letra por letra
	 		if((proxima && Frase.length() < Letras.length()) &&
	 				(personagemDelay <= TrocaPosicao*2)) {
	 			Frase = Frase + Letras.charAt(contador);
	 			contador++;			
	 			dialogM = true;
	 		}
	 		g.setColor(Color.white);
			g.setFont(f);
			g.drawString(Frase, x, y);
   }

}
	
