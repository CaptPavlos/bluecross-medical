package androidx.media.session;

import a3.a;
import a4.f;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.c;
import android.support.v4.media.d;
import android.support.v4.media.g;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.h;
import android.support.v4.media.session.i;
import android.support.v4.media.session.m;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.RestrictTo;
import androidx.media.MediaBrowserServiceCompat;
import java.util.HashSet;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class MediaButtonReceiver extends BroadcastReceiver {
    private static final String TAG = "MediaButtonReceiver";

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class MediaButtonConnectionCallback extends c {
        private final Context mContext;
        private final Intent mIntent;
        private g mMediaBrowser;
        private final BroadcastReceiver.PendingResult mPendingResult;

        public MediaButtonConnectionCallback(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.mContext = context;
            this.mIntent = intent;
            this.mPendingResult = pendingResult;
        }

        private void finish() throws RemoteException {
            Messenger messenger;
            d dVar = this.mMediaBrowser.f386a;
            f fVar = dVar.f;
            if (fVar != null && (messenger = dVar.g) != null) {
                try {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 7;
                    messageObtain.arg1 = 1;
                    messageObtain.setData(null);
                    messageObtain.replyTo = messenger;
                    ((Messenger) fVar.f218b).send(messageObtain);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            dVar.f381b.disconnect();
            this.mPendingResult.finish();
        }

        @Override // android.support.v4.media.c
        public void onConnected() throws RemoteException {
            Context context;
            MediaSessionCompat$Token mediaSessionCompat$Token;
            try {
                context = this.mContext;
                d dVar = this.mMediaBrowser.f386a;
                if (dVar.h == null) {
                    dVar.h = MediaSessionCompat$Token.a(dVar.f381b.getSessionToken(), null);
                }
                mediaSessionCompat$Token = dVar.h;
                new HashSet();
            } catch (RemoteException e) {
                Log.e(MediaButtonReceiver.TAG, "Failed to create a media controller", e);
            }
            if (mediaSessionCompat$Token == null) {
                throw new IllegalArgumentException("sessionToken must not be null");
            }
            h iVar = Build.VERSION.SDK_INT >= 24 ? new i(context, mediaSessionCompat$Token) : new h(context, mediaSessionCompat$Token);
            KeyEvent keyEvent = (KeyEvent) this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
            if (keyEvent == null) {
                throw new IllegalArgumentException("KeyEvent may not be null");
            }
            iVar.f415a.dispatchMediaButtonEvent(keyEvent);
            finish();
        }

        @Override // android.support.v4.media.c
        public void onConnectionFailed() throws RemoteException {
            finish();
        }

        @Override // android.support.v4.media.c
        public void onConnectionSuspended() throws RemoteException {
            finish();
        }

        public void setMediaBrowser(g gVar) {
            this.mMediaBrowser = gVar;
        }
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context context, ComponentName componentName, long j10) {
        if (componentName == null) {
            Log.w(TAG, "The component name of media button receiver should be provided.");
            return null;
        }
        int i10 = j10 == 4 ? 126 : j10 == 2 ? 127 : j10 == 32 ? 87 : j10 == 16 ? 88 : j10 == 1 ? 86 : j10 == 64 ? 90 : j10 == 8 ? 89 : j10 == 512 ? 85 : 0;
        if (i10 == 0) {
            Log.w(TAG, "Cannot build a media button pending intent with the given action: " + j10);
            return null;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(componentName);
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, i10));
        return PendingIntent.getBroadcast(context, i10, intent, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static ComponentName getMediaButtonReceiverComponent(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (listQueryBroadcastReceivers.size() == 1) {
            ActivityInfo activityInfo = listQueryBroadcastReceivers.get(0).activityInfo;
            return new ComponentName(activityInfo.packageName, activityInfo.name);
        }
        if (listQueryBroadcastReceivers.size() <= 1) {
            return null;
        }
        Log.w(TAG, "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
        return null;
    }

    private static ComponentName getServiceComponentByAction(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices.size() == 1) {
            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        }
        if (listQueryIntentServices.isEmpty()) {
            return null;
        }
        StringBuilder sbY = a.y("Expected 1 service that handles ", str, ", found ");
        sbY.append(listQueryIntentServices.size());
        throw new IllegalStateException(sbY.toString());
    }

    public static KeyEvent handleIntent(m mVar, Intent intent) {
        return null;
    }

    private static void startForegroundService(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.d(TAG, "Ignore unsupported intent: " + intent);
            return;
        }
        ComponentName serviceComponentByAction = getServiceComponentByAction(context, "android.intent.action.MEDIA_BUTTON");
        if (serviceComponentByAction != null) {
            intent.setComponent(serviceComponentByAction);
            startForegroundService(context, intent);
            return;
        }
        ComponentName serviceComponentByAction2 = getServiceComponentByAction(context, MediaBrowserServiceCompat.SERVICE_INTERFACE);
        if (serviceComponentByAction2 == null) {
            androidx.window.layout.c.g("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
            return;
        }
        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        Context applicationContext = context.getApplicationContext();
        MediaButtonConnectionCallback mediaButtonConnectionCallback = new MediaButtonConnectionCallback(applicationContext, intent, pendingResultGoAsync);
        g gVar = new g(applicationContext, serviceComponentByAction2, mediaButtonConnectionCallback);
        mediaButtonConnectionCallback.setMediaBrowser(gVar);
        gVar.f386a.f381b.connect();
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context context, long j10) {
        ComponentName mediaButtonReceiverComponent = getMediaButtonReceiverComponent(context);
        if (mediaButtonReceiverComponent == null) {
            Log.w(TAG, "A unique media button receiver could not be found in the given context, so couldn't build a pending intent.");
            return null;
        }
        return buildMediaButtonPendingIntent(context, mediaButtonReceiverComponent, j10);
    }
}
