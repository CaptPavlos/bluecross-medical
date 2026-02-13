package com.mbridge.msdk.foundation.download.core;

import android.text.TextUtils;
import com.google.gson.internal.a;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.af;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class DownloaderReporter {
    private static final String KEY = "key=";
    private static final String TAG = "DownloaderReporter";
    private final Map<String, String> _params;
    private final String _reportKey;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Builder {
        private final Map<String, String> _params;
        private final String _reportKey;

        public Builder(String str) {
            if (TextUtils.isEmpty(str)) {
                a.n("reportKey can not be empty");
                throw null;
            }
            this._reportKey = str;
            this._params = new HashMap();
        }

        public Builder add(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    this._params.put(str, str2);
                } catch (Exception unused) {
                }
            }
            return this;
        }

        public DownloaderReporter build() {
            return new DownloaderReporter(this);
        }
    }

    private DownloaderReporter(Builder builder) {
        this._reportKey = builder._reportKey;
        this._params = builder._params;
    }

    private void addUrlParams(Map<String, String> map, JSONObject jSONObject) throws JSONException {
        if (map == null || map.isEmpty() || jSONObject == null) {
            return;
        }
        try {
            for (String str : map.keySet()) {
                jSONObject.put(str, encodeValue(map.get(str)));
            }
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    private String encodeValue(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception unused) {
            return str;
        }
    }

    public final void report() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KEY, this._reportKey);
            addUrlParams(this._params, jSONObject);
            d.a().a(jSONObject);
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }
}
