package e5;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppFilesActivity;
import com.uptodown.activities.CustomWebView;
import com.uptodown.activities.FeedActivity;
import com.uptodown.activities.FollowListActivity;
import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.activities.Gallery;
import com.uptodown.activities.LanguageSettingsActivity;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.MyStatsActivity;
import com.uptodown.activities.NotificationsRegistryActivity;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.OrganizationActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.UserCommentsActivity;
import com.uptodown.activities.UserDevicesActivity;
import com.uptodown.tv.ui.activity.TvMainActivity;
import com.uptodown.tv.ui.activity.TvSearchActivity;
import com.uptodown.workers.DownloadWorker;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class s implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7849a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7850b;

    public /* synthetic */ s(Object obj, int i10) {
        this.f7849a = i10;
        this.f7850b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        s5.s sVar;
        FragmentManager supportFragmentManager;
        FragmentManager supportFragmentManager2;
        FragmentTransaction fragmentTransactionBeginTransaction;
        FragmentTransaction fragmentTransactionRemove;
        FragmentActivity activity;
        FragmentManager supportFragmentManager3;
        FragmentTransaction fragmentTransactionBeginTransaction2;
        FragmentTransaction fragmentTransactionReplace;
        FragmentTransaction fragmentTransactionAddToBackStack;
        int bindingAdapterPosition;
        int i10 = this.f7849a;
        Object obj = this.f7850b;
        switch (i10) {
            case 0:
                if (((d5.k) obj).f7146c.getVisibility() == 0) {
                    DownloadWorker.f = false;
                    DownloadWorker.e = false;
                    return;
                }
                return;
            case 1:
                h1 h1Var = (h1) obj;
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    h1Var.i().setVisibility(8);
                    h1Var.d().setVisibility(0);
                    h1Var.e().setVisibility(8);
                    h1Var.g = false;
                    h1Var.c();
                    return;
                }
                return;
            case 2:
                t1 t1Var = (t1) obj;
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    t1Var.b().f7347c.setVisibility(0);
                    t1Var.b().f7346b.setVisibility(8);
                    t1Var.c();
                    return;
                }
                return;
            case 3:
                ((g6.d) obj).dismiss();
                return;
            case 4:
                ((k6.c) obj).dismiss();
                return;
            case 5:
                AppFilesActivity appFilesActivity = (AppFilesActivity) obj;
                int i11 = AppFilesActivity.L;
                float f11 = UptodownApp.E;
                if (k4.c.s()) {
                    appFilesActivity.getOnBackPressedDispatcher().onBackPressed();
                    return;
                }
                return;
            case 6:
                int i12 = CustomWebView.J;
                ((CustomWebView) obj).getOnBackPressedDispatcher().onBackPressed();
                return;
            case 7:
                int i13 = FeedActivity.L;
                ((FeedActivity) obj).finish();
                return;
            case 8:
                int i14 = FollowListActivity.L;
                ((FollowListActivity) obj).finish();
                return;
            case 9:
                int i15 = FreeUpSpaceActivity.M;
                ((FreeUpSpaceActivity) obj).finish();
                return;
            case 10:
                int i16 = LanguageSettingsActivity.L;
                ((LanguageSettingsActivity) obj).getOnBackPressedDispatcher().onBackPressed();
                return;
            case 11:
                l4.b2 b2Var = (l4.b2) obj;
                b2Var.t0();
                c0.a aVar = b2Var.H;
                aVar.getClass();
                b2Var.I.launch(aVar.b());
                return;
            case 12:
                int i17 = MoreInfo.P;
                TextView textView = ((d5.u) obj).f7366c;
                if (textView.getMaxLines() == 1) {
                    textView.setMaxLines(Integer.MAX_VALUE);
                    return;
                } else {
                    textView.setMaxLines(1);
                    return;
                }
            case 13:
                int i18 = MyStatsActivity.K;
                ((MyStatsActivity) obj).getOnBackPressedDispatcher().onBackPressed();
                return;
            case 14:
                int i19 = NotificationsRegistryActivity.M;
                ((NotificationsRegistryActivity) obj).getOnBackPressedDispatcher().onBackPressed();
                return;
            case 15:
                int i20 = OldVersionsActivity.L;
                ((OldVersionsActivity) obj).getOnBackPressedDispatcher().onBackPressed();
                return;
            case 16:
                int i21 = OrganizationActivity.K;
                ((OrganizationActivity) obj).finish();
                return;
            case 17:
                int i22 = PublicListActivity.Y;
                ((PublicListActivity) obj).finish();
                return;
            case 18:
                int i23 = SecurityActivity.Z;
                ((SecurityActivity) obj).finish();
                return;
            case 19:
                int i24 = UserCommentsActivity.L;
                ((UserCommentsActivity) obj).getOnBackPressedDispatcher().onBackPressed();
                return;
            case 20:
                int i25 = UserDevicesActivity.K;
                ((UserDevicesActivity) obj).getOnBackPressedDispatcher().onBackPressed();
                return;
            case 21:
                view.getClass();
                g5.n nVar = ((n4.g1) obj).f11351c;
                Object tag = view.getTag();
                tag.getClass();
                nVar.K(((Integer) tag).intValue());
                return;
            case 22:
                n4.k1 k1Var = (n4.k1) obj;
                boolean z9 = k1Var.f11416m;
                e4.e eVar = k1Var.h;
                if (z9) {
                    if (eVar != null) {
                        ((i4.g) eVar).e();
                        return;
                    }
                    return;
                } else {
                    if (eVar != null) {
                        ((i4.g) eVar).f();
                        return;
                    }
                    return;
                }
            case 23:
                Fragment fragment = (s5.j) obj;
                if (fragment.getActivity() instanceof TvMainActivity) {
                    FragmentActivity activity2 = fragment.getActivity();
                    activity2.getClass();
                    sVar = ((TvMainActivity) activity2).f6690c;
                    if (sVar == null) {
                        kotlin.jvm.internal.l.i("tvMainFragment");
                        throw null;
                    }
                } else {
                    sVar = null;
                }
                if (sVar != null && (activity = fragment.getActivity()) != null && (supportFragmentManager3 = activity.getSupportFragmentManager()) != null && (fragmentTransactionBeginTransaction2 = supportFragmentManager3.beginTransaction()) != null && (fragmentTransactionReplace = fragmentTransactionBeginTransaction2.replace(R.id.fragmentContainer, sVar)) != null && (fragmentTransactionAddToBackStack = fragmentTransactionReplace.addToBackStack(null)) != null) {
                    fragmentTransactionAddToBackStack.commit();
                }
                FragmentActivity activity3 = fragment.getActivity();
                if (activity3 != null && (supportFragmentManager2 = activity3.getSupportFragmentManager()) != null && (fragmentTransactionBeginTransaction = supportFragmentManager2.beginTransaction()) != null && (fragmentTransactionRemove = fragmentTransactionBeginTransaction.remove(fragment)) != null) {
                    fragmentTransactionRemove.commit();
                }
                FragmentActivity activity4 = fragment.getActivity();
                if (activity4 == null || (supportFragmentManager = activity4.getSupportFragmentManager()) == null) {
                    return;
                }
                supportFragmentManager.popBackStack();
                return;
            case 24:
                s5.s sVar2 = (s5.s) obj;
                int i26 = s5.s.f12669c;
                sVar2.startActivity(new Intent(sVar2.getActivity(), (Class<?>) TvSearchActivity.class));
                return;
            case 25:
                Object tag2 = view.getTag();
                tag2.getClass();
                int iIntValue = ((Integer) tag2).intValue();
                Intent intent = new Intent(view.getContext(), (Class<?>) Gallery.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("images", ((h5.h) obj).O);
                bundle.putInt("index", iIntValue);
                intent.putExtra("bundle", bundle);
                view.getContext().startActivity(intent);
                return;
            case 26:
                ((AlertDialog) obj).dismiss();
                return;
            case 27:
                View view2 = (View) obj;
                ViewParent parent = view2.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(view2);
                    return;
                }
                return;
            case 28:
                ((i4.g) ((e4.e) obj)).f();
                return;
            default:
                y5.a aVar2 = (y5.a) obj;
                g5.b bVar = aVar2.f13794a;
                if (bVar == null || (bindingAdapterPosition = aVar2.getBindingAdapterPosition()) == -1) {
                    return;
                }
                bVar.a(bindingAdapterPosition);
                return;
        }
    }
}
