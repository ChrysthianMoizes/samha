package cgd.hibernate;

import java.io.File;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateConfig {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            File absoluto = new File("../src/cgd/hibernate/hibernate.cfg.xml");
            File netbeans = new File("src/cgd/hibernate/hibernate.cfg.xml");
            sessionFactory = new AnnotationConfiguration().configure(netbeans).buildSessionFactory();
            Session session = sessionFactory.openSession(); 
            Transaction tx = session.beginTransaction();
            tx.commit();
            session.close();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
