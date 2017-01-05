package com.example.user.mytabs;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 2016/11/23.
 */

public class SearchFragment extends Fragment
{
    private SearchView mSearchView;
    private ListView mListView;
    private Course[] saveCourses;       //@TODO: Delete it.
    private final int svCrsCnt = 4;
    private ArrayList<Course> mCourseList;

    public SearchFragment()
    {
    }

    public static SearchFragment newInstance()
    {
        Bundle args = new Bundle();

        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.search_fragment, container, false);
        mSearchView = (SearchView) rootView.findViewById(R.id.search_box);
        mListView = (ListView) rootView.findViewById(R.id.result_list);
        saveCourses = new Course[svCrsCnt];
        saveCourses[0] = new Course(new Teacher("Teacher1"), "Course1", 0, 0, 0);
        saveCourses[1] = new Course(new Teacher("Teacher1"), "Course2", 1, 1, 1);
        saveCourses[2] = new Course(new Teacher("Teacher2"), "Course1", 2, 2, 2);
        saveCourses[3] = new Course(new Teacher("Teacher2"), "Course2", 3, 3, 3);

        mCourseList = new ArrayList<>();

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String s)
            {
                mCourseList.clear();
                for (Course c : saveCourses)
                {
                    if(c.getName().contains(s))
                    {
                        mCourseList.add(c);
                    }
                }
                ((MyAdapter) mListView.getAdapter()).notifyDataSetChanged();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s)
            {
                return false;
            }
        });
        mListView.setAdapter(new MyAdapter(getContext()));

        return rootView;
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
            return mCourseList.size();
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
            Log.v("SearchFragment-ListView", "getView " + position + " " + convertView);
            if (convertView == null)
            {
                convertView = mLayoutInflater.inflate(R.layout.course_item, null);
            }
            viewHolder = new ViewHolder();

            viewHolder.nameText = (TextView) convertView.findViewById(R.id.name_text);
            viewHolder.teacherInfo = (TextView) convertView.findViewById(R.id.teacher_info_text);
            viewHolder.likesText = (TextView) convertView.findViewById(R.id.likes_cnt_text);
            viewHolder.neutralsText = (TextView) convertView.findViewById(R.id.neutral_cnt_text);
            viewHolder.dislikesText = (TextView) convertView.findViewById(R.id.dislike_cnt_text);

            // convertView.setTag(viewHolder);

            // viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.nameText.setText(mCourseList.get(position).getName());
            viewHolder.teacherInfo.setText(mCourseList.get(position).getTeacher().getName());
            viewHolder.likesText.setText(Integer.toString(mCourseList.get(position).getLikeCnt()));
            viewHolder.neutralsText.setText(Integer.toString(mCourseList.get(position).getNeutralCnt()));
            viewHolder.dislikesText.setText(Integer.toString(mCourseList.get(position).getDislikeCnt()));

            return convertView;
        }

        public final class ViewHolder
        {
            TextView nameText;
            TextView teacherInfo;
            TextView likesText;
            TextView neutralsText;
            TextView dislikesText;
        }
    }
}
