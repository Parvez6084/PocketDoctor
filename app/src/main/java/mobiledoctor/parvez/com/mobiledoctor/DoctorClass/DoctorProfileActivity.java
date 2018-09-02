package mobiledoctor.parvez.com.mobiledoctor.DoctorClass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mobiledoctor.parvez.com.mobiledoctor.R;

public class DoctorProfileActivity extends AppCompatActivity {

    TextView tvdoctorName,tvdoctorEmail,tvdoctorPhoneNo,tvdoctorDetails,tvdoctorDate;
    Button btnEditProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);

        tvdoctorName =findViewById(R.id.tv_doctor_profile_name);
        tvdoctorEmail =findViewById(R.id.tv_doctor_profile_Email);
        tvdoctorPhoneNo =findViewById(R.id.tv_doctor_profile_Phone);
        tvdoctorDetails =findViewById(R.id.tv_doctor_profile_Details);
        tvdoctorDate =findViewById(R.id.tv_doctor_profile_date);
        btnEditProfile =findViewById(R.id.btn_Doctor_profile_Edit);



        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DoctorProfileActivity.this, EditDoctorActivity.class);
                startActivity(intent);
            }
        });



    }




}
