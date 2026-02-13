package j5;

import android.os.Bundle;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import c5.b0;
import g7.p;
import s6.w;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10025a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b0 f10026b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(b0 b0Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10025a = i10;
        this.f10026b = b0Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10025a) {
            case 0:
                return new c(this.f10026b, cVar, 0);
            case 1:
                return new c(this.f10026b, cVar, 1);
            case 2:
                return new c(this.f10026b, cVar, 2);
            default:
                return new c(this.f10026b, cVar, 3);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w6.c cVar = (w6.c) obj2;
        switch (this.f10025a) {
            case 0:
                c cVar2 = new c(this.f10026b, cVar, 0);
                w wVar = w.f12711a;
                cVar2.invokeSuspend(wVar);
                return wVar;
            case 1:
                c cVar3 = new c(this.f10026b, cVar, 1);
                w wVar2 = w.f12711a;
                cVar3.invokeSuspend(wVar2);
                return wVar2;
            case 2:
                c cVar4 = new c(this.f10026b, cVar, 2);
                w wVar3 = w.f12711a;
                cVar4.invokeSuspend(wVar3);
                return wVar3;
            default:
                c cVar5 = new c(this.f10026b, cVar, 3);
                w wVar4 = w.f12711a;
                cVar5.invokeSuspend(wVar4);
                return wVar4;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f10025a;
        w wVar = w.f12711a;
        b0 b0Var = this.f10026b;
        switch (i10) {
            case 0:
                s6.a.e(obj);
                b0Var.getClass();
                break;
            case 1:
                s6.a.e(obj);
                b0Var.getClass();
                Bundle bundle = new Bundle();
                bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "success");
                new t1.c(b0Var.f1657a, 4).e(bundle, "uptodown_services_init");
                break;
            case 2:
                s6.a.e(obj);
                b0Var.c();
                break;
            default:
                s6.a.e(obj);
                b0Var.c();
                break;
        }
        return wVar;
    }
}
