package h0;

import androidx.fragment.app.Fragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import com.uptodown.activities.MyDownloads;
import com.uptodown.tv.ui.activity.TvMyDownloadsActivity;
import com.uptodown.tv.ui.activity.TvOldVersionsActivity;
import com.uptodown.tv.ui.fragment.TvMyDownloadsFragment;
import com.uptodown.tv.ui.fragment.TvOldVersionsFragment;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8377a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8378b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8379c;

    public /* synthetic */ m(Object obj, int i10, int i11) {
        this.f8377a = i11;
        this.f8379c = obj;
        this.f8378b = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8377a) {
            case 0:
                ((n) this.f8379c).i(this.f8378b);
                break;
            case 1:
                MyDownloads myDownloads = (MyDownloads) this.f8379c;
                int i10 = this.f8378b;
                if (i10 != 302 && i10 != 352) {
                    n4.b bVar = myDownloads.J;
                    if (bVar != null) {
                        bVar.notifyDataSetChanged();
                        break;
                    }
                } else {
                    myDownloads.r0(false);
                    break;
                }
                break;
            case 2:
                List<Fragment> fragments = ((TvMyDownloadsActivity) this.f8379c).getSupportFragmentManager().getFragments();
                fragments.getClass();
                if (fragments.size() > 0) {
                    Fragment fragment = fragments.get(0);
                    if (fragment instanceof TvMyDownloadsFragment) {
                        TvMyDownloadsFragment tvMyDownloadsFragment = (TvMyDownloadsFragment) fragment;
                        switch (this.f8378b) {
                            case 201:
                                ArrayObjectAdapter arrayObjectAdapter = tvMyDownloadsFragment.f6712a;
                                arrayObjectAdapter.getClass();
                                ArrayObjectAdapter arrayObjectAdapter2 = tvMyDownloadsFragment.f6712a;
                                arrayObjectAdapter2.getClass();
                                arrayObjectAdapter.notifyArrayItemRangeChanged(0, arrayObjectAdapter2.size());
                                break;
                            case 202:
                            case 203:
                                ArrayObjectAdapter arrayObjectAdapter3 = tvMyDownloadsFragment.f6712a;
                                arrayObjectAdapter3.getClass();
                                ArrayObjectAdapter arrayObjectAdapter4 = tvMyDownloadsFragment.f6712a;
                                arrayObjectAdapter4.getClass();
                                arrayObjectAdapter3.notifyArrayItemRangeChanged(0, arrayObjectAdapter4.size());
                                break;
                        }
                    }
                }
                break;
            default:
                List<Fragment> fragments2 = ((TvOldVersionsActivity) this.f8379c).getSupportFragmentManager().getFragments();
                fragments2.getClass();
                if (fragments2.size() > 0) {
                    Fragment fragment2 = fragments2.get(0);
                    if (fragment2 instanceof TvOldVersionsFragment) {
                        TvOldVersionsFragment tvOldVersionsFragment = (TvOldVersionsFragment) fragment2;
                        switch (this.f8378b) {
                            case 201:
                                s5.w wVar = tvOldVersionsFragment.f6718d;
                                wVar.getClass();
                                s5.w wVar2 = tvOldVersionsFragment.f6718d;
                                wVar2.getClass();
                                wVar.notifyArrayItemRangeChanged(0, wVar2.size());
                                break;
                            case 202:
                            case 203:
                                s5.w wVar3 = tvOldVersionsFragment.f6718d;
                                wVar3.getClass();
                                s5.w wVar4 = tvOldVersionsFragment.f6718d;
                                wVar4.getClass();
                                wVar3.notifyArrayItemRangeChanged(0, wVar4.size());
                                break;
                        }
                    }
                }
                break;
        }
    }
}
