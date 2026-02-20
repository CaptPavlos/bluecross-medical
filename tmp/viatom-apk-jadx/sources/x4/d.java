package x4;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStatVfs;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.FragmentActivity;
import c1.w4;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.R;
import java.io.File;
import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class d {
    public static File a(Context context) {
        File externalStorageDirectory;
        context.getClass();
        w4 w4Var = new w4(context, 3, false);
        if (w4Var.D()) {
            File[] externalFilesDirs = context.getExternalFilesDirs(null);
            if (externalFilesDirs.length > 1) {
                externalStorageDirectory = externalFilesDirs[1];
            } else {
                File externalStorageDirectory2 = Environment.getExternalStorageDirectory();
                w4Var.P();
                w4Var.O();
                externalStorageDirectory = externalStorageDirectory2;
            }
        } else {
            externalStorageDirectory = Environment.getExternalStorageDirectory();
        }
        if (externalStorageDirectory == null) {
            return context.getExternalFilesDir(null);
        }
        File file = new File(externalStorageDirectory.getAbsolutePath() + '/' + context.getResources().getString(R.string.app_name) + "/Backups");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String b(Uri uri, FragmentActivity fragmentActivity) throws Throwable {
        Uri uri2;
        Throwable th;
        String string = null;
        try {
            try {
                uri2 = uri;
                try {
                    Cursor cursorQuery = fragmentActivity.getContentResolver().query(uri2, null, null, null, null);
                    if (cursorQuery != null) {
                        int columnIndex = cursorQuery.getColumnIndex("_display_name");
                        cursorQuery.moveToFirst();
                        string = cursorQuery.getString(columnIndex);
                        cursorQuery.close();
                    }
                    if (string == null && uri2.getPath() != null) {
                        String path = uri2.getPath();
                        path.getClass();
                        if (e(path)) {
                            return uri2.getLastPathSegment();
                        }
                    }
                    return string;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    if (string != null || uri2.getPath() == null) {
                        return string;
                    }
                    String path2 = uri2.getPath();
                    path2.getClass();
                    return e(path2) ? uri2.getLastPathSegment() : string;
                }
            } catch (Throwable th2) {
                th = th2;
                th = th;
                if (0 == 0 || uri.getPath() == null) {
                    throw th;
                }
                String path3 = uri.getPath();
                path3.getClass();
                if (!e(path3)) {
                    throw th;
                }
                uri.getLastPathSegment();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            uri2 = uri;
        } catch (Throwable th3) {
            th = th3;
            th = th;
            if (0 == 0) {
                throw th;
            }
            throw th;
        }
    }

    public static long c(Context context, DocumentFile documentFile) throws IOException, ErrnoException {
        context.getClass();
        documentFile.getClass();
        Uri uri = documentFile.getUri();
        uri.getClass();
        long j10 = 0;
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, CampaignEx.JSON_KEY_AD_R);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                return 0L;
            }
            StructStatVfs structStatVfsFstatvfs = Os.fstatvfs(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
            j10 = structStatVfsFstatvfs.f_bsize * structStatVfsFstatvfs.f_bavail;
            parcelFileDescriptorOpenFileDescriptor.close();
            return j10;
        } catch (Exception e) {
            e.printStackTrace();
            return j10;
        }
    }

    public static long d(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
    }

    public static boolean e(String str) {
        return o7.u.X(str, ".apk", true) || o7.u.X(str, ".xapk", true) || o7.u.X(str, ".apks", true) || o7.u.X(str, ".apkm", true);
    }
}
