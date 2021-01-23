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


public class Mainwindow extends JFrame {
	
	String[] Price = {"$1Million","$500,000","$250,000","$125,000","$64,000","$32,000","$16,000","$8,000","$4,000","$2,000","$1,000"," $500"," $300"," $200"," $100"};
	String[] Questionno = {"15 ","14","13","12","11","10","9","8","7","6","5","4","3","2","1"};
	JLabel bg;
	JLabel Clock;
	JLabel symbol[] = new JLabel[16];
	JLabel panel[]=new JLabel[16];
	JLabel op1 = new JLabel("");
	JLabel op2 = new JLabel("");
	JLabel op3 = new JLabel("");
	JLabel op4 = new JLabel("");
	JLabel bounds[] = new JLabel[4];
	JLabel Percentage[] = new JLabel[4];
	JLabel Experttxt = new JLabel("");
	JLabel box = new JLabel();
	JLabel Expert = new JLabel();
	Timer time;
	Timer time1;
	Timer stoptime;
	JLabel option[]=new JLabel[5];
	JLabel Questiontext = new JLabel("");
	int easyquestionid[]=new int[20];
	int mediumquestionid[]=new int[20];
	int hardquestionid[]=new int[20];
	
	
    int neweasyquestion=0;
    int newmediumquestion=0;
    int newhardquestion=0;
	int boxvisible = 0;
    int Expertvisible = 0;
	int used=0;
	int sec;
	int sec1;
	int t;
	int z;
	int variable[]=new int [4];
	int clickableaftershow=0;
	
	int questionno=0;
	int level = 1;
	int safeposition=0;
	
