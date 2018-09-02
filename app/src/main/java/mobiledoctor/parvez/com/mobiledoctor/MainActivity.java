package mobiledoctor.parvez.com.mobiledoctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import mobiledoctor.parvez.com.mobiledoctor.DoctorClass.AddDoctorActivity;
import mobiledoctor.parvez.com.mobiledoctor.DoctorClass.EditDoctorActivity;
import mobiledoctor.parvez.com.mobiledoctor.DoctorClass.ListViewActivity;
import mobiledoctor.parvez.com.mobiledoctor.MedisineClass.MadicineDocumentActivaty;
import mobiledoctor.parvez.com.mobiledoctor.MedisineClass.MedisinlistviewActivity;

public class MainActivity extends AppCompatActivity {


    private CardView cvAddDoctor,cvDoctorDetails,cvAddPrescription,cvPrescriptionDetails,cvProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cvAddDoctor =findViewById(R.id.cv_addDoctor);
        cvDoctorDetails=findViewById(R.id.cv_doctorDetails);
        cvAddPrescription =findViewById(R.id.cv_addPrescription);
        cvPrescriptionDetails=findViewById(R.id.cv_ViewPresciption);
        cvProfile=findViewById(R.id.cv_Profile);



        cvAddDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainActivity.this, AddDoctorActivity.class);
                startActivity(intent);

            }
        });

        cvDoctorDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });

        cvAddPrescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainActivity.this, MadicineDocumentActivaty.class);
                startActivity(intent);
            }
        });

        cvPrescriptionDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainActivity.this, MedisinlistviewActivity.class);
                startActivity(intent);

            }
        });

        cvProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainActivity.this, EditDoctorActivity.class);
                startActivity(intent);
            }
        });

    }



}
