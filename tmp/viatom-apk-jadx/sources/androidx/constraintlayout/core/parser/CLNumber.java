package androidx.constraintlayout.core.parser;

import a3.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class CLNumber extends CLElement {
    float mValue;

    public CLNumber(char[] cArr) {
        super(cArr);
        this.mValue = Float.NaN;
    }

    public static CLElement allocate(char[] cArr) {
        return new CLNumber(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CLNumber) {
            float f = getFloat();
            float f10 = ((CLNumber) obj).getFloat();
            if ((Float.isNaN(f) && Float.isNaN(f10)) || f == f10) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public float getFloat() {
        if (Float.isNaN(this.mValue) && hasContent()) {
            this.mValue = Float.parseFloat(content());
        }
        return this.mValue;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int getInt() {
        if (Float.isNaN(this.mValue) && hasContent()) {
            this.mValue = Integer.parseInt(content());
        }
        return (int) this.mValue;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        float f = this.mValue;
        return iHashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0);
    }

    public boolean isInt() {
        float f = getFloat();
        return ((float) ((int) f)) == f;
    }

    public void putValue(float f) {
        this.mValue = f;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i10, int i11) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i10);
        float f = getFloat();
        int i12 = (int) f;
        if (i12 == f) {
            sb.append(i12);
        } else {
            sb.append(f);
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        float f = getFloat();
        int i10 = (int) f;
        if (i10 == f) {
            return a.f(i10, "");
        }
        return "" + f;
    }

    public CLNumber(float f) {
        super(null);
        this.mValue = f;
    }
}
