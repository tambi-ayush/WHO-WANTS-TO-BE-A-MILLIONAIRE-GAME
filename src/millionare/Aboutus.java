package millionare;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.net.*;




public class Aboutus extends JFrame{
	JLabel Aboutus,Ayushimage,Deepakimage,AText,DText,Institute,Department;
	JLabel Gmaillogo1,Facebooklogo1,Instagramlogo1,Linkedinlogo1,Githublogo1,Gmaillogo,Facebooklogo,Youtubelogo,Instagramlogo,Linkedinlogo,Githublogo;
	 JPanel p = new JPanel();
public Aboutus() {
	
		setTitle("WHO WANTS TO BE A MILLIONAIRE");
		setLayout(new BorderLayout()); 
        JLabel bg=new JLabel(new ImageIcon("images/background2.jpg"));
        add(bg);
		
        Aboutus = new JLabel("ABOUT US");
		Aboutus.setBounds(0, 30, 1200, 40);
		Aboutus.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 40));
		Aboutus.setHorizontalAlignment(JLabel.CENTER);
		Aboutus.setForeground(Color.YELLOW);
		bg.add(Aboutus);
	
		Ayushimage = new JLabel();
		Ayushimage.setBounds(300, 100, 150, 150);
		bg.add(Ayushimage);
		Ayushimage.setIcon(new ImageIcon("images/AyushGupta1.gif"));
        Ayushimage.addMouseListener(new MouseAdapter() {
		    
			public void mouseEntered(MouseEvent e) {
				Ayushimage.setBounds(300, 100, 155, 155);
		    	Ayushimage.setIcon(new ImageIcon("images/Ayushgupta2.png"));   	
		    }

		    public void mouseExited(MouseEvent e) {
		    	Ayushimage.setBounds(300, 100, 150, 150);
		    	Ayushimage.setIcon(new ImageIcon("images/AyushGupta1.gif"));
		    	
		    }             
		});
		
	    AText = new JLabel("Ayush Kumar Gupta");
		AText.setBounds(220,275,300 , 30);
		AText.setFont(new Font("Rockwell", Font.PLAIN, 25));
		AText.setForeground(Color.WHITE);
		AText.setHorizontalAlignment(JLabel.CENTER);
		bg.add(AText);		
		
		Deepakimage = new JLabel();
		Deepakimage.setBounds(750, 100, 150, 150);
		bg.add(Deepakimage);
		Deepakimage.setIcon(new ImageIcon("images/Deepak1.png"));
		
		Deepakimage.addMouseListener(new MouseAdapter() {
		    
			public void mouseEntered(MouseEvent e) {
				Deepakimage.setBounds(750, 100, 155, 155);
		    	Deepakimage.setIcon(new ImageIcon("images/Deepak2.png"));   	
		    }

		    public void mouseExited(MouseEvent e) {
		    	Deepakimage.setBounds(750, 100, 150, 150);
		    	Deepakimage.setIcon(new ImageIcon("images/Deepak1.png")); 
		    	
		    }             
		});
		
	    DText = new JLabel("Deepak Gurjar");
		DText.setBounds(680, 275, 300, 30);
		DText.setFont(new Font("Rockwell", Font.PLAIN, 25));
		DText.setForeground(Color.WHITE);
		DText.setHorizontalAlignment(JLabel.CENTER);
		bg.add(DText);	
		
		Gmaillogo = new JLabel();
		Gmaillogo.setBounds(225, 330, 35, 35);
		bg.add(Gmaillogo);
		Gmaillogo.setIcon(new ImageIcon("images/Gmail3.gif"));
	    Gmaillogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    mousehandle(Gmaillogo,1);
		
		Instagramlogo = new JLabel();
		Instagramlogo.setBounds(275, 330, 35, 35);
		bg.add(Instagramlogo);
		Instagramlogo.setIcon(new ImageIcon("images/Instagram3.gif"));
		Instagramlogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mousehandle(Instagramlogo,2);
		
		Facebooklogo = new JLabel();
		Facebooklogo.setBounds(325,330 , 35, 35);
		bg.add(Facebooklogo);
		Facebooklogo.setIcon(new ImageIcon("images/Facebook3.gif"));
		Facebooklogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mousehandle(Facebooklogo,3);
		
		Githublogo = new JLabel();
		Githublogo.setBounds(375, 330, 35, 35);
		bg.add(Githublogo);
		Githublogo.setIcon(new ImageIcon("images/Github3.png"));
		Githublogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mousehandle(Githublogo,4);
		
		Linkedinlogo = new JLabel();
		Linkedinlogo.setBounds(425, 330, 35, 35);
		bg.add(Linkedinlogo);
		Linkedinlogo.setIcon(new ImageIcon("images/Linkedin3.gif"));
		Linkedinlogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mousehandle(Linkedinlogo,5);
		
		Youtubelogo = new JLabel();
		Youtubelogo.setBounds(475, 330, 35, 35);
		bg.add(Youtubelogo);
		Youtubelogo.setIcon(new ImageIcon("images/Youtube3.gif"));
		Youtubelogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mousehandle(Youtubelogo,6);
		
		
		Gmaillogo1 = new JLabel();
		Gmaillogo1.setBounds(710, 330, 35, 35);
		bg.add(Gmaillogo1);
		Gmaillogo1.setIcon(new ImageIcon("images/Gmail3.gif"));
		Gmaillogo1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mousehandle(Gmaillogo1,7);
		
		Instagramlogo1 = new JLabel();
		Instagramlogo1.setBounds(760, 330, 35, 35);
		bg.add(Instagramlogo1);
		Instagramlogo1.setIcon(new ImageIcon("images/Instagram3.gif"));
		Instagramlogo1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mousehandle(Instagramlogo1,8);
		
		Facebooklogo1 = new JLabel();
		Facebooklogo1.setBounds(810,330 , 35, 35);
		bg.add(Facebooklogo1);
		Facebooklogo1.setIcon(new ImageIcon("images/Facebook3.gif"));
		Facebooklogo1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mousehandle(Facebooklogo1,9);
		
		
		Githublogo1 = new JLabel();
		Githublogo1.setBounds(860, 330, 35, 35);
		bg.add(Githublogo1);
		Githublogo1.setIcon(new ImageIcon("images/Github3.png"));
		Githublogo1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mousehandle(Githublogo1,10);
		
		
		Linkedinlogo1 = new JLabel();
		Linkedinlogo1.setBounds(910, 330, 35, 35);
		bg.add(Linkedinlogo1);
		Linkedinlogo1.setIcon(new ImageIcon("images/Linkedin3.gif"));
		Linkedinlogo1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mousehandle(Linkedinlogo1,11);
		
		
		Institute = new JLabel("Institute: Indian Institute of Information Technology,Kota  Situated at: Malviya National Institute of Technology,Jaipur,Rajasthan");
		Institute.setBounds(0,450,1200,20);
		Institute.setFont(new Font("Rockwell", Font.PLAIN, 18));
		Institute.setForeground(Color.WHITE);
		Institute.setHorizontalAlignment(JLabel.CENTER);
		bg.add(Institute);
		Institute.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mousehandle(Institute,12);
		
		
		Department = new JLabel("Department: Electronics and Communication Engineering");
		Department.setBounds(0,470,1200,20);
		Department.setFont(new Font("Rockwell", Font.PLAIN, 18));
		Department.setForeground(Color.WHITE);
		Department.setHorizontalAlignment(JLabel.CENTER);
		bg.add(Department);	
		
		Backbutton(bg);	
		
		String MotivationalQuote = "";
		File f = new File("images/Aboutus.txt");
		try{
			Scanner reader = new Scanner(f);
	        while(reader.hasNextLine())
	        {
	            MotivationalQuote += reader.nextLine()+"\n";
	            // if there is a next line, add in the new line character that was skipped
	        }
	        reader.close();
		}
		catch (IOException e)
		{
			
		}
		JTextArea text;
		text = new JTextArea(MotivationalQuote);
		text.setBounds(25, 550, 1175, 60);
		text.setFont(new Font("Roboto", Font.PLAIN, 18));
		text.setForeground(Color.GREEN);
		text.setEditable(false);
		text.setOpaque(false);
		bg.add(text);
}

