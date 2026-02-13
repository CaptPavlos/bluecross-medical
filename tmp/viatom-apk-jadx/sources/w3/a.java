package w3;

import j$.util.DesugarCollections;
import java.util.Date;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class a implements d {
    public static final a f;

    /* renamed from: a, reason: collision with root package name */
    public t3.h f13493a;

    /* renamed from: b, reason: collision with root package name */
    public Date f13494b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13495c;

    /* renamed from: d, reason: collision with root package name */
    public e f13496d;
    public boolean e;

    static {
        e eVar = new e();
        a aVar = new a();
        aVar.f13493a = new t3.h(19);
        aVar.f13496d = eVar;
        f = aVar;
    }

    @Override // w3.d
    public final void a(boolean z9) {
        if (!this.e && z9) {
            this.f13493a.getClass();
            Date date = new Date();
            Date date2 = this.f13494b;
            if (date2 == null || date.after(date2)) {
                this.f13494b = date;
                if (this.f13495c) {
                    Iterator it = DesugarCollections.unmodifiableCollection(c.f13498c.f13500b).iterator();
                    while (it.hasNext()) {
                        y3.a aVar = ((t3.j) it.next()).e;
                        Date date3 = this.f13494b;
                        aVar.b(date3 != null ? (Date) date3.clone() : null);
                    }
                }
            }
        }
        this.e = z9;
    }
}
