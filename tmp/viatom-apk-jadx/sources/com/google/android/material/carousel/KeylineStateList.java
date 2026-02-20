package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.CarouselStrategy;
import com.google.android.material.carousel.KeylineState;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class KeylineStateList {
    private static final int NO_INDEX = -1;
    private final KeylineState defaultState;
    private final float endShiftRange;
    private final List<KeylineState> endStateSteps;
    private final float[] endStateStepsInterpolationPoints;
    private final float startShiftRange;
    private final List<KeylineState> startStateSteps;
    private final float[] startStateStepsInterpolationPoints;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.google.android.material.carousel.KeylineStateList$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$material$carousel$CarouselStrategy$StrategyType;

        static {
            int[] iArr = new int[CarouselStrategy.StrategyType.values().length];
            $SwitchMap$com$google$android$material$carousel$CarouselStrategy$StrategyType = iArr;
            try {
                iArr[CarouselStrategy.StrategyType.CONTAINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private KeylineStateList(@NonNull KeylineState keylineState, List<KeylineState> list, List<KeylineState> list2) {
        this.defaultState = keylineState;
        this.startStateSteps = DesugarCollections.unmodifiableList(list);
        this.endStateSteps = DesugarCollections.unmodifiableList(list2);
        float f = ((KeylineState) a3.a.e(1, list)).getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
        this.startShiftRange = f;
        float f10 = keylineState.getLastKeyline().loc - ((KeylineState) a3.a.e(1, list2)).getLastKeyline().loc;
        this.endShiftRange = f10;
        this.startStateStepsInterpolationPoints = getStateStepInterpolationPoints(f, list, true);
        this.endStateStepsInterpolationPoints = getStateStepInterpolationPoints(f10, list2, false);
    }

    private KeylineState closestStateStepFromInterpolation(List<KeylineState> list, float f, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f, fArr);
        return stateStepsRange[0] >= 0.5f ? list.get((int) stateStepsRange[2]) : list.get((int) stateStepsRange[1]);
    }

    private static int findFirstIndexAfterLastFocalKeylineWithMask(KeylineState keylineState, float f) {
        for (int lastFocalKeylineIndex = keylineState.getLastFocalKeylineIndex(); lastFocalKeylineIndex < keylineState.getKeylines().size(); lastFocalKeylineIndex++) {
            if (f == keylineState.getKeylines().get(lastFocalKeylineIndex).mask) {
                return lastFocalKeylineIndex;
            }
        }
        return keylineState.getKeylines().size() - 1;
    }

    private static int findFirstNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int i10 = 0; i10 < keylineState.getKeylines().size(); i10++) {
            if (!keylineState.getKeylines().get(i10).isAnchor) {
                return i10;
            }
        }
        return -1;
    }

    private static int findLastIndexBeforeFirstFocalKeylineWithMask(KeylineState keylineState, float f) {
        for (int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - 1; firstFocalKeylineIndex >= 0; firstFocalKeylineIndex--) {
            if (f == keylineState.getKeylines().get(firstFocalKeylineIndex).mask) {
                return firstFocalKeylineIndex;
            }
        }
        return 0;
    }

    private static int findLastNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int size = keylineState.getKeylines().size() - 1; size >= 0; size--) {
            if (!keylineState.getKeylines().get(size).isAnchor) {
                return size;
            }
        }
        return -1;
    }

    public static KeylineStateList from(Carousel carousel, KeylineState keylineState, float f, float f10, float f11, CarouselStrategy.StrategyType strategyType) {
        return new KeylineStateList(keylineState, getStateStepsStart(carousel, keylineState, f, f10, strategyType), getStateStepsEnd(carousel, keylineState, f, f11, strategyType));
    }

    private static float[] getStateStepInterpolationPoints(float f, List<KeylineState> list, boolean z9) {
        int size = list.size();
        float[] fArr = new float[size];
        int i10 = 1;
        while (i10 < size) {
            int i11 = i10 - 1;
            KeylineState keylineState = list.get(i11);
            KeylineState keylineState2 = list.get(i10);
            fArr[i10] = i10 == size + (-1) ? 1.0f : fArr[i11] + ((z9 ? keylineState2.getFirstKeyline().loc - keylineState.getFirstKeyline().loc : keylineState.getLastKeyline().loc - keylineState2.getLastKeyline().loc) / f);
            i10++;
        }
        return fArr;
    }

    private static List<KeylineState> getStateStepsEnd(Carousel carousel, KeylineState keylineState, float f, float f10, CarouselStrategy.StrategyType strategyType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int iFindLastNonAnchorKeylineIndex = findLastNonAnchorKeylineIndex(keylineState);
        int containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        if (!isLastFocalItemVisibleAtRightOfContainer(carousel, keylineState) && iFindLastNonAnchorKeylineIndex != -1) {
            int lastFocalKeylineIndex = iFindLastNonAnchorKeylineIndex - keylineState.getLastFocalKeylineIndex();
            float f11 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            if (lastFocalKeylineIndex <= 0 && keylineState.getLastFocalKeyline().cutoff > 0.0f) {
                arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState, (f11 - keylineState.getLastFocalKeyline().cutoff) - f10, containerWidth));
                return arrayList;
            }
            float f12 = 0.0f;
            int i10 = 0;
            while (i10 < lastFocalKeylineIndex) {
                KeylineState keylineState2 = (KeylineState) androidx.constraintlayout.core.widgets.analyzer.a.t(arrayList, 1);
                int i11 = iFindLastNonAnchorKeylineIndex - i10;
                float f13 = f12 + keylineState.getKeylines().get(i11).cutoff;
                int i12 = i11 + 1;
                int i13 = containerWidth;
                KeylineState keylineStateMoveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState2, iFindLastNonAnchorKeylineIndex, i12 < keylineState.getKeylines().size() ? findLastIndexBeforeFirstFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i12).mask) + 1 : 0, f11 - f13, keylineState.getFirstFocalKeylineIndex() + i10 + 1, keylineState.getLastFocalKeylineIndex() + i10 + 1, i13);
                containerWidth = i13;
                if (i10 == lastFocalKeylineIndex - 1 && f10 > 0.0f) {
                    keylineStateMoveKeylineAndCreateKeylineState = shiftKeylineStateForPadding(keylineStateMoveKeylineAndCreateKeylineState, f10, containerWidth, false, f, strategyType);
                }
                arrayList.add(keylineStateMoveKeylineAndCreateKeylineState);
                i10++;
                f12 = f13;
            }
        } else if (f10 > 0.0f) {
            arrayList.add(shiftKeylineStateForPadding(keylineState, f10, containerWidth, false, f, strategyType));
        }
        return arrayList;
    }

    private static float[] getStateStepsRange(List<KeylineState> list, float f, float[] fArr) {
        int size = list.size();
        float f10 = fArr[0];
        int i10 = 1;
        while (i10 < size) {
            float f11 = fArr[i10];
            if (f <= f11) {
                return new float[]{AnimationUtils.lerp(0.0f, 1.0f, f10, f11, f), i10 - 1, i10};
            }
            i10++;
            f10 = f11;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private static List<KeylineState> getStateStepsStart(Carousel carousel, KeylineState keylineState, float f, float f10, CarouselStrategy.StrategyType strategyType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int iFindFirstNonAnchorKeylineIndex = findFirstNonAnchorKeylineIndex(keylineState);
        int containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        if (!isFirstFocalItemAtLeftOfContainer(keylineState) && iFindFirstNonAnchorKeylineIndex != -1) {
            int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - iFindFirstNonAnchorKeylineIndex;
            float f11 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            if (firstFocalKeylineIndex <= 0 && keylineState.getFirstFocalKeyline().cutoff > 0.0f) {
                arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState, f11 + keylineState.getFirstFocalKeyline().cutoff + f10, containerWidth));
                return arrayList;
            }
            int i10 = 0;
            float f12 = 0.0f;
            while (i10 < firstFocalKeylineIndex) {
                KeylineState keylineState2 = (KeylineState) androidx.constraintlayout.core.widgets.analyzer.a.t(arrayList, 1);
                int i11 = iFindFirstNonAnchorKeylineIndex + i10;
                int size = keylineState.getKeylines().size() - 1;
                f12 += keylineState.getKeylines().get(i11).cutoff;
                int i12 = i11 - 1;
                if (i12 >= 0) {
                    size = findFirstIndexAfterLastFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i12).mask) - 1;
                }
                int i13 = containerWidth;
                KeylineState keylineStateMoveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState2, iFindFirstNonAnchorKeylineIndex, size, f11 + f12, (keylineState.getFirstFocalKeylineIndex() - i10) - 1, (keylineState.getLastFocalKeylineIndex() - i10) - 1, i13);
                if (i10 == firstFocalKeylineIndex - 1 && f10 > 0.0f) {
                    keylineStateMoveKeylineAndCreateKeylineState = shiftKeylineStateForPadding(keylineStateMoveKeylineAndCreateKeylineState, f10, i13, true, f, strategyType);
                    i13 = i13;
                }
                arrayList.add(keylineStateMoveKeylineAndCreateKeylineState);
                i10++;
                containerWidth = i13;
            }
        } else if (f10 > 0.0f) {
            arrayList.add(shiftKeylineStateForPadding(keylineState, f10, containerWidth, true, f, strategyType));
        }
        return arrayList;
    }

    private static boolean isFirstFocalItemAtLeftOfContainer(KeylineState keylineState) {
        return keylineState.getFirstFocalKeyline().locOffset - (keylineState.getFirstFocalKeyline().maskedItemSize / 2.0f) >= 0.0f && keylineState.getFirstFocalKeyline() == keylineState.getFirstNonAnchorKeyline();
    }

    private static boolean isLastFocalItemVisibleAtRightOfContainer(Carousel carousel, KeylineState keylineState) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        return (keylineState.getLastFocalKeyline().maskedItemSize / 2.0f) + keylineState.getLastFocalKeyline().locOffset <= ((float) containerHeight) && keylineState.getLastFocalKeyline() == keylineState.getLastNonAnchorKeyline();
    }

    private static KeylineState lerp(List<KeylineState> list, float f, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f, fArr);
        return KeylineState.lerp(list.get((int) stateStepsRange[1]), list.get((int) stateStepsRange[2]), stateStepsRange[0]);
    }

    private static KeylineState moveKeylineAndCreateKeylineState(KeylineState keylineState, int i10, int i11, float f, int i12, int i13, int i14) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        arrayList.add(i11, (KeylineState.Keyline) arrayList.remove(i10));
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), i14);
        int i15 = 0;
        while (i15 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i15);
            float f10 = keyline.maskedItemSize;
            builder.addKeyline((f10 / 2.0f) + f, keyline.mask, f10, i15 >= i12 && i15 <= i13, keyline.isAnchor, keyline.cutoff);
            f += keyline.maskedItemSize;
            i15++;
        }
        return builder.build();
    }

    @NonNull
    private static KeylineState shiftKeylineStateForPadding(@NonNull KeylineState keylineState, float f, int i10, boolean z9, float f10, CarouselStrategy.StrategyType strategyType) {
        return AnonymousClass1.$SwitchMap$com$google$android$material$carousel$CarouselStrategy$StrategyType[strategyType.ordinal()] != 1 ? shiftKeylineStateForPaddingUncontained(keylineState, f, i10, z9) : shiftKeylineStateForPaddingContained(keylineState, f, i10, z9, f10);
    }

    private static KeylineState shiftKeylineStateForPaddingContained(KeylineState keylineState, float f, int i10, boolean z9, float f10) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), i10);
        float numberOfNonAnchorKeylines = f / keylineState.getNumberOfNonAnchorKeylines();
        float f11 = z9 ? f : 0.0f;
        int i11 = 0;
        while (i11 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i11);
            if (keyline.isAnchor) {
                builder.addKeyline(keyline.locOffset, keyline.mask, keyline.maskedItemSize, false, true, keyline.cutoff);
            } else {
                boolean z10 = i11 >= keylineState.getFirstFocalKeylineIndex() && i11 <= keylineState.getLastFocalKeylineIndex();
                float f12 = keyline.maskedItemSize - numberOfNonAnchorKeylines;
                float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(f12, keylineState.getItemSize(), f10);
                float f13 = (f12 / 2.0f) + f11;
                float fAbs = Math.abs(f13 - keyline.locOffset);
                builder.addKeyline(f13, childMaskPercentage, f12, z10, false, keyline.cutoff, z9 ? fAbs : 0.0f, z9 ? 0.0f : fAbs);
                f11 += f12;
            }
            i11++;
        }
        return builder.build();
    }

    @NonNull
    private static KeylineState shiftKeylineStateForPaddingUncontained(@NonNull KeylineState keylineState, float f, int i10, boolean z9) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), i10);
        boolean z10 = true;
        int size = z9 ? 0 : arrayList.size() - 1;
        int i11 = 0;
        while (i11 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i11);
            if (keyline.isAnchor && i11 == size) {
                builder.addKeyline(keyline.locOffset, keyline.mask, keyline.maskedItemSize, false, true, keyline.cutoff);
            } else {
                float f10 = keyline.locOffset;
                float f11 = z9 ? f10 + f : f10 - f;
                float f12 = z9 ? f : 0.0f;
                float f13 = z9 ? 0.0f : f;
                boolean z11 = (i11 < keylineState.getFirstFocalKeylineIndex() || i11 > keylineState.getLastFocalKeylineIndex()) ? false : z10;
                float f14 = f11;
                float f15 = keyline.mask;
                float f16 = keyline.maskedItemSize;
                builder.addKeyline(f14, f15, f16, z11, keyline.isAnchor, Math.abs(z9 ? Math.max(0.0f, ((f16 / 2.0f) + f14) - i10) : Math.min(0.0f, f14 - (f16 / 2.0f))), f12, f13);
            }
            i11++;
            z10 = true;
        }
        return builder.build();
    }

    private static KeylineState shiftKeylinesAndCreateKeylineState(KeylineState keylineState, float f, int i10) {
        return moveKeylineAndCreateKeylineState(keylineState, 0, 0, f, keylineState.getFirstFocalKeylineIndex(), keylineState.getLastFocalKeylineIndex(), i10);
    }

    public KeylineState getDefaultState() {
        return this.defaultState;
    }

    public KeylineState getEndState() {
        return (KeylineState) a3.a.e(1, this.endStateSteps);
    }

    public Map<Integer, KeylineState> getKeylineStateForPositionMap(int i10, int i11, int i12, boolean z9) {
        float itemSize = this.defaultState.getItemSize();
        HashMap map = new HashMap();
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i13 >= i10) {
                break;
            }
            int i15 = z9 ? (i10 - i13) - 1 : i13;
            if (i15 * itemSize * (z9 ? -1 : 1) > i12 - this.endShiftRange || i13 >= i10 - this.endStateSteps.size()) {
                Integer numValueOf = Integer.valueOf(i15);
                List<KeylineState> list = this.endStateSteps;
                map.put(numValueOf, list.get(MathUtils.clamp(i14, 0, list.size() - 1)));
                i14++;
            }
            i13++;
        }
        int i16 = 0;
        for (int i17 = i10 - 1; i17 >= 0; i17--) {
            int i18 = z9 ? (i10 - i17) - 1 : i17;
            if (i18 * itemSize * (z9 ? -1 : 1) < i11 + this.startShiftRange || i17 < this.startStateSteps.size()) {
                Integer numValueOf2 = Integer.valueOf(i18);
                List<KeylineState> list2 = this.startStateSteps;
                map.put(numValueOf2, list2.get(MathUtils.clamp(i16, 0, list2.size() - 1)));
                i16++;
            }
        }
        return map;
    }

    public KeylineState getShiftedState(float f, float f10, float f11, boolean z9) {
        float fLerp;
        List<KeylineState> list;
        float[] fArr;
        float f12 = this.startShiftRange + f10;
        float f13 = f11 - this.endShiftRange;
        float f14 = getStartState().getFirstFocalKeyline().leftOrTopPaddingShift;
        float f15 = getEndState().getFirstFocalKeyline().rightOrBottomPaddingShift;
        if (this.startShiftRange == f14) {
            f12 += f14;
        }
        if (this.endShiftRange == f15) {
            f13 -= f15;
        }
        if (f < f12) {
            fLerp = AnimationUtils.lerp(1.0f, 0.0f, f10, f12, f);
            list = this.startStateSteps;
            fArr = this.startStateStepsInterpolationPoints;
        } else {
            if (f <= f13) {
                return this.defaultState;
            }
            fLerp = AnimationUtils.lerp(0.0f, 1.0f, f13, f11, f);
            list = this.endStateSteps;
            fArr = this.endStateStepsInterpolationPoints;
        }
        return z9 ? closestStateStepFromInterpolation(list, fLerp, fArr) : lerp(list, fLerp, fArr);
    }

    public KeylineState getStartState() {
        return (KeylineState) a3.a.e(1, this.startStateSteps);
    }

    @NonNull
    public KeylineState getShiftedState(float f, float f10, float f11) {
        return getShiftedState(f, f10, f11, false);
    }
}
