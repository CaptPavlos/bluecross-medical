package n4;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a0 extends y5.f {

    /* renamed from: b, reason: collision with root package name */
    public final z f11295b;

    /* JADX WARN: Illegal instructions before constructor call */
    public a0(b0 b0Var, a4.f fVar, n5 n5Var, Context context) {
        n5Var.getClass();
        LinearLayout linearLayout = (LinearLayout) fVar.f218b;
        linearLayout.getClass();
        super(linearLayout, context);
        z zVar = new z();
        zVar.f11520a = n5Var;
        zVar.f11521b = context;
        zVar.f11522c = new ArrayList();
        this.f11295b = zVar;
        RecyclerView recyclerView = (RecyclerView) fVar.f219c;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.itemView.getContext(), 1, false));
        recyclerView.setAdapter(zVar);
    }
}
