package ru.specialist.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


@Repository
public class JdbcCourseDAO implements CourseDAO {

    private static final String SQL_SELECT_COURSE = "SELECT id, title, length, description FROM courses";

    private static final String SQL_SELECT_COURSE_BY_ID = SQL_SELECT_COURSE + " WHERE id = ?";

    private static final String SQL_SELECT_COURSE_BY_TITLE = SQL_SELECT_COURSE + " WHERE title LIKE ?";

    private static final String SQL_DELETE_COURSE_BY_ID = "DELETE FROM courses WHERE id = ?";

    private static final String SQL_INSERT_COURSE = "INSERT INTO courses (title, length, description) VALUES (?, ?, ?)";

    private static final String SQL_UPDATE_COURSE = "UPDATE courses SET title = ?, length = ?, description = ? WHERE id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RowMapper<Course> courseRowMapper;

    // public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    //     this.jdbcTemplate = jdbcTemplate;
    // }

    @Override
    public Course findById(int id) {
        Course course = jdbcTemplate.queryForObject(
            SQL_SELECT_COURSE_BY_ID,
            courseRowMapper,
            id);
        System.out.println(courseRowMapper);
        return course;
    }

    @Override
    public List<Course> findAll() {

        // manual map rows -> objects
        /*
         * List<Map<String, Object>> rows =
         * getJdbcTemplate().queryForList(SQL_SELECT_COURSE);
         *
         * List<Course> courses = new ArrayList<Course>();
         * for(Map<String, Object>row : rows) {
         * Course c = new Course();
         * c.setId( (int)row.get("id") );
         * c.setTitle( (String)row.get("title") );
         * c.setLength( (int)row.get("length") );
         * c.setDescription( (String)row.get("description") );
         * courses.add(c);
         * }
         */

        List<Course> courses = jdbcTemplate.query(
            SQL_SELECT_COURSE,
            new BeanPropertyRowMapper<Course>(Course.class));
        return courses;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public List<Course> findByTitle(String title) {
        return jdbcTemplate.query(
            SQL_SELECT_COURSE_BY_TITLE,
            new BeanPropertyRowMapper(Course.class),
            "%" + title + "%");
    }

    @Override
    public void insert(Course course) {
        PreparedStatementCreatorFactory f = new PreparedStatementCreatorFactory(SQL_INSERT_COURSE,
                Types.NVARCHAR, Types.INTEGER, Types.NVARCHAR);

        f.setGeneratedKeysColumnNames("id");
        KeyHolder kh = new GeneratedKeyHolder();

        jdbcTemplate.update(
                f.newPreparedStatementCreator(new Object[] {
                        course.getTitle(), course.getLength(), course.getDescription() }),
                kh);

        course.setId(kh.getKey().intValue());

    }

    @Override
    public void update(Course course) {
        jdbcTemplate.update(SQL_UPDATE_COURSE,
                course.getTitle(), course.getLength(),
                course.getDescription(), course.getId());

    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(SQL_DELETE_COURSE_BY_ID, id);
    }

}
