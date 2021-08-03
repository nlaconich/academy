package py.com.ci.academy.Presentation;

import py.com.ci.academy.Teacher.boundary.TeacherManager;
import py.com.ci.academy.Teacher.entities.Teacher;

import java.util.List;
import java.util.Scanner;

public class TeacherUI {
    Scanner sc = new Scanner(System.in);
    TeacherManager teacherManager = new TeacherManager();
    Teacher teacher = new Teacher();


    public static void main(String[] args) {
        TeacherUI teacherUI= new TeacherUI();
        teacherUI.mainMenu();
    }

    private void mainMenu(){
        System.out.println("Welcome to teacher academy beta 0.0");
        System.out.println("-----------------------------------");
        System.out.println("Choose an option: ");
        System.out.println("1 : List all teachers");
        System.out.println("2 : Add a teacher");
        System.out.println("3 : Delete a teacher");
        System.out.println("4 : Update a teacher");
        System.out.println("5 : Exit");
        System.out.println("Option: ___");
        String option =     sc.next();
        try{
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption){
                case 1:
                    listAllTeachers();
                    break;
                case 2:
                    registerTeacher();
                    break;
                case 3:
                    deleteTeacher();
                    break;
                case 4:
                    updateTeacher();
                    break;
                case 5:
                    return;
            }
            mainMenu();
        }catch (Exception ex){

            mainMenu();
        }
    }

    private  void listAllTeachers() {
        List<Teacher> listTeachers = teacherManager.getAll();
        if (!listTeachers.isEmpty()){
            for(Teacher teacher: listTeachers){
                System.out.println(teacher);
            }
        }
        else{
            System.out.println("No teacher found");
        }
    }

    private  void registerTeacher() {
        String name = null, lastName = null, cellphone = null, address = null, email = null;

        sc.nextLine();
        System.out.println("Insert Name");
        name= sc.nextLine();
        System.out.println("Insert Last Name");
        lastName= sc.nextLine();
        System.out.println("Insert Phone");
        cellphone= sc.nextLine();
        System.out.println("Insert Address");
        address= sc.nextLine();
        System.out.println("Insert Mail");
        email= sc.nextLine();

        teacher.setNameTeacher(name);
        teacher.setLastName(lastName);
        teacher.setCellphone(cellphone);
        teacher.setAddress(address);
        teacher.setEmail(email);

        boolean tm = teacherManager.add(teacher);
            if(tm == true){
                System.out.println("Opration succesful");

            }else{
                System.out.println("Error");
            }
    }

    private void deleteTeacher(){
        int id=0, rows=0;

        System.out.println("Insert Id ");
        id=sc.nextInt();
        teacher.setIdTeacher(id);

        rows= teacherManager.deleteById(teacher);
        System.out.println("Applied, "+rows+" affected");
    }

   private void updateTeacher(){
        int id=0, rows=0;
        String name = null, lastName = null, cellphone = null, address = null, email = null;

        System.out.println("Insert Id ");
        id= sc.nextInt();
        sc.nextLine();
        System.out.println("Insert new Name");
        name= sc.nextLine();
        System.out.println("Insert new Last Name");
        lastName= sc.nextLine();
        System.out.println("Insert new Phone");
        cellphone= sc.nextLine();
        System.out.println("Insert new Address");
        address= sc.nextLine();
        System.out.println("Insert new Mail");
        email= sc.nextLine();
        teacher.setIdTeacher(id);
        teacher.setNameTeacher(name);
        teacher.setLastName(lastName);
        teacher.setCellphone(cellphone);
        teacher.setAddress(address);
        teacher.setEmail(email);

        rows= teacherManager.updateById(teacher);
        System.out.println("Applied, "+rows+" affected");
    }


}
