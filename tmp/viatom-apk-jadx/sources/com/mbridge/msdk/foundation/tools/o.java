package com.mbridge.msdk.foundation.tools;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    static final List<String> f4018a;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface a {
        void a(String str, DownloadError downloadError);

        void a(String str, String str2, String str3, String str4, boolean z9);
    }

    static {
        ArrayList arrayList = new ArrayList(4);
        f4018a = arrayList;
        arrayList.add("mbridge_splash_native_template_v_v1.xml");
        arrayList.add("mbridge_splash_native_template_h_v1.xml");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x008a, code lost:
    
        if (r17 != 5) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(int r17, java.lang.String r18, final java.lang.String r19, final com.mbridge.msdk.foundation.tools.o.a r20, com.mbridge.msdk.foundation.entity.CampaignEx r21) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.o.a(int, java.lang.String, java.lang.String, com.mbridge.msdk.foundation.tools.o$a, com.mbridge.msdk.foundation.entity.CampaignEx):void");
    }

    private static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String path = new URL(str).getPath();
                String strSubstring = path.substring(path.lastIndexOf(47) + 1);
                if (!TextUtils.isEmpty(strSubstring)) {
                    String strReplace = strSubstring.replace(".zip", "");
                    List<String> list = f4018a;
                    if (list != null) {
                        if (!list.contains(strReplace)) {
                            return strReplace;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return "";
    }

    private static String b(int i10, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                String path = new URL(str2).getPath();
                String strSubstring = path.substring(path.lastIndexOf(47) + 1);
                if (!TextUtils.isEmpty(strSubstring)) {
                    return strSubstring.replace(".zip", "");
                }
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String a(int i10, String str, String str2) {
        String strB;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            strB = b(i10, str, str2);
        } catch (Exception unused) {
            strB = "";
        }
        String str3 = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_XML) + File.separator;
        File file = null;
        try {
            if (!TextUtils.isEmpty(strB)) {
                file = new File(str3, strB);
            }
        } catch (Exception unused2) {
        }
        if (file == null || !file.exists()) {
            file = new File(a3.a.o(a3.a.v(str3), File.separator, strB.replace(".xml", "")), strB);
        }
        return file.getPath();
    }

    public static String a(String str) {
        String strB;
        final String str2;
        File file;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String queryParameter = Uri.parse(str).getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_NATMP);
            if (!TextUtils.isEmpty(queryParameter)) {
                if (!queryParameter.equals("1")) {
                    return "";
                }
            }
        } catch (Throwable unused) {
        }
        try {
            strB = b(str);
        } catch (Exception unused2) {
            strB = "";
        }
        if (TextUtils.isEmpty(strB)) {
            return "";
        }
        try {
            str2 = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_XML) + File.separator;
            file = new File(str2, strB);
        } catch (Exception unused3) {
        }
        if (file.isFile() && file.exists()) {
            return file.getPath();
        }
        String path = new URL(str).getPath();
        final String strSubstring = path.substring(path.lastIndexOf(47) + 1);
        MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str, strSubstring, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER)).withReadTimeout(com.mbridge.msdk.foundation.same.a.f3616u).withConnectTimeout(com.mbridge.msdk.foundation.same.a.f3611o).with("download_scene", "download_dynamic_view").withWriteTimeout(com.mbridge.msdk.foundation.same.a.f3615s).withTimeout(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS).withDownloadPriority(DownloadPriority.MEDIUM).withHttpRetryCounter(1).withDirectoryPathInternal(str2).withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.foundation.tools.o.2
            @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
            public final void onDownloadComplete(DownloadMessage downloadMessage) {
                try {
                    MBResourceManager.getInstance().unZip(str2 + File.separator + strSubstring, str2);
                } catch (Exception unused4) {
                }
            }

            @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
            public final void onCancelDownload(DownloadMessage downloadMessage) {
            }

            @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
            public final void onDownloadStart(DownloadMessage downloadMessage) {
            }

            @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
            public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
            }
        }).build().start();
        return "";
    }
}
