package com.mbridge.msdk.dycreator.bus;

import android.os.Looper;
import android.util.Log;
import com.google.gson.internal.a;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class EventBus {

    /* renamed from: b, reason: collision with root package name */
    private static volatile EventBus f3208b;

    /* renamed from: n, reason: collision with root package name */
    private boolean f3216n;

    /* renamed from: a, reason: collision with root package name */
    static ExecutorService f3207a = Executors.newCachedThreadPool();
    public static String TAG = "Event";

    /* renamed from: c, reason: collision with root package name */
    private static final Map<Class<?>, List<Class<?>>> f3209c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> f3210d = new HashMap();
    private final Map<Object, List<Class<?>>> e = new HashMap();
    private final Map<Class<?>, Object> f = new ConcurrentHashMap();
    private final ThreadLocal<List<Object>> g = new ThreadLocal<List<Object>>() { // from class: com.mbridge.msdk.dycreator.bus.EventBus.1
        @Override // java.lang.ThreadLocal
        public /* synthetic */ List<Object> initialValue() {
            return new ArrayList();
        }
    };
    private final ThreadLocal<BooleanWrapper> h = new ThreadLocal<BooleanWrapper>() { // from class: com.mbridge.msdk.dycreator.bus.EventBus.2
        @Override // java.lang.ThreadLocal
        public /* synthetic */ BooleanWrapper initialValue() {
            return new BooleanWrapper();
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private String f3211i = "onEvent";

    /* renamed from: j, reason: collision with root package name */
    private final HandlerPoster f3212j = new HandlerPoster(this, Looper.getMainLooper(), 10);

    /* renamed from: k, reason: collision with root package name */
    private final BackgroundPoster f3213k = new BackgroundPoster(this);

    /* renamed from: l, reason: collision with root package name */
    private final AsyncPoster f3214l = new AsyncPoster(this);

    /* renamed from: m, reason: collision with root package name */
    private final SubscriberMethodFinder f3215m = new SubscriberMethodFinder();

    /* renamed from: o, reason: collision with root package name */
    private boolean f3217o = true;

    /* renamed from: p, reason: collision with root package name */
    private Map<String, Object> f3218p = new ConcurrentHashMap();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.dycreator.bus.EventBus$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3221a;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            f3221a = iArr;
            try {
                iArr[ThreadMode.PostThread.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3221a[ThreadMode.MainThread.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3221a[ThreadMode.BackgroundThread.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3221a[ThreadMode.Async.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class BooleanWrapper {

        /* renamed from: a, reason: collision with root package name */
        boolean f3222a;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface PostCallback {
        void onPostCompleted(List<SubscriberExceptionEvent> list);
    }

    private void a(Subscription subscription, Object obj) throws IllegalAccessException, Error, IllegalArgumentException, InvocationTargetException {
        try {
            subscription.f3240b.f3233a.invoke(subscription.f3239a, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (!(obj instanceof SubscriberExceptionEvent)) {
                if (this.f3217o) {
                    Log.e(TAG, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + subscription.f3239a.getClass(), cause);
                }
                post(new SubscriberExceptionEvent(this, cause, obj, subscription.f3239a));
                return;
            }
            Log.e(TAG, "SubscriberExceptionEvent subscriber " + subscription.f3239a.getClass() + " threw an exception", cause);
            SubscriberExceptionEvent subscriberExceptionEvent = (SubscriberExceptionEvent) obj;
            Log.e(TAG, "Initial event " + subscriberExceptionEvent.causingEvent + " caused exception in " + subscriberExceptionEvent.causingSubscriber, subscriberExceptionEvent.throwable);
        }
    }

    public static void clearCaches() {
        SubscriberMethodFinder.a();
        f3209c.clear();
    }

    public static void clearSkipMethodNameVerifications() {
        SubscriberMethodFinder.clearSkipMethodNameVerifications();
    }

    public static EventBus getDefault() {
        if (f3208b == null) {
            synchronized (EventBus.class) {
                try {
                    if (f3208b == null) {
                        f3208b = new EventBus();
                    }
                } finally {
                }
            }
        }
        return f3208b;
    }

    public static void skipMethodNameVerificationFor(Class<?> cls) {
        SubscriberMethodFinder.a(cls);
    }

    public final void configureLogSubscriberExceptions(boolean z9) {
        if (this.f3216n) {
            throw new EventBusException("This method must be called before any registration");
        }
        this.f3217o = z9;
    }

    public final Object getStickyEvent(Class<?> cls) {
        Object obj;
        synchronized (this.f) {
            obj = this.f.get(cls);
        }
        return obj;
    }

    public final void post(Object obj) {
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList;
        List<Object> list = this.g.get();
        list.add(obj);
        BooleanWrapper booleanWrapper = this.h.get();
        if (booleanWrapper.f3222a) {
            return;
        }
        boolean z9 = Looper.getMainLooper() == Looper.myLooper();
        booleanWrapper.f3222a = true;
        while (!list.isEmpty()) {
            try {
                Object objRemove = list.remove(0);
                if (objRemove != null) {
                    try {
                        Class<?> cls = objRemove.getClass();
                        List<Class<?>> listA = a(cls);
                        int size = listA.size();
                        boolean z10 = false;
                        for (int i10 = 0; i10 < size; i10++) {
                            Class<?> cls2 = listA.get(i10);
                            synchronized (this) {
                                copyOnWriteArrayList = this.f3210d.get(cls2);
                            }
                            if (copyOnWriteArrayList != null) {
                                Iterator<Subscription> it = copyOnWriteArrayList.iterator();
                                while (it.hasNext()) {
                                    a(it.next(), objRemove, z9);
                                }
                                z10 = true;
                            }
                        }
                        if (!z10) {
                            Log.d(TAG, "No subscripers registered for event " + cls);
                            if (cls != NoSubscriberEvent.class && cls != SubscriberExceptionEvent.class) {
                                post(new NoSubscriberEvent(this, objRemove));
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                booleanWrapper.f3222a = false;
            }
        }
    }

    public final void postSticky(Object obj) {
        post(obj);
        synchronized (this.f) {
            this.f.put(obj.getClass(), obj);
        }
    }

    public final void register(String str, Object obj) throws IllegalAccessException, Error, SecurityException, IllegalArgumentException, InvocationTargetException {
        Map<String, Object> map = this.f3218p;
        if (map != null && map.containsKey(str)) {
            unregister(this.f3218p.get(str));
        }
        this.f3218p.put(str, obj);
        a(obj, this.f3211i, false);
    }

    public final synchronized void registerSticky(Object obj, String str, Class<?> cls, Class<?>... clsArr) {
        a(obj, str, true, cls, clsArr);
    }

    public final void release() {
        if (f3208b != null) {
            f3208b = null;
            f3207a = null;
            Map<Class<?>, List<Class<?>>> map = f3209c;
            if (map != null && map.size() > 0) {
                map.clear();
            }
            Map<Class<?>, CopyOnWriteArrayList<Subscription>> map2 = this.f3210d;
            if (map2 != null && map2.size() > 0) {
                this.f3210d.clear();
            }
            Map<Object, List<Class<?>>> map3 = this.e;
            if (map3 != null && map3.size() > 0) {
                this.e.clear();
            }
            Map<Class<?>, Object> map4 = this.f;
            if (map4 != null && map4.size() > 0) {
                this.f.clear();
            }
            Map<String, Object> map5 = this.f3218p;
            if (map5 == null || map5.size() <= 0) {
                return;
            }
            this.f3218p.clear();
        }
    }

    public final boolean removeStickyEvent(Object obj) {
        synchronized (this.f) {
            try {
                Class<?> cls = obj.getClass();
                if (!obj.equals(this.f.get(cls))) {
                    return false;
                }
                this.f.remove(cls);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void unregister(String str) {
        try {
            Map<String, Object> map = this.f3218p;
            if (map != null && map.containsKey(str)) {
                Object objRemove = this.f3218p.remove(str);
                List<Class<?>> list = this.e.get(objRemove);
                if (list != null) {
                    Iterator<Class<?>> it = list.iterator();
                    while (it.hasNext()) {
                        a(objRemove, it.next());
                    }
                    this.e.remove(objRemove);
                } else {
                    Log.w(TAG, "Subscriber to unregister was not registered before: " + objRemove.getClass());
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void registerSticky(Object obj, String str) throws IllegalAccessException, Error, SecurityException, IllegalArgumentException, InvocationTargetException {
        a(obj, str, true);
    }

    public final void registerSticky(Object obj, Class<?> cls, Class<?>... clsArr) {
        a(obj, this.f3211i, true, cls, clsArr);
    }

    public final void registerSticky(Object obj) throws IllegalAccessException, Error, SecurityException, IllegalArgumentException, InvocationTargetException {
        a(obj, this.f3211i, true);
    }

    public final void register(Object obj) throws IllegalAccessException, Error, SecurityException, IllegalArgumentException, InvocationTargetException {
        a(obj, this.f3211i, false);
    }

    public final void register(Object obj, String str) throws IllegalAccessException, Error, SecurityException, IllegalArgumentException, InvocationTargetException {
        a(obj, str, false);
    }

    public final void register(Object obj, Class<?> cls, Class<?>... clsArr) {
        a(obj, this.f3211i, false, cls, clsArr);
    }

    public final synchronized void register(Object obj, String str, Class<?> cls, Class<?>... clsArr) {
        a(obj, str, false, cls, clsArr);
    }

    public final Object removeStickyEvent(Class<?> cls) {
        Object objRemove;
        synchronized (this.f) {
            objRemove = this.f.remove(cls);
        }
        return objRemove;
    }

    public final synchronized void unregister(Object obj) {
        try {
            List<Class<?>> list = this.e.get(obj);
            if (list != null) {
                Iterator<Class<?>> it = list.iterator();
                while (it.hasNext()) {
                    a(obj, it.next());
                }
                this.e.remove(obj);
            } else {
                Log.w(TAG, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void unregister(Object obj, Class<?>... clsArr) {
        try {
            if (clsArr.length != 0) {
                List<Class<?>> list = this.e.get(obj);
                if (list != null) {
                    for (Class<?> cls : clsArr) {
                        a(obj, cls);
                        list.remove(cls);
                    }
                    if (list.isEmpty()) {
                        this.e.remove(obj);
                    }
                } else {
                    Log.w(TAG, "Subscriber to unregister was not registered before: " + obj.getClass());
                }
            } else {
                throw new IllegalArgumentException("Provide at least one event class");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void a(Object obj, String str, boolean z9, Class<?> cls, Class<?>... clsArr) {
        try {
            for (SubscriberMethod subscriberMethod : this.f3215m.a(obj.getClass(), str)) {
                if (cls == subscriberMethod.f3235c) {
                    a(obj, subscriberMethod, z9);
                } else if (clsArr != null) {
                    int length = clsArr.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length) {
                            break;
                        }
                        if (clsArr[i10] == subscriberMethod.f3235c) {
                            a(obj, subscriberMethod, z9);
                            break;
                        }
                        i10++;
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void a(Object obj, SubscriberMethod subscriberMethod, boolean z9) throws IllegalAccessException, Error, SecurityException, IllegalArgumentException, InvocationTargetException {
        Object obj2;
        this.f3216n = true;
        Class<?> cls = subscriberMethod.f3235c;
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList = this.f3210d.get(cls);
        Subscription subscription = new Subscription(obj, subscriberMethod);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f3210d.put(cls, copyOnWriteArrayList);
        } else {
            Iterator<Subscription> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (it.next().equals(subscription)) {
                    throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
                }
            }
        }
        subscriberMethod.f3233a.setAccessible(true);
        copyOnWriteArrayList.add(subscription);
        List<Class<?>> arrayList = this.e.get(obj);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.e.put(obj, arrayList);
        }
        arrayList.add(cls);
        if (z9) {
            synchronized (this.f) {
                obj2 = this.f.get(cls);
            }
            if (obj2 != null) {
                a(subscription, obj2, Looper.getMainLooper() == Looper.myLooper());
            }
        }
    }

    private void a(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList = this.f3210d.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i10 = 0;
            while (i10 < size) {
                if (copyOnWriteArrayList.get(i10).f3239a == obj) {
                    copyOnWriteArrayList.remove(i10);
                    i10--;
                    size--;
                }
                i10++;
            }
        }
    }

    private void a(Subscription subscription, Object obj, boolean z9) throws IllegalAccessException, Error, IllegalArgumentException, InvocationTargetException {
        int i10 = AnonymousClass3.f3221a[subscription.f3240b.f3234b.ordinal()];
        if (i10 == 1) {
            a(subscription, obj);
            return;
        }
        if (i10 == 2) {
            if (z9) {
                a(subscription, obj);
                return;
            } else {
                this.f3212j.a(subscription, obj);
                return;
            }
        }
        if (i10 != 3) {
            if (i10 == 4) {
                this.f3214l.enqueue(subscription, obj);
                return;
            } else {
                a.l(subscription.f3240b.f3234b, "Unknown thread mode: ");
                return;
            }
        }
        if (z9) {
            this.f3213k.enqueue(subscription, obj);
        } else {
            a(subscription, obj);
        }
    }

    private List<Class<?>> a(Class<?> cls) {
        List<Class<?>> list;
        Map<Class<?>, List<Class<?>>> map = f3209c;
        synchronized (map) {
            try {
                List<Class<?>> list2 = map.get(cls);
                list = list2;
                if (list2 == null) {
                    ArrayList arrayList = new ArrayList();
                    for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                        arrayList.add(superclass);
                        a(arrayList, superclass.getInterfaces());
                    }
                    f3209c.put(cls, arrayList);
                    list = arrayList;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return list;
    }

    private static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    public final void a(PendingPost pendingPost) {
        Object obj = pendingPost.f3228a;
        Subscription subscription = pendingPost.f3229b;
        PendingPost.a(pendingPost);
        a(subscription, obj);
    }

    private void a(Object obj, String str, boolean z9) throws IllegalAccessException, Error, SecurityException, IllegalArgumentException, InvocationTargetException {
        Iterator<SubscriberMethod> it = this.f3215m.a(obj.getClass(), str).iterator();
        while (it.hasNext()) {
            a(obj, it.next(), z9);
        }
    }
}
