package stelio.braga.steliobrga.MyListe.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.kishannareshpal.lib.AppMenu;
import com.kishannareshpal.lib.AppMenuPropertiesDelegate;

import stelio.braga.steliobrga.MyListe.activites.Add_Categoria_Activity;
import stelio.braga.steliobrga.MyListe.activites.Listem_item_Activity;
import stelio.braga.steliobrga.MyListe.activites.ProdutoActivity;
import stelio.braga.steliobrga.MyListe.R;

public class MyAppMenuPropertiesDelegate implements AppMenuPropertiesDelegate {

    Context ctx;
    Activity activity;

    public MyAppMenuPropertiesDelegate(Context ctx, Activity activity) {
        this.ctx = ctx;
        this.activity = activity;
    }

    @Override
    public boolean shouldShowAppMenu() {
        return true;
    }

    @Override
    public void prepareMenu(@NonNull Menu menu) {

    }

    @Override
    public boolean shouldShowHeader(int maxMenuHeight) {
        return true;
    }

    @Override
    public int getHeaderResourceId() {
        return R.layout.header_theme_menu;
    }

    @Override
    public void onHeaderViewInflated(@NonNull AppMenu appMenu, @NonNull View view) {

    }

    @Override
    public boolean shouldShowFooter(int maxMenuHeight) {
        return false;
    }

    @Override
    public int getFooterResourceId() {

        return 0;
    }

    @Override
    public void onFooterViewInflated(@NonNull AppMenu appMenu, @NonNull View view) {

    }

    @Override
    public void onMenuItemClicked(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_add:
                Intent  intent = new Intent(activity, ProdutoActivity.class);
                activity.startActivity(intent);
                break;
            case R.id.menu_remove:
                Intent  intents = new Intent(activity, Add_Categoria_Activity.class);
                activity.startActivity(intents);
                break;
            case R.id.menu_editar:
                Intent  inten = new Intent(activity, Listem_item_Activity.class);
                activity.startActivity(inten);
                break;
                default:
        }



    }
}
