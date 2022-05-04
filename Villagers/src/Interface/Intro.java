package Interface;

//AUDIO
import javax.sound.sampled.AudioSystem;
import java.io.File;

//Criação de janelas
import javax.swing.*;
import java.awt.*;

public class Intro extends JPanel implements Runnable{
	JFrame window = new JFrame();
	private String imagePath = "images//brasao_ufba.png";
	private int wait = 1500;
	private String audioFileName = "sounds//musicafundo.wav";
	
	public Intro(){
		//Tocar audio
		playAudio();
		this.setPreferredSize(new Dimension(GameManager.SCREEN_WIDTH, GameManager.SCREEN_HEIGHT));
		window.setBackground(Color.black);
		//Criar janela
		window.add(this);
		//Fechar processos ao fechar janela
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		
		//FullScreen
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setVisible(true);
	}
	
	public void playAudio(){
		try {
		File audioPath = new File(audioFileName);
		//JAVA'S AUDIO INPUT STREAM
		GameManager.stream = AudioSystem.getAudioInputStream(audioPath);
		//REFERENCE TO AUDIO CLIP CLASS
		GameManager.clip = AudioSystem.getClip();
		//OPEN THE STREAM USING THE CLIP CLASS
		GameManager.clip.open(GameManager.stream);
		//MUSIC STARTS
		GameManager.clip.start();
		} //END OF TRY BLOCK
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(new ImageIcon(imagePath).getImage() ,0 ,0 , null);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(wait);
			window.dispose();		
			//MENU CLASS
			Menu menu = new Menu();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}