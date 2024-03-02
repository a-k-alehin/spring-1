package ru.specialist.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

@Service("courseService")
// Business logic implementation
public class SpringJpaCourseService implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseRepository getCourseRepository() {
        return courseRepository;
    }

    @Override
    public void updateLength(int oldLength, int newLength) {
        getCourseRepository().incrementLength(oldLength, newLength);
    }



    public List<Course> findAll() {
        return Lists.newArrayList(courseRepository.findAll());
    }

    public Course save(Course c) {
        return courseRepository.save(c);
    }

    @Override
    public List<Course> findByTitle(String search) {
        return getCourseRepository().findByTitle("%"+search.trim()+"%");
    }


}