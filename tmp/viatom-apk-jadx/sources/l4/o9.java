package l4;

import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.Updates;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o9 implements g5.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Updates f10695a;

    public /* synthetic */ o9(Updates updates) {
        this.f10695a = updates;
    }

    @Override // g5.k
    public void k() {
        float f = UptodownApp.E;
        if (k4.c.s()) {
            Updates updates = this.f10695a;
            String string = updates.getString(R.string.disabled_apps_explanation);
            string.getClass();
            updates.N(string);
        }
    }
}
