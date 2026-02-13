package l4;

import android.content.Intent;
import android.view.View;
import com.uptodown.UptodownApp;
import com.uptodown.activities.FeedActivity;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.WishlistActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class n6 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10655a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f10656b;

    public /* synthetic */ n6(PublicProfileActivity publicProfileActivity, int i10) {
        this.f10655a = i10;
        this.f10656b = publicProfileActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f10655a;
        PublicProfileActivity publicProfileActivity = this.f10656b;
        switch (i10) {
            case 0:
                int i11 = PublicProfileActivity.K;
                publicProfileActivity.finish();
                break;
            case 1:
                int i12 = PublicProfileActivity.K;
                Intent intent = new Intent(publicProfileActivity, (Class<?>) FeedActivity.class);
                float f = UptodownApp.E;
                publicProfileActivity.startActivity(intent, k4.c.a(publicProfileActivity));
                break;
            case 2:
                int i13 = PublicProfileActivity.K;
                publicProfileActivity.setResult(1);
                publicProfileActivity.finish();
                break;
            case 3:
                int i14 = PublicProfileActivity.K;
                publicProfileActivity.setResult(1);
                publicProfileActivity.finish();
                break;
            case 4:
                publicProfileActivity.startActivity(new Intent(publicProfileActivity, (Class<?>) WishlistActivity.class));
                break;
            default:
                int i15 = PublicProfileActivity.K;
                publicProfileActivity.setResult(1);
                publicProfileActivity.finish();
                break;
        }
    }
}
