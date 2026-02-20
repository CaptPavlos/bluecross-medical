package androidx.fragment.app;

import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FragmentManagerKt {
    public static final void commit(FragmentManager fragmentManager, boolean z9, l lVar) {
        fragmentManager.getClass();
        lVar.getClass();
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.getClass();
        lVar.invoke(fragmentTransactionBeginTransaction);
        if (z9) {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commit();
        }
    }

    public static /* synthetic */ void commit$default(FragmentManager fragmentManager, boolean z9, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z9 = false;
        }
        fragmentManager.getClass();
        lVar.getClass();
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.getClass();
        lVar.invoke(fragmentTransactionBeginTransaction);
        if (z9) {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commit();
        }
    }

    public static final void commitNow(FragmentManager fragmentManager, boolean z9, l lVar) {
        fragmentManager.getClass();
        lVar.getClass();
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.getClass();
        lVar.invoke(fragmentTransactionBeginTransaction);
        if (z9) {
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commitNow();
        }
    }

    public static /* synthetic */ void commitNow$default(FragmentManager fragmentManager, boolean z9, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z9 = false;
        }
        fragmentManager.getClass();
        lVar.getClass();
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.getClass();
        lVar.invoke(fragmentTransactionBeginTransaction);
        if (z9) {
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commitNow();
        }
    }

    public static final void transaction(FragmentManager fragmentManager, boolean z9, boolean z10, l lVar) {
        fragmentManager.getClass();
        lVar.getClass();
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.getClass();
        lVar.invoke(fragmentTransactionBeginTransaction);
        if (z9) {
            if (z10) {
                fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                return;
            } else {
                fragmentTransactionBeginTransaction.commitNow();
                return;
            }
        }
        if (z10) {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commit();
        }
    }

    public static /* synthetic */ void transaction$default(FragmentManager fragmentManager, boolean z9, boolean z10, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z9 = false;
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        fragmentManager.getClass();
        lVar.getClass();
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.getClass();
        lVar.invoke(fragmentTransactionBeginTransaction);
        if (z9) {
            if (z10) {
                fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                return;
            } else {
                fragmentTransactionBeginTransaction.commitNow();
                return;
            }
        }
        if (z10) {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commit();
        }
    }
}
