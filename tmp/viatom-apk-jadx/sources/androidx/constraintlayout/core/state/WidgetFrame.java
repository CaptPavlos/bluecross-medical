package androidx.constraintlayout.core.state;

import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.core.os.EnvironmentCompat;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class WidgetFrame {
    public static float phone_orientation = Float.NaN;
    public float alpha;
    public int bottom;
    public float interpolatedPos;
    public int left;
    private final HashMap<String, CustomVariable> mCustom;
    TypedBundle mMotionProperties;
    public String name;
    public float pivotX;
    public float pivotY;
    public int right;
    public float rotationX;
    public float rotationY;
    public float rotationZ;
    public float scaleX;
    public float scaleY;
    public int top;
    public float translationX;
    public float translationY;
    public float translationZ;
    public int visibility;
    public ConstraintWidget widget;

    public WidgetFrame(WidgetFrame widgetFrame) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
        this.widget = widgetFrame.widget;
        this.left = widgetFrame.left;
        this.top = widgetFrame.top;
        this.right = widgetFrame.right;
        this.bottom = widgetFrame.bottom;
        updateAttributes(widgetFrame);
    }

    private static void add(StringBuilder sb, String str, float f) {
        if (Float.isNaN(f)) {
            return;
        }
        sb.append(str);
        sb.append(": ");
        sb.append(f);
        sb.append(",\n");
    }

    public static void interpolate(int i10, int i11, WidgetFrame widgetFrame, WidgetFrame widgetFrame2, WidgetFrame widgetFrame3, Transition transition, float f) {
        int i12;
        int i13;
        int i14;
        float f10;
        int i15;
        float f11;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        float f12 = 100.0f * f;
        int i21 = (int) f12;
        int i22 = widgetFrame2.left;
        int i23 = widgetFrame2.top;
        int i24 = widgetFrame3.left;
        int i25 = widgetFrame3.top;
        int i26 = widgetFrame2.right - i22;
        int i27 = widgetFrame2.bottom - i23;
        int i28 = widgetFrame3.right - i24;
        int i29 = widgetFrame3.bottom - i25;
        int i30 = i22;
        float f13 = widgetFrame2.alpha;
        float f14 = widgetFrame3.alpha;
        if (widgetFrame2.visibility == 8) {
            int i31 = i30 - ((int) (i28 / 2.0f));
            i14 = i23 - ((int) (i29 / 2.0f));
            if (Float.isNaN(f13)) {
                i12 = i29;
                i30 = i31;
                i13 = i28;
                f10 = 0.0f;
            } else {
                i30 = i31;
                i13 = i28;
                f10 = f13;
                i12 = i29;
            }
        } else {
            i12 = i29;
            i29 = i27;
            i13 = i26;
            i14 = i23;
            f10 = f13;
        }
        if (widgetFrame3.visibility == 8) {
            i24 -= (int) (i13 / 2.0f);
            i25 -= (int) (i29 / 2.0f);
            if (Float.isNaN(f14)) {
                i15 = i29;
                i28 = i13;
                f14 = 0.0f;
            } else {
                i15 = i29;
                i28 = i13;
            }
        } else {
            i15 = i12;
        }
        if (Float.isNaN(f10) && !Float.isNaN(f14)) {
            f10 = 1.0f;
        }
        if (!Float.isNaN(f10) && Float.isNaN(f14)) {
            f14 = 1.0f;
        }
        int i32 = i24;
        float f15 = widgetFrame2.visibility == 4 ? 0.0f : f10;
        int i33 = i25;
        float f16 = widgetFrame3.visibility == 4 ? 0.0f : f14;
        if (widgetFrame.widget == null || !transition.hasPositionKeyframes()) {
            f11 = f;
            i16 = i32;
            i17 = i33;
            i18 = i14;
        } else {
            Transition.KeyPosition keyPositionFindPreviousPosition = transition.findPreviousPosition(widgetFrame.widget.stringId, i21);
            int i34 = i14;
            Transition.KeyPosition keyPositionFindNextPosition = transition.findNextPosition(widgetFrame.widget.stringId, i21);
            if (keyPositionFindPreviousPosition == keyPositionFindNextPosition) {
                keyPositionFindNextPosition = null;
            }
            if (keyPositionFindPreviousPosition != null) {
                i30 = (int) (keyPositionFindPreviousPosition.mX * i10);
                i18 = (int) (keyPositionFindPreviousPosition.mY * i11);
                i19 = keyPositionFindPreviousPosition.mFrame;
            } else {
                i19 = 0;
                i18 = i34;
            }
            if (keyPositionFindNextPosition != null) {
                i16 = (int) (keyPositionFindNextPosition.mX * i10);
                i17 = (int) (keyPositionFindNextPosition.mY * i11);
                i20 = keyPositionFindNextPosition.mFrame;
            } else {
                i20 = 100;
                i16 = i32;
                i17 = i33;
            }
            f11 = (f12 - i19) / (i20 - i19);
        }
        int i35 = i30;
        widgetFrame.widget = widgetFrame2.widget;
        int i36 = (int) (((i16 - i35) * f11) + i35);
        widgetFrame.left = i36;
        int i37 = (int) ((f11 * (i17 - i18)) + i18);
        widgetFrame.top = i37;
        float f17 = 1.0f - f;
        widgetFrame.right = i36 + ((int) ((i28 * f) + (i13 * f17)));
        widgetFrame.bottom = i37 + ((int) ((i15 * f) + (f17 * i29)));
        widgetFrame.pivotX = interpolate(widgetFrame2.pivotX, widgetFrame3.pivotX, 0.5f, f);
        widgetFrame.pivotY = interpolate(widgetFrame2.pivotY, widgetFrame3.pivotY, 0.5f, f);
        widgetFrame.rotationX = interpolate(widgetFrame2.rotationX, widgetFrame3.rotationX, 0.0f, f);
        widgetFrame.rotationY = interpolate(widgetFrame2.rotationY, widgetFrame3.rotationY, 0.0f, f);
        widgetFrame.rotationZ = interpolate(widgetFrame2.rotationZ, widgetFrame3.rotationZ, 0.0f, f);
        widgetFrame.scaleX = interpolate(widgetFrame2.scaleX, widgetFrame3.scaleX, 1.0f, f);
        widgetFrame.scaleY = interpolate(widgetFrame2.scaleY, widgetFrame3.scaleY, 1.0f, f);
        widgetFrame.translationX = interpolate(widgetFrame2.translationX, widgetFrame3.translationX, 0.0f, f);
        widgetFrame.translationY = interpolate(widgetFrame2.translationY, widgetFrame3.translationY, 0.0f, f);
        widgetFrame.translationZ = interpolate(widgetFrame2.translationZ, widgetFrame3.translationZ, 0.0f, f);
        widgetFrame.alpha = interpolate(f15, f16, 1.0f, f);
        Set<String> setKeySet = widgetFrame3.mCustom.keySet();
        widgetFrame.mCustom.clear();
        for (String str : setKeySet) {
            if (widgetFrame2.mCustom.containsKey(str)) {
                CustomVariable customVariable = widgetFrame2.mCustom.get(str);
                CustomVariable customVariable2 = widgetFrame3.mCustom.get(str);
                CustomVariable customVariable3 = new CustomVariable(customVariable);
                widgetFrame.mCustom.put(str, customVariable3);
                if (customVariable.numberOfInterpolatedValues() == 1) {
                    customVariable3.setValue(Float.valueOf(interpolate(customVariable.getValueToInterpolate(), customVariable2.getValueToInterpolate(), 0.0f, f)));
                } else {
                    int iNumberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
                    float[] fArr = new float[iNumberOfInterpolatedValues];
                    float[] fArr2 = new float[iNumberOfInterpolatedValues];
                    customVariable.getValuesToInterpolate(fArr);
                    customVariable2.getValuesToInterpolate(fArr2);
                    for (int i38 = 0; i38 < iNumberOfInterpolatedValues; i38++) {
                        fArr[i38] = interpolate(fArr[i38], fArr2[i38], 0.0f, f);
                        customVariable3.setValue(fArr);
                    }
                }
            }
        }
    }

    private void serializeAnchor(StringBuilder sb, ConstraintAnchor.Type type) {
        ConstraintAnchor anchor = this.widget.getAnchor(type);
        if (anchor == null || anchor.mTarget == null) {
            return;
        }
        sb.append("Anchor");
        sb.append(type.name());
        sb.append(": ['");
        String str = anchor.mTarget.getOwner().stringId;
        if (str == null) {
            str = "#PARENT";
        }
        sb.append(str);
        sb.append("', '");
        sb.append(anchor.mTarget.getType().name());
        sb.append("', '");
        sb.append(anchor.mMargin);
        sb.append("'],\n");
    }

    public void addCustomColor(String str, int i10) {
        setCustomAttribute(str, TypedValues.Custom.TYPE_COLOR, i10);
    }

    public void addCustomFloat(String str, float f) {
        setCustomAttribute(str, TypedValues.Custom.TYPE_FLOAT, f);
    }

    public float centerX() {
        return ((this.right - r0) / 2.0f) + this.left;
    }

    public float centerY() {
        return ((this.bottom - r0) / 2.0f) + this.top;
    }

    public boolean containsCustom(@NonNull String str) {
        return this.mCustom.containsKey(str);
    }

    public CustomVariable getCustomAttribute(String str) {
        return this.mCustom.get(str);
    }

    public Set<String> getCustomAttributeNames() {
        return this.mCustom.keySet();
    }

    public int getCustomColor(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getColorValue();
        }
        return -21880;
    }

    public float getCustomFloat(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getFloatValue();
        }
        return Float.NaN;
    }

    public String getId() {
        ConstraintWidget constraintWidget = this.widget;
        return constraintWidget == null ? EnvironmentCompat.MEDIA_UNKNOWN : constraintWidget.stringId;
    }

    public TypedBundle getMotionProperties() {
        return this.mMotionProperties;
    }

    public int height() {
        return Math.max(0, this.bottom - this.top);
    }

    public boolean isDefaultTransform() {
        return Float.isNaN(this.rotationX) && Float.isNaN(this.rotationY) && Float.isNaN(this.rotationZ) && Float.isNaN(this.translationX) && Float.isNaN(this.translationY) && Float.isNaN(this.translationZ) && Float.isNaN(this.scaleX) && Float.isNaN(this.scaleY) && Float.isNaN(this.alpha);
    }

    public void logv(String str) {
        String strConcat;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sbW = a3.a.w(".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName(), " ");
        sbW.append(hashCode() % 1000);
        String string = sbW.toString();
        if (this.widget != null) {
            StringBuilder sbW2 = a3.a.w(string, "/");
            sbW2.append(this.widget.hashCode() % 1000);
            strConcat = sbW2.toString();
        } else {
            strConcat = string.concat("/NULL");
        }
        System.out.println(strConcat + " " + str);
    }

    public void parseCustom(CLElement cLElement) throws CLParsingException, NumberFormatException {
        CLObject cLObject = (CLObject) cLElement;
        int size = cLObject.size();
        for (int i10 = 0; i10 < size; i10++) {
            CLElement value = ((CLKey) cLObject.get(i10)).getValue();
            String strContent = value.content();
            if (strContent.matches("#[0-9a-fA-F]+")) {
                setCustomAttribute(this.name, TypedValues.Custom.TYPE_COLOR, Integer.parseInt(strContent.substring(1), 16));
            } else {
                boolean z9 = value instanceof CLNumber;
                String str = this.name;
                if (z9) {
                    setCustomAttribute(str, TypedValues.Custom.TYPE_FLOAT, value.getFloat());
                } else {
                    setCustomAttribute(str, TypedValues.Custom.TYPE_STRING, strContent);
                }
            }
        }
    }

    public void printCustomAttributes() {
        String strConcat;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sbW = a3.a.w(".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName(), " ");
        sbW.append(hashCode() % 1000);
        String string = sbW.toString();
        if (this.widget != null) {
            StringBuilder sbW2 = a3.a.w(string, "/");
            sbW2.append(this.widget.hashCode() % 1000);
            sbW2.append(" ");
            strConcat = sbW2.toString();
        } else {
            strConcat = string.concat("/NULL ");
        }
        HashMap<String, CustomVariable> map = this.mCustom;
        if (map != null) {
            for (String str : map.keySet()) {
                PrintStream printStream = System.out;
                StringBuilder sbV = a3.a.v(strConcat);
                sbV.append(this.mCustom.get(str).toString());
                printStream.println(sbV.toString());
            }
        }
    }

    public StringBuilder serialize(StringBuilder sb, boolean z9) {
        sb.append("{\n");
        add(sb, TtmlNode.LEFT, this.left);
        add(sb, "top", this.top);
        add(sb, TtmlNode.RIGHT, this.right);
        add(sb, "bottom", this.bottom);
        add(sb, "pivotX", this.pivotX);
        add(sb, "pivotY", this.pivotY);
        add(sb, "rotationX", this.rotationX);
        add(sb, "rotationY", this.rotationY);
        add(sb, "rotationZ", this.rotationZ);
        add(sb, "translationX", this.translationX);
        add(sb, "translationY", this.translationY);
        add(sb, "translationZ", this.translationZ);
        add(sb, "scaleX", this.scaleX);
        add(sb, "scaleY", this.scaleY);
        add(sb, "alpha", this.alpha);
        add(sb, "visibility", this.visibility);
        add(sb, "interpolatedPos", this.interpolatedPos);
        if (this.widget != null) {
            for (ConstraintAnchor.Type type : ConstraintAnchor.Type.values()) {
                serializeAnchor(sb, type);
            }
        }
        if (z9) {
            add(sb, "phone_orientation", phone_orientation);
        }
        if (z9) {
            add(sb, "phone_orientation", phone_orientation);
        }
        if (this.mCustom.size() != 0) {
            sb.append("custom : {\n");
            for (String str : this.mCustom.keySet()) {
                CustomVariable customVariable = this.mCustom.get(str);
                sb.append(str);
                sb.append(": ");
                switch (customVariable.getType()) {
                    case 900:
                        sb.append(customVariable.getIntegerValue());
                        sb.append(",\n");
                        break;
                    case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                    case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                        sb.append(customVariable.getFloatValue());
                        sb.append(",\n");
                        break;
                    case TypedValues.Custom.TYPE_COLOR /* 902 */:
                        sb.append("'");
                        sb.append(CustomVariable.colorString(customVariable.getIntegerValue()));
                        sb.append("',\n");
                        break;
                    case TypedValues.Custom.TYPE_STRING /* 903 */:
                        sb.append("'");
                        sb.append(customVariable.getStringValue());
                        sb.append("',\n");
                        break;
                    case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                        sb.append("'");
                        sb.append(customVariable.getBooleanValue());
                        sb.append("',\n");
                        break;
                }
            }
            sb.append("}\n");
        }
        sb.append("}\n");
        return sb;
    }

    public void setCustomAttribute(String str, int i10, float f) {
        boolean zContainsKey = this.mCustom.containsKey(str);
        HashMap<String, CustomVariable> map = this.mCustom;
        if (zContainsKey) {
            map.get(str).setFloatValue(f);
        } else {
            map.put(str, new CustomVariable(str, i10, f));
        }
    }

    public void setMotionAttributes(TypedBundle typedBundle) {
        this.mMotionProperties = typedBundle;
    }

    public boolean setValue(String str, CLElement cLElement) throws CLParsingException, NumberFormatException {
        str.getClass();
        switch (str) {
            case "phone_orientation":
                phone_orientation = cLElement.getFloat();
                return true;
            case "bottom":
                this.bottom = cLElement.getInt();
                return true;
            case "custom":
                parseCustom(cLElement);
                return true;
            case "rotationX":
                this.rotationX = cLElement.getFloat();
                return true;
            case "rotationY":
                this.rotationY = cLElement.getFloat();
                return true;
            case "rotationZ":
                this.rotationZ = cLElement.getFloat();
                return true;
            case "translationX":
                this.translationX = cLElement.getFloat();
                return true;
            case "translationY":
                this.translationY = cLElement.getFloat();
                return true;
            case "translationZ":
                this.translationZ = cLElement.getFloat();
                return true;
            case "pivotX":
                this.pivotX = cLElement.getFloat();
                return true;
            case "pivotY":
                this.pivotY = cLElement.getFloat();
                return true;
            case "scaleX":
                this.scaleX = cLElement.getFloat();
                return true;
            case "scaleY":
                this.scaleY = cLElement.getFloat();
                return true;
            case "top":
                this.top = cLElement.getInt();
                return true;
            case "left":
                this.left = cLElement.getInt();
                return true;
            case "alpha":
                this.alpha = cLElement.getFloat();
                return true;
            case "right":
                this.right = cLElement.getInt();
                return true;
            case "interpolatedPos":
                this.interpolatedPos = cLElement.getFloat();
                return true;
            default:
                return false;
        }
    }

    public WidgetFrame update() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget != null) {
            this.left = constraintWidget.getLeft();
            this.top = this.widget.getTop();
            this.right = this.widget.getRight();
            this.bottom = this.widget.getBottom();
            updateAttributes(this.widget.frame);
        }
        return this;
    }

    public void updateAttributes(WidgetFrame widgetFrame) {
        if (widgetFrame == null) {
            return;
        }
        this.pivotX = widgetFrame.pivotX;
        this.pivotY = widgetFrame.pivotY;
        this.rotationX = widgetFrame.rotationX;
        this.rotationY = widgetFrame.rotationY;
        this.rotationZ = widgetFrame.rotationZ;
        this.translationX = widgetFrame.translationX;
        this.translationY = widgetFrame.translationY;
        this.translationZ = widgetFrame.translationZ;
        this.scaleX = widgetFrame.scaleX;
        this.scaleY = widgetFrame.scaleY;
        this.alpha = widgetFrame.alpha;
        this.visibility = widgetFrame.visibility;
        setMotionAttributes(widgetFrame.mMotionProperties);
        this.mCustom.clear();
        for (CustomVariable customVariable : widgetFrame.mCustom.values()) {
            this.mCustom.put(customVariable.getName(), customVariable.copy());
        }
    }

    public int width() {
        return Math.max(0, this.right - this.left);
    }

    private static void add(StringBuilder sb, String str, int i10) {
        sb.append(str);
        sb.append(": ");
        sb.append(i10);
        sb.append(",\n");
    }

    public void setCustomAttribute(String str, int i10, int i11) {
        boolean zContainsKey = this.mCustom.containsKey(str);
        HashMap<String, CustomVariable> map = this.mCustom;
        if (zContainsKey) {
            map.get(str).setIntValue(i11);
        } else {
            map.put(str, new CustomVariable(str, i10, i11));
        }
    }

    public void setCustomAttribute(String str, int i10, boolean z9) {
        boolean zContainsKey = this.mCustom.containsKey(str);
        HashMap<String, CustomVariable> map = this.mCustom;
        if (zContainsKey) {
            map.get(str).setBooleanValue(z9);
        } else {
            map.put(str, new CustomVariable(str, i10, z9));
        }
    }

    public void setCustomAttribute(String str, int i10, String str2) {
        boolean zContainsKey = this.mCustom.containsKey(str);
        HashMap<String, CustomVariable> map = this.mCustom;
        if (zContainsKey) {
            map.get(str).setStringValue(str2);
        } else {
            map.put(str, new CustomVariable(str, i10, str2));
        }
    }

    public void setCustomValue(CustomAttribute customAttribute, float[] fArr) {
    }

    public WidgetFrame update(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return this;
        }
        this.widget = constraintWidget;
        update();
        return this;
    }

    public WidgetFrame(ConstraintWidget constraintWidget) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
        this.widget = constraintWidget;
    }

    public WidgetFrame() {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
    }

    public StringBuilder serialize(StringBuilder sb) {
        return serialize(sb, false);
    }

    private static float interpolate(float f, float f10, float f11, float f12) {
        boolean zIsNaN = Float.isNaN(f);
        boolean zIsNaN2 = Float.isNaN(f10);
        if (zIsNaN && zIsNaN2) {
            return Float.NaN;
        }
        if (zIsNaN) {
            f = f11;
        }
        if (zIsNaN2) {
            f10 = f11;
        }
        return a3.a.d(f10, f, f12, f);
    }
}
