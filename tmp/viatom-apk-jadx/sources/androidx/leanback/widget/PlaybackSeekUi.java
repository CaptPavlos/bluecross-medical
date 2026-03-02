package androidx.leanback.widget;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface PlaybackSeekUi {
    void setPlaybackSeekUiClient(Client client);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Client {
        public PlaybackSeekDataProvider getPlaybackSeekDataProvider() {
            return null;
        }

        public boolean isSeekEnabled() {
            return false;
        }

        public void onSeekStarted() {
        }

        public void onSeekFinished(boolean z9) {
        }

        public void onSeekPositionChanged(long j10) {
        }
    }
}
