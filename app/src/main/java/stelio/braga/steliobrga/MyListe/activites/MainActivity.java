package stelio.braga.steliobrga.MyListe.activites;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import com.kishannareshpal.lib.AppMenuButtonHelper;
import com.kishannareshpal.lib.AppMenuHandler;

import stelio.braga.steliobrga.MyListe.utils.MyAppMenuPropertiesDelegate;
import stelio.braga.steliobrga.MyListe.R;
import stelio.braga.steliobrga.MyListe.fragment.CategoriaFragment;
import stelio.braga.steliobrga.MyListe.utils.MyUtils;

public class MainActivity extends AppCompatActivity {


    FloatingActionButton bt_floating, fab1, fab2, fab3;
    boolean isFABOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_floating = findViewById(R.id.fab);
        fab1 = findViewById(R.id.fab1);
        fab2 = findViewById(R.id.fab2);
        fab3 = findViewById(R.id.fab3);

        //fragment
        int framelayout = R.id.fl_frameLayout;
        CategoriaFragment homeFragment = new CategoriaFragment();
        MyUtils.changeFragment(framelayout, homeFragment, getSupportFragmentManager());

        MyAppMenuPropertiesDelegate listener = new MyAppMenuPropertiesDelegate(this, this);
        AppMenuHandler handler = new AppMenuHandler(this, listener, R.menu.fab_popup_menu);
        AppMenuButtonHelper helper = new AppMenuButtonHelper(handler);
        bt_floating.setOnTouchListener(helper);


        // FLOATING BUTTON
//        bt_floating.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Handle the click.
////                if (!isFABOpen) {
////                    showFABMenu();
////                } else {
////                    closeFABMenu();
////                }
//
//                showPopup(view);
//
//            }
//        });


    }

    private void showPopup(View view) {



//
//        PopupMenu popup = new PopupMenu(this, view);
//        popup.getMenuInflater().inflate(R.menu.fab_popup_menu, popup.getMenu());
//        popup.show();
    }

    private void showFABMenu() {
        isFABOpen = true;
        int height = fab1.getHeight();

        fab1.animate().translationY(-height - 4);
        fab2.animate().translationY(-height - height - 4 - 4);
        fab3.animate().translationY(-height - height - 4 - height - 4 - 4);
    }

    private void closeFABMenu() {
        isFABOpen = false;
        fab1.animate().translationY(0);
        fab2.animate().translationY(0);
        fab3.animate().translationY(0);
    }


}
