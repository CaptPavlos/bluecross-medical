package v8;

import java.io.IOException;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends q8.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f13233b = 2;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13234c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q f13235d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(q qVar, Object[] objArr, int i10, ArrayList arrayList) {
        super("OkHttp %s Push Request[%s]", objArr);
        this.f13235d = qVar;
        this.f13234c = i10;
    }

    private final void b() {
        this.f13235d.f13253j.getClass();
        try {
            this.f13235d.f13261r.i(this.f13234c, 6);
            synchronized (this.f13235d) {
                this.f13235d.t.remove(Integer.valueOf(this.f13234c));
            }
        } catch (IOException unused) {
        }
    }

    private final void c() {
        this.f13235d.f13253j.getClass();
        try {
            this.f13235d.f13261r.i(this.f13234c, 6);
            synchronized (this.f13235d) {
                this.f13235d.t.remove(Integer.valueOf(this.f13234c));
            }
        } catch (IOException unused) {
        }
    }

    @Override // q8.a
    public final void a() {
        switch (this.f13233b) {
            case 0:
                b();
                return;
            case 1:
                c();
                return;
            default:
                this.f13235d.f13253j.getClass();
                synchronized (this.f13235d) {
                    this.f13235d.t.remove(Integer.valueOf(this.f13234c));
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(q qVar, Object[] objArr, int i10, ArrayList arrayList, boolean z9) {
        super("OkHttp %s Push Headers[%s]", objArr);
        this.f13235d = qVar;
        this.f13234c = i10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(q qVar, Object[] objArr, int i10, int i11) {
        super("OkHttp %s Push Reset[%s]", objArr);
        this.f13235d = qVar;
        this.f13234c = i10;
    }
}
