package lk.mapper;

import lk.pojo.CourseSecond;

import java.util.List;


public interface CourseSecondDao {
    /**
     * 查询所有二级目录信息
     * @return
     */
    List<CourseSecond> findAll();

    /**
     * 根据一级目录id查询二级目录信息
     * @param id
     * @return
     */
    List<CourseSecond> findByFirstId(Integer id);

    /**
     * 删除多个二级目录
     * @param integers
     */
    int deleteByList(List<Integer> integers);
}
