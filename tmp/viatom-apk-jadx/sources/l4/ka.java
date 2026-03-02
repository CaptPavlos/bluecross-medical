package l4;

import com.uptodown.activities.UserAvatarActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ka extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10570a;

    /* renamed from: b, reason: collision with root package name */
    public int f10571b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UserAvatarActivity f10572c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ka(UserAvatarActivity userAvatarActivity, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10570a = i10;
        this.f10572c = userAvatarActivity;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10570a) {
            case 0:
                return new ka(this.f10572c, cVar, 0);
            case 1:
                return new ka(this.f10572c, cVar, 1);
            default:
                return new ka(this.f10572c, cVar, 2);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10570a) {
            case 0:
                break;
            case 1:
                ((ka) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            default:
                ((ka) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
        }
        return x6.a.f13718a;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cb  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            int r0 = r13.f10570a
            r1 = 0
            com.uptodown.activities.UserAvatarActivity r2 = r13.f10572c
            r3 = 0
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            x6.a r5 = x6.a.f13718a
            r6 = 1
            switch(r0) {
                case 0: goto L5a;
                case 1: goto L34;
                default: goto Le;
            }
        Le:
            int r0 = r13.f10571b
            if (r0 == 0) goto L1d
            if (r0 == r6) goto L18
            androidx.window.layout.c.g(r4)
            goto L33
        L18:
            com.google.android.gms.internal.measurement.u6 r14 = androidx.constraintlayout.core.widgets.analyzer.a.q(r14)
            throw r14
        L1d:
            s6.a.e(r14)
            int r14 = com.uptodown.activities.UserAvatarActivity.O
            l4.pa r14 = r2.o0()
            u7.m0 r14 = r14.f10739d
            l4.la r0 = new l4.la
            r0.<init>(r2, r6)
            r13.f10571b = r6
            r14.collect(r0, r13)
            r3 = r5
        L33:
            return r3
        L34:
            int r0 = r13.f10571b
            if (r0 == 0) goto L43
            if (r0 == r6) goto L3e
            androidx.window.layout.c.g(r4)
            goto L59
        L3e:
            com.google.android.gms.internal.measurement.u6 r14 = androidx.constraintlayout.core.widgets.analyzer.a.q(r14)
            throw r14
        L43:
            s6.a.e(r14)
            int r14 = com.uptodown.activities.UserAvatarActivity.O
            l4.pa r14 = r2.o0()
            u7.m0 r14 = r14.f10737b
            l4.la r0 = new l4.la
            r0.<init>(r2, r1)
            r13.f10571b = r6
            r14.collect(r0, r13)
            r3 = r5
        L59:
            return r3
        L5a:
            com.uptodown.activities.UserAvatarActivity r8 = r13.f10572c
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.M
            int r2 = r13.f10571b
            s6.w r12 = s6.w.f12711a
            if (r2 == 0) goto L6e
            if (r2 != r6) goto L6a
            s6.a.e(r14)
            goto Lcd
        L6a:
            androidx.window.layout.c.g(r4)
            goto Ld1
        L6e:
            s6.a.e(r14)
            boolean r14 = r0.compareAndSet(r1, r6)
            if (r14 == 0) goto Ld0
            r13.f10571b = r6
            androidx.lifecycle.LifecycleCoroutineScope r14 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r8)
            y7.e r2 = r7.i0.f12407a
            s7.c r2 = w7.n.f13548a
            l4.ka r3 = new l4.ka
            r10 = 0
            r4 = 2
            r3.<init>(r8, r10, r4)
            r7.y.q(r14, r2, r10, r3, r4)
            n4.z0 r14 = r8.J
            r2 = -1
            if (r14 == 0) goto L9e
            int r3 = r14.f
            if (r3 == r2) goto L9e
            java.util.ArrayList r14 = r14.f11523a
            java.lang.Object r14 = r14.get(r3)
            h5.j r14 = (h5.j) r14
        L9c:
            r9 = r14
            goto Lb0
        L9e:
            n4.z0 r14 = r8.K
            if (r14 == 0) goto Laf
            int r3 = r14.f
            if (r3 == r2) goto Laf
            java.util.ArrayList r14 = r14.f11523a
            java.lang.Object r14 = r14.get(r3)
            h5.j r14 = (h5.j) r14
            goto L9c
        Laf:
            r9 = r10
        Lb0:
            if (r9 == 0) goto Lc9
            l4.pa r7 = r8.o0()
            r7.getClass()
            r7.w r14 = androidx.lifecycle.ViewModelKt.getViewModelScope(r7)
            y7.d r2 = y7.d.f14116a
            c5.m r6 = new c5.m
            r11 = 17
            r6.<init>(r7, r8, r9, r10, r11)
            r7.y.q(r14, r2, r10, r6, r4)
        Lc9:
            if (r12 != r5) goto Lcd
            r3 = r5
            goto Ld1
        Lcd:
            r0.set(r1)
        Ld0:
            r3 = r12
        Ld1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.ka.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
