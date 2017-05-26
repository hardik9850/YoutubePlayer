package com.youtube.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pravin on 26/05/17.
 */

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {
    private ListView listView;
    private List<String> listOfUrls;
    String array[] = {
            "https://www.youtube.com/watch?v=qvVkDb7DqCk",
            "https://www.youtube.com/watch?v=dmoiy1aPA9I",
            "https://www.youtube.com/watch?v=fPzxfeDJDzY",
            "https://www.youtube.com/watch?v=Hx_rwS1NTiI",
            "https://www.youtube.com/watch?v=9Jg1D07NgeI",
            "https://www.youtube.com/watch?v=9HtTL_RO2wI",
            "https://www.youtube.com/watch?v=C0BPXZIvG-Q",
            "https://www.youtube.com/watch?v=BNcODK-Ju0g",
            "https://www.youtube.com/watch?v=FrteWKKVyzI&t=1840s"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_youtube);
        listOfUrls = getListOfUrls();
        ListAdapter listAdapter = new ListAdapter(this, 0, listOfUrls);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(this);
    }

    private List<String> getListOfUrls() {
        return Arrays.asList(array);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(view.getContext(), YoutubeActivity.class);
        String[] splitArray = array[position].split("=");
        intent.putExtra("url", splitArray[1]);
        Log.d("@@@@ url is ", "" + splitArray[1]);
        startActivity(intent);
    }
}
