package m6;

import a3.z0;
import androidx.lifecycle.ViewModel;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
import f6.m;
import j.g;
import k8.h;
import kotlin.jvm.internal.l;
import o8.i;
import w2.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final m f11229a;

    /* renamed from: b, reason: collision with root package name */
    public final i f11230b;

    /* renamed from: c, reason: collision with root package name */
    public final f6.d f11231c;

    /* renamed from: d, reason: collision with root package name */
    public final h f11232d;
    public final z0 e;
    public final r f;
    public final boolean g;
    public final d9.i h;

    /* renamed from: i, reason: collision with root package name */
    public final n6.c f11233i;

    /* renamed from: j, reason: collision with root package name */
    public final a4.f f11234j;

    public f(m mVar, i iVar, f6.d dVar, h hVar, z0 z0Var, r rVar, boolean z9, d9.i iVar2, n6.c cVar, a4.f fVar) {
        dVar.getClass();
        z0Var.getClass();
        this.f11229a = mVar;
        this.f11230b = iVar;
        this.f11231c = dVar;
        this.f11232d = hVar;
        this.e = z0Var;
        this.f = rVar;
        this.g = z9;
        this.h = iVar2;
        this.f11233i = cVar;
        this.f11234j = fVar;
    }

    public final String a() {
        String str;
        boolean zT = r0.f.t();
        d9.i iVar = this.h;
        if (zT) {
            str = iVar.f7516i.f7486d;
        } else if (r0.f.l()) {
            str = iVar.f7517j.f7463c;
            if (str.length() == 0) {
                str = iVar.f7513b;
            }
        } else {
            str = iVar.f7513b;
        }
        return g.f9878a ? l.g(this.f11233i.f11566b.f11561c, str) : str;
    }

    public final void b() {
        i iVar = this.f11230b;
        String str = iVar.f11814b.I;
        r rVar = this.f;
        if (str != null) {
            PrivacyEncodingMode privacyEncodingMode = PrivacyEncodingMode.GPP;
            if (str.equals(privacyEncodingMode.getValue())) {
                rVar.i(privacyEncodingMode, true, true);
                return;
            }
        }
        String str2 = iVar.f11814b.I;
        if (str2 != null) {
            PrivacyEncodingMode privacyEncodingMode2 = PrivacyEncodingMode.TCF;
            if (str2.equals(privacyEncodingMode2.getValue())) {
                rVar.i(privacyEncodingMode2, true, true);
                return;
            }
        }
        rVar.i(PrivacyEncodingMode.TCF_AND_GPP, true, true);
    }
}
