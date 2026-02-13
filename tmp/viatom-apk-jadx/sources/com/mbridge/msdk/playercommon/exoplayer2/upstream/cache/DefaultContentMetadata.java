package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import androidx.core.view.accessibility.a;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.util.DesugarCollections;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class DefaultContentMetadata implements ContentMetadata {
    public static final DefaultContentMetadata EMPTY = new DefaultContentMetadata(Collections.EMPTY_MAP);
    private static final int MAX_VALUE_LENGTH = 10485760;
    private int hashCode;
    private final Map<String, byte[]> metadata;

    private DefaultContentMetadata(Map<String, byte[]> map) {
        this.metadata = DesugarCollections.unmodifiableMap(map);
    }

    private static void addValues(HashMap<String, byte[]> map, Map<String, Object> map2) {
        for (String str : map2.keySet()) {
            byte[] bytes = getBytes(map2.get(str));
            if (bytes.length > MAX_VALUE_LENGTH) {
                a.r("The size of %s (%d) is greater than maximum allowed: %d", new Object[]{str, Integer.valueOf(bytes.length), Integer.valueOf(MAX_VALUE_LENGTH)});
                return;
            }
            map.put(str, bytes);
        }
    }

    private static Map<String, byte[]> applyMutations(Map<String, byte[]> map, ContentMetadataMutations contentMetadataMutations) {
        HashMap map2 = new HashMap(map);
        removeValues(map2, contentMetadataMutations.getRemovedValues());
        addValues(map2, contentMetadataMutations.getEditedValues());
        return map2;
    }

    private static byte[] getBytes(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(Charset.forName(C.UTF8_NAME));
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        f.a();
        return null;
    }

    private boolean isMetadataEqual(Map<String, byte[]> map) {
        if (this.metadata.size() != map.size()) {
            return false;
        }
        for (Map.Entry<String, byte[]> entry : this.metadata.entrySet()) {
            if (!Arrays.equals(entry.getValue(), map.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static DefaultContentMetadata readFromStream(DataInputStream dataInputStream) throws IOException {
        int i10 = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i11 = 0; i11 < i10; i11++) {
            String utf = dataInputStream.readUTF();
            int i12 = dataInputStream.readInt();
            if (i12 < 0 || i12 > MAX_VALUE_LENGTH) {
                com.google.gson.internal.a.m(a3.a.f(i12, "Invalid value size: "));
                return null;
            }
            byte[] bArr = new byte[i12];
            dataInputStream.readFully(bArr);
            map.put(utf, bArr);
        }
        return new DefaultContentMetadata(map);
    }

    private static void removeValues(HashMap<String, byte[]> map, List<String> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            map.remove(list.get(i10));
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.ContentMetadata
    public final boolean contains(String str) {
        return this.metadata.containsKey(str);
    }

    public final DefaultContentMetadata copyWithMutationsApplied(ContentMetadataMutations contentMetadataMutations) {
        Map<String, byte[]> mapApplyMutations = applyMutations(this.metadata, contentMetadataMutations);
        return isMetadataEqual(mapApplyMutations) ? this : new DefaultContentMetadata(mapApplyMutations);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultContentMetadata.class != obj.getClass()) {
            return false;
        }
        return isMetadataEqual(((DefaultContentMetadata) obj).metadata);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.ContentMetadata
    public final String get(String str, String str2) {
        return this.metadata.containsKey(str) ? new String(this.metadata.get(str), Charset.forName(C.UTF8_NAME)) : str2;
    }

    public final int hashCode() {
        if (this.hashCode == 0) {
            int iHashCode = 0;
            for (Map.Entry<String, byte[]> entry : this.metadata.entrySet()) {
                iHashCode += Arrays.hashCode(entry.getValue()) ^ entry.getKey().hashCode();
            }
            this.hashCode = iHashCode;
        }
        return this.hashCode;
    }

    public final void writeToStream(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.metadata.size());
        for (Map.Entry<String, byte[]> entry : this.metadata.entrySet()) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.ContentMetadata
    public final byte[] get(String str, byte[] bArr) {
        if (!this.metadata.containsKey(str)) {
            return bArr;
        }
        byte[] bArr2 = this.metadata.get(str);
        return Arrays.copyOf(bArr2, bArr2.length);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.ContentMetadata
    public final long get(String str, long j10) {
        return this.metadata.containsKey(str) ? ByteBuffer.wrap(this.metadata.get(str)).getLong() : j10;
    }
}
