package com.uptodown.core.activities;

import a3.a;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.UriPermission;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.documentfile.provider.DocumentFile;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.uptodown.R;
import d5.j;
import e5.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.x;
import l4.ca;
import l4.f5;
import l4.n5;
import l4.x4;
import o7.m;
import p4.e;
import p4.g;
import p4.h;
import p4.k;
import p4.m0;
import p4.s;
import r4.b;
import r7.i0;
import r7.y;
import w2.r;
import w6.c;
import y7.d;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class FileExplorerActivity extends m0 {

    /* renamed from: q0, reason: collision with root package name */
    public static final /* synthetic */ int f6665q0 = 0;
    public HorizontalScrollView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public SearchView E;
    public RelativeLayout F;
    public RadioButton G;
    public RadioButton H;
    public RadioButton I;
    public AlertDialog J;
    public Toolbar K;
    public TextView L;
    public b M;
    public ArrayList N;
    public ArrayList O;
    public DocumentFile P;
    public ArrayList Q;
    public ArrayList R;
    public ArrayList S;
    public File T;
    public boolean U;
    public boolean V;
    public ArrayList W;
    public boolean X;
    public TabLayout Y;
    public TextView Z;

    /* renamed from: j0, reason: collision with root package name */
    public Uri f6666j0;

    /* renamed from: k0, reason: collision with root package name */
    public String f6667k0;
    public final x4 l0 = new x4(this, 15);

    /* renamed from: m0, reason: collision with root package name */
    public final n5 f6668m0 = new n5(this, 16);

    /* renamed from: n0, reason: collision with root package name */
    public final s f6669n0 = new s(this);

    /* renamed from: o0, reason: collision with root package name */
    public final l4.b f6670o0 = new l4.b(this, 8);

    /* renamed from: p0, reason: collision with root package name */
    public final ActivityResultLauncher f6671p0;

    /* renamed from: v, reason: collision with root package name */
    public TextView f6672v;

    /* renamed from: w, reason: collision with root package name */
    public RecyclerView f6673w;

    /* renamed from: x, reason: collision with root package name */
    public RelativeLayout f6674x;
    public LinearLayout y;

    /* renamed from: z, reason: collision with root package name */
    public LinearLayout f6675z;

    public FileExplorerActivity() {
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new h(this));
        activityResultLauncherRegisterForActivityResult.getClass();
        this.f6671p0 = activityResultLauncherRegisterForActivityResult;
    }

    public static final void J(FileExplorerActivity fileExplorerActivity) {
        AlertDialog alertDialog = fileExplorerActivity.J;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        View viewInflate = fileExplorerActivity.getLayoutInflater().inflate(R.layout.dialog_accept_cancel, (ViewGroup) null, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_dialog_msg);
        textView.setTypeface(o4.b.f11720s);
        textView.setText(textView.getContext().getString(R.string.dialog_close_file_manager));
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_accept_option);
        textView2.setText(fileExplorerActivity.getString(R.string.ok));
        textView2.setTypeface(o4.b.f11719r);
        textView2.setOnClickListener(new e(fileExplorerActivity, 8));
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_cancel_option);
        textView3.setText(fileExplorerActivity.getString(R.string.option_button_cancel));
        textView3.setTypeface(o4.b.f11719r);
        textView3.setOnClickListener(new e(fileExplorerActivity, 9));
        AlertDialog.Builder builder = new AlertDialog.Builder(fileExplorerActivity);
        builder.setView(viewInflate);
        AlertDialog alertDialogCreate = builder.create();
        fileExplorerActivity.J = alertDialogCreate;
        alertDialogCreate.getClass();
        Window window = alertDialogCreate.getWindow();
        if (window != null) {
            a.A(window, 0);
        }
        AlertDialog alertDialog2 = fileExplorerActivity.J;
        alertDialog2.getClass();
        alertDialog2.show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
    
        if (r7.y.z(r1, r7, r0) == r5) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object K(com.uptodown.core.activities.FileExplorerActivity r6, y6.c r7) {
        /*
            boolean r0 = r7 instanceof p4.n
            if (r0 == 0) goto L13
            r0 = r7
            p4.n r0 = (p4.n) r0
            int r1 = r0.f12002d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f12002d = r1
            goto L18
        L13:
            p4.n r0 = new p4.n
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f12000b
            int r1 = r0.f12002d
            r2 = 2
            r3 = 1
            r4 = 0
            x6.a r5 = x6.a.f13718a
            if (r1 == 0) goto L37
            if (r1 == r3) goto L31
            if (r1 != r2) goto L2b
            s6.a.e(r7)
            goto L63
        L2b:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r6)
            return r4
        L31:
            com.uptodown.core.activities.FileExplorerActivity r6 = r0.f11999a
            s6.a.e(r7)
            goto L4e
        L37:
            s6.a.e(r7)
            y7.e r7 = r7.i0.f12407a
            y7.d r7 = y7.d.f14116a
            p4.l r1 = new p4.l
            r1.<init>(r6, r4, r2)
            r0.f11999a = r6
            r0.f12002d = r3
            java.lang.Object r7 = r7.y.z(r1, r7, r0)
            if (r7 != r5) goto L4e
            goto L62
        L4e:
            y7.e r7 = r7.i0.f12407a
            s7.c r7 = w7.n.f13548a
            p4.l r1 = new p4.l
            r3 = 3
            r1.<init>(r6, r4, r3)
            r0.f11999a = r4
            r0.f12002d = r2
            java.lang.Object r6 = r7.y.z(r1, r7, r0)
            if (r6 != r5) goto L63
        L62:
            return r5
        L63:
            s6.w r6 = s6.w.f12711a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.K(com.uptodown.core.activities.FileExplorerActivity, y6.c):java.lang.Object");
    }

    public static final void L(FileExplorerActivity fileExplorerActivity, String str, int i10, int i11, long j10) {
        AlertDialog alertDialog = fileExplorerActivity.f11942a;
        if (alertDialog != null) {
            TextView textView = (TextView) alertDialog.findViewById(R.id.tv_title_dialog_copying);
            if (textView != null) {
                textView.setText(fileExplorerActivity.getString(R.string.copying, fileExplorerActivity.getString(R.string.size_of_total_size, String.valueOf(i10), String.valueOf(i11))));
            }
            AlertDialog alertDialog2 = fileExplorerActivity.f11942a;
            alertDialog2.getClass();
            TextView textView2 = (TextView) alertDialog2.findViewById(R.id.tv_files_dialog_copying);
            if (textView2 != null) {
                textView2.setTypeface(o4.b.f11720s);
                textView2.setText(str);
                return;
            }
            return;
        }
        View viewInflate = fileExplorerActivity.getLayoutInflater().inflate(R.layout.dialog_copy_files, (ViewGroup) null, false);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_title_dialog_copying);
        textView3.setTypeface(o4.b.f11719r);
        textView3.setText(fileExplorerActivity.getString(R.string.copying, fileExplorerActivity.getString(R.string.size_of_total_size, String.valueOf(i10), String.valueOf(i11))));
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_size_dialog_copying);
        textView4.setTypeface(o4.b.f11720s);
        textView4.setText(fileExplorerActivity.getString(R.string.size_of_total_size, fileExplorerActivity.getString(R.string.mb_placeholder, fileExplorerActivity.getString(R.string.zero)), l1.b.L(j10)));
        ((ProgressBar) viewInflate.findViewById(R.id.pb_dialog_copying)).setProgress(0);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_files_dialog_copying);
        textView5.setTypeface(o4.b.f11720s);
        textView5.setText(str);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.tv_percentage_dialog_copying);
        textView6.setTypeface(o4.b.f11720s);
        textView6.setText(fileExplorerActivity.getString(R.string.zero) + fileExplorerActivity.getString(R.string.percentage));
        AlertDialog.Builder builder = new AlertDialog.Builder(fileExplorerActivity);
        builder.setView(viewInflate);
        builder.setCancelable(false);
        if (fileExplorerActivity.isFinishing()) {
            return;
        }
        AlertDialog alertDialogCreate = builder.create();
        fileExplorerActivity.f11942a = alertDialogCreate;
        alertDialogCreate.getClass();
        Window window = alertDialogCreate.getWindow();
        if (window != null) {
            a.A(window, 0);
        }
        AlertDialog alertDialog3 = fileExplorerActivity.f11942a;
        alertDialog3.getClass();
        alertDialog3.show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
    
        if (r7.y.z(r1, r8, r0) == r5) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object M(com.uptodown.core.activities.FileExplorerActivity r7, y6.c r8) {
        /*
            boolean r0 = r8 instanceof p4.p
            if (r0 == 0) goto L13
            r0 = r8
            p4.p r0 = (p4.p) r0
            int r1 = r0.f12008d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f12008d = r1
            goto L18
        L13:
            p4.p r0 = new p4.p
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f12006b
            int r1 = r0.f12008d
            r2 = 2
            r3 = 1
            r4 = 0
            x6.a r5 = x6.a.f13718a
            if (r1 == 0) goto L37
            if (r1 == r3) goto L31
            if (r1 != r2) goto L2b
            s6.a.e(r8)
            goto L64
        L2b:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r7)
            return r4
        L31:
            com.uptodown.core.activities.FileExplorerActivity r7 = r0.f12005a
            s6.a.e(r8)
            goto L4f
        L37:
            s6.a.e(r8)
            y7.e r8 = r7.i0.f12407a
            y7.d r8 = y7.d.f14116a
            p4.l r1 = new p4.l
            r6 = 5
            r1.<init>(r7, r4, r6)
            r0.f12005a = r7
            r0.f12008d = r3
            java.lang.Object r8 = r7.y.z(r1, r8, r0)
            if (r8 != r5) goto L4f
            goto L63
        L4f:
            y7.e r8 = r7.i0.f12407a
            s7.c r8 = w7.n.f13548a
            p4.l r1 = new p4.l
            r3 = 6
            r1.<init>(r7, r4, r3)
            r0.f12005a = r4
            r0.f12008d = r2
            java.lang.Object r7 = r7.y.z(r1, r8, r0)
            if (r7 != r5) goto L64
        L63:
            return r5
        L64:
            s6.w r7 = s6.w.f12711a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.M(com.uptodown.core.activities.FileExplorerActivity, y6.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0093, code lost:
    
        if (r7.y.z(r3, r10, r0) != r6) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object N(com.uptodown.core.activities.FileExplorerActivity r9, y6.c r10) {
        /*
            boolean r0 = r10 instanceof p4.q
            if (r0 == 0) goto L13
            r0 = r10
            p4.q r0 = (p4.q) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            p4.q r0 = new p4.q
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f12011c
            int r1 = r0.e
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            x6.a r6 = x6.a.f13718a
            if (r1 == 0) goto L46
            if (r1 == r4) goto L3c
            if (r1 == r3) goto L34
            if (r1 != r2) goto L2e
            s6.a.e(r10)
            goto L96
        L2e:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r9)
            return r5
        L34:
            kotlin.jvm.internal.v r9 = r0.f12010b
            com.uptodown.core.activities.FileExplorerActivity r1 = r0.f12009a
            s6.a.e(r10)
            goto L7e
        L3c:
            kotlin.jvm.internal.v r9 = r0.f12010b
            com.uptodown.core.activities.FileExplorerActivity r1 = r0.f12009a
            s6.a.e(r10)
            r10 = r9
            r9 = r1
            goto L66
        L46:
            s6.a.e(r10)
            kotlin.jvm.internal.v r10 = new kotlin.jvm.internal.v
            r10.<init>()
            y7.e r1 = r7.i0.f12407a
            s7.c r1 = w7.n.f13548a
            p4.l r7 = new p4.l
            r8 = 11
            r7.<init>(r9, r5, r8)
            r0.f12009a = r9
            r0.f12010b = r10
            r0.e = r4
            java.lang.Object r1 = r7.y.z(r7, r1, r0)
            if (r1 != r6) goto L66
            goto L95
        L66:
            y7.e r1 = r7.i0.f12407a
            y7.d r1 = y7.d.f14116a
            c5.h0 r4 = new c5.h0
            r4.<init>(r9, r10, r5)
            r0.f12009a = r9
            r0.f12010b = r10
            r0.e = r3
            java.lang.Object r1 = r7.y.z(r4, r1, r0)
            if (r1 != r6) goto L7c
            goto L95
        L7c:
            r1 = r9
            r9 = r10
        L7e:
            y7.e r10 = r7.i0.f12407a
            s7.c r10 = w7.n.f13548a
            l4.u4 r3 = new l4.u4
            r4 = 19
            r3.<init>(r1, r9, r5, r4)
            r0.f12009a = r5
            r0.f12010b = r5
            r0.e = r2
            java.lang.Object r9 = r7.y.z(r3, r10, r0)
            if (r9 != r6) goto L96
        L95:
            return r6
        L96:
            s6.w r9 = s6.w.f12711a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.N(com.uptodown.core.activities.FileExplorerActivity, y6.c):java.lang.Object");
    }

    public static final void O(FileExplorerActivity fileExplorerActivity, Object obj) {
        String strSubstring;
        AlertDialog alertDialog;
        if (fileExplorerActivity.isFinishing()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(fileExplorerActivity);
        LayoutInflater layoutInflater = fileExplorerActivity.getLayoutInflater();
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.dialog_decompress_file, (ViewGroup) null, false);
        ((TextView) viewInflate.findViewById(R.id.tv_dialog_title_decompress)).setTypeface(o4.b.f11719r);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_dialog_file_name_decompress);
        textView.setTypeface(o4.b.f11720s);
        RadioButton radioButton = (RadioButton) viewInflate.findViewById(R.id.rb_dialog_decompress_current_path);
        radioButton.setTypeface(o4.b.f11720s);
        RadioButton radioButton2 = (RadioButton) viewInflate.findViewById(R.id.rb_dialog_decompress_select_path);
        radioButton2.setTypeface(o4.b.f11720s);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_dialog_decompress_selected_path);
        fileExplorerActivity.C = textView2;
        if (textView2 == null) {
            l.i("tvSelectedPath");
            throw null;
        }
        textView2.setTypeface(o4.b.f11720s);
        x xVar = new x();
        if (obj instanceof File) {
            xVar.f10138a = ((File) obj).getParent();
        } else if (obj instanceof DocumentFile) {
            DocumentFile documentFile = fileExplorerActivity.P;
            documentFile.getClass();
            String lastPathSegment = documentFile.getUri().getLastPathSegment();
            if (lastPathSegment != null) {
                DocumentFile documentFile2 = fileExplorerActivity.P;
                documentFile2.getClass();
                String lastPathSegment2 = documentFile2.getUri().getLastPathSegment();
                lastPathSegment2.getClass();
                strSubstring = lastPathSegment.substring(m.m0(":", lastPathSegment2, 6) + 1);
            } else {
                strSubstring = null;
            }
            xVar.f10138a = fileExplorerActivity.getString(R.string.sd_card) + '/' + strSubstring;
        }
        TextView textView3 = fileExplorerActivity.C;
        if (textView3 == null) {
            l.i("tvSelectedPath");
            throw null;
        }
        textView3.setText((CharSequence) xVar.f10138a);
        fileExplorerActivity.f6667k0 = (String) xVar.f10138a;
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_accept_option_compress);
        textView4.setTypeface(o4.b.f11719r);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_cancel_option_decompress);
        textView5.setTypeface(o4.b.f11719r);
        ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(R.id.pb_dialog_decompress);
        TextView textView6 = fileExplorerActivity.C;
        if (textView6 == null) {
            l.i("tvSelectedPath");
            throw null;
        }
        textView6.setOnClickListener(new e(fileExplorerActivity, 13));
        radioButton.setOnCheckedChangeListener(new ca(fileExplorerActivity, xVar));
        radioButton2.setOnCheckedChangeListener(new g(fileExplorerActivity, 3));
        x xVar2 = new x();
        textView4.setOnClickListener(new m4.h(obj, fileExplorerActivity, xVar2, new j(textView, fileExplorerActivity, viewInflate, progressBar, textView4, textView5), 1));
        textView5.setOnClickListener(new p4.j(xVar2, fileExplorerActivity, 1));
        builder.setView(viewInflate);
        fileExplorerActivity.J = builder.create();
        if (fileExplorerActivity.isFinishing() || (alertDialog = fileExplorerActivity.J) == null) {
            return;
        }
        Window window = alertDialog.getWindow();
        if (window != null) {
            a.A(window, 0);
        }
        AlertDialog alertDialog2 = fileExplorerActivity.J;
        alertDialog2.getClass();
        alertDialog2.show();
    }

    public static final void P(FileExplorerActivity fileExplorerActivity, Object obj, String str) {
        AlertDialog alertDialog = fileExplorerActivity.J;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        View viewInflate = fileExplorerActivity.getLayoutInflater().inflate(R.layout.dialog_accept_cancel, (ViewGroup) null, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_dialog_msg);
        textView.setTypeface(o4.b.f11720s);
        textView.setText(textView.getContext().getString(R.string.install_dialog_confirmation_msg, str));
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_accept_option);
        textView2.setText(fileExplorerActivity.getString(R.string.option_button_install));
        textView2.setTypeface(o4.b.f11719r);
        textView2.setOnClickListener(new f5(17, obj, fileExplorerActivity));
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_cancel_option);
        textView3.setText(fileExplorerActivity.getString(R.string.option_button_cancel));
        textView3.setTypeface(o4.b.f11719r);
        textView3.setOnClickListener(new e(fileExplorerActivity, 14));
        AlertDialog.Builder builder = new AlertDialog.Builder(fileExplorerActivity);
        builder.setView(viewInflate);
        AlertDialog alertDialogCreate = builder.create();
        fileExplorerActivity.J = alertDialogCreate;
        alertDialogCreate.getClass();
        Window window = alertDialogCreate.getWindow();
        if (window != null) {
            a.A(window, 0);
        }
        AlertDialog alertDialog2 = fileExplorerActivity.J;
        alertDialog2.getClass();
        alertDialog2.show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0063, code lost:
    
        if (r7.y.z(r1, r8, r0) == r5) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object Q(com.uptodown.core.activities.FileExplorerActivity r7, y6.c r8) {
        /*
            boolean r0 = r8 instanceof p4.t
            if (r0 == 0) goto L13
            r0 = r8
            p4.t r0 = (p4.t) r0
            int r1 = r0.f12018d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f12018d = r1
            goto L18
        L13:
            p4.t r0 = new p4.t
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f12016b
            int r1 = r0.f12018d
            r2 = 2
            r3 = 1
            r4 = 0
            x6.a r5 = x6.a.f13718a
            if (r1 == 0) goto L37
            if (r1 == r3) goto L31
            if (r1 != r2) goto L2b
            s6.a.e(r8)
            goto L66
        L2b:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r7)
            return r4
        L31:
            com.uptodown.core.activities.FileExplorerActivity r7 = r0.f12015a
            s6.a.e(r8)
            goto L50
        L37:
            s6.a.e(r8)
            y7.e r8 = r7.i0.f12407a
            y7.d r8 = y7.d.f14116a
            a3.o r1 = new a3.o
            r6 = 29
            r1.<init>(r7, r4, r6)
            r0.f12015a = r7
            r0.f12018d = r3
            java.lang.Object r8 = r7.y.z(r1, r8, r0)
            if (r8 != r5) goto L50
            goto L65
        L50:
            y7.e r8 = r7.i0.f12407a
            s7.c r8 = w7.n.f13548a
            p4.l r1 = new p4.l
            r3 = 15
            r1.<init>(r7, r4, r3)
            r0.f12015a = r4
            r0.f12018d = r2
            java.lang.Object r7 = r7.y.z(r1, r8, r0)
            if (r7 != r5) goto L66
        L65:
            return r5
        L66:
            s6.w r7 = s6.w.f12711a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.Q(com.uptodown.core.activities.FileExplorerActivity, y6.c):java.lang.Object");
    }

    public static final void R(FileExplorerActivity fileExplorerActivity) {
        LinearLayout linearLayout = fileExplorerActivity.f6675z;
        if (linearLayout == null) {
            l.i("llBreadcrumb");
            throw null;
        }
        if (linearLayout.getChildCount() > 1) {
            LinearLayout linearLayout2 = fileExplorerActivity.f6675z;
            if (linearLayout2 != null) {
                linearLayout2.removeViewAt(linearLayout2.getChildCount() - 1);
            } else {
                l.i("llBreadcrumb");
                throw null;
            }
        }
    }

    public static final void S(FileExplorerActivity fileExplorerActivity) {
        int i10;
        Menu menu;
        MenuItem menuItemFindItem;
        Menu menu2;
        MenuItem menuItemFindItem2;
        Menu menu3;
        MenuItem menuItemFindItem3;
        Menu menu4;
        MenuItem menuItemFindItem4;
        Toolbar toolbar;
        Menu menu5;
        MenuItem menuItemFindItem5;
        Menu menu6;
        MenuItem menuItemFindItem6;
        Menu menu7;
        MenuItem menuItemFindItem7;
        Menu menu8;
        MenuItem menuItemFindItem8;
        Menu menu9;
        MenuItem menuItemFindItem9;
        boolean[] zArr;
        Menu menu10;
        MenuItem menuItemFindItem10;
        Menu menu11;
        MenuItem menuItemFindItem11;
        Menu menu12;
        MenuItem menuItemFindItem12;
        Menu menu13;
        MenuItem menuItemFindItem13;
        Menu menu14;
        MenuItem menuItemFindItem14;
        Toolbar toolbar2 = fileExplorerActivity.K;
        if (toolbar2 != null && (menu14 = toolbar2.getMenu()) != null && (menuItemFindItem14 = menu14.findItem(R.id.action_delete)) != null) {
            menuItemFindItem14.setVisible(true);
        }
        Toolbar toolbar3 = fileExplorerActivity.K;
        if (toolbar3 != null && (menu13 = toolbar3.getMenu()) != null && (menuItemFindItem13 = menu13.findItem(R.id.action_create)) != null) {
            menuItemFindItem13.setVisible(true);
        }
        Toolbar toolbar4 = fileExplorerActivity.K;
        if (toolbar4 != null && (menu12 = toolbar4.getMenu()) != null && (menuItemFindItem12 = menu12.findItem(R.id.action_copy)) != null) {
            menuItemFindItem12.setVisible(true);
        }
        Toolbar toolbar5 = fileExplorerActivity.K;
        if (toolbar5 != null && (menu11 = toolbar5.getMenu()) != null && (menuItemFindItem11 = menu11.findItem(R.id.action_compress)) != null) {
            menuItemFindItem11.setVisible(true);
        }
        Toolbar toolbar6 = fileExplorerActivity.K;
        if (toolbar6 != null && (menu10 = toolbar6.getMenu()) != null && (menuItemFindItem10 = menu10.findItem(R.id.action_cut)) != null) {
            menuItemFindItem10.setVisible(true);
        }
        b bVar = fileExplorerActivity.M;
        if (bVar == null || (zArr = bVar.f12377d) == null) {
            i10 = 0;
        } else {
            i10 = 0;
            for (boolean z9 : zArr) {
                if (z9) {
                    i10++;
                }
            }
        }
        Toolbar toolbar7 = fileExplorerActivity.K;
        if (i10 > 0) {
            if (toolbar7 != null && (menu9 = toolbar7.getMenu()) != null && (menuItemFindItem9 = menu9.findItem(R.id.action_delete)) != null) {
                menuItemFindItem9.setEnabled(true);
            }
            Toolbar toolbar8 = fileExplorerActivity.K;
            if (toolbar8 != null && (menu8 = toolbar8.getMenu()) != null && (menuItemFindItem8 = menu8.findItem(R.id.action_copy)) != null) {
                menuItemFindItem8.setEnabled(true);
            }
            Toolbar toolbar9 = fileExplorerActivity.K;
            if (toolbar9 != null && (menu7 = toolbar9.getMenu()) != null && (menuItemFindItem7 = menu7.findItem(R.id.action_cut)) != null) {
                menuItemFindItem7.setEnabled(true);
            }
            Toolbar toolbar10 = fileExplorerActivity.K;
            if (toolbar10 != null && (menu6 = toolbar10.getMenu()) != null && (menuItemFindItem6 = menu6.findItem(R.id.action_compress)) != null) {
                menuItemFindItem6.setEnabled(true);
            }
        } else {
            if (toolbar7 != null && (menu4 = toolbar7.getMenu()) != null && (menuItemFindItem4 = menu4.findItem(R.id.action_delete)) != null) {
                menuItemFindItem4.setEnabled(false);
            }
            Toolbar toolbar11 = fileExplorerActivity.K;
            if (toolbar11 != null && (menu3 = toolbar11.getMenu()) != null && (menuItemFindItem3 = menu3.findItem(R.id.action_copy)) != null) {
                menuItemFindItem3.setEnabled(false);
            }
            Toolbar toolbar12 = fileExplorerActivity.K;
            if (toolbar12 != null && (menu2 = toolbar12.getMenu()) != null && (menuItemFindItem2 = menu2.findItem(R.id.action_cut)) != null) {
                menuItemFindItem2.setEnabled(false);
            }
            Toolbar toolbar13 = fileExplorerActivity.K;
            if (toolbar13 != null && (menu = toolbar13.getMenu()) != null && (menuItemFindItem = menu.findItem(R.id.action_compress)) != null) {
                menuItemFindItem.setEnabled(false);
            }
        }
        TextView textView = fileExplorerActivity.L;
        if (textView != null) {
            textView.setText(fileExplorerActivity.getString(R.string.core_x_items_selected, String.valueOf(i10)));
        }
        ArrayList arrayList = fileExplorerActivity.W;
        if (arrayList == null || arrayList.isEmpty() || (toolbar = fileExplorerActivity.K) == null || (menu5 = toolbar.getMenu()) == null || (menuItemFindItem5 = menu5.findItem(R.id.action_paste)) == null) {
            return;
        }
        menuItemFindItem5.setVisible(true);
    }

    public static final void T(FileExplorerActivity fileExplorerActivity) {
        b bVar = fileExplorerActivity.M;
        bVar.getClass();
        bVar.c(false);
        fileExplorerActivity.W();
        fileExplorerActivity.X(null);
    }

    @Override // p4.m0
    public final void H() {
        o4.b.t.getClass();
    }

    public final void U(String str, String str2) {
        if (isFinishing()) {
            return;
        }
        RelativeLayout relativeLayout = this.f6674x;
        c cVar = null;
        if (relativeLayout == null) {
            l.i("rlLoading");
            throw null;
        }
        relativeLayout.setVisibility(0);
        y7.e eVar = i0.f12407a;
        y.q(y.a(d.f14116a), null, null, new k(this, str, str2, cVar, 1), 3);
    }

    public final void V(SearchView searchView) {
        searchView.setOnQueryTextListener(null);
        searchView.setQuery("", false);
        searchView.setOnQueryTextListener(this.f6669n0);
        Object systemService = getSystemService("input_method");
        systemService.getClass();
        ((InputMethodManager) systemService).hideSoftInputFromWindow(searchView.getWindowToken(), 0);
    }

    public final void W() {
        Menu menu;
        MenuItem menuItemFindItem;
        Menu menu2;
        MenuItem menuItemFindItem2;
        Menu menu3;
        MenuItem menuItemFindItem3;
        Menu menu4;
        MenuItem menuItemFindItem4;
        Menu menu5;
        MenuItem menuItemFindItem5;
        Menu menu6;
        MenuItem menuItemFindItem6;
        TextView textView = this.L;
        if (textView != null) {
            textView.setText(getString(R.string.action_name_file_explorer));
        }
        Toolbar toolbar = this.K;
        if (toolbar != null && (menu6 = toolbar.getMenu()) != null && (menuItemFindItem6 = menu6.findItem(R.id.action_create)) != null) {
            menuItemFindItem6.setVisible(true);
        }
        Toolbar toolbar2 = this.K;
        if (toolbar2 != null && (menu5 = toolbar2.getMenu()) != null && (menuItemFindItem5 = menu5.findItem(R.id.action_delete)) != null) {
            menuItemFindItem5.setVisible(false);
        }
        Toolbar toolbar3 = this.K;
        if (toolbar3 != null && (menu4 = toolbar3.getMenu()) != null && (menuItemFindItem4 = menu4.findItem(R.id.action_copy)) != null) {
            menuItemFindItem4.setVisible(false);
        }
        Toolbar toolbar4 = this.K;
        if (toolbar4 != null && (menu3 = toolbar4.getMenu()) != null && (menuItemFindItem3 = menu3.findItem(R.id.action_compress)) != null) {
            menuItemFindItem3.setVisible(false);
        }
        Toolbar toolbar5 = this.K;
        if (toolbar5 != null && (menu2 = toolbar5.getMenu()) != null && (menuItemFindItem2 = menu2.findItem(R.id.action_cut)) != null) {
            menuItemFindItem2.setVisible(false);
        }
        Toolbar toolbar6 = this.K;
        if (toolbar6 == null || (menu = toolbar6.getMenu()) == null || (menuItemFindItem = menu.findItem(R.id.action_paste)) == null) {
            return;
        }
        menuItemFindItem.setVisible(false);
    }

    public final void X(String str) {
        File externalStorageDirectory;
        RelativeLayout relativeLayout = this.f6674x;
        if (relativeLayout == null) {
            l.i("rlLoading");
            throw null;
        }
        relativeLayout.setVisibility(0);
        if (this.P == null && this.T == null && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.T = externalStorageDirectory;
            this.P = null;
        }
        new r(this.P, this.T, this, new i0.k(19, this, str));
    }

    public final void Y(boolean z9) {
        SearchView searchView;
        if (z9 && (searchView = this.E) != null) {
            V(searchView);
        }
        X(null);
    }

    public final void Z() {
        y7.e eVar = i0.f12407a;
        y.q(y.a(d.f14116a), null, null, new p4.m(this, (c) null, 4), 3);
    }

    public final void a0() {
        LinearLayout linearLayout = this.f6675z;
        if (linearLayout == null) {
            l.i("llBreadcrumb");
            throw null;
        }
        linearLayout.removeAllViews();
        LayoutInflater layoutInflater = getLayoutInflater();
        LinearLayout linearLayout2 = this.f6675z;
        if (linearLayout2 == null) {
            l.i("llBreadcrumb");
            throw null;
        }
        View viewInflate = layoutInflater.inflate(R.layout.breadcrumb_main, (ViewGroup) linearLayout2, false);
        viewInflate.getClass();
        LinearLayout linearLayout3 = (LinearLayout) viewInflate;
        TextView textView = (TextView) linearLayout3.findViewById(R.id.tv_main_path);
        if (this.V) {
            textView.setText(getString(R.string.sd_card));
        } else {
            textView.setText(getString(R.string.internal_storage));
        }
        textView.setTypeface(o4.b.f11720s);
        LinearLayout linearLayout4 = this.f6675z;
        if (linearLayout4 != null) {
            linearLayout4.addView(linearLayout3);
        } else {
            l.i("llBreadcrumb");
            throw null;
        }
    }

    public final void b0() {
        boolean z9 = this.U;
        RadioButton radioButton = this.G;
        if (z9) {
            radioButton.getClass();
            radioButton.setBackground(ContextCompat.getDrawable(this, R.drawable.core_vector_sort_az_desc_on));
            RadioButton radioButton2 = this.H;
            radioButton2.getClass();
            radioButton2.setBackground(ContextCompat.getDrawable(this, R.drawable.core_vector_sort_size_desc_off));
            RadioButton radioButton3 = this.I;
            radioButton3.getClass();
            radioButton3.setBackground(ContextCompat.getDrawable(this, R.drawable.core_vector_sort_date_desc_off));
            return;
        }
        radioButton.getClass();
        radioButton.setBackground(ContextCompat.getDrawable(this, R.drawable.core_vector_sort_az_asc_on));
        RadioButton radioButton4 = this.H;
        radioButton4.getClass();
        radioButton4.setBackground(ContextCompat.getDrawable(this, R.drawable.core_vector_sort_size_asc_off));
        RadioButton radioButton5 = this.I;
        radioButton5.getClass();
        radioButton5.setBackground(ContextCompat.getDrawable(this, R.drawable.core_vector_sort_date_asc_off));
    }

    public final void c0(boolean z9) {
        TextView textView = this.B;
        if (z9) {
            if (textView == null) {
                l.i("tvEmptyDirectory");
                throw null;
            }
            textView.setText(getString(R.string.empty_directory));
        } else {
            if (textView == null) {
                l.i("tvEmptyDirectory");
                throw null;
            }
            textView.setText(getString(R.string.no_permissions_directory));
        }
        TextView textView2 = this.B;
        if (textView2 != null) {
            textView2.setVisibility(0);
        } else {
            l.i("tvEmptyDirectory");
            throw null;
        }
    }

    public final void d0(Uri uri) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(uri, getContentResolver().getType(uri));
        intent.addFlags(1);
        startActivity(Intent.createChooser(intent, null));
    }

    @Override // p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        AlertDialog alertDialog;
        SharedPreferences sharedPreferences;
        String string;
        Uri uri;
        boolean zMatches;
        super.onCreate(bundle);
        setContentView(R.layout.file_explorer);
        ViewCompat.setOnApplyWindowInsetsListener((RelativeLayout) findViewById(R.id.rl_file_explorer), new com.google.gson.internal.a(26));
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("subdir") && (string = extras.getString("subdir")) != null) {
                boolean z9 = extras.getBoolean("subdir_sd");
                this.V = z9;
                if (z9) {
                    List<UriPermission> persistedUriPermissions = getContentResolver().getPersistedUriPermissions();
                    persistedUriPermissions.getClass();
                    Iterator<UriPermission> it = persistedUriPermissions.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            uri = null;
                            break;
                        }
                        UriPermission next = it.next();
                        Uri uri2 = next.getUri();
                        uri2.getClass();
                        String path = uri2.getPath();
                        if (path != null) {
                            Pattern patternCompile = Pattern.compile(".*\\b[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]-[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]:.*");
                            patternCompile.getClass();
                            zMatches = patternCompile.matcher(path).matches();
                        } else {
                            zMatches = false;
                        }
                        if (zMatches) {
                            uri = next.getUri();
                            break;
                        }
                    }
                    if (uri != null) {
                        DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(this, uri);
                        if (documentFileFromTreeUri != null && string.length() > 0) {
                            Iterator it2 = m.s0(string, new String[]{"/"}).iterator();
                            while (it2.hasNext() && (documentFileFromTreeUri = documentFileFromTreeUri.findFile((String) it2.next())) != null) {
                            }
                        }
                        this.P = documentFileFromTreeUri;
                        this.T = null;
                    }
                } else {
                    this.T = new File(string);
                    this.P = null;
                }
            }
            if (extras.containsKey("select_path") && extras.getInt("select_path") == 1) {
                View viewFindViewById = findViewById(R.id.ll_options);
                viewFindViewById.getClass();
                View viewFindViewById2 = findViewById(R.id.view_options_shadow);
                viewFindViewById2.getClass();
                ((LinearLayout) viewFindViewById).setVisibility(0);
                viewFindViewById2.setVisibility(0);
                TextView textView = (TextView) findViewById(R.id.tv_select_current_dir);
                this.D = textView;
                if (textView != null) {
                    textView.setTypeface(o4.b.f11719r);
                }
                TextView textView2 = this.D;
                if (textView2 != null) {
                    textView2.setOnClickListener(new e(this, 15));
                }
                TextView textView3 = (TextView) findViewById(R.id.tv_cancel);
                textView3.setTypeface(o4.b.f11719r);
                textView3.setOnClickListener(new e(this, 16));
            }
        }
        this.K = (Toolbar) findViewById(R.id.toolbar);
        TextView textView4 = (TextView) findViewById(R.id.tv_toolbar_title);
        this.L = textView4;
        if (textView4 != null) {
            textView4.setText(getString(R.string.action_name_file_explorer));
        }
        TextView textView5 = this.L;
        if (textView5 != null) {
            textView5.setTypeface(o4.b.f11719r);
        }
        Toolbar toolbar = this.K;
        if (toolbar != null) {
            toolbar.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.core_vector_menu_dots_blue));
        }
        Toolbar toolbar2 = this.K;
        if (toolbar2 != null) {
            toolbar2.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.core_vector_back));
        }
        Toolbar toolbar3 = this.K;
        if (toolbar3 != null) {
            toolbar3.setNavigationOnClickListener(new e(this, 17));
        }
        Toolbar toolbar4 = this.K;
        if (toolbar4 != null) {
            toolbar4.inflateMenu(R.menu.core_menu_file_explorer);
        }
        Toolbar toolbar5 = this.K;
        if (toolbar5 != null) {
            toolbar5.setOnMenuItemClickListener(new h(this));
        }
        W();
        this.f6675z = (LinearLayout) findViewById(R.id.layout_breadcrumb_main);
        this.A = (HorizontalScrollView) findViewById(R.id.sv_breadcumb);
        LinearLayout linearLayout = this.f6675z;
        if (linearLayout == null) {
            l.i("llBreadcrumb");
            throw null;
        }
        this.f6672v = (TextView) linearLayout.findViewById(R.id.tv_main_path);
        ImageView imageView = (ImageView) findViewById(R.id.iv_home_path);
        if (imageView == null) {
            l.i("ivBreadCrumb");
            throw null;
        }
        imageView.setOnClickListener(new e(this, 18));
        TextView textView6 = this.f6672v;
        if (textView6 == null) {
            l.i("tvBreadCrumb");
            throw null;
        }
        textView6.setTypeface(o4.b.f11720s);
        TextView textView7 = (TextView) findViewById(R.id.tv_empty_dir);
        this.B = textView7;
        if (textView7 == null) {
            l.i("tvEmptyDirectory");
            throw null;
        }
        textView7.setTypeface(o4.b.f11720s);
        SearchView searchView = (SearchView) findViewById(R.id.search_view);
        this.E = searchView;
        if (searchView != null) {
            searchView.setOnQueryTextListener(this.f6669n0);
        }
        SearchView searchView2 = this.E;
        if (searchView2 != null) {
            searchView2.setOnClickListener(new e(this, 1));
        }
        SearchView searchView3 = this.E;
        searchView3.getClass();
        ((ImageView) searchView3.findViewById(androidx.appcompat.R.id.search_close_btn)).setBackgroundResource(R.drawable.core_shape_transparent);
        SearchView searchView4 = this.E;
        searchView4.getClass();
        EditText editText = (EditText) searchView4.findViewById(androidx.appcompat.R.id.search_src_text);
        editText.setTypeface(o4.b.f11720s);
        editText.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
        editText.setHintTextColor(ContextCompat.getColor(this, R.color.core_search_view_color));
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_search_options);
        imageView2.getClass();
        imageView2.setOnClickListener(new e(this, 2));
        this.F = (RelativeLayout) findViewById(R.id.rl_sort_options);
        RadioButton radioButton = (RadioButton) findViewById(R.id.rb_name_sort);
        this.G = radioButton;
        radioButton.getClass();
        radioButton.setTypeface(o4.b.f11720s);
        RadioButton radioButton2 = this.G;
        radioButton2.getClass();
        radioButton2.setOnClickListener(new e(this, 3));
        RadioButton radioButton3 = this.G;
        radioButton3.getClass();
        radioButton3.setOnCheckedChangeListener(new g(this, 0));
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.rb_size_sort);
        this.H = radioButton4;
        radioButton4.getClass();
        radioButton4.setOnCheckedChangeListener(new g(this, 1));
        RadioButton radioButton5 = (RadioButton) findViewById(R.id.rb_date_sort);
        this.I = radioButton5;
        radioButton5.getClass();
        radioButton5.setOnCheckedChangeListener(new g(this, 2));
        CheckBox checkBox = (CheckBox) findViewById(R.id.cb_show_hidden_files);
        checkBox.setTypeface(o4.b.f11720s);
        try {
            sharedPreferences = getSharedPreferences("CoreSettings", 0);
        } catch (Exception unused) {
        }
        boolean z10 = sharedPreferences.contains("show_hidden_files") ? sharedPreferences.getBoolean("show_hidden_files", false) : false;
        checkBox.setChecked(z10);
        checkBox.setOnCheckedChangeListener(new g(this, 4));
        b0();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_files);
        this.f6673w = recyclerView;
        if (recyclerView == null) {
            l.i("rvFiles");
            throw null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        RecyclerView recyclerView2 = this.f6673w;
        if (recyclerView2 == null) {
            l.i("rvFiles");
            throw null;
        }
        recyclerView2.addItemDecoration(new x4.j((int) getResources().getDimension(R.dimen.margin_generic_item_recyclerview)));
        RecyclerView recyclerView3 = this.f6673w;
        if (recyclerView3 == null) {
            l.i("rvFiles");
            throw null;
        }
        recyclerView3.setItemAnimator(new DefaultItemAnimator());
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_loading_file_explorer);
        this.f6674x = relativeLayout;
        if (relativeLayout == null) {
            l.i("rlLoading");
            throw null;
        }
        relativeLayout.setOnClickListener(new n(28));
        this.y = (LinearLayout) findViewById(R.id.ll_sd_permissions_explanation);
        TextView textView8 = (TextView) findViewById(R.id.tv_storage_devices);
        this.Z = textView8;
        if (textView8 != null) {
            textView8.setTypeface(o4.b.f11719r);
        }
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tl_storage);
        this.Y = tabLayout;
        tabLayout.getClass();
        TabLayout.Tab text = tabLayout.newTab().setText(getString(R.string.internal_storage));
        text.getClass();
        text.setId(0);
        TabLayout tabLayout2 = this.Y;
        tabLayout2.getClass();
        tabLayout2.addTab(text);
        TabLayout tabLayout3 = this.Y;
        tabLayout3.getClass();
        TabLayout.Tab text2 = tabLayout3.newTab().setText(getString(R.string.sd_card));
        text2.getClass();
        text2.setId(1);
        TabLayout tabLayout4 = this.Y;
        tabLayout4.getClass();
        tabLayout4.addTab(text2);
        TabLayout tabLayout5 = this.Y;
        tabLayout5.getClass();
        ViewGroupKt.get(tabLayout5, 0).setSelected(true);
        TabLayout tabLayout6 = this.Y;
        tabLayout6.getClass();
        tabLayout6.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new p4.r(this));
        if (n()) {
            Y(true);
            ArrayList arrayListI = t1.I(this);
            this.Q = arrayListI;
            boolean zIsEmpty = arrayListI.isEmpty();
            TabLayout tabLayout7 = this.Y;
            if (zIsEmpty) {
                if (tabLayout7 != null) {
                    tabLayout7.setVisibility(8);
                }
                TextView textView9 = this.Z;
                if (textView9 != null) {
                    textView9.setVisibility(8);
                }
            } else {
                if (tabLayout7 != null) {
                    tabLayout7.setVisibility(0);
                }
                TextView textView10 = this.Z;
                if (textView10 != null) {
                    textView10.setVisibility(0);
                }
            }
        } else {
            AlertDialog alertDialog2 = this.f11942a;
            if (alertDialog2 != null) {
                alertDialog2.dismiss();
            }
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_accept, (ViewGroup) null, false);
            TextView textView11 = (TextView) viewInflate.findViewById(R.id.tv_dialog_accept_msg);
            textView11.setTypeface(o4.b.f11720s);
            textView11.setText(getString(R.string.msg_request_permissions_write_external_storage));
            TextView textView12 = (TextView) viewInflate.findViewById(R.id.tv_accept_option);
            textView12.setTypeface(o4.b.f11719r);
            textView12.setOnClickListener(new e(this, 0));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(viewInflate);
            builder.setCancelable(false);
            this.f11942a = builder.create();
            if (!isFinishing() && (alertDialog = this.f11942a) != null) {
                alertDialog.show();
            }
        }
        getOnBackPressedDispatcher().addCallback(this, this.f6670o0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i10, KeyEvent keyEvent) {
        keyEvent.getClass();
        if (i10 != 82) {
            return super.onKeyDown(i10, keyEvent);
        }
        Toolbar toolbar = this.K;
        toolbar.getClass();
        toolbar.showOverflowMenu();
        return true;
    }

    @Override // p4.f
    public final void r() {
        j(getString(R.string.msg_permission_storage_denied));
    }

    @Override // p4.f
    public final void s() {
        Uri uri;
        boolean zMatches;
        List<UriPermission> persistedUriPermissions = getContentResolver().getPersistedUriPermissions();
        persistedUriPermissions.getClass();
        Iterator<UriPermission> it = persistedUriPermissions.iterator();
        while (true) {
            if (!it.hasNext()) {
                uri = null;
                break;
            }
            UriPermission next = it.next();
            Uri uri2 = next.getUri();
            uri2.getClass();
            String path = uri2.getPath();
            if (path != null) {
                Pattern patternCompile = Pattern.compile(".*\\b[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]-[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]:.*");
                patternCompile.getClass();
                zMatches = patternCompile.matcher(path).matches();
            } else {
                zMatches = false;
            }
            if (zMatches) {
                uri = next.getUri();
                break;
            }
        }
        if (uri != null) {
            LinearLayout linearLayout = this.y;
            if (linearLayout == null) {
                l.i("llPermissionExplanation");
                throw null;
            }
            linearLayout.setVisibility(8);
            RecyclerView recyclerView = this.f6673w;
            if (recyclerView == null) {
                l.i("rvFiles");
                throw null;
            }
            recyclerView.setVisibility(0);
            this.P = DocumentFile.fromTreeUri(this, uri);
            this.T = null;
            Y(true);
        }
    }

    @Override // p4.f
    public final void t() {
        j(getString(R.string.core_error_wrong_sdcard_path));
    }

    @Override // p4.f
    public final void u() {
        j(getString(R.string.msg_permission_storage_denied));
    }

    @Override // p4.f
    public final void w() {
        Y(true);
        if (m()) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 645);
    }
}
