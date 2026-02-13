package n4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import y5.r1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final g5.b f11448a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.p f11449b;

    /* renamed from: c, reason: collision with root package name */
    public final g5.k f11450c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f11451d;
    public int e;

    public p(g5.b bVar, g5.p pVar, g5.k kVar) {
        bVar.getClass();
        kVar.getClass();
        this.f11448a = bVar;
        this.f11449b = pVar;
        this.f11450c = kVar;
        this.f11451d = new ArrayList();
        this.e = -1;
    }

    public final void a(Context context, File file) {
        h5.f fVar;
        String str;
        file.getClass();
        v5.g gVarL = v5.g.f13148u.l(context);
        gVarL.a();
        Iterator it = this.f11451d.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            int i11 = i10 + 1;
            Object next = it.next();
            if ((next instanceof h5.f) && (str = (fVar = (h5.f) next).f8526c) != null && str.length() != 0) {
                String str2 = fVar.f8526c;
                str2.getClass();
                h5.y0 y0VarM = gVarL.M(str2);
                h5.q qVarA = y0VarM != null ? y0VarM.a(context) : null;
                if (qVarA != null && qVarA.f8716v.size() == 1 && o7.u.Z(((h5.r) qVarA.f8716v.get(0)).h, file.getAbsolutePath(), true)) {
                    break;
                }
            }
            i10 = i11;
        }
        gVarL.b();
        if (i10 >= 0) {
            notifyItemChanged(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11451d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        Object obj = this.f11451d.get(i10);
        obj.getClass();
        if (obj instanceof u0) {
            return 1;
        }
        if (obj instanceof h5.f) {
            return 0;
        }
        if (!(obj instanceof String)) {
            z8.f.a();
            return 0;
        }
        String str = (String) obj;
        int iHashCode = str.hashCode();
        if (iHashCode != 1477891299) {
            if (iHashCode != 1692569964) {
                if (iHashCode == 2032679000 && str.equals("title_system_app")) {
                    return 2;
                }
            } else if (str.equals("title_system_service")) {
                return 3;
            }
        } else if (str.equals("title_disable_app")) {
            return 4;
        }
        z8.f.a();
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        viewHolder.getClass();
        if (viewHolder instanceof y5.e) {
            Object obj = this.f11451d.get(i10);
            obj.getClass();
            ((y5.e) viewHolder).a((h5.f) obj);
            return;
        }
        if (viewHolder instanceof r1) {
            r1 r1Var = (r1) viewHolder;
            Object obj2 = this.f11451d.get(i10);
            obj2.getClass();
            r1Var.a((u0) obj2, this.e == i10, false);
            return;
        }
        if (!(viewHolder instanceof y5.l0)) {
            com.google.gson.internal.a.n("ViewHolder unknown!!");
            return;
        }
        y5.l0 l0Var = (y5.l0) viewHolder;
        ImageView imageView = l0Var.f13935c;
        l0Var.f13934b.setVisibility(0);
        if (l0Var.f13933a == null) {
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        } else {
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (imageView != null) {
                imageView.setOnClickListener(new y5.k0(l0Var, 1));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        if (i10 == 0) {
            return new y5.e(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.installed_app_item, viewGroup, false), this.f11448a);
        }
        if (i10 == 1) {
            return new r1(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.update_item, viewGroup, false), this.f11449b);
        }
        if (i10 == 2) {
            View viewX = com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.tv_myappsupdates_title, viewGroup, false);
            String string = viewX.getContext().getString(R.string.system_apps_title);
            string.getClass();
            return new y5.l0(viewX, string, null);
        }
        if (i10 == 3) {
            View viewX2 = com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.tv_myappsupdates_title, viewGroup, false);
            String string2 = viewX2.getContext().getString(R.string.menu_item_title_system_services);
            string2.getClass();
            return new y5.l0(viewX2, string2, null);
        }
        if (i10 != 4) {
            com.google.gson.internal.a.n("viewType unknown");
            return null;
        }
        View viewX3 = com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.tv_myappsupdates_title, viewGroup, false);
        String string3 = viewX3.getContext().getString(R.string.disabled_apps);
        string3.getClass();
        return new y5.l0(viewX3, string3, this.f11450c);
    }
}
