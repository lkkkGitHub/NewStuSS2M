package lk.pojo;


import java.util.List;

public class CourseSecond {

    private Integer id;
    private String name;
    private Integer firstId;

    private List<Course> courseList;

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFirstId() {
        return firstId;
    }

    public void setFirstId(Integer firstId) {
        this.firstId = firstId;
    }

    @Override
    public String toString() {
        return "CourseSecond{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstId=" + firstId +
                '}';
    }
}
