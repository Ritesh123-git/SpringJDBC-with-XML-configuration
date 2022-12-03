package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
//        ApplicationContext context= new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
//        JdbcTemplate template=context.getBean("jdbcTemplate",JdbcTemplate.class);
        
        
        // insert query
//        String query="insert into student values(?,?,?)";
        
        // fire the query
        
//        int update = template.update(query,457,"Ritesh","pune");
//        System.out.println("number of record inserted "+update);
        
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        // insert 
//        Student student=new Student();
//        student.setId(666);
//        student.setName("john");
//        student.setCity("Lucknow");
//        
//        int result=studentDao.insert(student);
//        System.out.println("student added "+result);
        
        
        
        
        // update
//        Student student= new Student();
//        student.setId(222);
//        student.setName("Sam Billings");
//        student.setCity("bali");
//        int change = studentDao.change(student);
//        System.out.println("data change "+change);
        
        
        
        // delete
//        int delete = studentDao.delete(456);
//        System.out.println("deleted "+delete);
        
//        Student student = studentDao.getStudent(222);
//        System.out.println(student);
        
        List<Student> students= studentDao.getAllStudents();
        for(Student s:students) {
        	System.out.println(s);
        }
        
    }
}
