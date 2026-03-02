package z8;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface k extends h0, ReadableByteChannel {
    InputStream inputStream();

    byte readByte();

    l readByteString(long j10);

    long readHexadecimalUnsignedLong();

    int readInt();

    short readShort();

    String readUtf8LineStrict();

    String readUtf8LineStrict(long j10);

    void require(long j10);

    void skip(long j10);
}
