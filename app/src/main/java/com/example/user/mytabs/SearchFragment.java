package com.example.user.mytabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.webkit.WebView;
import android.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by user on 2016/11/23.
 */

public class SearchFragment extends Fragment
{
    RequestQueue mRequestQueue;
    SearchView mSearchView;
    WebView mWebView;

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
        mWebView = (WebView) rootView.findViewById(R.id.search_result);
        mRequestQueue = Volley.newRequestQueue(getContext());

        final String url = "https://www.bing.com/";
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String s)
            {
                /*
                StringRequest sRequest = new StringRequest(Request.Method.GET, url + "search?q=" + s,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response)
                            {
                                mWebView.loadData(response., "text/html", null);
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                Log.d(getTag(), "Volley error response");
                            }
                        }
                );
                mRequestQueue.add(sRequest);
                */
                mWebView.loadUrl(url + "search?q=" + s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s)
            {
                return false;
            }
        });

        return rootView;
    }


}
