package l4;

import android.content.Intent;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.SearchActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u8 implements g5.i, g5.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchActivity f10885a;

    public /* synthetic */ u8(SearchActivity searchActivity) {
        this.f10885a = searchActivity;
    }

    @Override // g5.i
    public void l(h5.h hVar) {
        long j10 = hVar.A;
        SearchActivity searchActivity = this.f10885a;
        if (j10 > 0 && hVar.k()) {
            float f = UptodownApp.E;
            k4.c.t(hVar, searchActivity);
        } else {
            Intent intent = new Intent(searchActivity, (Class<?>) AppDetailActivity.class);
            intent.putExtra("appInfo", hVar);
            float f10 = UptodownApp.E;
            searchActivity.startActivity(intent, k4.c.a(searchActivity));
        }
    }

    @Override // g5.c
    public void z(h5.h hVar) {
        hVar.getClass();
        float f = UptodownApp.E;
        if (k4.c.s()) {
            this.f10885a.Y(hVar.f8566a);
        }
    }

    @Override // g5.i
    public void f(int i10) {
    }
}
