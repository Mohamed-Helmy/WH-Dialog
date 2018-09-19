package dialog.wh.lib;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class WHDialog extends Dialog{
    FrameLayout toolbarFrame,bottombarFrame,bodyFrame;
    RelativeLayout dialogLayout;
    public WHDialog(Context context,WHBuilder builder) {
        super(context);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.dailog_layout);
        this.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent);
        Window window = this.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.CENTER_HORIZONTAL;
        toolbarFrame=(FrameLayout)findViewById(R.id.toolbar_frame);
        bottombarFrame=(FrameLayout)findViewById(R.id.bottom_bar_frame);
        dialogLayout=(RelativeLayout)findViewById(R.id.dialog);
        final float scale = getContext().getResources().getDisplayMetrics().density;
        int px = (int) (builder.getDialogHieght() * scale + 0.5f);
        dialogLayout.getLayoutParams().height=px;
        toolbarFrame.setBackground(getToolbarShape(builder));
        bottombarFrame.setBackground(getBottombarShape(builder));
        bodyFrame=(FrameLayout)findViewById(R.id.body);
        bodyFrame.setBackgroundColor(Color.parseColor(builder.getBackgroundColor()));

    }


    private GradientDrawable getToolbarShape(WHBuilder builder){
        final float scale = getContext().getResources().getDisplayMetrics().density;
        int x = (int) (builder.getRadius() * scale + 0.5f);
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadii(new float[] { x, x, x, x, 0, 0, 0, 0 });
        shape.setColor(Color.parseColor(builder.getToolbarColor()));
        return shape;
    }

    private GradientDrawable getBottombarShape(WHBuilder builder){
        final float scale = getContext().getResources().getDisplayMetrics().density;
        int x = (int) (builder.getRadius() * scale + 0.5f);
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadii(new float[] { 0, 0, 0, 0, x, x, x, x });
        shape.setColor(Color.parseColor(builder.getBackgroundColor()));
        return shape;
    }



}
