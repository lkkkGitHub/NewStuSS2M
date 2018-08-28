package lk.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import lk.pojo.CourseSecond;
import lk.service.CourseSecondService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author lk
 * 2018/8/28 14:26
 * @description:
 */
public class CourseSecondAction {

    private CourseSecond courseSecond;


    public CourseSecond getCourseSecond() {
        return courseSecond;
    }

    public void setCourseSecond(CourseSecond courseSecond) {
        this.courseSecond = courseSecond;
    }

    private Map request = (Map) ActionContext.getContext().get("request");

    @Autowired
    private CourseSecondService courseSecondService;

    public String findAll() {
        List<CourseSecond> list = courseSecondService.findAll();
        if (list.size() != 0) {
            request.put("seconds", list);
            return Action.SUCCESS;
        } else {
            request.put("messageSecond", "没有课程信息");
            return Action.SUCCESS;
        }
    }
}
