package l4;

import android.content.res.Resources;
import com.uptodown.UptodownApp;
import com.uptodown.activities.Updates;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j9 implements g5.b, g5.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10531a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Updates f10532b;

    public /* synthetic */ j9(Updates updates, int i10) {
        this.f10531a = i10;
        this.f10532b = updates;
    }

    @Override // g5.b, g5.p
    public final void a(int i10) throws Resources.NotFoundException {
        int i11 = this.f10531a;
        h5.f fVar = null;
        Updates updates = this.f10532b;
        switch (i11) {
            case 0:
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    n4.w0 w0Var = updates.X;
                    boolean z9 = (w0Var != null ? w0Var.a().get(i10) : null) instanceof n4.u0;
                    n4.w0 w0Var2 = updates.X;
                    if (z9) {
                        w0Var2.getClass();
                        Object obj = w0Var2.a().get(i10);
                        obj.getClass();
                        fVar = ((n4.u0) obj).f11493a;
                    } else {
                        if ((w0Var2 != null ? w0Var2.a().get(i10) : null) instanceof h5.f) {
                            n4.w0 w0Var3 = updates.X;
                            w0Var3.getClass();
                            Object obj2 = w0Var3.a().get(i10);
                            obj2.getClass();
                            fVar = (h5.f) obj2;
                        }
                    }
                    if (fVar != null) {
                        updates.p0(fVar, i10);
                        break;
                    }
                }
                break;
            default:
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    n4.w0 w0Var4 = updates.X;
                    if ((w0Var4 != null ? w0Var4.a().get(i10) : null) instanceof n4.u0) {
                        n4.w0 w0Var5 = updates.X;
                        w0Var5.getClass();
                        Object obj3 = w0Var5.a().get(i10);
                        obj3.getClass();
                        updates.p0(((n4.u0) obj3).f11493a, i10);
                        break;
                    }
                }
                break;
        }
    }

    @Override // g5.p
    public void b(int i10) {
        int i11 = Updates.f6656p0;
        Updates updates = this.f10532b;
        if (updates.L0(i10)) {
            n4.w0 w0Var = updates.X;
            w0Var.getClass();
            Object obj = w0Var.a().get(i10);
            obj.getClass();
            ((n4.u0) obj).f11493a.f8540v = true;
            n4.w0 w0Var2 = updates.X;
            w0Var2.getClass();
            w0Var2.notifyItemChanged(i10);
        }
    }

    @Override // g5.p
    public void c(int i10) throws Resources.NotFoundException {
        float f = UptodownApp.E;
        if (k4.c.s()) {
            int i11 = Updates.f6656p0;
            Updates updates = this.f10532b;
            if (updates.L0(i10)) {
                n4.w0 w0Var = updates.X;
                w0Var.getClass();
                Object obj = w0Var.a().get(i10);
                obj.getClass();
                updates.w0(((n4.u0) obj).f11493a);
                updates.P0();
                n4.w0 w0Var2 = updates.X;
                w0Var2.getClass();
                w0Var2.notifyItemChanged(i10);
            }
        }
    }

    @Override // g5.b, g5.p
    public final void d(int i10) {
        int i11 = this.f10531a;
        Updates updates = this.f10532b;
        h5.f fVar = null;
        switch (i11) {
            case 0:
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    n4.w0 w0Var = updates.X;
                    boolean z9 = (w0Var != null ? w0Var.a().get(i10) : null) instanceof n4.u0;
                    n4.w0 w0Var2 = updates.X;
                    if (z9) {
                        w0Var2.getClass();
                        Object obj = w0Var2.a().get(i10);
                        obj.getClass();
                        fVar = ((n4.u0) obj).f11493a;
                    } else {
                        if ((w0Var2 != null ? w0Var2.a().get(i10) : null) instanceof h5.f) {
                            n4.w0 w0Var3 = updates.X;
                            w0Var3.getClass();
                            Object obj2 = w0Var3.a().get(i10);
                            obj2.getClass();
                            fVar = (h5.f) obj2;
                        }
                    }
                    if (fVar != null) {
                        long j10 = fVar.f8541w;
                        if (j10 > 0) {
                            updates.Y(j10);
                            break;
                        }
                    }
                }
                break;
            default:
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    n4.w0 w0Var4 = updates.X;
                    boolean z10 = (w0Var4 != null ? w0Var4.a().get(i10) : null) instanceof n4.u0;
                    n4.w0 w0Var5 = updates.X;
                    if (z10) {
                        w0Var5.getClass();
                        Object obj3 = w0Var5.a().get(i10);
                        obj3.getClass();
                        fVar = ((n4.u0) obj3).f11493a;
                    } else {
                        if ((w0Var5 != null ? w0Var5.a().get(i10) : null) instanceof h5.f) {
                            n4.w0 w0Var6 = updates.X;
                            w0Var6.getClass();
                            Object obj4 = w0Var6.a().get(i10);
                            obj4.getClass();
                            fVar = (h5.f) obj4;
                        }
                    }
                    if (fVar != null) {
                        long j11 = fVar.f8541w;
                        if (j11 > 0) {
                            updates.Y(j11);
                            break;
                        }
                    }
                }
                break;
        }
    }

    @Override // g5.p
    public void e(int i10) {
        float f = UptodownApp.E;
        if (k4.c.s()) {
            int i11 = Updates.f6656p0;
            Updates updates = this.f10532b;
            updates.D0(i10);
            n4.w0 w0Var = updates.X;
            if (w0Var != null) {
                w0Var.h = false;
            }
        }
    }

    @Override // g5.p
    public void f(int i10) {
        int i11 = Updates.f6656p0;
        Updates updates = this.f10532b;
        if (updates.L0(i10)) {
            n4.w0 w0Var = updates.X;
            w0Var.getClass();
            Object obj = w0Var.a().get(i10);
            obj.getClass();
            ((n4.u0) obj).f11493a.f8540v = false;
            n4.w0 w0Var2 = updates.X;
            w0Var2.getClass();
            w0Var2.notifyItemChanged(i10);
        }
    }
}
