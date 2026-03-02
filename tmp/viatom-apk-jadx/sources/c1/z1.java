package c1;

import java.util.concurrent.Callable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z1 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1620a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1621b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1622c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f1623d;
    public final /* synthetic */ d2 e;

    public /* synthetic */ z1(d2 d2Var, String str, String str2, String str3, int i10) {
        this.f1620a = i10;
        this.f1621b = str;
        this.f1622c = str2;
        this.f1623d = str3;
        this.e = d2Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f1620a) {
            case 0:
                d2 d2Var = this.e;
                d2Var.f1108a.B();
                n nVar = d2Var.f1108a.f1520c;
                v4.U(nVar);
                return nVar.c0(this.f1621b, this.f1622c, this.f1623d);
            case 1:
                d2 d2Var2 = this.e;
                d2Var2.f1108a.B();
                n nVar2 = d2Var2.f1108a.f1520c;
                v4.U(nVar2);
                return nVar2.c0(this.f1621b, this.f1622c, this.f1623d);
            case 2:
                d2 d2Var3 = this.e;
                d2Var3.f1108a.B();
                n nVar3 = d2Var3.f1108a.f1520c;
                v4.U(nVar3);
                return nVar3.g0(this.f1621b, this.f1622c, this.f1623d);
            default:
                d2 d2Var4 = this.e;
                d2Var4.f1108a.B();
                n nVar4 = d2Var4.f1108a.f1520c;
                v4.U(nVar4);
                return nVar4.g0(this.f1621b, this.f1622c, this.f1623d);
        }
    }
}
