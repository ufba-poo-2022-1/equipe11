package Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Intro extends JPanel{
	//Resolução da tela
	final static int SCREEN_WIDTH = 1366;
	final static int SCREEN_HEIGHT = 768;
	
	//Inicializar audio
	public static AudioInputStream stream;
	public static Clip clip;
	String audioFileName = "sounds//UndetaleCompact.wav";
	
	//Delay para fechar introdução
	static int wait = 2000;
	
	//Declaração imagem de fundo
	Image Background;
	String BackgroundPath = "images//brasao_ufba.png";
	Image Background2;
	String BackgroundPath2 = "images//candybox2.png";
	
	Intro(){
		//Panel
		playAudio();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
				
		Background = new ImageIcon(BackgroundPath).getImage();
		Background2 = new ImageIcon(BackgroundPath2).getImage();
	}
	
	//Pintura do quadro
	@Override
	public void paint(Graphics g) {
		Graphics2D intro2D = (Graphics2D) g;
		super.paint(intro2D);
		intro2D.drawImage(Background, 0, 0, null);
	}	
	
	//Leitura de arquivo .wav
	public void playAudio(){
		try {
		File audioPath = new File(audioFileName);
		stream = AudioSystem.getAudioInputStream(audioPath);
		clip = AudioSystem.getClip();
		clip.open(stream);
		clip.start();
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
