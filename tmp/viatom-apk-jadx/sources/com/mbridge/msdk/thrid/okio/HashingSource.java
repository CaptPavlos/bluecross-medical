package com.mbridge.msdk.thrid.okio;

import com.mbridge.msdk.foundation.tools.SameMD5;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class HashingSource extends ForwardingSource {
    private final Mac mac;
    private final MessageDigest messageDigest;

    private HashingSource(Source source, ByteString byteString, String str) throws NoSuchAlgorithmException, InvalidKeyException {
        super(source);
        try {
            Mac mac = Mac.getInstance(str);
            this.mac = mac;
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            this.messageDigest = null;
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException unused) {
            u.m();
            throw null;
        }
    }

    public static HashingSource hmacSha1(Source source, ByteString byteString) {
        return new HashingSource(source, byteString, "HmacSHA1");
    }

    public static HashingSource hmacSha256(Source source, ByteString byteString) {
        return new HashingSource(source, byteString, "HmacSHA256");
    }

    public static HashingSource md5(Source source) {
        return new HashingSource(source, SameMD5.TAG);
    }

    public static HashingSource sha1(Source source) {
        return new HashingSource(source, "SHA-1");
    }

    public static HashingSource sha256(Source source) {
        return new HashingSource(source, "SHA-256");
    }

    public final ByteString hash() {
        MessageDigest messageDigest = this.messageDigest;
        return ByteString.of(messageDigest != null ? messageDigest.digest() : this.mac.doFinal());
    }

    @Override // com.mbridge.msdk.thrid.okio.ForwardingSource, com.mbridge.msdk.thrid.okio.Source
    public long read(Buffer buffer, long j10) throws IllegalStateException, IOException {
        long j11 = super.read(buffer, j10);
        if (j11 != -1) {
            long j12 = buffer.size;
            long j13 = j12 - j11;
            Segment segment = buffer.head;
            while (j12 > j13) {
                segment = segment.prev;
                j12 -= segment.limit - segment.pos;
            }
            while (j12 < buffer.size) {
                int i10 = (int) ((segment.pos + j13) - j12);
                MessageDigest messageDigest = this.messageDigest;
                if (messageDigest != null) {
                    messageDigest.update(segment.data, i10, segment.limit - i10);
                } else {
                    this.mac.update(segment.data, i10, segment.limit - i10);
                }
                j13 = (segment.limit - segment.pos) + j12;
                segment = segment.next;
                j12 = j13;
            }
        }
        return j11;
    }

    private HashingSource(Source source, String str) {
        super(source);
        try {
            this.messageDigest = MessageDigest.getInstance(str);
            this.mac = null;
        } catch (NoSuchAlgorithmException unused) {
            u.m();
            throw null;
        }
    }
}
