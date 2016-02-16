package com.repkap11.fractivity.tests;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.repkap11.fractivity.R;

/**
 * Created by paul on 2/16/16.
 */
public class TestFractivityAdapter extends BaseAdapter {
    private final TestAdapterFractivity.TestAdapterFractivityFragment mFragment;

    public TestFractivityAdapter(TestAdapterFractivity.TestAdapterFractivityFragment testAdapterFractivityFragment) {
        mFragment = testAdapterFractivityFragment;
    }

    @Override
    public int getCount() {
        return 100;
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
        holder.mName.setText(position + "");
        holder.mIndex = position;

        return convertView;
    }

    public class Holder {
        public TextView mName;
        public int mIndex;
    }
}
