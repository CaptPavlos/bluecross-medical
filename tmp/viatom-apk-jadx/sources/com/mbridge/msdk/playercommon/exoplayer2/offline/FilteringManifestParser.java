package com.mbridge.msdk.playercommon.exoplayer2.offline;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.offline.FilterableManifest;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.ParsingLoadable;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class FilteringManifestParser<T extends FilterableManifest<T, K>, K> implements ParsingLoadable.Parser<T> {
    private final ParsingLoadable.Parser<T> parser;
    private final List<K> trackKeys;

    public FilteringManifestParser(ParsingLoadable.Parser<T> parser, List<K> list) {
        this.parser = parser;
        this.trackKeys = list;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.ParsingLoadable.Parser
    public final T parse(Uri uri, InputStream inputStream) throws IOException {
        T t = this.parser.parse(uri, inputStream);
        List<K> list = this.trackKeys;
        return (list == null || list.isEmpty()) ? t : (T) t.copy(this.trackKeys);
    }
}
