package com.repkap11.fractivity.tests;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.repkap11.fractivity.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 2/16/16.
 */
public class TestAdapter extends BaseAdapter {
    private final AdapterFractivity.AdapterFractivityFragment mFragment;
    private List<String> mStrings;

    public TestAdapter(AdapterFractivity.AdapterFractivityFragment testAdapterFractivityFragment) {
        mFragment = testAdapterFractivityFragment;
        mStrings = new ArrayList<>();
        TestAsyncDownloader downloader = new TestAsyncDownloader(this);
        downloader.execute(42);
    }

    @Override
    public int getCount() {
        return mStrings.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mFragment.getActivity()).inflate(R.layout.fractivity_adaptertest_list_element, parent, false);
            holder = new Holder();
            holder.mName = (TextView) convertView.findViewById(R.id.fractivity_adaptertest__list_text);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.mName.setText(mStrings.get(position));
        holder.mIndex = position;

        return convertView;
    }

    public void onDownloadComplete(List<String> strings) {
        mStrings = strings;
        notifyDataSetChanged();
    }

    public class Holder {
        public TextView mName;
        public int mIndex;
    }
}
