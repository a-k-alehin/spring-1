package ru.specialist.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

// SUFFIX: Impl !!! (by default)
// className == Original_repository_interface_name + Impl
public class CourseRepositoryImpl implements CourseRepositoryCustomized<Course> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public int getCourseMaxLength() {return 40;}
    /*
    @Transactional
    @Override
    @Modifying
    public void delete(Course entity) {
        // custmozied opertaion instead CrudRepository
    }*/


}
