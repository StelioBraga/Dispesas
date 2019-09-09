package com.kishannareshpal.examescomponents;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.design.button.MaterialButton;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StateView extends LinearLayout {

    private static final int NO_VALUE = 0;
    private static final int CENTER = 17;
    private static final int START = 3;

    public static final int INTEGER_STATE_MODE_NORMAL = 33;
    public static final int INTEGER_STATE_MODE_ALTERNATE = 44;


    // Utils
    Context ctx;

    // Components
    LinearLayout ll_root; // root
    ImageView iv_icon;
    TextView tv_title;
    TextView tv_message;
    MaterialButton btn_action;

    @DrawableRes int iconRes;
    StateMode stateMode;
    int messageGravity;
    String title, message;
    String actionText;
    OnActionButtonClickListener onAction;
    @ColorRes int titleColor, messageColor, actionColor, actionTextColor;

    public interface OnActionButtonClickListener {
        void OnActionButtonClick(MaterialButton actionButton);
    }


    // Action Button
    public StateView actionText(String actionText) {
        this.actionText = actionText;
        changeActionText(actionText);
        return this;
    }
    public StateView actionTextColor(@ColorRes int actionTextColor) {
        this.actionTextColor = actionTextColor;
        changeActionTextColor(actionTextColor);
        return this;
    }
    public StateView actionColor(@ColorRes int actionColor) {
        this.actionColor = actionColor;
        return this;
    }
    public StateView onAction(OnActionButtonClickListener onAction) {
        this.onAction = onAction;
        changeOnAction(onAction);
        return this;
    }

    // Title
    public StateView title(String title) {
        this.title = title;
        changeTitle(title);
        return this;
    }
    public StateView titleColor(@ColorRes int titleColor) {
        this.titleColor = titleColor;
        changeTitleColor(titleColor);
        return this;
    }

    // Message
    public StateView message(String message) {
        this.message = message;
        this.messageGravity = Gravity.CENTER;
        changeMessage(message);
        changeMessageGravity(this.messageGravity);

        return this;
    }
    public StateView message(String message, int messageGravity) {
        this.message = message;
        this.messageGravity = messageGravity;
        changeMessage(message);
        changeMessageGravity(messageGravity);

        return this;
    }
    public StateView messageColor(@ColorRes int messageColor) {
        this.messageColor = messageColor;
        changeMessageColor(messageColor);
        return this;
    }


    // Icon
    public StateView iconRes(@DrawableRes int iconRes) {
        this.iconRes = iconRes;
        changeIconRes(iconRes);
        return this;
    }

    // State Mode
    public StateView stateMode(StateMode stateMode) {
        this.stateMode = stateMode;
        changeState(stateMode);
        return this;
    }



    // Default Constructor
    public StateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.ctx = context;
        init(context, attrs);
    }

    /**
     * Main Method
     */
    private void init(Context ctx, @Nullable AttributeSet attrs){
        inflate(ctx, R.layout.stateview_main, this);
        TypedArray ta = null;

        // Init Inside Components
        ll_root    = findViewById(R.id.ll_root);
        iv_icon    = findViewById(R.id.iv_icon);
        tv_title   = findViewById(R.id.tv_title);
        tv_message = findViewById(R.id.tv_message);
        btn_action = findViewById(R.id.btn_action);

        // if attrs were set via xml
        if (attrs != null) {
            // get the attributes from the attrs.xml
            ta                         = getContext().obtainStyledAttributes(attrs, R.styleable.StateView);
            this.title                 = ta.getString(R.styleable.StateView_stateTitle);
            this.message               = ta.getString(R.styleable.StateView_stateMessage);
            this.iconRes               = ta.getResourceId(R.styleable.StateView_stateIcon, 0);
            this.stateMode             = ta.getInt(R.styleable.StateView_stateMode, INTEGER_STATE_MODE_NORMAL) == INTEGER_STATE_MODE_NORMAL ? StateMode.NORMAL : StateMode.ALTERNATE;

            this.titleColor            = ta.getResourceId(R.styleable.StateView_stateTitleColor, NO_VALUE);
            this.messageColor          = ta.getResourceId(R.styleable.StateView_stateMessageColor, NO_VALUE);
            this.messageGravity        = ta.getInt(R.styleable.StateView_messageGravity, Gravity.CENTER);
            this.actionText            = ta.getString(R.styleable.StateView_stateActionButtonText);
            this.actionColor           = ta.getResourceId(R.styleable.StateView_stateActionButtonColor, NO_VALUE);
            this.actionTextColor       = ta.getResourceId(R.styleable.StateView_stateActionButtonTextColor, NO_VALUE);
        }

        changeState(stateMode);
        changeIconRes(iconRes);

        changeTitle(title);
        changeTitleColor(titleColor);

        changeMessage(message);
        changeMessageGravity(messageGravity);
        changeMessageColor(messageColor);

        changeActionText(actionText);
        changeOnAction(onAction);
        changeActionColor(actionColor);

        if (attrs != null){
            ta.recycle();
        }
    }







    /**
     * Setup Action Button
     */
    private void changeActionText(String actionButtonText){
        if (actionButtonText == null) {
            btn_action.setVisibility(GONE);
            return;
        }
        if (btn_action == null) return;

        btn_action.setText(actionButtonText);
        btn_action.setVisibility(VISIBLE);
    }
    public void changeActionColor(@ColorRes int actionColor){
        if (actionColor == NO_VALUE) return;
        if (btn_action == null) return;
        btn_action.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(ctx, actionColor)));
    }
    public void changeActionTextColor(@ColorRes int actionButtonTextColor){
        if (actionButtonTextColor == NO_VALUE) return;
        if (btn_action == null) return;

        btn_action.setTextColor(ContextCompat.getColor(ctx, actionButtonTextColor));
    }
    private void changeOnAction(final OnActionButtonClickListener onActionButton){
        if (onActionButton == null) return;
        if (btn_action == null) return;

        btn_action.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onActionButton.OnActionButtonClick((MaterialButton) v);
        }
            });

    }



    /**
     * Setup Message
     */
    private void changeMessage(String message){
        if (message != null) {
            if (tv_message.getVisibility() != View.VISIBLE){
                tv_message.setVisibility(View.VISIBLE);
            }
            tv_message.setText(message);

        } else {
            tv_message.setVisibility(View.GONE);
        }
    }
    private void changeMessageGravity(int gravity){
        if (message != null) {
            tv_message.setGravity(gravity);
        }
    }
    private void changeMessageColor(@ColorRes int messageColor){
        if (messageColor == NO_VALUE) return;
        if (tv_message == null) return;
        tv_message.setTextColor(ContextCompat.getColor(ctx, messageColor));
    }



    /**
     * Setup Title
     */
    private void changeTitle(String title){
        if (title != null) {
            if (tv_title.getVisibility() != View.VISIBLE){
                tv_title.setVisibility(View.VISIBLE);
            }
            tv_title.setText(title);

        } else {
            tv_title.setVisibility(View.GONE);
        }
    }
    private void changeTitleGravity(int gravity){
        if (title != null) {
            tv_title.setGravity(gravity);
        } else {
            tv_title.setGravity(Gravity.CENTER);
        }
    }
    private void changeTitleColor(@ColorRes int titleColor){
        if (titleColor == NO_VALUE) return;
        if (tv_title == null) return;
        tv_title.setTextColor(ContextCompat.getColor(ctx, titleColor));
    }


    /**
     * Setup Icon
     */
    private void changeIconRes(@DrawableRes int iconRes){
        if (iconRes == NO_VALUE) return;
        iv_icon.setImageResource(iconRes);
        if (iv_icon.getVisibility() != View.VISIBLE){
            iv_icon.setVisibility(View.VISIBLE);
        }
    }


    /**
     * Setup State changing
     */
    private void changeState(StateMode stateMode){
        switch (stateMode){
            case NORMAL:
                ll_root.setVisibility(GONE);
                break;

            case ALTERNATE:
                ll_root.setVisibility(VISIBLE);
                break;
        }
    }
}
