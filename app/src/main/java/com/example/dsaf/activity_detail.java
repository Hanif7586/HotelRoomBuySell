package com.example.dsaf;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class activity_detail extends AppCompatActivity {


    Button callbtn;
    String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        TextView detailDesc, detailTitle, detailLang;
        ImageView detailImage;
        FloatingActionButton deleteButton, editButton;
        String key = "";
        String imageUrl = "";



        callbtn=findViewById(R.id.callID);

        detailDesc = findViewById(R.id.detailDesc);
        detailImage = findViewById(R.id.detailImage);
        detailTitle = findViewById(R.id.detailTitle);
        detailLang = findViewById(R.id.detailLang);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailDesc.setText(bundle.getString("Description"));
            detailTitle.setText(bundle.getString("Title"));
            detailLang.setText(bundle.getString("Language"));
            key = bundle.getString("Key");
            imageUrl = bundle.getString("Image");
            Glide.with(this).load(bundle.getString("Image")).into(detailImage);
        }



        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=detailLang.getText().toString().trim();
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+Uri.encode(number)));
                startActivity(intent);
            }
        });



    }
}