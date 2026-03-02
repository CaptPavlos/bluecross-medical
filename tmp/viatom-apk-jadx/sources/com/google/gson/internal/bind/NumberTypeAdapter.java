package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class NumberTypeAdapter extends i {

    /* renamed from: b, reason: collision with root package name */
    public static final j f2497b = d(2);

    /* renamed from: a, reason: collision with root package name */
    public final int f2498a;

    public NumberTypeAdapter(int i10) {
        this.f2498a = i10;
    }

    public static j d(int i10) {
        return new j() { // from class: com.google.gson.internal.bind.NumberTypeAdapter.1
            @Override // com.google.gson.j
            public final i a(com.google.gson.b bVar, TypeToken typeToken) {
                if (typeToken.f2599a == Number.class) {
                    return NumberTypeAdapter.this;
                }
                return null;
            }
        };
    }

    @Override // com.google.gson.i
    public final Object b(i3.a aVar) throws IOException {
        int iX = aVar.x();
        int iC = c.i.c(iX);
        if (iC == 5 || iC == 6) {
            return androidx.constraintlayout.core.widgets.analyzer.a.f(this.f2498a, aVar);
        }
        if (iC == 8) {
            aVar.t();
            return null;
        }
        throw new com.google.gson.e("Expecting number, got: " + com.mbridge.msdk.dycreator.baseview.a.y(iX) + "; at path " + aVar.j(false));
    }

    @Override // com.google.gson.i
    public final void c(i3.b bVar, Object obj) throws IOException {
        bVar.r((Number) obj);
    }
}
