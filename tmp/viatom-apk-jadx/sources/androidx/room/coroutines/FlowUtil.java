package androidx.room.coroutines;

import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import g7.l;
import java.util.Arrays;
import s6.w;
import u7.h;
import u7.i;
import u7.i0;
import y6.c;
import y6.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FlowUtil {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <R> h createFlow(final RoomDatabase roomDatabase, final boolean z9, String[] strArr, final l lVar) {
        roomDatabase.getClass();
        strArr.getClass();
        lVar.getClass();
        final h hVarF = i0.f(roomDatabase.getInvalidationTracker().createFlow((String[]) Arrays.copyOf(strArr, strArr.length), true));
        return new h() { // from class: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1

            /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
            /* renamed from: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ l $block$inlined;
                final /* synthetic */ RoomDatabase $db$inlined;
                final /* synthetic */ boolean $inTransaction$inlined;
                final /* synthetic */ i $this_unsafeFlow;

                /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
                @e(c = "androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2", f = "FlowBuilder.kt", l = {224, 223}, m = "emit")
                /* renamed from: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends c {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(w6.c cVar) {
                        super(cVar);
                    }

                    @Override // y6.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar, RoomDatabase roomDatabase, boolean z9, l lVar) {
                    this.$this_unsafeFlow = iVar;
                    this.$db$inlined = roomDatabase;
                    this.$inTransaction$inlined = z9;
                    this.$block$inlined = lVar;
                }

                /* JADX WARN: Code restructure failed: missing block: B:21:0x005d, code lost:
                
                    if (r8.emit(r9, r0) == r4) goto L22;
                 */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // u7.i
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r8, w6.c r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r9
                        androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1 r0 = (androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1 r0 = new androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.result
                        int r1 = r0.label
                        r2 = 2
                        r3 = 1
                        x6.a r4 = x6.a.f13718a
                        if (r1 == 0) goto L39
                        if (r1 == r3) goto L31
                        if (r1 != r2) goto L2a
                        s6.a.e(r9)
                        goto L60
                    L2a:
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        androidx.window.layout.c.g(r8)
                        r8 = 0
                        return r8
                    L31:
                        java.lang.Object r8 = r0.L$0
                        u7.i r8 = (u7.i) r8
                        s6.a.e(r9)
                        goto L54
                    L39:
                        s6.a.e(r9)
                        u7.i r9 = r7.$this_unsafeFlow
                        java.util.Set r8 = (java.util.Set) r8
                        androidx.room.RoomDatabase r8 = r7.$db$inlined
                        boolean r1 = r7.$inTransaction$inlined
                        g7.l r5 = r7.$block$inlined
                        r0.L$0 = r9
                        r0.label = r3
                        java.lang.Object r8 = androidx.room.util.DBUtil.performSuspending(r8, r3, r1, r5, r0)
                        if (r8 != r4) goto L51
                        goto L5f
                    L51:
                        r6 = r9
                        r9 = r8
                        r8 = r6
                    L54:
                        r1 = 0
                        r0.L$0 = r1
                        r0.label = r2
                        java.lang.Object r8 = r8.emit(r9, r0)
                        if (r8 != r4) goto L60
                    L5f:
                        return r4
                    L60:
                        s6.w r8 = s6.w.f12711a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, w6.c):java.lang.Object");
                }
            }

            @Override // u7.h
            public Object collect(i iVar, w6.c cVar) {
                Object objCollect = hVarF.collect(new AnonymousClass2(iVar, roomDatabase, z9, lVar), cVar);
                return objCollect == x6.a.f13718a ? objCollect : w.f12711a;
            }
        };
    }
}
