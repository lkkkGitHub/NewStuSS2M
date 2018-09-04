package lk.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lk.pojo.Course;
import lk.pojo.CourseSecond;
import lk.service.CourseSecondService;
import lk.service.CourseService;
import lk.tools.UploadVideoDemo;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
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

    @Autowired
    private CourseService courseService;

    /**
     * 查询所有的二级目录
     *
     * @return
     */
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

    public String admin() {
        return Action.SUCCESS;
    }

    private String courseName;
    private String courseDesc;
    private File imgFile; //所上传的图像文件
    private String imgFileFileName; //所上传文件的名字
    private String courseTeacher;
    private String courseType;
    private Integer secondId;
    private File videoFile;
    private String videoFileFileName;

    public String createCourse() {

        final String accessKeyId = "LTAIDYKSIXN9yPSZ";
        final String accessKeySecret = "yC9v1x1JpyghnGcc2YhzcmpwS3y45a";

        //取出文件名中的扩展名
        //找到最后一个“.”的位置，取出其后的字符串
        int index = imgFileFileName.lastIndexOf('.');
        String fileExt = imgFileFileName.substring(index + 1);

        //视频上传
        FileInputStream fileInputStream = null;

        //处理上传的图像
        FileOutputStream fos = null;
        FileInputStream fis = null;

        try {
            fileInputStream = new FileInputStream(videoFile);
            String videoId = UploadVideoDemo.testUploadStream(accessKeyId, accessKeySecret,
                    "test", videoFileFileName, fileInputStream);
            Course course = new Course(0, courseName, courseDesc, fileExt,
                    courseTeacher, courseType, secondId, videoId);
            courseService.insertCourse(course);

            //添加一门课程
            // 建立文件输出流
            String savePath = ServletActionContext.getServletContext()
                    .getRealPath("images/course/" + course.getId() + "." + course.getCourseImg());
            fos = new FileOutputStream(savePath);
            // 建立文件上传流
            fis = new FileInputStream(imgFile);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ActionSupport.SUCCESS;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public File getImgFile() {
        return imgFile;
    }

    public void setImgFile(File imgFile) {
        this.imgFile = imgFile;
    }

    public String getImgFileFileName() {
        return imgFileFileName;
    }

    public void setImgFileFileName(String imgFileFileName) {
        this.imgFileFileName = imgFileFileName;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public Integer getSecondId() {
        return secondId;
    }

    public void setSecondId(Integer secondId) {
        this.secondId = secondId;
    }

    public File getVideoFile() {
        return videoFile;
    }

    public void setVideoFile(File videoFile) {
        this.videoFile = videoFile;
    }

    public String getVideoFileFileName() {
        return videoFileFileName;
    }

    public void setVideoFileFileName(String videoFileFileName) {
        this.videoFileFileName = videoFileFileName;
    }

    //    public String deleteByList() {
//
//        return courseSecondService.deleteByList();
//    }
}
