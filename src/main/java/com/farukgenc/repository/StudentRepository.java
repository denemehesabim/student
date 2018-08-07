package com.farukgenc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.farukgenc.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByStudentNumber(Integer number);

	@Modifying
	void deleteByStudentNumber(Integer number);

}
