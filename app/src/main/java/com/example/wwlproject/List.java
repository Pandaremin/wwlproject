package com.example.wwlproject;//package com.example.login;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.drawable.RoundedBitmapDrawable;
//import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
//
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.SearchView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
//import com.bumptech.glide.request.RequestOptions;
//import com.bumptech.glide.request.target.BitmapImageViewTarget;
//
//import java.util.ArrayList;
//
//public class List extends AppCompatActivity {
//    ListView listView;
//    SearchView searchView;
//    int[] IMAGES = {R.drawable.airx0, R.drawable.biogesic0, R.drawable.diegene0, R.drawable.fluza0, R.drawable.para0, R.drawable.procold0, R.drawable.sitaglit0};
//    String[] NAMES = {"AirX", "Biogesic", "Diegene", "Fluza", "Paracetamol", "Procold", "Sitaglit"};
//    int[] PRICES = {2200,20450,204460,3546200,200,200,200};
//    ArrayList<MyCustomItem> arrayList = new ArrayList<>();
//    ArrayAdapter<String> adapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list);
//        searchView = findViewById(R.id.searchView);
//        CharSequence queryHint = searchView.getQueryHint();
//        listView = findViewById(R.id.list);
//        prepareList();
//        final CustomAdapter customAdapter = new CustomAdapter(arrayList,getApplicationContext());
//
//        listView.setAdapter(customAdapter);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                arrayList = new ArrayList<>();
//                prepareList();
//                ArrayList<MyCustomItem> itemstoremove = new ArrayList<>();
//                for (int i = 0; i < arrayList.size(); i++) {
//                    if (!arrayList.get(i).getName().toLowerCase().contains(s.toLowerCase())) {
//                        itemstoremove.add(arrayList.get(i));
//                    }
//                }
//                for (MyCustomItem myitem :
//                        itemstoremove) {
//                    arrayList.remove(myitem);
//                }
//                customAdapter.notifyDataSetChanged();
//                return false;
//            }
//        });
//    }
//
//    private void prepareList() {
//
//        for (int i = 0; i < NAMES.length; i++) {
//
//
//            arrayList.add(new MyCustomItem(NAMES[i], IMAGES[i],PRICES[i]));
//        }
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent=new Intent(List.this,Order.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//
//    class CustomAdapter extends BaseAdapter {
//        ArrayList<MyCustomItem> list;
//        Context context ;
//        public CustomAdapter(ArrayList<MyCustomItem> arrayList, Context context) {
//            list = arrayList;
//            this.context = context;
//        }
//
//        @Override
//        public int getCount() {
//            return arrayList.size();
//        }
//
//        @Override
//        public Object getItem(int i) {
//            return arrayList.get(i);
//        }
//
//        @Override
//        public long getItemId(int i) {
//            return i;
//        }
//
//        @Override
//        public View getView(int i, View view, ViewGroup viewGroup) {
//            view = getLayoutInflater().inflate(R.layout.list, null);
//            ImageView imageView = view.findViewById(R.id.imageView);
//            TextView textView_name = view.findViewById(R.id.textView);
//            TextView textView_price = view.findViewById(R.id.textViewPrice);
//            MyCustomItem newCustomItem = arrayList.get(i);
//            RequestOptions requestOptions = new RequestOptions();
//            requestOptions.placeholder(R.drawable.ic_launcher_background);
//            requestOptions.circleCropTransform();
//            requestOptions.transforms( new RoundedCorners(30));
//            Glide.with(context)
//                    .load(newCustomItem.getImage_ids())
//                    .apply(requestOptions)
//                    .into(imageView);
//            textView_name.setText(newCustomItem.getName());
//            textView_price.setText(String.valueOf(newCustomItem.getPrice())+ " MMK");
//            return view;
//        }
//
//    }
//
//}