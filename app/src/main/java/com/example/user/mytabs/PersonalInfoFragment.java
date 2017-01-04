package com.example.user.mytabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by user on 2016/11/23.
 */

public class PersonalInfoFragment extends Fragment
{
    ImageView mUserIcon;
    TextView mUsername;
    ListView mInfoList;

    public PersonalInfoFragment()
    {
    }

    public static PersonalInfoFragment newInstance()
    {

        Bundle args = new Bundle();

        PersonalInfoFragment fragment = new PersonalInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.personal_info_fragment, container, false);
        mUserIcon = (ImageView) rootView.findViewById(R.id.user_icon);
        mUsername = (TextView) rootView.findViewById(R.id.username_text);
        mInfoList = (ListView) rootView.findViewById(R.id.info_list);

        String[] infos = {"Nickname: Sythello", "Email: sythello@163.com"};
        mInfoList.setAdapter(new ArrayAdapter<String>(
                getContext(), R.layout.item_row, R.id.item_text, infos
        ));
        mUsername.setText("sythello");

        return rootView;
    }
}
