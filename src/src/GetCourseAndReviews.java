package src;

import entity.Course;
import entity.Instructor;
import entity.Review;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author abdel
 */
public class GetCourseAndReviews {
    public static void main(String[] args) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();
            
            int theId = 10;
            Course tempCourse = (Course) session.get(Course.class, theId);
            
            // print out the course 
            System.out.println(tempCourse);
            
            // print out the reviews
            System.out.println(tempCourse.getReviews());
            
            session.getTransaction().commit();
            System.out.println("Done.");
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }
}
