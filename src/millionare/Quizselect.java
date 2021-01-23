package millionare;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Quizselect extends JFrame {
	
	JLabel Subject,Programming,Sports,History,Entertainment,Politics,Miscellaneous,Instructions;
	JLabel Programmingtxt,Sportstxt,Historytxt,Entertainmenttxt,Politicstxt,Miscellaneoustxt;
	JLabel lines[]=new JLabel[9];
	
public Quizselect() {
		setTitle("WHO WANTS TO BE A MILLIONAIRE");
		setLayout(new BorderLayout()); 
        JLabel bg=new JLabel(new ImageIcon("images/background2.jpg"));
        add(bg);
        
        JLabel logo;
		logo = new JLabel("");
		logo.setBounds(496,22,200,200);
		bg.add(logo);
		logo.setIcon(new ImageIcon("images/logo3.gif"));
        
        Subject = new JLabel("Select Your Subject of Interest");
        Subject.setBounds(0, 260, 1200, 20);
        Subject.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 24));
        Subject.setHorizontalAlignment(JLabel.CENTER);
        Subject.setForeground(Color.YELLOW);
        bg.add(Subject);
        
        
      //WHITE LINES FOR INTERFACE
        int x=1,y=382;
		for(int i=1;i<=8;i++)
		{
			if(i==3)
			{
				x+=369;
			}
			if(i==5)
			{
				x+=367;
			}
			if(i==7)
			{
				x+=369;
			}
			
			if(i%2==1)
			{
				y=382;
			}
			if(i%2==0)
			{
				y=507;
			}
			lines[i] = new JLabel();
			lines[i].setBounds(x,y,107,2);
			bg.add(lines[i]);
			lines[i].setOpaque(true);
			lines[i].setBackground(Color.WHITE);
		}

        
        Programmingtxt = new JLabel("Programming");
        Programmingtxt.setBounds(97,350,285,65);
        Programmingtxt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Programmingtxt.setFont(new Font("Rockwell", Font.PLAIN, 20));
        Programmingtxt.setForeground(Color.WHITE);
        Programmingtxt.setHorizontalAlignment(JLabel.CENTER);
	    bg.add(Programmingtxt);		
		
        Programming = new JLabel();
        Programming.setBounds(97,350,285,65);
        Programming.setIcon(new ImageIcon("images/Whitebox2.png"));
        Programming.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //Programming.setToolTipText("Play Programming Quiz");  
        bg.add(Programming);
        Programming.setHorizontalAlignment(JLabel.CENTER);
        mousehandle(Programming,Programmingtxt,1,lines[1],lines[3]);
        
        Sportstxt = new JLabel("Sports");
        Sportstxt.setBounds(465,350,285,65);
        Sportstxt.setFont(new Font("Rockwell", Font.PLAIN, 20));
        Sportstxt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Sportstxt.setForeground(Color.WHITE);
        Sportstxt.setHorizontalAlignment(JLabel.CENTER);
	    bg.add(Sportstxt);		

        Sports = new JLabel();
        Sports.setBounds(465,350,285,65);
        Sports.setIcon(new ImageIcon("images/Whitebox2.png"));
        Sports.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //Sports.setToolTipText("Play Sports Quiz");  
        bg.add(Sports);
        Sports.setHorizontalAlignment(JLabel.CENTER);
        mousehandle(Sports,Sportstxt,2,lines[3],lines[5]);
        
        Historytxt = new JLabel("History");
        Historytxt.setBounds(832,350,285,65);
        Historytxt.setFont(new Font("Rockwell", Font.PLAIN, 20));
        Historytxt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Historytxt.setForeground(Color.WHITE);
        Historytxt.setHorizontalAlignment(JLabel.CENTER);
	    bg.add(Historytxt);		

        History = new JLabel();
        History.setBounds(832,350,285,65);
        History.setIcon(new ImageIcon("images/Whitebox2.png"));
        History.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //History.setToolTipText("Play History Quiz");  
        bg.add(History);
        History.setHorizontalAlignment(JLabel.CENTER);
        mousehandle(History,Historytxt,3,lines[5],lines[7]);
        
        Entertainmenttxt = new JLabel("Entertainment");
        Entertainmenttxt.setBounds(97,475,285,65);
        Entertainmenttxt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Entertainmenttxt.setFont(new Font("Rockwell", Font.PLAIN, 20));
        Entertainmenttxt.setForeground(Color.WHITE);
        Entertainmenttxt.setHorizontalAlignment(JLabel.CENTER);
	    bg.add(Entertainmenttxt);		

        Entertainment = new JLabel();
        Entertainment.setBounds(97,475,285,65);
        Entertainment.setIcon(new ImageIcon("images/Whitebox2.png"));
        Entertainment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //Entertainment.setToolTipText("Play Entertainment Quiz");  
        bg.add(Entertainment);
        Entertainment.setHorizontalAlignment(JLabel.CENTER);
        mousehandle(Entertainment,Entertainmenttxt,4,lines[2],lines[4]);
        
        Politicstxt = new JLabel("Politics");
        Politicstxt.setBounds(465,475,285,65);
        Politicstxt.setFont(new Font("Rockwell", Font.PLAIN, 20));
        Politicstxt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Politicstxt.setForeground(Color.WHITE);
        Politicstxt.setHorizontalAlignment(JLabel.CENTER);
	    bg.add(Politicstxt );	

        Politics = new JLabel();
        Politics.setBounds(465,475,285,65);
        Politics.setIcon(new ImageIcon("images/Whitebox2.png"));
        Politics.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //Politics.setToolTipText("Play Politics Quiz");  
        bg.add(Politics);
        Politics.setHorizontalAlignment(JLabel.CENTER);
        mousehandle(Politics,Politicstxt,5,lines[4],lines[6]);
        
        Miscellaneoustxt= new JLabel("Miscellaneous");
        Miscellaneoustxt.setBounds(832,475,285,65);
        Miscellaneoustxt.setFont(new Font("Rockwell", Font.PLAIN, 20));
        Miscellaneoustxt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Miscellaneoustxt.setForeground(Color.WHITE);
        Miscellaneoustxt.setHorizontalAlignment(JLabel.CENTER);
	    bg.add(Miscellaneoustxt );	
        
        Miscellaneous = new JLabel();
        Miscellaneous.setBounds(832,475,285,65);
        Miscellaneous.setIcon(new ImageIcon("images/Whitebox2.png"));
        Miscellaneous.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //Miscellaneous.setToolTipText("Play Miscellaneous Quiz");  
        bg.add(Miscellaneous);
        Miscellaneous.setHorizontalAlignment(JLabel.CENTER);
        mousehandle(Miscellaneous,Miscellaneoustxt,6,lines[6],lines[8]);
        
        Backbutton(bg);
        audio1("music/theme1.wav");
        
        Instructions = new JLabel("");
		Instructions.setBounds(10,10,200,101);
		Instructions.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bg.add(Instructions);
		Instructions.setIcon(new ImageIcon("images/Instructions1.png"));
		Instructions.setHorizontalAlignment(JLabel.CENTER);
		Instructions.addMouseListener(new MouseAdapter() {
			    
		   public void mouseEntered(MouseEvent e) {
			    	Instructions.setIcon(new ImageIcon("images/Instructions2.png")); 
			    	audio("music/Hover3.wav");
			    }

		  public void mouseExited(MouseEvent e) {
			    	Instructions.setIcon(new ImageIcon("images/Instructions1.png"));
			    	
			    } 
		   public void mouseClicked(MouseEvent e) {
			    clip1.stop();
			    setVisible(false);
				Instruction2 obj=new Instruction2();
				Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png");  
		        obj.setIconImage(Titlebaricon);  
				obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				obj.setResizable(false);
				obj.setSize(1200,720);
				obj.setVisible(true);    
		   } 
			});
      
}