void Backbutton(JLabel bg){
	JLabel back = new JLabel();
	back.setBounds(500,580,200,101);
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

void mousehandle(JLabel op,int n) {
	op.addMouseListener(new MouseAdapter() {

		public void mouseClicked(MouseEvent e) {
			if(n==1) {
		  try {
		        Desktop.getDesktop().mail(new URI("mailto:2019kuec2018@iiitkota.ac.in?subject=Mail%20from%20user%20Regarding%20who%20wants%20to%20be%20a%20millionaire%20project"));
		    } 
		  catch (IOException | URISyntaxException e1) {
		       System.out.println("There is some error in Fetching URL");
		    }
			}
			else if(n==2) {
				try {
			        Desktop.getDesktop().browse(new URI("https://www.instagram.com/ayush_tambi001/"));
			    } 
			  catch (IOException | URISyntaxException e1) {
			       System.out.println("There is some error in Fetching URL");
			    }	
			}
			else if(n==3) {
				try {
			        Desktop.getDesktop().browse(new URI("https://m.facebook.com/ayush.tambi.7?ref=bookmarks"));
			    } 
			  catch (IOException | URISyntaxException e1) {
			       System.out.println("There is some error in Fetching URL");
			    }	
			}
			else if(n==4) {
				try {
			        Desktop.getDesktop().browse(new URI("https://github.com/tambi-ayush"));
			    } 
			  catch (IOException | URISyntaxException e1) {
			       System.out.println("There is some error in Fetching URL");
			    }
			}
			else if(n==5) {
				try {
			        Desktop.getDesktop().browse(new URI("https://www.linkedin.com/mwlite/in/ayush-kumar-gupta-4036911b9"));
			    } 
			  catch (IOException | URISyntaxException e1) {
			       System.out.println("There is some error in Fetching URL");
			    }	
			}
			else if(n==6) {
				try {
			        Desktop.getDesktop().browse(new URI("https://m.youtube.com/channel/UCRnIJlJkOMsHKqogJSmmAOQ"));
			    } 
			  catch (IOException | URISyntaxException e1) {
			       System.out.println("There is some error in Fetching URL");
			    }
			}
			else if(n==7) {
				try {
					Desktop.getDesktop().mail(new URI("mailto:2019kuec2027@iiitkota.ac.in?subject=Mail%20from%20user%20Regarding%20who%20wants%20to%20be%20a%20millionaire%20project"));
			    } 
			  catch (IOException | URISyntaxException e1) {
			       System.out.println("There is some error in Fetching URL");
			    }
			}
			else if(n==8) {
				try {
			        Desktop.getDesktop().browse(new URI("https://www.instagram.com/deepakgurjar42098/"));
			    } 
			  catch (IOException | URISyntaxException e1) {
			       System.out.println("There is some error in Fetching URL");
			    }
			}
			else if(n==9) {
				try {
			        Desktop.getDesktop().browse(new URI("https://www.facebook.com/profile.php?id=100050076653183"));
			    } 
			  catch (IOException | URISyntaxException e1) {
			       System.out.println("There is some error in Fetching URL");
			    }
			}
			else if(n==10) {
				try {
			        Desktop.getDesktop().browse(new URI("https://github.com/deepak12345rawat"));
			    } 
			  catch (IOException | URISyntaxException e1) {
			       System.out.println("There is some error in Fetching URL");
			    }
			}
			else if(n==11) {
				try {
			        Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/deepak-gurjar-7a91211a0"));
			    } 
			  catch (IOException | URISyntaxException e1) {
			       System.out.println("There is some error in Fetching URL");
			    }
			}
			else {
				try {
			        Desktop.getDesktop().browse(new URI("http://www.iiitkota.ac.in/"));
			    } 
			  catch (IOException | URISyntaxException e1) {
			       System.out.println("There is some error in Fetching URL");
			    }
			}
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
