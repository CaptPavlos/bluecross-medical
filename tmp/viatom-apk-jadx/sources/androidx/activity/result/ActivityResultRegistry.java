package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.window.layout.c;
import j7.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {
    private static final int INITIAL_REQUEST_CODE_VALUE = 65536;
    private static final String KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS = "KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_PENDING_RESULTS = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS = "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_RCS = "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS";
    private static final String LOG_TAG = "ActivityResultRegistry";
    private final Map<Integer, String> mRcToKey = new HashMap();
    final Map<String, Integer> mKeyToRc = new HashMap();
    private final Map<String, LifecycleContainer> mKeyToLifecycleContainers = new HashMap();
    ArrayList<String> mLaunchedKeys = new ArrayList<>();
    final transient Map<String, CallbackAndContract<?>> mKeyToCallback = new HashMap();
    final Map<String, Object> mParsedPendingResults = new HashMap();
    final Bundle mPendingResults = new Bundle();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class CallbackAndContract<O> {
        final ActivityResultCallback<O> mCallback;
        final ActivityResultContract<?, O> mContract;

        public CallbackAndContract(ActivityResultCallback<O> activityResultCallback, ActivityResultContract<?, O> activityResultContract) {
            this.mCallback = activityResultCallback;
            this.mContract = activityResultContract;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class LifecycleContainer {
        final Lifecycle mLifecycle;
        private final ArrayList<LifecycleEventObserver> mObservers = new ArrayList<>();

        public LifecycleContainer(@NonNull Lifecycle lifecycle) {
            this.mLifecycle = lifecycle;
        }

        public void addObserver(@NonNull LifecycleEventObserver lifecycleEventObserver) {
            this.mLifecycle.addObserver(lifecycleEventObserver);
            this.mObservers.add(lifecycleEventObserver);
        }

        public void clearObservers() {
            ArrayList<LifecycleEventObserver> arrayList = this.mObservers;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                LifecycleEventObserver lifecycleEventObserver = arrayList.get(i10);
                i10++;
                this.mLifecycle.removeObserver(lifecycleEventObserver);
            }
            this.mObservers.clear();
        }
    }

    private void bindRcKey(int i10, String str) {
        this.mRcToKey.put(Integer.valueOf(i10), str);
        this.mKeyToRc.put(str, Integer.valueOf(i10));
    }

    private <O> void doDispatch(String str, int i10, @Nullable Intent intent, @Nullable CallbackAndContract<O> callbackAndContract) {
        if (callbackAndContract == null || callbackAndContract.mCallback == null || !this.mLaunchedKeys.contains(str)) {
            this.mParsedPendingResults.remove(str);
            this.mPendingResults.putParcelable(str, new ActivityResult(i10, intent));
        } else {
            callbackAndContract.mCallback.onActivityResult(callbackAndContract.mContract.parseResult(i10, intent));
            this.mLaunchedKeys.remove(str);
        }
    }

    private int generateRandomNumber() {
        j7.a aVar = d.f10029a;
        int iNextInt = d.f10029a.a().nextInt(2147418112);
        while (true) {
            int i10 = iNextInt + 65536;
            if (!this.mRcToKey.containsKey(Integer.valueOf(i10))) {
                return i10;
            }
            j7.a aVar2 = d.f10029a;
            iNextInt = d.f10029a.a().nextInt(2147418112);
        }
    }

    private void registerKey(String str) {
        if (this.mKeyToRc.get(str) != null) {
            return;
        }
        bindRcKey(generateRandomNumber(), str);
    }

    @MainThread
    public final <O> boolean dispatchResult(int i10, @SuppressLint({"UnknownNullness"}) O o9) {
        ActivityResultCallback<?> activityResultCallback;
        String str = this.mRcToKey.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        CallbackAndContract<?> callbackAndContract = this.mKeyToCallback.get(str);
        if (callbackAndContract == null || (activityResultCallback = callbackAndContract.mCallback) == null) {
            this.mPendingResults.remove(str);
            this.mParsedPendingResults.put(str, o9);
            return true;
        }
        if (!this.mLaunchedKeys.remove(str)) {
            return true;
        }
        activityResultCallback.onActivityResult(o9);
        return true;
    }

    @MainThread
    public abstract <I, O> void onLaunch(int i10, @NonNull ActivityResultContract<I, O> activityResultContract, @SuppressLint({"UnknownNullness"}) I i11, @Nullable ActivityOptionsCompat activityOptionsCompat);

    public final void onRestoreInstanceState(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS);
        ArrayList<String> stringArrayList = bundle.getStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS);
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.mLaunchedKeys = bundle.getStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS);
        this.mPendingResults.putAll(bundle.getBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS));
        for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
            String str = stringArrayList.get(i10);
            if (this.mKeyToRc.containsKey(str)) {
                Integer numRemove = this.mKeyToRc.remove(str);
                if (!this.mPendingResults.containsKey(str)) {
                    this.mRcToKey.remove(numRemove);
                }
            }
            bindRcKey(integerArrayList.get(i10).intValue(), stringArrayList.get(i10));
        }
    }

    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS, new ArrayList<>(this.mKeyToRc.values()));
        bundle.putStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS, new ArrayList<>(this.mKeyToRc.keySet()));
        bundle.putStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS, new ArrayList<>(this.mLaunchedKeys));
        bundle.putBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS, (Bundle) this.mPendingResults.clone());
    }

    @NonNull
    public final <I, O> ActivityResultLauncher<I> register(@NonNull final String str, @NonNull LifecycleOwner lifecycleOwner, @NonNull final ActivityResultContract<I, O> activityResultContract, @NonNull final ActivityResultCallback<O> activityResultCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            StringBuilder sb = new StringBuilder("LifecycleOwner ");
            sb.append(lifecycleOwner);
            Lifecycle.State currentState = lifecycle.getCurrentState();
            sb.append(" is attempting to register while current state is ");
            sb.append(currentState);
            sb.append(". LifecycleOwners must call register before they are STARTED.");
            throw new IllegalStateException(sb.toString());
        }
        registerKey(str);
        LifecycleContainer lifecycleContainer = this.mKeyToLifecycleContainers.get(str);
        if (lifecycleContainer == null) {
            lifecycleContainer = new LifecycleContainer(lifecycle);
        }
        lifecycleContainer.addObserver(new LifecycleEventObserver() { // from class: androidx.activity.result.ActivityResultRegistry.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner2, @NonNull Lifecycle.Event event) {
                if (!Lifecycle.Event.ON_START.equals(event)) {
                    if (Lifecycle.Event.ON_STOP.equals(event)) {
                        ActivityResultRegistry.this.mKeyToCallback.remove(str);
                        return;
                    } else {
                        if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                            ActivityResultRegistry.this.unregister(str);
                            return;
                        }
                        return;
                    }
                }
                ActivityResultRegistry.this.mKeyToCallback.put(str, new CallbackAndContract<>(activityResultCallback, activityResultContract));
                if (ActivityResultRegistry.this.mParsedPendingResults.containsKey(str)) {
                    Object obj = ActivityResultRegistry.this.mParsedPendingResults.get(str);
                    ActivityResultRegistry.this.mParsedPendingResults.remove(str);
                    activityResultCallback.onActivityResult(obj);
                }
                ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.mPendingResults.getParcelable(str);
                if (activityResult != null) {
                    ActivityResultRegistry.this.mPendingResults.remove(str);
                    activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.getResultCode(), activityResult.getData()));
                }
            }
        });
        this.mKeyToLifecycleContainers.put(str, lifecycleContainer);
        return new ActivityResultLauncher<I>() { // from class: androidx.activity.result.ActivityResultRegistry.2
            @Override // androidx.activity.result.ActivityResultLauncher
            @NonNull
            public ActivityResultContract<I, ?> getContract() {
                return activityResultContract;
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public void launch(I i10, @Nullable ActivityOptionsCompat activityOptionsCompat) throws Exception {
                Integer num = ActivityResultRegistry.this.mKeyToRc.get(str);
                if (num == null) {
                    c.i("Attempting to launch an unregistered ActivityResultLauncher with contract ", activityResultContract, " and input ", i10, ". You must ensure the ActivityResultLauncher is registered before calling launch().");
                    return;
                }
                ActivityResultRegistry.this.mLaunchedKeys.add(str);
                try {
                    ActivityResultRegistry.this.onLaunch(num.intValue(), activityResultContract, i10, activityOptionsCompat);
                } catch (Exception e) {
                    ActivityResultRegistry.this.mLaunchedKeys.remove(str);
                    throw e;
                }
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public void unregister() {
                ActivityResultRegistry.this.unregister(str);
            }
        };
    }

    @MainThread
    public final void unregister(@NonNull String str) {
        Integer numRemove;
        if (!this.mLaunchedKeys.contains(str) && (numRemove = this.mKeyToRc.remove(str)) != null) {
            this.mRcToKey.remove(numRemove);
        }
        this.mKeyToCallback.remove(str);
        if (this.mParsedPendingResults.containsKey(str)) {
            StringBuilder sbY = a3.a.y("Dropping pending result for request ", str, ": ");
            sbY.append(this.mParsedPendingResults.get(str));
            Log.w(LOG_TAG, sbY.toString());
            this.mParsedPendingResults.remove(str);
        }
        if (this.mPendingResults.containsKey(str)) {
            StringBuilder sbY2 = a3.a.y("Dropping pending result for request ", str, ": ");
            sbY2.append(this.mPendingResults.getParcelable(str));
            Log.w(LOG_TAG, sbY2.toString());
            this.mPendingResults.remove(str);
        }
        LifecycleContainer lifecycleContainer = this.mKeyToLifecycleContainers.get(str);
        if (lifecycleContainer != null) {
            lifecycleContainer.clearObservers();
            this.mKeyToLifecycleContainers.remove(str);
        }
    }

    @MainThread
    public final boolean dispatchResult(int i10, int i11, @Nullable Intent intent) {
        String str = this.mRcToKey.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        doDispatch(str, i11, intent, this.mKeyToCallback.get(str));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public final <I, O> ActivityResultLauncher<I> register(@NonNull final String str, @NonNull final ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultCallback<O> activityResultCallback) {
        registerKey(str);
        this.mKeyToCallback.put(str, new CallbackAndContract<>(activityResultCallback, activityResultContract));
        if (this.mParsedPendingResults.containsKey(str)) {
            Object obj = this.mParsedPendingResults.get(str);
            this.mParsedPendingResults.remove(str);
            activityResultCallback.onActivityResult(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.mPendingResults.getParcelable(str);
        if (activityResult != null) {
            this.mPendingResults.remove(str);
            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.getResultCode(), activityResult.getData()));
        }
        return new ActivityResultLauncher<I>() { // from class: androidx.activity.result.ActivityResultRegistry.3
            @Override // androidx.activity.result.ActivityResultLauncher
            @NonNull
            public ActivityResultContract<I, ?> getContract() {
                return activityResultContract;
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public void launch(I i10, @Nullable ActivityOptionsCompat activityOptionsCompat) throws Exception {
                Integer num = ActivityResultRegistry.this.mKeyToRc.get(str);
                if (num == null) {
                    c.i("Attempting to launch an unregistered ActivityResultLauncher with contract ", activityResultContract, " and input ", i10, ". You must ensure the ActivityResultLauncher is registered before calling launch().");
                    return;
                }
                ActivityResultRegistry.this.mLaunchedKeys.add(str);
                try {
                    ActivityResultRegistry.this.onLaunch(num.intValue(), activityResultContract, i10, activityOptionsCompat);
                } catch (Exception e) {
                    ActivityResultRegistry.this.mLaunchedKeys.remove(str);
                    throw e;
                }
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public void unregister() {
                ActivityResultRegistry.this.unregister(str);
            }
        };
    }
}
