package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class ChainRun extends WidgetRun {
    private int mChainStyle;
    ArrayList<WidgetRun> mWidgets;

    public ChainRun(ConstraintWidget constraintWidget, int i10) {
        super(constraintWidget);
        this.mWidgets = new ArrayList<>();
        this.orientation = i10;
        build();
    }

    private void build() {
        ConstraintWidget constraintWidget;
        ArrayList<WidgetRun> arrayList;
        ConstraintWidget constraintWidget2 = this.mWidget;
        ConstraintWidget previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        while (true) {
            ConstraintWidget constraintWidget3 = previousChainMember;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            } else {
                previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
            }
        }
        this.mWidget = constraintWidget;
        this.mWidgets.add(constraintWidget.getRun(this.orientation));
        ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
        while (true) {
            arrayList = this.mWidgets;
            if (nextChainMember == null) {
                break;
            }
            arrayList.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            WidgetRun widgetRun = arrayList.get(i10);
            i10++;
            WidgetRun widgetRun2 = widgetRun;
            int i11 = this.orientation;
            if (i11 == 0) {
                widgetRun2.mWidget.horizontalChainRun = this;
            } else if (i11 == 1) {
                widgetRun2.mWidget.verticalChainRun = this;
            }
        }
        if (this.orientation == 0 && ((ConstraintWidgetContainer) this.mWidget.getParent()).isRtl() && this.mWidgets.size() > 1) {
            this.mWidget = ((WidgetRun) a.t(this.mWidgets, 1)).mWidget;
        }
        int i12 = this.orientation;
        ConstraintWidget constraintWidget4 = this.mWidget;
        this.mChainStyle = i12 == 0 ? constraintWidget4.getHorizontalChainStyle() : constraintWidget4.getVerticalChainStyle();
    }

    private ConstraintWidget getFirstVisibleWidget() {
        for (int i10 = 0; i10 < this.mWidgets.size(); i10++) {
            WidgetRun widgetRun = this.mWidgets.get(i10);
            if (widgetRun.mWidget.getVisibility() != 8) {
                return widgetRun.mWidget;
            }
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        for (int size = this.mWidgets.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.mWidgets.get(size);
            if (widgetRun.mWidget.getVisibility() != 8) {
                return widgetRun.mWidget;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void apply() {
        ArrayList<WidgetRun> arrayList = this.mWidgets;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            WidgetRun widgetRun = arrayList.get(i10);
            i10++;
            widgetRun.apply();
        }
        int size2 = this.mWidgets.size();
        if (size2 < 1) {
            return;
        }
        ConstraintWidget constraintWidget = this.mWidgets.get(0).mWidget;
        ConstraintWidget constraintWidget2 = this.mWidgets.get(size2 - 1).mWidget;
        if (this.orientation == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
            DependencyNode target = getTarget(constraintAnchor, 0);
            int margin = constraintAnchor.getMargin();
            ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
            if (firstVisibleWidget != null) {
                margin = firstVisibleWidget.mLeft.getMargin();
            }
            if (target != null) {
                addTarget(this.start, target, margin);
            }
            DependencyNode target2 = getTarget(constraintAnchor2, 0);
            int margin2 = constraintAnchor2.getMargin();
            ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
            if (lastVisibleWidget != null) {
                margin2 = lastVisibleWidget.mRight.getMargin();
            }
            if (target2 != null) {
                addTarget(this.end, target2, -margin2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
            DependencyNode target3 = getTarget(constraintAnchor3, 1);
            int margin3 = constraintAnchor3.getMargin();
            ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
            if (firstVisibleWidget2 != null) {
                margin3 = firstVisibleWidget2.mTop.getMargin();
            }
            if (target3 != null) {
                addTarget(this.start, target3, margin3);
            }
            DependencyNode target4 = getTarget(constraintAnchor4, 1);
            int margin4 = constraintAnchor4.getMargin();
            ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
            if (lastVisibleWidget2 != null) {
                margin4 = lastVisibleWidget2.mBottom.getMargin();
            }
            if (target4 != null) {
                addTarget(this.end, target4, -margin4);
            }
        }
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        for (int i10 = 0; i10 < this.mWidgets.size(); i10++) {
            this.mWidgets.get(i10).applyToWidget();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void clear() {
        this.mRunGroup = null;
        ArrayList<WidgetRun> arrayList = this.mWidgets;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            WidgetRun widgetRun = arrayList.get(i10);
            i10++;
            widgetRun.clear();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int size = this.mWidgets.size();
        long wrapDimension = 0;
        for (int i10 = 0; i10 < size; i10++) {
            wrapDimension = r4.end.mMargin + this.mWidgets.get(i10).getWrapDimension() + wrapDimension + r4.start.mMargin;
        }
        return wrapDimension;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        int size = this.mWidgets.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.mWidgets.get(i10).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        ArrayList<WidgetRun> arrayList = this.mWidgets;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            WidgetRun widgetRun = arrayList.get(i10);
            i10++;
            sb.append("<");
            sb.append(widgetRun);
            sb.append("> ");
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x0160  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void update(androidx.constraintlayout.core.widgets.analyzer.Dependency r27) {
        /*
            Method dump skipped, instructions count: 1039
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.ChainRun.update(androidx.constraintlayout.core.widgets.analyzer.Dependency):void");
    }
}
