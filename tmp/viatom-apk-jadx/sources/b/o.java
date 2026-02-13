package b;

import a3.x;
import a3.z0;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.internal.measurement.a4;
import com.google.android.gms.internal.measurement.l5;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import j$.util.DesugarTimeZone;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import o7.u;
import w2.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final d0.i f805a;

    /* renamed from: b, reason: collision with root package name */
    public final f6.m f806b;

    /* renamed from: c, reason: collision with root package name */
    public final o8.i f807c;

    /* renamed from: d, reason: collision with root package name */
    public final f9.n f808d;
    public final r e;
    public final z0 f;
    public final d5.n g;
    public final x h;

    /* renamed from: i, reason: collision with root package name */
    public final r f809i;

    /* renamed from: j, reason: collision with root package name */
    public final z0 f810j;

    /* renamed from: k, reason: collision with root package name */
    public final r f811k;

    /* renamed from: l, reason: collision with root package name */
    public final a4.f f812l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f813m;

    /* renamed from: n, reason: collision with root package name */
    public f6.d f814n;

    /* renamed from: o, reason: collision with root package name */
    public q6.a f815o;

    /* renamed from: p, reason: collision with root package name */
    public int f816p;

    /* renamed from: q, reason: collision with root package name */
    public f6.f f817q;

    public o(d0.i iVar, f6.m mVar, o8.i iVar2, f9.n nVar, r rVar, z0 z0Var, d5.n nVar2, x xVar, r rVar2, z0 z0Var2, r rVar3, a4.f fVar) {
        nVar.getClass();
        rVar.getClass();
        z0Var.getClass();
        xVar.getClass();
        rVar2.getClass();
        z0Var2.getClass();
        this.f805a = iVar;
        this.f806b = mVar;
        this.f807c = iVar2;
        this.f808d = nVar;
        this.e = rVar;
        this.f = z0Var;
        this.g = nVar2;
        this.h = xVar;
        this.f809i = rVar2;
        this.f810j = z0Var2;
        this.f811k = rVar3;
        this.f812l = fVar;
        this.f814n = new f6.d();
        this.f816p = -1;
        this.f817q = new f6.f();
        this.f816p = i();
    }

    public static Vector a(Object obj) {
        ArrayList arrayList = obj instanceof ArrayList ? (ArrayList) obj : null;
        Vector vector = new Vector(null, 1, null);
        if (arrayList != null) {
            int size = arrayList.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                Object obj2 = arrayList.get(i11);
                i11++;
                int i12 = i10 + 1;
                if (i10 < 0) {
                    t6.m.U();
                    throw null;
                }
                if (kotlin.jvm.internal.l.a(obj2 instanceof Boolean ? (Boolean) obj2 : null, Boolean.TRUE)) {
                    vector.set(i12);
                }
                i10 = i12;
            }
        }
        return vector;
    }

    public static Vector e(Object obj) {
        ArrayList arrayList = obj instanceof ArrayList ? (ArrayList) obj : null;
        Vector vector = new Vector(null, 1, null);
        if (arrayList != null) {
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj2 = arrayList.get(i10);
                i10++;
                Integer num = obj2 instanceof Integer ? (Integer) obj2 : null;
                if (num != null) {
                    vector.set(num.intValue());
                }
            }
        }
        return vector;
    }

    public final void b() {
        d0.i iVar = this.f805a;
        iVar.k(43);
        iVar.k(44);
        iVar.k(45);
        iVar.k(46);
        iVar.k(47);
        iVar.k(48);
        iVar.k(49);
        iVar.k(51);
        iVar.k(52);
        iVar.k(53);
        iVar.k(54);
        iVar.k(55);
        iVar.k(56);
        iVar.k(57);
        iVar.k(58);
        iVar.k(59);
        iVar.k(60);
    }

    public final void c(boolean z9) {
        d0.i iVar = this.f805a;
        if (z9) {
            iVar.p(76, "Reject");
        } else {
            iVar.p(76, "");
            iVar.k(75);
        }
        if (j.g.f9878a) {
            if (z9) {
                iVar.p(93, "Reject");
            } else {
                iVar.p(93, "");
                iVar.k(92);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.List] */
    public final boolean d(Set set) {
        ?? r02 = this.f807c.f11814b.h;
        if (set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (r02.contains(Integer.valueOf(((Number) it.next()).intValue()))) {
                return true;
            }
        }
        return false;
    }

    public final void f() {
        d0.i iVar = this.f805a;
        iVar.k(1);
        iVar.k(2);
        iVar.k(3);
        iVar.k(4);
        iVar.k(5);
        iVar.k(6);
        iVar.k(7);
        iVar.k(8);
        iVar.k(50);
        iVar.k(9);
        iVar.k(10);
        iVar.k(11);
        iVar.k(12);
        iVar.k(13);
        iVar.k(14);
        iVar.k(15);
        iVar.k(16);
        iVar.k(17);
        iVar.k(18);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Object, java.util.List] */
    public final boolean g() {
        String upperCase;
        o8.i iVar = this.f807c;
        if (iVar.f11814b.f11779b.contains("GDPR")) {
            ?? r12 = iVar.f11814b.Q;
            if (!l()) {
                if (!r12.contains("WORLDWIDE")) {
                    if (iVar.f11814b.Q.contains("EEA")) {
                        q6.a aVar = this.f815o;
                        String str = aVar == null ? null : aVar.f12280a;
                        int[] iArr = new int[32];
                        System.arraycopy(d6.b.f7455a, 0, iArr, 0, 32);
                        int i10 = 0;
                        while (i10 < 32) {
                            int i11 = iArr[i10];
                            i10++;
                            String strB = l5.b(i11);
                            if (str == null) {
                                upperCase = null;
                            } else {
                                upperCase = str.toUpperCase(Locale.ROOT);
                                upperCase.getClass();
                            }
                            if (strB.equals(upperCase)) {
                                break;
                            }
                        }
                    }
                    boolean z9 = false;
                    for (String str2 : iVar.f11814b.Q) {
                        q6.a aVar2 = this.f815o;
                        if (u.Z(str2, aVar2 == null ? null : aVar2.f12280a, true)) {
                            z9 = true;
                        }
                    }
                    if (z9) {
                        break;
                    }
                }
                return true;
            }
            if (iVar.f11814b.S && (r12.contains("USA") || r12.contains("WORLDWIDE"))) {
                return true;
            }
        }
        return false;
    }

    public final String h() {
        StringBuilder sb = new StringBuilder();
        o8.i iVar = this.f807c;
        sb.append(iVar.f11815c.f11812c);
        sb.append(iVar.f11814b.f11797z);
        sb.append(iVar.f11814b.f11794v);
        sb.append(iVar.f11814b.f11795w);
        sb.append(iVar.f11814b.f11793u);
        sb.append(iVar.f11814b.f11792s);
        sb.append(iVar.f11814b.t);
        return l1.b.l(sb.toString());
    }

    public final int i() {
        SharedPreferences sharedPreferences = (SharedPreferences) this.f805a.f6781b;
        int i10 = sharedPreferences.getInt("IABTCF_PolicyVersion", 0);
        return i10 != 0 ? i10 : sharedPreferences.getInt("IABGPP_TCFEU2_PolicyVersion", 0);
    }

    public final int j() {
        k8.c cVar = this.f806b.f8097a;
        Integer num = cVar == null ? null : cVar.f10082b;
        return num == null ? ((SharedPreferences) this.f805a.f6781b).getInt("gvl_version", 0) : num.intValue();
    }

    public final boolean k() {
        return this.f807c.f11814b.M && kotlin.jvm.internal.l.a(i9.a.f9113m, DownloadCommon.DOWNLOAD_REPORT_CANCEL);
    }

    public final boolean l() {
        q6.a aVar = this.f815o;
        return u.Z(aVar == null ? null : aVar.f12280a, "USA", true);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Iterable, java.lang.Object, java.util.List] */
    public final boolean m() {
        String upperCase;
        String upperCase2;
        o8.f fVar = this.f807c.f11814b.W;
        ?? r12 = fVar.f11804b;
        q6.a aVar = this.f815o;
        String lowerCase = null;
        String str = aVar == null ? null : aVar.f12280a;
        if (fVar.f11803a) {
            if (r12.contains("WORLDWIDE")) {
                return true;
            }
            if (r12.contains("EEA")) {
                int[] iArr = new int[32];
                System.arraycopy(d6.b.f7455a, 0, iArr, 0, 32);
                int i10 = 0;
                while (i10 < 32) {
                    int i11 = iArr[i10];
                    i10++;
                    String strB = l5.b(i11);
                    if (str == null) {
                        upperCase2 = null;
                    } else {
                        upperCase2 = str.toUpperCase(Locale.ROOT);
                        upperCase2.getClass();
                    }
                    if (strB.equals(upperCase2)) {
                        return true;
                    }
                }
            }
            if (str == null) {
                upperCase = null;
            } else {
                upperCase = str.toUpperCase(Locale.ROOT);
                upperCase.getClass();
            }
            if (t6.l.a0(r12, upperCase)) {
                return true;
            }
            if (str != null) {
                lowerCase = str.toLowerCase(Locale.ROOT);
                lowerCase.getClass();
            }
            if (t6.l.a0(r12, lowerCase)) {
                return true;
            }
        }
        return false;
    }

    public final boolean n() {
        SharedPreferences sharedPreferences = (SharedPreferences) this.f805a.f6781b;
        return (System.currentTimeMillis() - sharedPreferences.getLong("gvl_last_updated", 0L)) / 86400000 < ((long) this.f807c.f11814b.A) || j() <= sharedPreferences.getInt("gvl_version", 0);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, java.util.List] */
    public final boolean o() {
        o8.i iVar = this.f807c;
        if (iVar.f11814b.f11779b.contains("USP")) {
            return iVar.f11814b.Q.contains("WORLDWIDE") || iVar.f11814b.Q.contains("USA");
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r12v4, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r14v10, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r15v15, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r15v5, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v44, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v54, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v5 */
    public final void p() {
        int i10;
        String strSubstring;
        String[] strArr;
        int i11;
        int i12;
        String str;
        int i13;
        int i14;
        int iIntValue;
        int i15;
        int iIntValue2;
        int i16;
        int iIntValue3;
        String str2;
        int iIntValue4;
        int i17;
        int iIntValue5;
        int i18;
        int iIntValue6;
        int i19;
        int iIntValue7;
        String str3;
        int iIntValue8;
        int i20;
        int iIntValue9;
        int i21;
        int iIntValue10;
        Integer num;
        j3.a aVarE = i9.a.e();
        HashMap map = q3.b.f12257b;
        boolean zG = aVarE.g((String) map.get(2));
        d0.i iVar = this.f805a;
        f6.m mVar = this.f806b;
        boolean z9 = false;
        if (zG) {
            q3.a aVarE2 = i9.a.e().e((String) map.get(2));
            Vector vector = mVar.f8110r;
            List list = p3.f.f11884a;
            Object objD = aVarE2.d("PurposeConsents");
            objD.getClass();
            vector.set(a(objD));
            Vector vector2 = mVar.f8111s;
            vector2.unsetAllOwnedItems();
            Object objD2 = aVarE2.d("PurposeLegitimateInterests");
            objD2.getClass();
            vector2.set(a(objD2));
            Vector vector3 = mVar.f8109q;
            Object objD3 = aVarE2.d("SpecialFeatureOptins");
            objD3.getClass();
            vector3.set(a(objD3));
            Vector vector4 = mVar.f8116z;
            vector4.unsetAllOwnedItems();
            Object objD4 = aVarE2.d("VendorConsents");
            objD4.getClass();
            vector4.setOwnedItems(e(objD4));
            Vector vector5 = mVar.C;
            vector5.unsetAllOwnedItems();
            Object objD5 = aVarE2.d("VendorLegitimateInterests");
            objD5.getClass();
            vector5.setOwnedItems(e(objD5));
            Vector vector6 = mVar.f8113v;
            vector6.unsetAllOwnedItems();
            Object objD6 = aVarE2.d("PublisherConsents");
            objD6.getClass();
            vector6.setOwnedItems(a(objD6));
            Vector vector7 = mVar.f8114w;
            vector7.unsetAllOwnedItems();
            Object objD7 = aVarE2.d("PublisherLegitimateInterests");
            objD7.getClass();
            vector7.setOwnedItems(a(objD7));
        } else {
            String strT = iVar.t(8);
            if (strT.length() <= 0) {
                strT = null;
            }
            if (strT != null) {
                List listS0 = o7.m.s0(strT, new String[]{"."});
                int size = listS0.size();
                f6.m mVar2 = new f6.m();
                int i22 = 0;
                while (i22 < size) {
                    int i23 = i22 + 1;
                    String str4 = (String) listS0.get(i22);
                    Object obj = h6.a.f8807a;
                    String strE = a.a.e(String.valueOf(str4.charAt(z9 ? 1 : 0)));
                    Object obj2 = h6.c.f8810a;
                    ?? r14 = h6.c.f8811b;
                    h6.d dVar = h6.d.f8817i;
                    Integer num2 = (Integer) r14.get(dVar);
                    String strSubstring2 = strE.substring(z9 ? 1 : 0, num2 == null ? z9 ? 1 : 0 : num2.intValue());
                    Set set = f6.k.f8093a;
                    Integer num3 = (Integer) r14.get(dVar);
                    f6.j jVar = (f6.j) t6.l.b0(set, l5.a(num3 == null ? z9 ? 1 : 0 : num3.intValue(), strSubstring2));
                    jVar.getClass();
                    String str5 = jVar.f8092a;
                    String strE2 = a.a.e(str4);
                    f6.j jVar2 = f6.j.CORE;
                    if (jVar == jVar2) {
                        ?? r15 = h6.c.f8810a;
                        f6.a aVar = f6.a.f8069z;
                        Integer num4 = (Integer) r15.get(aVar);
                        String strSubstring3 = strE2.substring(z9 ? 1 : 0, num4 == null ? z9 ? 1 : 0 : num4.intValue());
                        Integer num5 = (Integer) r15.get(aVar);
                        mVar2.f8101i = l5.a(num5 == null ? z9 ? 1 : 0 : num5.intValue(), strSubstring3);
                    }
                    int iIntValue11 = (jVar == jVar2 || (num = (Integer) h6.c.f8812c.get("segmentType")) == null) ? z9 ? 1 : 0 : num.intValue();
                    String[] strArr2 = mVar2.f8101i == 1 ? (String[]) l6.a.f11082a.get(str5) : (String[]) l6.a.f11083b.get(str5);
                    if (strArr2 != null) {
                        int length = strArr2.length;
                        int i24 = z9 ? 1 : 0;
                        ?? r9 = z9;
                        while (i24 < length) {
                            String str6 = strArr2[i24];
                            int i25 = i24 + 1;
                            Object obj3 = j6.a.f10027a;
                            str6.getClass();
                            Integer numValueOf = (Integer) h6.c.f8812c.get(str6);
                            List list2 = listS0;
                            if (numValueOf == null) {
                                i10 = size;
                                if (o7.m.k0(str6, "publisherCustom", r9, r9, 6) == 0) {
                                    numValueOf = Integer.valueOf(mVar2.f8108p);
                                }
                            } else {
                                i10 = size;
                            }
                            if ((numValueOf != null && numValueOf.intValue() == 0) || numValueOf == null) {
                                str = strE2;
                                i13 = i23;
                                i14 = i25;
                                listS0 = list2;
                                size = i10;
                                strArr2 = strArr2;
                                length = length;
                                iIntValue11 = iIntValue11;
                            } else {
                                try {
                                    strSubstring = strE2.substring(iIntValue11, numValueOf.intValue() + iIntValue11);
                                } catch (IndexOutOfBoundsException unused) {
                                    strSubstring = o7.m.o0(numValueOf.intValue() + iIntValue11, strE2).substring(iIntValue11, numValueOf.intValue() + iIntValue11);
                                }
                                if (str6.equals("version")) {
                                    mVar2.f8101i = l5.a(numValueOf.intValue(), strSubstring);
                                    i11 = iIntValue11;
                                    strArr = strArr2;
                                } else {
                                    if (str6.equals("created")) {
                                        strArr = strArr2;
                                        mVar2.f8098b = a.a.c(numValueOf.intValue(), strSubstring);
                                    } else {
                                        strArr = strArr2;
                                        if (str6.equals("lastUpdated")) {
                                            mVar2.f8099c = a.a.c(numValueOf.intValue(), strSubstring);
                                        } else if (str6.equals("cmpId")) {
                                            int iA = l5.a(numValueOf.intValue(), strSubstring);
                                            if (iA > -1) {
                                                mVar2.f8105m = iA;
                                            } else {
                                                f6.n nVar = new f6.n("cmpId", String.valueOf(iA));
                                                ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
                                                if (callback != null) {
                                                    callback.onCmpError(ChoiceError.TC_MODEL_PROPERTY_ERROR);
                                                }
                                                String message = nVar.getMessage();
                                                if (message == null) {
                                                    message = "";
                                                }
                                                Object obj4 = Boolean.TRUE;
                                                if (obj4.equals(obj4)) {
                                                    Log.e("f.u", message, nVar);
                                                }
                                            }
                                        } else if (str6.equals("cmpVersion")) {
                                            int iA2 = l5.a(numValueOf.intValue(), strSubstring);
                                            if (iA2 > -1) {
                                                mVar2.f8106n = iA2;
                                            } else {
                                                f6.n nVar2 = new f6.n("cmpVersion", String.valueOf(iA2));
                                                ChoiceCmpCallback callback2 = ChoiceCmp.INSTANCE.getCallback();
                                                if (callback2 != null) {
                                                    callback2.onCmpError(ChoiceError.TC_MODEL_PROPERTY_ERROR);
                                                }
                                                String message2 = nVar2.getMessage();
                                                if (message2 == null) {
                                                    message2 = "";
                                                }
                                                Object obj5 = Boolean.TRUE;
                                                if (obj5.equals(obj5)) {
                                                    Log.e("f.u", message2, nVar2);
                                                }
                                            }
                                        } else if (str6.equals("consentScreen")) {
                                            int iA3 = l5.a(numValueOf.intValue(), strSubstring);
                                            if (iA3 > -1) {
                                                mVar2.f8102j = iA3;
                                            } else {
                                                f6.n nVar3 = new f6.n("consentScreen", String.valueOf(iA3));
                                                ChoiceCmpCallback callback3 = ChoiceCmp.INSTANCE.getCallback();
                                                if (callback3 != null) {
                                                    callback3.onCmpError(ChoiceError.TC_MODEL_PROPERTY_ERROR);
                                                }
                                                String message3 = nVar3.getMessage();
                                                if (message3 == null) {
                                                    message3 = "";
                                                }
                                                Object obj6 = Boolean.TRUE;
                                                if (obj6.equals(obj6)) {
                                                    Log.e("f.u", message3, nVar3);
                                                }
                                            }
                                        } else if (str6.equals("consentLanguage")) {
                                            mVar2.f8104l = l1.b.b(numValueOf.intValue(), strSubstring);
                                        } else if (str6.equals("vendorListVersion")) {
                                            int iA4 = l5.a(numValueOf.intValue(), strSubstring);
                                            mVar2.f8107o = iA4;
                                            if (iA4 < 0) {
                                                f6.n nVar4 = new f6.n("vendorListVersion", String.valueOf(iA4));
                                                ChoiceCmpCallback callback4 = ChoiceCmp.INSTANCE.getCallback();
                                                if (callback4 != null) {
                                                    callback4.onCmpError(ChoiceError.TC_MODEL_PROPERTY_ERROR);
                                                }
                                                String message4 = nVar4.getMessage();
                                                if (message4 == null) {
                                                    message4 = "";
                                                }
                                                Object obj7 = Boolean.TRUE;
                                                if (obj7.equals(obj7)) {
                                                    Log.e("f.u", message4, nVar4);
                                                }
                                            }
                                        } else if (str6.equals("policyVersion")) {
                                            int iA5 = l5.a(numValueOf.intValue(), strSubstring);
                                            mVar2.f8103k = iA5;
                                            if (iA5 < 0) {
                                                f6.n nVar5 = new f6.n("policyVersion", String.valueOf(iA5));
                                                ChoiceCmpCallback callback5 = ChoiceCmp.INSTANCE.getCallback();
                                                if (callback5 != null) {
                                                    callback5.onCmpError(ChoiceError.TC_MODEL_PROPERTY_ERROR);
                                                }
                                                String message5 = nVar5.getMessage();
                                                if (message5 == null) {
                                                    message5 = "";
                                                }
                                                Object obj8 = Boolean.TRUE;
                                                if (obj8.equals(obj8)) {
                                                    Log.e("f.u", message5, nVar5);
                                                }
                                            }
                                        } else {
                                            String str7 = "1";
                                            if (str6.equals("isServiceSpecific")) {
                                                mVar2.e = strSubstring.equals("1");
                                            } else if (str6.equals("useNonStandardStacks")) {
                                                mVar2.f = strSubstring.equals("1");
                                            } else if (str6.equals("specialFeatureOptions")) {
                                                mVar2.f8109q = a4.a(numValueOf.intValue(), strSubstring);
                                            } else if (str6.equals("purposeConsents")) {
                                                mVar2.f8110r = a4.a(numValueOf.intValue(), strSubstring);
                                            } else if (str6.equals("purposeLegitimateInterests")) {
                                                mVar2.f8111s = a4.a(numValueOf.intValue(), strSubstring);
                                            } else if (str6.equals("purposeOneTreatment")) {
                                                mVar2.g = strSubstring.equals("1");
                                            } else if (str6.equals("publisherCountryCode")) {
                                                mVar2.a(l1.b.b(numValueOf.intValue(), strSubstring));
                                            } else if (str6.equals("vendorConsents")) {
                                                Vector vectorC = r0.f.c(strE2.substring(iIntValue11));
                                                mVar2.f8116z = vectorC;
                                                numValueOf = Integer.valueOf(vectorC.getBitLength());
                                            } else if (str6.equals("vendorLegitimateInterests")) {
                                                Vector vectorC2 = r0.f.c(strE2.substring(iIntValue11));
                                                mVar2.C = vectorC2;
                                                numValueOf = Integer.valueOf(vectorC2.getBitLength());
                                            } else {
                                                if (str6.equals("publisherRestrictions")) {
                                                    f6.h hVar = new f6.h(new k8.c());
                                                    Object obj9 = h6.c.f8810a;
                                                    ?? r42 = h6.c.f8811b;
                                                    h6.d dVar2 = h6.d.f;
                                                    Integer num6 = (Integer) r42.get(dVar2);
                                                    if (num6 == null) {
                                                        i11 = iIntValue11;
                                                        iIntValue = 0;
                                                    } else {
                                                        i11 = iIntValue11;
                                                        iIntValue = num6.intValue();
                                                    }
                                                    i12 = length;
                                                    String strSubstring4 = strSubstring.substring(0, iIntValue);
                                                    Integer num7 = (Integer) r42.get(dVar2);
                                                    int iA6 = l5.a(num7 == null ? 0 : num7.intValue(), strSubstring4);
                                                    Integer num8 = (Integer) r42.get(dVar2);
                                                    int iIntValue12 = num8 == null ? 0 : num8.intValue();
                                                    int i26 = 0;
                                                    while (i26 < iA6) {
                                                        int i27 = i26 + 1;
                                                        Object obj10 = h6.c.f8810a;
                                                        ?? r142 = h6.c.f8811b;
                                                        int i28 = iA6;
                                                        h6.d dVar3 = h6.d.g;
                                                        Integer num9 = (Integer) r142.get(dVar3);
                                                        if (num9 == null) {
                                                            i15 = i27;
                                                            iIntValue2 = 0;
                                                        } else {
                                                            i15 = i27;
                                                            iIntValue2 = num9.intValue();
                                                        }
                                                        String strSubstring5 = strSubstring.substring(iIntValue12, iIntValue2);
                                                        Integer num10 = (Integer) r142.get(dVar3);
                                                        if (num10 == null) {
                                                            i16 = iIntValue12;
                                                            iIntValue3 = 0;
                                                        } else {
                                                            i16 = iIntValue12;
                                                            iIntValue3 = num10.intValue();
                                                        }
                                                        int iA7 = l5.a(iIntValue3, strSubstring5);
                                                        Integer num11 = (Integer) r142.get(dVar3);
                                                        int iIntValue13 = i16 + (num11 == null ? 0 : num11.intValue());
                                                        h6.d dVar4 = h6.d.h;
                                                        Integer num12 = (Integer) r142.get(dVar4);
                                                        if (num12 == null) {
                                                            str2 = strE2;
                                                            iIntValue4 = 0;
                                                        } else {
                                                            str2 = strE2;
                                                            iIntValue4 = num12.intValue();
                                                        }
                                                        String strSubstring6 = strSubstring.substring(iIntValue13, iIntValue4);
                                                        Integer num13 = (Integer) r142.get(dVar4);
                                                        if (num13 == null) {
                                                            i17 = iIntValue13;
                                                            iIntValue5 = 0;
                                                        } else {
                                                            i17 = iIntValue13;
                                                            iIntValue5 = num13.intValue();
                                                        }
                                                        int iA8 = l5.a(iIntValue5, strSubstring6);
                                                        Integer num14 = (Integer) r142.get(dVar4);
                                                        int iIntValue14 = i17 + (num14 == null ? 0 : num14.intValue());
                                                        f6.g gVar = new f6.g(iA7, f6.i.valueOf(String.valueOf(iA8)));
                                                        h6.d dVar5 = h6.d.e;
                                                        Integer num15 = (Integer) r142.get(dVar5);
                                                        String strSubstring7 = strSubstring.substring(iIntValue14, num15 == null ? 0 : num15.intValue());
                                                        Integer num16 = (Integer) r142.get(dVar5);
                                                        if (num16 == null) {
                                                            i18 = iIntValue14;
                                                            iIntValue6 = 0;
                                                        } else {
                                                            i18 = iIntValue14;
                                                            iIntValue6 = num16.intValue();
                                                        }
                                                        int iA9 = l5.a(iIntValue6, strSubstring7);
                                                        Integer num17 = (Integer) r142.get(dVar5);
                                                        int iIntValue15 = i18 + (num17 == null ? 0 : num17.intValue());
                                                        if (iA9 >= 0) {
                                                            int i29 = 0;
                                                            while (true) {
                                                                int i30 = i29 + 1;
                                                                Object obj11 = h6.c.f8810a;
                                                                int i31 = i23;
                                                                ?? r12 = h6.c.f8811b;
                                                                int i32 = i25;
                                                                h6.d dVar6 = h6.d.f8813a;
                                                                Integer num18 = (Integer) r12.get(dVar6);
                                                                if (num18 == null) {
                                                                    i19 = i30;
                                                                    iIntValue7 = 0;
                                                                } else {
                                                                    i19 = i30;
                                                                    iIntValue7 = num18.intValue();
                                                                }
                                                                boolean zEquals = strSubstring.substring(iIntValue15, iIntValue7).equals(str7);
                                                                Integer num19 = (Integer) r12.get(dVar6);
                                                                int iIntValue16 = iIntValue15 + (num19 == null ? 0 : num19.intValue());
                                                                h6.d dVar7 = h6.d.f8819k;
                                                                Integer num20 = (Integer) r12.get(dVar7);
                                                                if (num20 == null) {
                                                                    str3 = str7;
                                                                    iIntValue8 = 0;
                                                                } else {
                                                                    str3 = str7;
                                                                    iIntValue8 = num20.intValue();
                                                                }
                                                                String strSubstring8 = strSubstring.substring(iIntValue16, iIntValue8);
                                                                Integer num21 = (Integer) r12.get(dVar7);
                                                                if (num21 == null) {
                                                                    i20 = iIntValue16;
                                                                    iIntValue9 = 0;
                                                                } else {
                                                                    i20 = iIntValue16;
                                                                    iIntValue9 = num21.intValue();
                                                                }
                                                                int iA10 = l5.a(iIntValue9, strSubstring8);
                                                                Integer num22 = (Integer) r12.get(dVar7);
                                                                int iIntValue17 = i20 + (num22 == null ? 0 : num22.intValue());
                                                                if (zEquals) {
                                                                    Integer num23 = (Integer) r12.get(dVar7);
                                                                    String strSubstring9 = strSubstring.substring(iIntValue17, num23 == null ? 0 : num23.intValue());
                                                                    Integer num24 = (Integer) r12.get(dVar7);
                                                                    if (num24 == null) {
                                                                        i21 = iIntValue17;
                                                                        iIntValue10 = 0;
                                                                    } else {
                                                                        i21 = iIntValue17;
                                                                        iIntValue10 = num24.intValue();
                                                                    }
                                                                    int iA11 = l5.a(iIntValue10, strSubstring9);
                                                                    Integer num25 = (Integer) r12.get(dVar7);
                                                                    int iIntValue18 = i21 + (num25 == null ? 0 : num25.intValue());
                                                                    if (iA11 < iA10) {
                                                                        throw new h6.e(androidx.constraintlayout.core.widgets.analyzer.a.u(iA11, iA10, "h.k: Invalid RangeEntry: endVendorId ", " is less than "));
                                                                    }
                                                                    if (iA10 <= iA11) {
                                                                        while (true) {
                                                                            int i33 = iA10 + 1;
                                                                            hVar.a(iA10, gVar);
                                                                            if (iA10 == iA11) {
                                                                                break;
                                                                            } else {
                                                                                iA10 = i33;
                                                                            }
                                                                        }
                                                                    }
                                                                    iIntValue15 = iIntValue18;
                                                                } else {
                                                                    hVar.a(iA10, gVar);
                                                                    iIntValue15 = iIntValue17;
                                                                }
                                                                if (i29 == iA9) {
                                                                    iIntValue12 = iIntValue15;
                                                                    iA6 = i28;
                                                                    i23 = i31;
                                                                    i26 = i15;
                                                                    strE2 = str2;
                                                                    i25 = i32;
                                                                    str7 = str3;
                                                                    break;
                                                                }
                                                                i23 = i31;
                                                                i25 = i32;
                                                                i29 = i19;
                                                                str7 = str3;
                                                            }
                                                        } else {
                                                            iIntValue12 = iIntValue15;
                                                            iA6 = i28;
                                                            i26 = i15;
                                                            strE2 = str2;
                                                        }
                                                    }
                                                    str = strE2;
                                                    i13 = i23;
                                                    i14 = i25;
                                                    mVar2.G = hVar;
                                                } else {
                                                    i11 = iIntValue11;
                                                    i12 = length;
                                                    str = strE2;
                                                    i13 = i23;
                                                    i14 = i25;
                                                    if (str6.equals("publisherConsents")) {
                                                        mVar2.f8113v = a4.a(numValueOf.intValue(), strSubstring);
                                                    } else if (str6.equals("publisherLegitimateInterests")) {
                                                        mVar2.f8114w = a4.a(numValueOf.intValue(), strSubstring);
                                                    } else if (str6.equals("numCustomPurposes")) {
                                                        mVar2.f8108p = l5.a(numValueOf.intValue(), strSubstring);
                                                    } else if (str6.equals("publisherCustomConsents")) {
                                                        mVar2.f8115x = a4.a(numValueOf.intValue(), strSubstring);
                                                    } else if (str6.equals("publisherCustomLegitimateInterests")) {
                                                        mVar2.y = a4.a(numValueOf.intValue(), strSubstring);
                                                    } else if (str6.equals("vendorsAllowed")) {
                                                        mVar2.F = r0.f.c(strSubstring);
                                                    } else {
                                                        if (!str6.equals("vendorsDisclosed")) {
                                                            throw new h6.e(androidx.constraintlayout.core.widgets.analyzer.a.x("g.i: Unable to find: ", str6, " field on TCModel, segment"));
                                                        }
                                                        mVar2.E = r0.f.c(strSubstring);
                                                    }
                                                }
                                                iIntValue11 = numValueOf.intValue() + i11;
                                                listS0 = list2;
                                                size = i10;
                                                strArr2 = strArr;
                                                length = i12;
                                            }
                                        }
                                    }
                                    i11 = iIntValue11;
                                }
                                i12 = length;
                                str = strE2;
                                i13 = i23;
                                i14 = i25;
                                iIntValue11 = numValueOf.intValue() + i11;
                                listS0 = list2;
                                size = i10;
                                strArr2 = strArr;
                                length = i12;
                            }
                            i23 = i13;
                            strE2 = str;
                            i24 = i14;
                            r9 = 0;
                        }
                    }
                    listS0 = listS0;
                    size = size;
                    i22 = i23;
                    z9 = false;
                }
                mVar.f8110r.set(mVar2.f8110r);
                Vector vector8 = mVar.f8111s;
                vector8.unsetAllOwnedItems();
                vector8.set(mVar2.f8111s);
                mVar.f8109q.set(mVar2.f8109q);
                Vector vector9 = mVar.f8116z;
                vector9.unsetAllOwnedItems();
                vector9.setOwnedItems(mVar2.f8116z);
                Vector vector10 = mVar.C;
                vector10.unsetAllOwnedItems();
                vector10.setOwnedItems(mVar2.C);
                Vector vector11 = mVar.f8113v;
                vector11.unsetAllOwnedItems();
                vector11.set(mVar2.f8113v);
                Vector vector12 = mVar.f8114w;
                vector12.unsetAllOwnedItems();
                vector12.set(mVar2.f8114w);
            }
        }
        if (i9.a.e().g("tcfeuv2") || iVar.t(8).length() > 0) {
            o8.i iVar2 = this.f807c;
            String str8 = iVar2.f11814b.I;
            r rVar = this.f811k;
            if (str8 != null) {
                PrivacyEncodingMode privacyEncodingMode = PrivacyEncodingMode.GPP;
                if (str8.equals(privacyEncodingMode.getValue())) {
                    if (!i9.a.e().g((String) q3.b.f12257b.get(2))) {
                        rVar.i(privacyEncodingMode, false, false);
                    }
                    f();
                    return;
                }
            }
            String str9 = iVar2.f11814b.I;
            if (str9 != null) {
                PrivacyEncodingMode privacyEncodingMode2 = PrivacyEncodingMode.TCF;
                if (str9.equals(privacyEncodingMode2.getValue())) {
                    i9.a.e().b(2);
                    b();
                    String strC = i9.a.e().c();
                    d0.i iVarJ = i9.a.j();
                    strC.getClass();
                    iVarJ.p(63, strC);
                    if (iVar.t(8).length() == 0) {
                        rVar.i(privacyEncodingMode2, false, false);
                        return;
                    }
                    return;
                }
            }
            if (!i9.a.e().g((String) q3.b.f12257b.get(2))) {
                rVar.i(PrivacyEncodingMode.GPP, false, false);
            }
            if (iVar.t(8).length() == 0) {
                rVar.i(PrivacyEncodingMode.TCF, false, false);
            }
        }
    }

    public final void q() {
        f6.m mVar = this.f806b;
        int i10 = mVar.f8105m;
        d0.i iVar = this.f805a;
        iVar.l(43, i10);
        iVar.l(44, mVar.f8106n);
        iVar.l(45, mVar.d());
        iVar.l(46, g() ? 1 : 0);
        iVar.p(47, this.f807c.f11814b.f);
        iVar.l(48, mVar.g ? 1 : 0);
        iVar.l(49, mVar.f ? 1 : 0);
    }

    public final void r() {
        f6.m mVar = this.f806b;
        int i10 = mVar.f8105m;
        d0.i iVar = this.f805a;
        iVar.l(1, i10);
        iVar.l(2, mVar.f8106n);
        iVar.l(3, mVar.d());
        if (this.f816p <= 0) {
            this.f816p = mVar.d();
        }
        iVar.l(4, g() ? 1 : 0);
        iVar.p(5, this.f807c.f11814b.f);
        iVar.l(6, mVar.g ? 1 : 0);
        iVar.l(7, mVar.f ? 1 : 0);
    }

    public final boolean s() {
        o8.i iVar = this.f807c;
        long j10 = iVar.h;
        d0.i iVar2 = this.f805a;
        long j11 = ((SharedPreferences) iVar2.f6781b).getLong("LastVisitTime", 0L);
        boolean z9 = ((double) (j10 - j11)) / ((double) MBridgeCommon.DEFAULT_LOAD_TIMEOUT) >= 30.0d;
        TimeZone timeZone = DesugarTimeZone.getTimeZone("UTC");
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTimeInMillis(j11);
        Calendar calendar2 = Calendar.getInstance(timeZone);
        calendar2.setTimeInMillis(j10);
        boolean z10 = calendar.get(6) != calendar2.get(6);
        iVar2.m(79, iVar.h);
        return z9 || z10;
    }

    public final boolean t() {
        boolean z9;
        d0.i iVar = this.f805a;
        int length = iVar.t(28).length();
        o8.i iVar2 = this.f807c;
        if (length <= 0 || iVar.t(21).length() <= 0) {
            z9 = false;
        } else {
            LinkedHashMap linkedHashMap = this.f817q.f8078b;
            f6.m mVar = this.f806b;
            if (linkedHashMap.containsKey(String.valueOf(mVar.f8105m)) && n()) {
                if (kotlin.jvm.internal.l.g(h(), iVar.t(23)).equals(iVar.t(22))) {
                    int i10 = this.f816p;
                    k8.c cVar = mVar.f8097a;
                    Integer num = cVar == null ? null : cVar.f10083c;
                    if (i10 == (num == null ? i() : num.intValue()) && (iVar.t(8).length() != 0 || i9.a.e().g("tcfeuv2"))) {
                        if (m()) {
                            String strT = iVar.t(39);
                            StringBuilder sb = new StringBuilder();
                            sb.append(iVar2.f11814b.W.f11805c);
                            sb.append(iVar2.f11814b.W.f11803a);
                            if (!strT.equals(l1.b.l(sb.toString()))) {
                            }
                        }
                        z9 = false;
                    }
                }
            }
            z9 = true;
        }
        if (m()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(iVar2.f11814b.W.f11805c);
            sb2.append(iVar2.f11814b.W.f11803a);
            iVar.p(39, l1.b.l(sb2.toString()));
        }
        return z9;
    }
}
