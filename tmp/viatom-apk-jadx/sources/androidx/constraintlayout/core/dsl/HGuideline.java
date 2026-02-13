package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.dsl.Helper;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class HGuideline extends Guideline {
    public HGuideline(String str, String str2) {
        super(str);
        this.config = str2;
        this.type = new Helper.HelperType(Helper.typeMap.get(Helper.Type.HORIZONTAL_GUIDELINE));
        this.configMap = convertConfigToMap();
    }

    public HGuideline(String str) {
        super(str);
        this.type = new Helper.HelperType(Helper.typeMap.get(Helper.Type.HORIZONTAL_GUIDELINE));
    }
}
