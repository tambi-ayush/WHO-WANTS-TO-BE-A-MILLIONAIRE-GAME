package millionare;

import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;



public class Firstpage extends JFrame{
	Timer time;
	int sec;
	JLabel b1,b2;
	JLabel logo,Aboutus,Aboutgame;
    int n;
    JLabel lines[]=new JLabel[7];
    JLabel b1Text,b2Text,b3Text,b4Text;
    static public String playername=" ";
    
//constructor overloading
public Firstpage() {
        millionairestart();
		}
   
public Firstpage(JFrame f,JPanel p) {
        countdown(f,p);
		}

void  countdown(JFrame f,JPanel p) {
    time = new Timer();
    sec=25;//24
	time.scheduleAtFixedRate(
	new TimerTask() {
				public void run()
				{
				if(sec==0){
				    millionairestart(f,p);
					time.cancel();
					return ;
					}
			    sec--;
			}
		} ,0,1000);
 }

void millionairestart(JFrame f,JPanel p) {
	
		f.getContentPane().remove(p);
		f.setLayout(new BorderLayout()); 
        JLabel bg=new JLabel(new ImageIcon("images/background1.png"));
        f.add(bg);
        //taking user name as input
        playername= playername+JOptionPane.showInputDialog(f,"Enter your Name");        
        
		logo = new JLabel("");
		logo.setBounds(450,15,300,300);
		bg.add(logo);
		logo.setIcon(new ImageIcon("images/logo2.gif"));
		
		Aboutus = new JLabel("");
		Aboutus.setBounds(10,10,200,101);
		Aboutus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bg.add(Aboutus);
		Aboutus.setIcon(new ImageIcon("images/Aboutus3.png"));
		Aboutus.setHorizontalAlignment(JLabel.CENTER);
		b3Text = new JLabel(" ");
		mouseaction(Aboutus,b3Text,3,bg);
		

		Aboutgame = new JLabel("");
		Aboutgame.setBounds(970,15,200,101);
		Aboutgame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Aboutgame.setIcon(new ImageIcon("images/Aboutgame1.png"));
		bg.add(Aboutgame);
		Aboutgame.setHorizontalAlignment(JLabel.CENTER);
		b4Text = new JLabel(" ");
	    mouseaction(Aboutgame,b4Text,4,bg);
		
		
		//WHITE LINES FOR INTERFACE
		        int x=0,y=415;
				for(int i=1;i<=4;i++)
				{
					if(i==3)
					{
						x+=996;
					}
					if(i%2==1)
					{
						y=415;
					}
					if(i%2==0)
					{
						y=525;
					}
					lines[i] = new JLabel();
					lines[i].setBounds(x,y,204,2);
					bg.add(lines[i]);
					lines[i].setOpaque(true);
					lines[i].setBackground(Color.WHITE);
					
				}
				
		
	    b1Text = new JLabel("...Instructions For Fastest Finger First...");
		b1Text.setBounds(200, 375, 800, 80);
		b1Text.setFont(new Font("Rockwell", Font.PLAIN, 27));
		b1Text.setForeground(Color.WHITE);
		b1Text.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b1Text.setHorizontalAlignment(JLabel.CENTER);
	    bg.add(b1Text);		
					
		b1 = new JLabel();
		b1.setBounds(200,375,800,80);
		b1.setIcon(new ImageIcon("images/whitebox1.png"));
		//b1.setToolTipText("Instructions for Fastest Finger First");  
		bg.add(b1);
		b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b1.setHorizontalAlignment(JLabel.CENTER);
		mouseaction(b1,b1Text,1,bg);
		
		
		b2Text = new JLabel("........... Fastest Finger First ...........");
		b2Text.setBounds(205, 480, 785, 75);
		b2Text.setFont(new Font("Rockwell", Font.PLAIN, 27));
		b2Text.setForeground(Color.WHITE);
		b2Text.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b2Text.setHorizontalAlignment(JLabel.CENTER);
		bg.add(b2Text);
		
		b2 = new JLabel();
		b2.setBounds(200,485,800,80);
		b2.setIcon(new ImageIcon("images/whitebox1.png"));
		//b2.setToolTipText("Play Fastest Finger First");  
		bg.add(b2);
		b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b2.setHorizontalAlignment(JLabel.CENTER);
	    mouseaction(b2,b2Text,2,bg);
		
		
	  
}

void mouseaction(JLabel op,JLabel op1,int n,JLabel bg) {
	
	op.addMouseListener(new MouseAdapter() {

					public void mouseEntered(MouseEvent e) {
						    if(n==1) {
						    	audio("music/Hover3.wav");
							    op.setIcon(new ImageIcon("images/yellowbox1.png"));
							    lines[1].setBackground(Color.	YELLOW);
							    lines[3].setBackground(Color.YELLOW);
							    op1.setFont(new Font("Rockwell", Font.PLAIN, 29));
								op1.setForeground(Color.BLUE);
						    }
						        
						    else if(n==2) {
						    	audio("music/Hover3.wav");
							   op.setIcon(new ImageIcon("images/yellowbox1.png"));
							   lines[2].setBackground(Color.YELLOW);
							    lines[4].setBackground(Color.YELLOW);
							    op1.setFont(new Font("Rockwell", Font.PLAIN, 29));
								op1.setForeground(Color.BLUE);

								}
							    
						    else if(n==3) {
						    	audio("music/Hover3.wav");
								op.setIcon(new ImageIcon("images/Aboutus4.png"));}
							    
						    else {
						    	audio("music/Hover3.wav");
						    	op.setIcon(new ImageIcon("images/Aboutgame2.png"));}
					}
	

					public void mouseExited(MouseEvent e) {
						    if(n==1) {
							    op.setIcon(new ImageIcon("images/whitebox1.png"));
							    lines[1].setBackground(Color.WHITE);
							    lines[3].setBackground(Color.WHITE);
							    op1.setFont(new Font("Rockwell", Font.PLAIN, 27));
								op1.setForeground(Color.WHITE);
							    }
						    
						    else if(n==2) {
								op.setIcon(new ImageIcon("images/whitebox1.png"));
								lines[2].setBackground(Color.WHITE);
							    lines[4].setBackground(Color.WHITE);
							    op1.setFont(new Font("Rockwell", Font.PLAIN, 27));
								op1.setForeground(Color.WHITE);
							
								}
							    
						    else  if(n==3) {
							  op.setIcon(new ImageIcon("images/Aboutus3.png"));}
							    
						    else {
						    	op.setIcon(new ImageIcon("images/Aboutgame1.png"));}
					}

					public void mouseClicked(MouseEvent e) {
						if(n==1) {
							setVisible(false);
							Instruction1 obj=new Instruction1();
							Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png");  
					        obj.setIconImage(Titlebaricon);  
							obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							obj.setResizable(false);
							obj.setSize(1200,720);
							obj.setVisible(true);
						}
					else if(n==2) {
							setVisible(false);
							fastestFingerPrint obj1=new fastestFingerPrint();
							Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png");  
					        obj1.setIconImage(Titlebaricon);  
					        obj1.setSize(1200,720);
							obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							obj1.setResizable(false);
							obj1.setVisible(true);
							
						}
						
					else if(n==3){
						    setVisible(false);
							Aboutus obj=new Aboutus();
							Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png");  
					        obj.setIconImage(Titlebaricon);  
							obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							obj.setResizable(false);
							obj.setSize(1200,720);
							obj.setVisible(true);
							
						}
					else{
					    setVisible(false);
						aboutgame obj=new aboutgame();
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


//Method overloading (make all changes here that you made in paramaterised millionairestart method)

void millionairestart() {
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	setSize(1200,720);
	setVisible(true);
	setTitle("WHO WANTS TO BE A MILLIONAIRE");
	setLayout(new BorderLayout()); 
    JLabel bg=new JLabel(new ImageIcon("images/background1.png"));
    add(bg);
    
	logo = new JLabel("");
	logo.setBounds(450,15,300,300);
	bg.add(logo);
	logo.setIcon(new ImageIcon("images/logo2.gif"));
	
	Aboutus = new JLabel("");
	Aboutus.setBounds(10,10,200,101);
	bg.add(Aboutus);
	Aboutus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	Aboutus.setIcon(new ImageIcon("images/Aboutus3.png"));
	Aboutus.setHorizontalAlignment(JLabel.CENTER);
	b3Text = new JLabel(" ");
	mouseaction(Aboutus,b3Text,3,bg);
	

	Aboutgame = new JLabel("");
	Aboutgame.setBounds(970,15,200,101);
	Aboutgame.setIcon(new ImageIcon("images/Aboutgame1.png"));
	Aboutgame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	bg.add(Aboutgame);
	Aboutgame.setHorizontalAlignment(JLabel.CENTER);
	b4Text = new JLabel(" ");
    mouseaction(Aboutgame,b4Text,4,bg);
	
	
	//WHITE LINES FOR INTERFACE
	        int x=0,y=415;
			for(int i=1;i<=4;i++)
			{
				if(i==3)
				{
					x+=996;
				}
				if(i%2==1)
				{
					y=415;
				}
				if(i%2==0)
				{
					y=525;
				}
				lines[i] = new JLabel();
				lines[i].setBounds(x,y,204,2);
				bg.add(lines[i]);
				lines[i].setOpaque(true);
				lines[i].setBackground(Color.WHITE);
				
			}
			
	
    b1Text = new JLabel("...Instructions For Fastest Finger First...");
	b1Text.setBounds(200, 375, 800, 80);
	b1Text.setFont(new Font("Rockwell", Font.PLAIN, 27));
	b1Text.setForeground(Color.WHITE);
	b1Text.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	b1Text.setHorizontalAlignment(JLabel.CENTER);
    bg.add(b1Text);		
				
	b1 = new JLabel();
	b1.setBounds(200,375,800,80);
	b1.setIcon(new ImageIcon("images/whitebox1.png"));
	//b1.setToolTipText("Instructions for Fastest Finger First");  
	bg.add(b1);
	b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	b1.setHorizontalAlignment(JLabel.CENTER);
	mouseaction(b1,b1Text,1,bg);
	
	
	b2Text = new JLabel("........... Fastest Finger First ...........");
	b2Text.setBounds(205, 480, 785, 75);
	b2Text.setFont(new Font("Rockwell", Font.PLAIN, 27));
	b2Text.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	b2Text.setForeground(Color.WHITE);
	b2Text.setHorizontalAlignment(JLabel.CENTER);
	bg.add(b2Text);
	
	b2 = new JLabel();
	b2.setBounds(200,485,800,80);
	b2.setIcon(new ImageIcon("images/whitebox1.png"));
	//b2.setToolTipText("Play Fastest Finger First");  
	bg.add(b2);
	b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	b2.setHorizontalAlignment(JLabel.CENTER);
    mouseaction(b2,b2Text,2,bg);
	
	
  
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
	