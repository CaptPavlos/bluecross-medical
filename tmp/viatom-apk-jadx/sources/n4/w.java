package n4;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;
import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w extends y5.f {

    /* renamed from: b, reason: collision with root package name */
    public final v f11501b;

    /* JADX WARN: Illegal instructions before constructor call */
    public w(b0 b0Var, a3.x xVar, n5 n5Var, Context context, String str) {
        n5Var.getClass();
        str.getClass();
        LinearLayout linearLayout = (LinearLayout) xVar.f181b;
        linearLayout.getClass();
        super(linearLayout, context);
        v vVar = new v();
        vVar.f11497a = n5Var;
        vVar.f11498b = context;
        vVar.f11499c = new ArrayList();
        this.f11501b = vVar;
        RecyclerView recyclerView = (RecyclerView) xVar.f182c;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.itemView.getContext(), 0, false));
        recyclerView.setAdapter(vVar);
        TextView textView = (TextView) xVar.f183d;
        textView.setTypeface(o4.b.f11719r);
        textView.setText(context.getString(R.string.organization_populars_apps_title, str));
    }
}
