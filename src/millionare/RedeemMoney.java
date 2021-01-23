package millionare;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RedeemMoney extends JFrame {
	JLabel Home,Newgame;
	
	public RedeemMoney() {
		
		setTitle("WHO WANTS TO BE A MILLIONAIRE");
		Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png"); 
		setIconImage(Titlebaricon);  
		setSize(1200,720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		JLabel bg =new JLabel(new ImageIcon("images/background2.jpg"));
		add(bg); 
		
		JLabel logo= new JLabel();
		logo.setIcon(new ImageIcon("images/logo3.gif"));
		logo.setBounds(500,0,200,200);
		bg.add(logo);
		
		
		JLabel joke = new JLabel();
		joke.setIcon(new ImageIcon("images/sunilgrovermeme.gif"));
		joke.setBounds(330,260,600,338);
		bg.add(joke);
		
		Home = new JLabel("");
		Home.setBounds(10,10,200,101);
		Home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bg.add(Home);
		Home.setIcon(new ImageIcon("images/Home1.png"));
		Home.setHorizontalAlignment(JLabel.CENTER);
		mouseaction(Home,1);
		

		Newgame = new JLabel("");
		Newgame.setBounds(970,15,200,101);
		Newgame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Newgame.setIcon(new ImageIcon("images/Newgame1.png"));
		bg.add(Newgame);
		Newgame.setHorizontalAlignment(JLabel.CENTER);
	    mouseaction(Newgame,2);
	    audio("music/meme.wav");
	    
	}
	
	void mouseaction(JLabel op,int n) {
		
		op.addMouseListener(new MouseAdapter() {

						public void mouseEntered(MouseEvent e) {					    
							    if(n==1) {
							    	audio("music/Hover3.wav");
									op.setIcon(new ImageIcon("images/Home2.png"));
									}
								    
							    else if(n==2) {
							    	audio("music/Hover3.wav");
							    	op.setIcon(new ImageIcon("images/Newgame2.png"));
							    	}
							 	
							    }
						
		

						public void mouseExited(MouseEvent e) {  
							    if(n==1) {
								  op.setIcon(new ImageIcon("images/Home1.png"));}
								    
							    else if(n==2) {
							    	op.setIcon(new ImageIcon("images/Newgame1.png"));}
							    
						}

						public void mouseClicked(MouseEvent e) {
							if(n==1) {
								setVisible(false);
								Firstpage obj=new Firstpage();
						    	Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png");  
						        obj.setIconImage(Titlebaricon); 
							}
							
						else if(n==2){
							    setVisible(false);
								Quizselect obj=new Quizselect();
								Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png");  
						        obj.setIconImage(Titlebaricon);  
								obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								obj.setResizable(false);
								obj.setSize(1200,720);
								obj.setVisible(true);
							}
						
							
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