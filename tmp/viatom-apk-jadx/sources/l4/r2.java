package l4;

import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.uptodown.R;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r2 implements TabLayout.OnTabSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainActivity f10784a;

    public r2(MainActivity mainActivity) {
        this.f10784a = mainActivity;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(TabLayout.Tab tab) {
        e5.m1 m1Var;
        tab.getClass();
        int position = tab.getPosition();
        MainActivity mainActivity = this.f10784a;
        if (position == 0) {
            int i10 = MainActivity.B0;
            mainActivity.X0();
            e5.t1 t1Var = mainActivity.f6641k0;
            if (t1Var != null) {
                t1Var.b().f7348d.smoothScrollToPosition(0);
                return;
            }
            return;
        }
        if (position == 1) {
            int i11 = MainActivity.B0;
            mainActivity.X0();
            e5.n1 n1Var = mainActivity.Z;
            if (n1Var != null) {
                n1Var.f().smoothScrollToPosition(0);
                return;
            }
            return;
        }
        if (position != 2) {
            if (position == 3 && (m1Var = mainActivity.l0) != null) {
                m1Var.a().g.smoothScrollToPosition(0);
                return;
            }
            return;
        }
        int i12 = MainActivity.B0;
        mainActivity.X0();
        if (mainActivity.getSupportFragmentManager().getBackStackEntryCount() > 0) {
            mainActivity.getSupportFragmentManager().popBackStackImmediate("appsCategory", 1);
            return;
        }
        e5.d1 d1Var = mainActivity.f6640j0;
        if (d1Var != null) {
            d1Var.f().smoothScrollToPosition(0);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(TabLayout.Tab tab) {
        tab.getClass();
        MainActivity mainActivity = this.f10784a;
        ViewPager2 viewPager2 = mainActivity.U;
        viewPager2.getClass();
        viewPager2.setCurrentItem(tab.getPosition(), false);
        mainActivity.P0();
        mainActivity.X0();
        int position = tab.getPosition();
        if (position == 0) {
            MainActivity.x0(mainActivity, "home");
            return;
        }
        if (position == 1) {
            MainActivity.x0(mainActivity, "games");
            return;
        }
        if (position == 2) {
            MainActivity.x0(mainActivity, "apps");
            return;
        }
        if (position != 3) {
            return;
        }
        AppBarLayout appBarLayout = mainActivity.Q;
        appBarLayout.getClass();
        appBarLayout.setVisibility(0);
        AppBarLayout appBarLayout2 = mainActivity.Q;
        appBarLayout2.getClass();
        appBarLayout2.setExpanded(false, false);
        MainActivity.x0(mainActivity, "feed");
        TabLayout tabLayout = mainActivity.Y;
        tabLayout.getClass();
        TabLayout.Tab tabAt = tabLayout.getTabAt(3);
        if (tabAt != null) {
            tabAt.setIcon(ContextCompat.getDrawable(mainActivity, R.drawable.selector_icon_tab_feed));
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(TabLayout.Tab tab) {
        tab.getClass();
    }
}
