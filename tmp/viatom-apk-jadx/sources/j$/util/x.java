package j$.util;

import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public final class x implements DoubleConsumer {

    /* renamed from: a, reason: collision with root package name */
    public double f9855a;

    /* renamed from: b, reason: collision with root package name */
    public double f9856b;
    private long count;
    private double sum;
    private double min = Double.POSITIVE_INFINITY;
    private double max = Double.NEGATIVE_INFINITY;

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.d(this, doubleConsumer);
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d8) {
        this.count++;
        this.f9856b += d8;
        b(d8);
        this.min = Math.min(this.min, d8);
        this.max = Math.max(this.max, d8);
    }

    public final void a(x xVar) {
        this.count += xVar.count;
        this.f9856b += xVar.f9856b;
        b(xVar.sum);
        b(xVar.f9855a);
        this.min = Math.min(this.min, xVar.min);
        this.max = Math.max(this.max, xVar.max);
    }

    public final void b(double d8) {
        double d10 = d8 - this.f9855a;
        double d11 = this.sum;
        double d12 = d11 + d10;
        this.f9855a = (d12 - d11) - d10;
        this.sum = d12;
    }

    public final String toString() {
        double d8;
        String simpleName = x.class.getSimpleName();
        Long lValueOf = Long.valueOf(this.count);
        double d10 = this.sum + this.f9855a;
        if (Double.isNaN(d10) && Double.isInfinite(this.f9856b)) {
            d10 = this.f9856b;
        }
        Double dValueOf = Double.valueOf(d10);
        Double dValueOf2 = Double.valueOf(this.min);
        if (this.count > 0) {
            double d11 = this.sum + this.f9855a;
            if (Double.isNaN(d11) && Double.isInfinite(this.f9856b)) {
                d11 = this.f9856b;
            }
            d8 = d11 / this.count;
        } else {
            d8 = 0.0d;
        }
        return String.format("%s{count=%d, sum=%f, min=%f, average=%f, max=%f}", simpleName, lValueOf, dValueOf, dValueOf2, Double.valueOf(d8), Double.valueOf(this.max));
    }
}
