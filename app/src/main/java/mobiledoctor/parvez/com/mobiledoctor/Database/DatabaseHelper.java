package mobiledoctor.parvez.com.mobiledoctor.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "doctor.db";
    public static final String TABLE_NAME = "doctor_table";
    public static final int DATABASE_VERSION = 1;

    public static final String KEY_ID = "_id";
    public static final String KEY_DOCTOR_NAME = "doctor_name";
    public static final String KEY_DOCTOR_DETAILS = "doctor_details";
    public static final String KEY_DOCTOR_EMAIL= "doctor_email";
    public static final String KEY_DOCTOR_PHONENO = "doctor_phoneno";
    public static final String KEY_APPOINMENT_DATE = "appoinment_date";

    private static String CREATE_TABLE = " CREATE TABLE "+ TABLE_NAME +"("+ KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_DOCTOR_NAME +" TEXT,"+ KEY_DOCTOR_EMAIL +" TEXT,"
            + KEY_DOCTOR_PHONENO +" TEXT,"+ KEY_DOCTOR_DETAILS +" TEXT,"+KEY_APPOINMENT_DATE+" TEXT" +")";

    private Context context;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
        this.context=context;

    }


    @Override
    public void onCreate(SQLiteDatabase db) {



        try {
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context, "on create", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(context, "Exception", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    }



