package mobiledoctor.parvez.com.mobiledoctor.MedisineClass;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

import mobiledoctor.parvez.com.mobiledoctor.Database.MedicineDatabaseManager;
import mobiledoctor.parvez.com.mobiledoctor.R;

public class MadicineDocumentActivaty extends AppCompatActivity {

    private EditText etDoctoreName,etDetails,etDate;
    private ImageView imageView;
    private Button btnSave,btnTakePhoto,btnGellary,btnvisitDate;
    private Calendar calendar;
    private DatePickerDialog datePickerDialog;
    private static int TAKE_PHOTO_REQUEST =200;
    private static int GALLER_PHOTO_REQUEST =200;
    private MedicineDatabaseManager medicineDatabaseManager;
    private String mPhotoData;


    Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madicine_document_activaty);

        initialization ();

        medicineDatabaseManager = new MedicineDatabaseManager(this);

        btnvisitDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance();
                datePickerDialog = new DatePickerDialog(MadicineDocumentActivaty.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        int current_month= month+1;
                        etDate.setText(dayOfMonth +" / "+current_month+" / "+year);
                    }
                },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();

            }
        });





        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto();
            }
        });

        btnGellary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openGallery();
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String doctorName = etDoctoreName.getText().toString();
                String visitdate =  etDate.getText().toString();
                String details =  etDetails.getText().toString();

                MedisinePojoclass medisinePojoclass =new MedisinePojoclass(doctorName,visitdate,details);

               boolean isVelue = medicineDatabaseManager.insertData(medisinePojoclass);

               if (isVelue){

                   Toast.makeText(MadicineDocumentActivaty.this, "Data insert Successful", Toast.LENGTH_SHORT).show();
               }



               etDoctoreName.setText("");
               etDate.setText("");
               etDetails.setText("");


            }
        });

    }











    private void initialization (){

        imageView =findViewById(R.id.img_Madicine);
        etDoctoreName =findViewById(R.id.et_visitDoctorName);
        etDetails =findViewById(R.id.et_DocumentDetails);
        etDate =findViewById(R.id.et_visit_Date);
        btnSave=findViewById(R.id.btn_documentSave);
        btnGellary=findViewById(R.id.btm_Gallery);
        btnTakePhoto=findViewById(R.id.btm_TakePhoto);
        btnvisitDate=findViewById(R.id.btn_visitDate);



    }

    private void takePhoto(){

        Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePhotoIntent,TAKE_PHOTO_REQUEST);

    }

    private void openGallery(){

        Intent galleryIntent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent,GALLER_PHOTO_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == TAKE_PHOTO_REQUEST)
        {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            mPhotoData = encodeToBase64(bitmap,Bitmap.CompressFormat.JPEG,100);
            //------- Before Database
            Bitmap secondBitmap = decodeBase64(mPhotoData);
            //------- After Database
            imageView.setImageBitmap(secondBitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);




        if (resultCode == RESULT_OK && requestCode ==GALLER_PHOTO_REQUEST){
          imageUri = data.getData();
          imageView.setImageURI(imageUri);

        }


    }






    //------------------------
    public static String encodeToBase64(Bitmap image, Bitmap.CompressFormat compressFormat, int quality)
    {
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        image.compress(compressFormat, quality, byteArrayOS);
        return Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT);
    }

    public static Bitmap decodeBase64(String input)
    {
        byte[] decodedBytes = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }



}
