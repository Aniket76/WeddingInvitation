package com.aniketvishal.weddingdemo1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginFragment extends Fragment implements View.OnClickListener{
    private AppCompatButton btn_login;

    @BindView(R.id.love)
    TextView love;
    @BindView(R.id.vishal)
    TextView vishal;
    @BindView(R.id.weds)
    TextView weds;
    @BindView(R.id.jiju)
    TextView jiju;

    Typeface typeface;

    private EditText et_email;
    private TextView tv_register,greeting_login,company_name;
    SharedPreferences pref;

    MaterialDialog.Builder materialDialog; MaterialDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login,container,false);
        ButterKnife.bind(this,view);
        initViews(view);
        return view;
    }

    private void initViews(View view){


        btn_login = (AppCompatButton)view.findViewById(R.id.btn_login);
        et_email = (EditText)view.findViewById(R.id.et_email);
        greeting_login=(TextView)view.findViewById(R.id.greeting_login);
        company_name=(TextView)view.findViewById(R.id.company_name);
        btn_login.setOnClickListener(this);

        String greets=getTimeFromAndroid();
        greeting_login.setText(greets);
        materialDialog=new MaterialDialog.Builder(getActivity())
                .content(R.string.loading)
                .widgetColor(Color.RED)
                .progress(true, 0);
        dialog=materialDialog.build();
        Typeface font= Typeface.createFromAsset(getActivity().getAssets(),"greet.ttf");
        greeting_login.setTypeface(font);
        Typeface font2= Typeface.createFromAsset(getActivity().getAssets(),"billabong.ttf");
        company_name.setTypeface(font2);
        Typeface font3= Typeface.createFromAsset(getActivity().getAssets(),"Asiago.ttf");
        setToptext();



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                dialog.show();
                loginclicked(v);
                break;
        }

    }

    private void loginclicked(View v) {
        if(et_email.getText().toString().toLowerCase().equals("123")){
            gotomainActivity();
        }else {
            Toast.makeText(getActivity(), "Please enter correct password", Toast.LENGTH_SHORT).show();
        }

    }

    private void setToptext() {
        typeface=Typeface.createFromAsset(getActivity().getAssets(),"Satisfy-Regular.ttf");
        love.setTypeface(typeface);
        vishal.setTypeface(typeface);
        weds.setTypeface(typeface);
        jiju.setTypeface(typeface);
    }



    private void gotomainActivity() {
        Intent intent=new Intent(getActivity(),MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }


    private String getTimeFromAndroid() {
        String greeting=null;
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        int hours = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);


        if(hours>=0 && hours<=12){
            greeting = "Good Morning";
        } else if(hours>=12 && hours<=16){
            greeting = "Good Afternoon";
        } else if(hours>=16 && hours<=21){
            greeting = "Good Evening";
        } else if(hours>=21 && hours<=24){
            greeting = "Good Night";
        }
        return greeting;
    }

}
