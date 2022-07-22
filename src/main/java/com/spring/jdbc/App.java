package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
//        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
    	
    	// By using java config and not using xml file
    	ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		
        /*
		 * JdbcTemplate temp = context.getBean("jdbcTempName", JdbcTemplate.class);
		 * String query = "insert into student(id, name, city) values(?, ?, ?)"; int
		 * result = temp.update(query, 121, "Rohit Gupta", "Delhi");
		 */
        //System.out.println("Row affected: " + result);
        
        StudentDao sd = context.getBean("studentDao", StudentDao.class);

//        Student student = new Student(125, "Shruti", "Lucknow");
//        int result = sd.insert(student);
//        System.out.println("Student added: " + result);
        
//        Student student = new Student(125, "Shivani", "Varanasi");
//        int result = sd.update(student);
//        System.out.println("Result updated" + result);
        
//        int r = sd.delete(125);
//        System.out.println("Row deleted: " + r);
        
//        Student student = sd.getStudent(222);
//        System.out.println(student);
        
        List<Student> st = sd.getAllStudent();
        for(Student s : st) {
        	System.out.println(s);
        }
        
    }
}
