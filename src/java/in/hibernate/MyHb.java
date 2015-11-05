
package in.hibernate;

import java.text.SimpleDateFormat;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Darshan
 */
public class MyHb {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static java.util.Date parseDate(String str,String patt){
        SimpleDateFormat sdf=new SimpleDateFormat(patt);
        try {
            return sdf.parse(str);
        } catch (Exception e) {
            return null;
        }
    }
    public static java.util.Date toDate(String str){
        java.util.Date dt = parseDate(str,"dd-MMMM-yyyy");
        if(dt!=null) return dt;
        
        dt = parseDate(str,"d-MMMM-yyyy");
        if(dt!=null) return dt;
        
        dt = parseDate(str,"dd-MMM-yyyy");
        if(dt!=null) return dt;
        
        dt = parseDate(str,"dd/MM/yyyy");
        if(dt!=null) return dt;
        
        dt = parseDate(str,"dd-MM-yyyy");
        if(dt!=null) return dt;
        
        dt = parseDate(str,"dd/MMMM/yyyy");
        if(dt!=null) return dt;
        return null;
    }
}
