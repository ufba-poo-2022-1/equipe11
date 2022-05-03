package Interface;

//Criação de janelas
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {
	//Criação de uma janela para o menu
	private static JFrame frame;

	//Criação de botão
	private static void setupStartButton(Container pane) {
		//Criar botão
		JButton button = new JButton();
		
		//Dimensões do botão (dimensões no parâmetro)
		button.setPreferredSize(new Dimension(GameManager.SCREEN_WIDTH, GameManager.SCREEN_HEIGHT/5));
		
		//Selecionar imagem para o botão
		button.setIcon(new ImageIcon("images//start.png"));
		
		//Definir o que o botão realiza ao ser pressionado
		button.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				//Método para fechar a janela
				//frame.dispose();
				
				//Aqui iniciar o jogo, abrindo outra janela do jogo
				JOptionPane.showMessageDialog(null, "BOTAO BOTAO");
				
				System.out.println("Botao sendo pressionado");
			}
		});
		
		//Modelo de layout de borda, adicionando botão ao topo
		pane.add(button, BorderLayout.PAGE_START); //page_start = inicio pagina
	}
	
	//Método para adicionar label no menu
	private static void setupCenterImage(Container pane) {
		JLabel label = new JLabel();
		
		label.setPreferredSize(new Dimension(GameManager.SCREEN_WIDTH/3, GameManager.SCREEN_HEIGHT/2));
		label.setIcon(new ImageIcon("images//about.png"));
		pane.add(label, BorderLayout.CENTER);
	}
	
	//Adicionar componentes a janela
	public static void addComponents(Container pane) {
		pane.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT); 
		setupStartButton(pane);
		setupCenterImage(pane);
	}
	
	//Criar janela
	private static void createFrame() {
		frame = new JFrame("Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponents(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
	
	//Construtor
	public Menu() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			//override run
			public void run() {
				createFrame();
			}
		});
	}
}