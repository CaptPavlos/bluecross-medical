package l4;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.Updates;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class h9 implements ActivityResultCallback, Toolbar.OnMenuItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Updates f10465a;

    public /* synthetic */ h9(Updates updates) {
        this.f10465a = updates;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        int i10 = Updates.f6656p0;
        if (((ActivityResult) obj).getResultCode() == -1) {
            Updates updates = this.f10465a;
            updates.f10934v = new t1.c(updates, 4);
            updates.M0(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        int i10 = Updates.f6656p0;
        menuItem.getClass();
        int itemId = menuItem.getItemId();
        Updates updates = this.f10465a;
        if (itemId == R.id.action_show_system_apps) {
            boolean zIsChecked = menuItem.isChecked();
            boolean z9 = !zIsChecked;
            menuItem.setChecked(z9);
            Context applicationContext = updates.getApplicationContext();
            applicationContext.getClass();
            z1.t1.N(applicationContext, "show_system_apps", z9);
            if (zIsChecked) {
                Context applicationContext2 = updates.getApplicationContext();
                applicationContext2.getClass();
                z1.t1.N(applicationContext2, "show_system_services", false);
                a4.q0(updates.I0().f7448i, false);
                Toolbar toolbar = updates.I0().f7448i;
                if (toolbar.getMenu() != null) {
                    Menu menu = toolbar.getMenu();
                    menu.getClass();
                    menu.findItem(R.id.action_show_system_services).setChecked(false);
                }
                updates.M0(true);
                return true;
            }
            a4.q0(updates.I0().f7448i, true);
            float f = UptodownApp.E;
            if (k4.c.E(updates)) {
                u7.m0 m0Var = updates.J0().f11049c;
                Boolean bool = Boolean.TRUE;
                m0Var.getClass();
                m0Var.g(null, bool);
                return true;
            }
        } else if (menuItem.getItemId() == R.id.action_show_system_services) {
            boolean zIsChecked2 = menuItem.isChecked();
            boolean z10 = !zIsChecked2;
            menuItem.setChecked(z10);
            Context applicationContext3 = updates.getApplicationContext();
            applicationContext3.getClass();
            try {
                SharedPreferences.Editor editorEdit = applicationContext3.getSharedPreferences("SettingsPreferences", 0).edit();
                editorEdit.putBoolean("show_system_services", z10);
                editorEdit.apply();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (zIsChecked2) {
                updates.M0(true);
            } else {
                float f10 = UptodownApp.E;
                if (k4.c.E(updates)) {
                    u7.m0 m0Var2 = updates.J0().f11049c;
                    Boolean bool2 = Boolean.TRUE;
                    m0Var2.getClass();
                    m0Var2.g(null, bool2);
                }
            }
        }
        return true;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        int i10 = Updates.f6656p0;
        float f = UptodownApp.E;
        Updates updates = this.f10465a;
        if (!k4.c.E(updates)) {
            updates.I0().h.setRefreshing(false);
            return;
        }
        u7.m0 m0Var = updates.J0().f11049c;
        Boolean bool = Boolean.TRUE;
        m0Var.getClass();
        m0Var.g(null, bool);
    }
}
