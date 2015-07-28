package com.jerry.avatar;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;


/**
 * 绘制选图框
 */
public class ClipImageBorderView extends View
{
	/**
	 * 水平方向与View的边距
	 */
	private int mHorizontalPadding;
	/**
	 * 垂直方向与View的边距
	 */
	private int mVerticalPadding;
	/**
	 * 边框的宽度 单位dp
	 */
	private int mBorderWidth = 2;

	private Paint mPaint;

	public ClipImageBorderView(Context context)
	{
		this(context, null);
	}

	public ClipImageBorderView(Context context, AttributeSet attrs)
	{
		this(context, attrs, 0);
	}

	public ClipImageBorderView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);

		mBorderWidth = (int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, mBorderWidth, getResources()
						.getDisplayMetrics());
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		// 绘制边框
		mPaint.setColor(Color.parseColor("#FFFFFF"));
		mPaint.setStrokeWidth(mBorderWidth);
		mPaint.setStyle(Style.STROKE);
		//方形边框
		//canvas.drawRect(mHorizontalPadding, mVerticalPadding, getWidth()- mHorizontalPadding, getHeight() - mVerticalPadding, mPaint);
		//圆形边框
		canvas.drawCircle( getWidth()/2, getHeight()/2, getWidth()/2-mHorizontalPadding, mPaint);

	}

	public void setHorizontalPadding(int mHorizontalPadding)
	{
		this.mHorizontalPadding = mHorizontalPadding;
	}

	public  void setVerticalPadding(int mVerticalPadding){
		this.mVerticalPadding = mVerticalPadding;
	}

}
