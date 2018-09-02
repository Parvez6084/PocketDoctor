package mobiledoctor.parvez.com.mobiledoctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mobiledoctor.parvez.com.mobiledoctor.Database.DatabaseHelper;
import mobiledoctor.parvez.com.mobiledoctor.userClass.UserResgistationActivity;

public class LogActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    private EditText etEmail,etPassword;
    private Button btnLogin,btnRegistation;
     private String mUserEmail,mUserPassword;
    String email ="a";
    String password ="0000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);


        etEmail = findViewById(R.id.et_UserEmail);
        etPassword = findViewById(R.id.et_UserPassword);
        btnLogin = findViewById(R.id.btm_LoginButton);
        btnRegistation = findViewById(R.id.btm_Registration);

         mUserEmail = etEmail.getText().toString();
         mUserPassword = etPassword.getText().toString();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(LogActivity.this,MainActivity.class);
                startActivity(intent);

                if (mUserEmail.isEmpty())
                {
                    etEmail.setError("Please Enter Your Username");
                }
                else if(mUserPassword.isEmpty())
                {
                    etPassword.setError("Please Enter Your Password");
                }
                else {

                      if (mUserEmail.equals(email) && mUserPassword.equals(password))
                        {

                            Toast.makeText(LogActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                            etEmail.setText("");
                            etPassword.setText("");
                        }
                        else {
                            Toast.makeText(LogActivity.this, "Login Unsuccessfully", Toast.LENGTH_SHORT).show();
                        }

                }



            }
        });

        btnRegistation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogActivity.this,UserResgistationActivity.class);
                startActivity(intent);
            }
        });




    }

}
