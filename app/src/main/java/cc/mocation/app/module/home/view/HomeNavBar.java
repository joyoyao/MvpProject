package cc.mocation.app.module.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cc.mocation.app.R;

public class HomeNavBar extends LinearLayout {

    private OnHomeNavChangeListener mOnHomeNavChangeListener;


    public HomeNavBar(Context context) {
        super(context);
    }

    public HomeNavBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeNavBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }

    @OnClick(R.id.txt_home)
    public void homeClick(View view) {
        if (mOnHomeNavChangeListener != null) {
            mOnHomeNavChangeListener.setNavChange(0);
        }
    }


    @OnClick(R.id.txt_movie)
    public void movieClick() {
        if (mOnHomeNavChangeListener != null) {
            mOnHomeNavChangeListener.setNavChange(1);
        }
    }


    @OnClick(R.id.txt_city)
    public void cityClick() {
        if (mOnHomeNavChangeListener != null) {
            mOnHomeNavChangeListener.setNavChange(2);
        }
    }

    @OnClick(R.id.txt_address)
    public void addressClick() {
        if (mOnHomeNavChangeListener != null) {
            mOnHomeNavChangeListener.setNavChange(3);
        }
    }

    @OnClick(R.id.txt_person)
    public void personClick() {
        if (mOnHomeNavChangeListener != null) {
            mOnHomeNavChangeListener.setNavChange(4);
        }
    }

    public void setOnHomeNavChangeListener(OnHomeNavChangeListener onHomeNavChangeListener) {
        mOnHomeNavChangeListener = onHomeNavChangeListener;
    }

    public interface OnHomeNavChangeListener {
        public void setNavChange(int index);
    }
}