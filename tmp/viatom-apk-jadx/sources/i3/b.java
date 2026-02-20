package i3;

import j$.util.Objects;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class b implements Closeable, Flushable {

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f8980l = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f8981m = new String[128];

    /* renamed from: n, reason: collision with root package name */
    public static final String[] f8982n;

    /* renamed from: a, reason: collision with root package name */
    public final Writer f8983a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f8984b;

    /* renamed from: c, reason: collision with root package name */
    public int f8985c;

    /* renamed from: d, reason: collision with root package name */
    public com.google.gson.a f8986d;
    public String e;
    public String f;
    public boolean g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8987i;

    /* renamed from: j, reason: collision with root package name */
    public String f8988j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8989k;

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f8981m[i10] = String.format("\\u%04x", Integer.valueOf(i10));
        }
        String[] strArr = f8981m;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f8982n = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public b(Writer writer) {
        int[] iArr = new int[32];
        this.f8984b = iArr;
        this.f8985c = 0;
        if (iArr.length == 0) {
            this.f8984b = Arrays.copyOf(iArr, 0);
        }
        int[] iArr2 = this.f8984b;
        int i10 = this.f8985c;
        this.f8985c = i10 + 1;
        iArr2[i10] = 6;
        this.h = 2;
        this.f8989k = true;
        Objects.requireNonNull(writer, "out == null");
        this.f8983a = writer;
        m(com.google.gson.a.f2448d);
    }

    public final void a() throws IOException {
        int iL = l();
        if (iL == 1) {
            this.f8984b[this.f8985c - 1] = 2;
            j();
            return;
        }
        Writer writer = this.f8983a;
        if (iL == 2) {
            writer.append((CharSequence) this.f);
            j();
            return;
        }
        if (iL == 4) {
            writer.append((CharSequence) this.e);
            this.f8984b[this.f8985c - 1] = 5;
            return;
        }
        if (iL != 6) {
            if (iL != 7) {
                androidx.window.layout.c.g("Nesting problem.");
                return;
            } else if (this.h != 1) {
                androidx.window.layout.c.g("JSON must have only one top-level value.");
                return;
            }
        }
        this.f8984b[this.f8985c - 1] = 7;
    }

    public void b() throws IOException {
        u();
        a();
        int i10 = this.f8985c;
        int[] iArr = this.f8984b;
        if (i10 == iArr.length) {
            this.f8984b = Arrays.copyOf(iArr, i10 * 2);
        }
        int[] iArr2 = this.f8984b;
        int i11 = this.f8985c;
        this.f8985c = i11 + 1;
        iArr2[i11] = 1;
        this.f8983a.write(91);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f8983a.close();
        int i10 = this.f8985c;
        if (i10 > 1 || (i10 == 1 && this.f8984b[i10 - 1] != 7)) {
            com.google.gson.internal.a.m("Incomplete document");
        } else {
            this.f8985c = 0;
        }
    }

    public void d() throws IOException {
        u();
        a();
        int i10 = this.f8985c;
        int[] iArr = this.f8984b;
        if (i10 == iArr.length) {
            this.f8984b = Arrays.copyOf(iArr, i10 * 2);
        }
        int[] iArr2 = this.f8984b;
        int i11 = this.f8985c;
        this.f8985c = i11 + 1;
        iArr2[i11] = 3;
        this.f8983a.write(123);
    }

    public final void e(int i10, int i11, char c10) throws IOException {
        int iL = l();
        if (iL != i11 && iL != i10) {
            androidx.window.layout.c.g("Nesting problem.");
            return;
        }
        if (this.f8988j != null) {
            com.google.gson.internal.a.l(this.f8988j, "Dangling name: ");
            return;
        }
        this.f8985c--;
        if (iL == i11) {
            j();
        }
        this.f8983a.write(c10);
    }

    public void f() throws IOException {
        e(1, 2, ']');
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f8985c != 0) {
            this.f8983a.flush();
        } else {
            androidx.window.layout.c.g("JsonWriter is closed.");
        }
    }

    public void h() throws IOException {
        e(3, 5, '}');
    }

    public void i(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f8988j != null) {
            androidx.window.layout.c.g("Already wrote a name, expecting a value.");
            return;
        }
        int iL = l();
        if (iL == 3 || iL == 5) {
            this.f8988j = str;
        } else {
            androidx.window.layout.c.g("Please begin an object before writing a name.");
        }
    }

    public final void j() throws IOException {
        if (this.g) {
            return;
        }
        String str = this.f8986d.f2449a;
        Writer writer = this.f8983a;
        writer.write(str);
        int i10 = this.f8985c;
        for (int i11 = 1; i11 < i10; i11++) {
            writer.write(this.f8986d.f2450b);
        }
    }

    public b k() throws IOException {
        if (this.f8988j != null) {
            if (!this.f8989k) {
                this.f8988j = null;
                return this;
            }
            u();
        }
        a();
        this.f8983a.write("null");
        return this;
    }

    public final int l() {
        int i10 = this.f8985c;
        if (i10 != 0) {
            return this.f8984b[i10 - 1];
        }
        androidx.window.layout.c.g("JsonWriter is closed.");
        return 0;
    }

    public final void m(com.google.gson.a aVar) {
        Objects.requireNonNull(aVar);
        this.f8986d = aVar;
        this.f = ",";
        if (aVar.f2451c) {
            this.e = ": ";
            if (aVar.f2449a.isEmpty()) {
                this.f = ", ";
            }
        } else {
            this.e = ":";
        }
        this.g = this.f8986d.f2449a.isEmpty() && this.f8986d.f2450b.isEmpty();
    }

    public final void n(int i10) {
        if (i10 == 0) {
            throw null;
        }
        this.h = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f8987i
            if (r0 == 0) goto L7
            java.lang.String[] r0 = i3.b.f8982n
            goto L9
        L7:
            java.lang.String[] r0 = i3.b.f8981m
        L9:
            java.io.Writer r1 = r8.f8983a
            r2 = 34
            r1.write(r2)
            int r3 = r9.length()
            r4 = 0
            r5 = r4
        L16:
            if (r4 >= r3) goto L41
            char r6 = r9.charAt(r4)
            r7 = 128(0x80, float:1.8E-43)
            if (r6 >= r7) goto L25
            r6 = r0[r6]
            if (r6 != 0) goto L32
            goto L3e
        L25:
            r7 = 8232(0x2028, float:1.1535E-41)
            if (r6 != r7) goto L2c
            java.lang.String r6 = "\\u2028"
            goto L32
        L2c:
            r7 = 8233(0x2029, float:1.1537E-41)
            if (r6 != r7) goto L3e
            java.lang.String r6 = "\\u2029"
        L32:
            if (r5 >= r4) goto L39
            int r7 = r4 - r5
            r1.write(r9, r5, r7)
        L39:
            r1.write(r6)
            int r5 = r4 + 1
        L3e:
            int r4 = r4 + 1
            goto L16
        L41:
            if (r5 >= r3) goto L47
            int r3 = r3 - r5
            r1.write(r9, r5, r3)
        L47:
            r1.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.b.o(java.lang.String):void");
    }

    public void p(double d8) throws IOException {
        u();
        if (this.h == 1 || !(Double.isNaN(d8) || Double.isInfinite(d8))) {
            a();
            this.f8983a.append((CharSequence) Double.toString(d8));
        } else {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d8);
        }
    }

    public void q(long j10) throws IOException {
        u();
        a();
        this.f8983a.write(Long.toString(j10));
    }

    public void r(Number number) throws IOException {
        if (number == null) {
            k();
            return;
        }
        u();
        String string = number.toString();
        Class<?> cls = number.getClass();
        if (cls != Integer.class && cls != Long.class && cls != Byte.class && cls != Short.class && cls != BigDecimal.class && cls != BigInteger.class && cls != AtomicInteger.class && cls != AtomicLong.class) {
            if (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN")) {
                if (this.h != 1) {
                    com.google.gson.internal.a.n("Numeric values must be finite, but was ".concat(string));
                    return;
                }
            } else if (cls != Float.class && cls != Double.class && !f8980l.matcher(string).matches()) {
                androidx.window.layout.c.h("String created by ", cls, " is not a valid JSON number: ", string);
                return;
            }
        }
        a();
        this.f8983a.append((CharSequence) string);
    }

    public void s(String str) throws IOException {
        if (str == null) {
            k();
            return;
        }
        u();
        a();
        o(str);
    }

    public void t(boolean z9) throws IOException {
        u();
        a();
        this.f8983a.write(z9 ? "true" : "false");
    }

    public final void u() throws IOException {
        if (this.f8988j != null) {
            int iL = l();
            if (iL == 5) {
                this.f8983a.write(this.f);
            } else if (iL != 3) {
                androidx.window.layout.c.g("Nesting problem.");
                return;
            }
            j();
            this.f8984b[this.f8985c - 1] = 4;
            o(this.f8988j);
            this.f8988j = null;
        }
    }
}
