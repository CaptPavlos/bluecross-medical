package com.mbridge.msdk.playercommon.exoplayer2.text.subrip;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.text.SimpleSubtitleDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.util.LongArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class SubripDecoder extends SimpleSubtitleDecoder {
    private static final String SUBRIP_TIMECODE = "(?:(\\d+):)?(\\d+):(\\d+),(\\d+)";
    private static final Pattern SUBRIP_TIMING_LINE = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
    private static final String TAG = "SubripDecoder";
    private final StringBuilder textBuilder;

    public SubripDecoder() {
        super(TAG);
        this.textBuilder = new StringBuilder();
    }

    private static long parseTimecode(Matcher matcher, int i10) {
        return (Long.parseLong(matcher.group(i10 + 4)) + (Long.parseLong(matcher.group(i10 + 3)) * 1000) + (Long.parseLong(matcher.group(i10 + 2)) * ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) + (Long.parseLong(matcher.group(i10 + 1)) * 3600000)) * 1000;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.text.SimpleSubtitleDecoder
    public final SubripSubtitle decode(byte[] bArr, int i10, boolean z9) throws NumberFormatException {
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        LongArray longArray = new LongArray();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i10);
        while (true) {
            String line = parsableByteArray.readLine();
            if (line == null) {
                break;
            }
            if (line.length() != 0) {
                try {
                    Integer.parseInt(line);
                    String line2 = parsableByteArray.readLine();
                    if (line2 == null) {
                        Log.w(TAG, "Unexpected end");
                        break;
                    }
                    Matcher matcher = SUBRIP_TIMING_LINE.matcher(line2);
                    if (matcher.matches()) {
                        boolean z10 = true;
                        longArray.add(parseTimecode(matcher, 1));
                        if (TextUtils.isEmpty(matcher.group(6))) {
                            z10 = false;
                        } else {
                            longArray.add(parseTimecode(matcher, 6));
                        }
                        this.textBuilder.setLength(0);
                        while (true) {
                            String line3 = parsableByteArray.readLine();
                            boolean zIsEmpty = TextUtils.isEmpty(line3);
                            sb = this.textBuilder;
                            if (zIsEmpty) {
                                break;
                            }
                            if (sb.length() > 0) {
                                this.textBuilder.append("<br>");
                            }
                            this.textBuilder.append(line3.trim());
                        }
                        arrayList.add(new Cue(Html.fromHtml(sb.toString())));
                        if (z10) {
                            arrayList.add(null);
                        }
                    } else {
                        Log.w(TAG, "Skipping invalid timing: ".concat(line2));
                    }
                } catch (NumberFormatException unused) {
                    Log.w(TAG, "Skipping invalid index: ".concat(line));
                }
            }
        }
        Cue[] cueArr = new Cue[arrayList.size()];
        arrayList.toArray(cueArr);
        return new SubripSubtitle(cueArr, longArray.toArray());
    }
}
