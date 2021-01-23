package millionare;

import java.io.File;
import javax.sound.sampled.*;
import java.awt.*;
import javax.swing.*;

public class Millionaire {
    	
	
static void audio() {
     try {
          File file = new File("images/music1.wav");
          Clip clip = AudioSystem.getClip();
          clip.open(AudioSystem.getAudioInputStream(file));
          clip.start();
          } 
     catch (Exception e) {
                System.err.println("Put the music1.wav file in the appropriate folder");
            }
        }

 
public static void main(String[] args){
	
        String arg = "images/gif1.gif";
        JFrame f = new JFrame();
        Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png");  
        f.setIconImage(Titlebaricon);  
        JPanel p = new JPanel();
        JLabel l = new JLabel();
        ImageIcon icon = new ImageIcon(arg);    
        f.setSize(1200, 720);
        f.setVisible(true);
        l.setIcon(icon);
        p.add(l);
        f.getContentPane().add(p);
        f.setTitle("WHO WANTS TO BE A MILLIONAIRE");
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       audio();
        Firstpage obj=new Firstpage(f,p);
       
	}
    
}    