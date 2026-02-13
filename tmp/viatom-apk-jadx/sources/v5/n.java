package v5;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import androidx.core.content.ContextCompat;
import com.google.android.gms.internal.measurement.l5;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.uptodown.R;
import j$.util.DesugarTimeZone;
import j$.util.concurrent.ConcurrentHashMap;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f13169a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final i5.f f13170b = new i5.f(0, null);

    /* renamed from: c, reason: collision with root package name */
    public static final i5.d f13171c = new i5.d(null);

    /* renamed from: d, reason: collision with root package name */
    public static final ArrayList f13172d = new ArrayList();
    public static final ArrayList e = new ArrayList();

    public static Spanned a(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            Spanned spannedFromHtml = Html.fromHtml(str, 0);
            spannedFromHtml.getClass();
            return spannedFromHtml;
        }
        Spanned spannedFromHtml2 = Html.fromHtml(str);
        spannedFromHtml2.getClass();
        return spannedFromHtml2;
    }

    public static String b() {
        DateFormat timeInstance = DateFormat.getTimeInstance();
        timeInstance.setTimeZone(DesugarTimeZone.getTimeZone("gmt"));
        timeInstance.format(new Date(System.currentTimeMillis()));
        String strH = a3.a.h((timeInstance.getCalendar().getTimeInMillis() - (((r0.get(12) * MBridgeCommon.DEFAULT_LOAD_TIMEOUT) + (r0.get(13) * 1000)) + r0.get(14))) / 1000, "$(=a%·!45J&S");
        Charset charsetForName = Charset.forName(C.UTF8_NAME);
        charsetForName.getClass();
        byte[] bytes = strH.getBytes(charsetForName);
        bytes.getClass();
        return l5.x(bytes);
    }

    public static Drawable c(Context context, String str) {
        Drawable drawableLoadIcon;
        context.getClass();
        if (str != null) {
            ConcurrentHashMap concurrentHashMap = f13169a;
            drawableLoadIcon = (Drawable) concurrentHashMap.get(str);
            if (drawableLoadIcon == null) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    packageManager.getClass();
                    ApplicationInfo applicationInfo = l5.a.f(packageManager, str, 0).applicationInfo;
                    if (applicationInfo != null) {
                        drawableLoadIcon = applicationInfo.loadIcon(context.getPackageManager());
                        concurrentHashMap.put(str, drawableLoadIcon);
                    }
                } catch (Exception unused) {
                }
            }
        } else {
            drawableLoadIcon = null;
        }
        return drawableLoadIcon == null ? ContextCompat.getDrawable(context, R.drawable.vector_uptodown_logo_disabled) : drawableLoadIcon;
    }
}
