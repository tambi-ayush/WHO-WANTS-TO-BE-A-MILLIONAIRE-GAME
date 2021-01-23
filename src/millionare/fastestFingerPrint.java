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

public class fastestFingerPrint extends JFrame{
	JLabel Clock;
	Timer time;
	Timer time1;
	String result="";
	String temp_id[]= {"","1","2","3","4"};
	int count=0;
	String hoverimagepath[]= {" ","images/optionA3.png","images/optionB3.png","images/optionC3.png","images/optionD3.png"};
	String imagepath[]= {" ","images/optionA1.png","images/optionB1.png","images/optionC1.png","images/optionD1.png"};
	JLabel option[]=new JLabel[5];
	String Question="";
	String option_A="";
	String option_B="";
	String option_C="";
	String option_D="";
	String answer="";
	JLabel bg;
	int sec1;
	int flag=0;
	
	JLabel option1 = new JLabel("");
	JLabel option2 = new JLabel("");
	JLabel option3 = new JLabel("");
	JLabel option4 = new JLabel("");
	
	public fastestFingerPrint(){
		//Getting random question and options from server
		
		/*---------------------------------*/
		Random rd = new Random();
		int n = 1+rd.nextInt(12);
		try {
		String url="jdbc:mysql://localhost:3306/ffp";
		String user="root";
		String pass="ayush1234";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection(url,user,pass);
		String query="SELECT * FROM question WHERE ID="+n;
		Statement st =	con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		Question = rs.getString("QUESTION");//name is our main string which we got from database
		option_A= rs.getString("OPTION_A");
		option_B= rs.getString("OPTION_B");
		option_C= rs.getString("OPTION_C");
	    option_D= rs.getString("OPTION_D");
	    answer= rs.getString("answer");
	    st.close();
		con.close();
		}
		catch(Exception e){
			System.out.println("Server not responding");
		}
		/*---------------------------------------------------------------*/
		
		//set title
		setTitle("FASTEST FINGER FIRST");
		setLayout(new BorderLayout()); 
		bg =new JLabel(new ImageIcon("images/background2.jpg"));
		add(bg);
		
		//Line for interface
		JLabel line = new JLabel();
		line.setBounds(600,100,2,590);
		bg.add(line);
		line.setBackground(Color.WHITE);
		line.setOpaque(true);
		
		//Heading of the page
		JLabel Heading;
		Heading = new JLabel("Let's Play Fastest Finger First");
		Heading.setBounds(0,20,1200,35);
		Heading.setForeground(Color.WHITE);
		Heading.setFont(new Font("Roboto", Font.BOLD, 30));
		Heading.setHorizontalAlignment(JLabel.CENTER);
		bg.add(Heading);
		
		//Clock for timer
		Clock = new JLabel("");
		Clock.setBounds(230,100, 100, 100);
		bg.add(Clock);
		Clock.setIcon(new ImageIcon("images/Clock1.gif"));
		Clock.setVisible(false);
		
		//Adding Question text
		JLabel questiontxt = new JLabel("<html>"+Question+"</html>");
		questiontxt.setBounds(110,223,460,200);
		questiontxt.setFont(new Font("SansSerif", Font.PLAIN, 20));
		questiontxt.setForeground(Color.WHITE);
		bg.add(questiontxt);
		audio("music/Question_sound.wav");
		countdown1();
		
		//Question panel image set
		JLabel questionimage = new JLabel("");
		questionimage.setBounds(20,220,560,210);
		questionimage.setIcon(new ImageIcon("images/Questionpanel.png"));
		bg.add(questionimage);
		
		//setting options text
		
		option1.setBounds(118,420,480,75);
		option1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bg.add(option1);
		option1.setFont(new Font("Roboto", Font.BOLD, 20));
		option1.setForeground(Color.WHITE);
		
		
		option2.setBounds(118,470,480,75);
		option2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bg.add(option2);
		option2.setFont(new Font("Roboto", Font.BOLD, 20));
		option2.setForeground(Color.WHITE);
		
		
		option3.setBounds(118,520,480,75);
		option3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bg.add(option3);
		option3.setFont(new Font("Roboto", Font.BOLD, 20));
		option3.setForeground(Color.WHITE);
		
		
		option4.setBounds(118,570,480,75);
		option4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bg.add(option4);
		option4.setFont(new Font("Roboto", Font.BOLD, 20));
		option4.setForeground(Color.WHITE);
		
		
		//SETTING OPTION IMAGES
		//All 4 Options panel
		int y2=420;
		for(int i=1;i<=4;i++)
		{
			
			option[i] = new JLabel();
			option[i].setBounds(40,y2,500,80);
			bg.add(option[i]);
			option[i].setIcon(new ImageIcon(imagepath[i]));
			y2+=50;
			Optionaction(option[i],i);
		}
		
		
	
}
	
void countdown1()
	{
		time1 = new Timer();
		sec1=35;
		
		time1.scheduleAtFixedRate(
				new TimerTask()
				{
					public void run()
					{
					
						if(sec1==30){
							audio("music/timer.wav");
							option1.setText("<html>"+option_A+"</html>");	
							option2.setText("<html>"+option_B+"</html>");
							option3.setText("<html>"+option_C+"</html>");
							option4.setText("<html>"+option_D+"</html>");
							flag=1;
							Clock.setVisible(true);
						}
						if(sec1==0)
						{   
							setVisible(false);
					    	Firstpage obj=new Firstpage();
					    	Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png");  
					        obj.setIconImage(Titlebaricon); 
							Clock.setVisible(false);
							time1.cancel();
						}
						sec1--;
					}
				}					
				,0,1000);
		
	}

	
	int position=135;	
	int position1=130;
	int click_check[]= {0,1,1,1,1};	
void Optionaction(JLabel op,int n) {
	
		op.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				op.setIcon(new ImageIcon(hoverimagepath[n]));
				
			}
			
