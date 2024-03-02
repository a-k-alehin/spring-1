package ru.specialist.dbSpringData;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.specialist.dao.Course;
import ru.specialist.dao.CourseService;
import ru.specialist.dao.DaoConfig;
import ru.specialist.teacher.TeacherRepository;

public class App
{
    public static void main( String[] args )
    {
        //ClassPathXmlApplicationContext context =
        //        new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DaoConfig.class);

        CourseService courseService = context.getBean("courseService",
                CourseService.class);

        // courseService.updateLength(0, 0);

        for(Course c : courseService.findByTitle("web"))
            System.out.println(c);

        //for(Course c : courseService.findAll())
        //    System.out.println(c);

        TeacherRepository teacherRepository = context.getBean(TeacherRepository.class);

        long cnt = teacherRepository.count();
        System.out.println("teachers count="+cnt);

        context.close();
    }
}
