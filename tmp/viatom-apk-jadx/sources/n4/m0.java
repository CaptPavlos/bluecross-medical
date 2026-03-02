package n4;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import l4.x4;
import y5.s1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final Context f11434a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.b f11435b;

    /* renamed from: c, reason: collision with root package name */
    public final x4 f11436c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f11437d;

    public m0(ArrayList arrayList, Context context, g5.b bVar, x4 x4Var) {
        arrayList.getClass();
        bVar.getClass();
        x4Var.getClass();
        this.f11434a = context;
        this.f11435b = bVar;
        this.f11436c = x4Var;
        this.f11437d = new ArrayList();
        a().add("uptodown_protect");
        a().addAll(arrayList);
    }

    public final ArrayList a() {
        ArrayList arrayList = this.f11437d;
        if (arrayList != null) {
            return arrayList;
        }
        kotlin.jvm.internal.l.i(DataSchemeDataSource.SCHEME_DATA);
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return a().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        Object obj = a().get(i10);
        obj.getClass();
        if (obj instanceof h5.f) {
            return 0;
        }
        if (!(obj instanceof String)) {
            z8.f.a();
            return 0;
        }
        if (((String) obj).equals("uptodown_protect")) {
            return 3;
        }
        z8.f.a();
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        viewHolder.getClass();
        if (viewHolder instanceof y5.s0) {
            y5.s0 s0Var = (y5.s0) viewHolder;
            Object obj = a().get(i10);
            obj.getClass();
            h5.f fVar = (h5.f) obj;
            Context context = s0Var.f14004b;
            ConcurrentHashMap concurrentHashMap = v5.n.f13169a;
            s0Var.f14005c.setImageDrawable(v5.n.c(context, fVar.f8526c));
            s0Var.f14006d.setText(fVar.f8525b);
            s0Var.e.setText(fVar.e);
            if (fVar.f8539u != null) {
                String string = context.getString(R.string.x_positives);
                string.getClass();
                h5.f0 f0Var = fVar.f8539u;
                f0Var.getClass();
                s0Var.f.setText(String.format(string, Arrays.copyOf(new Object[]{String.valueOf(f0Var.f8544a)}, 1)));
                return;
            }
            return;
        }
        if (!(viewHolder instanceof s1)) {
            com.google.gson.internal.a.n("ViewHolder unknown!!");
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = a().iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            if (next instanceof h5.f) {
                arrayList.add(next);
            }
        }
        s1 s1Var = (s1) viewHolder;
        TextView textView = s1Var.e;
        TextView textView2 = s1Var.f14011d;
        ImageView imageView = s1Var.f14010c;
        ImageView imageView2 = s1Var.g;
        Context context2 = this.f11434a;
        context2.getClass();
        s1Var.f14009b.setVisibility(0);
        RelativeLayout relativeLayout = s1Var.f;
        relativeLayout.setOnClickListener(new y5.i0(8, s1Var, context2));
        if (arrayList.size() > 0) {
            imageView.setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.vector_shield_protect_bad));
            textView2.setText(R.string.positives_title_security_badge);
            textView.setText(R.string.positives_msg_security_badge);
            relativeLayout.setBackground(ContextCompat.getDrawable(context2, R.drawable.ripple_cancel_button));
            s1Var.itemView.setOnClickListener(new y5.p(s1Var, 4));
        } else {
            imageView.setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.vector_shield_protect_ok));
            textView2.setText(R.string.no_positives_title_security_badge);
            textView.setText(R.string.no_positives_msg_security_badge);
            relativeLayout.setBackground(ContextCompat.getDrawable(context2, R.drawable.ripple_blue_primary_button));
            s1Var.itemView.setOnClickListener(new e5.n(29));
        }
        if (imageView2.getAnimation() == null || imageView2.getAnimation().getRepeatCount() == 0) {
            return;
        }
        imageView2.getAnimation().setRepeatCount(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        if (i10 == 0) {
            return new y5.s0(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.app_positive, viewGroup, false), this.f11435b, this.f11434a);
        }
        if (i10 == 3) {
            return new s1(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.uptodown_protect, viewGroup, false), this.f11436c);
        }
        com.google.gson.internal.a.n("viewType unknown");
        return null;
    }
}
