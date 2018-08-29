package lk.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import lk.pojo.CourseFirst;
import lk.mapper.CourseFirstDao;

@Service
public class CourseFirstService {

    @Resource
    private CourseFirstDao courseFirstDao;

    public List<CourseFirst> findAllFirstCtxSecond() {
        return courseFirstDao.findAllFirstCtxSecond();
    }
}
