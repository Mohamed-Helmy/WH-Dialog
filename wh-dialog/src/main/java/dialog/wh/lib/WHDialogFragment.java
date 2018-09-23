package dialog.wh.lib;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WHDialogFragment extends DialogFragment implements View.OnClickListener {
    FrameLayout toolbarFrame,bottombarFrame,bodyFrame;

    RelativeLayout dialogLayout;
    Button imgCloseIcon;
    TextView txtTitle;
    ImageView imgIcon;
    public  static  WHBuilder builder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  builder=new WHBuilder();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.dailog_layout, container, false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Window window = getActivity().getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.CENTER_HORIZONTAL;
        toolbarFrame=(FrameLayout)rootView.findViewById(R.id.toolbar_frame);
        bottombarFrame=(FrameLayout)rootView.findViewById(R.id.bottom_bar_frame);
        dialogLayout=(RelativeLayout)rootView.findViewById(R.id.dialog);
        final float scale = getActivity().getResources().getDisplayMetrics().density;
        int px = (int) (builder.getDialogHieght() * scale + 0.5f);
        dialogLayout.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,px));
        toolbarFrame.setBackground(getToolbarShape(builder));
        bottombarFrame.setBackground(getBottombarShape(builder));
        bodyFrame.setBackgroundColor(Color.parseColor(builder.getBackgroundColor()));
        imgCloseIcon=(Button) rootView.findViewById(R.id.btn_close);
        imgCloseIcon.setOnClickListener(this);
        if(builder.getToolbarCloseIcon()!=null) {
            imgCloseIcon.setBackground(builder.getToolbarCloseIcon());
        }
        txtTitle=(TextView)rootView.findViewById(R.id.txt_title);
        imgIcon=(ImageView)rootView.findViewById(R.id.icon);
        if(builder.getToolbartitle()!=null){
            txtTitle.setVisibility(View.VISIBLE);
            txtTitle.setText(builder.getToolbartitle());
            txtTitle.setTextColor(Color.parseColor(builder.getBackgroundColor()));
        }
        if(builder.getToolbarIcon()!=null){
            imgIcon.setVisibility(View.VISIBLE);
            imgIcon.setImageDrawable(builder.getToolbarIcon());
        }
        bottombarFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return rootView;
    }



    private GradientDrawable getToolbarShape(WHBuilder builder){
        final float scale = getActivity().getResources().getDisplayMetrics().density;
        int x = (int) (builder.getRadius() * scale + 0.5f);
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadii(new float[] { x, x, x, x, 0, 0, 0, 0 });
        shape.setColor(Color.parseColor(builder.getToolbarColor()));
        return shape;
    }

    private GradientDrawable getBottombarShape(WHBuilder builder){
        final float scale = getActivity().getResources().getDisplayMetrics().density;
        int x = (int) (builder.getRadius() * scale + 0.5f);
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadii(new float[] { 0, 0, 0, 0, x, x, x, x });
        shape.setColor(Color.parseColor(builder.getBackgroundColor()));
        return shape;
    }



    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_close){
            this.dismiss();
        }
    }
}
