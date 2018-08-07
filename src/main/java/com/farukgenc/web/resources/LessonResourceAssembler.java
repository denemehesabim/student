package com.farukgenc.web.resources;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.farukgenc.domain.Lesson;
import com.farukgenc.web.controller.LessonController;
@Component
public class LessonResourceAssembler extends ResourceAssemblerSupport<Lesson, LessonResource> {

	public LessonResourceAssembler() {
		super(LessonController.class, LessonResource.class);
	}

	@Override
	public LessonResource toResource(Lesson lesson) {
		LessonResource resources = new LessonResource();
		resources.setLessonId(lesson.getId());
		resources.setName(lesson.getName());
		return resources;
	}
	
}
