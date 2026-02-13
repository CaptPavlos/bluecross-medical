package n4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public g5.c f11497a;

    /* renamed from: b, reason: collision with root package name */
    public Context f11498b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f11499c;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11499c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        u uVar = (u) viewHolder;
        uVar.getClass();
        boolean zA = kotlin.jvm.internal.l.a(this.f11499c.get(i10), t6.l.i0(this.f11499c));
        ArrayList arrayList = this.f11499c;
        if (zA) {
            Object obj = arrayList.get(i10);
            obj.getClass();
            uVar.g((h5.h) obj, true);
        } else {
            Object obj2 = arrayList.get(i10);
            obj2.getClass();
            uVar.g((h5.h) obj2, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        return new u(this, d5.j.f(LayoutInflater.from(viewGroup.getContext()), viewGroup), this.f11497a, this.f11498b);
    }
}
