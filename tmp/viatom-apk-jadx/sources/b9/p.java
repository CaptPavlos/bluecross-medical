package b9;

import a3.z0;
import android.app.Activity;
import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import c1.w4;
import c5.b0;
import c5.t;
import com.uptodown.activities.ContactUsActivity;
import com.uptodown.activities.ListsActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.UsernameEditActivity;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.activities.preferences.PreferencesActivity;
import e5.c1;
import h5.g0;
import h5.i1;
import h5.m0;
import h5.t0;
import h5.v0;
import java.io.File;
import kotlin.jvm.internal.v;
import l4.b9;
import l4.c7;
import l4.d6;
import l4.f7;
import l4.k8;
import l4.kc;
import l4.l7;
import l4.n5;
import l4.p1;
import l4.pc;
import l4.wa;
import l4.x4;
import l4.y7;
import p4.d0;
import r7.i0;
import r7.x;
import r7.y;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f924a;

    /* renamed from: b, reason: collision with root package name */
    public int f925b;

    /* renamed from: c, reason: collision with root package name */
    public Object f926c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f927d;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(b9 b9Var, Context context, String str, int i10, w6.c cVar) {
        super(2, cVar);
        this.f924a = 18;
        this.f927d = b9Var;
        this.e = context;
        this.f926c = str;
        this.f925b = i10;
    }

    private final Object a(Object obj) throws Throwable {
        int i10 = this.f925b;
        w wVar = w.f12711a;
        if (i10 == 0) {
            s6.a.e(obj);
            b0 b0Var = new b0((Context) this.f926c, false);
            int i11 = ((pc) this.f927d).e;
            n5 n5Var = (n5) this.e;
            this.f925b = 1;
            y7.e eVar = i0.f12407a;
            Object objZ = y.z(new o(b0Var, 30, i11, n5Var, null, 2), y7.d.f14116a, this);
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

    private final Object b(Object obj) throws Throwable {
        m6.a aVar;
        int i10 = this.f925b;
        if (i10 == 0) {
            s6.a.e(obj);
            aVar = (m6.a) this.f927d;
            z0 z0Var = ((m6.f) this.e).e;
            this.f926c = aVar;
            this.f925b = 1;
            obj = z0Var.h(this);
            x6.a aVar2 = x6.a.f13718a;
            if (obj == aVar2) {
                return aVar2;
            }
        } else {
            if (i10 != 1) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            aVar = (m6.a) this.f926c;
            s6.a.e(obj);
        }
        aVar.invoke(obj);
        return w.f12711a;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b2 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object d(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = r12.e
            androidx.documentfile.provider.DocumentFile r0 = (androidx.documentfile.provider.DocumentFile) r0
            java.lang.Object r1 = r12.f927d
            s4.n r1 = (s4.n) r1
            java.lang.Object r2 = r12.f926c
            java.io.File r2 = (java.io.File) r2
            x6.a r3 = x6.a.f13718a
            int r4 = r12.f925b
            r5 = 5
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            s6.w r10 = s6.w.f12711a
            r11 = 0
            if (r4 == 0) goto L3e
            if (r4 == r9) goto L3a
            if (r4 == r8) goto L36
            if (r4 == r7) goto L32
            if (r4 == r6) goto L2e
            if (r4 != r5) goto L28
            s6.a.e(r13)
            return r10
        L28:
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r13)
            return r11
        L2e:
            s6.a.e(r13)
            return r10
        L32:
            s6.a.e(r13)
            return r10
        L36:
            s6.a.e(r13)
            return r10
        L3a:
            s6.a.e(r13)
            return r10
        L3e:
            s6.a.e(r13)
            java.io.FileInputStream r13 = new java.io.FileInputStream     // Catch: java.lang.SecurityException -> L8e java.io.FileNotFoundException -> La0
            r13.<init>(r2)     // Catch: java.lang.SecurityException -> L8e java.io.FileNotFoundException -> La0
            android.content.Context r4 = r1.e     // Catch: java.io.FileNotFoundException -> L7c
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch: java.io.FileNotFoundException -> L7c
            if (r4 == 0) goto L57
            android.net.Uri r9 = r0.getUri()     // Catch: java.io.FileNotFoundException -> L7c
            java.io.OutputStream r4 = r4.openOutputStream(r9)     // Catch: java.io.FileNotFoundException -> L7c
            goto L58
        L57:
            r4 = r11
        L58:
            if (r4 != 0) goto L6c
            y7.e r13 = r7.i0.f12407a
            s7.c r13 = w7.n.f13548a
            s4.i r2 = new s4.i
            r2.<init>(r1, r0, r11, r7)
            r12.f925b = r6
            java.lang.Object r13 = r7.y.z(r2, r13, r12)
            if (r13 != r3) goto Lb2
            goto Lb1
        L6c:
            java.lang.String r0 = r2.getName()
            r2.length()
            r12.f925b = r5
            java.lang.Object r13 = r1.b(r13, r4, r0, r12)
            if (r13 != r3) goto Lb2
            goto Lb1
        L7c:
            y7.e r13 = r7.i0.f12407a
            s7.c r13 = w7.n.f13548a
            s4.i r2 = new s4.i
            r2.<init>(r1, r0, r11, r8)
            r12.f925b = r7
            java.lang.Object r13 = r7.y.z(r2, r13, r12)
            if (r13 != r3) goto Lb2
            goto Lb1
        L8e:
            y7.e r13 = r7.i0.f12407a
            s7.c r13 = w7.n.f13548a
            s4.h r0 = new s4.h
            r0.<init>(r1, r2, r11, r6)
            r12.f925b = r8
            java.lang.Object r13 = r7.y.z(r0, r13, r12)
            if (r13 != r3) goto Lb2
            goto Lb1
        La0:
            y7.e r13 = r7.i0.f12407a
            s7.c r13 = w7.n.f13548a
            s4.h r0 = new s4.h
            r0.<init>(r1, r2, r11, r7)
            r12.f925b = r9
            java.lang.Object r13 = r7.y.z(r0, r13, r12)
            if (r13 != r3) goto Lb2
        Lb1:
            return r3
        Lb2:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: b9.p.d(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [t7.i] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    private final Object e(Object obj) throws Throwable {
        ?? r42;
        int i10 = this.f925b;
        w wVar = w.f12711a;
        if (i10 != 0) {
            if (i10 == 1) {
                s6.a.e(obj);
                return wVar;
            }
            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        s6.a.e(obj);
        r7.w wVar2 = (r7.w) this.f926c;
        u7.i iVar = (u7.i) this.f927d;
        u7.d dVar = (u7.d) this.e;
        switch (dVar.f12985d) {
            case 2:
                w6.h hVar = dVar.f12982a;
                int i11 = dVar.f12983b;
                p4.i0 i0Var = new p4.i0(dVar, null, 12);
                r7.a rVar = new t7.r(y.r(wVar2, hVar), r0.f.a(i11, t7.a.f12813a, 4));
                rVar.e0(x.f12445a, rVar, i0Var);
                r42 = rVar;
                break;
            default:
                w6.h hVar2 = dVar.f12982a;
                int i12 = dVar.f12983b;
                if (i12 == -3) {
                    i12 = -2;
                }
                t7.a aVar = dVar.f12984c;
                p4.i0 i0Var2 = new p4.i0(dVar, null, 12);
                r7.a rVar2 = new t7.r(y.r(wVar2, hVar2), r0.f.a(i12, aVar, 4));
                rVar2.e0(x.f12447c, rVar2, i0Var2);
                r42 = rVar2;
                break;
        }
        this.f925b = 1;
        Object objH = u7.i0.h(iVar, r42, true, this);
        x6.a aVar2 = x6.a.f13718a;
        if (objH != aVar2) {
            objH = wVar;
        }
        return objH == aVar2 ? aVar2 : wVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f924a) {
            case 0:
                return new p(this.f926c, this.f927d, this.e, cVar, 0);
            case 1:
                return new p((w2.r) this.f927d, (w4) this.e, cVar, 1);
            case 2:
                return new p((t) this.f927d, (w4) this.e, cVar, 2);
            case 3:
                return new p((c5.x) this.f927d, (String) this.f926c, (g5.q) this.e, cVar);
            case 4:
                return new p((c1) this.f926c, (t0) this.f927d, (Context) this.e, cVar, 4);
            case 5:
                return new p(this.f927d, this.e, (String) this.f926c, cVar, 5);
            case 6:
                return new p((v) this.f926c, (ContactUsActivity) this.f927d, (kotlin.jvm.internal.x) this.e, cVar, 6);
            case 7:
                return new p((ContactUsActivity) this.e, (String) this.f926c, (String) this.f927d, cVar);
            case 8:
                return new p(this.f927d, this.e, (String) this.f926c, cVar, 8);
            case 9:
                return new p((ListsActivity) this.f926c, (p1) this.f927d, (d0.i) this.e, cVar, 9);
            case 10:
                return new p((ListsActivity) this.f926c, (p1) this.f927d, (y2.c) this.e, cVar, 10);
            case 11:
                return new p((Context) this.f926c, (g0) this.f927d, (d6) this.e, cVar, 11);
            case 12:
                return new p((t0) this.f926c, (Context) this.f927d, (c7) this.e, cVar, 12);
            case 13:
                return new p((RecommendedActivity) this.f926c, (i1) this.f927d, (f7) this.e, cVar, 13);
            case 14:
                return new p((l7) this.f926c, (Context) this.f927d, (x4) this.e, cVar, 14);
            case 15:
                return new p((m0) this.f926c, (Context) this.f927d, (y7) this.e, cVar, 15);
            case 16:
                return new p((t0) this.f926c, (Context) this.f927d, (y7) this.e, cVar, 16);
            case 17:
                return new p((t0) this.f926c, (Context) this.f927d, (k8) this.e, cVar, 17);
            case 18:
                return new p((b9) this.f927d, (Context) this.e, (String) this.f926c, this.f925b, cVar);
            case 19:
                return new p((t0) this.f926c, (Context) this.f927d, (wa) this.e, cVar, 19);
            case 20:
                return new p((UsernameEditActivity) this.f926c, (v) this.f927d, (kotlin.jvm.internal.x) this.e, cVar, 20);
            case 21:
                return new p((WishlistActivity) this.f926c, (i1) this.f927d, (kc) this.e, cVar, 21);
            case 22:
                return new p((Context) this.f926c, (pc) this.f927d, (n5) this.e, cVar, 22);
            case 23:
                return new p((v0) this.f926c, (PreferencesActivity) this.f927d, (h5.p) this.e, cVar, 23);
            case 24:
                return new p((m6.a) this.f927d, (m6.f) this.e, cVar, 24);
            case 25:
                return new p((File) this.f926c, (s4.n) this.f927d, (DocumentFile) this.e, cVar, 25);
            case 26:
                p pVar = new p((u7.i) this.f927d, (u7.d) this.e, cVar, 26);
                pVar.f926c = obj;
                return pVar;
            default:
                return new p((String) this.f926c, (Activity) this.f927d, (d0) this.e, cVar, 27);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f924a) {
            case 18:
                p pVar = (p) create(wVar, cVar);
                w wVar2 = w.f12711a;
                pVar.invokeSuspend(wVar2);
                break;
            case 20:
                ((p) create(wVar, cVar)).invokeSuspend(w.f12711a);
                break;
        }
        return ((p) create(wVar, cVar)).invokeSuspend(w.f12711a);
    }

    /* JADX WARN: Removed duplicated region for block: B:371:0x0851  */
    /* JADX WARN: Removed duplicated region for block: B:557:? A[RETURN, SYNTHETIC] */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 3134
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b9.p.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(ContactUsActivity contactUsActivity, String str, String str2, w6.c cVar) {
        super(2, cVar);
        this.f924a = 7;
        this.e = contactUsActivity;
        this.f926c = str;
        this.f927d = str2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(Object obj, Object obj2, Object obj3, w6.c cVar, int i10) {
        super(2, cVar);
        this.f924a = i10;
        this.f926c = obj;
        this.f927d = obj2;
        this.e = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(Object obj, Object obj2, String str, w6.c cVar, int i10) {
        super(2, cVar);
        this.f924a = i10;
        this.f927d = obj;
        this.e = obj2;
        this.f926c = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(Object obj, Object obj2, w6.c cVar, int i10) {
        super(2, cVar);
        this.f924a = i10;
        this.f927d = obj;
        this.e = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(c5.x xVar, String str, g5.q qVar, w6.c cVar) {
        super(2, cVar);
        this.f924a = 3;
        this.f927d = xVar;
        this.f926c = str;
        this.e = qVar;
    }
}
