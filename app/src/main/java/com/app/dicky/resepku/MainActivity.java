package com.app.dicky.resepku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ResepAdapter.ResepListener {
    private ResepAdapter adapter;
    public static final String POSITION = "position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        String title [] = getResources().getStringArray(R.array.title_resep);
        Log.v("Main",title[0]);
        String langkah [] =  getResources().getStringArray(R.array.Deskripsi_resep);


        adapter = new ResepAdapter(title, langkah, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(this,DetailResepActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT,adapter.getJudul(position));
        intent.putExtra(POSITION,position);
        startActivity(intent);
    }
}
