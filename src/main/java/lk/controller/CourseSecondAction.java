package lk.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lk.pojo.Course;
import lk.pojo.CourseSecond;
import lk.service.CourseSecondService;
import lk.service.CourseService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

    public String createCourse() {
        //添加一门课程

        //取出文件名中的扩展名
        //找到最后一个“.”的位置，取出其后的字符串
        System.out.println(imgFile);
        int index = imgFileFileName.lastIndexOf('.');
        String fileExt = imgFileFileName.substring(index + 1);

        Course course = new Course(0, courseName, courseDesc, fileExt, courseTeacher, courseType, secondId);
        courseService.insertCourse(course);

        //处理上传的图像
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
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


//    public String deleteByList() {
//
//        return courseSecondService.deleteByList();
//    }
}
