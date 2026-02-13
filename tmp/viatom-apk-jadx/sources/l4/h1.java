package l4;

import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import com.uptodown.UptodownApp;
import com.uptodown.activities.ListsActivity;
import com.uptodown.activities.PreregistrationActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.WishlistActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class h1 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10449a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ListsActivity f10450b;

    public /* synthetic */ h1(ListsActivity listsActivity, int i10) {
        this.f10449a = i10;
        this.f10450b = listsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f10449a;
        ListsActivity listsActivity = this.f10450b;
        switch (i10) {
            case 0:
                int i11 = ListsActivity.K;
                listsActivity.finish();
                break;
            case 1:
                Intent intent = new Intent(listsActivity, (Class<?>) WishlistActivity.class);
                ActivityResultLauncher activityResultLauncher = listsActivity.J;
                float f = UptodownApp.E;
                activityResultLauncher.launch(intent, k4.c.b(listsActivity));
                break;
            case 2:
                listsActivity.startActivity(new Intent(listsActivity, (Class<?>) RecommendedActivity.class));
                break;
            default:
                Intent intent2 = new Intent(listsActivity, (Class<?>) PreregistrationActivity.class);
                float f10 = UptodownApp.E;
                listsActivity.startActivity(intent2, k4.c.a(listsActivity));
                break;
        }
    }
}
