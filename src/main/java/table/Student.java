package table;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "Students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  private int age;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "registration_date")
  private Date registrationDate;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "student_id")
  private Set<Subscription> subsStudent = new HashSet<>();

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

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Date getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(Date registrationDate) {
    this.registrationDate = registrationDate;
  }

  public Set<Subscription> getSubsStudent() {
    return subsStudent;
  }

  public void setSubsStudent(Set<Subscription> subsStudent) {
    this.subsStudent = subsStudent;
  }
}
