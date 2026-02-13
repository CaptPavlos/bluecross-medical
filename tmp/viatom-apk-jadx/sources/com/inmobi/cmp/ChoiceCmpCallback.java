package com.inmobi.cmp;

import com.inmobi.cmp.core.model.ACData;
import com.inmobi.cmp.core.model.GDPRData;
import com.inmobi.cmp.core.model.gbc.GoogleBasicConsents;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.model.ActionButton;
import com.inmobi.cmp.model.ChoiceError;
import com.inmobi.cmp.model.DisplayInfo;
import com.inmobi.cmp.model.NonIABData;
import com.inmobi.cmp.model.PingReturn;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface ChoiceCmpCallback {
    void onActionButtonClicked(ActionButton actionButton);

    void onCCPAConsentGiven(String str);

    void onCMPUIStatusChanged(DisplayInfo displayInfo);

    void onCmpError(ChoiceError choiceError);

    void onCmpLoaded(PingReturn pingReturn);

    void onGoogleBasicConsentChange(GoogleBasicConsents googleBasicConsents);

    void onGoogleVendorConsentGiven(ACData aCData);

    void onIABVendorConsentGiven(GDPRData gDPRData);

    void onNonIABVendorConsentGiven(NonIABData nonIABData);

    void onReceiveUSRegulationsConsent(USRegulationData uSRegulationData);

    void onUserMovedToOtherState();
}
