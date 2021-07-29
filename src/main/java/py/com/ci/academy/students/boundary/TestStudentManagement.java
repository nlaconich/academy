package py.com.ci.academy.students.boundary;

import py.com.ci.academy.students.entities.Student;

import java.util.List;
import java.util.Scanner;

public class TestStudentManagement {
    public static void main(String[] args) {
        StudentManager studentManager= new StudentManager();
        List<Student> students=null;
        Scanner sc= new Scanner(System.in);
        int idSelected=0;
        String name = "", lastName = null, cellphone = null, address = null, email = null;

        System.out.println("Introduzca nombre");
        name=sc.next();
        System.out.println("Introduzca apellido");
        lastName=sc.next();
        System.out.println("Introduzca telefono");
        cellphone=sc.next();
        System.out.println("Introduzca direccion");
        address=sc.next();
        System.out.println("Introduzca email");
        email=sc.next();

        studentManager.add(name,lastName,cellphone,address,email);



        /*
        int select = Integer.parseInt(JOptionPane.showInputDialog("Seleccione opcion: " +
                "\n1- Ver Datos Tabla Estudiante" +
                "\n2- Ver Estudiante de Id seleccionado" +
                "\n3- Eliminar Estudiante por Id"));

        switch (select){
          case 1:
                students= studentManager.getAll();
                for (Student student: students) {
                    System.out.println(student);
                }
                break;
            case 2:
                idSelected=Integer.parseInt(JOptionPane.showInputDialog("Ingrese Id Estudiante: "));
                students= Collections.singletonList(studentManager.getById(idSelected));
                System.out.println(students);
                break;
            case 3:

                break;
        }
        */
    }
}
