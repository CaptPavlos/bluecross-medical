package l4;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.SearchActivity;
import com.uptodown.views.InstantAutoCompleteTextView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class q8 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10769a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchActivity f10770b;

    public /* synthetic */ q8(SearchActivity searchActivity, int i10) {
        this.f10769a = i10;
        this.f10770b = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f10769a;
        SearchActivity searchActivity = this.f10770b;
        switch (i10) {
            case 0:
                int i11 = SearchActivity.Q;
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    searchActivity.finish();
                    break;
                }
                break;
            case 1:
                int i12 = SearchActivity.Q;
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    ((InstantAutoCompleteTextView) searchActivity.o0().f7377b.f13463c).setText("");
                    break;
                }
                break;
            case 2:
                int i13 = SearchActivity.Q;
                float f11 = UptodownApp.E;
                if (k4.c.s()) {
                    try {
                        searchActivity.P.launch(new Intent("android.speech.action.RECOGNIZE_SPEECH"));
                        break;
                    } catch (ActivityNotFoundException e) {
                        e.printStackTrace();
                        String string = searchActivity.getString(R.string.feature_not_supported);
                        string.getClass();
                        searchActivity.C(string);
                        return;
                    }
                }
                break;
            default:
                view.getClass();
                float f12 = UptodownApp.E;
                if (k4.c.s()) {
                    Object tag = view.getTag();
                    tag.getClass();
                    t3.h hVar = v5.g.f13148u;
                    Context applicationContext = searchActivity.getApplicationContext();
                    applicationContext.getClass();
                    v5.g gVarL = hVar.l(applicationContext);
                    gVarL.a();
                    SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
                    sQLiteDatabase.getClass();
                    int iDelete = sQLiteDatabase.delete("recent_searches", "search=?", new String[]{(String) tag});
                    gVarL.b();
                    if (iDelete > 0) {
                        t8 t8Var = searchActivity.L;
                        t8Var.getClass();
                        t8Var.getFilter().filter(((InstantAutoCompleteTextView) searchActivity.o0().f7377b.f13463c).getText().toString());
                        break;
                    }
                }
                break;
        }
    }
}
