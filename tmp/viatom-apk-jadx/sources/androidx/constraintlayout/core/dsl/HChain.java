package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.dsl.Chain;
import androidx.constraintlayout.core.dsl.Constraint;
import androidx.constraintlayout.core.dsl.Helper;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class HChain extends Chain {
    private HAnchor mEnd;
    private HAnchor mLeft;
    private HAnchor mRight;
    private HAnchor mStart;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class HAnchor extends Chain.Anchor {
        public HAnchor(Constraint.HSide hSide) {
            super(Constraint.Side.valueOf(hSide.name()));
        }
    }

    public HChain(String str, String str2) {
        super(str);
        this.mLeft = new HAnchor(Constraint.HSide.LEFT);
        this.mRight = new HAnchor(Constraint.HSide.RIGHT);
        this.mStart = new HAnchor(Constraint.HSide.START);
        this.mEnd = new HAnchor(Constraint.HSide.END);
        this.config = str2;
        this.type = new Helper.HelperType(Helper.typeMap.get(Helper.Type.HORIZONTAL_CHAIN));
        Map<String, String> mapConvertConfigToMap = convertConfigToMap();
        this.configMap = mapConvertConfigToMap;
        if (mapConvertConfigToMap.containsKey("contains")) {
            Ref.addStringToReferences(this.configMap.get("contains"), this.references);
        }
    }

    public HAnchor getEnd() {
        return this.mEnd;
    }

    public HAnchor getLeft() {
        return this.mLeft;
    }

    public HAnchor getRight() {
        return this.mRight;
    }

    public HAnchor getStart() {
        return this.mStart;
    }

    public void linkToEnd(Constraint.HAnchor hAnchor, int i10, int i11) {
        HAnchor hAnchor2 = this.mEnd;
        hAnchor2.mConnection = hAnchor;
        hAnchor2.mMargin = i10;
        hAnchor2.mGoneMargin = i11;
        this.configMap.put(TtmlNode.END, hAnchor2.toString());
    }

    public void linkToLeft(Constraint.HAnchor hAnchor, int i10, int i11) {
        HAnchor hAnchor2 = this.mLeft;
        hAnchor2.mConnection = hAnchor;
        hAnchor2.mMargin = i10;
        hAnchor2.mGoneMargin = i11;
        this.configMap.put(TtmlNode.LEFT, hAnchor2.toString());
    }

    public void linkToRight(Constraint.HAnchor hAnchor, int i10, int i11) {
        HAnchor hAnchor2 = this.mRight;
        hAnchor2.mConnection = hAnchor;
        hAnchor2.mMargin = i10;
        hAnchor2.mGoneMargin = i11;
        this.configMap.put(TtmlNode.RIGHT, hAnchor2.toString());
    }

    public void linkToStart(Constraint.HAnchor hAnchor, int i10, int i11) {
        HAnchor hAnchor2 = this.mStart;
        hAnchor2.mConnection = hAnchor;
        hAnchor2.mMargin = i10;
        hAnchor2.mGoneMargin = i11;
        this.configMap.put("start", hAnchor2.toString());
    }

    public void linkToEnd(Constraint.HAnchor hAnchor, int i10) {
        linkToEnd(hAnchor, i10, Integer.MIN_VALUE);
    }

    public void linkToLeft(Constraint.HAnchor hAnchor, int i10) {
        linkToLeft(hAnchor, i10, Integer.MIN_VALUE);
    }

    public void linkToRight(Constraint.HAnchor hAnchor, int i10) {
        linkToRight(hAnchor, i10, Integer.MIN_VALUE);
    }

    public void linkToStart(Constraint.HAnchor hAnchor, int i10) {
        linkToStart(hAnchor, i10, Integer.MIN_VALUE);
    }

    public void linkToEnd(Constraint.HAnchor hAnchor) {
        linkToEnd(hAnchor, 0);
    }

    public void linkToLeft(Constraint.HAnchor hAnchor) {
        linkToLeft(hAnchor, 0);
    }

    public void linkToRight(Constraint.HAnchor hAnchor) {
        linkToRight(hAnchor, 0);
    }

    public void linkToStart(Constraint.HAnchor hAnchor) {
        linkToStart(hAnchor, 0);
    }

    public HChain(String str) {
        super(str);
        this.mLeft = new HAnchor(Constraint.HSide.LEFT);
        this.mRight = new HAnchor(Constraint.HSide.RIGHT);
        this.mStart = new HAnchor(Constraint.HSide.START);
        this.mEnd = new HAnchor(Constraint.HSide.END);
        this.type = new Helper.HelperType(Helper.typeMap.get(Helper.Type.HORIZONTAL_CHAIN));
    }
}
