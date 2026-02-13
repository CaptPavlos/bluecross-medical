package androidx.leanback.app;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.transition.Transition;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.leanback.R;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.widget.DiffCallback;
import androidx.leanback.widget.GuidanceStylist;
import androidx.leanback.widget.GuidedAction;
import androidx.leanback.widget.GuidedActionAdapter;
import androidx.leanback.widget.GuidedActionAdapterGroup;
import androidx.leanback.widget.GuidedActionsStylist;
import androidx.leanback.widget.NonOverlappingLinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Deprecated
/* loaded from: classes.dex */
public class GuidedStepFragment extends Fragment implements GuidedActionAdapter.FocusListener {
    private static final boolean DEBUG = false;
    private static final String ENTRY_NAME_ENTRANCE = "GuidedStepEntrance";
    private static final String ENTRY_NAME_REPLACE = "GuidedStepDefault";
    private static final String EXTRA_ACTION_PREFIX = "action_";
    private static final String EXTRA_BUTTON_ACTION_PREFIX = "buttonaction_";
    public static final String EXTRA_UI_STYLE = "uiStyle";
    private static final boolean IS_FRAMEWORK_FRAGMENT = true;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int SLIDE_FROM_BOTTOM = 1;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int SLIDE_FROM_SIDE = 0;
    private static final String TAG = "GuidedStepF";
    private static final String TAG_LEAN_BACK_ACTIONS_FRAGMENT = "leanBackGuidedStepFragment";
    public static final int UI_STYLE_ACTIVITY_ROOT = 2;