	String Question="";
	String OptionA="";
	String OptionB="";
	String OptionC="";
	String OptionD="";
	int answer;
	int selecttopic;
	String databasename;

	
	public Mainwindow(int selectquiz){
		selecttopic=selectquiz;
///-----------------------------------------------------------------------------	
		//To Get id of easy Questions
		int arr[]=new int[20];//Total 20 easy Questions are there in database
		Random rd = new Random();
		for(int i=0;i<=19;i++) {
			int n= 1+rd.nextInt(20);
		if(arr[n-1]==0) {
			arr[n-1]++;
		}
		else {
			i--;
			continue;
		}
		easyquestionid[i]=n;
		}
		
		//To Get id of medium Questions
		int arr1[]=new int[20];//Total 20 easy Questions are there in database
		Random rd1 = new Random();
		for(int j=0;j<=19;j++) {
			int m= 1+rd1.nextInt(20);
		if(arr1[m-1]==0) {
			arr1[m-1]++;
		}
		else {
			j--;
			continue;
		}
		mediumquestionid[j]=m;
		}
		
		//To Get id of Hard Question
		int arr2[]=new int[20];//Total 20 easy Questions are there in database
		Random rd2 = new Random();
		for(int k=0;k<=19;k++) {
			int l= 1+rd2.nextInt(20);
		if(arr2[l-1]==0) {
			arr2[l-1]++;
		}
		else {
			k--;
			continue;
		}
		hardquestionid[k]=l;
		}
//---------------------------------------------------------------------------
		frame();
		Quit();
	}
	
//---------------------------------------------------------------------------
//Function to give id and fetch easy question from database
void geteasyquestion(int id){
	try {
		if(selecttopic==1)
			databasename="programming";
		if(selecttopic==2)
			databasename="sports";
		if(selecttopic==3) 
			databasename="history";
	    if(selecttopic==4) 
	    	databasename="entertainment";
	    if(selecttopic==5)
	    	databasename="politics";
	    if(selecttopic==6)
	    	databasename="misc";
	    	
		String url="jdbc:mysql://localhost:3306/"+databasename;
		String user="root";
		String pass="ayush1234";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection(url,user,pass);
		
		String query="SELECT * FROM easy WHERE ID="+id;
		Statement st =	con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
	    Question = rs.getString("question");
		OptionA= rs.getString("option_A");
		OptionB= rs.getString("option_B");
		OptionC= rs.getString("option_C");
		OptionD= rs.getString("option_D");
	    answer= rs.getInt("answer");
		st.close();
		con.close();
		}
		catch(Exception e){
		System.out.println("Server not Responding");
		}
}
//Function to give id and fetch medium question from database
void getmediumquestion(int id){
	try {
		if(selecttopic==1)
			databasename="programming";
		if(selecttopic==2)
			databasename="sports";
		if(selecttopic==3) 
			databasename="history";
	    if(selecttopic==4) 
	    	databasename="entertainment";
	    if(selecttopic==5)
	    	databasename="politics";
	    if(selecttopic==6)
	    	databasename="misc";
		String url="jdbc:mysql://localhost:3306/"+databasename;
		String user="root";
		String pass="ayush1234";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection(url,user,pass);
		
		String query="SELECT * FROM medium WHERE ID="+id;
		Statement st =	con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
	    Question = rs.getString("question");
		OptionA= rs.getString("option_A");
		OptionB= rs.getString("option_B");
		OptionC= rs.getString("option_C");
		OptionD= rs.getString("option_D");
	    answer= rs.getInt("answer");
		st.close();
		con.close();
		}
		catch(Exception e){
		System.out.println("Server not Responding");
		}
}
//Function to give id and fetch medium question from database
void gethardquestion(int id){
	try {
		if(selecttopic==1)
			databasename="programming";
		if(selecttopic==2)
			databasename="sports";
		if(selecttopic==3) 
			databasename="history";
	    if(selecttopic==4) 
	    	databasename="entertainment";
	    if(selecttopic==5)
	    	databasename="politics";
	    if(selecttopic==6)
	    	databasename="misc";
		String url="jdbc:mysql://localhost:3306/"+databasename;
		String user="root";
		String pass="ayush1234";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection(url,user,pass);
		
		String query="SELECT * FROM hard WHERE ID="+id;
		Statement st =	con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
	    Question = rs.getString("question");
		OptionA= rs.getString("option_A");
		OptionB= rs.getString("option_B");
		OptionC= rs.getString("option_C");
		OptionD= rs.getString("option_D");
	    answer= rs.getInt("answer");
		st.close();
		con.close();
		}
		catch(Exception e){
		System.out.println("Server not Responding");
		}
}
///--------------------------------------------------------------------------------------


void Setnewquestion(){
	audio("music/Question_sound.wav");
	used=0;
	flag=0;
	clickableaftershow=0;
	if(boxvisible==1){
		box.setVisible(false);
		for(int i=0;i<4;i++){
			bounds[i].setVisible(false);
			Percentage[i].setVisible(false);
		}
	}
	if(Expertvisible==1){
		Expert.setVisible(false);
		Experttxt.setVisible(false);
	}

	while(true) {
		questionno++;
		if(questionno==6){
			level++;
			safeposition++;
			questionno=0;
			continue;
			}
		if(level==4 && questionno==1){
			setVisible(false);
			clip.stop();
			Endingpage ob1 = new Endingpage(safeposition,1);
			ob1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ob1.setResizable(false);
			ob1.setSize(1200,720);
			ob1.setVisible(true);
		
		    }
			break;
		}
	z=15-(level-1)*5-questionno;
	if(z==14)
	{
		panel[z].setBackground(Color.ORANGE);
		panel[z].setForeground(Color.WHITE);
		panel[z].setOpaque(true);
	}
	if(z<14 && z>=0)
	{
		symbol[z+1].setVisible(true);
		panel[z].setBackground(Color.ORANGE);
		panel[z].setForeground(Color.WHITE);
	    panel[z].setOpaque(true);
	    panel[z+1].setOpaque(false);
		if((z+1)%5==0)
			panel[z+1].setForeground(Color.ORANGE);
		else
			panel[z+1].setForeground(Color.WHITE);
	}
//----------------------------------------------------------------------------	
	if(z>=10) {
		int getid1=easyquestionid[neweasyquestion];
		neweasyquestion++;
		geteasyquestion(getid1);
	}
	if(z>=5&&z<10) {
		int getid2=mediumquestionid[newmediumquestion];
		newmediumquestion++;
		getmediumquestion(getid2);
	}
	if(z>=0&&z<5) {
		int getid3=hardquestionid[newhardquestion];
		newhardquestion++;
		gethardquestion(getid3);
	}
//------------------------------------------------------------------------------	
	if(z>=5) {
	Questiontext.setText("<html>"+Question+"</html>");
		countdown1();
    }
	else {
    clickableaftershow=1;
	Questiontext.setText("<html>"+Question+"</html>");
	op1.setText("<html>"+OptionA+"</html>");	
	op2.setText("<html>"+OptionB+"</html>");
	op3.setText("<html>"+OptionC+"</html>");
	op4.setText("<html>"+OptionD+"</html>");
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
					if(sec1==35){
						op1.setText("");	
						op2.setText("");
						op3.setText("");
						op4.setText("");
					}
					
					if(sec1==30){
						audio("music/timer.wav");
						op1.setText("<html>"+OptionA+"</html>");	
						op2.setText("<html>"+OptionB+"</html>");
						op3.setText("<html>"+OptionC+"</html>");
						op4.setText("<html>"+OptionD+"</html>");
						clickableaftershow=1;
						Clock.setVisible(true);
					}
					if(sec1==0)
					{   
						int r=15-5*(level-1) -questionno;
		    			setVisible(false);
						Endingpage ob = new Endingpage(r,2);
						ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						ob.setResizable(false);
						ob.setSize(1200,720);
						ob.setVisible(true);
						//Clock.setVisible(false);
						time1.cancel();
					}
					sec1--;
				}
			}					
			,0,1000);
	
}

