package c1;

import j$.util.Objects;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1616a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final URL f1617b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f1618c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1619d;
    public final Map e;
    public final Object f;
    public final /* synthetic */ e2 g;

    public z0(a1 a1Var, String str, URL url, byte[] bArr, Map map, y0 y0Var) {
        Objects.requireNonNull(a1Var);
        this.g = a1Var;
        i0.y.d(str);
        i0.y.g(url);
        this.f1617b = url;
        this.f1618c = bArr;
        this.f = y0Var;
        this.f1619d = str;
        this.e = map;
    }

    public void a(final int i10, final IOException iOException, final byte[] bArr, final Map map) {
        r1 r1Var = ((g3) this.g).f1149a.g;
        u1.m(r1Var);
        r1Var.p(new Runnable() { // from class: c1.f3
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                z0 z0Var = this.f1214a;
                ((e3) z0Var.f).c(z0Var.f1619d, i10, iOException, bArr, map);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x027c: MOVE (r11 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]) (LINE:637), block:B:141:0x027a */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x027f: MOVE (r12 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]) (LINE:640), block:B:142:0x027e */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x013a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x015c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0171  */
    /* JADX WARN: Type inference failed for: r8v25, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v26, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v35, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v40 */
    /* JADX WARN: Type inference failed for: r8v42, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v49 */
    /* JADX WARN: Type inference failed for: r8v50 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 782
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.z0.run():void");
    }

    public z0(g3 g3Var, String str, URL url, byte[] bArr, HashMap map, e3 e3Var) {
        Objects.requireNonNull(g3Var);
        this.g = g3Var;
        i0.y.d(str);
        this.f1617b = url;
        this.f1618c = bArr;
        this.f = e3Var;
        this.f1619d = str;
        this.e = map;
    }
}
