package fcu.flashDrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private int images[]={R.drawable.kfc, R.drawable.mc,R.drawable.pizzah, R.drawable.xinbake};
    private String names[]={"Kfc","McDonald's","pizza hut", "Starbucks"};

    private List<ItemsModal> itemsModalList = new ArrayList<>();


    GridView gridView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        for (int i=0; i< names.length; i++){
            ItemsModal itemsModal = new ItemsModal(images[i], names[i]);
            itemsModalList.add(itemsModal);
        }
        gridView = findViewById(R.id.gridView);
        customAdapter = new CustomAdapter(itemsModalList, this);

        gridView.setAdapter(customAdapter);
    }

    public class CustomAdapter extends BaseAdapter {

        private  List<ItemsModal> itemsModalList;
        private Context context;

        public CustomAdapter(List<ItemsModal> itemsModalList, Context context) {
            this.itemsModalList = itemsModalList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return itemsModalList.size();
        }

        @Override
        public Object getItem(int i) {
            return itemsModalList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = view;

            final ItemsModal itemsModal = itemsModalList.get(i);

            if (view1 == null){
                view1 = LayoutInflater.from(context).inflate(R.layout.row_items, viewGroup, false);
            }

            ImageView imageName = view1.findViewById(R.id.imageName);
            TextView tvName = view1.findViewById(R.id.tvName);

            String name = itemsModal.getName();
            int image = itemsModal.getImage();

            imageName.setImageResource(image);
            tvName.setText(name);

            return view1;
        }
    }
}