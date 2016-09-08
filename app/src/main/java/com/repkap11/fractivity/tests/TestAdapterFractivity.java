package com.repkap11.fractivity.tests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import com.repkap11.fractivity.Fractivity;
import com.repkap11.fractivity.R;

public class TestAdapterFractivity extends Fractivity<TestAdapterFractivity.TestAdapterFractivityFragment> {
    private TestAdapterFractivityFragment mTestFragment;

    @Override
    protected void fragmentCreated(TestAdapterFractivityFragment fractivityFragment) {
        mTestFragment = fractivityFragment;
    }

    @Override
    protected TestAdapterFractivityFragment createFragment(Bundle savedInstanceState) {
        //use the bundle to create the fragment
        return new TestAdapterFractivityFragment();
    }

    public static final class TestAdapterFractivityFragment extends Fractivity.FractivityFragment {
        TestAdapter mAdapter;

        @Override
        protected void create(Bundle savedInstanceState) {
            mAdapter = new TestAdapter(this);
        }

        AbsListView mListView;


        @Override
        protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fractivity_adaptertest, container, false);
            mListView = (AbsListView) rootView.findViewById(R.id.fractivity_adaptertest_list);
            mListView.setAdapter(mAdapter);
            return rootView;
        }
    }
}
