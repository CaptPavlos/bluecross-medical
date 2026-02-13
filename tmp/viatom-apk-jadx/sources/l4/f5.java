package l4;

import android.app.AlertDialog;
import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.view.PointerIconCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppFilesActivity;
import com.uptodown.activities.FollowListActivity;
import com.uptodown.activities.LanguageSettingsActivity;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.OrganizationActivity;
import com.uptodown.activities.PreregistrationActivity;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.ReviewsActivity;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.UserCommentsActivity;
import com.uptodown.activities.UserDeviceDetailsActivity;
import com.uptodown.activities.UserDevicesActivity;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.core.activities.InstallerActivity;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class f5 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10394a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10395b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10396c;

    public /* synthetic */ f5(a3.z0 z0Var, OldVersionsActivity oldVersionsActivity) {
        this.f10394a = 1;
        this.f10396c = z0Var;
        this.f10395b = oldVersionsActivity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Resources.NotFoundException {
        TextView textView;
        int i10 = this.f10394a;
        int i11 = -1;
        int i12 = 25;
        int i13 = 0;
        Object obj = this.f10396c;
        Object obj2 = this.f10395b;
        switch (i10) {
            case 0:
                OldVersionsActivity oldVersionsActivity = (OldVersionsActivity) obj2;
                int i14 = OldVersionsActivity.L;
                oldVersionsActivity.s0((h5.q) obj);
                AlertDialog alertDialog = oldVersionsActivity.f10935w;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                    break;
                }
                break;
            case 1:
                OldVersionsActivity oldVersionsActivity2 = (OldVersionsActivity) obj2;
                int i15 = OldVersionsActivity.L;
                if (((CheckBox) ((a3.z0) obj).f196b).isChecked()) {
                    try {
                        SharedPreferences.Editor editorEdit = oldVersionsActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                        editorEdit.putBoolean("show_warning_download_incompatible", true);
                        editorEdit.apply();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                AlertDialog alertDialog2 = oldVersionsActivity2.f10935w;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                    break;
                }
                break;
            case 2:
                d5.g0 g0Var = (d5.g0) obj;
                int i16 = OrganizationActivity.K;
                String str = ((h5.d0) obj2).h;
                if (str != null && str.length() != 0) {
                    View view2 = g0Var.f7073q;
                    TextView textView2 = g0Var.f7068l;
                    int visibility = view2.getVisibility();
                    TextView textView3 = g0Var.f7070n;
                    if (visibility != 0) {
                        textView3.setText(R.string.read_more_desc_app_detail);
                        view2.setVisibility(0);
                        textView2.setMaxLines(6);
                        textView2.setEllipsize(TextUtils.TruncateAt.END);
                        break;
                    } else {
                        textView3.setText(R.string.read_less_desc_app_detail);
                        view2.setVisibility(8);
                        textView2.setMaxLines(Integer.MAX_VALUE);
                        textView2.setEllipsize(null);
                        break;
                    }
                }
                break;
            case 3:
                PreregistrationActivity preregistrationActivity = (PreregistrationActivity) obj2;
                int i17 = PreregistrationActivity.M;
                y7.e eVar = r7.i0.f12407a;
                r7.y.q(r7.y.a(y7.d.f14116a), null, null, new u4(preregistrationActivity, (h5.g0) obj, null == true ? 1 : 0, 6), 3);
                AlertDialog alertDialog3 = preregistrationActivity.f10935w;
                alertDialog3.getClass();
                alertDialog3.dismiss();
                break;
            case 4:
                PublicProfileActivity publicProfileActivity = (PublicProfileActivity) obj2;
                h5.e1 e1Var = (h5.e1) ((kotlin.jvm.internal.x) obj).f10138a;
                String str2 = e1Var != null ? e1Var.f8512a : null;
                int i18 = PublicProfileActivity.K;
                Intent intent = new Intent(publicProfileActivity, (Class<?>) UserCommentsActivity.class);
                intent.putExtra("userID", str2);
                float f = UptodownApp.E;
                publicProfileActivity.startActivity(intent, k4.c.a(publicProfileActivity));
                break;
            case 5:
                ReviewsActivity reviewsActivity = (ReviewsActivity) obj2;
                Drawable drawable = (Drawable) obj;
                int i19 = ReviewsActivity.M;
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    u7.m0 m0Var = reviewsActivity.p0().f10563l;
                    m0Var.getClass();
                    m0Var.g(null, 5);
                    reviewsActivity.n0().e.setImageDrawable(drawable);
                    reviewsActivity.n0().f.setImageDrawable(drawable);
                    reviewsActivity.n0().g.setImageDrawable(drawable);
                    reviewsActivity.n0().h.setImageDrawable(drawable);
                    reviewsActivity.n0().f7353i.setImageDrawable(drawable);
                    break;
                }
                break;
            case 6:
                SecurityActivity securityActivity = (SecurityActivity) obj2;
                d5.x0 x0Var = (d5.x0) obj;
                int i20 = SecurityActivity.Z;
                float f11 = UptodownApp.E;
                if (k4.c.s()) {
                    LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(securityActivity);
                    y7.e eVar2 = r7.i0.f12407a;
                    r7.y.q(lifecycleScope, y7.d.f14116a, null, new a3.o((Object) securityActivity, (Object) x0Var, (w6.c) (null == true ? 1 : 0), i12), 2);
                    break;
                }
                break;
            case 7:
                Updates updates = (Updates) obj2;
                String str3 = (String) obj;
                updates.Q();
                UptodownApp.l0 = null;
                if (!updates.Y.isEmpty()) {
                    updates.F0(str3);
                    updates.G0();
                }
                updates.G0();
                break;
            case 8:
                UserDevicesActivity userDevicesActivity = (UserDevicesActivity) obj2;
                int i21 = UserDevicesActivity.K;
                Intent intent2 = new Intent(userDevicesActivity, (Class<?>) UserDeviceDetailsActivity.class);
                intent2.putExtra("user_device", (h5.h1) obj);
                ActivityResultLauncher activityResultLauncher = userDevicesActivity.J;
                float f12 = UptodownApp.E;
                activityResultLauncher.launch(intent2, k4.c.b(userDevicesActivity));
                break;
            case 9:
                Context context = (Context) obj2;
                context.getClass();
                Intent intent3 = new Intent("android.intent.action.VIEW");
                intent3.setData(Uri.parse(((d9.q) obj).f7576b));
                context.startActivity(intent3);
                break;
            case 10:
                l9.m mVar = (l9.m) obj2;
                d9.r rVar = (d9.r) obj;
                mVar.getClass();
                e6.c cVar = mVar.f11140a;
                cVar.getClass();
                FragmentActivity activity = cVar.getActivity();
                if (activity != null && activity.getSupportFragmentManager().findFragmentByTag("o6.b") == null) {
                    int i22 = rVar.f7577a;
                    o6.b bVar = new o6.b();
                    Bundle bundle = new Bundle();
                    bundle.putInt("stack_id", i22);
                    bVar.setArguments(bundle);
                    activity.getSupportFragmentManager().beginTransaction().add(bVar, "o6.b").commit();
                    break;
                }
                break;
            case 11:
                int i23 = PreferencesActivity.M;
                ((kotlin.jvm.internal.v) obj2).f10136a = ((Number) ((Map.Entry) obj).getKey()).intValue();
                break;
            case 12:
                n4.i iVar = (n4.i) obj2;
                h5.h hVar = (h5.h) obj;
                if (iVar.f11370a != null && iVar.getBindingAdapterPosition() != -1) {
                    g5.j jVar = iVar.f11370a;
                    jVar.getClass();
                    jVar.z(hVar);
                    break;
                }
                break;
            case 13:
                ((n4.x) obj2).f11508c.z((h5.h) obj);
                break;
            case 14:
                h5.g0 g0Var2 = (h5.g0) obj;
                q qVar = ((n4.c0) obj2).f11313b;
                qVar.getClass();
                w wVar = qVar.f10746a;
                wVar.Y(g0Var2.f8558a);
                n4.c0 c0Var = wVar.A;
                if (c0Var != null) {
                    Iterator it = c0Var.f11315d.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            int i24 = i13 + 1;
                            if (((h5.g0) it.next()).f8558a == g0Var2.f8558a) {
                                i11 = i13;
                            } else {
                                i13 = i24;
                            }
                        }
                    }
                    c0Var.a(i11);
                    break;
                }
                break;
            case 15:
                n4.g1 g1Var = (n4.g1) obj2;
                h5.t0 t0Var = (h5.t0) obj;
                view.getClass();
                g5.n nVar = g1Var.f11351c;
                d5.r0 r0Var = g1Var.f11350b;
                Object tag = view.getTag();
                tag.getClass();
                nVar.B(((Integer) tag).intValue());
                Context context2 = g1Var.itemView.getContext();
                context2.getClass();
                if (h5.c1.h(context2) != null) {
                    Context context3 = g1Var.itemView.getContext();
                    context3.getClass();
                    new c1.w4(context3, 5, false).F(r0Var.f7316c);
                    if (!v5.n.f13172d.contains(Long.valueOf(t0Var.f8739a))) {
                        r0Var.f7323n.setText(String.valueOf(t0Var.f8744j + 1));
                        break;
                    }
                }
                break;
            case 16:
                EditText editText = (EditText) obj2;
                FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) obj;
                int i25 = FileExplorerActivity.f6665q0;
                if (editText.getText().toString().length() <= 0) {
                    String string = fileExplorerActivity.getString(R.string.core_compress_dialog_file_name_empty);
                    string.getClass();
                    fileExplorerActivity.C(string);
                    break;
                } else {
                    y7.e eVar3 = r7.i0.f12407a;
                    r7.y.q(r7.y.a(y7.d.f14116a), null, null, new u4(fileExplorerActivity, editText, null == true ? 1 : 0, 20), 3);
                    break;
                }
            case 17:
                FileExplorerActivity fileExplorerActivity2 = (FileExplorerActivity) obj;
                int i26 = FileExplorerActivity.f6665q0;
                if (obj2 instanceof File) {
                    Application application = fileExplorerActivity2.getApplication();
                    application.getClass();
                    String absolutePath = ((File) obj2).getAbsolutePath();
                    absolutePath.getClass();
                    Intent intent4 = new Intent(fileExplorerActivity2, (Class<?>) InstallerActivity.class);
                    intent4.putExtra("realPath", absolutePath);
                    intent4.putExtra("requireUserAction", false);
                    intent4.putExtra("backgroundInstallation", false);
                    intent4.addFlags(268435456);
                    fileExplorerActivity2.startActivity(intent4);
                } else if (obj2 instanceof DocumentFile) {
                    DocumentFile documentFile = (DocumentFile) obj2;
                    Application application2 = fileExplorerActivity2.getApplication();
                    application2.getClass();
                    documentFile.getUri().getClass();
                    Uri uri = documentFile.getUri();
                    uri.getClass();
                    Intent intent5 = new Intent(fileExplorerActivity2, (Class<?>) InstallerActivity.class);
                    intent5.setData(uri);
                    intent5.putExtra("requireUserAction", false);
                    intent5.putExtra("backgroundInstallation", false);
                    intent5.addFlags(268435456);
                    fileExplorerActivity2.startActivity(intent5);
                }
                AlertDialog alertDialog4 = fileExplorerActivity2.J;
                alertDialog4.getClass();
                alertDialog4.dismiss();
                break;
            case 18:
                InstallerActivity installerActivity = (InstallerActivity) obj2;
                AlertDialog alertDialog5 = installerActivity.N;
                alertDialog5.getClass();
                alertDialog5.dismiss();
                installerActivity.J(installerActivity, ((d5.j) obj).m());
                break;
            case 19:
                p4.m0 m0Var2 = (p4.m0) obj2;
                m0Var2.G();
                String str4 = ((u4.c) obj).f12899b;
                m0Var2.E();
                TextView textView4 = m0Var2.f11997s;
                if (textView4 != null) {
                    textView4.setText(m0Var2.getString(R.string.msg_receiving));
                }
                if (str4 != null && (textView = m0Var2.t) != null) {
                    textView.setText(str4);
                }
                v4.a aVar = o4.b.f11721u;
                aVar.getClass();
                aVar.d(true);
                break;
            case 20:
                p4.m0 m0Var3 = (p4.m0) obj2;
                String str5 = (String) obj;
                File file = new File(m0Var3.getExternalFilesDir(null), "received");
                if (!file.exists()) {
                    file.mkdirs();
                }
                String absolutePath2 = new File(file, str5).getAbsolutePath();
                absolutePath2.getClass();
                Intent intent6 = new Intent(m0Var3, (Class<?>) InstallerActivity.class);
                intent6.putExtra("realPath", absolutePath2);
                intent6.putExtra("requireUserAction", false);
                intent6.putExtra("backgroundInstallation", false);
                intent6.addFlags(268435456);
                m0Var3.startActivity(intent6);
                m0Var3.G();
                break;
            case 21:
                h5.w wVar2 = (h5.w) obj;
                AppFilesActivity appFilesActivity = (AppFilesActivity) ((y5.b) obj2).f13807a.f6781b;
                float f13 = UptodownApp.E;
                if (k4.c.s() && wVar2.f8781a != null && !appFilesActivity.isFinishing()) {
                    r7.y.q(LifecycleOwnerKt.getLifecycleScope(appFilesActivity), null, null, new a3.o((Object) appFilesActivity, (Object) wVar2, (w6.c) (null == true ? 1 : 0), 16), 3);
                    break;
                }
                break;
            case 22:
                ((g5.c) obj2).z((h5.h) obj);
                break;
            case 23:
                ((y5.r) obj2).f13980a.a((h5.k) obj);
                break;
            case 24:
                d0.i iVar2 = ((y5.u) obj2).f14023b;
                String str6 = ((h5.e1) obj).f8512a;
                str6.getClass();
                FollowListActivity followListActivity = (FollowListActivity) iVar2.f6781b;
                float f14 = UptodownApp.E;
                if (k4.c.s()) {
                    new c5.x(followListActivity, LifecycleOwnerKt.getLifecycleScope(followListActivity)).a(str6, new y2.c(followListActivity, i12));
                    break;
                }
                break;
            case 25:
                h5.k kVar = (h5.k) obj;
                g5.j jVar2 = ((y5.a0) obj2).f13798a;
                if (jVar2 != null) {
                    jVar2.a(kVar);
                    break;
                }
                break;
            case 26:
                ((y5.b0) obj2).f13811a.A((h5.x0) obj);
                break;
            case 27:
                ((y5.c0) obj2).f13827a.A((h5.x0) obj);
                break;
            case 28:
                ((y5.e0) obj2).f13849a.A((h5.x0) obj);
                break;
            default:
                d0.i iVar3 = ((y5.f0) obj2).f13858a;
                iVar3.getClass();
                String str7 = ((h5.z) obj).f8802c;
                if (str7 != null) {
                    LanguageSettingsActivity languageSettingsActivity = (LanguageSettingsActivity) iVar3.f6781b;
                    int i27 = LanguageSettingsActivity.L;
                    v5.g gVarL = v5.g.f13148u.l(languageSettingsActivity);
                    gVarL.a();
                    ContentValues contentValues = new ContentValues();
                    contentValues.putNull("urlFicha");
                    SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
                    sQLiteDatabase.getClass();
                    sQLiteDatabase.update("apps", contentValues, null, null);
                    gVarL.b();
                    Context applicationContext = languageSettingsActivity.getApplicationContext();
                    applicationContext.getClass();
                    z1.t1.P(applicationContext, str7);
                    languageSettingsActivity.setResult(PointerIconCompat.TYPE_HELP);
                    languageSettingsActivity.finish();
                    break;
                }
                break;
        }
    }

    public /* synthetic */ f5(int i10, Object obj, Object obj2) {
        this.f10394a = i10;
        this.f10395b = obj;
        this.f10396c = obj2;
    }
}
