package i0;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.activity.result.ActivityResultLauncher;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.internal.measurement.k4;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.AppFilesActivity;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.UserDeviceDetailsActivity;
import com.uptodown.activities.UserDevicesActivity;
import com.uptodown.activities.VirusTotalReport;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.tv.ui.activity.TvOldVersionsActivity;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;
import h5.h1;
import h5.o0;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import l4.a4;
import l4.j5;
import l4.k5;
import l4.n5;
import l4.nb;
import l4.p2;
import l4.x4;
import org.json.JSONException;
import org.json.JSONObject;
import u7.m0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class k implements g5.z, g5.i, t4.a, g5.l, g5.r, r.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8922a;

    /* renamed from: b, reason: collision with root package name */
    public Object f8923b;

    /* renamed from: c, reason: collision with root package name */
    public Object f8924c;

    public k(int i10) {
        this.f8922a = i10;
        switch (i10) {
            case 20:
                new ArrayDeque();
                this.f8923b = new ArrayDeque();
                this.f8924c = new ArrayDeque();
                break;
            default:
                f0.e eVar = f0.e.f8001d;
                this.f8923b = new SparseIntArray();
                this.f8924c = eVar;
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static i0.k b(android.content.Context r5) throws java.io.IOException {
        /*
            java.lang.String r0 = "generatefid.lock"
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            java.io.File r5 = r5.getFilesDir()     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            r2.<init>(r5, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            java.lang.String r0 = "rw"
            r5.<init>(r2, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            java.nio.channels.FileChannel r5 = r5.getChannel()     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            java.nio.channels.FileLock r0 = r5.lock()     // Catch: java.nio.channels.OverlappingFileLockException -> L29 java.lang.Error -> L2c java.io.IOException -> L2e
            i0.k r2 = new i0.k     // Catch: java.nio.channels.OverlappingFileLockException -> L23 java.lang.Error -> L25 java.io.IOException -> L27
            r3 = 23
            r2.<init>(r3, r5, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L23 java.lang.Error -> L25 java.io.IOException -> L27
            return r2
        L23:
            r2 = move-exception
            goto L38
        L25:
            r2 = move-exception
            goto L38
        L27:
            r2 = move-exception
            goto L38
        L29:
            r2 = move-exception
        L2a:
            r0 = r1
            goto L38
        L2c:
            r2 = move-exception
            goto L2a
        L2e:
            r2 = move-exception
            goto L2a
        L30:
            r2 = move-exception
        L31:
            r5 = r1
            r0 = r5
            goto L38
        L34:
            r2 = move-exception
            goto L31
        L36:
            r2 = move-exception
            goto L31
        L38:
            java.lang.String r3 = "CrossProcessLock"
            java.lang.String r4 = "encountered error while creating and acquiring the lock, ignoring"
            android.util.Log.e(r3, r4, r2)
            if (r0 == 0) goto L44
            r0.release()     // Catch: java.io.IOException -> L44
        L44:
            if (r5 == 0) goto L49
            r5.close()     // Catch: java.io.IOException -> L49
        L49:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.k.b(android.content.Context):i0.k");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean y(p8.b0 r2, p8.z r3) {
        /*
            int r0 = r2.f12065c
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 == r1) goto L4f
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L4f
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L4f
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L4f
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L4f
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L4f
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L2e
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L4f
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L4f
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L4f
            switch(r0) {
                case 300: goto L4f;
                case 301: goto L4f;
                case 302: goto L2e;
                default: goto L2d;
            }
        L2d:
            goto L6a
        L2e:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r2.b(r0)
            if (r0 != 0) goto L4f
            p8.i r0 = r2.a()
            int r0 = r0.f12105c
            r1 = -1
            if (r0 != r1) goto L4f
            p8.i r0 = r2.a()
            boolean r0 = r0.f
            if (r0 != 0) goto L4f
            p8.i r0 = r2.a()
            boolean r0 = r0.e
            if (r0 == 0) goto L6a
        L4f:
            p8.i r2 = r2.a()
            boolean r2 = r2.f12104b
            if (r2 != 0) goto L6a
            p8.i r2 = r3.e
            if (r2 == 0) goto L5c
            goto L64
        L5c:
            p8.r r2 = r3.f12207c
            p8.i r2 = p8.i.a(r2)
            r3.e = r2
        L64:
            boolean r2 = r2.f12104b
            if (r2 != 0) goto L6a
            r2 = 1
            return r2
        L6a:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.k.y(p8.b0, p8.z):boolean");
    }

    public void B(int i10, Bundle bundle) {
        Locale locale = Locale.US;
        String str = "Analytics listener received message. ID: " + i10 + ", Extras: " + bundle;
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", str, null);
        }
        String string = bundle.getString(RewardPlus.NAME);
        if (string != null) {
            Bundle bundle2 = bundle.getBundle("params");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            u1.b bVar = "clx".equals(bundle2.getString("_o")) ? (p2) this.f8923b : (n5) this.f8924c;
            if (bVar == null) {
                return;
            }
            bVar.H(bundle2, string);
        }
    }

    public s2.b C() throws IOException {
        JSONObject jSONObject;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(p());
            while (true) {
                try {
                    int i10 = fileInputStream.read(bArr, 0, 16384);
                    if (i10 < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i10);
                } finally {
                }
            }
            jSONObject = new JSONObject(byteArrayOutputStream.toString());
            fileInputStream.close();
        } catch (IOException | JSONException unused) {
            jSONObject = new JSONObject();
        }
        String strOptString = jSONObject.optString("Fid", null);
        int iOptInt = jSONObject.optInt("Status", 0);
        String strOptString2 = jSONObject.optString("AuthToken", null);
        String strOptString3 = jSONObject.optString("RefreshToken", null);
        long jOptLong = jSONObject.optLong("TokenCreationEpochInSecs", 0L);
        long jOptLong2 = jSONObject.optLong("ExpiresInSecs", 0L);
        String strOptString4 = jSONObject.optString("FisError", null);
        int i11 = s2.b.h;
        byte b10 = (byte) (((byte) (0 | 2)) | 1);
        int i12 = c.i.e(5)[iOptInt];
        if (i12 == 0) {
            androidx.window.layout.c.k("Null registrationStatus");
            return null;
        }
        byte b11 = (byte) (((byte) (b10 | 2)) | 1);
        if (b11 == 3 && i12 != 0) {
            return new s2.b(strOptString, i12, strOptString2, strOptString3, jOptLong2, jOptLong, strOptString4);
        }
        StringBuilder sb = new StringBuilder();
        if (i12 == 0) {
            sb.append(" registrationStatus");
        }
        if ((b11 & 1) == 0) {
            sb.append(" expiresInSecs");
        }
        if ((b11 & 2) == 0) {
            sb.append(" tokenCreationEpochInSecs");
        }
        androidx.window.layout.c.g(r1.i.e(sb, "Missing required properties:"));
        return null;
    }

    @Override // t4.a
    public void D(File file) {
        int i10 = this.f8922a;
        file.getClass();
    }

    public void E() throws IOException {
        try {
            ((FileLock) this.f8924c).release();
            ((FileChannel) this.f8923b).close();
        } catch (IOException e) {
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", e);
        }
    }

    public synchronized void F() {
        ((ArrayDeque) this.f8923b).size();
        ((ArrayDeque) this.f8924c).size();
    }

    @Override // t4.a
    public void J(Object obj) {
        int i10 = this.f8922a;
        obj.getClass();
    }

    @Override // t4.a
    public void L() {
        switch (this.f8922a) {
            case 10:
                a4 a4Var = (a4) this.f8924c;
                File file = new File(a4Var.getExternalFilesDir(null), "tmp");
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str = ((u4.b) ((ArrayList) this.f8923b).get(0)).f12897c;
                str.getClass();
                File file2 = new File(file, str);
                a4Var.Q = file2;
                v4.f fVar = o4.b.t;
                if ((fVar != null ? fVar.f : null) != null) {
                    if (file2.exists()) {
                        File file3 = a4Var.Q;
                        file3.getClass();
                        if (!file3.isDirectory()) {
                            new UptodownApp();
                            File file4 = a4Var.Q;
                            file4.getClass();
                            o4.b.c(file4);
                            break;
                        }
                    }
                    a4Var.j(a4Var.getString(R.string.error_generico));
                    break;
                } else {
                    a4Var.F();
                    break;
                }
            default:
                float f = UptodownApp.E;
                File file5 = (File) this.f8923b;
                file5.getClass();
                FragmentActivity fragmentActivityRequireActivity = ((TvAppDetailFragment) this.f8924c).requireActivity();
                fragmentActivityRequireActivity.getClass();
                k4.c.q(fragmentActivityRequireActivity, file5, null);
                break;
        }
    }

    @Override // g5.r
    public void a(int i10) {
        UserDevicesActivity userDevicesActivity = (UserDevicesActivity) this.f8923b;
        Object obj = ((nb) ((v5.l) ((v5.m) this.f8924c)).f13168a).f10667b.get(i10);
        obj.getClass();
        int i11 = UserDevicesActivity.K;
        Intent intent = new Intent(userDevicesActivity, (Class<?>) UserDeviceDetailsActivity.class);
        intent.putExtra("user_device", (h1) obj);
        ActivityResultLauncher activityResultLauncher = userDevicesActivity.J;
        float f = UptodownApp.E;
        activityResultLauncher.launch(intent, k4.c.b(userDevicesActivity));
    }

    @Override // g5.l
    public void c(ArrayList arrayList) {
        k5 k5Var = (k5) this.f8923b;
        m0 m0Var = k5Var.f10552d;
        Object value = m0Var.getValue();
        value.getClass();
        ((h5.h) value).C0 = arrayList;
        m0 m0Var2 = k5Var.f10549a;
        h5.f fVar = (h5.f) this.f8924c;
        Object value2 = m0Var.getValue();
        value2.getClass();
        v5.l lVar = new v5.l(new j5(fVar, (h5.h) value2, true));
        m0Var2.getClass();
        m0Var2.g(null, lVar);
    }

    public void d(Object obj, String str) {
        ((ArrayList) this.f8923b).add(a3.a.j(str, "=", String.valueOf(obj)));
    }

    @Override // g5.i
    public void f(int i10) {
        switch (this.f8922a) {
            case 6:
                l4.w wVar = (l4.w) this.f8923b;
                String str = (String) this.f8924c;
                if (str != null && str.length() != 0) {
                    v5.c.e(wVar, str, null);
                    break;
                } else {
                    String string = wVar.getString(R.string.app_detail_not_found);
                    string.getClass();
                    wVar.C(string);
                    break;
                }
                break;
            case 7:
                ((l4.w) this.f8924c).X();
                break;
            case 8:
                if (i10 == 404) {
                    v5.g gVarL = v5.g.f13148u.l((l4.w) this.f8923b);
                    gVarL.a();
                    String[] strArr = {String.valueOf(((h5.g0) this.f8924c).f8558a)};
                    SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
                    sQLiteDatabase.getClass();
                    sQLiteDatabase.delete("preregistrations_to_notify", "appId=?", strArr);
                    gVarL.b();
                    break;
                }
                break;
            case 13:
                PublicListActivity publicListActivity = (PublicListActivity) this.f8923b;
                String string2 = publicListActivity.getString(R.string.app_detail_not_found);
                string2.getClass();
                publicListActivity.C(string2);
                break;
            case 14:
                RecommendedActivity recommendedActivity = (RecommendedActivity) this.f8923b;
                String string3 = recommendedActivity.getString(R.string.app_detail_not_found);
                string3.getClass();
                recommendedActivity.C(string3);
                break;
            case 15:
                SecurityActivity securityActivity = (SecurityActivity) this.f8923b;
                String string4 = securityActivity.getString(R.string.rollback_not_available, ((h5.f) this.f8924c).f8525b);
                string4.getClass();
                securityActivity.C(string4);
                break;
            case 17:
                WishlistActivity wishlistActivity = (WishlistActivity) this.f8923b;
                String string5 = wishlistActivity.getString(R.string.app_detail_not_found);
                string5.getClass();
                wishlistActivity.C(string5);
                break;
        }
    }

    @Override // p6.a
    public Object get() {
        return new q.d((Context) ((x4) this.f8923b).f10987b, (p2) ((x4) this.f8924c).get());
    }

    public synchronized void j(p8.y yVar) {
        ((ArrayDeque) this.f8924c).add(yVar);
    }

    @Override // t4.a
    public void k(DocumentFile documentFile) {
        int i10 = this.f8922a;
    }

    @Override // g5.i
    public void l(h5.h hVar) throws Resources.NotFoundException {
        Bundle bundleA = null;
        switch (this.f8922a) {
            case 5:
                AppInstalledDetailsActivity appInstalledDetailsActivity = (AppInstalledDetailsActivity) this.f8924c;
                int i10 = v5.e.f13141d;
                CharSequence charSequence = (CharSequence) this.f8923b;
                SpannableString spannableStringC = k4.c(String.valueOf(charSequence));
                if (charSequence != null) {
                    float dimension = appInstalledDetailsActivity.getResources().getDimension(R.dimen.text_size_m);
                    Typeface typeface = o4.b.f11720s;
                    typeface.getClass();
                    spannableStringC.setSpan(new v5.e(dimension, typeface, ContextCompat.getColor(appInstalledDetailsActivity, R.color.blue_primary)), 0, charSequence.length(), 33);
                }
                int i11 = AppInstalledDetailsActivity.Y;
                appInstalledDetailsActivity.F0().l0.setText(spannableStringC);
                appInstalledDetailsActivity.F0().l0.setOnClickListener(new b5.a(21, appInstalledDetailsActivity, hVar));
                return;
            case 6:
                l4.w wVar = (l4.w) this.f8923b;
                if (wVar.isFinishing()) {
                    return;
                }
                Intent intent = new Intent(wVar, (Class<?>) AppDetailActivity.class);
                intent.putExtra("appInfo", hVar);
                float f = UptodownApp.E;
                wVar.startActivity(intent, k4.c.a(wVar));
                return;
            case 7:
                l4.w wVar2 = (l4.w) this.f8924c;
                h5.l lVar = (h5.l) this.f8923b;
                if (hVar.f8566a <= 0) {
                    wVar2.X();
                    return;
                }
                UptodownApp.Z = lVar;
                if (lVar != null) {
                    v5.g gVarL = v5.g.f13148u.l(wVar2);
                    gVarL.a();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, lVar.b());
                    String str = lVar.f8645b;
                    if (str == null) {
                        kotlin.jvm.internal.l.i("date");
                        throw null;
                    }
                    contentValues.put("date", str);
                    SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
                    sQLiteDatabase.getClass();
                    sQLiteDatabase.insert("deep_link_files", null, contentValues);
                    gVarL.b();
                    File file = new File(lVar.b());
                    if (file.exists()) {
                        file.delete();
                    }
                }
                wVar2.W(hVar);
                return;
            case 8:
                h5.g0 g0Var = new h5.g0();
                g0Var.f8558a = hVar.f8566a;
                g0Var.f8559b = hVar.f8567b;
                g0Var.f8560c = hVar.h();
                l4.w wVar3 = (l4.w) this.f8923b;
                n4.c0 c0Var = wVar3.A;
                if (c0Var != null) {
                    ArrayList arrayList = c0Var.f11315d;
                    arrayList.add(g0Var);
                    c0Var.notifyItemInserted(arrayList.size());
                }
                v5.g gVarL2 = v5.g.f13148u.l(wVar3);
                gVarL2.a();
                String[] strArr = {String.valueOf(g0Var.f8558a)};
                SQLiteDatabase sQLiteDatabase2 = gVarL2.f13150a;
                sQLiteDatabase2.getClass();
                sQLiteDatabase2.delete("preregistrations_to_notify", "appId=?", strArr);
                gVarL2.b();
                return;
            case 9:
            case 10:
            case 11:
            case 12:
            case 16:
            default:
                TvMyAppsFragment tvMyAppsFragment = (TvMyAppsFragment) this.f8923b;
                if (tvMyAppsFragment.getActivity() != null) {
                    Intent intent2 = new Intent(tvMyAppsFragment.getContext(), (Class<?>) TvOldVersionsActivity.class);
                    intent2.putExtra("appInfo", hVar);
                    intent2.putExtra(MBridgeConstans.DYNAMIC_VIEW_WX_APP, (h5.f) this.f8924c);
                    FragmentActivity activity = tvMyAppsFragment.getActivity();
                    if (activity != null) {
                        float f10 = UptodownApp.E;
                        bundleA = k4.c.a(activity);
                    }
                    tvMyAppsFragment.startActivity(intent2, bundleA);
                    return;
                }
                return;
            case 13:
                PublicListActivity publicListActivity = (PublicListActivity) this.f8923b;
                if (publicListActivity.isFinishing()) {
                    return;
                }
                Intent intent3 = new Intent(publicListActivity, (Class<?>) AppDetailActivity.class);
                intent3.putExtra("appInfo", hVar);
                intent3.putExtra("viewCategory", (h5.k) this.f8924c);
                float f11 = UptodownApp.E;
                publicListActivity.startActivity(intent3, k4.c.a(publicListActivity));
                return;
            case 14:
                RecommendedActivity recommendedActivity = (RecommendedActivity) this.f8923b;
                if (recommendedActivity.isFinishing()) {
                    return;
                }
                Intent intent4 = new Intent(recommendedActivity, (Class<?>) AppDetailActivity.class);
                intent4.putExtra("appInfo", hVar);
                intent4.putExtra("viewCategory", (h5.k) this.f8924c);
                float f12 = UptodownApp.E;
                recommendedActivity.startActivity(intent4, k4.c.a(recommendedActivity));
                return;
            case 15:
                SecurityActivity securityActivity = (SecurityActivity) this.f8923b;
                if (!hVar.b()) {
                    String string = securityActivity.getString(R.string.rollback_not_available, hVar.f8567b);
                    string.getClass();
                    securityActivity.C(string);
                    return;
                } else {
                    Intent intent5 = new Intent(securityActivity.getApplicationContext(), (Class<?>) OldVersionsActivity.class);
                    intent5.putExtra(MBridgeConstans.DYNAMIC_VIEW_WX_APP, (h5.f) this.f8924c);
                    intent5.putExtra("appInfo", hVar);
                    float f13 = UptodownApp.E;
                    securityActivity.startActivity(intent5, k4.c.a(securityActivity));
                    return;
                }
            case 17:
                WishlistActivity wishlistActivity = (WishlistActivity) this.f8923b;
                if (wishlistActivity.isFinishing()) {
                    return;
                }
                Intent intent6 = new Intent(wishlistActivity, (Class<?>) AppDetailActivity.class);
                intent6.putExtra("appInfo", hVar);
                intent6.putExtra("viewCategory", (h5.k) this.f8924c);
                float f14 = UptodownApp.E;
                wishlistActivity.startActivity(intent6, k4.c.a(wishlistActivity));
                return;
        }
    }

    @Override // g5.z
    public void m(o0 o0Var) {
        switch (this.f8922a) {
            case 4:
                AppFilesActivity appFilesActivity = (AppFilesActivity) this.f8923b;
                Intent intent = new Intent(appFilesActivity, (Class<?>) VirusTotalReport.class);
                intent.putExtra("app_selected", appFilesActivity.J);
                intent.putExtra("appReportVT", o0Var);
                float f = UptodownApp.E;
                appFilesActivity.startActivity(intent, k4.c.a(appFilesActivity));
                break;
            case 11:
                OldVersionsActivity oldVersionsActivity = (OldVersionsActivity) this.f8923b;
                Intent intent2 = new Intent(oldVersionsActivity, (Class<?>) VirusTotalReport.class);
                int i10 = OldVersionsActivity.L;
                intent2.putExtra("appInfo", (Parcelable) oldVersionsActivity.q0().f10552d.getValue());
                intent2.putExtra("appReportVT", o0Var);
                intent2.putExtra("old_version_name", ((h5.c0) this.f8924c).f8485a);
                float f10 = UptodownApp.E;
                oldVersionsActivity.startActivity(intent2, k4.c.a(oldVersionsActivity));
                break;
            default:
                h5.q qVar = (h5.q) this.f8924c;
                TvAppDetailFragment tvAppDetailFragment = (TvAppDetailFragment) this.f8923b;
                if (tvAppDetailFragment.getActivity() != null && (tvAppDetailFragment.getActivity() instanceof l4.w) && !tvAppDetailFragment.requireActivity().isFinishing()) {
                    h5.h hVar = tvAppDetailFragment.f6693a;
                    hVar.getClass();
                    hVar.Q = o0Var;
                    if (o0Var.f8677c <= 0) {
                        tvAppDetailFragment.i(qVar);
                        break;
                    } else {
                        FragmentActivity activity = tvAppDetailFragment.getActivity();
                        activity.getClass();
                        h5.h hVar2 = tvAppDetailFragment.f6693a;
                        hVar2.getClass();
                        ((l4.w) activity).P(hVar2, new s5.a(tvAppDetailFragment, qVar, 1), new s5.b(tvAppDetailFragment, 1));
                        break;
                    }
                }
                break;
        }
    }

    public void n(p8.y yVar) {
        ArrayDeque arrayDeque = (ArrayDeque) this.f8924c;
        synchronized (this) {
            try {
                if (!arrayDeque.remove(yVar)) {
                    throw new AssertionError("Call wasn't in-flight!");
                }
                F();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.datatransport.cct.CctBackendFactory o(java.lang.String r14) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.k.o(java.lang.String):com.google.android.datatransport.cct.CctBackendFactory");
    }

    public File p() {
        if (((File) this.f8923b) == null) {
            synchronized (this) {
                try {
                    if (((File) this.f8923b) == null) {
                        l1.g gVar = (l1.g) this.f8924c;
                        gVar.a();
                        this.f8923b = new File(gVar.f10177a.getFilesDir(), "PersistedInstallation." + ((l1.g) this.f8924c).d() + ".json");
                    }
                } finally {
                }
            }
        }
        return (File) this.f8923b;
    }

    @Override // g5.z
    public void q() {
        switch (this.f8922a) {
            case 4:
                AppFilesActivity appFilesActivity = (AppFilesActivity) this.f8923b;
                h5.w wVar = (h5.w) this.f8924c;
                if (wVar.f8781a != null && !appFilesActivity.isFinishing()) {
                    String str = wVar.f8781a;
                    str.getClass();
                    v5.c.e(appFilesActivity, "https://www.virustotal.com/gui/file/" + str + "/detection", appFilesActivity.getString(R.string.virustotal_safety_report_title));
                    break;
                }
                break;
            case 11:
                OldVersionsActivity oldVersionsActivity = (OldVersionsActivity) this.f8923b;
                int i10 = OldVersionsActivity.L;
                if (oldVersionsActivity.q0().f10552d.getValue() != null) {
                    Object value = oldVersionsActivity.q0().f10552d.getValue();
                    value.getClass();
                    String str2 = ((h5.h) value).g;
                    if (str2 != null && str2.length() != 0) {
                        Object value2 = oldVersionsActivity.q0().f10552d.getValue();
                        value2.getClass();
                        String str3 = ((h5.h) value2).g;
                        str3.getClass();
                        if (Long.parseLong(str3) > 650000000) {
                            Intent intent = new Intent(oldVersionsActivity, (Class<?>) VirusTotalReport.class);
                            intent.putExtra("appInfo", (Parcelable) oldVersionsActivity.q0().f10552d.getValue());
                            intent.putExtra("isVirusTotalReportAvaialable", false);
                            float f = UptodownApp.E;
                            oldVersionsActivity.startActivity(intent, k4.c.a(oldVersionsActivity));
                            break;
                        }
                    }
                }
                Object value3 = oldVersionsActivity.q0().f10552d.getValue();
                value3.getClass();
                oldVersionsActivity.c0(((h5.h) value3).G);
                break;
            default:
                ((TvAppDetailFragment) this.f8923b).i((h5.q) this.f8924c);
                break;
        }
    }

    public String r(String str) {
        String str2 = (String) this.f8924c;
        Resources resources = (Resources) this.f8923b;
        int identifier = resources.getIdentifier(str, TypedValues.Custom.S_STRING, str2);
        if (identifier == 0) {
            return null;
        }
        return resources.getString(identifier);
    }

    @Override // t4.a
    public void s(Object obj, int i10, int i11, long j10) {
        int i12 = this.f8922a;
        obj.getClass();
    }

    @Override // t4.a
    public void t(File file) {
        int i10 = this.f8922a;
        file.getClass();
    }

    public String toString() {
        switch (this.f8922a) {
            case 0:
                StringBuilder sb = new StringBuilder(100);
                sb.append(this.f8924c.getClass().getSimpleName());
                sb.append('{');
                ArrayList arrayList = (ArrayList) this.f8923b;
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    sb.append((String) arrayList.get(i10));
                    if (i10 < size - 1) {
                        sb.append(", ");
                    }
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    @Override // g5.l
    public void u() {
        k5 k5Var = (k5) this.f8923b;
        m0 m0Var = k5Var.f10549a;
        h5.f fVar = (h5.f) this.f8924c;
        Object value = k5Var.f10552d.getValue();
        value.getClass();
        v5.l lVar = new v5.l(new j5(fVar, (h5.h) value, false));
        m0Var.getClass();
        m0Var.g(null, lVar);
    }

    @Override // t4.a
    public void v(DocumentFile documentFile) {
        int i10 = this.f8922a;
    }

    @Override // t4.a
    public void w(int i10, String str, long j10, long j11) {
        int i11 = this.f8922a;
        str.getClass();
    }

    public void x(s2.b bVar) throws JSONException, IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", bVar.f12522a);
            jSONObject.put("Status", c.i.c(bVar.f12523b));
            jSONObject.put("AuthToken", bVar.f12524c);
            jSONObject.put("RefreshToken", bVar.f12525d);
            jSONObject.put("TokenCreationEpochInSecs", bVar.f);
            jSONObject.put("ExpiresInSecs", bVar.e);
            jSONObject.put("FisError", bVar.g);
            l1.g gVar = (l1.g) this.f8924c;
            gVar.a();
            File fileCreateTempFile = File.createTempFile("PersistedInstallation", "tmp", gVar.f10177a.getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes(C.UTF8_NAME));
            fileOutputStream.close();
            if (fileCreateTempFile.renameTo(p())) {
            } else {
                throw new IOException("unable to rename the tmpfile to PersistedInstallation");
            }
        } catch (IOException | JSONException unused) {
        }
    }

    private final void A(int i10) {
    }

    private final void e(DocumentFile documentFile) {
    }

    private final void g(DocumentFile documentFile) {
    }

    private final void h(DocumentFile documentFile) {
    }

    private final void i(DocumentFile documentFile) {
    }

    private final void z(int i10) {
    }

    public /* synthetic */ k(int i10, boolean z9) {
        this.f8922a = i10;
    }

    public k(Context context, int i10) {
        this.f8922a = i10;
        switch (i10) {
            case 21:
                this.f8924c = null;
                this.f8923b = context;
                break;
            default:
                y.g(context);
                Resources resources = context.getResources();
                this.f8923b = resources;
                this.f8924c = resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
                break;
        }
    }

    public k(d0.i iVar, k kVar) {
        this.f8922a = 18;
        this.f8924c = kVar;
        iVar.C(new o1.b(this, 0));
        this.f8923b = new HashSet();
    }

    public /* synthetic */ k(Object obj) {
        this.f8922a = 0;
        this.f8924c = obj;
        this.f8923b = new ArrayList();
    }

    public /* synthetic */ k(int i10, Object obj, Object obj2) {
        this.f8922a = i10;
        this.f8923b = obj;
        this.f8924c = obj2;
    }

    public k(l1.g gVar) {
        this.f8922a = 26;
        this.f8924c = gVar;
    }

    public k(ArrayList arrayList, a4 a4Var) {
        this.f8922a = 10;
        this.f8924c = a4Var;
        this.f8923b = arrayList;
    }
}
