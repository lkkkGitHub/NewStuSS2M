package lk.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tools.SpringTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lk
 * 2018/8/28 19:00
 * @description:
 */
public class CourseSecondDaoTest extends SpringTest {

    @Autowired
    CourseSecondDao courseSecondDao;

    @Test
    public void deleteByList() {
        List<Integer> list = new ArrayList<>();
        list.add(109);
        list.add(110);
        list.add(111);
        System.out.println(courseSecondDao.deleteByList(list));
    }
}