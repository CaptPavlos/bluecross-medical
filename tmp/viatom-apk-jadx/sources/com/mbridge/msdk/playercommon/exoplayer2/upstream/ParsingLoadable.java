package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Loader;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ParsingLoadable<T> implements Loader.Loadable {
    private volatile long bytesLoaded;
    private final DataSource dataSource;
    public final DataSpec dataSpec;
    private final Parser<? extends T> parser;
    private volatile T result;
    public final int type;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface Parser<T> {
        T parse(Uri uri, InputStream inputStream) throws IOException;
    }

    public ParsingLoadable(DataSource dataSource, DataSpec dataSpec, int i10, Parser<? extends T> parser) {
        this.dataSource = dataSource;
        this.dataSpec = dataSpec;
        this.type = i10;
        this.parser = parser;
    }

    public final long bytesLoaded() {
        return this.bytesLoaded;
    }

    public final T getResult() {
        return this.result;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.Loader.Loadable
    public final void load() throws IOException {
        DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(this.dataSource, this.dataSpec);
        try {
            dataSourceInputStream.open();
            this.result = this.parser.parse(this.dataSource.getUri(), dataSourceInputStream);
        } finally {
            this.bytesLoaded = dataSourceInputStream.bytesRead();
            Util.closeQuietly(dataSourceInputStream);
        }
    }

    public ParsingLoadable(DataSource dataSource, Uri uri, int i10, Parser<? extends T> parser) {
        this(dataSource, new DataSpec(uri, 3), i10, parser);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
    }

    public static <T> T load(DataSource dataSource, Parser<? extends T> parser, Uri uri) throws IOException {
        ParsingLoadable parsingLoadable = new ParsingLoadable(dataSource, uri, 0, parser);
        parsingLoadable.load();
        return (T) parsingLoadable.getResult();
    }
}
