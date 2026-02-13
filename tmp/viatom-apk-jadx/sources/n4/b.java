package n4;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.activities.MyDownloads;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final d0.i f11299a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f11300b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11301c;

    /* renamed from: d, reason: collision with root package name */
    public boolean[] f11302d;
    public int e;

    public b(d0.i iVar) {
        iVar.getClass();
        this.f11299a = iVar;
        this.f11300b = new ArrayList();
        this.e = -1;
    }

    public final void a(MyDownloads myDownloads, File file) {
        file.getClass();
        Iterator it = this.f11300b.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            int i11 = i10 + 1;
            if (kotlin.jvm.internal.l.a(((h5.q) it.next()).f(myDownloads), file)) {
                break;
            } else {
                i10 = i11;
            }
        }
        if (i10 >= 0) {
            notifyItemChanged(i10);
        }
    }

    public final void b(int i10) {
        boolean[] zArr = this.f11302d;
        zArr.getClass();
        this.f11302d.getClass();
        zArr[i10] = !r1[i10];
        notifyItemChanged(i10);
    }

    public final void c(boolean z9) {
        this.f11301c = z9;
        if (!z9) {
            if (this.f11300b.isEmpty()) {
                this.f11302d = new boolean[0];
            } else {
                this.f11302d = new boolean[this.f11300b.size()];
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11300b.size();
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x040c  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r25, int r26) {
        /*
            Method dump skipped, instructions count: 1400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.b.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.download_item, viewGroup, false);
        viewG.getClass();
        return new y5.k(viewG, this.f11299a);
    }
}
