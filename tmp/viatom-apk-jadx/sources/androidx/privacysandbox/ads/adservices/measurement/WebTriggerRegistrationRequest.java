package androidx.privacysandbox.ads.adservices.measurement;

import android.adservices.measurement.WebTriggerRegistrationRequest;
import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import java.util.List;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class WebTriggerRegistrationRequest {
    private final Uri destination;
    private final List<WebTriggerParams> webTriggerParams;

    public WebTriggerRegistrationRequest(List<WebTriggerParams> list, Uri uri) {
        list.getClass();
        uri.getClass();
        this.webTriggerParams = list;
        this.destination = uri;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final android.adservices.measurement.WebTriggerRegistrationRequest convertToAdServices$ads_adservices_release() {
        android.adservices.measurement.WebTriggerRegistrationRequest webTriggerRegistrationRequestBuild = new WebTriggerRegistrationRequest.Builder(WebTriggerParams.Companion.convertWebTriggerParams$ads_adservices_release(this.webTriggerParams), this.destination).build();
        webTriggerRegistrationRequestBuild.getClass();
        return webTriggerRegistrationRequestBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebTriggerRegistrationRequest)) {
            return false;
        }
        WebTriggerRegistrationRequest webTriggerRegistrationRequest = (WebTriggerRegistrationRequest) obj;
        return l.a(this.webTriggerParams, webTriggerRegistrationRequest.webTriggerParams) && l.a(this.destination, webTriggerRegistrationRequest.destination);
    }

    public final Uri getDestination() {
        return this.destination;
    }

    public final List<WebTriggerParams> getWebTriggerParams() {
        return this.webTriggerParams;
    }

    public int hashCode() {
        return this.destination.hashCode() + (this.webTriggerParams.hashCode() * 31);
    }

    public String toString() {
        return "WebTriggerRegistrationRequest { WebTriggerParams=" + this.webTriggerParams + ", Destination=" + this.destination;
    }
}
