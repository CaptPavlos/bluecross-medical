package androidx.leanback.util;

import a3.a;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class StateMachine {
    static final boolean DEBUG = false;
    public static final int STATUS_INVOKED = 1;
    public static final int STATUS_ZERO = 0;
    static final String TAG = "StateMachine";
    final ArrayList<State> mStates = new ArrayList<>();
    final ArrayList<State> mFinishedStates = new ArrayList<>();
    final ArrayList<State> mUnfinishedStates = new ArrayList<>();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Condition {
        final String mName;

        public Condition(String str) {
            this.mName = str;
        }

        public boolean canProceed() {
            return true;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Event {
        final String mName;

        public Event(String str) {
            this.mName = str;
        }
    }

    public void addState(State state) {
        if (this.mStates.contains(state)) {
            return;
        }
        this.mStates.add(state);
    }

    public void addTransition(State state, State state2, Event event) {
        Transition transition = new Transition(state, state2, event);
        state2.addIncoming(transition);
        state.addOutgoing(transition);
    }

    public void fireEvent(Event event) {
        for (int i10 = 0; i10 < this.mFinishedStates.size(); i10++) {
            State state = this.mFinishedStates.get(i10);
            ArrayList<Transition> arrayList = state.mOutgoings;
            if (arrayList != null && (state.mBranchStart || state.mInvokedOutTransitions <= 0)) {
                int size = arrayList.size();
                int i11 = 0;
                while (i11 < size) {
                    Transition transition = arrayList.get(i11);
                    i11++;
                    Transition transition2 = transition;
                    if (transition2.mState != 1 && transition2.mEvent == event) {
                        transition2.mState = 1;
                        state.mInvokedOutTransitions++;
                        if (!state.mBranchStart) {
                            break;
                        }
                    }
                }
            }
        }
        runUnfinishedStates();
    }

    public void reset() {
        this.mUnfinishedStates.clear();
        this.mFinishedStates.clear();
        ArrayList<State> arrayList = this.mStates;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            State state = arrayList.get(i10);
            i10++;
            State state2 = state;
            state2.mStatus = 0;
            state2.mInvokedOutTransitions = 0;
            ArrayList<Transition> arrayList2 = state2.mOutgoings;
            if (arrayList2 != null) {
                int size2 = arrayList2.size();
                int i11 = 0;
                while (i11 < size2) {
                    Transition transition = arrayList2.get(i11);
                    i11++;
                    transition.mState = 0;
                }
            }
        }
    }

    public void runUnfinishedStates() {
        boolean z9;
        do {
            z9 = false;
            for (int size = this.mUnfinishedStates.size() - 1; size >= 0; size--) {
                State state = this.mUnfinishedStates.get(size);
                if (state.runIfNeeded()) {
                    this.mUnfinishedStates.remove(size);
                    this.mFinishedStates.add(state);
                    z9 = true;
                }
            }
        } while (z9);
    }

    public void start() {
        this.mUnfinishedStates.addAll(this.mStates);
        runUnfinishedStates();
    }

    public void addTransition(State state, State state2, Condition condition) {
        Transition transition = new Transition(state, state2, condition);
        state2.addIncoming(transition);
        state.addOutgoing(transition);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class State {
        final boolean mBranchEnd;
        final boolean mBranchStart;
        ArrayList<Transition> mIncomings;
        int mInvokedOutTransitions;
        final String mName;
        ArrayList<Transition> mOutgoings;
        int mStatus;

        public State(String str, boolean z9, boolean z10) {
            this.mStatus = 0;
            this.mInvokedOutTransitions = 0;
            this.mName = str;
            this.mBranchStart = z9;
            this.mBranchEnd = z10;
        }

        public void addIncoming(Transition transition) {
            if (this.mIncomings == null) {
                this.mIncomings = new ArrayList<>();
            }
            this.mIncomings.add(transition);
        }

        public void addOutgoing(Transition transition) {
            if (this.mOutgoings == null) {
                this.mOutgoings = new ArrayList<>();
            }
            this.mOutgoings.add(transition);
        }

        public final boolean checkPreCondition() {
            ArrayList<Transition> arrayList = this.mIncomings;
            if (arrayList == null) {
                return true;
            }
            if (this.mBranchEnd) {
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Transition transition = arrayList.get(i10);
                    i10++;
                    if (transition.mState != 1) {
                        return false;
                    }
                }
                return true;
            }
            int size2 = arrayList.size();
            int i11 = 0;
            while (i11 < size2) {
                Transition transition2 = arrayList.get(i11);
                i11++;
                if (transition2.mState == 1) {
                    return true;
                }
            }
            return false;
        }

        public final int getStatus() {
            return this.mStatus;
        }

        public final boolean runIfNeeded() {
            if (this.mStatus == 1 || !checkPreCondition()) {
                return false;
            }
            this.mStatus = 1;
            run();
            signalAutoTransitionsAfterRun();
            return true;
        }

        public final void signalAutoTransitionsAfterRun() {
            Condition condition;
            ArrayList<Transition> arrayList = this.mOutgoings;
            if (arrayList != null) {
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Transition transition = arrayList.get(i10);
                    i10++;
                    Transition transition2 = transition;
                    if (transition2.mEvent == null && ((condition = transition2.mCondition) == null || condition.canProceed())) {
                        this.mInvokedOutTransitions++;
                        transition2.mState = 1;
                        if (!this.mBranchStart) {
                            return;
                        }
                    }
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            sb.append(this.mName);
            sb.append(" ");
            return a.n(sb, "]", this.mStatus);
        }

        public State(String str) {
            this(str, false, true);
        }

        public void run() {
        }
    }

    public void addTransition(State state, State state2) {
        Transition transition = new Transition(state, state2);
        state2.addIncoming(transition);
        state.addOutgoing(transition);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Transition {
        final Condition mCondition;
        final Event mEvent;
        final State mFromState;
        int mState;
        final State mToState;

        public Transition(State state, State state2, Event event) {
            this.mState = 0;
            if (event == null) {
                f.a();
                throw null;
            }
            this.mFromState = state;
            this.mToState = state2;
            this.mEvent = event;
            this.mCondition = null;
        }

        public String toString() {
            String str;
            Event event = this.mEvent;
            if (event != null) {
                str = event.mName;
            } else {
                Condition condition = this.mCondition;
                str = condition != null ? condition.mName : "auto";
            }
            return "[" + this.mFromState.mName + " -> " + this.mToState.mName + " <" + str + ">]";
        }

        public Transition(State state, State state2) {
            this.mState = 0;
            this.mFromState = state;
            this.mToState = state2;
            this.mEvent = null;
            this.mCondition = null;
        }

        public Transition(State state, State state2, Condition condition) {
            this.mState = 0;
            if (condition != null) {
                this.mFromState = state;
                this.mToState = state2;
                this.mEvent = null;
                this.mCondition = condition;
                return;
            }
            f.a();
            throw null;
        }
    }
}
