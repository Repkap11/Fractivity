package com.repkap11.fractivity.tests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.repkap11.fractivity.Fractivity;
import com.repkap11.fractivity.R;

public class StubFractivity extends Fractivity<StubFractivity.StubFractivityFragment> {

    @Override
    protected StubFractivityFragment createFragment(Bundle savedInstanceState) {
        return new StubFractivityFragment();
    }

    public static final class StubFractivityFragment extends Fractivity.FractivityFragment {

        @Override
        protected void create(Bundle savedInstanceState) {
            //TODO Create persisting things, like adapters
        }

        @Override
        protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fractivity_stub, container, false);
            //TODO create UI things, like views, and attach adapters and listeners
            return rootView;
        }

        @Override
        protected void destroyView() {
            //TODO destroy UI things and detach views and adapters
        }
    }
}
