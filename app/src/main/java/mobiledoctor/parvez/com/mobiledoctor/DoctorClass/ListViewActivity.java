package mobiledoctor.parvez.com.mobiledoctor.DoctorClass;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import mobiledoctor.parvez.com.mobiledoctor.Database.DatabaseHelper;
import mobiledoctor.parvez.com.mobiledoctor.Database.DatabaseManager;
import mobiledoctor.parvez.com.mobiledoctor.MedisineClass.MedicinViewActivity;
import mobiledoctor.parvez.com.mobiledoctor.MedisineClass.MedisinlistviewActivity;
import mobiledoctor.parvez.com.mobiledoctor.R;
import mobiledoctor.parvez.com.mobiledoctor.userClass.UserAdapter;

public class ListViewActivity extends AppCompatActivity {

    ListView mlistView;
    private UserAdapter userAdapter;
    private DoctorAdapter doctorAdapter;
    private SQLiteDatabase sqLiteDatabase;
    private DatabaseHelper databaseHelper;
    private DatabaseManager databaseManager;
    ArrayList<DoctorPojoclass> doctor_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__view);
        mlistView = findViewById(R.id.list_item);

        databaseManager =new DatabaseManager(this);

        doctor_list = databaseManager.doctor_view();
        DoctorAdapter doctorAdapter =new DoctorAdapter(ListViewActivity.this,doctor_list);
        mlistView.setAdapter(doctorAdapter);

        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent(ListViewActivity.this, DoctorProfileActivity.class);
                intent.putExtra("id",i+1);



                startActivity(intent);

            }
        });

    }
}
