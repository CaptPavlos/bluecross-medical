package androidx.room;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Set;
import u7.c0;
import u7.i0;
import u7.m0;
import y6.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ObservedTableVersions {
    private final c0 versions;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.ObservedTableVersions", f = "InvalidationTracker.kt", l = {TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE}, m = "collect")
    /* renamed from: androidx.room.ObservedTableVersions$collect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends y6.c {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(w6.c cVar) {
            super(cVar);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ObservedTableVersions.this.collect(null, this);
        }
    }

    public ObservedTableVersions(int i10) {
        this.versions = i0.a(new int[i10]);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(u7.i r5, w6.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.room.ObservedTableVersions.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.room.ObservedTableVersions$collect$1 r0 = (androidx.room.ObservedTableVersions.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.ObservedTableVersions$collect$1 r0 = new androidx.room.ObservedTableVersions$collect$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L2d
            if (r1 == r2) goto L28
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r5)
            r5 = 0
            return r5
        L28:
            com.google.android.gms.internal.measurement.u6 r5 = androidx.constraintlayout.core.widgets.analyzer.a.q(r6)
            throw r5
        L2d:
            s6.a.e(r6)
            u7.c0 r6 = r4.versions
            r0.label = r2
            u7.m0 r6 = (u7.m0) r6
            r6.collect(r5, r0)
            x6.a r5 = x6.a.f13718a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.ObservedTableVersions.collect(u7.i, w6.c):java.lang.Object");
    }

    public final void increment(Set<Integer> set) {
        m0 m0Var;
        Object value;
        int[] iArr;
        set.getClass();
        if (set.isEmpty()) {
            return;
        }
        c0 c0Var = this.versions;
        do {
            m0Var = (m0) c0Var;
            value = m0Var.getValue();
            int[] iArr2 = (int[]) value;
            int length = iArr2.length;
            iArr = new int[length];
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = set.contains(Integer.valueOf(i10)) ? iArr2[i10] + 1 : iArr2[i10];
            }
            e2.a aVar = v7.c.f13178b;
            if (value == null) {
                value = aVar;
            }
        } while (!m0Var.g(value, iArr));
    }
}
