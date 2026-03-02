package com.google.android.material.navigation;

import a3.a;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class NavigationBarMenuBuilder {
    private final MenuBuilder menuBuilder;
    private int contentItemCount = 0;
    private int visibleContentItemCount = 0;
    private int visibleMainItemCount = 0;
    private final List<MenuItem> items = new ArrayList();

    public NavigationBarMenuBuilder(MenuBuilder menuBuilder) {
        this.menuBuilder = menuBuilder;
        refreshItems();
    }

    public int getContentItemCount() {
        return this.contentItemCount;
    }

    @NonNull
    public MenuItem getItemAt(int i10) {
        return this.items.get(i10);
    }

    public int getVisibleContentItemCount() {
        return this.visibleContentItemCount;
    }

    public int getVisibleMainContentItemCount() {
        return this.visibleMainItemCount;
    }

    public boolean performItemAction(@NonNull MenuItem menuItem, @NonNull MenuPresenter menuPresenter, int i10) {
        return this.menuBuilder.performItemAction(menuItem, menuPresenter, i10);
    }

    public void refreshItems() {
        this.items.clear();
        this.contentItemCount = 0;
        this.visibleContentItemCount = 0;
        this.visibleMainItemCount = 0;
        for (int i10 = 0; i10 < this.menuBuilder.size(); i10++) {
            MenuItem item = this.menuBuilder.getItem(i10);
            boolean zHasSubMenu = item.hasSubMenu();
            List<MenuItem> list = this.items;
            if (zHasSubMenu) {
                if (!list.isEmpty() && !(a.e(1, this.items) instanceof DividerMenuItem) && item.isVisible()) {
                    this.items.add(new DividerMenuItem());
                }
                this.items.add(item);
                SubMenu subMenu = item.getSubMenu();
                for (int i11 = 0; i11 < subMenu.size(); i11++) {
                    MenuItem item2 = subMenu.getItem(i11);
                    if (!item.isVisible()) {
                        item2.setVisible(false);
                    }
                    this.items.add(item2);
                    this.contentItemCount++;
                    if (item2.isVisible()) {
                        this.visibleContentItemCount++;
                    }
                }
                this.items.add(new DividerMenuItem());
            } else {
                list.add(item);
                this.contentItemCount++;
                if (item.isVisible()) {
                    this.visibleContentItemCount++;
                    this.visibleMainItemCount++;
                }
            }
        }
        if (this.items.isEmpty() || !(a.e(1, this.items) instanceof DividerMenuItem)) {
            return;
        }
        List<MenuItem> list2 = this.items;
        list2.remove(list2.size() - 1);
    }

    public int size() {
        return this.items.size();
    }
}
