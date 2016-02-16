package com.repkap11.fractivity.tests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import com.repkap11.fractivity.Fractivity;
import com.repkap11.fractivity.R;

public class TestAdapterFractivity extends Fractivity {
    private TestAdapterFractivityFragment mTestFragment;

    @Override
    protected void fragmentCreated(FractivityFragment fractivityFragment) {
        mTestFragment = (TestAdapterFractivityFragment) fractivityFragment;
    }

    @Override
    protected FractivityFragment createFragment(Bundle savedInstanceState) {
        FractivityFragment fragment = new TestAdapterFractivityFragment();
        //use the bundle to create the fragment
        return fragment;
    }

    public static final class TestAdapterFractivityFragment extends FractivityFragment {
        TestFractivityAdapter mAdapter;

        @Override
        protected void create(Bundle savedInstanceState) {
            mAdapter = new TestFractivityAdapter(this);
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
