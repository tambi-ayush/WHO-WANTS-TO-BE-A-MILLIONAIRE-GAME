package millionare;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Instruction2 extends JFrame{
	JLabel instructions;
	JTextArea  instructionsgame;
	public Instruction2() {
		
		setTitle("WHO WANTS TO BE A MILLIONAIRE");
		setLayout(new BorderLayout()); 
        JLabel bg=new JLabel(new ImageIcon("images/background2.jpg"));
        add(bg);
        
        JLabel logo;
		logo = new JLabel("");
		logo.setBounds(496,40,200,200);
		bg.add(logo);
		logo.setIcon(new ImageIcon("images/logo3.gif"));
        
        instructions = new JLabel("Instructions For the Game");
        instructions.setBounds(0, 10, 1200, 40);
        instructions.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setForeground(Color.YELLOW);
		bg.add(instructions);
		
		//Reading the instructions from game instructions file(instructionsGame.txt)
				String instructiongame = "";
				File f = new File("images/instructionsGame.txt");
				try{
					Scanner reader = new Scanner(f);
			        while(reader.hasNextLine())
			        {
			            instructiongame += reader.nextLine()+"\n";
			            // if there is a next line,add new line character because it was skipped.
			        }
			        reader.close();
				}
				catch (IOException e)
				{
				System.out.println("Problem reading from the instructions file");	
				}
				
				instructionsgame = new JTextArea(instructiongame);
				instructionsgame.setBounds(180,240,1080,370);
				instructionsgame.setFont(new Font("Roboto", Font.BOLD, 18));
				instructionsgame.setForeground(Color.WHITE);
				instructionsgame.setOpaque(false);
				instructionsgame.setEditable(false);
				bg.add(instructionsgame);
        
        Backbutton(bg);	
	}
	void Backbutton(JLabel bg){
		JLabel back = new JLabel();
		back.setBounds(500,600,200,101);
	    back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bg.add(back);
		back.setIcon(new ImageIcon("images/back1.png"));
		back.addMouseListener(new MouseAdapter() {
		    
			public void mouseEntered(MouseEvent e) {
				audio("music/Hover3.wav");
				back.setIcon(new ImageIcon("images/back2.png"));   	
		    }

		    public void mouseExited(MouseEvent e) {
		    	
		    	back.setIcon(new ImageIcon("images/back1.png"));
		    	
		    } 
			
		    public void mouseClicked(MouseEvent e) {
		    	setVisible(false);
				Quizselect obj1=new Quizselect();
				obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png");  
		        obj1.setIconImage(Titlebaricon);  
				obj1.setResizable(false);
				obj1.setSize(1200,720);
				obj1.setVisible(true);
				
		    }     
		            
		});
	}
	
void audio(String audio_path) {
	    try {
	         File file = new File(audio_path);
	         Clip clip = AudioSystem.getClip();
	         clip.open(AudioSystem.getAudioInputStream(file));
	         clip.start();
	         } 
	    catch (Exception e) {
	               System.err.println("Put the music1.wav file in the appropriate folder");
	           }
	       }
}
