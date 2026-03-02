package j$.util.stream;

/* loaded from: classes2.dex */
public final class j8 extends i5 implements r8 {

    /* renamed from: b, reason: collision with root package name */
    public long f9628b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9629c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f9630d;
    public final /* synthetic */ i8 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j8(i8 i8Var, m5 m5Var, boolean z9) {
        super(m5Var);
        this.e = i8Var;
        this.f9630d = z9;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    @Override // java.util.function.Consumer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void accept(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r6.f9629c
            if (r0 != 0) goto L15
            j$.util.stream.i8 r0 = r6.e
            java.util.function.Predicate r0 = r0.f9614m
            boolean r0 = r0.test(r7)
            r1 = r0 ^ 1
            r6.f9629c = r1
            if (r0 != 0) goto L13
            goto L15
        L13:
            r0 = 0
            goto L16
        L15:
            r0 = 1
        L16:
            boolean r1 = r6.f9630d
            if (r1 == 0) goto L23
            if (r0 != 0) goto L23
            long r2 = r6.f9628b
            r4 = 1
            long r2 = r2 + r4
            r6.f9628b = r2
        L23:
            if (r1 != 0) goto L29
            if (r0 == 0) goto L28
            goto L29
        L28:
            return
        L29:
            j$.util.stream.m5 r0 = r6.f9607a
            r0.accept(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.j8.accept(java.lang.Object):void");
    }

    @Override // j$.util.stream.r8
    public final long h() {
        return this.f9628b;
    }
}
