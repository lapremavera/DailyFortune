package com.lapremavera.dailyfortune.app;


import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class AppController extends Application {
    private static AppController mInstance;
    private static final String TAG ="AppController";


    public static synchronized AppController getInstance() {
        return mInstance;
    }

    private RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }
    public <T> void addToRequestQueue (Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag)? TAG:tag);
        getRequestQueue().add(req);
    }
    public <T> void addToRequestQueue (Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }
    public void cancelPendingsRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
