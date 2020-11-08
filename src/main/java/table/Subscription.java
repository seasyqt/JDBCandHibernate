package table;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Subscriptions")
public class Subscription {

  @EmbeddedId
  private SubscriptionId id = new SubscriptionId();

  @Column(name = "subscription_date")
  protected Date subscriptionDate;


  public Subscription() {
  }


  public Date getSubscriptionDate() {
    return subscriptionDate;
  }

  public void setSubscriptionDate(Date subscriptionDate) {
    this.subscriptionDate = subscriptionDate;
  }

  public SubscriptionId getId() {
    return id;
  }

  public void setId(SubscriptionId id) {
    this.id = id;
  }

  @Transient
  public Student getStudent() {
    return getId().getStudent();
  }

  public void setStudent(Student student) {
    getId().setStudent(student);
  }

  @Transient
  public Course getCourse() {
    return getId().getCourse();
  }

  public void setCourse(Course course) {
    getId().setCourse(course);
  }

}
