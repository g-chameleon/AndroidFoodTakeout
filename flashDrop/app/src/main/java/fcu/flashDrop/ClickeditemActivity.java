package fcu.flashDrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class ClickeditemActivity extends AppCompatActivity {

    private final int[] food_image = {
            R.drawable.kfc1, R.drawable.kfc2, R.drawable.kfc3,
            R.drawable.m1, R.drawable.m2, R.drawable.m3,
            R.drawable.p1, R.drawable.p2, R.drawable.p3,
            R.drawable.s1, R.drawable.s2, R.drawable.s3
    };
    private final String[] food_name = {"炸鷄套餐", "雙層漢堡", "超級套餐", "巨無霸", "小食套餐", "可樂", "香腸披薩",
            "海鮮披薩", "海陸雙排", "拿鐵", "美式", "帕尼尼"};
    private final String[] food_price = {"$130", "$70", "$230", "$100", "$160", "$40", "$170",
            "$200", "$230", "$130", "$120", "$70"};

    private final List<Items_foodModal> items_foodModalList = new ArrayList<>();

    ListView listView;
    FoodAdapter foodAdapter;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickeditem);
        //使用findViewById 得到TextView对象

        Intent intent= this.getIntent();
        int albumNo = intent.getIntExtra(SearchActivity.ALBUM_NO,0);

        if(albumNo==0){
            textView = (TextView)findViewById(R.id.text_name);
            //使用setText()方法修改文本
            textView.setText(R.string.text1);

            for(int i=0; i<=2;i++){
                Items_foodModal items_foodModal = new Items_foodModal(food_image[i],food_name[i],food_price[i]);
                items_foodModalList.add(items_foodModal);
            }
        }
        if(albumNo==1){
            textView = (TextView)findViewById(R.id.text_name);
            //使用setText()方法修改文本
            textView.setText(R.string.text2);

            for(int j=3; j<=5;j++){
                Items_foodModal items_foodModal = new Items_foodModal(food_image[j],food_name[j],food_price[j]);
                items_foodModalList.add(items_foodModal);
            }
        }
        if(albumNo==2){
            textView = (TextView)findViewById(R.id.text_name);
            //使用setText()方法修改文本
            textView.setText(R.string.text3);

            for(int j=6; j<=8;j++){
                Items_foodModal items_foodModal = new Items_foodModal(food_image[j],food_name[j],food_price[j]);
                items_foodModalList.add(items_foodModal);
            }
        }
        if(albumNo==3){
            textView = (TextView)findViewById(R.id.text_name);
            //使用setText()方法修改文本
            textView.setText(R.string.text4);

            for(int j=9; j<=11;j++){
                Items_foodModal items_foodModal = new Items_foodModal(food_image[j],food_name[j],food_price[j]);
                items_foodModalList.add(items_foodModal);
            }
        }

        listView = findViewById(R.id.listView);
        foodAdapter = new FoodAdapter(items_foodModalList,this);

        listView.setAdapter(foodAdapter);
    }


    public class FoodAdapter extends BaseAdapter {

        private final List<Items_foodModal> items_foodModalList;
        private final Context context;

        public FoodAdapter(List<Items_foodModal> items_foodModalList,Context context) {
            this.items_foodModalList = items_foodModalList;
            this.context = context;
        }
        @Override
        public int getCount() {
            return items_foodModalList.size();
        }

        @Override
        public Object getItem(int i) {
            return items_foodModalList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = view;

            final Items_foodModal items_foodModal = items_foodModalList.get(i);

            if(view1 == null){
                view1 = LayoutInflater.from(context).inflate(R.layout.menu_items,viewGroup,false);
            }

            ImageView imageName = view1.findViewById(R.id.iv_food_pic);
            TextView tvName = view1.findViewById(R.id.tv_food_name);
            TextView tvPrice = view1.findViewById(R.id.tv_price);


            String name = items_foodModal.getFood_name();
            String price = items_foodModal.getFood_price();
            int image = items_foodModal.getFood_image();

            imageName.setImageResource(image);
            tvName.setText(name);
            tvPrice.setText(price);

            return view1;
        }
    }
}