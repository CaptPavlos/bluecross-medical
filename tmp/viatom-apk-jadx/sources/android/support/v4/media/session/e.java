package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class e extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public boolean f412a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f413b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, Looper looper) {
        super(looper);
        this.f413b = fVar;
        this.f412a = false;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.f412a) {
            int i10 = message.what;
            f fVar = this.f413b;
            switch (i10) {
                case 1:
                    Bundle data = message.getData();
                    m.a(data);
                    fVar.onSessionEvent((String) message.obj, data);
                    break;
                case 2:
                    fVar.onPlaybackStateChanged((PlaybackStateCompat) message.obj);
                    break;
                case 3:
                    fVar.onMetadataChanged((MediaMetadataCompat) message.obj);
                    break;
                case 4:
                    fVar.onAudioInfoChanged((j) message.obj);
                    break;
                case 5:
                    fVar.onQueueChanged((List) message.obj);
                    break;
                case 6:
                    fVar.onQueueTitleChanged((CharSequence) message.obj);
                    break;
                case 7:
                    Bundle bundle = (Bundle) message.obj;
                    m.a(bundle);
                    fVar.onExtrasChanged(bundle);
                    break;
                case 8:
                    fVar.onSessionDestroyed();
                    break;
                case 9:
                    fVar.onRepeatModeChanged(((Integer) message.obj).intValue());
                    break;
                case 11:
                    fVar.onCaptioningEnabledChanged(((Boolean) message.obj).booleanValue());
                    break;
                case 12:
                    fVar.onShuffleModeChanged(((Integer) message.obj).intValue());
                    break;
                case 13:
                    fVar.onSessionReady();
                    break;
            }
        }
    }
}
