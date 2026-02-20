package androidx.browser.trusted;

import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class Token {
    private static final String TAG = "Token";

    @NonNull
    private final TokenContents mContents;

    private Token(@NonNull TokenContents tokenContents) {
        this.mContents = tokenContents;
    }

    @Nullable
    public static Token create(@NonNull String str, @NonNull PackageManager packageManager) {
        List<byte[]> fingerprintsForPackage = PackageIdentityUtils.getFingerprintsForPackage(str, packageManager);
        if (fingerprintsForPackage == null) {
            return null;
        }
        try {
            return new Token(TokenContents.create(str, fingerprintsForPackage));
        } catch (IOException e) {
            Log.e(TAG, "Exception when creating token.", e);
            return null;
        }
    }

    @NonNull
    public static Token deserialize(@NonNull byte[] bArr) {
        return new Token(TokenContents.deserialize(bArr));
    }

    public boolean matches(@NonNull String str, @NonNull PackageManager packageManager) {
        return PackageIdentityUtils.packageMatchesToken(str, packageManager, this.mContents);
    }

    @NonNull
    public byte[] serialize() {
        return this.mContents.serialize();
    }
}
