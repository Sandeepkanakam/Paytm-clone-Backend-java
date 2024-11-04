package com.example.LibrarayManagement.repository;

import com.example.LibrarayManagement.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Integer> {
    Student findStudentByRollNumber(String rollNumber);
    Student findStudentByEmail(String email);
}
