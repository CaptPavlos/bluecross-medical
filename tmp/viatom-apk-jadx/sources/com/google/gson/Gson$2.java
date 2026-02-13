package com.google.gson;

import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
class Gson$2 extends i {
    @Override // com.google.gson.i
    public final Object b(i3.a aVar) throws IOException {
        if (aVar.x() != 9) {
            return Float.valueOf((float) aVar.o());
        }
        aVar.t();
        return null;
    }

    @Override // com.google.gson.i
    public final void c(i3.b bVar, Object obj) throws IOException {
        Number numberValueOf = (Number) obj;
        if (numberValueOf == null) {
            bVar.k();
            return;
        }
        float fFloatValue = numberValueOf.floatValue();
        b.a(fFloatValue);
        if (!(numberValueOf instanceof Float)) {
            numberValueOf = Float.valueOf(fFloatValue);
        }
        bVar.r(numberValueOf);
    }
}
