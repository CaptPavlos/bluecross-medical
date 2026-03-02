package com.mbridge.msdk.newreward.function.common;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.FastKV;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class MBridgeSharedPreferenceModel {
    private static final String DEFAULT_NAME = "mbridge_new_config";
    private volatile FastKV mFastKV;
    private final String mName;
    private static final ConcurrentHashMap<String, String> mStringCache = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Integer> mIntegerCache = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Long> mLongCache = new ConcurrentHashMap<>();
    private static final Map<String, MBridgeSharedPreferenceModel> mInstanceMap = new HashMap();
    private static final String mPath = e.a(c.MBRIDGE_700_CONFIG) + File.separator;

    private MBridgeSharedPreferenceModel(String str) {
        this.mName = str;
        initFastKV();
    }

    public static MBridgeSharedPreferenceModel getInstance(String str) {
        MBridgeSharedPreferenceModel mBridgeSharedPreferenceModel;
        Map<String, MBridgeSharedPreferenceModel> map = mInstanceMap;
        synchronized (map) {
            try {
                if (TextUtils.isEmpty(str)) {
                    str = DEFAULT_NAME;
                }
                mBridgeSharedPreferenceModel = map.get(str);
                if (mBridgeSharedPreferenceModel == null) {
                    mBridgeSharedPreferenceModel = new MBridgeSharedPreferenceModel(str);
                    map.put(str, mBridgeSharedPreferenceModel);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mBridgeSharedPreferenceModel;
    }

    private int getIntegerValue(String str, int i10) {
        if (this.mFastKV == null) {
            initFastKV();
        }
        try {
            int i11 = this.mFastKV.getInt(str, i10);
            mIntegerCache.put(str, Integer.valueOf(i11));
            return i11;
        } catch (Exception unused) {
            return i10;
        }
    }

    private long getLongValue(String str, long j10) {
        if (this.mFastKV == null) {
            initFastKV();
        }
        try {
            long j11 = this.mFastKV.getLong(str, j10);
            mLongCache.put(str, Long.valueOf(j11));
            return j11;
        } catch (Exception unused) {
            return j10;
        }
    }

    private String getStringValue(String str, String str2) {
        if (this.mFastKV == null) {
            initFastKV();
        }
        String string = this.mFastKV.getString(str, str2);
        if (string != null) {
            mStringCache.put(str, string);
        }
        return string;
    }

    private void initFastKV() {
        if (this.mFastKV == null) {
            try {
                this.mFastKV = new FastKV.Builder(mPath, this.mName).build();
            } catch (Exception unused) {
            }
        }
    }

    private void putIntegerValue(String str, int i10) {
        try {
            mIntegerCache.put(str, Integer.valueOf(i10));
        } catch (Exception unused) {
        }
        try {
            this.mFastKV.putInt(str, i10);
        } catch (Exception unused2) {
        }
    }

    private void putLongValue(String str, long j10) {
        try {
            mLongCache.put(str, Long.valueOf(j10));
        } catch (Exception unused) {
        }
        try {
            this.mFastKV.putLong(str, j10);
        } catch (Exception unused2) {
        }
    }

    private void putStringValue(String str, String str2) {
        try {
            mStringCache.put(str, str2);
            this.mFastKV.putString(str, str2);
        } catch (Exception unused) {
        }
    }

    public final void clear() {
        mStringCache.clear();
        mIntegerCache.clear();
        mLongCache.clear();
        if (this.mFastKV != null) {
            this.mFastKV.clear();
        }
    }

    public final int getInteger(String str, int i10) {
        Integer num;
        if (TextUtils.isEmpty(str)) {
            return i10;
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap = mIntegerCache;
        return (!concurrentHashMap.containsKey(str) || (num = concurrentHashMap.get(str)) == null) ? getIntegerValue(str, i10) : num.intValue();
    }

    public final long getLong(String str, long j10) {
        Long l10;
        if (TextUtils.isEmpty(str)) {
            return j10;
        }
        ConcurrentHashMap<String, Long> concurrentHashMap = mLongCache;
        return (!concurrentHashMap.containsKey(str) || (l10 = concurrentHashMap.get(str)) == null) ? getLongValue(str, j10) : l10.longValue();
    }

    public final String getString(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = mStringCache;
        return concurrentHashMap.containsKey(str) ? concurrentHashMap.get(str) : getStringValue(str, str2);
    }

    public final void putInteger(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap = mIntegerCache;
        if (!concurrentHashMap.containsKey(str)) {
            putIntegerValue(str, i10);
            return;
        }
        Integer num = concurrentHashMap.get(str);
        if (num == null || num.intValue() != i10) {
            putIntegerValue(str, i10);
        }
    }

    public final void putLong(String str, long j10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ConcurrentHashMap<String, Long> concurrentHashMap = mLongCache;
        if (!concurrentHashMap.containsKey(str)) {
            putLongValue(str, j10);
            return;
        }
        Long l10 = concurrentHashMap.get(str);
        if (l10 == null || l10.longValue() != j10) {
            putLongValue(str, j10);
        }
    }

    public final void putString(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = mStringCache;
        if (!concurrentHashMap.containsKey(str)) {
            putStringValue(str, str2);
        } else {
            if (TextUtils.equals(concurrentHashMap.get(str), str2)) {
                return;
            }
            putStringValue(str, str2);
        }
    }

    public final void init() {
    }

    public static MBridgeSharedPreferenceModel getInstance() {
        return getInstance("");
    }
}
