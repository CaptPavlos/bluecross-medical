package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.dsl.Chain;
import androidx.constraintlayout.core.dsl.Constraint;
import androidx.constraintlayout.core.dsl.Helper;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class VChain extends Chain {
    private VAnchor mBaseline;
    private VAnchor mBottom;
    private VAnchor mTop;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class VAnchor extends Chain.Anchor {
        public VAnchor(Constraint.VSide vSide) {
            super(Constraint.Side.valueOf(vSide.name()));
        }
    }

    public VChain(String str, String str2) {
        super(str);
        this.mTop = new VAnchor(Constraint.VSide.TOP);
        this.mBottom = new VAnchor(Constraint.VSide.BOTTOM);
        this.mBaseline = new VAnchor(Constraint.VSide.BASELINE);
        this.config = str2;
        this.type = new Helper.HelperType(Helper.typeMap.get(Helper.Type.VERTICAL_CHAIN));
        Map<String, String> mapConvertConfigToMap = convertConfigToMap();
        this.configMap = mapConvertConfigToMap;
        if (mapConvertConfigToMap.containsKey("contains")) {
            Ref.addStringToReferences(this.configMap.get("contains"), this.references);
        }
    }

    public VAnchor getBaseline() {
        return this.mBaseline;
    }

    public VAnchor getBottom() {
        return this.mBottom;
    }

    public VAnchor getTop() {
        return this.mTop;
    }

    public void linkToBaseline(Constraint.VAnchor vAnchor, int i10, int i11) {
        VAnchor vAnchor2 = this.mBaseline;
        vAnchor2.mConnection = vAnchor;
        vAnchor2.mMargin = i10;
        vAnchor2.mGoneMargin = i11;
        this.configMap.put("baseline", vAnchor2.toString());
    }

    public void linkToBottom(Constraint.VAnchor vAnchor, int i10, int i11) {
        VAnchor vAnchor2 = this.mBottom;
        vAnchor2.mConnection = vAnchor;
        vAnchor2.mMargin = i10;
        vAnchor2.mGoneMargin = i11;
        this.configMap.put("bottom", vAnchor2.toString());
    }

    public void linkToTop(Constraint.VAnchor vAnchor, int i10, int i11) {
        VAnchor vAnchor2 = this.mTop;
        vAnchor2.mConnection = vAnchor;
        vAnchor2.mMargin = i10;
        vAnchor2.mGoneMargin = i11;
        this.configMap.put("top", vAnchor2.toString());
    }

    public void linkToBaseline(Constraint.VAnchor vAnchor, int i10) {
        linkToBaseline(vAnchor, i10, Integer.MIN_VALUE);
    }

    public void linkToBottom(Constraint.VAnchor vAnchor, int i10) {
        linkToBottom(vAnchor, i10, Integer.MIN_VALUE);
    }

    public void linkToTop(Constraint.VAnchor vAnchor, int i10) {
        linkToTop(vAnchor, i10, Integer.MIN_VALUE);
    }

    public void linkToBaseline(Constraint.VAnchor vAnchor) {
        linkToBaseline(vAnchor, 0);
    }

    public void linkToBottom(Constraint.VAnchor vAnchor) {
        linkToBottom(vAnchor, 0);
    }

    public void linkToTop(Constraint.VAnchor vAnchor) {
        linkToTop(vAnchor, 0);
    }

    public VChain(String str) {
        super(str);
        this.mTop = new VAnchor(Constraint.VSide.TOP);
        this.mBottom = new VAnchor(Constraint.VSide.BOTTOM);
        this.mBaseline = new VAnchor(Constraint.VSide.BASELINE);
        this.type = new Helper.HelperType(Helper.typeMap.get(Helper.Type.VERTICAL_CHAIN));
    }
}
