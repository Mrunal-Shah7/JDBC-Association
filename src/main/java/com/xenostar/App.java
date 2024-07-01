package  com.xenostar;

import javax.swing.plaf.nimbus.State;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public  class App {




    public static void main(String[] args) throws IOException ,InterruptedException, SQLException {
        Student student;
        Course course;


        Connection connection = DB.getConnection();
        Statement statement = connection.createStatement();
        PreparedStatement insertStudent = connection.prepareStatement("insert into Student values (?,?)");
        PreparedStatement insertCourse = connection.prepareStatement("insert into Course values (?,?,?)");
        ResultSet resultSet;
        PreparedStatement insertStudent_Course = connection.prepareStatement("insert into student_courses values (?,?)");
        PreparedStatement getStudent_Course = connection.prepareStatement("select cId from student_courses where sId = ?");
        PreparedStatement getCourseFromId = connection.prepareStatement("select name from course where cId = ?");
        ArrayList<Integer> holder = new ArrayList<>();








        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner input = new Scanner(System.in);
        int choice=1;

        while (choice!=7) {
            System.out.println("-----------------------------------------");
            System.out.println("1.Add Student");
            System.out.println("2.Add Course");
            System.out.println("3.Assign Course");
            System.out.println("4.Display a Student's Courses");
            System.out.println("5.Show Data of all Students");
            System.out.println("6.Show Data of all Courses");
            System.out.println("7.Exit");
            System.out.print("-->");
            choice = input.nextInt();

            switch (choice) {
                case  1:
                    student = new Student();
                    System.out.print("Enter Student Id:");
                    int inputID = input.nextInt();
                    student.setsId(inputID);
                    System.out.print("Enter Student Name:");
                    String inputName = br.readLine();
                    student.setSname(inputName);
                    student.addToList();
                    statement.execute("create table if not exists Student(sId int primary key, Name varchar(20))");
                    insertStudent.setInt(1,inputID);
                    insertStudent.setString(2,inputName);
                    System.out.println(insertStudent.executeUpdate()+" Rows Effected");
                    System.out.println("Student added Successfully");
                    Thread.sleep(500);
                break;

                case 2:
                    course = new Course();
                    System.out.print("Enter the course ID:");
                    inputID = input.nextInt();
                    course.setcId(inputID);
                    System.out.print("Enter the course Name:");
                    inputName = br.readLine();
                    course.setCname(inputName);
                    System.out.print("Enter the course Credits:");
                    int credits = input.nextInt();
                    course.setCredits(credits);
                    course.addToList();
                    statement.execute("create  table  if not exists Course(cId int primary key,Name varchar(20),Credits int)");
                    insertCourse.setInt(1,inputID);
                    insertCourse.setString(2,inputName);
                    insertCourse.setInt(3,credits);
                    System.out.println(insertCourse.executeUpdate()+" Rows Effected");
                    System.out.println("Course added Successfully");
                    Thread.sleep(500);
                break;

                case 3:


                    statement.execute("create table if not exists Student_Courses(sId int , cId int , Primary Key(sId,cId),Foreign Key(sId) references Student(sId),Foreign Key(cId) references Course(cId))");

                    System.out.println("Select Student ID:");
                    resultSet = statement.executeQuery("select * from student");

                    while (resultSet.next()){
                        System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2));
                    }
                    System.out.print("-->");
                    int stuIndex = input.nextInt();


                    System.out.println("Select Course ID:");
                    resultSet = statement.executeQuery("select * from course");

                    while (resultSet.next()){
                        System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2));
                    }
                    System.out.print("-->");
                    int corIndex = input.nextInt();


                    insertStudent_Course.setInt(1,stuIndex);
                    insertStudent_Course.setInt(2,corIndex);

                    System.out.println(insertStudent_Course.executeUpdate()+" Rows Affected");






                    /*     This code was used to locally associate courses with student by using arrayLists.
                    int i=1;
                    int j=1;
                    System.out.println("Select Student:");
                    for(Student stu:Student.getSL()){
                        System.out.println(i+" "+stu.getSname());
                        i++;
                    }
                    System.out.print("-->");
                    int stuIndex = input.nextInt();

                    System.out.println("Select Course:");
                    for(Course cor:Course.getCL()){
                        System.out.println(j+" "+cor.getCname());
                        j++;
                    }
                    System.out.print("-->");
                    int corIndex = input.nextInt();

                    student = Student.getSL().get((stuIndex)-1);
                    course = Course.getCL().get(corIndex-1);
                    student.addCourse(course);


                     */
                    System.out.println("Successfully added !");
                    Thread.sleep(1000);
                break;

                case 4:








                    /*
                    int k=1;
                    int l=1;
                    System.out.println("Select Student:");
                    for(Student stu:Student.getSL()){
                        System.out.println(k+" "+stu.getSname());
                        k++;
                    }
                    System.out.print("-->");
                    int val = input.nextInt();

                    student = Student.getSL().get(val-1);

                    System.out.println("All courses taken by "+student.getSname()+" are:");
                    for(Course cor:student.getsCourses()){
                        System.out.println(l+" "+cor.getCname());
                        l++;
                    }

                     */
                    Thread.sleep(1000);

                break;


                case 5:
                    resultSet = statement.executeQuery("select * from Student");
                    System.out.println("ID"+"\t"+"Name");
                    while (resultSet.next()){
                        System.out.println(resultSet.getInt(1)+ "\t"+resultSet.getString(2));
                    }
                    Thread.sleep(2000);
                break;

                case 6:
                    resultSet = statement.executeQuery("select  * from Course");
                    System.out.println("ID"+"\t"+"Name"+"\t"+"Credits");
                    while (resultSet.next()){
                        System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3));
                    }
                    Thread.sleep(2000);
            }
        }
    }
}