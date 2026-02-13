package l1;

import android.animation.ValueAnimator;
import android.app.NotificationManager;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spanned;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import androidx.lifecycle.k;
import c1.x;
import com.google.android.gms.internal.measurement.l5;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.util.views.UsernameTextView;
import g7.p;
import g8.m0;
import h5.c1;
import h5.e1;
import h5.g1;
import h5.h1;
import h5.q;
import h5.r;
import h5.y0;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.l;
import l4.w;
import o7.m;
import o7.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import t6.j;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static UiModeManager f10167a;

    public static final void A(long j10, byte[] bArr, int i10, int i11, int i12) {
        int i13 = 7 - i11;
        int i14 = 8 - i12;
        if (i14 > i13) {
            return;
        }
        while (true) {
            int i15 = o7.c.f11754a[(int) ((j10 >> (i13 << 3)) & 255)];
            int i16 = i10 + 1;
            bArr[i10] = (byte) (i15 >> 8);
            i10 += 2;
            bArr[i16] = (byte) i15;
            if (i13 == i14) {
                return;
            } else {
                i13--;
            }
        }
    }

    public static final c8.b B(c8.b bVar) {
        bVar.getClass();
        return bVar.getDescriptor().c() ? bVar : new m0(bVar);
    }

    public static boolean C(String str) {
        return str.equals(TypedValues.TransitionType.S_DURATION) || str.equals("speed");
    }

    public static boolean D(String str) {
        return str.equals("responseCode") || str.equals("exception") || str.equals(CampaignEx.JSON_NATIVE_VIDEO_ERROR) || str.equals("extraError") || str.equals("filehashCalculated");
    }

    public static boolean E(String str) {
        return str.equals("host") || str.equals("connectionType") || str.equals("downBandwidthKbps") || str.equals("upBandwidthKbps");
    }

    public static n7.g F(p pVar) {
        n7.g gVar = new n7.g();
        gVar.f11583d = r0.f.s(pVar, gVar, gVar);
        return gVar;
    }

    public static String G(long j10) {
        return j10 < 1000 ? String.valueOf(j10) : j10 < 1000000 ? String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(j10 / 1000)}, 1)).concat("K") : String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(j10 / 1000000)}, 1)).concat("M");
    }

    public static final long H(String str) {
        char cCharAt;
        int length = str.length();
        int i10 = (length <= 0 || !m.e0("+-", str.charAt(0))) ? 0 : 1;
        if (length - i10 > 16) {
            int i11 = i10;
            while (true) {
                if (i10 < length) {
                    char cCharAt2 = str.charAt(i10);
                    if (cCharAt2 == '0') {
                        if (i11 == i10) {
                            i11++;
                        }
                    } else if ('1' > cCharAt2 || cCharAt2 >= ':') {
                        break;
                    }
                    i10++;
                } else if (length - i11 > 16) {
                    return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
            }
        }
        return (!u.c0(str, "+", false) || length <= 1 || '0' > (cCharAt = str.charAt(1)) || cCharAt >= ':') ? Long.parseLong(str) : Long.parseLong(m.f0(1, str));
    }

    public static g1 I(JSONObject jSONObject) {
        return new g1(!jSONObject.isNull("lastUpdate") ? jSONObject.optLong("lastUpdate") : -1L, !jSONObject.isNull(RewardPlus.NAME) ? jSONObject.optString(RewardPlus.NAME) : null, !jSONObject.isNull("packagename") ? jSONObject.optString("packagename") : null, jSONObject.isNull(RewardPlus.ICON) ? null : jSONObject.optString(RewardPlus.ICON));
    }

    public static void J(String str, JSONObject jSONObject, Bundle bundle) throws JSONException {
        if (str.equalsIgnoreCase("downBandwidthKbps") || str.equalsIgnoreCase("upBandwidthKbps") || str.equalsIgnoreCase("speed") || str.equalsIgnoreCase(TypedValues.TransitionType.S_DURATION)) {
            jSONObject.put(str, bundle.getLong(str));
            return;
        }
        if (str.equalsIgnoreCase("update") || str.equalsIgnoreCase("deeplink") || str.equalsIgnoreCase("notification_fcm") || str.equalsIgnoreCase("rollback")) {
            jSONObject.put(str, bundle.getInt(str));
        } else {
            jSONObject.put(str, bundle.getString(str));
        }
    }

    public static void K(UsernameTextView usernameTextView) {
        usernameTextView.getClass();
        ValueAnimator valueAnimator = usernameTextView.f6729a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        usernameTextView.f6729a = null;
        usernameTextView.f6730b = 0.0f;
        usernameTextView.f6731c = null;
        usernameTextView.f6732d = Integer.valueOf(ContextCompat.getColor(usernameTextView.getContext(), R.color.text_terciary));
        usernameTextView.e = 0L;
        usernameTextView.f = 0L;
        int i10 = UsernameTextView.f6728j;
        usernameTextView.setTurbo(false);
        usernameTextView.setUsernameFormat(null);
        usernameTextView.getPaint().setShader(null);
        Handler animationHandler = usernameTextView.getAnimationHandler();
        if (animationHandler != null) {
            animationHandler.removeCallbacksAndMessages(null);
        }
        usernameTextView.setAnimationHandler(new Handler(Looper.getMainLooper()));
        Integer num = usernameTextView.f6732d;
        num.getClass();
        usernameTextView.setTextColor(num.intValue());
        usernameTextView.invalidate();
    }

    public static String L(long j10) {
        double d8 = j10 / 1024.0d;
        if (d8 < 1024.0d) {
            return String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d8)}, 1)).concat(" KB");
        }
        double d10 = 1024;
        double d11 = d8 / d10;
        return d11 < 1024.0d ? String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d11)}, 1)).concat(" MB") : String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d11 / d10)}, 1)).concat(" GB");
    }

    public static String M(Context context, long j10) {
        context.getClass();
        double d8 = j10 / 1024.0d;
        if (d8 < 1024.0d) {
            String string = context.getString(R.string.kb_placeholder, String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d8)}, 1)));
            string.getClass();
            return string;
        }
        double d10 = 1024;
        double d11 = d8 / d10;
        if (d11 < 1024.0d) {
            String string2 = context.getString(R.string.mb_placeholder, String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d11)}, 1)));
            string2.getClass();
            return string2;
        }
        String string3 = context.getString(R.string.gb_placeholder, String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d11 / d10)}, 1)));
        string3.getClass();
        return string3;
    }

    public static int N(int i10) {
        return (int) (Integer.rotateLeft((int) (i10 * (-862048943)), 15) * 461845907);
    }

    public static final long O(int i10, p7.c cVar) {
        if (cVar.compareTo(p7.c.SECONDS) > 0) {
            return P(i10, cVar);
        }
        return z(TimeUnit.NANOSECONDS.convert(i10, cVar.f12044a));
    }

    public static final long P(long j10, p7.c cVar) {
        TimeUnit timeUnit = cVar.f12044a;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        long jConvert = timeUnit.convert(4611686018426999999L, timeUnit2);
        return ((-jConvert) > j10 || j10 > jConvert) ? x(l5.n(TimeUnit.MILLISECONDS.convert(j10, timeUnit), -4611686018427387903L, 4611686018427387903L)) : z(timeUnit2.convert(j10, timeUnit));
    }

    public static int Q(int i10) {
        int[] iArr = {1, 2, 3, 4, 5, 6};
        for (int i11 = 0; i11 < 6; i11++) {
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

    public static int R(int i10) {
        return (i10 >>> 1) ^ (-(i10 & 1));
    }

    public static long S(long j10) {
        return (j10 >>> 1) ^ (-(1 & j10));
    }

    public static final Spanned a(String str) {
        str.getClass();
        Spanned spannedFromHtml = HtmlCompat.fromHtml(u.b0(u.b0(u.b0(u.b0(u.b0(u.b0(str, "<ul>", "<customUl>", true), "</ul>", "</customUl>", true), "<ol>", "<customOl>", true), "<ol>", "</customOl>", true), "<li>", "<customLi>", true), "</li>", "</customLi>", true), 0, null, new l8.a());
        spannedFromHtml.getClass();
        return spannedFromHtml;
    }

    public static String b(int i10, String str) throws h6.e {
        if (i10 != str.length()) {
            throw new h6.e(l.g(": invalid bit length for language", "h.i"));
        }
        int length = str.length() / 2;
        l7.d dVarN = l5.N(0, length);
        dVarN.getClass();
        int iA = l5.a(length, dVarN.isEmpty() ? "" : str.substring(dVarN.f11084a, dVarN.f11085b + 1)) + 65;
        l7.d dVarN2 = l5.N(length, str.length());
        dVarN2.getClass();
        int iA2 = l5.a(length, dVarN2.isEmpty() ? "" : str.substring(dVarN2.f11084a, dVarN2.f11085b + 1)) + 65;
        StringBuilder sb = new StringBuilder();
        sb.append((char) iA);
        sb.append((char) iA2);
        return sb.toString();
    }

    public static final String c(String str) {
        str.getClass();
        return t6.l.h0(m.s0(str, new String[]{" "}), " ", null, null, c9.a.f1818b, 30);
    }

    public static final ArrayList d(String str, JSONObject jSONObject) throws JSONException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            if (jSONArray.length() > 0) {
                int length = jSONArray.length();
                int i10 = 0;
                while (i10 < length) {
                    int i11 = i10 + 1;
                    int iOptInt = jSONArray.optInt(i10);
                    Integer numValueOf = Integer.valueOf(iOptInt);
                    if (iOptInt == 0) {
                        numValueOf = null;
                    }
                    if (numValueOf != null) {
                        arrayList.add(Integer.valueOf(numValueOf.intValue()));
                    }
                    i10 = i11;
                }
            }
            return arrayList;
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    public static Object e(Parcel parcel) {
        Parcelable.Creator creator = Bundle.CREATOR;
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static void f(int i10, Bundle bundle, Parcel parcel) {
        if (bundle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, i10);
        }
    }

    public static final long g(String str) throws NumberFormatException {
        p7.c cVar;
        long jY;
        char cCharAt;
        int length = str.length();
        if (length == 0) {
            com.google.gson.internal.a.n("The string is empty");
            return 0L;
        }
        int i10 = p7.a.f12038d;
        char cCharAt2 = str.charAt(0);
        int i11 = (cCharAt2 == '+' || cCharAt2 == '-') ? 1 : 0;
        boolean z9 = i11 > 0 && str.length() > 0 && t1.n(str.charAt(0), '-', false);
        if (length <= i11) {
            com.google.gson.internal.a.n("No components");
            return 0L;
        }
        if (str.charAt(i11) != 'P') {
            z8.f.a();
            return 0L;
        }
        int i12 = i11 + 1;
        if (i12 == length) {
            z8.f.a();
            return 0L;
        }
        p7.c cVar2 = null;
        long jF = 0;
        boolean z10 = false;
        while (i12 < length) {
            if (str.charAt(i12) != 'T') {
                int i13 = i12;
                while (i13 < str.length() && (('0' <= (cCharAt = str.charAt(i13)) && cCharAt < ':') || m.e0("+-.", cCharAt))) {
                    i13++;
                }
                String strSubstring = str.substring(i12, i13);
                if (strSubstring.length() == 0) {
                    z8.f.a();
                    return 0L;
                }
                int length2 = strSubstring.length() + i12;
                if (length2 < 0 || length2 >= str.length()) {
                    com.google.gson.internal.a.n("Missing unit for value ".concat(strSubstring));
                    return 0L;
                }
                char cCharAt3 = str.charAt(length2);
                int i14 = length2 + 1;
                p7.c cVar3 = p7.c.SECONDS;
                if (z10) {
                    if (cCharAt3 == 'H') {
                        cVar = p7.c.HOURS;
                    } else if (cCharAt3 == 'M') {
                        cVar = p7.c.MINUTES;
                    } else {
                        if (cCharAt3 != 'S') {
                            throw new IllegalArgumentException("Invalid duration ISO time unit: " + cCharAt3);
                        }
                        cVar = cVar3;
                    }
                } else {
                    if (cCharAt3 != 'D') {
                        throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + cCharAt3);
                    }
                    cVar = p7.c.DAYS;
                }
                if (cVar2 != null && cVar2.compareTo(cVar) <= 0) {
                    com.google.gson.internal.a.n("Unexpected order of duration components");
                    return 0L;
                }
                int iJ0 = m.j0(strSubstring, '.', 0, 6);
                if (cVar != cVar3 || iJ0 <= 0) {
                    jF = p7.a.f(jF, P(H(strSubstring), cVar));
                } else {
                    long jF2 = p7.a.f(jF, P(H(strSubstring.substring(0, iJ0)), cVar));
                    double d8 = Double.parseDouble(strSubstring.substring(iJ0));
                    double dR = r0.f.r(d8, cVar, p7.c.NANOSECONDS);
                    if (Double.isNaN(dR)) {
                        com.google.gson.internal.a.n("Duration value cannot be NaN.");
                    } else if (Double.isNaN(dR)) {
                        com.google.gson.internal.a.n("Cannot round NaN value.");
                    } else {
                        long jRound = Math.round(dR);
                        if (-4611686018426999999L > jRound || jRound >= 4611686018427000000L) {
                            double dR2 = r0.f.r(d8, cVar, p7.c.MILLISECONDS);
                            if (Double.isNaN(dR2)) {
                                com.google.gson.internal.a.n("Cannot round NaN value.");
                            } else {
                                jY = y(Math.round(dR2));
                            }
                        } else {
                            jY = z(jRound);
                        }
                        jF = p7.a.f(jF2, jY);
                    }
                    jY = 0;
                    jF = p7.a.f(jF2, jY);
                }
                cVar2 = cVar;
                i12 = i14;
            } else {
                if (z10 || (i12 = i12 + 1) == length) {
                    z8.f.a();
                    return 0L;
                }
                z10 = true;
            }
        }
        if (!z9) {
            return jF;
        }
        long j10 = ((-(jF >> 1)) << 1) + (((int) jF) & 1);
        int i15 = p7.b.f12040a;
        return j10;
    }

    public static final void h(Context context, w wVar, h5.h hVar, g5.g gVar, boolean z9) {
        String str;
        q qVarA;
        q qVarA2;
        String str2;
        hVar.getClass();
        gVar.getClass();
        if (z9 && (str2 = hVar.f8595w) != null && str2.length() != 0) {
            v5.g gVarL = v5.g.f13148u.l(context);
            gVarL.a();
            String str3 = hVar.f8595w;
            str3.getClass();
            h5.f fVarR = gVarL.r(str3);
            String str4 = hVar.f8595w;
            str4.getClass();
            y0 y0VarM = gVarL.M(str4);
            if (y0VarM == null || y0VarM.b() || (fVarR != null && fVarR.f8532m == 1)) {
                PackageManager packageManager = context.getPackageManager();
                String str5 = hVar.f8595w;
                str5.getClass();
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str5);
                if (launchIntentForPackage != null) {
                    wVar.startActivity(launchIntentForPackage);
                    return;
                }
            }
        }
        String str6 = hVar.f8595w;
        q qVarU = null;
        if (str6 != null && str6.length() != 0) {
            boolean z10 = false;
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences.contains("is_device_tracking_registered")) {
                    z10 = sharedPreferences.getBoolean("is_device_tracking_registered", false);
                }
            } catch (Exception unused) {
            }
            if (!z10) {
                v5.g gVarL2 = v5.g.f13148u.l(context);
                gVarL2.a();
                long j10 = hVar.B;
                String str7 = hVar.f8595w;
                if (j10 > 0) {
                    str7.getClass();
                    qVarA2 = gVarL2.B(hVar.B, str7);
                } else {
                    str7.getClass();
                    qVarA2 = gVarL2.A(str7);
                }
                gVarL2.b();
                if (((qVarA2 == null || !qVarA2.c()) ? null : qVarA2.g()) != null && qVarA2 != null) {
                    gVar.h(qVarA2);
                    return;
                }
                String str8 = hVar.E;
                if (str8 == null || str8.length() == 0) {
                    String string = context.getString(R.string.download_error_message);
                    string.getClass();
                    gVar.onError(string);
                    return;
                } else {
                    if (z9) {
                        float f = UptodownApp.E;
                        qVarU = k4.c.u(hVar, context);
                    }
                    gVar.C(qVarU);
                    return;
                }
            }
        }
        if (hVar.j() && hVar.k()) {
            v5.g gVarL3 = v5.g.f13148u.l(context);
            gVarL3.a();
            long j11 = hVar.B;
            String str9 = hVar.f8595w;
            if (j11 > 0) {
                str9.getClass();
                qVarA = gVarL3.B(hVar.B, str9);
            } else {
                str9.getClass();
                qVarA = gVarL3.A(str9);
            }
            gVarL3.b();
            File fileG = (qVarA == null || !qVarA.c()) ? null : qVarA.g();
            if (fileG != null && fileG.exists()) {
                qVarA.getClass();
                gVar.h(qVarA);
                return;
            } else {
                if (z9) {
                    float f10 = UptodownApp.E;
                    qVarU = k4.c.u(hVar, context);
                }
                gVar.C(qVarU);
                return;
            }
        }
        if (!l.a(hVar.N, "ExternalDownload") || (str = hVar.Z) == null || str.length() == 0) {
            String str10 = hVar.e;
            if (str10 != null && str10.length() != 0) {
                a.a.p(wVar, hVar.e);
                return;
            }
            String string2 = context.getString(R.string.download_error_message);
            string2.getClass();
            gVar.onError(string2);
            return;
        }
        e1 e1VarH = c1.h(context);
        if (e1VarH != null && e1VarH.d()) {
            wVar.P(hVar, new androidx.work.impl.utils.c(11, gVar, hVar), new k(19));
            return;
        }
        String str11 = hVar.Z;
        str11.getClass();
        gVar.x(str11);
    }

    public static h1 i(JSONObject jSONObject) {
        h1 h1Var = new h1();
        if (!jSONObject.isNull("id")) {
            h1Var.f8605a = jSONObject.optLong("id");
        }
        if (!jSONObject.isNull("identifier")) {
            h1Var.f8606b = jSONObject.optString("identifier");
        }
        if (!jSONObject.isNull(RewardPlus.NAME)) {
            h1Var.f8607c = jSONObject.optString(RewardPlus.NAME);
        }
        if (!jSONObject.isNull("platformID")) {
            int iOptInt = jSONObject.optInt("platformID");
            h1Var.f = iOptInt;
            if (iOptInt == 1) {
                h1Var.g = "Windows";
            } else if (iOptInt == 3) {
                h1Var.g = "Mac";
            } else if (iOptInt == 13) {
                h1Var.g = "Android";
            } else if (iOptInt == 14) {
                h1Var.g = "iOS";
            }
        }
        if (!jSONObject.isNull("lastUpdate")) {
            h1Var.h = jSONObject.optLong("lastUpdate");
        }
        return h1Var;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static void j(UsernameTextView usernameTextView, boolean z9, String str) {
        usernameTextView.getClass();
        K(usernameTextView);
        ValueAnimator valueAnimator = usernameTextView.f6729a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        usernameTextView.setTurbo(z9);
        usernameTextView.setUsernameFormat(str);
        if (str != null) {
            switch (str.hashCode()) {
                case 110843959:
                    if (str.equals("type1")) {
                        usernameTextView.e = AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;
                        usernameTextView.f = 200L;
                        break;
                    }
                    break;
                case 110843960:
                    if (str.equals("type2")) {
                        usernameTextView.e = 4000L;
                        usernameTextView.f = 300L;
                        break;
                    }
                    break;
                case 110843961:
                    if (str.equals("type3")) {
                        usernameTextView.e = 3000L;
                        usernameTextView.f = 400L;
                        break;
                    }
                    break;
            }
        }
        long j10 = usernameTextView.f;
        if (usernameTextView.g) {
            usernameTextView.a();
            usernameTextView.f6733i = new Handler(Looper.getMainLooper());
            x xVar = new x(usernameTextView, j10);
            String str2 = usernameTextView.h;
            if (str2 != null) {
                switch (str2.hashCode()) {
                    case 110843959:
                        if (str2.equals("type1")) {
                            int color = ContextCompat.getColor(usernameTextView.getContext(), R.color.turbo_username_type_1_1);
                            usernameTextView.f6731c = new int[]{color, ContextCompat.getColor(usernameTextView.getContext(), R.color.turbo_username_type_1_2), color, color, color};
                            break;
                        }
                        break;
                    case 110843960:
                        if (str2.equals("type2")) {
                            int color2 = ContextCompat.getColor(usernameTextView.getContext(), R.color.turbo_username_type_2_1);
                            usernameTextView.f6731c = new int[]{color2, ContextCompat.getColor(usernameTextView.getContext(), R.color.turbo_username_type_2_2), color2, color2, color2};
                            break;
                        }
                        break;
                    case 110843961:
                        if (str2.equals("type3")) {
                            int color3 = ContextCompat.getColor(usernameTextView.getContext(), R.color.turbo_username_type_3_1);
                            usernameTextView.f6731c = new int[]{color3, ContextCompat.getColor(usernameTextView.getContext(), R.color.turbo_username_type_3_2), color3, color3, color3};
                            break;
                        }
                        break;
                }
            }
            Handler handler = usernameTextView.f6733i;
            if (handler != null) {
                handler.post(xVar);
            }
        }
    }

    public static z8.d k() throws InterruptedException {
        z8.d dVar = z8.d.f14469l;
        dVar.getClass();
        z8.d dVar2 = dVar.f;
        if (dVar2 == null) {
            long jNanoTime = System.nanoTime();
            z8.d.f14466i.await(z8.d.f14467j, TimeUnit.MILLISECONDS);
            z8.d dVar3 = z8.d.f14469l;
            dVar3.getClass();
            if (dVar3.f != null || System.nanoTime() - jNanoTime < z8.d.f14468k) {
                return null;
            }
            return z8.d.f14469l;
        }
        long jNanoTime2 = dVar2.g - System.nanoTime();
        if (jNanoTime2 > 0) {
            z8.d.f14466i.await(jNanoTime2, TimeUnit.NANOSECONDS);
            return null;
        }
        z8.d dVar4 = z8.d.f14469l;
        dVar4.getClass();
        dVar4.f = dVar2.f;
        dVar2.f = null;
        return dVar2;
    }

    public static final String l(String str) throws NoSuchAlgorithmException {
        str.getClass();
        MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
        byte[] bytes = str.getBytes(o7.a.f11749a);
        bytes.getClass();
        byte[] bArrDigest = messageDigest.digest(bytes);
        bArrDigest.getClass();
        return j.w0("", 30, bArrDigest);
    }

    public static final ArrayList m(String str, JSONObject jSONObject) throws JSONException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            if (jSONArray.length() > 0) {
                int length = jSONArray.length();
                int i10 = 0;
                while (i10 < length) {
                    int i11 = i10 + 1;
                    String strOptString = jSONArray.optString(i10);
                    strOptString.getClass();
                    if (strOptString.length() <= 0) {
                        strOptString = null;
                    }
                    if (strOptString != null) {
                        arrayList.add(strOptString);
                    }
                    i10 = i11;
                }
            }
            return arrayList;
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    public static String n(int i10, int i11, String str) {
        if (i10 < 0) {
            return r0.f.H("%s (%s) must not be negative", str, Integer.valueOf(i10));
        }
        if (i11 >= 0) {
            return r0.f.H("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i11);
        throw new IllegalArgumentException(sb.toString());
    }

    public static u6.i o(u6.i iVar) {
        u6.f fVar = iVar.f12969a;
        fVar.c();
        return fVar.f12960i > 0 ? iVar : u6.i.f12968b;
    }

    public static final void p(long j10, Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (a.a.D(j10)) {
            a.a.l(str);
            Object systemService = context.getSystemService("notification");
            systemService.getClass();
            ((NotificationManager) systemService).cancel(261);
            return;
        }
        if (a.a.F(str)) {
            a.a.l(str);
            return;
        }
        v5.g gVarL = v5.g.f13148u.l(context);
        gVarL.a();
        q qVarA = gVarL.A(str);
        if (qVarA != null) {
            if (qVarA.o()) {
                gVarL.j(qVarA);
            } else {
                Iterator it = qVarA.f8716v.iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    r rVar = (r) next;
                    rVar.f = 0L;
                    rVar.f8724i = 0;
                    gVarL.e0(rVar);
                }
            }
        }
        gVarL.b();
    }

    public static void q(int i10, int i11) {
        String strH;
        if (i10 < 0 || i10 >= i11) {
            if (i10 < 0) {
                strH = r0.f.H("%s (%s) must not be negative", "index", Integer.valueOf(i10));
            } else {
                if (i11 < 0) {
                    StringBuilder sb = new StringBuilder(26);
                    sb.append("negative size: ");
                    sb.append(i11);
                    throw new IllegalArgumentException(sb.toString());
                }
                strH = r0.f.H("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i10), Integer.valueOf(i11));
            }
            throw new IndexOutOfBoundsException(strH);
        }
    }

    public static final void r(int i10, String str) {
        if (str.charAt(i10) == '-') {
            return;
        }
        StringBuilder sbR = a3.a.r(i10, "Expected '-' (hyphen) at index ", ", but was '");
        sbR.append(str.charAt(i10));
        sbR.append('\'');
        throw new IllegalArgumentException(sbR.toString().toString());
    }

    public static void s(int i10, int i11) {
        if (i10 < 0 || i10 > i11) {
            p8.u.k(n(i10, i11, "index"));
        }
    }

    public static void t(int i10, int i11, int i12) {
        if (i10 < 0 || i11 < i10 || i11 > i12) {
            throw new IndexOutOfBoundsException((i10 < 0 || i10 > i12) ? n(i10, i12, "start index") : (i11 < 0 || i11 > i12) ? n(i11, i12, "end index") : r0.f.H("end index (%s) must not be less than start index (%s)", Integer.valueOf(i11), Integer.valueOf(i10)));
        }
    }

    public static int u(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static String v(String str, String str2) {
        String strConcat = "uptodown.native.1.".concat(str);
        if (str2 == null) {
            return strConcat;
        }
        return strConcat + '.' + str2;
    }

    public static boolean w(File file) {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                file2.getClass();
                w(file2);
            }
        }
        return file.delete();
    }

    public static final long x(long j10) {
        long j11 = (j10 << 1) + 1;
        int i10 = p7.a.f12038d;
        int i11 = p7.b.f12040a;
        return j11;
    }

    public static final long y(long j10) {
        return (-4611686018426L > j10 || j10 >= 4611686018427L) ? x(l5.n(j10, -4611686018427387903L, 4611686018427387903L)) : z(j10 * 1000000);
    }

    public static final long z(long j10) {
        long j11 = j10 << 1;
        int i10 = p7.a.f12038d;
        int i11 = p7.b.f12040a;
        return j11;
    }
}
