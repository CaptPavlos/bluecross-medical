package l4;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10543a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10544b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10545c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MainActivity f10546d;

    public /* synthetic */ k2(MainActivity mainActivity, int i10, String str, int i11) {
        this.f10543a = i11;
        this.f10546d = mainActivity;
        this.f10544b = i10;
        this.f10545c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h5.y0 y0VarM;
        switch (this.f10543a) {
            case 0:
                MainActivity mainActivity = this.f10546d;
                Fragment fragmentG0 = mainActivity.G0();
                if (fragmentG0 instanceof e5.j0) {
                    mainActivity.runOnUiThread(new e5.v(this.f10544b, 1, (e5.j0) fragmentG0, this.f10545c));
                    break;
                }
                break;
            default:
                MainActivity mainActivity2 = this.f10546d;
                String str = this.f10545c;
                if (str != null) {
                    t3.h hVar = v5.g.f13148u;
                    Context baseContext = mainActivity2.getBaseContext();
                    baseContext.getClass();
                    v5.g gVarL = hVar.l(baseContext);
                    gVarL.a();
                    y0VarM = gVarL.M(str);
                    gVarL.b();
                } else {
                    y0VarM = null;
                }
                Fragment fragmentG02 = mainActivity2.G0();
                if (y0VarM != null && (fragmentG02 instanceof e5.j0)) {
                    mainActivity2.runOnUiThread(new e5.v(this.f10544b, (e5.j0) fragmentG02, 0, y0VarM));
                    break;
                }
                break;
        }
    }
}