void frame() {
	
	setTitle("WHO WANTS TO BE A MILLIONAIRE");
	setLayout(new BorderLayout()); 
    bg=new JLabel(new ImageIcon("images/background3.png"));
    add(bg);
    
    //For Creating the Panel of 15 Questions on Right hand side
	int siz=22;
	for(int i=0;i<=14;i++)
	{
		
		String temp=new String();
		int a=Questionno[i].length(),b=Price[i].length();
		for(int j=0;j<=5;j++)
		{
			temp=temp.concat(" ");
		}
		if(a==1)
			temp=temp.concat("  ");
		int spaces=18-b;
		temp=temp.concat(Questionno[i]);
		for(int j=1;j<=spaces;j++)
			temp=temp.concat("  ");
		temp=temp.concat(Price[i]);
		panel[i]=new JLabel(temp);
		panel[i].setFont(new Font("Rockwell", Font.PLAIN, 17));
		panel[i].setBounds(982, 22+i*siz, 220, 20);
		if(i%5 == 0) 
			panel[i].setForeground(Color.ORANGE);
		
		  else 
			panel[i].setForeground(Color.WHITE);
		bg.add(panel[i]);
		
		symbol[i]=new JLabel();
		symbol[i].setBounds(1045, i*siz, 60, 64);
		symbol[i].setIcon(new ImageIcon("images/diamond.png"));
		symbol[i].setVisible(false);
		bg.add(symbol[i]);
	}
	
	//Lines for Interface
	JLabel line1 = new JLabel("");
    line1.setBounds(980, 0, 3, 365);
	bg.add(line1);
	line1.setOpaque(true);
	line1.setBackground(Color.WHITE);

	JLabel line2 = new JLabel("");
	line2.setBounds(980, 365, 290, 3);
	bg.add(line2);
	line2.setOpaque(true);
	line2.setBackground(Color.WHITE);
	
	
	//QUESTION Text
	Questiontext.setBounds(140, 400, 910, 110);
	bg.add(Questiontext);
	Questiontext.setFont(new Font("Rockwell", Font.PLAIN, 18));
    Questiontext.setForeground(Color.WHITE);
	
	//OPTIONS Text
	op1.setBounds(165, 512, 410, 55);
	op1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	bg.add(op1);
	op1.setFont(new Font("Rockwell", Font.PLAIN, 16));
    op1.setForeground(Color.WHITE);
	
	op2.setBounds(655, 512, 410, 55);
	op2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	bg.add(op2);
	op2.setFont(new Font("Rockwell", Font.PLAIN, 16));
    op2.setForeground(Color.WHITE);
	
	op3.setBounds(165, 572, 410, 55);
	op3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	bg.add(op3);
	op3.setFont(new Font("Rockwell", Font.PLAIN, 16));
    op3.setForeground(Color.WHITE);
	
	op4.setBounds(655, 572, 410, 55);
	op4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	bg.add(op4);
	op4.setFont(new Font("Rockwell", Font.PLAIN, 16));
    op4.setForeground(Color.WHITE);
	
    Setnewquestion();
	
	//Question box
	JLabel Questions = new JLabel("");
    Questions.setBounds(35, 400, 1100, 110);
	bg.add(Questions);
	Questions.setIcon(new ImageIcon("images/Question1.png"));
	
	//Lines for Interface
	JLabel line3 = new JLabel("");
    line3.setBounds(0, 455, 108, 2);
	bg.add(line3);
	line3.setOpaque(true);
	line3.setBackground(Color.WHITE);
	
	JLabel line4 = new JLabel("");
    line4.setBounds(1060, 455, 130, 2);
	bg.add(line4);
	line4.setOpaque(true);
	line4.setBackground(Color.WHITE);
	
	//Text of all 4 options
	JLabel Aoption;
	Aoption = new JLabel("A :");
    Aoption.setBounds(125,510,25,55);
    Aoption.setFont(new Font("Rockwell", Font.PLAIN, 20));
    Aoption.setForeground(Color.ORANGE);
    Aoption.setHorizontalAlignment(JLabel.CENTER);
    bg.add(Aoption);	
    
    JLabel Boption;
	Boption = new JLabel("B :");
    Boption.setBounds(615,510,25,55);
    Boption.setFont(new Font("Rockwell", Font.PLAIN, 20));
    Boption.setForeground(Color.ORANGE);
    Boption.setHorizontalAlignment(JLabel.CENTER);
    bg.add(Boption);	
    
    
    JLabel Coption;
	Coption = new JLabel("C :");
    Coption.setBounds(125,570,26,55);
    Coption.setFont(new Font("Rockwell", Font.PLAIN, 20));
    Coption.setForeground(Color.ORANGE);
    Coption.setHorizontalAlignment(JLabel.CENTER);
    bg.add(Coption);
    
    JLabel Doption;
	Doption = new JLabel("D :");
    Doption.setBounds(615,570,25,55);
    Doption.setFont(new Font("Rockwell", Font.PLAIN, 20));
    Doption.setForeground(Color.ORANGE);
    Doption.setHorizontalAlignment(JLabel.CENTER);
    bg.add(Doption);
	
	//All 4 Options panel
	
			int x=70,y=510;

			for(int i=1;i<=4;i++)
			{
				if(i%2==0)
				{
					x+=490;
				}
				else
				{
					x=70;
				}
				if(i==3)
				{
					y+=60;
				}
				option[i] = new JLabel();
				option[i].setBounds(x,y,550,55);
				bg.add(option[i]);
				option[i].setIcon(new ImageIcon("images/Option1.png"));
				Optionaction(option[i],i);
			}
			
			
		    
			//6 lines of options for interface
			JLabel lines[]=new JLabel[7];
			int x1=0,y1=537,z1=108;

			for(int i=1;i<=6;i++)
			{
				if(i%3==1)
				{
					x1=0;
					z1=108;
				}
				if(i%3==2)
				{
					x1=582;
					z1=25;
				}
				if(i%3==0)
				{
					x1=1060;
					z1=130;
				}
				if(i<=3)
				{
					y1=537;
				}
				else if(i<=6)
				{
					y1=598;
				}
				lines[i] = new JLabel();
				lines[i].setBounds(x1,y1,z1,2);
				bg.add(lines[i]);
				lines[i].setOpaque(true);
				lines[i].setBackground(Color.WHITE);
			}
			

			//All the 4 Life lines
			JLabel Askexpert = new JLabel("");
			Askexpert.setBounds(20, 20, 50, 50);
			bg.add(Askexpert);
			Askexpert.setIcon(new ImageIcon("images/askexpert1.png"));
			Askexpert.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lifelineaction(Askexpert,1);

			JLabel Fifty = new JLabel("");
			Fifty.setBounds(95, 20, 50, 50);
			bg.add(Fifty);
			Fifty.setIcon(new ImageIcon("images/Fifty1.png"));
			Fifty.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lifelineaction(Fifty,2);
		
			JLabel Flip = new JLabel("");
			Flip.setBounds(170, 20, 50, 50);
			bg.add(Flip);
			Flip.setIcon(new ImageIcon("images/Flip1.png"));
			Flip.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lifelineaction(Flip,3);
			
			JLabel Audiencepoll = new JLabel("");
			Audiencepoll.setBounds(245, 20, 50, 50);
			bg.add(Audiencepoll);
			Audiencepoll.setIcon(new ImageIcon("images/Audiencepoll1.png"));
			Audiencepoll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lifelineaction(Audiencepoll,4);
			
			Clock = new JLabel("");
			Clock.setBounds(543, 293, 100, 100);
			bg.add(Clock);
			Clock.setIcon(new ImageIcon("images/Clock1.gif"));
			Clock.setVisible(false);
			
}

