package habibellah.ayata.elmahirofquran.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbOperator {

    private SQLiteDatabase access;
    private final SQLiteOpenHelper db;
    private static DbOperator instance;

    private DbOperator(Context context)
    {
        this.db = new DB(context);
    }

    //this function to implement singleton design pattern
    public static DbOperator getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new DbOperator(context);
        }
        return instance;
    }

    //two function of open and close data base
    public void open()
    {
        this.access = this.db.getWritableDatabase();
    }
    public void close()
    {
        if(this.access !=null)
        {
            this.access.close();
        }
    }


    public void getStudent()
    {

    }




}
