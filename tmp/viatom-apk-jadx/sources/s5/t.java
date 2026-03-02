package s5;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.tv.ui.activity.TvMyAppsActivity;
import com.uptodown.tv.ui.activity.TvMyDownloadsActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class t implements ActivityResultCallback, OnItemViewClickedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f12672a;

    public /* synthetic */ t(u uVar) {
        this.f12672a = uVar;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        int resultCode = ((ActivityResult) obj).getResultCode();
        u uVar = this.f12672a;
        if (resultCode != 1003) {
            if (resultCode != 1004) {
                return;
            }
            float f = UptodownApp.E;
            Context contextRequireContext = uVar.requireContext();
            contextRequireContext.getClass();
            k4.c.d(contextRequireContext);
            String string = uVar.getString(R.string.restart_for_changes_take_effect);
            string.getClass();
            uVar.a(string);
            return;
        }
        t3.h hVar = v5.g.f13148u;
        Context contextRequireContext2 = uVar.requireContext();
        contextRequireContext2.getClass();
        v5.g gVarL = hVar.l(contextRequireContext2);
        gVarL.a();
        SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.delete("responses", null, null);
        gVarL.b();
        String string2 = uVar.getString(R.string.restart_for_changes_take_effect);
        string2.getClass();
        uVar.a(string2);
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof o5.b) {
            int i10 = ((o5.b) obj).f11731a;
            u uVar = this.f12672a;
            if (i10 == 0) {
                Intent intent = new Intent(uVar.getContext(), (Class<?>) TvMyAppsActivity.class);
                intent.putExtra("updates", true);
                uVar.startActivity(intent);
                return;
            }
            if (i10 == 1) {
                uVar.startActivity(new Intent(uVar.getContext(), (Class<?>) TvMyAppsActivity.class));
                return;
            }
            if (i10 == 2) {
                Intent intent2 = new Intent(uVar.getContext(), (Class<?>) TvMyAppsActivity.class);
                intent2.putExtra("rollback", true);
                uVar.startActivity(intent2);
            } else if (i10 == 3) {
                uVar.startActivity(new Intent(uVar.getContext(), (Class<?>) TvMyDownloadsActivity.class));
            } else {
                if (i10 != 4) {
                    return;
                }
                uVar.f12674b.launch(new Intent(uVar.getContext(), (Class<?>) PreferencesActivity.class));
            }
        }
    }
}
