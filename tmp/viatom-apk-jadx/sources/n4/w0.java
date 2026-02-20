package n4;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c1.w4;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import l4.o9;
import y5.e2;
import y5.f2;
import y5.o1;
import y5.p1;
import y5.r1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final g5.p f11502a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.b f11503b;

    /* renamed from: c, reason: collision with root package name */
    public final o9 f11504c;

    /* renamed from: d, reason: collision with root package name */
    public final g5.k f11505d;
    public ArrayList e;
    public final v0 f;
    public int g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public int f11506i;

    public w0(g5.p pVar, g5.b bVar, o9 o9Var, g5.k kVar) {
        pVar.getClass();
        bVar.getClass();
        o9Var.getClass();
        kVar.getClass();
        this.f11502a = pVar;
        this.f11503b = bVar;
        this.f11504c = o9Var;
        this.f11505d = kVar;
        this.f = new v0();
        this.g = -1;
    }

    public final ArrayList a() {
        ArrayList arrayList = this.e;
        if (arrayList != null) {
            return arrayList;
        }
        kotlin.jvm.internal.l.i(DataSchemeDataSource.SCHEME_DATA);
        throw null;
    }

    public final void b(Context context, File file) {
        h5.f fVar;
        String str;
        file.getClass();
        v5.g gVarL = v5.g.f13148u.l(context);
        gVarL.a();
        int i10 = -1;
        int i11 = 0;
        for (Object obj : a()) {
            int i12 = i11 + 1;
            if ((obj instanceof h5.f) && (str = (fVar = (h5.f) obj).f8526c) != null && str.length() != 0) {
                String str2 = fVar.f8526c;
                str2.getClass();
                h5.y0 y0VarM = gVarL.M(str2);
                h5.q qVarA = y0VarM != null ? y0VarM.a(context) : null;
                if (qVarA != null && qVarA.f8716v.size() > 0) {
                    Iterator it = qVarA.f8716v.iterator();
                    it.getClass();
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        if (o7.u.Z(((h5.r) next).h, file.getAbsolutePath(), true)) {
                            i10 = i11;
                            break;
                            break;
                        }
                    }
                }
            } else if (obj instanceof u0) {
                h5.y0 y0Var = ((u0) obj).f11494b;
                h5.q qVar = y0Var.f8798i;
                if ((qVar != null ? qVar.f8716v : null) != null) {
                    qVar.getClass();
                    if (qVar.f8716v.size() > 0) {
                        h5.q qVar2 = y0Var.f8798i;
                        qVar2.getClass();
                        Iterator it2 = qVar2.f8716v.iterator();
                        it2.getClass();
                        while (it2.hasNext()) {
                            Object next2 = it2.next();
                            next2.getClass();
                            if (o7.u.Z(((h5.r) next2).h, file.getAbsolutePath(), true)) {
                                i10 = i11;
                                break;
                            }
                        }
                    }
                }
            }
            i11 = i12;
        }
        gVarL.b();
        if (i10 >= 0) {
            notifyItemChanged(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return a().size();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        Object obj = a().get(i10);
        obj.getClass();
        if (obj instanceof h5.f) {
            return ((h5.f) obj).f8532m == 1 ? 9 : 1;
        }
        if (obj instanceof u0) {
            u0 u0Var = (u0) obj;
            if (u0Var.f11493a.f8532m == 1) {
                return 9;
            }
            return u0Var.f11494b.b() ? 10 : 0;
        }
        if (!(obj instanceof String)) {
            if (obj instanceof v0) {
                return 8;
            }
            z8.f.a();
            return 0;
        }
        String str = (String) obj;
        switch (str.hashCode()) {
            case -1764562172:
                if (str.equals("tracking_disabled")) {
                    return 4;
                }
                break;
            case -864119891:
                if (str.equals("title_recent_updates")) {
                    return 5;
                }
                break;
            case 446114743:
                if (str.equals("warning_not_space")) {
                    return 2;
                }
                break;
            case 903589355:
                if (str.equals("title_ignored")) {
                    return 6;
                }
                break;
            case 1477891299:
                if (str.equals("title_disable_app")) {
                    return 7;
                }
                break;
        }
        z8.f.a();
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        SharedPreferences sharedPreferences;
        long j10;
        viewHolder.getClass();
        if (viewHolder instanceof y5.e) {
            Object obj = a().get(i10);
            obj.getClass();
            ((y5.e) viewHolder).a((h5.f) obj);
            return;
        }
        if (viewHolder instanceof r1) {
            r1 r1Var = (r1) viewHolder;
            Object obj2 = a().get(i10);
            obj2.getClass();
            r1Var.a((u0) obj2, this.g == i10, this.h);
            return;
        }
        if (viewHolder instanceof y5.l0) {
            y5.l0 l0Var = (y5.l0) viewHolder;
            ImageView imageView = l0Var.f13935c;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, (int) l0Var.itemView.getContext().getResources().getDimension(R.dimen.margin_l), 0, 0);
            l0Var.itemView.setLayoutParams(layoutParams);
            l0Var.f13934b.setVisibility(0);
            if (l0Var.f13933a == null) {
                if (imageView != null) {
                    imageView.setVisibility(8);
                    return;
                }
                return;
            } else {
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                if (imageView != null) {
                    imageView.setOnClickListener(new y5.k0(l0Var, 0));
                    return;
                }
                return;
            }
        }
        if (viewHolder instanceof e2) {
            ((e2) viewHolder).f13856a.setVisibility(0);
            return;
        }
        if (viewHolder instanceof p1) {
            p1 p1Var = (p1) viewHolder;
            int i11 = this.f.f11500a;
            LinearLayout linearLayout = p1Var.f13967c;
            TextView textView = p1Var.f13966b;
            TextView textView2 = p1Var.e;
            if (i11 != 0) {
                textView.setText(p1Var.itemView.getContext().getString(R.string.my_downloads_pending));
                linearLayout.setVisibility(8);
                return;
            }
            float f = UptodownApp.E;
            Context context = p1Var.itemView.getContext();
            context.getClass();
            if (k4.c.n(context, "TrackingWorkerSingle")) {
                textView2.setOnClickListener(null);
                Context context2 = p1Var.itemView.getContext();
                context2.getClass();
                new w4(context2, 5, false).E(textView2, 0.3f);
            } else {
                textView2.setOnClickListener(new y5.p(p1Var, 3));
                Context context3 = p1Var.itemView.getContext();
                context3.getClass();
                new w4(context3, 5, false).E(textView2, 1.0f);
            }
            textView.setText(p1Var.itemView.getContext().getString(R.string.you_are_up_to_date));
            TextView textView3 = p1Var.f13968d;
            Resources resources = p1Var.itemView.getResources();
            Context context4 = p1Var.itemView.getContext();
            context4.getClass();
            SharedPreferences sharedPreferences2 = context4.getSharedPreferences("SettingsPreferences", 0);
            try {
                try {
                    j10 = sharedPreferences2.getLong("last_tracking_timestamp", 0L);
                } catch (ClassCastException unused) {
                    j10 = 0;
                }
            } catch (ClassCastException unused2) {
                long j11 = sharedPreferences2.getInt("last_tracking_timestamp", -1);
                try {
                    SharedPreferences.Editor editorEdit = context4.getSharedPreferences("SettingsPreferences", 0).edit();
                    editorEdit.putLong("last_tracking_timestamp", j11);
                    editorEdit.apply();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                j10 = j11;
            }
            textView3.setText(resources.getString(R.string.last_check, String.valueOf(j10 > 0 ? new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault()).format(new Date(j10)) : null)));
            linearLayout.setVisibility(0);
            return;
        }
        if (viewHolder instanceof f2) {
            f2 f2Var = (f2) viewHolder;
            Context context5 = viewHolder.itemView.getContext();
            context5.getClass();
            try {
                sharedPreferences = context5.getSharedPreferences("SettingsPreferences", 0);
            } catch (Exception unused3) {
            }
            boolean z9 = sharedPreferences.contains("gdpr_tracking_allowed") ? sharedPreferences.getBoolean("gdpr_tracking_allowed", false) : false;
            LinearLayout linearLayout2 = f2Var.f13862a;
            if (z9) {
                linearLayout2.setVisibility(8);
                return;
            } else {
                linearLayout2.setVisibility(0);
                return;
            }
        }
        if (viewHolder instanceof y5.a) {
            Object obj3 = a().get(i10);
            obj3.getClass();
            if (obj3 instanceof h5.f) {
                Object obj4 = a().get(i10);
                obj4.getClass();
                ((y5.a) viewHolder).a((h5.f) obj4);
                return;
            } else {
                if (obj3 instanceof u0) {
                    Object obj5 = a().get(i10);
                    obj5.getClass();
                    ((y5.a) viewHolder).a(((u0) obj5).f11493a);
                    return;
                }
                return;
            }
        }
        if (!(viewHolder instanceof o1)) {
            com.google.gson.internal.a.n("ViewHolder unknown!!");
            return;
        }
        o1 o1Var = (o1) viewHolder;
        Object obj6 = a().get(i10);
        obj6.getClass();
        u0 u0Var = (u0) obj6;
        TextView textView4 = o1Var.g;
        TextView textView5 = o1Var.e;
        h5.f fVar = u0Var.f11493a;
        boolean z10 = fVar.B;
        View view = o1Var.itemView;
        if (z10) {
            view.setAlpha(0.3f);
        } else {
            view.setAlpha(1.0f);
        }
        ConcurrentHashMap concurrentHashMap = v5.n.f13169a;
        Context context6 = o1Var.itemView.getContext();
        context6.getClass();
        o1Var.f13958b.setImageDrawable(v5.n.c(context6, fVar.f8526c));
        o1Var.f13959c.setText(fVar.f8525b);
        o1Var.f13960d.setText(fVar.e);
        long j12 = fVar.f8533n;
        Context context7 = o1Var.itemView.getContext();
        context7.getClass();
        textView5.setText(l1.b.M(context7, j12));
        TextView textView6 = o1Var.f;
        long j13 = fVar.f8534o;
        textView6.setText(j13 > 0 ? new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date(j13)) : null);
        float f10 = UptodownApp.E;
        if (u0Var.f11494b.f == 1) {
            textView4.setText(o1Var.itemView.getContext().getString(R.string.skipped_update));
            textView4.setVisibility(0);
        } else {
            textView4.setVisibility(8);
            textView5.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        o9 o9Var = this.f11504c;
        g5.b bVar = this.f11503b;
        switch (i10) {
            case 0:
                return new r1(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.update_item, viewGroup, false), this.f11502a);
            case 1:
                return new y5.e(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.installed_app_item, viewGroup, false), bVar);
            case 2:
                return new e2(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.warning_not_space_available, viewGroup, false));
            case 3:
            default:
                com.google.gson.internal.a.n("viewType unknown");
                return null;
            case 4:
                return new f2(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.tracking_disabled, viewGroup, false), o9Var);
            case 5:
                View viewX = com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.tv_myappsupdates_title, viewGroup, false);
                String string = viewGroup.getContext().getString(R.string.recent_updates);
                string.getClass();
                return new y5.l0(viewX, string, null);
            case 6:
                View viewX2 = com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.tv_myappsupdates_title, viewGroup, false);
                String string2 = viewGroup.getContext().getString(R.string.update_ignored);
                string2.getClass();
                return new y5.l0(viewX2, string2, null);
            case 7:
                View viewX3 = com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.tv_myappsupdates_title, viewGroup, false);
                String string3 = viewGroup.getContext().getString(R.string.disabled_apps);
                string3.getClass();
                return new y5.l0(viewX3, string3, this.f11505d);
            case 8:
                return new p1(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.updates_header, viewGroup, false), o9Var);
            case 9:
                return new y5.a(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.installed_app_item, viewGroup, false), bVar);
            case 10:
                return new o1(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.installed_app_item, viewGroup, false), bVar);
        }
    }
}
