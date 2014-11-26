package es.sanoguera.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created with IntelliJ IDEA.
 * User: fjfalcon
 * Date: 17.12.12
 * Time: 14:52
 * To change this template use File | Settings | File Templates.
 */
public class HibernateUtil {


    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    private static final ThreadLocal<Session> session = new ThreadLocal<Session>();


    public static Session getSession() {
        Session session = (Session) HibernateUtil.session.get();
        if (session == null) {
            session = getSessionFactory().openSession();
            HibernateUtil.session.set(session);
        }
        return session;
    }

    public static void close() {
        getSession().close();
        HibernateUtil.session.set(null);
    }

    protected void begin() {
        getSession().beginTransaction();
    }

    protected void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        try {
            getSession().close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        HibernateUtil.session.set(null);
    }

    protected void commit() {
        getSession().getTransaction().commit();
    }

    private static SessionFactory configureSessionFactory()
            throws HibernateException {
        Configuration configuration=new Configuration()
                .configure();

        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();


        serviceRegistryBuilder.applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null)
            sessionFactory = configureSessionFactory();
        return sessionFactory;

    }
}