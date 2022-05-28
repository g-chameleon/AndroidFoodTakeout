package fcu.flashDrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity_openup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_openup);
    }
    public void user_main(View v) {
        Intent it = new Intent(this,MainActivity.class);
        startActivity(it);
    }

}