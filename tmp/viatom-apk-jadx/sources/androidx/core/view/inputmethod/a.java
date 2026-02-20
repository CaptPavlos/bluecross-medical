package androidx.core.view.inputmethod;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.appcompat.widget.Toolbar;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.work.Constraints;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.impl.WorkDatabase;
import c1.l;
import c5.x;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.gson.internal.m;
import com.google.gson.internal.t;
import com.mbridge.msdk.foundation.download.Command;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.ListsActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.MyStatsActivity;
import com.uptodown.activities.NotificationsRegistryActivity;
import com.uptodown.activities.PreregistrationActivity;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.RollbackActivity;
import com.uptodown.activities.SearchActivity;
import com.uptodown.activities.UserDevicesActivity;
import com.uptodown.core.activities.ConfirmationIntentWrapperActivity;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.tv.ui.activity.TvAppsListActivity;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import com.uptodown.tv.ui.fragment.TvSearchFragment;
import com.uptodown.views.InstantAutoCompleteTextView;
import com.uptodown.workers.SendUserUsageStatsWorker;
import e5.b2;
import e5.f2;
import e5.m1;
import h1.d;
import h1.p;
import h5.c1;
import h5.e1;
import h5.h;
import h5.k;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import l2.e;
import l4.a4;
import l4.d5;
import l4.e5;
import l4.f0;
import l4.ob;
import l4.p2;
import l4.u4;
import l4.v4;
import l4.x4;
import n.b;
import n.c;
import o.u;
import r7.i0;
import r7.w;
import r7.y;
import s5.g0;
import v5.o;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements InputConnectionCompat.OnCommitContentListener, SupportSQLiteOpenHelper.Factory, AccessibilityViewCommand, MaterialShapeDrawable.OnCornerSizeChangeListener, CanvasCompat.CanvasOperation, m, SwipeRefreshLayout.OnRefreshListener, ActivityResultCallback, d, Toolbar.OnMenuItemClickListener, q1.d, OnItemViewClickedListener, q2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f526a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f527b;

    public /* synthetic */ a(Object obj, int i10) {
        this.f526a = i10;
        this.f527b = obj;
    }

    public b a(p2 p2Var) throws IOException {
        c cVar = (c) this.f527b;
        URL url = (URL) p2Var.f10716c;
        String strC = t1.C("CctTransportBackend");
        if (Log.isLoggable(strC, 4)) {
            Log.i(strC, String.format("Making request to: %s", url));
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(cVar.g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
        httpURLConnection.setRequestProperty(Command.HTTP_HEADER_USER_AGENT, "datatransport/3.3.0 android/");
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = (String) p2Var.f10715b;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    y2.c cVar2 = cVar.f11262a;
                    o.m mVar = (o.m) p2Var.f10717d;
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(gZIPOutputStream));
                    l2.d dVar = (l2.d) cVar2.f13781b;
                    e eVar = new e(bufferedWriter, dVar.f10194a, dVar.f10195b, dVar.f10196c, dVar.f10197d);
                    eVar.h(mVar);
                    eVar.j();
                    eVar.f10199b.flush();
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Integer numValueOf = Integer.valueOf(responseCode);
                    String strC2 = t1.C("CctTransportBackend");
                    if (Log.isLoggable(strC2, 4)) {
                        Log.i(strC2, String.format("Status Code: %d", numValueOf));
                    }
                    t1.l(httpURLConnection.getHeaderField("Content-Type"), "CctTransportBackend", "Content-Type: %s");
                    t1.l(httpURLConnection.getHeaderField("Content-Encoding"), "CctTransportBackend", "Content-Encoding: %s");
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new b(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                        try {
                            b bVar = new b(responseCode, null, u.a(new BufferedReader(new InputStreamReader(gZIPInputStream))).f11655a);
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return bVar;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (j2.b e) {
            e = e;
            t1.m("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        } catch (ConnectException e3) {
            e = e3;
            t1.m("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (UnknownHostException e7) {
            e = e7;
            t1.m("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (IOException e10) {
            e = e10;
            t1.m("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        }
    }

    @Override // q2.a
    public void b(q2.b bVar) {
        t1.b bVar2 = (t1.b) this.f527b;
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Crashlytics native component now available.", null);
        }
        bVar2.f12749b.set((t1.b) bVar.get());
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0425  */
    @Override // q1.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(a3.z0 r51) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.inputmethod.a.c(a3.z0):java.lang.Object");
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return WorkDatabase.Companion.create$lambda$0((Context) this.f527b, configuration);
    }

    @Override // com.google.gson.internal.m
    public Object d() {
        int i10 = this.f526a;
        Object obj = this.f527b;
        switch (i10) {
            case 6:
                Constructor constructor = (Constructor) obj;
                try {
                    return constructor.newInstance(null);
                } catch (IllegalAccessException e) {
                    t1 t1Var = h3.c.f8442a;
                    androidx.privacysandbox.ads.adservices.adid.a.l("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
                    return null;
                } catch (InstantiationException e3) {
                    throw new RuntimeException("Failed to invoke constructor '" + h3.c.b(constructor) + "' with no args", e3);
                } catch (InvocationTargetException e7) {
                    androidx.privacysandbox.ads.adservices.adid.a.l("Failed to invoke constructor '" + h3.c.b(constructor) + "' with no args", e7.getCause());
                    return null;
                }
            default:
                Class cls = (Class) obj;
                try {
                    return t.f2598a.a(cls);
                } catch (Exception e10) {
                    throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e10);
                }
        }
    }

    @Override // h1.d
    public void o(p pVar) {
        UptodownApp uptodownApp = (UptodownApp) this.f527b;
        pVar.getClass();
        if (pVar.i()) {
            String str = (String) pVar.g();
            try {
                SharedPreferences.Editor editorEdit = uptodownApp.getSharedPreferences("SettingsPreferences", 0).edit();
                editorEdit.putString("fcmToken", str);
                editorEdit.apply();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        SharedPreferences sharedPreferences;
        e1 e1VarH;
        String str;
        int i10 = this.f526a;
        int i11 = 4;
        int i12 = 0;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object obj2 = this.f527b;
        switch (i10) {
            case 9:
                b2 b2Var = (b2) obj2;
                if (((ActivityResult) obj).getResultCode() == 1 && b2Var.f7688c.f8635d && b2Var.getContext() != null) {
                    f2 f2VarD = b2Var.d();
                    Context contextRequireContext = b2Var.requireContext();
                    contextRequireContext.getClass();
                    f2VarD.c(contextRequireContext, b2Var.f7688c.f8632a);
                    break;
                }
                break;
            case 10:
            case 12:
            case 13:
            case 15:
            case 21:
            default:
                TvAppDetailFragment.a((TvAppDetailFragment) obj2);
                break;
            case 11:
                ListsActivity listsActivity = (ListsActivity) obj2;
                int i13 = ListsActivity.K;
                if (((ActivityResult) obj).getResultCode() == 1) {
                    listsActivity.setResult(1);
                    listsActivity.finish();
                    break;
                }
                break;
            case 14:
                MyStatsActivity myStatsActivity = (MyStatsActivity) obj2;
                int i14 = MyStatsActivity.K;
                if (!o.b(myStatsActivity)) {
                    try {
                        SharedPreferences.Editor editorEdit = myStatsActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                        editorEdit.putBoolean("stats_enabled", false);
                        editorEdit.apply();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    float f = UptodownApp.E;
                    if (k4.c.o(myStatsActivity, "SendUserUsageStatsWorker")) {
                        WorkManager.Companion.getInstance(myStatsActivity).cancelAllWorkByTag("SendUserUsageStatsWorker");
                    }
                    myStatsActivity.finish();
                    break;
                } else {
                    myStatsActivity.o0();
                    v4 v4Var = (v4) myStatsActivity.I.getValue();
                    v4Var.getClass();
                    w viewModelScope = ViewModelKt.getViewModelScope(v4Var);
                    y7.e eVar = i0.f12407a;
                    y.q(viewModelScope, y7.d.f14116a, null, new u4(v4Var, myStatsActivity, objArr == true ? 1 : 0, i12), 2);
                    try {
                        SharedPreferences.Editor editorEdit2 = myStatsActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                        editorEdit2.putBoolean("stats_enabled", true);
                        editorEdit2.apply();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    float f10 = UptodownApp.E;
                    if (!k4.c.o(myStatsActivity, "SendUserUsageStatsWorker")) {
                        WorkManager.Companion.getInstance(myStatsActivity).enqueue(new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) SendUserUsageStatsWorker.class, 24L, TimeUnit.HOURS).addTag("SendUserUsageStatsWorker").setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build());
                        break;
                    }
                }
                break;
            case 16:
                PreregistrationActivity preregistrationActivity = (PreregistrationActivity) obj2;
                int i15 = PreregistrationActivity.M;
                if (((ActivityResult) obj).getResultCode() == 1) {
                    SharedPreferences sharedPreferences2 = preregistrationActivity.getSharedPreferences("SharedPreferencesUser", 0);
                    try {
                        sharedPreferences = preregistrationActivity.getSharedPreferences("SettingsPreferences", 0);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                    String string = sharedPreferences.contains("UTOKEN") ? sharedPreferences.getString("UTOKEN", null) : null;
                    if (string != null || sharedPreferences2.getString("is_turbo", null) != null) {
                        float f11 = UptodownApp.E;
                        k4.c.B(preregistrationActivity);
                        k4.c.A(preregistrationActivity);
                        break;
                    }
                }
                break;
            case 17:
                PublicProfileActivity publicProfileActivity = (PublicProfileActivity) obj2;
                int i16 = PublicProfileActivity.K;
                if (((ActivityResult) obj).getResultCode() == 10 && (e1VarH = c1.h(publicProfileActivity)) != null && (str = e1VarH.f8512a) != null && str.length() != 0) {
                    new x(publicProfileActivity, LifecycleOwnerKt.getLifecycleScope(publicProfileActivity)).a(String.valueOf(e1VarH.f8512a), new x4(publicProfileActivity, i11));
                    break;
                }
                break;
            case 18:
                RollbackActivity rollbackActivity = (RollbackActivity) obj2;
                int i17 = RollbackActivity.Y;
                if (((ActivityResult) obj).getResultCode() == -1) {
                    rollbackActivity.f10934v = new t1.c(rollbackActivity, 4);
                    rollbackActivity.B0().e.setVisibility(8);
                    rollbackActivity.B0().f.setText(rollbackActivity.getString(R.string.msg_checking_device_rollback));
                    break;
                }
                break;
            case 19:
                SearchActivity searchActivity = (SearchActivity) obj2;
                ActivityResult activityResult = (ActivityResult) obj;
                int i18 = SearchActivity.Q;
                if (activityResult.getResultCode() == -1 && activityResult.getData() != null) {
                    Intent data = activityResult.getData();
                    data.getClass();
                    ArrayList<String> stringArrayListExtra = data.getStringArrayListExtra("android.speech.extra.RESULTS");
                    ((InstantAutoCompleteTextView) searchActivity.o0().f7377b.f13463c).setText(stringArrayListExtra != null ? stringArrayListExtra.get(0) : null);
                    break;
                }
                break;
            case 20:
                UserDevicesActivity userDevicesActivity = (UserDevicesActivity) obj2;
                int i19 = UserDevicesActivity.K;
                int resultCode = ((ActivityResult) obj).getResultCode();
                if (resultCode != 3 && resultCode != 4) {
                    if (resultCode == 5) {
                        userDevicesActivity.setResult(5);
                        userDevicesActivity.finish();
                        break;
                    }
                } else {
                    ob obVar = (ob) userDevicesActivity.I.getValue();
                    obVar.getClass();
                    w viewModelScope2 = ViewModelKt.getViewModelScope(obVar);
                    y7.e eVar2 = i0.f12407a;
                    y.q(viewModelScope2, y7.d.f14116a, null, new u4(userDevicesActivity, obVar, objArr2 == true ? 1 : 0, 13), 2);
                    break;
                }
                break;
            case 22:
                ConfirmationIntentWrapperActivity confirmationIntentWrapperActivity = (ConfirmationIntentWrapperActivity) obj2;
                int i20 = ConfirmationIntentWrapperActivity.f6662c;
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(confirmationIntentWrapperActivity);
                y7.e eVar3 = i0.f12407a;
                y.q(lifecycleScope, y7.d.f14116a, null, new a3.o(confirmationIntentWrapperActivity, objArr3 == true ? 1 : 0, 28), 2);
                break;
        }
    }

    @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
    public boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i10, Bundle bundle) {
        return InputConnectionCompat.lambda$createOnCommitContentListenerUsingPerformReceiveContent$0((View) this.f527b, inputContentInfoCompat, i10, bundle);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable.OnCornerSizeChangeListener
    public void onCornerSizeChange(float f) {
        ((MaterialButton) this.f527b).lambda$setOpticalCenterEnabled$0(f);
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        int i10 = this.f526a;
        Object obj2 = this.f527b;
        switch (i10) {
            case 26:
                s5.m mVar = (s5.m) obj2;
                if (!(obj instanceof h)) {
                    if (!(obj instanceof o5.c)) {
                        if (obj instanceof k) {
                            Intent intent = new Intent(mVar.getContext(), (Class<?>) TvAppsListActivity.class);
                            intent.putExtra("category", (Parcelable) obj);
                            mVar.startActivity(intent);
                            break;
                        }
                    } else {
                        Intent intent2 = new Intent(mVar.getContext(), (Class<?>) TvAppsListActivity.class);
                        intent2.putExtra("category", ((o5.c) obj).f11734a);
                        mVar.startActivity(intent2);
                        break;
                    }
                } else if (viewHolder != null && mVar.getContext() != null) {
                    Context contextRequireContext = mVar.requireContext();
                    contextRequireContext.getClass();
                    new l(contextRequireContext, ((h) obj).f8566a, new s5.l(mVar, viewHolder), LifecycleOwnerKt.getLifecycleScope(mVar));
                    break;
                }
                break;
            case 27:
                s5.p pVar = (s5.p) obj2;
                if (!(obj instanceof h)) {
                    if (!(obj instanceof o5.c)) {
                        if (obj instanceof k) {
                            Intent intent3 = new Intent(pVar.getContext(), (Class<?>) TvAppsListActivity.class);
                            intent3.putExtra("category", (Parcelable) obj);
                            pVar.startActivity(intent3);
                            break;
                        }
                    } else {
                        Intent intent4 = new Intent(pVar.getContext(), (Class<?>) TvAppsListActivity.class);
                        intent4.putExtra("category", ((o5.c) obj).f11734a);
                        pVar.startActivity(intent4);
                        break;
                    }
                } else if (viewHolder != null) {
                    Context contextRequireContext2 = pVar.requireContext();
                    contextRequireContext2.getClass();
                    new l(contextRequireContext2, ((h) obj).f8566a, new s5.o(pVar, viewHolder), LifecycleOwnerKt.getLifecycleScope(pVar));
                    break;
                }
                break;
            default:
                TvSearchFragment tvSearchFragment = (TvSearchFragment) obj2;
                int i11 = TvSearchFragment.f6719d;
                obj.getClass();
                y.q(LifecycleOwnerKt.getLifecycleScope(tvSearchFragment), null, null, new g0(tvSearchFragment, (h) obj, null, 1), 3);
                break;
        }
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        int i10 = this.f526a;
        int i11 = 0;
        Object obj = this.f527b;
        switch (i10) {
            case 12:
                MyApps myApps = (MyApps) obj;
                int i12 = MyApps.f6655j0;
                menuItem.getClass();
                if (menuItem.getItemId() != R.id.action_show_system_apps) {
                    if (menuItem.getItemId() != R.id.action_show_system_services) {
                        if (menuItem.getItemId() == R.id.action_search) {
                            if (myApps.E0().f.getVisibility() != 0) {
                                myApps.E0().f.setVisibility(0);
                                myApps.E0().f.requestFocus();
                                myApps.showKeyboard(myApps.E0().f);
                                break;
                            } else {
                                myApps.E0().f.setVisibility(8);
                                myApps.E0().f.clearFocus();
                                break;
                            }
                        }
                    } else {
                        boolean z9 = !menuItem.isChecked();
                        menuItem.setChecked(z9);
                        Context applicationContext = myApps.getApplicationContext();
                        applicationContext.getClass();
                        try {
                            SharedPreferences.Editor editorEdit = applicationContext.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit.putBoolean("show_system_services", z9);
                            editorEdit.apply();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        myApps.G0(true);
                        break;
                    }
                } else {
                    boolean zIsChecked = menuItem.isChecked();
                    boolean z10 = !zIsChecked;
                    menuItem.setChecked(z10);
                    Context applicationContext2 = myApps.getApplicationContext();
                    applicationContext2.getClass();
                    t1.N(applicationContext2, "show_system_apps", z10);
                    if (zIsChecked) {
                        Context applicationContext3 = myApps.getApplicationContext();
                        applicationContext3.getClass();
                        t1.N(applicationContext3, "show_system_services", false);
                        a4.q0(myApps.E0().g, false);
                        Toolbar toolbar = myApps.E0().g;
                        if (toolbar.getMenu() != null) {
                            Menu menu = toolbar.getMenu();
                            menu.getClass();
                            menu.findItem(R.id.action_show_system_services).setChecked(false);
                        }
                    } else {
                        a4.q0(myApps.E0().g, true);
                    }
                    myApps.G0(true);
                    break;
                }
                break;
            case 13:
                MyDownloads myDownloads = (MyDownloads) obj;
                int i13 = MyDownloads.O;
                if (menuItem.getItemId() == R.id.action_file_explorer) {
                    myDownloads.startActivity(new Intent(myDownloads, (Class<?>) FileExplorerActivity.class));
                }
                if (menuItem.getItemId() == R.id.action_search) {
                    if (myDownloads.p0().f.getVisibility() != 0) {
                        myDownloads.p0().f.setVisibility(0);
                        myDownloads.p0().f.requestFocus();
                        myDownloads.showKeyboard(myDownloads.p0().f);
                        break;
                    } else {
                        myDownloads.p0().f.setVisibility(8);
                        myDownloads.p0().f.clearFocus();
                        break;
                    }
                }
                break;
            default:
                NotificationsRegistryActivity notificationsRegistryActivity = (NotificationsRegistryActivity) obj;
                int i14 = NotificationsRegistryActivity.M;
                menuItem.getClass();
                if (menuItem.getItemId() == R.id.action_delete_all) {
                    e5 e5VarQ0 = notificationsRegistryActivity.q0();
                    e5VarQ0.getClass();
                    w viewModelScope = ViewModelKt.getViewModelScope(e5VarQ0);
                    y7.e eVar = i0.f12407a;
                    y.q(viewModelScope, y7.d.f14116a, null, new d5(notificationsRegistryActivity, e5VarQ0, null, i11), 2);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        m1 m1Var = (m1) this.f527b;
        Context contextRequireContext = m1Var.requireContext();
        contextRequireContext.getClass();
        if (c1.h(contextRequireContext) == null) {
            m1Var.a().h.setRefreshing(false);
            return;
        }
        f0 f0VarB = m1Var.b();
        Context contextRequireContext2 = m1Var.requireContext();
        contextRequireContext2.getClass();
        f0VarB.getClass();
        f0VarB.e = 0;
        f0VarB.f = true;
        f0VarB.a(contextRequireContext2);
        m1Var.a().h.setRefreshing(true);
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return ((BottomSheetDragHandleView) this.f527b).lambda$onBottomSheetStateChanged$0(view, commandArguments);
    }

    @Override // com.google.android.material.canvas.CanvasCompat.CanvasOperation
    public void run(Canvas canvas) {
        switch (this.f526a) {
            case 4:
                ((MaskableFrameLayout) this.f527b).lambda$dispatchDraw$1(canvas);
                break;
            default:
                ((NavigationView) this.f527b).lambda$dispatchDraw$0(canvas);
                break;
        }
    }
}
