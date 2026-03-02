package i5;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b.j;
import b9.p;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import h5.a0;
import h5.l;
import h5.y0;
import kotlin.jvm.internal.x;
import o7.u;
import r7.i0;
import r7.y;
import v5.i;
import w7.n;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends ResultReceiver {

    /* renamed from: a, reason: collision with root package name */
    public Context f9026a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i10, Bundle bundle) {
        SharedPreferences sharedPreferences;
        long j10;
        int i11;
        String string;
        String strValueOf;
        Context context = this.f9026a;
        if (context != null) {
            int i12 = 1;
            Object[] objArr = 0;
            if (i10 == 222) {
                String string2 = bundle != null ? bundle.getString("appNameAndVersion") : null;
                if (string2 == null) {
                    string2 = "";
                }
                Context context2 = this.f9026a;
                context2.getClass();
                if (i.a(context2)) {
                    try {
                        sharedPreferences = context2.getSharedPreferences("SettingsPreferences", 0);
                    } catch (Exception unused) {
                    }
                    boolean z9 = sharedPreferences.contains("installation_notification") ? sharedPreferences.getBoolean("installation_notification", true) : true;
                    if (z9) {
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(context2, "CHANNEL_ID_UPTODOWN");
                        builder.setSmallIcon(R.drawable.vector_uptodown_notification);
                        String string3 = context2.getString(R.string.installing);
                        string3.getClass();
                        builder.setContentTitle(string3);
                        builder.setContentText(string2);
                        builder.setProgress(100, 0, true);
                        Object systemService = context2.getSystemService("notification");
                        systemService.getClass();
                        ((NotificationManager) systemService).notify(255, builder.build());
                        i.k(string3, context2, String.valueOf(System.currentTimeMillis()), string2, null, null);
                        return;
                    }
                    return;
                }
                return;
            }
            int i13 = 2;
            if (i10 == 223) {
                UptodownApp.l0 = null;
                new t1.c(this.f9026a, 4).e(com.mbridge.msdk.dycreator.baseview.a.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "cancelled"), "install");
                Context context3 = this.f9026a;
                context3.getClass();
                Object systemService2 = context3.getSystemService("notification");
                systemService2.getClass();
                ((NotificationManager) systemService2).cancel(255);
                y7.e eVar = i0.f12407a;
                y.q(y.a(n.f13548a), null, null, new j(i13, objArr == true ? 1 : 0, i12), 3);
                return;
            }
            if (i10 != 227) {
                if (i10 != 228) {
                    return;
                }
                Object systemService3 = context.getSystemService("notification");
                systemService3.getClass();
                ((NotificationManager) systemService3).cancel(255);
                return;
            }
            UptodownApp.l0 = null;
            x xVar = new x();
            x xVar2 = new x();
            Object systemService4 = context.getSystemService("notification");
            systemService4.getClass();
            ((NotificationManager) systemService4).cancel(255);
            if (bundle != null) {
                i11 = bundle.getInt("piStatus");
                xVar.f10138a = bundle.getString("packagename");
                j10 = bundle.getLong("size");
                string = bundle.getString("extra_error");
            } else {
                j10 = -1;
                i11 = 0;
                string = null;
            }
            switch (i11) {
                case 1:
                    strValueOf = "STATUS_FAILURE";
                    break;
                case 2:
                    strValueOf = "STATUS_FAILURE_BLOCKED";
                    break;
                case 3:
                    strValueOf = "STATUS_FAILURE_ABORTED";
                    break;
                case 4:
                    strValueOf = "STATUS_FAILURE_INVALID";
                    break;
                case 5:
                    strValueOf = "STATUS_FAILURE_CONFLICT";
                    break;
                case 6:
                    strValueOf = "STATUS_FAILURE_STORAGE";
                    break;
                case 7:
                    strValueOf = "STATUS_FAILURE_INCOMPATIBLE";
                    break;
                default:
                    strValueOf = String.valueOf(i11);
                    break;
            }
            Bundle bundleF = com.mbridge.msdk.dycreator.baseview.a.f(CampaignEx.JSON_NATIVE_VIDEO_ERROR, strValueOf);
            if (string != null) {
                bundleF.putString("extraError", string);
            }
            bundleF.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "failed");
            Object obj = xVar.f10138a;
            if (obj != null) {
                bundleF.putString("packagename", (String) obj);
                Context context4 = this.f9026a;
                if (context4 != null) {
                    h5.f fVarH = v5.a.h(context4, (String) xVar.f10138a);
                    t3.h hVar = v5.g.f13148u;
                    Context context5 = this.f9026a;
                    context5.getClass();
                    v5.g gVarL = hVar.l(context5);
                    gVarL.a();
                    y0 y0VarM = gVarL.M((String) xVar.f10138a);
                    if (y0VarM != null) {
                        if (y0VarM.f == 0) {
                            y0VarM.f = 2;
                            gVarL.c0(y0VarM);
                        }
                        bundleF.putInt("update", 1);
                        xVar2.f10138a = fVarH != null ? fVarH.f8525b : null;
                    } else {
                        bundleF.putInt("update", 0);
                    }
                    gVarL.b();
                    Context context6 = this.f9026a;
                    context6.getClass();
                    String str = (String) xVar.f10138a;
                    str.getClass();
                    l lVar = UptodownApp.Z;
                    if (lVar != null) {
                        String strC = r0.f.C(lVar.a());
                        if (strC != null && strC.equalsIgnoreCase(str)) {
                            bundleF.putString("source", "deeplink");
                        }
                    } else {
                        a0 a0VarJ = t1.J(context6);
                        if (a0VarJ != null && u.Z(a0VarJ.f8461b, str, true)) {
                            bundleF.putString("source", "notification_fcm");
                        }
                    }
                    Context context7 = this.f9026a;
                    context7.getClass();
                    a.a.H(context7, fVarH, bundleF);
                }
            }
            if (j10 > 0) {
                String str2 = "<10MB";
                if (j10 >= 10485760) {
                    if (j10 < 104857600) {
                        str2 = "<100MB";
                    } else if (j10 < 524288000) {
                        str2 = "<500MB";
                    } else if (j10 < 1073741824) {
                        str2 = "<1GB";
                    } else if (j10 < 10737418240L) {
                        str2 = "<10GB";
                    }
                }
                bundleF.putString("size", str2);
            }
            Context context8 = this.f9026a;
            String string4 = context8 != null ? context8.getString(R.string.dpi_device) : null;
            if (string4 != null && string4.length() != 0) {
                bundleF.putString("dpi", string4);
            }
            new t1.c(this.f9026a, 4).e(bundleF, "install");
            y7.e eVar2 = i0.f12407a;
            y.q(y.a(n.f13548a), null, null, new p((Object) xVar, (Object) xVar2, strValueOf, (w6.c) null, 5), 3);
        }
    }
}
