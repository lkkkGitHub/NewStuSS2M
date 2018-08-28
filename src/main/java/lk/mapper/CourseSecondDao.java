package lk.mapper;

import lk.pojo.CourseSecond;

import java.util.List;


public interface CourseSecondDao {
    /**
     * 查询所有二级目录信息
     * @return
     */
    List<CourseSecond> findAll();
}
