package t3;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* loaded from: classes3.dex */
public enum d {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO(MimeTypes.BASE_TYPE_VIDEO),
    /* JADX INFO: Fake field, exist only in values array */
    AUDIO(MimeTypes.BASE_TYPE_AUDIO);


    /* renamed from: a, reason: collision with root package name */
    public final String f12774a;

    d(String str) {
        this.f12774a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f12774a;
    }
}
