package com.example.fishinbank;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import java.util.Map;

public class PieChartView extends View {
    private Paint paint;
    private int[] colors = {
            Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW,
            Color.CYAN, Color.MAGENTA, Color.GRAY, Color.DKGRAY
    };

    public PieChartView(Context context) {
        super(context);
        init();
    }

    public PieChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PieChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Проверяем, есть ли данные
        if (DataManager.expensesByCategory == null || DataManager.expensesByCategory.isEmpty()) {
            drawEmptyChart(canvas);
            return;
        }

        double totalExpenses = 0.0;
        for (double value : DataManager.expensesByCategory.values()) {
            totalExpenses += value;
        }

        if (totalExpenses == 0.0) {
            drawEmptyChart(canvas);
            return;
        }

        float startAngle = 0f;
        int colorIndex = 0;
        float padding = 10f;
        RectF rect = new RectF(padding, padding, getWidth() - padding, getHeight() - padding);

        // Рисуем сегменты для каждой категории расходов
        for (Map.Entry<String, Double> entry : DataManager.expensesByCategory.entrySet()) {
            double value = entry.getValue();
            float sweepAngle = (float) (value / totalExpenses * 360);

            paint.setColor(colors[colorIndex % colors.length]);
            canvas.drawArc(rect, startAngle, sweepAngle, true, paint);

            startAngle += sweepAngle;
            colorIndex++;
        }

        // Добавляем заголовок
        drawTitle(canvas, "Расходы");
    }

    private void drawEmptyChart(Canvas canvas) {
        paint.setColor(Color.LTGRAY);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4f);
        float padding = 10f;
        RectF rect = new RectF(padding, padding, getWidth() - padding, getHeight() - padding);
        canvas.drawArc(rect, 0f, 360f, false, paint);
        paint.setStyle(Paint.Style.FILL);

        drawTitle(canvas, "Расходы (нет данных)");
    }

    private void drawTitle(Canvas canvas, String title) {
        Paint textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(24f);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setAntiAlias(true);

        float x = getWidth() / 2f;
        float y = getHeight() - 20f;
        canvas.drawText(title, x, y, textPaint);
    }
}