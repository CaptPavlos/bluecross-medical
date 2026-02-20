package com.inmobi.cmp.core.model;

import androidx.annotation.Keep;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Keep
/* loaded from: classes3.dex */
public final class ACData {
    private final String acString;

    public /* synthetic */ ACData(String str, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : str);
    }

    public static /* synthetic */ ACData copy$default(ACData aCData, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = aCData.acString;
        }
        return aCData.copy(str);
    }

    public final String component1() {
        return this.acString;
    }

    public final ACData copy(String str) {
        return new ACData(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ACData) && l.a(this.acString, ((ACData) obj).acString);
    }

    public final String getAcString() {
        return this.acString;
    }

    public int hashCode() {
        String str = this.acString;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "ACData(acString=" + ((Object) this.acString) + ')';
    }

    public ACData(String str) {
        this.acString = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ACData() {
        this(null, 1, 0 == true ? 1 : 0);
    }
}
