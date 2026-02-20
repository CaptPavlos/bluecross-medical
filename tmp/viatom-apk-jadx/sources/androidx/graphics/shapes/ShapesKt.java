package androidx.graphics.shapes;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.collection.FloatFloatPair;
import androidx.graphics.shapes.RoundedPolygon;
import com.google.android.gms.internal.measurement.l5;
import com.google.android.material.color.utilities.Contrast;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l7.c;
import l7.d;
import t6.m;
import t6.r;
import t6.x;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ShapesKt {
    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i10, float f, float f10, float f11) {
        companion.getClass();
        if (i10 >= 3) {
            return RoundedPolygonKt.RoundedPolygon$default(i10, f / ((float) Math.cos(Utils.getFloatPi() / i10)), f10, f11, new CornerRounding(f, 0.0f, 2, null), null, 32, null);
        }
        com.google.gson.internal.a.n("Circle must have at least three vertices");
        return null;
    }

    public static /* synthetic */ RoundedPolygon circle$default(RoundedPolygon.Companion companion, int i10, float f, float f10, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 8;
        }
        if ((i11 & 2) != 0) {
            f = 1.0f;
        }
        if ((i11 & 4) != 0) {
            f10 = 0.0f;
        }
        if ((i11 & 8) != 0) {
            f11 = 0.0f;
        }
        return circle(companion, i10, f, f10, f11);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f, float f10, float f11, float f12, float f13) {
        companion.getClass();
        if (f <= 0.0f || f10 <= 0.0f) {
            com.google.gson.internal.a.n("Pill shapes must have positive width and height");
            return null;
        }
        float f14 = 2;
        float f15 = f / f14;
        float f16 = f10 / f14;
        float f17 = f15 + f12;
        float f18 = f16 + f13;
        float f19 = (-f15) + f12;
        float f20 = (-f16) + f13;
        return RoundedPolygonKt.RoundedPolygon$default(new float[]{f17, f18, f19, f18, f19, f20, f17, f20}, new CornerRounding(Math.min(f15, f16), f11), null, f12, f13, 4, null);
    }

    public static /* synthetic */ RoundedPolygon pill$default(RoundedPolygon.Companion companion, float f, float f10, float f11, float f12, float f13, int i10, Object obj) {
        float f14;
        float f15;
        float f16;
        float f17;
        RoundedPolygon.Companion companion2;
        float f18;
        if ((i10 & 1) != 0) {
            f = 2.0f;
        }
        if ((i10 & 2) != 0) {
            f10 = 1.0f;
        }
        if ((i10 & 4) != 0) {
            f11 = 0.0f;
        }
        if ((i10 & 8) != 0) {
            f12 = 0.0f;
        }
        if ((i10 & 16) != 0) {
            f14 = 0.0f;
            f17 = f11;
            f15 = f12;
            f18 = f;
            f16 = f10;
            companion2 = companion;
        } else {
            f14 = f13;
            f15 = f12;
            f16 = f10;
            f17 = f11;
            companion2 = companion;
            f18 = f;
        }
        return pill(companion2, f18, f16, f17, f15, f14);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f10, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f11, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f12, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f13, float f14, float f15) {
        List<CornerRounding> arrayList;
        companion.getClass();
        cornerRounding.getClass();
        if (f <= 0.0f || f10 <= 0.0f) {
            com.google.gson.internal.a.n("Pill shapes must have positive width and height");
            return null;
        }
        if (f11 <= 0.0f || f11 > 1.0f) {
            com.google.gson.internal.a.n("innerRadius must be between 0 and 1");
            return null;
        }
        if (list != null || cornerRounding2 == null) {
            arrayList = list;
        } else {
            d dVarN = l5.N(0, i10);
            arrayList = new ArrayList<>();
            Iterator it = dVarN.iterator();
            while (((c) it).f11089c) {
                ((x) it).nextInt();
                r.X(m.Q(cornerRounding, cornerRounding2), arrayList);
            }
        }
        return RoundedPolygonKt.RoundedPolygon(pillStarVerticesFromNumVerts(i10, f, f10, f11, f12, f13, f14, f15), cornerRounding, arrayList, f14, f15);
    }

    public static /* synthetic */ RoundedPolygon pillStar$default(RoundedPolygon.Companion companion, float f, float f10, int i10, float f11, CornerRounding cornerRounding, CornerRounding cornerRounding2, List list, float f12, float f13, float f14, float f15, int i11, Object obj) {
        float f16;
        float f17;
        float f18;
        float f19;
        CornerRounding cornerRounding3;
        List list2;
        float f20;
        CornerRounding cornerRounding4;
        float f21;
        int i12;
        RoundedPolygon.Companion companion2;
        float f22;
        if ((i11 & 1) != 0) {
            f = 2.0f;
        }
        if ((i11 & 2) != 0) {
            f10 = 1.0f;
        }
        if ((i11 & 4) != 0) {
            i10 = 8;
        }
        if ((i11 & 8) != 0) {
            f11 = 0.5f;
        }
        if ((i11 & 16) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i11 & 32) != 0) {
            cornerRounding2 = null;
        }
        if ((i11 & 64) != 0) {
            list = null;
        }
        if ((i11 & 128) != 0) {
            f12 = 0.5f;
        }
        if ((i11 & 256) != 0) {
            f13 = 0.0f;
        }
        if ((i11 & 512) != 0) {
            f14 = 0.0f;
        }
        if ((i11 & 1024) != 0) {
            f16 = 0.0f;
            f19 = f13;
            f17 = f14;
            list2 = list;
            f18 = f12;
            cornerRounding4 = cornerRounding;
            cornerRounding3 = cornerRounding2;
            i12 = i10;
            f20 = f11;
            f22 = f;
            f21 = f10;
            companion2 = companion;
        } else {
            f16 = f15;
            f17 = f14;
            f18 = f12;
            f19 = f13;
            cornerRounding3 = cornerRounding2;
            list2 = list;
            f20 = f11;
            cornerRounding4 = cornerRounding;
            f21 = f10;
            i12 = i10;
            companion2 = companion;
            f22 = f;
        }
        return pillStar(companion2, f22, f21, i12, f20, cornerRounding4, cornerRounding3, list2, f18, f19, f17, f16);
    }

    private static final float[] pillStarVerticesFromNumVerts(int i10, float f, float f10, float f11, float f12, float f13, float f14, float f15) {
        int i11;
        float f16;
        float f17;
        float f18;
        long jM9constructorimpl;
        float fMin = Math.min(f, f10);
        float f19 = f10 - f;
        if (f19 < 0.0f) {
            f19 = 0.0f;
        }
        float f20 = f - f10;
        if (f20 < 0.0f) {
            f20 = 0.0f;
        }
        float f21 = 2;
        float f22 = f19 / f21;
        float f23 = f20 / f21;
        float fInterpolate = Utils.interpolate(f11, 1.0f, f12) * Utils.getTwoPi() * fMin;
        float f24 = (f21 * f19) + (f21 * f20) + fInterpolate;
        float f25 = fInterpolate / 4;
        float f26 = f22 + f25;
        float f27 = f26 + f20;
        float f28 = f27 + f25;
        float f29 = f28 + f19;
        float f30 = f29 + f25;
        float f31 = f30 + f20;
        float f32 = f31 + f25;
        float[] fArr = {0.0f, f22, f26, f27, f28, f29, f30, f31, f32, f32 + f22, f24};
        int i12 = i10 * 2;
        float f33 = f24 / i12;
        float f34 = f13 * f24;
        float[] fArr2 = new float[i10 * 4];
        float f35 = f20;
        long jM9constructorimpl2 = FloatFloatPair.m9constructorimpl(f23, f22);
        float f36 = -f23;
        long jM9constructorimpl3 = FloatFloatPair.m9constructorimpl(f36, f22);
        float f37 = -f22;
        long jM9constructorimpl4 = FloatFloatPair.m9constructorimpl(f36, f37);
        long jM9constructorimpl5 = FloatFloatPair.m9constructorimpl(f23, f37);
        float f38 = f19;
        float f39 = f22;
        int i13 = 0;
        float f40 = 0.0f;
        boolean z9 = false;
        int i14 = 0;
        int i15 = 0;
        while (i13 < i12) {
            float f41 = f34 % f24;
            if (f41 < f40) {
                i14 = 0;
            }
            while (true) {
                int i16 = (i14 + 1) % 11;
                float f42 = fArr[i16];
                if (f41 >= f42) {
                    f39 = fArr[(i16 + 1) % 11];
                    i14 = i16;
                    f40 = f42;
                } else {
                    float f43 = (f41 - f40) / (f39 - f40);
                    if (z9) {
                        i11 = i13;
                        f16 = fMin * f11;
                    } else {
                        i11 = i13;
                        f16 = fMin;
                    }
                    switch (i14) {
                        case 0:
                            f17 = f22;
                            float f44 = f16;
                            f18 = f23;
                            jM9constructorimpl = FloatFloatPair.m9constructorimpl(f44, f43 * f17);
                            break;
                        case 1:
                            f17 = f22;
                            float f45 = f16;
                            f18 = f23;
                            jM9constructorimpl = PointKt.m63plusybeJwSQ(Utils.m79radialToCartesianL6JJ3z0$default(f45, (Utils.getFloatPi() * f43) / f21, 0L, 4, null), jM9constructorimpl2);
                            break;
                        case 2:
                            f17 = f22;
                            float f46 = f16;
                            f18 = f23;
                            jM9constructorimpl = FloatFloatPair.m9constructorimpl(f18 - (f43 * f35), f46);
                            break;
                        case 3:
                            f17 = f22;
                            float f47 = f16;
                            f18 = f23;
                            jM9constructorimpl = PointKt.m63plusybeJwSQ(Utils.m79radialToCartesianL6JJ3z0$default(f47, ((Utils.getFloatPi() * f43) / f21) + (Utils.getFloatPi() / f21), 0L, 4, null), jM9constructorimpl3);
                            break;
                        case 4:
                            f17 = f22;
                            float f48 = f16;
                            f18 = f23;
                            jM9constructorimpl = FloatFloatPair.m9constructorimpl(-f48, f17 - (f43 * f38));
                            break;
                        case 5:
                            f17 = f22;
                            float f49 = f16;
                            f18 = f23;
                            jM9constructorimpl = PointKt.m63plusybeJwSQ(Utils.m79radialToCartesianL6JJ3z0$default(f49, ((Utils.getFloatPi() * f43) / f21) + Utils.getFloatPi(), 0L, 4, null), jM9constructorimpl4);
                            break;
                        case 6:
                            f17 = f22;
                            float f50 = f16;
                            f18 = f23;
                            jM9constructorimpl = FloatFloatPair.m9constructorimpl((f43 * f35) + f36, -f50);
                            break;
                        case 7:
                            f17 = f22;
                            float f51 = f16;
                            f18 = f23;
                            jM9constructorimpl = PointKt.m63plusybeJwSQ(Utils.m79radialToCartesianL6JJ3z0$default(f51, ((Utils.getFloatPi() * f43) / f21) + (Utils.getFloatPi() * 1.5f), 0L, 4, null), jM9constructorimpl5);
                            break;
                        default:
                            f17 = f22;
                            jM9constructorimpl = FloatFloatPair.m9constructorimpl(f16, (f43 * f22) + f37);
                            f18 = f23;
                            break;
                    }
                    int i17 = i15 + 1;
                    fArr2[i15] = PointKt.m59getXDnnuFBc(jM9constructorimpl) + f14;
                    i15 += 2;
                    fArr2[i17] = PointKt.m60getYDnnuFBc(jM9constructorimpl) + f15;
                    f34 += f33;
                    z9 = !z9;
                    f23 = f18;
                    i13 = i11 + 1;
                    f22 = f17;
                }
            }
        }
        return fArr2;
    }

    public static final RoundedPolygon rectangle(RoundedPolygon.Companion companion, float f, float f10, CornerRounding cornerRounding, List<CornerRounding> list, float f11, float f12) {
        companion.getClass();
        cornerRounding.getClass();
        float f13 = 2;
        float f14 = f / f13;
        float f15 = f11 - f14;
        float f16 = f10 / f13;
        float f17 = f12 - f16;
        float f18 = f14 + f11;
        float f19 = f16 + f12;
        return RoundedPolygonKt.RoundedPolygon(new float[]{f18, f19, f15, f19, f15, f17, f18, f17}, cornerRounding, list, f11, f12);
    }

    public static /* synthetic */ RoundedPolygon rectangle$default(RoundedPolygon.Companion companion, float f, float f10, CornerRounding cornerRounding, List list, float f11, float f12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f = 2.0f;
        }
        if ((i10 & 2) != 0) {
            f10 = 2.0f;
        }
        if ((i10 & 4) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i10 & 8) != 0) {
            list = null;
        }
        if ((i10 & 16) != 0) {
            f11 = 0.0f;
        }
        if ((i10 & 32) != 0) {
            f12 = 0.0f;
        }
        return rectangle(companion, f, f10, cornerRounding, list, f11, f12);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i10, float f, float f10, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list, float f11, float f12) {
        companion.getClass();
        cornerRounding.getClass();
        if (f <= 0.0f || f10 <= 0.0f) {
            com.google.gson.internal.a.n("Star radii must both be greater than 0");
            return null;
        }
        if (f10 >= f) {
            com.google.gson.internal.a.n("innerRadius must be less than radius");
            return null;
        }
        if (list == null && cornerRounding2 != null) {
            d dVarN = l5.N(0, i10);
            ArrayList arrayList = new ArrayList();
            Iterator it = dVarN.iterator();
            while (((c) it).f11089c) {
                ((x) it).nextInt();
                r.X(m.Q(cornerRounding, cornerRounding2), arrayList);
            }
            list = arrayList;
        }
        return RoundedPolygonKt.RoundedPolygon(starVerticesFromNumVerts(i10, f, f10, f11, f12), cornerRounding, list, f11, f12);
    }

    public static /* synthetic */ RoundedPolygon star$default(RoundedPolygon.Companion companion, int i10, float f, float f10, CornerRounding cornerRounding, CornerRounding cornerRounding2, List list, float f11, float f12, int i11, Object obj) {
        return star(companion, i10, (i11 & 2) != 0 ? 1.0f : f, (i11 & 4) != 0 ? 0.5f : f10, (i11 & 8) != 0 ? CornerRounding.Unrounded : cornerRounding, (i11 & 16) != 0 ? null : cornerRounding2, (i11 & 32) == 0 ? list : null, (i11 & 64) != 0 ? 0.0f : f11, (i11 & 128) != 0 ? 0.0f : f12);
    }

    private static final float[] starVerticesFromNumVerts(int i10, float f, float f10, float f11, float f12) {
        float[] fArr = new float[i10 * 4];
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            float f13 = i10;
            long jM79radialToCartesianL6JJ3z0$default = Utils.m79radialToCartesianL6JJ3z0$default(f, (Utils.getFloatPi() / f13) * 2 * i12, 0L, 4, null);
            fArr[i11] = PointKt.m59getXDnnuFBc(jM79radialToCartesianL6JJ3z0$default) + f11;
            fArr[i11 + 1] = PointKt.m60getYDnnuFBc(jM79radialToCartesianL6JJ3z0$default) + f12;
            long jM79radialToCartesianL6JJ3z0$default2 = Utils.m79radialToCartesianL6JJ3z0$default(f10, (Utils.getFloatPi() / f13) * ((i12 * 2) + 1), 0L, 4, null);
            int i13 = i11 + 3;
            fArr[i11 + 2] = PointKt.m59getXDnnuFBc(jM79radialToCartesianL6JJ3z0$default2) + f11;
            i11 += 4;
            fArr[i13] = PointKt.m60getYDnnuFBc(jM79radialToCartesianL6JJ3z0$default2) + f12;
        }
        return fArr;
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i10) {
        companion.getClass();
        return circle$default(companion, i10, 0.0f, 0.0f, 0.0f, 14, null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i10, float f) {
        companion.getClass();
        return circle$default(companion, i10, f, 0.0f, 0.0f, 12, null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i10, float f, float f10) {
        companion.getClass();
        return circle$default(companion, i10, f, f10, 0.0f, 8, null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion) {
        companion.getClass();
        return circle$default(companion, 0, 0.0f, 0.0f, 0.0f, 15, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f) {
        companion.getClass();
        return pill$default(companion, f, 0.0f, 0.0f, 0.0f, 0.0f, 30, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f, float f10) {
        companion.getClass();
        return pill$default(companion, f, f10, 0.0f, 0.0f, 0.0f, 28, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f, float f10, float f11) {
        companion.getClass();
        return pill$default(companion, f, f10, f11, 0.0f, 0.0f, 24, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f, float f10, float f11, float f12) {
        companion.getClass();
        return pill$default(companion, f, f10, f11, f12, 0.0f, 16, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion) {
        companion.getClass();
        return pill$default(companion, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 31, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i10, float f) {
        companion.getClass();
        return star$default(companion, i10, f, 0.0f, null, null, null, 0.0f, 0.0f, 252, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i10, float f, float f10) {
        companion.getClass();
        return star$default(companion, i10, f, f10, null, null, null, 0.0f, 0.0f, 248, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i10, float f, float f10, CornerRounding cornerRounding) {
        companion.getClass();
        cornerRounding.getClass();
        return star$default(companion, i10, f, f10, cornerRounding, null, null, 0.0f, 0.0f, PsExtractor.VIDEO_STREAM_MASK, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i10, float f, float f10, CornerRounding cornerRounding, CornerRounding cornerRounding2) {
        companion.getClass();
        cornerRounding.getClass();
        return star$default(companion, i10, f, f10, cornerRounding, cornerRounding2, null, 0.0f, 0.0f, 224, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i10, float f, float f10, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list) {
        companion.getClass();
        cornerRounding.getClass();
        return star$default(companion, i10, f, f10, cornerRounding, cornerRounding2, list, 0.0f, 0.0f, PsExtractor.AUDIO_STREAM, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i10, float f, float f10, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list, float f11) {
        companion.getClass();
        cornerRounding.getClass();
        return star$default(companion, i10, f, f10, cornerRounding, cornerRounding2, list, f11, 0.0f, 128, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i10) {
        companion.getClass();
        return star$default(companion, i10, 0.0f, 0.0f, null, null, null, 0.0f, 0.0f, 254, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f) {
        companion.getClass();
        return pillStar$default(companion, f, 0.0f, 0, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2046, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f10) {
        companion.getClass();
        return pillStar$default(companion, f, f10, 0, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2044, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f10, int i10) {
        companion.getClass();
        return pillStar$default(companion, f, f10, i10, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2040, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f10, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f11) {
        companion.getClass();
        return pillStar$default(companion, f, f10, i10, f11, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2032, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f10, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f11, CornerRounding cornerRounding) {
        companion.getClass();
        cornerRounding.getClass();
        return pillStar$default(companion, f, f10, i10, f11, cornerRounding, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2016, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f10, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f11, CornerRounding cornerRounding, CornerRounding cornerRounding2) {
        companion.getClass();
        cornerRounding.getClass();
        return pillStar$default(companion, f, f10, i10, f11, cornerRounding, cornerRounding2, null, 0.0f, 0.0f, 0.0f, 0.0f, 1984, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f10, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f11, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list) {
        companion.getClass();
        cornerRounding.getClass();
        return pillStar$default(companion, f, f10, i10, f11, cornerRounding, cornerRounding2, list, 0.0f, 0.0f, 0.0f, 0.0f, 1920, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f10, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f11, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f12) {
        companion.getClass();
        cornerRounding.getClass();
        return pillStar$default(companion, f, f10, i10, f11, cornerRounding, cornerRounding2, list, f12, 0.0f, 0.0f, 0.0f, 1792, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f10, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f11, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f12, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f13) {
        companion.getClass();
        cornerRounding.getClass();
        return pillStar$default(companion, f, f10, i10, f11, cornerRounding, cornerRounding2, list, f12, f13, 0.0f, 0.0f, 1536, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f10, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f11, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f12, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f13, float f14) {
        companion.getClass();
        cornerRounding.getClass();
        return pillStar$default(companion, f, f10, i10, f11, cornerRounding, cornerRounding2, list, f12, f13, f14, 0.0f, 1024, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion) {
        companion.getClass();
        return pillStar$default(companion, 0.0f, 0.0f, 0, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2047, null);
    }
}
