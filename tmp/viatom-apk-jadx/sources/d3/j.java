package d3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final o f6825a;

    /* renamed from: b, reason: collision with root package name */
    public final o f6826b;

    public j(o oVar, o oVar2) {
        oVar.getClass();
        oVar2.getClass();
        this.f6825a = oVar;
        this.f6826b = oVar2;
    }

    public final double a() {
        Double dC = this.f6825a.c();
        if (dC != null) {
            double dDoubleValue = dC.doubleValue();
            if (0.0d <= dDoubleValue && dDoubleValue <= 1.0d) {
                return dDoubleValue;
            }
        }
        Double dC2 = this.f6826b.c();
        if (dC2 != null) {
            double dDoubleValue2 = dC2.doubleValue();
            if (0.0d <= dDoubleValue2 && dDoubleValue2 <= 1.0d) {
                return dDoubleValue2;
            }
        }
        return 1.0d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
    
        if (r6.d(r0) == r4) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(y6.c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof d3.i
            if (r0 == 0) goto L13
            r0 = r6
            d3.i r0 = (d3.i) r0
            int r1 = r0.f6824d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6824d = r1
            goto L18
        L13:
            d3.i r0 = new d3.i
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f6822b
            int r1 = r0.f6824d
            r2 = 2
            r3 = 1
            x6.a r4 = x6.a.f13718a
            if (r1 == 0) goto L37
            if (r1 == r3) goto L31
            if (r1 != r2) goto L2a
            s6.a.e(r6)
            goto L56
        L2a:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r6)
            r6 = 0
            return r6
        L31:
            d3.j r1 = r0.f6821a
            s6.a.e(r6)
            goto L48
        L37:
            s6.a.e(r6)
            r0.f6821a = r5
            r0.f6824d = r3
            d3.o r6 = r5.f6825a
            java.lang.Object r6 = r6.d(r0)
            if (r6 != r4) goto L47
            goto L55
        L47:
            r1 = r5
        L48:
            d3.o r6 = r1.f6826b
            r1 = 0
            r0.f6821a = r1
            r0.f6824d = r2
            java.lang.Object r6 = r6.d(r0)
            if (r6 != r4) goto L56
        L55:
            return r4
        L56:
            s6.w r6 = s6.w.f12711a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: d3.j.b(y6.c):java.lang.Object");
    }
}
