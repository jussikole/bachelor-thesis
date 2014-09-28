package io.db;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.ImprovedNamingStrategy;

import sport.item.Country;
import sport.item.Game;
import sport.item.League;
import sport.item.Season;
import sport.item.Team;

public class HibernateUtil {
	
	
	private static final Logger log = Logger.getLogger(HibernateUtil.class);
    
	private static final SessionFactory sessionFactory;
	private static Session session = null;
	private static Transaction transaction = null;

	private static final Logger logger = Logger.getLogger(HibernateUtil.class);
	private static int holdLevel = 0;

	    
    static {
        try {
            sessionFactory = getSessionFactory();
        } catch (Throwable ex) {
            logger.fatal("Could not initialize Hibernate");
            throw new ExceptionInInitializerError(ex);
        }
    }
    

    public static void startSession() {
    	session = sessionFactory.openSession();
    }
    
    public static void closeSession() {
    	session.close();
    	session = null;
    }
    
    public static void begin() {
    	if (transaction == null) {
    		transaction = session.beginTransaction();
    	}
    	else {
    		holdLevel++;
    	}
    }
    
    public static void commit(boolean success) {
    	if (holdLevel > 0) {
    		log.info("Holding...");
    		holdLevel--;
    	}
    	else {
    		if (success) {
    			log.info("Commiting");
    			transaction.commit();	
    		}
    		else {
    			log.info("Rollbacking");
    			transaction.rollback();
    		}
    		transaction = null;
    	}
    }
   
    public static Query createQuery(String hql) {
    	return session.createQuery(hql);
    }
    
    public static void save(Object o) {
    	session.save(o);
    }
    
    
    
    
    private static SessionFactory getSessionFactory() {
        Configuration configuration = new AnnotationConfiguration()
        .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
        .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
        .setProperty("hibernate.connection.url", "jdbc:mysql://localhost/betting")
        .setProperty("hibernate.connection.username", "root")
        .setProperty("hibernate.connection.password", "jyrki")
//	        .setProperty("hibernate.hbm2ddl.auto", "validate")
//        .setProperty("hibernate.hbm2ddl.auto", "create-drop")
        .setProperty("hibernate.show_sql", "true")
        .setProperty("hibernate.c3p0.acquire_increment", "1")
        .setProperty("hibernate.c3p0.idle_test_period", "15")
        .setProperty("hibernate.c3p0.max_size", "100")
        .setProperty("hibernate.c3p0.max_statements", "0")
        .setProperty("hibernate.c3p0.min_size", "10")
        .setProperty("hibernate.c3p0.timeout", "10")
        .setProperty("hibernate.current_session_context_class", "thread")
        .setNamingStrategy(ImprovedNamingStrategy.INSTANCE)
        .addAnnotatedClass(Country.class)
        .addAnnotatedClass(League.class)
        .addAnnotatedClass(Season.class)
        .addAnnotatedClass(Team.class)
        .addAnnotatedClass(Game.class)
        ;
        
        return configuration.buildSessionFactory();
    }

	
}