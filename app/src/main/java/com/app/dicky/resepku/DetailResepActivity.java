package com.app.dicky.resepku;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DICKY IBROHIM on 9/19/2017.
 */

public class DetailResepActivity extends AppCompatActivity {
    private ArrayList<Integer> mImageID;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar toolbar = getSupportActionBar();
        toolbar.setDisplayHomeAsUpEnabled(true);

        addImgID();
        bindData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void bindData(){
        int position;
        String titleresep;
        String bahan [] = getResources().getStringArray(R.array.detail_resep);
        String steps [] = getResources().getStringArray(R.array.step_resep);
        Intent  intent = getIntent();

        titleresep = intent.getStringExtra(Intent.EXTRA_TEXT);
        position = intent.getIntExtra(MainActivity.POSITION, 0);

        TextView tv_titleresep = (TextView) findViewById(R.id.titleresep);
        tv_titleresep.setText(titleresep);

        TextView tv_bahan = (TextView) findViewById(R.id.bahan);
        tv_bahan.setText(bahan[position]);

        TextView tv_langkah = (TextView) findViewById(R.id.langkah);
        tv_langkah.setText(steps[position]);

        ImageView image = (ImageView) findViewById(R.id.gambar);
        image.setImageResource(mImageID.get(position));

    }
    private void addImgID(){
        mImageID = new ArrayList<>();
        mImageID.add(R.drawable.satu);
        mImageID.add(R.drawable.dua);
        mImageID.add(R.drawable.tiga);
        mImageID.add(R.drawable.empat);
        mImageID.add(R.drawable.lima);
    }
}
