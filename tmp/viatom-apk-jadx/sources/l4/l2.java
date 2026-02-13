package l4;

import android.content.SharedPreferences;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l2 implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10586a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f10587b;

    public /* synthetic */ l2(int i10, MainActivity mainActivity) {
        this.f10586a = i10;
        this.f10587b = mainActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        int i10 = this.f10586a;
        int i11 = -1;
        boolean z9 = true;
        MainActivity mainActivity = this.f10587b;
        animation.getClass();
        switch (i10) {
            case 0:
                ArrayList arrayList = mainActivity.N;
                int i12 = mainActivity.M;
                if (i12 > 0 && i12 < arrayList.size()) {
                    i11 = (-1) + mainActivity.M;
                    mainActivity.M = i11;
                }
                if (i11 < 0 || i11 >= arrayList.size()) {
                    ((h5.m1) arrayList.get(mainActivity.M)).a().setVisibility(8);
                    mainActivity.finish();
                } else {
                    RelativeLayout relativeLayout = mainActivity.P;
                    if (relativeLayout != null) {
                        relativeLayout.removeAllViews();
                    }
                    RelativeLayout relativeLayoutA = ((h5.m1) arrayList.get(i11)).a();
                    RelativeLayout relativeLayout2 = mainActivity.P;
                    if (relativeLayout2 != null) {
                        relativeLayout2.addView(relativeLayoutA);
                    }
                    float f = UptodownApp.E;
                    try {
                        SharedPreferences sharedPreferences = mainActivity.getSharedPreferences("SettingsPreferences", 0);
                        if (sharedPreferences.contains("animations")) {
                            z9 = sharedPreferences.getBoolean("animations", true);
                        }
                    } catch (Exception unused) {
                    }
                    if (z9) {
                        float f10 = UptodownApp.E;
                        relativeLayoutA.startAnimation(AnimationUtils.loadAnimation(mainActivity, R.anim.slide_back_in));
                        relativeLayoutA.setVisibility(0);
                    } else {
                        relativeLayoutA.setVisibility(0);
                    }
                }
                mainActivity.O = false;
                break;
            case 1:
                ArrayList arrayList2 = mainActivity.N;
                int i13 = mainActivity.M;
                if (i13 >= 0 && i13 < arrayList2.size() - 1) {
                    i11 = mainActivity.M + 1;
                    mainActivity.M = i11;
                }
                if (i11 >= 0 && i11 < arrayList2.size()) {
                    Object obj = arrayList2.get(i11);
                    obj.getClass();
                    mainActivity.W0((h5.m1) obj);
                    if (((h5.m1) arrayList2.get(mainActivity.M)).f8665a == 2 && ((h5.m1) arrayList2.get(0)).f8665a == 1) {
                        ((h5.m1) arrayList2.get(0)).a().removeAllViews();
                        arrayList2.remove(0);
                        mainActivity.M = 0;
                    }
                    mainActivity.f1();
                    break;
                } else {
                    mainActivity.R0();
                    break;
                }
                break;
            case 2:
                FrameLayout frameLayout = mainActivity.f6645p0;
                frameLayout.getClass();
                frameLayout.removeAllViews();
                break;
            case 3:
                FrameLayout frameLayout2 = mainActivity.f6647r0;
                frameLayout2.getClass();
                frameLayout2.removeAllViews();
                mainActivity.f6647r0 = null;
                break;
            default:
                RelativeLayout relativeLayout3 = mainActivity.L;
                if (relativeLayout3 != null) {
                    relativeLayout3.removeAllViews();
                    RelativeLayout relativeLayout4 = mainActivity.L;
                    if (relativeLayout4 != null) {
                        relativeLayout4.setVisibility(8);
                    }
                    mainActivity.L = null;
                }
                mainActivity.Q0();
                break;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i10 = this.f10586a;
        animation.getClass();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        int i10 = this.f10586a;
        animation.getClass();
        switch (i10) {
            case 0:
                this.f10587b.O = true;
                break;
        }
    }
}
