package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.res.Resources;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.core.provider.b;
import androidx.core.view.accessibility.a;
import androidx.media.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class NotificationCompat {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        private void setBackgroundColor(RemoteViews remoteViews) {
            int color = this.mBuilder.getColor();
            NotificationCompat.Builder builder = this.mBuilder;
            remoteViews.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", color != 0 ? builder.getColor() : builder.mContext.getResources().getColor(R.color.notification_material_background_media_default_color));
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(fillInMediaStyle(b.a()));
            } else {
                super.apply(notificationBuilderWithBuilderAccessor);
            }
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        public int getBigContentViewLayoutResource(int i10) {
            return i10 <= 3 ? R.layout.notification_template_big_media_narrow_custom : R.layout.notification_template_big_media_custom;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        public int getContentViewLayoutResource() {
            return this.mBuilder.getContentView() != null ? R.layout.notification_template_media_custom : super.getContentViewLayoutResource();
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) throws Resources.NotFoundException {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews bigContentView = this.mBuilder.getBigContentView();
            NotificationCompat.Builder builder = this.mBuilder;
            RemoteViews bigContentView2 = bigContentView != null ? builder.getBigContentView() : builder.getContentView();
            if (bigContentView2 == null) {
                return null;
            }
            RemoteViews remoteViewsGenerateBigContentView = generateBigContentView();
            buildIntoRemoteViews(remoteViewsGenerateBigContentView, bigContentView2);
            setBackgroundColor(remoteViewsGenerateBigContentView);
            return remoteViewsGenerateBigContentView;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) throws Resources.NotFoundException {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            boolean z9 = this.mBuilder.getContentView() != null;
            if (!z9 && this.mBuilder.getBigContentView() == null) {
                return null;
            }
            RemoteViews remoteViewsGenerateContentView = generateContentView();
            if (z9) {
                buildIntoRemoteViews(remoteViewsGenerateContentView, this.mBuilder.getContentView());
            }
            setBackgroundColor(remoteViewsGenerateContentView);
            return remoteViewsGenerateContentView;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) throws Resources.NotFoundException {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews headsUpContentView = this.mBuilder.getHeadsUpContentView();
            NotificationCompat.Builder builder = this.mBuilder;
            RemoteViews headsUpContentView2 = headsUpContentView != null ? builder.getHeadsUpContentView() : builder.getContentView();
            if (headsUpContentView2 == null) {
                return null;
            }
            RemoteViews remoteViewsGenerateBigContentView = generateBigContentView();
            buildIntoRemoteViews(remoteViewsGenerateBigContentView, headsUpContentView2);
            setBackgroundColor(remoteViewsGenerateBigContentView);
            return remoteViewsGenerateBigContentView;
        }
    }

    private NotificationCompat() {
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class MediaStyle extends NotificationCompat.Style {
        private static final int MAX_MEDIA_BUTTONS = 5;
        private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
        int[] mActionsToShowInCompact = null;
        PendingIntent mCancelButtonIntent;
        boolean mShowCancelButton;
        MediaSessionCompat$Token mToken;

        public MediaStyle(NotificationCompat.Builder builder) {
            setBuilder(builder);
        }

        private RemoteViews generateMediaActionButton(NotificationCompat.Action action) {
            boolean z9 = action.getActionIntent() == null;
            RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), R.layout.notification_media_action);
            int i10 = R.id.action0;
            remoteViews.setImageViewResource(i10, action.getIcon());
            if (!z9) {
                remoteViews.setOnClickPendingIntent(i10, action.getActionIntent());
            }
            remoteViews.setContentDescription(i10, action.getTitle());
            return remoteViews;
        }

        public static MediaSessionCompat$Token getMediaSession(Notification notification) {
            Parcelable parcelable;
            Bundle extras = androidx.core.app.NotificationCompat.getExtras(notification);
            if (extras == null || (parcelable = extras.getParcelable(androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION)) == null) {
                return null;
            }
            return MediaSessionCompat$Token.a(parcelable, null);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            notificationBuilderWithBuilderAccessor.getBuilder().setStyle(fillInMediaStyle(new Notification.MediaStyle()));
        }

        @RequiresApi(21)
        public Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle mediaStyle) {
            int[] iArr = this.mActionsToShowInCompact;
            if (iArr != null) {
                mediaStyle.setShowActionsInCompactView(iArr);
            }
            MediaSessionCompat$Token mediaSessionCompat$Token = this.mToken;
            if (mediaSessionCompat$Token != null) {
                mediaStyle.setMediaSession((MediaSession.Token) mediaSessionCompat$Token.f393a);
            }
            return mediaStyle;
        }

        public RemoteViews generateBigContentView() throws Resources.NotFoundException {
            int iMin = Math.min(this.mBuilder.mActions.size(), 5);
            RemoteViews remoteViewsApplyStandardTemplate = applyStandardTemplate(false, getBigContentViewLayoutResource(iMin), false);
            remoteViewsApplyStandardTemplate.removeAllViews(R.id.media_actions);
            if (iMin > 0) {
                for (int i10 = 0; i10 < iMin; i10++) {
                    remoteViewsApplyStandardTemplate.addView(R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(i10)));
                }
            }
            if (!this.mShowCancelButton) {
                remoteViewsApplyStandardTemplate.setViewVisibility(R.id.cancel_action, 8);
                return remoteViewsApplyStandardTemplate;
            }
            int i11 = R.id.cancel_action;
            remoteViewsApplyStandardTemplate.setViewVisibility(i11, 0);
            remoteViewsApplyStandardTemplate.setInt(i11, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
            remoteViewsApplyStandardTemplate.setOnClickPendingIntent(i11, this.mCancelButtonIntent);
            return remoteViewsApplyStandardTemplate;
        }

        public RemoteViews generateContentView() throws Resources.NotFoundException {
            RemoteViews remoteViewsApplyStandardTemplate = applyStandardTemplate(false, getContentViewLayoutResource(), true);
            int size = this.mBuilder.mActions.size();
            int[] iArr = this.mActionsToShowInCompact;
            int iMin = iArr == null ? 0 : Math.min(iArr.length, 3);
            remoteViewsApplyStandardTemplate.removeAllViews(R.id.media_actions);
            if (iMin > 0) {
                for (int i10 = 0; i10 < iMin; i10++) {
                    if (i10 >= size) {
                        a.r("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(i10), Integer.valueOf(size - 1)});
                        return null;
                    }
                    remoteViewsApplyStandardTemplate.addView(R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(this.mActionsToShowInCompact[i10])));
                }
            }
            if (!this.mShowCancelButton) {
                remoteViewsApplyStandardTemplate.setViewVisibility(R.id.end_padder, 0);
                remoteViewsApplyStandardTemplate.setViewVisibility(R.id.cancel_action, 8);
                return remoteViewsApplyStandardTemplate;
            }
            remoteViewsApplyStandardTemplate.setViewVisibility(R.id.end_padder, 8);
            int i11 = R.id.cancel_action;
            remoteViewsApplyStandardTemplate.setViewVisibility(i11, 0);
            remoteViewsApplyStandardTemplate.setOnClickPendingIntent(i11, this.mCancelButtonIntent);
            remoteViewsApplyStandardTemplate.setInt(i11, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
            return remoteViewsApplyStandardTemplate;
        }

        public int getBigContentViewLayoutResource(int i10) {
            return i10 <= 3 ? R.layout.notification_template_big_media_narrow : R.layout.notification_template_big_media;
        }

        public int getContentViewLayoutResource() {
            return R.layout.notification_template_media;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.mCancelButtonIntent = pendingIntent;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat$Token mediaSessionCompat$Token) {
            this.mToken = mediaSessionCompat$Token;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.mActionsToShowInCompact = iArr;
            return this;
        }

        public MediaStyle() {
        }

        public MediaStyle setShowCancelButton(boolean z9) {
            return this;
        }
    }
}
