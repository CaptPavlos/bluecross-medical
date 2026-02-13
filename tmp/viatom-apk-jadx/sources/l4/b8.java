package l4;

import android.content.SharedPreferences;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.core.widget.NestedScrollView;
import com.uptodown.UptodownApp;
import com.uptodown.activities.ReviewsActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class b8 implements ActivityResultCallback, NestedScrollView.OnScrollChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReviewsActivity f10257a;

    public /* synthetic */ b8(ReviewsActivity reviewsActivity) {
        this.f10257a = reviewsActivity;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        SharedPreferences sharedPreferences;
        int i10 = ReviewsActivity.M;
        if (((ActivityResult) obj).getResultCode() == 1) {
            ReviewsActivity reviewsActivity = this.f10257a;
            SharedPreferences sharedPreferences2 = reviewsActivity.getSharedPreferences("SharedPreferencesUser", 0);
            try {
                sharedPreferences = reviewsActivity.getSharedPreferences("SettingsPreferences", 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String string = sharedPreferences.contains("UTOKEN") ? sharedPreferences.getString("UTOKEN", null) : null;
            if (string == null && sharedPreferences2.getString("is_turbo", null) == null) {
                return;
            }
            float f = UptodownApp.E;
            k4.c.B(reviewsActivity);
            k4.c.A(reviewsActivity);
            reviewsActivity.r0(reviewsActivity.n0().f7350b.getText().toString());
        }
    }

    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
    public void onScrollChange(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
        int i14 = ReviewsActivity.M;
        nestedScrollView.getClass();
        if (i11 == nestedScrollView.getChildAt(0).getMeasuredHeight() - nestedScrollView.getMeasuredHeight()) {
            ReviewsActivity reviewsActivity = this.f10257a;
            if (reviewsActivity.p0().f10565n || !reviewsActivity.p0().f10564m) {
                return;
            }
            reviewsActivity.p0().f10565n = true;
            n4.i0 i0Var = reviewsActivity.J;
            if (i0Var != null) {
                i0Var.f11377d = true;
                i0Var.notifyItemInserted(i0Var.getItemCount());
            }
            reviewsActivity.o0();
        }
    }
}
