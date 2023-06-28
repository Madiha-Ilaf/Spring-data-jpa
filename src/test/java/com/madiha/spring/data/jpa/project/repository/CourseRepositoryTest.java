package com.madiha.spring.data.jpa.project.repository;

import com.madiha.spring.data.jpa.project.entity.Course;
import com.madiha.spring.data.jpa.project.entity.Student;
import com.madiha.spring.data.jpa.project.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses =
                courseRepository.findAll();
        System.out.println("courses ="+courses);
    }
    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Shakera")
                .lastName("Begum")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
    @Test
    public void findAllPagination(){
         org.springframework.data.domain.Pageable firstPageWithThreeRecords =
                PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1,2);
        List<Course> courses =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getContent();

        long totalElements =
                courseRepository.findAll(secondPageWithTwoRecords)
                                .getTotalElements();

        long totalPages =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getTotalPages();

        System.out.println("Total Elements = "+totalElements);
        System.out.println("Total Pages = "+totalPages);
        System.out.println("Courses = "+courses);
    }
    @Test
    public void findAllSorting() {
        Pageable sortByTitle =
                PageRequest.of(0,
                        3,
                        Sort.by("title")
                );
        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );
        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credit"))
                );
        List<Course> courses =
                courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses ="+courses);
    }
    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);
        List<Course> courses =
                courseRepository.findByTitleContaining(
                        "D",
                        firstPageTenRecords).getContent();
        System.out.println("courses ="+courses);
    }
    @Test
    public void saveCourseWithStudentTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Shaheda")
                .lastName("Begum")
                .build();

        Course course = Course.builder()
                .title("ML")
                .credit(7)
                .teacher(teacher)
                .build();
        Student student = Student.builder()
                .firstName("Farooq")
                .lastName("Basha")
                .emailId("farooq@gmail.com")
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}