package androidx.core.util;

import android.util.LruCache;
import g7.l;
import g7.p;
import g7.r;
import kotlin.jvm.internal.m;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class LruCacheKt {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.core.util.LruCacheKt$lruCache$1, reason: invalid class name */
    public static final class AnonymousClass1 extends m implements p {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // g7.p
        public final Integer invoke(Object obj, Object obj2) {
            return 1;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.core.util.LruCacheKt$lruCache$2, reason: invalid class name */
    public static final class AnonymousClass2 extends m implements l {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // g7.l
        public final Object invoke(Object obj) {
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.core.util.LruCacheKt$lruCache$4, reason: invalid class name */
    public static final class AnonymousClass4<K, V> extends LruCache<K, V> {
        final /* synthetic */ l $create;
        final /* synthetic */ r $onEntryRemoved;
        final /* synthetic */ p $sizeOf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(int i10, p pVar, l lVar, r rVar) {
            super(i10);
            this.$sizeOf = pVar;
            this.$create = lVar;
            this.$onEntryRemoved = rVar;
        }

        @Override // android.util.LruCache
        public V create(K k10) {
            return (V) this.$create.invoke(k10);
        }

        @Override // android.util.LruCache
        public void entryRemoved(boolean z9, K k10, V v6, V v9) {
            this.$onEntryRemoved.invoke(Boolean.valueOf(z9), k10, v6, v9);
        }

        @Override // android.util.LruCache
        public int sizeOf(K k10, V v6) {
            return ((Number) this.$sizeOf.invoke(k10, v6)).intValue();
        }
    }

    public static final <K, V> LruCache<K, V> lruCache(int i10, p pVar, l lVar, r rVar) {
        return new AnonymousClass4(i10, pVar, lVar, rVar);
    }

    public static /* synthetic */ LruCache lruCache$default(int i10, p pVar, l lVar, r rVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            pVar = AnonymousClass1.INSTANCE;
        }
        if ((i11 & 4) != 0) {
            lVar = AnonymousClass2.INSTANCE;
        }
        if ((i11 & 8) != 0) {
            rVar = AnonymousClass3.INSTANCE;
        }
        return new AnonymousClass4(i10, pVar, lVar, rVar);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.core.util.LruCacheKt$lruCache$3, reason: invalid class name */
    public static final class AnonymousClass3 extends m implements r {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(4);
        }

        @Override // g7.r
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke(((Boolean) obj).booleanValue(), obj2, obj3, obj4);
            return w.f12711a;
        }

        public final void invoke(boolean z9, Object obj, Object obj2, Object obj3) {
        }
    }
}
