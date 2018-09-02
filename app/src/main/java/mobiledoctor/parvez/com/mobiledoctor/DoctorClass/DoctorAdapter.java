package mobiledoctor.parvez.com.mobiledoctor.DoctorClass;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mobiledoctor.parvez.com.mobiledoctor.R;

public class DoctorAdapter extends ArrayAdapter<DoctorPojoclass> {

    private List<DoctorPojoclass>doctorinfo =new ArrayList<>();
    private Context context;

    public DoctorAdapter(@NonNull Context context, @NonNull List<DoctorPojoclass>doctorinfo) {
        super(context, R.layout.doctor_model, doctorinfo);
        this.context=context;
        this.doctorinfo=doctorinfo;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView=layoutInflater.inflate(R.layout.doctor_model,parent,false);

        TextView doctorName =convertView.findViewById(R.id.dtv_doctorName);
        TextView doctorEmail =convertView.findViewById(R.id.tv_doctorEmail);
        TextView doctorDetails =convertView.findViewById(R.id.tv_doctorDetails);
        TextView doctorPhone =convertView.findViewById(R.id.tv_doctorPhone);
        TextView doctorAppointDate =convertView.findViewById(R.id.tv_doctordate);


        DoctorPojoclass doctorPojoclass = doctorinfo.get(position);

        doctorName.setText(doctorPojoclass.getDoctorName());
        doctorEmail.setText(doctorPojoclass.getDoctorEmail());
        doctorDetails.setText(doctorPojoclass.getDetails());
        doctorPhone.setText(doctorPojoclass.getDoctorPhoneNo());
        doctorAppointDate.setText(doctorPojoclass.getAppointDate());

        return convertView;
    }
}
