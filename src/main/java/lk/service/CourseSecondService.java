package lk.service;

import lk.pojo.CourseSecond;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import lk.mapper.CourseSecondDao;

import java.util.List;

@Service
public class CourseSecondService {

    @Resource
    private CourseSecondDao courseSecondDao;

    public List<CourseSecond> findAll() {
        return courseSecondDao.findAll();
    }

}
