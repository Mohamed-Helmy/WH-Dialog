package dialog.wh;

import android.arch.lifecycle.ReportFragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import dialog.wh.lib.WHBuilder;
import dialog.wh.lib.WHDialog;
import dialog.wh.lib.WHDialogFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WHDialog whDialog = new WHDialog(MainActivity.this,
                        new WHBuilder()
                                .setToolbarColor("#9301d2")
                                .setBackgroundColor("#ffffff")
                                .setDialogRadius(20)
                                .setToolbarTitle("sadasdsad")
                                .setDialogHieght(500)
                                .setToolbarIcon(getDrawable(R.drawable.ic_launcher_background))
                                .setImage("https://i.stack.imgur.com/AYKAp.png").setImageName("helmy.png")

                );
                whDialog.show();
                whDialog.setCancelable(false);

//                TestFragment testFragment=new TestFragment();
//
//                WHDialogFragment whDialogFragment = new WHDialogFragment();
//                WHDialogFragment.builder=new WHBuilder().setToolbarTitle("dfsd")
//                .build(testFragment,getSupportFragmentManager())
//                ;
//                whDialogFragment.show(getSupportFragmentManager(),"");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
