package com.farukgenc.web.resources;

import org.springframework.hateoas.ResourceSupport;

public class LessonResource extends ResourceSupport {

	private long lessonId;

	private String name;

	public long getLessonId() {
		return lessonId;
	}

	public void setLessonId(long lessonId) {
		this.lessonId = lessonId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}