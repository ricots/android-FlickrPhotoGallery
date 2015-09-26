package org.josh.example.android.photogallery;

import android.os.HandlerThread;
import android.util.Log;

/**
 * Created by Josh on 9/25/2015.
 */
public class ThumbnailDownloader<T> extends HandlerThread {

    private static final String TAG = "ThumbnailDownloader";

    public ThumbnailDownloader(){
        super(TAG);
    }
    public void queueThumbnail(T target, String url){
        Log.i(TAG, "Got a URL: " + url);
    }
}
