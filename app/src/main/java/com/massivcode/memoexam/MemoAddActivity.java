package com.massivcode.memoexam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MemoAddActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mTitleEditText, mContentsEditText;
    private Button mCancelButton, mSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_add);

        mTitleEditText = (EditText) findViewById(R.id.et_title);
        mContentsEditText = (EditText) findViewById(R.id.et_contents);
        mCancelButton = (Button) findViewById(R.id.btn_cancel);
        mSaveButton = (Button) findViewById(R.id.btn_save);

        mCancelButton.setOnClickListener(this);
        mSaveButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
            case R.id.btn_save:
                String title = mTitleEditText.getText().toString();
                String contents = mContentsEditText.getText().toString();
                Intent result = new Intent();
                result.putExtra("memo", new Memo(title, contents));
                setResult(RESULT_OK, result);
                finish();
                break;
        }
    }
}
