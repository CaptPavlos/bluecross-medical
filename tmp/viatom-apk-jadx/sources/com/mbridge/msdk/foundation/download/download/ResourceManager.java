package com.mbridge.msdk.foundation.download.download;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.d;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aq;
import java.io.File;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class ResourceManager {
    public static final int EXPIRE_TIME = 259200000;
    public static final String KEY_INDEX_HTML = "foldername";
    public static final String KEY_MD5CHECK = "nc";
    public static final String KEY_MD5FILENAME = "md5filename";
    private static String TAG = "ResourceManager";
    private String mFileSaveSDDir;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ResourceManagerHolder {
        public static ResourceManager instance = new ResourceManager();

        private ResourceManagerHolder() {
        }
    }

    private ResourceManager() {
        init();
    }

    public static ResourceManager getinstance() {
        return ResourceManagerHolder.instance;
    }

    private String save(String str, String str2, File file) throws Throwable {
        String strB = ad.b(str2, this.mFileSaveSDDir + "/" + SameMD5.getMD5(aq.b(str)));
        return TextUtils.isEmpty(strB) ? ad.a(file) : strB;
    }

    public void cleanZipRes() {
        try {
            if (TextUtils.isEmpty(this.mFileSaveSDDir)) {
                return;
            }
            DownloadTask.getInstance().runTask(new a() { // from class: com.mbridge.msdk.foundation.download.download.ResourceManager.1
                @Override // com.mbridge.msdk.foundation.same.e.a
                public void runTask() {
                    ad.a(ResourceManager.this.mFileSaveSDDir);
                }

                @Override // com.mbridge.msdk.foundation.same.e.a
                public void cancelTask() {
                }

                @Override // com.mbridge.msdk.foundation.same.e.a
                public void pauseTask(boolean z9) {
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public String getResDirFromCampaign(String str) {
        String strSubstring;
        try {
            String str2 = this.mFileSaveSDDir + "/" + SameMD5.getMD5(aq.b(str));
            List<String> queryParameters = Uri.parse(str).getQueryParameters(KEY_INDEX_HTML);
            af.a(TAG, "check zip 下载情况：url:" + str);
            af.a(TAG, "check zip 下载情况：indexHtml:" + queryParameters);
            if (queryParameters == null || queryParameters.size() <= 0) {
                return null;
            }
            String str3 = queryParameters.get(0);
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            String str4 = str2 + "/" + str3 + "/" + str3 + ".html";
            if (!ad.d(str4)) {
                return null;
            }
            g gVarB = h.a().b(c.m().k());
            if (gVarB != null && !TextUtils.isEmpty(gVarB.W())) {
                d.a(str, new File(str4));
            }
            try {
                strSubstring = str.substring(str.indexOf("?") + 1);
            } catch (Exception unused) {
                strSubstring = "";
            }
            return "file://" + str4 + (TextUtils.isEmpty(strSubstring) ? "" : "?".concat(strSubstring));
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    public void init() {
        this.mFileSaveSDDir = e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_RES);
    }

    public synchronized String saveResFile(String str, byte[] bArr) {
        String message;
        String strSave = "unknow exception ";
        if (bArr != null) {
            try {
                try {
                    if (bArr.length > 0) {
                        String str2 = this.mFileSaveSDDir + "/" + SameMD5.getMD5(aq.b(str)) + ".zip";
                        File file = new File(str2);
                        if (ad.a(bArr, file)) {
                            Uri uri = Uri.parse(str);
                            List<String> queryParameters = uri.getQueryParameters(KEY_MD5CHECK);
                            if (queryParameters == null || queryParameters.size() == 0) {
                                List<String> queryParameters2 = uri.getQueryParameters(KEY_MD5FILENAME);
                                if (queryParameters2 != null && queryParameters2.size() > 0) {
                                    String str3 = queryParameters2.get(0);
                                    if (!TextUtils.isEmpty(str3) && str3.equals(ac.a(file))) {
                                        strSave = save(str, str2, file);
                                    }
                                }
                            } else {
                                strSave = save(str, str2, file);
                            }
                        }
                        if (!TextUtils.isEmpty(strSave)) {
                            ad.a(file);
                        }
                    }
                    message = strSave;
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                    message = e.getMessage();
                }
            } catch (Throwable th) {
                throw th;
            }
        } else {
            message = strSave;
        }
        return message;
    }
}
