package d5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.core.activities.FileExplorerActivity;
import j$.util.DesugarCollections;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7133a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f7134b;

    /* renamed from: c, reason: collision with root package name */
    public Object f7135c;

    /* renamed from: d, reason: collision with root package name */
    public Object f7136d;
    public Object e;
    public Object f;
    public Object g;

    public j(String str, Set set, String str2) {
        this.f7133a = 7;
        Set setUnmodifiableSet = set == null ? Collections.EMPTY_SET : DesugarCollections.unmodifiableSet(set);
        this.f7134b = setUnmodifiableSet;
        Map map = Collections.EMPTY_MAP;
        this.f7136d = str;
        this.e = str2;
        this.f = e1.a.f7623a;
        HashSet hashSet = new HashSet(setUnmodifiableSet);
        Iterator it = map.values().iterator();
        if (!it.hasNext()) {
            this.f7135c = DesugarCollections.unmodifiableSet(hashSet);
        } else {
            it.next().getClass();
            com.google.gson.internal.a.k();
            throw null;
        }
    }

    public static j a(View view) {
        int i10 = R.id.ll_pb_fus;
        if (((LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_pb_fus)) != null) {
            i10 = R.id.pb_enough_storage;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.pb_enough_storage);
            if (progressBar != null) {
                i10 = R.id.pb_not_storage;
                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, R.id.pb_not_storage);
                if (progressBar2 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view;
                    i10 = R.id.tv_no_storage_action;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_storage_action);
                    if (textView != null) {
                        i10 = R.id.tv_not_storage;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_not_storage);
                        if (textView2 != null) {
                            i10 = R.id.tv_not_storage_text;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_not_storage_text);
                            if (textView3 != null) {
                                return new j(relativeLayout, progressBar, progressBar2, textView, textView2, textView3, 6);
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        return null;
    }

    public static j e(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_no_wifi_connection, (ViewGroup) null, false);
        int i10 = R.id.tv_cancel_dialog_no_wifi_connection;
        TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_cancel_dialog_no_wifi_connection);
        if (textView != null) {
            i10 = R.id.tv_description_dialog_no_wifi_connection;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_description_dialog_no_wifi_connection);
            if (textView2 != null) {
                i10 = R.id.tv_ok_dialog_no_wifi_connection;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_ok_dialog_no_wifi_connection);
                if (textView3 != null) {
                    i10 = R.id.tv_settings_dialog_no_wifi_connection;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_settings_dialog_no_wifi_connection);
                    if (textView4 != null) {
                        i10 = R.id.tv_title_dialog_no_wifi_connection;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_dialog_no_wifi_connection);
                        if (textView5 != null) {
                            return new j((ViewGroup) viewInflate, textView, textView2, textView3, textView4, textView5, 0);
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i10)));
        return null;
    }

    public static j f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(R.layout.home_card_featured_item, viewGroup, false);
        int i10 = R.id.iv_home_card_featured_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_home_card_featured_item);
        if (imageView != null) {
            i10 = R.id.iv_logo_home_card_featured_item;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_logo_home_card_featured_item);
            if (imageView2 != null) {
                i10 = R.id.ll_progress_home_card_featured_item;
                if (((LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_progress_home_card_featured_item)) != null) {
                    i10 = R.id.pb_progress_home_card_featured_item;
                    if (((ProgressBar) ViewBindings.findChildViewById(viewInflate, R.id.pb_progress_home_card_featured_item)) != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
                        i10 = R.id.rl_logo_home_card_featured_item;
                        if (((RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_logo_home_card_featured_item)) != null) {
                            i10 = R.id.tv_desc_home_card_featured_item;
                            TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_desc_home_card_featured_item);
                            if (textView != null) {
                                i10 = R.id.tv_desc_home_card_featured_item_holder;
                                if (((TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_desc_home_card_featured_item_holder)) != null) {
                                    i10 = R.id.tv_name_home_card_featured_item;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_name_home_card_featured_item);
                                    if (textView2 != null) {
                                        i10 = R.id.tv_name_home_card_featured_item_holder;
                                        if (((TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_name_home_card_featured_item_holder)) != null) {
                                            i10 = R.id.tv_progress_home_card_featured_item;
                                            if (((TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_progress_home_card_featured_item)) != null) {
                                                i10 = R.id.tv_status_home_card_featured_item;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_status_home_card_featured_item);
                                                if (textView3 != null) {
                                                    i10 = R.id.tv_verified_home_card_featured_item;
                                                    if (((TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_verified_home_card_featured_item)) != null) {
                                                        return new j(relativeLayout, imageView, imageView2, textView, textView2, textView3, 3);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i10)));
        return null;
    }

    public static j g(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_pre_register, (ViewGroup) null, false);
        int i10 = R.id.iv_close_dialog_pre_register;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_close_dialog_pre_register);
        if (imageView != null) {
            i10 = R.id.tv_cancel_dialog_pre_register;
            TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_cancel_dialog_pre_register);
            if (textView != null) {
                i10 = R.id.tv_description_dialog_pre_register;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_description_dialog_pre_register);
                if (textView2 != null) {
                    i10 = R.id.tv_ok_dialog_pre_register;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_ok_dialog_pre_register);
                    if (textView3 != null) {
                        i10 = R.id.tv_title_dialog_pre_register;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_dialog_pre_register);
                        if (textView4 != null) {
                            return new j((RelativeLayout) viewInflate, imageView, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i10)));
        return null;
    }

    public static j h(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_required_features_missed, (ViewGroup) null, false);
        int i10 = R.id.tv_cancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_cancel);
        if (textView != null) {
            i10 = R.id.tv_missed_features;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_missed_features);
            if (textView2 != null) {
                i10 = R.id.tv_msg;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_msg);
                if (textView3 != null) {
                    i10 = R.id.tv_ok;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_ok);
                    if (textView4 != null) {
                        i10 = R.id.tv_title;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title);
                        if (textView5 != null) {
                            return new j((LinearLayout) viewInflate, textView, textView2, textView3, textView4, textView5, 2);
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i10)));
        return null;
    }

    public static boolean i(u4.e eVar, int i10) {
        int i11;
        return i10 == -1 || (i11 = eVar.f) == -1 || i11 == i10;
    }

    public void b(int i10) {
        TextView textView = (TextView) this.f7135c;
        FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) this.f7134b;
        textView.setText(fileExplorerActivity.getString(R.string.core_decompress_dialog_completed, String.valueOf(i10)));
        ProgressBar progressBar = (ProgressBar) this.g;
        progressBar.setIndeterminate(false);
        progressBar.setProgress(100);
        ((TextView) this.e).setText(fileExplorerActivity.getString(R.string.close));
    }

    public void c() {
        ProgressBar progressBar = (ProgressBar) this.g;
        TextView textView = (TextView) this.f7135c;
        FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) this.f7134b;
        textView.setText(fileExplorerActivity.getString(R.string.core_decompress_dialog_decompressing));
        ((RadioGroup) ((View) this.f).findViewById(R.id.rg_decompress_path)).setVisibility(8);
        TextView textView2 = fileExplorerActivity.C;
        if (textView2 == null) {
            kotlin.jvm.internal.l.i("tvSelectedPath");
            throw null;
        }
        textView2.setVisibility(8);
        progressBar.setVisibility(0);
        progressBar.setIndeterminate(true);
        ((TextView) this.f7136d).setVisibility(8);
    }

    public h1.p d(h1.p pVar) {
        return pVar.d(new androidx.arch.core.executor.a(2), new p8.u(this, 23));
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        switch (this.f7133a) {
        }
        return (RelativeLayout) this.f7134b;
    }

    public void j() {
        TextView textView = (TextView) this.f7135c;
        FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) this.f7134b;
        textView.setText(fileExplorerActivity.getString(R.string.core_decompress_dialog_error));
        ProgressBar progressBar = (ProgressBar) this.g;
        progressBar.setIndeterminate(false);
        progressBar.setProgress(0);
        ((TextView) this.e).setText(fileExplorerActivity.getString(R.string.close));
    }

    public void k(long j10) {
        TextView textView = (TextView) this.f7135c;
        StringBuilder sb = new StringBuilder();
        FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) this.f7134b;
        sb.append(fileExplorerActivity.getString(R.string.core_decompress_dialog_decompressing));
        sb.append(' ');
        sb.append(l1.b.M(fileExplorerActivity, j10));
        textView.setText(sb.toString());
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:76:0x0226. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l(java.util.ArrayList r17) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.j.l(java.util.ArrayList):void");
    }

    public ArrayList m() {
        ArrayList arrayList = new ArrayList();
        p4.z zVar = (p4.z) this.f7135c;
        if (zVar != null) {
            arrayList.add(zVar.f12030a);
        }
        Iterator it = ((ArrayList) this.f7136d).iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            u4.e eVar = (u4.e) next;
            if (eVar.f12905b) {
                File file = eVar.f12904a;
                file.getClass();
                arrayList.add(file);
            }
        }
        Iterator it2 = ((ArrayList) this.e).iterator();
        it2.getClass();
        while (it2.hasNext()) {
            Object next2 = it2.next();
            next2.getClass();
            u4.e eVar2 = (u4.e) next2;
            if (eVar2.f12905b) {
                File file2 = eVar2.f12904a;
                file2.getClass();
                arrayList.add(file2);
            }
        }
        Iterator it3 = ((ArrayList) this.f).iterator();
        it3.getClass();
        while (it3.hasNext()) {
            Object next3 = it3.next();
            next3.getClass();
            u4.e eVar3 = (u4.e) next3;
            if (eVar3.f12905b) {
                File file3 = eVar3.f12904a;
                file3.getClass();
                arrayList.add(file3);
            }
        }
        Iterator it4 = ((ArrayList) this.g).iterator();
        it4.getClass();
        while (it4.hasNext()) {
            Object next4 = it4.next();
            next4.getClass();
            u4.e eVar4 = (u4.e) next4;
            if (eVar4.f12905b) {
                File file4 = eVar4.f12904a;
                file4.getClass();
                arrayList.add(file4);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00f1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n(java.lang.String r2, java.lang.String r3, android.os.Bundle r4) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.j.n(java.lang.String, java.lang.String, android.os.Bundle):void");
    }

    public h1.p o(String str, String str2, Bundle bundle) {
        int i10;
        try {
            n(str, str2, bundle);
            e0.b bVar = (e0.b) this.f7136d;
            e0.h hVar = e0.h.f7603c;
            e0.o oVar = bVar.f7593c;
            if (oVar.a() < 12000000) {
                return oVar.b() != 0 ? bVar.a(bundle).e(hVar, new a4.f(bVar, bundle, 15, false)) : r0.f.w(new IOException("MISSING_INSTANCEID_SERVICE"));
            }
            e0.n nVarA = e0.n.a(bVar.f7592b);
            synchronized (nVarA) {
                i10 = nVarA.f7617b;
                nVarA.f7617b = i10 + 1;
            }
            return nVarA.b(new e0.l(i10, 1, bundle, 1)).d(hVar, e0.d.f7596b);
        } catch (InterruptedException | ExecutionException e) {
            return r0.f.w(e);
        }
    }

    public /* synthetic */ j(RelativeLayout relativeLayout, Object obj, View view, TextView textView, TextView textView2, TextView textView3, int i10) {
        this.f7133a = i10;
        this.f7134b = relativeLayout;
        this.f = obj;
        this.g = view;
        this.f7135c = textView;
        this.f7136d = textView2;
        this.e = textView3;
    }

    public /* synthetic */ j(ViewGroup viewGroup, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, int i10) {
        this.f7133a = i10;
        this.f7134b = viewGroup;
        this.f7135c = textView;
        this.f7136d = textView2;
        this.e = textView3;
        this.f = textView4;
        this.g = textView5;
    }

    public j(Context context) {
        this.f7133a = 10;
        this.f7134b = context;
        this.f7136d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
    }

    public j(RelativeLayout relativeLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f7133a = 1;
        this.f7134b = relativeLayout;
        this.g = imageView;
        this.f7135c = textView;
        this.f7136d = textView2;
        this.e = textView3;
        this.f = textView4;
    }

    public j(l1.g gVar, c5.t tVar, q2.b bVar, q2.b bVar2, r2.d dVar) {
        this.f7133a = 9;
        gVar.a();
        e0.b bVar3 = new e0.b(gVar.f10177a);
        this.f7134b = gVar;
        this.f7135c = tVar;
        this.f7136d = bVar3;
        this.e = bVar;
        this.f = bVar2;
        this.g = dVar;
    }

    public j(TextView textView, FileExplorerActivity fileExplorerActivity, View view, ProgressBar progressBar, TextView textView2, TextView textView3) {
        this.f7133a = 8;
        this.f7135c = textView;
        this.f7134b = fileExplorerActivity;
        this.f = view;
        this.g = progressBar;
        this.f7136d = textView2;
        this.e = textView3;
    }
}
