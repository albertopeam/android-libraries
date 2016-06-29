package es.albertopeam.infrastructure.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.TextView;

/**
 * Created by alberto on 29/6/16.
 */
public class FallbackTextView extends TextView{

    public FallbackTextView(Context context) {
        super(context);
        setup();
    }

    public FallbackTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public FallbackTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FallbackTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setup();
    }

    private void setup(){
        if (!isInEditMode()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                setTextAppearance(android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Title);
            } else {
                setTextAppearance(getContext(), android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Title);
            }
            setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT));
        }
    }
}
