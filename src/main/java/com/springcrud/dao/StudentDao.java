package com.springcrud.dao;

import com.springcrud.model.Student;

import java.util.List;

public interface StudentDao {
    public int create(Student student);

    public List<Student> read();

    public List<Student> findStudentById(int studentId);
    //public Student findStudentById(int studentId);
    public int update(Student student);

    public int delete(int studentId);
}
