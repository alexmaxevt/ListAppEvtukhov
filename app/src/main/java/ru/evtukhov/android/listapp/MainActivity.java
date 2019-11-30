package ru.evtukhov.android.listapp;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);

        List<Map<String, String>> values = prepareContent();

        BaseAdapter listContentAdapter = createAdapter(values);

        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private SimpleAdapter createAdapter(List<Map<String, String>> values) {
        return new SimpleAdapter(this, values, R.layout.list, new String[]{"text","length"}, new int[]{R.id.textView, R.id.textViewNumberOfChars});
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        List<Map<String, String>> contentList = new ArrayList<>();
        String[] arrayContent = getString(R.string.large_text).split("\n\n");
        Map<String, String> mapForList;
        for (int i = 0 ; i < arrayContent.length ; i++){
            mapForList = new HashMap<>();
            mapForList.put("text",arrayContent[i]);
            mapForList.put("length",Integer.toString(arrayContent[i].length()));
            contentList.add(mapForList);
        };
        return contentList;
    }
}