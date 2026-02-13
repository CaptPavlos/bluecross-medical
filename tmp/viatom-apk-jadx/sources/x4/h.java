package x4;

import android.os.Bundle;
import com.uptodown.core.activities.InstallerActivity;
import p4.d0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13619a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d0 f13620b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f13621c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f13622d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(d0 d0Var, String str, String str2, w6.c cVar, int i10) {
        super(2, cVar);
        this.f13619a = i10;
        this.f13620b = d0Var;
        this.f13621c = str;
        this.f13622d = str2;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f13619a) {
            case 0:
                return new h(this.f13620b, this.f13621c, this.f13622d, cVar, 0);
            case 1:
                return new h(this.f13620b, this.f13621c, this.f13622d, cVar, 1);
            default:
                return new h(this.f13620b, this.f13621c, this.f13622d, cVar, 2);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f13619a) {
            case 0:
                h hVar = (h) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                hVar.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                h hVar2 = (h) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                hVar2.invokeSuspend(wVar3);
                return wVar3;
            default:
                h hVar3 = (h) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                hVar3.invokeSuspend(wVar4);
                return wVar4;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f13619a) {
            case 0:
                s6.a.e(obj);
                d0 d0Var = this.f13620b;
                if (d0Var != null) {
                    d0Var.f11935a.O("invalid version code");
                }
                if (o4.b.f11716o != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("packageName", this.f13622d);
                    i5.f fVar = o4.b.f11716o;
                    if (fVar != null) {
                        fVar.send(304, bundle);
                    }
                }
                break;
            case 1:
                s6.a.e(obj);
                d0 d0Var2 = this.f13620b;
                if (d0Var2 != null) {
                    InstallerActivity installerActivity = d0Var2.f11935a;
                    installerActivity.runOnUiThread(new p4.y(installerActivity, 0));
                }
                if (o4.b.f11716o != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("packageName", this.f13622d);
                    i5.f fVar2 = o4.b.f11716o;
                    if (fVar2 != null) {
                        fVar2.send(301, bundle2);
                    }
                }
                break;
            default:
                s6.a.e(obj);
                d0 d0Var3 = this.f13620b;
                if (d0Var3 != null) {
                    d0Var3.f11935a.finish();
                }
                if (o4.b.f11716o != null) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("packageName", this.f13622d);
                    bundle3.putString("filename", this.f13621c);
                    i5.f fVar3 = o4.b.f11716o;
                    if (fVar3 != null) {
                        fVar3.send(302, bundle3);
                    }
                }
                break;
        }
        return s6.w.f12711a;
    }
}
