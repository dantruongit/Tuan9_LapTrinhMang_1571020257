package tuan91;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(9999);
            StudentService obj = new StudentServiceImp();
            Naming.rebind("//localhost:9999/StudentService", obj);
            System.out.println("Server is running ...");
        } catch (MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
