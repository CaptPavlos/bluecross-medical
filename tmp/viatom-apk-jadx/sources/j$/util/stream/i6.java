package j$.util.stream;

import j$.util.Collection;
import j$.util.Objects;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class i6 extends a6 {

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f9608d;

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public final void c(long j10) {
        if (j10 >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
        } else {
            this.f9608d = j10 >= 0 ? new ArrayList((int) j10) : new ArrayList();
        }
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public final void end() {
        j$.util.c.u(this.f9608d, this.f9514b);
        long size = this.f9608d.size();
        m5 m5Var = this.f9607a;
        m5Var.c(size);
        boolean z9 = this.f9515c;
        ArrayList arrayList = this.f9608d;
        if (!z9) {
            Objects.requireNonNull(m5Var);
            Collection.EL.a(arrayList, new j$.util.q(8, m5Var));
        } else {
            int size2 = arrayList.size();
            int i10 = 0;
            while (i10 < size2) {
                Object obj = arrayList.get(i10);
                i10++;
                if (m5Var.e()) {
                    break;
                } else {
                    m5Var.n((m5) obj);
                }
            }
        }
        m5Var.end();
        this.f9608d = null;
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final void n(Object obj) {
        this.f9608d.add(obj);
    }
}
