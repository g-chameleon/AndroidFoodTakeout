package fcu.flashDrop;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String ALBUM_NO = "album_no";

    public  static boolean VALID_USER = false;

    private final int[] shop_image = {R.drawable.kfc, R.drawable.mc,R.drawable.pizzah, R.drawable.xinbake};
    private final String[] shop_name = {"KFC","McDonald's","pizza hut", "Starbucks"};
    private final String[] shop_sale = {"月售：999","月售：1023","月售：2333","月售：767"};
    private final String[] shop_cost = {"起送：￥100|外送：￥20","起送：￥100|外送：￥10","起送：￥70|外送：￥25","起送：￥50|外送：￥20"};
    private final String[] shop_welfare = {"滿￥100減￥10","薯條買一送一","紅茶買一送一","無"};
    private final String[] shop_time = {"大約15-20分鐘送達","大約20分鐘送達","大約40分鐘送達","大約30分鐘送達"};

    private final List<ItemsShop> itemsShopList = new ArrayList<>();

    ListView listView;
    CustomAdapter customAdapter;

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

        listView = findViewById(R.id.listView);
        customAdapter = new CustomAdapter(itemsShopList,this);

        listView.setAdapter(customAdapter);

        if (!VALID_USER){
            Intent it = new Intent();
            it.setClass(this,Login.class);
            startActivity(it);
        }
        //登陸的判斷
        for(int i=0; i< shop_name.length;i++){
            ItemsShop itemsShop = new ItemsShop(shop_image[i],shop_name[i],shop_sale[i],shop_cost[i],shop_welfare[i],shop_time[i]);
            itemsShopList.add(itemsShop);
        }
        //輸出陣列中的內容
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ShopDetailActivity.class);
                intent.putExtra(ALBUM_NO, position);
                startActivity(intent);

            }
        });
        //頁面跳轉
    }

    public void onClick(View v) {
        Intent it = new Intent(this, user.class);
        startActivity(it);
    }

    public class CustomAdapter extends BaseAdapter {

        private final List<ItemsShop> itemsShopList;
        private final Context context;

        public CustomAdapter(List<ItemsShop> itemsShopList, Context context) {
            this.itemsShopList = itemsShopList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return itemsShopList.size();
        }

        @Override
        public Object getItem(int i) {
            return itemsShopList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = view;

            final ItemsShop itemsShop = itemsShopList.get(i);

            if(view1 == null){
                view1 = LayoutInflater.from(context).inflate(R.layout.shop_item,viewGroup,false);
            }

            ImageView shopImage = view1.findViewById(R.id.iv_shop_pic);
            TextView shopName = view1.findViewById(R.id.tv_shop_name);
            TextView shopSale = view1.findViewById(R.id.tv_sale_num);
            TextView shopCost = view1.findViewById(R.id.tv_cost);
            TextView shopWelfare = view1.findViewById(R.id.tv_welfare);
            TextView shopTime = view1.findViewById(R.id.tv_time);

            String name = itemsShop.getShop_name();
            String sale = itemsShop.getShop_sale();
            String cost = itemsShop.getShop_cost();
            String welfare = itemsShop.getShop_welfare();
            String time = itemsShop.getShop_time();
            int image = itemsShop.getShop_image();

            shopImage.setImageResource(image);
            shopName.setText(name);
            shopSale.setText(sale);
            shopCost.setText(cost);
            shopWelfare.setText(welfare);
            shopTime.setText(time);

            return view1;
        }
    }
}