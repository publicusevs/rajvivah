package com.example.rajvivah;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.rajvivah.modal.Userresponse;

import java.util.List;

public class ProfileFragment extends Fragment {
   List<Userresponse> profileList;
    TextView dobTextView;
    Button dobBtn;
    TextView birthTime;
    Button birthtime_button, btn_edit_profile;
    String names,regid;
    int day, month, year, hour, minute;
    int myday, myMonth, myYear, myHour, myMinute;
    private Button save;
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ImageView addBiodata = view.findViewById(R.id.btnAddBiodata);
        ImageView btnLogOut = view.findViewById(R.id.btnLogOut);
        Button btn_edit_profile = view.findViewById(R.id.btn_edit_profile);
        addBiodata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BiodataregistrationActivity.class);
                startActivity(intent);
            }
        });

        btn_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ActivityEditProfile.class);
                startActivity(intent);

            }
        });


        //Button for logut from profile screen
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences mPrefs = ProfileFragment.this.getActivity().getSharedPreferences("IDvalue", MODE_PRIVATE);
                mPrefs.edit().clear().commit();
                names = mPrefs.getString("name", "");
                regid = mPrefs.getString("regis", "");
                Intent i = new Intent(ProfileFragment.this.getContext(), LoginActivity.class);
                startActivity(i);
                //Toast.makeText(ProfileFragment.this.getContext(), "Logout clicked :-  " , Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }


}