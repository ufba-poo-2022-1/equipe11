package dialogos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Interface.Intro;
import cenarios.Caminhos;
import cenarios.Menina;
import cenarios.MeninaBatalha;
import cenarios.Velho;
import fases.Cena02;


public class Caixa {
	public static int cena;
	public static int fala =0;
	//Se alternancia for 1, serão utilizados falas da menina, 2, do guerreiro.
	public static int Alternancia = 0; 
	
	//Boolean para verificar interação com a menina
	public static boolean CaixaMenina = false;
	public static int auxPassagemdeDialogo = 0;
	
		
	static int fontSize = 20;
	public static int contador = 0;
    static Font f = new Font("Comic Sans MS", Font.BOLD, fontSize);
	//Dialogos
  	public static String currentDialog = "";
  	public static String auxiliar = "";
	public static String dialogosMenina[] [] = new String[12][10];
	public static String dialogosGuerreiro[] [] = new String[12][10];

	public Caixa(int Alternancia) {
		
		Caixa.Alternancia = Alternancia;
		
		if(Alternancia == 1) {
			dialogosMenina[10][0] = "Menina \n 1";
			dialogosMenina[10][1] = "Menina \n 2"; 
			dialogosMenina[10][2] = "Menina \n 3"; 
			dialogosMenina[10][3] = "Menina \n 4"; 
			dialogosMenina[10][4] = "Menina \n 5"; 
			dialogosMenina[10][5] = "Menina \n 6"; 
			dialogosMenina[10][6] = "Menina \n 7"; 
			dialogosMenina[10][7] = "Menina \n 8"; 
			dialogosMenina[10][8] = "Menina \n 9"; 
			
		// Dialogos da cena 3
			dialogosMenina[3][0] = "Menina \n Oi, licença, sei que parece estranho, mas posso te pedir um favor?";
			dialogosMenina[3][1] = "Menina \n Estou um pouco longe de casa e me perdi...";
	     	dialogosMenina[3][2] = "Menina \n Posso ir com você por enquanto?";
			
		// Dialogos da cena 4
			dialogosMenina[4][0] = "Menina \n Moro em uma vila próxima daqui sabe, ela foi destruída recentemente e os moradores sumiram, junto com minha \nfamília.";
			dialogosMenina[4][1] = "Menina \n Não consigo lembrar de nada daquele dia, tudo é tão confuso, não sei o que fazer."; 
					
		// Teste cena batalha
			dialogosMenina[11][0] = "Menina \n 1";
			dialogosMenina[11][1] = "Menina \n 2"; 
			dialogosMenina[11][2] = "Menina \n 3"; 
			dialogosMenina[11][3] = "Menina \n 4"; 
			dialogosMenina[11][4] = "Menina \n 5"; 
			dialogosMenina[11][5] = "Menina \n 6"; 
			dialogosMenina[11][6] = "Menina \n 7"; 
			dialogosMenina[11][7] = "Menina \n 8"; 
			dialogosMenina[11][8] = "Menina \n 9"; 
		
		}

		
		if(Alternancia == 2) {
			dialogosGuerreiro[10][0] = "Guerreiro \n"; 
			dialogosGuerreiro[10][1] = "Guerreiro \n"; 
			dialogosGuerreiro[10][2] = "Velho \n"; 
			dialogosGuerreiro[10][3] = "Velho \n"; 
			dialogosGuerreiro[10][4] = "Velho "; 
			dialogosGuerreiro[10][5] = "Velho "; 
			dialogosGuerreiro[10][6] = "Velho "; 
		}
		
	}
	
	public static void DialogoM(Graphics g, Menina menina) {
		
		//Window
		Graphics2D g2 = (Graphics2D) g;
		
		//Janela de texto
		int x = 50, y = 500, width = 1250, height= Intro.SCREEN_HEIGHT/4;
		drawSubWindow(g2,x, y, width, height);
		
		//Imprimir frase letra por letra na caixa
		if((menina.proxima && auxiliar.length() < currentDialog.length()) &&
		(menina.personagemDelay <= menina.TrocaPosicao*2)) {
			auxiliar = auxiliar + currentDialog.charAt(contador);
			contador++;			
			Menina.dialogM = true;
		}
		
		g.setColor(Color.white);
		g.setFont(f);
		
		for(String line : currentDialog.split("\n")) {
			if(cena >= 0  && dialogosMenina[cena][fala] != null) {
				g.drawString(line, x+30, y+35);
				y+= 45;
				x+= 10;
		
				currentDialog = dialogosMenina[cena][fala];
			}
			
			else {
				contador = 0;
				currentDialog = "";
				auxiliar = "";
				fala = 0;
				auxPassagemdeDialogo = 0;
				CaixaMenina = false;
			}
		}
		
	}
	
	public static void DialogoSemProximidade(Graphics g, MeninaBatalha menina) {
		
		//Window
		Graphics2D g2 = (Graphics2D) g;
		
		//Janela de texto
		int x = 50, y = 500, width = 1250, height= Intro.SCREEN_HEIGHT/4;
		drawSubWindow(g2,x, y, width, height);
		
		//Imprimir frase letra por letra na caixa
		if((auxiliar.length() < currentDialog.length()) &&
		(menina.personagemDelay <= menina.TrocaPosicao*2)) {
			auxiliar = auxiliar + currentDialog.charAt(contador);
			contador++;			
			Menina.dialogM = true;
		}
		
		g.setColor(Color.white);
		g.setFont(f);
		
		for(String line : currentDialog.split("\n")) {
			if(cena >= 0  && dialogosMenina[cena][fala] != null) {
				g.drawString(line, x+30, y+35);
				y+= 45;
				x+= 10;
		
				currentDialog = dialogosMenina[cena][fala];
			}
			
			else {
				contador = 0;
				currentDialog = "";
				auxiliar = "";
				fala = 0;
				auxPassagemdeDialogo = 0;
				CaixaMenina = false;
			}
		}
		
	}
	
	public static void DialogoV(Graphics g, Velho velho) {
		
		//Window
		Graphics2D g2 = (Graphics2D) g;
		
		//Janela de texto
		int x = 50, y = 500, width = 1250, height= Intro.SCREEN_HEIGHT/4;
		drawSubWindow(g2,x, y, width, height);
		
		//Imprimir frase letra por letra na caixa
		if((velho.proximo && auxiliar.length() < currentDialog.length()) &&
			(velho.personagemDelay <= velho.TrocaPosicao*2)) {
			auxiliar = auxiliar + currentDialog.charAt(contador);
			contador++;			
			Velho.dialogV = true;
		}
		
		g.setColor(Color.white);
		g.setFont(f);
		
		for(String line : currentDialog.split("\n")) {
			if(cena >= 0  && dialogosGuerreiro[cena][fala] != null) {
				g.drawString(line, x+30, y+35);
				y+= 45;
				x+= 10;
		
				currentDialog = dialogosGuerreiro[cena][fala];
			}
			else {
				contador = 0;
				currentDialog = "";
				auxiliar = "";
				fala = 0;
				auxPassagemdeDialogo = 0;
				CaixaMenina = false;
			}
		}
		
	}
	
	
	public static void drawSubWindow(Graphics g, int x, int y, int width, int height) {
		Graphics2D g2 = (Graphics2D) g;
		Color c = new Color(0,0,0);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 25, 25);
		
		c = new Color(255,255,255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+5, y+5, width-10, height-10, 15, 15);
		
	}
}
	
	
	

