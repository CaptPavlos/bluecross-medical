package androidx.savedstate.serialization.serializers;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import c8.b;
import e8.e;
import f8.f;
import g8.c0;
import g8.d;
import g8.o0;
import g8.q0;
import g8.x0;
import java.util.ArrayList;
import java.util.List;
import s6.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SparseArraySerializer<T> implements b {
    private final e descriptor;
    private final b surrogateSerializer;

    public SparseArraySerializer(b bVar) {
        bVar.getClass();
        b bVarSerializer = SparseArraySurrogate.Companion.serializer(bVar);
        this.surrogateSerializer = bVarSerializer;
        this.descriptor = bVarSerializer.getDescriptor();
    }

    @Override // c8.a
    public SparseArray<T> deserialize(f8.e eVar) {
        eVar.getClass();
        SparseArraySurrogate sparseArraySurrogate = (SparseArraySurrogate) eVar.decodeSerializableValue(this.surrogateSerializer);
        if (sparseArraySurrogate.getKeys().size() != sparseArraySurrogate.getValues().size()) {
            com.google.gson.internal.a.n("Failed requirement.");
            return null;
        }
        SparseArray<T> sparseArray = new SparseArray<>(sparseArraySurrogate.getKeys().size());
        int size = sparseArraySurrogate.getKeys().size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseArray.append(sparseArraySurrogate.getKeys().get(i10).intValue(), sparseArraySurrogate.getValues().get(i10));
        }
        return sparseArray;
    }

    @Override // c8.g, c8.a
    public e getDescriptor() {
        return this.descriptor;
    }

    @Override // c8.g
    public void serialize(f fVar, SparseArray<T> sparseArray) {
        fVar.getClass();
        sparseArray.getClass();
        int size = sparseArray.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i10)));
        }
        int size2 = sparseArray.size();
        ArrayList arrayList2 = new ArrayList(size2);
        for (int i11 = 0; i11 < size2; i11++) {
            arrayList2.add(sparseArray.valueAt(i11));
        }
        fVar.encodeSerializableValue(this.surrogateSerializer, new SparseArraySurrogate(arrayList, arrayList2));
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @SuppressLint({"UnsafeOptInUsageError"})
    public static final class SparseArraySurrogate<T> {
        private static final e $cachedDescriptor;
        private final List<Integer> keys;
        private final List<T> values;
        public static final Companion Companion = new Companion(null);
        private static final s6.f[] $childSerializers = {s6.a.c(g.f12690a, new a()), null};

        static {
            q0 q0Var = new q0("androidx.savedstate.serialization.serializers.SparseArraySerializer.SparseArraySurrogate", null, 2);
            q0Var.j("keys", false);
            q0Var.j("values", false);
            $cachedDescriptor = q0Var;
        }

        public /* synthetic */ SparseArraySurrogate(int i10, List list, List list2, x0 x0Var) {
            if (3 != (i10 & 3)) {
                o0.e($cachedDescriptor, i10, 3);
                throw null;
            }
            this.keys = list;
            this.values = list2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ b _childSerializers$_anonymous_() {
            return new d(c0.f8244a);
        }

        public static final /* synthetic */ void write$Self$savedstate_release(SparseArraySurrogate sparseArraySurrogate, f8.d dVar, e eVar, b bVar) {
            dVar.encodeSerializableElement(eVar, 0, (c8.g) $childSerializers[0].getValue(), sparseArraySurrogate.keys);
            dVar.encodeSerializableElement(eVar, 1, new d(bVar), sparseArraySurrogate.values);
        }

        public final List<Integer> getKeys() {
            return this.keys;
        }

        public final List<T> getValues() {
            return this.values;
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class Companion {
            private Companion() {
            }

            public final <T> b serializer(b bVar) {
                bVar.getClass();
                return new SparseArraySerializer$SparseArraySurrogate$$serializer(bVar);
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SparseArraySurrogate(List<Integer> list, List<? extends T> list2) {
            list.getClass();
            list2.getClass();
            this.keys = list;
            this.values = list2;
        }
    }
}
