package in.projects.studentmanagementsystem;

import in.projects.studentmanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);
    }

    @Autowired
    private StudentRepository repository;
    @Override
    public void run(String... args) throws Exception {
//        Student student1 = new Student("shyla","sree","shylasree@gmail.com");
//        repository.save(student1);
//        Student student2 = new Student("ashutosh","sagade","ashutoshsagade@gmail.com");
//        repository.save(student2);
    }
}
