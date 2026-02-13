package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class ContentMetadataMutations {
    private final Map<String, Object> editedValues = new HashMap();
    private final List<String> removedValues = new ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    private ContentMetadataMutations checkAndSet(String str, Object obj) {
        this.editedValues.put(Assertions.checkNotNull(str), Assertions.checkNotNull(obj));
        this.removedValues.remove(str);
        return this;
    }

    public Map<String, Object> getEditedValues() {
        HashMap map = new HashMap(this.editedValues);
        for (Map.Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        return DesugarCollections.unmodifiableMap(map);
    }

    public List<String> getRemovedValues() {
        return DesugarCollections.unmodifiableList(new ArrayList(this.removedValues));
    }

    public ContentMetadataMutations remove(String str) {
        this.removedValues.add(str);
        this.editedValues.remove(str);
        return this;
    }

    public ContentMetadataMutations set(String str, byte[] bArr) {
        return checkAndSet(str, Arrays.copyOf(bArr, bArr.length));
    }

    public ContentMetadataMutations set(String str, long j10) {
        return checkAndSet(str, Long.valueOf(j10));
    }

    public ContentMetadataMutations set(String str, String str2) {
        return checkAndSet(str, str2);
    }
}
