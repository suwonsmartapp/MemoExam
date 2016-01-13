package com.massivcode.memoexam;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Memo> mList;
    private ListView mListView;
    private FloatingActionButton mFab;
    private MemoAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList = new ArrayList<>();

        mListView = (ListView) findViewById(R.id.listview);
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent addMemoIntent = new Intent(MainActivity.this, MemoAddActivity.class);
        startActivityForResult(addMemoIntent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1000) {
            if(resultCode == RESULT_OK) {
                if(data != null) {
                        Memo memo = (Memo) data.getSerializableExtra("memo");
                    if(memo != null) {
                        Toast.makeText(MainActivity.this, "메모가 추가되었습니다.", Toast.LENGTH_SHORT).show();
                        mList.add(memo);

                        if(mAdapter == null) {
                            mAdapter = new MemoAdapter(mList, getApplicationContext());
                            mListView.setAdapter(mAdapter);
                        } else {
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }
            else if(resultCode == RESULT_CANCELED) {
                Toast.makeText(MainActivity.this, "취소하였습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
