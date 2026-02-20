package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Entity
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class Preference {

    @PrimaryKey
    @ColumnInfo(name = "key")
    private final String key;

    @ColumnInfo(name = "long_value")
    private final Long value;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Preference(String str, boolean z9) {
        this(str, Long.valueOf(z9 ? 1L : 0L));
        str.getClass();
    }

    public static /* synthetic */ Preference copy$default(Preference preference, String str, Long l10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = preference.key;
        }
        if ((i10 & 2) != 0) {
            l10 = preference.value;
        }
        return preference.copy(str, l10);
    }

    public final String component1() {
        return this.key;
    }

    public final Long component2() {
        return this.value;
    }

    public final Preference copy(String str, Long l10) {
        str.getClass();
        return new Preference(str, l10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) obj;
        return l.a(this.key, preference.key) && l.a(this.value, preference.value);
    }

    public final String getKey() {
        return this.key;
    }

    public final Long getValue() {
        return this.value;
    }

    public int hashCode() {
        int iHashCode = this.key.hashCode() * 31;
        Long l10 = this.value;
        return iHashCode + (l10 == null ? 0 : l10.hashCode());
    }

    public String toString() {
        return "Preference(key=" + this.key + ", value=" + this.value + ')';
    }

    public Preference(String str, Long l10) {
        str.getClass();
        this.key = str;
        this.value = l10;
    }
}
