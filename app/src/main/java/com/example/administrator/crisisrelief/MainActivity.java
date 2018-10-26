package com.example.administrator.crisisrelief;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    private ArrayList<String> titleText;

    private RecyclerView mRecyclerView;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = MainActivity.this;

        titleText = new ArrayList<String>();

        titleText.add(Constants.NATURAL_DISASTER_PRECAUTIONS);
        titleText.add(Constants.EARTHQUAKE);
        titleText.add(Constants.FLOOD);
        titleText.add(Constants.TSUNAMI);
        titleText.add(Constants.STORM);
        titleText.add(Constants.DROUGHT);
        titleText.add(Constants.THUNDERSTORM);
        titleText.add(Constants.WILD_FIRE);
        titleText.add(Constants.TORNADOES);
        titleText.add(Constants.LANDSLIDES);
      //  titleText.add(Constants.EMERGENCY_HELPLINE_CONTACTS);

        mRecyclerView = (RecyclerView) findViewById(R.id.title_layout_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setHasFixedSize(true);


        TitleAdapter adapter = new TitleAdapter(mContext, titleText, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                Toast.makeText(mContext, "clicked - "+String.valueOf(titleText.get(position)), Toast.LENGTH_SHORT).show();

                Intent desIntent = new Intent(mContext,DescriptionActivity.class);

                desIntent.putExtra("titles",String.valueOf(titleText.get(position)));

                startActivity(desIntent);

            }
        });

        mRecyclerView.setAdapter(adapter);

    }
}