package com.google.android.material.navigation;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class NavigationBarSubMenu extends SubMenuBuilder {
    public NavigationBarSubMenu(@NonNull Context context, @NonNull NavigationBarMenu navigationBarMenu, @NonNull MenuItemImpl menuItemImpl) {
        super(context, navigationBarMenu, menuItemImpl);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void onItemsChanged(boolean z9) {
        super.onItemsChanged(z9);
        ((MenuBuilder) getParentMenu()).onItemsChanged(z9);
    }
}
