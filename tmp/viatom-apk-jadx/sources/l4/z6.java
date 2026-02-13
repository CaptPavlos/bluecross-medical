package l4;

import com.uptodown.activities.PublicProfileActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z6 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f11065a;

    /* renamed from: b, reason: collision with root package name */
    public int f11066b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c7 f11067c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f11068d;
    public final /* synthetic */ PublicProfileActivity e;
    public final /* synthetic */ String f;
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z6(c7 c7Var, int i10, PublicProfileActivity publicProfileActivity, String str, int i11, w6.c cVar) {
        super(2, cVar);
        this.f11067c = c7Var;
        this.f11068d = i10;
        this.e = publicProfileActivity;
        this.f = str;
        this.g = i11;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new z6(this.f11067c, this.f11068d, this.e, this.f, this.g, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((z6) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x008c, code lost:
    
        if (r15 != r10) goto L30;
     */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            r14 = this;
            int r0 = r14.f11066b
            r1 = 0
            s6.w r2 = s6.w.f12711a
            r3 = 3
            r4 = 2
            r5 = 1
            java.lang.String r6 = r14.f
            com.uptodown.activities.PublicProfileActivity r7 = r14.e
            l4.c7 r8 = r14.f11067c
            r9 = 0
            x6.a r10 = x6.a.f13718a
            if (r0 == 0) goto L2e
            if (r0 == r5) goto L2a
            if (r0 == r4) goto L26
            if (r0 != r3) goto L20
            java.util.ArrayList r0 = r14.f11065a
            s6.a.e(r15)
            goto L8f
        L20:
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r15)
            return r9
        L26:
            s6.a.e(r15)
            goto L78
        L2a:
            s6.a.e(r15)
            goto L66
        L2e:
            s6.a.e(r15)
            int r15 = r14.f11068d
            r8.f10298i = r15
            h5.e1 r15 = h5.c1.h(r7)
            if (r15 == 0) goto L3e
            java.lang.String r15 = r15.f8512a
            goto L3f
        L3e:
            r15 = r9
        L3f:
            boolean r15 = r6.equals(r15)
            if (r15 == 0) goto L66
            c5.b0 r15 = new c5.b0
            r15.<init>(r7, r1)
            l4.n5 r0 = new l4.n5
            r0.<init>(r8, r3)
            r14.f11066b = r5
            y7.e r11 = r7.i0.f12407a
            y7.d r11 = y7.d.f14116a
            a3.o r12 = new a3.o
            r13 = 5
            r12.<init>(r15, r0, r9, r13)
            java.lang.Object r15 = r7.y.z(r12, r11, r14)
            if (r15 != r10) goto L62
            goto L63
        L62:
            r15 = r2
        L63:
            if (r15 != r10) goto L66
            goto L8e
        L66:
            r14.f11066b = r4
            y7.e r15 = r7.i0.f12407a
            y7.d r15 = y7.d.f14116a
            l4.b7 r0 = new l4.b7
            r0.<init>(r7, r6, r9, r5)
            java.lang.Object r15 = r7.y.z(r0, r15, r14)
            if (r15 != r10) goto L78
            goto L8e
        L78:
            r0 = r15
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            r14.f11065a = r0
            r14.f11066b = r3
            y7.e r15 = r7.i0.f12407a
            y7.d r15 = y7.d.f14116a
            l4.b7 r3 = new l4.b7
            r3.<init>(r7, r6, r9, r1)
            java.lang.Object r15 = r7.y.z(r3, r15, r14)
            if (r15 != r10) goto L8f
        L8e:
            return r10
        L8f:
            java.util.ArrayList r15 = (java.util.ArrayList) r15
            u7.m0 r1 = r8.f10294a
            v5.l r3 = new v5.l
            l4.y6 r4 = new l4.y6
            r4.<init>(r15, r0)
            r3.<init>(r4)
            r1.getClass()
            r1.g(r9, r3)
            u7.m0 r15 = r8.g
            v5.l r0 = new v5.l
            h5.d1 r1 = new h5.d1
            r3 = -1
            int r4 = r14.g
            r1.<init>(r6, r5, r3, r4)
            r0.<init>(r1)
            r15.getClass()
            r15.g(r9, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.z6.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
