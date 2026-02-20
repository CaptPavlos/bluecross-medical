package j$.util.stream;

import java.util.Comparator;

/* loaded from: classes2.dex */
public abstract class a6 extends i5 {

    /* renamed from: b, reason: collision with root package name */
    public final Comparator f9514b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9515c;

    public a6(m5 m5Var, Comparator comparator) {
        super(m5Var);
        this.f9514b = comparator;
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public final boolean e() {
        this.f9515c = true;
        return false;
    }
}
