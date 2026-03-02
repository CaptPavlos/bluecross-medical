package androidx.core.app;

import android.content.res.Configuration;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MultiWindowModeChangedInfo {
    private final boolean isInMultiWindowMode;

    @RequiresApi(26)
    private Configuration newConfiguration;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RequiresApi(26)
    public MultiWindowModeChangedInfo(boolean z9, Configuration configuration) {
        this(z9);
        configuration.getClass();
        this.newConfiguration = configuration;
    }

    @RequiresApi(26)
    public final Configuration getNewConfig() {
        Configuration configuration = this.newConfiguration;
        if (configuration != null) {
            return configuration;
        }
        androidx.window.layout.c.g("MultiWindowModeChangedInfo must be constructed with the constructor that takes a Configuration to access the newConfig. Are you running on an API 26 or higher device that makes this information available?");
        return null;
    }

    public final boolean isInMultiWindowMode() {
        return this.isInMultiWindowMode;
    }

    public MultiWindowModeChangedInfo(boolean z9) {
        this.isInMultiWindowMode = z9;
    }
}
