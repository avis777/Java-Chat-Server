import java.*;
import java.rmi.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class client1 extends JFrame implements ActionListener,Runnable
{
	String mee = "CLIENT1",smsg="",rmsg="";
	JPanel p1;
	JButton b1;//,/b2;
	JTextField tf1;
	JLabel l1;
	static int1 i1;
	static Thread th1;
	
	public void run()
	{
		try
		{
			while(true)
			{
			System.out.println(" Thread is Running");
			rmsg = i1.getit("sd",mee);
			if(!(rmsg.equals("")))
			{
				l1.setText(""+rmsg);
				System.out.println(" Client 1 Received : "+rmsg);
			}
			Thread.sleep(1000);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	public client1()
	{
		p1 = new JPanel();
		p1.setLayout(null);
		
		b1 = new JButton("SEND");
		//b2 = new JButton("RECeIVE");
		
		l1 = new JLabel("Messages");
		tf1 = new JTextField("");
		
		tf1.setBounds(20,335,240,30);
		b1.setBounds(270,336,80,30);
		l1.setBounds(150,160,100,100);
		//b2.setBounds(100,100,80,30);
		
		p1.add(l1);
		p1.add(tf1);
		p1.add(b1);
		//p1.add(b2);
		
		b1.addActionListener(this);
		//b2.addActionListener(this);
		
		this.getContentPane().add(p1);
		
		setSize(390,417);
		setVisible(true);
		setTitle("Client 1");
		p1.setBackground(Color.cyan);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		th1 = new Thread(this);
		th1.setPriority(1);
		th1.start();
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			if(ae.getSource()==b1)
			{
				smsg = tf1.getText();
				if(!(smsg.equals("")))
				{
					i1.passit(smsg,mee);
					System.out.println("Client 1 Passed : "+smsg);
				}
				tf1.setText("");
			}
			/* if(ae.getSource()==b2)
			{
				rmsg = i1.getit("sd",mee);
				if(!(smsg.equals("")))
				{
					l1.setText(""+rmsg);
					System.out.println(" Client 1 Received : "+rmsg);
				}
			} */
				
		}
		catch(Exception e)
		{
			
		}
		
		
	}
	public static void main(String ar[])
	{
		
		try
		{
			i1 = (int1)Naming.lookup("con1");
			System.out.println("Client 1 is ready...");
		}
		catch(Exception e)
		{
			
		}
		
		new client1();
	}
}
