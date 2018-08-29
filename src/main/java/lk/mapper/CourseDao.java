package lk.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import lk.pojo.Course;


public interface CourseDao {
    /**
     * 根据二级目录id查询二级目录下所有课程的信息
     * @param firstId
     * @return
     */
    List<Course> findCourseById(Integer firstId);

    /**
     * 插入课程具体信息
     * @param course
     * @return
     */
    int insertCourse(Course course);
}
