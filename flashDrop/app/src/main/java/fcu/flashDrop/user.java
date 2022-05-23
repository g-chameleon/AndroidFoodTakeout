package fcu.flashDrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class user extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_user);
        View title_1 = findViewById(R.id.title_1);
        TextView tv1 = (TextView) title_1.findViewById(R.id.tv_title);
        tv1.setText("個人主頁");
        ImageView imageView = findViewById(R.id.icon);
        imageView.setImageResource(R.drawable.go_back);
    }
    public void onClick(View v) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
    public void reg(View v) {
        Intent it = new Intent(this, reg.class);

        startActivity(it);
    }

    public void Login(View v) {
        Intent it = new Intent(this, Login.class);

        startActivity(it);
    }
    public void search(View v) {
        Intent it = new Intent(this, SearchActivity.class);

        startActivity(it);
    }
    public void coupon(View v) {
        Intent it = new Intent(this, couponActivity.class);

        startActivity(it);
    }


}