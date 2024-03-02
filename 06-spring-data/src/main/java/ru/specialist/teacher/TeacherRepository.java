package ru.specialist.teacher;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface TeacherRepository extends CrudRepository<Teacher, Integer>{

    List<Teacher> findByAddr(String addr);

    //@Query("SELECT * FROM teachers t WHERE t.addr like :addr", nativeQuery=true) // SQL
    //List<Teacher> findByAddr_(@Param("addr") String addr);

}
