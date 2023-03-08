package org.example;

import org.example.Dao.StudentDao;
import org.example.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ApplicationContext context =new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao=context.getBean("studentDao", StudentDao.class);
//        System.out.println(studentDao);
        Student student=new Student(234,"Abhijeet","Ashti");
        int r=studentDao.insert(student);
        System.out.println("done "+r);
        System.out.println(studentDao.getAllStudent());
    }
}
