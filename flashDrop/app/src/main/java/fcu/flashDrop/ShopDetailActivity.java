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


    private final int[] food_image = {R.drawable.kfc1,R.drawable.kfc2,R.drawable.kfc3};
    private final String[] food_name = {"炸鷄套餐", "雙層漢堡", "超級套餐"};
    private final String[] food_taste = {"炸雞，薯條，可樂","麵包，雞肉，生菜","漢堡，可樂，雞塊，炸雞，土豆泥"};
    private final String[] food_sale = {"月售：66","月售：104","月售：274"};
    private final String[] food_price = {"￥120","￥90","￥198"};

    private final List<ItemsDetail> itemsDetailList = new ArrayList<>();

    ListView listView;
    FoodAdapter foodAdapter;
    private TextView textView;

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
            for(int i=0; i<=2;i++){
                ItemsDetail itemsdetail = new ItemsDetail(food_image[i],food_name[i],food_taste[i],food_sale[i],food_price[i]);
                itemsDetailList.add(itemsdetail);
            }
        }

        listView = findViewById(R.id.listView);
        foodAdapter = new FoodAdapter(itemsDetailList,this);
        listView.setAdapter(foodAdapter);

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
