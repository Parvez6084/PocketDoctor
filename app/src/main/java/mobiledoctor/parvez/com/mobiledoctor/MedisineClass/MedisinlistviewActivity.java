package mobiledoctor.parvez.com.mobiledoctor.MedisineClass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import mobiledoctor.parvez.com.mobiledoctor.Database.MedicineDatabaseManager;
import mobiledoctor.parvez.com.mobiledoctor.R;

public class MedisinlistviewActivity extends AppCompatActivity {

    ListView mlistView;
    private MedicineDatabaseManager medicineDatabaseManager;
    ArrayList<MedisinePojoclass> medisine_list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medisinlistview);
        mlistView = findViewById(R.id.medisine_item);
        medicineDatabaseManager = new MedicineDatabaseManager(this);



        medisine_list = medicineDatabaseManager.medisine_view();
        MedicineAdapter medicineAdapter = new MedicineAdapter(MedisinlistviewActivity.this,medisine_list);
        mlistView.setAdapter(medicineAdapter);


        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent =new Intent(MedisinlistviewActivity.this, MedicinViewActivity.class);
                intent.putExtra("medisine",mlistView.getItemAtPosition(position).toString());
                startActivity(intent);

            }
        });

    }
}
