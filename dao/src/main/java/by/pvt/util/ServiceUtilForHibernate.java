package by.pvt.util;

import org.apache.log4j.Logger;

/**
 * Created by Dmitry on 11/19/2016.
 */
public class ServiceUtilForHibernate {
    private static Logger log = Logger.getLogger(ServiceUtilForHibernate.class);
    private static volatile ServiceUtilForHibernate instance = null;
    private HibernateUtil hibernateUtilInService = null;

    private ServiceUtilForHibernate() {
    }

    public static synchronized ServiceUtilForHibernate getInstance(){
        if (instance == null){
            instance = new ServiceUtilForHibernate();
        }
        return instance;
    }

    public HibernateUtil getUtil() {
        return hibernateUtilInService;
    }

    public void setUtil(HibernateUtil util) {
        hibernateUtilInService = util;
    }
}
