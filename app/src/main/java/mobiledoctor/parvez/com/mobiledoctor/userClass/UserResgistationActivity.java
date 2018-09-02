package mobiledoctor.parvez.com.mobiledoctor.userClass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import mobiledoctor.parvez.com.mobiledoctor.R;
import mobiledoctor.parvez.com.mobiledoctor.TempData;

public class UserResgistationActivity extends AppCompatActivity {

    private EditText etFullname,etUserEmail,etUserPassword,etUserPhoneNo;
    private Button btnRegistation,btnReset;
    private RadioGroup rgGander;
    private SeekBar skAge;
    private TextView tvAge;
    private int mAge;
    private String mGander;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_resgistation);

        initialization();

        rgGander.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rbMale = findViewById(checkedId);
                mGander = rbMale.getText().toString();
                Toast.makeText(UserResgistationActivity.this, mGander, Toast.LENGTH_SHORT).show();
            }
        });


        skAge.setMax(100);
        skAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

              mAge = progress;
              tvAge.setText(Integer.toString(mAge));


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        btnRegistation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mName = etFullname.getText().toString();
                String mEmail = etUserEmail.getText().toString();
                String mPassword = etUserPassword.getText().toString();
                String mPhoneNo = etUserPhoneNo.getText().toString();
                UserPojoclass pojoclass = new UserPojoclass(mName,mEmail,mPassword,mPhoneNo,mAge,mGander);
                TempData.usertempData.add(pojoclass);

                etFullname.setText("");
                etUserEmail.setText("");
                etUserPassword.setText("");
                etUserPhoneNo.setText("");

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etFullname.setText("");
                etUserEmail.setText("");
                etUserPassword.setText("");
                etUserPhoneNo.setText("");
                skAge.setMax(0);
            }
        });


    }

    private void initialization (){

        etFullname = findViewById(R.id.et_FullName);
        etUserEmail = findViewById(R.id.et_UserEmail);
        etUserPassword = findViewById(R.id.et_UserPassword);
        etUserPhoneNo = findViewById(R.id.et_UserPhone);
        rgGander = findViewById(R.id.rg_Gander_Group);
        skAge = findViewById(R.id.sikbar_Age);

        btnRegistation = findViewById(R.id.btm_registration);
        btnReset = findViewById(R.id.btm_Reset);


    }

}
