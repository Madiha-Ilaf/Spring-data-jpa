package com.madiha.spring.data.jpa.project.repository;

import com.madiha.spring.data.jpa.project.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
