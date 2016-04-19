package com.jianda.liwenjie.day21_contentprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        sms = (Button) findViewById(R.id.getSms);
        sms.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.getSms:
                //获取一个ContentResolver实例
                ContentResolver resolver = getContentResolver();
                //需要查询的字段  数据库的列
                String[] projections ={"number"};
                //查询条件
                //String selection = "address=?";
                String selection = null;
                //条件涉及的字段的值
                String[] selectionArgs =null;    // {"15853152295"};
                //排序
                String sortOrder ="number DESC";
                Cursor cursor = resolver.query(Uri.parse("content://call_log/calls"), projections,selection,selectionArgs,sortOrder);
                while (cursor.moveToNext()){
                    for (int i = 0; i < cursor.getColumnCount(); i++) {

                        Log.d(TAG, "短信 ---" + cursor.getColumnName(i)+":"+cursor.getString(i));
                    }
                }
                break;
        }
    }
}
