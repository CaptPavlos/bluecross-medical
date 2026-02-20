package androidx.savedstate.serialization.serializers;

import c8.b;
import com.google.android.gms.internal.measurement.a4;
import e8.d;
import e8.e;
import e8.j;
import f8.f;
import o7.m;
import u7.c0;
import u7.i0;
import u7.m0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MutableStateFlowSerializer<T> implements b {
    private final e descriptor;
    private final b valueSerializer;

    public MutableStateFlowSerializer(b bVar) {
        e jVar;
        bVar.getClass();
        this.valueSerializer = bVar;
        a4 kind = bVar.getDescriptor().getKind();
        if (kind instanceof d) {
            jVar = a.a.a("kotlinx.coroutines.flow.MutableStateFlow", (d) kind);
        } else {
            e descriptor = bVar.getDescriptor();
            descriptor.getClass();
            if (m.l0("kotlinx.coroutines.flow.MutableStateFlow")) {
                com.google.gson.internal.a.n("Blank serial names are prohibited");
                throw null;
            }
            if (descriptor.getKind() instanceof d) {
                com.google.gson.internal.a.n("For primitive descriptors please use 'PrimitiveSerialDescriptor' instead");
                throw null;
            }
            if ("kotlinx.coroutines.flow.MutableStateFlow".equals(descriptor.a())) {
                throw new IllegalArgumentException(("The name of the wrapped descriptor (kotlinx.coroutines.flow.MutableStateFlow) cannot be the same as the name of the original descriptor (" + descriptor.a() + ')').toString());
            }
            jVar = new j(descriptor);
        }
        this.descriptor = jVar;
    }

    @Override // c8.a
    public c0 deserialize(f8.e eVar) {
        eVar.getClass();
        return i0.a(eVar.decodeSerializableValue(this.valueSerializer));
    }

    @Override // c8.g, c8.a
    public e getDescriptor() {
        return this.descriptor;
    }

    @Override // c8.g
    public void serialize(f fVar, c0 c0Var) {
        fVar.getClass();
        c0Var.getClass();
        fVar.encodeSerializableValue(this.valueSerializer, ((m0) c0Var).getValue());
    }

    public static /* synthetic */ void getDescriptor$annotations() {
    }
}
