package com.example.user.mytabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.TimeUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

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

    private String[] titles = new String[tagsCount];
    private String[] bodyTexts = new String[tagsCount];
    private String[] metaInfos = new String[tagsCount];
    private int[] agrees = new int[tagsCount];
    private int[] disagrees = new int[tagsCount];

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

        for(int i = 0; i < tagsCount; i++)
        {
            titles[i] = "Title " + Integer.toString(sectionNumber) + "-" + Integer.toString(i+1);
            bodyTexts[i] = "Lalala~~";
            metaInfos[i] = "1-5 00:00";
            agrees[i] = 0;
            disagrees[i] = 0;
        }

        /*
        SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(), getArrayList(), R.layout.news_item,
                new String[]{"title", "body", "meta", "agree", "disagree"},
                new int[]{R.id.title_text, R.id.body_text, R.id.meta_info_text, R.id.agree_cnt_text, R.id.disagree_cnt_text});
        mListView.setAdapter(simpleAdapter);
        */

        MyAdapter myAdapter = new MyAdapter(getContext());
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
            }
        });

        return rootView;
    }

    private ArrayList<HashMap<String, Object>> getArrayList()
    {
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
        for (int i = 0; i < tagsCount; i++)
        {
            HashMap<String, Object> map = new HashMap<>();
            map.put("title", titles[i]);
            map.put("body", bodyTexts[i]);
            map.put("meta", metaInfos[i]);
            map.put("agree", Integer.toString(agrees[i]));
            map.put("disagree", Integer.toString(disagrees[i]));
            arrayList.add(map);
        }
        return arrayList;
    }

    private class MyAdapter extends BaseAdapter
    {
        private LayoutInflater mLayoutInflater;

        public MyAdapter(Context context)
        {
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount()
        {
            return tagsCount;
        }

        @Override
        public Object getItem(int position)
        {
            return null;
        }

        @Override
        public long getItemId(int position)
        {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent)
        {
            ViewHolder viewHolder;
            Log.v("NewsFragment-Listview", "getView " + position + " " + convertView);
            if (convertView == null)
            {
                convertView = mLayoutInflater.inflate(R.layout.news_item, null);
            }
            viewHolder = new ViewHolder();

            viewHolder.titleText = (TextView) convertView.findViewById(R.id.title_text);
            viewHolder.bodyText = (TextView) convertView.findViewById(R.id.body_text);
            viewHolder.metaInfo = (TextView) convertView.findViewById(R.id.meta_info_text);
            viewHolder.agreeButton = (ImageButton) convertView.findViewById(R.id.agree_button);
            viewHolder.agreeText = (TextView) convertView.findViewById(R.id.agree_cnt_text);
            viewHolder.disagreeButton = (ImageButton) convertView.findViewById(R.id.disagree_button);
            viewHolder.disagreeText = (TextView) convertView.findViewById(R.id.disagree_cnt_text);

            // convertView.setTag(viewHolder);

            // viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.titleText.setText(titles[position]);
            viewHolder.bodyText.setText(bodyTexts[position]);
            viewHolder.metaInfo.setText(metaInfos[position]);
            viewHolder.agreeButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    agrees[position]++;
                    MyAdapter.super.notifyDataSetChanged();
                }
            });
            viewHolder.agreeText.setText(Integer.toString(agrees[position]));
            viewHolder.disagreeButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    disagrees[position]++;
                    MyAdapter.super.notifyDataSetChanged();
                }
            });
            viewHolder.disagreeText.setText(Integer.toString(disagrees[position]));

            return convertView;
        }

        public final class ViewHolder
        {
            TextView titleText;
            TextView bodyText;
            TextView metaInfo;
            ImageButton agreeButton;
            TextView agreeText;
            ImageButton disagreeButton;
            TextView disagreeText;
        }
    }
}
