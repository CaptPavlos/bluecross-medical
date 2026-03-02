package androidx.datastore.migrations;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.datastore.core.DataMigration;
import g7.a;
import g7.p;
import g7.q;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import s6.f;
import s6.w;
import t6.l;
import y6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SharedPreferencesMigration<T> implements DataMigration<T> {
    private final Context context;
    private final Set<String> keySet;
    private final q migrate;
    private final String name;
    private final f sharedPrefs$delegate;
    private final p shouldRunMigration;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.datastore.migrations.SharedPreferencesMigration$4, reason: invalid class name */
    public static final class AnonymousClass4 extends m implements a {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $sharedPreferencesName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Context context, String str) {
            super(0);
            this.$context = context;
            this.$sharedPreferencesName = str;
        }

        @Override // g7.a
        public final SharedPreferences invoke() {
            SharedPreferences sharedPreferences = this.$context.getSharedPreferences(this.$sharedPreferencesName, 0);
            sharedPreferences.getClass();
            return sharedPreferences;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(24)
    public static final class Api24Impl {
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @DoNotInline
        public static final boolean deleteSharedPreferences(Context context, String str) {
            context.getClass();
            str.getClass();
            return context.deleteSharedPreferences(str);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.migrations.SharedPreferencesMigration", f = "SharedPreferencesMigration.android.kt", l = {151}, m = "shouldMigrate")
    /* renamed from: androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01011 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SharedPreferencesMigration<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01011(SharedPreferencesMigration<T> sharedPreferencesMigration, w6.c cVar) {
            super(cVar);
            this.this$0 = sharedPreferencesMigration;
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.shouldMigrate(null, this);
        }
    }

    private SharedPreferencesMigration(a aVar, Set<String> set, p pVar, q qVar, Context context, String str) {
        this.shouldRunMigration = pVar;
        this.migrate = qVar;
        this.context = context;
        this.name = str;
        this.sharedPrefs$delegate = s6.a.d(aVar);
        this.keySet = set == SharedPreferencesMigration_androidKt.getMIGRATE_ALL_KEYS() ? null : l.t0(set);
    }

    private final void deleteSharedPreferences(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.deleteSharedPreferences(context, str);
            return;
        }
        File sharedPrefsFile = getSharedPrefsFile(context, str);
        File sharedPrefsBackup = getSharedPrefsBackup(sharedPrefsFile);
        sharedPrefsFile.delete();
        sharedPrefsBackup.delete();
    }

    private final SharedPreferences getSharedPrefs() {
        return (SharedPreferences) this.sharedPrefs$delegate.getValue();
    }

    private final File getSharedPrefsBackup(File file) {
        return new File(file.getPath() + ".bak");
    }

    private final File getSharedPrefsFile(Context context, String str) {
        return new File(new File(context.getApplicationInfo().dataDir, "shared_prefs"), a3.a.C(str, ".xml"));
    }

    @Override // androidx.datastore.core.DataMigration
    public Object cleanUp(w6.c cVar) throws IOException {
        Context context;
        String str;
        SharedPreferences.Editor editorEdit = getSharedPrefs().edit();
        Set<String> set = this.keySet;
        if (set == null) {
            editorEdit.clear();
        } else {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                editorEdit.remove((String) it.next());
            }
        }
        if (!editorEdit.commit()) {
            com.google.gson.internal.a.m("Unable to delete migrated keys from SharedPreferences.");
            return null;
        }
        if (getSharedPrefs().getAll().isEmpty() && (context = this.context) != null && (str = this.name) != null) {
            deleteSharedPreferences(context, str);
        }
        Set<String> set2 = this.keySet;
        if (set2 != null) {
            set2.clear();
        }
        return w.f12711a;
    }

    @Override // androidx.datastore.core.DataMigration
    public Object migrate(T t, w6.c cVar) {
        return this.migrate.invoke(new SharedPreferencesView(getSharedPrefs(), this.keySet), t, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.datastore.core.DataMigration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object shouldMigrate(T r5, w6.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.datastore.migrations.SharedPreferencesMigration.C01011
            if (r0 == 0) goto L13
            r0 = r6
            androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1 r0 = (androidx.datastore.migrations.SharedPreferencesMigration.C01011) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1 r0 = new androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L29
            java.lang.Object r5 = r0.L$0
            androidx.datastore.migrations.SharedPreferencesMigration r5 = (androidx.datastore.migrations.SharedPreferencesMigration) r5
            s6.a.e(r6)
            goto L43
        L29:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r5)
            r5 = 0
            return r5
        L30:
            s6.a.e(r6)
            g7.p r6 = r4.shouldRunMigration
            r0.L$0 = r4
            r0.label = r2
            java.lang.Object r6 = r6.invoke(r5, r0)
            x6.a r5 = x6.a.f13718a
            if (r6 != r5) goto L42
            return r5
        L42:
            r5 = r4
        L43:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L4e
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        L4e:
            java.util.Set<java.lang.String> r6 = r5.keySet
            r0 = 0
            if (r6 != 0) goto L67
            android.content.SharedPreferences r5 = r5.getSharedPrefs()
            java.util.Map r5 = r5.getAll()
            r5.getClass()
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L65
            goto L88
        L65:
            r2 = r0
            goto L88
        L67:
            android.content.SharedPreferences r5 = r5.getSharedPrefs()
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L72
            goto L65
        L72:
            java.util.Iterator r6 = r6.iterator()
        L76:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L65
            java.lang.Object r1 = r6.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r5.contains(r1)
            if (r1 == 0) goto L76
        L88:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.migrations.SharedPreferencesMigration.shouldMigrate(java.lang.Object, w6.c):java.lang.Object");
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.migrations.SharedPreferencesMigration$1", f = "SharedPreferencesMigration.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.migrations.SharedPreferencesMigration$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        int label;

        public AnonymousClass1(w6.c cVar) {
            super(2, cVar);
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return new AnonymousClass1(cVar);
        }

        public final Object invoke(T t, w6.c cVar) {
            return ((AnonymousClass1) create(t, cVar)).invokeSuspend(w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label == 0) {
                s6.a.e(obj);
                return Boolean.TRUE;
            }
            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
            return null;
        }

        @Override // g7.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((AnonymousClass1) obj, (w6.c) obj2);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.migrations.SharedPreferencesMigration$2", f = "SharedPreferencesMigration.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.migrations.SharedPreferencesMigration$2, reason: invalid class name */
    public static final class AnonymousClass2 extends i implements p {
        int label;

        public AnonymousClass2(w6.c cVar) {
            super(2, cVar);
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return new AnonymousClass2(cVar);
        }

        public final Object invoke(T t, w6.c cVar) {
            return ((AnonymousClass2) create(t, cVar)).invokeSuspend(w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label == 0) {
                s6.a.e(obj);
                return Boolean.TRUE;
            }
            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
            return null;
        }

        @Override // g7.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((AnonymousClass2) obj, (w6.c) obj2);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.migrations.SharedPreferencesMigration$3", f = "SharedPreferencesMigration.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.migrations.SharedPreferencesMigration$3, reason: invalid class name */
    public static final class AnonymousClass3 extends i implements p {
        int label;

        public AnonymousClass3(w6.c cVar) {
            super(2, cVar);
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return new AnonymousClass3(cVar);
        }

        public final Object invoke(T t, w6.c cVar) {
            return ((AnonymousClass3) create(t, cVar)).invokeSuspend(w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label == 0) {
                s6.a.e(obj);
                return Boolean.TRUE;
            }
            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
            return null;
        }

        @Override // g7.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((AnonymousClass3) obj, (w6.c) obj2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(Context context, String str, Set<String> set, q qVar) {
        this(context, str, set, null, qVar, 8, null);
        context.getClass();
        str.getClass();
        set.getClass();
        qVar.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(a aVar, q qVar) {
        this(aVar, (Set) null, (p) null, qVar, 6, (g) null);
        aVar.getClass();
        qVar.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(a aVar, Set<String> set, q qVar) {
        this(aVar, set, (p) null, qVar, 4, (g) null);
        aVar.getClass();
        set.getClass();
        qVar.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(Context context, String str, q qVar) {
        this(context, str, null, null, qVar, 12, null);
        context.getClass();
        str.getClass();
        qVar.getClass();
    }

    public /* synthetic */ SharedPreferencesMigration(a aVar, Set set, p pVar, q qVar, Context context, String str, int i10, g gVar) {
        this(aVar, (Set<String>) set, (i10 & 4) != 0 ? new AnonymousClass1(null) : pVar, qVar, context, str);
    }

    public /* synthetic */ SharedPreferencesMigration(a aVar, Set set, p pVar, q qVar, int i10, g gVar) {
        this(aVar, (Set<String>) ((i10 & 2) != 0 ? SharedPreferencesMigration_androidKt.getMIGRATE_ALL_KEYS() : set), (i10 & 4) != 0 ? new AnonymousClass2(null) : pVar, qVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(a aVar, Set<String> set, p pVar, q qVar) {
        this(aVar, set, pVar, qVar, (Context) null, (String) null);
        aVar.getClass();
        set.getClass();
        pVar.getClass();
        qVar.getClass();
    }

    public /* synthetic */ SharedPreferencesMigration(Context context, String str, Set set, p pVar, q qVar, int i10, g gVar) {
        this(context, str, (i10 & 4) != 0 ? SharedPreferencesMigration_androidKt.getMIGRATE_ALL_KEYS() : set, (i10 & 8) != 0 ? new AnonymousClass3(null) : pVar, qVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(Context context, String str, Set<String> set, p pVar, q qVar) {
        this(new AnonymousClass4(context, str), set, pVar, qVar, context, str);
        context.getClass();
        str.getClass();
        set.getClass();
        pVar.getClass();
        qVar.getClass();
    }
}
