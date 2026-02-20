package j$.util;

import java.util.Set;

/* loaded from: classes2.dex */
public class w extends n implements Set {
    private static final long serialVersionUID = -9215047833775013803L;

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return obj == this || this.f9475a.equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f9475a.hashCode();
    }
}
