package lk.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import lk.pojo.Course;
import lk.mapper.CourseDao;

@Service
public class CourseService{

    @Resource
    private CourseDao courseDao;

    /**
     * 插入课程信息
     * @param course
     * @return
     */
    public int insertCourse(Course course) {
        return courseDao.insertCourse(course);
    }

}
