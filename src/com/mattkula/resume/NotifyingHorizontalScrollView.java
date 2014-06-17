package com.mattkula.resume;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * Created by matt on 6/17/14.
 */
public class NotifyingHorizontalScrollView extends HorizontalScrollView {

    OnScrollListener listener;

    public NotifyingHorizontalScrollView(Context context) {
        super(context);
    }

    public NotifyingHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnScrollListener(OnScrollListener l){
        this.listener = l;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        listener.onScroll(l, t, oldl, oldt);
    }

    public interface OnScrollListener {
        public void onScroll(int l, int t, int oldl, int oldt);
    }
}
