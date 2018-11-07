package haiidea.com.demohaiidea.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/5/3.
 */

public class DuiGouToAddView extends View {
    private Paint mLinePaint;
    private boolean mState; // false add
    private int mProgress = 0;
    private float mWidth = 0, mHeight = 0, letf, top, right, bottom, centerX, centerY;
    private OnClickListener mListener;
    public DuiGouToAddView(Context context) {
        this(context, null);
    }

    public DuiGouToAddView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DuiGouToAddView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mLinePaint = new Paint();
        mLinePaint.setAntiAlias(true);
        mLinePaint.setStyle(Paint.Style.FILL);
        mLinePaint.setColor(Color.parseColor("#ffffff"));
        mLinePaint.setStrokeWidth(4);
        mLinePaint.setStrokeCap(Paint.Cap.ROUND);
        letf = getPaddingLeft();
        top = getPaddingTop();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        right = getMeasuredWidth() - getPaddingRight();
        bottom = getMeasuredHeight() - getPaddingBottom();
        mHeight = bottom - top;
        mWidth = right - letf;
        centerX = letf + mWidth/2;
        centerY = top + mHeight / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mState && mProgress == 0) {
            canvas.drawLine(letf, centerY, (float) (letf + mWidth*0.45), bottom, mLinePaint);
            canvas.drawLine((float) (letf + mWidth*0.45), bottom, right, top, mLinePaint);
        }
        if (!mState && mProgress == 0) {
            canvas.drawLine(letf, (float) (top + mHeight*0.5), right, (float) (top + mHeight*0.5), mLinePaint);
            canvas.drawLine(centerX, top, centerX, bottom, mLinePaint);
        }
        if (mState) {
            duiToAdd(canvas);
        } else {
            addToDui(canvas);
        }
    }
    private void addToDui(Canvas canvas) {
        if (mProgress == -4) {
            mProgress++;
            canvas.drawLine(letf, (float) (top + mHeight*0.5), right, (float) (top + mHeight*0.5), mLinePaint);
            canvas.drawLine(centerX, centerY, (float) (letf + mWidth*0.75), (float) (top + mHeight*0.13), mLinePaint);
            canvas.drawLine(centerX, centerY, (float) (letf + mWidth*0.75), (float) (top + mHeight*0.88), mLinePaint);
            invalidate();
        } else if (mProgress == -3) {
            mProgress++;
            canvas.drawLine(letf, (float) (top + mHeight*0.5), right, (float) (top + mHeight*0.5), mLinePaint);
            canvas.drawLine(centerX, centerY, (float) (letf + mWidth*0.95), (float) (top + mHeight*0.35), mLinePaint);
            canvas.drawLine(centerX, centerY, (float) (letf + mWidth*0.95), (float) (top + mHeight*0.65), mLinePaint);
            invalidate();
        } else if (mProgress == -2) {
            mProgress++;
            canvas.drawLine(letf, (float) (top + mHeight*0.5), right, (float) (top + mHeight*0.5), mLinePaint);
            invalidate();
        } else if (mProgress == -1){
            mProgress++;
            canvas.drawLine(letf, (float) (top + mHeight*0.4), (float) (letf + mWidth*0.25), (float) (top + mHeight*0.6), mLinePaint);
            canvas.drawLine((float) (letf + mWidth*0.25), (float) (top + mHeight*0.6), right, (float) (top + mHeight*0.4), mLinePaint);
            if (mState) {
                mState = false;
            } else {
                mState = true;
            }
            invalidate();
            if (mListener != null) {
                mListener.onClick(this);
            }
        }
    }
    private void duiToAdd(Canvas canvas) {
        if (mProgress == 4) {
            mProgress--;
            canvas.drawLine(letf, (float) (top + mHeight*0.4), (float) (letf + mWidth*0.25), (float) (top + mHeight*0.6), mLinePaint);
            canvas.drawLine((float) (letf + mWidth*0.25), (float) (top + mHeight*0.6), right, (float) (top + mHeight*0.4), mLinePaint);
            invalidate();
        } else if (mProgress == 3) {
            mProgress--;
            canvas.drawLine(letf, (float) (top + mHeight*0.5), right, (float) (top + mHeight*0.5), mLinePaint);
            invalidate();
        } else if (mProgress == 2) {
            mProgress--;
            canvas.drawLine(letf, (float) (top + mHeight*0.5), right, (float) (top + mHeight*0.5), mLinePaint);
            canvas.drawLine(centerX, centerY, (float) (letf + mWidth*0.95), (float) (top + mHeight*0.35), mLinePaint);
            canvas.drawLine(centerX, centerY, (float) (letf + mWidth*0.95), (float) (top + mHeight*0.65), mLinePaint);
            invalidate();
        } else if (mProgress == 1){
            mProgress--;
            canvas.drawLine(letf, (float) (top + mHeight*0.5), right, (float) (top + mHeight*0.5), mLinePaint);
            canvas.drawLine(centerX, centerY, (float) (letf + mWidth*0.75), (float) (top + mHeight*0.13), mLinePaint);
            canvas.drawLine(centerX, centerY, (float) (letf + mWidth*0.75), (float) (top + mHeight*0.88), mLinePaint);
            if (mState) {
                mState = false;
            } else {
                mState = true;
            }
            invalidate();
            if (mListener != null) {
                mListener.onClick(this);
            }
        }
    }
    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    public void setOnClickListener( OnClickListener l) {
        super.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mProgress != 0) {
                    return;
                }
                if (mState) {
                    mProgress = 4;
                } else {
                    mProgress = -4;
                }
                invalidate();
            }
        });
        mListener = l;
    }
    public boolean isChecked() {
        return mState;
    }
}
