package com.InventorSoftAcademy.hibernateproject.CRUD;

import com.InventorSoftAcademy.hibernateproject.exceptions.TeacherNotFoundException;
import com.InventorSoftAcademy.hibernateproject.model.Teacher;
import com.InventorSoftAcademy.hibernateproject.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TeacherDao {

    public void saveTeacher(Teacher teacher) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(teacher);
            transaction.commit();
            System.out.println("Teacher was successfully added");
            session.close();
            HibernateUtil.shutdown();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public Teacher getTeacherById(long id) throws TeacherNotFoundException {
        Transaction transaction = null;
        Teacher teacher = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            teacher = session.get(Teacher.class, id);
            System.out.println(teacher);
            transaction.commit();
            session.close();
            HibernateUtil.shutdown();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                throw new TeacherNotFoundException("Teacher with id: " + id + " was not found");
            }
        }
        return teacher;
    }

    public List<Teacher> getAllById() {
        Transaction transaction = null;
        List<Teacher> teacherList = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            teacherList = session.createQuery("from Teacher ").list();
            transaction.commit();
            System.out.println(teacherList);
            session.close();
            HibernateUtil.shutdown();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return teacherList;
    }

    public void updateTeacherById(Long teacherId, Teacher newTeacherData) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Teacher existingTeacher = session.get(Teacher.class, teacherId);
            if (existingTeacher != null) {
                existingTeacher.setFirstname(newTeacherData.getFirstname());
                existingTeacher.setLastname(newTeacherData.getLastname());
                existingTeacher.setSubject_Id(newTeacherData.getSubject_Id());
                session.merge(existingTeacher);
                transaction.commit();
                System.out.println("Teacher was successfully updated");
            } else {
                throw new TeacherNotFoundException("Teacher with id: " + teacherId + " not found");
            }
            session.close();
            HibernateUtil.shutdown();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


    public void delete(long id) throws TeacherNotFoundException {
        Transaction transaction = null;
        Teacher teacher = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            teacher = session.get(Teacher.class, id);
            session.delete(teacher);
            System.out.println("Teacher was successfully deleted");
            transaction.commit();
            session.close();
            HibernateUtil.shutdown();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                throw new TeacherNotFoundException("Teacher with id: " + id + " was not found");
            }
        }
    }
}
