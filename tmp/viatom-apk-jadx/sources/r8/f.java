package r8;

import c1.g1;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import x8.h;
import z1.t1;
import z8.a0;
import z8.b0;
import z8.j0;
import z8.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f implements Closeable, Flushable {

    /* renamed from: u, reason: collision with root package name */
    public static final Pattern f12475u = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: b, reason: collision with root package name */
    public final File f12477b;

    /* renamed from: c, reason: collision with root package name */
    public final File f12478c;

    /* renamed from: d, reason: collision with root package name */
    public final File f12479d;
    public final File e;
    public final long g;

    /* renamed from: j, reason: collision with root package name */
    public a0 f12481j;

    /* renamed from: l, reason: collision with root package name */
    public int f12483l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12484m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f12485n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12486o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f12487p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12488q;

    /* renamed from: s, reason: collision with root package name */
    public final ThreadPoolExecutor f12490s;

    /* renamed from: i, reason: collision with root package name */
    public long f12480i = 0;

    /* renamed from: k, reason: collision with root package name */
    public final LinkedHashMap f12482k = new LinkedHashMap(0, 0.75f, true);

    /* renamed from: r, reason: collision with root package name */
    public long f12489r = 0;
    public final a4.a t = new a4.a(this, 23);

    /* renamed from: a, reason: collision with root package name */
    public final w8.a f12476a = w8.a.f13568a;
    public final int f = 201105;
    public final int h = 2;

    public f(File file, long j10, ThreadPoolExecutor threadPoolExecutor) {
        this.f12477b = file;
        this.f12478c = new File(file, "journal");
        this.f12479d = new File(file, "journal.tmp");
        this.e = new File(file, "journal.bkp");
        this.g = j10;
        this.f12490s = threadPoolExecutor;
    }

    public static void p(String str) {
        if (f12475u.matcher(str).matches()) {
            return;
        }
        com.google.gson.internal.a.n(androidx.constraintlayout.core.widgets.analyzer.a.x("keys must match regex [a-z0-9_-]{1,120}: \"", str, "\""));
    }

    public final synchronized void a() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void b(g1 g1Var, boolean z9) {
        d dVar = (d) g1Var.f1230b;
        if (dVar.f != g1Var) {
            throw new IllegalStateException();
        }
        if (z9 && !dVar.e) {
            for (int i10 = 0; i10 < this.h; i10++) {
                if (!((boolean[]) g1Var.f1231c)[i10]) {
                    g1Var.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                }
                w8.a aVar = this.f12476a;
                File file = dVar.f12470d[i10];
                aVar.getClass();
                if (!file.exists()) {
                    g1Var.a();
                    return;
                }
            }
        }
        for (int i11 = 0; i11 < this.h; i11++) {
            File file2 = dVar.f12470d[i11];
            w8.a aVar2 = this.f12476a;
            if (z9) {
                aVar2.getClass();
                if (file2.exists()) {
                    File file3 = dVar.f12469c[i11];
                    this.f12476a.c(file2, file3);
                    long j10 = dVar.f12468b[i11];
                    this.f12476a.getClass();
                    long length = file3.length();
                    dVar.f12468b[i11] = length;
                    this.f12480i = (this.f12480i - j10) + length;
                }
            } else {
                aVar2.a(file2);
            }
        }
        this.f12483l++;
        dVar.f = null;
        if (dVar.e || z9) {
            dVar.e = true;
            a0 a0Var = this.f12481j;
            a0Var.writeUtf8("CLEAN");
            a0Var.writeByte(32);
            this.f12481j.writeUtf8(dVar.f12467a);
            a0 a0Var2 = this.f12481j;
            for (long j11 : dVar.f12468b) {
                a0Var2.writeByte(32);
                a0Var2.b(j11);
            }
            this.f12481j.writeByte(10);
            if (z9) {
                long j12 = this.f12489r;
                this.f12489r = 1 + j12;
                dVar.g = j12;
            }
        } else {
            this.f12482k.remove(dVar.f12467a);
            a0 a0Var3 = this.f12481j;
            a0Var3.writeUtf8("REMOVE");
            a0Var3.writeByte(32);
            this.f12481j.writeUtf8(dVar.f12467a);
            this.f12481j.writeByte(10);
        }
        this.f12481j.flush();
        if (this.f12480i > this.g || h()) {
            this.f12490s.execute(this.t);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.f12485n && !this.f12486o) {
                for (d dVar : (d[]) this.f12482k.values().toArray(new d[this.f12482k.size()])) {
                    g1 g1Var = dVar.f;
                    if (g1Var != null) {
                        g1Var.a();
                    }
                }
                o();
                this.f12481j.close();
                this.f12481j = null;
                this.f12486o = true;
                return;
            }
            this.f12486o = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized g1 d(long j10, String str) {
        f();
        a();
        p(str);
        d dVar = (d) this.f12482k.get(str);
        if (j10 != -1 && (dVar == null || dVar.g != j10)) {
            return null;
        }
        if (dVar != null && dVar.f != null) {
            return null;
        }
        if (!this.f12487p && !this.f12488q) {
            a0 a0Var = this.f12481j;
            a0Var.writeUtf8("DIRTY");
            a0Var.writeByte(32);
            a0Var.writeUtf8(str);
            a0Var.writeByte(10);
            this.f12481j.flush();
            if (this.f12484m) {
                return null;
            }
            if (dVar == null) {
                dVar = new d(this, str);
                this.f12482k.put(str, dVar);
            }
            g1 g1Var = new g1(this, dVar);
            dVar.f = g1Var;
            return g1Var;
        }
        this.f12490s.execute(this.t);
        return null;
    }

    public final synchronized e e(String str) {
        f();
        a();
        p(str);
        d dVar = (d) this.f12482k.get(str);
        if (dVar != null && dVar.e) {
            e eVarA = dVar.a();
            if (eVarA == null) {
                return null;
            }
            this.f12483l++;
            a0 a0Var = this.f12481j;
            a0Var.writeUtf8("READ");
            a0Var.writeByte(32);
            a0Var.writeUtf8(str);
            a0Var.writeByte(10);
            if (h()) {
                this.f12490s.execute(this.t);
            }
            return eVarA;
        }
        return null;
    }

    public final synchronized void f() {
        try {
            if (this.f12485n) {
                return;
            }
            w8.a aVar = this.f12476a;
            File file = this.e;
            aVar.getClass();
            if (file.exists()) {
                w8.a aVar2 = this.f12476a;
                File file2 = this.f12478c;
                aVar2.getClass();
                boolean zExists = file2.exists();
                w8.a aVar3 = this.f12476a;
                File file3 = this.e;
                if (zExists) {
                    aVar3.a(file3);
                } else {
                    aVar3.c(file3, this.f12478c);
                }
            }
            w8.a aVar4 = this.f12476a;
            File file4 = this.f12478c;
            aVar4.getClass();
            if (file4.exists()) {
                try {
                    k();
                    j();
                    this.f12485n = true;
                    return;
                } catch (IOException e) {
                    h.f13740a.k(5, "DiskLruCache " + this.f12477b + " is corrupt: " + e.getMessage() + ", removing", e);
                    try {
                        close();
                        this.f12476a.b(this.f12477b);
                        this.f12486o = false;
                    } catch (Throwable th) {
                        this.f12486o = false;
                        throw th;
                    }
                }
            }
            m();
            this.f12485n = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.Flushable
    public final synchronized void flush() {
        if (this.f12485n) {
            a();
            o();
            this.f12481j.flush();
        }
    }

    public final boolean h() {
        int i10 = this.f12483l;
        return i10 >= 2000 && i10 >= this.f12482k.size();
    }

    public final a0 i() {
        z8.b bVar;
        File file = this.f12478c;
        this.f12476a.getClass();
        int i10 = 1;
        try {
            Logger logger = y.f14516a;
            file.getClass();
            bVar = new z8.b(i10, new FileOutputStream(file, true), new j0());
        } catch (FileNotFoundException unused) {
            file.getParentFile().mkdirs();
            Logger logger2 = y.f14516a;
            bVar = new z8.b(i10, new FileOutputStream(file, true), new j0());
        }
        return new a0(new c(this, bVar, 0));
    }

    public final synchronized boolean isClosed() {
        return this.f12486o;
    }

    public final void j() throws IOException {
        File file = this.f12479d;
        w8.a aVar = this.f12476a;
        aVar.a(file);
        Iterator it = this.f12482k.values().iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            g1 g1Var = dVar.f;
            int i10 = this.h;
            int i11 = 0;
            if (g1Var == null) {
                while (i11 < i10) {
                    this.f12480i += dVar.f12468b[i11];
                    i11++;
                }
            } else {
                dVar.f = null;
                while (i11 < i10) {
                    aVar.a(dVar.f12469c[i11]);
                    aVar.a(dVar.f12470d[i11]);
                    i11++;
                }
                it.remove();
            }
        }
    }

    public final void k() throws IOException {
        this.f12476a.getClass();
        b0 b0Var = new b0(t1.S(this.f12478c));
        try {
            String utf8LineStrict = b0Var.readUtf8LineStrict(Long.MAX_VALUE);
            String utf8LineStrict2 = b0Var.readUtf8LineStrict(Long.MAX_VALUE);
            String utf8LineStrict3 = b0Var.readUtf8LineStrict(Long.MAX_VALUE);
            String utf8LineStrict4 = b0Var.readUtf8LineStrict(Long.MAX_VALUE);
            String utf8LineStrict5 = b0Var.readUtf8LineStrict(Long.MAX_VALUE);
            if (!"libcore.io.DiskLruCache".equals(utf8LineStrict) || !"1".equals(utf8LineStrict2) || !Integer.toString(this.f).equals(utf8LineStrict3) || !Integer.toString(this.h).equals(utf8LineStrict4) || !"".equals(utf8LineStrict5)) {
                throw new IOException("unexpected journal header: [" + utf8LineStrict + ", " + utf8LineStrict2 + ", " + utf8LineStrict4 + ", " + utf8LineStrict5 + "]");
            }
            int i10 = 0;
            while (true) {
                try {
                    l(b0Var.readUtf8LineStrict(Long.MAX_VALUE));
                    i10++;
                } catch (EOFException unused) {
                    this.f12483l = i10 - this.f12482k.size();
                    if (b0Var.exhausted()) {
                        this.f12481j = i();
                    } else {
                        m();
                    }
                    q8.c.c(b0Var);
                    return;
                }
            }
        } catch (Throwable th) {
            q8.c.c(b0Var);
            throw th;
        }
    }

    public final void l(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            com.google.gson.internal.a.m("unexpected journal line: ".concat(str));
            return;
        }
        int i10 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i10);
        LinkedHashMap linkedHashMap = this.f12482k;
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i10);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                linkedHashMap.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i10, iIndexOf2);
        }
        d dVar = (d) linkedHashMap.get(strSubstring);
        if (dVar == null) {
            dVar = new d(this, strSubstring);
            linkedHashMap.put(strSubstring, dVar);
        }
        if (iIndexOf2 == -1 || iIndexOf != 5 || !str.startsWith("CLEAN")) {
            if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f = new g1(this, dVar);
                return;
            } else {
                if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
                    return;
                }
                com.google.gson.internal.a.m("unexpected journal line: ".concat(str));
                return;
            }
        }
        String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
        dVar.e = true;
        dVar.f = null;
        if (strArrSplit.length != dVar.h.h) {
            androidx.core.view.accessibility.a.i(Arrays.toString(strArrSplit), "unexpected journal line: ");
            return;
        }
        for (int i11 = 0; i11 < strArrSplit.length; i11++) {
            try {
                dVar.f12468b[i11] = Long.parseLong(strArrSplit[i11]);
            } catch (NumberFormatException unused) {
                androidx.core.view.accessibility.a.i(Arrays.toString(strArrSplit), "unexpected journal line: ");
                return;
            }
        }
    }

    public final synchronized void m() {
        z8.b bVar;
        try {
            a0 a0Var = this.f12481j;
            if (a0Var != null) {
                a0Var.close();
            }
            w8.a aVar = this.f12476a;
            File file = this.f12479d;
            aVar.getClass();
            int i10 = 1;
            try {
                Logger logger = y.f14516a;
                file.getClass();
                bVar = new z8.b(i10, new FileOutputStream(file, false), new j0());
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                Logger logger2 = y.f14516a;
                bVar = new z8.b(i10, new FileOutputStream(file, false), new j0());
            }
            a0 a0Var2 = new a0(bVar);
            try {
                a0Var2.writeUtf8("libcore.io.DiskLruCache");
                a0Var2.writeByte(10);
                a0Var2.writeUtf8("1");
                a0Var2.writeByte(10);
                a0Var2.b(this.f);
                a0Var2.writeByte(10);
                a0Var2.b(this.h);
                a0Var2.writeByte(10);
                a0Var2.writeByte(10);
                for (d dVar : this.f12482k.values()) {
                    if (dVar.f != null) {
                        a0Var2.writeUtf8("DIRTY");
                        a0Var2.writeByte(32);
                        a0Var2.writeUtf8(dVar.f12467a);
                        a0Var2.writeByte(10);
                    } else {
                        a0Var2.writeUtf8("CLEAN");
                        a0Var2.writeByte(32);
                        a0Var2.writeUtf8(dVar.f12467a);
                        for (long j10 : dVar.f12468b) {
                            a0Var2.writeByte(32);
                            a0Var2.b(j10);
                        }
                        a0Var2.writeByte(10);
                    }
                }
                a0Var2.close();
                w8.a aVar2 = this.f12476a;
                File file2 = this.f12478c;
                aVar2.getClass();
                if (file2.exists()) {
                    this.f12476a.c(this.f12478c, this.e);
                }
                this.f12476a.c(this.f12479d, this.f12478c);
                this.f12476a.a(this.e);
                this.f12481j = i();
                this.f12484m = false;
                this.f12488q = false;
            } catch (Throwable th) {
                a0Var2.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void n(d dVar) throws IOException {
        g1 g1Var = dVar.f;
        String str = dVar.f12467a;
        if (g1Var != null) {
            g1Var.e();
        }
        for (int i10 = 0; i10 < this.h; i10++) {
            this.f12476a.a(dVar.f12469c[i10]);
            long j10 = this.f12480i;
            long[] jArr = dVar.f12468b;
            this.f12480i = j10 - jArr[i10];
            jArr[i10] = 0;
        }
        this.f12483l++;
        a0 a0Var = this.f12481j;
        a0Var.writeUtf8("REMOVE");
        a0Var.writeByte(32);
        a0Var.writeUtf8(str);
        a0Var.writeByte(10);
        this.f12482k.remove(str);
        if (h()) {
            this.f12490s.execute(this.t);
        }
    }

    public final void o() throws IOException {
        while (this.f12480i > this.g) {
            n((d) this.f12482k.values().iterator().next());
        }
        this.f12487p = false;
    }
}
