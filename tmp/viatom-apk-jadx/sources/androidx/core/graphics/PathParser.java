package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.widget.R;
import androidx.privacysandbox.ads.adservices.adid.a;
import java.util.ArrayList;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PathParser {
    private static final String LOGTAG = "PathParser";

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c10, float[] fArr) {
        arrayList.add(new PathDataNode(c10, fArr));
    }

    public static boolean canMorph(@Nullable PathDataNode[] pathDataNodeArr, @Nullable PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < pathDataNodeArr.length; i10++) {
            if (pathDataNodeArr[i10].mType != pathDataNodeArr2[i10].mType || pathDataNodeArr[i10].mParams.length != pathDataNodeArr2[i10].mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] copyOfRange(float[] fArr, int i10, int i11) {
        if (i10 > i11) {
            f.a();
            return null;
        }
        int length = fArr.length;
        if (i10 < 0 || i10 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i12 = i11 - i10;
        int iMin = Math.min(i12, length - i10);
        float[] fArr2 = new float[i12];
        System.arraycopy(fArr, i10, fArr2, 0, iMin);
        return fArr2;
    }

    @NonNull
    public static PathDataNode[] createNodesFromPathData(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        int i11 = 1;
        while (i11 < str.length()) {
            int iNextStart = nextStart(str, i11);
            String strTrim = str.substring(i10, iNextStart).trim();
            if (!strTrim.isEmpty()) {
                addNode(arrayList, strTrim.charAt(0), getFloats(strTrim));
            }
            i10 = iNextStart;
            i11 = iNextStart + 1;
        }
        if (i11 - i10 == 1 && i10 < str.length()) {
            addNode(arrayList, str.charAt(i10), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[0]);
    }

    @NonNull
    public static Path createPathFromPathData(@NonNull String str) {
        Path path = new Path();
        try {
            PathDataNode.nodesToPath(createNodesFromPathData(str), path);
            return path;
        } catch (RuntimeException e) {
            a.l(a3.a.i("Error in parsing ", str), e);
            return null;
        }
    }

    @NonNull
    public static PathDataNode[] deepCopyNodes(@NonNull PathDataNode[] pathDataNodeArr) {
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i10 = 0; i10 < pathDataNodeArr.length; i10++) {
            pathDataNodeArr2[i10] = new PathDataNode(pathDataNodeArr[i10]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0039 A[LOOP:0: B:3:0x0007->B:24:0x0039, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void extract(java.lang.String r8, int r9, androidx.core.graphics.PathParser.ExtractFloatResult r10) {
        /*
            r0 = 0
            r10.mEndWithNegOrDot = r0
            r1 = r9
            r2 = r0
            r3 = r2
            r4 = r3
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3c
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L29
            r6 = 69
            if (r5 == r6) goto L35
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L35
            switch(r5) {
                case 44: goto L29;
                case 45: goto L2c;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L33
        L22:
            if (r3 != 0) goto L27
            r2 = r0
            r3 = r7
            goto L36
        L27:
            r10.mEndWithNegOrDot = r7
        L29:
            r2 = r0
            r4 = r7
            goto L36
        L2c:
            if (r1 == r9) goto L33
            if (r2 != 0) goto L33
            r10.mEndWithNegOrDot = r7
            goto L29
        L33:
            r2 = r0
            goto L36
        L35:
            r2 = r7
        L36:
            if (r4 == 0) goto L39
            goto L3c
        L39:
            int r1 = r1 + 1
            goto L7
        L3c:
            r10.mEndPosition = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.extract(java.lang.String, int, androidx.core.graphics.PathParser$ExtractFloatResult):void");
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i10 = 1;
            int i11 = 0;
            while (i10 < length) {
                extract(str, i10, extractFloatResult);
                int i12 = extractFloatResult.mEndPosition;
                if (i10 < i12) {
                    fArr[i11] = Float.parseFloat(str.substring(i10, i12));
                    i11++;
                }
                i10 = extractFloatResult.mEndWithNegOrDot ? i12 : i12 + 1;
            }
            return copyOfRange(fArr, 0, i11);
        } catch (NumberFormatException e) {
            a.l(androidx.constraintlayout.core.widgets.analyzer.a.x("error in parsing \"", str, "\""), e);
            return null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static boolean interpolatePathDataNodes(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3, float f) {
        if (pathDataNodeArr.length != pathDataNodeArr2.length || pathDataNodeArr2.length != pathDataNodeArr3.length) {
            com.google.gson.internal.a.n("The nodes to be interpolated and resulting nodes must have the same length");
            return false;
        }
        if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
            return false;
        }
        for (int i10 = 0; i10 < pathDataNodeArr.length; i10++) {
            pathDataNodeArr[i10].interpolatePathDataNode(pathDataNodeArr2[i10], pathDataNodeArr3[i10], f);
        }
        return true;
    }

    private static int nextStart(String str, int i10) {
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            if ((cCharAt - 'Z') * (cCharAt - 'A') > 0) {
                if ((cCharAt - 'z') * (cCharAt - 'a') > 0) {
                    continue;
                }
                i10++;
            }
            if (cCharAt != 'e' && cCharAt != 'E') {
                break;
            }
            i10++;
        }
        return i10;
    }

    public static void nodesToPath(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
        float[] fArr = new float[6];
        char c10 = 'm';
        for (PathDataNode pathDataNode : pathDataNodeArr) {
            PathDataNode.addCommand(path, fArr, c10, pathDataNode.mType, pathDataNode.mParams);
            c10 = pathDataNode.mType;
        }
    }

    public static void updateNodes(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2) {
        for (int i10 = 0; i10 < pathDataNodeArr2.length; i10++) {
            pathDataNodeArr[i10].mType = pathDataNodeArr2[i10].mType;
            for (int i11 = 0; i11 < pathDataNodeArr2[i10].mParams.length; i11++) {
                pathDataNodeArr[i10].mParams[i11] = pathDataNodeArr2[i10].mParams[i11];
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class PathDataNode {
        private final float[] mParams;
        private char mType;

        public PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void addCommand(Path path, float[] fArr, char c10, char c11, float[] fArr2) {
            int i10;
            int i11;
            boolean z9;
            boolean z10;
            char c12;
            char c13;
            int i12;
            float f;
            boolean z11;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            boolean z12;
            float f15;
            float f16;
            float f17;
            float f18;
            float f19;
            float f20;
            float f21;
            float f22;
            float f23;
            float f24;
            Path path2 = path;
            boolean z13 = false;
            float f25 = fArr[0];
            boolean z14 = true;
            float f26 = fArr[1];
            char c14 = 2;
            float f27 = fArr[2];
            char c15 = 3;
            float f28 = fArr[3];
            float f29 = fArr[4];
            float f30 = fArr[5];
            switch (c11) {
                case 'A':
                case 'a':
                    i10 = 7;
                    i11 = i10;
                    break;
                case 'C':
                case 'c':
                    i10 = 6;
                    i11 = i10;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case R.styleable.ConstraintSet_polarRelativeTo /* 118 */:
                    i11 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case R.styleable.ConstraintSet_pathMotionArc /* 116 */:
                default:
                    i11 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i11 = 4;
                    break;
                case 'Z':
                case R.styleable.ConstraintSet_transitionPathRotate /* 122 */:
                    path2.close();
                    path2.moveTo(f29, f30);
                    f25 = f29;
                    f27 = f25;
                    f26 = f30;
                    f28 = f26;
                    i11 = 2;
                    break;
            }
            float f31 = f25;
            float f32 = f26;
            float f33 = f29;
            float f34 = f30;
            int i13 = 0;
            char c16 = c10;
            while (i13 < fArr2.length) {
                if (c11 == 'A') {
                    float f35 = f31;
                    float f36 = f32;
                    z9 = z13;
                    z10 = z14;
                    c12 = c14;
                    c13 = c15;
                    i12 = i13;
                    int i14 = i12 + 5;
                    float f37 = fArr2[i14];
                    int i15 = i12 + 6;
                    float f38 = fArr2[i15];
                    float f39 = fArr2[i12];
                    float f40 = fArr2[i12 + 1];
                    float f41 = fArr2[i12 + 2];
                    if (fArr2[i12 + 3] != 0.0f) {
                        f = 0.0f;
                        z11 = z10;
                    } else {
                        f = 0.0f;
                        z11 = z9;
                    }
                    drawArc(path, f35, f36, f37, f38, f39, f40, f41, z11, fArr2[i12 + 4] != f ? z10 : z9);
                    f27 = fArr2[i14];
                    f31 = f27;
                    f28 = fArr2[i15];
                    f32 = f28;
                } else if (c11 == 'C') {
                    z9 = z13;
                    z10 = z14;
                    c12 = c14;
                    c13 = c15;
                    i12 = i13;
                    int i16 = i12 + 2;
                    int i17 = i12 + 3;
                    int i18 = i12 + 4;
                    int i19 = i12 + 5;
                    path2.cubicTo(fArr2[i12], fArr2[i12 + 1], fArr2[i16], fArr2[i17], fArr2[i18], fArr2[i19]);
                    float f42 = fArr2[i18];
                    float f43 = fArr2[i19];
                    float f44 = fArr2[i16];
                    float f45 = fArr2[i17];
                    f31 = f42;
                    f32 = f43;
                    f28 = f45;
                    f27 = f44;
                } else if (c11 != 'H') {
                    if (c11 != 'Q') {
                        z9 = z13;
                        if (c11 == 'V') {
                            z10 = z14;
                            c12 = c14;
                            c13 = c15;
                            i12 = i13;
                            path2.lineTo(f31, fArr2[i12]);
                            f12 = fArr2[i12];
                        } else if (c11 != 'a') {
                            if (c11 != 'c') {
                                z10 = z14;
                                if (c11 != 'h') {
                                    if (c11 != 'q') {
                                        c12 = c14;
                                        if (c11 != 'v') {
                                            if (c11 != 'L') {
                                                if (c11 != 'M') {
                                                    c13 = c15;
                                                    if (c11 == 'S') {
                                                        if (c16 == 'c' || c16 == 's' || c16 == 'C' || c16 == 'S') {
                                                            f31 = (f31 * 2.0f) - f27;
                                                            f32 = (f32 * 2.0f) - f28;
                                                        }
                                                        float f46 = f31;
                                                        float f47 = f32;
                                                        int i20 = i13 + 1;
                                                        int i21 = i13 + 2;
                                                        int i22 = i13 + 3;
                                                        path2.cubicTo(f46, f47, fArr2[i13], fArr2[i20], fArr2[i21], fArr2[i22]);
                                                        f10 = fArr2[i13];
                                                        f11 = fArr2[i20];
                                                        f31 = fArr2[i21];
                                                        f32 = fArr2[i22];
                                                        i12 = i13;
                                                    } else if (c11 == 'T') {
                                                        if (c16 == 'q' || c16 == 't' || c16 == 'Q' || c16 == 'T') {
                                                            f31 = (f31 * 2.0f) - f27;
                                                            f32 = (f32 * 2.0f) - f28;
                                                        }
                                                        int i23 = i13 + 1;
                                                        path2.quadTo(f31, f32, fArr2[i13], fArr2[i23]);
                                                        float f48 = fArr2[i13];
                                                        f12 = fArr2[i23];
                                                        f27 = f31;
                                                        f28 = f32;
                                                        i12 = i13;
                                                        f31 = f48;
                                                    } else if (c11 == 'l') {
                                                        int i24 = i13 + 1;
                                                        path2.rLineTo(fArr2[i13], fArr2[i24]);
                                                        f31 += fArr2[i13];
                                                        f18 = fArr2[i24];
                                                    } else if (c11 == 'm') {
                                                        float f49 = fArr2[i13];
                                                        f31 += f49;
                                                        float f50 = fArr2[i13 + 1];
                                                        f32 += f50;
                                                        if (i13 > 0) {
                                                            path2.rLineTo(f49, f50);
                                                        } else {
                                                            path2.rMoveTo(f49, f50);
                                                            f33 = f31;
                                                        }
                                                    } else if (c11 == 's') {
                                                        if (c16 == 'c' || c16 == 's' || c16 == 'C' || c16 == 'S') {
                                                            f21 = f32 - f28;
                                                            f22 = f31 - f27;
                                                        } else {
                                                            f22 = 0.0f;
                                                            f21 = 0.0f;
                                                        }
                                                        int i25 = i13 + 1;
                                                        int i26 = i13 + 2;
                                                        int i27 = i13 + 3;
                                                        path2.rCubicTo(f22, f21, fArr2[i13], fArr2[i25], fArr2[i26], fArr2[i27]);
                                                        f15 = fArr2[i13] + f31;
                                                        f16 = fArr2[i25] + f32;
                                                        f31 += fArr2[i26];
                                                        f17 = fArr2[i27];
                                                    } else if (c11 == 't') {
                                                        if (c16 == 'q' || c16 == 't' || c16 == 'Q' || c16 == 'T') {
                                                            f23 = f31 - f27;
                                                            f24 = f32 - f28;
                                                        } else {
                                                            f24 = 0.0f;
                                                            f23 = 0.0f;
                                                        }
                                                        int i28 = i13 + 1;
                                                        path2.rQuadTo(f23, f24, fArr2[i13], fArr2[i28]);
                                                        float f51 = f23 + f31;
                                                        float f52 = f24 + f32;
                                                        f31 += fArr2[i13];
                                                        f32 += fArr2[i28];
                                                        f28 = f52;
                                                        f27 = f51;
                                                    }
                                                } else {
                                                    c13 = c15;
                                                    f19 = fArr2[i13];
                                                    f20 = fArr2[i13 + 1];
                                                    if (i13 > 0) {
                                                        path2.lineTo(f19, f20);
                                                    } else {
                                                        path2.moveTo(f19, f20);
                                                        f31 = f19;
                                                        f33 = f31;
                                                        f32 = f20;
                                                    }
                                                }
                                                f34 = f32;
                                            } else {
                                                c13 = c15;
                                                int i29 = i13 + 1;
                                                path2.lineTo(fArr2[i13], fArr2[i29]);
                                                f19 = fArr2[i13];
                                                f20 = fArr2[i29];
                                            }
                                            f31 = f19;
                                            f32 = f20;
                                        } else {
                                            c13 = c15;
                                            path2.rLineTo(0.0f, fArr2[i13]);
                                            f18 = fArr2[i13];
                                        }
                                        f32 += f18;
                                    } else {
                                        c12 = c14;
                                        c13 = c15;
                                        int i30 = i13 + 1;
                                        int i31 = i13 + 2;
                                        int i32 = i13 + 3;
                                        path2.rQuadTo(fArr2[i13], fArr2[i30], fArr2[i31], fArr2[i32]);
                                        f15 = fArr2[i13] + f31;
                                        f16 = fArr2[i30] + f32;
                                        f31 += fArr2[i31];
                                        f17 = fArr2[i32];
                                    }
                                    f32 += f17;
                                    f27 = f15;
                                    f28 = f16;
                                } else {
                                    c12 = c14;
                                    c13 = c15;
                                    path2.rLineTo(fArr2[i13], 0.0f);
                                    f31 += fArr2[i13];
                                }
                            } else {
                                z10 = z14;
                                c12 = c14;
                                c13 = c15;
                                int i33 = i13 + 2;
                                int i34 = i13 + 3;
                                int i35 = i13 + 4;
                                int i36 = i13 + 5;
                                path2.rCubicTo(fArr2[i13], fArr2[i13 + 1], fArr2[i33], fArr2[i34], fArr2[i35], fArr2[i36]);
                                float f53 = fArr2[i33] + f31;
                                float f54 = fArr2[i34] + f32;
                                f31 += fArr2[i35];
                                f32 += fArr2[i36];
                                f27 = f53;
                                f28 = f54;
                            }
                            i12 = i13;
                        } else {
                            z10 = z14;
                            c12 = c14;
                            c13 = c15;
                            int i37 = i13 + 5;
                            float f55 = fArr2[i37] + f31;
                            int i38 = i13 + 6;
                            float f56 = fArr2[i38] + f32;
                            float f57 = fArr2[i13];
                            float f58 = fArr2[i13 + 1];
                            float f59 = fArr2[i13 + 2];
                            if (fArr2[i13 + 3] != 0.0f) {
                                f13 = 0.0f;
                                f14 = f32;
                                z12 = z10;
                            } else {
                                f13 = 0.0f;
                                f14 = f32;
                                z12 = z9;
                            }
                            i12 = i13;
                            boolean z15 = fArr2[i13 + 4] != f13 ? z10 : z9;
                            float f60 = f31;
                            drawArc(path, f60, f14, f55, f56, f57, f58, f59, z12, z15);
                            f31 = f60 + fArr2[i37];
                            f32 = f14 + fArr2[i38];
                            f27 = f31;
                            f28 = f32;
                        }
                        f32 = f12;
                    } else {
                        z9 = z13;
                        z10 = z14;
                        c12 = c14;
                        c13 = c15;
                        i12 = i13;
                        int i39 = i12 + 1;
                        int i40 = i12 + 2;
                        int i41 = i12 + 3;
                        path2.quadTo(fArr2[i12], fArr2[i39], fArr2[i40], fArr2[i41]);
                        f10 = fArr2[i12];
                        f11 = fArr2[i39];
                        f31 = fArr2[i40];
                        f32 = fArr2[i41];
                    }
                    f27 = f10;
                    f28 = f11;
                } else {
                    z9 = z13;
                    z10 = z14;
                    c12 = c14;
                    c13 = c15;
                    i12 = i13;
                    path2.lineTo(fArr2[i12], f32);
                    f31 = fArr2[i12];
                }
                i13 = i12 + i11;
                path2 = path;
                c16 = c11;
                z13 = z9;
                z14 = z10;
                c14 = c12;
                c15 = c13;
            }
            fArr[z13 ? 1 : 0] = f31;
            fArr[z14 ? 1 : 0] = f32;
            fArr[c14] = f27;
            fArr[c15] = f28;
            fArr[4] = f33;
            fArr[5] = f34;
        }

        private static void arcToBezier(Path path, double d8, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17) {
            double d18 = d11;
            int iCeil = (int) Math.ceil(Math.abs((d17 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d15);
            double dSin = Math.sin(d15);
            double dCos2 = Math.cos(d16);
            double dSin2 = Math.sin(d16);
            double d19 = -d18;
            double d20 = d19 * dCos;
            double d21 = d12 * dSin;
            double d22 = (d20 * dSin2) - (d21 * dCos2);
            double d23 = d19 * dSin;
            double d24 = d12 * dCos;
            double d25 = (dCos2 * d24) + (dSin2 * d23);
            double d26 = d17 / iCeil;
            double d27 = d25;
            double d28 = d22;
            int i10 = 0;
            double d29 = d13;
            double d30 = d14;
            double d31 = d16;
            while (i10 < iCeil) {
                double d32 = d31 + d26;
                double dSin3 = Math.sin(d32);
                double dCos3 = Math.cos(d32);
                double d33 = (((d18 * dCos) * dCos3) + d8) - (d21 * dSin3);
                int i11 = i10;
                double d34 = (d24 * dSin3) + (d11 * dSin * dCos3) + d10;
                double d35 = (d20 * dSin3) - (d21 * dCos3);
                double d36 = (dCos3 * d24) + (dSin3 * d23);
                double d37 = d32 - d31;
                double dTan = Math.tan(d37 / 2.0d);
                double dSqrt = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d37)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d28 * dSqrt) + d29), (float) ((d27 * dSqrt) + d30), (float) (d33 - (dSqrt * d35)), (float) (d34 - (dSqrt * d36)), (float) d33, (float) d34);
                dSin = dSin;
                d26 = d26;
                d29 = d33;
                d23 = d23;
                dCos = dCos;
                d27 = d36;
                d28 = d35;
                d18 = d11;
                d30 = d34;
                i10 = i11 + 1;
                iCeil = iCeil;
                d31 = d32;
            }
        }

        private static void drawArc(Path path, float f, float f10, float f11, float f12, float f13, float f14, float f15, boolean z9, boolean z10) {
            double d8;
            double d10;
            double radians = Math.toRadians(f15);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d11 = f;
            double d12 = f10;
            double d13 = f13;
            double d14 = ((d12 * dSin) + (d11 * dCos)) / d13;
            double d15 = f14;
            double d16 = ((d12 * dCos) + ((-f) * dSin)) / d15;
            double d17 = f12;
            double d18 = ((d17 * dSin) + (f11 * dCos)) / d13;
            double d19 = ((d17 * dCos) + ((-f11) * dSin)) / d15;
            double d20 = d14 - d18;
            double d21 = d16 - d19;
            double d22 = (d14 + d18) / 2.0d;
            double d23 = (d16 + d19) / 2.0d;
            double d24 = (d21 * d21) + (d20 * d20);
            if (d24 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d25 = (1.0d / d24) - 0.25d;
            if (d25 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d24);
                float fSqrt = (float) (Math.sqrt(d24) / 1.99999d);
                drawArc(path, f, f10, f11, f12, f13 * fSqrt, fSqrt * f14, f15, z9, z10);
                return;
            }
            double dSqrt = Math.sqrt(d25);
            double d26 = dSqrt * d20;
            double d27 = dSqrt * d21;
            if (z9 == z10) {
                d8 = d22 - d27;
                d10 = d23 + d26;
            } else {
                d8 = d22 + d27;
                d10 = d23 - d26;
            }
            double dAtan2 = Math.atan2(d16 - d10, d14 - d8);
            double dAtan22 = Math.atan2(d19 - d10, d18 - d8) - dAtan2;
            if (z10 != (dAtan22 >= 0.0d)) {
                dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
            }
            double d28 = d8 * d13;
            double d29 = d10 * d15;
            arcToBezier(path, (d28 * dCos) - (d29 * dSin), (d29 * dCos) + (d28 * dSin), d13, d15, d11, d12, radians, dAtan2, dAtan22);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public static void nodesToPath(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
            PathParser.nodesToPath(pathDataNodeArr, path);
        }

        @NonNull
        public float[] getParams() {
            return this.mParams;
        }

        public char getType() {
            return this.mType;
        }

        public void interpolatePathDataNode(@NonNull PathDataNode pathDataNode, @NonNull PathDataNode pathDataNode2, float f) {
            this.mType = pathDataNode.mType;
            int i10 = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i10 >= fArr.length) {
                    return;
                }
                this.mParams[i10] = (pathDataNode2.mParams[i10] * f) + ((1.0f - f) * fArr[i10]);
                i10++;
            }
        }

        public PathDataNode(char c10, float[] fArr) {
            this.mType = c10;
            this.mParams = fArr;
        }
    }

    public static void interpolatePathDataNodes(@NonNull PathDataNode[] pathDataNodeArr, float f, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3) {
        if (interpolatePathDataNodes(pathDataNodeArr, pathDataNodeArr2, pathDataNodeArr3, f)) {
            return;
        }
        com.google.gson.internal.a.n("Can't interpolate between two incompatible pathData");
    }
}
