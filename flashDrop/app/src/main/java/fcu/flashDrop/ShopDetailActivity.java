package fcu.flashDrop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class ShopDetailActivity extends AppCompatActivity {


    private final int[] food_image = {R.drawable.kfc1,R.drawable.kfc2,R.drawable.kfc3,
                                      R.drawable.m1, R.drawable.m2, R.drawable.m3,
                                      R.drawable.p1, R.drawable.p2, R.drawable.p3,
                                      R.drawable.s1, R.drawable.s2, R.drawable.s3};
    private final String[] food_name = {"炸鷄套餐", "雙層漢堡", "超級套餐", "巨無霸", "小食套餐", "可樂", "香腸披薩",
            "海鮮披薩", "海陸雙排", "拿鐵咖啡", "美式咖啡", "帕尼尼"};
    private final String[] food_taste = {"炸雞，薯條，可樂","麵包，雞肉，生菜","漢堡，可樂，雞塊，炸雞，土豆泥","牛肉餅，麵包，生菜","雞翅，可樂，薯條","可樂","香腸，橄欖，芝士","蝦仁，魷魚，橄欖，青椒","海鮮","拿鐵","美式咖啡","帕尼尼"};
    private final String[] food_sale = {"月售：66","月售：104","月售：274","月售：87","月售：923","月售：23","月售：443","月售：123","月售：352","月售：155","月售：23","月售：222"};
    private final String[] food_price = {"￥130","￥70","￥230", "￥100", "￥160", "￥40", "￥170",
            "￥200", "￥230", "￥130", "￥120", "￥70"};

    private final List<ItemsDetail> itemsDetailList = new ArrayList<>();

    ListView listView;
    FoodAdapter foodAdapter;
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        //隱藏標題欄
        setContentView(R.layout.activity_shop_detail);

        Intent intent= this.getIntent();
        int albumNo = intent.getIntExtra(MainActivity.ALBUM_NO,0);

        if(albumNo==0){
            textView = (TextView)findViewById(R.id.tv_shop_name);
            //使用setText()方法修改文本
            textView.setText(R.string.tv_shop_name);

            textView = (TextView)findViewById(R.id.tv_time);
            //使用setText()方法修改文本
            textView.setText(R.string.tv_time);

            textView = (TextView)findViewById(R.id.tv_notice);
            //使用setText()方法修改文本
            textView.setText(R.string.tv_notice);


            imageView = findViewById(R.id.iv_shop_pic);
            imageView.setImageResource(R.drawable.kfc);
            for(int i=0; i<=2;i++){
                ItemsDetail itemsdetail = new ItemsDetail(food_image[i],food_name[i],food_taste[i],food_sale[i],food_price[i]);
                itemsDetailList.add(itemsdetail);
            }
        }
        if(albumNo==1){
            textView = (TextView)findViewById(R.id.tv_shop_name);
            //使用setText()方法修改文本
            textView.setText(R.string.tv_shop_name1);

            textView = (TextView)findViewById(R.id.tv_time);
            //使用setText()方法修改文本
            textView.setText(R.string.tv_time1);

            textView = (TextView)findViewById(R.id.tv_notice);
            //使用setText()方法修改文本
            textView.setText(R.string.tv_notice1);


            imageView = findViewById(R.id.iv_shop_pic);
            imageView.setImageResource(R.drawable.mc);
            for(int i=3; i<=5;i++){
                ItemsDetail itemsdetail = new ItemsDetail(food_image[i],food_name[i],food_taste[i],food_sale[i],food_price[i]);
                itemsDetailList.add(itemsdetail);
            }
        }
        if(albumNo==2){
            textView = (TextView)findViewById(R.id.tv_shop_name);
            //使用setText()方法修改文本
            textView.setText(R.string.tv_shop_name2);

            textView = (TextView)findViewById(R.id.tv_time);
            //使用setText()方法修改文本
            textView.setText(R.string.tv_time2);

            textView = (TextView)findViewById(R.id.tv_notice);
            //使用setText()方法修改文本
            textView.setText(R.string.tv_notice2);


            imageView = findViewById(R.id.iv_shop_pic);
            imageView.setImageResource(R.drawable.pizzah);
            for(int i=6; i<=8;i++){
                ItemsDetail itemsdetail = new ItemsDetail(food_image[i],food_name[i],food_taste[i],food_sale[i],food_price[i]);
                itemsDetailList.add(itemsdetail);
            }
        }
        if(albumNo==3){
            textView = (TextView)findViewById(R.id.tv_shop_name);
            //使用setText()方法修改文本
            textView.setText(R.string.tv_shop_name3);

            textView = (TextView)findViewById(R.id.tv_time);
            //使用setText()方法修改文本
            textView.setText(R.string.tv_time3);

            textView = (TextView)findViewById(R.id.tv_notice);
            //使用setText()方法修改文本
            textView.setText(R.string.tv_notice3);


            imageView = findViewById(R.id.iv_shop_pic);
            imageView.setImageResource(R.drawable.xinbake);
            for(int i=9; i<=11;i++){
                ItemsDetail itemsdetail = new ItemsDetail(food_image[i],food_name[i],food_taste[i],food_sale[i],food_price[i]);
                itemsDetailList.add(itemsdetail);
            }
        }

        listView = findViewById(R.id.listView);
        foodAdapter = new FoodAdapter(itemsDetailList,this);
        listView.setAdapter(foodAdapter);

    }
    public void onClick(View v) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
    public class FoodAdapter extends BaseAdapter {

        private final List<ItemsDetail> itemsDetailList;
        private final Context context;

        public FoodAdapter(List<ItemsDetail> itemsDetailList, Context context) {
            this.itemsDetailList = itemsDetailList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return itemsDetailList.size();
        }

        @Override
        public Object getItem(int i) {
            return itemsDetailList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = view;

            final ItemsDetail itemsDetail = itemsDetailList.get(i);

            if(view1 == null){
                view1 = LayoutInflater.from(context).inflate(R.layout.menu_item,viewGroup,false);
            }

            ImageView foodImage = view1.findViewById(R.id.iv_food_pic);
            TextView foodName = view1.findViewById(R.id.tv_food_name);
            TextView foodTaste = view1.findViewById(R.id.tv_taste);
            TextView foodSale = view1.findViewById(R.id.tv_sale_num);
            TextView foodPrice = view1.findViewById(R.id.tv_price);

            String name = itemsDetail.getFood_name();
            int image = itemsDetail.getFood_image();
            String taste = itemsDetail.getFood_taste();
            String sale = itemsDetail.getFood_sale();
            String price = itemsDetail.getFood_price();

            foodImage.setImageResource(image);
            foodName.setText(name);
            foodTaste.setText(taste);
            foodSale.setText(sale);
            foodPrice.setText(price);

            return view1;
        }
    }
}