package androidx.activity.result.contract;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.CallSuper;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.window.layout.c;
import com.google.gson.internal.a;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.g;
import s6.i;
import t6.a0;
import t6.j;
import t6.n;
import t6.t;
import t6.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ActivityResultContracts {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class CaptureVideo extends ActivityResultContract<Uri, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        public Intent createIntent(Context context, Uri uri) {
            context.getClass();
            uri.getClass();
            Intent intentPutExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", uri);
            intentPutExtra.getClass();
            return intentPutExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, Uri uri) {
            context.getClass();
            uri.getClass();
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Boolean parseResult(int i10, Intent intent) {
            return Boolean.valueOf(i10 == -1);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class GetContent extends ActivityResultContract<String, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        public Intent createIntent(Context context, String str) {
            context.getClass();
            str.getClass();
            Intent type = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str);
            type.getClass();
            return type;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String str) {
            context.getClass();
            str.getClass();
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int i10, Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(19)
    public static class OpenDocument extends ActivityResultContract<String[], Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        public Intent createIntent(Context context, String[] strArr) {
            context.getClass();
            strArr.getClass();
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).setType("*/*");
            type.getClass();
            return type;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String[] strArr) {
            context.getClass();
            strArr.getClass();
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int i10, Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(19)
    public static class OpenMultipleDocuments extends ActivityResultContract<String[], List<Uri>> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        public Intent createIntent(Context context, String[] strArr) {
            context.getClass();
            strArr.getClass();
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
            type.getClass();
            return type;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, String[] strArr) {
            context.getClass();
            strArr.getClass();
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final List<Uri> parseResult(int i10, Intent intent) {
            List<Uri> clipDataUris$activity_release;
            if (i10 != -1) {
                intent = null;
            }
            return (intent == null || (clipDataUris$activity_release = GetMultipleContents.Companion.getClipDataUris$activity_release(intent)) == null) ? t.f12808a : clipDataUris$activity_release;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class PickContact extends ActivityResultContract<Void, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Void r22) {
            context.getClass();
            Intent type = new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
            type.getClass();
            return type;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Uri parseResult(int i10, Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class RequestPermission extends ActivityResultContract<String, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, String str) {
            context.getClass();
            str.getClass();
            return RequestMultiplePermissions.Companion.createIntent$activity_release(new String[]{str});
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, String str) {
            context.getClass();
            str.getClass();
            if (ContextCompat.checkSelfPermission(context, str) == 0) {
                return new ActivityResultContract.SynchronousResult<>(Boolean.TRUE);
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Boolean parseResult(int i10, Intent intent) {
            if (intent == null || i10 != -1) {
                return Boolean.FALSE;
            }
            int[] intArrayExtra = intent.getIntArrayExtra(RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS);
            boolean z9 = false;
            if (intArrayExtra != null) {
                int length = intArrayExtra.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    if (intArrayExtra[i11] == 0) {
                        z9 = true;
                        break;
                    }
                    i11++;
                }
            }
            return Boolean.valueOf(z9);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class TakePicture extends ActivityResultContract<Uri, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        public Intent createIntent(Context context, Uri uri) {
            context.getClass();
            uri.getClass();
            Intent intentPutExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uri);
            intentPutExtra.getClass();
            return intentPutExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, Uri uri) {
            context.getClass();
            uri.getClass();
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Boolean parseResult(int i10, Intent intent) {
            return Boolean.valueOf(i10 == -1);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class TakeVideo extends ActivityResultContract<Uri, Bitmap> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        public Intent createIntent(Context context, Uri uri) {
            context.getClass();
            uri.getClass();
            Intent intentPutExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", uri);
            intentPutExtra.getClass();
            return intentPutExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context context, Uri uri) {
            context.getClass();
            uri.getClass();
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Bitmap parseResult(int i10, Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra(DataSchemeDataSource.SCHEME_DATA);
            }
            return null;
        }
    }

    private ActivityResultContracts() {
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(18)
    public static class GetMultipleContents extends ActivityResultContract<String, List<Uri>> {
        public static final Companion Companion = new Companion(null);

        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        public Intent createIntent(Context context, String str) {
            context.getClass();
            str.getClass();
            Intent intentPutExtra = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            intentPutExtra.getClass();
            return intentPutExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, String str) {
            context.getClass();
            str.getClass();
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final List<Uri> parseResult(int i10, Intent intent) {
            List<Uri> clipDataUris$activity_release;
            if (i10 != -1) {
                intent = null;
            }
            return (intent == null || (clipDataUris$activity_release = Companion.getClipDataUris$activity_release(intent)) == null) ? t.f12808a : clipDataUris$activity_release;
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        @RequiresApi(18)
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final List<Uri> getClipDataUris$activity_release(Intent intent) {
                intent.getClass();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Uri data = intent.getData();
                if (data != null) {
                    linkedHashSet.add(data);
                }
                ClipData clipData = intent.getClipData();
                if (clipData == null && linkedHashSet.isEmpty()) {
                    return t.f12808a;
                }
                if (clipData != null) {
                    int itemCount = clipData.getItemCount();
                    for (int i10 = 0; i10 < itemCount; i10++) {
                        Uri uri = clipData.getItemAt(i10).getUri();
                        if (uri != null) {
                            linkedHashSet.add(uri);
                        }
                    }
                }
                return new ArrayList(linkedHashSet);
            }

            private Companion() {
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(19)
    public static class PickMultipleVisualMedia extends ActivityResultContract<PickVisualMediaRequest, List<Uri>> {
        public static final Companion Companion = new Companion(null);
        private final int maxItems;

        public PickMultipleVisualMedia(int i10) {
            this.maxItems = i10;
            if (i10 > 1) {
                return;
            }
            a.n("Max items must be higher than 1");
            throw null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        @CallSuper
        public Intent createIntent(Context context, PickVisualMediaRequest pickVisualMediaRequest) {
            context.getClass();
            pickVisualMediaRequest.getClass();
            PickVisualMedia.Companion companion = PickVisualMedia.Companion;
            if (companion.isSystemPickerAvailable$activity_release()) {
                Intent intent = new Intent("android.provider.action.PICK_IMAGES");
                intent.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                if (this.maxItems <= MediaStore.getPickImagesMaxLimit()) {
                    intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", this.maxItems);
                    return intent;
                }
                a.n("Max items must be less or equals MediaStore.getPickImagesMaxLimit()");
                return null;
            }
            if (companion.isSystemFallbackPickerAvailable$activity_release(context)) {
                ResolveInfo systemFallbackPicker$activity_release = companion.getSystemFallbackPicker$activity_release(context);
                if (systemFallbackPicker$activity_release == null) {
                    c.g("Required value was null.");
                    return null;
                }
                ActivityInfo activityInfo = systemFallbackPicker$activity_release.activityInfo;
                Intent intent2 = new Intent(PickVisualMedia.ACTION_SYSTEM_FALLBACK_PICK_IMAGES);
                intent2.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                intent2.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                intent2.putExtra(PickVisualMedia.GMS_EXTRA_PICK_IMAGES_MAX, this.maxItems);
                return intent2;
            }
            if (!companion.isGmsPickerAvailable$activity_release(context)) {
                Intent intent3 = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent3.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                intent3.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                if (intent3.getType() == null) {
                    intent3.setType("*/*");
                    intent3.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                }
                return intent3;
            }
            ResolveInfo gmsPicker$activity_release = companion.getGmsPicker$activity_release(context);
            if (gmsPicker$activity_release == null) {
                c.g("Required value was null.");
                return null;
            }
            ActivityInfo activityInfo2 = gmsPicker$activity_release.activityInfo;
            Intent intent4 = new Intent(PickVisualMedia.GMS_ACTION_PICK_IMAGES);
            intent4.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
            intent4.putExtra(PickVisualMedia.GMS_EXTRA_PICK_IMAGES_MAX, this.maxItems);
            return intent4;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, PickVisualMediaRequest pickVisualMediaRequest) {
            context.getClass();
            pickVisualMediaRequest.getClass();
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final List<Uri> parseResult(int i10, Intent intent) {
            List<Uri> clipDataUris$activity_release;
            if (i10 != -1) {
                intent = null;
            }
            return (intent == null || (clipDataUris$activity_release = GetMultipleContents.Companion.getClipDataUris$activity_release(intent)) == null) ? t.f12808a : clipDataUris$activity_release;
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            @SuppressLint({"NewApi", "ClassVerificationFailure"})
            public final int getMaxItems$activity_release() {
                if (PickVisualMedia.Companion.isSystemPickerAvailable$activity_release()) {
                    return MediaStore.getPickImagesMaxLimit();
                }
                return Integer.MAX_VALUE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ PickMultipleVisualMedia(int i10, int i11, g gVar) {
            this((i11 & 1) != 0 ? Companion.getMaxItems$activity_release() : i10);
        }

        public PickMultipleVisualMedia() {
            this(0, 1, null);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(19)
    public static class PickVisualMedia extends ActivityResultContract<PickVisualMediaRequest, Uri> {
        public static final String ACTION_SYSTEM_FALLBACK_PICK_IMAGES = "androidx.activity.result.contract.action.PICK_IMAGES";
        public static final Companion Companion = new Companion(null);
        public static final String EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX = "androidx.activity.result.contract.extra.PICK_IMAGES_MAX";
        public static final String GMS_ACTION_PICK_IMAGES = "com.google.android.gms.provider.action.PICK_IMAGES";
        public static final String GMS_EXTRA_PICK_IMAGES_MAX = "com.google.android.gms.provider.extra.PICK_IMAGES_MAX";

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class ImageAndVideo implements VisualMediaType {
            public static final ImageAndVideo INSTANCE = new ImageAndVideo();

            private ImageAndVideo() {
            }
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class ImageOnly implements VisualMediaType {
            public static final ImageOnly INSTANCE = new ImageOnly();

            private ImageOnly() {
            }
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class SingleMimeType implements VisualMediaType {
            private final String mimeType;

            public SingleMimeType(String str) {
                str.getClass();
                this.mimeType = str;
            }

            public final String getMimeType() {
                return this.mimeType;
            }
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class VideoOnly implements VisualMediaType {
            public static final VideoOnly INSTANCE = new VideoOnly();

            private VideoOnly() {
            }
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public interface VisualMediaType {
        }

        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean isPhotoPickerAvailable() {
            return Companion.isPhotoPickerAvailable();
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        public Intent createIntent(Context context, PickVisualMediaRequest pickVisualMediaRequest) {
            context.getClass();
            pickVisualMediaRequest.getClass();
            Companion companion = Companion;
            if (companion.isSystemPickerAvailable$activity_release()) {
                Intent intent = new Intent("android.provider.action.PICK_IMAGES");
                intent.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                return intent;
            }
            if (companion.isSystemFallbackPickerAvailable$activity_release(context)) {
                ResolveInfo systemFallbackPicker$activity_release = companion.getSystemFallbackPicker$activity_release(context);
                if (systemFallbackPicker$activity_release == null) {
                    c.g("Required value was null.");
                    return null;
                }
                ActivityInfo activityInfo = systemFallbackPicker$activity_release.activityInfo;
                Intent intent2 = new Intent(ACTION_SYSTEM_FALLBACK_PICK_IMAGES);
                intent2.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                intent2.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                return intent2;
            }
            if (!companion.isGmsPickerAvailable$activity_release(context)) {
                Intent intent3 = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent3.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                if (intent3.getType() == null) {
                    intent3.setType("*/*");
                    intent3.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                }
                return intent3;
            }
            ResolveInfo gmsPicker$activity_release = companion.getGmsPicker$activity_release(context);
            if (gmsPicker$activity_release == null) {
                c.g("Required value was null.");
                return null;
            }
            ActivityInfo activityInfo2 = gmsPicker$activity_release.activityInfo;
            Intent intent4 = new Intent(GMS_ACTION_PICK_IMAGES);
            intent4.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
            intent4.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
            return intent4;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, PickVisualMediaRequest pickVisualMediaRequest) {
            context.getClass();
            pickVisualMediaRequest.getClass();
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int i10, Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent == null) {
                return null;
            }
            Uri data = intent.getData();
            if (data != null) {
                return data;
            }
            List<Uri> clipDataUris$activity_release = GetMultipleContents.Companion.getClipDataUris$activity_release(intent);
            clipDataUris$activity_release.getClass();
            return clipDataUris$activity_release.isEmpty() ? null : clipDataUris$activity_release.get(0);
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final ResolveInfo getGmsPicker$activity_release(Context context) {
                context.getClass();
                return context.getPackageManager().resolveActivity(new Intent(PickVisualMedia.GMS_ACTION_PICK_IMAGES), 1114112);
            }

            public final ResolveInfo getSystemFallbackPicker$activity_release(Context context) {
                context.getClass();
                return context.getPackageManager().resolveActivity(new Intent(PickVisualMedia.ACTION_SYSTEM_FALLBACK_PICK_IMAGES), 1114112);
            }

            public final String getVisualMimeType$activity_release(VisualMediaType visualMediaType) {
                visualMediaType.getClass();
                if (visualMediaType instanceof ImageOnly) {
                    return "image/*";
                }
                if (visualMediaType instanceof VideoOnly) {
                    return "video/*";
                }
                if (visualMediaType instanceof SingleMimeType) {
                    return ((SingleMimeType) visualMediaType).getMimeType();
                }
                if (visualMediaType instanceof ImageAndVideo) {
                    return null;
                }
                c.b();
                return null;
            }

            public final boolean isGmsPickerAvailable$activity_release(Context context) {
                context.getClass();
                return getGmsPicker$activity_release(context) != null;
            }

            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean isPhotoPickerAvailable(Context context) {
                context.getClass();
                return isSystemPickerAvailable$activity_release() || isSystemFallbackPickerAvailable$activity_release(context) || isGmsPickerAvailable$activity_release(context);
            }

            public final boolean isSystemFallbackPickerAvailable$activity_release(Context context) {
                context.getClass();
                return getSystemFallbackPicker$activity_release(context) != null;
            }

            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean isSystemPickerAvailable$activity_release() {
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 33) {
                    return true;
                }
                return i10 >= 30 && SdkExtensions.getExtensionVersion(30) >= 2;
            }

            private Companion() {
            }

            public static /* synthetic */ void getACTION_SYSTEM_FALLBACK_PICK_IMAGES$annotations() {
            }

            public static /* synthetic */ void getEXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX$annotations() {
            }

            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean isPhotoPickerAvailable() {
                return isSystemPickerAvailable$activity_release();
            }
        }

        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean isPhotoPickerAvailable(Context context) {
            return Companion.isPhotoPickerAvailable(context);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {
        public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
        public static final Companion Companion = new Companion(null);
        public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";
        public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, String[] strArr) {
            context.getClass();
            strArr.getClass();
            return Companion.createIntent$activity_release(strArr);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult(Context context, String[] strArr) {
            context.getClass();
            strArr.getClass();
            if (strArr.length == 0) {
                return new ActivityResultContract.SynchronousResult<>(u.f12809a);
            }
            for (String str : strArr) {
                if (ContextCompat.checkSelfPermission(context, str) != 0) {
                    return null;
                }
            }
            int iH0 = a0.h0(strArr.length);
            if (iH0 < 16) {
                iH0 = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iH0);
            for (String str2 : strArr) {
                linkedHashMap.put(str2, Boolean.TRUE);
            }
            return new ActivityResultContract.SynchronousResult<>(linkedHashMap);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Map<String, Boolean> parseResult(int i10, Intent intent) {
            if (i10 == -1 && intent != null) {
                String[] stringArrayExtra = intent.getStringArrayExtra(EXTRA_PERMISSIONS);
                int[] intArrayExtra = intent.getIntArrayExtra(EXTRA_PERMISSION_GRANT_RESULTS);
                if (intArrayExtra != null && stringArrayExtra != null) {
                    ArrayList arrayList = new ArrayList(intArrayExtra.length);
                    for (int i11 : intArrayExtra) {
                        arrayList.add(Boolean.valueOf(i11 == 0));
                    }
                    ArrayList arrayListT0 = j.t0(stringArrayExtra);
                    Iterator it = arrayListT0.iterator();
                    Iterator it2 = arrayList.iterator();
                    ArrayList arrayList2 = new ArrayList(Math.min(n.V(arrayListT0, 10), n.V(arrayList, 10)));
                    while (it.hasNext() && it2.hasNext()) {
                        arrayList2.add(new i(it.next(), it2.next()));
                    }
                    return a0.k0(arrayList2);
                }
            }
            return u.f12809a;
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final Intent createIntent$activity_release(String[] strArr) {
                strArr.getClass();
                Intent intentPutExtra = new Intent(RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS).putExtra(RequestMultiplePermissions.EXTRA_PERMISSIONS, strArr);
                intentPutExtra.getClass();
                return intentPutExtra;
            }

            private Companion() {
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {
        public static final Companion Companion = new Companion(null);
        public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Intent intent) {
            context.getClass();
            intent.getClass();
            return intent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public ActivityResult parseResult(int i10, Intent intent) {
            return new ActivityResult(i10, intent);
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class StartIntentSenderForResult extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
        public static final Companion Companion = new Companion(null);
        public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
        public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, IntentSenderRequest intentSenderRequest) {
            context.getClass();
            intentSenderRequest.getClass();
            Intent intentPutExtra = new Intent(ACTION_INTENT_SENDER_REQUEST).putExtra(EXTRA_INTENT_SENDER_REQUEST, intentSenderRequest);
            intentPutExtra.getClass();
            return intentPutExtra;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public ActivityResult parseResult(int i10, Intent intent) {
            return new ActivityResult(i10, intent);
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(21)
    public static class OpenDocumentTree extends ActivityResultContract<Uri, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        public Intent createIntent(Context context, Uri uri) {
            context.getClass();
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26 && uri != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", uri);
            }
            return intent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int i10, Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, Uri uri) {
            context.getClass();
            return null;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        public Intent createIntent(Context context, Void r22) {
            context.getClass();
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Bitmap parseResult(int i10, Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra(DataSchemeDataSource.SCHEME_DATA);
            }
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context context, Void r22) {
            context.getClass();
            return null;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(19)
    public static class CreateDocument extends ActivityResultContract<String, Uri> {
        private final String mimeType;

        public CreateDocument(String str) {
            str.getClass();
            this.mimeType = str;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        public Intent createIntent(Context context, String str) {
            context.getClass();
            str.getClass();
            Intent intentPutExtra = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.mimeType).putExtra("android.intent.extra.TITLE", str);
            intentPutExtra.getClass();
            return intentPutExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String str) {
            context.getClass();
            str.getClass();
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int i10, Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }

        public CreateDocument() {
            this("*/*");
        }
    }
}
