package com.google.android.material.navigation;

import a3.a;
import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class NavigationBarMenu extends MenuBuilder {
    public static final int NO_MAX_ITEM_LIMIT = Integer.MAX_VALUE;
    private final int maxItemCount;
    private final boolean subMenuSupported;

    @NonNull
    private final Class<?> viewClass;

    public NavigationBarMenu(@NonNull Context context, @NonNull Class<?> cls, int i10, boolean z9) {
        super(context);
        this.viewClass = cls;
        this.maxItemCount = i10;
        this.subMenuSupported = z9;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    @NonNull
    public MenuItem addInternal(int i10, int i11, int i12, @NonNull CharSequence charSequence) {
        if (size() + 1 <= this.maxItemCount) {
            stopDispatchingItemsChanged();
            MenuItem menuItemAddInternal = super.addInternal(i10, i11, i12, charSequence);
            startDispatchingItemsChanged();
            return menuItemAddInternal;
        }
        String simpleName = this.viewClass.getSimpleName();
        StringBuilder sbY = a.y("Maximum number of items supported by ", simpleName, " is ");
        sbY.append(this.maxItemCount);
        sbY.append(". Limit can be checked with ");
        sbY.append(simpleName);
        sbY.append("#getMaxItemCount()");
        throw new IllegalArgumentException(sbY.toString());
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    @NonNull
    public SubMenu addSubMenu(int i10, int i11, int i12, @NonNull CharSequence charSequence) {
        if (!this.subMenuSupported) {
            a2.a.m(this.viewClass.getSimpleName().concat(" does not support submenus"));
            return null;
        }
        MenuItemImpl menuItemImpl = (MenuItemImpl) addInternal(i10, i11, i12, charSequence);
        NavigationBarSubMenu navigationBarSubMenu = new NavigationBarSubMenu(getContext(), this, menuItemImpl);
        menuItemImpl.setSubMenu(navigationBarSubMenu);
        return navigationBarSubMenu;
    }

    public int getMaxItemCount() {
        return this.maxItemCount;
    }
}
