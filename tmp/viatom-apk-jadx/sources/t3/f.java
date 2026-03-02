package t3;

import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;

/* loaded from: classes3.dex */
public enum f {
    /* JADX INFO: Fake field, exist only in values array */
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    /* JADX INFO: Fake field, exist only in values array */
    UNSPECIFIED("unspecified"),
    /* JADX INFO: Fake field, exist only in values array */
    LOADED("loaded"),
    BEGIN_TO_RENDER("beginToRender"),
    /* JADX INFO: Fake field, exist only in values array */
    ONE_PIXEL("onePixel"),
    /* JADX INFO: Fake field, exist only in values array */
    VIEWABLE(MRAIDCommunicatorUtil.KEY_VIEWABLE),
    /* JADX INFO: Fake field, exist only in values array */
    AUDIBLE("audible"),
    /* JADX INFO: Fake field, exist only in values array */
    OTHER("other");


    /* renamed from: a, reason: collision with root package name */
    public final String f12781a;

    f(String str) {
        this.f12781a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f12781a;
    }
}
