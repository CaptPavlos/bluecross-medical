package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import androidx.annotation.RestrictTo;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class f implements IBinder.DeathRecipient {
    final Object mCallbackObj = new l(new y2.c(this));
    e mHandler;
    a mIControllerCallback;

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        postToHandler(8, null, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public a getIControllerCallback() {
        return this.mIControllerCallback;
    }

    public abstract void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat);

    public abstract void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat);

    public void postToHandler(int i10, Object obj, Bundle bundle) {
        e eVar = this.mHandler;
        if (eVar != null) {
            Message messageObtainMessage = eVar.obtainMessage(i10, obj);
            messageObtainMessage.setData(bundle);
            messageObtainMessage.sendToTarget();
        }
    }

    public void setHandler(Handler handler) {
        if (handler != null) {
            e eVar = new e(this, handler.getLooper());
            this.mHandler = eVar;
            eVar.f412a = true;
        } else {
            e eVar2 = this.mHandler;
            if (eVar2 != null) {
                eVar2.f412a = false;
                eVar2.removeCallbacksAndMessages(null);
                this.mHandler = null;
            }
        }
    }

    public void onSessionDestroyed() {
    }

    public void onSessionReady() {
    }

    public void onAudioInfoChanged(j jVar) {
    }

    public void onCaptioningEnabledChanged(boolean z9) {
    }

    public void onExtrasChanged(Bundle bundle) {
    }

    public void onQueueChanged(List<MediaSessionCompat$QueueItem> list) {
    }

    public void onQueueTitleChanged(CharSequence charSequence) {
    }

    public void onRepeatModeChanged(int i10) {
    }

    public void onShuffleModeChanged(int i10) {
    }

    public void onSessionEvent(String str, Bundle bundle) {
    }
}
