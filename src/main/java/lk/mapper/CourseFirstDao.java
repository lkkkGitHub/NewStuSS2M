package lk.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import lk.pojo.CourseFirst;


public interface CourseFirstDao {
    /**
     * 查询所有一级目录，以及连接查询二级目录
     * @return
     */
    List<CourseFirst> findAllFirstCtxSecond();
}
