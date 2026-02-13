package z5;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.HashMap;
import java.util.Locale;
import y5.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f14442a;

    /* renamed from: b, reason: collision with root package name */
    public final j f14443b;

    public m(HashMap map, j jVar) {
        this.f14442a = map;
        this.f14443b = jVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f14442a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        String string;
        l lVar = (l) viewHolder;
        lVar.getClass();
        a4.f fVar = lVar.f14441a;
        String str = (String) this.f14442a.get(Integer.valueOf(i10));
        if (str == null || str.length() == 0) {
            return;
        }
        TextView textView = (TextView) fVar.f219c;
        if (str.length() > 0) {
            StringBuilder sb = new StringBuilder();
            String strValueOf = String.valueOf(str.charAt(0));
            strValueOf.getClass();
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            upperCase.getClass();
            sb.append((Object) upperCase);
            sb.append(str.substring(1));
            string = sb.toString();
        } else {
            string = str;
        }
        textView.setText(string);
        ((TextView) fVar.f219c).setTypeface(o4.b.f11720s);
        lVar.itemView.setOnClickListener(new t(i10, this, 2, str));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.dropdown_option_item, viewGroup, false);
        if (viewG != null) {
            TextView textView = (TextView) viewG;
            return new l(new a4.f(textView, textView, 11, false));
        }
        androidx.window.layout.c.k("rootView");
        return null;
    }
}
