package j$.util.stream;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* loaded from: classes2.dex */
public final class m extends i5 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9665b;

    /* renamed from: c, reason: collision with root package name */
    public Object f9666c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(a aVar, m5 m5Var, int i10) {
        super(m5Var);
        this.f9665b = i10;
        this.f9666c = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(m5 m5Var) {
        super(m5Var);
        this.f9665b = 0;
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public void end() {
        switch (this.f9665b) {
            case 0:
                this.f9666c = null;
                this.f9607a.end();
                break;
            default:
                super.end();
                break;
        }
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public void c(long j10) {
        switch (this.f9665b) {
            case 0:
                this.f9666c = new HashSet();
                this.f9607a.c(-1L);
                break;
            case 1:
            default:
                super.c(j10);
                break;
            case 2:
                this.f9607a.c(-1L);
                break;
        }
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f9665b) {
            case 0:
                if (!((Set) this.f9666c).contains(obj)) {
                    ((Set) this.f9666c).add(obj);
                    this.f9607a.accept((m5) obj);
                    break;
                }
                break;
            case 1:
                ((Consumer) ((r) this.f9666c).f9718m).accept(obj);
                this.f9607a.accept((m5) obj);
                break;
            case 2:
                if (((Predicate) ((r) this.f9666c).f9718m).test(obj)) {
                    this.f9607a.accept((m5) obj);
                    break;
                }
                break;
            case 3:
                this.f9607a.accept((m5) ((Function) ((r) this.f9666c).f9718m).apply(obj));
                break;
            case 4:
                this.f9607a.accept(((ToIntFunction) ((v0) this.f9666c).f9775m).applyAsInt(obj));
                break;
            case 5:
                this.f9607a.accept(((ToLongFunction) ((g1) this.f9666c).f9582m).applyAsLong(obj));
                break;
            default:
                this.f9607a.accept(((ToDoubleFunction) ((x) this.f9666c).f9797m).applyAsDouble(obj));
                break;
        }
    }
}
