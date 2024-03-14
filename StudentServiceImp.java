package tuan91;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImp extends UnicastRemoteObject implements StudentService{
    private final List<Student> students  = new ArrayList<>();
    
    public StudentServiceImp() throws RemoteException{
        super();
    }
    
    @Override
    public void addStudent(String name, int age) throws RemoteException {
        Student student = new Student(name, age);
        students.add(student);
    }

    @Override
    public void removeStudent(String name) throws RemoteException {
        students.removeIf(student -> student.getName().equals(name));
    }

    @Override
    public List<Student> getAllStudents() throws RemoteException {
        return students;
    }

}
