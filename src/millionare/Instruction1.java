package millionare;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Instruction1 extends JFrame{
	JLabel instructions;
	JTextArea  instructionsfff;
	public Instruction1() {
		
		setTitle("WHO WANTS TO BE A MILLIONAIRE");
		setLayout(new BorderLayout()); 
        JLabel bg=new JLabel(new ImageIcon("images/background2.jpg"));
        add(bg);
        
        JLabel logo;
		logo = new JLabel("");
		logo.setBounds(496,40,200,200);
		bg.add(logo);
		logo.setIcon(new ImageIcon("images/logo3.gif"));
        
        instructions = new JLabel("Instructions For Fastest Finger First");
        instructions.setBounds(0, 10, 1200, 40);
        instructions.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setForeground(Color.YELLOW);
		bg.add(instructions);
		
		//Reading the instructions from instructions file(instructionsfastestfingerfirst.txt)
		String instruction = "";
		File f = new File("images/instructionsfastestfingerfirst.txt");
		try{
			Scanner reader = new Scanner(f);
	        while(reader.hasNextLine())
	        {
	            instruction += reader.nextLine()+"\n";
	            // if there is a next line,add new line character because it was skipped.
	        }
	        reader.close();
		}
		catch (IOException e)
		{
		System.out.println("Problem reading from the instructions file");	
		}
		
		instructionsfff = new JTextArea(instruction);
		instructionsfff.setBounds(130,240,1080,370);
		instructionsfff.setFont(new Font("Roboto", Font.BOLD, 18));
		instructionsfff.setForeground(Color.WHITE);
		instructionsfff.setOpaque(false);
		instructionsfff.setEditable(false);
		bg.add(instructionsfff);
        
		
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
		    	Firstpage obj=new Firstpage();
		    	Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png");  
		        obj.setIconImage(Titlebaricon);  
				
		    }     
		            
		});
	}
	
	public static void audio(String audio_path) {
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
