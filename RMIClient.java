package tuan91;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class RMIClient {
    public static <T> void out(T d, boolean newline){
        if(newline) System.out.println(d.toString());
        else System.out.print(d.toString());
    }
    
    public static void menu(){
        out("           -MENU-          ", true);
        out("   1.Show all Students", true);
        out("   2.Add new Student", true);
        out("   3.Remove student by name", true);
        out("  -1.Exit",true);
    }
    
    public static void main(String[] args) {
        try {
            //Tìm đối tượng từ máy chủ
            StudentService object = (StudentService)Naming.lookup("//localhost:9999/StudentService");
            Scanner sc = new Scanner(System.in);
            int choice = 0;
            menu();
            while(choice != -1){
                out("Input your choice ", false);
                choice = sc.nextInt();
                switch(choice){
                    case 1:{
                        out("           =======STUDENTS=======",true);
                        List<Student> studentsList = object.getAllStudents();
                        studentsList.forEach(student->{
                            out(student.getName() + " - " + student.getAge(), true);
                        });
                        break;
                    }
                    case 2:{
                        out("           =======ADD=======",true);
                        sc.nextLine();
                        out("Input new student name: ", false);
                        String name = sc.nextLine();
                        out("Input new student age: ", false);
                        int age = sc.nextInt();
                        object.addStudent(name, age);
                        break;
                    }
                    case 3:{
                        out("           =======REMOVE=======",true);
                        sc.nextLine();
                        out("Input new student name: ", false);
                        String name = sc.nextLine();
                        object.removeStudent(name);
                        break;
                    }
                    default:{
                        choice = -1;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
