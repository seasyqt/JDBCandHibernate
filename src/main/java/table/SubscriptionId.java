package table;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;


@Embeddable
public class SubscriptionId implements Serializable {

  @OneToOne(cascade = CascadeType.ALL)
  private Student student;

  @OneToOne(cascade = CascadeType.ALL)
  private Course course;

  public SubscriptionId() {
  }

  public SubscriptionId(Student student, Course course) {
    this.student = student;
    this.course = course;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student studentId) {
    this.student = studentId;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course courseId) {
    this.course = courseId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SubscriptionId)) {
      return false;
    }
    SubscriptionId that = (SubscriptionId) o;
    return getStudent().equals(that.getStudent()) &&
        getCourse().equals(that.getCourse());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getStudent(), getCourse());
  }
}
