package j$.util.stream;

import java.util.concurrent.CountedCompleter;

/* loaded from: classes2.dex */
public class v3 extends CountedCompleter {

    /* renamed from: a, reason: collision with root package name */
    public final h2 f9777a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9778b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9779c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f9780d;

    public v3(h2 h2Var, Object obj, int i10) {
        this.f9779c = i10;
        this.f9777a = h2Var;
        this.f9778b = 0;
        this.f9780d = obj;
    }

    public v3(v3 v3Var, h2 h2Var, int i10, byte b10) {
        super(v3Var);
        this.f9777a = h2Var;
        this.f9778b = i10;
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        int i10;
        v3 v3VarA = this;
        while (v3VarA.f9777a.o() != 0) {
            v3VarA.setPendingCount(v3VarA.f9777a.o() - 1);
            int i11 = 0;
            int iCount = 0;
            while (true) {
                int iO = v3VarA.f9777a.o() - 1;
                i10 = v3VarA.f9778b;
                if (i11 < iO) {
                    v3 v3VarA2 = v3VarA.a(i11, i10 + iCount);
                    iCount = (int) (v3VarA2.f9777a.count() + iCount);
                    v3VarA2.fork();
                    i11++;
                }
            }
            v3VarA = v3VarA.a(i11, i10 + iCount);
        }
        switch (v3VarA.f9779c) {
            case 0:
                ((g2) v3VarA.f9777a).f(v3VarA.f9778b, v3VarA.f9780d);
                break;
            default:
                v3VarA.f9777a.k((Object[]) v3VarA.f9780d, v3VarA.f9778b);
                break;
        }
        v3VarA.propagateCompletion();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v3(v3 v3Var, h2 h2Var, int i10) {
        this(v3Var, h2Var, i10, (byte) 0);
        this.f9779c = 1;
        this.f9780d = (Object[]) v3Var.f9780d;
    }

    public final v3 a(int i10, int i11) {
        switch (this.f9779c) {
            case 0:
                return new v3(this, ((g2) this.f9777a).a(i10), i11);
            default:
                return new v3(this, this.f9777a.a(i10), i11);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v3(v3 v3Var, g2 g2Var, int i10) {
        this(v3Var, g2Var, i10, (byte) 0);
        this.f9779c = 0;
        this.f9780d = v3Var.f9780d;
    }
}
