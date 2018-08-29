package lk.mapper;

import lk.pojo.CourseFirst;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tools.SpringTest;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lk
 * 2018/8/28 16:42
 * @description:
 */
public class CourseFirstDaoTest extends SpringTest {

    @Autowired
    CourseFirstDao courseFirstDao;

    @Test
    public void findAllFirstCtxSecond() {
       List<CourseFirst> list = courseFirstDao.findAllFirstCtxSecond();
    }
}