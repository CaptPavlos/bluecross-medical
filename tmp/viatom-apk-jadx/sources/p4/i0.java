package p4;

import androidx.leanback.widget.DetailsOverviewRow;
import c1.g1;
import com.google.android.gms.internal.measurement.j4;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import com.uptodown.tv.ui.fragment.TvMyDownloadsFragment;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11971a;

    /* renamed from: b, reason: collision with root package name */
    public int f11972b;

    /* renamed from: c, reason: collision with root package name */
    public Object f11973c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f11974d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(int i10, g1 g1Var, u4.b bVar, w6.c cVar) {
        super(2, cVar);
        this.f11971a = 1;
        this.f11973c = g1Var;
        this.f11974d = bVar;
        this.f11972b = i10;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f11971a) {
            case 0:
                return new i0((InstallerActivity) this.f11973c, this.f11972b, (kotlin.jvm.internal.x) this.f11974d, cVar, 0);
            case 1:
                return new i0(this.f11972b, (g1) this.f11973c, (u4.b) this.f11974d, cVar);
            case 2:
                return new i0((g1) this.f11973c, (ArrayList) this.f11974d, cVar, 2);
            case 3:
                return new i0((s4.n) this.f11974d, cVar, 3);
            case 4:
                return new i0(this.f11972b, (s4.n) this.f11973c, this.f11974d, cVar);
            case 5:
                return new i0((s4.n) this.f11973c, this.f11972b, (String) this.f11974d, cVar, 5);
            case 6:
                return new i0((g1) this.f11973c, (kotlin.jvm.internal.u) this.f11974d, cVar, 6);
            case 7:
                return new i0((TvAppDetailFragment) this.f11973c, (h5.h) this.f11974d, cVar, 7);
            case 8:
                return new i0((TvAppDetailFragment) this.f11973c, (h5.q) this.f11974d, cVar, 8);
            case 9:
                return new i0((TvAppDetailFragment) this.f11973c, (DetailsOverviewRow) this.f11974d, cVar, 9);
            case 10:
                return new i0((TvMyDownloadsFragment) this.f11973c, (ArrayList) this.f11974d, cVar, 10);
            case 11:
                i0 i0Var = new i0((t7.u) this.f11974d, cVar, 11);
                i0Var.f11973c = obj;
                return i0Var;
            case 12:
                i0 i0Var2 = new i0((u7.d) this.f11974d, cVar, 12);
                i0Var2.f11973c = obj;
                return i0Var2;
            case 13:
                i0 i0Var3 = new i0((u7.d) this.f11974d, cVar, 13);
                i0Var3.f11973c = obj;
                return i0Var3;
            case 14:
                return new i0((u7.h) this.f11973c, (v7.o) this.f11974d, cVar, 14);
            case 15:
                i0 i0Var4 = new i0((u7.i) this.f11974d, cVar, 15);
                i0Var4.f11973c = obj;
                return i0Var4;
            case 16:
                return new i0((j4) this.f11973c, (ArrayList) this.f11974d, cVar, 16);
            default:
                return new i0((t1.c) this.f11973c, (File) this.f11974d, cVar, 17);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        switch (this.f11971a) {
            case 0:
                i0 i0Var = (i0) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar = s6.w.f12711a;
                i0Var.invokeSuspend(wVar);
                break;
            case 1:
                i0 i0Var2 = (i0) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar2 = s6.w.f12711a;
                i0Var2.invokeSuspend(wVar2);
                break;
        }
        return ((i0) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0289  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1926
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.i0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(int i10, s4.n nVar, Object obj, w6.c cVar) {
        super(2, cVar);
        this.f11971a = 4;
        this.f11972b = i10;
        this.f11973c = nVar;
        this.f11974d = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(Object obj, int i10, Serializable serializable, w6.c cVar, int i11) {
        super(2, cVar);
        this.f11971a = i11;
        this.f11973c = obj;
        this.f11972b = i10;
        this.f11974d = serializable;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(Object obj, Object obj2, w6.c cVar, int i10) {
        super(2, cVar);
        this.f11971a = i10;
        this.f11973c = obj;
        this.f11974d = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(Object obj, w6.c cVar, int i10) {
        super(2, cVar);
        this.f11971a = i10;
        this.f11974d = obj;
    }
}
