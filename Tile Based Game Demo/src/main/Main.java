package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		//Chase
		//Doin ur mom Alex was here https://www.youtube.com/channel/UCqvIjHbQ5CqxfJt4RO32Vxg
		//no i'm doing YOUR mom - Adilson
		//GUI setup
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Tile Based Game Demo");
		
		//add the panel to the frame
		GamePanel panel = new GamePanel();
		window.add(panel);
		window.pack();
		
		window.setLocationRelativeTo(null); //center the window 
		window.setVisible(true);
		
		panel.startGameThread();
		
	} //end of main method
	
} //end of Main class
