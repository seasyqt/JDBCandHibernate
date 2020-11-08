package table;

import javax.persistence.*;


@Entity(name = "LinkedPurchaseList")
@IdClass(SubscriptionId.class)
public class LinkedPurchaseList {

  @Id
  @Column(name = "course_id")
  private Course course;

  @Id
  @Column(name = "student_id")
  private Student student;

  @Column(name = "student_name")
  private String studentName;

  @Column(name = "course_name")
  private String courseName;

  public LinkedPurchaseList() {
  }

  public LinkedPurchaseList(String studentName, String courseName) {
    this.studentName = studentName;
    this.courseName = courseName;
  }


  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }
}
