package s8;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import p8.e0;
import p8.m;
import p8.u;
import p8.y;
import v8.a0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final p8.a f12736a;

    /* renamed from: b, reason: collision with root package name */
    public c f12737b;

    /* renamed from: c, reason: collision with root package name */
    public e0 f12738c;

    /* renamed from: d, reason: collision with root package name */
    public final m f12739d;
    public final p8.b e;
    public final Object f;
    public final d g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public a f12740i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f12741j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12742k;

    /* renamed from: l, reason: collision with root package name */
    public t8.b f12743l;

    public f(m mVar, p8.a aVar, y yVar, p8.b bVar, Object obj) {
        this.f12739d = mVar;
        this.f12736a = aVar;
        this.e = bVar;
        p8.b.e.getClass();
        this.g = new d(aVar, mVar.e, yVar, bVar);
        this.f = obj;
    }

    public final synchronized a a() {
        return this.f12740i;
    }

    public final Socket b(boolean z9, boolean z10, boolean z11) {
        Socket socket;
        if (z11) {
            this.f12743l = null;
        }
        if (z10) {
            this.f12742k = true;
        }
        a aVar = this.f12740i;
        if (aVar != null) {
            if (z9) {
                aVar.f12722k = true;
            }
            if (this.f12743l == null && (this.f12742k || aVar.f12722k)) {
                ArrayList arrayList = aVar.f12725n;
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (((Reference) arrayList.get(i10)).get() == this) {
                        arrayList.remove(i10);
                        if (this.f12740i.f12725n.isEmpty()) {
                            this.f12740i.f12726o = System.nanoTime();
                            p8.b bVar = p8.b.e;
                            a aVar2 = this.f12740i;
                            bVar.getClass();
                            m mVar = this.f12739d;
                            mVar.getClass();
                            if (aVar2.f12722k || mVar.f12127a == 0) {
                                mVar.f12130d.remove(aVar2);
                                socket = this.f12740i.e;
                            } else {
                                mVar.notifyAll();
                                socket = null;
                            }
                        } else {
                            socket = null;
                        }
                        this.f12740i = null;
                        return socket;
                    }
                }
                u.e();
                return null;
            }
        }
        return null;
    }

    public final a c(int i10, int i11, int i12, boolean z9) throws Throwable {
        a aVar;
        boolean z10;
        Socket socketA;
        Socket socketB;
        a aVar2;
        boolean z11;
        e0 e0Var;
        boolean z12;
        c cVar;
        synchronized (this.f12739d) {
            try {
                if (this.f12742k) {
                    throw new IllegalStateException("released");
                }
                if (this.f12743l != null) {
                    throw new IllegalStateException("codec != null");
                }
                aVar = this.f12740i;
                z10 = true;
                socketA = null;
                socketB = (aVar == null || !aVar.f12722k) ? null : b(false, false, true);
                aVar2 = this.f12740i;
                if (aVar2 != null) {
                    aVar = null;
                } else {
                    aVar2 = null;
                }
                if (!this.f12741j) {
                    aVar = null;
                }
                if (aVar2 == null) {
                    p8.b bVar = p8.b.e;
                    m mVar = this.f12739d;
                    p8.a aVar3 = this.f12736a;
                    bVar.getClass();
                    p8.b.b(mVar, aVar3, this, null);
                    a aVar4 = this.f12740i;
                    if (aVar4 != null) {
                        z11 = true;
                        aVar2 = aVar4;
                    } else {
                        e0Var = this.f12738c;
                        z11 = false;
                    }
                } else {
                    z11 = false;
                }
                e0Var = null;
            } finally {
            }
        }
        q8.c.d(socketB);
        if (aVar != null) {
            this.e.getClass();
        }
        if (z11) {
            this.e.getClass();
        }
        if (aVar2 != null) {
            return aVar2;
        }
        if (e0Var != null || ((cVar = this.f12737b) != null && cVar.f12730b < cVar.f12729a.size())) {
            z12 = false;
        } else {
            this.f12737b = this.g.b();
            z12 = true;
        }
        synchronized (this.f12739d) {
            if (z12) {
                try {
                    c cVar2 = this.f12737b;
                    cVar2.getClass();
                    ArrayList arrayList = new ArrayList(cVar2.f12729a);
                    int size = arrayList.size();
                    int i13 = 0;
                    while (true) {
                        if (i13 >= size) {
                            break;
                        }
                        e0 e0Var2 = (e0) arrayList.get(i13);
                        p8.b bVar2 = p8.b.e;
                        m mVar2 = this.f12739d;
                        p8.a aVar5 = this.f12736a;
                        bVar2.getClass();
                        p8.b.b(mVar2, aVar5, this, e0Var2);
                        a aVar6 = this.f12740i;
                        if (aVar6 != null) {
                            this.f12738c = e0Var2;
                            z11 = true;
                            aVar2 = aVar6;
                            break;
                        }
                        i13++;
                    }
                } finally {
                }
            }
            if (!z11) {
                if (e0Var == null) {
                    c cVar3 = this.f12737b;
                    if (!(cVar3.f12730b < cVar3.f12729a.size())) {
                        throw new NoSuchElementException();
                    }
                    ArrayList arrayList2 = cVar3.f12729a;
                    int i14 = cVar3.f12730b;
                    cVar3.f12730b = i14 + 1;
                    e0Var = (e0) arrayList2.get(i14);
                }
                this.f12738c = e0Var;
                this.h = 0;
                aVar2 = new a(this.f12739d, e0Var);
                if (this.f12740i != null) {
                    throw new IllegalStateException();
                }
                this.f12740i = aVar2;
                this.f12741j = false;
                aVar2.f12725n.add(new e(this, this.f));
            }
        }
        if (z11) {
            this.e.getClass();
            return aVar2;
        }
        aVar2.c(i10, i11, i12, z9, this.e);
        p8.b bVar3 = p8.b.e;
        m mVar3 = this.f12739d;
        bVar3.getClass();
        mVar3.e.e(aVar2.f12718c);
        synchronized (this.f12739d) {
            try {
                this.f12741j = true;
                p8.b bVar4 = p8.b.e;
                m mVar4 = this.f12739d;
                bVar4.getClass();
                if (!mVar4.f) {
                    mVar4.f = true;
                    m.g.execute(mVar4.f12129c);
                }
                mVar4.f12130d.add(aVar2);
                if (aVar2.h == null) {
                    z10 = false;
                }
                if (z10) {
                    p8.b bVar5 = p8.b.e;
                    m mVar5 = this.f12739d;
                    p8.a aVar7 = this.f12736a;
                    bVar5.getClass();
                    socketA = p8.b.a(mVar5, aVar7, this);
                    aVar2 = this.f12740i;
                }
            } finally {
            }
        }
        q8.c.d(socketA);
        this.e.getClass();
        return aVar2;
    }

    public final a d(int i10, int i11, int i12, boolean z9, boolean z10) throws Throwable {
        while (true) {
            a aVarC = c(i10, i11, i12, z9);
            synchronized (this.f12739d) {
                try {
                    if (aVarC.f12723l == 0) {
                        return aVarC;
                    }
                    if (aVarC.h(z10)) {
                        return aVarC;
                    }
                    e();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void e() throws IOException {
        a aVar;
        Socket socketB;
        synchronized (this.f12739d) {
            aVar = this.f12740i;
            socketB = b(true, false, false);
            if (this.f12740i != null) {
                aVar = null;
            }
        }
        q8.c.d(socketB);
        if (aVar != null) {
            this.e.getClass();
        }
    }

    public final void f() throws IOException {
        a aVar;
        Socket socketB;
        synchronized (this.f12739d) {
            aVar = this.f12740i;
            socketB = b(false, true, false);
            if (this.f12740i != null) {
                aVar = null;
            }
        }
        q8.c.d(socketB);
        if (aVar != null) {
            this.e.getClass();
        }
    }

    public final void g(IOException iOException) throws IOException {
        a aVar;
        boolean z9;
        Socket socketB;
        synchronized (this.f12739d) {
            try {
                aVar = null;
                if (iOException instanceof a0) {
                    int i10 = ((a0) iOException).f13204a;
                    if (i10 == 5) {
                        this.h++;
                    }
                    if (i10 != 5 || this.h > 1) {
                        this.f12738c = null;
                        z9 = true;
                    }
                    z9 = false;
                } else {
                    a aVar2 = this.f12740i;
                    if (aVar2 != null) {
                        if (!(aVar2.h != null) || (iOException instanceof v8.a)) {
                            if (aVar2.f12723l == 0) {
                                e0 e0Var = this.f12738c;
                                if (e0Var != null && iOException != null) {
                                    this.g.a(e0Var, iOException);
                                }
                                this.f12738c = null;
                            }
                            z9 = true;
                        }
                    }
                    z9 = false;
                }
                a aVar3 = this.f12740i;
                socketB = b(z9, false, true);
                if (this.f12740i == null && this.f12741j) {
                    aVar = aVar3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        q8.c.d(socketB);
        if (aVar != null) {
            this.e.getClass();
        }
    }

    public final void h(boolean z9, t8.b bVar, IOException iOException) throws IOException {
        a aVar;
        Socket socketB;
        boolean z10;
        this.e.getClass();
        synchronized (this.f12739d) {
            try {
                if (bVar != this.f12743l) {
                    throw new IllegalStateException("expected " + this.f12743l + " but was " + bVar);
                }
                if (!z9) {
                    this.f12740i.f12723l++;
                }
                aVar = this.f12740i;
                socketB = b(z9, false, true);
                if (this.f12740i != null) {
                    aVar = null;
                }
                z10 = this.f12742k;
            } catch (Throwable th) {
                throw th;
            }
        }
        q8.c.d(socketB);
        if (aVar != null) {
            this.e.getClass();
        }
        if (iOException != null) {
            this.e.getClass();
        } else if (z10) {
            this.e.getClass();
        }
    }

    public final String toString() {
        a aVarA = a();
        return aVarA != null ? aVarA.toString() : this.f12736a.toString();
    }
}
