package com.google.android.material.shape;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import com.google.android.material.R;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class StateListCornerSize {
    private static final int INITIAL_CAPACITY = 10;

    @NonNull
    private CornerSize defaultCornerSize;
    int stateCount;

    @NonNull
    int[][] stateSpecs = new int[10][];

    @NonNull
    CornerSize[] cornerSizes = new CornerSize[10];

    private void addStateCornerSize(@NonNull int[] iArr, @NonNull CornerSize cornerSize) {
        int i10 = this.stateCount;
        if (i10 == 0 || iArr.length == 0) {
            this.defaultCornerSize = cornerSize;
        }
        if (i10 >= this.stateSpecs.length) {
            growArray(i10, i10 + 10);
        }
        int[][] iArr2 = this.stateSpecs;
        int i11 = this.stateCount;
        iArr2[i11] = iArr;
        this.cornerSizes[i11] = cornerSize;
        this.stateCount = i11 + 1;
    }

    @NonNull
    public static StateListCornerSize create(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i10, @NonNull CornerSize cornerSize) throws Resources.NotFoundException {
        int next;
        int resourceId = typedArray.getResourceId(i10, 0);
        if (resourceId == 0) {
            return create(ShapeAppearanceModel.getCornerSize(typedArray, i10, cornerSize));
        }
        if (!context.getResources().getResourceTypeName(resourceId).equals("xml")) {
            return create(ShapeAppearanceModel.getCornerSize(typedArray, i10, cornerSize));
        }
        try {
            XmlResourceParser xml = context.getResources().getXml(resourceId);
            try {
                StateListCornerSize stateListCornerSize = new StateListCornerSize();
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                if (xml.getName().equals("selector")) {
                    stateListCornerSize.loadCornerSizesFromItems(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                xml.close();
                return stateListCornerSize;
            } catch (Throwable th) {
                if (xml != null) {
                    try {
                        xml.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
            return create(cornerSize);
        }
    }

    private void growArray(int i10, int i11) {
        int[][] iArr = new int[i11][];
        System.arraycopy(this.stateSpecs, 0, iArr, 0, i10);
        this.stateSpecs = iArr;
        CornerSize[] cornerSizeArr = new CornerSize[i11];
        System.arraycopy(this.cornerSizes, 0, cornerSizeArr, 0, i10);
        this.cornerSizes = cornerSizeArr;
    }

    private int indexOfStateSet(int[] iArr) {
        int[][] iArr2 = this.stateSpecs;
        for (int i10 = 0; i10 < this.stateCount; i10++) {
            if (StateSet.stateSetMatches(iArr2[i10], iArr)) {
                return i10;
            }
        }
        return -1;
    }

    private void loadCornerSizesFromItems(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayObtainAttributes = theme == null ? context.getResources().obtainAttributes(attributeSet, R.styleable.ShapeAppearance) : theme.obtainStyledAttributes(attributeSet, R.styleable.ShapeAppearance, 0, 0);
                CornerSize cornerSize = ShapeAppearanceModel.getCornerSize(typedArrayObtainAttributes, R.styleable.ShapeAppearance_cornerSize, new AbsoluteCornerSize(0.0f));
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr = new int[attributeCount];
                int i10 = 0;
                for (int i11 = 0; i11 < attributeCount; i11++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i11);
                    if (attributeNameResource != R.attr.cornerSize) {
                        int i12 = i10 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i11, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr[i10] = attributeNameResource;
                        i10 = i12;
                    }
                }
                addStateCornerSize(StateSet.trimStateSet(iArr, i10), cornerSize);
            }
        }
    }

    @NonNull
    public CornerSize getCornerSizeForState(@NonNull int[] iArr) {
        int iIndexOfStateSet = indexOfStateSet(iArr);
        if (iIndexOfStateSet < 0) {
            iIndexOfStateSet = indexOfStateSet(StateSet.WILD_CARD);
        }
        return iIndexOfStateSet < 0 ? this.defaultCornerSize : this.cornerSizes[iIndexOfStateSet];
    }

    @NonNull
    public CornerSize getDefaultCornerSize() {
        return this.defaultCornerSize;
    }

    public boolean isStateful() {
        return this.stateCount > 1;
    }

    @NonNull
    public StateListCornerSize withTransformedCornerSizes(@NonNull ShapeAppearanceModel.CornerSizeUnaryOperator cornerSizeUnaryOperator) {
        StateListCornerSize stateListCornerSize = new StateListCornerSize();
        stateListCornerSize.stateCount = this.stateCount;
        int[][] iArr = new int[this.stateSpecs.length][];
        stateListCornerSize.stateSpecs = iArr;
        int[][] iArr2 = this.stateSpecs;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        stateListCornerSize.cornerSizes = new CornerSize[this.cornerSizes.length];
        for (int i10 = 0; i10 < this.stateCount; i10++) {
            stateListCornerSize.cornerSizes[i10] = cornerSizeUnaryOperator.apply(this.cornerSizes[i10]);
        }
        return stateListCornerSize;
    }

    @NonNull
    public static StateListCornerSize create(@NonNull CornerSize cornerSize) {
        StateListCornerSize stateListCornerSize = new StateListCornerSize();
        stateListCornerSize.addStateCornerSize(StateSet.WILD_CARD, cornerSize);
        return stateListCornerSize;
    }
}
