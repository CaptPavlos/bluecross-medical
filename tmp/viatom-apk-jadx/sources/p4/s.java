package p4;

import androidx.appcompat.widget.SearchView;
import com.uptodown.core.activities.FileExplorerActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s implements SearchView.OnQueryTextListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f12014a;

    public s(FileExplorerActivity fileExplorerActivity) {
        this.f12014a = fileExplorerActivity;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public final boolean onQueryTextChange(String str) {
        str.getClass();
        int i10 = FileExplorerActivity.f6665q0;
        this.f12014a.U(str, null);
        return false;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public final boolean onQueryTextSubmit(String str) {
        str.getClass();
        int i10 = FileExplorerActivity.f6665q0;
        this.f12014a.U(str, null);
        return true;
    }
}
