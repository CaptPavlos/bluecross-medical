package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class EmojiExclusions {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(34)
    public static class EmojiExclusions_Api34 {
        private EmojiExclusions_Api34() {
        }

        @NonNull
        @DoNotInline
        public static Set<int[]> getExclusions() {
            return EmojiExclusions_Reflections.getExclusions();
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class EmojiExclusions_Reflections {
        private EmojiExclusions_Reflections() {
        }

        @NonNull
        @SuppressLint({"BanUncheckedReflection"})
        public static Set<int[]> getExclusions() {
            try {
                Object objInvoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", null).invoke(null, null);
                if (objInvoke == null) {
                    return Collections.EMPTY_SET;
                }
                Set<int[]> set = (Set) objInvoke;
                Iterator<int[]> it = set.iterator();
                while (it.hasNext()) {
                    if (!(it.next() instanceof int[])) {
                        return Collections.EMPTY_SET;
                    }
                }
                return set;
            } catch (Throwable unused) {
                return Collections.EMPTY_SET;
            }
        }
    }

    private EmojiExclusions() {
    }

    @NonNull
    public static Set<int[]> getEmojiExclusions() {
        return Build.VERSION.SDK_INT >= 34 ? EmojiExclusions_Api34.getExclusions() : EmojiExclusions_Reflections.getExclusions();
    }
}
