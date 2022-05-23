package fcu.flashDrop;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;


public class ShopDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        //隱藏標題欄
        setContentView(R.layout.activity_shop_detail);
        initView();
    }
    private void initView() {

    }
}
