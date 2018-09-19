package dialog.wh.lib;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

public class WHDialog extends Dialog{
    private Context context;
    private String toolbarColor="";
    private String backgroundColor="";
    private int closeIcon = R.drawable.ic_clear_black_24dp;
    private String toolbartitle="";
    private int toolbarIcon=R.drawable.ic_clear_black_24dp;

    public WHDialog(Context context) {
        super(context);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.dailog_layout);
        this.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent);
        Window window = this.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.CENTER_HORIZONTAL;


    }





}
