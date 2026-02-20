package com.mbridge.msdk.tracker.network.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    protected static final Comparator<byte[]> f5449a = new Comparator<byte[]>() { // from class: com.mbridge.msdk.tracker.network.toolbox.c.1
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private final List<byte[]> f5450b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final List<byte[]> f5451c = new ArrayList(64);

    /* renamed from: d, reason: collision with root package name */
    private int f5452d = 0;
    private final int e;

    public c(int i10) {
        this.e = i10;
    }

    public final synchronized byte[] a(int i10) {
        for (int i11 = 0; i11 < this.f5451c.size(); i11++) {
            byte[] bArr = this.f5451c.get(i11);
            if (bArr.length >= i10) {
                this.f5452d -= bArr.length;
                this.f5451c.remove(i11);
                this.f5450b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i10];
    }

    public final synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.e) {
                this.f5450b.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.f5451c, bArr, f5449a);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.f5451c.add(iBinarySearch, bArr);
                this.f5452d += bArr.length;
                a();
            }
        }
    }

    private synchronized void a() {
        while (this.f5452d > this.e) {
            byte[] bArrRemove = this.f5450b.remove(0);
            this.f5451c.remove(bArrRemove);
            this.f5452d -= bArrRemove.length;
        }
    }
}
