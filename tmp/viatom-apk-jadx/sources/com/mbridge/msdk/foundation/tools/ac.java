package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class ac {

    /* renamed from: b, reason: collision with root package name */
    protected static MessageDigest f3925b;

    /* renamed from: a, reason: collision with root package name */
    protected static char[] f3924a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: c, reason: collision with root package name */
    private static String f3926c = "SameFileMD5";

    static {
        f3925b = null;
        try {
            f3925b = MessageDigest.getInstance(SameMD5.TAG);
        } catch (NoSuchAlgorithmException e) {
            System.err.println(ac.class.getName().concat("初始化失败，MessageDigest不支持MD5Util."));
            e.printStackTrace();
        }
    }

    public static String a(File file) throws IOException {
        MessageDigest messageDigest;
        RandomAccessFile randomAccessFile;
        if (file == null || !file.exists()) {
            return "";
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            messageDigest = MessageDigest.getInstance(SameMD5.TAG);
            randomAccessFile = new RandomAccessFile(file, CampaignEx.JSON_KEY_AD_R);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[10485760];
            while (true) {
                int i10 = randomAccessFile.read(bArr);
                if (i10 == -1) {
                    byte[] bArrDigest = messageDigest.digest();
                    String strA = a(bArrDigest, 0, bArrDigest.length);
                    try {
                        randomAccessFile.close();
                        return strA;
                    } catch (IOException e) {
                        af.b(f3926c, e.getMessage());
                        return strA;
                    }
                }
                messageDigest.update(bArr, 0, i10);
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            try {
                af.b(f3926c, th.getMessage());
                return "";
            } finally {
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e3) {
                        af.b(f3926c, e3.getMessage());
                    }
                }
            }
        }
    }

    private static String a(byte[] bArr, int i10, int i11) {
        StringBuffer stringBuffer = new StringBuffer(i11 * 2);
        int i12 = i11 + i10;
        while (i10 < i12) {
            byte b10 = bArr[i10];
            char[] cArr = f3924a;
            char c10 = cArr[(b10 & 240) >> 4];
            char c11 = cArr[b10 & 15];
            stringBuffer.append(c10);
            stringBuffer.append(c11);
            i10++;
        }
        return stringBuffer.toString();
    }
}
