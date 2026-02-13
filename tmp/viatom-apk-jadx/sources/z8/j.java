package z8;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface j extends f0, WritableByteChannel {
    @Override // z8.f0, java.io.Flushable
    void flush();

    OutputStream outputStream();

    j write(byte[] bArr);

    j writeByte(int i10);

    j writeHexadecimalUnsignedLong(long j10);

    j writeInt(int i10);

    j writeShort(int i10);

    j writeUtf8(String str);
}
