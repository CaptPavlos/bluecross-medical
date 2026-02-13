package l4;

import androidx.appcompat.widget.SearchView;
import com.uptodown.activities.MyApps;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k3 implements SearchView.OnQueryTextListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MyApps f10547a;

    public k3(MyApps myApps) {
        this.f10547a = myApps;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public final boolean onQueryTextChange(String str) {
        str.getClass();
        int i10 = MyApps.f6655j0;
        MyApps myApps = this.f10547a;
        myApps.F0().f10288d = str;
        myApps.G0(true);
        return false;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public final boolean onQueryTextSubmit(String str) {
        str.getClass();
        int i10 = MyApps.f6655j0;
        MyApps myApps = this.f10547a;
        myApps.F0().f10288d = str;
        myApps.G0(true);
        return true;
    }
}
