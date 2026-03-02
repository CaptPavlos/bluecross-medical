package androidx.leanback.system;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import androidx.annotation.RestrictTo;
import androidx.leanback.widget.ShadowOverlayContainer;
import com.google.gson.internal.a;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class Settings {
    private static final String ACTION_PARTNER_CUSTOMIZATION = "android.support.v17.leanback.action.PARTNER_CUSTOMIZATION";
    private static final boolean DEBUG = false;
    public static final String OUTLINE_CLIPPING_DISABLED = "OUTLINE_CLIPPING_DISABLED";
    public static final String PREFER_STATIC_SHADOWS = "PREFER_STATIC_SHADOWS";
    private static final String TAG = "Settings";
    private static Settings sInstance;
    private boolean mOutlineClippingDisabled;
    private boolean mPreferStaticShadows;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Customizations {
        String mPackageName;
        Resources mResources;

        public Customizations(Resources resources, String str) {
            this.mResources = resources;
            this.mPackageName = str;
        }

        public boolean getBoolean(String str, boolean z9) {
            int identifier = this.mResources.getIdentifier(str, "bool", this.mPackageName);
            return identifier > 0 ? this.mResources.getBoolean(identifier) : z9;
        }
    }

    private Settings(Context context) {
        generateSetting(getCustomizations(context), context);
    }

    private void generateSetting(Customizations customizations, Context context) {
        if (ShadowOverlayContainer.supportsDynamicShadow()) {
            this.mPreferStaticShadows = false;
            if (customizations != null) {
                this.mPreferStaticShadows = customizations.getBoolean("leanback_prefer_static_shadows", false);
            }
        } else {
            this.mPreferStaticShadows = true;
        }
        boolean zIsLowRamDevice = ((ActivityManager) context.getSystemService("activity")).isLowRamDevice();
        this.mOutlineClippingDisabled = zIsLowRamDevice;
        if (customizations != null) {
            this.mOutlineClippingDisabled = customizations.getBoolean("leanback_outline_clipping_disabled", zIsLowRamDevice);
        }
    }

    private Customizations getCustomizations(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getPackageManager();
        Iterator<ResolveInfo> it = packageManager.queryBroadcastReceivers(new Intent(ACTION_PARTNER_CUSTOMIZATION), 0).iterator();
        Resources resourcesForApplication = null;
        String str = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ResolveInfo next = it.next();
            String str2 = next.activityInfo.packageName;
            if (str2 != null && isSystemApp(next)) {
                try {
                    resourcesForApplication = packageManager.getResourcesForApplication(str2);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            if (resourcesForApplication != null) {
                str = str2;
                break;
            }
            str = str2;
        }
        if (resourcesForApplication == null) {
            return null;
        }
        return new Customizations(resourcesForApplication, str);
    }

    public static Settings getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new Settings(context);
        }
        return sInstance;
    }

    private static boolean isSystemApp(ResolveInfo resolveInfo) {
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        return (activityInfo == null || (activityInfo.applicationInfo.flags & 1) == 0) ? false : true;
    }

    public boolean getBoolean(String str) {
        return getOrSetBoolean(str, false, false);
    }

    public boolean getOrSetBoolean(String str, boolean z9, boolean z10) {
        if (str.compareTo(PREFER_STATIC_SHADOWS) == 0) {
            if (!z9) {
                return this.mPreferStaticShadows;
            }
            this.mPreferStaticShadows = z10;
            return z10;
        }
        if (str.compareTo(OUTLINE_CLIPPING_DISABLED) != 0) {
            a.n("Invalid key");
            return false;
        }
        if (!z9) {
            return this.mOutlineClippingDisabled;
        }
        this.mOutlineClippingDisabled = z10;
        return z10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOutlineClippingDisabled() {
        return this.mOutlineClippingDisabled;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean preferStaticShadows() {
        return this.mPreferStaticShadows;
    }

    public void setBoolean(String str, boolean z9) {
        getOrSetBoolean(str, true, z9);
    }
}