			public void mouseExited(MouseEvent e) {
				op.setIcon(new ImageIcon(imagepath[n]));
			}
			
			public void mouseClicked(MouseEvent e) {
				if(flag==1&&click_check[n]==1&&count<4) {
					
				JLabel message = new JLabel("");
				message.setBounds(698,80,480,35);
				bg.add(message);
				message.setText("Your Response Is:--");
				message.setFont(new Font("Roboto",Font.PLAIN,30));
				message.setForeground(Color.WHITE);
				
				if(n==1) {
					JLabel op1= new JLabel("");
					op1.setBounds(698,position,480,30);
					bg.add(op1);
					op1.setFont(new Font("Roboto",Font.PLAIN,20));
					op1.setForeground(Color.WHITE);
					op1.setText(option_A);
				}
                if(n==2) {
                	JLabel op2= new JLabel("");
					op2.setBounds(698,position,480,30);
					bg.add(op2);
					op2.setFont(new Font("Roboto",Font.PLAIN,20));
					op2.setForeground(Color.WHITE);
					op2.setText(option_B);
				}
                if(n==3) {
                	JLabel op3= new JLabel("");
					op3.setBounds(698,position,480,30);
					bg.add(op3);
					op3.setFont(new Font("Roboto",Font.PLAIN,20));
					op3.setForeground(Color.WHITE);
					op3.setText(option_C);	
				}
                if(n==4) {
                	JLabel op4= new JLabel("");
					op4.setBounds(698,position,480,30);
					bg.add(op4);
					op4.setFont(new Font("Roboto",Font.PLAIN,20));
					op4.setForeground(Color.WHITE);
					op4.setText(option_D);	
				}
                position=position+50;
                if(n==1) {
					JLabel temp1= new JLabel("");
					temp1.setBounds(620,position1,500,40);
					bg.add(temp1);
					temp1.setIcon(new ImageIcon("images/optionA3.png"));	
				}
                if(n==2) {
                	JLabel temp2= new JLabel("");
					temp2.setBounds(620,position1,500,40);
					bg.add(temp2);
					temp2.setIcon(new ImageIcon("images/optionB3.png"));	
				}
                if(n==3) {
                	JLabel temp3= new JLabel("");
					temp3.setBounds(620,position1,500,40);
					bg.add(temp3);
					temp3.setIcon(new ImageIcon("images/optionC3.png"));	
				}
                if(n==4) {
                	JLabel temp4= new JLabel("");
					temp4.setBounds(620,position1,500,40);
					bg.add(temp4);
					temp4.setIcon(new ImageIcon("images/optionD3.png"));	
				}
                position1=position1+50;

				result=result.concat(temp_id[n]);
				
				click_check[n]--;
				count++;
				checker();
			}
				
				
			}
		
		});
	}
