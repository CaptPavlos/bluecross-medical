package com.mbridge.msdk.out;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface WebLoadListener {
    void onFailed(String str, int i10, int i11, int i12, String str2, String str3);

    void onProgress(String str, int i10, int i11, int i12, String str2, String str3);

    void onSucess(String str, int i10, int i11, int i12, String str2, String str3);
}
