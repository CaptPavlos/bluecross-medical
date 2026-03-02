package androidx.datastore.core;

import g7.p;
import g7.q;
import s6.w;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.datastore.core.DataStoreImpl$data$1", f = "DataStoreImpl.kt", l = {72, 74, 100}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DataStoreImpl$data$1 extends i implements p {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.core.DataStoreImpl$data$1$1", f = "DataStoreImpl.kt", l = {102}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.core.DataStoreImpl$data$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DataStoreImpl<T> dataStoreImpl, c cVar) {
            super(2, cVar);
            this.this$0 = dataStoreImpl;
        }

        @Override // y6.a
        public final c create(Object obj, c cVar) {
            return new AnonymousClass1(this.this$0, cVar);
        }

        @Override // g7.p
        public final Object invoke(u7.i iVar, c cVar) {
            return ((AnonymousClass1) create(iVar, cVar)).invokeSuspend(w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 == 0) {
                s6.a.e(obj);
                DataStoreImpl<T> dataStoreImpl = this.this$0;
                this.label = 1;
                Object objIncrementCollector = dataStoreImpl.incrementCollector(this);
                x6.a aVar = x6.a.f13718a;
                if (objIncrementCollector == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
            }
            return w.f12711a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.core.DataStoreImpl$data$1$2", f = "DataStoreImpl.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.core.DataStoreImpl$data$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends i implements p {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(c cVar) {
            super(2, cVar);
        }

        @Override // y6.a
        public final c create(Object obj, c cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // g7.p
        public final Object invoke(State<T> state, c cVar) {
            return ((AnonymousClass2) create(state, cVar)).invokeSuspend(w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label == 0) {
                s6.a.e(obj);
                return Boolean.valueOf(!(((State) this.L$0) instanceof Final));
            }
            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.core.DataStoreImpl$data$1$3", f = "DataStoreImpl.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.core.DataStoreImpl$data$1$3, reason: invalid class name */
    public static final class AnonymousClass3 extends i implements p {
        final /* synthetic */ State<T> $startState;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(State<T> state, c cVar) {
            super(2, cVar);
            this.$startState = state;
        }

        @Override // y6.a
        public final c create(Object obj, c cVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$startState, cVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // g7.p
        public final Object invoke(State<T> state, c cVar) {
            return ((AnonymousClass3) create(state, cVar)).invokeSuspend(w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            State state = (State) this.L$0;
            return Boolean.valueOf((state instanceof Data) && state.getVersion() <= this.$startState.getVersion());
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.core.DataStoreImpl$data$1$5", f = "DataStoreImpl.kt", l = {androidx.constraintlayout.widget.R.styleable.ConstraintSet_pathMotionArc}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.core.DataStoreImpl$data$1$5, reason: invalid class name */
    public static final class AnonymousClass5 extends i implements q {
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(DataStoreImpl<T> dataStoreImpl, c cVar) {
            super(3, cVar);
            this.this$0 = dataStoreImpl;
        }

        @Override // g7.q
        public final Object invoke(u7.i iVar, Throwable th, c cVar) {
            return new AnonymousClass5(this.this$0, cVar).invokeSuspend(w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 == 0) {
                s6.a.e(obj);
                DataStoreImpl<T> dataStoreImpl = this.this$0;
                this.label = 1;
                Object objDecrementCollector = dataStoreImpl.decrementCollector(this);
                x6.a aVar = x6.a.f13718a;
                if (objDecrementCollector == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
            }
            return w.f12711a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$data$1(DataStoreImpl<T> dataStoreImpl, c cVar) {
        super(2, cVar);
        this.this$0 = dataStoreImpl;
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        DataStoreImpl$data$1 dataStoreImpl$data$1 = new DataStoreImpl$data$1(this.this$0, cVar);
        dataStoreImpl$data$1.L$0 = obj;
        return dataStoreImpl$data$1;
    }

    @Override // g7.p
    public final Object invoke(u7.i iVar, c cVar) {
        return ((DataStoreImpl$data$1) create(iVar, cVar)).invokeSuspend(w.f12711a);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c9  */
    /* JADX WARN: Type inference failed for: r2v11, types: [androidx.datastore.core.DataStoreImpl$data$1$invokeSuspend$$inlined$map$1] */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$data$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
