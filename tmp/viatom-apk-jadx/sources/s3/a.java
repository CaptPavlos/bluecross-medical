package s3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Pattern;
import z1.t1;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final b f12529a = new b();

    public static String a(String str, String str2) {
        Pattern pattern = c.f12531a;
        String str3 = "<script type=\"text/javascript\">" + str + "</script>";
        t1.c(str2, "HTML is null or empty");
        ArrayList arrayList = new ArrayList();
        int length = str2.length();
        int i10 = 0;
        while (i10 < length) {
            int iIndexOf = str2.indexOf("<!--", i10);
            if (iIndexOf >= 0) {
                int iIndexOf2 = str2.indexOf("-->", iIndexOf);
                if (iIndexOf2 >= 0) {
                    arrayList.add(new int[]{iIndexOf, iIndexOf2});
                    i10 = iIndexOf2 + 3;
                } else {
                    arrayList.add(new int[]{iIndexOf, length});
                }
            }
            i10 = length;
        }
        int[][] iArr = (int[][]) arrayList.toArray((int[][]) Array.newInstance((Class<?>) Integer.TYPE, 0, 2));
        StringBuilder sb = new StringBuilder(str3.length() + str2.length() + 16);
        return c.b(str2, sb, c.f12532b, str3, iArr) ? sb.toString() : c.a(str2, sb, c.f12531a, str3, iArr) ? sb.toString() : c.b(str2, sb, c.f12534d, str3, iArr) ? sb.toString() : c.a(str2, sb, c.f12533c, str3, iArr) ? sb.toString() : c.b(str2, sb, c.f, str3, iArr) ? sb.toString() : c.a(str2, sb, c.e, str3, iArr) ? sb.toString() : c.a(str2, sb, c.g, str3, iArr) ? sb.toString() : str3.concat(str2);
    }
}
