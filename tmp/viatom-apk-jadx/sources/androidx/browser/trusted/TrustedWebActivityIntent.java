package androidx.browser.trusted;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class TrustedWebActivityIntent {

    @NonNull
    private final Intent mIntent;

    @NonNull
    private final List<Uri> mSharedFileUris;

    public TrustedWebActivityIntent(@NonNull Intent intent, @NonNull List<Uri> list) {
        this.mIntent = intent;
        this.mSharedFileUris = list;
    }

    private void grantUriPermissionToProvider(Context context) {
        Iterator<Uri> it = this.mSharedFileUris.iterator();
        while (it.hasNext()) {
            context.grantUriPermission(this.mIntent.getPackage(), it.next(), 1);
        }
    }

    @NonNull
    public Intent getIntent() {
        return this.mIntent;
    }

    public void launchTrustedWebActivity(@NonNull Context context) {
        grantUriPermissionToProvider(context);
        ContextCompat.startActivity(context, this.mIntent, null);
    }
}
