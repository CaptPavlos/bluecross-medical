package androidx.constraintlayout.core.state;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLContainer;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.lang.reflect.Array;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class TransitionParser {
    private static void map(TypedBundle typedBundle, int i10, String str, String... strArr) {
        for (int i11 = 0; i11 < strArr.length; i11++) {
            if (strArr[i11].equals(str)) {
                typedBundle.add(i10, i11);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void parse(@NonNull CLObject cLObject, @NonNull Transition transition) throws CLParsingException {
        transition.resetProperties();
        String stringOrNull = cLObject.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
        TypedBundle typedBundle = new TypedBundle();
        boolean z9 = true;
        boolean z10 = false;
        if (stringOrNull != null) {
            switch (stringOrNull) {
                case "startVertical":
                    typedBundle.add(509, 1);
                    break;
                case "startHorizontal":
                    typedBundle.add(509, 2);
                    break;
                case "flip":
                    typedBundle.add(509, 3);
                    break;
                case "none":
                    typedBundle.add(509, 0);
                    break;
                case "above":
                    typedBundle.add(509, 5);
                    break;
                case "below":
                    typedBundle.add(509, 4);
                    break;
            }
            z10 = true;
        }
        String stringOrNull2 = cLObject.getStringOrNull("interpolator");
        if (stringOrNull2 != null) {
            typedBundle.add(TypedValues.TransitionType.TYPE_INTERPOLATOR, stringOrNull2);
            z10 = true;
        }
        float floatOrNaN = cLObject.getFloatOrNaN(TypedValues.TransitionType.S_STAGGERED);
        if (Float.isNaN(floatOrNaN)) {
            z9 = z10;
        } else {
            typedBundle.add(TypedValues.TransitionType.TYPE_STAGGERED, floatOrNaN);
        }
        if (z9) {
            transition.setTransitionProperties(typedBundle);
        }
        CLObject objectOrNull = cLObject.getObjectOrNull("onSwipe");
        if (objectOrNull != null) {
            parseOnSwipe(objectOrNull, transition);
        }
        parseKeyFrames(cLObject, transition);
    }

    private static void parseKeyAttribute(CLObject cLObject, Transition transition) throws CLParsingException {
        CLArray arrayOrNull;
        CustomVariable[][] customVariableArr;
        CLObject cLObject2;
        int i10;
        String[] strArr;
        CLArray arrayOrNull2 = cLObject.getArrayOrNull(TypedValues.AttributesType.S_TARGET);
        if (arrayOrNull2 == null || (arrayOrNull = cLObject.getArrayOrNull(com.mbridge.msdk.foundation.entity.b.JSON_KEY_FRAME_ADS)) == null) {
            return;
        }
        String stringOrNull = cLObject.getStringOrNull("transitionEasing");
        String[] strArr2 = {"scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha"};
        int[] iArr = {311, 312, 304, 305, 306, 308, 309, 310, 303};
        boolean[] zArr = {false, false, true, true, true, false, false, false, false};
        int size = arrayOrNull.size();
        TypedBundle[] typedBundleArr = new TypedBundle[size];
        for (int i11 = 0; i11 < arrayOrNull.size(); i11++) {
            typedBundleArr[i11] = new TypedBundle();
        }
        int i12 = 0;
        for (int i13 = 9; i12 < i13; i13 = 9) {
            String str = strArr2[i12];
            int i14 = iArr[i12];
            boolean z9 = zArr[i12];
            CLArray arrayOrNull3 = cLObject.getArrayOrNull(str);
            if (arrayOrNull3 != null && arrayOrNull3.size() != size) {
                throw new CLParsingException(androidx.constraintlayout.core.widgets.analyzer.a.x("incorrect size for ", str, " array, not matching targets array!"), cLObject);
            }
            if (arrayOrNull3 != null) {
                int i15 = 0;
                while (i15 < size) {
                    float pixels = arrayOrNull3.getFloat(i15);
                    String[] strArr3 = strArr2;
                    if (z9) {
                        pixels = transition.mToPixel.toPixels(pixels);
                    }
                    typedBundleArr[i15].add(i14, pixels);
                    i15++;
                    strArr2 = strArr3;
                }
                strArr = strArr2;
            } else {
                strArr = strArr2;
                float floatOrNaN = cLObject.getFloatOrNaN(str);
                if (!Float.isNaN(floatOrNaN)) {
                    if (z9) {
                        floatOrNaN = transition.mToPixel.toPixels(floatOrNaN);
                    }
                    for (int i16 = 0; i16 < size; i16++) {
                        typedBundleArr[i16].add(i14, floatOrNaN);
                    }
                }
            }
            i12++;
            strArr2 = strArr;
        }
        int i17 = 0;
        CLElement orNull = cLObject.getOrNull("custom");
        if (orNull == null || !(orNull instanceof CLObject)) {
            customVariableArr = null;
        } else {
            CLObject cLObject3 = (CLObject) orNull;
            int size2 = cLObject3.size();
            customVariableArr = (CustomVariable[][]) Array.newInstance((Class<?>) CustomVariable.class, arrayOrNull.size(), size2);
            int i18 = 0;
            while (i18 < size2) {
                CLKey cLKey = (CLKey) cLObject3.get(i18);
                String strContent = cLKey.content();
                if (cLKey.getValue() instanceof CLArray) {
                    CLArray cLArray = (CLArray) cLKey.getValue();
                    int size3 = cLArray.size();
                    if (size3 != size || size3 <= 0) {
                        cLObject2 = cLObject3;
                    } else {
                        int i19 = i17;
                        if (cLArray.get(i19) instanceof CLNumber) {
                            int i20 = i19;
                            while (i20 < size) {
                                customVariableArr[i20][i18] = new CustomVariable(strContent, TypedValues.Custom.TYPE_FLOAT, cLArray.get(i20).getFloat());
                                i20++;
                                cLObject3 = cLObject3;
                            }
                            cLObject2 = cLObject3;
                        } else {
                            cLObject2 = cLObject3;
                            int i21 = 0;
                            while (i21 < size) {
                                long colorString = ConstraintSetParser.parseColorString(cLArray.get(i21).content());
                                if (colorString != -1) {
                                    i10 = i21;
                                    customVariableArr[i21][i18] = new CustomVariable(strContent, TypedValues.Custom.TYPE_COLOR, (int) colorString);
                                } else {
                                    i10 = i21;
                                }
                                i21 = i10 + 1;
                            }
                        }
                    }
                } else {
                    cLObject2 = cLObject3;
                    CLElement value = cLKey.getValue();
                    if (value instanceof CLNumber) {
                        float f = value.getFloat();
                        for (int i22 = 0; i22 < size; i22++) {
                            customVariableArr[i22][i18] = new CustomVariable(strContent, TypedValues.Custom.TYPE_FLOAT, f);
                        }
                    } else {
                        long colorString2 = ConstraintSetParser.parseColorString(value.content());
                        if (colorString2 != -1) {
                            int i23 = 0;
                            while (i23 < size) {
                                customVariableArr[i23][i18] = new CustomVariable(strContent, TypedValues.Custom.TYPE_COLOR, (int) colorString2);
                                i23++;
                                size2 = size2;
                                colorString2 = colorString2;
                            }
                        }
                    }
                }
                i18++;
                size2 = size2;
                cLObject3 = cLObject2;
                i17 = 0;
            }
        }
        String stringOrNull2 = cLObject.getStringOrNull("curveFit");
        for (int i24 = 0; i24 < arrayOrNull2.size(); i24++) {
            for (int i25 = 0; i25 < size; i25++) {
                String string = arrayOrNull2.getString(i24);
                TypedBundle typedBundle = typedBundleArr[i25];
                if (stringOrNull2 != null) {
                    typedBundle.add(TypedValues.PositionType.TYPE_CURVE_FIT, map(stringOrNull2, "spline", "linear"));
                }
                typedBundle.addIfNotNull(TypedValues.PositionType.TYPE_TRANSITION_EASING, stringOrNull);
                typedBundle.add(100, arrayOrNull.getInt(i25));
                transition.addKeyAttribute(string, typedBundle, customVariableArr != null ? customVariableArr[i25] : null);
            }
        }
    }

    private static void parseKeyCycle(CLObject cLObject, Transition transition) throws CLParsingException {
        int[] iArr;
        CLArray array = cLObject.getArray(TypedValues.AttributesType.S_TARGET);
        CLArray array2 = cLObject.getArray(com.mbridge.msdk.foundation.entity.b.JSON_KEY_FRAME_ADS);
        String stringOrNull = cLObject.getStringOrNull("transitionEasing");
        String[] strArr = {"scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha", TypedValues.CycleType.S_WAVE_PERIOD, TypedValues.CycleType.S_WAVE_OFFSET, TypedValues.CycleType.S_WAVE_PHASE};
        int[] iArr2 = {311, 312, 304, 305, 306, 308, 309, 310, 403, TypedValues.CycleType.TYPE_WAVE_PERIOD, TypedValues.CycleType.TYPE_WAVE_OFFSET, TypedValues.CycleType.TYPE_WAVE_PHASE};
        int[] iArr3 = {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 2, 0};
        int size = array2.size();
        TypedBundle[] typedBundleArr = new TypedBundle[size];
        for (int i10 = 0; i10 < size; i10++) {
            typedBundleArr[i10] = new TypedBundle();
        }
        boolean z9 = false;
        for (int i11 = 0; i11 < 12; i11++) {
            if (cLObject.has(strArr[i11]) && iArr3[i11] == 1) {
                z9 = true;
            }
        }
        int i12 = 0;
        for (int i13 = 12; i12 < i13; i13 = 12) {
            String str = strArr[i12];
            int i14 = iArr2[i12];
            int i15 = iArr3[i12];
            CLArray arrayOrNull = cLObject.getArrayOrNull(str);
            String[] strArr2 = strArr;
            if (arrayOrNull != null && arrayOrNull.size() != size) {
                throw new CLParsingException("incorrect size for $attrName array, not matching targets array!", cLObject);
            }
            if (arrayOrNull != null) {
                int i16 = 0;
                while (i16 < size) {
                    float pixels = arrayOrNull.getFloat(i16);
                    int[] iArr4 = iArr2;
                    if (i15 == 1) {
                        pixels = transition.mToPixel.toPixels(pixels);
                    } else if (i15 == 2 && z9) {
                        pixels = transition.mToPixel.toPixels(pixels);
                    }
                    typedBundleArr[i16].add(i14, pixels);
                    i16++;
                    iArr2 = iArr4;
                }
                iArr = iArr2;
            } else {
                iArr = iArr2;
                float floatOrNaN = cLObject.getFloatOrNaN(str);
                if (!Float.isNaN(floatOrNaN)) {
                    if (i15 == 1) {
                        floatOrNaN = transition.mToPixel.toPixels(floatOrNaN);
                    } else if (i15 == 2 && z9) {
                        floatOrNaN = transition.mToPixel.toPixels(floatOrNaN);
                    }
                    for (int i17 = 0; i17 < size; i17++) {
                        typedBundleArr[i17].add(i14, floatOrNaN);
                    }
                }
            }
            i12++;
            strArr = strArr2;
            iArr2 = iArr;
        }
        String stringOrNull2 = cLObject.getStringOrNull("curveFit");
        String stringOrNull3 = cLObject.getStringOrNull("easing");
        String stringOrNull4 = cLObject.getStringOrNull("waveShape");
        String stringOrNull5 = cLObject.getStringOrNull(TypedValues.CycleType.S_CUSTOM_WAVE_SHAPE);
        for (int i18 = 0; i18 < array.size(); i18++) {
            for (int i19 = 0; i19 < size; i19++) {
                String string = array.getString(i18);
                TypedBundle typedBundle = typedBundleArr[i19];
                if (stringOrNull2 != null) {
                    if (stringOrNull2.equals("linear")) {
                        typedBundle.add(401, 1);
                    } else if (stringOrNull2.equals("spline")) {
                        typedBundle.add(401, 0);
                    }
                }
                typedBundle.addIfNotNull(TypedValues.PositionType.TYPE_TRANSITION_EASING, stringOrNull);
                if (stringOrNull3 != null) {
                    typedBundle.add(TypedValues.CycleType.TYPE_EASING, stringOrNull3);
                }
                if (stringOrNull4 != null) {
                    typedBundle.add(TypedValues.CycleType.TYPE_WAVE_SHAPE, stringOrNull4);
                }
                if (stringOrNull5 != null) {
                    typedBundle.add(TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, stringOrNull5);
                }
                typedBundle.add(100, array2.getInt(i19));
                transition.addKeyCycle(string, typedBundle);
            }
        }
    }

    public static void parseKeyFrames(CLObject cLObject, Transition transition) throws CLParsingException {
        CLObject objectOrNull = cLObject.getObjectOrNull("KeyFrames");
        if (objectOrNull == null) {
            return;
        }
        CLArray arrayOrNull = objectOrNull.getArrayOrNull("KeyPositions");
        if (arrayOrNull != null) {
            for (int i10 = 0; i10 < arrayOrNull.size(); i10++) {
                CLElement cLElement = arrayOrNull.get(i10);
                if (cLElement instanceof CLObject) {
                    parseKeyPosition((CLObject) cLElement, transition);
                }
            }
        }
        CLArray arrayOrNull2 = objectOrNull.getArrayOrNull(TypedValues.AttributesType.NAME);
        if (arrayOrNull2 != null) {
            for (int i11 = 0; i11 < arrayOrNull2.size(); i11++) {
                CLElement cLElement2 = arrayOrNull2.get(i11);
                if (cLElement2 instanceof CLObject) {
                    parseKeyAttribute((CLObject) cLElement2, transition);
                }
            }
        }
        CLArray arrayOrNull3 = objectOrNull.getArrayOrNull("KeyCycles");
        if (arrayOrNull3 != null) {
            for (int i12 = 0; i12 < arrayOrNull3.size(); i12++) {
                CLElement cLElement3 = arrayOrNull3.get(i12);
                if (cLElement3 instanceof CLObject) {
                    parseKeyCycle((CLObject) cLElement3, transition);
                }
            }
        }
    }

    private static void parseKeyPosition(CLObject cLObject, Transition transition) throws CLParsingException {
        TypedBundle typedBundle = new TypedBundle();
        CLArray array = cLObject.getArray(TypedValues.AttributesType.S_TARGET);
        CLArray array2 = cLObject.getArray(com.mbridge.msdk.foundation.entity.b.JSON_KEY_FRAME_ADS);
        CLArray arrayOrNull = cLObject.getArrayOrNull("percentX");
        CLArray arrayOrNull2 = cLObject.getArrayOrNull("percentY");
        CLArray arrayOrNull3 = cLObject.getArrayOrNull("percentWidth");
        CLArray arrayOrNull4 = cLObject.getArrayOrNull("percentHeight");
        String stringOrNull = cLObject.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
        String stringOrNull2 = cLObject.getStringOrNull("transitionEasing");
        String stringOrNull3 = cLObject.getStringOrNull("curveFit");
        String stringOrNull4 = cLObject.getStringOrNull(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        if (stringOrNull4 == null) {
            stringOrNull4 = "parentRelative";
        }
        if (arrayOrNull == null || array2.size() == arrayOrNull.size()) {
            if (arrayOrNull2 == null || array2.size() == arrayOrNull2.size()) {
                int i10 = 0;
                while (i10 < array.size()) {
                    String string = array.getString(i10);
                    int map = map(stringOrNull4, "deltaRelative", "pathRelative", "parentRelative");
                    typedBundle.clear();
                    typedBundle.add(TypedValues.PositionType.TYPE_POSITION_TYPE, map);
                    if (stringOrNull3 != null) {
                        map(typedBundle, TypedValues.PositionType.TYPE_CURVE_FIT, stringOrNull3, "spline", "linear");
                    }
                    typedBundle.addIfNotNull(TypedValues.PositionType.TYPE_TRANSITION_EASING, stringOrNull2);
                    if (stringOrNull != null) {
                        map(typedBundle, 509, stringOrNull, "none", "startVertical", "startHorizontal", "flip", "below", "above");
                    }
                    int i11 = 0;
                    while (i11 < array2.size()) {
                        typedBundle.add(100, array2.getInt(i11));
                        set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_X, arrayOrNull, i11);
                        set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_Y, arrayOrNull2, i11);
                        set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_WIDTH, arrayOrNull3, i11);
                        set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, arrayOrNull4, i11);
                        transition.addKeyPosition(string, typedBundle);
                        i11++;
                        stringOrNull4 = stringOrNull4;
                    }
                    i10++;
                    stringOrNull4 = stringOrNull4;
                }
            }
        }
    }

    private static void parseOnSwipe(CLContainer cLContainer, Transition transition) {
        String stringOrNull = cLContainer.getStringOrNull("anchor");
        int map = map(cLContainer.getStringOrNull("side"), Transition.OnSwipe.SIDES);
        int map2 = map(cLContainer.getStringOrNull("direction"), Transition.OnSwipe.DIRECTIONS);
        float floatOrNaN = cLContainer.getFloatOrNaN("scale");
        float floatOrNaN2 = cLContainer.getFloatOrNaN("threshold");
        float floatOrNaN3 = cLContainer.getFloatOrNaN("maxVelocity");
        float floatOrNaN4 = cLContainer.getFloatOrNaN("maxAccel");
        String stringOrNull2 = cLContainer.getStringOrNull("limitBounds");
        int map3 = map(cLContainer.getStringOrNull("mode"), Transition.OnSwipe.MODE);
        int map4 = map(cLContainer.getStringOrNull("touchUp"), Transition.OnSwipe.TOUCH_UP);
        float floatOrNaN5 = cLContainer.getFloatOrNaN("springMass");
        float floatOrNaN6 = cLContainer.getFloatOrNaN("springStiffness");
        float floatOrNaN7 = cLContainer.getFloatOrNaN("springDamping");
        float floatOrNaN8 = cLContainer.getFloatOrNaN("stopThreshold");
        int map5 = map(cLContainer.getStringOrNull("springBoundary"), Transition.OnSwipe.BOUNDARY);
        String stringOrNull3 = cLContainer.getStringOrNull("around");
        Transition.OnSwipe onSwipeCreateOnSwipe = transition.createOnSwipe();
        onSwipeCreateOnSwipe.setAnchorId(stringOrNull);
        onSwipeCreateOnSwipe.setAnchorSide(map);
        onSwipeCreateOnSwipe.setDragDirection(map2);
        onSwipeCreateOnSwipe.setDragScale(floatOrNaN);
        onSwipeCreateOnSwipe.setDragThreshold(floatOrNaN2);
        onSwipeCreateOnSwipe.setMaxVelocity(floatOrNaN3);
        onSwipeCreateOnSwipe.setMaxAcceleration(floatOrNaN4);
        onSwipeCreateOnSwipe.setLimitBoundsTo(stringOrNull2);
        onSwipeCreateOnSwipe.setAutoCompleteMode(map3);
        onSwipeCreateOnSwipe.setOnTouchUp(map4);
        onSwipeCreateOnSwipe.setSpringMass(floatOrNaN5);
        onSwipeCreateOnSwipe.setSpringStiffness(floatOrNaN6);
        onSwipeCreateOnSwipe.setSpringDamping(floatOrNaN7);
        onSwipeCreateOnSwipe.setSpringStopThreshold(floatOrNaN8);
        onSwipeCreateOnSwipe.setSpringBoundary(map5);
        onSwipeCreateOnSwipe.setRotationCenterId(stringOrNull3);
    }

    private static void set(TypedBundle typedBundle, int i10, CLArray cLArray, int i11) throws CLParsingException {
        if (cLArray != null) {
            typedBundle.add(i10, cLArray.getFloat(i11));
        }
    }

    private static int map(String str, String... strArr) {
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (strArr[i10].equals(str)) {
                return i10;
            }
        }
        return 0;
    }

    @Deprecated
    public static void parse(CLObject cLObject, Transition transition, CorePixelDp corePixelDp) throws CLParsingException {
        parse(cLObject, transition);
    }
}
