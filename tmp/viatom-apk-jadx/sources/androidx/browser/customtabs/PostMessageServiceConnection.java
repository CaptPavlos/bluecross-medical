package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.k;
import android.support.customtabs.l;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class PostMessageServiceConnection implements PostMessageBackend, ServiceConnection {
    private static final String TAG = "PostMessageServConn";
    private final Object mLock = new Object();
    private boolean mMessageChannelCreated;

    @Nullable
    private String mPackageName;

    @Nullable
    private l mService;
    private final android.support.customtabs.c mSessionBinder;

    public PostMessageServiceConnection(@NonNull CustomTabsSessionToken customTabsSessionToken) {
        IBinder callbackBinder = customTabsSessionToken.getCallbackBinder();
        if (callbackBinder != null) {
            this.mSessionBinder = android.support.customtabs.b.asInterface(callbackBinder);
        } else {
            com.google.gson.internal.a.n("Provided session must have binder.");
            throw null;
        }
    }

    private boolean isBoundToService() {
        return this.mService != null;
    }

    private boolean notifyMessageChannelReadyInternal(@Nullable Bundle bundle) {
        if (this.mService == null) {
            return false;
        }
        synchronized (this.mLock) {
            try {
                try {
                    this.mService.onMessageChannelReady(this.mSessionBinder, bundle);
                } catch (RemoteException unused) {
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    public boolean bindSessionToPostMessageService(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent();
        intent.setClassName(str, PostMessageService.class.getName());
        boolean zBindService = context.bindService(intent, this, 1);
        if (!zBindService) {
            Log.w(TAG, "Could not bind to PostMessageService in client.");
        }
        return zBindService;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void cleanup(@NonNull Context context) {
        if (isBoundToService()) {
            unbindFromContext(context);
        }
    }

    public final boolean notifyMessageChannelReady(@Nullable Bundle bundle) {
        this.mMessageChannelCreated = true;
        return notifyMessageChannelReadyInternal(bundle);
    }

    @Override // androidx.browser.customtabs.PostMessageBackend
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onDisconnectChannel(@NonNull Context context) {
        unbindFromContext(context);
    }

    @Override // androidx.browser.customtabs.PostMessageBackend
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final boolean onNotifyMessageChannelReady(@Nullable Bundle bundle) {
        return notifyMessageChannelReady(bundle);
    }

    @Override // androidx.browser.customtabs.PostMessageBackend
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final boolean onPostMessage(@NonNull String str, @Nullable Bundle bundle) {
        return postMessage(str, bundle);
    }

    public void onPostMessageServiceConnected() {
        if (this.mMessageChannelCreated) {
            notifyMessageChannelReadyInternal(null);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
        this.mService = k.asInterface(iBinder);
        onPostMessageServiceConnected();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(@NonNull ComponentName componentName) {
        this.mService = null;
        onPostMessageServiceDisconnected();
    }

    public final boolean postMessage(@NonNull String str, @Nullable Bundle bundle) {
        if (this.mService == null) {
            return false;
        }
        synchronized (this.mLock) {
            try {
                try {
                    this.mService.onPostMessage(this.mSessionBinder, str, bundle);
                } catch (RemoteException unused) {
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setPackageName(@NonNull String str) {
        this.mPackageName = str;
    }

    public void unbindFromContext(@NonNull Context context) {
        if (isBoundToService()) {
            context.unbindService(this);
            this.mService = null;
        }
    }

    public void onPostMessageServiceDisconnected() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean bindSessionToPostMessageService(@NonNull Context context) {
        String str = this.mPackageName;
        if (str != null) {
            return bindSessionToPostMessageService(context, str);
        }
        androidx.window.layout.c.g("setPackageName must be called before bindSessionToPostMessageService.");
        return false;
    }
}
