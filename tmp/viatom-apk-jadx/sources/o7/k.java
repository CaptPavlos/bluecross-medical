package o7;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Pattern f11772a;

    public k(String str, int i10) {
        str.getClass();
        Pattern patternCompile = Pattern.compile(str, 66);
        patternCompile.getClass();
        this.f11772a = patternCompile;
    }

    public static n7.d a(k kVar, String str) {
        if (str.length() >= 0) {
            return new n7.d(new androidx.work.impl.utils.c(10, kVar, str), j.f11771a);
        }
        com.google.gson.internal.a.f(str.length(), a3.a.r(0, "Start index out of bounds: ", ", input length: "));
        return null;
    }

    public final String b(CharSequence charSequence, g7.l lVar) {
        charSequence.getClass();
        Matcher matcher = this.f11772a.matcher(charSequence);
        matcher.getClass();
        int i10 = 0;
        i iVar = !matcher.find(0) ? null : new i(matcher, charSequence);
        if (iVar == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(charSequence, i10, iVar.b().f11084a);
            sb.append((CharSequence) lVar.invoke(iVar));
            i10 = iVar.b().f11085b + 1;
            iVar = iVar.c();
            if (i10 >= length) {
                break;
            }
        } while (iVar != null);
        if (i10 < length) {
            sb.append(charSequence, i10, length);
        }
        return sb.toString();
    }

    public final String c(String str) {
        String strReplaceAll = this.f11772a.matcher(str).replaceAll("");
        strReplaceAll.getClass();
        return strReplaceAll;
    }

    public final String toString() {
        String string = this.f11772a.toString();
        string.getClass();
        return string;
    }

    public k(String str) {
        Pattern patternCompile = Pattern.compile(str);
        patternCompile.getClass();
        this.f11772a = patternCompile;
    }
}
