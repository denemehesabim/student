package com.farukgenc.web.resources;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.farukgenc.domain.Student;
import com.farukgenc.web.controller.StudentController;

@Component
public class StudentResourceAssembler extends ResourceAssemblerSupport<Student, StudentResource> {

	public StudentResourceAssembler() {
		super(StudentController.class, StudentResource.class);
	}

	@Override
	public StudentResource toResource(Student student) {
		StudentResource resources = new StudentResource();
		resources.setNumber(student.getStudentNumber());
		resources.setName(student.getName());
		resources.setSurname(student.getSurname());
		resources.setAge(student.getAge());
		return resources;
	}

}
