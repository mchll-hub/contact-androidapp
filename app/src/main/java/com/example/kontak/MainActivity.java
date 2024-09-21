package com.example.kontak;

import androidx.activity.result.contract.ActivityResultContracts;

 import androidx.annotation.NonNull;

 import androidx.appcompat.app.AppCompatActivity;

 import androidx.recyclerview.widget.LinearLayoutManager;

 import androidx.recyclerview.widget.RecyclerView;


import android.app.Activity;
import android.content.Intent;

 import android.os.Bundle;

 import android.view.Menu;

 import android.view.MenuItem;

 import android.view.View;

 import android.widget.Button;

 import android.widget.SearchView;



 import com.firebase.ui.database.FirebaseRecyclerOptions;

 import com.google.android.gms.tasks.OnFailureListener;

 import com.google.android.gms.tasks.OnSuccessListener;

 import com.google.android.material.floatingactionbutton.FloatingActionButton;

 import com.google.firebase.FirebaseOptions;

 import com.firebase.ui.database.FirebaseRecyclerAdapter;

 import com.google.firebase.database.FirebaseDatabase;

 import com.orhanobut.dialogplus.DialogPlus;



 import java.util.HashMap;

 import java.util.Map;

 public class MainActivity extends Activity {

     RecyclerView recview;
     myadapter adapter;
     FloatingActionButton fb;

     @Override
     protected void onCreate(Bundle savedInstanceState) {

         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         recview=(RecyclerView)findViewById(R.id.recview);
         recview.setLayoutManager(new LinearLayoutManager(this));

         FirebaseRecyclerOptions<DataModel> options =
                 new FirebaseRecyclerOptions.Builder<DataModel>()
                         .setQuery(FirebaseDatabase.getInstance().getReference().child("Daftar"), DataModel.class)
                         .build();

         adapter=new myadapter(options);
         recview.setAdapter(adapter);

         fb=(FloatingActionButton)findViewById(R.id.fadd);
         fb.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(getApplicationContext(),Tambah.class));
             }
         });
     }

     @Override
     protected void onStart() {
         super.onStart();
         adapter.startListening();
     }

     @Override
     protected void onStop() {
         super.onStop();
         adapter.stopListening();
     }
 }