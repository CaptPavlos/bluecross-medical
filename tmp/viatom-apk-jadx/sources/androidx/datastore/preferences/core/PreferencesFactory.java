package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PreferencesFactory {
    public static final Preferences create(Preferences.Pair<?>... pairArr) {
        pairArr.getClass();
        return createMutable((Preferences.Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    public static final Preferences createEmpty() {
        return new MutablePreferences(null, true, 1, null);
    }

    public static final MutablePreferences createMutable(Preferences.Pair<?>... pairArr) {
        pairArr.getClass();
        MutablePreferences mutablePreferences = new MutablePreferences(null, false, 1, null);
        mutablePreferences.putAll((Preferences.Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        return mutablePreferences;
    }
}
