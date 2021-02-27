package com.example.farmerfriend.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farmerfriend.Model.ModelUser;
import com.example.farmerfriend.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnWartermelon,btnPaddy,more;
    private FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    private Menu menu;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Splash.getInstance().finish();

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser==null){
            Intent intent= new Intent(MainActivity.this, Login.class);
            startActivity(intent);
            finish();
        }

        btnWartermelon=(Button) findViewById(R.id.btnWatermelon);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnPaddy=findViewById(R.id.btnPaddy);
        more=findViewById(R.id.more);
        btnPaddy.setOnClickListener(this);
        more.setOnClickListener(this);

        btnWartermelon.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.threedotmenu,menu);
        this.menu= menu;
        updateMenuTitles();
        return true;
    }


    @Override
    protected void onResume() {
        super.onResume();
        if(firebaseUser==null)
        {
            Intent intent = new Intent(MainActivity.this,Login.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();

        switch (id){
            case R.id.itemMessage:
                Intent intentNew= new Intent(MainActivity.this, Message.class);
                startActivity(intentNew);
                break;
            case R.id.itemLogOut:
                firebaseAuth.signOut();
                Intent intent= new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                finish();
                break;
            case R.id.itemAbout:
                Intent intentNew2= new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intentNew2);
                break;
        }

        return true;
    }

    private void updateMenuTitles() {
        final MenuItem usernameMenu = menu.findItem(R.id.itemLogOut);

        Query query = FirebaseDatabase.getInstance().getReference().child("Users");
        query.orderByKey().equalTo(firebaseAuth.getCurrentUser().getUid()).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                ModelUser modelUser=dataSnapshot.getValue(ModelUser.class);
                usernameMenu.setTitle("লগ আউট ("+modelUser.getUsername()+")");

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnWatermelon:
                Intent watermelonIntent= new Intent(MainActivity.this, Watermelon.class);
                startActivity(watermelonIntent);
                break;
            case R.id.btnPaddy:
                Intent paddy= new Intent(MainActivity.this, PaddyActivity.class);
                startActivity(paddy);
                break;
            case R.id.more:
                Toast.makeText(getApplicationContext(),"খুব শীঘ্রই আসবে",Toast.LENGTH_SHORT).show();
                break;
        }
    }

}

