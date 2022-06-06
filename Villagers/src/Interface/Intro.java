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
	public final static int SCREEN_WIDTH = 1366;
	public final static int SCREEN_HEIGHT = 768;
	
	//Inicializar audio
	public static AudioInputStream stream;
	public static Clip clip;
	String audioFileName = "sounds//Undetale--Compact.wav";
	
	//Delay para fechar introdução
	static int wait = 1500;
	
	Intro(){
		//Panel
		playAudio();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setLayout(null);

		
		//Configurações botão jogar
		JButton botaoMenu = new JButton("");	
		botaoMenu.setIcon(new ImageIcon("images//introducao_black.png"));
		botaoMenu.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);		
		botaoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.cl.show(Janela.panelBase, "menu");	
			}
		});
		this.add(botaoMenu);
	}
	
	//Pintura do quadro
	@Override
	public void paint(Graphics g) {
		Graphics2D intro2D = (Graphics2D) g;
		super.paint(intro2D);
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
