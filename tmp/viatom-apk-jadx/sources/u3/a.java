package u3;

import com.mbridge.msdk.foundation.entity.CampaignEx;

/* loaded from: classes3.dex */
public enum a {
    CLICK(CampaignEx.JSON_NATIVE_VIDEO_CLICK),
    /* JADX INFO: Fake field, exist only in values array */
    INVITATION_ACCEPTED("invitationAccept");


    /* renamed from: a, reason: collision with root package name */
    public final String f12886a;

    a(String str) {
        this.f12886a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f12886a;
    }
}
