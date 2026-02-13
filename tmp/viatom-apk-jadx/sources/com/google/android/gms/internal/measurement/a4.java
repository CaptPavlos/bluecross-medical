package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.internal.view.SupportMenu;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Status;
import com.inmobi.cmp.core.model.Vector;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a4 {

    /* renamed from: b, reason: collision with root package name */
    public static c2.d f1870b;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1871a = 5;

    public static final void A(Object[] objArr, int i10, int i11) {
        objArr.getClass();
        while (i10 < i11) {
            objArr[i10] = null;
            i10++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x00d3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0047 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void B(android.content.Context r20, t1.c r21) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.a4.B(android.content.Context, t1.c):void");
    }

    public static void C(int i10, Bundle bundle, Parcel parcel) {
        if (bundle == null) {
            return;
        }
        int I = I(parcel, i10);
        parcel.writeBundle(bundle);
        M(parcel, I);
    }

    public static void D(Parcel parcel, int i10, IBinder iBinder) {
        if (iBinder == null) {
            return;
        }
        int I = I(parcel, i10);
        parcel.writeStrongBinder(iBinder);
        M(parcel, I);
    }

    public static void E(Parcel parcel, int i10, Parcelable parcelable, int i11) {
        if (parcelable == null) {
            return;
        }
        int I = I(parcel, i10);
        parcelable.writeToParcel(parcel, i11);
        M(parcel, I);
    }

    public static void F(Parcel parcel, int i10, String str) {
        if (str == null) {
            return;
        }
        int I = I(parcel, i10);
        parcel.writeString(str);
        M(parcel, I);
    }

    public static void G(Parcel parcel, int i10, Parcelable[] parcelableArr, int i11) {
        if (parcelableArr == null) {
            return;
        }
        int I = I(parcel, i10);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i11);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        M(parcel, I);
    }

    public static void H(Parcel parcel, int i10, List list) {
        if (list == null) {
            return;
        }
        int I = I(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            Parcelable parcelable = (Parcelable) list.get(i11);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, 0);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        M(parcel, I);
    }

    public static int I(Parcel parcel, int i10) {
        parcel.writeInt(i10 | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static n J(Object obj) {
        if (obj == null) {
            return n.f2092b0;
        }
        if (obj instanceof String) {
            return new q((String) obj);
        }
        if (obj instanceof Double) {
            return new g((Double) obj);
        }
        if (obj instanceof Long) {
            return new g(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new g(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new e((Boolean) obj);
        }
        if (!(obj instanceof Map)) {
            if (!(obj instanceof List)) {
                com.google.gson.internal.a.n("Invalid value type");
                return null;
            }
            d dVar = new d();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                dVar.q(dVar.o(), J(it.next()));
            }
            return dVar;
        }
        k kVar = new k();
        Map map = (Map) obj;
        for (Object string : map.keySet()) {
            n nVarJ = J(map.get(string));
            if (string != null) {
                if (!(string instanceof String)) {
                    string = string.toString();
                }
                kVar.d((String) string, nVarJ);
            }
        }
        return kVar;
    }

    public static synchronized void K(c2.d dVar) {
        if (f1870b != null) {
            throw new IllegalStateException("init() already called");
        }
        f1870b = dVar;
    }

    public static n L(x3 x3Var) {
        if (x3Var == null) {
            return n.f2091a0;
        }
        int iX = x3Var.x() - 1;
        if (iX == 1) {
            return x3Var.r() ? new q(x3Var.s()) : n.f2098h0;
        }
        if (iX == 2) {
            return x3Var.v() ? new g(Double.valueOf(x3Var.w())) : new g(null);
        }
        if (iX == 3) {
            return x3Var.t() ? new e(Boolean.valueOf(x3Var.u())) : new e(null);
        }
        if (iX != 4) {
            com.google.gson.internal.a.n("Unknown type found. Cannot convert entity");
            return null;
        }
        List listP = x3Var.p();
        ArrayList arrayList = new ArrayList();
        Iterator it = listP.iterator();
        while (it.hasNext()) {
            arrayList.add(L((x3) it.next()));
        }
        return new o(x3Var.q(), arrayList);
    }

    public static void M(Parcel parcel, int i10) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i10 - 4);
        parcel.writeInt(iDataPosition - i10);
        parcel.setDataPosition(iDataPosition);
    }

    public static Object N(Class cls, String str, t1.c... cVarArr) {
        int length = cVarArr.length;
        Class<?>[] clsArr = new Class[length];
        Object[] objArr = new Object[length];
        for (int i10 = 0; i10 < cVarArr.length; i10++) {
            t1.c cVar = cVarArr[i10];
            cVar.getClass();
            clsArr[i10] = (Class) cVar.f12751b;
            objArr[i10] = cVarArr[i10].f12752c;
        }
        return cls.getDeclaredMethod(str, clsArr).invoke(null, objArr);
    }

    public static void O(Parcel parcel, int i10, int i11) {
        parcel.writeInt(i10 | (i11 << 16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Vector a(int i10, String str) throws h6.e {
        if (str.length() != i10) {
            throw new h6.e(kotlin.jvm.internal.l.g(": bitfield encoding length mismatch", "h.e"));
        }
        int i11 = 1;
        Vector vector = new Vector(null, i11, 0 == true ? 1 : 0);
        if (1 <= i10) {
            while (true) {
                int i12 = i11 + 1;
                String strValueOf = String.valueOf(str.charAt(i11 - 1));
                strValueOf.getClass();
                if (strValueOf.equals("1")) {
                    vector.set(i11);
                }
                if (i11 == i10) {
                    break;
                }
                i11 = i12;
            }
        }
        vector.setBitLength(str.length());
        return vector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Vector b(String str) {
        Vector vector = new Vector(null, 1, 0 == true ? 1 : 0);
        int i10 = 0;
        int i11 = 0;
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            i10++;
            i11++;
            if (cCharAt == '1') {
                vector.set(i11);
            }
        }
        return vector;
    }

    public static String c(Vector vector) {
        vector.getClass();
        kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
        xVar.f10138a = o7.u.a0(vector.getMaxId());
        vector.forEach(new h6.b(xVar, 0));
        return (String) xVar.f10138a;
    }

    public static Object d(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static void e(Parcel parcel, Parcelable parcelable, int i10) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, i10);
        }
    }

    public static final String f(Object[] objArr, int i10, int i11, t6.f fVar) {
        StringBuilder sb = new StringBuilder((i11 * 3) + 2);
        sb.append("[");
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i10 + i12];
            if (obj == fVar) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void g(StringBuilder sb, Object obj, g7.l lVar) {
        if (lVar != null) {
            sb.append((CharSequence) lVar.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) obj.toString());
        }
    }

    public static u6.c h(u6.c cVar) {
        cVar.i();
        cVar.f12947c = true;
        return cVar.f12946b > 0 ? cVar : u6.c.f12944d;
    }

    public static void i(Object obj, String str) {
        if (obj != null) {
            return;
        }
        androidx.window.layout.c.k(str);
    }

    public static final void j(Closeable closeable, Throwable th) throws IOException {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                s6.a.a(th, th2);
            }
        }
    }

    public static void k(a5.d dVar, y4.a aVar) {
        while (!aVar.g) {
            StringBuilder sb = new StringBuilder("Command is in position ");
            ArrayList arrayList = dVar.f232i;
            sb.append(arrayList.indexOf(aVar));
            sb.append(" currently executing command at position ");
            sb.append(dVar.f238o);
            sb.append(" and the number of commands is ");
            sb.append(arrayList.size());
            w(sb.toString());
            w("Processed " + aVar.f13790b + " of " + aVar.f13789a + " output from command.");
            synchronized (aVar) {
                try {
                    if (!aVar.g) {
                        aVar.wait(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!aVar.e && !aVar.g) {
                boolean z9 = dVar.f234k;
                if (!z9 && !dVar.f235l) {
                    w("Waiting for a command to be executed in a shell that is not executing and not reading! \n\n Command: ".concat(aVar.b()));
                    Exception exc = new Exception();
                    exc.setStackTrace(Thread.currentThread().getStackTrace());
                    exc.printStackTrace();
                } else if (!z9 || dVar.f235l) {
                    w("Waiting for a command to be executed in a shell that is not reading! \n\n Command: ".concat(aVar.b()));
                    Exception exc2 = new Exception();
                    exc2.setStackTrace(Thread.currentThread().getStackTrace());
                    exc2.printStackTrace();
                } else {
                    w("Waiting for a command to be executed in a shell that is executing but not reading! \n\n Command: ".concat(aVar.b()));
                    Exception exc3 = new Exception();
                    exc3.setStackTrace(Thread.currentThread().getStackTrace());
                    exc3.printStackTrace();
                }
            }
        }
    }

    public static u6.c l() {
        return new u6.c(10);
    }

    public static final z6.b m(Enum[] enumArr) {
        enumArr.getClass();
        return new z6.b(enumArr);
    }

    public static ArrayList n(JSONObject jSONObject) {
        jSONObject.getClass();
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                int iOptInt = jSONObjectOptJSONObject.optInt("id");
                h5.k kVar = new h5.k(0, (String) null, 7);
                kVar.a(jSONObjectOptJSONObject, iOptInt);
                if (iOptInt == 831) {
                    kVar.h = new ArrayList();
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("children");
                    if (jSONArrayOptJSONArray2 != null) {
                        int length2 = jSONArrayOptJSONArray2.length();
                        for (int i11 = 0; i11 < length2; i11++) {
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i11);
                            h5.k kVar2 = new h5.k(0, (String) null, 7);
                            jSONObjectOptJSONObject2.getClass();
                            kVar2.a(jSONObjectOptJSONObject2, iOptInt);
                            ArrayList arrayList2 = kVar.h;
                            arrayList2.getClass();
                            arrayList2.add(kVar2);
                        }
                    }
                }
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    public static c0.a o(Context context, GoogleSignInOptions googleSignInOptions) {
        i0.y.g(googleSignInOptions);
        return new c0.a(context, b0.a.f818a, googleSignInOptions, new g0.c(new c1.d0(14), Looper.getMainLooper()));
    }

    public static ArrayList p(JSONObject jSONObject) {
        jSONObject.getClass();
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                h5.k kVar = new h5.k(0, (String) null, 7);
                jSONObjectOptJSONObject.getClass();
                if (!jSONObjectOptJSONObject.isNull("id")) {
                    kVar.f8632a = jSONObjectOptJSONObject.optInt("id");
                }
                if (!jSONObjectOptJSONObject.isNull(RewardPlus.NAME)) {
                    kVar.f8633b = jSONObjectOptJSONObject.optString(RewardPlus.NAME);
                }
                if (!jSONObjectOptJSONObject.isNull(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
                    if (kotlin.jvm.internal.l.a(jSONObjectOptJSONObject.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY), "floatingCategory")) {
                        kVar.f8635d = true;
                    } else {
                        kVar.e = true;
                    }
                }
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    public static final Class q(m7.c cVar) {
        cVar.getClass();
        Class clsA = ((kotlin.jvm.internal.e) cVar).a();
        clsA.getClass();
        return clsA;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final Class r(m7.c cVar) {
        cVar.getClass();
        Class clsA = ((kotlin.jvm.internal.e) cVar).a();
        if (clsA.isPrimitive()) {
            String name = clsA.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals(TypedValues.Custom.S_FLOAT)) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return clsA;
    }

    public static h1.p s(Intent intent) {
        c0.c cVar;
        GoogleSignInAccount googleSignInAccount;
        a6.o oVar = d0.h.f6778a;
        Status status = Status.g;
        if (intent == null) {
            cVar = new c0.c(null, status);
        } else {
            Status status2 = (Status) intent.getParcelableExtra("googleSignInStatus");
            GoogleSignInAccount googleSignInAccount2 = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
            if (googleSignInAccount2 == null) {
                if (status2 != null) {
                    status = status2;
                }
                cVar = new c0.c(null, status);
            } else {
                cVar = new c0.c(googleSignInAccount2, Status.e);
            }
        }
        Status status3 = cVar.f975a;
        if (status3.f1858a > 0 || (googleSignInAccount = cVar.f976b) == null) {
            return r0.f.w(status3.f1860c != null ? new g0.h(status3) : new e0.m(status3));
        }
        return r0.f.x(googleSignInAccount);
    }

    public static final boolean t(TextView textView) {
        int lineCount;
        textView.getClass();
        Layout layout = textView.getLayout();
        return layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0;
    }

    public static List u(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        listSingletonList.getClass();
        return listSingletonList;
    }

    public static h5.x0 v(h5.p0 p0Var, h5.k kVar) {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        kVar.getClass();
        h5.x0 x0Var = new h5.x0(null, null, 7);
        x0Var.f8788a = kVar;
        JSONObject jSONObject = p0Var.f8699d;
        if (jSONObject != null) {
            int iOptInt = !jSONObject.isNull("success") ? jSONObject.optInt("success") : 0;
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (jSONObjectOptJSONObject3 != null) {
                if (!jSONObjectOptJSONObject3.isNull("category") && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject3.optJSONObject("category")) != null && !jSONObjectOptJSONObject2.isNull("description")) {
                    x0Var.f8788a.f8634c = jSONObjectOptJSONObject2.optString("description");
                }
                if (!jSONObjectOptJSONObject3.isNull(CampaignEx.JSON_KEY_TITLE)) {
                    x0Var.f8788a.f8633b = jSONObjectOptJSONObject3.optString(CampaignEx.JSON_KEY_TITLE);
                }
                if (!jSONObjectOptJSONObject3.isNull("description")) {
                    x0Var.f8788a.f8634c = jSONObjectOptJSONObject3.optString("description");
                }
                if (kVar.f8635d) {
                    h5.w0 w0Var = new h5.w0();
                    w0Var.f8784a = -1L;
                    w0Var.f8785b = -1;
                    w0Var.f8786c = -1;
                    w0Var.f8787d = null;
                    w0Var.e = null;
                    w0Var.f = null;
                    w0Var.g = null;
                    x0Var.f8791d = w0Var;
                    if (!jSONObjectOptJSONObject3.isNull("lastUpdate")) {
                        h5.w0 w0Var2 = x0Var.f8791d;
                        w0Var2.getClass();
                        w0Var2.f8784a = jSONObjectOptJSONObject3.optLong("lastUpdate");
                    }
                    if (!jSONObjectOptJSONObject3.isNull("totalApps")) {
                        h5.w0 w0Var3 = x0Var.f8791d;
                        w0Var3.getClass();
                        w0Var3.f8785b = jSONObjectOptJSONObject3.optInt("totalApps");
                    }
                    if (!jSONObjectOptJSONObject3.isNull("url")) {
                        h5.w0 w0Var4 = x0Var.f8791d;
                        w0Var4.getClass();
                        w0Var4.g = jSONObjectOptJSONObject3.optString("url");
                    }
                    if (!jSONObjectOptJSONObject3.isNull("editor") && (jSONObjectOptJSONObject = jSONObjectOptJSONObject3.optJSONObject("editor")) != null) {
                        if (!jSONObjectOptJSONObject.isNull("editorID")) {
                            h5.w0 w0Var5 = x0Var.f8791d;
                            w0Var5.getClass();
                            w0Var5.f8786c = jSONObjectOptJSONObject.optInt("editorID");
                        }
                        if (!jSONObjectOptJSONObject.isNull(RewardPlus.NAME)) {
                            h5.w0 w0Var6 = x0Var.f8791d;
                            w0Var6.getClass();
                            w0Var6.f8787d = jSONObjectOptJSONObject.optString(RewardPlus.NAME);
                        }
                        if (!jSONObjectOptJSONObject.isNull("avatar")) {
                            h5.w0 w0Var7 = x0Var.f8791d;
                            w0Var7.getClass();
                            w0Var7.e = jSONObjectOptJSONObject.optString("avatar");
                        }
                        if (!jSONObjectOptJSONObject.isNull("jobTitle")) {
                            h5.w0 w0Var8 = x0Var.f8791d;
                            w0Var8.getClass();
                            w0Var8.f = jSONObjectOptJSONObject.optString("jobTitle");
                        }
                    }
                }
                if (!jSONObjectOptJSONObject3.isNull("floatingCategoryRelated") && (jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray("floatingCategoryRelated")) != null) {
                    x0Var.e = new ArrayList();
                    int length = jSONArrayOptJSONArray.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i10);
                        jSONObjectOptJSONObject4.getClass();
                        h5.k kVar2 = new h5.k(0, (String) null, 7);
                        if (!jSONObjectOptJSONObject4.isNull("id")) {
                            kVar2.f8632a = jSONObjectOptJSONObject4.optInt("id");
                        }
                        if (!jSONObjectOptJSONObject4.isNull(RewardPlus.NAME)) {
                            kVar2.f8633b = jSONObjectOptJSONObject4.optString(RewardPlus.NAME);
                        }
                        kVar2.f8635d = true;
                        ArrayList arrayList = x0Var.e;
                        arrayList.getClass();
                        arrayList.add(kVar2);
                    }
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject3.optJSONArray("apps");
                if (jSONArrayOptJSONArray2 != null && iOptInt == 1 && jSONArrayOptJSONArray2.length() > 0) {
                    int length2 = jSONArrayOptJSONArray2.length();
                    for (int i11 = 0; i11 < length2; i11++) {
                        JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i11);
                        jSONObjectOptJSONObject5.getClass();
                        h5.h hVar = new h5.h();
                        hVar.a(null, jSONObjectOptJSONObject5);
                        x0Var.f8789b.add(hVar);
                    }
                }
            }
        }
        return x0Var;
    }

    public static void w(String str) {
        str.equals("");
    }

    public static void x(String str) {
        if (str != null) {
            str.equals("");
        }
    }

    public static String y(byte[] bArr) throws NoSuchAlgorithmException {
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

    public static String z(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            com.google.gson.internal.a.n("Invalid input received");
            return null;
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            sb.append(str.charAt(i10));
            if (str2.length() > i10) {
                sb.append(str2.charAt(i10));
            }
        }
        return sb.toString();
    }

    public int hashCode() {
        switch (this.f1871a) {
            case 5:
                return toString().hashCode();
            default:
                return super.hashCode();
        }
    }

    public String toString() {
        switch (this.f1871a) {
            case 5:
                String strC = kotlin.jvm.internal.y.a(getClass()).c();
                strC.getClass();
                return strC;
            default:
                return super.toString();
        }
    }
}
