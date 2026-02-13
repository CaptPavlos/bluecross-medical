package a3;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.MultiProcessDataStoreFactory;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import c1.e3;
import c1.u1;
import c1.v4;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import com.inmobi.cmp.data.model.ChoiceColor;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.uptodown.R;
import com.uptodown.util.views.MaxHeightRecyclerView;
import com.uptodown.workers.DownloadApkWorker;
import com.uptodown.workers.DownloadWorker;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import l4.t3;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x implements c3.b, a6.g, e3, c1.y0, ViewBinding, h1.d, t4.a, g5.r, g5.z {
    public static x e;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f180a;

    /* renamed from: b, reason: collision with root package name */
    public Object f181b;

    /* renamed from: c, reason: collision with root package name */
    public Object f182c;

    /* renamed from: d, reason: collision with root package name */
    public Object f183d;

    public x(int i10) {
        this.f180a = i10;
        switch (i10) {
            case 13:
                this.f181b = new com.google.android.gms.internal.measurement.b("", 0L, null);
                this.f182c = new com.google.android.gms.internal.measurement.b("", 0L, null);
                this.f183d = new ArrayList();
                break;
            default:
                this.f182c = new ArrayDeque();
                this.f183d = null;
                this.f181b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                break;
        }
    }

    public static ChoiceColor f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ChoiceColor choiceColor = new ChoiceColor();
        choiceColor.setDividerColor(Integer.valueOf(Color.parseColor(jSONObject.optString("dividerColor"))));
        choiceColor.setTabBackgroundColor(Integer.valueOf(Color.parseColor(jSONObject.optString("tabBackgroundColor"))));
        choiceColor.setSearchBarBackgroundColor(Integer.valueOf(Color.parseColor(jSONObject.optString("searchBarBackgroundColor"))));
        choiceColor.setSearchBarForegroundColor(Integer.valueOf(Color.parseColor(jSONObject.optString("searchBarForegroundColor"))));
        choiceColor.setToggleActiveColor(Integer.valueOf(Color.parseColor(jSONObject.optString("toggleActiveColor"))));
        choiceColor.setToggleInactiveColor(Integer.valueOf(Color.parseColor(jSONObject.optString("toggleInactiveColor"))));
        choiceColor.setGlobalBackgroundColor(Integer.valueOf(Color.parseColor(jSONObject.optString("globalBackgroundColor"))));
        choiceColor.setTitleTextColor(Integer.valueOf(Color.parseColor(jSONObject.optString("titleTextColor"))));
        choiceColor.setBodyTextColor(Integer.valueOf(Color.parseColor(jSONObject.optString("bodyTextColor"))));
        choiceColor.setTabTextColor(Integer.valueOf(Color.parseColor(jSONObject.optString("tabTextColor"))));
        choiceColor.setMenuTextColor(Integer.valueOf(Color.parseColor(jSONObject.optString("menuTextColor"))));
        choiceColor.setLinkTextColor(Integer.valueOf(Color.parseColor(jSONObject.optString("linkTextColor"))));
        choiceColor.setButtonTextColor(Integer.valueOf(Color.parseColor(jSONObject.optString("buttonTextColor"))));
        choiceColor.setButtonDisabledTextColor(Integer.valueOf(Color.parseColor(jSONObject.optString("buttonDisabledTextColor"))));
        choiceColor.setButtonBackgroundColor(Integer.valueOf(Color.parseColor(jSONObject.optString("buttonBackgroundColor"))));
        choiceColor.setButtonDisabledBackgroundColor(Integer.valueOf(Color.parseColor(jSONObject.optString("buttonDisabledBackgroundColor"))));
        return choiceColor;
    }

    public static x p(View view) {
        int i10 = R.id.iv_version_details_update_item;
        if (((ImageView) ViewBindings.findChildViewById(view, R.id.iv_version_details_update_item)) != null) {
            i10 = R.id.tv_order_label_selector;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_order_label_selector);
            if (textView != null) {
                i10 = R.id.tv_order_selector;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_order_selector);
                if (textView2 != null) {
                    return new x((LinearLayout) view, textView, textView2, 15);
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        return null;
    }

    public static x r(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i10 = R.id.tv_preference_list_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_preference_list_description);
        if (textView != null) {
            i10 = R.id.tv_preference_list_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_preference_list_title);
            if (textView2 != null) {
                return new x(relativeLayout, textView, textView2, 18);
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        return null;
    }

    public static String x(String str, HashMap map) {
        StringBuilder sb = new StringBuilder();
        Iterator it = map.entrySet().iterator();
        Map.Entry entry = (Map.Entry) it.next();
        sb.append((String) entry.getKey());
        sb.append("=");
        sb.append(entry.getValue() != null ? URLEncoder.encode((String) entry.getValue(), C.UTF8_NAME) : "");
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            sb.append("&");
            sb.append((String) entry2.getKey());
            sb.append("=");
            sb.append(entry2.getValue() != null ? URLEncoder.encode((String) entry2.getValue(), C.UTF8_NAME) : "");
        }
        String string = sb.toString();
        if (string.isEmpty()) {
            return str;
        }
        if (!str.contains("?")) {
            return a.j(str, "?", string);
        }
        if (!str.endsWith("&")) {
            string = "&".concat(string);
        }
        return str.concat(string);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b2.a A() throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.String r0 = "GET Request URL: "
            java.lang.String r1 = "FirebaseCrashlytics"
            x1.e.b()
            r2 = 0
            java.lang.Object r3 = r8.f181b     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> Lb5
            java.lang.Object r4 = r8.f182c     // Catch: java.lang.Throwable -> Lb5
            java.util.HashMap r4 = (java.util.HashMap) r4     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r3 = x(r3, r4)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r0 = r0.concat(r3)     // Catch: java.lang.Throwable -> Lb0
            r4 = 2
            boolean r4 = android.util.Log.isLoggable(r1, r4)     // Catch: java.lang.Throwable -> L23
            if (r4 == 0) goto L26
            android.util.Log.v(r1, r0, r2)     // Catch: java.lang.Throwable -> L23
            goto L26
        L23:
            r0 = move-exception
            goto Lb3
        L26:
            java.net.URL r0 = new java.net.URL     // Catch: java.lang.Throwable -> Lb0
            r0.<init>(r3)     // Catch: java.lang.Throwable -> Lb0
            java.net.URLConnection r0 = r0.openConnection()     // Catch: java.lang.Throwable -> Lb0
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch: java.lang.Throwable -> Lb0
            r1 = 10000(0x2710, float:1.4013E-41)
            r0.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L66
            r0.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L66
            java.lang.String r1 = "GET"
            r0.setRequestMethod(r1)     // Catch: java.lang.Throwable -> L66
            java.lang.Object r1 = r8.f183d     // Catch: java.lang.Throwable -> L66
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch: java.lang.Throwable -> L66
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L66
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L66
        L4a:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Throwable -> L66
            if (r3 == 0) goto L68
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> L66
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> L66
            java.lang.Object r4 = r3.getKey()     // Catch: java.lang.Throwable -> L66
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L66
            java.lang.Object r3 = r3.getValue()     // Catch: java.lang.Throwable -> L66
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L66
            r0.addRequestProperty(r4, r3)     // Catch: java.lang.Throwable -> L66
            goto L4a
        L66:
            r1 = move-exception
            goto Lb7
        L68:
            r0.connect()     // Catch: java.lang.Throwable -> L66
            int r1 = r0.getResponseCode()     // Catch: java.lang.Throwable -> L66
            java.io.InputStream r3 = r0.getInputStream()     // Catch: java.lang.Throwable -> L66
            if (r3 == 0) goto L9e
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L9b
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L9b
            java.lang.String r5 = "UTF-8"
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> L9b
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L9b
            r4 = 8192(0x2000, float:1.148E-41)
            char[] r4 = new char[r4]     // Catch: java.lang.Throwable -> L9b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b
            r5.<init>()     // Catch: java.lang.Throwable -> L9b
        L8a:
            int r6 = r2.read(r4)     // Catch: java.lang.Throwable -> L9b
            r7 = -1
            if (r6 == r7) goto L96
            r7 = 0
            r5.append(r4, r7, r6)     // Catch: java.lang.Throwable -> L9b
            goto L8a
        L96:
            java.lang.String r2 = r5.toString()     // Catch: java.lang.Throwable -> L9b
            goto L9e
        L9b:
            r1 = move-exception
            r2 = r3
            goto Lb7
        L9e:
            if (r3 == 0) goto La3
            r3.close()
        La3:
            r0.disconnect()
            b2.a r0 = new b2.a
            r0.<init>()
            r0.f824b = r1
            r0.f823a = r2
            return r0
        Lb0:
            r1 = move-exception
        Lb1:
            r0 = r2
            goto Lb7
        Lb3:
            r1 = r0
            goto Lb1
        Lb5:
            r0 = move-exception
            goto Lb3
        Lb7:
            if (r2 == 0) goto Lbc
            r2.close()
        Lbc:
            if (r0 == 0) goto Lc1
            r0.disconnect()
        Lc1:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.x.A():b2.a");
    }

    public Object B(y6.c cVar) {
        kotlin.jvm.internal.v vVar = new kotlin.jvm.internal.v();
        ArrayList arrayList = new ArrayList();
        kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
        y7.e eVar = r7.i0.f12407a;
        return r7.y.z(new a6.q(this, vVar, arrayList, xVar, (w6.c) null, 2), y7.d.f14116a, cVar);
    }

    public void C(String str, String str2) {
        ((HashMap) this.f183d).put(str, str2);
    }

    @Override // t4.a
    public void D(File file) {
        file.getClass();
    }

    public synchronized void E(int i10, int i11, long j10, long j11) {
        ((u1) this.f181b).f1481k.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        AtomicLong atomicLong = (AtomicLong) this.f183d;
        if (atomicLong.get() != -1 && jElapsedRealtime - atomicLong.get() <= 1800000) {
            return;
        }
        h1.p pVarB = ((k0.b) this.f182c).b(new i0.n(0, Arrays.asList(new i0.j(36301, i10, 0, j10, j11, null, null, 0, i11))));
        c1.s0 s0Var = new c1.s0();
        s0Var.f1448b = this;
        s0Var.f1447a = jElapsedRealtime;
        pVarB.getClass();
        pVarB.b(h1.j.f8419a, s0Var);
    }

    @Override // t4.a
    public void J(Object obj) {
        obj.getClass();
    }

    @Override // t4.a
    public void L() {
        e5.j0 j0Var = (e5.j0) this.f181b;
        if (j0Var.getActivity() == null || !(j0Var.getActivity() instanceof l4.w)) {
            return;
        }
        FragmentActivity activity = j0Var.getActivity();
        activity.getClass();
        File file = (File) this.f182c;
        file.getClass();
        ((l4.w) activity).U(file, ((h5.y0) this.f183d).h);
    }

    @Override // g5.r
    public void a(int i10) {
        ArrayList arrayList = (ArrayList) this.f182c;
        ArrayList arrayList2 = (ArrayList) this.f181b;
        if (((h5.j1) arrayList2.get(i10)).f8630c != 0) {
            ((kotlin.jvm.internal.u) this.f183d).f10135a = !r4.f10135a;
        } else if (arrayList.contains(arrayList2.get(i10))) {
            arrayList.remove(arrayList2.get(i10));
        } else {
            arrayList.add(arrayList2.get(i10));
        }
    }

    @Override // a6.g
    public void b(long j10) {
        ((kotlin.jvm.internal.w) this.f181b).f10137a = j10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032 A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:6:0x0020, B:21:0x006b, B:24:0x008f, B:15:0x0032, B:17:0x0058, B:19:0x0063, B:20:0x0067), top: B:55:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:6:0x0020, B:21:0x006b, B:24:0x008f, B:15:0x0032, B:17:0x0058, B:19:0x0063, B:20:0x0067), top: B:55:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0174 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v19, types: [java.lang.String] */
    @Override // c1.e3, c1.y0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(java.lang.String r9, int r10, java.lang.Throwable r11, byte[] r12, java.util.Map r13) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.x.c(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    public /* bridge */ /* synthetic */ Object clone() {
        switch (this.f180a) {
            case 13:
                x xVar = new x(((com.google.android.gms.internal.measurement.b) this.f181b).clone());
                ArrayList arrayList = (ArrayList) this.f183d;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((ArrayList) xVar.f183d).add(((com.google.android.gms.internal.measurement.b) obj).clone());
                }
                return xVar;
            default:
                return super.clone();
        }
    }

    @Override // a6.g
    public void d(long j10) {
        ((kotlin.jvm.internal.w) this.f182c).f10137a = j10;
    }

    @Override // a6.g
    public void e() {
        Bundle bundleF = com.mbridge.msdk.dycreator.baseview.a.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "reconnected");
        DownloadApkWorker downloadApkWorker = (DownloadApkWorker) this.f183d;
        String str = downloadApkWorker.f6741c;
        h5.q qVar = DownloadWorker.f6738d;
        qVar.getClass();
        downloadApkWorker.n(bundleF, str, (h5.r) qVar.f8716v.get(0));
    }

    public Object g(String str) throws JSONException, IOException, ParseException {
        switch (this.f180a) {
            case 25:
                str.getClass();
                try {
                    if (str.length() == 0) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(((Application) this.f181b).getResources().openRawResource(R.raw.cmp_list)));
                        try {
                            str = bufferedReader.readLine();
                            bufferedReader.close();
                        } finally {
                        }
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    this.f183d = jSONObject;
                    String string = jSONObject.getString("lastUpdated");
                    string.getClass();
                    Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", (Locale) this.f182c).parse(string);
                    return new f6.f(date == null ? null : Long.valueOf(date.getTime()), i());
                } catch (JSONException unused) {
                    ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
                    if (callback != null) {
                        callback.onCmpError(ChoiceError.INVALID_JSON_FORMAT);
                    }
                    return new f6.f();
                }
            default:
                str.getClass();
                try {
                    this.f183d = new JSONObject(str);
                    o8.j jVarU = u();
                    o8.c cVarJ = j();
                    o8.h hVarN = n();
                    ((c1.d0) this.f182c).getClass();
                    d9.g gVarL = c1.d0.l(str);
                    d9.p pVarY = y();
                    o8.k kVarZ = z();
                    JSONObject jSONObject2 = (JSONObject) this.f183d;
                    if (jSONObject2 != null) {
                        return new o8.i(jVarU, cVarJ, hVarN, gVarL, pVarY, kVarZ, jSONObject2.getLong("currentTimeStamp"), 16);
                    }
                    kotlin.jvm.internal.l.i("json");
                    throw null;
                } catch (JSONException e3) {
                    d6.b.b("Choice", kotlin.jvm.internal.l.g(e3.getMessage(), "Error parsing portal config: "), null, 12);
                    ChoiceCmpCallback choiceCmpCallback = (ChoiceCmpCallback) this.f181b;
                    if (choiceCmpCallback != null) {
                        choiceCmpCallback.onCmpError(ChoiceError.UNKNOWN_CONFIG);
                    }
                    return new o8.i(null, null, null, null, null, null, 0L, 255);
                }
        }
    }

    @Override // p6.a
    public Object get() {
        DataStore dataStoreCreate;
        switch (this.f180a) {
            case 0:
                Context context = (Context) ((d0.i) this.f181b).f6781b;
                w6.h hVar = (w6.h) ((p6.a) this.f182c).get();
                p0 p0Var = (p0) ((c3.c) this.f183d).get();
                context.getClass();
                hVar.getClass();
                p0Var.getClass();
                ReplaceFileCorruptionHandler replaceFileCorruptionHandler = new ReplaceFileCorruptionHandler(new s(p0Var, 0));
                w7.c cVarA = r7.y.a(hVar);
                r rVar = new r(context, 1);
                t6.t tVar = t6.t.f12808a;
                try {
                    System.loadLibrary("datastore_shared_counter");
                    dataStoreCreate = MultiProcessDataStoreFactory.INSTANCE.create(p0Var, replaceFileCorruptionHandler, tVar, cVarA, rVar);
                } catch (SecurityException | UnsatisfiedLinkError unused) {
                    dataStoreCreate = DataStoreFactory.INSTANCE.create(p0Var, replaceFileCorruptionHandler, tVar, cVarA, rVar);
                }
                if (dataStoreCreate != null) {
                    return dataStoreCreate;
                }
                androidx.window.layout.c.k("Cannot return null from a non-@Nullable @Provides method");
                return null;
            default:
                return new d3.n((w6.h) ((p6.a) this.f182c).get(), (o1) ((p6.a) this.f181b).get(), (DataStore) ((c3.c) this.f183d).get());
        }
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        switch (this.f180a) {
        }
        return (RelativeLayout) this.f181b;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object h(y6.c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof f9.h
            if (r0 == 0) goto L13
            r0 = r6
            f9.h r0 = (f9.h) r0
            int r1 = r0.f8148d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8148d = r1
            goto L18
        L13:
            f9.h r0 = new f9.h
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f8146b
            int r1 = r0.f8148d
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2f
            if (r1 != r3) goto L28
            a3.x r0 = r0.f8145a
            s6.a.e(r6)     // Catch: d6.a -> L68
            goto L56
        L28:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r6)
            r6 = 0
            return r6
        L2f:
            s6.a.e(r6)
            java.lang.Object r6 = r5.f181b     // Catch: d6.a -> L67
            y2.c r6 = (y2.c) r6     // Catch: d6.a -> L67
            boolean r6 = r6.v()     // Catch: d6.a -> L67
            if (r6 == 0) goto L59
            java.lang.Object r6 = r5.f182c     // Catch: d6.a -> L67
            c1.d0 r6 = (c1.d0) r6     // Catch: d6.a -> L67
            java.lang.String r1 = "https://cmp.inmobi.com/"
            java.lang.String r4 = "geoip"
            java.lang.String r1 = kotlin.jvm.internal.l.g(r4, r1)     // Catch: d6.a -> L67
            r0.f8145a = r5     // Catch: d6.a -> L67
            r0.f8148d = r3     // Catch: d6.a -> L67
            java.lang.Object r6 = r6.k(r1, r0)     // Catch: d6.a -> L67
            x6.a r0 = x6.a.f13718a
            if (r6 != r0) goto L55
            return r0
        L55:
            r0 = r5
        L56:
            java.lang.String r6 = (java.lang.String) r6     // Catch: d6.a -> L68
            goto L69
        L59:
            com.inmobi.cmp.ChoiceCmp r6 = com.inmobi.cmp.ChoiceCmp.INSTANCE     // Catch: d6.a -> L67
            com.inmobi.cmp.ChoiceCmpCallback r6 = r6.getCallback()     // Catch: d6.a -> L67
            if (r6 != 0) goto L62
            goto L67
        L62:
            com.inmobi.cmp.model.ChoiceError r0 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch: d6.a -> L67
            r6.onCmpError(r0)     // Catch: d6.a -> L67
        L67:
            r0 = r5
        L68:
            r6 = r2
        L69:
            if (r6 != 0) goto L6c
            goto Lb3
        L6c:
            java.lang.Object r0 = r0.f183d
            c1.d0 r0 = (c1.d0) r0
            r0.getClass()
            r6.getClass()
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L9d
            r0.<init>(r6)     // Catch: org.json.JSONException -> L9d
            q6.a r6 = new q6.a     // Catch: org.json.JSONException -> L9d
            java.lang.String r1 = "country"
            java.lang.String r1 = r0.optString(r1)     // Catch: org.json.JSONException -> L9d
            r1.getClass()     // Catch: org.json.JSONException -> L9d
            java.lang.String r2 = "region"
            java.lang.String r2 = r0.optString(r2)     // Catch: org.json.JSONException -> L9d
            r2.getClass()     // Catch: org.json.JSONException -> L9d
            java.lang.String r3 = "city"
            java.lang.String r0 = r0.optString(r3)     // Catch: org.json.JSONException -> L9d
            r0.getClass()     // Catch: org.json.JSONException -> L9d
            r6.<init>(r1, r2, r0)     // Catch: org.json.JSONException -> L9d
        L9b:
            r2 = r6
            goto Lb3
        L9d:
            com.inmobi.cmp.ChoiceCmp r6 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            com.inmobi.cmp.ChoiceCmpCallback r6 = r6.getCallback()
            if (r6 != 0) goto La6
            goto Lab
        La6:
            com.inmobi.cmp.model.ChoiceError r0 = com.inmobi.cmp.model.ChoiceError.INVALID_JSON_FORMAT
            r6.onCmpError(r0)
        Lab:
            q6.a r6 = new q6.a
            java.lang.String r0 = ""
            r6.<init>(r0, r0, r0)
            goto L9b
        Lb3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.x.h(y6.c):java.lang.Object");
    }

    public LinkedHashMap i() throws JSONException {
        String string;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = (JSONObject) this.f183d;
        if (jSONObject == null) {
            kotlin.jvm.internal.l.i("cmpListJson");
            throw null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("cmps");
        JSONArray jSONArrayNames = jSONObject2.names();
        int i10 = 0;
        int length = jSONArrayNames == null ? 0 : jSONArrayNames.length();
        while (i10 < length) {
            int i11 = i10 + 1;
            if (jSONArrayNames == null || (string = jSONArrayNames.getString(i10)) == null) {
                string = "0";
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject(string);
            jSONObject3.getInt("id");
            jSONObject3.getString(RewardPlus.NAME).getClass();
            jSONObject3.getBoolean("isCommercial");
            linkedHashMap.put(string, new c1.d0(9));
            i10 = i11;
        }
        return linkedHashMap;
    }

    public o8.c j() throws JSONException {
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        o8.d dVar;
        o8.d dVar2;
        String str3;
        String str4;
        String str5;
        o8.f fVar;
        boolean z9;
        boolean zOptBoolean;
        o8.b bVar;
        JSONObject jSONObject = (JSONObject) this.f183d;
        if (jSONObject == null) {
            kotlin.jvm.internal.l.i("json");
            throw null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("coreConfig");
        String strOptString = jSONObject2.optString("inmobiAccountId");
        strOptString.getClass();
        ArrayList arrayListM = l1.b.m("privacyMode", jSONObject2);
        ArrayList arrayListM2 = l1.b.m("uspJurisdiction", jSONObject2);
        String strOptString2 = jSONObject2.optString("uspLspact");
        strOptString2.getClass();
        String strOptString3 = jSONObject2.optString("hashCode");
        strOptString3.getClass();
        String strOptString4 = jSONObject2.optString("publisherCountryCode");
        strOptString4.getClass();
        String strOptString5 = jSONObject2.optString("publisherName");
        strOptString5.getClass();
        ArrayList arrayListD = l1.b.d("vendorPurposeIds", jSONObject2);
        ArrayList arrayListD2 = l1.b.d("vendorFeaturesIds", jSONObject2);
        ArrayList arrayListD3 = l1.b.d("vendorPurposeLegitimateInterestIds", jSONObject2);
        ArrayList arrayListD4 = l1.b.d("vendorSpecialFeaturesIds", jSONObject2);
        ArrayList arrayListD5 = l1.b.d("vendorSpecialPurposesIds", jSONObject2);
        boolean zOptBoolean2 = jSONObject2.optBoolean("googleEnabled");
        String strOptString6 = jSONObject2.optString("consentScope");
        strOptString6.getClass();
        String strOptString7 = jSONObject2.optString("lang_");
        strOptString7.getClass();
        String strOptString8 = jSONObject2.optString("displayUi");
        strOptString8.getClass();
        boolean zOptBoolean3 = jSONObject2.optBoolean("initScreenRejectButtonShowing");
        String strOptString9 = jSONObject2.optString("publisherLogo");
        strOptString9.getClass();
        ArrayList arrayListD6 = l1.b.d("publisherPurposeIds", jSONObject2);
        ArrayList arrayListD7 = l1.b.d("publisherPurposeLegitimateInterestIds", jSONObject2);
        ArrayList arrayListD8 = l1.b.d("publisherSpecialPurposesIds", jSONObject2);
        ArrayList arrayListD9 = l1.b.d("publisherFeaturesIds", jSONObject2);
        ArrayList arrayListD10 = l1.b.d("publisherSpecialFeaturesIds", jSONObject2);
        ArrayList arrayListD11 = l1.b.d("publisherConsentRestrictionIds", jSONObject2);
        ArrayList arrayListD12 = l1.b.d("publisherLIRestrictionIds", jSONObject2);
        ArrayList arrayListD13 = l1.b.d("stacks", jSONObject2);
        int iOptInt = jSONObject2.optInt("vendorListUpdateFreq");
        String strOptString10 = jSONObject2.optString("thirdPartyStorageType");
        strOptString10.getClass();
        boolean zOptBoolean4 = jSONObject2.optBoolean("suppressCcpaLinks", false);
        String strOptString11 = jSONObject2.optString("uspDeleteDataLink");
        strOptString11.getClass();
        String strOptString12 = jSONObject2.optString("uspAccessDataLink");
        strOptString12.getClass();
        String strOptString13 = jSONObject2.optString("uspPrivacyPolicyLink");
        strOptString13.getClass();
        int iOptInt2 = jSONObject2.optInt("gvlVersion", 2);
        Integer numValueOf = Integer.valueOf(jSONObject2.optInt("totalVendors"));
        String strOptString14 = jSONObject2.optString("gdprEncodingMode");
        String strOptString15 = jSONObject2.optString("mspaJurisdiction");
        boolean zOptBoolean5 = jSONObject2.optBoolean("isCoveredTransaction", false);
        String strOptString16 = jSONObject2.optString("mspaSignalMode");
        boolean zOptBoolean6 = jSONObject2.optBoolean("ccpaViaUsp", false);
        ArrayList arrayListD14 = l1.b.d("mspaOptOutPurposeIds", jSONObject2);
        ArrayList arrayListD15 = l1.b.d("mspaSensitiveDataPurposeIds", jSONObject2);
        String strOptString17 = jSONObject2.optString("cmpVersion");
        ArrayList arrayListM3 = l1.b.m("consentLocations", jSONObject2);
        boolean zOptBoolean7 = jSONObject2.optBoolean("mspaAutoPopUp", false);
        boolean zOptBoolean8 = jSONObject2.optBoolean("gdprEnabledInUS", false);
        String strOptString18 = jSONObject2.optString("siteUuid");
        String strOptString19 = jSONObject2.optString("themeUuid");
        JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("features");
        if (jSONObjectOptJSONObject == null) {
            str = strOptString;
            Boolean bool = Boolean.FALSE;
            dVar = new o8.d(bool, bool, bool);
            arrayList = arrayListM;
            arrayList2 = arrayListM2;
            str2 = strOptString2;
        } else {
            str = strOptString;
            arrayList = arrayListM;
            arrayList2 = arrayListM2;
            str2 = strOptString2;
            dVar = new o8.d(Boolean.valueOf(jSONObjectOptJSONObject.optBoolean("visitEvents", false)), Boolean.valueOf(jSONObjectOptJSONObject.optBoolean("advancedCustomizations", false)), Boolean.valueOf(jSONObjectOptJSONObject.optBoolean("consentOrPay", false)));
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("gbcConfig");
        if (jSONObjectOptJSONObject2 == null) {
            fVar = new o8.f();
            dVar2 = dVar;
            str3 = strOptString3;
            str4 = strOptString4;
            str5 = strOptString5;
        } else {
            boolean zOptBoolean9 = jSONObjectOptJSONObject2.optBoolean("enabled", false);
            ArrayList arrayListM4 = l1.b.m("locations", jSONObjectOptJSONObject2);
            dVar2 = dVar;
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("applicablePurposes");
            ArrayList arrayList3 = new ArrayList();
            if (jSONArrayOptJSONArray == null) {
                str3 = strOptString3;
                str4 = strOptString4;
            } else {
                str3 = strOptString3;
                int length = jSONArrayOptJSONArray.length();
                str4 = strOptString4;
                int i10 = 0;
                while (i10 < length) {
                    int i11 = i10 + 1;
                    JSONObject jSONObject3 = jSONArrayOptJSONArray.getJSONObject(i10);
                    int i12 = length;
                    int iOptInt3 = jSONObject3.optInt("id");
                    String strOptString20 = jSONObject3.optString("defaultValue");
                    strOptString20.getClass();
                    arrayList3.add(new o8.e(iOptInt3, GBCConsentValue.valueOf(strOptString20)));
                    i10 = i11;
                    jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                    length = i12;
                    strOptString5 = strOptString5;
                }
            }
            str5 = strOptString5;
            fVar = new o8.f(zOptBoolean9, arrayListM4, arrayList3);
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject2.optJSONObject("consentOrPay");
        if (jSONObjectOptJSONObject3 == null) {
            bVar = new o8.b();
        } else {
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("actionButtonSettings");
            ArrayList arrayListM5 = l1.b.m("countries", jSONObjectOptJSONObject3);
            if (jSONObjectOptJSONObject4 == null) {
                zOptBoolean = false;
                z9 = false;
            } else {
                z9 = false;
                zOptBoolean = jSONObjectOptJSONObject4.optBoolean("action1Enabled", false);
            }
            bVar = new o8.b(arrayListM5, new o8.a(zOptBoolean, jSONObjectOptJSONObject4 == null ? z9 : jSONObjectOptJSONObject4.optBoolean("action2Enabled", z9)));
        }
        JSONObject jSONObject4 = jSONObject2.getJSONObject("translationUrls");
        jSONObject4.getClass();
        return new o8.c(str, arrayList, arrayList2, str2, str3, str4, str5, arrayListD, arrayListD2, arrayListD3, arrayListD4, arrayListD5, zOptBoolean2, strOptString6, strOptString7, strOptString8, zOptBoolean3, strOptString9, arrayListD6, arrayListD7, arrayListD8, arrayListD9, arrayListD10, arrayListD11, arrayListD12, arrayListD13, iOptInt, strOptString10, zOptBoolean4, strOptString11, strOptString12, strOptString13, iOptInt2, numValueOf, strOptString14, strOptString15, zOptBoolean5, strOptString16, zOptBoolean6, arrayListD14, arrayListD15, strOptString17, arrayListM3, zOptBoolean7, zOptBoolean8, strOptString18, strOptString19, dVar2, fVar, bVar, new o8.l(jSONObject4.optString("common"), jSONObject4.optString("theme"), jSONObject4.optString("all")), l1.b.m("supportedLanguages", jSONObject2));
    }

    public void l() {
        b4.a aVar = (b4.a) ((ArrayDeque) this.f182c).poll();
        this.f183d = aVar;
        if (aVar != null) {
            aVar.executeOnExecutor((ThreadPoolExecutor) this.f181b, new Object[0]);
        }
    }

    @Override // g5.z
    public void m(h5.o0 o0Var) {
        String str = (String) this.f183d;
        File file = (File) this.f182c;
        int i10 = o0Var.f8677c;
        l4.w wVar = (l4.w) this.f181b;
        if (i10 <= 0) {
            int i11 = l4.w.G;
            wVar.S(file, str);
            return;
        }
        androidx.room.b bVar = new androidx.room.b(wVar, file, str, 3);
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(wVar);
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new c5.m(wVar, o0Var, bVar, null, 6), 2);
    }

    public o8.h n() throws JSONException {
        JSONObject jSONObject = (JSONObject) this.f183d;
        if (jSONObject == null) {
            kotlin.jvm.internal.l.i("json");
            throw null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("nonIabVendorsInfo");
        JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("nonIabVendorList");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                JSONObject jSONObject3 = jSONArrayOptJSONArray.getJSONObject(i10);
                int iOptInt = jSONObject3.optInt("vendorId");
                String strOptString = jSONObject3.optString("pCode");
                strOptString.getClass();
                String strOptString2 = jSONObject3.optString(RewardPlus.NAME);
                strOptString2.getClass();
                String strOptString3 = jSONObject3.optString("description", "");
                strOptString3.getClass();
                String strOptString4 = jSONObject3.optString("privacyPolicyUrl", "");
                strOptString4.getClass();
                arrayList.add(new o8.g(iOptInt, strOptString, strOptString2, strOptString3, strOptString4, l1.b.d("nonIabPurposeConsentIds", jSONObject3), l1.b.d("nonIabPurposeLegitimateInterestIds", jSONObject3)));
                i10 = i11;
            }
        }
        String strOptString5 = jSONObject2.optString("updateAt");
        strOptString5.getClass();
        String strOptString6 = jSONObject2.optString("nonIabVendorsHash");
        strOptString6.getClass();
        return new o8.h(arrayList, strOptString5, strOptString6);
    }

    @Override // h1.d
    public void o(h1.p pVar) {
        e0.b bVar = (e0.b) this.f181b;
        String str = (String) this.f182c;
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.f183d;
        synchronized (bVar.f7591a) {
            bVar.f7591a.remove(str);
        }
        scheduledFuture.cancel(false);
    }

    @Override // g5.z
    public void q() {
        l4.w wVar = (l4.w) this.f181b;
        File file = (File) this.f182c;
        String str = (String) this.f183d;
        int i10 = l4.w.G;
        wVar.S(file, str);
    }

    @Override // t4.a
    public void s(Object obj, int i10, int i11, long j10) {
        obj.getClass();
    }

    @Override // t4.a
    public void t(File file) {
        file.getClass();
    }

    public String toString() {
        switch (this.f180a) {
            case 28:
                StringBuilder sb = new StringBuilder(32);
                sb.append((String) this.f181b);
                sb.append('{');
                i0.k kVar = (i0.k) ((i0.k) this.f182c).f8923b;
                String str = "";
                while (kVar != null) {
                    Object obj = kVar.f8924c;
                    sb.append(str);
                    if (obj == null || !obj.getClass().isArray()) {
                        sb.append(obj);
                    } else {
                        String strDeepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                    }
                    kVar = (i0.k) kVar.f8923b;
                    str = ", ";
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public o8.j u() throws JSONException {
        JSONObject jSONObject = (JSONObject) this.f183d;
        if (jSONObject == null) {
            kotlin.jvm.internal.l.i("json");
            throw null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("premiumProperties");
        jSONObject2.getClass();
        return new o8.j(l1.b.d("vendorBlacklist", jSONObject2), l1.b.d("vendorWhitelist", jSONObject2), l1.b.d("googleWhitelist", jSONObject2));
    }

    @Override // t4.a
    public void w(int i10, String str, long j10, long j11) {
        str.getClass();
    }

    public d9.p y() throws JSONException {
        JSONObject jSONObject = (JSONObject) this.f183d;
        d9.p pVar = null;
        ArrayList arrayList = null;
        if (jSONObject == null) {
            kotlin.jvm.internal.l.i("json");
            throw null;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("premiumUiLabels");
        if (jSONObjectOptJSONObject != null) {
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("initScreenCustomLinks");
            if (jSONArrayOptJSONArray != null) {
                arrayList = new ArrayList();
                int length = jSONArrayOptJSONArray.length();
                int i10 = 0;
                while (i10 < length) {
                    int i11 = i10 + 1;
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i10);
                    String strOptString = jSONObjectOptJSONObject2.optString("label");
                    strOptString.getClass();
                    String strOptString2 = jSONObjectOptJSONObject2.optString("link");
                    strOptString2.getClass();
                    arrayList.add(new d9.q(strOptString, strOptString2));
                    i10 = i11;
                }
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            String strOptString3 = jSONObjectOptJSONObject.optString("uspDnsTitle");
            ArrayList arrayListM = l1.b.m("uspDnsText", jSONObjectOptJSONObject);
            String strOptString4 = jSONObjectOptJSONObject.optString("uspDeleteDataLinkText");
            String strOptString5 = jSONObjectOptJSONObject.optString("uspAccessDataLinkText");
            String strOptString6 = jSONObjectOptJSONObject.optString("uspPrivacyPolicyLinkText");
            strOptString3.getClass();
            strOptString6.getClass();
            strOptString4.getClass();
            strOptString5.getClass();
            pVar = new d9.p(null, null, strOptString3, arrayListM, null, strOptString6, strOptString4, strOptString5, null, arrayList, 275);
        }
        return pVar == null ? new d9.p(null, null, null, null, null, null, null, null, null, null, 1023) : pVar;
    }

    public o8.k z() {
        JSONObject jSONObject = (JSONObject) this.f183d;
        if (jSONObject == null) {
            kotlin.jvm.internal.l.i("json");
            throw null;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("theme");
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        String strOptString = jSONObjectOptJSONObject.optString("themeMode");
        strOptString.getClass();
        return new o8.k(strOptString, f(jSONObjectOptJSONObject.optJSONObject("lightModeColors")), f(jSONObjectOptJSONObject.optJSONObject("darkModeColors")));
    }

    @Override // t4.a
    public void k(DocumentFile documentFile) {
    }

    @Override // t4.a
    public void v(DocumentFile documentFile) {
    }

    public /* synthetic */ x(int i10, boolean z9) {
        this.f180a = i10;
    }

    public /* synthetic */ x(v4 v4Var, String str, Object obj, int i10) {
        this.f180a = i10;
        this.f181b = str;
        this.f182c = obj;
        this.f183d = v4Var;
    }

    public /* synthetic */ x(Object obj, Object obj2, Object obj3, int i10) {
        this.f180a = i10;
        this.f181b = obj;
        this.f182c = obj2;
        this.f183d = obj3;
    }

    public x(Application application, Locale locale) {
        this.f180a = 25;
        this.f181b = application;
        this.f182c = locale;
    }

    public x(Context context, u1 u1Var) {
        this.f180a = 5;
        this.f183d = new AtomicLong(-1L);
        this.f182c = new k0.b(context, k0.b.f10037k, new i0.o("measurement:api"), g0.c.f8184c);
        this.f181b = u1Var;
    }

    public x(ChoiceCmpCallback choiceCmpCallback, c1.d0 d0Var) {
        this.f180a = 26;
        d0Var.getClass();
        this.f181b = choiceCmpCallback;
        this.f182c = d0Var;
    }

    public x(com.google.android.gms.internal.measurement.b bVar) {
        this.f180a = 13;
        this.f181b = bVar;
        this.f182c = bVar.clone();
        this.f183d = new ArrayList();
    }

    public x(Context context, h5.p pVar, h5.v0 v0Var) {
        this.f180a = 12;
        context.getClass();
        pVar.getClass();
        this.f181b = context;
        this.f182c = pVar;
        this.f183d = v0Var;
    }

    public x(Context context, t3 t3Var) {
        this.f180a = 9;
        context.getClass();
        this.f181b = context;
        this.f182c = t3Var;
    }

    public x(d0.i iVar, c3.c cVar, c3.c cVar2) {
        this.f180a = 14;
        this.f182c = iVar;
        this.f181b = cVar;
        this.f183d = cVar2;
    }

    public x(String str, HashMap map) {
        this.f180a = 2;
        this.f181b = str;
        this.f182c = map;
        this.f183d = new HashMap();
    }

    public x(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, MaxHeightRecyclerView maxHeightRecyclerView, TextView textView, TextView textView2, View view) {
        this.f180a = 19;
        this.f181b = relativeLayout;
        this.f182c = relativeLayout2;
        this.f183d = view;
    }

    public x(String str) {
        this.f180a = 28;
        i0.k kVar = new i0.k(3, false);
        this.f182c = kVar;
        this.f183d = kVar;
        this.f181b = str;
    }
}