//////////////////Life line action management----------------------------------------
int flag=0;
int liflines[]=new int[5];
void lifelineaction(JLabel op,int i) {

op.addMouseListener(new MouseAdapter() {
public void mouseEntered(MouseEvent e) {
    	if(flag!=1&&clickableaftershow==1)
    	{     audio1("music/Hover3.wav");
    		if(i==1&&liflines[i]!=1)
	    	{
    			op.setIcon(new ImageIcon("images/askexpert2.png"));
	    	}
	    	else if(i==2&&liflines[i]!=1)
	    	{
	    		op.setIcon(new ImageIcon("images/Fifty2.png"));
	    	}
	    	else if(i==3&&liflines[i]!=1)
	    	{
	    		op.setIcon(new ImageIcon("images/Flip2.png"));
	    	}
	    	else if(i==4&&liflines[i]!=1)
	    	{
	    		op.setIcon(new ImageIcon("images/Audiencepoll2.gif"));
	    	}
    	}
	    	
    }
public void mouseExited(MouseEvent e) {
	    	if(flag!=1&&clickableaftershow==1)
	    	{
	    		if(i==1 && liflines[i]!=1)
		    	{
		    		op.setIcon(new ImageIcon("images/askexpert1.png"));
		    	}
		    	else if(i==2 && liflines[i]!=1)
		    	{
		    		op.setIcon(new ImageIcon("images/Fifty1.png"));
		    	}
		    	else if(i==3 && liflines[i]!=1)
		    	{
		    		op.setIcon(new ImageIcon("images/Flip1.png"));
		    	}
		    	else if(i==4 && liflines[i]!=1)
		    	{
		    		op.setIcon(new ImageIcon("images/Audiencepoll1.png"));
		    	}
	    	}	
	    } 

 public void mouseClicked(MouseEvent e) {
	if(flag!=1)
	{
		
////Expert Advice life line---------------------------------------------------------
		if(i==1&&clickableaftershow==1){
			int temp1=answer;//In temp1 store the correct answer
			
    		if(liflines[i]==1)
    			return ;
    		liflines[i]=1;
    		op.setIcon(new ImageIcon("images/Expertcross1.png"));
    		if(temp1==1) {
    			Experttxt = new JLabel("A");
    		}
    		if(temp1==2) {
    			Experttxt = new JLabel("B");
    		}
    		if(temp1==3) {
    			Experttxt = new JLabel("C");
    		}
    		if(temp1==4) {
    			Experttxt = new JLabel("D");
    		}
			Experttxt.setBounds(330, 240, 30, 30);
			Experttxt.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
			bg.add(Experttxt);
			Experttxt.setForeground(Color.YELLOW);
    		
    		
    		Expert.setBounds(170, 110, 305,187 );
			bg.add(Expert);
			Expert.setIcon(new ImageIcon("images/ExpertTenali.png"));
			
			Expertvisible=1;
		}	
		
/////50-50 Life line----------------------------------------------------------------
    	if(i==2&&clickableaftershow==1){
    		int k=0,j=0;
        	int temp=answer;//In temp store the correct answer
    		if(liflines[i]==1)
    			return ;
    		liflines[i]=1;
    		used=1;
    		op.setIcon(new ImageIcon("images/Fiftycross1.png"));
    	
    		while(j<2){k++;
				if(temp!=k){
					j++;
					if(k==1)op1.setText("");
					if(k==2)op2.setText("");
					if(k==3)op3.setText("");
						}}
    	}
    	
///////Flip the Question Life line ------------------------------------------------------    	
    	if(i==3&&clickableaftershow==1){
    		clip.stop();
    		Clock.setVisible(false);//related to countdown1
	    	time1.cancel();//related to countdown1
    		if(liflines[i]==1)
    			return ;
    		liflines[i]=1;
    		op.setIcon(new ImageIcon("images/Flipcross1.png"));
    		questionno--;
    		try {
			Setnewquestion();
			} catch (Exception e1) {
				
			
	    	}
    	}
 
////////////Audience Poll Life line ------------------------------------------
    	if(i==4&&clickableaftershow==1){

    		int tem;
			tem =answer;
    		if(liflines[i]==1)
    			return ;
    		op.setIcon(new ImageIcon("images/Audiencecross1.png"));
    		liflines[i]=1;
    		Random ran = new Random();
    		
				if(tem==1){
					if(used==1)
						variable[0]=60;
					else
						variable[0]=ran.nextInt(15)+40;
				}
				else{
					if(used==1)
						variable[0]=0;
					else
						variable[0]=ran.nextInt(10)+12;
				}
			
				if(tem==2){
					if(used==1)
						variable[1]=60;
					else
					variable[1]=ran.nextInt(15)+40;
				}
					
				else{
					if(used==1)
						variable[1]=0;
					else
					variable[1]=ran.nextInt(10)+12;
				}
					
				
				if(tem==3){
					if(used==1)
						variable[2]=60;
					else
					variable[2]=ran.nextInt(15)+40;
				}
					
				else{
					if(used==1)
						variable[2]=0;
					else
					variable[2]=ran.nextInt(10)+12;
				}
					
				if(variable[0]==variable[1] && variable[2]==0 && used==1)
					variable[2]=35;
				
				variable[3]=100-variable[1]-variable[0]-variable[2];
				
				
				
				int xx=30;
				for(int i=0;i<4;i++){
					bounds[i] = new JLabel();
					int z= 290-(int)(1.2*(double)variable[i]);
					bounds[i].setBounds(xx, z , 18, (int)(1.2*(double)variable[i]));
					bg.add(bounds[i]);
					bounds[i].setBackground(Color.decode("#44a2fa"));
					bounds[i].setOpaque(true);
					xx+=30;
					Percentage[i] = new JLabel(Integer.toString(variable[i])+"%");
					Percentage[i].setBounds(xx-30, z-25, 25, 25);
					bg.add(Percentage[i]);
					Percentage[i].setForeground(Color.WHITE);
				    Percentage[i].setBackground(Color.BLACK);
					Percentage[i].setOpaque(true);
				}
				
				box.setBounds(3, 110, 167, 220);
				bg.add(box);
				box.setIcon(new ImageIcon("images/Audiencebox.png"));
				box.setBackground(Color.BLACK);
				
				boxvisible=1;
				
    	}
//---------------------------------------------------------------------------------------------------    	
    	
    	
	}
 }
});
}
//----------------------------------------------------------------------------------------------------
//Option Panel Action
void Optionaction(JLabel op,int i){
	
	op.addMouseListener(new MouseAdapter() {

	    public void mouseEntered(MouseEvent e) {
	    	
	    	if(flag!=1&&clickableaftershow==1)
	    	{
	    		op.setIcon(new ImageIcon("images/Violetoption.png"));
	  
	    	}
	    }

	    public void mouseExited(MouseEvent e) {
	    	
	    	if(flag!=1&&clickableaftershow==1)
	    	op.setIcon(new ImageIcon("images/Option1.png"));
	    	
	    } 
	    
	    public void mouseClicked(MouseEvent e) {
	    	if(clickableaftershow==1) {
	    		clip.stop();
	    		Clock.setVisible(false);//related to countdown1
		    	time1.cancel();//related to countdown1
	    	if(flag!=1)
	    	{
	    		
	    		countdown(i);
		    	flag=1;
	    	}
	    	}
	    }     
	            
	});
	
}
//-----------------------------------------------------------------------------------------------------------------

