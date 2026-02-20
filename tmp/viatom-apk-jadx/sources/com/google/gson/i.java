package com.google.gson;

import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class i {
    public final i a() {
        return !(this instanceof TypeAdapter$NullSafeTypeAdapter) ? new i() { // from class: com.google.gson.TypeAdapter$NullSafeTypeAdapter
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                if (aVar.x() != 9) {
                    return this.f2447a.b(aVar);
                }
                aVar.t();
                return null;
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                if (obj == null) {
                    bVar.k();
                } else {
                    this.f2447a.c(bVar, obj);
                }
            }

            public final String toString() {
                return "NullSafeTypeAdapter[" + this.f2447a + "]";
            }
        } : this;
    }

    public abstract Object b(i3.a aVar);

    public abstract void c(i3.b bVar, Object obj);
}
