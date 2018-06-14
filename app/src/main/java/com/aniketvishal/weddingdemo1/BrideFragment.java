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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.aniketvishal.weddingdemo1.R.id.txt_1;
import static com.aniketvishal.weddingdemo1.R.id.txt_2;
import static com.aniketvishal.weddingdemo1.R.id.txt_3;
import static com.aniketvishal.weddingdemo1.R.id.txt_slid;

/**
 * Created by aniketvishal on 30/04/17.
 */

public class BrideFragment extends Fragment{

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.txt_date)
    TextView txt_date;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.txt_1a)
    TextView txt_1a;
    @BindView(R.id.txt_1b)
    TextView txt_1b;
    @BindView(R.id.txt_2a)
    TextView txt_2a;
    @BindView(R.id.txt_2b)
    TextView txt_2b;
    @BindView(R.id.txt_3a)
    TextView txt_3a;
    @BindView(R.id.txt_3b)
    TextView txt_3b;
    @BindView(R.id.txt_4a)
    TextView txt_4a;
    @BindView(R.id.txt_4b)
    TextView txt_4b;
    @BindView(R.id.txt_5a)
    TextView txt_5a;
    @BindView(R.id.txt_5b)
    TextView txt_5b;
    @BindView(R.id.txt_6a)
    TextView txt_6a;
    @BindView(R.id.txt_6b)
    TextView txt_6b;
    @BindView(R.id.txt_slid)
    TextView txt_slid;

    Typeface typeface;
    ArrayList<Mainmodel> mainmodels=new ArrayList<>();
    MainAdapter mainAdapter;

    public static BrideFragment newInstance() {
        BrideFragment brideFragment=new BrideFragment();
        return brideFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.bridefragmentlayout,container,false);
        ButterKnife.bind(this,view);
        setToptext();
        initRecycler();
        return view;
    }

    private void setToptext() {
        typeface=Typeface.createFromAsset(getActivity().getAssets(),"Satisfy-Regular.ttf");
        txt_date.setTypeface(typeface);
        txt_1a.setTypeface(typeface);
        txt_1b.setTypeface(typeface);
        txt_2a.setTypeface(typeface);
        txt_2b.setTypeface(typeface);
        txt_3a.setTypeface(typeface);
        txt_3b.setTypeface(typeface);
        txt_4a.setTypeface(typeface);
        txt_4b.setTypeface(typeface);
        txt_5a.setTypeface(typeface);
        txt_5b.setTypeface(typeface);
        txt_6a.setTypeface(typeface);
        txt_6b.setTypeface(typeface);
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
        mainmodels.add(new Mainmodel(R.drawable.b1));
        mainmodels.add(new Mainmodel(R.drawable.b2));
        mainmodels.add(new Mainmodel(R.drawable.b3));
        mainmodels.add(new Mainmodel(R.drawable.b4));
        mainmodels.add(new Mainmodel(R.drawable.b5));
        mainmodels.add(new Mainmodel(R.drawable.b6));
    }

}
