package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
import p8.u;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class Segment {
    static final int SHARE_MINIMUM = 1024;
    static final int SIZE = 8192;
    final byte[] data;
    int limit;
    Segment next;
    boolean owner;
    int pos;
    Segment prev;
    boolean shared;

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void compact() {
        Segment segment = this.prev;
        if (segment == this) {
            u.e();
            return;
        }
        if (segment.owner) {
            int i10 = this.limit - this.pos;
            if (i10 > (8192 - segment.limit) + (segment.shared ? 0 : segment.pos)) {
                return;
            }
            writeTo(segment, i10);
            pop();
            SegmentPool.recycle(this);
        }
    }

    @Nullable
    public final Segment pop() {
        Segment segment = this.next;
        Segment segment2 = segment != this ? segment : null;
        Segment segment3 = this.prev;
        segment3.next = segment;
        this.next.prev = segment3;
        this.next = null;
        this.prev = null;
        return segment2;
    }

    public final Segment push(Segment segment) {
        segment.prev = this;
        segment.next = this.next;
        this.next.prev = segment;
        this.next = segment;
        return segment;
    }

    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public final Segment split(int i10) {
        Segment segmentTake;
        if (i10 <= 0 || i10 > this.limit - this.pos) {
            f.a();
            return null;
        }
        if (i10 >= 1024) {
            segmentTake = sharedCopy();
        } else {
            segmentTake = SegmentPool.take();
            System.arraycopy(this.data, this.pos, segmentTake.data, 0, i10);
        }
        segmentTake.limit = segmentTake.pos + i10;
        this.pos += i10;
        this.prev.push(segmentTake);
        return segmentTake;
    }

    public final Segment unsharedCopy() {
        return new Segment((byte[]) this.data.clone(), this.pos, this.limit, false, true);
    }

    public final void writeTo(Segment segment, int i10) {
        if (!segment.owner) {
            f.a();
            return;
        }
        int i11 = segment.limit;
        if (i11 + i10 > 8192) {
            if (segment.shared) {
                f.a();
                return;
            }
            int i12 = segment.pos;
            if ((i11 + i10) - i12 > 8192) {
                f.a();
                return;
            }
            byte[] bArr = segment.data;
            System.arraycopy(bArr, i12, bArr, 0, i11 - i12);
            segment.limit -= segment.pos;
            segment.pos = 0;
        }
        System.arraycopy(this.data, this.pos, segment.data, segment.limit, i10);
        segment.limit += i10;
        this.pos += i10;
    }

    public Segment(byte[] bArr, int i10, int i11, boolean z9, boolean z10) {
        this.data = bArr;
        this.pos = i10;
        this.limit = i11;
        this.shared = z9;
        this.owner = z10;
    }
}
