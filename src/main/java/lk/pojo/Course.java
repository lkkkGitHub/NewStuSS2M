package lk.pojo;


import java.io.File;

public class Course {

    private Integer id;
    private String courseName;
    private String courseDesc;
    private String courseImg;
    private String courseTeacher;
    private String courseType;
    private Integer secondId;
    private String videoId;

    public Course() {
    }

    public Course(Integer id, String courseName, String courseDesc,
                  String courseImg, String courseTeacher, String courseType, Integer secondId,
                  String videoId) {
        this.id = id;
        this.courseName = courseName;
        this.courseDesc = courseDesc;
        this.courseImg = courseImg;
        this.courseTeacher = courseTeacher;
        this.courseType = courseType;
        this.secondId = secondId;
        this.videoId = videoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


    public String getCourseImg() {
        return courseImg;
    }

    public void setCourseImg(String courseImg) {
        this.courseImg = courseImg;
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

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", courseDesc='" + courseDesc + '\'' +
                ", courseImg='" + courseImg + '\'' +
                ", courseTeacher='" + courseTeacher + '\'' +
                ", courseType='" + courseType + '\'' +
                ", secondId=" + secondId +
                '}';
    }
}
