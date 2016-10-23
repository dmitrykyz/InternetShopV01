package by.pvt.pool.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class DBResourceManager {
    private static final DBResourceManager instance = new DBResourceManager();

    private ResourceBundle bundle = ResourceBundle.getBundle("database/db", Locale.ENGLISH);

    public static DBResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key) {
        return bundle.getString(key);
    }

}
