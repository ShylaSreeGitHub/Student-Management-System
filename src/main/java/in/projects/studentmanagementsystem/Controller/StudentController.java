package in.projects.studentmanagementsystem.Controller;

import in.projects.studentmanagementsystem.Entity.Student;
import in.projects.studentmanagementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students")
    public ModelAndView listStudents(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students",service.getAllStudents());
        modelAndView.setViewName("students.html");
        return modelAndView;
    }
    @GetMapping("/students/new")
    public ModelAndView createStudentForm(){
        Student student = new Student();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student",student);
        modelAndView.setViewName("create_student.html");
        return modelAndView;
    }
    @PostMapping("/students")
    public ModelAndView saveStudent(@ModelAttribute("student") Student student){
        service.saveStudent(student);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students",service.getAllStudents());
        modelAndView.setViewName("students.html");
//        return "redirect:/students";
        return modelAndView;
    }
    @GetMapping("/students/edit/{id}")
    public ModelAndView editStudentForm(@PathVariable Long id, ModelAndView modelAndView){
        modelAndView.addObject("student",service.findByid(id));
        System.out.println(service.findByid(id).getEmail()+"I am in! good morninggggg-----------------");
        modelAndView.setViewName("edit_student");

        return modelAndView;
    }
    @PostMapping("/students/{id}")
    public ModelAndView updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student){
        ModelAndView modelAndView = new ModelAndView();
        Student existingStudent = service.findByid(id);
        System.out.println(existingStudent.getEmail());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        service.updateStudent(existingStudent);
        modelAndView.addObject("students",service.getAllStudents());
        return modelAndView;
    }
    @GetMapping("/students/{id}")
    public ModelAndView deleteStudent(@PathVariable Long id){
        Student student = service.findByid(id);
        service.deleteStudent(student);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", service.getAllStudents());
        modelAndView.setViewName("students");
        return modelAndView;
    }

}
