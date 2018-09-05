package lk.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import lk.pojo.Course;
import lk.pojo.CourseFirst;
import lk.service.CourseFirstService;
import lk.tools.PlayVideo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author lk
 * 2018/8/28 16:53
 * @description:
 */
public class CourseFirstAction {

    private Map requestMap = (Map) ActionContext.getContext().get("request");

    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Autowired
    private CourseFirstService courseFirstService;

    /**
     * 查询所有一级目录，连级查询二级目录，以及二级目录下的course的具体信息
     *
     * @return
     */
    public String findAllFirstCtxSecond() {
        List<CourseFirst> list = courseFirstService.findAllFirstCtxSecond();
        requestMap.put("courseFirsts", list);
        return Action.SUCCESS;
    }

    public String playVideo() {
        Map requestMap = (Map) ActionContext.getContext().get("request");
        String url = PlayVideo.getUrl(course.getVideoId());
        if (url != null) {
            requestMap.put("videoUrl", url);
            return Action.SUCCESS;
        } else {
            return Action.INPUT;
        }
    }
}
