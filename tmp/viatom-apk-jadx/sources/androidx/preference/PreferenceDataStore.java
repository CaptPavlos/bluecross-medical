package androidx.preference;

import androidx.annotation.Nullable;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class PreferenceDataStore {
    public void putBoolean(String str, boolean z9) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putFloat(String str, float f) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putInt(String str, int i10) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putLong(String str, long j10) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putString(String str, @Nullable String str2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putStringSet(String str, @Nullable Set<String> set) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public boolean getBoolean(String str, boolean z9) {
        return z9;
    }

    public float getFloat(String str, float f) {
        return f;
    }

    public int getInt(String str, int i10) {
        return i10;
    }

    public long getLong(String str, long j10) {
        return j10;
    }

    @Nullable
    public String getString(String str, @Nullable String str2) {
        return str2;
    }

    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return set;
    }
}
