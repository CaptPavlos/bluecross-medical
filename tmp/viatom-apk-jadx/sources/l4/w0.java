package l4;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.Gallery;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class w0 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10938a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Gallery f10939b;

    public /* synthetic */ w0(Gallery gallery, int i10) {
        this.f10938a = i10;
        this.f10939b = gallery;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Resources.NotFoundException {
        int i10 = this.f10938a;
        Gallery gallery = this.f10939b;
        switch (i10) {
            case 0:
                gallery.J.handleOnBackPressed();
                break;
            default:
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    int i11 = Gallery.K;
                    boolean z9 = true;
                    if (gallery.n0().f7293c.getVisibility() != 0) {
                        RelativeLayout relativeLayout = gallery.n0().f7293c;
                        try {
                            SharedPreferences sharedPreferences = gallery.getSharedPreferences("SettingsPreferences", 0);
                            if (sharedPreferences.contains("animations")) {
                                z9 = sharedPreferences.getBoolean("animations", true);
                            }
                        } catch (Exception unused) {
                        }
                        if (!z9) {
                            relativeLayout.setVisibility(0);
                            break;
                        } else {
                            float f10 = UptodownApp.E;
                            relativeLayout.startAnimation(AnimationUtils.loadAnimation(gallery, R.anim.slide_in_top_toolbar));
                            relativeLayout.setVisibility(0);
                            break;
                        }
                    } else {
                        RelativeLayout relativeLayout2 = gallery.n0().f7293c;
                        try {
                            SharedPreferences sharedPreferences2 = gallery.getSharedPreferences("SettingsPreferences", 0);
                            if (sharedPreferences2.contains("animations")) {
                                z9 = sharedPreferences2.getBoolean("animations", true);
                            }
                        } catch (Exception unused2) {
                        }
                        if (!z9) {
                            relativeLayout2.setVisibility(8);
                            break;
                        } else {
                            float f11 = UptodownApp.E;
                            relativeLayout2.startAnimation(AnimationUtils.loadAnimation(gallery, R.anim.slide_to_top_toolbar));
                            relativeLayout2.setVisibility(8);
                            break;
                        }
                    }
                }
                break;
        }
    }
}
