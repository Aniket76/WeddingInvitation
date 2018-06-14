package com.aniketvishal.weddingdemo1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.TextView;

import com.ToxicBakery.viewpager.transforms.CubeInTransformer;
import com.aniketvishal.weddingdemo1.adapter.MainAdapter;
import com.aniketvishal.weddingdemo1.model.Mainmodel;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.app_bar_product)
    AppBarLayout appBarLayout;
    @BindView(R.id.wedding_text)
    TextView weddingtext;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.wedding_viewpager)
    ViewPager viewPager;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingtoolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.title_toptext)
    TextView title_toptext;


    Typeface typeface;
    ArrayList<Mainmodel> mainmodels=new ArrayList<>();
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" ");

        setToptext();
        initializeRecycler();



    }

    private void setToptext() {
        typeface=Typeface.createFromAsset(getAssets(),"Satisfy-Regular.ttf");
        title_toptext.setTypeface(typeface);

    }

    private void initializeRecycler() {
        recyclerView.setHasFixedSize(true);
        mainAdapter=new MainAdapter(mainmodels, this, new MainAdapter.Onitemclicked() {
            @Override
            public void onimageclicked(int pos) {
                Intent intent=new Intent(getApplicationContext(),Screenshot_Activity.class);
                intent.putExtra(CONSTANT.textimage,mainmodels.get(pos).getPicture());
                startActivity(intent);
            }
        });




        recyclerView.setAdapter(mainAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        SnapHelper snapHelper=new GravitySnapHelper(Gravity.START);
        snapHelper.attachToRecyclerView(recyclerView);

        prepareData();




    }

    private void prepareData() {
        mainmodels.add(new Mainmodel(R.drawable.m1));
        mainmodels.add(new Mainmodel(R.drawable.m2));
        mainmodels.add(new Mainmodel(R.drawable.m3));
        mainmodels.add(new Mainmodel(R.drawable.m4));
        mainmodels.add(new Mainmodel(R.drawable.m5));
        mainmodels.add(new Mainmodel(R.drawable.m6));
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(IntroFragment.newInstance(),"INTRO");
        adapter.addFragment(BrideFragment.newInstance(),"BRIDE");
        adapter.addFragment(GroomFragment.newInstance(),"BRIDEGROOM");
        viewPager.setAdapter(adapter);
        // viewPager.setPageTransformer(true,new CubeInTransformer());

    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }

}
