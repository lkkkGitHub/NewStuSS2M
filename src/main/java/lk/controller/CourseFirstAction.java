package lk.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import lk.pojo.CourseFirst;
import lk.service.CourseFirstService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author lk
 * 2018/8/28 16:53
 * @description:
 */
public class CourseFirstAction {

    private Map request = (Map) ActionContext.getContext().get("request");

    @Autowired
    private CourseFirstService courseFirstService;

    /**
     * 查询所有一级目录，连级查询二级目录
     * @return
     */
    public String findAllFirstCtxSecond() {
        List<CourseFirst> list = courseFirstService.findAllFirstCtxSecond();
        request.put("courseFirsts", list);
        return Action.SUCCESS;
    }
}
