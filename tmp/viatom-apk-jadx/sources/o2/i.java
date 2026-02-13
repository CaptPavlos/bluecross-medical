package o2;

import a3.s;
import android.content.Context;
import android.os.Build;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import g7.l;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import j$.util.DateRetargetClass;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    public static final Preferences.Key f11705b = PreferencesKeys.longKey("fire-global");

    /* renamed from: c, reason: collision with root package name */
    public static final Preferences.Key f11706c = PreferencesKeys.longKey("fire-count");

    /* renamed from: d, reason: collision with root package name */
    public static final Preferences.Key f11707d = PreferencesKeys.stringKey("last-used-date");

    /* renamed from: a, reason: collision with root package name */
    public final g2.f f11708a;

    public i(Context context, String str) {
        this.f11708a = new g2.f(context, "FirebaseHeartBeat".concat(str));
    }

    public final synchronized long a(MutablePreferences mutablePreferences) {
        long j10;
        try {
            long jLongValue = ((Long) g2.g.a(mutablePreferences, f11706c, 0L)).longValue();
            String name = "";
            Set hashSet = new HashSet();
            String str = null;
            for (Map.Entry<Preferences.Key<?>, Object> entry : mutablePreferences.asMap().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    Set<String> set = (Set) entry.getValue();
                    for (String str2 : set) {
                        if (str == null || str.compareTo(str2) > 0) {
                            name = entry.getKey().getName();
                            hashSet = set;
                            str = str2;
                        }
                    }
                }
            }
            HashSet hashSet2 = new HashSet(hashSet);
            hashSet2.remove(str);
            mutablePreferences.set(PreferencesKeys.stringSetKey(name), hashSet2);
            j10 = jLongValue - 1;
            mutablePreferences.set(f11706c, Long.valueOf(j10));
        } catch (Throwable th) {
            throw th;
        }
        return j10;
    }

    public final synchronized void b() {
        this.f11708a.a(new s(this, 15));
    }

    public final synchronized ArrayList c() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            String strD = d(System.currentTimeMillis());
            g2.f fVar = this.f11708a;
            fVar.getClass();
            for (Map.Entry entry : ((Map) y.u(w6.i.f13523a, new g2.b(fVar, null))).entrySet()) {
                if (entry.getValue() instanceof Set) {
                    HashSet hashSet = new HashSet((Set) entry.getValue());
                    hashSet.remove(strD);
                    if (!hashSet.isEmpty()) {
                        arrayList.add(new a(((Preferences.Key) entry.getKey()).getName(), new ArrayList(hashSet)));
                    }
                }
            }
            l(System.currentTimeMillis());
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public final synchronized String d(long j10) {
        if (Build.VERSION.SDK_INT >= 26) {
            return DateRetargetClass.toInstant(new Date(j10)).atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j10));
    }

    public final synchronized Preferences.Key e(MutablePreferences mutablePreferences, String str) {
        for (Map.Entry<Preferences.Key<?>, Object> entry : mutablePreferences.asMap().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return PreferencesKeys.stringSetKey(entry.getKey().getName());
                    }
                }
            }
        }
        return null;
    }

    public final synchronized boolean f(long j10, long j11) {
        return d(j10).equals(d(j11));
    }

    public final synchronized void g() {
        this.f11708a.a(new a8.d(10, this, d(System.currentTimeMillis())));
    }

    public final synchronized void h(MutablePreferences mutablePreferences, String str) {
        try {
            Preferences.Key keyE = e(mutablePreferences, str);
            if (keyE == null) {
                return;
            }
            HashSet hashSet = new HashSet((Collection) g2.g.a(mutablePreferences, keyE, new HashSet()));
            hashSet.remove(str);
            if (hashSet.isEmpty()) {
                mutablePreferences.remove(keyE);
            } else {
                mutablePreferences.set(keyE, hashSet);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean i(long j10) {
        return j(f11705b, j10);
    }

    public final synchronized boolean j(Preferences.Key key, long j10) {
        g2.f fVar = this.f11708a;
        fVar.getClass();
        key.getClass();
        g2.c cVar = new g2.c(fVar, key, null);
        w6.i iVar = w6.i.f13523a;
        if (f(((Long) y.u(iVar, cVar)).longValue(), j10)) {
            return false;
        }
        g2.f fVar2 = this.f11708a;
        Long lValueOf = Long.valueOf(j10);
        fVar2.getClass();
        return true;
    }

    public final synchronized void k(long j10, final String str) {
        final String strD = d(j10);
        final Preferences.Key<Set<String>> keyStringSetKey = PreferencesKeys.stringSetKey(str);
        this.f11708a.a(new l() { // from class: o2.h
            @Override // g7.l
            public final Object invoke(Object obj) {
                i iVar = this.f11701a;
                String str2 = strD;
                String str3 = str;
                Preferences.Key key = keyStringSetKey;
                MutablePreferences mutablePreferences = (MutablePreferences) obj;
                iVar.getClass();
                Preferences.Key key2 = i.f11707d;
                if (((String) g2.g.a(mutablePreferences, key2, "")).equals(str2)) {
                    Preferences.Key keyE = iVar.e(mutablePreferences, str2);
                    if (keyE == null || keyE.getName().equals(str3)) {
                        return null;
                    }
                    synchronized (iVar) {
                        iVar.h(mutablePreferences, str2);
                        HashSet hashSet = new HashSet((Collection) g2.g.a(mutablePreferences, key, new HashSet()));
                        hashSet.add(str2);
                        mutablePreferences.set(key, hashSet);
                    }
                    return null;
                }
                Preferences.Key key3 = i.f11706c;
                long jLongValue = ((Long) g2.g.a(mutablePreferences, key3, 0L)).longValue();
                if (jLongValue + 1 == 30) {
                    jLongValue = iVar.a(mutablePreferences);
                }
                HashSet hashSet2 = new HashSet((Collection) g2.g.a(mutablePreferences, key, new HashSet()));
                hashSet2.add(str2);
                mutablePreferences.set(key, hashSet2);
                mutablePreferences.set(key3, Long.valueOf(jLongValue + 1));
                mutablePreferences.set(key2, str2);
                return null;
            }
        });
    }

    public final synchronized void l(long j10) {
        this.f11708a.a(new androidx.room.support.c(j10, 3));
    }
}