    @Deprecated
    public static final int UI_STYLE_DEFAULT = 0;
    public static final int UI_STYLE_ENTRANCE = 1;
    public static final int UI_STYLE_REPLACE = 0;
    GuidedActionsStylist mActionsStylist;
    private GuidedActionAdapter mAdapter;
    private GuidedActionAdapterGroup mAdapterGroup;
    private GuidedActionsStylist mButtonActionsStylist;
    private GuidedActionAdapter mButtonAdapter;
    private GuidanceStylist mGuidanceStylist;
    private GuidedActionAdapter mSubAdapter;
    private ContextThemeWrapper mThemeWrapper;
    private List<GuidedAction> mActions = new ArrayList();
    private List<GuidedAction> mButtonActions = new ArrayList();
    private int entranceTransitionType = 0;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class DummyFragment extends Fragment {
        @Override // android.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View view = new View(layoutInflater.getContext());
            view.setVisibility(8);
            return view;
        }
    }

    public GuidedStepFragment() {
        onProvideFragmentTransitions();
    }

    public static int add(FragmentManager fragmentManager, GuidedStepFragment guidedStepFragment, int i10) {
        GuidedStepFragment currentGuidedStepFragment = getCurrentGuidedStepFragment(fragmentManager);
        int i11 = currentGuidedStepFragment != null ? 1 : 0;
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        guidedStepFragment.setUiStyle(1 ^ i11);
        fragmentTransactionBeginTransaction.addToBackStack(guidedStepFragment.generateStackEntryName());
        if (currentGuidedStepFragment != null) {
            guidedStepFragment.onAddSharedElementTransition(fragmentTransactionBeginTransaction, currentGuidedStepFragment);
        }
        return fragmentTransactionBeginTransaction.replace(i10, guidedStepFragment, TAG_LEAN_BACK_ACTIONS_FRAGMENT).commit();
    }

    public static int addAsRoot(Activity activity, GuidedStepFragment guidedStepFragment, int i10) {
        activity.getWindow().getDecorView();
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag(TAG_LEAN_BACK_ACTIONS_FRAGMENT) != null) {
            Log.w(TAG, "Fragment is already exists, likely calling addAsRoot() when savedInstanceState is not null in Activity.onCreate().");
            return -1;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        guidedStepFragment.setUiStyle(2);
        return fragmentTransactionBeginTransaction.replace(i10, guidedStepFragment, TAG_LEAN_BACK_ACTIONS_FRAGMENT).commit();
    }

    private static void addNonNullSharedElementTransition(FragmentTransaction fragmentTransaction, View view, String str) {
        if (view != null) {
            fragmentTransaction.addSharedElement(view, str);
        }
    }

    public static String generateStackEntryName(int i10, Class<?> cls) {
        return i10 != 0 ? i10 != 1 ? "" : ENTRY_NAME_ENTRANCE.concat(cls.getName()) : ENTRY_NAME_REPLACE.concat(cls.getName());
    }

    public static GuidedStepFragment getCurrentGuidedStepFragment(FragmentManager fragmentManager) {
        Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(TAG_LEAN_BACK_ACTIONS_FRAGMENT);
        if (fragmentFindFragmentByTag instanceof GuidedStepFragment) {
            return (GuidedStepFragment) fragmentFindFragmentByTag;
        }
        return null;
    }

    public static String getGuidedStepFragmentClassName(String str) {
        return str.startsWith(ENTRY_NAME_REPLACE) ? str.substring(17) : str.startsWith(ENTRY_NAME_ENTRANCE) ? str.substring(18) : "";
    }

    private LayoutInflater getThemeInflater(LayoutInflater layoutInflater) {
        ContextThemeWrapper contextThemeWrapper = this.mThemeWrapper;
        return contextThemeWrapper == null ? layoutInflater : layoutInflater.cloneInContext(contextThemeWrapper);
    }

    private static boolean isGuidedStepTheme(Context context) {
        int i10 = R.attr.guidedStepThemeFlag;
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(i10, typedValue, true) && typedValue.type == 18 && typedValue.data != 0;
    }

    public static boolean isSaveEnabled(GuidedAction guidedAction) {
        return guidedAction.isAutoSaveRestoreEnabled() && guidedAction.getId() != -1;
    }

    public static boolean isStackEntryUiStyleEntrance(String str) {
        return str != null && str.startsWith(ENTRY_NAME_ENTRANCE);
    }

    private void resolveTheme() {
        Context context = FragmentUtil.getContext(this);
        int iOnProvideTheme = onProvideTheme();
        if (iOnProvideTheme != -1 || isGuidedStepTheme(context)) {
            if (iOnProvideTheme != -1) {
                this.mThemeWrapper = new ContextThemeWrapper(context, iOnProvideTheme);
                return;
            }
            return;
        }
        int i10 = R.attr.guidedStepTheme;
        TypedValue typedValue = new TypedValue();
        boolean zResolveAttribute = context.getTheme().resolveAttribute(i10, typedValue, true);
        if (zResolveAttribute) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, typedValue.resourceId);
            if (isGuidedStepTheme(contextThemeWrapper)) {
                this.mThemeWrapper = contextThemeWrapper;
            } else {
                this.mThemeWrapper = null;
                zResolveAttribute = false;
            }
        }
        if (zResolveAttribute) {
            return;
        }
        Log.e(TAG, "GuidedStepFragment does not have an appropriate theme set.");
    }

    public void collapseAction(boolean z9) {
        GuidedActionsStylist guidedActionsStylist = this.mActionsStylist;
        if (guidedActionsStylist == null || guidedActionsStylist.getActionsGridView() == null) {
            return;
        }
        this.mActionsStylist.collapseAction(z9);
    }

    public void collapseSubActions() {
        collapseAction(true);
    }

    public void expandAction(GuidedAction guidedAction, boolean z9) {
        this.mActionsStylist.expandAction(guidedAction, z9);
    }

    public void expandSubActions(GuidedAction guidedAction) {
        if (guidedAction.hasSubActions()) {
            expandAction(guidedAction, true);
        }
    }

    public GuidedAction findActionById(long j10) {
        int iFindActionPositionById = findActionPositionById(j10);
        if (iFindActionPositionById >= 0) {
            return this.mActions.get(iFindActionPositionById);
        }
        return null;
    }

    public int findActionPositionById(long j10) {
        if (this.mActions == null) {
            return -1;
        }
        for (int i10 = 0; i10 < this.mActions.size(); i10++) {
            if (this.mActions.get(i10).getId() == j10) {
                return i10;
            }
        }
        return -1;
    }

    public GuidedAction findButtonActionById(long j10) {
        int iFindButtonActionPositionById = findButtonActionPositionById(j10);
        if (iFindButtonActionPositionById >= 0) {
            return this.mButtonActions.get(iFindButtonActionPositionById);
        }
        return null;
    }

    public int findButtonActionPositionById(long j10) {
        if (this.mButtonActions == null) {
            return -1;
        }
        for (int i10 = 0; i10 < this.mButtonActions.size(); i10++) {
            if (this.mButtonActions.get(i10).getId() == j10) {
                return i10;
            }
        }
        return -1;
    }

    public void finishGuidedStepFragments() {
        FragmentManager fragmentManager = getFragmentManager();
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        if (backStackEntryCount > 0) {
            for (int i10 = backStackEntryCount - 1; i10 >= 0; i10--) {
                FragmentManager.BackStackEntry backStackEntryAt = fragmentManager.getBackStackEntryAt(i10);
                if (isStackEntryUiStyleEntrance(backStackEntryAt.getName())) {
                    GuidedStepFragment currentGuidedStepFragment = getCurrentGuidedStepFragment(fragmentManager);
                    if (currentGuidedStepFragment != null) {
                        currentGuidedStepFragment.setUiStyle(1);
                    }
                    fragmentManager.popBackStackImmediate(backStackEntryAt.getId(), 1);
                    return;
                }
            }
        }
        ActivityCompat.finishAfterTransition(getActivity());
    }

    public View getActionItemView(int i10) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForPosition = this.mActionsStylist.getActionsGridView().findViewHolderForPosition(i10);
        if (viewHolderFindViewHolderForPosition == null) {
            return null;
        }
        return viewHolderFindViewHolderForPosition.itemView;
    }

    public List<GuidedAction> getActions() {
        return this.mActions;
    }

    public final String getAutoRestoreKey(GuidedAction guidedAction) {
        return EXTRA_ACTION_PREFIX + guidedAction.getId();
    }

    public View getButtonActionItemView(int i10) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForPosition = this.mButtonActionsStylist.getActionsGridView().findViewHolderForPosition(i10);
        if (viewHolderFindViewHolderForPosition == null) {
            return null;
        }
        return viewHolderFindViewHolderForPosition.itemView;
    }

    public List<GuidedAction> getButtonActions() {
        return this.mButtonActions;
    }

    public final String getButtonAutoRestoreKey(GuidedAction guidedAction) {
        return EXTRA_BUTTON_ACTION_PREFIX + guidedAction.getId();
    }

    public GuidanceStylist getGuidanceStylist() {
        return this.mGuidanceStylist;
    }

    public GuidedActionsStylist getGuidedActionsStylist() {
        return this.mActionsStylist;
    }

    public GuidedActionsStylist getGuidedButtonActionsStylist() {
        return this.mButtonActionsStylist;
    }

    public int getSelectedActionPosition() {
        return this.mActionsStylist.getActionsGridView().getSelectedPosition();
    }

    public int getSelectedButtonActionPosition() {
        return this.mButtonActionsStylist.getActionsGridView().getSelectedPosition();
    }

    public int getUiStyle() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return 1;
        }
        return arguments.getInt("uiStyle", 1);
    }

    public boolean isExpanded() {
        return this.mActionsStylist.isExpanded();
    }

    public boolean isFocusOutEndAllowed() {
        return false;
    }

    public boolean isFocusOutStartAllowed() {
        return false;
    }

    public boolean isSubActionsExpanded() {
        return this.mActionsStylist.isSubActionsExpanded();
    }

    public void notifyActionChanged(int i10) {
        GuidedActionAdapter guidedActionAdapter = this.mAdapter;
        if (guidedActionAdapter != null) {
            guidedActionAdapter.notifyItemChanged(i10);
        }
    }

    public void notifyButtonActionChanged(int i10) {
        GuidedActionAdapter guidedActionAdapter = this.mButtonAdapter;
        if (guidedActionAdapter != null) {
            guidedActionAdapter.notifyItemChanged(i10);
        }
    }

    public void onAddSharedElementTransition(FragmentTransaction fragmentTransaction, GuidedStepFragment guidedStepFragment) {
        View view = guidedStepFragment.getView();
        addNonNullSharedElementTransition(fragmentTransaction, view.findViewById(R.id.action_fragment_root), "action_fragment_root");
        addNonNullSharedElementTransition(fragmentTransaction, view.findViewById(R.id.action_fragment_background), "action_fragment_background");
        addNonNullSharedElementTransition(fragmentTransaction, view.findViewById(R.id.action_fragment), "action_fragment");
        addNonNullSharedElementTransition(fragmentTransaction, view.findViewById(R.id.guidedactions_root), "guidedactions_root");
        addNonNullSharedElementTransition(fragmentTransaction, view.findViewById(R.id.guidedactions_content), "guidedactions_content");
        addNonNullSharedElementTransition(fragmentTransaction, view.findViewById(R.id.guidedactions_list_background), "guidedactions_list_background");
        addNonNullSharedElementTransition(fragmentTransaction, view.findViewById(R.id.guidedactions_root2), "guidedactions_root2");
        addNonNullSharedElementTransition(fragmentTransaction, view.findViewById(R.id.guidedactions_content2), "guidedactions_content2");
        addNonNullSharedElementTransition(fragmentTransaction, view.findViewById(R.id.guidedactions_list_background2), "guidedactions_list_background2");
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mGuidanceStylist = onCreateGuidanceStylist();
        this.mActionsStylist = onCreateActionsStylist();
        this.mButtonActionsStylist = onCreateButtonActionsStylist();
        onProvideFragmentTransitions();
        ArrayList arrayList = new ArrayList();
        onCreateActions(arrayList, bundle);
        if (bundle != null) {
            onRestoreActions(arrayList, bundle);
        }
        setActions(arrayList);
        ArrayList arrayList2 = new ArrayList();
        onCreateButtonActions(arrayList2, bundle);
        if (bundle != null) {
            onRestoreButtonActions(arrayList2, bundle);
        }
        setButtonActions(arrayList2);
    }

    public GuidedActionsStylist onCreateActionsStylist() {
        return new GuidedActionsStylist();
    }

    public View onCreateBackgroundView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.lb_guidedstep_background, viewGroup, false);
    }

    public GuidedActionsStylist onCreateButtonActionsStylist() {
        GuidedActionsStylist guidedActionsStylist = new GuidedActionsStylist();
        guidedActionsStylist.setAsButtonActions();
        return guidedActionsStylist;
    }

    public GuidanceStylist.Guidance onCreateGuidance(Bundle bundle) {
        return new GuidanceStylist.Guidance("", "", "", null);
    }

    public GuidanceStylist onCreateGuidanceStylist() {
        return new GuidanceStylist();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        resolveTheme();
        LayoutInflater themeInflater = getThemeInflater(layoutInflater);
        GuidedStepRootLayout guidedStepRootLayout = (GuidedStepRootLayout) themeInflater.inflate(R.layout.lb_guidedstep_fragment, viewGroup, false);
        guidedStepRootLayout.setFocusOutStart(isFocusOutStartAllowed());
        guidedStepRootLayout.setFocusOutEnd(isFocusOutEndAllowed());
        ViewGroup viewGroup2 = (ViewGroup) guidedStepRootLayout.findViewById(R.id.content_fragment);
        ViewGroup viewGroup3 = (ViewGroup) guidedStepRootLayout.findViewById(R.id.action_fragment);
        ((NonOverlappingLinearLayout) viewGroup3).setFocusableViewAvailableFixEnabled(true);
        viewGroup2.addView(this.mGuidanceStylist.onCreateView(themeInflater, viewGroup2, onCreateGuidance(bundle)));
        viewGroup3.addView(this.mActionsStylist.onCreateView(themeInflater, viewGroup3));
        View viewOnCreateView = this.mButtonActionsStylist.onCreateView(themeInflater, viewGroup3);
        viewGroup3.addView(viewOnCreateView);
        GuidedActionAdapter.EditListener editListener = new GuidedActionAdapter.EditListener() { // from class: androidx.leanback.app.GuidedStepFragment.1
            @Override // androidx.leanback.widget.GuidedActionAdapter.EditListener
            public void onGuidedActionEditCanceled(GuidedAction guidedAction) {
                GuidedStepFragment.this.onGuidedActionEditCanceled(guidedAction);
            }

            @Override // androidx.leanback.widget.GuidedActionAdapter.EditListener
            public long onGuidedActionEditedAndProceed(GuidedAction guidedAction) {
                return GuidedStepFragment.this.onGuidedActionEditedAndProceed(guidedAction);
            }

            @Override // androidx.leanback.widget.GuidedActionAdapter.EditListener
            public void onImeClose() {
                GuidedStepFragment.this.runImeAnimations(false);
            }

            @Override // androidx.leanback.widget.GuidedActionAdapter.EditListener
            public void onImeOpen() {
                GuidedStepFragment.this.runImeAnimations(true);
            }
        };
        this.mAdapter = new GuidedActionAdapter(this.mActions, new GuidedActionAdapter.ClickListener() { // from class: androidx.leanback.app.GuidedStepFragment.2
            @Override // androidx.leanback.widget.GuidedActionAdapter.ClickListener
            public void onGuidedActionClicked(GuidedAction guidedAction) {
                GuidedStepFragment.this.onGuidedActionClicked(guidedAction);
                if (GuidedStepFragment.this.isExpanded()) {
                    GuidedStepFragment.this.collapseAction(true);
                } else if (guidedAction.hasSubActions() || guidedAction.hasEditableActivatorView()) {
                    GuidedStepFragment.this.expandAction(guidedAction, true);
                }
            }
        }, this, this.mActionsStylist, false);
        this.mButtonAdapter = new GuidedActionAdapter(this.mButtonActions, new GuidedActionAdapter.ClickListener() { // from class: androidx.leanback.app.GuidedStepFragment.3
            @Override // androidx.leanback.widget.GuidedActionAdapter.ClickListener
            public void onGuidedActionClicked(GuidedAction guidedAction) {
                GuidedStepFragment.this.onGuidedActionClicked(guidedAction);
            }
        }, this, this.mButtonActionsStylist, false);
        this.mSubAdapter = new GuidedActionAdapter(null, new GuidedActionAdapter.ClickListener() { // from class: androidx.leanback.app.GuidedStepFragment.4
            @Override // androidx.leanback.widget.GuidedActionAdapter.ClickListener
            public void onGuidedActionClicked(GuidedAction guidedAction) {
                if (!GuidedStepFragment.this.mActionsStylist.isInExpandTransition() && GuidedStepFragment.this.onSubGuidedActionClicked(guidedAction)) {
                    GuidedStepFragment.this.collapseSubActions();
                }
            }
        }, this, this.mActionsStylist, true);
        GuidedActionAdapterGroup guidedActionAdapterGroup = new GuidedActionAdapterGroup();
        this.mAdapterGroup = guidedActionAdapterGroup;
        guidedActionAdapterGroup.addAdpter(this.mAdapter, this.mButtonAdapter);
        this.mAdapterGroup.addAdpter(this.mSubAdapter, null);
        this.mAdapterGroup.setEditListener(editListener);
        this.mActionsStylist.setEditListener(editListener);
        this.mActionsStylist.getActionsGridView().setAdapter(this.mAdapter);
        if (this.mActionsStylist.getSubActionsGridView() != null) {
            this.mActionsStylist.getSubActionsGridView().setAdapter(this.mSubAdapter);
        }
        this.mButtonActionsStylist.getActionsGridView().setAdapter(this.mButtonAdapter);
        if (this.mButtonActions.size() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewOnCreateView.getLayoutParams();
            layoutParams.weight = 0.0f;
            viewOnCreateView.setLayoutParams(layoutParams);
        } else {
            Context context = this.mThemeWrapper;
            if (context == null) {
                context = FragmentUtil.getContext(this);
            }
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(R.attr.guidedActionContentWidthWeightTwoPanels, typedValue, true)) {
                View viewFindViewById = guidedStepRootLayout.findViewById(R.id.action_fragment_root);
                float f = typedValue.getFloat();
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) viewFindViewById.getLayoutParams();
                layoutParams2.weight = f;
                viewFindViewById.setLayoutParams(layoutParams2);
            }
        }
        View viewOnCreateBackgroundView = onCreateBackgroundView(themeInflater, guidedStepRootLayout, bundle);
        if (viewOnCreateBackgroundView != null) {
            ((FrameLayout) guidedStepRootLayout.findViewById(R.id.guidedstep_background_view_root)).addView(viewOnCreateBackgroundView, 0);
        }
        return guidedStepRootLayout;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.mGuidanceStylist.onDestroyView();
        this.mActionsStylist.onDestroyView();
        this.mButtonActionsStylist.onDestroyView();
        this.mAdapter = null;
        this.mSubAdapter = null;
        this.mButtonAdapter = null;
        this.mAdapterGroup = null;
        super.onDestroyView();
    }

    public void onGuidedActionEditCanceled(GuidedAction guidedAction) {
        onGuidedActionEdited(guidedAction);
    }

    public long onGuidedActionEditedAndProceed(GuidedAction guidedAction) {
        onGuidedActionEdited(guidedAction);
        return -2L;
    }

    public void onProvideFragmentTransitions() {
        int uiStyle = getUiStyle();
        if (uiStyle == 0) {
            Object objCreateFadeAndShortSlide = TransitionHelper.createFadeAndShortSlide(GravityCompat.END);
            TransitionHelper.exclude(objCreateFadeAndShortSlide, R.id.guidedstep_background, true);
            int i10 = R.id.guidedactions_sub_list_background;
            TransitionHelper.exclude(objCreateFadeAndShortSlide, i10, true);
            setEnterTransition((Transition) objCreateFadeAndShortSlide);
            Object objCreateFadeTransition = TransitionHelper.createFadeTransition(3);
            TransitionHelper.include(objCreateFadeTransition, i10);
            Object objCreateChangeBounds = TransitionHelper.createChangeBounds(false);
            Object objCreateTransitionSet = TransitionHelper.createTransitionSet(false);
            TransitionHelper.addTransition(objCreateTransitionSet, objCreateFadeTransition);
            TransitionHelper.addTransition(objCreateTransitionSet, objCreateChangeBounds);
            setSharedElementEnterTransition((Transition) objCreateTransitionSet);
        } else if (uiStyle == 1) {
            if (this.entranceTransitionType == 0) {
                Object objCreateFadeTransition2 = TransitionHelper.createFadeTransition(3);
                TransitionHelper.include(objCreateFadeTransition2, R.id.guidedstep_background);
                Object objCreateFadeAndShortSlide2 = TransitionHelper.createFadeAndShortSlide(GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK);
                TransitionHelper.include(objCreateFadeAndShortSlide2, R.id.content_fragment);
                TransitionHelper.include(objCreateFadeAndShortSlide2, R.id.action_fragment_root);
                Object objCreateTransitionSet2 = TransitionHelper.createTransitionSet(false);
                TransitionHelper.addTransition(objCreateTransitionSet2, objCreateFadeTransition2);
                TransitionHelper.addTransition(objCreateTransitionSet2, objCreateFadeAndShortSlide2);
                setEnterTransition((Transition) objCreateTransitionSet2);
            } else {
                Object objCreateFadeAndShortSlide3 = TransitionHelper.createFadeAndShortSlide(80);
                TransitionHelper.include(objCreateFadeAndShortSlide3, R.id.guidedstep_background_view_root);
                Object objCreateTransitionSet3 = TransitionHelper.createTransitionSet(false);
                TransitionHelper.addTransition(objCreateTransitionSet3, objCreateFadeAndShortSlide3);
                setEnterTransition((Transition) objCreateTransitionSet3);
            }
            setSharedElementEnterTransition(null);
        } else if (uiStyle == 2) {
            setEnterTransition(null);
            setSharedElementEnterTransition(null);
        }
        Object objCreateFadeAndShortSlide4 = TransitionHelper.createFadeAndShortSlide(GravityCompat.START);
        TransitionHelper.exclude(objCreateFadeAndShortSlide4, R.id.guidedstep_background, true);
        TransitionHelper.exclude(objCreateFadeAndShortSlide4, R.id.guidedactions_sub_list_background, true);
        setExitTransition((Transition) objCreateFadeAndShortSlide4);
    }

    public int onProvideTheme() {
        return -1;
    }

    public final void onRestoreActions(List<GuidedAction> list, Bundle bundle) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            GuidedAction guidedAction = list.get(i10);
            if (isSaveEnabled(guidedAction)) {
                guidedAction.onRestoreInstanceState(bundle, getAutoRestoreKey(guidedAction));
            }
        }
    }

    public final void onRestoreButtonActions(List<GuidedAction> list, Bundle bundle) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            GuidedAction guidedAction = list.get(i10);
            if (isSaveEnabled(guidedAction)) {
                guidedAction.onRestoreInstanceState(bundle, getButtonAutoRestoreKey(guidedAction));
            }
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        getView().findViewById(R.id.action_fragment).requestFocus();
    }

    public final void onSaveActions(List<GuidedAction> list, Bundle bundle) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            GuidedAction guidedAction = list.get(i10);
            if (isSaveEnabled(guidedAction)) {
                guidedAction.onSaveInstanceState(bundle, getAutoRestoreKey(guidedAction));
            }
        }
    }

    public final void onSaveButtonActions(List<GuidedAction> list, Bundle bundle) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            GuidedAction guidedAction = list.get(i10);
            if (isSaveEnabled(guidedAction)) {
                guidedAction.onSaveInstanceState(bundle, getButtonAutoRestoreKey(guidedAction));
            }
        }
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        onSaveActions(this.mActions, bundle);
        onSaveButtonActions(this.mButtonActions, bundle);
    }

    public boolean onSubGuidedActionClicked(GuidedAction guidedAction) {
        return true;
    }

    public void openInEditMode(GuidedAction guidedAction) {
        this.mActionsStylist.openInEditMode(guidedAction);
    }

    public void popBackStackToGuidedStepFragment(Class<?> cls, int i10) {
        if (GuidedStepFragment.class.isAssignableFrom(cls)) {
            FragmentManager fragmentManager = getFragmentManager();
            int backStackEntryCount = fragmentManager.getBackStackEntryCount();
            String name = cls.getName();
            if (backStackEntryCount > 0) {
                for (int i11 = backStackEntryCount - 1; i11 >= 0; i11--) {
                    FragmentManager.BackStackEntry backStackEntryAt = fragmentManager.getBackStackEntryAt(i11);
                    if (name.equals(getGuidedStepFragmentClassName(backStackEntryAt.getName()))) {
                        fragmentManager.popBackStackImmediate(backStackEntryAt.getId(), i10);
                        return;
                    }
                }
            }
        }
    }

    public void runImeAnimations(boolean z9) {
        ArrayList arrayList = new ArrayList();
        GuidanceStylist guidanceStylist = this.mGuidanceStylist;
        if (z9) {
            guidanceStylist.onImeAppearing(arrayList);
            this.mActionsStylist.onImeAppearing(arrayList);
            this.mButtonActionsStylist.onImeAppearing(arrayList);
        } else {
            guidanceStylist.onImeDisappearing(arrayList);
            this.mActionsStylist.onImeDisappearing(arrayList);
            this.mButtonActionsStylist.onImeDisappearing(arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void setActions(List<GuidedAction> list) {
        this.mActions = list;
        GuidedActionAdapter guidedActionAdapter = this.mAdapter;
        if (guidedActionAdapter != null) {
            guidedActionAdapter.setActions(list);
        }
    }

    public void setActionsDiffCallback(DiffCallback<GuidedAction> diffCallback) {
        this.mAdapter.setDiffCallback(diffCallback);
    }

    public void setButtonActions(List<GuidedAction> list) {
        this.mButtonActions = list;
        GuidedActionAdapter guidedActionAdapter = this.mButtonAdapter;
        if (guidedActionAdapter != null) {
            guidedActionAdapter.setActions(list);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setEntranceTransitionType(int i10) {
        this.entranceTransitionType = i10;
    }

    public void setSelectedActionPosition(int i10) {
        this.mActionsStylist.getActionsGridView().setSelectedPosition(i10);
    }

    public void setSelectedButtonActionPosition(int i10) {
        this.mButtonActionsStylist.getActionsGridView().setSelectedPosition(i10);
    }

    public void setUiStyle(int i10) {
        boolean z9;
        int uiStyle = getUiStyle();
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
            z9 = true;
        } else {
            z9 = false;
        }
        arguments.putInt("uiStyle", i10);
        if (z9) {
            setArguments(arguments);
        }
        if (i10 != uiStyle) {
            onProvideFragmentTransitions();
        }
    }

    public void onGuidedActionClicked(GuidedAction guidedAction) {
    }

    @Deprecated
    public void onGuidedActionEdited(GuidedAction guidedAction) {
    }

    @Override // androidx.leanback.widget.GuidedActionAdapter.FocusListener
    public void onGuidedActionFocused(GuidedAction guidedAction) {
    }

    public final String generateStackEntryName() {
        return generateStackEntryName(getUiStyle(), getClass());
    }

    public void onCreateActions(List<GuidedAction> list, Bundle bundle) {
    }

    public void onCreateButtonActions(List<GuidedAction> list, Bundle bundle) {
    }

    public static int add(FragmentManager fragmentManager, GuidedStepFragment guidedStepFragment) {
        return add(fragmentManager, guidedStepFragment, android.R.id.content);
    }
}
