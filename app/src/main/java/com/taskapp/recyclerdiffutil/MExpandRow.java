package com.taskapp.recyclerdiffutil;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;

public class MExpandRow extends FrameLayout {
    private String titleText = "Title";
    private TextView titleView;
    private ConstraintLayout child;
    private ConstraintLayout tail;
    private final Context context;
    private int startIcon = 0;
    private ImageView startIconView;

    private void createView() {
        inflate(context, R.layout.extented_row, this);
        titleView = findViewById(R.id.title);
        child = findViewById(R.id.childView);
        tail = findViewById(R.id.tail);
        startIconView = findViewById(R.id.start_icon);
        ImageView endIconView = findViewById(R.id.end_icon);
        endIconView.setOnClickListener(view -> {
            if (tail.getVisibility() == VISIBLE) {
                tail.setVisibility(GONE);
                endIconView.setImageResource(R.drawable.ic_open);
                return;
            }
            tail.setVisibility(VISIBLE);
            endIconView.setImageResource(R.drawable.ic_close);
        });




    }

    public MExpandRow(@NonNull Context context) {
        super(context);
        this.context = context;
        createView();
    }

    public MExpandRow(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        createView();

    }

    public MExpandRow(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        createView();

    }


    public void setView(View childView) {
        child.addView(childView);
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
        titleView.setText(titleText);

    }


    public void setStartIcon(int startIcon) {
        this.startIcon = startIcon;
        if (startIcon != 0) {
            startIconView.setVisibility(VISIBLE);
            startIconView.setImageResource(startIcon);
        }
        startIconView.setVisibility(GONE);

    }


}
