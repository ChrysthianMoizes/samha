package cgd.hibernate;

import java.io.File;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

public class HibernateConfig {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            //File absoluto = new File("../src/cgd/hibernate/hibernate.cfg.xml");
            File netbeans = new File("src/cgd/hibernate/hibernate.cfg.xml");
            //File funciona = new File("C:\\Users\\chrys\\Desktop\\Projetos\\SAMHA\\src\\cgd\\hibernate\\hibernate.cfg.xml");
            //String pastaRaiz = System.getProperty("user.dir");
            sessionFactory = new AnnotationConfiguration().configure(netbeans).buildSessionFactory();
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
