package mobiledoctor.parvez.com.mobiledoctor.userClass;

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

public class UserAdapter extends ArrayAdapter<UserPojoclass>{

    private List<UserPojoclass> userinfo =new ArrayList<>();
    private Context context;

    public UserAdapter(@NonNull Context context,  @NonNull List<UserPojoclass> userinfo) {
        super(context, R.layout.user_model, userinfo);
        this.context=context;
        this.userinfo=userinfo;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater =LayoutInflater.from(context);
        convertView =inflater.inflate(R.layout.user_model,parent,false);

        TextView mFullname = convertView.findViewById(R.id.mtv_Name);
        TextView mEmail = convertView.findViewById(R.id.mtv_Email);
        TextView mAge = convertView.findViewById(R.id.mtv_Age);
        TextView mPhone = convertView.findViewById(R.id.mtv_Phone);

        UserPojoclass pojoclass = userinfo.get(position);

        mFullname.setText(pojoclass.getFullName());
        mEmail.setText(pojoclass.getUserEmail());
        mPhone.setText(pojoclass.getUserPhoneNo());
        mAge.setText(String.valueOf(pojoclass.getAge()));






        return convertView;
    }
}
