package fcu.flashDrop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    public static final String ALBUM_NO = "album_no";

    private int images[]={R.drawable.kfc, R.drawable.mc,R.drawable.pizzah, R.drawable.xinbake};
    private String names[]={"Kfc","McDonald's","pizza hut", "Starbucks"};

    private List<ItemsModal> itemsModalList = new ArrayList<>();



    GridView gridView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        for (int i=0; i< names.length; i++){
            ItemsModal itemsModal = new ItemsModal(images[i], names[i]);
            itemsModalList.add(itemsModal);
        }
        gridView = findViewById(R.id.gridView);
        customAdapter = new CustomAdapter(itemsModalList, this);

        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//開啓
                Intent intent = new Intent();
                intent.setClass(SearchActivity.this, ShopDetailActivity.class);
                intent.putExtra(ALBUM_NO, position);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
//sousuo
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem menuItem = menu.findItem(R.id.searchView);

        SearchView searchView= (SearchView) menuItem.getActionView();

        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.e("TAG","new text ==>"+newText);

                customAdapter.getFilter().filter(newText);
                return true;
            }
        });
        return true;
    }

    public class CustomAdapter extends BaseAdapter implements Filterable {

        private  List<ItemsModal> itemsModalList;
        private List<ItemsModal> itemsModalListFilter;
        private Context context;

        public CustomAdapter(List<ItemsModal> itemsModalList, Context context) {
            this.itemsModalList = itemsModalList;
            this.itemsModalListFilter = itemsModalList;
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

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence charSequence) {
                    FilterResults filterResults = new FilterResults();
                    if(charSequence == null||charSequence.length() == 0){
                        filterResults.count = itemsModalListFilter.size();
                        filterResults.values = itemsModalListFilter;

                    }else{
                        String searchChr = charSequence.toString().toLowerCase();
                        List<ItemsModal> searchResult = new ArrayList<>();

                        for(ItemsModal itemsModal:itemsModalListFilter){
                            if(itemsModal.getName().toLowerCase().contains(searchChr)){
                                searchResult.add(itemsModal);
                            }
                        }
                        filterResults.count = searchResult.size();
                        filterResults.values = searchResult;

                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                    itemsModalList = (List<ItemsModal>) filterResults.values;
                    notifyDataSetChanged();

                }
            };
            return filter;
        }
    }
}