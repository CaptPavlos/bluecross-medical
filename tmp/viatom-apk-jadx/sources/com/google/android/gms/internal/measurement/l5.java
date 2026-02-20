package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.uptodown.R;
import com.uptodown.activities.MyApps;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class l5 {
    public static String A(Context context) {
        context.getClass();
        String string = null;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("Language")) {
                string = sharedPreferences.getString("Language", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o7.u.b0("https://www.uptodown.com/turbo?platform=android", "www", p(string), false);
    }

    public static String B(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
            messageDigest.update(bArr);
            String string = new BigInteger(1, messageDigest.digest()).toString(16);
            while (string.length() < 32) {
                string = String.format("0%s", Arrays.copyOf(new Object[]{string}, 1));
            }
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static SpannableStringBuilder C(String str, Context context, g5.f fVar) throws Resources.NotFoundException, NumberFormatException {
        str.getClass();
        fVar.getClass();
        int length = 0;
        String strB0 = o7.u.b0(o7.u.b0(str, "<br />", "\n", false), "<br/>", "\n", false);
        List<h5.o> listS = s(strB0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strB0);
        for (h5.o oVar : listS) {
            int i10 = oVar.f8671a;
            String str2 = oVar.e;
            String str3 = oVar.f8674d;
            int i11 = i10 - length;
            int length2 = str3.length() + i11;
            str2.getClass();
            spannableStringBuilder = spannableStringBuilder.replace(i11, str2.length() + i11, (CharSequence) str3);
            spannableStringBuilder.getClass();
            String str4 = oVar.f8672b;
            int iHashCode = str4.hashCode();
            if (iHashCode != 98) {
                if (iHashCode != 105) {
                    if (iHashCode != 117) {
                        if (iHashCode != 93028092) {
                            if (iHashCode != 1524339519) {
                                if (iHashCode != 3274) {
                                    if (iHashCode == 3275 && str4.equals("h3")) {
                                        float dimension = context.getResources().getDimension(R.dimen.text_size_m);
                                        Typeface typeface = o4.b.f11719r;
                                        typeface.getClass();
                                        spannableStringBuilder.setSpan(new v5.e(dimension, typeface, ContextCompat.getColor(context, R.color.text_primary)), i11, length2, 33);
                                    }
                                } else if (str4.equals("h2")) {
                                    float dimension2 = context.getResources().getDimension(R.dimen.text_size_l);
                                    Typeface typeface2 = o4.b.f11719r;
                                    typeface2.getClass();
                                    spannableStringBuilder.setSpan(new v5.e(dimension2, typeface2, ContextCompat.getColor(context, R.color.text_primary)), i11, length2, 33);
                                }
                            } else if (str4.equals("floatingCategoryID")) {
                                spannableStringBuilder.setSpan(new h5.n(oVar, fVar, context, 1), i11, length2, 33);
                            }
                        } else if (str4.equals("appID")) {
                            spannableStringBuilder.setSpan(new h5.n(oVar, fVar, context, 0), i11, length2, 33);
                        }
                    } else if (str4.equals("u")) {
                        spannableStringBuilder.setSpan(new UnderlineSpan(), i11, length2, 33);
                    }
                } else if (str4.equals("i")) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), i11, length2, 33);
                }
            } else if (str4.equals(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                spannableStringBuilder.setSpan(new StyleSpan(1), i11, length2, 33);
            }
            length = (str2.length() + length) - str3.length();
        }
        return spannableStringBuilder;
    }

    public static final ArrayList D(BufferedReader bufferedReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator it = new n7.a(new d7.b(bufferedReader, 0)).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                str.getClass();
                arrayList.add(str);
            }
            bufferedReader.close();
            return arrayList;
        } finally {
        }
    }

    public static final void E(TextView textView) {
        textView.getClass();
        textView.setVisibility(0);
        textView.setBackground(ContextCompat.getDrawable(textView.getContext(), R.drawable.ripple_blue_primary_button));
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.white));
    }

    public static final void F(TextView textView) {
        textView.getClass();
        textView.setVisibility(0);
        textView.setBackground(ContextCompat.getDrawable(textView.getContext(), R.drawable.ripple_open_button));
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.blue_primary));
    }

    public static final void G(TextView textView) {
        textView.getClass();
        textView.setVisibility(0);
        textView.setBackground(ContextCompat.getDrawable(textView.getContext(), R.drawable.ripple_install_button));
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.white));
    }

    public static final void H(TextView textView) {
        textView.getClass();
        textView.setVisibility(0);
        textView.setBackground(ContextCompat.getDrawable(textView.getContext(), R.drawable.ripple_cancel_button));
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.white));
    }

    public static void I(ArrayList arrayList, MyApps myApps) {
        t6.q.W(arrayList, new com.google.android.material.button.a(new e5.u0(9), 7));
        t(arrayList, myApps);
    }

    public static void J(ArrayList arrayList, l4.a4 a4Var) {
        t6.q.W(arrayList, new a6.h(6));
        t(arrayList, a4Var);
    }

    public static void K(ArrayList arrayList, MyApps myApps) {
        t6.q.W(arrayList, new com.google.android.material.button.a(new e5.u0(10), 8));
        t(arrayList, myApps);
    }

    public static final s6.p L(String str) {
        int i10;
        z1.t1.k(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i11 = 0;
        char cCharAt = str.charAt(0);
        if (kotlin.jvm.internal.l.c(cCharAt, 48) < 0) {
            i10 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i10 = 0;
        }
        int i12 = 119304647;
        while (i10 < length) {
            int iDigit = Character.digit((int) str.charAt(i10), 10);
            if (iDigit < 0) {
                return null;
            }
            int i13 = i11 ^ Integer.MIN_VALUE;
            if (Integer.compare(i13, i12 ^ Integer.MIN_VALUE) > 0) {
                if (i12 != 119304647) {
                    return null;
                }
                i12 = (int) (((-1) & 4294967295L) / (4294967295L & 10));
                if (Integer.compare(i13, i12 ^ Integer.MIN_VALUE) > 0) {
                    return null;
                }
            }
            int i14 = i11 * 10;
            int i15 = iDigit + i14;
            if (Integer.compare(i15 ^ Integer.MIN_VALUE, i14 ^ Integer.MIN_VALUE) < 0) {
                return null;
            }
            i10++;
            i11 = i15;
        }
        return new s6.p(i11);
    }

    public static final s6.r M(String str) {
        int i10;
        long j10;
        str.getClass();
        int i11 = 10;
        z1.t1.k(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        char cCharAt = str.charAt(0);
        int i12 = 1;
        if (kotlin.jvm.internal.l.c(cCharAt, 48) >= 0) {
            i10 = 0;
        } else {
            if (length == 1 || cCharAt != '+') {
                return null;
            }
            i10 = 1;
        }
        long j11 = 10;
        long j12 = 0;
        long j13 = 512409557603043100L;
        while (i10 < length) {
            int iDigit = Character.digit((int) str.charAt(i10), i11);
            if (iDigit < 0) {
                return null;
            }
            int i13 = length;
            long j14 = j12 ^ Long.MIN_VALUE;
            int i14 = i10;
            if (Long.compare(j14, j13 ^ Long.MIN_VALUE) <= 0) {
                j10 = j11;
            } else {
                if (j13 != 512409557603043100L) {
                    return null;
                }
                if (j11 >= 0) {
                    long j15 = (Long.MAX_VALUE / j11) << i12;
                    j10 = j11;
                    j13 = j15 + ((((-1) - (j15 * j11)) ^ Long.MIN_VALUE) >= (j11 ^ Long.MIN_VALUE) ? i12 : 0);
                } else if (Long.MAX_VALUE < (j11 ^ Long.MIN_VALUE)) {
                    j10 = j11;
                    j13 = 0;
                } else {
                    j13 = 1;
                    j10 = j11;
                }
                if (Long.compare(j14, j13 ^ Long.MIN_VALUE) > 0) {
                    return null;
                }
            }
            long j16 = j12 * j10;
            long j17 = (iDigit & 4294967295L) + j16;
            if (Long.compare(j17 ^ Long.MIN_VALUE, j16 ^ Long.MIN_VALUE) < 0) {
                return null;
            }
            i10 = i14 + 1;
            j12 = j17;
            length = i13;
            j11 = j10;
            i11 = 10;
            i12 = 1;
        }
        return new s6.r(j12);
    }

    public static l7.d N(int i10, int i11) {
        if (i11 > Integer.MIN_VALUE) {
            return new l7.d(i10, i11 - 1, 1);
        }
        l7.d dVar = l7.d.f11091d;
        return l7.d.f11091d;
    }

    public static void O(Parcel parcel, Parcelable parcelable, int i10) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, i10);
        }
    }

    public static int P(int i10) {
        int[] iArr = {1, 2, 3};
        for (int i11 = 0; i11 < 3; i11++) {
            int i12 = iArr[i11];
            int i13 = i12 - 1;
            if (i12 == 0) {
                throw null;
            }
            if (i13 == i10) {
                return i12;
            }
        }
        return 1;
    }

    public static int Q(byte[] bArr, int i10, x4 x4Var) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 < 0) {
            return R(b10, bArr, i11, x4Var);
        }
        x4Var.f2257a = b10;
        return i11;
    }

    public static int R(int i10, byte[] bArr, int i11, x4 x4Var) {
        byte b10 = bArr[i11];
        int i12 = i11 + 1;
        int i13 = i10 & 127;
        if (b10 >= 0) {
            x4Var.f2257a = i13 | (b10 << 7);
            return i12;
        }
        int i14 = i13 | ((b10 & 127) << 7);
        int i15 = i11 + 2;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            x4Var.f2257a = i14 | (b11 << 14);
            return i15;
        }
        int i16 = i14 | ((b11 & 127) << 14);
        int i17 = i11 + 3;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            x4Var.f2257a = i16 | (b12 << 21);
            return i17;
        }
        int i18 = i16 | ((b12 & 127) << 21);
        int i19 = i11 + 4;
        byte b13 = bArr[i17];
        if (b13 >= 0) {
            x4Var.f2257a = i18 | (b13 << 28);
            return i19;
        }
        int i20 = i18 | ((b13 & 127) << 28);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] >= 0) {
                x4Var.f2257a = i20;
                return i21;
            }
            i19 = i21;
        }
    }

    public static g5 S() {
        String str;
        ClassLoader classLoader = l5.class.getClassLoader();
        if (g5.class.equals(g5.class)) {
            str = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
        } else {
            if (!g5.class.getPackage().equals(l5.class.getPackage())) {
                com.google.gson.internal.a.n(g5.class.getName());
                return null;
            }
            str = g5.class.getPackage().getName() + ".BlazeGenerated" + g5.class.getSimpleName() + "Loader";
        }
        try {
            try {
                try {
                    try {
                        com.mbridge.msdk.dycreator.baseview.a.s(Class.forName(str, true, classLoader).getConstructor(null).newInstance(null));
                        throw null;
                    } catch (InvocationTargetException e) {
                        throw new IllegalStateException(e);
                    }
                } catch (NoSuchMethodException e3) {
                    throw new IllegalStateException(e3);
                }
            } catch (IllegalAccessException e7) {
                throw new IllegalStateException(e7);
            } catch (InstantiationException e10) {
                throw new IllegalStateException(e10);
            }
        } catch (ClassNotFoundException unused) {
            try {
                Iterator it = Arrays.asList(new l5[0]).iterator();
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    try {
                        if (it.next() == null) {
                            throw null;
                        }
                        throw new ClassCastException();
                    } catch (ServiceConfigurationError e11) {
                        Logger.getLogger(d5.class.getName()).logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(g5.class.getSimpleName()), (Throwable) e11);
                    }
                }
                if (arrayList.size() == 1) {
                    return (g5) arrayList.get(0);
                }
                if (arrayList.size() == 0) {
                    return null;
                }
                try {
                    return (g5) g5.class.getMethod("combine", Collection.class).invoke(null, arrayList);
                } catch (IllegalAccessException e12) {
                    throw new IllegalStateException(e12);
                } catch (NoSuchMethodException e13) {
                    throw new IllegalStateException(e13);
                } catch (InvocationTargetException e14) {
                    throw new IllegalStateException(e14);
                }
            } catch (Throwable th) {
                throw new ServiceConfigurationError(th.getMessage(), th);
            }
        }
    }

    public static int T(byte[] bArr, int i10, x4 x4Var) {
        long j10 = bArr[i10];
        int i11 = i10 + 1;
        if (j10 >= 0) {
            x4Var.f2258b = j10;
            return i11;
        }
        int i12 = i10 + 2;
        byte b10 = bArr[i11];
        long j11 = (j10 & 127) | ((b10 & 127) << 7);
        int i13 = 7;
        while (b10 < 0) {
            int i14 = i12 + 1;
            i13 += 7;
            j11 |= (r10 & 127) << i13;
            b10 = bArr[i12];
            i12 = i14;
        }
        x4Var.f2258b = j11;
        return i12;
    }

    public static int U(int i10, byte[] bArr) {
        int i11 = bArr[i10] & 255;
        int i12 = bArr[i10 + 1] & 255;
        int i13 = bArr[i10 + 2] & 255;
        return ((bArr[i10 + 3] & 255) << 24) | (i12 << 8) | i11 | (i13 << 16);
    }

    public static long V(int i10, byte[] bArr) {
        return (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48) | ((bArr[i10 + 7] & 255) << 56);
    }

    public static int W(byte[] bArr, int i10, x4 x4Var) throws w5 {
        int iQ = Q(bArr, i10, x4Var);
        int i11 = x4Var.f2257a;
        if (i11 < 0) {
            androidx.window.layout.c.m("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return 0;
        }
        if (i11 == 0) {
            x4Var.f2259c = "";
            return iQ;
        }
        int i12 = c7.f1905a;
        int length = bArr.length;
        if ((((length - iQ) - i11) | iQ | i11) < 0) {
            androidx.core.view.accessibility.a.o("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(iQ), Integer.valueOf(i11)});
            return 0;
        }
        int i13 = iQ + i11;
        char[] cArr = new char[i11];
        int i14 = 0;
        while (iQ < i13) {
            byte b10 = bArr[iQ];
            if (b10 < 0) {
                break;
            }
            iQ++;
            cArr[i14] = (char) b10;
            i14++;
        }
        while (iQ < i13) {
            int i15 = iQ + 1;
            byte b11 = bArr[iQ];
            if (b11 >= 0) {
                cArr[i14] = (char) b11;
                i14++;
                iQ = i15;
                while (iQ < i13) {
                    byte b12 = bArr[iQ];
                    if (b12 >= 0) {
                        iQ++;
                        cArr[i14] = (char) b12;
                        i14++;
                    }
                }
            } else if (b11 < -32) {
                if (i15 >= i13) {
                    androidx.window.layout.c.m("Protocol message had invalid UTF-8.");
                    return 0;
                }
                int i16 = i14 + 1;
                iQ += 2;
                byte b13 = bArr[i15];
                if (b11 < -62 || z1.t1.W(b13)) {
                    androidx.window.layout.c.m("Protocol message had invalid UTF-8.");
                    return 0;
                }
                cArr[i14] = (char) ((b13 & 63) | ((b11 & 31) << 6));
                i14 = i16;
            } else {
                if (b11 < -16) {
                    if (i15 >= i13 - 1) {
                        androidx.window.layout.c.m("Protocol message had invalid UTF-8.");
                        return 0;
                    }
                    int i17 = i14 + 1;
                    int i18 = iQ + 2;
                    byte b14 = bArr[i15];
                    iQ += 3;
                    byte b15 = bArr[i18];
                    if (!z1.t1.W(b14)) {
                        if (b11 == -32) {
                            if (b14 >= -96) {
                                b11 = -32;
                            }
                        }
                        if (b11 == -19) {
                            if (b14 < -96) {
                                b11 = -19;
                            }
                        }
                        if (!z1.t1.W(b15)) {
                            cArr[i14] = (char) (((b14 & 63) << 6) | ((b11 & 15) << 12) | (b15 & 63));
                            i14 = i17;
                        }
                    }
                    androidx.window.layout.c.m("Protocol message had invalid UTF-8.");
                    return 0;
                }
                if (i15 >= i13 - 2) {
                    androidx.window.layout.c.m("Protocol message had invalid UTF-8.");
                    return 0;
                }
                byte b16 = bArr[i15];
                int i19 = iQ + 3;
                byte b17 = bArr[iQ + 2];
                iQ += 4;
                byte b18 = bArr[i19];
                if (z1.t1.W(b16) || (((b16 + 112) + (b11 << 28)) >> 30) != 0 || z1.t1.W(b17) || z1.t1.W(b18)) {
                    androidx.window.layout.c.m("Protocol message had invalid UTF-8.");
                    return 0;
                }
                int i20 = ((b16 & 63) << 12) | ((b11 & 7) << 18) | ((b17 & 63) << 6) | (b18 & 63);
                cArr[i14] = (char) ((i20 >>> 10) + 55232);
                cArr[i14 + 1] = (char) ((i20 & 1023) + 56320);
                i14 += 2;
            }
        }
        x4Var.f2259c = new String(cArr, 0, i14);
        return i13;
    }

    public static int X(byte[] bArr, int i10, x4 x4Var) throws w5 {
        int iQ = Q(bArr, i10, x4Var);
        int i11 = x4Var.f2257a;
        if (i11 < 0) {
            androidx.window.layout.c.m("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return 0;
        }
        if (i11 > bArr.length - iQ) {
            androidx.window.layout.c.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        if (i11 == 0) {
            x4Var.f2259c = c5.f1900c;
            return iQ;
        }
        x4Var.f2259c = c5.e(iQ, i11, bArr);
        return iQ + i11;
    }

    public static int Y(Object obj, p6 p6Var, byte[] bArr, int i10, int i11, x4 x4Var) throws w5 {
        int iR = i10 + 1;
        int i12 = bArr[i10];
        if (i12 < 0) {
            iR = R(i12, bArr, iR, x4Var);
            i12 = x4Var.f2257a;
        }
        int i13 = iR;
        if (i12 < 0 || i12 > i11 - i13) {
            androidx.window.layout.c.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        int i14 = x4Var.f2260d + 1;
        x4Var.f2260d = i14;
        if (i14 >= 100) {
            androidx.window.layout.c.m("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            return 0;
        }
        int i15 = i13 + i12;
        p6Var.h(obj, bArr, i13, i15, x4Var);
        x4Var.f2260d--;
        x4Var.f2259c = obj;
        return i15;
    }

    public static int Z(Object obj, p6 p6Var, byte[] bArr, int i10, int i11, int i12, x4 x4Var) throws w5 {
        i6 i6Var = (i6) p6Var;
        int i13 = x4Var.f2260d + 1;
        x4Var.f2260d = i13;
        if (i13 >= 100) {
            androidx.window.layout.c.m("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            return 0;
        }
        int iT = i6Var.t(obj, bArr, i10, i11, i12, x4Var);
        x4Var.f2260d--;
        x4Var.f2259c = obj;
        return iT;
    }

    public static int a(int i10, String str) {
        str.getClass();
        if (i10 != str.length()) {
            throw new h6.e(kotlin.jvm.internal.l.g(": invalid bit length", "h.g"));
        }
        z1.t1.k(2);
        return Integer.parseInt(str, 2);
    }

    public static int a0(int i10, byte[] bArr, int i11, int i12, t5 t5Var, x4 x4Var) {
        p5 p5Var = (p5) t5Var;
        int iQ = Q(bArr, i11, x4Var);
        p5Var.e(x4Var.f2257a);
        while (iQ < i12) {
            int iQ2 = Q(bArr, iQ, x4Var);
            if (i10 != x4Var.f2257a) {
                break;
            }
            iQ = Q(bArr, iQ2, x4Var);
            p5Var.e(x4Var.f2257a);
        }
        return iQ;
    }

    public static /* synthetic */ String b(int i10) {
        switch (i10) {
            case 1:
                return "BEL";
            case 2:
                return "GRC";
            case 3:
                return "LTU";
            case 4:
                return "PRT";
            case 5:
                return "BGR";
            case 6:
                return "ESP";
            case 7:
                return "LUX";
            case 8:
                return "ROU";
            case 9:
                return "CZE";
            case 10:
                return "FRA";
            case 11:
                return "HUN";
            case 12:
                return "SVN";
            case 13:
                return "DNK";
            case 14:
                return "HRV";
            case 15:
                return "MLT";
            case 16:
                return "SVK";
            case 17:
                return "DEU";
            case 18:
                return "ITA";
            case 19:
                return "NLD";
            case 20:
                return "FIN";
            case 21:
                return "EST";
            case 22:
                return "CYP";
            case 23:
                return "AUT";
            case 24:
                return "SWE";
            case 25:
                return "IRL";
            case 26:
                return "LVA";
            case 27:
                return "POL";
            case 28:
                return "GBR";
            case 29:
                return "CHE";
            case 30:
                return "NOR";
            case 31:
                return "LIE";
            case 32:
                return "ISL";
            default:
                throw null;
        }
    }

    public static int b0(byte[] bArr, int i10, t5 t5Var, x4 x4Var) throws w5 {
        p5 p5Var = (p5) t5Var;
        int iQ = Q(bArr, i10, x4Var);
        int i11 = x4Var.f2257a + iQ;
        while (iQ < i11) {
            iQ = Q(bArr, iQ, x4Var);
            p5Var.e(x4Var.f2257a);
        }
        if (iQ == i11) {
            return iQ;
        }
        androidx.window.layout.c.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return 0;
    }

    public static String c(Number number, int i10) {
        String string;
        number.getClass();
        if ((number instanceof Integer) && number.intValue() >= 0) {
            int iIntValue = number.intValue();
            z1.t1.k(2);
            string = Integer.toString(iIntValue, 2);
            string.getClass();
        } else {
            if (!(number instanceof Long) || number.longValue() < 0) {
                throw new h6.e(kotlin.jvm.internal.l.g(": incorrect format passed", "h.g"));
            }
            long jLongValue = number.longValue();
            z1.t1.k(2);
            string = Long.toString(jLongValue, 2);
            string.getClass();
        }
        if (string.length() <= i10) {
            return o7.m.p0(i10, string);
        }
        throw new h6.e("h.g: " + number + " too large to encode into " + i10);
    }

    public static int c0(p6 p6Var, int i10, byte[] bArr, int i11, int i12, t5 t5Var, x4 x4Var) throws w5 {
        o5 o5VarA = p6Var.a();
        p6 p6Var2 = p6Var;
        byte[] bArr2 = bArr;
        int i13 = i12;
        x4 x4Var2 = x4Var;
        int iY = Y(o5VarA, p6Var2, bArr2, i11, i13, x4Var2);
        p6Var2.g(o5VarA);
        x4Var2.f2259c = o5VarA;
        t5Var.add(o5VarA);
        while (iY < i13) {
            x4 x4Var3 = x4Var2;
            int i14 = i13;
            int iQ = Q(bArr2, iY, x4Var3);
            if (i10 != x4Var3.f2257a) {
                break;
            }
            byte[] bArr3 = bArr2;
            p6 p6Var3 = p6Var2;
            o5 o5VarA2 = p6Var3.a();
            iY = Y(o5VarA2, p6Var3, bArr3, iQ, i14, x4Var3);
            p6Var2 = p6Var3;
            bArr2 = bArr3;
            i13 = i14;
            x4Var2 = x4Var3;
            p6Var2.g(o5VarA2);
            x4Var2.f2259c = o5VarA2;
            t5Var.add(o5VarA2);
        }
        return iY;
    }

    public static Object d(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static int d0(int i10, byte[] bArr, int i11, int i12, v6 v6Var, x4 x4Var) throws w5 {
        if ((i10 >>> 3) == 0) {
            androidx.window.layout.c.m("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            int iT = T(bArr, i11, x4Var);
            v6Var.d(i10, Long.valueOf(x4Var.f2258b));
            return iT;
        }
        if (i13 == 1) {
            v6Var.d(i10, Long.valueOf(V(i11, bArr)));
            return i11 + 8;
        }
        if (i13 == 2) {
            int iQ = Q(bArr, i11, x4Var);
            int i14 = x4Var.f2257a;
            if (i14 < 0) {
                androidx.window.layout.c.m("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                return 0;
            }
            if (i14 > bArr.length - iQ) {
                androidx.window.layout.c.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                return 0;
            }
            if (i14 == 0) {
                v6Var.d(i10, c5.f1900c);
            } else {
                v6Var.d(i10, c5.e(iQ, i14, bArr));
            }
            return iQ + i14;
        }
        if (i13 != 3) {
            if (i13 == 5) {
                v6Var.d(i10, Integer.valueOf(U(i11, bArr)));
                return i11 + 4;
            }
            androidx.window.layout.c.m("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i15 = (i10 & (-8)) | 4;
        v6 v6VarA = v6.a();
        int i16 = x4Var.f2260d + 1;
        x4Var.f2260d = i16;
        if (i16 >= 100) {
            androidx.window.layout.c.m("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            return 0;
        }
        int i17 = 0;
        while (true) {
            if (i11 >= i12) {
                break;
            }
            int iQ2 = Q(bArr, i11, x4Var);
            int i18 = x4Var.f2257a;
            if (i18 == i15) {
                i17 = i18;
                i11 = iQ2;
                break;
            }
            i11 = d0(i18, bArr, iQ2, i12, v6VarA, x4Var);
            i17 = i18;
        }
        x4Var.f2260d--;
        if (i11 > i12 || i17 != i15) {
            androidx.window.layout.c.m("Failed to parse the message.");
            return 0;
        }
        v6Var.d(i10, v6VarA);
        return i11;
    }

    public static final void e(f8.f fVar) {
        fVar.getClass();
        if ((fVar instanceof i8.u ? (i8.u) fVar : null) != null) {
            return;
        }
        com.google.gson.internal.a.l(kotlin.jvm.internal.y.a(fVar.getClass()), "This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got ");
    }

    public static int e0(int i10, byte[] bArr, int i11, int i12, x4 x4Var) throws w5 {
        if ((i10 >>> 3) == 0) {
            androidx.window.layout.c.m("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            return T(bArr, i11, x4Var);
        }
        if (i13 == 1) {
            return i11 + 8;
        }
        if (i13 == 2) {
            return Q(bArr, i11, x4Var) + x4Var.f2257a;
        }
        if (i13 != 3) {
            if (i13 == 5) {
                return i11 + 4;
            }
            androidx.window.layout.c.m("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i14 = (i10 & (-8)) | 4;
        int i15 = 0;
        while (i11 < i12) {
            i11 = Q(bArr, i11, x4Var);
            i15 = x4Var.f2257a;
            if (i15 == i14) {
                break;
            }
            i11 = e0(i15, bArr, i11, i12, x4Var);
        }
        if (i11 <= i12 && i15 == i14) {
            return i11;
        }
        androidx.window.layout.c.m("Failed to parse the message.");
        return 0;
    }

    public static final boolean f(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        bArr.getClass();
        bArr2.getClass();
        for (int i13 = 0; i13 < i12; i13++) {
            if (bArr[i13 + i10] != bArr2[i13 + i11]) {
                return false;
            }
        }
        return true;
    }

    public static final h8.i g(f8.e eVar) {
        eVar.getClass();
        h8.i iVar = eVar instanceof h8.i ? (h8.i) eVar : null;
        if (iVar != null) {
            return iVar;
        }
        com.google.gson.internal.a.l(kotlin.jvm.internal.y.a(eVar.getClass()), "This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got ");
        return null;
    }

    public static void j(int i10, String str) {
        if (i10 >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(str.length() + 40);
        sb.append(str);
        sb.append(" cannot be negative but was: ");
        sb.append(i10);
        throw new IllegalArgumentException(sb.toString());
    }

    public static final void k(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            StringBuilder sbX = a3.a.x("size=", " offset=", j10);
            sbX.append(j11);
            sbX.append(" byteCount=");
            sbX.append(j12);
            throw new ArrayIndexOutOfBoundsException(sbX.toString());
        }
    }

    public static float m(float f, float f10, float f11) {
        if (f10 <= f11) {
            return f < f10 ? f10 : f > f11 ? f11 : f;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f11 + " is less than minimum " + f10 + '.');
    }

    public static long n(long j10, long j11, long j12) {
        if (j11 <= j12) {
            return j10 < j11 ? j11 : j10 > j12 ? j12 : j10;
        }
        StringBuilder sbX = a3.a.x("Cannot coerce value to an empty range: maximum ", " is less than minimum ", j12);
        sbX.append(j11);
        sbX.append('.');
        throw new IllegalArgumentException(sbX.toString());
    }

    public static byte[] o(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        byte[] bytes = str.getBytes(o7.a.f11749a);
        bytes.getClass();
        gZIPOutputStream.write(bytes);
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        byteArray.getClass();
        return byteArray;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d0 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String p(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.l5.p(java.lang.String):java.lang.String");
    }

    public static boolean q(String str) {
        if (str.equals("1")) {
            return true;
        }
        if (str.equals("0")) {
            return false;
        }
        throw new o3.a(androidx.constraintlayout.core.widgets.analyzer.a.x("Undecodable Boolean '", str, "'"));
    }

    public static String r(Boolean bool) {
        if (bool.booleanValue()) {
            return "1";
        }
        if (!bool.booleanValue()) {
            return "0";
        }
        throw new u6("Unencodable Boolean '" + bool + "'");
    }

    public static List s(String str) throws NumberFormatException {
        ArrayList arrayList = new ArrayList();
        n7.e eVar = new n7.e(o7.k.a(new o7.k("\\[(\\w+)=([\\w\\d]*)](.*?)\\[/(\\w+)]"), str));
        while (eVar.hasNext()) {
            o7.i iVar = (o7.i) eVar.next();
            int i10 = iVar.b().f11084a;
            String str2 = (String) ((o7.h) iVar.a()).get(1);
            long j10 = Long.parseLong((String) ((o7.h) iVar.a()).get(2));
            String str3 = (String) ((o7.h) iVar.a()).get(3);
            Long lValueOf = Long.valueOf(j10);
            String strGroup = iVar.f11768a.group();
            strGroup.getClass();
            arrayList.add(new h5.o(i10, str2, lValueOf, str3, strGroup));
        }
        n7.e eVar2 = new n7.e(o7.k.a(new o7.k("\\[url=([^\\]]+)](.*?)\\[/url]"), str));
        while (eVar2.hasNext()) {
            o7.i iVar2 = (o7.i) eVar2.next();
            int i11 = iVar2.b().f11084a;
            String str4 = (String) ((o7.h) iVar2.a()).get(0);
            String str5 = (String) ((o7.h) iVar2.a()).get(1);
            String str6 = (String) ((o7.h) iVar2.a()).get(2);
            String strGroup2 = iVar2.f11768a.group();
            strGroup2.getClass();
            h5.o oVar = new h5.o(i11, str4, str6, strGroup2);
            oVar.f = str5;
            arrayList.add(oVar);
        }
        n7.e eVar3 = new n7.e(o7.k.a(new o7.k("<(\\w+)>(.*?)</(\\w+)>"), str));
        while (eVar3.hasNext()) {
            o7.i iVar3 = (o7.i) eVar3.next();
            int i12 = iVar3.b().f11084a;
            String str7 = (String) ((o7.h) iVar3.a()).get(1);
            String str8 = (String) ((o7.h) iVar3.a()).get(2);
            String strGroup3 = iVar3.f11768a.group();
            strGroup3.getClass();
            arrayList.add(new h5.o(i12, str7, str8, strGroup3));
        }
        return t6.l.n0(arrayList, new a9.i(4));
    }

    public static void t(ArrayList arrayList, l4.a4 a4Var) {
        h5.e eVar;
        v5.g gVarL = v5.g.f13148u.l(a4Var);
        gVarL.a();
        ArrayList arrayListO = gVarL.O();
        gVarL.b();
        Iterator it = arrayListO.iterator();
        it.getClass();
        while (true) {
            boolean zHasNext = it.hasNext();
            eVar = h5.e.f8506a;
            if (!zHasNext) {
                break;
            }
            Object next = it.next();
            next.getClass();
            h5.y0 y0Var = (h5.y0) next;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                long j10 = ((h5.f) arrayList.get(i10)).f8527d;
                if (o7.u.Z(y0Var.f8795b, ((h5.f) arrayList.get(i10)).f8526c, true) && y0Var.f8796c > j10) {
                    h5.f fVar = (h5.f) arrayList.get(i10);
                    fVar.getClass();
                    fVar.g = eVar;
                }
            }
        }
        int size2 = arrayList.size();
        int i11 = 0;
        while (i11 < size2) {
            Object obj = arrayList.get(i11);
            i11++;
            h5.f fVar2 = (h5.f) obj;
            int size3 = arrayListO.size();
            int i12 = 0;
            while (i12 < size3) {
                Object obj2 = arrayListO.get(i12);
                i12++;
                h5.y0 y0Var2 = (h5.y0) obj2;
                if (fVar2.f8532m == 1 || (kotlin.jvm.internal.l.a(fVar2.f8526c, y0Var2.f8795b) && y0Var2.b())) {
                    fVar2.g = h5.e.f8507b;
                }
            }
        }
        t6.q.W(arrayList, new p4.u(14));
        int i13 = 0;
        while (i13 < arrayList.size() && (!o7.u.Z(a4Var.getPackageName(), ((h5.f) arrayList.get(i13)).f8526c, true) || ((h5.f) arrayList.get(i13)).g != eVar)) {
            i13++;
        }
        if (i13 < arrayList.size()) {
            Object objRemove = arrayList.remove(i13);
            objRemove.getClass();
            arrayList.add(0, (h5.f) objRemove);
        }
    }

    public static final c8.a u(g8.b bVar, f8.c cVar, String str) {
        c8.b bVar2;
        bVar.getClass();
        j8.f serializersModule = cVar.getSerializersModule();
        m7.c cVar2 = ((c8.d) bVar).f1816a;
        j8.d dVar = (j8.d) serializersModule;
        dVar.getClass();
        cVar2.getClass();
        Map map = (Map) dVar.f10035d.get(cVar2);
        c8.b bVar3 = map != null ? (c8.b) map.get(str) : null;
        if (!(bVar3 instanceof c8.b)) {
            bVar3 = null;
        }
        if (bVar3 != null) {
            bVar2 = bVar3;
        } else {
            Object obj = dVar.e.get(cVar2);
            g7.l lVar = kotlin.jvm.internal.a0.c(1, obj) ? (g7.l) obj : null;
            bVar2 = lVar != null ? (c8.a) lVar.invoke(str) : null;
        }
        if (bVar2 != null) {
            return bVar2;
        }
        g8.o0.f(str, cVar2);
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final c8.g v(g8.b r3, f8.b r4, java.lang.Object r5) {
        /*
            r3.getClass()
            r5.getClass()
            j8.f r4 = r4.getSerializersModule()
            c8.d r3 = (c8.d) r3
            m7.c r3 = r3.f1816a
            j8.d r4 = (j8.d) r4
            r4.getClass()
            r3.getClass()
            r0 = r3
            kotlin.jvm.internal.f r0 = (kotlin.jvm.internal.f) r0
            boolean r0 = r0.d(r5)
            r1 = 0
            if (r0 != 0) goto L21
            goto L61
        L21:
            java.util.Map r0 = r4.f10033b
            java.lang.Object r0 = r0.get(r3)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 == 0) goto L3a
            java.lang.Class r2 = r5.getClass()
            kotlin.jvm.internal.f r2 = kotlin.jvm.internal.y.a(r2)
            java.lang.Object r0 = r0.get(r2)
            c8.b r0 = (c8.b) r0
            goto L3b
        L3a:
            r0 = r1
        L3b:
            boolean r2 = r0 instanceof c8.g
            if (r2 == 0) goto L42
            c8.g r0 = (c8.g) r0
            goto L43
        L42:
            r0 = r1
        L43:
            if (r0 == 0) goto L46
            goto L62
        L46:
            java.util.Map r4 = r4.f10034c
            java.lang.Object r4 = r4.get(r3)
            r0 = 1
            boolean r0 = kotlin.jvm.internal.a0.c(r0, r4)
            if (r0 == 0) goto L56
            g7.l r4 = (g7.l) r4
            goto L57
        L56:
            r4 = r1
        L57:
            if (r4 == 0) goto L61
            java.lang.Object r4 = r4.invoke(r5)
            r0 = r4
            c8.g r0 = (c8.g) r0
            goto L62
        L61:
            r0 = r1
        L62:
            if (r0 != 0) goto L7a
            java.lang.Class r4 = r5.getClass()
            kotlin.jvm.internal.f r4 = kotlin.jvm.internal.y.a(r4)
            java.lang.String r5 = r4.c()
            if (r5 != 0) goto L76
            java.lang.String r5 = java.lang.String.valueOf(r4)
        L76:
            g8.o0.f(r5, r3)
            throw r1
        L7a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.l5.v(g8.b, f8.b, java.lang.Object):c8.g");
    }

    public static SpannableStringBuilder w(l4.w wVar, String str) {
        List<h5.o> listU = n7.i.U(new n7.d(o7.k.a(new o7.k("\\[a](.*?)\\[/a]"), str), new a3.q(20)));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new o7.k("\\[a](.*?)\\[/a]").b(str, new a3.q(21)));
        for (h5.o oVar : listU) {
            int iK0 = o7.m.k0(spannableStringBuilder, oVar.f8674d, 0, false, 6);
            int length = oVar.f8674d.length() + iK0;
            if (iK0 >= 0) {
                spannableStringBuilder.setSpan(new l4.u2(wVar, 2), iK0, length, 33);
            }
        }
        return spannableStringBuilder;
    }

    public static String x(byte[] bArr) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b10 : bArrDigest) {
                z1.t1.k(16);
                String string = Integer.toString((b10 & 255) + 256, 16);
                string.getClass();
                sb.append(string.substring(1));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String y(String str) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            messageDigest = null;
        }
        if (messageDigest != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                byte[] bArr = new byte[8192];
                while (true) {
                    int i10 = fileInputStream.read(bArr);
                    if (i10 <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i10);
                }
                String string = new BigInteger(1, messageDigest.digest()).toString(16);
                while (string.length() < 64) {
                    string = '0' + string;
                }
                return string;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }

    public static ArrayList z(Context context) {
        h5.f fVarR;
        int applicationEnabledSetting;
        context.getClass();
        v5.g gVarL = v5.g.f13148u.l(context);
        gVarL.a();
        ArrayList arrayList = new ArrayList();
        Iterator it = gVarL.O().iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            h5.y0 y0Var = (h5.y0) next;
            String str = y0Var.f8795b;
            str.getClass();
            try {
                applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting(str);
            } catch (Error e) {
                e.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            if (applicationEnabledSetting != 2 && applicationEnabledSetting != 3 && applicationEnabledSetting != 4) {
                if (str.equalsIgnoreCase(context.getPackageName())) {
                    long j10 = y0Var.f8796c;
                    if (j10 > 0) {
                        if (j10 > 704) {
                            arrayList.add(y0Var);
                        }
                    }
                }
                if (!y0Var.b() && (fVarR = gVarL.r(str)) != null && fVarR.f8532m == 0 && fVarR.b(context)) {
                    arrayList.add(y0Var);
                }
            }
        }
        gVarL.b();
        return arrayList;
    }

    public g0.b h(Context context, Looper looper, d5.j jVar, Object obj, g0.e eVar, g0.f fVar) {
        return i(context, looper, jVar, obj, (h0.n) eVar, (h0.n) fVar);
    }

    public g0.b i(Context context, Looper looper, d5.j jVar, Object obj, h0.n nVar, h0.n nVar2) {
        throw new UnsupportedOperationException("buildClient must be implemented");
    }

    public abstract List l(List list, String str);
}
