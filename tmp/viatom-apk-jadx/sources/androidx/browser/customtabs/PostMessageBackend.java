package androidx.browser.customtabs;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public interface PostMessageBackend {
    void onDisconnectChannel(@NonNull Context context);

    boolean onNotifyMessageChannelReady(@Nullable Bundle bundle);

    boolean onPostMessage(@NonNull String str, @Nullable Bundle bundle);
}
