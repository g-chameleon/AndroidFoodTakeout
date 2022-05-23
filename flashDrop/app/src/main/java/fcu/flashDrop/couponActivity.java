package fcu.flashDrop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class couponActivity extends AppCompatActivity {
    CardView cardView1, cardView2, cardView3, cardView4;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.coupon);

        cardView1 = findViewById(R.id.CV1);
        cardView2 = findViewById(R.id.CV2);
        cardView3 = findViewById(R.id.CV3);
        cardView4 = findViewById(R.id.CV4);

        btn1 = findViewById(R.id.Left);
        btn2 = findViewById(R.id.Right);
    }
}