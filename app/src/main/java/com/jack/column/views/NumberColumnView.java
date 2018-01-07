package com.jack.column.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jack.column.utils.ScreenUtils;


/**
 * @author ycj
 * @version V1.0 <>
 * @date: 2017-06-25 17:34
 */

public class NumberColumnView extends View {
    /**
     * 最大
     */
    private int maxValue = 100;

    private int corner = 40;
    /**
     * 显示的数
     */

    private int data = 0;
    private int tempData = 0;
    private int textPadding = 20;
    private Paint mPaint;
    private int mColor;

    private Context mContext;

    public NumberColumnView(Context context) {
        super(context);
        mContext = context;
    }

    public NumberColumnView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initPaint();
    }

    public NumberColumnView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mColor = Color.RED;
        mPaint.setColor(mColor);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (data == 0) {
            mPaint.setTextSize(getWidth() / 4);
            // 设置个新的长方形
            RectF oval3 = new RectF(0, getHeight() - ScreenUtils.px2dip(20, mContext), getWidth(), getHeight());
            canvas.drawRoundRect(oval3, ScreenUtils.px2dip(corner, mContext), ScreenUtils.px2dip(corner, mContext), mPaint);
            canvas.drawText("0",
                    getWidth() * 0.5f - mPaint.measureText("0") * 0.5f,
                    getHeight() - ScreenUtils.px2dip(20, mContext) - 2 * ScreenUtils.px2dip(textPadding, mContext),
                    mPaint);
            return;
        }

        //防止数值很大的的时候，动画时间过长
        int step = data / 100 + 1;

        if (tempData < data - step) {
            tempData = tempData + step;
        } else {
            tempData = data;
        }
        //画圆角矩形
        String s = tempData + "";

        //一个字和两,三个字的字号相同
        if (s.length() < 4) {
            mPaint.setTextSize(getWidth() / 4);
        } else {
            mPaint.setTextSize(getWidth() / (s.length()));
        }

        float textH = mPaint.ascent() + mPaint.descent();
        float maxHeight = getHeight() - textH - 2 * ScreenUtils.px2dip(textPadding, mContext);
        //圆角矩形的实际高度
        float realH = maxHeight / maxValue * tempData;
        // 设置个新的长方形
        RectF oval3 = new RectF(0, getHeight() - realH, getWidth(), getHeight());
        canvas.drawRoundRect(oval3, ScreenUtils.px2dip(corner, mContext), ScreenUtils.px2dip(corner, mContext), mPaint);
        //写数字
        canvas.drawText(s,
                getWidth() * 0.5f - mPaint.measureText(s) * 0.5f,
                getHeight() - realH - 2 * ScreenUtils.px2dip(textPadding, mContext),
                mPaint);
        if (tempData != data) {
            postInvalidate();
        }
    }

    public void setData(int data, int maxValue) {
        this.data = data;
        tempData = 0;
        this.maxValue = maxValue;
        postInvalidate();
    }

    public void setData(int data) {
        this.data = data;
        tempData = 0;
        postInvalidate();
    }
}
