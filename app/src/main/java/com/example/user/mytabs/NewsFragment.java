package com.example.user.mytabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.TimeUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.TimeZone;
import java.util.Timer;

/**
 * Created by user on 2016/11/22.
 */

public class NewsFragment extends Fragment
{
    private ListView mListView;
    private final int tagsCount = 10;

    public NewsFragment()
    {
    }

    public static NewsFragment newInstance(int sectionNumber)
    {
        NewsFragment itemsFragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putInt("section_number", sectionNumber);
        itemsFragment.setArguments(args);
        return itemsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.news_fragment, container, false);
        mListView = (ListView)rootView.findViewById(R.id.item_list);
        int sectionNumber = getArguments().getInt("section_number");
        String[] titles = new String[tagsCount];
        String[] bodyTexts = new String[tagsCount];
        String[] metaInfos = new String[tagsCount];
        String[] agrees = new String[tagsCount];
        String[] disagrees = new String[tagsCount];
        for(int i = 0; i < tagsCount; i++)
        {
            titles[i] = "Title " + Integer.toString(sectionNumber) + "-" + Integer.toString(i+1);
            bodyTexts[i] = "Lalala";
            metaInfos[i] = "1-5 00:00";
            agrees[i] = "233";
            disagrees[i] = "233";
        }

        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
        for(int i = 0; i < tagsCount; i++)
        {
            HashMap<String, Object> map = new HashMap<>();
            map.put("title", titles[i]);
            map.put("body", bodyTexts[i]);
            map.put("meta", metaInfos[i]);
            map.put("agree", agrees[i]);
            map.put("disagree", disagrees[i]);
            arrayList.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(), arrayList, R.layout.news_item,
                new String[]{"title", "body", "meta", "agree", "disagree"},
                new int[]{R.id.title_text, R.id.body_text, R.id.meta_info_text, R.id.agree_cnt_text, R.id.disagree_cnt_text});
        mListView.setAdapter(simpleAdapter);

        return rootView;
    }
}
