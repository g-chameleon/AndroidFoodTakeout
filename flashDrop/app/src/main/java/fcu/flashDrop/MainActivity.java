package fcu.flashDrop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import fcu.flashDrop.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tvTitle;
    private ListView ivshopList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        //隱藏標題欄
        setContentView(R.layout.activity_main);

        View title_1 = findViewById(R.id.title_1);
        TextView tv1 = (TextView) title_1.findViewById(R.id.tv_title);
        tv1.setText("首页");
        ImageView imageView = findViewById(R.id.icon);
        imageView.setImageResource(R.drawable.menu_48);

        //設置include中標題欄的textview

        initView();
    }
    public void onClick(View v) {
        Intent it = new Intent(this, user.class);
        startActivity(it);
    }

    private void initView() {
        tvTitle=findViewById(R.id.tv_title);
        ivshopList=findViewById(R.id.iv_shop_list);

        List<String> list=new ArrayList<>();
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,list.toArray());
        ivshopList.setAdapter(adapter);
    }
}