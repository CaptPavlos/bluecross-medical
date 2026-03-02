package a3;

import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static void A(Window window, int i10) {
        window.setBackgroundDrawable(new ColorDrawable(i10));
    }

    public static void B(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
    }

    public static String C(String str, String str2) {
        return str + str2;
    }

    public static /* synthetic */ String D(int i10) {
        switch (i10) {
            case 1:
                return "NORMAL";
            case 2:
                return "SHELL";
            case 3:
                return "SYSTEM_SERVER";
            case 4:
                return "SYSTEM_APP";
            case 5:
                return "PLATFORM_APP";
            case 6:
                return "UNTRUSTED_APP";
            case 7:
                return "RECOVERY";
            default:
                return "null";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(java.lang.String r2) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.a.a(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int b(java.lang.String r2) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.a.b(java.lang.String):int");
    }

    public static double c(double d8, double d10, double d11) {
        return (Math.sin(d8) * d10) + d11;
    }

    public static float d(float f, float f10, float f11, float f12) {
        return ((f - f10) * f11) + f12;
    }

    public static Object e(int i10, List list) {
        return list.get(list.size() - i10);
    }

    public static String f(int i10, String str) {
        return str + i10;
    }

    public static String g(int i10, String str, String str2) {
        return str + i10 + str2;
    }

    public static String h(long j10, String str) {
        return str + j10;
    }

    public static String i(String str, String str2) {
        return str + str2;
    }

    public static String j(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String k(StringBuilder sb, int i10, char c10) {
        sb.append(i10);
        sb.append(c10);
        return sb.toString();
    }

    public static String l(StringBuilder sb, long j10, String str) {
        sb.append(j10);
        sb.append(str);
        return sb.toString();
    }

    public static String m(StringBuilder sb, String str, char c10) {
        sb.append(str);
        sb.append(c10);
        return sb.toString();
    }

    public static String n(StringBuilder sb, String str, int i10) {
        sb.append(i10);
        sb.append(str);
        return sb.toString();
    }

    public static String o(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String p(StringBuilder sb, ArrayList arrayList, char c10) {
        sb.append(arrayList);
        sb.append(c10);
        return sb.toString();
    }

    public static StringBuilder q(int i10, int i11, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i10);
        sb.append(str2);
        sb.append(i11);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder r(int i10, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i10);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder s(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, g7.p pVar, CharSequence charSequence4) {
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        pVar.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence4);
        return sb;
    }

    public static StringBuilder t(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, g7.p pVar) {
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        pVar.getClass();
        return new StringBuilder();
    }

    public static StringBuilder u(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5) {
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence5);
        return sb;
    }

    public static StringBuilder v(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder w(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder x(String str, String str2, long j10) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(j10);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder y(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static void z(int i10, int i11, g7.l lVar) {
        lVar.invoke(Integer.valueOf(i10 + i11));
    }
}
