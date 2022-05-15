package fcu.flashDrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class reg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_reg);

        View title_1 = findViewById(R.id.title_1);
        TextView tv1 = (TextView) title_1.findViewById(R.id.tv_title);
        tv1.setText("註冊");
        ImageView imageView = findViewById(R.id.icon);
        imageView.setImageResource(R.drawable.go_back);
    }
    public void onClick(View v) {
        Intent it = new Intent(this, user.class);
        startActivity(it);
    }
}