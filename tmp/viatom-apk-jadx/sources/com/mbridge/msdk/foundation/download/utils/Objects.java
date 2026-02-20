package com.mbridge.msdk.foundation.download.utils;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.ResponseBody;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class Objects {
    public static void closeInputStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (Exception e) {
            af.a("closeStream", e.getLocalizedMessage());
        }
    }

    public static void closeOutputStream(DownloadFileOutputStream downloadFileOutputStream) {
        if (downloadFileOutputStream == null) {
            return;
        }
        try {
            downloadFileOutputStream.close();
        } catch (Exception e) {
            af.a("closeStream", e.getLocalizedMessage());
        }
    }

    public static void closeResponse(Response response) {
        if (response == null) {
            return;
        }
        try {
            if (response.body() != null) {
                response.body().close();
            }
            response.close();
        } catch (Exception e) {
            af.a("closeStream", e.getLocalizedMessage());
        }
    }

    public static void closeResponseBody(ResponseBody responseBody) {
        if (responseBody == null) {
            return;
        }
        try {
            responseBody.close();
        } catch (Exception e) {
            af.a("closeStream", e.getLocalizedMessage());
        }
    }

    private static boolean doubleCheckExists(File file, final String str, final String str2) {
        File[] fileArrListFiles;
        try {
            fileArrListFiles = file.getParentFile().listFiles(new FileFilter() { // from class: com.mbridge.msdk.foundation.download.utils.Objects.1
                @Override // java.io.FileFilter
                public final boolean accept(File file2) {
                    return TextUtils.equals(file2.getAbsolutePath(), str + str2);
                }
            });
        } catch (Exception e) {
            af.a("doubleCheckExists", e.getLocalizedMessage());
            fileArrListFiles = null;
        }
        return fileArrListFiles != null && file.length() > 0;
    }

    public static boolean exists(File file, String str, String str2) {
        if (file == null || TextUtils.isEmpty(str)) {
            return false;
        }
        boolean zExists = file.exists();
        return !zExists ? doubleCheckExists(file, str, str2) : zExists;
    }

    public static int hash(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }
}
