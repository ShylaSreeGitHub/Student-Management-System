package in.projects.studentmanagementsystem.Service.impl;

import in.projects.studentmanagementsystem.Entity.Student;
import in.projects.studentmanagementsystem.Repository.StudentRepository;
import in.projects.studentmanagementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findByid(Long id) {
        return studentRepository.findById(id).get();
    }


    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Student student){
        studentRepository.delete(student);
    }
}
