package a;

import a3.z0;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.internal.view.SupportMenu;
import androidx.lifecycle.k;
import androidx.viewbinding.ViewBindings;
import androidx.window.layout.c;
import com.google.android.gms.internal.measurement.a4;
import com.google.android.gms.internal.measurement.n;
import com.google.android.gms.internal.measurement.r;
import com.google.android.gms.internal.measurement.w;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.uptodown.R;
import com.uptodown.workers.DownloadWorker;
import e8.d;
import e8.i;
import f9.p;
import g8.u0;
import g8.v0;
import h5.e;
import h5.f;
import h5.j;
import h5.q;
import j$.util.DesugarTimeZone;
import j0.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.y;
import l4.x2;
import o7.m;
import o7.u;
import org.json.JSONObject;
import v5.g;
import y5.i0;
import z1.t1;
import z5.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f0a;

    /* renamed from: b, reason: collision with root package name */
    public static int f1b;

    /* renamed from: c, reason: collision with root package name */
    public static int f2c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f3d;

    public static j A(JSONObject jSONObject) {
        j jVar = new j();
        if (!jSONObject.isNull("id")) {
            jVar.f8621a = jSONObject.optLong("id");
        }
        if (!jSONObject.isNull("sha256")) {
            jSONObject.optString("sha256");
        }
        if (!jSONObject.isNull("active")) {
            jVar.f8622b = jSONObject.optInt("active");
        }
        if (!jSONObject.isNull("url")) {
            jVar.f8623c = jSONObject.optString("url");
        }
        if (!jSONObject.isNull("isTurbo")) {
            jSONObject.optInt("isTurbo");
        }
        return jVar;
    }

    public static String B() throws NoSuchAlgorithmException {
        DateFormat timeInstance = DateFormat.getTimeInstance();
        timeInstance.setTimeZone(DesugarTimeZone.getTimeZone("gmt"));
        timeInstance.format(new Date(System.currentTimeMillis()));
        String strH = a3.a.h((timeInstance.getCalendar().getTimeInMillis() - (((r0.get(12) * MBridgeCommon.DEFAULT_LOAD_TIMEOUT) + (r0.get(13) * 1000)) + r0.get(14))) / 1000, "$(=a%·!45J&S");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            Charset charsetForName = Charset.forName(C.UTF8_NAME);
            charsetForName.getClass();
            byte[] bytes = strH.getBytes(charsetForName);
            bytes.getClass();
            byte[] bArrDigest = messageDigest.digest(bytes);
            StringBuilder sb = new StringBuilder();
            bArrDigest.getClass();
            for (byte b10 : bArrDigest) {
                t1.k(16);
                String string = Integer.toString((b10 & 255) + 256, 16);
                string.getClass();
                sb.append(string.substring(1));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean C(String str) {
        return str.equals(ShareTarget.METHOD_POST) || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean D(long j10) {
        q qVar = DownloadWorker.f6738d;
        return qVar != null && qVar.h == j10;
    }

    public static boolean E(q qVar) {
        q qVar2 = DownloadWorker.f6738d;
        if (qVar2 == null || qVar2.h != qVar.h) {
            return false;
        }
        qVar2.getClass();
        return qVar2.e == qVar.e;
    }

    public static boolean F(String str) {
        str.getClass();
        q qVar = DownloadWorker.f6738d;
        return qVar != null && l.a(qVar.f8701b, str);
    }

    public static boolean G(String str) {
        return (str.equals(ShareTarget.METHOD_GET) || str.equals("HEAD")) ? false : true;
    }

    public static void H(Context context, f fVar, Bundle bundle) {
        int i10;
        context.getClass();
        int i11 = 0;
        if (fVar != null && (i10 = context.getSharedPreferences("SettingsPreferences", 0).getInt("downloadID_to_rollback", -1)) >= 0) {
            g gVarL = g.f13148u.l(context);
            gVarL.a();
            if (gVarL.z(i10) != null) {
                fVar.f8532m = 1;
                fVar.g = e.f8507b;
                gVarL.Z(fVar);
                String str = fVar.f8526c;
                str.getClass();
                gVarL.m(str);
                r0.f.o(context);
                try {
                    SharedPreferences.Editor editorEdit = context.getSharedPreferences("SettingsPreferences", 0).edit();
                    editorEdit.putInt("downloadID_to_rollback", -1);
                    editorEdit.apply();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i11 = 1;
            }
            gVarL.b();
        }
        bundle.putInt("rollback", i11);
    }

    public static boolean I(Parcel parcel, int i10) {
        U(parcel, i10, 4);
        return parcel.readInt() != 0;
    }

    public static final byte[] J(InputStream inputStream) throws IOException {
        inputStream.getClass();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        n(inputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArray.getClass();
        return byteArray;
    }

    public static IBinder K(Parcel parcel, int i10) {
        int iN = N(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iN == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iN);
        return strongBinder;
    }

    public static int L(Parcel parcel, int i10) {
        U(parcel, i10, 4);
        return parcel.readInt();
    }

    public static long M(Parcel parcel, int i10) {
        U(parcel, i10, 8);
        return parcel.readLong();
    }

    public static int N(Parcel parcel, int i10) {
        return (i10 & SupportMenu.CATEGORY_MASK) != -65536 ? (char) (i10 >> 16) : parcel.readInt();
    }

    public static void O(Parcel parcel, int i10) {
        parcel.setDataPosition(parcel.dataPosition() + N(parcel, i10));
    }

    public static void P(ProgressBar progressBar, ImageView imageView) {
        progressBar.getClass();
        imageView.getClass();
        if (progressBar.getVisibility() == 8) {
            progressBar.setVisibility(0);
            progressBar.getContext().getClass();
            k kVar = new k(19);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.6f);
            valueAnimatorOfFloat.setDuration(300L);
            valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new z5.g(imageView, 0));
            valueAnimatorOfFloat.addListener(new h(kVar, 1));
            valueAnimatorOfFloat.start();
        }
    }

    public static int Q(Parcel parcel) {
        int i10 = parcel.readInt();
        int iN = N(parcel, i10);
        char c10 = (char) i10;
        int iDataPosition = parcel.dataPosition();
        if (c10 != 20293) {
            throw new b("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(i10))), parcel);
        }
        int i11 = iN + iDataPosition;
        if (i11 < iDataPosition || i11 > parcel.dataSize()) {
            throw new b(androidx.constraintlayout.core.widgets.analyzer.a.u(iDataPosition, i11, "Size read is invalid start=", " end="), parcel);
        }
        return i11;
    }

    public static String R(Object... objArr) {
        int length;
        int length2;
        int iIndexOf;
        String string;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            length = objArr.length;
            if (i11 >= length) {
                break;
            }
            Object obj = objArr[i11];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e) {
                    String strJ = a3.a.j(obj.getClass().getName(), "@", Integer.toHexString(System.identityHashCode(obj)));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(strJ), (Throwable) e);
                    string = "<" + strJ + " threw " + e.getClass().getName() + ">";
                }
            }
            objArr[i11] = string;
            i11++;
        }
        StringBuilder sb = new StringBuilder((length * 16) + 29);
        int i12 = 0;
        while (true) {
            length2 = objArr.length;
            if (i10 >= length2 || (iIndexOf = "expected a non-null reference".indexOf("%s", i12)) == -1) {
                break;
            }
            sb.append((CharSequence) "expected a non-null reference", i12, iIndexOf);
            sb.append(objArr[i10]);
            i10++;
            i12 = iIndexOf + 2;
        }
        sb.append((CharSequence) "expected a non-null reference", i12, 29);
        if (i10 < length2) {
            sb.append(" [");
            sb.append(objArr[i10]);
            for (int i13 = i10 + 1; i13 < objArr.length; i13++) {
                sb.append(", ");
                sb.append(objArr[i13]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static void S(Parcel parcel, int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        throw new b(a3.a.o(a3.a.q(i11, i10, "Expected size ", " got ", " (0x"), Integer.toHexString(i10), ")"), parcel);
    }

    public static void T(List list, String str, int i10) {
        if (list.size() == i10) {
            return;
        }
        c.e(i10, str, list.size(), " operation requires ");
    }

    public static void U(Parcel parcel, int i10, int i11) {
        int iN = N(parcel, i10);
        if (iN == i11) {
            return;
        }
        throw new b(a3.a.o(a3.a.q(i11, iN, "Expected size ", " got ", " (0x"), Integer.toHexString(iN), ")"), parcel);
    }

    public static void V(List list, String str, int i10) {
        if (list.size() >= i10) {
            return;
        }
        c.e(i10, str, list.size(), " operation requires at least ");
    }

    public static void W(int i10, String str, ArrayList arrayList) {
        if (arrayList.size() <= i10) {
            return;
        }
        c.e(i10, str, arrayList.size(), " operation requires at most ");
    }

    public static boolean X(n nVar) {
        if (nVar == null) {
            return false;
        }
        Double dG = nVar.g();
        return !dG.isNaN() && dG.doubleValue() >= 0.0d && dG.equals(Double.valueOf(Math.floor(dG.doubleValue())));
    }

    public static w Y(String str) throws NumberFormatException {
        w wVar = null;
        if (str != null && !str.isEmpty()) {
            wVar = (w) w.f2238u0.get(Integer.valueOf(Integer.parseInt(str)));
        }
        if (wVar != null) {
            return wVar;
        }
        com.google.gson.internal.a.n(a3.a.i("Unsupported commandId ", str));
        return null;
    }

    public static boolean Z(n nVar, n nVar2) {
        if (!nVar.getClass().equals(nVar2.getClass())) {
            return false;
        }
        if ((nVar instanceof r) || (nVar instanceof com.google.android.gms.internal.measurement.l)) {
            return true;
        }
        if (!(nVar instanceof com.google.android.gms.internal.measurement.g)) {
            return nVar instanceof com.google.android.gms.internal.measurement.q ? nVar.f().equals(nVar2.f()) : nVar instanceof com.google.android.gms.internal.measurement.e ? nVar.e().equals(nVar2.e()) : nVar == nVar2;
        }
        if (Double.isNaN(nVar.g().doubleValue()) || Double.isNaN(nVar2.g().doubleValue())) {
            return false;
        }
        return nVar.g().equals(nVar2.g());
    }

    public static final u0 a(String str, d dVar) {
        if (m.l0(str)) {
            com.google.gson.internal.a.n("Blank serial names are prohibited");
            return null;
        }
        Iterator it = ((u6.h) v0.f8336a.values()).iterator();
        while (((u6.d) it).hasNext()) {
            c8.b bVar = (c8.b) ((u6.d) it).next();
            if (str.equals(bVar.getDescriptor().a())) {
                StringBuilder sbY = a3.a.y("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name ", str, " there already exists ");
                sbY.append(y.a(bVar.getClass()).c());
                sbY.append(".\n                Please refer to SerialDescriptor documentation for additional information.\n            ");
                com.google.gson.internal.a.n(o7.n.Q(sbY.toString()));
                return null;
            }
        }
        return new u0(str, dVar);
    }

    public static int a0(double d8) {
        if (Double.isNaN(d8) || Double.isInfinite(d8) || d8 == 0.0d) {
            return 0;
        }
        return (int) (((d8 > 0.0d ? 1 : -1) * Math.floor(Math.abs(d8))) % 4.294967296E9d);
    }

    public static int b(String str, int i10) {
        return androidx.constraintlayout.core.widgets.analyzer.a.o(i10, 31, str);
    }

    public static double b0(double d8) {
        if (Double.isNaN(d8)) {
            return 0.0d;
        }
        if (Double.isInfinite(d8) || d8 == 0.0d || d8 == 0.0d) {
            return d8;
        }
        return (d8 > 0.0d ? 1 : -1) * Math.floor(Math.abs(d8));
    }

    public static long c(int i10, String str) throws h6.e, NumberFormatException {
        long j10;
        if (i10 != str.length()) {
            throw new h6.e(l.g(": invalid bit length", "h.b"));
        }
        if (i10 != str.length()) {
            d6.b.b(null, ChoiceError.ENCODE_INVALID_BIT_LENGTH.getMessage(), null, 5);
            j10 = -1;
        } else {
            t1.k(2);
            j10 = Long.parseLong(str, 2);
        }
        return j10 * 100;
    }

    public static Object c0(n nVar) {
        if (n.f2092b0.equals(nVar)) {
            return null;
        }
        if (n.f2091a0.equals(nVar)) {
            return "";
        }
        if (nVar instanceof com.google.android.gms.internal.measurement.k) {
            return d0((com.google.android.gms.internal.measurement.k) nVar);
        }
        if (!(nVar instanceof com.google.android.gms.internal.measurement.d)) {
            return !nVar.g().isNaN() ? nVar.g() : nVar.f();
        }
        ArrayList arrayList = new ArrayList();
        com.google.android.gms.internal.measurement.d dVar = (com.google.android.gms.internal.measurement.d) nVar;
        int i10 = 0;
        while (i10 < dVar.o()) {
            if (i10 >= dVar.o()) {
                StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 21);
                sb.append("Out of bounds index: ");
                sb.append(i10);
                throw new NoSuchElementException(sb.toString());
            }
            int i11 = i10 + 1;
            Object objC0 = c0(dVar.p(i10));
            if (objC0 != null) {
                arrayList.add(objC0);
            }
            i10 = i11;
        }
        return arrayList;
    }

    public static /* synthetic */ String d(int i10) {
        switch (i10) {
            case 1:
                return "FEATURE";
            case 2:
                return "NON_IAB";
            case 3:
                return "PURPOSES";
            case 4:
                return "LEGITIMATE_PURPOSES";
            case 5:
                return "LEGITIMATE_VENDORS";
            case 6:
                return "SPECIAL_PURPOSES";
            case 7:
                return "SPECIAL_FEATURES";
            case 8:
                return "VENDORS";
            case 9:
                return "STACKS";
            case 10:
                return "GOOGLE";
            default:
                return "null";
        }
    }

    public static HashMap d0(com.google.android.gms.internal.measurement.k kVar) {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList(kVar.f2020a.keySet());
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            String str = (String) obj;
            Object objC0 = c0(kVar.c(str));
            if (objC0 != null) {
                map.put(str, objC0);
            }
        }
        return map;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, java.util.Map] */
    public static String e(String str) throws h6.e {
        String string;
        str.getClass();
        Pattern patternCompile = Pattern.compile("^[A-Za-z0-9\\-_]+$");
        patternCompile.getClass();
        if (!patternCompile.matcher(str).matches()) {
            Object obj = h6.a.f8807a;
            throw new h6.e(l.g(": Invalidly encoded Base64URL string", "g.b"));
        }
        int length = str.length();
        String string2 = "";
        int i10 = 0;
        while (i10 < length) {
            char cCharAt = str.charAt(i10);
            i10++;
            Integer num = (Integer) h6.a.f8807a.get(String.valueOf(cCharAt));
            if (num == null) {
                string = null;
            } else {
                int iIntValue = num.intValue();
                t1.k(2);
                string = Integer.toString(iIntValue, 2);
                string.getClass();
            }
            if (string != null) {
                StringBuilder sbV = a3.a.v(string2);
                sbV.append(u.a0(6 - string.length()));
                sbV.append((Object) string);
                string2 = sbV.toString();
            }
        }
        return string2;
    }

    public static void e0(w2.r rVar) {
        int iA0 = a0(rVar.R("runtime.counter").g().doubleValue() + 1.0d);
        if (iA0 <= 1000000) {
            rVar.P("runtime.counter", new com.google.android.gms.internal.measurement.g(Double.valueOf(iA0)));
        } else {
            c.g("Instructions allowed exceeded");
        }
    }

    public static String f(HashMap map) {
        StringBuilder sb = new StringBuilder();
        boolean z9 = true;
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (z9) {
                z9 = false;
            } else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(str, C.UTF8_NAME));
            sb.append("=");
            sb.append(URLEncoder.encode(str2, C.UTF8_NAME));
        }
        return sb.toString();
    }

    public static final boolean g(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (l.c(cCharAt, 128) >= 0 || Character.isLetter(cCharAt)) {
                return true;
            }
        }
        return false;
    }

    public static String h(String str) throws h6.e {
        Pattern patternCompile = Pattern.compile("^[0-1]+$");
        patternCompile.getClass();
        if (!patternCompile.matcher(str).matches()) {
            Object obj = h6.a.f8807a;
            throw new h6.e("g.b: invalid bitField + ".concat(str));
        }
        int length = str.length();
        int i10 = 0;
        ArrayList arrayList = new ArrayList((length / 6) + (length % 6 == 0 ? 0 : 1));
        int i11 = 0;
        while (i11 >= 0 && i11 < length) {
            int i12 = i11 + 6;
            CharSequence charSequenceSubSequence = str.subSequence(i11, (i12 < 0 || i12 > length) ? length : i12);
            charSequenceSubSequence.getClass();
            arrayList.add(charSequenceSubSequence.toString());
            i11 = i12;
        }
        int size = arrayList.size();
        String strG = "";
        while (i10 < size) {
            Object obj2 = arrayList.get(i10);
            i10++;
            strG = l.g(Character.valueOf("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(Integer.parseInt((String) obj2, 2))), strG);
        }
        return strG;
    }

    public static e8.f i(String str, e8.e[] eVarArr) {
        if (m.l0(str)) {
            com.google.gson.internal.a.n("Blank serial names are prohibited");
            return null;
        }
        e8.a aVar = new e8.a(str);
        return new e8.f(str, i.f7973c, aVar.f7951b.size(), t6.j.y0(eVarArr), aVar);
    }

    public static final e8.f j(String str, a4 a4Var, e8.e[] eVarArr, g7.l lVar) {
        if (m.l0(str)) {
            com.google.gson.internal.a.n("Blank serial names are prohibited");
            return null;
        }
        if (a4Var.equals(i.f7973c)) {
            com.google.gson.internal.a.n("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
            return null;
        }
        e8.a aVar = new e8.a(str);
        lVar.invoke(aVar);
        return new e8.f(str, a4Var, aVar.f7951b.size(), t6.j.y0(eVarArr), aVar);
    }

    public static e8.f k(String str, a4 a4Var, e8.e[] eVarArr) {
        if (m.l0(str)) {
            com.google.gson.internal.a.n("Blank serial names are prohibited");
            return null;
        }
        if (a4Var.equals(i.f7973c)) {
            com.google.gson.internal.a.n("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
            return null;
        }
        e8.a aVar = new e8.a(str);
        return new e8.f(str, a4Var, aVar.f7951b.size(), t6.j.y0(eVarArr), aVar);
    }

    public static void l(String str) {
        str.getClass();
        q qVar = DownloadWorker.f6738d;
        if (l.a(qVar != null ? qVar.f8701b : null, str)) {
            DownloadWorker.f = false;
            DownloadWorker.e = true;
        }
    }

    public static final void m(int i10, int i11) {
        if (i10 <= i11) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i10 + ") is greater than size (" + i11 + ").");
    }

    public static long n(InputStream inputStream, OutputStream outputStream) throws IOException {
        inputStream.getClass();
        byte[] bArr = new byte[8192];
        int i10 = inputStream.read(bArr);
        long j10 = 0;
        while (i10 >= 0) {
            outputStream.write(bArr, 0, i10);
            j10 += i10;
            i10 = inputStream.read(bArr);
        }
        return j10;
    }

    public static q1.a o(String str, String str2) {
        y2.a aVar = new y2.a(str, str2);
        p pVarA = q1.a.a(y2.a.class);
        pVarA.f8177b = 1;
        pVarA.f = new androidx.core.view.inputmethod.a(aVar, 23);
        return pVarA.d();
    }

    public static final void p(l4.w wVar, String str) {
        if (wVar.isFinishing() || str == null || str.length() == 0) {
            return;
        }
        AlertDialog alertDialog = wVar.f10935w;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(wVar);
        z0 z0VarK = z0.k(wVar.getLayoutInflater());
        TextView textView = (TextView) z0VarK.f197c;
        TextView textView2 = (TextView) z0VarK.f198d;
        TextView textView3 = (TextView) z0VarK.e;
        textView2.setTypeface(o4.b.f11720s);
        textView2.setText(wVar.getString(R.string.go_to_web_dialog_message));
        textView.setTypeface(o4.b.f11719r);
        textView.setOnClickListener(new l4.n(wVar, 5));
        textView3.setTypeface(o4.b.f11719r);
        textView3.setText(wVar.getString(R.string.open_web));
        textView3.setOnClickListener(new i0(10, wVar, str));
        builder.setView((LinearLayout) z0VarK.f);
        builder.setCancelable(true);
        AlertDialog alertDialog2 = wVar.f10935w;
        if (alertDialog2 == null || !alertDialog2.isShowing()) {
            AlertDialog alertDialogCreate = builder.create();
            wVar.f10935w = alertDialogCreate;
            alertDialogCreate.getClass();
            Window window = alertDialogCreate.getWindow();
            if (window != null) {
                a3.a.A(window, 0);
            }
            AlertDialog alertDialog3 = wVar.f10935w;
            alertDialog3.getClass();
            alertDialog3.show();
        }
    }

    public static final void q(l4.w wVar, String str, String str2) {
        wVar.getClass();
        if (wVar.isFinishing()) {
            return;
        }
        AlertDialog alertDialog = wVar.f10935w;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(wVar);
        View viewInflate = wVar.getLayoutInflater().inflate(R.layout.dialog_login_required, (ViewGroup) null, false);
        int i10 = R.id.iv_close_dialog_login_required;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_close_dialog_login_required);
        if (imageView != null) {
            i10 = R.id.tv_login_dialog_login_required;
            TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_login_dialog_login_required);
            if (textView != null) {
                i10 = R.id.tv_msg_dialog_login_required;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_msg_dialog_login_required);
                if (textView2 != null) {
                    i10 = R.id.tv_title_dialog_login_required;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_dialog_login_required);
                    if (textView3 != null) {
                        textView3.setTypeface(o4.b.f11719r);
                        textView3.setText(str);
                        textView2.setTypeface(o4.b.f11720s);
                        textView2.setText(str2);
                        textView.setTypeface(o4.b.f11719r);
                        textView.setOnClickListener(new l4.n(wVar, 3));
                        imageView.setOnClickListener(new l4.n(wVar, 4));
                        builder.setView((RelativeLayout) viewInflate);
                        builder.setCancelable(true);
                        AlertDialog alertDialog2 = wVar.f10935w;
                        if (alertDialog2 == null || !alertDialog2.isShowing()) {
                            AlertDialog alertDialogCreate = builder.create();
                            wVar.f10935w = alertDialogCreate;
                            alertDialogCreate.getClass();
                            Window window = alertDialogCreate.getWindow();
                            if (window != null) {
                                a3.a.A(window, 0);
                            }
                            AlertDialog alertDialog3 = wVar.f10935w;
                            alertDialog3.getClass();
                            alertDialog3.show();
                            return;
                        }
                        return;
                    }
                }
            }
        }
        c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i10)));
    }

    public static Bundle r(Parcel parcel, int i10) {
        int iN = N(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iN == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iN);
        return bundle;
    }

    public static Parcelable s(Parcel parcel, int i10, Parcelable.Creator creator) {
        int iN = N(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iN == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iN);
        return parcelable;
    }

    public static String t(Parcel parcel, int i10) {
        int iN = N(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iN == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iN);
        return string;
    }

    public static Object[] u(Parcel parcel, int i10, Parcelable.Creator creator) {
        int iN = N(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iN == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iN);
        return objArrCreateTypedArray;
    }

    public static ArrayList v(Parcel parcel, int i10, Parcelable.Creator creator) {
        int iN = N(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iN == 0) {
            return null;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iN);
        return arrayListCreateTypedArrayList;
    }

    public static void w(ArrayList arrayList) {
        HashMap map = new HashMap(arrayList.size());
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            q1.a aVar = (q1.a) obj;
            q1.g gVar = new q1.g(aVar);
            for (q1.q qVar : aVar.f12220b) {
                boolean z9 = aVar.e == 0;
                q1.h hVar = new q1.h(qVar, !z9);
                if (!map.containsKey(hVar)) {
                    map.put(hVar, new HashSet());
                }
                Set set = (Set) map.get(hVar);
                if (!set.isEmpty() && z9) {
                    androidx.core.view.accessibility.a.j(qVar, "Multiple components provide ", ".");
                    return;
                }
                set.add(gVar);
            }
        }
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            for (q1.g gVar2 : (Set) it.next()) {
                for (q1.i iVar : gVar2.f12230a.f12221c) {
                    if (iVar.f12237c == 0) {
                        Set<q1.g> set2 = (Set) map.get(new q1.h(iVar.f12235a, iVar.f12236b == 2));
                        if (set2 != null) {
                            for (q1.g gVar3 : set2) {
                                gVar2.f12231b.add(gVar3);
                                gVar3.f12232c.add(gVar2);
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        Iterator it2 = map.values().iterator();
        while (it2.hasNext()) {
            hashSet.addAll((Set) it2.next());
        }
        HashSet hashSet2 = new HashSet();
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            q1.g gVar4 = (q1.g) it3.next();
            if (gVar4.f12232c.isEmpty()) {
                hashSet2.add(gVar4);
            }
        }
        while (!hashSet2.isEmpty()) {
            q1.g gVar5 = (q1.g) hashSet2.iterator().next();
            hashSet2.remove(gVar5);
            i10++;
            Iterator it4 = gVar5.f12231b.iterator();
            while (it4.hasNext()) {
                q1.g gVar6 = (q1.g) it4.next();
                gVar6.f12232c.remove(gVar5);
                if (gVar6.f12232c.isEmpty()) {
                    hashSet2.add(gVar6);
                }
            }
        }
        if (i10 == arrayList.size()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it5 = hashSet.iterator();
        while (it5.hasNext()) {
            q1.g gVar7 = (q1.g) it5.next();
            if (!gVar7.f12232c.isEmpty() && !gVar7.f12231b.isEmpty()) {
                arrayList2.add(gVar7.f12230a);
            }
        }
        throw new q1.j("Dependency cycle detected: " + Arrays.toString(arrayList2.toArray()));
    }

    public static void x(ProgressBar progressBar, ImageView imageView) {
        progressBar.getClass();
        imageView.getClass();
        if (progressBar.getVisibility() == 0) {
            progressBar.getContext().getClass();
            x2 x2Var = new x2(progressBar, 29);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.6f, 1.0f);
            valueAnimatorOfFloat.setStartDelay(200L);
            valueAnimatorOfFloat.setDuration(300L);
            valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new z5.g(imageView, 1));
            valueAnimatorOfFloat.addListener(new h(x2Var, 0));
            valueAnimatorOfFloat.start();
        }
    }

    public static void y(Parcel parcel, int i10) {
        if (parcel.dataPosition() != i10) {
            throw new b(a3.a.f(i10, "Overread allowed size end="), parcel);
        }
    }

    public static q1.a z(String str, com.google.gson.internal.a aVar) {
        p pVarA = q1.a.a(y2.a.class);
        pVarA.f8177b = 1;
        pVarA.c(q1.i.a(Context.class));
        pVarA.f = new androidx.privacysandbox.ads.adservices.java.internal.a(10, str, aVar);
        return pVarA.d();
    }
}
