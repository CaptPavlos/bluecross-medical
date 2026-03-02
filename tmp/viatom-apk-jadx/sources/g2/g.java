package g2;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import java.io.Serializable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class g {
    public static final Object a(MutablePreferences mutablePreferences, Preferences.Key key, Serializable serializable) {
        mutablePreferences.getClass();
        key.getClass();
        Object obj = mutablePreferences.get(key);
        return obj == null ? serializable : obj;
    }
}
