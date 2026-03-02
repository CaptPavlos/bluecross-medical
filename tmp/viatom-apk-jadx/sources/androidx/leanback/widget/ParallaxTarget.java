package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.animation.LinearInterpolator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class ParallaxTarget {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class DirectPropertyTarget<T, V extends Number> extends ParallaxTarget {
        Object mObject;
        Property<T, V> mProperty;

        public DirectPropertyTarget(Object obj, Property<T, V> property) {
            this.mObject = obj;
            this.mProperty = property;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.leanback.widget.ParallaxTarget
        public void directUpdate(Number number) {
            this.mProperty.set(this.mObject, number);
        }

        @Override // androidx.leanback.widget.ParallaxTarget
        public boolean isDirectMapping() {
            return true;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class PropertyValuesHolderTarget extends ParallaxTarget {
        private static final long PSEUDO_DURATION = 1000000;
        private final ObjectAnimator mAnimator;

        public PropertyValuesHolderTarget(Object obj, PropertyValuesHolder propertyValuesHolder) {
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(obj, propertyValuesHolder);
            this.mAnimator = objectAnimatorOfPropertyValuesHolder;
            objectAnimatorOfPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            objectAnimatorOfPropertyValuesHolder.setDuration(1000000L);
        }

        @Override // androidx.leanback.widget.ParallaxTarget
        public void update(float f) {
            this.mAnimator.setCurrentPlayTime((long) (f * 1000000.0f));
        }
    }

    public boolean isDirectMapping() {
        return false;
    }

    public void directUpdate(Number number) {
    }

    public void update(float f) {
    }
}
