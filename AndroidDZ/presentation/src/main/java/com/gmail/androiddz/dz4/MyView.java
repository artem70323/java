package com.gmail.androiddz.dz4;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import java.util.Calendar;

public class MyView extends View {

    private int height, width = 0;
    //отступ, если нужен
    private int padding = 0;
    //размер шрифта
    private int fontSize = 0;
    //отступ
    private int numeralSpacing = 0;
    //длина стрелок
    private int handTruncation, hourHandTruncation = 0;
    private int radius = 0;
    private Paint paint;
    //boolean для первой инициализации
    private boolean isInit;
    private int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private Rect rect = new Rect();


    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initClock() {
        height = getHeight();
        width = getWidth();
        padding = numeralSpacing + 50;
        fontSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 13,
                getResources().getDisplayMetrics());
        int min = Math.min(height, width);
        radius = min / 2 - padding;
        handTruncation = min / 20;
        hourHandTruncation = min / 7;
        paint = new Paint();
        isInit = true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (!isInit) {
            initClock();
        }

        drawCircle(canvas);
        drawCenter(canvas);
        drawNumeral(canvas);
        drawHands(canvas);

        postInvalidateDelayed(500);
        invalidate();
    }

    private void drawHand(Canvas canvas, double loc, boolean isHour) {
        //Math.PI = 30 минутам (пол часа, пол оборота), поэтому loc делим на 30
        // - Math.PI / 2  нужен для правильного отображения на часах
        double angle = Math.PI * loc / 30 - Math.PI / 2;
        //часовая стрелка меньше
        int handRadius = isHour ? radius - handTruncation - hourHandTruncation : radius - handTruncation;
        canvas.drawLine(width / 2, height / 2,
                (float) (width / 2 + Math.cos(angle) * handRadius),
                (float) (height / 2 + Math.sin(angle) * handRadius),
                paint);
    }

    private void drawHands(Canvas canvas) {
        Calendar c = Calendar.getInstance();
        float hour = c.get(Calendar.HOUR);
        //5f нужен потому, что на циферблате 1 час = 5 минутам, это для прорисовки стрелки,
        //т.к. код выше рассчитан на минуты b секунды (один оборот = 60 единицам)
        drawHand(canvas, (hour + (float) c.get(Calendar.MINUTE) / 60) * 5f, true);
        drawHand(canvas, c.get(Calendar.MINUTE), false);
        drawHand(canvas, c.get(Calendar.SECOND), false);
    }

    private void drawNumeral(Canvas canvas) {
        paint.setTextSize(fontSize);

        for (int number : numbers) {
            String tmp = String.valueOf(number);
            paint.getTextBounds(tmp, 0, tmp.length(), rect);
            //3.14 / 6 * (-2) = -1.0467
            //3,14 / 6 * (-1) = -0,52 и т.д.
            //2Pi - полный оборот, нам нужно нарисовать 12 чисел, поэтому 2Pi / 12 = Pi / 6
            //(number - 3) - нужен для правильного расположения чисел по кругу
            double angle = Math.PI / 6 * (number - 3);
            int x = (int) (width / 2 + Math.cos(angle) * radius - rect.width() / 2);
            int y = (int) (height / 2 + Math.sin(angle) * radius + rect.height() / 2);
            canvas.drawText(tmp, x, y, paint);

            x = (int) (width / 2 + Math.cos(angle) * (radius + padding - 10));
            y = (int) (height / 2 + Math.sin(angle) * (radius + padding - 10));
            int stopX = (int) (width / 2 + Math.cos(angle) * (radius + 25));
            int stopY = (int) (height / 2 + Math.sin(angle) * (radius + 25));
            canvas.drawLine(x, y, stopX, stopY, paint);
        }
    }

    private void drawCenter(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(width / 2, height / 2, 12, paint);
    }

    private void drawCircle(Canvas canvas) {
        paint.reset();
        paint.setColor(ContextCompat.getColor(getContext(), android.R.color.white));
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        canvas.drawCircle(width / 2, height / 2, radius + padding - 10, paint);
    }

}
