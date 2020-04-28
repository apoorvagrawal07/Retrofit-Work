package com.example.thereqresapicall;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class Main2Activity extends AppCompatActivity {

    public void onClick(View view){
      finish();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        TextView textView = findViewById(R.id.userText);
        ImageView imageView = findViewById(R.id.userImage);
        Button button = findViewById(R.id.button);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            String name = bundle.getString("name");
            String email = bundle.getString("email");
            String avatar = bundle.getString("avatar");
            Glide.with(getApplicationContext()).load(avatar).listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    progressBar.setVisibility(View.GONE);
                    return  false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    progressBar.setVisibility(View.GONE);

                    return false;
                }
            }).into(imageView);

            textView.setText(name + "\n\n" + email);
        }
    }
}