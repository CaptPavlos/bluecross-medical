package l4;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.RecommendedActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class d7 implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10330a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecommendedActivity f10331b;

    public /* synthetic */ d7(RecommendedActivity recommendedActivity, int i10) {
        this.f10330a = i10;
        this.f10331b = recommendedActivity;
    }

    @Override // g7.a
    public final Object invoke() {
        int i10 = this.f10330a;
        s6.w wVar = s6.w.f12711a;
        RecommendedActivity recommendedActivity = this.f10331b;
        switch (i10) {
            case 0:
                int i11 = RecommendedActivity.Z;
                View viewInflate = recommendedActivity.getLayoutInflater().inflate(R.layout.recommended_activity, (ViewGroup) null, false);
                int i12 = R.id.loading_view_recommended;
                View viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, R.id.loading_view_recommended);
                if (viewFindChildViewById != null) {
                    i12 = R.id.rv_recommended;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate, R.id.rv_recommended);
                    if (recyclerView != null) {
                        i12 = R.id.s_list_state_recommended;
                        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(viewInflate, R.id.s_list_state_recommended);
                        if (switchCompat != null) {
                            i12 = R.id.toolbar_recommended;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(viewInflate, R.id.toolbar_recommended);
                            if (toolbar != null) {
                                i12 = R.id.tv_explore_recommended;
                                TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_explore_recommended);
                                if (textView != null) {
                                    i12 = R.id.tv_list_state_recommended;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_list_state_recommended);
                                    if (textView2 != null) {
                                        i12 = R.id.tv_no_items_recommended;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_no_items_recommended);
                                        if (textView3 != null) {
                                            i12 = R.id.tv_title_recommended;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_recommended);
                                            if (textView4 != null) {
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i12)));
                break;
            case 1:
                int i13 = RecommendedActivity.Z;
                Intent intent = new Intent(recommendedActivity, (Class<?>) LoginActivity.class);
                ActivityResultLauncher activityResultLauncher = recommendedActivity.Y;
                float f = UptodownApp.E;
                activityResultLauncher.launch(intent, k4.c.b(recommendedActivity));
                AlertDialog alertDialog = recommendedActivity.f10935w;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                    break;
                }
                break;
            default:
                int i14 = RecommendedActivity.Z;
                recommendedActivity.finish();
                break;
        }
        return wVar;
    }
}
