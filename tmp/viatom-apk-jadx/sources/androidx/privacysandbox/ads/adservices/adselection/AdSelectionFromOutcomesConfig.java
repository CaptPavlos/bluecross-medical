package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.adselection.AdSelectionFromOutcomesConfig;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.List;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ExperimentalFeatures.Ext10OptIn
/* loaded from: classes.dex */
public final class AdSelectionFromOutcomesConfig {
    private final List<Long> adSelectionIds;
    private final AdSelectionSignals adSelectionSignals;
    private Uri selectionLogicUri;
    private final AdTechIdentifier seller;

    public AdSelectionFromOutcomesConfig(AdTechIdentifier adTechIdentifier, List<Long> list, AdSelectionSignals adSelectionSignals, Uri uri) {
        adTechIdentifier.getClass();
        list.getClass();
        adSelectionSignals.getClass();
        uri.getClass();
        this.seller = adTechIdentifier;
        this.adSelectionIds = list;
        this.adSelectionSignals = adSelectionSignals;
        this.selectionLogicUri = uri;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.AdSelectionFromOutcomesConfig convertToAdServices$ads_adservices_release() {
        android.adservices.adselection.AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfigBuild = new AdSelectionFromOutcomesConfig.Builder().setSelectionSignals(this.adSelectionSignals.convertToAdServices$ads_adservices_release()).setAdSelectionIds(this.adSelectionIds).setSelectionLogicUri(this.selectionLogicUri).setSeller(this.seller.convertToAdServices$ads_adservices_release()).build();
        adSelectionFromOutcomesConfigBuild.getClass();
        return adSelectionFromOutcomesConfigBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionFromOutcomesConfig)) {
            return false;
        }
        AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig = (AdSelectionFromOutcomesConfig) obj;
        return l.a(this.seller, adSelectionFromOutcomesConfig.seller) && l.a(this.adSelectionIds, adSelectionFromOutcomesConfig.adSelectionIds) && l.a(this.adSelectionSignals, adSelectionFromOutcomesConfig.adSelectionSignals) && l.a(this.selectionLogicUri, adSelectionFromOutcomesConfig.selectionLogicUri);
    }

    public final List<Long> getAdSelectionIds() {
        return this.adSelectionIds;
    }

    public final AdSelectionSignals getAdSelectionSignals() {
        return this.adSelectionSignals;
    }

    public final Uri getSelectionLogicUri() {
        return this.selectionLogicUri;
    }

    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    public int hashCode() {
        return this.selectionLogicUri.hashCode() + ((this.adSelectionSignals.hashCode() + ((this.adSelectionIds.hashCode() + (this.seller.hashCode() * 31)) * 31)) * 31);
    }

    public final void setSelectionLogicUri(Uri uri) {
        uri.getClass();
        this.selectionLogicUri = uri;
    }

    public String toString() {
        return "AdSelectionFromOutcomesConfig: seller=" + this.seller + ", adSelectionIds='" + this.adSelectionIds + "', adSelectionSignals=" + this.adSelectionSignals + ", selectionLogicUri=" + this.selectionLogicUri;
    }
}
