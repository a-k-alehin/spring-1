package ru.specialist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseRepository extends
    CrudRepository<Course, Integer>
    ,CourseRepositoryCustomized<Course>
{

    List<Course> findByLength(int length);

    @Query("SELECT c FROM Course c WHERE c.length <= :mLength") // JPQL
    List<Course> findShortCourses(@Param("mLength") int maxLength);

    @Modifying
    @Query("update Course c set c.length = :nLength where c.length = :oLength")
    int incrementLength(@Param("oLength") int oldLength,
            @Param("nLength") int newLength);

    @Query("SELECT c FROM Course c WHERE c.title LIKE :search") // JPQL
    List<Course> findByTitle(@Param("search") String title);

}

/*public interface CourseRepository extends
    CrudRepository<Course, Integer>
    //PagingAndSortingRepository<Course, Integer>
    ,CourseRepositoryCustomized<Course>
{
    List<Course> findAll();


    // Методы запросов из имени метода
    // префиксы find..By, read...By, query..By, count...By, get...By
    // Distinct, And, Or
    // Optional<Person> findByFirstNameAndLastName(String firstName, String lastName)

    //List<Course> findByLength(int length);





    // courses.length <= 24
    //@Query("SELECT c FROM Course c WHERE c.length <= 24") // JPQL
    //@Query(value = "SELECT * FROM Course c WHERE c.length <= 24",
    //            nativeQuery = true) // SQL

    // indexed params
    //@Query("SELECT c FROM Course c WHERE c.length <= ?1") // JPQL
    //List<Course> findShortCourses(@Param("mLength") int maxLength);



}*/



















//}
