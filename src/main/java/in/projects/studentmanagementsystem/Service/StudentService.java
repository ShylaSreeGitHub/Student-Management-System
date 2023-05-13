package in.projects.studentmanagementsystem.Service;

import in.projects.studentmanagementsystem.Entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student findByid(Long id);
    Student updateStudent(Student student);

    void deleteStudent(Student student);
}
