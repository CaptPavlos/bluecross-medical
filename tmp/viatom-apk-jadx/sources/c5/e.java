package c5;

import android.content.res.Resources;
import androidx.lifecycle.LifecycleOwnerKt;
import c1.f4;
import com.uptodown.activities.MainActivity;
import l4.q2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a3.x f1669a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f1670b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f1671c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f1672d;
    public final /* synthetic */ long e;
    public final /* synthetic */ boolean f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(a3.x xVar, long j10, long j11, String str, long j12, boolean z9, w6.c cVar) {
        super(2, cVar);
        this.f1669a = xVar;
        this.f1670b = j10;
        this.f1671c = j11;
        this.f1672d = str;
        this.e = j12;
        this.f = z9;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new e(this.f1669a, this.f1670b, this.f1671c, this.f1672d, this.e, this.f, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
        e eVar = (e) create((r7.w) obj, (w6.c) obj2);
        s6.w wVar = s6.w.f12711a;
        eVar.invokeSuspend(wVar);
        return wVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Resources.NotFoundException {
        s6.a.e(obj);
        MainActivity mainActivity = ((q2) this.f1669a.f183d).f10752a;
        int i10 = MainActivity.B0;
        mainActivity.E0();
        mainActivity.H0();
        long j10 = this.f1670b;
        if (j10 <= 0) {
            mainActivity.b0();
        } else if (mainActivity.f6644o0 == -1) {
            mainActivity.f6644o0 = j10;
            new c1.l(mainActivity, j10, new f4(this.f1671c, this.e, this.f1672d, mainActivity), LifecycleOwnerKt.getLifecycleScope(mainActivity));
        }
        return s6.w.f12711a;
    }
}
