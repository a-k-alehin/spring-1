package ru.specialist.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

@Service("courseService")
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Transactional(readOnly=true) 
    public List<Course> findAll() {
        return Lists.newArrayList(courseRepository.findAll());
    }

    @Transactional(readOnly=true)
    public Course findById(int id) {
        return courseRepository.findOne(id);
    }


    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public void delete(int id) {
        courseRepository.delete(id);
    }



}