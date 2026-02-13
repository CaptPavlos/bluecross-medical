package p;

import android.util.Base64;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class n {
    public final i a(m.d dVar) {
        i iVar = (i) this;
        String str = iVar.f11855a;
        if (str == null) {
            androidx.window.layout.c.k("Null backendName");
            return null;
        }
        if (dVar != null) {
            return new i(str, iVar.f11856b, dVar);
        }
        androidx.window.layout.c.k("Null priority");
        return null;
    }

    public final String toString() {
        i iVar = (i) this;
        byte[] bArr = iVar.f11856b;
        String strEncodeToString = bArr == null ? "" : Base64.encodeToString(bArr, 2);
        StringBuilder sb = new StringBuilder("TransportContext(");
        sb.append(iVar.f11855a);
        sb.append(", ");
        sb.append(iVar.f11857c);
        sb.append(", ");
        return a3.a.o(sb, strEncodeToString, ")");
    }
}
