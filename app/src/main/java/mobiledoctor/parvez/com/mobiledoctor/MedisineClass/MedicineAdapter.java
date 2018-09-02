package mobiledoctor.parvez.com.mobiledoctor.MedisineClass;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mobiledoctor.parvez.com.mobiledoctor.R;

public class MedicineAdapter extends ArrayAdapter<MedisinePojoclass> {

    private List<MedisinePojoclass>medisine_List = new ArrayList<>();
    private Context context;
    public MedicineAdapter(@NonNull Context context, @NonNull List<MedisinePojoclass>medisine_List ) {
        super(context, R.layout.medicin_model, medisine_List);
        this.context = context;
        this.medisine_List = medisine_List;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.medicin_model,parent,false);

     //   ImageView mimage =convertView.findViewById(R.id.imgView);
        TextView doctorName =convertView.findViewById(R.id.tv_visiteDoctorName);
        TextView details =convertView.findViewById(R.id.tv_visiteDetails);
        TextView visitDate =convertView.findViewById(R.id.tv_visiteDate);

        MedisinePojoclass medisinePojoclass = medisine_List.get(position);

       // mimage.setImageResource(medisinePojoclass.getImage());
        doctorName.setText(medisinePojoclass.getDoctorName());
        details.setText(medisinePojoclass.getDetails());
        visitDate.setText(medisinePojoclass.getVisitDate());


        return convertView;
    }
}
