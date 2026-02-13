package r5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import com.uptodown.UptodownApp;
import com.uptodown.tv.ui.activity.TvAppDetailActivity;
import com.uptodown.tv.ui.activity.TvSearchActivity;
import h5.h;
import r0.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class b extends FragmentActivity {

    /* renamed from: a, reason: collision with root package name */
    public t1.c f12383a;

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        if (context != null) {
            Activity activity = o4.b.g;
            context = f.h(context);
        }
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getSource() != 8194) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return true;
    }

    public final void i(h hVar, Presenter.ViewHolder viewHolder) {
        hVar.getClass();
        Intent intent = new Intent(this, (Class<?>) TvAppDetailActivity.class);
        intent.putExtra("appInfo", hVar);
        View view = viewHolder.view;
        ImageCardView imageCardView = view instanceof ImageCardView ? (ImageCardView) view : null;
        ImageView mainImageView = imageCardView != null ? imageCardView.getMainImageView() : null;
        float f = UptodownApp.E;
        boolean z9 = true;
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("animations")) {
                z9 = sharedPreferences.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (!z9 || mainImageView == null) {
            startActivity(intent);
        } else {
            startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, mainImageView, "transition_name").toBundle());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f12383a = new t1.c(this, 4);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onSearchRequested() {
        startActivity(new Intent(this, (Class<?>) TvSearchActivity.class));
        return true;
    }
}
