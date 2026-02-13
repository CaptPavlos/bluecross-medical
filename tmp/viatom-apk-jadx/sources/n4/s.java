package n4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;
import l4.x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final h5.h f11475a;

    /* renamed from: b, reason: collision with root package name */
    public h5.f f11476b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f11477c;

    /* renamed from: d, reason: collision with root package name */
    public final x4 f11478d;
    public final int e;
    public int f;

    public s(h5.h hVar, h5.f fVar, Context context, x4 x4Var, int i10) {
        x4Var.getClass();
        this.f11475a = hVar;
        this.f11476b = fVar;
        this.f11477c = context;
        this.f11478d = x4Var;
        this.e = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ArrayList arrayList = this.f11475a.C0;
        arrayList.getClass();
        return arrayList.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        if (i10 == 0) {
            return 0;
        }
        ArrayList arrayList = this.f11475a.C0;
        arrayList.getClass();
        return i10 < arrayList.size() ? 1 : 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x01bc  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r21, int r22) {
        /*
            Method dump skipped, instructions count: 1009
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.s.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        Context context = this.f11477c;
        if (i10 == 0) {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.header_installed_app, viewGroup, false);
            viewInflate.getClass();
            return new y5.x(viewInflate, context);
        }
        if (i10 != 1) {
            View viewInflate2 = LayoutInflater.from(context).inflate(R.layout.load_more_versions, viewGroup, false);
            viewInflate2.getClass();
            return new y5.g0(viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(context).inflate(R.layout.old_version_item, viewGroup, false);
        viewInflate3.getClass();
        return new y5.q0(viewInflate3, this.f11478d);
    }
}
