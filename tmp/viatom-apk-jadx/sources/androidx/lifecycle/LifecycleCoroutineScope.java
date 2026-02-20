package androidx.lifecycle;

import g7.p;
import r7.a1;
import r7.w;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class LifecycleCoroutineScope implements w {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1", f = "Lifecycle.jvm.kt", l = {68}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 extends y6.i implements p {
        final /* synthetic */ p $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(p pVar, w6.c cVar) {
            super(2, cVar);
            this.$block = pVar;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return LifecycleCoroutineScope.this.new AnonymousClass1(this.$block, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((AnonymousClass1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 == 0) {
                s6.a.e(obj);
                Lifecycle lifecycle$lifecycle_common = LifecycleCoroutineScope.this.getLifecycle$lifecycle_common();
                p pVar = this.$block;
                this.label = 1;
                Object objWhenCreated = PausingDispatcherKt.whenCreated(lifecycle$lifecycle_common, pVar, this);
                x6.a aVar = x6.a.f13718a;
                if (objWhenCreated == aVar) {
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
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1", f = "Lifecycle.jvm.kt", l = {108}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01071 extends y6.i implements p {
        final /* synthetic */ p $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01071(p pVar, w6.c cVar) {
            super(2, cVar);
            this.$block = pVar;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return LifecycleCoroutineScope.this.new C01071(this.$block, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((C01071) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 == 0) {
                s6.a.e(obj);
                Lifecycle lifecycle$lifecycle_common = LifecycleCoroutineScope.this.getLifecycle$lifecycle_common();
                p pVar = this.$block;
                this.label = 1;
                Object objWhenResumed = PausingDispatcherKt.whenResumed(lifecycle$lifecycle_common, pVar, this);
                x6.a aVar = x6.a.f13718a;
                if (objWhenResumed == aVar) {
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
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1", f = "Lifecycle.jvm.kt", l = {88}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01081 extends y6.i implements p {
        final /* synthetic */ p $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01081(p pVar, w6.c cVar) {
            super(2, cVar);
            this.$block = pVar;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return LifecycleCoroutineScope.this.new C01081(this.$block, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((C01081) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 == 0) {
                s6.a.e(obj);
                Lifecycle lifecycle$lifecycle_common = LifecycleCoroutineScope.this.getLifecycle$lifecycle_common();
                p pVar = this.$block;
                this.label = 1;
                Object objWhenStarted = PausingDispatcherKt.whenStarted(lifecycle$lifecycle_common, pVar, this);
                x6.a aVar = x6.a.f13718a;
                if (objWhenStarted == aVar) {
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
    }

    @Override // r7.w
    public abstract /* synthetic */ w6.h getCoroutineContext();

    public abstract Lifecycle getLifecycle$lifecycle_common();

    public final a1 launchWhenCreated(p pVar) {
        pVar.getClass();
        return y.q(this, null, null, new AnonymousClass1(pVar, null), 3);
    }

    public final a1 launchWhenResumed(p pVar) {
        pVar.getClass();
        return y.q(this, null, null, new C01071(pVar, null), 3);
    }

    public final a1 launchWhenStarted(p pVar) {
        pVar.getClass();
        return y.q(this, null, null, new C01081(pVar, null), 3);
    }
}
