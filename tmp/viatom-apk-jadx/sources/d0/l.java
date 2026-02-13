package d0;

import android.os.Bundle;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l implements LoaderManager.LoaderCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SignInHubActivity f6783a;

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final Loader onCreateLoader(int i10, Bundle bundle) {
        return new d(this.f6783a, g0.g.a());
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        SignInHubActivity signInHubActivity = this.f6783a;
        signInHubActivity.setResult(signInHubActivity.f1852d, signInHubActivity.e);
        signInHubActivity.finish();
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final void onLoaderReset(Loader loader) {
    }
}
