package acc.br.student.controller;

import acc.br.student.model.Student;
import acc.br.student.service.StudentService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@Tag(name = "Student", description = "API de gerenciamento de estudantes")
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Lista todos os estudantes")
    @GetMapping("/student")
    private List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @Operation(summary = "Busca estudante por ID")
    @GetMapping("/student/{id}")
    private Student getStudent(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    @Operation(summary = "Remove um estudante")
    @DeleteMapping("/student/{id}")
    private void deleteStudent(@PathVariable("id") int id) {
        studentService.delete(id);
    }

    @Operation(summary = "Cria ou atualiza um estudante")
    @PostMapping("/student")
    private int saveStudent(@RequestBody Student student) {
        studentService.saveOrUpdate(student);
        return student.getId();
    }
}
