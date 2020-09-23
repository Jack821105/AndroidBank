package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private final static String TAG = "MainActivity";
    private RecyclerView rv;
    private CommonTask addTask;
    private List<News> arrayNews = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        arrayNews = getData();

        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rv.setAdapter(new showAdapter(MainActivity.this, arrayNews));

    }

    private List<News> getData() {

        List<News> list = null;
        String getStrJson = Common.getJson("list.json", MainActivity.this);
        Log.e(TAG, "getStrJson" + getStrJson);


        //將讀出的字串轉換成JSONobject
//            JSONArray jsonObject = new JSONArray(getStrJson);
//            //獲取JSONObject中的陣列資料
//            Log.e(TAG, "JSONArray" + jsonObject);
        Type listType = new TypeToken<List<News>>() {
        }.getType();
        //這裡的json是字串型別 = jsonArray.toString();
        list =  new Gson().fromJson(getStrJson.toString(),listType);


        Log.e(TAG, "list" + list);

        return list;

    }


    private class showAdapter extends RecyclerView.Adapter<showAdapter.Myviewholder> {

        Context context;
        List<News> arrayNews;

        public showAdapter(Context context, List<News> arrayNews) {

            this.context = context;
            this.arrayNews = arrayNews;

        }

        @NonNull
        @Override
        public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

            return new Myviewholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Myviewholder holder, int position) {

            final News finalNew = arrayNews.get(position);


            holder.tv_Name.setText(finalNew.getDESCRIPT());
            holder.tv_Time.setText(finalNew.getSTART_TIME() + "-" + finalNew.getEND_TIME());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,UriActivity.class);
                    intent.putExtra("news",finalNew);

                    startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {


            return arrayNews != null ? arrayNews.size() : 0;
        }

        private class Myviewholder extends RecyclerView.ViewHolder {
            TextView tv_Name;
            TextView tv_Time;
            RelativeLayout relativeLayout;


            public Myviewholder(View view) {
                super(view);
                relativeLayout = view.findViewById(R.id.relativeLayout);
                tv_Name = view.findViewById(R.id.tv_Name);
                tv_Time = view.findViewById(R.id.tv_Time);

            }
        }
    }

}
