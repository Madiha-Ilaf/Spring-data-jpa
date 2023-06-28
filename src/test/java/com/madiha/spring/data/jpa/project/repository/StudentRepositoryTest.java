package com.madiha.spring.data.jpa.project.repository;
import com.madiha.spring.data.jpa.project.entity.Guardian;
import com.madiha.spring.data.jpa.project.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("madihailaf3133@gmail.com")
                .firstName("Madiha")
                .lastName("Ilaf")
                //.guardianName("hayat bee")
                //.guardianEmail("hayatbee580@gmail.com")
                //.guardianMobile("9848788580")
                .build();

        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("khasim580@gmail.com")
                .name("khasimbee")
                .mobile("1234567890")
                .build();
        Student student = Student.builder()
                .firstName("mfrj")
                .emailId("mfrj@email.com")
                .lastName("jdi")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
    @Test
    public void printAllStudent(){

        List<Student> studentList =
                studentRepository.findAll();
        System.out.println("studentList = " + studentList);

    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students =
                studentRepository.findByFirstName("Madiha");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students =
                studentRepository.findByFirstNameContaining("a");
        System.out.println("students = " + students);
    }
    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("hayat");
        System.out.println("students = " + students);
    }
    @Test
    public void printStudentByLastName(){
        List<Student> students =
                studentRepository.findByLastName("jdi");
        System.out.println("students = " + students);
    }
    @Test
    public void printGetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress(
                "frj@email.com"
        );
        System.out.println("student = " + student);
    }
    @Test
    public void printGetStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress(
                "frj@email.com"
        );
        System.out.println("firstName = " + firstName);
    }
    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative(
                "frj@email.com"
        );
        System.out.println("student = " + student);
    }
    @Test
    public void printGetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam(
                "frj@email.com"
        );
        System.out.println("student = " + student);
    }
    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId(
            "frj m"  ,  "frj@email.com"
        );
    }


}