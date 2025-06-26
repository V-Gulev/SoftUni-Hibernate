package org.example;

import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure();

        SessionFactory factory = config.buildSessionFactory();
        Session currentSession = factory.openSession();

        currentSession.getTransaction().begin();

        Student student = new Student();
//        student.setName("Vili");
//        currentSession.persist(student);

        Student student1 = currentSession.find(Student.class, 1);
        System.out.println(student1.getName());
        currentSession.getTransaction().commit();
        currentSession.close();
    }
}