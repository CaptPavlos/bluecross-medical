package h0;

import com.uptodown.R;
import com.uptodown.activities.PublicListActivity;
import h5.i1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import l4.n5;
import n4.d1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a0 implements g5.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8351a;

    /* renamed from: b, reason: collision with root package name */
    public int f8352b;

    /* renamed from: c, reason: collision with root package name */
    public Object f8353c;

    public a0(int i10) {
        this.f8351a = i10;
        switch (i10) {
            case 4:
                this.f8353c = new int[10];
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(h0.a0 r9, s6.b r10, y6.a r11) {
        /*
            java.lang.Object r0 = r9.f8353c
            a6.f r0 = (a6.f) r0
            boolean r1 = r11 instanceof i8.s
            if (r1 == 0) goto L17
            r1 = r11
            i8.s r1 = (i8.s) r1
            int r2 = r1.g
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.g = r2
            goto L1c
        L17:
            i8.s r1 = new i8.s
            r1.<init>(r9, r11)
        L1c:
            java.lang.Object r11 = r1.e
            int r2 = r1.g
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 7
            r7 = 4
            r8 = 1
            if (r2 == 0) goto L5d
            if (r2 != r8) goto L56
            java.lang.String r9 = r1.f9088d
            java.util.LinkedHashMap r10 = r1.f9087c
            h0.a0 r0 = r1.f9086b
            s6.b r2 = r1.f9085a
            s6.a.e(r11)
            h8.k r11 = (h8.k) r11
            r10.put(r9, r11)
            java.lang.Object r9 = r0.f8353c
            a6.f r9 = (a6.f) r9
            byte r9 = r9.h()
            if (r9 == r7) goto L51
            if (r9 != r6) goto L47
            goto L96
        L47:
            java.lang.Object r9 = r0.f8353c
            a6.f r9 = (a6.f) r9
            java.lang.String r10 = "Expected end of the object or comma"
            a6.f.o(r9, r10, r3, r4, r5)
            throw r4
        L51:
            r11 = r9
            r9 = r0
            r0 = r10
            r10 = r2
            goto L6f
        L56:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r9)
            r9 = 0
            return r9
        L5d:
            s6.a.e(r11)
            byte r11 = r0.i(r5)
            byte r2 = r0.t()
            if (r2 == r7) goto Lae
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
        L6f:
            java.lang.Object r2 = r9.f8353c
            a6.f r2 = (a6.f) r2
            boolean r3 = r2.c()
            if (r3 == 0) goto L93
            java.lang.String r11 = r2.l()
            r3 = 5
            r2.i(r3)
            r1.f9085a = r10
            r1.f9086b = r9
            r1.f9087c = r0
            r1.f9088d = r11
            r1.g = r8
            r10.getClass()
            r10.f12686b = r1
            x6.a r9 = x6.a.f13718a
            return r9
        L93:
            r10 = r0
            r0 = r9
            r9 = r11
        L96:
            java.lang.Object r11 = r0.f8353c
            a6.f r11 = (a6.f) r11
            if (r9 != r5) goto La0
            r11.i(r6)
            goto La2
        La0:
            if (r9 == r7) goto La8
        La2:
            h8.t r9 = new h8.t
            r9.<init>(r10)
            return r9
        La8:
            java.lang.String r9 = "object"
            i8.l.j(r11, r9)
            throw r4
        Lae:
            java.lang.String r9 = "Unexpected leading comma"
            a6.f.o(r0, r9, r3, r4, r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.a0.a(h0.a0, s6.b, y6.a):java.lang.Object");
    }

    public void b(int i10, int i11) {
        int i12 = i11 + i10;
        char[] cArr = (char[]) this.f8353c;
        if (cArr.length <= i12) {
            int i13 = i10 * 2;
            if (i12 < i13) {
                i12 = i13;
            }
            this.f8353c = Arrays.copyOf(cArr, i12);
        }
    }

    public int c() {
        if ((this.f8352b & 128) != 0) {
            return ((int[]) this.f8353c)[7];
        }
        return 65535;
    }

    public h8.k d() {
        h8.k tVar;
        Object obj;
        a6.f fVar = (a6.f) this.f8353c;
        byte bT = fVar.t();
        if (bT == 1) {
            return g(true);
        }
        if (bT == 0) {
            return g(false);
        }
        if (bT != 6) {
            if (bT == 8) {
                return e();
            }
            a6.f.o(fVar, "Cannot read Json element because of unexpected ".concat(i8.l.p(bT)), 0, null, 6);
            throw null;
        }
        int i10 = this.f8352b + 1;
        this.f8352b = i10;
        if (i10 == 200) {
            i8.r rVar = new i8.r(this, null);
            s6.b bVar = new s6.b();
            bVar.f12685a = rVar;
            bVar.f12686b = bVar;
            x6.a aVar = s6.a.f12684a;
            bVar.f12687c = aVar;
            while (true) {
                obj = bVar.f12687c;
                w6.c cVar = bVar.f12686b;
                if (cVar == null) {
                    break;
                }
                if (kotlin.jvm.internal.l.a(aVar, obj)) {
                    try {
                        i8.r rVar2 = bVar.f12685a;
                        kotlin.jvm.internal.a0.b(3, rVar2);
                        i8.r rVar3 = new i8.r(rVar2.f9084c, cVar);
                        rVar3.f9083b = bVar;
                        Object objInvokeSuspend = rVar3.invokeSuspend(s6.w.f12711a);
                        if (objInvokeSuspend != x6.a.f13718a) {
                            cVar.resumeWith(objInvokeSuspend);
                        }
                    } catch (Throwable th) {
                        cVar.resumeWith(new s6.j(th));
                    }
                } else {
                    bVar.f12687c = aVar;
                    cVar.resumeWith(obj);
                }
            }
            s6.a.e(obj);
            tVar = (h8.k) obj;
        } else {
            byte bI = fVar.i((byte) 6);
            if (fVar.t() == 4) {
                a6.f.o(fVar, "Unexpected leading comma", 0, null, 6);
                throw null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (true) {
                if (!fVar.c()) {
                    break;
                }
                String strL = fVar.l();
                fVar.i((byte) 5);
                linkedHashMap.put(strL, d());
                bI = fVar.h();
                if (bI != 4) {
                    if (bI != 7) {
                        a6.f.o(fVar, "Expected end of the object or comma", 0, null, 6);
                        throw null;
                    }
                }
            }
            if (bI == 6) {
                fVar.i((byte) 7);
            } else if (bI == 4) {
                i8.l.j(fVar, "object");
                throw null;
            }
            tVar = new h8.t(linkedHashMap);
        }
        this.f8352b--;
        return tVar;
    }

    public h8.d e() {
        a6.f fVar = (a6.f) this.f8353c;
        byte bH = fVar.h();
        if (fVar.t() == 4) {
            a6.f.o(fVar, "Unexpected leading comma", 0, null, 6);
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        while (fVar.c()) {
            arrayList.add(d());
            bH = fVar.h();
            if (bH != 4) {
                boolean z9 = bH == 9;
                int i10 = fVar.f256b;
                if (!z9) {
                    a6.f.o(fVar, "Expected end of the array or comma", i10, null, 4);
                    throw null;
                }
            }
        }
        if (bH == 8) {
            fVar.i((byte) 9);
        } else if (bH == 4) {
            i8.l.j(fVar, "array");
            throw null;
        }
        return new h8.d(arrayList);
    }

    @Override // g5.i
    public void f(int i10) {
        String str;
        PublicListActivity publicListActivity = (PublicListActivity) this.f8353c;
        d1 d1Var = publicListActivity.W;
        d1Var.getClass();
        Object obj = d1Var.f11324a.get(this.f8352b);
        obj.getClass();
        i1 i1Var = (i1) obj;
        if (i1Var.f == 13 || (str = i1Var.f8620i) == null || str.length() == 0) {
            String string = publicListActivity.getString(R.string.error_cant_enqueue_download);
            string.getClass();
            publicListActivity.C(string);
        } else {
            String str2 = i1Var.f8620i;
            str2.getClass();
            v5.c.e(publicListActivity, str2, null);
        }
    }

    public h8.x g(boolean z9) {
        a6.f fVar = (a6.f) this.f8353c;
        String strM = !z9 ? fVar.m() : fVar.l();
        return (z9 || !kotlin.jvm.internal.l.a(strM, "null")) ? new h8.n(strM, z9) : h8.q.INSTANCE;
    }

    public void h() {
        i8.c cVar = i8.c.f9064c;
        char[] cArr = (char[]) this.f8353c;
        cVar.getClass();
        cArr.getClass();
        synchronized (cVar) {
            int i10 = cVar.f9066b;
            if (cArr.length + i10 < i8.b.f9063a) {
                cVar.f9066b = i10 + cArr.length;
                cVar.f9065a.addLast(cArr);
            }
        }
    }

    public void i(int i10, int i11) {
        if (i10 >= 0) {
            int[] iArr = (int[]) this.f8353c;
            if (i10 >= iArr.length) {
                return;
            }
            this.f8352b = (1 << i10) | this.f8352b;
            iArr[i10] = i11;
        }
    }

    public void j(String str) {
        str.getClass();
        int length = str.length();
        if (length == 0) {
            return;
        }
        b(this.f8352b, length);
        str.getChars(0, str.length(), (char[]) this.f8353c, this.f8352b);
        this.f8352b += length;
    }

    @Override // g5.i
    public void l(h5.h hVar) {
        PublicListActivity publicListActivity = (PublicListActivity) this.f8353c;
        l1.b.h(publicListActivity, publicListActivity, hVar, new n5(publicListActivity, 1), true);
    }

    public String toString() {
        switch (this.f8351a) {
            case 1:
                return new String((char[]) this.f8353c, 0, this.f8352b);
            default:
                return super.toString();
        }
    }

    public a0(h8.h hVar, a6.f fVar) {
        this.f8351a = 2;
        hVar.getClass();
        this.f8353c = fVar;
    }

    public a0(f0.b bVar, int i10) {
        this.f8351a = 0;
        i0.y.g(bVar);
        this.f8353c = bVar;
        this.f8352b = i10;
    }

    public a0(PublicListActivity publicListActivity, int i10) {
        this.f8351a = 3;
        this.f8353c = publicListActivity;
        this.f8352b = i10;
    }
}
