package com.mbridge.msdk.foundation.download.utils;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.af;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class UnzipUtility {
    private static final int BUFFER_SIZE = 4096;
    private static final String TAG = "UnzipUtility";

    private void extractFile(ZipInputStream zipInputStream, String str) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i10 = zipInputStream.read(bArr);
                if (i10 == -1) {
                    bufferedOutputStream.close();
                    return;
                }
                bufferedOutputStream.write(bArr, 0, i10);
            }
        } catch (IOException e3) {
            e = e3;
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                bufferedOutputStream2.close();
            }
            throw th;
        }
    }

    public int unzip(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        String canonicalPath;
        if (str == null || str2 == null) {
            return -1;
        }
        if (!str2.endsWith("/")) {
            str2 = str2.concat("/");
        }
        File file = new File(str);
        if (!file.exists()) {
            return 1;
        }
        InputStream inputStream = null;
        try {
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            fileOutputStream = null;
            while (enumerationEntries.hasMoreElements()) {
                try {
                    try {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        if (zipEntryNextElement == null) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e) {
                                    af.b(TAG, e.getMessage());
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                    af.b(TAG, e3.getMessage());
                                }
                            }
                            return 2;
                        }
                        String name = zipEntryNextElement.getName();
                        if (!TextUtils.isEmpty(name) && !name.startsWith("..") && !name.startsWith("../")) {
                            File file2 = new File(str2 + name);
                            try {
                                canonicalPath = file2.getCanonicalPath();
                            } catch (IOException unused) {
                                canonicalPath = "";
                            }
                            if (!TextUtils.isEmpty(canonicalPath) && canonicalPath.startsWith(str2) && !canonicalPath.startsWith("..") && !canonicalPath.startsWith("../")) {
                                if (zipEntryNextElement.isDirectory()) {
                                    file2.mkdirs();
                                } else {
                                    if (!file2.getParentFile().exists()) {
                                        file2.getParentFile().mkdirs();
                                    }
                                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                                    try {
                                        inputStream = zipFile.getInputStream(zipEntryNextElement);
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int i10 = inputStream.read(bArr, 0, 1024);
                                            if (i10 == -1) {
                                                break;
                                            }
                                            fileOutputStream2.write(bArr, 0, i10);
                                            fileOutputStream2.flush();
                                        }
                                        fileOutputStream = fileOutputStream2;
                                    } catch (IOException e7) {
                                        e = e7;
                                        fileOutputStream = fileOutputStream2;
                                        af.b(TAG, e.getMessage());
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e10) {
                                                af.b(TAG, e10.getMessage());
                                            }
                                        }
                                        if (fileOutputStream == null) {
                                            return 3;
                                        }
                                        try {
                                            fileOutputStream.close();
                                            return 3;
                                        } catch (IOException e11) {
                                            af.b(TAG, e11.getMessage());
                                            return 3;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        fileOutputStream = fileOutputStream2;
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e12) {
                                                af.b(TAG, e12.getMessage());
                                            }
                                        }
                                        if (fileOutputStream == null) {
                                            throw th;
                                        }
                                        try {
                                            fileOutputStream.close();
                                            throw th;
                                        } catch (IOException e13) {
                                            af.b(TAG, e13.getMessage());
                                            throw th;
                                        }
                                    }
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e14) {
                                    af.b(TAG, e14.getMessage());
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e15) {
                                    af.b(TAG, e15.getMessage());
                                }
                            }
                            return 2;
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e16) {
                                af.b(TAG, e16.getMessage());
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e17) {
                                af.b(TAG, e17.getMessage());
                            }
                        }
                        return 2;
                    } catch (IOException e18) {
                        e = e18;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            zipFile.close();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e19) {
                    af.b(TAG, e19.getMessage());
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e20) {
                    af.b(TAG, e20.getMessage());
                }
            }
            return 0;
        } catch (IOException e21) {
            e = e21;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }
}
