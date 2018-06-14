package com.aniketvishal.weddingdemo1;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aniketvishal.weddingdemo1.adapter.MainAdapter;
import com.aniketvishal.weddingdemo1.model.Mainmodel;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aniketvishal on 30/04/17.
 */

public class IntroFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.txt_date)
    TextView txt_date;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.txt_1)
    TextView txt_1;
    @BindView(R.id.txt_2)
    TextView txt_2;
    @BindView(R.id.txt_3)
    TextView txt_3;
    @BindView(R.id.txt_date1)
    TextView txt_date1;
    @BindView(R.id.txt_date2)
    TextView txt_date2;
    @BindView(R.id.txt_date3)
    TextView txt_date3;
    @BindView(R.id.txt_date0)
    TextView txt_date0;
    @BindView(R.id.txt_date4)
    TextView txt_date4;
    @BindView(R.id.txt_inv)
    TextView txt_inv;
    @BindView(R.id.txt_slid)
    TextView txt_slid;

    Typeface typeface;
    ArrayList<Mainmodel> mainmodels=new ArrayList<>();
    MainAdapter mainAdapter;

    public static IntroFragment newInstance() {
        IntroFragment fragment =new IntroFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.introfragmentlayout,container,false);
        ButterKnife.bind(this,view);
        setToptext();
        initRecycler();
        return view;
    }

    private void setToptext() {
        typeface=Typeface.createFromAsset(getActivity().getAssets(),"Satisfy-Regular.ttf");
        txt_date.setTypeface(typeface);
        txt_1.setTypeface(typeface);
        txt_2.setTypeface(typeface);
        txt_3.setTypeface(typeface);
        txt_date1.setTypeface(typeface);
        txt_date2.setTypeface(typeface);
        txt_date3.setTypeface(typeface);
        txt_date0.setTypeface(typeface);
        txt_date4.setTypeface(typeface);
        txt_inv.setTypeface(typeface);
        txt_slid.setTypeface(typeface);
    }

    private void initRecycler() {
        recyclerView.setHasFixedSize(true);
        mainAdapter=new MainAdapter(mainmodels, getActivity(), new MainAdapter.Onitemclicked() {
            @Override
            public void onimageclicked(int pos) {
                Intent intent=new Intent(getActivity(),Screenshot_Activity.class);
                intent.putExtra(CONSTANT.textimage,mainmodels.get(pos).getPicture());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(mainAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        SnapHelper snapHelper=new GravitySnapHelper(Gravity.START);
        snapHelper.attachToRecyclerView(recyclerView);

        prepareData();

    }

    private void prepareData() {
        mainmodels.add(new Mainmodel(R.drawable.i1));
        mainmodels.add(new Mainmodel(R.drawable.i2));
        mainmodels.add(new Mainmodel(R.drawable.i3));
        mainmodels.add(new Mainmodel(R.drawable.i4));
        mainmodels.add(new Mainmodel(R.drawable.i5));
        mainmodels.add(new Mainmodel(R.drawable.i6));
    }

}

