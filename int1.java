import java.rmi.*;

public interface int1 extends Remote
{
	public String passit(String s1,String s2)throws RemoteException;
	public String getit(String s1,String s2)throws RemoteException;
}
