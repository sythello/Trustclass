package com.example.user.mytabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 2016/11/23.
 */

public class PersonalInfoFragment extends Fragment
{
    ImageView mImageView;
    TextView mTextView;

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
        mImageView = (ImageView) rootView.findViewById(R.id.user_icon);
        mTextView = (TextView) rootView.findViewById(R.id.username_text);

        return rootView;
    }
}
