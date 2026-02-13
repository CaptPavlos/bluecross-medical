package com.mbridge.msdk.playercommon.exoplayer2.util;

import com.google.gson.internal.a;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class LongArray {
    private static final int DEFAULT_INITIAL_CAPACITY = 32;
    private int size;
    private long[] values;

    public LongArray(int i10) {
        this.values = new long[i10];
    }

    public final void add(long j10) {
        int i10 = this.size;
        long[] jArr = this.values;
        if (i10 == jArr.length) {
            this.values = Arrays.copyOf(jArr, i10 * 2);
        }
        long[] jArr2 = this.values;
        int i11 = this.size;
        this.size = i11 + 1;
        jArr2[i11] = j10;
    }

    public final long get(int i10) {
        if (i10 >= 0 && i10 < this.size) {
            return this.values[i10];
        }
        a.f(this.size, a3.a.r(i10, "Invalid index ", ", size is "));
        return 0L;
    }

    public final int size() {
        return this.size;
    }

    public final long[] toArray() {
        return Arrays.copyOf(this.values, this.size);
    }

    public LongArray() {
        this(32);
    }
}
