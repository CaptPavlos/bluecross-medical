package androidx.privacysandbox.ads.adservices.measurement;

import android.adservices.measurement.WebSourceParams;
import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class WebSourceParams {
    public static final Companion Companion = new Companion(null);
    private final boolean debugKeyAllowed;
    private final Uri registrationUri;

    public WebSourceParams(Uri uri, boolean z9) {
        uri.getClass();
        this.registrationUri = uri;
        this.debugKeyAllowed = z9;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSourceParams)) {
            return false;
        }
        WebSourceParams webSourceParams = (WebSourceParams) obj;
        return l.a(this.registrationUri, webSourceParams.registrationUri) && this.debugKeyAllowed == webSourceParams.debugKeyAllowed;
    }

    public final boolean getDebugKeyAllowed() {
        return this.debugKeyAllowed;
    }

    public final Uri getRegistrationUri() {
        return this.registrationUri;
    }

    public int hashCode() {
        return (this.registrationUri.hashCode() * 31) + (this.debugKeyAllowed ? 1231 : 1237);
    }

    public String toString() {
        return "WebSourceParams { RegistrationUri=" + this.registrationUri + ", DebugKeyAllowed=" + this.debugKeyAllowed + " }";
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public final List<android.adservices.measurement.WebSourceParams> convertWebSourceParams$ads_adservices_release(List<WebSourceParams> list) {
            list.getClass();
            ArrayList arrayList = new ArrayList();
            for (WebSourceParams webSourceParams : list) {
                android.adservices.measurement.WebSourceParams webSourceParamsBuild = new WebSourceParams.Builder(webSourceParams.getRegistrationUri()).setDebugKeyAllowed(webSourceParams.getDebugKeyAllowed()).build();
                webSourceParamsBuild.getClass();
                arrayList.add(webSourceParamsBuild);
            }
            return arrayList;
        }

        private Companion() {
        }
    }
}
