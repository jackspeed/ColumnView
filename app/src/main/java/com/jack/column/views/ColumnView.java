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
 * @version V1.0 <来自网上代码>
 * @author: ycj
 * @date: 2017-06-25 17:34
 */

public class ColumnView extends View {
    private int maxValue = 100;
    private int corner = 10;
    private int data = 0;
    private Paint mPaint;
    private int mColor;

    Context mContext;

    public ColumnView(Context context) {
        super(context);
        mContext = context;
    }

    public ColumnView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initPaint();
    }

    public ColumnView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
            RectF oval3 = new RectF(0,
                    getHeight() - ScreenUtils.px2dip(20, mContext),
                    getWidth(),
                    getHeight());
            canvas.drawRoundRect(oval3,
                    ScreenUtils.px2dip(corner, mContext),
                    ScreenUtils.px2dip(corner, mContext),
                    mPaint);
            return;
        }
        //圆角矩形的实际高度
        float realH = getHeight() / maxValue * data;
        RectF oval3 = new RectF(0,
                getHeight() - realH,
                getWidth(),
                getHeight());
        canvas.drawRoundRect(oval3,
                ScreenUtils.px2dip(corner, mContext),
                ScreenUtils.px2dip(corner, mContext),
                mPaint);
    }

    public void setData(int data, int maxValue) {
        this.data = data;
        this.maxValue = maxValue;
        postInvalidate();
    }

    public void setData(int data) {
        this.data = data;
        postInvalidate();
    }
}
