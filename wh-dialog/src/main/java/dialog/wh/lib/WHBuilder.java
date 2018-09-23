package dialog.wh.lib;

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.drawable.Drawable;

public class WHBuilder {
    private String toolbarColor = "#3300ec";
    private String backgroundColor = "#ffffff";
    private String toolbarTitle = null;
    private Drawable toolbarIcon = null;
    private Drawable toolbarCloseIcon = null;
    private int dialogHieght = 500;
    private int radius = 20;
    private String Image;
    private String ImageName;

    private Fragment fragment;
    private FragmentManager fragmentManager;
    public WHBuilder setImageName(String ImageName){
        this.ImageName=ImageName;
        return this;
    }

    public String getImageName(){
        return this.ImageName;
    }


    public WHBuilder setImage(String Image){
        this.Image=Image;
        return this;
    }

    public String getImage(){
        return this.Image;
    }
    public WHBuilder setToolbarColor(String toolbarColor) {
        this.toolbarColor = toolbarColor;
        return this;
    }

    public WHBuilder setToolbarTitle(String toolbartitle) {
        this.toolbarTitle = toolbartitle;
        return this;
    }

    public WHBuilder setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public WHBuilder setToolbarIcon(Drawable toolbarIcon) {
        this.toolbarIcon = toolbarIcon;
        return this;
    }

    public WHBuilder setToolbarCloseIcon(Drawable toolbarCloseIcon) {
        this.toolbarCloseIcon = toolbarCloseIcon;
        return this;
    }

    public WHBuilder setDialogHieght(int dialogHieght) {
        this.dialogHieght = dialogHieght;
        return this;
    }

    public WHBuilder setDialogRadius(int radius) {
        this.radius = radius;
        return this;
    }

    public WHBuilder build(Fragment fragment,FragmentManager fragmentManager) {
        this.fragment = fragment;
        return this;
    }



    public Drawable getToolbarCloseIcon() {
        return this.toolbarCloseIcon;
    }

    public Drawable getToolbarIcon() {
        return this.toolbarIcon;
    }

    public int getDialogHieght() {
        return this.dialogHieght;

    }

    public int getRadius() {
        return this.radius;
    }

    public String getToolbarColor() {
        return this.toolbarColor;
    }

    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    public String getToolbartitle() {
        return this.toolbarTitle;
    }

    public Fragment getFragment() {
        return this.fragment;
    }
    public FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }
}
