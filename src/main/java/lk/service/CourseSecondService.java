package lk.service;

import lk.pojo.CourseSecond;
import org.omg.CORBA.INTERNAL;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import lk.mapper.CourseSecondDao;

import java.util.List;

@Service
public class CourseSecondService {

    @Resource
    private CourseSecondDao courseSecondDao;

    /**
     * 查询所有二级目录信息
     * @return
     */
    public List<CourseSecond> findAll() {
        return courseSecondDao.findAll();
    }

    public int deleteByList(List<Integer> list) {
        return courseSecondDao.deleteByList(list);
    }
}
