package com.example.user.mytabs;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by user on 2016/11/22.
 */

public class ItemInfoActivity extends AppCompatActivity
{
    public static final String IN_INTENTMSG = "ItemInfoActivity_intent_message";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.d(getLocalClassName(), "calling onCreate");

        Intent intent = getIntent();
        String msg = intent.getStringExtra(IN_INTENTMSG);
        TextView textView = (TextView) findViewById(R.id.text_content);
        textView.setText(msg);
    }

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
    */
}
