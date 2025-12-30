package com.skillnext2;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n======== STUDENT MENU ========");
            System.out.println("1. Insert Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice) {

            case 1:
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                Student s = new Student(name, age);
                Session session = factory.openSession();
                Transaction tx = session.beginTransaction();
                session.save(s);
                tx.commit();
                session.close();
                System.out.println("✔ Student Inserted Successfully!");
                break;

            case 2:
                System.out.print("Enter ID to View: ");
                int idView = sc.nextInt();
                Session session2 = factory.openSession();
                Student stu = session2.get(Student.class, idView);
                if(stu != null) {
                    System.out.println("\n--- Student Details ---");
                    System.out.println("ID   : " + stu.getId());
                    System.out.println("Name : " + stu.getName());
                    System.out.println("Age  : " + stu.getAge());
                } else {
                    System.out.println("❌ Student Not Found");
                }
                session2.close();
                break;

            case 3:
                System.out.print("Enter ID to Update: ");
                int idUpdate = sc.nextInt();
                Session session3 = factory.openSession();
                Transaction tx3 = session3.beginTransaction();
                Student st = session3.get(Student.class, idUpdate);
                if(st != null) {
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();
                    st.setName(newName);
                    st.setAge(newAge);
                    session3.update(st);
                    tx3.commit();
                    System.out.println("✔ Updated Successfully!");
                } else {
                    System.out.println("❌ Student Not Found");
                }
                session3.close();
                break;

            case 4:
                System.out.print("Enter ID to Delete: ");
                int idDelete = sc.nextInt();
                Session session4 = factory.openSession();
                Transaction tx4 = session4.beginTransaction();
                Student stDel = session4.get(Student.class, idDelete);
                if(stDel != null) {
                    session4.delete(stDel);
                    tx4.commit();
                    System.out.println("🗑 Record Deleted!");
                } else {
                    System.out.println("❌ Student Not Found");
                }
                session4.close();
                break;

            case 5:
                System.out.println("🚪 Exiting App... Bye!");
                break;

            default:
                System.out.println("⚠ Invalid Choice! Try Again.");
            }

        } while(choice != 5);

        factory.close();
        sc.close();
    }
}
