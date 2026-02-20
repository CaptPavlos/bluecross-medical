package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f implements com.mbridge.msdk.newreward.function.command.receiver.e {

    /* renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.command.f f4888a;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.f$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4889a;

        static {
            int[] iArr = new int[com.mbridge.msdk.newreward.function.command.f.values().length];
            f4889a = iArr;
            try {
                iArr[com.mbridge.msdk.newreward.function.command.f.TEMP_PLAYER_INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4889a[com.mbridge.msdk.newreward.function.command.f.TEMP_PLAY_START_COUNT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4889a[com.mbridge.msdk.newreward.function.command.f.TEMP_PLAY_PROGRESS_COUNT_DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public f(com.mbridge.msdk.newreward.function.command.f fVar) {
        this.f4888a = fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object b(java.util.Map r20) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.f.b(java.util.Map):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0157  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.f.a(java.lang.Object):java.lang.Object");
    }

    private Object a(Map map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            try {
                if (!map.isEmpty() && map.containsKey("videoCompleteTime") && (map.get("videoCompleteTime") instanceof Integer)) {
                    int iIntValue = ((Integer) map.get("videoCompleteTime")).intValue();
                    int iA = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 25.0f);
                    int iA2 = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 5.0f);
                    int iA3 = x.a(com.mbridge.msdk.foundation.controller.c.m().c(), iIntValue > 0 ? "mbridge_reward_video_time_count_num_bg" : "mbridge_reward_shape_progress", "drawable");
                    map2.put("width", -2);
                    map2.put("height", Integer.valueOf(iA));
                    map2.put("padding", Integer.valueOf(iA2));
                    map2.put("background", Integer.valueOf(iA3));
                    return map2;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map2;
    }
}
