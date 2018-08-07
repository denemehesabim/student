package com.farukgenc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farukgenc.domain.Student;
import com.farukgenc.exception.StudentNotFoundException;
import com.farukgenc.repository.StudentRepository;
import com.farukgenc.web.resources.StudentResource;
import com.farukgenc.web.resources.SuccessResource;

@Service
public class StudentService {

	private StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	/**
	 * 
	 * @param studentResource
	 * @return
	 */
	@Transactional
	public Student create(StudentResource studentResource) {
		Student student = new Student();
		student.setStudentNumber(studentResource.getNumber());
		student.setName(studentResource.getName());
		student.setSurname(studentResource.getSurname());
		student.setAge(studentResource.getAge());

		return studentRepository.save(student);
	}

	/**
	 * 
	 * @param number
	 * @return
	 * @throws StudentNotFoundException
	 */
	public Student getStudent(Integer number) throws StudentNotFoundException {
		Student tempStudent = studentRepository.findByStudentNumber(number);

		if (tempStudent != null) {
			return tempStudent;
		} else {
			throw new StudentNotFoundException("404", "sdfhasdfasdfasdfads");
		}
	}

	/**
	 * 
	 * @param studentResource
	 * @return
	 */
	public Student update(StudentResource studentResource) {
		Student student = studentRepository.findByStudentNumber(studentResource.getNumber());
		if (student != null) {
			student.setStudentNumber(studentResource.getNumber());
			student.setName(studentResource.getName());
			student.setSurname(studentResource.getSurname());
			student.setAge(studentResource.getAge());
			return studentRepository.save(student);
		} else {
			throw new StudentNotFoundException("404", "Student Not Found");
		}
	}

	/**
	 * 
	 * @param number
	 * @return
	 * @throws StudentNotFoundException
	 */
	@Transactional
	public SuccessResource delete(Integer number) throws StudentNotFoundException {
		Student student = studentRepository.findByStudentNumber(number);
		if (student != null) {
			studentRepository.delete(student);
			SuccessResource resource = new SuccessResource();
			resource.setStatusCode("204");
			resource.setDescription("Student is removed !");
			return resource;
		} else {
			throw new StudentNotFoundException("404", "Student Not Found");
		}

	}

}
