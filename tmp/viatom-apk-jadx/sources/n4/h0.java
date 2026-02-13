package n4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;
import java.util.Iterator;
import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11363a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f11364b;

    /* renamed from: c, reason: collision with root package name */
    public final n5 f11365c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11366d;

    public h0(ArrayList arrayList, Context context, n5 n5Var) {
        arrayList.getClass();
        n5Var.getClass();
        this.f11363a = arrayList;
        this.f11364b = context;
        this.f11365c = n5Var;
    }

    public final void a(boolean z9) {
        this.f11366d = z9;
        if (z9) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    public final void b(h5.m0 m0Var) {
        m0Var.getClass();
        ArrayList arrayList = this.f11363a;
        Iterator it = arrayList.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            int i11 = i10 + 1;
            if (((h5.m0) it.next()).f8657a == m0Var.f8657a) {
                break;
            } else {
                i10 = i11;
            }
        }
        arrayList.set(i10, m0Var);
        notifyItemChanged(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11363a.size() + (this.f11366d ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        return i10 == this.f11363a.size() ? 1 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005e  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r14, int r15) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.h0.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        if (i10 == 0) {
            View viewB = c.i.b(viewGroup, R.layout.reply, viewGroup, false);
            viewB.getClass();
            return new y5.w0(viewB, this.f11364b, this.f11365c);
        }
        if (i10 != 1) {
            com.google.gson.internal.a.n("viewType unknown");
            return null;
        }
        View viewB2 = c.i.b(viewGroup, R.layout.pb_loading_more_content, viewGroup, false);
        viewB2.getClass();
        return new y5.h0(viewB2);
    }
}
