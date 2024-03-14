package tuan91;
import java.rmi.*;
import java.util.List;

public interface StudentService extends Remote{
    public void addStudent(String name, int age) throws RemoteException;
    public void removeStudent(String name) throws RemoteException;
    public List<Student> getAllStudents() throws RemoteException;
}
