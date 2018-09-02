package mobiledoctor.parvez.com.mobiledoctor.MedisineClass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import mobiledoctor.parvez.com.mobiledoctor.R;

public class MedicinViewActivity extends AppCompatActivity {

    TextView tvVisitDoctorName,tvVisitDetails,tvVisitDate;
    Button btnEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicin_view);

        tvVisitDoctorName =findViewById(R.id.tv_visiteDoctorName);
        tvVisitDetails=findViewById(R.id.tv_doctorDetails);
        tvVisitDate =findViewById(R.id.tv_doctordate);
        btnEdit=findViewById(R.id.btn_medisine_Edit);







       /* Intent intent = getIntent();
        MedisinePojoclass medisinePojoclass = new MedisinePojoclass(intent.getExtras("medisine"));
        tvVisitDoctorName.setText(medisinePojoclass.getDoctorName());
        tvVisitDetails.setText(medisinePojoclass.getDetails());
        tvVisitDate.setText(medisinePojoclass.getVisitDate()); */









    }
}
