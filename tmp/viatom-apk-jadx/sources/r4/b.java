package r4;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import b5.d;
import com.uptodown.R;
import java.util.ArrayList;
import l4.x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final x4 f12374a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f12375b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12376c;

    /* renamed from: d, reason: collision with root package name */
    public boolean[] f12377d;

    public b(x4 x4Var) {
        x4Var.getClass();
        this.f12374a = x4Var;
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        if (this.f12375b != null) {
            boolean[] zArr = this.f12377d;
            zArr.getClass();
            int length = zArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                if (zArr[i10]) {
                    ArrayList arrayList2 = this.f12375b;
                    arrayList2.getClass();
                    arrayList.add(arrayList2.get(i10));
                }
            }
        }
        return arrayList;
    }

    public final void b(int i10) {
        boolean[] zArr = this.f12377d;
        zArr.getClass();
        this.f12377d.getClass();
        zArr[i10] = !r1[i10];
        notifyItemChanged(i10);
    }

    public final void c(boolean z9) {
        this.f12376c = z9;
        if (!z9) {
            ArrayList arrayList = this.f12375b;
            if (arrayList != null) {
                this.f12377d = new boolean[arrayList.size()];
            } else {
                this.f12377d = new boolean[0];
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ArrayList arrayList = this.f12375b;
        if (arrayList == null) {
            return 0;
        }
        arrayList.getClass();
        return arrayList.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00bf  */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r18, int r19) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r4.b.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        return new d(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.file_item, viewGroup, false), this.f12374a);
    }
}
