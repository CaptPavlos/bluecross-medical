package a3;

import android.content.Context;
import android.graphics.Bitmap;
import c1.w4;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppFilesActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.Updates;
import com.uptodown.core.activities.ConfirmationIntentWrapperActivity;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.gcm.MyFirebaseMessagingService;
import java.util.ArrayList;
import java.util.Iterator;
import l4.a4;
import l4.l7;
import l4.m6;
import l4.n5;
import l4.o2;
import l4.q4;
import l4.u4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f140a;

    /* renamed from: b, reason: collision with root package name */
    public int f141b;

    /* renamed from: c, reason: collision with root package name */
    public Object f142c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f143d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(int i10, MainActivity mainActivity, h5.q qVar, w6.c cVar) {
        super(2, cVar);
        this.f140a = 18;
        this.f141b = i10;
        this.f142c = mainActivity;
        this.f143d = qVar;
    }

    private final Object a(Object obj) throws Throwable {
        int i10 = this.f141b;
        if (i10 == 0) {
            s6.a.e(obj);
            AppFilesActivity appFilesActivity = (AppFilesActivity) this.f142c;
            h5.w wVar = (h5.w) this.f143d;
            w2.r rVar = new w2.r(appFilesActivity, (String) null, wVar.f8781a, new i0.k(4, appFilesActivity, wVar));
            this.f141b = 1;
            Object objX = rVar.x(this);
            x6.a aVar = x6.a.f13718a;
            if (objX == aVar) {
                return aVar;
            }
        } else {
            if (i10 != 1) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
        }
        return s6.w.f12711a;
    }

    private final Object b(Object obj) throws Throwable {
        int i10 = this.f141b;
        w6.c cVar = null;
        s6.w wVar = s6.w.f12711a;
        if (i10 != 0) {
            if (i10 == 1) {
                s6.a.e(obj);
                return wVar;
            }
            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        s6.a.e(obj);
        MainActivity mainActivity = (MainActivity) this.f142c;
        o2 o2Var = (o2) this.f143d;
        this.f141b = 1;
        y7.e eVar = r7.i0.f12407a;
        Object objZ = r7.y.z(new a6.j(mainActivity, o2Var, cVar, 0), y7.d.f14116a, this);
        x6.a aVar = x6.a.f13718a;
        if (objZ != aVar) {
            objZ = wVar;
        }
        return objZ == aVar ? aVar : wVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object d(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.o.d(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object e(java.lang.Object r8) {
        /*
            r7 = this;
            int r0 = r7.f141b
            s6.a.e(r8)
            java.lang.Object r8 = r7.f142c
            com.uptodown.activities.MyApps r8 = (com.uptodown.activities.MyApps) r8
            n4.p r1 = r8.W
            if (r1 == 0) goto Lc3
            java.lang.Object r1 = r7.f143d
            java.lang.String r1 = (java.lang.String) r1
            int r1 = com.uptodown.activities.MyApps.B0(r8, r1)
            r2 = -1
            r3 = 1
            r4 = 0
            if (r1 <= r2) goto L1c
            r2 = r3
            goto L1d
        L1c:
            r2 = r4
        L1d:
            r5 = 306(0x132, float:4.29E-43)
            if (r0 != r5) goto L37
            if (r2 == 0) goto Lc3
            n4.p r0 = r8.W
            r0.getClass()
            java.util.ArrayList r0 = r0.f11451d
            r0.remove(r1)
            n4.p r8 = r8.W
            r8.getClass()
            r8.notifyItemRemoved(r1)
            goto Lc3
        L37:
            r5 = 301(0x12d, float:4.22E-43)
            if (r0 != r5) goto L47
            if (r2 == 0) goto Lc3
            n4.p r8 = r8.W
            r8.getClass()
            r8.notifyItemChanged(r1)
            goto Lc3
        L47:
            r5 = 305(0x131, float:4.27E-43)
            if (r0 == r5) goto Lc3
            r5 = 302(0x12e, float:4.23E-43)
            if (r0 != r5) goto L5e
            if (r2 == 0) goto L5a
            n4.p r8 = r8.W
            r8.getClass()
            r8.notifyItemChanged(r1)
            goto Lc3
        L5a:
            r8.G0(r4)
            goto Lc3
        L5e:
            if (r2 == 0) goto L82
            n4.p r5 = r8.W
            r5.getClass()
            java.util.ArrayList r5 = r5.f11451d
            java.lang.Object r5 = r5.get(r1)
            boolean r5 = r5 instanceof h5.f
            if (r5 == 0) goto L82
            n4.p r5 = r8.W
            r5.getClass()
            java.util.ArrayList r5 = r5.f11451d
            java.lang.Object r5 = r5.get(r1)
            r5.getClass()
            h5.f r5 = (h5.f) r5
            java.lang.String r5 = r5.f8525b
            goto L83
        L82:
            r5 = 0
        L83:
            r6 = 304(0x130, float:4.26E-43)
            if (r0 == r6) goto La5
            r6 = 307(0x133, float:4.3E-43)
            if (r0 == r6) goto L9a
            java.lang.Object[] r0 = new java.lang.Object[r3]
            r0[r4] = r5
            r3 = 2131952070(0x7f1301c6, float:1.9540572E38)
            java.lang.String r0 = r8.getString(r3, r0)
            r0.getClass()
            goto Laf
        L9a:
            r0 = 2131951993(0x7f130179, float:1.9540416E38)
            java.lang.String r0 = r8.getString(r0)
            r0.getClass()
            goto Laf
        La5:
            r0 = 2131952292(0x7f1302a4, float:1.9541023E38)
            java.lang.String r0 = r8.getString(r0)
            r0.getClass()
        Laf:
            r8.N(r0)
            n4.p r8 = r8.W
            if (r2 == 0) goto Lbd
            r8.getClass()
            r8.notifyItemChanged(r1)
            goto Lc3
        Lbd:
            r8.getClass()
            r8.notifyDataSetChanged()
        Lc3:
            s6.w r8 = s6.w.f12711a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.o.e(java.lang.Object):java.lang.Object");
    }

    private final Object g(Object obj) throws Throwable {
        Iterator it;
        MyDownloads myDownloads = (MyDownloads) this.f143d;
        int i10 = this.f141b;
        w6.c cVar = null;
        if (i10 == 0) {
            s6.a.e(obj);
            n4.b bVar = myDownloads.J;
            if (bVar != null) {
                ArrayList arrayList = new ArrayList();
                boolean[] zArr = bVar.f11302d;
                zArr.getClass();
                int length = zArr.length;
                for (int i11 = 0; i11 < length; i11++) {
                    if (zArr[i11]) {
                        boolean[] zArr2 = bVar.f11302d;
                        zArr2.getClass();
                        if (i11 < zArr2.length) {
                            arrayList.add(bVar.f11300b.get(i11));
                        }
                    }
                }
                Iterator it2 = arrayList.iterator();
                it2.getClass();
                it = it2;
            }
            myDownloads.r0(false);
            myDownloads.u0();
            return s6.w.f12711a;
        }
        if (i10 != 1) {
            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        it = (Iterator) this.f142c;
        s6.a.e(obj);
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            int i12 = MyDownloads.O;
            q4 q4VarQ0 = myDownloads.q0();
            this.f142c = it;
            this.f141b = 1;
            q4VarQ0.getClass();
            y7.e eVar = r7.i0.f12407a;
            Object objZ = r7.y.z(new a6.j(next, (Context) myDownloads, cVar, 29), y7.d.f14116a, this);
            x6.a aVar = x6.a.f13718a;
            if (objZ == aVar) {
                return aVar;
            }
        }
        myDownloads.r0(false);
        myDownloads.u0();
        return s6.w.f12711a;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object h(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f143d
            h5.q r0 = (h5.q) r0
            s6.a.e(r10)
            java.lang.Object r10 = r9.f142c
            com.uptodown.activities.MyDownloads r10 = (com.uptodown.activities.MyDownloads) r10
            n4.b r1 = r10.J
            if (r1 == 0) goto Lac
            int r2 = r9.f141b
            r3 = 202(0xca, float:2.83E-43)
            r4 = 0
            if (r2 == r3) goto La9
            r3 = 203(0xcb, float:2.84E-43)
            if (r2 == r3) goto La9
            r3 = 207(0xcf, float:2.9E-43)
            if (r2 == r3) goto L6a
            if (r0 == 0) goto Lac
            java.lang.String r1 = r0.f8701b
            r2 = -1
            if (r1 == 0) goto L50
            int r3 = r1.length()
            if (r3 != 0) goto L2c
            goto L50
        L2c:
            n4.b r3 = r10.J
            r3.getClass()
            java.util.ArrayList r3 = r3.f11300b
            int r5 = r3.size()
            r6 = r4
        L38:
            if (r6 >= r5) goto L50
            java.lang.Object r7 = r3.get(r6)
            r7.getClass()
            h5.q r7 = (h5.q) r7
            java.lang.String r7 = r7.f8701b
            r8 = 1
            boolean r7 = o7.u.Z(r7, r1, r8)
            if (r7 == 0) goto L4d
            goto L51
        L4d:
            int r6 = r6 + 1
            goto L38
        L50:
            r6 = r2
        L51:
            if (r6 <= r2) goto L66
            n4.b r1 = r10.J
            r1.getClass()
            java.util.ArrayList r1 = r1.f11300b
            r1.set(r6, r0)
            n4.b r10 = r10.J
            r10.getClass()
            r10.notifyItemChanged(r6)
            goto Lac
        L66:
            r10.r0(r4)
            goto Lac
        L6a:
            java.util.ArrayList r1 = r1.f11300b
            boolean r1 = t6.l.a0(r1, r0)
            if (r1 == 0) goto Lac
            n4.b r1 = r10.J
            r1.getClass()
            n4.b r2 = r10.J
            r2.getClass()
            java.util.ArrayList r2 = r2.f11300b
            int r2 = t6.l.e0(r2, r0)
            r1.notifyItemRemoved(r2)
            n4.b r1 = r10.J
            r1.getClass()
            java.util.ArrayList r1 = r1.f11300b
            kotlin.jvm.internal.a0.a(r1)
            r1.remove(r0)
            n4.b r0 = r10.J
            r0.getClass()
            java.util.ArrayList r0 = r0.f11300b
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lac
            d5.b0 r10 = r10.p0()
            android.widget.TextView r10 = r10.h
            r10.setVisibility(r4)
            goto Lac
        La9:
            r10.r0(r4)
        Lac:
            s6.w r10 = s6.w.f12711a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.o.h(java.lang.Object):java.lang.Object");
    }

    private final Object i(Object obj) throws Throwable {
        int i10 = this.f141b;
        if (i10 == 0) {
            s6.a.e(obj);
            OldVersionsActivity oldVersionsActivity = (OldVersionsActivity) this.f142c;
            h5.c0 c0Var = (h5.c0) this.f143d;
            w2.r rVar = new w2.r(oldVersionsActivity, c0Var.g, (String) null, new i0.k(11, oldVersionsActivity, c0Var));
            this.f141b = 1;
            Object objX = rVar.x(this);
            x6.a aVar = x6.a.f13718a;
            if (objX == aVar) {
                return aVar;
            }
        } else {
            if (i10 != 1) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
        }
        return s6.w.f12711a;
    }

    private final Object j(Object obj) throws Throwable {
        m6 m6Var = (m6) this.f142c;
        int i10 = this.f141b;
        s6.w wVar = s6.w.f12711a;
        if (i10 != 0) {
            if (i10 == 1) {
                s6.a.e(obj);
                return wVar;
            }
            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        s6.a.e(obj);
        m6Var.e = true;
        u7.m0 m0Var = m6Var.f10626a;
        m0Var.getClass();
        m0Var.g(null, v5.j.f13166a);
        n5 n5Var = new n5(m6Var, 2);
        w4 w4Var = new w4((Context) this.f143d, (short) 0);
        String str = (String) m6Var.f10628c.getValue();
        int i11 = m6Var.f;
        this.f141b = 1;
        y7.e eVar = r7.i0.f12407a;
        Object objZ = r7.y.z(new c5.h0(w4Var, str, i11, n5Var, (w6.c) null), y7.d.f14116a, this);
        x6.a aVar = x6.a.f13718a;
        if (objZ != aVar) {
            objZ = wVar;
        }
        return objZ == aVar ? aVar : wVar;
    }

    private final Object k(Object obj) throws Throwable {
        l7 l7Var = (l7) this.f142c;
        int i10 = this.f141b;
        s6.w wVar = s6.w.f12711a;
        if (i10 == 0) {
            s6.a.e(obj);
            l7Var.f = true;
            u7.m0 m0Var = l7Var.f10596a;
            m0Var.getClass();
            m0Var.g(null, v5.j.f13166a);
            n5 n5Var = new n5(l7Var, 5);
            w4 w4Var = new w4((Context) this.f143d, (short) 0);
            int i11 = l7Var.g;
            this.f141b = 1;
            y7.e eVar = r7.i0.f12407a;
            Object objZ = r7.y.z(new b9.o(w4Var, 30, i11, n5Var, null, 1), y7.d.f14116a, this);
            x6.a aVar = x6.a.f13718a;
            if (objZ != aVar) {
                objZ = wVar;
            }
            if (objZ == aVar) {
                return aVar;
            }
        } else {
            if (i10 != 1) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
        }
        return wVar;
    }

    private final Object l(Object obj) throws Throwable {
        int i10 = this.f141b;
        w6.c cVar = null;
        if (i10 == 0) {
            s6.a.e(obj);
            y7.e eVar = r7.i0.f12407a;
            s7.c cVar2 = w7.n.f13548a;
            a6.n nVar = new a6.n((d5.x0) this.f143d, cVar, 21);
            this.f141b = 1;
            Object objZ = r7.y.z(nVar, cVar2, this);
            x6.a aVar = x6.a.f13718a;
            if (objZ == aVar) {
                return aVar;
            }
        } else {
            if (i10 != 1) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
        }
        ((SecurityActivity) this.f142c).u0();
        return s6.w.f12711a;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object m(java.lang.Object r9) {
        /*
            r8 = this;
            int r0 = r8.f141b
            s6.a.e(r9)
            java.lang.Object r9 = r8.f142c
            com.uptodown.activities.Updates r9 = (com.uptodown.activities.Updates) r9
            n4.w0 r1 = r9.X
            if (r1 == 0) goto Ld6
            java.lang.Object r1 = r8.f143d
            java.lang.String r1 = (java.lang.String) r1
            int r1 = com.uptodown.activities.Updates.B0(r9, r1)
            r2 = -1
            r3 = 1
            r4 = 0
            if (r1 <= r2) goto L1c
            r2 = r3
            goto L1d
        L1c:
            r2 = r4
        L1d:
            r5 = 306(0x132, float:4.29E-43)
            if (r0 != r5) goto L39
            if (r2 == 0) goto Ld6
            n4.w0 r0 = r9.X
            r0.getClass()
            java.util.ArrayList r0 = r0.a()
            r0.remove(r1)
            n4.w0 r9 = r9.X
            r9.getClass()
            r9.notifyItemRemoved(r1)
            goto Ld6
        L39:
            r5 = 301(0x12d, float:4.22E-43)
            if (r0 != r5) goto L49
            if (r2 == 0) goto Ld6
            n4.w0 r9 = r9.X
            r9.getClass()
            r9.notifyItemChanged(r1)
            goto Ld6
        L49:
            r5 = 305(0x131, float:4.27E-43)
            if (r0 == r5) goto Ld6
            r5 = 302(0x12e, float:4.23E-43)
            if (r0 != r5) goto L62
            if (r2 == 0) goto L5d
            n4.w0 r9 = r9.X
            r9.getClass()
            r9.notifyItemChanged(r1)
            goto Ld6
        L5d:
            r9.M0(r4)
            goto Ld6
        L62:
            if (r2 == 0) goto L8c
            n4.w0 r5 = r9.X
            r5.getClass()
            java.util.ArrayList r5 = r5.a()
            java.lang.Object r5 = r5.get(r1)
            boolean r5 = r5 instanceof n4.u0
            if (r5 == 0) goto L8c
            n4.w0 r5 = r9.X
            r5.getClass()
            java.util.ArrayList r5 = r5.a()
            java.lang.Object r5 = r5.get(r1)
            r5.getClass()
            n4.u0 r5 = (n4.u0) r5
            h5.f r5 = r5.f11493a
            java.lang.String r5 = r5.f8525b
            goto L8d
        L8c:
            r5 = 0
        L8d:
            r6 = 303(0x12f, float:4.25E-43)
            r7 = 2131952070(0x7f1301c6, float:1.9540572E38)
            if (r0 == r6) goto Lbe
            r6 = 304(0x130, float:4.26E-43)
            if (r0 == r6) goto Lb3
            r6 = 307(0x133, float:4.3E-43)
            if (r0 == r6) goto La8
            java.lang.Object[] r0 = new java.lang.Object[r3]
            r0[r4] = r5
            java.lang.String r0 = r9.getString(r7, r0)
            r0.getClass()
            goto Lc9
        La8:
            r0 = 2131951993(0x7f130179, float:1.9540416E38)
            java.lang.String r0 = r9.getString(r0)
            r0.getClass()
            goto Lc9
        Lb3:
            r0 = 2131952292(0x7f1302a4, float:1.9541023E38)
            java.lang.String r0 = r9.getString(r0)
            r0.getClass()
            goto Lc9
        Lbe:
            java.lang.Object[] r0 = new java.lang.Object[r3]
            r0[r4] = r5
            java.lang.String r0 = r9.getString(r7, r0)
            r0.getClass()
        Lc9:
            r9.N(r0)
            if (r2 == 0) goto Ld6
            n4.w0 r9 = r9.X
            r9.getClass()
            r9.notifyItemChanged(r1)
        Ld6:
            s6.w r9 = s6.w.f12711a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.o.m(java.lang.Object):java.lang.Object");
    }

    private final Object o(Object obj) throws Throwable {
        int i10 = this.f141b;
        w6.c cVar = null;
        if (i10 == 0) {
            s6.a.e(obj);
            y7.e eVar = r7.i0.f12407a;
            s7.c cVar2 = w7.n.f13548a.f12716c;
            u4 u4Var = new u4((Bitmap) this.f142c, (m6.e) this.f143d, cVar, 16);
            this.f141b = 1;
            Object objZ = r7.y.z(u4Var, cVar2, this);
            x6.a aVar = x6.a.f13718a;
            if (objZ == aVar) {
                return aVar;
            }
        } else {
            if (i10 != 1) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
        }
        return s6.w.f12711a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:
    
        if (r7.y.z(r3, r2, r11) == r1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0089, code lost:
    
        if (r7.y.z(r3, r2, r11) != r1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a2, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object p(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = r11.f143d
            com.uptodown.core.activities.ConfirmationIntentWrapperActivity r0 = (com.uptodown.core.activities.ConfirmationIntentWrapperActivity) r0
            x6.a r1 = x6.a.f13718a
            int r2 = r11.f141b
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L27
            if (r2 == r6) goto L23
            if (r2 == r4) goto L23
            if (r2 == r3) goto L1a
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r12)
            return r5
        L1a:
            java.lang.Object r0 = r11.f142c
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            s6.a.e(r12)
            goto La4
        L23:
            s6.a.e(r12)
            goto L8c
        L27:
            s6.a.e(r12)
            r12 = 23
            android.content.pm.PackageManager r2 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            android.content.pm.PackageInstaller r2 = r2.getPackageInstaller()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            int r7 = o4.b.f11710i     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            android.content.pm.PackageInstaller$SessionInfo r2 = r2.getSessionInfo(r7)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            if (r2 == 0) goto L50
            float r2 = r2.getProgress()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            double r7 = (double) r2     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            r9 = 4605471050941616620(0x3fe9eb851eb851ec, double:0.81)
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 < 0) goto L50
            r2 = r6
            goto L51
        L4c:
            r2 = move-exception
            goto L8f
        L4e:
            r2 = move-exception
            goto L6e
        L50:
            r2 = 0
        L51:
            r7.m r7 = com.google.android.gms.internal.measurement.j4.f     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            if (r7 == 0) goto L5c
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            r7.P(r2)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
        L5c:
            y7.e r2 = r7.i0.f12407a
            s7.c r2 = w7.n.f13548a
            a6.n r3 = new a6.n
            r3.<init>(r0, r5, r12)
            r11.f141b = r6
            java.lang.Object r12 = r7.y.z(r3, r2, r11)
            if (r12 != r1) goto L8c
            goto La2
        L6e:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L4c
            r7.m r2 = com.google.android.gms.internal.measurement.j4.f     // Catch: java.lang.Throwable -> L4c
            if (r2 == 0) goto L7a
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L4c
            r2.P(r6)     // Catch: java.lang.Throwable -> L4c
        L7a:
            y7.e r2 = r7.i0.f12407a
            s7.c r2 = w7.n.f13548a
            a6.n r3 = new a6.n
            r3.<init>(r0, r5, r12)
            r11.f141b = r4
            java.lang.Object r12 = r7.y.z(r3, r2, r11)
            if (r12 != r1) goto L8c
            goto La2
        L8c:
            s6.w r12 = s6.w.f12711a
            return r12
        L8f:
            y7.e r4 = r7.i0.f12407a
            s7.c r4 = w7.n.f13548a
            a6.n r6 = new a6.n
            r6.<init>(r0, r5, r12)
            r11.f142c = r2
            r11.f141b = r3
            java.lang.Object r12 = r7.y.z(r6, r4, r11)
            if (r12 != r1) goto La3
        La2:
            return r1
        La3:
            r0 = r2
        La4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.o.p(java.lang.Object):java.lang.Object");
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f140a) {
            case 0:
                return new o((p) this.f142c, (d1) this.f143d, cVar, 0);
            case 1:
                return new o((k1) this.f142c, (o0) this.f143d, cVar, 1);
            case 2:
                return new o((x) this.f142c, (ArrayList) this.f143d, cVar, 2);
            case 3:
                return new o((a4.f) this.f142c, (h5.g0) this.f143d, cVar, 3);
            case 4:
                return new o((h5.h) this.f142c, (a4.f) this.f143d, cVar, 4);
            case 5:
                return new o((c5.b0) this.f142c, (n5) this.f143d, cVar, 5);
            case 6:
                o oVar = new o((d3.c) this.f143d, cVar, 6);
                oVar.f142c = obj;
                return oVar;
            case 7:
                return new o((e5.d) this.f142c, (h5.h) this.f143d, cVar, 7);
            case 8:
                return new o((e5.j0) this.f142c, (h5.t0) this.f143d, cVar, 8);
            case 9:
                return new o((e5.j0) this.f142c, (Context) this.f143d, cVar, 9);
            case 10:
                return new o((e5.j0) this.f142c, (e5.w) this.f143d, cVar, 10);
            case 11:
                return new o((MyFirebaseMessagingService) this.f142c, (String) this.f143d, cVar, 11);
            case 12:
                return new o((g2.f) this.f142c, (g7.l) this.f143d, cVar, 12);
            case 13:
                return new o((j5.a) this.f142c, (c5.b0) this.f143d, cVar, 13);
            case 14:
                return new o((UptodownApp) this.f142c, (String) this.f143d, cVar, 14);
            case 15:
                return new o((UptodownApp) this.f142c, (d0.i) this.f143d, cVar, 15);
            case 16:
                return new o((AppFilesActivity) this.f142c, (h5.w) this.f143d, cVar, 16);
            case 17:
                return new o((MainActivity) this.f142c, (o2) this.f143d, cVar, 17);
            case 18:
                return new o(this.f141b, (MainActivity) this.f142c, (h5.q) this.f143d, cVar);
            case 19:
                return new o((MyApps) this.f142c, (String) this.f143d, this.f141b, cVar, 19);
            case 20:
                return new o((MyDownloads) this.f143d, cVar, 20);
            case 21:
                return new o((MyDownloads) this.f142c, this.f141b, (h5.q) this.f143d, cVar);
            case 22:
                return new o((OldVersionsActivity) this.f142c, (h5.c0) this.f143d, cVar, 22);
            case 23:
                return new o((m6) this.f142c, (Context) this.f143d, cVar, 23);
            case 24:
                return new o((l7) this.f142c, (Context) this.f143d, cVar, 24);
            case 25:
                return new o((SecurityActivity) this.f142c, (d5.x0) this.f143d, cVar, 25);
            case 26:
                return new o((Updates) this.f142c, (String) this.f143d, this.f141b, cVar, 26);
            case 27:
                return new o((Bitmap) this.f142c, (m6.e) this.f143d, cVar, 27);
            case 28:
                return new o((ConfirmationIntentWrapperActivity) this.f143d, cVar, 28);
            default:
                o oVar2 = new o((FileExplorerActivity) this.f143d, cVar, 29);
                oVar2.f142c = obj;
                return oVar2;
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        switch (this.f140a) {
            case 8:
                ((o) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
                break;
            case 18:
                o oVar = (o) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar = s6.w.f12711a;
                oVar.invokeSuspend(wVar);
                break;
            case 19:
                o oVar2 = (o) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar2 = s6.w.f12711a;
                oVar2.invokeSuspend(wVar2);
                break;
            case 21:
                o oVar3 = (o) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar3 = s6.w.f12711a;
                oVar3.invokeSuspend(wVar3);
                break;
            case 26:
                o oVar4 = (o) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar4 = s6.w.f12711a;
                oVar4.invokeSuspend(wVar4);
                break;
            case 27:
                break;
        }
        return ((o) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:358:0x077e, code lost:
    
        if (r7.y.z(r3, r2, r27) == r15) goto L362;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x0791, code lost:
    
        if (r7.y.z(r2, r0, r27) == r15) goto L362;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x084e, code lost:
    
        if (r7.y.z(r2, r0, r27) == r15) goto L404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x0863, code lost:
    
        if (r7.y.z(r2, r0, r27) == r15) goto L404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x0878, code lost:
    
        if (r7.y.z(r2, r0, r27) == r15) goto L404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x088c, code lost:
    
        if (r7.y.z(r2, r0, r27) == r15) goto L404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x088f, code lost:
    
        return r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x08f9, code lost:
    
        if (r7.y.z(r3, r2, r27) == r15) goto L431;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x090d, code lost:
    
        if (r7.y.z(r3, r2, r27) == r15) goto L431;
     */
    /* JADX WARN: Code restructure failed: missing block: B:430:0x0922, code lost:
    
        if (r7.y.z(r3, r2, r27) == r15) goto L431;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x0a07, code lost:
    
        if (r0.updateData(r3, r27) == r15) goto L481;
     */
    /* JADX WARN: Code restructure failed: missing block: B:480:0x0a51, code lost:
    
        if (a3.k1.a(r2, r0, a3.h1.f83b, r27) == r15) goto L481;
     */
    /* JADX WARN: Code restructure failed: missing block: B:506:0x0abe, code lost:
    
        if (r2.b(r27) == r15) goto L507;
     */
    /* JADX WARN: Code restructure failed: missing block: B:585:?, code lost:
    
        return r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:589:?, code lost:
    
        return r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:593:?, code lost:
    
        return r15;
     */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x06b4  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x06b9  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x06de  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2884
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.o.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(MyDownloads myDownloads, int i10, h5.q qVar, w6.c cVar) {
        super(2, cVar);
        this.f140a = 21;
        this.f142c = myDownloads;
        this.f141b = i10;
        this.f143d = qVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(Object obj, Object obj2, w6.c cVar, int i10) {
        super(2, cVar);
        this.f140a = i10;
        this.f142c = obj;
        this.f143d = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(Object obj, w6.c cVar, int i10) {
        super(2, cVar);
        this.f140a = i10;
        this.f143d = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(a4 a4Var, String str, int i10, w6.c cVar, int i11) {
        super(2, cVar);
        this.f140a = i11;
        this.f142c = a4Var;
        this.f143d = str;
        this.f141b = i10;
    }
}
