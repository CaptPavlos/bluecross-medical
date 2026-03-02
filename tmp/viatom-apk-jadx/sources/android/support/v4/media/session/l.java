package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class l extends MediaController.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final y2.c f419a;

    public l(y2.c cVar) {
        this.f419a = cVar;
    }

    @Override // android.media.session.MediaController.Callback
    public final void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
        playbackInfo.getPlaybackType();
        AudioAttributes audioAttributes = playbackInfo.getAudioAttributes();
        if ((audioAttributes.getFlags() & 1) != 1 && (audioAttributes.getFlags() & 4) != 4) {
            audioAttributes.getUsage();
        }
        playbackInfo.getVolumeControl();
        playbackInfo.getMaxVolume();
        playbackInfo.getCurrentVolume();
        f fVar = (f) ((WeakReference) this.f419a.f13781b).get();
        if (fVar != null) {
            fVar.onAudioInfoChanged(new j());
        }
    }

    @Override // android.media.session.MediaController.Callback
    public final void onExtrasChanged(Bundle bundle) {
        m.a(bundle);
        f fVar = (f) ((WeakReference) this.f419a.f13781b).get();
        if (fVar != null) {
            fVar.onExtrasChanged(bundle);
        }
    }

    @Override // android.media.session.MediaController.Callback
    public final void onMetadataChanged(MediaMetadata mediaMetadata) {
        MediaMetadataCompat mediaMetadataCompatCreateFromParcel;
        f fVar = (f) ((WeakReference) this.f419a.f13781b).get();
        if (fVar != null) {
            Parcelable.Creator<MediaMetadataCompat> creator = MediaMetadataCompat.CREATOR;
            if (mediaMetadata != null) {
                Parcel parcelObtain = Parcel.obtain();
                mediaMetadata.writeToParcel(parcelObtain, 0);
                parcelObtain.setDataPosition(0);
                mediaMetadataCompatCreateFromParcel = MediaMetadataCompat.CREATOR.createFromParcel(parcelObtain);
                parcelObtain.recycle();
                mediaMetadataCompatCreateFromParcel.getClass();
            } else {
                mediaMetadataCompatCreateFromParcel = null;
            }
            fVar.onMetadataChanged(mediaMetadataCompatCreateFromParcel);
        }
    }

    @Override // android.media.session.MediaController.Callback
    public final void onPlaybackStateChanged(PlaybackState playbackState) {
        ArrayList arrayList;
        PlaybackStateCompat.CustomAction customAction;
        f fVar = (f) ((WeakReference) this.f419a.f13781b).get();
        if (fVar == null || fVar.mIControllerCallback != null) {
            return;
        }
        PlaybackStateCompat playbackStateCompat = null;
        if (playbackState != null) {
            List<PlaybackState.CustomAction> customActions = playbackState.getCustomActions();
            if (customActions != null) {
                ArrayList arrayList2 = new ArrayList(customActions.size());
                for (PlaybackState.CustomAction customAction2 : customActions) {
                    if (customAction2 != null) {
                        PlaybackState.CustomAction customAction3 = customAction2;
                        customAction = new PlaybackStateCompat.CustomAction(customAction3.getAction(), customAction3.getName(), customAction3.getIcon(), customAction3.getExtras());
                        customAction.e = customAction2;
                    } else {
                        customAction = null;
                    }
                    arrayList2.add(customAction);
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            playbackStateCompat = new PlaybackStateCompat(playbackState.getState(), playbackState.getPosition(), playbackState.getBufferedPosition(), playbackState.getPlaybackSpeed(), playbackState.getActions(), playbackState.getErrorMessage(), playbackState.getLastPositionUpdateTime(), arrayList, playbackState.getActiveQueueItemId(), playbackState.getExtras());
        }
        fVar.onPlaybackStateChanged(playbackStateCompat);
    }

    @Override // android.media.session.MediaController.Callback
    public final void onQueueChanged(List list) {
        MediaSessionCompat$QueueItem mediaSessionCompat$QueueItem;
        f fVar = (f) ((WeakReference) this.f419a.f13781b).get();
        if (fVar != null) {
            ArrayList arrayList = null;
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list) {
                    if (obj != null) {
                        MediaSession.QueueItem queueItem = (MediaSession.QueueItem) obj;
                        mediaSessionCompat$QueueItem = new MediaSessionCompat$QueueItem(obj, MediaDescriptionCompat.a(queueItem.getDescription()), queueItem.getQueueId());
                    } else {
                        mediaSessionCompat$QueueItem = null;
                    }
                    arrayList2.add(mediaSessionCompat$QueueItem);
                }
                arrayList = arrayList2;
            }
            fVar.onQueueChanged(arrayList);
        }
    }

    @Override // android.media.session.MediaController.Callback
    public final void onQueueTitleChanged(CharSequence charSequence) {
        f fVar = (f) ((WeakReference) this.f419a.f13781b).get();
        if (fVar != null) {
            fVar.onQueueTitleChanged(charSequence);
        }
    }

    @Override // android.media.session.MediaController.Callback
    public final void onSessionDestroyed() {
        f fVar = (f) ((WeakReference) this.f419a.f13781b).get();
        if (fVar != null) {
            fVar.onSessionDestroyed();
        }
    }

    @Override // android.media.session.MediaController.Callback
    public final void onSessionEvent(String str, Bundle bundle) {
        m.a(bundle);
        f fVar = (f) ((WeakReference) this.f419a.f13781b).get();
        if (fVar != null) {
            fVar.onSessionEvent(str, bundle);
        }
    }
}
