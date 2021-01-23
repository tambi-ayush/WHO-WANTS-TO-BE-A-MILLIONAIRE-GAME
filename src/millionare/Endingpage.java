package millionare;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.*;
import java.util.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Endingpage extends JFrame {
	String[] Price = {"1,000,000 /-","500,000 /-","250,000 /-","125,000 /-","64,000 /-","32,000 /-","16,000 /-","8,000 /-","4,000 /-","2,000 /-","1,000 /-","500 /-","300 /-","200 /-","100 /-"};
	String[] Pricetxt = {"One Million Dollar only","Half Million Dollar only","Two Fifty Thousand Dollar only","One Twenty Five Thousand Dollar only","Sixty Four Thousand Dollar only","Thirty Two Thousand Dollar only","Sixteen Thousand Dollar only","Eight Thousand Dollar only","Four Thousand Dollar only","Two Thousand Dollar only","One Thousand Dollar only","Five Hundred Dollar only","Three Hundred Dollar only","Two Hundred Dollar only","Hundred Dollar only"};
	String pricewon=new String();
	String pricewontxt=new String();
	JLabel Home,Newgame;
	String winner = Firstpage.playername;
public Endingpage(int n, int i) {
	
	
	setTitle("WHO WANTS TO BE A MILLIONAIRE");
	Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png"); 
	setIconImage(Titlebaricon);  
	setLayout(new BorderLayout());
	JLabel bg;
    bg=new JLabel(new ImageIcon("images/background2.jpg"));
    add(bg);
    
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
    
  //----------------------------------------------------------------------------------------
  	//Calculate Winning Amount
  		if(i==1){
  			
  			if(n==0){
  				pricewon="0 /-";
  				pricewontxt= "Zero Dollar only (Perform better next time)";
  			}
  			else if(n==1){
  				pricewon ="1,000 /-";
  				pricewontxt= "One Thousand Dollar only";
  			}
  			else if(n==2){
  				pricewon="32,000 /-";
  				pricewontxt= "Thirty Two Thousand Dollar only";
  			}
  			else if(n==3){
  				pricewon="1,000,000 /-";
  				pricewontxt= "1 Million Dollar only (You are a Champion)";
  			}
  			
  		}
  		
  		if(i==2){
  			if(n==14) {
  				pricewon="0 /-";
  			    pricewontxt= "Zero Dollar only (Perform better next time)";
  			}
  			else{
  				pricewon= Price[n+1];
  				pricewontxt= Pricetxt[n+1];
  			}
  		}		
  	
  	//----------------------------------------------------------------------------------------
  

	JLabel congratstxt = new JLabel();
	congratstxt.setIcon(new ImageIcon("images/Congratulation.png"));
	congratstxt.setBounds(200,200,850,180);
	bg.add(congratstxt);
	
	JLabel logo= new JLabel();
	logo.setIcon(new ImageIcon("images/logo3.gif"));
	logo.setBounds(500,0,200,200);
	bg.add(logo);
	
	winner=winner.toUpperCase();
	JLabel name= new JLabel(winner);
	name.setBounds(290,432,350,20);
	name.setForeground(Color.BLACK);
	name.setFont(new Font("Roboto", Font.BOLD, 17));
	bg.add(name);
	
	 JLabel amountwon= new JLabel(pricewon);
	 amountwon.setBounds(615,440,150,30);
	 amountwon.setForeground(Color.BLACK);
	 amountwon.setFont(new Font("Roboto", Font.BOLD, 25));
	 bg.add( amountwon);
	
	JLabel amountinwords= new JLabel(pricewontxt);
	amountinwords.setBounds(220,485,580,40);
	amountinwords.setForeground(Color.BLACK);
	amountinwords.setFont(new Font("Roboto", Font.BOLD, 25));
	bg.add(amountinwords);
	
	JLabel img = new JLabel();
	img.setIcon(new ImageIcon("images/winningcheque.png"));
	img.setBounds(190,360,600,280);
	bg.add(img);
	
	audio1("music/crowdapplause.wav");
	
	JLabel Redeem = new JLabel();
	Redeem.setIcon(new ImageIcon("images/Redeemcash.png"));
	Redeem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	Redeem.setBounds(860,400,300,220);
	bg.add(Redeem);
	Redeem.addMouseListener(new MouseAdapter() {
		
		public void mouseEntered(MouseEvent e) {
			audio("music/Hover3.wav");
			Redeem.setIcon(new ImageIcon("images/Redeemcash1.png"));
		}

		public void mouseExited(MouseEvent e) {
			Redeem.setIcon(new ImageIcon("images/Redeemcash.png"));
		}
		public void mouseClicked(MouseEvent e) {
			clip1.stop();
			setVisible(false);
			RedeemMoney obj = new RedeemMoney();
			
		}
	});
	
}


void mouseaction(JLabel op,int n) {
	
	op.addMouseListener(new MouseAdapter() {

					public void mouseEntered(MouseEvent e) {					    
						    if(n==1) {
						    	audio("music/Hover3.wav");
								op.setIcon(new ImageIcon("images/Home2.png"));}
							    
						    else {
						    	audio("music/Hover3.wav");
						    	op.setIcon(new ImageIcon("images/Newgame2.png"));}
					}
	

					public void mouseExited(MouseEvent e) {  
						    if(n==1) {
							  op.setIcon(new ImageIcon("images/Home1.png"));}
							    
						    else {
						    	op.setIcon(new ImageIcon("images/Newgame1.png"));}
					}

					public void mouseClicked(MouseEvent e) {
						if(n==1) {
							clip1.stop();
							setVisible(false);
							Firstpage obj=new Firstpage();
					    	Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png");  
					        obj.setIconImage(Titlebaricon); 
						}
						
					else{    clip1.stop();
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
Clip clip;
Clip clip1;
void audio(String audio_path) {
    try {
         File file = new File(audio_path);
         clip = AudioSystem.getClip();
         clip.open(AudioSystem.getAudioInputStream(file));
         clip.start();
         } 
    catch (Exception e) {
               System.err.println("Put the music1.wav file in the appropriate folder");
           }
       }
void audio1(String audio_path) {
    try {
         File file = new File(audio_path);
         clip1 = AudioSystem.getClip();
         clip1.open(AudioSystem.getAudioInputStream(file));
         clip1.start();
         } 
    catch (Exception e) {
               System.err.println("Put the music1.wav file in the appropriate folder");
           }
       }

}
