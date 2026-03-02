package com.uptodown.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.inputmethod.a;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import c1.l;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import d0.i;
import d5.e0;
import e5.n;
import e5.s;
import h5.b0;
import java.io.File;
import java.util.List;
import k4.c;
import kotlin.jvm.internal.y;
import l4.a5;
import l4.d5;
import l4.e5;
import l4.w;
import l4.w4;
import l4.x2;
import l4.x4;
import l4.y4;
import l4.z4;
import n4.q;
import o4.b;
import r7.i0;
import s6.m;
import x5.f;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class NotificationsRegistryActivity extends w {
    public static final /* synthetic */ int M = 0;
    public q K;
    public final m H = new m(new x2(this, 3));
    public final ViewModelLazy I = new ViewModelLazy(y.a(e5.class), new a5(this, 0), new z4(this), new a5(this, 1));
    public boolean J = true;
    public final i L = new i((Object) this, 29);

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final void n0(NotificationsRegistryActivity notificationsRegistryActivity, int i10, int i11) {
        NotificationsRegistryActivity notificationsRegistryActivity2;
        q qVar = notificationsRegistryActivity.K;
        if (qVar == null || qVar.f11460a.size() <= i10) {
            return;
        }
        q qVar2 = notificationsRegistryActivity.K;
        qVar2.getClass();
        Object obj = qVar2.f11460a.get(i10);
        obj.getClass();
        b0 b0Var = (b0) obj;
        String str = b0Var.e;
        if (str != null) {
            List listS0 = o7.m.s0(str, new String[]{";"});
            if (listS0.size() > i11) {
                String str2 = (String) listS0.get(i11);
                String str3 = b0Var.f;
                int i12 = 0;
                switch (str2.hashCode()) {
                    case -1569440520:
                        notificationsRegistryActivity2 = notificationsRegistryActivity;
                        if (str2.equals("positive_apps")) {
                            Intent intent = new Intent(notificationsRegistryActivity2, (Class<?>) SecurityActivity.class);
                            float f = UptodownApp.E;
                            notificationsRegistryActivity2.startActivity(intent, c.a(notificationsRegistryActivity2));
                            return;
                        }
                        String string = notificationsRegistryActivity2.getString(R.string.msg_no_action_available);
                        string.getClass();
                        notificationsRegistryActivity2.C(string);
                    case -1335458389:
                        notificationsRegistryActivity2 = notificationsRegistryActivity;
                        if (str2.equals("delete")) {
                            if (str3 == null) {
                                String string2 = notificationsRegistryActivity2.getString(R.string.msg_no_action_available);
                                string2.getClass();
                                notificationsRegistryActivity2.C(string2);
                                return;
                            } else {
                                File file = new File(str3);
                                String string3 = notificationsRegistryActivity2.getString(R.string.dialog_delete_download_msg, file.getName());
                                string3.getClass();
                                notificationsRegistryActivity2.K(string3, new w4(file, notificationsRegistryActivity2, i10));
                                return;
                            }
                        }
                        String string4 = notificationsRegistryActivity2.getString(R.string.msg_no_action_available);
                        string4.getClass();
                        notificationsRegistryActivity2.C(string4);
                    case -504325460:
                        notificationsRegistryActivity2 = notificationsRegistryActivity;
                        if (str2.equals("open_app")) {
                            if (str3 == null) {
                                String string5 = notificationsRegistryActivity2.getString(R.string.msg_no_action_available);
                                string5.getClass();
                                notificationsRegistryActivity2.C(string5);
                                return;
                            }
                            try {
                                Intent launchIntentForPackage = notificationsRegistryActivity2.getPackageManager().getLaunchIntentForPackage(str3);
                                if (launchIntentForPackage != null) {
                                    notificationsRegistryActivity2.startActivity(launchIntentForPackage);
                                    return;
                                }
                                String string6 = notificationsRegistryActivity2.getString(R.string.app_detail_not_found);
                                string6.getClass();
                                notificationsRegistryActivity2.C(string6);
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                String string7 = notificationsRegistryActivity2.getString(R.string.app_detail_not_found);
                                string7.getClass();
                                notificationsRegistryActivity2.C(string7);
                                return;
                            }
                        }
                        String string42 = notificationsRegistryActivity2.getString(R.string.msg_no_action_available);
                        string42.getClass();
                        notificationsRegistryActivity2.C(string42);
                    case -234430262:
                        notificationsRegistryActivity2 = notificationsRegistryActivity;
                        if (str2.equals("updates")) {
                            Intent intent2 = new Intent(notificationsRegistryActivity2, (Class<?>) Updates.class);
                            float f10 = UptodownApp.E;
                            notificationsRegistryActivity2.startActivity(intent2, c.a(notificationsRegistryActivity2));
                            return;
                        }
                        String string422 = notificationsRegistryActivity2.getString(R.string.msg_no_action_available);
                        string422.getClass();
                        notificationsRegistryActivity2.C(string422);
                    case 1085191854:
                        notificationsRegistryActivity2 = notificationsRegistryActivity;
                        if (str2.equals("update_uptodown")) {
                            if (str3 == null) {
                                String string8 = notificationsRegistryActivity2.getString(R.string.msg_no_action_available);
                                string8.getClass();
                                notificationsRegistryActivity2.C(string8);
                                return;
                            }
                            File file2 = new File(str3);
                            if (file2.exists()) {
                                float f11 = UptodownApp.E;
                                c.q(notificationsRegistryActivity2, file2, null);
                                return;
                            } else {
                                String string9 = notificationsRegistryActivity2.getString(R.string.installable_files_not_found);
                                string9.getClass();
                                notificationsRegistryActivity2.C(string9);
                                return;
                            }
                        }
                        String string4222 = notificationsRegistryActivity2.getString(R.string.msg_no_action_available);
                        string4222.getClass();
                        notificationsRegistryActivity2.C(string4222);
                    case 1117687366:
                        if (str2.equals("preregister")) {
                            if (str3 != null) {
                                new l(notificationsRegistryActivity, Long.parseLong(str3), new x4(notificationsRegistryActivity, i12), LifecycleOwnerKt.getLifecycleScope(notificationsRegistryActivity));
                                return;
                            }
                            String string10 = notificationsRegistryActivity.getString(R.string.msg_no_action_available);
                            string10.getClass();
                            notificationsRegistryActivity.C(string10);
                            return;
                        }
                        break;
                    case 1312704747:
                        if (str2.equals("downloads")) {
                            Intent intent3 = new Intent(notificationsRegistryActivity, (Class<?>) MyDownloads.class);
                            float f12 = UptodownApp.E;
                            notificationsRegistryActivity.startActivity(intent3, c.a(notificationsRegistryActivity));
                            return;
                        }
                        break;
                    case 1957569947:
                        if (str2.equals("install")) {
                            if (str3 == null) {
                                String string11 = notificationsRegistryActivity.getString(R.string.msg_no_action_available);
                                string11.getClass();
                                notificationsRegistryActivity.C(string11);
                                return;
                            }
                            File file3 = new File(str3);
                            if (file3.exists()) {
                                float f13 = UptodownApp.E;
                                c.q(notificationsRegistryActivity, file3, null);
                                return;
                            } else {
                                String string12 = notificationsRegistryActivity.getString(R.string.installable_files_not_found);
                                string12.getClass();
                                notificationsRegistryActivity.C(string12);
                                return;
                            }
                        }
                        break;
                }
                notificationsRegistryActivity2 = notificationsRegistryActivity;
                String string42222 = notificationsRegistryActivity2.getString(R.string.msg_no_action_available);
                string42222.getClass();
                notificationsRegistryActivity2.C(string42222);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:
    
        if (r7.y.z(r1, r8, r0) == r5) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object o0(com.uptodown.activities.NotificationsRegistryActivity r6, int r7, y6.c r8) {
        /*
            boolean r0 = r8 instanceof l4.b5
            if (r0 == 0) goto L13
            r0 = r8
            l4.b5 r0 = (l4.b5) r0
            int r1 = r0.f10249d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10249d = r1
            goto L18
        L13:
            l4.b5 r0 = new l4.b5
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f10247b
            int r1 = r0.f10249d
            r2 = 0
            r3 = 2
            r4 = 1
            x6.a r5 = x6.a.f13718a
            if (r1 == 0) goto L37
            if (r1 == r4) goto L31
            if (r1 != r3) goto L2b
            s6.a.e(r8)
            goto L62
        L2b:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r6)
            return r2
        L31:
            int r7 = r0.f10246a
            s6.a.e(r8)
            goto L4e
        L37:
            s6.a.e(r8)
            y7.e r8 = r7.i0.f12407a
            y7.d r8 = y7.d.f14116a
            l4.y4 r1 = new l4.y4
            r1.<init>(r6, r7, r2, r4)
            r0.f10246a = r7
            r0.f10249d = r4
            java.lang.Object r8 = r7.y.z(r1, r8, r0)
            if (r8 != r5) goto L4e
            goto L61
        L4e:
            y7.e r8 = r7.i0.f12407a
            s7.c r8 = w7.n.f13548a
            l4.y4 r1 = new l4.y4
            r1.<init>(r6, r7, r2, r3)
            r0.f10246a = r7
            r0.f10249d = r3
            java.lang.Object r6 = r7.y.z(r1, r8, r0)
            if (r6 != r5) goto L62
        L61:
            return r5
        L62:
            s6.w r6 = s6.w.f12711a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.NotificationsRegistryActivity.o0(com.uptodown.activities.NotificationsRegistryActivity, int, y6.c):java.lang.Object");
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = p0().f7014a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            p0().f7017d.setNavigationIcon(drawable);
            p0().f7017d.setNavigationContentDescription(getString(R.string.back));
        }
        p0().f7017d.setNavigationOnClickListener(new s(this, 14));
        p0().f7017d.inflateMenu(R.menu.menu_notifications_registry);
        p0().f7017d.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.vector_menu_dots_color_adaptable));
        p0().f7017d.setOnMenuItemClickListener(new a(this, 15));
        p0().f.setTypeface(b.f11719r);
        p0().e.setTypeface(b.f11720s);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        p0().f7016c.addItemDecoration(new f(dimension, dimension));
        p0().f7016c.setLayoutManager(linearLayoutManager);
        p0().f7016c.setItemAnimator(new DefaultItemAnimator());
        p0().f7015b.setOnClickListener(new n(15));
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new y4(this, null), 2);
    }

    @Override // l4.w, p4.m0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.J) {
            e5 e5VarQ0 = q0();
            e5VarQ0.getClass();
            r7.w viewModelScope = ViewModelKt.getViewModelScope(e5VarQ0);
            e eVar = i0.f12407a;
            r7.y.q(viewModelScope, d.f14116a, null, new d5(this, e5VarQ0, null, 1), 2);
        }
    }

    public final e0 p0() {
        return (e0) this.H.getValue();
    }

    public final e5 q0() {
        return (e5) this.I.getValue();
    }
}
