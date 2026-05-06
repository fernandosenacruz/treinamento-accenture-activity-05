package acc.br.student.service;

import acc.br.student.model.Student;
import acc.br.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
  @Autowired
  private StudentRepository studentRepository;

  public List<Student> getAllStudent() {
    List<Student> students = new ArrayList<Student>();
    studentRepository.findAll().forEach(students::add);
    return students;
  }


  public Student getStudentById(int id) {
    return (Student) studentRepository.findById(id).orElse(null);
  }

  public void saveOrUpdate(Student student) {
    studentRepository.save(student);
  }

  public void delete(int id) {
    studentRepository.deleteById(id);
  }

}
