package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.collection.SimpleArrayMap;
import androidx.window.layout.c;
import java.util.ArrayList;
import java.util.List;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MotionSpec {
    private static final String TAG = "MotionSpec";
    private final SimpleArrayMap<String, MotionTiming> timings = new SimpleArrayMap<>();
    private final SimpleArrayMap<String, PropertyValuesHolder[]> propertyValues = new SimpleArrayMap<>();

    private static void addInfoFromAnimator(@NonNull MotionSpec motionSpec, Animator animator) {
        if (!(animator instanceof ObjectAnimator)) {
            c.j(animator, "Animator must be an ObjectAnimator: ");
            return;
        }
        ObjectAnimator objectAnimator = (ObjectAnimator) animator;
        motionSpec.setPropertyValues(objectAnimator.getPropertyName(), objectAnimator.getValues());
        motionSpec.setTiming(objectAnimator.getPropertyName(), MotionTiming.createFromAnimator(objectAnimator));
    }

    @NonNull
    private PropertyValuesHolder[] clonePropertyValuesHolder(@NonNull PropertyValuesHolder[] propertyValuesHolderArr) {
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i10 = 0; i10 < propertyValuesHolderArr.length; i10++) {
            propertyValuesHolderArr2[i10] = propertyValuesHolderArr[i10].clone();
        }
        return propertyValuesHolderArr2;
    }

    @Nullable
    public static MotionSpec createFromAttribute(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i10) {
        int resourceId;
        if (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return createFromResource(context, resourceId);
    }

    @Nullable
    public static MotionSpec createFromResource(@NonNull Context context, @AnimatorRes int i10) throws Resources.NotFoundException {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i10);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return createSpecFromAnimators(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return createSpecFromAnimators(arrayList);
        } catch (Exception e) {
            Log.w(TAG, "Can't load animation resource ID #0x" + Integer.toHexString(i10), e);
            return null;
        }
    }

    @NonNull
    private static MotionSpec createSpecFromAnimators(@NonNull List<Animator> list) {
        MotionSpec motionSpec = new MotionSpec();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            addInfoFromAnimator(motionSpec, list.get(i10));
        }
        return motionSpec;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MotionSpec) {
            return this.timings.equals(((MotionSpec) obj).timings);
        }
        return false;
    }

    @NonNull
    public <T> ObjectAnimator getAnimator(@NonNull String str, @NonNull T t, @NonNull Property<T, ?> property) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(t, getPropertyValues(str));
        objectAnimatorOfPropertyValuesHolder.setProperty(property);
        getTiming(str).apply(objectAnimatorOfPropertyValuesHolder);
        return objectAnimatorOfPropertyValuesHolder;
    }

    @NonNull
    public PropertyValuesHolder[] getPropertyValues(String str) {
        if (hasPropertyValues(str)) {
            return clonePropertyValuesHolder(this.propertyValues.get(str));
        }
        f.a();
        return null;
    }

    public MotionTiming getTiming(String str) {
        if (hasTiming(str)) {
            return this.timings.get(str);
        }
        f.a();
        return null;
    }

    public long getTotalDuration() {
        int size = this.timings.size();
        long jMax = 0;
        for (int i10 = 0; i10 < size; i10++) {
            MotionTiming motionTimingValueAt = this.timings.valueAt(i10);
            jMax = Math.max(jMax, motionTimingValueAt.getDuration() + motionTimingValueAt.getDelay());
        }
        return jMax;
    }

    public boolean hasPropertyValues(String str) {
        return this.propertyValues.get(str) != null;
    }

    public boolean hasTiming(String str) {
        return this.timings.get(str) != null;
    }

    public int hashCode() {
        return this.timings.hashCode();
    }

    public void setPropertyValues(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.propertyValues.put(str, propertyValuesHolderArr);
    }

    public void setTiming(String str, @Nullable MotionTiming motionTiming) {
        this.timings.put(str, motionTiming);
    }

    @NonNull
    public String toString() {
        return "\n" + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.timings + "}\n";
    }
}
