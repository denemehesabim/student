package com.farukgenc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farukgenc.domain.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
