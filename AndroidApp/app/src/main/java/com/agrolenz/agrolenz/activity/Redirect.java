package com.agrolenz.agrolenz.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.agrolenz.agrolenz.R;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class Redirect extends AppCompatActivity {
    private final String PLANT_ID="com.agrolenz.plantid";
    private final int REQUEST_MODE=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_redirect);
        int plantid=getIntent().getIntExtra(PLANT_ID,9);
        ImageView imageView = (ImageView)findViewById(R.id.plant_selected);
        imageView.setImageResource(mThumbIds[plantid]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(0, 0, 0,0);
        TextView textView = (TextView)findViewById(R.id.plant_selected_name);
        textView.setText(titles[plantid]);
    }
    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.tomato,
            R.drawable.maize,
            R.drawable.watermelon,
            R.drawable.potatoes,
    };
    private String[] titles = {
            "nyanya",
            "mahindi",
            "matikiti",
            "viazi"
    };
    public void lauchcamera(View view){
        Intent intent=new Intent(this,ShowResults.class);
        intent.putExtra("REDIRECT",1);
        startActivity(intent);
    }
    public void getfile(View view){
        Intent intent=new Intent(this,ShowResults.class);
        intent.putExtra("REDIRECT",2);
        startActivity(intent);
    }
}
