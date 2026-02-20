package l4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.uptodown.R;
import com.uptodown.activities.SearchActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t8 extends ArrayAdapter implements Filterable {

    /* renamed from: a, reason: collision with root package name */
    public final LayoutInflater f10851a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchActivity f10852b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t8(SearchActivity searchActivity, SearchActivity searchActivity2) {
        super(searchActivity2, -1);
        this.f10852b = searchActivity;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(searchActivity2);
        layoutInflaterFrom.getClass();
        this.f10851a = layoutInflaterFrom;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Filterable
    public final Filter getFilter() {
        return new s8(this.f10852b, this);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i10, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout;
        viewGroup.getClass();
        h5.i0 i0Var = (h5.i0) getItem(i10);
        LayoutInflater layoutInflater = this.f10851a;
        if (i0Var == null) {
            View viewInflate = layoutInflater.inflate(R.layout.recent_search_item, viewGroup, false);
            viewInflate.getClass();
            return (LinearLayout) viewInflate;
        }
        if (view != null) {
            linearLayout = (LinearLayout) view;
        } else {
            View viewInflate2 = layoutInflater.inflate(R.layout.recent_search_item, viewGroup, false);
            viewInflate2.getClass();
            linearLayout = (LinearLayout) viewInflate2;
        }
        TextView textView = (TextView) linearLayout.findViewById(R.id.tv_query_recent_search_item);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.iv_delete_recent_search_item);
        imageView.setTag(i0Var.f8614a);
        imageView.setOnClickListener(new q8(this.f10852b, 3));
        textView.setTypeface(o4.b.f11720s);
        textView.setText(i0Var.f8614a);
        return linearLayout;
    }
}
