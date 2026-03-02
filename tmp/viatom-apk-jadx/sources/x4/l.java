package x4;

import android.content.pm.IPackageInstallObserver;
import android.os.Bundle;
import p4.a0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends IPackageInstallObserver.Stub {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t1.c f13629a;

    public l(t1.c cVar) {
        this.f13629a = cVar;
    }

    @Override // android.content.pm.IPackageInstallObserver
    public final void packageInstalled(String str, int i10) {
        str.getClass();
        if (i10 == 1) {
            a0 a0Var = (a0) this.f13629a.f12752c;
            if (a0Var != null) {
                a0Var.f11920a.finish();
            }
            if (o4.b.f11716o != null) {
                Bundle bundleF = com.mbridge.msdk.dycreator.baseview.a.f("packageName", str);
                i5.f fVar = o4.b.f11716o;
                if (fVar != null) {
                    fVar.send(352, bundleF);
                }
            }
        }
        o4.b.f11717p = null;
    }
}
