package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.ProcessUtils;
import g7.p;
import g7.r;
import l4.kb;
import r7.w;
import r7.y;
import u7.i0;
import u7.o;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class UnfinishedWorkListenerKt {
    private static final int DELAY_MS = 30000;
    private static final long MAX_DELAY_MS;
    private static final String TAG;

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("UnfinishedWorkListener");
        strTagWithPrefix.getClass();
        TAG = strTagWithPrefix;
        MAX_DELAY_MS = 3600000L;
    }

    public static final void maybeLaunchUnfinishedWorkListener(w wVar, Context context, Configuration configuration, WorkDatabase workDatabase) {
        wVar.getClass();
        context.getClass();
        configuration.getClass();
        workDatabase.getClass();
        if (ProcessUtils.isDefaultProcess(context, configuration)) {
            y.q(wVar, null, null, new kb(new o(i0.g(i0.f(new o(workDatabase.workSpecDao().hasUnfinishedWorkFlow(), new AnonymousClass1(null), 2))), new AnonymousClass2(context, null)), (w6.c) null, 11), 3);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.work.impl.UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2", f = "UnfinishedWorkListener.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.work.impl.UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2, reason: invalid class name */
    public static final class AnonymousClass2 extends y6.i implements p {
        final /* synthetic */ Context $appContext;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, w6.c cVar) {
            super(2, cVar);
            this.$appContext = context;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$appContext, cVar);
            anonymousClass2.Z$0 = ((Boolean) obj).booleanValue();
            return anonymousClass2;
        }

        public final Object invoke(boolean z9, w6.c cVar) {
            return ((AnonymousClass2) create(Boolean.valueOf(z9), cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            PackageManagerHelper.setComponentEnabled(this.$appContext, RescheduleReceiver.class, this.Z$0);
            return s6.w.f12711a;
        }

        @Override // g7.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (w6.c) obj2);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.work.impl.UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1", f = "UnfinishedWorkListener.kt", l = {59}, m = "invokeSuspend")
    /* renamed from: androidx.work.impl.UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1, reason: invalid class name */
    public static final class AnonymousClass1 extends y6.i implements r {
        /* synthetic */ long J$0;
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(w6.c cVar) {
            super(4, cVar);
        }

        @Override // g7.r
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return invoke((u7.i) obj, (Throwable) obj2, ((Number) obj3).longValue(), (w6.c) obj4);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 == 0) {
                s6.a.e(obj);
                Throwable th = (Throwable) this.L$0;
                long j10 = this.J$0;
                Logger.get().error(UnfinishedWorkListenerKt.TAG, "Cannot check for unfinished work", th);
                long jMin = Math.min(j10 * UnfinishedWorkListenerKt.DELAY_MS, UnfinishedWorkListenerKt.MAX_DELAY_MS);
                this.label = 1;
                Object objH = y.h(jMin, this);
                x6.a aVar = x6.a.f13718a;
                if (objH == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
            }
            return Boolean.TRUE;
        }

        public final Object invoke(u7.i iVar, Throwable th, long j10, w6.c cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(cVar);
            anonymousClass1.L$0 = th;
            anonymousClass1.J$0 = j10;
            return anonymousClass1.invokeSuspend(s6.w.f12711a);
        }
    }
}
