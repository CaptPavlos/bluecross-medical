package c1;

import android.os.Bundle;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q0 {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReference f1407b = new AtomicReference();

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference f1408c = new AtomicReference();

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicReference f1409d = new AtomicReference();

    /* renamed from: a, reason: collision with root package name */
    public final j1 f1410a;

    public q0(j1 j1Var) {
        this.f1410a = j1Var;
    }

    public static final String g(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        String str2;
        i0.y.g(atomicReference);
        i0.y.b(strArr.length == strArr2.length);
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (Objects.equals(str, strArr[i10])) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        str2 = strArr3[i10];
                        if (str2 == null) {
                            str2 = strArr2[i10] + "(" + strArr[i10] + ")";
                            strArr3[i10] = str2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    public final String a(String str) {
        if (str == null) {
            return null;
        }
        return !this.f1410a.a() ? str : g(str, l2.f1319c, l2.f1317a, f1407b);
    }

    public final String b(String str) {
        if (str == null) {
            return null;
        }
        return !this.f1410a.a() ? str : g(str, l2.f, l2.e, f1408c);
    }

    public final String c(String str) {
        if (str == null) {
            return null;
        }
        return !this.f1410a.a() ? str : str.startsWith("_exp_") ? androidx.constraintlayout.core.widgets.analyzer.a.x("experiment_id(", str, ")") : g(str, l2.f1322j, l2.f1321i, f1409d);
    }

    public final String d(v vVar) {
        j1 j1Var = this.f1410a;
        if (!j1Var.a()) {
            return vVar.toString();
        }
        StringBuilder sb = new StringBuilder("origin=");
        sb.append(vVar.f1507c);
        sb.append(",name=");
        sb.append(a(vVar.f1505a));
        sb.append(",params=");
        u uVar = vVar.f1506b;
        sb.append(uVar == null ? null : !j1Var.a() ? uVar.f1470a.toString() : e(uVar.e()));
        return sb.toString();
    }

    public final String e(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!this.f1410a.a()) {
            return bundle.toString();
        }
        StringBuilder sbV = a3.a.v("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sbV.length() != 8) {
                sbV.append(", ");
            }
            sbV.append(b(str));
            sbV.append("=");
            Object obj = bundle.get(str);
            sbV.append(obj instanceof Bundle ? f(new Object[]{obj}) : obj instanceof Object[] ? f((Object[]) obj) : obj instanceof ArrayList ? f(((ArrayList) obj).toArray()) : String.valueOf(obj));
        }
        sbV.append("}]");
        return sbV.toString();
    }

    public final String f(Object[] objArr) {
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sbV = a3.a.v("[");
        for (Object obj : objArr) {
            String strE = obj instanceof Bundle ? e((Bundle) obj) : String.valueOf(obj);
            if (strE != null) {
                if (sbV.length() != 1) {
                    sbV.append(", ");
                }
                sbV.append(strE);
            }
        }
        sbV.append("]");
        return sbV.toString();
    }
}
