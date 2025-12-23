package com.skillnext2;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.skillnext2.entity.Student;
import com.skillnext2.util.HibernateUtil;

public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student s1 = new Student("Ravi", 22);
        session.save(s1);

        tx.commit();
        session.close();

        System.out.println("Student record inserted successfully!");
    }
}
