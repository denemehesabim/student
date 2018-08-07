package com.farukgenc.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farukgenc.service.LessonService;
import com.farukgenc.web.resources.LessonResource;
import com.farukgenc.web.resources.LessonResourceAssembler;

@RestController
@RequestMapping("/lesson")
public class LessonController {

	private LessonService lessonService;
	private LessonResourceAssembler lessonResourceAssembler;

	public LessonController(LessonService lessonService, LessonResourceAssembler lessonResourceAssembler) {
		this.lessonResourceAssembler = lessonResourceAssembler;
		this.lessonService = lessonService;
	}
	
	@PostMapping
	public ResponseEntity<LessonResource> create(@RequestBody LessonResource lessonResource) {
		return ResponseEntity.ok().body(lessonResourceAssembler.toResource(lessonService.create(lessonResource)));
	}
}
