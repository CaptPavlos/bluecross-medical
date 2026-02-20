package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class CustomTabsSessionToken {
    private static final String TAG = "CustomTabsSessionToken";

    @Nullable
    private final CustomTabsCallback mCallback;

    @Nullable
    final android.support.customtabs.c mCallbackBinder;

    @Nullable
    private final PendingIntent mSessionId;

    public CustomTabsSessionToken(@Nullable android.support.customtabs.c cVar, @Nullable PendingIntent pendingIntent) {
        if (cVar == null && pendingIntent == null) {
            androidx.window.layout.c.g("CustomTabsSessionToken must have either a session id or a callback (or both).");
            throw null;
        }
        this.mCallbackBinder = cVar;
        this.mSessionId = pendingIntent;
        this.mCallback = cVar == null ? null : new CustomTabsCallback() { // from class: androidx.browser.customtabs.CustomTabsSessionToken.1
            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void extraCallback(@NonNull String str, @Nullable Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.extraCallback(str, bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            @NonNull
            public Bundle extraCallbackWithResult(@NonNull String str, @Nullable Bundle bundle) {
                try {
                    return CustomTabsSessionToken.this.mCallbackBinder.extraCallbackWithResult(str, bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                    return null;
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onActivityLayout(int i10, int i11, int i12, int i13, int i14, @NonNull Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onActivityLayout(i10, i11, i12, i13, i14, bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onActivityResized(int i10, int i11, @NonNull Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onActivityResized(i10, i11, bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onMessageChannelReady(@Nullable Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onMessageChannelReady(bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onMinimized(@NonNull Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onMinimized(bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onNavigationEvent(int i10, @Nullable Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onNavigationEvent(i10, bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onPostMessage(@NonNull String str, @Nullable Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onPostMessage(str, bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onRelationshipValidationResult(int i10, @NonNull Uri uri, boolean z9, @Nullable Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onRelationshipValidationResult(i10, uri, z9, bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onUnminimized(@NonNull Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onUnminimized(bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onWarmupCompleted(@NonNull Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onWarmupCompleted(bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }
        };
    }

    @NonNull
    public static CustomTabsSessionToken createMockSessionTokenForTesting() {
        return new CustomTabsSessionToken(new MockCallback(), null);
    }

    private IBinder getCallbackBinderAssertNotNull() {
        android.support.customtabs.c cVar = this.mCallbackBinder;
        if (cVar != null) {
            return cVar.asBinder();
        }
        androidx.window.layout.c.g("CustomTabSessionToken must have valid binder or pending session");
        return null;
    }

    @Nullable
    public static CustomTabsSessionToken getSessionTokenFromIntent(@NonNull Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return null;
        }
        IBinder binder = extras.getBinder(CustomTabsIntent.EXTRA_SESSION);
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(CustomTabsIntent.EXTRA_SESSION_ID);
        if (binder == null && pendingIntent == null) {
            return null;
        }
        return new CustomTabsSessionToken(binder != null ? android.support.customtabs.b.asInterface(binder) : null, pendingIntent);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CustomTabsSessionToken)) {
            return false;
        }
        CustomTabsSessionToken customTabsSessionToken = (CustomTabsSessionToken) obj;
        PendingIntent id = customTabsSessionToken.getId();
        PendingIntent pendingIntent = this.mSessionId;
        if ((pendingIntent == null) != (id == null)) {
            return false;
        }
        return pendingIntent != null ? pendingIntent.equals(id) : getCallbackBinderAssertNotNull().equals(customTabsSessionToken.getCallbackBinderAssertNotNull());
    }

    @Nullable
    public CustomTabsCallback getCallback() {
        return this.mCallback;
    }

    @Nullable
    public IBinder getCallbackBinder() {
        android.support.customtabs.c cVar = this.mCallbackBinder;
        if (cVar == null) {
            return null;
        }
        return cVar.asBinder();
    }

    @Nullable
    public PendingIntent getId() {
        return this.mSessionId;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasCallback() {
        return this.mCallbackBinder != null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasId() {
        return this.mSessionId != null;
    }

    public int hashCode() {
        PendingIntent pendingIntent = this.mSessionId;
        return pendingIntent != null ? pendingIntent.hashCode() : getCallbackBinderAssertNotNull().hashCode();
    }

    public boolean isAssociatedWith(@NonNull CustomTabsSession customTabsSession) {
        return customTabsSession.getBinder().equals(this.mCallbackBinder);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class MockCallback extends android.support.customtabs.b {
        @Override // android.support.customtabs.c
        public Bundle extraCallbackWithResult(String str, Bundle bundle) {
            return null;
        }

        @Override // android.support.customtabs.b, android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.support.customtabs.c
        public void onMessageChannelReady(Bundle bundle) {
        }

        @Override // android.support.customtabs.c
        public void onMinimized(@NonNull Bundle bundle) {
        }

        @Override // android.support.customtabs.c
        public void onUnminimized(@NonNull Bundle bundle) {
        }

        @Override // android.support.customtabs.c
        public void onWarmupCompleted(Bundle bundle) {
        }

        @Override // android.support.customtabs.c
        public void extraCallback(String str, Bundle bundle) {
        }

        @Override // android.support.customtabs.c
        public void onNavigationEvent(int i10, Bundle bundle) {
        }

        @Override // android.support.customtabs.c
        public void onPostMessage(String str, Bundle bundle) {
        }

        @Override // android.support.customtabs.c
        public void onActivityResized(int i10, int i11, Bundle bundle) {
        }

        @Override // android.support.customtabs.c
        public void onRelationshipValidationResult(int i10, Uri uri, boolean z9, Bundle bundle) {
        }

        @Override // android.support.customtabs.c
        public void onActivityLayout(int i10, int i11, int i12, int i13, int i14, @NonNull Bundle bundle) {
        }
    }
}
