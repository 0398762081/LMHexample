package vn.molu.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
        private static final SessionFactory sessionFactory;
        static {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new ExceptionInInitializerError(ex);
            }
        }
////    @Autowired
//    private static final SessionFactory sessionFactory;
//    static {
//        sessionFactory = new Configuration().configure().buildSessionFactory();
//    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
