package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.dsl.Helper;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class Guideline extends Helper {
    private int mEnd;
    private float mPercent;
    private int mStart;

    public Guideline(String str) {
        super(str, new Helper.HelperType(""));
        this.mStart = Integer.MIN_VALUE;
        this.mEnd = Integer.MIN_VALUE;
        this.mPercent = Float.NaN;
    }

    public int getEnd() {
        return this.mEnd;
    }

    public float getPercent() {
        return this.mPercent;
    }

    public int getStart() {
        return this.mStart;
    }

    public void setEnd(int i10) {
        this.mEnd = i10;
        this.configMap.put(TtmlNode.END, String.valueOf(i10));
    }

    public void setPercent(float f) {
        this.mPercent = f;
        this.configMap.put("percent", String.valueOf(f));
    }

    public void setStart(int i10) {
        this.mStart = i10;
        this.configMap.put("start", String.valueOf(i10));
    }
}
