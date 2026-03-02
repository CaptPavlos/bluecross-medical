package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.e;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class CustomTabsService extends Service {
    public static final String ACTION_CUSTOM_TABS_CONNECTION = "android.support.customtabs.action.CustomTabsService";
    public static final String CATEGORY_COLOR_SCHEME_CUSTOMIZATION = "androidx.browser.customtabs.category.ColorSchemeCustomization";
    public static final String CATEGORY_NAVBAR_COLOR_CUSTOMIZATION = "androidx.browser.customtabs.category.NavBarColorCustomization";
    public static final String CATEGORY_TRUSTED_WEB_ACTIVITY_IMMERSIVE_MODE = "androidx.browser.trusted.category.ImmersiveMode";
    public static final String CATEGORY_WEB_SHARE_TARGET_V2 = "androidx.browser.trusted.category.WebShareTargetV2";
    public static final int FILE_PURPOSE_TRUSTED_WEB_ACTIVITY_SPLASH_IMAGE = 1;
    public static final String KEY_SUCCESS = "androidx.browser.customtabs.SUCCESS";
    public static final String KEY_URL = "android.support.customtabs.otherurls.URL";
    public static final int RELATION_HANDLE_ALL_URLS = 2;
    public static final int RELATION_USE_AS_ORIGIN = 1;
    public static final int RESULT_FAILURE_DISALLOWED = -1;
    public static final int RESULT_FAILURE_MESSAGING_ERROR = -3;
    public static final int RESULT_FAILURE_REMOTE_ERROR = -2;
    public static final int RESULT_SUCCESS = 0;
    private static final String TAG = "CustomTabsService";
    public static final String TRUSTED_WEB_ACTIVITY_CATEGORY = "androidx.browser.trusted.category.TrustedWebActivities";
    final SimpleArrayMap<IBinder, IBinder.DeathRecipient> mDeathRecipientMap = new SimpleArrayMap<>();
    private e mBinder = new AnonymousClass1();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.browser.customtabs.CustomTabsService$1, reason: invalid class name */
    public class AnonymousClass1 extends e {
        public AnonymousClass1() {
        }

        @Nullable
        private PendingIntent getSessionIdFromBundle(@Nullable Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(CustomTabsIntent.EXTRA_SESSION_ID);
            bundle.remove(CustomTabsIntent.EXTRA_SESSION_ID);
            return pendingIntent;
        }

        @Nullable
        private Uri getTargetOriginFromBundle(@Nullable Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            return Build.VERSION.SDK_INT >= 33 ? (Uri) Api33Impl.getParcelable(bundle, "target_origin", Uri.class) : (Uri) bundle.getParcelable("target_origin");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$newSessionInternal$0(CustomTabsSessionToken customTabsSessionToken) {
            CustomTabsService.this.cleanUpSession(customTabsSessionToken);
        }

        private boolean newSessionInternal(@NonNull android.support.customtabs.c cVar, @Nullable PendingIntent pendingIntent) {
            final CustomTabsSessionToken customTabsSessionToken = new CustomTabsSessionToken(cVar, pendingIntent);
            try {
                IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: androidx.browser.customtabs.a
                    @Override // android.os.IBinder.DeathRecipient
                    public final void binderDied() {
                        this.f444a.lambda$newSessionInternal$0(customTabsSessionToken);
                    }
                };
                synchronized (CustomTabsService.this.mDeathRecipientMap) {
                    cVar.asBinder().linkToDeath(deathRecipient, 0);
                    CustomTabsService.this.mDeathRecipientMap.put(cVar.asBinder(), deathRecipient);
                }
                return CustomTabsService.this.newSession(customTabsSessionToken);
            } catch (RemoteException unused) {
                return false;
            }
        }

        @Override // android.support.customtabs.f
        public Bundle extraCommand(@NonNull String str, @Nullable Bundle bundle) {
            return CustomTabsService.this.extraCommand(str, bundle);
        }

        @Override // android.support.customtabs.f
        public boolean isEngagementSignalsApiAvailable(android.support.customtabs.c cVar, @NonNull Bundle bundle) {
            return CustomTabsService.this.isEngagementSignalsApiAvailable(new CustomTabsSessionToken(cVar, getSessionIdFromBundle(bundle)), bundle);
        }

        @Override // android.support.customtabs.f
        public boolean mayLaunchUrl(@Nullable android.support.customtabs.c cVar, @Nullable Uri uri, @Nullable Bundle bundle, @Nullable List<Bundle> list) {
            return CustomTabsService.this.mayLaunchUrl(new CustomTabsSessionToken(cVar, getSessionIdFromBundle(bundle)), uri, bundle, list);
        }

        @Override // android.support.customtabs.f
        public boolean newSession(@NonNull android.support.customtabs.c cVar) {
            return newSessionInternal(cVar, null);
        }

        @Override // android.support.customtabs.f
        public boolean newSessionWithExtras(@NonNull android.support.customtabs.c cVar, @Nullable Bundle bundle) {
            return newSessionInternal(cVar, getSessionIdFromBundle(bundle));
        }

        @Override // android.support.customtabs.f
        public int postMessage(@NonNull android.support.customtabs.c cVar, @NonNull String str, @Nullable Bundle bundle) {
            return CustomTabsService.this.postMessage(new CustomTabsSessionToken(cVar, getSessionIdFromBundle(bundle)), str, bundle);
        }

        @Override // android.support.customtabs.f
        public boolean receiveFile(@NonNull android.support.customtabs.c cVar, @NonNull Uri uri, int i10, @Nullable Bundle bundle) {
            return CustomTabsService.this.receiveFile(new CustomTabsSessionToken(cVar, getSessionIdFromBundle(bundle)), uri, i10, bundle);
        }

        @Override // android.support.customtabs.f
        public boolean requestPostMessageChannel(@NonNull android.support.customtabs.c cVar, @NonNull Uri uri) {
            return CustomTabsService.this.requestPostMessageChannel(new CustomTabsSessionToken(cVar, null), uri, null, new Bundle());
        }

        @Override // android.support.customtabs.f
        public boolean requestPostMessageChannelWithExtras(@NonNull android.support.customtabs.c cVar, @NonNull Uri uri, @NonNull Bundle bundle) {
            return CustomTabsService.this.requestPostMessageChannel(new CustomTabsSessionToken(cVar, getSessionIdFromBundle(bundle)), uri, getTargetOriginFromBundle(bundle), bundle);
        }

        @Override // android.support.customtabs.f
        public boolean setEngagementSignalsCallback(@NonNull android.support.customtabs.c cVar, @NonNull IBinder iBinder, @NonNull Bundle bundle) {
            return CustomTabsService.this.setEngagementSignalsCallback(new CustomTabsSessionToken(cVar, getSessionIdFromBundle(bundle)), EngagementSignalsCallbackRemote.fromBinder(iBinder), bundle);
        }

        @Override // android.support.customtabs.f
        public boolean updateVisuals(@NonNull android.support.customtabs.c cVar, @Nullable Bundle bundle) {
            return CustomTabsService.this.updateVisuals(new CustomTabsSessionToken(cVar, getSessionIdFromBundle(bundle)), bundle);
        }

        @Override // android.support.customtabs.f
        public boolean validateRelationship(@NonNull android.support.customtabs.c cVar, int i10, @NonNull Uri uri, @Nullable Bundle bundle) {
            return CustomTabsService.this.validateRelationship(new CustomTabsSessionToken(cVar, getSessionIdFromBundle(bundle)), i10, uri, bundle);
        }

        @Override // android.support.customtabs.f
        public boolean warmup(long j10) {
            return CustomTabsService.this.warmup(j10);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface FilePurpose {
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Relation {
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Result {
    }

    public boolean cleanUpSession(@NonNull CustomTabsSessionToken customTabsSessionToken) {
        try {
            synchronized (this.mDeathRecipientMap) {
                try {
                    IBinder callbackBinder = customTabsSessionToken.getCallbackBinder();
                    if (callbackBinder == null) {
                        return false;
                    }
                    callbackBinder.unlinkToDeath(this.mDeathRecipientMap.get(callbackBinder), 0);
                    this.mDeathRecipientMap.remove(callbackBinder);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (NoSuchElementException unused) {
            return false;
        }
    }

    @Nullable
    public abstract Bundle extraCommand(@NonNull String str, @Nullable Bundle bundle);

    public boolean isEngagementSignalsApiAvailable(@NonNull CustomTabsSessionToken customTabsSessionToken, @NonNull Bundle bundle) {
        return false;
    }

    public abstract boolean mayLaunchUrl(@NonNull CustomTabsSessionToken customTabsSessionToken, @Nullable Uri uri, @Nullable Bundle bundle, @Nullable List<Bundle> list);

    public abstract boolean newSession(@NonNull CustomTabsSessionToken customTabsSessionToken);

    @Override // android.app.Service
    @NonNull
    public IBinder onBind(@Nullable Intent intent) {
        return this.mBinder;
    }

    public abstract int postMessage(@NonNull CustomTabsSessionToken customTabsSessionToken, @NonNull String str, @Nullable Bundle bundle);

    public abstract boolean receiveFile(@NonNull CustomTabsSessionToken customTabsSessionToken, @NonNull Uri uri, int i10, @Nullable Bundle bundle);

    public abstract boolean requestPostMessageChannel(@NonNull CustomTabsSessionToken customTabsSessionToken, @NonNull Uri uri);

    public boolean requestPostMessageChannel(@NonNull CustomTabsSessionToken customTabsSessionToken, @NonNull Uri uri, @Nullable Uri uri2, @NonNull Bundle bundle) {
        return requestPostMessageChannel(customTabsSessionToken, uri);
    }

    public boolean setEngagementSignalsCallback(@NonNull CustomTabsSessionToken customTabsSessionToken, @NonNull EngagementSignalsCallback engagementSignalsCallback, @NonNull Bundle bundle) {
        return false;
    }

    public abstract boolean updateVisuals(@NonNull CustomTabsSessionToken customTabsSessionToken, @Nullable Bundle bundle);

    public abstract boolean validateRelationship(@NonNull CustomTabsSessionToken customTabsSessionToken, int i10, @NonNull Uri uri, @Nullable Bundle bundle);

    public abstract boolean warmup(long j10);
}
