package m4;

import android.app.Activity;
import android.content.Context;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class d extends AppCompatActivity {
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        if (context != null) {
            Activity activity = o4.b.g;
            context = r0.f.h(context);
        }
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.right_to_left_out);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        menuItem.getClass();
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}
