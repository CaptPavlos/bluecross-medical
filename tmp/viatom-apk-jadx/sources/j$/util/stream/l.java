package j$.util.stream;

import j$.util.Spliterator;

/* loaded from: classes2.dex */
public final class l extends i5 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9649b = 2;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9650c;

    /* renamed from: d, reason: collision with root package name */
    public Object f9651d;

    public /* synthetic */ l(m5 m5Var) {
        super(m5Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(i8 i8Var, m5 m5Var) {
        super(m5Var);
        this.f9651d = i8Var;
        this.f9650c = true;
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public final void c(long j10) {
        switch (this.f9649b) {
            case 0:
                this.f9650c = false;
                this.f9651d = null;
                this.f9607a.c(-1L);
                break;
            case 1:
                this.f9607a.c(-1L);
                break;
            default:
                this.f9607a.c(-1L);
                break;
        }
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final void n(Object obj) throws Exception {
        switch (this.f9649b) {
            case 0:
                m5 m5Var = this.f9607a;
                if (obj == null) {
                    if (this.f9650c) {
                        return;
                    }
                    this.f9650c = true;
                    this.f9651d = null;
                    m5Var.n((m5) null);
                    return;
                }
                Object obj2 = this.f9651d;
                if (obj2 == null || !obj.equals(obj2)) {
                    this.f9651d = obj;
                    m5Var.n((m5) obj);
                    return;
                }
                return;
            case 1:
                Stream stream = (Stream) ((j$.util.q) ((r) this.f9651d).f9718m).apply((j$.util.q) obj);
                if (stream != null) {
                    try {
                        boolean z9 = this.f9650c;
                        m5 m5Var2 = this.f9607a;
                        if (!z9) {
                            ((Stream) stream.sequential()).forEach(m5Var2);
                        } else {
                            Spliterator spliterator = ((Stream) stream.sequential()).spliterator();
                            while (!m5Var2.e() && spliterator.tryAdvance(m5Var2)) {
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            stream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (stream != null) {
                    stream.close();
                    return;
                }
                return;
            default:
                if (this.f9650c) {
                    boolean zTest = ((i8) this.f9651d).f9614m.test(obj);
                    this.f9650c = zTest;
                    if (zTest) {
                        this.f9607a.n((m5) obj);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public boolean e() {
        switch (this.f9649b) {
            case 1:
                this.f9650c = true;
                return this.f9607a.e();
            case 2:
                return !this.f9650c || this.f9607a.e();
            default:
                return super.e();
        }
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public void end() {
        switch (this.f9649b) {
            case 0:
                this.f9650c = false;
                this.f9651d = null;
                this.f9607a.end();
                break;
            default:
                super.end();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(r rVar, m5 m5Var) {
        super(m5Var);
        this.f9651d = rVar;
    }
}
