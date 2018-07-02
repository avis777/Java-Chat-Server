import java.rmi.*;
import java.rmi.server.*;
import java.awt.*;
import java.awt.event.*;

public class chatserver extends UnicastRemoteObject implements int1
{
	String cl1 = "",cl2 = "";
	public chatserver()throws RemoteException
	{
		super();
	}
	public String passit(String pmsg,String whoo)throws RemoteException
	{
		if(whoo.equals("CLIENT1"))
		{
			System.out.println("server received "+pmsg+" from client1");
			cl1 = "" + pmsg;
		}
		if(whoo.equals("CLIENT2"))
		{
			System.out.println("server received "+pmsg+" from client2");
			cl2 = "" + pmsg;
		}
		return "";
	}
	public String getit(String pmsg,String whoo)throws RemoteException
	{
		if(whoo.equals("CLIENT1"))
		{
			System.out.println("server sent "+cl2+" to client1");
			return cl2;
		}
		if(whoo.equals("CLIENT2"))
		{
			System.out.println("server sent "+cl1+" to client2");
			return cl1;
		}
		return "";
	}
	public static void main(String ar[])
	{
		try
		{
			chatserver cs1 = new chatserver();
			Naming.rebind("con1",cs1);
			System.out.println("Server is Running...");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
}
