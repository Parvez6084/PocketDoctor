package mobiledoctor.parvez.com.mobiledoctor.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import mobiledoctor.parvez.com.mobiledoctor.DoctorClass.DoctorPojoclass;
import mobiledoctor.parvez.com.mobiledoctor.MedisineClass.MedisinePojoclass;

public class DatabaseManager {

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase sqLiteDatabase;

    public DatabaseManager(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public boolean insertData(DoctorPojoclass doctorPojoclass){

        sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.KEY_DOCTOR_NAME,doctorPojoclass.getDoctorName());
        contentValues.put(DatabaseHelper.KEY_DOCTOR_EMAIL,doctorPojoclass.getDoctorEmail());
        contentValues.put(DatabaseHelper.KEY_DOCTOR_PHONENO,doctorPojoclass.getDoctorPhoneNo());
        contentValues.put(DatabaseHelper.KEY_DOCTOR_DETAILS,doctorPojoclass.getDetails());
        contentValues.put(DatabaseHelper.KEY_APPOINMENT_DATE,doctorPojoclass.getAppointDate());

         long value = sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME,null,contentValues);

         sqLiteDatabase.close();
         if (value > 0){

             return true;
         }
         else {
             return false;
         }



    }


    public ArrayList<DoctorPojoclass> doctor_view(){


        ArrayList<DoctorPojoclass> doctor_List =new ArrayList<>();
        sqLiteDatabase=databaseHelper.getReadableDatabase();
        String query = " SELECT * FROM " + DatabaseHelper.TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if (cursor.moveToFirst()){

            do {

                String id =cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_ID));
                String dName =cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_DOCTOR_NAME));
                String dEmail =cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_DOCTOR_EMAIL));
                String dPhoneNo =cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_DOCTOR_PHONENO));
                String dDetails =cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_DOCTOR_DETAILS));
                String dAppointDate =cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_APPOINMENT_DATE));

                DoctorPojoclass doctorPojoclass = new DoctorPojoclass(id,dName,dEmail,dPhoneNo,dDetails,dAppointDate);
                doctor_List.add(doctorPojoclass);

            }while (cursor.moveToNext());

            sqLiteDatabase.close();

        }
        return doctor_List;

    }



    public boolean updateData(DoctorPojoclass doctorPojoclass){

        sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues =new ContentValues();

        contentValues.put(DatabaseHelper.KEY_DOCTOR_NAME,doctorPojoclass.getDoctorName());
        contentValues.put(DatabaseHelper.KEY_DOCTOR_EMAIL,doctorPojoclass.getDoctorEmail());
        contentValues.put(DatabaseHelper.KEY_DOCTOR_PHONENO,doctorPojoclass.getDoctorPhoneNo());
        contentValues.put(DatabaseHelper.KEY_DOCTOR_DETAILS,doctorPojoclass.getDetails());
        contentValues.put(DatabaseHelper.KEY_APPOINMENT_DATE,doctorPojoclass.getAppointDate());



        String whereClause = DatabaseHelper.KEY_ID + " = ?";
        String[] whereArgs = {doctorPojoclass.getId()};
        int isUpdated = sqLiteDatabase.update(DatabaseHelper.TABLE_NAME,contentValues,whereClause,whereArgs);

        sqLiteDatabase.close();
        if (isUpdated >0) {
            return true;
        }
        else {
            return false;
        }

    }



    /////////////////////////////
   /* public MedisinePojoclass getMedicineById(int id){

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
    }*/



}
