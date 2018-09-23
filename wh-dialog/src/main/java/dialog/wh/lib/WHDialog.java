package dialog.wh.lib;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Environment;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.budiyev.android.imageloader.ImageLoader;

import java.io.File;
import java.io.FileOutputStream;



public class WHDialog extends Dialog implements View.OnClickListener {
    FrameLayout toolbarFrame,bottombarFrame;
    ImageView bodyFrame;
    RelativeLayout dialogLayout;
    Button imgCloseIcon;
    TextView txtTitle;
    ImageView imgIcon;
    public WHDialog(Context context, final WHBuilder builder) {
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
        bodyFrame=(ImageView) findViewById(R.id.image);
        bodyFrame.setBackgroundColor(Color.parseColor(builder.getBackgroundColor()));
        imgCloseIcon=(Button) findViewById(R.id.btn_close);
        imgCloseIcon.setOnClickListener(this);
        if(builder.getToolbarCloseIcon()!=null) {

            imgCloseIcon.setBackground(builder.getToolbarCloseIcon());
        }
        txtTitle=(TextView)findViewById(R.id.txt_title);
        imgIcon=(ImageView)findViewById(R.id.icon);
        if(builder.getToolbartitle()!=null){
            txtTitle.setVisibility(View.VISIBLE);
            txtTitle.setText(builder.getToolbartitle());
            txtTitle.setTextColor(Color.parseColor(builder.getBackgroundColor()));
        }

        if(builder.getToolbarIcon()!=null){
            imgIcon.setVisibility(View.VISIBLE);
            imgIcon.setImageDrawable(builder.getToolbarIcon());
        }


        if(builder.getImage()!=null){
            ImageLoader.with(getContext())
                    .from(builder.getImage())
                    .placeholder(new ColorDrawable(Color.LTGRAY))
                    .load(bodyFrame);

        }

        bottombarFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap b= ImageLoader.with(getContext())
                        .from(builder.getImage())
                        .placeholder(new ColorDrawable(Color.LTGRAY))
                        .loadSync();
                Toast.makeText(getContext(),storeImage(b,builder.getImageName()),Toast.LENGTH_LONG).show();

            }
        });

    }



    public static String storeImage(Bitmap bitmap, String filename) {

        String stored = null;

        File sdcard = Environment.getExternalStorageDirectory();
        File file = new File(sdcard, filename + ".png");

        if (file.exists())
            file.delete();

        try {
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
            stored = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stored;
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


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_close){
            this.dismiss();
        }
    }
}
