package e8;

import com.google.android.gms.internal.measurement.a4;
import java.util.List;
import s6.m;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j implements e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7975a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f7976b;

    public j(g7.a aVar) {
        this.f7976b = new m(aVar);
    }

    @Override // e8.e
    public final String a() {
        switch (this.f7975a) {
            case 0:
                return "kotlinx.coroutines.flow.MutableStateFlow";
            default:
                return b().a();
        }
    }

    public e b() {
        return (e) ((m) this.f7976b).getValue();
    }

    @Override // e8.e
    public final boolean c() {
        switch (this.f7975a) {
            case 0:
                return ((e) this.f7976b).c();
            default:
                return false;
        }
    }

    @Override // e8.e
    public final int d(String str) {
        switch (this.f7975a) {
            case 0:
                str.getClass();
                return ((e) this.f7976b).d(str);
            default:
                str.getClass();
                return b().d(str);
        }
    }

    @Override // e8.e
    public final int e() {
        switch (this.f7975a) {
            case 0:
                return ((e) this.f7976b).e();
            default:
                return b().e();
        }
    }

    @Override // e8.e
    public final String f(int i10) {
        switch (this.f7975a) {
            case 0:
                return ((e) this.f7976b).f(i10);
            default:
                return b().f(i10);
        }
    }

    @Override // e8.e
    public final List g(int i10) {
        switch (this.f7975a) {
            case 0:
                return ((e) this.f7976b).g(i10);
            default:
                return b().g(i10);
        }
    }

    @Override // e8.e
    public final List getAnnotations() {
        switch (this.f7975a) {
            case 0:
                return ((e) this.f7976b).getAnnotations();
            default:
                return t.f12808a;
        }
    }

    @Override // e8.e
    public final a4 getKind() {
        switch (this.f7975a) {
            case 0:
                return ((e) this.f7976b).getKind();
            default:
                return b().getKind();
        }
    }

    @Override // e8.e
    public final e h(int i10) {
        switch (this.f7975a) {
            case 0:
                return ((e) this.f7976b).h(i10);
            default:
                return b().h(i10);
        }
    }

    @Override // e8.e
    public final boolean i(int i10) {
        switch (this.f7975a) {
            case 0:
                return ((e) this.f7976b).i(i10);
            default:
                return b().i(i10);
        }
    }

    @Override // e8.e
    public final boolean isInline() {
        switch (this.f7975a) {
            case 0:
                return ((e) this.f7976b).isInline();
            default:
                return false;
        }
    }

    public j(e eVar) {
        this.f7976b = eVar;
    }
}
