package theVillagersJourney;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JPanel{
	
	JFrame window = new JFrame();
	Menu(){
		window.add(this);
		
		window.setSize(1154,794);
		window.setVisible(true);
	}
	
	public void paint(Graphics g) {
		ImageIcon background = new ImageIcon("images//candybox2.png");
		
		g.drawImage(background.getImage(),0,0,null);
	}
}
