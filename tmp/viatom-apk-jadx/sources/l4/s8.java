package l4;

import android.content.Context;
import android.widget.Filter;
import com.uptodown.activities.SearchActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s8 extends Filter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchActivity f10823a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t8 f10824b;

    public s8(SearchActivity searchActivity, t8 t8Var) {
        this.f10823a = searchActivity;
        this.f10824b = t8Var;
    }

    @Override // android.widget.Filter
    public final CharSequence convertResultToString(Object obj) {
        obj.getClass();
        String str = ((h5.i0) obj).f8614a;
        str.getClass();
        return str;
    }

    @Override // android.widget.Filter
    public final Filter.FilterResults performFiltering(CharSequence charSequence) {
        charSequence.getClass();
        t3.h hVar = v5.g.f13148u;
        Context applicationContext = this.f10823a.getApplicationContext();
        applicationContext.getClass();
        v5.g gVarL = hVar.l(applicationContext);
        gVarL.a();
        ArrayList arrayListJ = gVarL.J();
        gVarL.b();
        if (charSequence.length() > 0) {
            ArrayList arrayList = new ArrayList();
            int size = arrayListJ.size();
            for (int i10 = 0; i10 < size; i10++) {
                String str = ((h5.i0) arrayListJ.get(i10)).f8614a;
                if (str != null && o7.m.d0(str, charSequence, false)) {
                    arrayList.add(arrayListJ.get(i10));
                }
            }
            arrayListJ = arrayList;
        }
        Filter.FilterResults filterResults = new Filter.FilterResults();
        filterResults.values = arrayListJ;
        filterResults.count = arrayListJ.size();
        return filterResults;
    }

    @Override // android.widget.Filter
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        charSequence.getClass();
        filterResults.getClass();
        t8 t8Var = this.f10824b;
        t8Var.clear();
        Object obj = filterResults.values;
        obj.getClass();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            t8Var.add((h5.i0) it.next());
        }
        int i10 = filterResults.count;
        t8 t8Var2 = this.f10823a.L;
        if (i10 > 0) {
            t8Var2.getClass();
            t8Var2.notifyDataSetChanged();
        } else {
            t8Var2.getClass();
            t8Var2.notifyDataSetInvalidated();
        }
    }
}
