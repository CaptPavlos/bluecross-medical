package com.davemorrissey.labs.subscaleview;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.window.layout.c;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ImageSource {
    static final String ASSET_SCHEME = "file:///android_asset/";
    static final String FILE_SCHEME = "file:///";
    private final Bitmap bitmap;
    private boolean cached;
    private final Integer resource;
    private int sHeight;
    private Rect sRegion;
    private int sWidth;
    private boolean tile;
    private final Uri uri;

    private ImageSource(@NonNull Uri uri) {
        String string = uri.toString();
        if (string.startsWith(FILE_SCHEME) && !new File(string.substring(7)).exists()) {
            try {
                uri = Uri.parse(URLDecoder.decode(string, C.UTF8_NAME));
            } catch (UnsupportedEncodingException unused) {
            }
        }
        this.bitmap = null;
        this.uri = uri;
        this.resource = null;
        this.tile = true;
    }

    @NonNull
    public static ImageSource asset(@NonNull String str) {
        if (str != null) {
            return uri(ASSET_SCHEME.concat(str));
        }
        c.k("Asset name must not be null");
        return null;
    }

    @NonNull
    public static ImageSource bitmap(@NonNull Bitmap bitmap) {
        if (bitmap != null) {
            return new ImageSource(bitmap, false);
        }
        c.k("Bitmap must not be null");
        return null;
    }

    @NonNull
    public static ImageSource cachedBitmap(@NonNull Bitmap bitmap) {
        if (bitmap != null) {
            return new ImageSource(bitmap, true);
        }
        c.k("Bitmap must not be null");
        return null;
    }

    @NonNull
    public static ImageSource resource(int i10) {
        return new ImageSource(i10);
    }

    private void setInvariants() {
        Rect rect = this.sRegion;
        if (rect != null) {
            this.tile = true;
            this.sWidth = rect.width();
            this.sHeight = this.sRegion.height();
        }
    }

    @NonNull
    public static ImageSource uri(@NonNull String str) {
        if (str == null) {
            c.k("Uri must not be null");
            return null;
        }
        if (!str.contains("://")) {
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            str = FILE_SCHEME.concat(str);
        }
        return new ImageSource(Uri.parse(str));
    }

    @NonNull
    public ImageSource dimensions(int i10, int i11) {
        if (this.bitmap == null) {
            this.sWidth = i10;
            this.sHeight = i11;
        }
        setInvariants();
        return this;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final Integer getResource() {
        return this.resource;
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final Rect getSRegion() {
        return this.sRegion;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final boolean getTile() {
        return this.tile;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final boolean isCached() {
        return this.cached;
    }

    @NonNull
    public ImageSource region(Rect rect) {
        this.sRegion = rect;
        setInvariants();
        return this;
    }

    @NonNull
    public ImageSource tiling(boolean z9) {
        this.tile = z9;
        return this;
    }

    @NonNull
    public ImageSource tilingDisabled() {
        return tiling(false);
    }

    @NonNull
    public ImageSource tilingEnabled() {
        return tiling(true);
    }

    @NonNull
    public static ImageSource uri(@NonNull Uri uri) {
        if (uri != null) {
            return new ImageSource(uri);
        }
        c.k("Uri must not be null");
        return null;
    }

    private ImageSource(Bitmap bitmap, boolean z9) {
        this.bitmap = bitmap;
        this.uri = null;
        this.resource = null;
        this.tile = false;
        this.sWidth = bitmap.getWidth();
        this.sHeight = bitmap.getHeight();
        this.cached = z9;
    }

    private ImageSource(int i10) {
        this.bitmap = null;
        this.uri = null;
        this.resource = Integer.valueOf(i10);
        this.tile = true;
    }
}
