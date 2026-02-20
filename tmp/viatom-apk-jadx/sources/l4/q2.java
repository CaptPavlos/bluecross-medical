package l4;

import com.uptodown.R;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q2 implements g5.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainActivity f10752a;

    public /* synthetic */ q2(MainActivity mainActivity) {
        this.f10752a = mainActivity;
    }

    @Override // g5.i
    public void f(int i10) {
        MainActivity mainActivity = this.f10752a;
        mainActivity.f6644o0 = -1L;
        String string = mainActivity.getString(R.string.app_detail_not_found);
        string.getClass();
        mainActivity.C(string);
    }

    @Override // g5.i
    public void l(h5.h hVar) {
        MainActivity mainActivity = this.f10752a;
        mainActivity.m0(hVar);
        mainActivity.f6644o0 = -1L;
    }
}
