package fcu.flashDrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class user extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_user);
    }
    public void reg(View v) {
        Intent it = new Intent(this, reg.class);

        startActivity(it);
    }

    public void search(View v) {
        Intent it = new Intent(this, SearchActivity.class);

        startActivity(it);
    }

}