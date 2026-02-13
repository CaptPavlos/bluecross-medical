package i4;

import a3.i0;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends WebChromeClient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f8997a;

    public e(f fVar) {
        this.f8997a = fVar;
    }

    @Override // android.webkit.WebChromeClient
    public final Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
        if (defaultVideoPoster != null) {
            return defaultVideoPoster;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
        bitmapCreateBitmap.getClass();
        return bitmapCreateBitmap;
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        super.onHideCustomView();
        this.f8997a.f8998a.b();
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        view.getClass();
        customViewCallback.getClass();
        super.onShowCustomView(view, customViewCallback);
        this.f8997a.f8998a.a(view, new i0(customViewCallback, 16));
    }
}
