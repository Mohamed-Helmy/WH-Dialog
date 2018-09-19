package dialog.wh.lib;


import android.app.Fragment;

public class WHBuilder {
    private String toolbarColor="";
    private String backgroundColor="";
    private String toolbarTitle="";
    private int toolbarIcon=0;
    private int dialogHieght=300;
    private int radius=20;

    private Fragment fragment;

    public WHBuilder setToolbarColor(String toolbarColor){
        this.toolbarColor=toolbarColor;
        return this;
    }

    public WHBuilder setToolbarTitle(String toolbartitle){
        this.toolbarTitle=toolbartitle;
        return this;
    }
    public WHBuilder setBackgroundColor(String backgroundColor){
        this.backgroundColor=backgroundColor;
        return this;
    }

    public WHBuilder setToolbarIcon(int toolbarIcon){
        this.toolbarIcon=toolbarIcon;
        return this;
    }
    public WHBuilder setDialogHieght(int dialogHieght){
        this.dialogHieght=dialogHieght;
        return this;
    }
    public WHBuilder setDialogRadius(int radius){
        this.radius=radius;
        return this;
    }
    public WHBuilder build(Fragment fragment){
        this.fragment=fragment;
        return this;
    }


    public int getToolbarIcon(){
        return this.toolbarIcon;
    }
    public int getDialogHieght(){
        return this.dialogHieght;

    }
    public int getRadius(){
        return this.radius;
    }

    public String getToolbarColor(){
        return this.toolbarColor;
    }

    public String getBackgroundColor(){
        return this.backgroundColor;
    }
    public String getToolbartitle(){
        return this.toolbarTitle;
    }

    public Fragment getFragment(){
        return this.fragment;
    }

}