void countdown(int i)
{
	time = new Timer();
	 sec=6;
	
	time.scheduleAtFixedRate(
			new TimerTask()
			{
				public void run()
				{
					if(sec==0){
						checkanswer(i);
						time.cancel();
						return ;
					}
					if(sec%2!=0)
						option[i].setIcon(new ImageIcon("images/Orangeoption.png"));
					else
						option[i].setIcon(new ImageIcon("images/Greenoption4.png"));
					sec--;
				}
			}					
			,0,300);
	
}
//---------------------------------------------------------------------------------------------
void checkanswer(int i)
{
	int ans;
	ans=answer;
	if(ans==i)
	{    audio1("music/correct answer.wav");
		stoptime = new Timer();
		 t=8;
		option[i].setIcon(new ImageIcon("images/Greenoption4.png"));
		stoptime.schedule(
			new TimerTask()
			{
				public void run()
				{
					if(t==0){
						option[i].setIcon(new ImageIcon("images/Option1.png"));
						try {
							
							Setnewquestion();
							stoptime.cancel();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					t--;
				}
			}					
			,0,1000);
	}
	else
	{
		stoptime = new Timer();
		audio1("music/wrong answer.wav");
		t=8;
		option[i].setIcon(new ImageIcon("images/Orangeoption.png"));
		option[ans].setIcon(new ImageIcon("images/Greenoption4.png"));
		stoptime.scheduleAtFixedRate(
			new TimerTask()
			{
				public void run()
				{
					if(t==0)
					{
						setVisible(false);
						Endingpage ob1 = new Endingpage(safeposition,1);
						ob1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						ob1.setResizable(false);
						ob1.setSize(1200,720);
						ob1.setVisible(true);
					
					} 	
					t--;
				}
			}					
			,0,600);
	}
}
//------------------------------------------------------------------------------------------

//Quit button
void Quit(){
	JLabel Quit = new JLabel("");
	Quit.setBounds(830, 10, 150, 75);
	Quit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	bg.add(Quit);
	Quit.setIcon(new ImageIcon("images/Quit2.png"));
	
	Quit.addMouseListener(new MouseAdapter() {
		   public void mouseEntered(MouseEvent e) {
			   
			   if(flag!=1&&clickableaftershow==1) {
				   audio1("music/Hover3.wav");
			   Quit.setIcon(new ImageIcon("images/Quit1.png"));  } 	
			    }

		  public void mouseExited(MouseEvent e) {
			        if(flag!=1&&clickableaftershow==1)
			    	Quit.setIcon(new ImageIcon("images/Quit2.png"));
			    	
			    } 
		   public void mouseClicked(MouseEvent e) {
			   if(flag!=1&&clickableaftershow==1)
		    	{ 
				   
		    		Object[] options = {"Yes","No"};
		    		int n = JOptionPane.showOptionDialog(null,"Want to Quit and walk out with the Money?","Want to Quit?",
		    											JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		    		if(n==0){
		    			clip.stop();
		    			int r=15-5*(level-1) -questionno;
		    			setVisible(false);
						Endingpage ob = new Endingpage(r,2);
						ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						ob.setResizable(false);
						ob.setSize(1200,720);
						ob.setVisible(true);
						
		    		}
		    	}
		   }
			});
}
//---------------------------------------------------------------------------------------
Clip clip;
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
         Clip clip1 = AudioSystem.getClip();
         clip1.open(AudioSystem.getAudioInputStream(file));
         clip1.start();
         } 
    catch (Exception e) {
               System.err.println("Put the music1.wav file in the appropriate folder");
           }
       }
}