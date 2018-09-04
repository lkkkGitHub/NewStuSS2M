package lk.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
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
        DefaultAcsClient client = PlayVideo.getDefaultAcsClient();
        GetPlayInfoResponse response;
//        GetVideoPlayAuthResponse responsePlay;
        try {
//            //获取播放凭证
//            GetVideoPlayAuthRequest requestPlay = new GetVideoPlayAuthRequest();
//            requestPlay.setVideoId("视频ID");
//            responsePlay = client.getAcsResponse(requestPlay);
//            //播放凭证
//            System.out.print("PlayAuth = " + responsePlay.getPlayAuth() + "\n");
//            //VideoMeta信息
//            System.out.print("VideoMeta.Title = " + responsePlay.getVideoMeta().getTitle() + "\n");

            //获取播放地址
            GetPlayInfoRequest request = new GetPlayInfoRequest();
            request.setVideoId(course.getVideoId());
            response = client.getAcsResponse(request);
            List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
            //播放地址
            requestMap.put("videoUrl", playInfoList.get(0).getPlayURL());
            //Base信息
//            System.out.print("VideoBase.Title = " + response.getVideoBase().getTitle() + "\n");
            return Action.SUCCESS;
        } catch (Exception e) {
            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
            return Action.INPUT;
        }
//        System.out.print("RequestId = " + response.getRequestId() + "\n");
    }
}
