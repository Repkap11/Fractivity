package com.repkap11.fractivity.tests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.repkap11.fractivity.Fractivity;
import com.repkap11.fractivity.R;

public class TestFractivity extends Fractivity<TestFractivity.TestFractivityFragment> {

    @Override
    protected TestFractivityFragment createFragment(Bundle savedInstanceState) {
        //use the bundle to create the fragment
        return new TestFractivityFragment();
    }

    public static final class TestFractivityFragment extends Fractivity.FractivityFragment {
        int mPersistingVar = 0;

        @Override
        protected void create(Bundle savedInstanceState) {
            mPersistingVar = 76;
        }

        TextView mTextView;

        @Override
        protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fractivity_test, container, false);
            mTextView = (TextView) rootView.findViewById(R.id.fractivity_test_text);
            incrementCounter();

            return rootView;
        }

        @Override
        protected void destroyView() {
            mTextView = null;
        }

        public void incrementCounter() {
            mPersistingVar += 1;
            mTextView.setText("" + mPersistingVar);
        }
    }

    @Override
    public void onBackPressed() {
        mFragment.incrementCounter();
    }
}
