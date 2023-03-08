package org.example.Dao;

import org.example.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
//import org.springframework.transaction.annotation.Transactional;


import javax.transaction.Transactional;
import java.util.List;

public class StudentDao {


    private HibernateTemplate hibernateTemplate;
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }


    //save student
    @Transactional
    //we have to use transaction on the only write operation
    public int insert(Student student)
    {
       Integer i=(Integer)this.hibernateTemplate.save(student);
        return i;
    }

    //get the single data
    public Student getStudent(int studentId)
    {
        Student student=this.hibernateTemplate.get(Student.class,studentId);
        return student;
    }

    //get all students
    public List<Student> getAllStudent()
    {
        List<Student> students=this.hibernateTemplate.loadAll(Student.class);
        return students;
    }

    //for delete
    @Transactional
    public void delete(int studentId)
    {
       Student student= this.hibernateTemplate.get(Student.class,studentId);
       this.hibernateTemplate.delete(student);
    }

    //update
    @Transactional
    public void update(Student student)
    {
        this.hibernateTemplate.update(student);
    }

    @Override
    public String toString() {
        return "StudentDao{" +
                "hibernateTemplate=" + hibernateTemplate +
                '}';
    }
}
