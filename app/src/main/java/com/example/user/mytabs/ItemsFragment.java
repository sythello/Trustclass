package com.example.user.mytabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by user on 2016/11/22.
 */

public class ItemsFragment extends Fragment
{
    private ListView mListView;
    private final int tagsCount = 10;

    public ItemsFragment()
    {
    }

    public static ItemsFragment newInstance(int sectionNumber)
    {
        ItemsFragment itemsFragment = new ItemsFragment();
        Bundle args = new Bundle();
        args.putInt("section_number", sectionNumber);
        itemsFragment.setArguments(args);
        return itemsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.items_fragment, container, false);
        mListView = (ListView)rootView.findViewById(R.id.item_list);
        int sectionNumber = getArguments().getInt("section_number");
        String[] tags = new String[tagsCount];
        for(int i = 0; i < tagsCount; i++)
        {
            tags[i] = Integer.toString(sectionNumber) + "-" + Integer.toString(i+1);
        }
        mListView.setAdapter(new ArrayAdapter<String>(
                getContext(), R.layout.item_row, R.id.item_text, tags
        ));

        return rootView;
    }
}
