package androidx.datastore.core;

import g7.p;
import g7.q;
import s6.w;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class StorageConnectionKt {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.core.StorageConnectionKt$writeData$2", f = "StorageConnection.kt", l = {77}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.core.StorageConnectionKt$writeData$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00992 extends i implements p {
        final /* synthetic */ T $value;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00992(T t, c cVar) {
            super(2, cVar);
            this.$value = t;
        }

        @Override // y6.a
        public final c create(Object obj, c cVar) {
            C00992 c00992 = new C00992(this.$value, cVar);
            c00992.L$0 = obj;
            return c00992;
        }

        @Override // g7.p
        public final Object invoke(WriteScope<T> writeScope, c cVar) {
            return ((C00992) create(writeScope, cVar)).invokeSuspend(w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 == 0) {
                s6.a.e(obj);
                WriteScope writeScope = (WriteScope) this.L$0;
                T t = this.$value;
                this.label = 1;
                Object objWriteData = writeScope.writeData(t, this);
                x6.a aVar = x6.a.f13718a;
                if (objWriteData == aVar) {
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

    public static final <T> Object readData(StorageConnection<T> storageConnection, c cVar) {
        return storageConnection.readScope(new AnonymousClass2(null), cVar);
    }

    public static final <T> Object writeData(StorageConnection<T> storageConnection, T t, c cVar) {
        Object objWriteScope = storageConnection.writeScope(new C00992(t, null), cVar);
        return objWriteScope == x6.a.f13718a ? objWriteScope : w.f12711a;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.core.StorageConnectionKt$readData$2", f = "StorageConnection.kt", l = {74}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.core.StorageConnectionKt$readData$2, reason: invalid class name */
    public static final class AnonymousClass2 extends i implements q {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(c cVar) {
            super(3, cVar);
        }

        @Override // g7.q
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((ReadScope) obj, ((Boolean) obj2).booleanValue(), (c) obj3);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    s6.a.e(obj);
                    return obj;
                }
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            ReadScope readScope = (ReadScope) this.L$0;
            this.label = 1;
            Object data = readScope.readData(this);
            x6.a aVar = x6.a.f13718a;
            return data == aVar ? aVar : data;
        }

        public final Object invoke(ReadScope<T> readScope, boolean z9, c cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar);
            anonymousClass2.L$0 = readScope;
            return anonymousClass2.invokeSuspend(w.f12711a);
        }
    }
}
