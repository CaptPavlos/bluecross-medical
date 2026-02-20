package s5;

import com.uptodown.tv.ui.fragment.TvOldVersionsFragment;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12628a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TvOldVersionsFragment f12629b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f0(TvOldVersionsFragment tvOldVersionsFragment, w6.c cVar, int i10) {
        super(2, cVar);
        this.f12628a = i10;
        this.f12629b = tvOldVersionsFragment;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f12628a) {
            case 0:
                return new f0(this.f12629b, cVar, 0);
            default:
                return new f0(this.f12629b, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f12628a) {
            case 0:
                f0 f0Var = (f0) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                f0Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                f0 f0Var2 = (f0) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                f0Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            int r0 = r6.f12628a
            switch(r0) {
                case 0: goto L25;
                default: goto L5;
            }
        L5:
            com.uptodown.tv.ui.fragment.TvOldVersionsFragment r0 = r6.f12629b
            s6.a.e(r7)
            h5.h r7 = r0.f6715a     // Catch: java.lang.Exception -> L1e
            if (r7 == 0) goto L22
            java.util.ArrayList r1 = r7.C0     // Catch: java.lang.Exception -> L1e
            if (r1 == 0) goto L22
            r7.getClass()     // Catch: java.lang.Exception -> L1e
            java.util.ArrayList r7 = r7.C0     // Catch: java.lang.Exception -> L1e
            r7.getClass()     // Catch: java.lang.Exception -> L1e
            com.uptodown.tv.ui.fragment.TvOldVersionsFragment.c(r0, r7)     // Catch: java.lang.Exception -> L1e
            goto L22
        L1e:
            r7 = move-exception
            r7.printStackTrace()
        L22:
            s6.w r7 = s6.w.f12711a
            return r7
        L25:
            s6.a.e(r7)
            com.uptodown.tv.ui.fragment.TvOldVersionsFragment r7 = r6.f12629b
            h5.h r0 = r7.f6715a
            if (r0 == 0) goto L87
            android.content.Context r0 = r7.getContext()
            if (r0 == 0) goto L87
            h5.h r0 = r7.f6715a
            r0.getClass()
            java.util.ArrayList r0 = r0.C0
            if (r0 == 0) goto L5c
            h5.h r0 = r7.f6715a
            r0.getClass()
            java.util.ArrayList r0 = r0.C0
            r0.getClass()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L5c
            h5.h r0 = r7.f6715a
            r0.getClass()
            java.util.ArrayList r0 = r0.C0
            r0.getClass()
            int r0 = r0.size()
            goto L5d
        L5c:
            r0 = 0
        L5d:
            e0.n r1 = new e0.n
            android.content.Context r2 = r7.requireContext()
            r2.getClass()
            h5.h r3 = r7.f6715a
            r3.getClass()
            l4.n5 r4 = new l4.n5
            r5 = 21
            r4.<init>(r7, r5)
            r1.<init>(r2, r3, r4, r0)
            androidx.lifecycle.LifecycleCoroutineScope r7 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r7)
            r7.getClass()
            c5.u r0 = new c5.u
            r2 = 0
            r3 = 0
            r0.<init>(r1, r3, r2)
            r1 = 3
            r7.y.q(r7, r3, r3, r0, r1)
        L87:
            s6.w r7 = s6.w.f12711a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.f0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
