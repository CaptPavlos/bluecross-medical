package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.window.layout.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Deprecated
/* loaded from: classes.dex */
public class BrowserActionItem {

    @Nullable
    private final PendingIntent mAction;

    @DrawableRes
    private int mIconId;

    @Nullable
    private Uri mIconUri;

    @Nullable
    private Runnable mRunnableAction;
    private final String mTitle;

    public BrowserActionItem(@NonNull String str, @NonNull Runnable runnable) {
        this.mTitle = str;
        this.mAction = null;
        this.mRunnableAction = runnable;
    }

    @NonNull
    public PendingIntent getAction() {
        PendingIntent pendingIntent = this.mAction;
        if (pendingIntent != null) {
            return pendingIntent;
        }
        c.g("Can't call getAction on BrowserActionItem with null action.");
        return null;
    }

    public int getIconId() {
        return this.mIconId;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Uri getIconUri() {
        return this.mIconUri;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Runnable getRunnableAction() {
        return this.mRunnableAction;
    }

    @NonNull
    public String getTitle() {
        return this.mTitle;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public BrowserActionItem(@NonNull String str, @NonNull PendingIntent pendingIntent, @NonNull Uri uri) {
        this.mTitle = str;
        this.mAction = pendingIntent;
        this.mIconUri = uri;
    }

    public BrowserActionItem(@NonNull String str, @NonNull PendingIntent pendingIntent, @DrawableRes int i10) {
        this.mTitle = str;
        this.mAction = pendingIntent;
        this.mIconId = i10;
    }

    public BrowserActionItem(@NonNull String str, @NonNull PendingIntent pendingIntent) {
        this(str, pendingIntent, 0);
    }
}
