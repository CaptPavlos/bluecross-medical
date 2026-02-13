package l4;

import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import java.io.File;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class g2 implements ActivityResultCallback, TabLayoutMediator.TabConfigurationStrategy {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10420a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f10421b;

    public /* synthetic */ g2(int i10, MainActivity mainActivity) {
        this.f10420a = i10;
        this.f10421b = mainActivity;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) throws Resources.NotFoundException {
        Bundle extras;
        int i10 = this.f10420a;
        w6.c cVar = null;
        MainActivity mainActivity = this.f10421b;
        ActivityResult activityResult = (ActivityResult) obj;
        switch (i10) {
            case 0:
                int i11 = MainActivity.B0;
                if (activityResult.getResultCode() == -1) {
                    mainActivity.f10934v = new t1.c(mainActivity, 4);
                    break;
                }
                break;
            case 1:
                int i12 = MainActivity.B0;
                int resultCode = activityResult.getResultCode();
                if (resultCode == 1003) {
                    v5.g gVarL = v5.g.f13148u.l(mainActivity);
                    gVarL.a();
                    SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
                    sQLiteDatabase.getClass();
                    sQLiteDatabase.delete("responses", null, null);
                    gVarL.b();
                    mainActivity.finish();
                    mainActivity.startActivity(mainActivity.getIntent());
                    break;
                } else if (resultCode == 1004) {
                    float f = UptodownApp.E;
                    k4.c.d(mainActivity);
                    mainActivity.finish();
                    mainActivity.startActivity(mainActivity.getIntent());
                    break;
                } else {
                    mainActivity.R();
                    break;
                }
            case 2:
                int i13 = MainActivity.B0;
                int resultCode2 = activityResult.getResultCode();
                if (resultCode2 == -1) {
                    mainActivity.d1();
                    e5.m1 m1Var = mainActivity.l0;
                    if (m1Var != null) {
                        m1Var.a().g.setVisibility(8);
                        m1Var.a().f7212d.setVisibility(0);
                        break;
                    }
                } else if (resultCode2 == 1) {
                    h5.e1 e1VarO0 = mainActivity.o0();
                    ArrayList arrayList = mainActivity.N;
                    if (e1VarO0 != null && mainActivity.P != null) {
                        int size = arrayList.size();
                        int i14 = mainActivity.M;
                        if (size > i14 && ((h5.m1) arrayList.get(i14)).f8665a == 5) {
                            mainActivity.A0();
                        }
                    }
                    mainActivity.d1();
                    break;
                }
                break;
            case 3:
                int i15 = MainActivity.B0;
                int resultCode3 = activityResult.getResultCode();
                if (resultCode3 == -1) {
                    mainActivity.d1();
                    e5.m1 m1Var2 = mainActivity.l0;
                    if (m1Var2 != null) {
                        m1Var2.a().g.setVisibility(8);
                        m1Var2.a().f7212d.setVisibility(0);
                        break;
                    }
                } else if (resultCode3 == 1) {
                    if (mainActivity.o0() != null) {
                        mainActivity.c1();
                    }
                    mainActivity.d1();
                    break;
                } else if (resultCode3 == 1003) {
                    mainActivity.finish();
                    mainActivity.startActivity(mainActivity.getIntent());
                    break;
                } else if (resultCode3 == 1004) {
                    mainActivity.finish();
                    mainActivity.startActivity(mainActivity.getIntent());
                    break;
                }
                break;
            case 4:
                int i16 = MainActivity.B0;
                if (activityResult.getResultCode() == 10) {
                    Intent data = activityResult.getData();
                    String string = (data == null || (extras = data.getExtras()) == null) ? null : extras.getString("realPath");
                    if (string != null && string.length() != 0) {
                        mainActivity.U(new File(string), null);
                        break;
                    }
                }
                break;
            default:
                int i17 = MainActivity.B0;
                o2 o2Var = new o2(mainActivity);
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(mainActivity);
                y7.e eVar = r7.i0.f12407a;
                r7.y.q(lifecycleScope, y7.d.f14116a, null, new a3.o(mainActivity, o2Var, cVar, 17), 2);
                break;
        }
    }

    @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
    public void onConfigureTab(TabLayout.Tab tab, int i10) {
        int i11 = MainActivity.B0;
        tab.getClass();
        MainActivity mainActivity = this.f10421b;
        if (i10 == 0) {
            tab.setContentDescription(mainActivity.getString(R.string.cd_home_tab));
            tab.setIcon(ContextCompat.getDrawable(mainActivity, R.drawable.selector_icon_tab_home));
            return;
        }
        if (i10 == 1) {
            tab.setContentDescription(mainActivity.getString(R.string.top_games_title));
            tab.setIcon(ContextCompat.getDrawable(mainActivity, R.drawable.selector_icon_tab_games));
            return;
        }
        if (i10 == 2) {
            tab.setContentDescription(mainActivity.getString(R.string.apps));
            tab.setIcon(ContextCompat.getDrawable(mainActivity, R.drawable.selector_icon_tab_apps));
        } else {
            if (i10 != 3) {
                return;
            }
            tab.setContentDescription(mainActivity.getString(R.string.my_feed));
            h5.e1 e1VarH = h5.c1.h(mainActivity);
            if (e1VarH == null || !e1VarH.f8523p) {
                tab.setIcon(ContextCompat.getDrawable(mainActivity, R.drawable.selector_icon_tab_feed));
            } else {
                tab.setIcon(ContextCompat.getDrawable(mainActivity, R.drawable.selector_icon_tab_feed_badge));
            }
        }
    }
}