int position3=470;
int position4=470;
String options[]=new String[5];
JLabel temp_ans[]=new JLabel[5];
JLabel temp_ans_img[]=new JLabel[5];
void checker(){
	options[1]=option_A;
	options[2]=option_B;
	options[3]=option_C;
	options[4]=option_D;
		if(count==4){
			Clock.setVisible(false);
			clip.stop();
			time1.cancel();
			String displayTxt="";
			if(result.equals(answer)) {
				audio("music/correct answer.wav");
				displayTxt="<html>"+"Correct Answer Now you will be directed automatically to who wants to be a millionaire page in few seconds"+"</html>";
				JLabel status = new JLabel("");
				status.setBounds(625,380,550,45);
				bg.add(status);
				status.setForeground(Color.GREEN);
				status.setFont(new Font("SansSerif",Font.BOLD,16));
				status.setText(displayTxt);
				}
			else {
				audio("music/wrong answer.wav");
				displayTxt="<html>"+"Oops Wrong Answer.Try once again in few seconds in order to play who wants to be a millionaire. Correct Answer is:"+"<html>";
				JLabel status1 = new JLabel("");
				status1.setBounds(625,380,550,45);
				bg.add(status1);
				status1.setForeground(Color.RED);
				status1.setFont(new Font("SansSerif",Font.BOLD,16));
				status1.setText(displayTxt);
			}
			
			
			
			for(int i=0;i<=3;i++) {
				int num = answer.charAt(i);
				num-=48;//getting ascii value & subtract
				temp_ans[i]= new JLabel(options[num]);
				temp_ans[i].setBounds(620,position3,500,40);
				temp_ans[i].setHorizontalAlignment(JLabel.CENTER);
				bg.add(temp_ans[i]);
				temp_ans[i].setFont(new Font("Roboto", Font.BOLD, 20));
				temp_ans[i].setForeground(Color.WHITE);
				position3+=50;
			}
			for(int i=0;i<=3;i++) {
				int num = answer.charAt(i);
				num-=48;//getting ascii value & subtract
				temp_ans_img[i]= new JLabel();
				temp_ans_img[i].setBounds(620,position4,500,40);
				temp_ans_img[i].setIcon(new ImageIcon(imagepath[num]));
				bg.add(temp_ans_img[i]);
				position4+=50;
			}
			countdown(answer);
		
		}
	}
	
int sec;
void countdown(String ans)
	{ 
		time = new Timer();
		sec=8;
		time.scheduleAtFixedRate(
				new TimerTask()
				{
					public void run()
					{    
						if(sec==0) {
							if(result.equals(ans)) {
								setVisible(false);
								Quizselect obj1=new Quizselect();
								obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png");  
						        obj1.setIconImage(Titlebaricon);  
								obj1.setResizable(false);
								obj1.setSize(1200,720);
								obj1.setVisible(true);
								time.cancel();
							}
							else {
								setVisible(false);
						    	Firstpage obj=new Firstpage();
						    	Image Titlebaricon = Toolkit.getDefaultToolkit().getImage("images/Titlebaricon1.png");  
						        obj.setIconImage(Titlebaricon); 
						        time.cancel();
							}
						}
						sec--;
					}
				}					
				,0,1000);
	}

Clip clip ;
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
}
