package l9;

import android.app.Dialog;
import android.content.Context;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f11119a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, j jVar) {
        super(context, R.style.CmpActivityTheme);
        this.f11119a = jVar;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.f11119a.a();
    }
}
