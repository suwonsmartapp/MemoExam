package com.massivcode.memoexam;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Copyright 2015 Pureum Choe
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p/>
 * <p/>
 * Created by Ray Choe on 2015-12-17.
 */
public class MemoAdapter extends BaseAdapter {

    private List<Memo> mList;
    private LayoutInflater mLayoutInflater;

    public MemoAdapter(List<Memo> mList, Context context) {
        this.mList = mList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.item_memo, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.item_title_tv);
            viewHolder.contents = (TextView) convertView.findViewById(R.id.item_contents_tv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Memo memo = (Memo) getItem(position);
        String title = memo.getTitle();
        String contents = memo.getContents();

        if(TextUtils.isEmpty(title)) {
            viewHolder.title.setText("제목이 비어있습니다.");
        } else {
            viewHolder.title.setText(title);
        }

        if(TextUtils.isEmpty(contents)) {
            viewHolder.contents.setText("내용이 비어있습니다.");
        } else {
            viewHolder.contents.setText(contents);
        }

        return convertView;
    }

    static class ViewHolder {
        TextView title;
        TextView contents;
    }
}
