package l4;

import androidx.appcompat.widget.SearchView;
import com.uptodown.activities.MyDownloads;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k4 implements SearchView.OnQueryTextListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MyDownloads f10548a;

    public k4(MyDownloads myDownloads) {
        this.f10548a = myDownloads;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public final boolean onQueryTextChange(String str) {
        str.getClass();
        int i10 = MyDownloads.O;
        MyDownloads myDownloads = this.f10548a;
        myDownloads.q0().e = str;
        myDownloads.r0(false);
        return false;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public final boolean onQueryTextSubmit(String str) {
        str.getClass();
        int i10 = MyDownloads.O;
        MyDownloads myDownloads = this.f10548a;
        myDownloads.q0().e = str;
        myDownloads.r0(false);
        return true;
    }
}