void Backbutton(JLabel bg){
	JLabel back = new JLabel();
	back.setBounds(500,580,200,101);
	bg.add(back);
	back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
	    	clip1.stop();
	    	Firstpage obj=new Firstpage();
	    	Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png");  
	        obj.setIconImage(Titlebaricon);  
	        setVisible(false);
			
	    }     
	            
	});
}



void mousehandle(JLabel op,JLabel op1,int n,JLabel l1,JLabel l2){
	
	op.addMouseListener(new MouseAdapter() {

	    public void mouseEntered(MouseEvent e) {
	    	
	    	if(n==1) {
	    		audio("music/Hover3.wav");
	    		l1.setBounds(l1.getX(), l1.getY(), l1.getWidth()-8, l1.getHeight());
				l2.setBounds(l2.getX()+9, l2.getY(), l2.getWidth()-9, l2.getHeight());
	    		op.setIcon(new ImageIcon("images/Whitebox4.png"));
	    		op1.setFont(new Font("Rockwell", Font.PLAIN, 25));
	    			
	    	}
	    	else if(n==2) {
	    		audio("music/Hover3.wav");
	    		l1.setBounds(l1.getX(), l1.getY(), l1.getWidth()-10, l1.getHeight());
				l2.setBounds(l2.getX()+9, l2.getY(), l2.getWidth()-9, l2.getHeight());
	    		op.setIcon(new ImageIcon("images/Whitebox4.png"));
	    		op1.setFont(new Font("Rockwell", Font.PLAIN, 25));
	    		
	    	}
	    	else if(n==3) {
	    		audio("music/Hover3.wav");
	    		l1.setBounds(l1.getX(), l1.getY(), l1.getWidth()-10, l1.getHeight());
				l2.setBounds(l2.getX()+9, l2.getY(), l2.getWidth()-9, l2.getHeight());
	    		op.setIcon(new ImageIcon("images/Whitebox4.png"));
	    		op1.setFont(new Font("Rockwell", Font.PLAIN, 25));
	    		
	    	}
	    	else if(n==4) {
	    		audio("music/Hover3.wav");
	    		l1.setBounds(l1.getX(), l1.getY(), l1.getWidth()-8, l1.getHeight());
				l2.setBounds(l2.getX()+9, l2.getY(), l2.getWidth()-9, l2.getHeight());
	    		op.setIcon(new ImageIcon("images/Whitebox4.png"));
	    		op1.setFont(new Font("Rockwell", Font.PLAIN, 25));
	    		
	    	}
	    	else if(n==5) {
	    		audio("music/Hover3.wav");
	    		l1.setBounds(l1.getX(), l1.getY(), l1.getWidth()-10, l1.getHeight());
				l2.setBounds(l2.getX()+9, l2.getY(), l2.getWidth()-9, l2.getHeight());
	    		op.setIcon(new ImageIcon("images/Whitebox4.png"));
	    		op1.setFont(new Font("Rockwell", Font.PLAIN, 25));
	    		
	    	}
	    	else{
	    		audio("music/Hover3.wav");
	    		l1.setBounds(l1.getX(), l1.getY(), l1.getWidth()-10, l1.getHeight());
				l2.setBounds(l2.getX()+9, l2.getY(), l2.getWidth()-9, l2.getHeight());
	    		op.setIcon(new ImageIcon("images/Whitebox4.png"));
	    		op1.setFont(new Font("Rockwell", Font.PLAIN, 25));
	    		
	    	}
	    	
	    	
	    }

	    public void mouseExited(MouseEvent e) {

	    	if(n==1) {
	    		l1.setBounds(l1.getX(), l1.getY(), l1.getWidth()+8, l1.getHeight());
	    		l2.setBounds(l2.getX()-9, l2.getY(), l2.getWidth()+9, l2.getHeight());
	    		op.setIcon(new ImageIcon("images/Whitebox2.png"));
				op1.setFont(new Font("Rockwell", Font.PLAIN, 20));
	    	}
	    	else if(n==2) {
	    		l1.setBounds(l1.getX(), l1.getY(), l1.getWidth()+10, l1.getHeight());
	    		l2.setBounds(l2.getX()-9, l2.getY(), l2.getWidth()+9, l2.getHeight());
	    		op.setIcon(new ImageIcon("images/Whitebox2.png"));
				op1.setFont(new Font("Rockwell", Font.PLAIN, 20));
	    	}
	    	else if(n==3) {
	    		l1.setBounds(l1.getX(), l1.getY(), l1.getWidth()+10, l1.getHeight());
	    		l2.setBounds(l2.getX()-9, l2.getY(), l2.getWidth()+9, l2.getHeight());
	    		op.setIcon(new ImageIcon("images/Whitebox2.png"));
				op1.setFont(new Font("Rockwell", Font.PLAIN, 20));
	    	}
	    	else if(n==4) {
	    		l1.setBounds(l1.getX(), l1.getY(), l1.getWidth()+8, l1.getHeight());
	    		l2.setBounds(l2.getX()-9, l2.getY(), l2.getWidth()+9, l2.getHeight());
	    		op.setIcon(new ImageIcon("images/Whitebox2.png"));
				op1.setFont(new Font("Rockwell", Font.PLAIN, 20));
	    	}
	    	else if(n==5) {
	    		l1.setBounds(l1.getX(), l1.getY(), l1.getWidth()+10, l1.getHeight());
	    		l2.setBounds(l2.getX()-9, l2.getY(), l2.getWidth()+9, l2.getHeight());
	    		op.setIcon(new ImageIcon("images/Whitebox2.png"));
				op1.setFont(new Font("Rockwell", Font.PLAIN, 20));
	    	}
	    	else{
	    		l1.setBounds(l1.getX(), l1.getY(), l1.getWidth()+10, l1.getHeight());
	    		l2.setBounds(l2.getX()-9, l2.getY(), l2.getWidth()+9, l2.getHeight());
	    		op.setIcon(new ImageIcon("images/Whitebox2.png"));
				op1.setFont(new Font("Rockwell", Font.PLAIN, 20));
	    	}
	
	    } 
	    
	    public void mouseClicked(MouseEvent e) {
	    	if(n==1) {
	    		clip1.stop();
	    		Mainwindow obj1=new Mainwindow(1);
	    		Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png");  
	            obj1.setIconImage(Titlebaricon);  
				obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				obj1.setResizable(false);
				obj1.setSize(1200,720);
				obj1.setVisible(true);
				setVisible(false);
	    	}
	    	
	    	else if(n==2) {
	    		clip1.stop();
	    		Mainwindow obj1=new Mainwindow(2);
	    		Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png");  
	            obj1.setIconImage(Titlebaricon);  
				obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				obj1.setResizable(false);
				obj1.setSize(1200,720);
				obj1.setVisible(true);
				setVisible(false);
	    	}
	    	else if(n==3) {
	    		clip1.stop();
	    		Mainwindow obj1=new Mainwindow(3);
	    		Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png");  
	            obj1.setIconImage(Titlebaricon);  
				obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				obj1.setResizable(false);
				obj1.setSize(1200,720);
				obj1.setVisible(true);
				setVisible(false);
	    	}
	    	else if(n==4) {
	    		clip1.stop();
	    		Mainwindow obj1=new Mainwindow(4);
	    		Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png");  
	            obj1.setIconImage(Titlebaricon);  
				obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				obj1.setResizable(false);
				obj1.setSize(1200,720);
				obj1.setVisible(true);
				setVisible(false);
	    	}
	    	else if(n==5) {
	    		clip1.stop();
	    		Mainwindow obj1=new Mainwindow(5);
	    		Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png");  
	            obj1.setIconImage(Titlebaricon);  
				obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				obj1.setResizable(false);
				obj1.setSize(1200,720);
				obj1.setVisible(true);
				setVisible(false);
	    	}
	    	else {
	    		clip1.stop();
	    		Mainwindow obj1=new Mainwindow(6);
	    		Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png");  
	            obj1.setIconImage(Titlebaricon);  
				obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				obj1.setResizable(false);
				obj1.setSize(1200,720);
				obj1.setVisible(true);
				setVisible(false);
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
