package ru.specialist.dbJDBC;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.specialist.dao.Course;
import ru.specialist.dao.CourseDAO;

public class App {

    public static void main(String[] args) {
        //ClassPathXmlApplicationContext context =
        //        new ClassPathXmlApplicationContext("applicationContext.xml");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DaoConfig.class);

        CourseDAO courseDao = context.getBean(CourseDAO.class);

        /*Course nc = new Course();
        nc.setTitle("Spring");
        nc.setLength(40);
        nc.setDescription("Spring framework");

        System.out.println(nc); // id == 0
        courseDao.insert(nc);
        System.out.println(nc); // id == ???*/

		System.out.println("findById");
        Course s = courseDao.findById(5);
		System.out.println(s);
        //s.setLength(42);
        //courseDao.update(s);

        //courseDao.delete(8);


		System.out.println("findByTitle");
        for(Course c : courseDao.findByTitle("web"))
            System.out.println(c);
		System.out.println("findAll");
        for(Course c : courseDao.findAll())
            System.out.println(c);


        //System.out.printf("Курс: %s\n", courseDao.findById(4));

        context.close();

    }

}
