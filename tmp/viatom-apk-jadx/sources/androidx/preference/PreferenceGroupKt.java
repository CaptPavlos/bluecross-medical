package androidx.preference;

import g7.p;
import java.util.Iterator;
import kotlin.jvm.internal.l;
import n7.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PreferenceGroupKt {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.preference.PreferenceGroupKt$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<Preference>, h7.a {
        final /* synthetic */ PreferenceGroup $this_iterator;
        private int index;

        public AnonymousClass1(PreferenceGroup preferenceGroup) {
            this.$this_iterator = preferenceGroup;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.getPreferenceCount();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Preference next() {
            PreferenceGroup preferenceGroup = this.$this_iterator;
            int i10 = this.index;
            this.index = i10 + 1;
            Preference preference = preferenceGroup.getPreference(i10);
            preference.getClass();
            return preference;
        }

        @Override // java.util.Iterator
        public void remove() {
            PreferenceGroup preferenceGroup = this.$this_iterator;
            int i10 = this.index - 1;
            this.index = i10;
            preferenceGroup.removePreference(preferenceGroup.getPreference(i10));
        }
    }

    public static final boolean contains(PreferenceGroup preferenceGroup, Preference preference) {
        preferenceGroup.getClass();
        preference.getClass();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        int i10 = 0;
        while (i10 < preferenceCount) {
            int i11 = i10 + 1;
            if (l.a(preferenceGroup.getPreference(i10), preference)) {
                return true;
            }
            i10 = i11;
        }
        return false;
    }

    public static final void forEach(PreferenceGroup preferenceGroup, g7.l lVar) {
        preferenceGroup.getClass();
        lVar.getClass();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i10 = 0; i10 < preferenceCount; i10++) {
            lVar.invoke(get(preferenceGroup, i10));
        }
    }

    public static final void forEachIndexed(PreferenceGroup preferenceGroup, p pVar) {
        preferenceGroup.getClass();
        pVar.getClass();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i10 = 0; i10 < preferenceCount; i10++) {
            pVar.invoke(Integer.valueOf(i10), get(preferenceGroup, i10));
        }
    }

    public static final <T extends Preference> T get(PreferenceGroup preferenceGroup, CharSequence charSequence) {
        preferenceGroup.getClass();
        charSequence.getClass();
        return (T) preferenceGroup.findPreference(charSequence);
    }

    public static final f getChildren(final PreferenceGroup preferenceGroup) {
        preferenceGroup.getClass();
        return new f() { // from class: androidx.preference.PreferenceGroupKt$children$1
            @Override // n7.f
            public Iterator<Preference> iterator() {
                return PreferenceGroupKt.iterator(preferenceGroup);
            }
        };
    }

    public static final int getSize(PreferenceGroup preferenceGroup) {
        preferenceGroup.getClass();
        return preferenceGroup.getPreferenceCount();
    }

    public static final boolean isEmpty(PreferenceGroup preferenceGroup) {
        preferenceGroup.getClass();
        return preferenceGroup.getPreferenceCount() == 0;
    }

    public static final boolean isNotEmpty(PreferenceGroup preferenceGroup) {
        preferenceGroup.getClass();
        return preferenceGroup.getPreferenceCount() != 0;
    }

    public static final Iterator<Preference> iterator(PreferenceGroup preferenceGroup) {
        preferenceGroup.getClass();
        return new AnonymousClass1(preferenceGroup);
    }

    public static final void minusAssign(PreferenceGroup preferenceGroup, Preference preference) {
        preferenceGroup.getClass();
        preference.getClass();
        preferenceGroup.removePreference(preference);
    }

    public static final void plusAssign(PreferenceGroup preferenceGroup, Preference preference) {
        preferenceGroup.getClass();
        preference.getClass();
        preferenceGroup.addPreference(preference);
    }

    public static final Preference get(PreferenceGroup preferenceGroup, int i10) {
        preferenceGroup.getClass();
        Preference preference = preferenceGroup.getPreference(i10);
        preference.getClass();
        return preference;
    }
}
