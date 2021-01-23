package millionare;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
public class aboutgame extends JFrame {
public aboutgame() {
	setTitle("WHO WANTS TO BE A MILLIONAIRE");
	setLayout(new BorderLayout()); 
    JLabel bg=new JLabel(new ImageIcon("images/background_aboutgame.png"));
    add(bg);
	 Backbutton(bg);	
}
void Backbutton(JLabel bg){
	JLabel back = new JLabel();
	back.setBounds(500,550,200,101);
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
