package com.mbridge.msdk.playercommon.exoplayer2.extractor.ts;

import android.util.SparseArray;
import androidx.window.layout.c;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.TimestampAdjuster;
import j$.util.DesugarCollections;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface TsPayloadReader {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class DvbSubtitleInfo {
        public final byte[] initializationData;
        public final String language;
        public final int type;

        public DvbSubtitleInfo(String str, int i10, byte[] bArr) {
            this.language = str;
            this.type = i10;
            this.initializationData = bArr;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class EsInfo {
        public final byte[] descriptorBytes;
        public final List<DvbSubtitleInfo> dvbSubtitleInfos;
        public final String language;
        public final int streamType;

        public EsInfo(int i10, String str, List<DvbSubtitleInfo> list, byte[] bArr) {
            this.streamType = i10;
            this.language = str;
            this.dvbSubtitleInfos = list == null ? Collections.EMPTY_LIST : DesugarCollections.unmodifiableList(list);
            this.descriptorBytes = bArr;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface Factory {
        SparseArray<TsPayloadReader> createInitialPayloadReaders();

        TsPayloadReader createPayloadReader(int i10, EsInfo esInfo);
    }

    void consume(ParsableByteArray parsableByteArray, boolean z9) throws ParserException;

    void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator);

    void seek();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class TrackIdGenerator {
        private static final int ID_UNSET = Integer.MIN_VALUE;
        private final int firstTrackId;
        private String formatId;
        private final String formatIdPrefix;
        private int trackId;
        private final int trackIdIncrement;

        public TrackIdGenerator(int i10, int i11, int i12) {
            String str;
            if (i10 != Integer.MIN_VALUE) {
                str = i10 + "/";
            } else {
                str = "";
            }
            this.formatIdPrefix = str;
            this.firstTrackId = i11;
            this.trackIdIncrement = i12;
            this.trackId = Integer.MIN_VALUE;
        }

        private void maybeThrowUninitializedError() {
            if (this.trackId != Integer.MIN_VALUE) {
                return;
            }
            c.g("generateNewId() must be called before retrieving ids.");
        }

        public final void generateNewId() {
            int i10 = this.trackId;
            this.trackId = i10 == Integer.MIN_VALUE ? this.firstTrackId : i10 + this.trackIdIncrement;
            this.formatId = this.formatIdPrefix + this.trackId;
        }

        public final String getFormatId() {
            maybeThrowUninitializedError();
            return this.formatId;
        }

        public final int getTrackId() {
            maybeThrowUninitializedError();
            return this.trackId;
        }

        public TrackIdGenerator(int i10, int i11) {
            this(Integer.MIN_VALUE, i10, i11);
        }
    }
}
