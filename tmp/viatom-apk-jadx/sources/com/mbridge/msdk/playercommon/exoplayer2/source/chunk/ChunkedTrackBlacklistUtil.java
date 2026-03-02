package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

import a3.a;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.HttpDataSource;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ChunkedTrackBlacklistUtil {
    public static final long DEFAULT_TRACK_BLACKLIST_MS = 60000;
    private static final String TAG = "ChunkedTrackBlacklist";

    private ChunkedTrackBlacklistUtil() {
    }

    public static boolean maybeBlacklistTrack(TrackSelection trackSelection, int i10, Exception exc, long j10) {
        if (!shouldBlacklist(exc)) {
            return false;
        }
        boolean zBlacklist = trackSelection.blacklist(i10, j10);
        int i11 = ((HttpDataSource.InvalidResponseCodeException) exc).responseCode;
        if (!zBlacklist) {
            StringBuilder sbR = a.r(i11, "Blacklisting failed (cannot blacklist last enabled track): responseCode=", ", format=");
            sbR.append(trackSelection.getFormat(i10));
            Log.w(TAG, sbR.toString());
            return zBlacklist;
        }
        Log.w(TAG, "Blacklisted: duration=" + j10 + ", responseCode=" + i11 + ", format=" + trackSelection.getFormat(i10));
        return zBlacklist;
    }

    public static boolean shouldBlacklist(Exception exc) {
        if (!(exc instanceof HttpDataSource.InvalidResponseCodeException)) {
            return false;
        }
        int i10 = ((HttpDataSource.InvalidResponseCodeException) exc).responseCode;
        return i10 == 404 || i10 == 410;
    }

    public static boolean maybeBlacklistTrack(TrackSelection trackSelection, int i10, Exception exc) {
        return maybeBlacklistTrack(trackSelection, i10, exc, DEFAULT_TRACK_BLACKLIST_MS);
    }
}
