package lk.pojo;


import java.util.List;

public class CourseFirst {

    private Integer id;
    private String name;

    private List<CourseSecond> secondList;

    public List<CourseSecond> getSecondList() {
        return secondList;
    }

    public void setSecondList(List<CourseSecond> secondList) {
        this.secondList = secondList;
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

    @Override
    public String toString() {
        return "CourseFirst{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondList=" + secondList +
                '}';
    }
}
