package fcu.flashDrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
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

        setContentView(R.layout.activity_main);
        initView();
    }
    public void user(View v) {
        Intent it = new Intent(this, user.class);

        startActivity(it);
    }

    private void initView() {
        tvTitle=findViewById(R.id.tv_title);
        ivshopList=findViewById(R.id.iv_shop_list);
        List<String> list=new ArrayList<>();
       // for (int i=0;i<20;i++){
        //    list.add(i+"-"+i);
        //}
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,list.toArray());
        ivshopList.setAdapter(adapter);
    }
}