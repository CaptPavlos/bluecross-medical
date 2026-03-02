package com.mbridge.msdk.foundation.tools;

import androidx.work.WorkInfo;
import com.mbridge.msdk.foundation.tools.FastKV;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class ao implements FastKV.a<Set<String>> {

    /* renamed from: a, reason: collision with root package name */
    static final ao f3968a = new ao();

    private ao() {
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.a
    public final /* synthetic */ byte[] a(Set<String> set) {
        byte[] bArr;
        Set<String> set2 = set;
        if (set2.isEmpty()) {
            return new byte[0];
        }
        int size = set2.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i10 = 0;
        int i11 = 0;
        for (String str : set2) {
            if (str == null) {
                i10 += 5;
                iArr[i11] = -1;
            } else {
                int iA = q.a(str);
                strArr[i11] = str;
                iArr[i11] = iA;
                i10 = ((iA >> 7) == 0 ? 1 : (iA >> 14) == 0 ? 2 : (iA >> 21) == 0 ? 3 : (iA >> 28) == 0 ? 4 : 5) + iA + i10;
            }
            i11++;
        }
        q qVar = new q(i10);
        for (int i12 = 0; i12 < size; i12++) {
            int i13 = iArr[i12];
            int i14 = qVar.f4027b;
            int i15 = i13;
            while (true) {
                int i16 = i15 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
                bArr = qVar.f4026a;
                if (i16 == 0) {
                    break;
                }
                bArr[i14] = (byte) ((i15 & 127) | 128);
                i15 >>>= 7;
                i14++;
            }
            bArr[i14] = (byte) i15;
            qVar.f4027b = i14 + 1;
            if (i13 >= 0) {
                qVar.b(strArr[i12]);
            }
        }
        return qVar.f4026a;
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.a
    public final String a() {
        return "StringSet";
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.a
    public final /* synthetic */ Set<String> a(byte[] bArr, int i10, int i11) {
        int i12;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i11 > 0) {
            q qVar = new q(bArr, i10);
            int i13 = i10 + i11;
            while (true) {
                i12 = qVar.f4027b;
                if (i12 >= i13) {
                    break;
                }
                byte[] bArr2 = qVar.f4026a;
                int i14 = i12 + 1;
                qVar.f4027b = i14;
                int i15 = bArr2[i12];
                if ((i15 >> 7) != 0) {
                    int i16 = i12 + 2;
                    qVar.f4027b = i16;
                    i15 = (i15 & 127) | (bArr2[i14] << 7);
                    if ((i15 >> 14) != 0) {
                        int i17 = i15 & 16383;
                        int i18 = i12 + 3;
                        qVar.f4027b = i18;
                        int i19 = i17 | (bArr2[i16] << 14);
                        if ((i19 >> 21) == 0) {
                            i15 = i19;
                        } else {
                            int i20 = i12 + 4;
                            qVar.f4027b = i20;
                            i15 = (bArr2[i18] << 21) | (i19 & 2097151);
                            if ((i15 >> 28) != 0) {
                                qVar.f4027b = i12 + 5;
                                i15 = (268435455 & i15) | (bArr2[i20] << 28);
                            }
                        }
                    }
                }
                linkedHashSet.add(qVar.a(i15));
            }
            if (i12 != i13) {
                com.google.gson.internal.a.n("Invalid String set");
                return null;
            }
        }
        return linkedHashSet;
    }
}
