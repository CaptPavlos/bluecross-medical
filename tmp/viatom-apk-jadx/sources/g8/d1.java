package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d1 extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final d1 f8252c = new d1(e1.f8258a);

    @Override // g8.a
    public final int e(Object obj) {
        return ((s6.o) obj).f12703a.length;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: g8.r0.c(g8.r0):void
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:80)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:50)
        Caused by: java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 9
        	at java.base/java.util.ArrayList.add(ArrayList.java:485)
        	at java.base/java.util.ArrayList.add(ArrayList.java:497)
        	at jadx.core.utils.ListUtils.safeReplace(ListUtils.java:120)
        	at jadx.core.dex.visitors.InlineMethods.lambda$updateUsageInfo$0(InlineMethods.java:170)
        	at jadx.core.dex.nodes.InsnNode.visitInsns(InsnNode.java:288)
        	at jadx.core.dex.visitors.InlineMethods.updateUsageInfo(InlineMethods.java:162)
        	at jadx.core.dex.visitors.InlineMethods.inlineMethod(InlineMethods.java:93)
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:78)
        	... 1 more
        */
    @Override // g8.o, g8.a
    public final void h(f8.c r3, int r4, java.lang.Object r5) {
        /*
            r2 = this;
            g8.c1 r5 = (g8.c1) r5
            r5.getClass()
            g8.s0 r0 = r2.f8330b
            f8.e r3 = r3.decodeInlineElement(r0, r4)
            byte r3 = r3.decodeByte()
            g8.r0.c(r5)
            byte[] r4 = r5.f8246a
            int r0 = r5.f8247b
            int r1 = r0 + 1
            r5.f8247b = r1
            r4[r0] = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g8.d1.h(f8.c, int, java.lang.Object):void");
    }

    @Override // g8.a
    public final Object i(Object obj) {
        byte[] bArr = ((s6.o) obj).f12703a;
        c1 c1Var = new c1();
        c1Var.f8246a = bArr;
        c1Var.f8247b = bArr.length;
        c1Var.b(10);
        return c1Var;
    }

    @Override // g8.t0
    public final Object l() {
        return new s6.o(new byte[0]);
    }

    @Override // g8.t0
    public final void m(f8.d dVar, Object obj, int i10) {
        byte[] bArr = ((s6.o) obj).f12703a;
        dVar.getClass();
        for (int i11 = 0; i11 < i10; i11++) {
            dVar.encodeInlineElement(this.f8330b, i11).encodeByte(bArr[i11]);
        }
    }
}
