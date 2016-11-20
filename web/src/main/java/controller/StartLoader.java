package controller;

import by.pvt.util.HibernateUtil;
import org.apache.log4j.Logger;

import java.util.Locale;

/**
 * Created by Dmitry on 11/19/2016.
 */
public class StartLoader {
    private static Logger log = Logger.getLogger(StartLoader.class);
    public static HibernateUtil util = null;

    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        util = HibernateUtil.getHibernateUtil();
        System.out.println("Start Menu");


    }
}
