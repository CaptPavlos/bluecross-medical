package com.google.gson;

import com.google.gson.internal.o;
import java.io.IOException;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class d {
    public final String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            i3.b bVar = new i3.b(new o(sb));
            bVar.h = 1;
            com.google.gson.internal.bind.e.f2553z.c(bVar, this);
            return sb.toString();
        } catch (IOException e) {
            u.h(e);
            return null;
        }
    }
}
