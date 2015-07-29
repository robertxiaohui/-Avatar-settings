package com.jerry.avatar;


import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RelativeLayout;

public class ClipImageLayout extends RelativeLayout {

    public static String savePath = "/xiaoluo";

    private ClipZoomImageView mZoomImageView;
    private ClipImageBorderView mClipImageView;

    private int mHorizontalPadding = 60;
    private int mVerticalPadding = 120;

    public ClipImageLayout(Context context) {
        this(context, null);
    }
    public ClipImageLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        mZoomImageView = new ClipZoomImageView(context);//选择图片
        mClipImageView = new ClipImageBorderView(context);//选择框

        android.view.ViewGroup.LayoutParams lp = new LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                android.view.ViewGroup.LayoutParams.MATCH_PARENT);

        this.addView(mZoomImageView, lp);//显示的图片
        this.addView(mClipImageView, lp);//前面截取的边框


        // 计算padding的px
        mHorizontalPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, mHorizontalPadding, getResources().getDisplayMetrics());
        mVerticalPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, mVerticalPadding, getResources().getDisplayMetrics());
        mZoomImageView.setHorizontalPadding(mHorizontalPadding);
       // mZoomImageView.setVerticalPadding(mVerticalPadding);
        mClipImageView.setHorizontalPadding(mHorizontalPadding);
        mClipImageView.setVerticalPadding(mVerticalPadding);
    }

    /**
     * 对外公布设置边距的方法,单位为dp
     *
     * @param mHorizontalPadding
     */
    public void setHorizontalPadding(int mHorizontalPadding) {
        this.mHorizontalPadding = mHorizontalPadding;
    }

    public void setmVerticalPadding(int mVerticalPadding) {
        this.mVerticalPadding = mVerticalPadding;
    }

    /**
     * 裁切图片
     *
     * @return
     */
    public Bitmap clip() {
        return mZoomImageView.clip();
    }

    public void setBitmap(Bitmap bitmap) {
        mZoomImageView.setImageBitmap(bitmap);
    }


  /*  public interface setAvatarOnClickListener(AvatarOnClickListener listener){

    }*/
}
