package com.InventorSoftAcademy.hibernateproject;

import com.InventorSoftAcademy.hibernateproject.CRUD.TeacherDao;
import com.InventorSoftAcademy.hibernateproject.model.Teacher;

public class HibernateProjectApplication {

	public static void main(String[] args) throws Exception {
		Teacher teacher = new Teacher("Kseniia", "Komaritsa", 4L);
		Teacher teacher1 = new Teacher("Ksyuuuuuuu", "Komaritsa", 2L);


//
//		TeacherDao teacherDao = new TeacherDao();
//		teacherDao.saveTeacher(teacher);

//
//		TeacherDao teacherDao = new TeacherDao();
//		teacherDao.getTeacherById(4L);



//		TeacherDao teacherDao = new TeacherDao();
//		teacherDao.getAllById();

//
//		TeacherDao teacherDao = new TeacherDao();
//		teacherDao.updateTeacherById(7L, teacher1);


		TeacherDao teacherDao = new TeacherDao();
		teacherDao.delete(7L);


	}

}
