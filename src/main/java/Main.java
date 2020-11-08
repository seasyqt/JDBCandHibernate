import java.sql.*;
import java.util.List;
import org.hibernate.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;
import table.*;

public class Main {

  public static void main(String[] args) {

    StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure("hibernate.cfg.xml").build();

    Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
    SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

    Session session = sessionFactory.openSession();

    //Вывод данных,где ид = 1 из таблицы Courses
    List<Course> listCourse = session.createQuery("from Course where id = 1").getResultList();
    listCourse.forEach(line -> System.out.println(line.getName()));

    //Вывод данных,где ид = 1 из таблицы Students
    List<Student> listStudent = session.createQuery("from Student where id = 1").getResultList();
    listStudent.forEach(line -> System.out.println(line.getName()));

    //Вывод данных,где ид = 1 из таблицы Teachers
    List<Teacher> listTeacher = session.createQuery("from Teacher where id = 1").getResultList();
    listTeacher.forEach(line -> System.out.println(line.getName()));

    //Вывод данных, где course_id = 1 из таблицы Subscriptions
    List<Subscription> listSubs = session.createQuery("from Subscription where id.course = '1' ")
        .getResultList();
    listSubs.forEach(line -> System.out.println(line.getId().getStudent().getName()));

    List<PurchaseList> listPurchases = session.createQuery("from PurchaseList where price > 200000")
        .getResultList();
    listPurchases.forEach(line -> System.out.println(line.getCourseName()));

    session.beginTransaction();
    insert(session);
    session.getTransaction().commit();

    sessionFactory.close();
  }

  private void countCoursesBoughtInMonth() {
    try {
      String url = "jdbc:mysql://localhost:3306/skillbox?serverTimezone=UTC";
      String user = "root";
      String pass = "testtest";
      Connection connection = DriverManager.getConnection(url, user, pass);

      Statement statement = connection.createStatement();

      ResultSet resultSet = statement
          .executeQuery("select course_name,COUNT(1)/12 as middleCount_buyInMonth \n"
              + "from PurchaseList group by course_name order by course_name asc");

      while (resultSet.next()) {

        String countCourses = resultSet.getString("middleCount_buyInMonth");
        String courseName = resultSet.getString("course_name");

        System.out
            .printf("Курс %s в среднем покупают %s раз(а) в месяц \n", courseName, countCourses);
      }
      resultSet.close();
      statement.close();
      connection.close();

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  static private void insert(Session session) {
    int insert = session
        .createQuery("insert into LinkedPurchaseList (courseName,studentName,course,student) "
            + "select p.courseName,p.studentName,c,s from PurchaseList p,Course c ,Student s "
            + "where p.studentName = s.name and p.courseName = c.name").executeUpdate();
  }
}
