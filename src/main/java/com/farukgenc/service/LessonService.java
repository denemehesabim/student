package com.farukgenc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farukgenc.domain.Lesson;
import com.farukgenc.repository.LessonRepository;
import com.farukgenc.web.resources.LessonResource;

@Service
public class LessonService {
	
	private LessonRepository lessonRepository;
	
	@Autowired
	public LessonService(LessonRepository lessonRepository) {
		this.lessonRepository = lessonRepository;
	}

	@Transactional
	public Lesson create(LessonResource lessonResource) {
		Lesson lesson = new Lesson();
		lesson.setId(lessonResource.getLessonId());
		lesson.setName(lessonResource.getName());
		return lessonRepository.save(lesson);
	}
	
}
