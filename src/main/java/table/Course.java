package table;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "Courses")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  private int duration;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "enum")
  private CourseType type;

  private String description;

  @ManyToOne(cascade = CascadeType.ALL)
  private Teacher teacher;

  @Column(name = "students_count")
  private Integer studentCount;

  private Integer price;

  @Column(name = "price_per_hour")
  private float pricePerHour;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "course_id")
  private Set<Subscription> subsCourse = new HashSet<>();

  public Course() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public CourseType getType() {
    return type;
  }

  public void setType(CourseType type) {
    this.type = type;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public Integer getStudentCount() {
    return studentCount;
  }

  public void setStudentCount(Integer studentCount) {
    this.studentCount = studentCount;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public float getPricePerHour() {
    return pricePerHour;
  }

  public void setPricePerHour(float pricePerHour) {
    this.pricePerHour = pricePerHour;
  }


  public Set<Subscription> getSubsCourse() {
    return subsCourse;
  }

  public void setSubsCourse(Set<Subscription> subscriptions) {
    this.subsCourse = subscriptions;
  }
}
