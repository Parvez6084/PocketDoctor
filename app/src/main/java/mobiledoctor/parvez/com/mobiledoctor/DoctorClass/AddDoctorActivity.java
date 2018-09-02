package mobiledoctor.parvez.com.mobiledoctor.DoctorClass;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import mobiledoctor.parvez.com.mobiledoctor.Database.DatabaseManager;
import mobiledoctor.parvez.com.mobiledoctor.R;

public class AddDoctorActivity extends AppCompatActivity {



    private EditText etDoctorName,etDoctorEmail,etDoctorphoneNo,etDetails,etDate;
    private Button btnSave,btnReset,btnCalendar;
    private DatePickerDialog datePickerDialog ;
    private Calendar calendar;
    private DatabaseManager databaseManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor);

        initialization();

        databaseManager =new DatabaseManager(this);





        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance();
                datePickerDialog = new DatePickerDialog(AddDoctorActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        int current_month= month+1;
                        etDate.setText(dayOfMonth +" / "+current_month+" / "+year);
                    }
                },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();

            }
        });





        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String dName =  etDoctorName.getText().toString();
                String dEmail =  etDoctorEmail.getText().toString();
                String dPhoneNo = etDoctorphoneNo.getText().toString();
                String dDetails = etDetails.getText().toString();
                String dDate = etDate.getText().toString();
                DoctorPojoclass doctorPojoclass = new DoctorPojoclass(dName,dEmail,dPhoneNo,dDetails,dDate);

                boolean isValue = databaseManager.insertData(doctorPojoclass);

                if (isValue){

                    Toast.makeText(AddDoctorActivity.this, "Data insert Successful", Toast.LENGTH_SHORT).show();
                }





                etDoctorName.setText("");
                etDoctorEmail.setText("");
                etDoctorphoneNo.setText("");
                etDetails.setText("");
                etDate.setText("");

            }
        });


    }

    private void initialization (){

        etDoctorName = findViewById(R.id.et_DoctorName);
        etDoctorEmail = findViewById(R.id.et_DoctorEmail);
        etDoctorphoneNo = findViewById(R.id.et_DoctorPhone);
        etDate = findViewById(R.id.et_Appoint_Date);
        etDetails =findViewById(R.id.et_Details);
        btnSave = findViewById(R.id.btn_Save);
        btnReset = findViewById(R.id.btn_Reset);
        btnCalendar = findViewById(R.id.btn_calendar);
    }
}
