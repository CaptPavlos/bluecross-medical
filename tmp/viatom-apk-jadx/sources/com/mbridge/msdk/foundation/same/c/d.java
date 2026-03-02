package com.mbridge.msdk.foundation.same.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.io.File;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final ThreadPoolExecutor f3657a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f3658b;

    /* renamed from: c, reason: collision with root package name */
    private final String f3659c;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final d f3665a = new d();
    }

    private d() {
        this.f3658b = new Handler(Looper.getMainLooper());
        this.f3659c = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_IMG) + File.separator;
        this.f3657a = f.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadRequest<?> a(String str, String str2, g gVar, c cVar) {
        try {
            return MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str2, str, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_IMAGE)).withReadTimeout(com.mbridge.msdk.foundation.same.a.f3616u).withConnectTimeout(com.mbridge.msdk.foundation.same.a.t).withWriteTimeout(com.mbridge.msdk.foundation.same.a.f3615s).withDownloadPriority(DownloadPriority.LOW).withHttpRetryCounter(1).withDirectoryPathInternal(this.f3659c).withDownloadStateListener(new b(this.f3658b, this.f3657a, str2, this.f3659c, str, gVar, cVar)).with("download_scene", "download_image").withProgressStateListener(null).withTimeout(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS).with("do_us_fi_re", Boolean.FALSE.toString()).build();
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("CommonImageLoaderRefactor", "createDownloadRequest error", e);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap d(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inDither = true;
        return BitmapFactory.decodeFile(str, options);
    }

    public final boolean b(String str) {
        File file;
        if (MBridgeConstans.DEBUG) {
            androidx.constraintlayout.core.widgets.analyzer.a.E("isImageFileExists imageUrl = ", str, "CommonImageLoaderRefactor");
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            try {
                file = new File(this.f3659c + ad.c(str));
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("CommonImageLoaderRefactor", "isImageFileExists error", e);
                }
                file = null;
            }
            if (file == null || !file.isFile()) {
                return false;
            }
            return file.exists();
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                af.b("CommonImageLoaderRefactor", "isImageFileExists error", e3);
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class b implements OnDownloadStateListener<Object> {

        /* renamed from: a, reason: collision with root package name */
        private final ThreadPoolExecutor f3666a;

        /* renamed from: b, reason: collision with root package name */
        private final Handler f3667b;

        /* renamed from: c, reason: collision with root package name */
        private final String f3668c;

        /* renamed from: d, reason: collision with root package name */
        private final String f3669d;
        private final g e;
        private final String f;
        private final c g;

        public b(Handler handler, ThreadPoolExecutor threadPoolExecutor, String str, String str2, String str3, g gVar, c cVar) {
            this.f3667b = handler;
            this.f3666a = threadPoolExecutor;
            this.f = str;
            this.f3668c = str2;
            this.f3669d = str3;
            this.e = gVar;
            this.g = cVar;
        }

        public static /* synthetic */ void a(b bVar) {
            if (bVar.g == null) {
                return;
            }
            try {
                Bitmap bitmapD = d.d(bVar.f3668c + bVar.f3669d);
                if (bitmapD == null) {
                    bVar.a("bitmap decode failed");
                    return;
                }
                final Bitmap bitmapA = bVar.a(bitmapD, bVar.e);
                if (bitmapA == null) {
                    bVar.a("bitmap transformation failed");
                } else {
                    if (bVar.g == null) {
                        return;
                    }
                    bVar.f3667b.post(new Runnable() { // from class: com.mbridge.msdk.foundation.same.c.d.b.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                b.this.g.onSuccessLoad(bitmapA, b.this.f);
                            } catch (Exception e) {
                                if (MBridgeConstans.DEBUG) {
                                    af.b("CommonImageLoaderRefactor", "callbackForSuccess error", e);
                                }
                            }
                        }
                    });
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.a("CommonImageLoaderRefactor", "onDownloadComplete decodeBitmap error = " + e.getLocalizedMessage());
                }
                bVar.a("bitmap decode failed");
            }
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadComplete(DownloadMessage<Object> downloadMessage) {
            File file;
            if (MBridgeConstans.DEBUG) {
                af.a("CommonImageLoaderRefactor", "onDownloadComplete imageUrl = " + this.f + " imagePath = " + this.f3668c + this.f3669d);
                try {
                    file = new File(this.f3668c + this.f3669d);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("CommonImageLoaderRefactor", "onDownloadComplete error", e);
                    }
                    file = null;
                }
                if (file != null && file.isFile() && file.exists()) {
                    af.a("CommonImageLoaderRefactor", "onDownloadComplete file size = " + file.length());
                } else {
                    af.b("CommonImageLoaderRefactor", "onDownloadComplete file not exist");
                }
            }
            this.f3666a.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.c.d.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.a(b.this);
                }
            });
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadError(DownloadMessage<Object> downloadMessage, DownloadError downloadError) {
            if (MBridgeConstans.DEBUG) {
                af.a("CommonImageLoaderRefactor", "onDownloadError imageUrl = " + downloadError.getException().getLocalizedMessage());
            }
            a(downloadError.getException().getLocalizedMessage());
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onCancelDownload(DownloadMessage<Object> downloadMessage) {
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadStart(DownloadMessage<Object> downloadMessage) {
        }

        private Bitmap a(Bitmap bitmap, g gVar) {
            if (gVar != null) {
                try {
                    return gVar.a(bitmap);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("CommonImageLoaderRefactor", "handlerImageTransformation error", e);
                    }
                }
            }
            return bitmap;
        }

        private void a(final String str) {
            if (this.g == null) {
                return;
            }
            this.f3667b.post(new Runnable() { // from class: com.mbridge.msdk.foundation.same.c.d.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        b.this.g.onFailedLoad(b.this.f, str);
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("CommonImageLoaderRefactor", "callbackForFailed error", e);
                        }
                    }
                }
            });
        }
    }

    public final Bitmap a(String str) {
        if (MBridgeConstans.DEBUG) {
            androidx.constraintlayout.core.widgets.analyzer.a.E("getImageBitmapByUrl imageUrl = ", str, "CommonImageLoaderRefactor");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strO = a3.a.o(new StringBuilder(), this.f3659c, ad.c(str));
        File file = new File(strO);
        if (file.isFile() && file.exists()) {
            try {
                return d(strO);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("CommonImageLoaderRefactor", "getImageBitmapByUrl error", e);
                }
            }
        }
        return null;
    }

    public final void a(final String str, final g gVar, final c cVar) {
        try {
            this.f3657a.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.c.d.1
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadRequest downloadRequestA = d.this.a(ad.c(str), str, gVar, cVar);
                    if (downloadRequestA != null) {
                        downloadRequestA.start();
                        return;
                    }
                    if (MBridgeConstans.DEBUG) {
                        af.b("CommonImageLoaderRefactor", "createDownloadRequest error");
                    }
                    if (cVar == null) {
                        return;
                    }
                    d.this.f3658b.post(new Runnable() { // from class: com.mbridge.msdk.foundation.same.c.d.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            cVar.onFailedLoad("create download request error", str);
                        }
                    });
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("CommonImageLoaderRefactor", "loadImage error", e);
            }
        }
    }
}
