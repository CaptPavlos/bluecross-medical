package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.e;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class CustomTabsServiceConnection implements ServiceConnection {

    @Nullable
    private Context mApplicationContext;

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public abstract void onCustomTabsServiceConnected(@NonNull ComponentName componentName, @NonNull CustomTabsClient customTabsClient);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
        if (this.mApplicationContext != null) {
            onCustomTabsServiceConnected(componentName, new CustomTabsClient(e.asInterface(iBinder), componentName, this.mApplicationContext) { // from class: androidx.browser.customtabs.CustomTabsServiceConnection.1
            });
        } else {
            androidx.window.layout.c.g("Custom Tabs Service connected before an applicationcontext has been provided.");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setApplicationContext(@NonNull Context context) {
        this.mApplicationContext = context;
    }
}
