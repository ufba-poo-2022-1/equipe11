package cenários;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Decorativos {
	
	ArrayList<Image> Decorativos = new ArrayList<Image>();

	
	//Path das imagens dos caminhos
	Image Decorativos00;
	String Decorativos00Path = "images//Decorativos//mushroom.png";
	Image Decorativos01;
	String Decorativos01Path = "images//Decorativos//plaquinha.png";
	
int numeroDecorativo, x, y;
	
	public Decorativos(int numeroDecorativo, int x, int y) {
		this.numeroDecorativo = numeroDecorativo;
		this.x = x;
		this.y = y;
		
		Decorativos00 = new ImageIcon(Decorativos00Path).getImage();
		Decorativos01 = new ImageIcon(Decorativos01Path).getImage();
		
		Decorativos.add(Decorativos00);
		Decorativos.add(Decorativos01);
	}		
	
	public void draw(Graphics g) {
		g.drawImage(Decorativos.get(numeroDecorativo), x, y, null);
		
	}
}
