package com.repkap11.fractivity.tests;

import android.os.AsyncTask;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by paul on 9/8/16.
 */
public class TestAsyncDownloader extends AsyncTask<Integer, Void, List<String>> {
    private static final String TAG = TestAsyncDownloader.class.getSimpleName();
    private final WeakReference<TestAdapter> mAdapterRef;

    public TestAsyncDownloader(TestAdapter adapter) {
        mAdapterRef = new WeakReference<TestAdapter>(adapter);
    }

    @Override
    protected List<String> doInBackground(Integer... params) {
        Integer numValues = params[0];
        String[] values = new String[numValues];
        for (int i = 0; i < numValues; i++) {
            values[i] = i + " out of " + numValues;
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList(values);
    }

    @Override
    protected void onPostExecute(List<String> strings) {
        TestAdapter adapter = mAdapterRef.get();
        if (adapter != null) {
            Log.e(TAG, "Download Complete");
            adapter.onDownloadComplete(strings);
        }
        super.onPostExecute(strings);
    }
}