package com.agrolenz.agrolenz.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.agrolenz.agrolenz.R;

import static java.security.AccessController.getContext;

public class ShowResults extends AppCompatActivity {
private  final int CAMERA_REQUEST =123,FILE_REQUEST=15;
    private int request;
    private TextView textView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        request = getIntent().getIntExtra("REDIRECT",0);
        if(request==1)getCameraPic();
        if(request==2)getFilePic();
        setContentView(R.layout.activity_show_results);
        textView=(TextView)findViewById(R.id.text);


    }

   public void onActivityResult(int requestCode,int resultCode,Intent data){
       imageView= (ImageView) findViewById(R.id.preview);
       if(requestCode==CAMERA_REQUEST&&resultCode== Activity.RESULT_OK){
           Bitmap photo = (Bitmap) data.getExtras().get("data");
           imageView.setImageBitmap(photo);
       }
      else if(requestCode==FILE_REQUEST&&resultCode== Activity.RESULT_OK){
           Uri uri =data.getData();
           imageView.setImageURI(uri);
       }
       else{
           textView.setText("{fa-warning} tafathari chagua picha {fa-frown-o}");
           textView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(getApplicationContext(),Redirect.class);
                   intent.putExtra("com.agrolenz.plantid",request);
                   startActivity(intent);
               }
           });
       }


   }
    private void getCameraPic(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,CAMERA_REQUEST);
    }
    private void getFilePic()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"),FILE_REQUEST);
    }
}
