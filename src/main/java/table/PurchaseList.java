package table;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "PurchaseList")
public class PurchaseList {

  @Id
  @Column(name = "student_name")
  private String studentName;

  @Column(name = "course_name")
  private String courseName;

  private Integer price;

  @Column(name = "subscription_date")
  private Date subscriptionDate;


  public PurchaseList() {
  }

  public PurchaseList(String studentName, String courseName, Integer price,
      Date subscriptionDate) {
    this.studentName = studentName;
    this.courseName = courseName;
    this.price = price;
    this.subscriptionDate = subscriptionDate;
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

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Date getSubscriptionDate() {
    return subscriptionDate;
  }

  public void setSubscriptionDate(Date subscriptionDate) {
    this.subscriptionDate = subscriptionDate;
  }
}
