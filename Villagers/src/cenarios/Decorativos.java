package cenarios;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Decorativos {
	
	ArrayList<Image> Decorativos = new ArrayList<Image>();
	/*
	 *Lista de decorativos:
	 	0 - Cogumelos
	 	1 - Placa de perigo
	 	2 - Arbusto
	 	3 - Arbusto com frutas
	 	4 - Arbusto em chamas
	 	5 - Arvore com frutos
	 	6 - Arvore 
	 	7 - Arvore seca
	 	8 - Arvore seca em chamas
	 	9 - Casa 01
	 	10 - Casa 02
	 	11 - Casa 03
	 	12 - Casa 04
	 	13 - Casa 05
	 	14 - Mercado Guerreiro
	 	15 - Transparente para colis�o
	 */

	
	//Path das imagens dos caminhos
	Image Decorativos00;
	String Decorativos00Path = "images//Decorativos//mushroom.png";
	Image Decorativos01;
	String Decorativos01Path = "images//Decorativos//plaquinha.png";
	
	Image Decorativos02;
	String Decorativos02Path = "images//Decorativos//arbusto-01.png";
	Image Decorativos03;
	String Decorativos03Path = "images//Decorativos//arbusto-02.png";
	Image Decorativos04;
	String Decorativos04Path = "images//Decorativos//arbusto-03.png";
	
	Image Decorativos05;
	String Decorativos05Path = "images//Decorativos//arvore-01.png";
	Image Decorativos06;
	String Decorativos06Path = "images//Decorativos//arvore-02.png";
	Image Decorativos07;
	String Decorativos07Path = "images//Decorativos//arvore-03.png";
	Image Decorativos08;
	String Decorativos08Path = "images//Decorativos//arvore-04.png";
	
	Image Decorativos09;
	String Decorativos09Path = "images//Decorativos//casa-01.png";
	Image Decorativos10;
	String Decorativos10Path = "images//Decorativos//casa-02.png";
	Image Decorativos11;
	String Decorativos11Path = "images//Decorativos//casa-03.png";
	Image Decorativos12;
	String Decorativos12Path = "images//Decorativos//casa-04.png";
	Image Decorativos13;
	String Decorativos13Path = "images//Decorativos//casa-05.png";
	
	Image Decorativos14;
	String Decorativos14Path = "images//Decorativos//mercado.png";
	
	Image Decorativos15;
	String Decorativos15Path = "images//Decorativos//transparente.png";

	int numeroDecorativo, x, y;
	
	public Decorativos(int numeroDecorativo, int x, int y) {
		this.numeroDecorativo = numeroDecorativo;
		this.x = x;
		this.y = y;
		
		Decorativos00 = new ImageIcon(Decorativos00Path).getImage();
		Decorativos01 = new ImageIcon(Decorativos01Path).getImage();
		Decorativos02 = new ImageIcon(Decorativos02Path).getImage();
		Decorativos03 = new ImageIcon(Decorativos03Path).getImage();
		Decorativos04 = new ImageIcon(Decorativos04Path).getImage();
		Decorativos05 = new ImageIcon(Decorativos05Path).getImage();
		Decorativos06 = new ImageIcon(Decorativos06Path).getImage();
		Decorativos07 = new ImageIcon(Decorativos07Path).getImage();
		Decorativos08 = new ImageIcon(Decorativos08Path).getImage();
		Decorativos09 = new ImageIcon(Decorativos09Path).getImage();
		Decorativos10 = new ImageIcon(Decorativos10Path).getImage();
		Decorativos11 = new ImageIcon(Decorativos11Path).getImage();
		Decorativos12 = new ImageIcon(Decorativos12Path).getImage();
		Decorativos13 = new ImageIcon(Decorativos13Path).getImage();
		Decorativos14 = new ImageIcon(Decorativos14Path).getImage();
		Decorativos15 = new ImageIcon(Decorativos15Path).getImage();
		
		Decorativos.add(Decorativos00);
		Decorativos.add(Decorativos01);
		Decorativos.add(Decorativos02);
		Decorativos.add(Decorativos03);
		Decorativos.add(Decorativos04);
		Decorativos.add(Decorativos05);
		Decorativos.add(Decorativos06);
		Decorativos.add(Decorativos07);
		Decorativos.add(Decorativos08);
		Decorativos.add(Decorativos09);
		Decorativos.add(Decorativos10);
		Decorativos.add(Decorativos11);
		Decorativos.add(Decorativos12);
		Decorativos.add(Decorativos13);
		Decorativos.add(Decorativos14);
		Decorativos.add(Decorativos15);
	}		
	public void colisaoD(Player player, Decorativos decorativos, int numeroDecorativo) {
		//Algoritmo de colisão com a objetos.
		if (player.x >= decorativos.x - decorativos.Decorativos.get(numeroDecorativo).getWidth(null)/2 && 
				(player.y >= decorativos.y - decorativos.Decorativos.get(numeroDecorativo).getHeight(null)*0.7 && 
				player.y <= decorativos.y + decorativos.Decorativos.get(numeroDecorativo).getHeight(null)*0.7 ) &&
				player.x <= decorativos.x) {
			
			player.x = player.x - player.velMax;
		}

		else if (player.x <= decorativos.x + decorativos.Decorativos.get(numeroDecorativo).getWidth(null)/2 && 
				(player.y >= decorativos.y - decorativos.Decorativos.get(numeroDecorativo).getHeight(null)*0.7 &&
				player.y <= decorativos.y + decorativos.Decorativos.get(numeroDecorativo).getHeight(null)*0.7 ) &&
				player.x >= decorativos.x) {
			
			player.x = player.x + player.velMax;
		}

		if (player.y >= decorativos.y - decorativos.Decorativos.get(numeroDecorativo).getHeight(null)*0.7 - player.velMax &&
				(player.x >= decorativos.x - decorativos.Decorativos.get(numeroDecorativo).getWidth(null)/2 && 
				player.x <= decorativos.x + decorativos.Decorativos.get(numeroDecorativo).getWidth(null)/2) &&
				player.y <= decorativos.y) {
			player.y = player.y - player.velMax;
		}
			
		else if (player.y <= decorativos.y + decorativos.Decorativos.get(numeroDecorativo).getHeight(null)*0.7+ player.velMax &&
				(player.x >= decorativos.x - decorativos.Decorativos.get(numeroDecorativo).getWidth(null)/2 && 
				player.x <= decorativos.x + decorativos.Decorativos.get(numeroDecorativo).getWidth(null)/2) &&
				player.y >= decorativos.y) {
			player.y = player.y + player.velMax;
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(Decorativos.get(numeroDecorativo), x, y, null);
		
	}
}
