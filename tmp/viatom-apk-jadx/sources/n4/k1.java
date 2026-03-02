package n4;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import e5.t1;
import h5.l1;
import java.util.ArrayList;
import java.util.HashMap;
import l4.qc;
import org.json.JSONException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k1 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final g5.j f11408a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.a f11409b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f11410c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11411d;
    public final ArrayList e;
    public boolean f;
    public final YouTubePlayerView g;
    public e4.e h;

    /* renamed from: i, reason: collision with root package name */
    public String f11412i;

    /* renamed from: j, reason: collision with root package name */
    public String f11413j;

    /* renamed from: k, reason: collision with root package name */
    public int f11414k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f11415l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f11416m;

    /* renamed from: n, reason: collision with root package name */
    public x5.c f11417n;

    /* renamed from: o, reason: collision with root package name */
    public final int f11418o;

    public k1(g5.j jVar, g5.a aVar, Context context, String str) {
        SharedPreferences sharedPreferences;
        jVar.getClass();
        aVar.getClass();
        str.getClass();
        this.f11408a = jVar;
        this.f11409b = aVar;
        this.f11410c = context;
        this.f11411d = str;
        this.e = new ArrayList();
        this.f11412i = "";
        this.f11416m = true;
        this.f11418o = 8;
        try {
            sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception unused) {
        }
        boolean z9 = sharedPreferences.contains("app_detail_inflate_view_failed") ? sharedPreferences.getBoolean("app_detail_inflate_view_failed", false) : false;
        if (!z9) {
            try {
                YouTubePlayerView youTubePlayerView = new YouTubePlayerView(context, null, 0);
                youTubePlayerView.setEnableAutomaticInitialization(false);
                this.g = youTubePlayerView;
                a();
            } catch (Exception e) {
                Context context2 = this.f11410c;
                context2.getClass();
                try {
                    SharedPreferences.Editor editorEdit = context2.getSharedPreferences("SettingsPreferences", 0).edit();
                    editorEdit.putBoolean("app_detail_inflate_view_failed", true);
                    editorEdit.apply();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                this.g = null;
                e.printStackTrace();
            } catch (UnsatisfiedLinkError e7) {
                Context context3 = this.f11410c;
                context3.getClass();
                try {
                    SharedPreferences.Editor editorEdit2 = context3.getSharedPreferences("SettingsPreferences", 0).edit();
                    editorEdit2.putBoolean("app_detail_inflate_view_failed", true);
                    editorEdit2.apply();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                this.g = null;
                e7.printStackTrace();
            }
        }
        if (kotlin.jvm.internal.l.a(this.f11411d, kotlin.jvm.internal.y.a(t1.class).c())) {
            this.f11418o = 8;
        } else {
            this.f11418o = 20;
        }
        float f = UptodownApp.E;
        this.f11416m = k4.c.e(this.f11410c);
    }

    public final void a() throws JSONException {
        YouTubePlayerView youTubePlayerView = this.g;
        if (youTubePlayerView != null) {
            i4.c cVar = youTubePlayerView.f6629b;
            cVar.removeViews(1, cVar.getChildCount() - 1);
            View viewInflate = View.inflate(cVar.getContext(), R.layout.home_youtube_player_layout, cVar);
            viewInflate.getClass();
            g4.a aVar = new g4.a(this.f11410c);
            aVar.b(0, "controls");
            aVar.b(0, "rel");
            aVar.b(3, "iv_load_policy");
            aVar.b(1, "cc_load_policy");
            youTubePlayerView.a(new qc(1, this, viewInflate), new g4.b(aVar.f8228a));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) throws JSONException {
        ArrayList arrayList;
        ImageView imageView;
        SharedPreferences sharedPreferences;
        j1 j1Var = (j1) viewHolder;
        j1Var.getClass();
        RelativeLayout relativeLayout = j1Var.g;
        ImageView imageView2 = j1Var.f;
        int i11 = i10 + 1;
        Context context = this.f11410c;
        context.getClass();
        try {
            sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception unused) {
        }
        boolean z9 = sharedPreferences.contains("app_detail_inflate_view_failed") ? sharedPreferences.getBoolean("app_detail_inflate_view_failed", false) : false;
        ArrayList arrayList2 = this.e;
        if (z9 || i10 != this.f11414k) {
            Object obj = arrayList2.get(i10);
            obj.getClass();
            j1Var.g((h5.h) obj, i11);
            return;
        }
        Object obj2 = arrayList2.get(i10);
        obj2.getClass();
        h5.h hVar = (h5.h) obj2;
        String str = j1Var.e;
        View view = j1Var.f11397p;
        CardView cardView = j1Var.f11396o;
        Context context2 = j1Var.f11389d;
        Float fValueOf = Float.valueOf(0.0f);
        k1 k1Var = j1Var.f11399r;
        YouTubePlayerView youTubePlayerView = k1Var.g;
        if (youTubePlayerView != null) {
            if (youTubePlayerView.getParent() != null) {
                ViewParent parent = youTubePlayerView.getParent();
                parent.getClass();
                ((ViewGroup) parent).removeView(youTubePlayerView);
            }
            cardView.addView(youTubePlayerView);
            cardView.setVisibility(0);
            view.setVisibility(0);
            imageView2.setVisibility(8);
            x5.c cVar = k1Var.f11417n;
            if (cVar != null && (imageView = cVar.f13702b) != null) {
                imageView.setImageDrawable(null);
            }
            y5.f.f(hVar, j1Var.f11391j, j1Var.f11392k);
            y5.f.b(relativeLayout, j1Var.f11387b, hVar);
            j1.h(imageView2, hVar);
            j1Var.e(j1Var.f11390i, hVar.i());
            j1Var.c(hVar, j1Var.h, j1Var.f11390i, j1Var.f11392k, j1Var.f11394m, j1Var.f11393l, j1Var.f11395n);
            view.setOnClickListener(new e5.s(k1Var, 22));
            relativeLayout.setOnLongClickListener(new i1(j1Var, hVar, i11, 0));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(j1Var.f11398q, -1);
            View view2 = j1Var.itemView;
            y5.f.a(layoutParams, context2, i11, k1Var.f11418o);
            view2.setLayoutParams(layoutParams);
            if (k1Var.f11415l && k1Var.h != null && (arrayList = hVar.P) != null && !arrayList.isEmpty()) {
                ArrayList arrayList3 = hVar.P;
                arrayList3.getClass();
                if (((l1) arrayList3.get(0)).f8650a != null) {
                    ArrayList arrayList4 = hVar.P;
                    arrayList4.getClass();
                    if (!kotlin.jvm.internal.l.a(((l1) arrayList4.get(0)).f8650a, k1Var.f11413j)) {
                        ArrayList arrayList5 = hVar.P;
                        arrayList5.getClass();
                        k1Var.f11413j = ((l1) arrayList5.get(0)).f8650a;
                        StringBuilder sb = new StringBuilder();
                        String str2 = hVar.f8567b;
                        str2.getClass();
                        sb.append(str2);
                        sb.append(str);
                        k1Var.f11412i = sb.toString();
                        if (kotlin.jvm.internal.l.a(str, kotlin.jvm.internal.y.a(t1.class).c())) {
                            float f = UptodownApp.E;
                            UptodownApp.T = k1Var.h;
                        } else {
                            float f10 = UptodownApp.E;
                            UptodownApp.U = k1Var.h;
                        }
                        float f11 = UptodownApp.E;
                        if (k4.c.e(context2)) {
                            String str3 = "1";
                            try {
                                SharedPreferences sharedPreferences2 = context2.getSharedPreferences("SettingsPreferences", 0);
                                if (sharedPreferences2.contains("data_saver_options")) {
                                    String string = sharedPreferences2.getString("data_saver_options", "1");
                                    string.getClass();
                                    str3 = string;
                                }
                            } catch (Exception unused2) {
                            }
                            if (Integer.parseInt(str3) > 0) {
                                HashMap map = UptodownApp.V;
                                boolean zContainsKey = map.containsKey(k1Var.f11412i);
                                e4.e eVar = k1Var.h;
                                if (zContainsKey) {
                                    eVar.getClass();
                                    ArrayList arrayList6 = hVar.P;
                                    arrayList6.getClass();
                                    String str4 = ((l1) arrayList6.get(0)).f8650a;
                                    str4.getClass();
                                    Object obj3 = map.get(k1Var.f11412i);
                                    obj3.getClass();
                                    ((i4.g) eVar).d(str4, ((Number) obj3).floatValue());
                                } else {
                                    eVar.getClass();
                                    ArrayList arrayList7 = hVar.P;
                                    arrayList7.getClass();
                                    String str5 = ((l1) arrayList7.get(0)).f8650a;
                                    str5.getClass();
                                    ((i4.g) eVar).d(str5, 0.0f);
                                    map.put(k1Var.f11412i, fValueOf);
                                }
                                boolean z10 = k1Var.f;
                                e4.e eVar2 = k1Var.h;
                                if (z10) {
                                    eVar2.getClass();
                                    ((i4.g) eVar2).f();
                                    return;
                                } else {
                                    eVar2.getClass();
                                    ((i4.g) eVar2).e();
                                    return;
                                }
                            }
                        }
                        HashMap map2 = UptodownApp.V;
                        boolean zContainsKey2 = map2.containsKey(k1Var.f11412i);
                        e4.e eVar3 = k1Var.h;
                        if (zContainsKey2) {
                            eVar3.getClass();
                            ArrayList arrayList8 = hVar.P;
                            arrayList8.getClass();
                            String str6 = ((l1) arrayList8.get(0)).f8650a;
                            str6.getClass();
                            Object obj4 = map2.get(k1Var.f11412i);
                            obj4.getClass();
                            ((i4.g) eVar3).b(str6, ((Number) obj4).floatValue());
                        } else {
                            eVar3.getClass();
                            ArrayList arrayList9 = hVar.P;
                            arrayList9.getClass();
                            String str7 = ((l1) arrayList9.get(0)).f8650a;
                            str7.getClass();
                            ((i4.g) eVar3).b(str7, 0.0f);
                            map2.put(k1Var.f11412i, fValueOf);
                        }
                        String strE = hVar.e();
                        if (strE == null || strE.length() == 0) {
                            return;
                        }
                        x5.c cVar2 = k1Var.f11417n;
                        cVar2.getClass();
                        cVar2.f13702b.setVisibility(0);
                        x5.c cVar3 = k1Var.f11417n;
                        cVar3.getClass();
                        j1.h(cVar3.f13702b, hVar);
                        return;
                    }
                }
            }
            ArrayList arrayList10 = hVar.P;
            if (arrayList10 == null || arrayList10.isEmpty()) {
                j1Var.g(hVar, i11);
            }
            if (k1Var.h == null) {
                k1Var.a();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.home_video_featured_item, viewGroup, false);
        viewG.getClass();
        return new j1(this, viewG, this.f11408a, this.f11409b, this.f11410c, this.f11411d);
    }
}
