package mobiledoctor.parvez.com.mobiledoctor.MedisineClass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import mobiledoctor.parvez.com.mobiledoctor.Database.MedicineDatabaseManager;
import mobiledoctor.parvez.com.mobiledoctor.R;

public class MedicinViewActivity extends AppCompatActivity {

    TextView tvVisitDoctorName,tvVisitDetails,tvVisitDate;
    Button btnEdit;
    private MedicineDatabaseManager medicineDatabaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicin_view);


        int  pesId= getIntent().getIntExtra("id",0);
        Toast.makeText(this, String.valueOf(pesId), Toast.LENGTH_SHORT).show();

        medicineDatabaseManager = new MedicineDatabaseManager(this);


        MedisinePojoclass medisinePojoclass = medicineDatabaseManager.getMedicineById(pesId);



        tvVisitDoctorName =findViewById(R.id.tv_visiteDoctorName);
        tvVisitDetails=findViewById(R.id.tv_doctorDetails);
        tvVisitDate =findViewById(R.id.tv_doctordate);
        btnEdit=findViewById(R.id.btn_medisine_Edit);


        tvVisitDoctorName.setText(medisinePojoclass.getDoctorName());
        tvVisitDetails.setText(medisinePojoclass.getDetails());
       tvVisitDate.setText(medisinePojoclass.getVisitDate());






       /* Intent intent = getIntent();
        MedisinePojoclass medisinePojoclass = new MedisinePojoclass(intent.getExtras("medisine"));
        tvVisitDoctorName.setText(medisinePojoclass.getDoctorName());
        tvVisitDetails.setText(medisinePojoclass.getDetails());
        tvVisitDate.setText(medisinePojoclass.getVisitDate()); */









    }
}
