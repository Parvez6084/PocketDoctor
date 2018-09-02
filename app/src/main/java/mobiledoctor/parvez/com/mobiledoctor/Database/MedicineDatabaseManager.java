package mobiledoctor.parvez.com.mobiledoctor.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import mobiledoctor.parvez.com.mobiledoctor.MedisineClass.MedisinePojoclass;

public class MedicineDatabaseManager {

    private MedicineDatabaseHelper medicineDatabaseHelper;
    private SQLiteDatabase sqLiteDatabase;

    public MedicineDatabaseManager(Context context) {
        medicineDatabaseHelper = new MedicineDatabaseHelper(context)

        ;
    }


    public boolean insertData(MedisinePojoclass medisinePojoclass){

        sqLiteDatabase = medicineDatabaseHelper.getWritableDatabase();

        ContentValues contentValues =new ContentValues();
      //  contentValues.put(MedicineDatabaseHelper.KEY_IMAGE,medisinePojoclass.getImage());
        contentValues.put(MedicineDatabaseHelper.KEY_DOCTOR_NAME,medisinePojoclass.getDoctorName());
        contentValues.put(MedicineDatabaseHelper.KEY_DETAILS,medisinePojoclass.getDetails());
        contentValues.put(MedicineDatabaseHelper.KEY_VISIT_DATE,medisinePojoclass.getVisitDate());

       long value = sqLiteDatabase.insert(MedicineDatabaseHelper.TABLE_NAME,null,contentValues);

       sqLiteDatabase.close();
       if (value > 0 ){
           return true;
       }
       else {
           return false;
       }

    }



    public ArrayList<MedisinePojoclass>medisine_view(){

        ArrayList<MedisinePojoclass>medisine_list = new ArrayList<>();
        sqLiteDatabase = medicineDatabaseHelper.getReadableDatabase();
        String query = " SELECT * FROM " + MedicineDatabaseHelper.TABLE_NAME;

        Cursor cursor =sqLiteDatabase.rawQuery(query,null);

        if (cursor.moveToFirst()){

            do {

                int id = cursor.getInt(cursor.getColumnIndex(MedicineDatabaseHelper.KEY_ID));
              //  String dimage= cursor.getString(cursor.getColumnIndex(MedicineDatabaseHelper.KEY_IMAGE));
               String dName= cursor.getString(cursor.getColumnIndex(MedicineDatabaseHelper.KEY_DOCTOR_NAME));
               String details = cursor.getString(cursor.getColumnIndex(MedicineDatabaseHelper.KEY_DETAILS));
               String visiteDate = cursor.getString(cursor.getColumnIndex(MedicineDatabaseHelper.KEY_VISIT_DATE));

               MedisinePojoclass medisinePojoclass = new MedisinePojoclass(id,dName,details,visiteDate);
               medisine_list.add(medisinePojoclass);

            }
            while (cursor.moveToNext());
            sqLiteDatabase.close();
        }
        return medisine_list;

    }

    public MedisinePojoclass getMedicineById(int id){

        sqLiteDatabase = medicineDatabaseHelper.getReadableDatabase();
        MedisinePojoclass medisinePojoclass = null;
        Cursor cursor = sqLiteDatabase.query(MedicineDatabaseHelper.TABLE_NAME,
                null,MedicineDatabaseHelper.KEY_ID+"="+id,null,null,null,null);
        if(cursor != null || cursor.getCount() > 0){
            cursor.moveToFirst();
            int eid = cursor.getInt(cursor.getColumnIndex(MedicineDatabaseHelper.KEY_ID));
            //  String dimage= cursor.getString(cursor.getColumnIndex(MedicineDatabaseHelper.KEY_IMAGE));
            String dName= cursor.getString(cursor.getColumnIndex(MedicineDatabaseHelper.KEY_DOCTOR_NAME));
            String details = cursor.getString(cursor.getColumnIndex(MedicineDatabaseHelper.KEY_DETAILS));
            String visiteDate = cursor.getString(cursor.getColumnIndex(MedicineDatabaseHelper.KEY_VISIT_DATE));

             medisinePojoclass = new MedisinePojoclass(id,dName,details,visiteDate);

        }
        medicineDatabaseHelper.close();
        return medisinePojoclass;
    }

}
