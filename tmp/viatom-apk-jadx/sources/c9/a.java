package c9;

import g7.l;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends m implements l {

    /* renamed from: b, reason: collision with root package name */
    public static final a f1818b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f1819c;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1820a;

    static {
        int i10 = 1;
        f1818b = new a(i10, 0);
        f1819c = new a(i10, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i10, int i11) {
        super(i10);
        this.f1820a = i11;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        String strValueOf;
        switch (this.f1820a) {
            case 0:
                String str = (String) obj;
                str.getClass();
                Locale locale = Locale.ROOT;
                String lowerCase = str.toLowerCase(locale);
                lowerCase.getClass();
                if (lowerCase.length() <= 0) {
                    return lowerCase;
                }
                StringBuilder sb = new StringBuilder();
                char cCharAt = lowerCase.charAt(0);
                if (Character.isLowerCase(cCharAt)) {
                    Locale locale2 = Locale.getDefault();
                    locale2.getClass();
                    String strValueOf2 = String.valueOf(cCharAt);
                    strValueOf2.getClass();
                    strValueOf = strValueOf2.toUpperCase(locale2);
                    strValueOf.getClass();
                    if (strValueOf.length() <= 1) {
                        String strValueOf3 = String.valueOf(cCharAt);
                        strValueOf3.getClass();
                        String upperCase = strValueOf3.toUpperCase(locale);
                        upperCase.getClass();
                        if (strValueOf.equals(upperCase)) {
                            strValueOf = String.valueOf(Character.toTitleCase(cCharAt));
                        }
                    } else if (cCharAt != 329) {
                        char cCharAt2 = strValueOf.charAt(0);
                        String lowerCase2 = strValueOf.substring(1).toLowerCase(locale);
                        lowerCase2.getClass();
                        strValueOf = cCharAt2 + lowerCase2;
                    }
                } else {
                    strValueOf = String.valueOf(cCharAt);
                }
                sb.append((Object) strValueOf);
                sb.append(lowerCase.substring(1));
                return sb.toString();
            default:
                return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(((Number) obj).byteValue())}, 1));
        }
    }
}
