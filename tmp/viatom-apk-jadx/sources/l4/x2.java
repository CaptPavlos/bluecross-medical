package l4;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBindings;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.uptodown.R;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyStatsActivity;
import com.uptodown.activities.NotificationsRegistryActivity;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.OrganizationActivity;
import com.uptodown.activities.PasswordEditActivity;
import com.uptodown.activities.PasswordRecoveryActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.activities.ReviewsActivity;
import com.uptodown.activities.RollbackActivity;
import com.uptodown.activities.SearchActivity;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.UserActivity;
import com.uptodown.activities.UserAvatarActivity;
import com.uptodown.activities.UserCommentsActivity;
import com.uptodown.activities.UserDeviceDetailsActivity;
import com.uptodown.activities.UserDevicesActivity;
import com.uptodown.activities.UserEditProfileActivity;
import com.uptodown.activities.UsernameEditActivity;
import com.uptodown.activities.VirusTotalReport;
import com.uptodown.activities.YouTubeActivity;
import com.uptodown.activities.preferences.AdvancedPreferencesActivity;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.util.views.UsernameTextView;
import com.uptodown.views.FullWidthImageView;
import com.uptodown.views.InstantAutoCompleteTextView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class x2 implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10980a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10981b;

    public /* synthetic */ x2(Object obj, int i10) {
        this.f10980a = i10;
        this.f10981b = obj;
    }

    private final Object a() {
        ReviewsActivity reviewsActivity = (ReviewsActivity) this.f10981b;
        int i10 = ReviewsActivity.M;
        View viewInflate = reviewsActivity.getLayoutInflater().inflate(R.layout.reviews_activity, (ViewGroup) null, false);
        int i11 = R.id.et_review;
        EditText editText = (EditText) ViewBindings.findChildViewById(viewInflate, R.id.et_review);
        if (editText != null) {
            i11 = R.id.hsv_order_reviews;
            if (((HorizontalScrollView) ViewBindings.findChildViewById(viewInflate, R.id.hsv_order_reviews)) != null) {
                i11 = R.id.iv_app_icon_reviews;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_app_icon_reviews);
                if (imageView != null) {
                    i11 = R.id.iv_send_review;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_send_review);
                    if (imageView2 != null) {
                        i11 = R.id.iv_star1_reviews;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_star1_reviews);
                        if (imageView3 != null) {
                            i11 = R.id.iv_star2_reviews;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_star2_reviews);
                            if (imageView4 != null) {
                                i11 = R.id.iv_star3_reviews;
                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_star3_reviews);
                                if (imageView5 != null) {
                                    i11 = R.id.iv_star4_reviews;
                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_star4_reviews);
                                    if (imageView6 != null) {
                                        i11 = R.id.iv_star5_reviews;
                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_star5_reviews);
                                        if (imageView7 != null) {
                                            i11 = R.id.ll_bottom_box_review;
                                            if (((LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_bottom_box_review)) != null) {
                                                i11 = R.id.ll_order_reviews;
                                                if (((LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_order_reviews)) != null) {
                                                    i11 = R.id.loading_view_reviews;
                                                    View viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, R.id.loading_view_reviews);
                                                    if (viewFindChildViewById != null) {
                                                        i11 = R.id.nsv_reviews;
                                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(viewInflate, R.id.nsv_reviews);
                                                        if (nestedScrollView != null) {
                                                            i11 = R.id.rl_bottom_box_shadow;
                                                            if (((RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_bottom_box_shadow)) != null) {
                                                                i11 = R.id.rl_header_reviews;
                                                                if (((RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_header_reviews)) != null) {
                                                                    i11 = R.id.rv_reviews;
                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate, R.id.rv_reviews);
                                                                    if (recyclerView != null) {
                                                                        i11 = R.id.toolbar_reviews;
                                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(viewInflate, R.id.toolbar_reviews);
                                                                        if (toolbar != null) {
                                                                            i11 = R.id.tv_app_author_reviews;
                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_app_author_reviews);
                                                                            if (textView != null) {
                                                                                i11 = R.id.tv_app_name_reviews;
                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_app_name_reviews);
                                                                                if (textView2 != null) {
                                                                                    i11 = R.id.tv_app_version_reviews;
                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_app_version_reviews);
                                                                                    if (textView3 != null) {
                                                                                        i11 = R.id.tv_order_by_best_reviews;
                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_order_by_best_reviews);
                                                                                        if (textView4 != null) {
                                                                                            i11 = R.id.tv_order_by_date_reviews;
                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_order_by_date_reviews);
                                                                                            if (textView5 != null) {
                                                                                                i11 = R.id.tv_order_by_most_reviews;
                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_order_by_most_reviews);
                                                                                                if (textView6 != null) {
                                                                                                    i11 = R.id.tv_toolbar_reviews;
                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_toolbar_reviews);
                                                                                                    if (textView7 != null) {
                                                                                                        return new d5.t0((RelativeLayout) viewInflate, editText, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, viewFindChildViewById, nestedScrollView, recyclerView, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
        return null;
    }

    private final Object b() {
        SecurityActivity securityActivity = (SecurityActivity) this.f10981b;
        int i10 = SecurityActivity.Z;
        View viewInflate = securityActivity.getLayoutInflater().inflate(R.layout.security_activity, (ViewGroup) null, false);
        int i11 = R.id.iv_positives;
        if (((AppCompatImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_positives)) != null) {
            i11 = R.id.loading_view_security;
            View viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, R.id.loading_view_security);
            if (viewFindChildViewById != null) {
                i11 = R.id.rl_free_positives;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_free_positives);
                if (linearLayout != null) {
                    i11 = R.id.rv_positives;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate, R.id.rv_positives);
                    if (recyclerView != null) {
                        i11 = R.id.toolbar_positives;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(viewInflate, R.id.toolbar_positives);
                        if (toolbar != null) {
                            i11 = R.id.tv_button_analysis_free_positives;
                            TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_button_analysis_free_positives);
                            if (textView != null) {
                                i11 = R.id.tv_last_analysis_free_positives;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_last_analysis_free_positives);
                                if (textView2 != null) {
                                    i11 = R.id.tv_title_free_positives;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_free_positives);
                                    if (textView3 != null) {
                                        i11 = R.id.tv_toolbar_title_positives;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_toolbar_title_positives);
                                        if (textView4 != null) {
                                            return new d5.x0((RelativeLayout) viewInflate, viewFindChildViewById, linearLayout, recyclerView, toolbar, textView, textView2, textView3, textView4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
        return null;
    }

    private final Object c() {
        Updates updates = (Updates) this.f10981b;
        int i10 = Updates.f6656p0;
        View viewInflate = updates.getLayoutInflater().inflate(R.layout.updates, (ViewGroup) null, false);
        int i11 = R.id.loading_view_updates;
        View viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, R.id.loading_view_updates);
        if (viewFindChildViewById != null) {
            i11 = R.id.pb_update_all;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(viewInflate, R.id.pb_update_all);
            if (progressBar != null) {
                i11 = R.id.rl_bottom_box_download_button_updates;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_bottom_box_download_button_updates);
                if (relativeLayout != null) {
                    i11 = R.id.rl_bottom_box_shadow;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_bottom_box_shadow);
                    if (relativeLayout2 != null) {
                        i11 = R.id.rl_update_all_progress_bottom;
                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_update_all_progress_bottom);
                        if (relativeLayout3 != null) {
                            i11 = R.id.rv_updates;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate, R.id.rv_updates);
                            if (recyclerView != null) {
                                i11 = R.id.srl_updates;
                                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(viewInflate, R.id.srl_updates);
                                if (swipeRefreshLayout != null) {
                                    i11 = R.id.toolbar_updates;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(viewInflate, R.id.toolbar_updates);
                                    if (toolbar != null) {
                                        i11 = R.id.tv_cancel_update_all;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_cancel_update_all);
                                        if (textView != null) {
                                            i11 = R.id.tv_description_update_all;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_description_update_all);
                                            if (textView2 != null) {
                                                i11 = R.id.tv_install_all_updates;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_install_all_updates);
                                                if (textView3 != null) {
                                                    i11 = R.id.tv_title_update_all;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_update_all);
                                                    if (textView4 != null) {
                                                        i11 = R.id.tv_toolbar_title_updates;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_toolbar_title_updates);
                                                        if (textView5 != null) {
                                                            return new d5.z0((RelativeLayout) viewInflate, viewFindChildViewById, progressBar, relativeLayout, relativeLayout2, relativeLayout3, recyclerView, swipeRefreshLayout, toolbar, textView, textView2, textView3, textView4, textView5);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
        return null;
    }

    private final Object d() {
        UserActivity userActivity = (UserActivity) this.f10981b;
        int i10 = UserActivity.Q;
        View viewInflate = userActivity.getLayoutInflater().inflate(R.layout.user_activity, (ViewGroup) null, false);
        int i11 = R.id.iv_turbo_mark_review;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_turbo_mark_review);
        if (imageView != null) {
            i11 = R.id.iv_user_avatar_user;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_user_avatar_user);
            if (imageView2 != null) {
                i11 = R.id.ll_feed_user;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_feed_user);
                if (linearLayout != null) {
                    i11 = R.id.ll_lists_user;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_lists_user);
                    if (linearLayout2 != null) {
                        i11 = R.id.ll_my_apps_user;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_my_apps_user);
                        if (linearLayout3 != null) {
                            i11 = R.id.ll_my_devices_user;
                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_my_devices_user);
                            if (linearLayout4 != null) {
                                i11 = R.id.ll_notifications_user;
                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_notifications_user);
                                if (linearLayout5 != null) {
                                    i11 = R.id.ll_reviews_user;
                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_reviews_user);
                                    if (linearLayout6 != null) {
                                        i11 = R.id.ll_rollback_user;
                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_rollback_user);
                                        if (linearLayout7 != null) {
                                            i11 = R.id.ll_settings_user;
                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_settings_user);
                                            if (linearLayout8 != null) {
                                                i11 = R.id.ll_stats_user;
                                                LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_stats_user);
                                                if (linearLayout9 != null) {
                                                    i11 = R.id.ll_turbo_promo_nordvpn_user;
                                                    LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_turbo_promo_nordvpn_user);
                                                    if (linearLayout10 != null) {
                                                        i11 = R.id.ll_turbo_user;
                                                        LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_turbo_user);
                                                        if (linearLayout11 != null) {
                                                            i11 = R.id.ll_user;
                                                            if (((LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_user)) != null) {
                                                                i11 = R.id.rl_downloads_user;
                                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_downloads_user);
                                                                if (relativeLayout != null) {
                                                                    i11 = R.id.rl_icon_downloads_user;
                                                                    if (((RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_icon_downloads_user)) != null) {
                                                                        i11 = R.id.rl_icon_updates_user;
                                                                        if (((RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_icon_updates_user)) != null) {
                                                                            i11 = R.id.rl_shadow_user;
                                                                            if (((RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_shadow_user)) != null) {
                                                                                i11 = R.id.rl_updates_user;
                                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_updates_user);
                                                                                if (relativeLayout2 != null) {
                                                                                    i11 = R.id.rl_user_avatar_user;
                                                                                    if (((RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_user_avatar_user)) != null) {
                                                                                        i11 = R.id.rl_user_info_user;
                                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_user_info_user);
                                                                                        if (relativeLayout3 != null) {
                                                                                            i11 = R.id.sv_user;
                                                                                            if (((ScrollView) ViewBindings.findChildViewById(viewInflate, R.id.sv_user)) != null) {
                                                                                                i11 = R.id.toolbar_user;
                                                                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(viewInflate, R.id.toolbar_user);
                                                                                                if (toolbar != null) {
                                                                                                    i11 = R.id.tv_downloads_user;
                                                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_downloads_user);
                                                                                                    if (textView != null) {
                                                                                                        i11 = R.id.tv_feed_user;
                                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_feed_user);
                                                                                                        if (textView2 != null) {
                                                                                                            i11 = R.id.tv_lists_user;
                                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_lists_user);
                                                                                                            if (textView3 != null) {
                                                                                                                i11 = R.id.tv_log_out_user;
                                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_log_out_user);
                                                                                                                if (textView4 != null) {
                                                                                                                    i11 = R.id.tv_my_apps_user;
                                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_my_apps_user);
                                                                                                                    if (textView5 != null) {
                                                                                                                        i11 = R.id.tv_my_devices_user;
                                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_my_devices_user);
                                                                                                                        if (textView6 != null) {
                                                                                                                            i11 = R.id.tv_notifications_user;
                                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_notifications_user);
                                                                                                                            if (textView7 != null) {
                                                                                                                                i11 = R.id.tv_notifier_downloads_user;
                                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_notifier_downloads_user);
                                                                                                                                if (textView8 != null) {
                                                                                                                                    i11 = R.id.tv_notifier_updates_user;
                                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_notifier_updates_user);
                                                                                                                                    if (textView9 != null) {
                                                                                                                                        i11 = R.id.tv_reviews_user;
                                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_reviews_user);
                                                                                                                                        if (textView10 != null) {
                                                                                                                                            i11 = R.id.tv_rollback_user;
                                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_rollback_user);
                                                                                                                                            if (textView11 != null) {
                                                                                                                                                i11 = R.id.tv_see_profile_user;
                                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_see_profile_user);
                                                                                                                                                if (textView12 != null) {
                                                                                                                                                    i11 = R.id.tv_settings_user;
                                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_settings_user);
                                                                                                                                                    if (textView13 != null) {
                                                                                                                                                        i11 = R.id.tv_stats_user;
                                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_stats_user);
                                                                                                                                                        if (textView14 != null) {
                                                                                                                                                            i11 = R.id.tv_toolbar_title_user;
                                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_toolbar_title_user);
                                                                                                                                                            if (textView15 != null) {
                                                                                                                                                                i11 = R.id.tv_turbo_promo_nordvpn_user;
                                                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_turbo_promo_nordvpn_user);
                                                                                                                                                                if (textView16 != null) {
                                                                                                                                                                    i11 = R.id.tv_turbo_user;
                                                                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_turbo_user);
                                                                                                                                                                    if (textView17 != null) {
                                                                                                                                                                        i11 = R.id.tv_updates_user;
                                                                                                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_updates_user);
                                                                                                                                                                        if (textView18 != null) {
                                                                                                                                                                            i11 = R.id.tv_username_user;
                                                                                                                                                                            UsernameTextView usernameTextView = (UsernameTextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_username_user);
                                                                                                                                                                            if (usernameTextView != null) {
                                                                                                                                                                                i11 = R.id.tv_web_user;
                                                                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_web_user);
                                                                                                                                                                                if (textView19 != null) {
                                                                                                                                                                                    return new d5.a1((RelativeLayout) viewInflate, imageView, imageView2, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, linearLayout11, relativeLayout, relativeLayout2, relativeLayout3, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, usernameTextView, textView19);
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
        return null;
    }

    private final Object e() {
        UserAvatarActivity userAvatarActivity = (UserAvatarActivity) this.f10981b;
        int i10 = UserAvatarActivity.O;
        View viewInflate = userAvatarActivity.getLayoutInflater().inflate(R.layout.user_avatar_activity, (ViewGroup) null, false);
        int i11 = R.id.iv_turbo_avatar_title_avatar_activity;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_turbo_avatar_title_avatar_activity);
        if (imageView != null) {
            i11 = R.id.ll_turbo_separator_avatar_activity;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_turbo_separator_avatar_activity);
            if (linearLayout != null) {
                i11 = R.id.loading_view_avatar;
                View viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, R.id.loading_view_avatar);
                if (viewFindChildViewById != null) {
                    i11 = R.id.rv_avatar_activity;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate, R.id.rv_avatar_activity);
                    if (recyclerView != null) {
                        i11 = R.id.rv_turbo_avatar_activity;
                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(viewInflate, R.id.rv_turbo_avatar_activity);
                        if (recyclerView2 != null) {
                            i11 = R.id.toolbar_avatar_activity;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(viewInflate, R.id.toolbar_avatar_activity);
                            if (toolbar != null) {
                                i11 = R.id.tv_avatars_title_avatar_activity;
                                TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_avatars_title_avatar_activity);
                                if (textView != null) {
                                    i11 = R.id.tv_save_avatar_activity;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_save_avatar_activity);
                                    if (textView2 != null) {
                                        i11 = R.id.tv_title_avatar_activity;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_avatar_activity);
                                        if (textView3 != null) {
                                            i11 = R.id.tv_toolbar_title_avatar_activity;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_toolbar_title_avatar_activity);
                                            if (textView4 != null) {
                                                i11 = R.id.tv_turbo_avatar_title_avatar_activity;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_turbo_avatar_title_avatar_activity);
                                                if (textView5 != null) {
                                                    return new d5.b1((RelativeLayout) viewInflate, imageView, linearLayout, viewFindChildViewById, recyclerView, recyclerView2, toolbar, textView, textView2, textView3, textView4, textView5);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
        return null;
    }

    private final Object f() {
        UserCommentsActivity userCommentsActivity = (UserCommentsActivity) this.f10981b;
        int i10 = UserCommentsActivity.L;
        View viewInflate = userCommentsActivity.getLayoutInflater().inflate(R.layout.user_comments_activity, (ViewGroup) null, false);
        int i11 = R.id.loading_view_user_comments;
        View viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, R.id.loading_view_user_comments);
        if (viewFindChildViewById != null) {
            i11 = R.id.rv_user_comments;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate, R.id.rv_user_comments);
            if (recyclerView != null) {
                i11 = R.id.toolbar_user_comments;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(viewInflate, R.id.toolbar_user_comments);
                if (toolbar != null) {
                    i11 = R.id.tv_error_user_comments;
                    TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_error_user_comments);
                    if (textView != null) {
                        i11 = R.id.tv_toolbar_title_user_comments;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_toolbar_title_user_comments);
                        if (textView2 != null) {
                            return new d5.c1((RelativeLayout) viewInflate, viewFindChildViewById, recyclerView, toolbar, textView, textView2);
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
        return null;
    }

    private final Object g() {
        UserDeviceDetailsActivity userDeviceDetailsActivity = (UserDeviceDetailsActivity) this.f10981b;
        int i10 = UserDeviceDetailsActivity.N;
        View viewInflate = userDeviceDetailsActivity.getLayoutInflater().inflate(R.layout.user_device_details_activity, (ViewGroup) null, false);
        int i11 = R.id.iv_edit_device_name_user_device_details;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_edit_device_name_user_device_details);
        if (imageView != null) {
            i11 = R.id.iv_filters_user_apps_details;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_filters_user_apps_details);
            if (imageView2 != null) {
                i11 = R.id.iv_uptodown_protect_value_user_device_details;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_uptodown_protect_value_user_device_details);
                if (imageView3 != null) {
                    i11 = R.id.ll_device_details;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_device_details);
                    if (linearLayout != null) {
                        i11 = R.id.loading_view_user_device_details;
                        View viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, R.id.loading_view_user_device_details);
                        if (viewFindChildViewById != null) {
                            i11 = R.id.rb_installed_apps_user_device_details;
                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(viewInflate, R.id.rb_installed_apps_user_device_details);
                            if (radioButton != null) {
                                i11 = R.id.rb_not_installed_apps_user_device_details;
                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(viewInflate, R.id.rb_not_installed_apps_user_device_details);
                                if (radioButton2 != null) {
                                    i11 = R.id.rg_filter_apps_user_device_details;
                                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(viewInflate, R.id.rg_filter_apps_user_device_details);
                                    if (radioGroup != null) {
                                        i11 = R.id.rv_user_apps_device_details;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate, R.id.rv_user_apps_device_details);
                                        if (recyclerView != null) {
                                            i11 = R.id.toolbar_user_device_details;
                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(viewInflate, R.id.toolbar_user_device_details);
                                            if (toolbar != null) {
                                                i11 = R.id.tv_brand_label_user_device_details;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_brand_label_user_device_details);
                                                if (textView != null) {
                                                    i11 = R.id.tv_brand_value_user_device_details;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_brand_value_user_device_details);
                                                    if (textView2 != null) {
                                                        i11 = R.id.tv_device_apps_user_device_details;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_device_apps_user_device_details);
                                                        if (textView3 != null) {
                                                            i11 = R.id.tv_device_name_user_device_details;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_device_name_user_device_details);
                                                            if (textView4 != null) {
                                                                i11 = R.id.tv_last_time_used_label_user_device_details;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_last_time_used_label_user_device_details);
                                                                if (textView5 != null) {
                                                                    i11 = R.id.tv_last_time_used_value_user_device_details;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_last_time_used_value_user_device_details);
                                                                    if (textView6 != null) {
                                                                        i11 = R.id.tv_model_label_user_device_details;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_model_label_user_device_details);
                                                                        if (textView7 != null) {
                                                                            i11 = R.id.tv_model_value_user_device_details;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_model_value_user_device_details);
                                                                            if (textView8 != null) {
                                                                                i11 = R.id.tv_no_items_device_details;
                                                                                if (((TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_no_items_device_details)) != null) {
                                                                                    i11 = R.id.tv_platform_label_user_device_details;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_platform_label_user_device_details);
                                                                                    if (textView9 != null) {
                                                                                        i11 = R.id.tv_platform_value_user_device_details;
                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_platform_value_user_device_details);
                                                                                        if (textView10 != null) {
                                                                                            i11 = R.id.tv_unlink_device_user_device_details;
                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_unlink_device_user_device_details);
                                                                                            if (textView11 != null) {
                                                                                                i11 = R.id.tv_uptodown_protect_label_user_device_details;
                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_uptodown_protect_label_user_device_details);
                                                                                                if (textView12 != null) {
                                                                                                    i11 = R.id.tv_user_device_details;
                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_user_device_details);
                                                                                                    if (textView13 != null) {
                                                                                                        return new d5.e1((RelativeLayout) viewInflate, imageView, imageView2, imageView3, linearLayout, viewFindChildViewById, radioButton, radioButton2, radioGroup, recyclerView, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
        return null;
    }

    private final Object h() {
        UserDevicesActivity userDevicesActivity = (UserDevicesActivity) this.f10981b;
        int i10 = UserDevicesActivity.K;
        View viewInflate = userDevicesActivity.getLayoutInflater().inflate(R.layout.user_devices_activity, (ViewGroup) null, false);
        int i11 = R.id.loading_view_user_devices;
        View viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, R.id.loading_view_user_devices);
        if (viewFindChildViewById != null) {
            i11 = R.id.nsv_user_devices;
            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(viewInflate, R.id.nsv_user_devices);
            if (nestedScrollView != null) {
                i11 = R.id.rv_user_devices;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate, R.id.rv_user_devices);
                if (recyclerView != null) {
                    i11 = R.id.toolbar_user_devices;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(viewInflate, R.id.toolbar_user_devices);
                    if (toolbar != null) {
                        i11 = R.id.tv_other_devices_user_devices;
                        TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_other_devices_user_devices);
                        if (textView != null) {
                            i11 = R.id.tv_this_device_user_devices;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_this_device_user_devices);
                            if (textView2 != null) {
                                i11 = R.id.tv_user_devices;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_user_devices);
                                if (textView3 != null) {
                                    i11 = R.id.user_device;
                                    View viewFindChildViewById2 = ViewBindings.findChildViewById(viewInflate, R.id.user_device);
                                    if (viewFindChildViewById2 != null) {
                                        return new d5.f1((RelativeLayout) viewInflate, viewFindChildViewById, nestedScrollView, recyclerView, toolbar, textView, textView2, textView3, d5.d1.a(viewFindChildViewById2));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
        return null;
    }

    private final Object i() {
        UserEditProfileActivity userEditProfileActivity = (UserEditProfileActivity) this.f10981b;
        int i10 = UserEditProfileActivity.K;
        View viewInflate = userEditProfileActivity.getLayoutInflater().inflate(R.layout.user_edit_profile, (ViewGroup) null, false);
        int i11 = R.id.ll_avatar_uep;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_avatar_uep);
        if (linearLayout != null) {
            i11 = R.id.ll_logout_uep;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_logout_uep);
            if (linearLayout2 != null) {
                i11 = R.id.ll_password_uep;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_password_uep);
                if (linearLayout3 != null) {
                    i11 = R.id.ll_username_uep;
                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_username_uep);
                    if (linearLayout4 != null) {
                        i11 = R.id.toolbar_uep;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(viewInflate, R.id.toolbar_uep);
                        if (toolbar != null) {
                            i11 = R.id.tv_avatar_uep;
                            TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_avatar_uep);
                            if (textView != null) {
                                i11 = R.id.tv_logout_uep;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_logout_uep);
                                if (textView2 != null) {
                                    i11 = R.id.tv_password_uep;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_password_uep);
                                    if (textView3 != null) {
                                        i11 = R.id.tv_title_uep;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_uep);
                                        if (textView4 != null) {
                                            i11 = R.id.tv_username_uep;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_username_uep);
                                            if (textView5 != null) {
                                                i11 = R.id.v_divider_uep;
                                                if (ViewBindings.findChildViewById(viewInflate, R.id.v_divider_uep) != null) {
                                                    return new d5.g1((RelativeLayout) viewInflate, linearLayout, linearLayout2, linearLayout3, linearLayout4, toolbar, textView, textView2, textView3, textView4, textView5);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
        return null;
    }

    private final Object j() {
        UsernameEditActivity usernameEditActivity = (UsernameEditActivity) this.f10981b;
        int i10 = UsernameEditActivity.K;
        View viewInflate = usernameEditActivity.getLayoutInflater().inflate(R.layout.username_edit, (ViewGroup) null, false);
        int i11 = R.id.et_username_edit;
        EditText editText = (EditText) ViewBindings.findChildViewById(viewInflate, R.id.et_username_edit);
        if (editText != null) {
            i11 = R.id.iv_lock_username_type_1;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_lock_username_type_1);
            if (imageView != null) {
                i11 = R.id.iv_lock_username_type_2;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_lock_username_type_2);
                if (imageView2 != null) {
                    i11 = R.id.iv_lock_username_type_3;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_lock_username_type_3);
                    if (imageView3 != null) {
                        i11 = R.id.iv_turbo_avatar_title_user_edit;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_turbo_avatar_title_user_edit);
                        if (imageView4 != null) {
                            i11 = R.id.ll_turbo_separator_user_edit;
                            if (((LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_turbo_separator_user_edit)) != null) {
                                i11 = R.id.ll_turbo_type_1;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_turbo_type_1);
                                if (linearLayout != null) {
                                    i11 = R.id.ll_turbo_type_2;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_turbo_type_2);
                                    if (linearLayout2 != null) {
                                        i11 = R.id.ll_turbo_type_3;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_turbo_type_3);
                                        if (linearLayout3 != null) {
                                            i11 = R.id.ll_turbo_username_type_user_edit;
                                            if (((LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_turbo_username_type_user_edit)) != null) {
                                                i11 = R.id.loading_view_username_edit;
                                                View viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, R.id.loading_view_username_edit);
                                                if (viewFindChildViewById != null) {
                                                    i11 = R.id.rb_turbo_type_0;
                                                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(viewInflate, R.id.rb_turbo_type_0);
                                                    if (radioButton != null) {
                                                        i11 = R.id.rb_turbo_type_1;
                                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(viewInflate, R.id.rb_turbo_type_1);
                                                        if (radioButton2 != null) {
                                                            i11 = R.id.rb_turbo_type_2;
                                                            RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(viewInflate, R.id.rb_turbo_type_2);
                                                            if (radioButton3 != null) {
                                                                i11 = R.id.rb_turbo_type_3;
                                                                RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(viewInflate, R.id.rb_turbo_type_3);
                                                                if (radioButton4 != null) {
                                                                    i11 = R.id.toolbar_username_edit;
                                                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(viewInflate, R.id.toolbar_username_edit);
                                                                    if (toolbar != null) {
                                                                        i11 = R.id.tv_max_chars_user_edit;
                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_max_chars_user_edit);
                                                                        if (textView != null) {
                                                                            i11 = R.id.tv_min_chars_user_edit;
                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_min_chars_user_edit);
                                                                            if (textView2 != null) {
                                                                                i11 = R.id.tv_title_toolbar_username_edit;
                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_toolbar_username_edit);
                                                                                if (textView3 != null) {
                                                                                    i11 = R.id.tv_turbo_username_styles_locked_user_edit;
                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_turbo_username_styles_locked_user_edit);
                                                                                    if (textView4 != null) {
                                                                                        i11 = R.id.tv_turbo_username_title_user_edit;
                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_turbo_username_title_user_edit);
                                                                                        if (textView5 != null) {
                                                                                            i11 = R.id.tv_type_chars_user_edit;
                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_type_chars_user_edit);
                                                                                            if (textView6 != null) {
                                                                                                i11 = R.id.tv_username_edit_change;
                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_username_edit_change);
                                                                                                if (textView7 != null) {
                                                                                                    i11 = R.id.tv_username_type_0;
                                                                                                    UsernameTextView usernameTextView = (UsernameTextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_username_type_0);
                                                                                                    if (usernameTextView != null) {
                                                                                                        i11 = R.id.tv_username_type_1;
                                                                                                        UsernameTextView usernameTextView2 = (UsernameTextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_username_type_1);
                                                                                                        if (usernameTextView2 != null) {
                                                                                                            i11 = R.id.tv_username_type_2;
                                                                                                            UsernameTextView usernameTextView3 = (UsernameTextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_username_type_2);
                                                                                                            if (usernameTextView3 != null) {
                                                                                                                i11 = R.id.tv_username_type_3;
                                                                                                                UsernameTextView usernameTextView4 = (UsernameTextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_username_type_3);
                                                                                                                if (usernameTextView4 != null) {
                                                                                                                    return new d5.i1((RelativeLayout) viewInflate, editText, imageView, imageView2, imageView3, imageView4, linearLayout, linearLayout2, linearLayout3, viewFindChildViewById, radioButton, radioButton2, radioButton3, radioButton4, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7, usernameTextView, usernameTextView2, usernameTextView3, usernameTextView4);
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
        return null;
    }

    private final Object k() {
        VirusTotalReport virusTotalReport = (VirusTotalReport) this.f10981b;
        int i10 = VirusTotalReport.J;
        View viewInflate = virusTotalReport.getLayoutInflater().inflate(R.layout.virus_total_report, (ViewGroup) null, false);
        int i11 = R.id.header_installed_app;
        View viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, R.id.header_installed_app);
        if (viewFindChildViewById != null) {
            int i12 = R.id.iv_logo_app;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById, R.id.iv_logo_app);
            if (imageView != null) {
                i12 = R.id.tv_app_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(viewFindChildViewById, R.id.tv_app_name);
                if (textView != null) {
                    i12 = R.id.tv_app_version;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById, R.id.tv_app_version);
                    if (textView2 != null) {
                        d5.s sVar = new d5.s((RelativeLayout) viewFindChildViewById, imageView, textView, textView2, 0);
                        i11 = R.id.iv_correct_malware;
                        if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_correct_malware)) != null) {
                            i11 = R.id.iv_correct_spyware;
                            if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_correct_spyware)) != null) {
                                i11 = R.id.iv_correct_virus;
                                if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_correct_virus)) != null) {
                                    i11 = R.id.iv_logo_uptodown_vtr;
                                    if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_logo_uptodown_vtr)) != null) {
                                        i11 = R.id.iv_sha256_vtr;
                                        if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_sha256_vtr)) != null) {
                                            i11 = R.id.iv_signature_vtr;
                                            if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_signature_vtr)) != null) {
                                                i11 = R.id.ll_container_scans_vtr;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_container_scans_vtr);
                                                if (linearLayout != null) {
                                                    i11 = R.id.ll_report_vtr;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_report_vtr);
                                                    if (linearLayout2 != null) {
                                                        i11 = R.id.loading_view_virus_total_report;
                                                        View viewFindChildViewById2 = ViewBindings.findChildViewById(viewInflate, R.id.loading_view_virus_total_report);
                                                        if (viewFindChildViewById2 != null) {
                                                            i11 = R.id.rl_container_result_clean;
                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_container_result_clean);
                                                            if (relativeLayout != null) {
                                                                i11 = R.id.rl_result_scan;
                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_result_scan);
                                                                if (relativeLayout2 != null) {
                                                                    i11 = R.id.rl_sha256_more_info;
                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_sha256_more_info);
                                                                    if (relativeLayout3 != null) {
                                                                        i11 = R.id.rl_signature_more_info;
                                                                        if (((RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_signature_more_info)) != null) {
                                                                            i11 = R.id.sv_report_vtr;
                                                                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(viewInflate, R.id.sv_report_vtr);
                                                                            if (scrollView != null) {
                                                                                i11 = R.id.toolbar_vtr;
                                                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(viewInflate, R.id.toolbar_vtr);
                                                                                if (toolbar != null) {
                                                                                    i11 = R.id.tv_full_report_vtr;
                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_full_report_vtr);
                                                                                    if (textView3 != null) {
                                                                                        i11 = R.id.tv_label_full_report_vtr;
                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_label_full_report_vtr);
                                                                                        if (textView4 != null) {
                                                                                            i11 = R.id.tv_last_scan_results;
                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_last_scan_results);
                                                                                            if (textView5 != null) {
                                                                                                i11 = R.id.tv_msg_results;
                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_msg_results);
                                                                                                if (textView6 != null) {
                                                                                                    i11 = R.id.tv_no_data_vtr;
                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_no_data_vtr);
                                                                                                    if (textView7 != null) {
                                                                                                        i11 = R.id.tv_no_malware;
                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_no_malware);
                                                                                                        if (textView8 != null) {
                                                                                                            i11 = R.id.tv_no_spyware;
                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_no_spyware);
                                                                                                            if (textView9 != null) {
                                                                                                                i11 = R.id.tv_no_virus;
                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_no_virus);
                                                                                                                if (textView10 != null) {
                                                                                                                    i11 = R.id.tv_not_avaialable_vtr;
                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_not_avaialable_vtr);
                                                                                                                    if (textView11 != null) {
                                                                                                                        i11 = R.id.tv_positives_results;
                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_positives_results);
                                                                                                                        if (textView12 != null) {
                                                                                                                            i11 = R.id.tv_sha256_label_vtr;
                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_sha256_label_vtr);
                                                                                                                            if (textView13 != null) {
                                                                                                                                i11 = R.id.tv_sha256_value_vtr;
                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_sha256_value_vtr);
                                                                                                                                if (textView14 != null) {
                                                                                                                                    i11 = R.id.tv_signature_label_vtr;
                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_signature_label_vtr);
                                                                                                                                    if (textView15 != null) {
                                                                                                                                        i11 = R.id.tv_signature_value_vtr;
                                                                                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_signature_value_vtr);
                                                                                                                                        if (textView16 != null) {
                                                                                                                                            i11 = R.id.tv_toolbar_vtr;
                                                                                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_toolbar_vtr);
                                                                                                                                            if (textView17 != null) {
                                                                                                                                                i11 = R.id.vt_report_certified_by_uptodown;
                                                                                                                                                TextView textView18 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.vt_report_certified_by_uptodown);
                                                                                                                                                if (textView18 != null) {
                                                                                                                                                    return new d5.k1((RelativeLayout) viewInflate, sVar, linearLayout, linearLayout2, viewFindChildViewById2, relativeLayout, relativeLayout2, relativeLayout3, scrollView, toolbar, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18);
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            androidx.window.layout.c.k("Missing required view with ID: ".concat(viewFindChildViewById.getResources().getResourceName(i12)));
            return null;
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
        return null;
    }

    private final Object l() {
        YouTubeActivity youTubeActivity = (YouTubeActivity) this.f10981b;
        int i10 = YouTubeActivity.J;
        View viewInflate = youTubeActivity.getLayoutInflater().inflate(R.layout.video_youtube, (ViewGroup) null, false);
        int i11 = R.id.youtube_full_screen;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(viewInflate, R.id.youtube_full_screen);
        if (frameLayout != null) {
            i11 = R.id.youtube_view;
            YouTubePlayerView youTubePlayerView = (YouTubePlayerView) ViewBindings.findChildViewById(viewInflate, R.id.youtube_view);
            if (youTubePlayerView != null) {
                return new d5.j1((RelativeLayout) viewInflate, frameLayout, youTubePlayerView);
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
        return null;
    }

    private final Object m() {
        AdvancedPreferencesActivity advancedPreferencesActivity = (AdvancedPreferencesActivity) this.f10981b;
        int i10 = AdvancedPreferencesActivity.J;
        View viewInflate = advancedPreferencesActivity.getLayoutInflater().inflate(R.layout.advanced_preferences_activity, (ViewGroup) null, false);
        int i11 = R.id.ll_advanced_preferences_list;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_advanced_preferences_list);
        if (linearLayout != null) {
            LinearLayout linearLayout2 = (LinearLayout) viewInflate;
            int i12 = R.id.toolbar_advanced_preferences;
            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(viewInflate, R.id.toolbar_advanced_preferences);
            if (toolbar != null) {
                i12 = R.id.tv_toolbar_title_advanced_preferences;
                TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_toolbar_title_advanced_preferences);
                if (textView != null) {
                    return new d5.a(linearLayout2, linearLayout, toolbar, textView);
                }
            }
            i11 = i12;
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
        return null;
    }

    private final Object n() {
        PreferencesActivity preferencesActivity = (PreferencesActivity) this.f10981b;
        int i10 = PreferencesActivity.M;
        View viewInflate = preferencesActivity.getLayoutInflater().inflate(R.layout.preferences_activity, (ViewGroup) null, false);
        int i11 = R.id.about_app_setting;
        View viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, R.id.about_app_setting);
        if (viewFindChildViewById != null) {
            d5.s sVarA = d5.s.a(viewFindChildViewById);
            i11 = R.id.about_uptodown_setting;
            View viewFindChildViewById2 = ViewBindings.findChildViewById(viewInflate, R.id.about_uptodown_setting);
            if (viewFindChildViewById2 != null) {
                d5.s sVarA2 = d5.s.a(viewFindChildViewById2);
                i11 = R.id.ads_setting;
                View viewFindChildViewById3 = ViewBindings.findChildViewById(viewInflate, R.id.ads_setting);
                if (viewFindChildViewById3 != null) {
                    d5.s sVarA3 = d5.s.a(viewFindChildViewById3);
                    i11 = R.id.advanced_setting;
                    View viewFindChildViewById4 = ViewBindings.findChildViewById(viewInflate, R.id.advanced_setting);
                    if (viewFindChildViewById4 != null) {
                        d5.s sVarA4 = d5.s.a(viewFindChildViewById4);
                        i11 = R.id.allow_animations_switch_setting;
                        View viewFindChildViewById5 = ViewBindings.findChildViewById(viewInflate, R.id.allow_animations_switch_setting);
                        if (viewFindChildViewById5 != null) {
                            d5.j0 j0VarA = d5.j0.a(viewFindChildViewById5);
                            i11 = R.id.auto_play_video_setting;
                            View viewFindChildViewById6 = ViewBindings.findChildViewById(viewInflate, R.id.auto_play_video_setting);
                            if (viewFindChildViewById6 != null) {
                                a3.x xVarR = a3.x.r(viewFindChildViewById6);
                                i11 = R.id.auto_update_root_switch_setting;
                                View viewFindChildViewById7 = ViewBindings.findChildViewById(viewInflate, R.id.auto_update_root_switch_setting);
                                if (viewFindChildViewById7 != null) {
                                    d5.j0 j0VarA2 = d5.j0.a(viewFindChildViewById7);
                                    i11 = R.id.data_saver_setting;
                                    View viewFindChildViewById8 = ViewBindings.findChildViewById(viewInflate, R.id.data_saver_setting);
                                    if (viewFindChildViewById8 != null) {
                                        a3.x xVarR2 = a3.x.r(viewFindChildViewById8);
                                        i11 = R.id.downloads_notification_setting;
                                        View viewFindChildViewById9 = ViewBindings.findChildViewById(viewInflate, R.id.downloads_notification_setting);
                                        if (viewFindChildViewById9 != null) {
                                            d5.j0 j0VarA3 = d5.j0.a(viewFindChildViewById9);
                                            i11 = R.id.feedback_setting;
                                            View viewFindChildViewById10 = ViewBindings.findChildViewById(viewInflate, R.id.feedback_setting);
                                            if (viewFindChildViewById10 != null) {
                                                d5.s sVarA5 = d5.s.a(viewFindChildViewById10);
                                                i11 = R.id.file_management_category;
                                                View viewFindChildViewById11 = ViewBindings.findChildViewById(viewInflate, R.id.file_management_category);
                                                if (viewFindChildViewById11 != null) {
                                                    a4.f fVarI = a4.f.i(viewFindChildViewById11);
                                                    i11 = R.id.installable_files_notification_setting;
                                                    View viewFindChildViewById12 = ViewBindings.findChildViewById(viewInflate, R.id.installable_files_notification_setting);
                                                    if (viewFindChildViewById12 != null) {
                                                        d5.j0 j0VarA4 = d5.j0.a(viewFindChildViewById12);
                                                        i11 = R.id.installations_notification_setting;
                                                        View viewFindChildViewById13 = ViewBindings.findChildViewById(viewInflate, R.id.installations_notification_setting);
                                                        if (viewFindChildViewById13 != null) {
                                                            d5.j0 j0VarA5 = d5.j0.a(viewFindChildViewById13);
                                                            i11 = R.id.language_setting;
                                                            View viewFindChildViewById14 = ViewBindings.findChildViewById(viewInflate, R.id.language_setting);
                                                            if (viewFindChildViewById14 != null) {
                                                                d5.s sVarA6 = d5.s.a(viewFindChildViewById14);
                                                                i11 = R.id.ll_preferences_list;
                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_preferences_list);
                                                                if (linearLayout != null) {
                                                                    i11 = R.id.more_info_category;
                                                                    View viewFindChildViewById15 = ViewBindings.findChildViewById(viewInflate, R.id.more_info_category);
                                                                    if (viewFindChildViewById15 != null) {
                                                                        a4.f fVarI2 = a4.f.i(viewFindChildViewById15);
                                                                        i11 = R.id.notifications_category;
                                                                        View viewFindChildViewById16 = ViewBindings.findChildViewById(viewInflate, R.id.notifications_category);
                                                                        if (viewFindChildViewById16 != null) {
                                                                            a4.f fVarI3 = a4.f.i(viewFindChildViewById16);
                                                                            i11 = R.id.only_wifi_switch_setting;
                                                                            View viewFindChildViewById17 = ViewBindings.findChildViewById(viewInflate, R.id.only_wifi_switch_setting);
                                                                            if (viewFindChildViewById17 != null) {
                                                                                d5.j0 j0VarA6 = d5.j0.a(viewFindChildViewById17);
                                                                                i11 = R.id.performance_category;
                                                                                View viewFindChildViewById18 = ViewBindings.findChildViewById(viewInflate, R.id.performance_category);
                                                                                if (viewFindChildViewById18 != null) {
                                                                                    a4.f fVarI4 = a4.f.i(viewFindChildViewById18);
                                                                                    i11 = R.id.privacy_and_policy_category;
                                                                                    View viewFindChildViewById19 = ViewBindings.findChildViewById(viewInflate, R.id.privacy_and_policy_category);
                                                                                    if (viewFindChildViewById19 != null) {
                                                                                        a4.f fVarI5 = a4.f.i(viewFindChildViewById19);
                                                                                        i11 = R.id.privacy_setting;
                                                                                        View viewFindChildViewById20 = ViewBindings.findChildViewById(viewInflate, R.id.privacy_setting);
                                                                                        if (viewFindChildViewById20 != null) {
                                                                                            d5.s sVarA7 = d5.s.a(viewFindChildViewById20);
                                                                                            i11 = R.id.quick_install_root_switch_setting;
                                                                                            View viewFindChildViewById21 = ViewBindings.findChildViewById(viewInflate, R.id.quick_install_root_switch_setting);
                                                                                            if (viewFindChildViewById21 != null) {
                                                                                                d5.j0 j0VarA7 = d5.j0.a(viewFindChildViewById21);
                                                                                                LinearLayout linearLayout2 = (LinearLayout) viewInflate;
                                                                                                i11 = R.id.root_category;
                                                                                                View viewFindChildViewById22 = ViewBindings.findChildViewById(viewInflate, R.id.root_category);
                                                                                                if (viewFindChildViewById22 != null) {
                                                                                                    a4.f fVarI6 = a4.f.i(viewFindChildViewById22);
                                                                                                    i11 = R.id.show_notifications_setting;
                                                                                                    View viewFindChildViewById23 = ViewBindings.findChildViewById(viewInflate, R.id.show_notifications_setting);
                                                                                                    if (viewFindChildViewById23 != null) {
                                                                                                        d5.j0 j0VarA8 = d5.j0.a(viewFindChildViewById23);
                                                                                                        i11 = R.id.toolbar_preferences;
                                                                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(viewInflate, R.id.toolbar_preferences);
                                                                                                        if (toolbar != null) {
                                                                                                            i11 = R.id.tos_setting;
                                                                                                            View viewFindChildViewById24 = ViewBindings.findChildViewById(viewInflate, R.id.tos_setting);
                                                                                                            if (viewFindChildViewById24 != null) {
                                                                                                                d5.s sVarA8 = d5.s.a(viewFindChildViewById24);
                                                                                                                i11 = R.id.tv_toolbar_title_preferences;
                                                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_toolbar_title_preferences);
                                                                                                                if (textView != null) {
                                                                                                                    i11 = R.id.updates_category;
                                                                                                                    View viewFindChildViewById25 = ViewBindings.findChildViewById(viewInflate, R.id.updates_category);
                                                                                                                    if (viewFindChildViewById25 != null) {
                                                                                                                        a4.f fVarI7 = a4.f.i(viewFindChildViewById25);
                                                                                                                        i11 = R.id.updates_notification_setting;
                                                                                                                        View viewFindChildViewById26 = ViewBindings.findChildViewById(viewInflate, R.id.updates_notification_setting);
                                                                                                                        if (viewFindChildViewById26 != null) {
                                                                                                                            a3.x xVarR3 = a3.x.r(viewFindChildViewById26);
                                                                                                                            i11 = R.id.updates_setting;
                                                                                                                            View viewFindChildViewById27 = ViewBindings.findChildViewById(viewInflate, R.id.updates_setting);
                                                                                                                            if (viewFindChildViewById27 != null) {
                                                                                                                                RelativeLayout relativeLayout = (RelativeLayout) viewFindChildViewById27;
                                                                                                                                int i12 = R.id.sc_preference_switch;
                                                                                                                                SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(viewFindChildViewById27, R.id.sc_preference_switch);
                                                                                                                                if (switchCompat != null) {
                                                                                                                                    i12 = R.id.tv_preference_switch_description;
                                                                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById27, R.id.tv_preference_switch_description);
                                                                                                                                    if (textView2 != null) {
                                                                                                                                        i12 = R.id.tv_preference_switch_title;
                                                                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById27, R.id.tv_preference_switch_title);
                                                                                                                                        if (textView3 != null) {
                                                                                                                                            return new d5.k0(linearLayout2, sVarA, sVarA2, sVarA3, sVarA4, j0VarA, xVarR, j0VarA2, xVarR2, j0VarA3, sVarA5, fVarI, j0VarA4, j0VarA5, sVarA6, linearLayout, fVarI2, fVarI3, j0VarA6, fVarI4, fVarI5, sVarA7, j0VarA7, fVarI6, j0VarA8, toolbar, sVarA8, textView, fVarI7, xVarR3, new d5.j0(relativeLayout, switchCompat, textView2, textView3, 1));
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewFindChildViewById27.getResources().getResourceName(i12)));
                                                                                                                                return null;
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
        return null;
    }

    @Override // g7.a
    public final Object invoke() {
        int i10 = this.f10980a;
        Object obj = this.f10981b;
        switch (i10) {
            case 0:
                int i11 = MoreInfo.P;
                View viewInflate = ((MoreInfo) obj).getLayoutInflater().inflate(R.layout.more_info, (ViewGroup) null, false);
                int i12 = R.id.iv_abis_more_info;
                if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_abis_more_info)) != null) {
                    i12 = R.id.iv_ads_more_info;
                    if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_ads_more_info)) != null) {
                        i12 = R.id.iv_author_more_info;
                        if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_author_more_info)) != null) {
                            i12 = R.id.iv_category_more_info;
                            if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_category_more_info)) != null) {
                                i12 = R.id.iv_copy_to_clipboard_sha_more_info;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_copy_to_clipboard_sha_more_info);
                                if (imageView != null) {
                                    i12 = R.id.iv_copy_to_clipboard_signature_more_info;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_copy_to_clipboard_signature_more_info);
                                    if (imageView2 != null) {
                                        i12 = R.id.iv_date_more_info;
                                        if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_date_more_info)) != null) {
                                            i12 = R.id.iv_device_type_more_info;
                                            if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_device_type_more_info)) != null) {
                                                i12 = R.id.iv_downloads_more_info;
                                                if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_downloads_more_info)) != null) {
                                                    i12 = R.id.iv_file_type_more_info;
                                                    if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_file_type_more_info)) != null) {
                                                        i12 = R.id.iv_lang_more_info;
                                                        if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_lang_more_info)) != null) {
                                                            i12 = R.id.iv_lang_plus_minus_more_info;
                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_lang_plus_minus_more_info);
                                                            if (imageView3 != null) {
                                                                i12 = R.id.iv_license_more_info;
                                                                if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_license_more_info)) != null) {
                                                                    i12 = R.id.iv_packagename_more_info;
                                                                    if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_packagename_more_info)) != null) {
                                                                        i12 = R.id.iv_pegi_more_info;
                                                                        if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_pegi_more_info)) != null) {
                                                                            i12 = R.id.iv_permissions_more_info;
                                                                            if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_permissions_more_info)) != null) {
                                                                                i12 = R.id.iv_plus_minus_more_info;
                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_plus_minus_more_info);
                                                                                if (imageView4 != null) {
                                                                                    i12 = R.id.iv_published_warning_more_info;
                                                                                    if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_published_warning_more_info)) != null) {
                                                                                        i12 = R.id.iv_req_more_info;
                                                                                        if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_req_more_info)) != null) {
                                                                                            i12 = R.id.iv_sha256_more_info;
                                                                                            if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_sha256_more_info)) != null) {
                                                                                                i12 = R.id.iv_signature_more_info;
                                                                                                if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_signature_more_info)) != null) {
                                                                                                    i12 = R.id.iv_size_more_info;
                                                                                                    if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_size_more_info)) != null) {
                                                                                                        i12 = R.id.iv_version_more_info;
                                                                                                        if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_version_more_info)) != null) {
                                                                                                            i12 = R.id.iv_virustotal_report_more_info;
                                                                                                            if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_virustotal_report_more_info)) != null) {
                                                                                                                i12 = R.id.ll_dangerous_permissions;
                                                                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_dangerous_permissions);
                                                                                                                if (linearLayout != null) {
                                                                                                                    i12 = R.id.ll_languages_list;
                                                                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_languages_list);
                                                                                                                    if (linearLayout2 != null) {
                                                                                                                        i12 = R.id.ll_more_info;
                                                                                                                        if (((LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_more_info)) != null) {
                                                                                                                            i12 = R.id.ll_others_permissions;
                                                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_others_permissions);
                                                                                                                            if (linearLayout3 != null) {
                                                                                                                                i12 = R.id.ll_permissions_more_info;
                                                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_permissions_more_info);
                                                                                                                                if (linearLayout4 != null) {
                                                                                                                                    i12 = R.id.loading_view_more_info;
                                                                                                                                    View viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, R.id.loading_view_more_info);
                                                                                                                                    if (viewFindChildViewById != null) {
                                                                                                                                        i12 = R.id.rl_abis_more_info;
                                                                                                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_abis_more_info);
                                                                                                                                        if (relativeLayout != null) {
                                                                                                                                            i12 = R.id.rl_ads_more_info;
                                                                                                                                            if (((RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_ads_more_info)) != null) {
                                                                                                                                                i12 = R.id.rl_author_more_info;
                                                                                                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_author_more_info);
                                                                                                                                                if (relativeLayout2 != null) {
                                                                                                                                                    i12 = R.id.rl_category_more_info;
                                                                                                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_category_more_info);
                                                                                                                                                    if (relativeLayout3 != null) {
                                                                                                                                                        i12 = R.id.rl_date_more_info;
                                                                                                                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_date_more_info);
                                                                                                                                                        if (relativeLayout4 != null) {
                                                                                                                                                            i12 = R.id.rl_device_type_more_info;
                                                                                                                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_device_type_more_info);
                                                                                                                                                            if (relativeLayout5 != null) {
                                                                                                                                                                i12 = R.id.rl_downloads_more_info;
                                                                                                                                                                RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_downloads_more_info);
                                                                                                                                                                if (relativeLayout6 != null) {
                                                                                                                                                                    i12 = R.id.rl_file_type_more_info;
                                                                                                                                                                    RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_file_type_more_info);
                                                                                                                                                                    if (relativeLayout7 != null) {
                                                                                                                                                                        i12 = R.id.rl_lang_more_info;
                                                                                                                                                                        RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_lang_more_info);
                                                                                                                                                                        if (relativeLayout8 != null) {
                                                                                                                                                                            i12 = R.id.rl_license_more_info;
                                                                                                                                                                            RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_license_more_info);
                                                                                                                                                                            if (relativeLayout9 != null) {
                                                                                                                                                                                RelativeLayout relativeLayout10 = (RelativeLayout) viewInflate;
                                                                                                                                                                                i12 = R.id.rl_packagename_more_info;
                                                                                                                                                                                RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_packagename_more_info);
                                                                                                                                                                                if (relativeLayout11 != null) {
                                                                                                                                                                                    i12 = R.id.rl_pegi_more_info;
                                                                                                                                                                                    RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_pegi_more_info);
                                                                                                                                                                                    if (relativeLayout12 != null) {
                                                                                                                                                                                        i12 = R.id.rl_permissions_more_info;
                                                                                                                                                                                        RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_permissions_more_info);
                                                                                                                                                                                        if (relativeLayout13 != null) {
                                                                                                                                                                                            i12 = R.id.rl_published_warning_more_info;
                                                                                                                                                                                            if (((RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_published_warning_more_info)) != null) {
                                                                                                                                                                                                i12 = R.id.rl_requirements_more_info;
                                                                                                                                                                                                RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_requirements_more_info);
                                                                                                                                                                                                if (relativeLayout14 != null) {
                                                                                                                                                                                                    i12 = R.id.rl_sha256_more_info;
                                                                                                                                                                                                    RelativeLayout relativeLayout15 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_sha256_more_info);
                                                                                                                                                                                                    if (relativeLayout15 != null) {
                                                                                                                                                                                                        i12 = R.id.rl_signature_more_info;
                                                                                                                                                                                                        RelativeLayout relativeLayout16 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_signature_more_info);
                                                                                                                                                                                                        if (relativeLayout16 != null) {
                                                                                                                                                                                                            i12 = R.id.rl_size_more_info;
                                                                                                                                                                                                            RelativeLayout relativeLayout17 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_size_more_info);
                                                                                                                                                                                                            if (relativeLayout17 != null) {
                                                                                                                                                                                                                i12 = R.id.rl_version_more_info;
                                                                                                                                                                                                                RelativeLayout relativeLayout18 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_version_more_info);
                                                                                                                                                                                                                if (relativeLayout18 != null) {
                                                                                                                                                                                                                    i12 = R.id.rl_virustotal_report_more_info;
                                                                                                                                                                                                                    if (((RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_virustotal_report_more_info)) != null) {
                                                                                                                                                                                                                        i12 = R.id.sv_more_info;
                                                                                                                                                                                                                        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(viewInflate, R.id.sv_more_info);
                                                                                                                                                                                                                        if (scrollView != null) {
                                                                                                                                                                                                                            i12 = R.id.toolbar_more_info;
                                                                                                                                                                                                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(viewInflate, R.id.toolbar_more_info);
                                                                                                                                                                                                                            if (toolbar != null) {
                                                                                                                                                                                                                                i12 = R.id.tv_abis_label_more_info;
                                                                                                                                                                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_abis_label_more_info);
                                                                                                                                                                                                                                if (textView != null) {
                                                                                                                                                                                                                                    i12 = R.id.tv_abis_more_info;
                                                                                                                                                                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_abis_more_info);
                                                                                                                                                                                                                                    if (textView2 != null) {
                                                                                                                                                                                                                                        i12 = R.id.tv_ads_label_more_info;
                                                                                                                                                                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_ads_label_more_info);
                                                                                                                                                                                                                                        if (textView3 != null) {
                                                                                                                                                                                                                                            i12 = R.id.tv_ads_more_info;
                                                                                                                                                                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_ads_more_info);
                                                                                                                                                                                                                                            if (textView4 != null) {
                                                                                                                                                                                                                                                i12 = R.id.tv_app_name_more_info;
                                                                                                                                                                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_app_name_more_info);
                                                                                                                                                                                                                                                if (textView5 != null) {
                                                                                                                                                                                                                                                    i12 = R.id.tv_author_label_more_info;
                                                                                                                                                                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_author_label_more_info);
                                                                                                                                                                                                                                                    if (textView6 != null) {
                                                                                                                                                                                                                                                        i12 = R.id.tv_author_more_info;
                                                                                                                                                                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_author_more_info);
                                                                                                                                                                                                                                                        if (textView7 != null) {
                                                                                                                                                                                                                                                            i12 = R.id.tv_basic_title_more_info;
                                                                                                                                                                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_basic_title_more_info);
                                                                                                                                                                                                                                                            if (textView8 != null) {
                                                                                                                                                                                                                                                                i12 = R.id.tv_category_label_more_info;
                                                                                                                                                                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_category_label_more_info);
                                                                                                                                                                                                                                                                if (textView9 != null) {
                                                                                                                                                                                                                                                                    i12 = R.id.tv_category_more_info;
                                                                                                                                                                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_category_more_info);
                                                                                                                                                                                                                                                                    if (textView10 != null) {
                                                                                                                                                                                                                                                                        i12 = R.id.tv_dangerous;
                                                                                                                                                                                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_dangerous);
                                                                                                                                                                                                                                                                        if (textView11 != null) {
                                                                                                                                                                                                                                                                            i12 = R.id.tv_date_label_more_info;
                                                                                                                                                                                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_date_label_more_info);
                                                                                                                                                                                                                                                                            if (textView12 != null) {
                                                                                                                                                                                                                                                                                i12 = R.id.tv_date_more_info;
                                                                                                                                                                                                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_date_more_info);
                                                                                                                                                                                                                                                                                if (textView13 != null) {
                                                                                                                                                                                                                                                                                    i12 = R.id.tv_device_type_label_more_info;
                                                                                                                                                                                                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_device_type_label_more_info);
                                                                                                                                                                                                                                                                                    if (textView14 != null) {
                                                                                                                                                                                                                                                                                        i12 = R.id.tv_device_type_more_info;
                                                                                                                                                                                                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_device_type_more_info);
                                                                                                                                                                                                                                                                                        if (textView15 != null) {
                                                                                                                                                                                                                                                                                            i12 = R.id.tv_download_title_more_info;
                                                                                                                                                                                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_download_title_more_info);
                                                                                                                                                                                                                                                                                            if (textView16 != null) {
                                                                                                                                                                                                                                                                                                i12 = R.id.tv_downloads_label_more_info;
                                                                                                                                                                                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_downloads_label_more_info);
                                                                                                                                                                                                                                                                                                if (textView17 != null) {
                                                                                                                                                                                                                                                                                                    i12 = R.id.tv_downloads_more_info;
                                                                                                                                                                                                                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_downloads_more_info);
                                                                                                                                                                                                                                                                                                    if (textView18 != null) {
                                                                                                                                                                                                                                                                                                        i12 = R.id.tv_file_type_label_more_info;
                                                                                                                                                                                                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_file_type_label_more_info);
                                                                                                                                                                                                                                                                                                        if (textView19 != null) {
                                                                                                                                                                                                                                                                                                            i12 = R.id.tv_file_type_more_info;
                                                                                                                                                                                                                                                                                                            TextView textView20 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_file_type_more_info);
                                                                                                                                                                                                                                                                                                            if (textView20 != null) {
                                                                                                                                                                                                                                                                                                                i12 = R.id.tv_lang_label_more_info;
                                                                                                                                                                                                                                                                                                                TextView textView21 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_lang_label_more_info);
                                                                                                                                                                                                                                                                                                                if (textView21 != null) {
                                                                                                                                                                                                                                                                                                                    i12 = R.id.tv_lang_more_info;
                                                                                                                                                                                                                                                                                                                    TextView textView22 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_lang_more_info);
                                                                                                                                                                                                                                                                                                                    if (textView22 != null) {
                                                                                                                                                                                                                                                                                                                        i12 = R.id.tv_license_label_more_info;
                                                                                                                                                                                                                                                                                                                        TextView textView23 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_license_label_more_info);
                                                                                                                                                                                                                                                                                                                        if (textView23 != null) {
                                                                                                                                                                                                                                                                                                                            i12 = R.id.tv_license_more_info;
                                                                                                                                                                                                                                                                                                                            TextView textView24 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_license_more_info);
                                                                                                                                                                                                                                                                                                                            if (textView24 != null) {
                                                                                                                                                                                                                                                                                                                                i12 = R.id.tv_no_data_more_info;
                                                                                                                                                                                                                                                                                                                                TextView textView25 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_no_data_more_info);
                                                                                                                                                                                                                                                                                                                                if (textView25 != null) {
                                                                                                                                                                                                                                                                                                                                    i12 = R.id.tv_others;
                                                                                                                                                                                                                                                                                                                                    TextView textView26 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_others);
                                                                                                                                                                                                                                                                                                                                    if (textView26 != null) {
                                                                                                                                                                                                                                                                                                                                        i12 = R.id.tv_packagename_label_more_info;
                                                                                                                                                                                                                                                                                                                                        TextView textView27 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_packagename_label_more_info);
                                                                                                                                                                                                                                                                                                                                        if (textView27 != null) {
                                                                                                                                                                                                                                                                                                                                            i12 = R.id.tv_packagename_more_info;
                                                                                                                                                                                                                                                                                                                                            TextView textView28 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_packagename_more_info);
                                                                                                                                                                                                                                                                                                                                            if (textView28 != null) {
                                                                                                                                                                                                                                                                                                                                                i12 = R.id.tv_pegi_label_more_info;
                                                                                                                                                                                                                                                                                                                                                TextView textView29 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_pegi_label_more_info);
                                                                                                                                                                                                                                                                                                                                                if (textView29 != null) {
                                                                                                                                                                                                                                                                                                                                                    i12 = R.id.tv_pegi_more_info;
                                                                                                                                                                                                                                                                                                                                                    TextView textView30 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_pegi_more_info);
                                                                                                                                                                                                                                                                                                                                                    if (textView30 != null) {
                                                                                                                                                                                                                                                                                                                                                        i12 = R.id.tv_permissions_label_more_info;
                                                                                                                                                                                                                                                                                                                                                        TextView textView31 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_permissions_label_more_info);
                                                                                                                                                                                                                                                                                                                                                        if (textView31 != null) {
                                                                                                                                                                                                                                                                                                                                                            i12 = R.id.tv_permissions_more_info;
                                                                                                                                                                                                                                                                                                                                                            TextView textView32 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_permissions_more_info);
                                                                                                                                                                                                                                                                                                                                                            if (textView32 != null) {
                                                                                                                                                                                                                                                                                                                                                                i12 = R.id.tv_published_warning_label_more_info;
                                                                                                                                                                                                                                                                                                                                                                TextView textView33 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_published_warning_label_more_info);
                                                                                                                                                                                                                                                                                                                                                                if (textView33 != null) {
                                                                                                                                                                                                                                                                                                                                                                    i12 = R.id.tv_published_warning_more_info;
                                                                                                                                                                                                                                                                                                                                                                    TextView textView34 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_published_warning_more_info);
                                                                                                                                                                                                                                                                                                                                                                    if (textView34 != null) {
                                                                                                                                                                                                                                                                                                                                                                        i12 = R.id.tv_req_label_more_info;
                                                                                                                                                                                                                                                                                                                                                                        TextView textView35 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_req_label_more_info);
                                                                                                                                                                                                                                                                                                                                                                        if (textView35 != null) {
                                                                                                                                                                                                                                                                                                                                                                            i12 = R.id.tv_req_more_info;
                                                                                                                                                                                                                                                                                                                                                                            TextView textView36 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_req_more_info);
                                                                                                                                                                                                                                                                                                                                                                            if (textView36 != null) {
                                                                                                                                                                                                                                                                                                                                                                                i12 = R.id.tv_security_title_more_info;
                                                                                                                                                                                                                                                                                                                                                                                TextView textView37 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_security_title_more_info);
                                                                                                                                                                                                                                                                                                                                                                                if (textView37 != null) {
                                                                                                                                                                                                                                                                                                                                                                                    i12 = R.id.tv_sha256_label_more_info;
                                                                                                                                                                                                                                                                                                                                                                                    TextView textView38 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_sha256_label_more_info);
                                                                                                                                                                                                                                                                                                                                                                                    if (textView38 != null) {
                                                                                                                                                                                                                                                                                                                                                                                        i12 = R.id.tv_sha256_more_info;
                                                                                                                                                                                                                                                                                                                                                                                        TextView textView39 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_sha256_more_info);
                                                                                                                                                                                                                                                                                                                                                                                        if (textView39 != null) {
                                                                                                                                                                                                                                                                                                                                                                                            i12 = R.id.tv_signature_label_more_info;
                                                                                                                                                                                                                                                                                                                                                                                            TextView textView40 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_signature_label_more_info);
                                                                                                                                                                                                                                                                                                                                                                                            if (textView40 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                i12 = R.id.tv_signature_more_info;
                                                                                                                                                                                                                                                                                                                                                                                                TextView textView41 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_signature_more_info);
                                                                                                                                                                                                                                                                                                                                                                                                if (textView41 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                    i12 = R.id.tv_size_label_more_info;
                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView42 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_size_label_more_info);
                                                                                                                                                                                                                                                                                                                                                                                                    if (textView42 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                        i12 = R.id.tv_size_more_info;
                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView43 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_size_more_info);
                                                                                                                                                                                                                                                                                                                                                                                                        if (textView43 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                            i12 = R.id.tv_technical_title_more_info;
                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView44 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_technical_title_more_info);
                                                                                                                                                                                                                                                                                                                                                                                                            if (textView44 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                i12 = R.id.tv_tv_virustotal_report_more_info;
                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView45 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_tv_virustotal_report_more_info);
                                                                                                                                                                                                                                                                                                                                                                                                                if (textView45 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                    i12 = R.id.tv_version_label_more_info;
                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView46 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_version_label_more_info);
                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView46 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                        i12 = R.id.tv_version_more_info;
                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView47 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_version_more_info);
                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView47 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                            i12 = R.id.v_req_more_info;
                                                                                                                                                                                                                                                                                                                                                                                                                            View viewFindChildViewById2 = ViewBindings.findChildViewById(viewInflate, R.id.v_req_more_info);
                                                                                                                                                                                                                                                                                                                                                                                                                            if (viewFindChildViewById2 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                return new d5.z(relativeLayout10, imageView, imageView2, imageView3, imageView4, linearLayout, linearLayout2, linearLayout3, linearLayout4, viewFindChildViewById, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, relativeLayout8, relativeLayout9, relativeLayout10, relativeLayout11, relativeLayout12, relativeLayout13, relativeLayout14, relativeLayout15, relativeLayout16, relativeLayout17, relativeLayout18, scrollView, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29, textView30, textView31, textView32, textView33, textView34, textView35, textView36, textView37, textView38, textView39, textView40, textView41, textView42, textView43, textView44, textView45, textView46, textView47, viewFindChildViewById2);
                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i12)));
                return null;
            case 1:
                int i13 = MyApps.f6655j0;
                View viewInflate2 = ((MyApps) obj).getLayoutInflater().inflate(R.layout.my_apps, (ViewGroup) null, false);
                int i14 = R.id.ll_order_my_apps;
                View viewFindChildViewById3 = ViewBindings.findChildViewById(viewInflate2, R.id.ll_order_my_apps);
                if (viewFindChildViewById3 != null) {
                    a3.x xVarP = a3.x.p(viewFindChildViewById3);
                    i14 = R.id.loading_view_my_apps;
                    View viewFindChildViewById4 = ViewBindings.findChildViewById(viewInflate2, R.id.loading_view_my_apps);
                    if (viewFindChildViewById4 != null) {
                        i14 = R.id.nsv_my_apps;
                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(viewInflate2, R.id.nsv_my_apps);
                        if (nestedScrollView != null) {
                            i14 = R.id.rv_my_apps;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate2, R.id.rv_my_apps);
                            if (recyclerView != null) {
                                i14 = R.id.search_view_my_apps;
                                SearchView searchView = (SearchView) ViewBindings.findChildViewById(viewInflate2, R.id.search_view_my_apps);
                                if (searchView != null) {
                                    i14 = R.id.toolbar_my_apps;
                                    Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(viewInflate2, R.id.toolbar_my_apps);
                                    if (toolbar2 != null) {
                                        i14 = R.id.tv_no_items_filtered_my_apps;
                                        TextView textView48 = (TextView) ViewBindings.findChildViewById(viewInflate2, R.id.tv_no_items_filtered_my_apps);
                                        if (textView48 != null) {
                                            i14 = R.id.tv_toolbar_title_my_apps;
                                            TextView textView49 = (TextView) ViewBindings.findChildViewById(viewInflate2, R.id.tv_toolbar_title_my_apps);
                                            if (textView49 != null) {
                                                return new d5.a0((RelativeLayout) viewInflate2, xVarP, viewFindChildViewById4, nestedScrollView, recyclerView, searchView, toolbar2, textView48, textView49);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i14)));
                return null;
            case 2:
                int i15 = MyStatsActivity.K;
                View viewInflate3 = ((MyStatsActivity) obj).getLayoutInflater().inflate(R.layout.my_stats_activity, (ViewGroup) null, false);
                int i16 = R.id.iv_user_avatar_my_stats;
                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(viewInflate3, R.id.iv_user_avatar_my_stats);
                if (imageView5 != null) {
                    i16 = R.id.ll_header_my_stats;
                    if (((LinearLayout) ViewBindings.findChildViewById(viewInflate3, R.id.ll_header_my_stats)) != null) {
                        i16 = R.id.ll_installation_box_my_stats;
                        if (((LinearLayout) ViewBindings.findChildViewById(viewInflate3, R.id.ll_installation_box_my_stats)) != null) {
                            i16 = R.id.loading_view_my_stats;
                            View viewFindChildViewById5 = ViewBindings.findChildViewById(viewInflate3, R.id.loading_view_my_stats);
                            if (viewFindChildViewById5 != null) {
                                i16 = R.id.nsv_my_stats;
                                NestedScrollView nestedScrollView2 = (NestedScrollView) ViewBindings.findChildViewById(viewInflate3, R.id.nsv_my_stats);
                                if (nestedScrollView2 != null) {
                                    i16 = R.id.toolbar_my_stats;
                                    Toolbar toolbar3 = (Toolbar) ViewBindings.findChildViewById(viewInflate3, R.id.toolbar_my_stats);
                                    if (toolbar3 != null) {
                                        i16 = R.id.tv_data_collected_label_my_stats;
                                        TextView textView50 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_data_collected_label_my_stats);
                                        if (textView50 != null) {
                                            i16 = R.id.tv_installations_label_my_stats;
                                            TextView textView51 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_installations_label_my_stats);
                                            if (textView51 != null) {
                                                i16 = R.id.tv_installations_value_my_stats;
                                                TextView textView52 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_installations_value_my_stats);
                                                if (textView52 != null) {
                                                    i16 = R.id.tv_likes_given_label_my_stats;
                                                    TextView textView53 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_likes_given_label_my_stats);
                                                    if (textView53 != null) {
                                                        i16 = R.id.tv_likes_given_value_my_stats;
                                                        TextView textView54 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_likes_given_value_my_stats);
                                                        if (textView54 != null) {
                                                            i16 = R.id.tv_likes_label_my_stats;
                                                            TextView textView55 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_likes_label_my_stats);
                                                            if (textView55 != null) {
                                                                i16 = R.id.tv_likes_value_my_stats;
                                                                TextView textView56 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_likes_value_my_stats);
                                                                if (textView56 != null) {
                                                                    i16 = R.id.tv_preregistrations_given_label_my_stats;
                                                                    TextView textView57 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_preregistrations_given_label_my_stats);
                                                                    if (textView57 != null) {
                                                                        i16 = R.id.tv_preregistrations_given_value_my_stats;
                                                                        TextView textView58 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_preregistrations_given_value_my_stats);
                                                                        if (textView58 != null) {
                                                                            i16 = R.id.tv_replies_given_label_my_stats;
                                                                            TextView textView59 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_replies_given_label_my_stats);
                                                                            if (textView59 != null) {
                                                                                i16 = R.id.tv_replies_given_value_my_stats;
                                                                                TextView textView60 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_replies_given_value_my_stats);
                                                                                if (textView60 != null) {
                                                                                    i16 = R.id.tv_replies_label_my_stats;
                                                                                    TextView textView61 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_replies_label_my_stats);
                                                                                    if (textView61 != null) {
                                                                                        i16 = R.id.tv_replies_value_my_stats;
                                                                                        TextView textView62 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_replies_value_my_stats);
                                                                                        if (textView62 != null) {
                                                                                            i16 = R.id.tv_reviews_label_my_stats;
                                                                                            TextView textView63 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_reviews_label_my_stats);
                                                                                            if (textView63 != null) {
                                                                                                i16 = R.id.tv_reviews_value_my_stats;
                                                                                                TextView textView64 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_reviews_value_my_stats);
                                                                                                if (textView64 != null) {
                                                                                                    i16 = R.id.tv_time_my_stats;
                                                                                                    TextView textView65 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_time_my_stats);
                                                                                                    if (textView65 != null) {
                                                                                                        i16 = R.id.tv_toolbar_my_stats;
                                                                                                        TextView textView66 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_toolbar_my_stats);
                                                                                                        if (textView66 != null) {
                                                                                                            i16 = R.id.tv_total_downloads_title_my_stats;
                                                                                                            TextView textView67 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_total_downloads_title_my_stats);
                                                                                                            if (textView67 != null) {
                                                                                                                i16 = R.id.tv_total_downloads_value_my_stats;
                                                                                                                TextView textView68 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_total_downloads_value_my_stats);
                                                                                                                if (textView68 != null) {
                                                                                                                    i16 = R.id.tv_updates_label_my_stats;
                                                                                                                    TextView textView69 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_updates_label_my_stats);
                                                                                                                    if (textView69 != null) {
                                                                                                                        i16 = R.id.tv_updates_value_my_stats;
                                                                                                                        TextView textView70 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_updates_value_my_stats);
                                                                                                                        if (textView70 != null) {
                                                                                                                            i16 = R.id.tv_usetime_my_stats;
                                                                                                                            TextView textView71 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_usetime_my_stats);
                                                                                                                            if (textView71 != null) {
                                                                                                                                i16 = R.id.v_bg_my_stats;
                                                                                                                                View viewFindChildViewById6 = ViewBindings.findChildViewById(viewInflate3, R.id.v_bg_my_stats);
                                                                                                                                if (viewFindChildViewById6 != null) {
                                                                                                                                    return new d5.c0((RelativeLayout) viewInflate3, imageView5, viewFindChildViewById5, nestedScrollView2, toolbar3, textView50, textView51, textView52, textView53, textView54, textView55, textView56, textView57, textView58, textView59, textView60, textView61, textView62, textView63, textView64, textView65, textView66, textView67, textView68, textView69, textView70, textView71, viewFindChildViewById6);
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate3.getResources().getResourceName(i16)));
                return null;
            case 3:
                int i17 = NotificationsRegistryActivity.M;
                View viewInflate4 = ((NotificationsRegistryActivity) obj).getLayoutInflater().inflate(R.layout.notifications_registry_activity, (ViewGroup) null, false);
                int i18 = R.id.loading_view_notification_registry;
                View viewFindChildViewById7 = ViewBindings.findChildViewById(viewInflate4, R.id.loading_view_notification_registry);
                if (viewFindChildViewById7 != null) {
                    i18 = R.id.rv_notifications_registry;
                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(viewInflate4, R.id.rv_notifications_registry);
                    if (recyclerView2 != null) {
                        i18 = R.id.toolbar_notifications_registry;
                        Toolbar toolbar4 = (Toolbar) ViewBindings.findChildViewById(viewInflate4, R.id.toolbar_notifications_registry);
                        if (toolbar4 != null) {
                            i18 = R.id.tv_no_data_notifications_registry;
                            TextView textView72 = (TextView) ViewBindings.findChildViewById(viewInflate4, R.id.tv_no_data_notifications_registry);
                            if (textView72 != null) {
                                i18 = R.id.tv_title_notifications_registry;
                                TextView textView73 = (TextView) ViewBindings.findChildViewById(viewInflate4, R.id.tv_title_notifications_registry);
                                if (textView73 != null) {
                                    return new d5.e0((RelativeLayout) viewInflate4, viewFindChildViewById7, recyclerView2, toolbar4, textView72, textView73);
                                }
                            }
                        }
                    }
                }
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate4.getResources().getResourceName(i18)));
                return null;
            case 4:
                int i19 = OldVersionsActivity.L;
                View viewInflate5 = ((OldVersionsActivity) obj).getLayoutInflater().inflate(R.layout.old_versions_activity, (ViewGroup) null, false);
                int i20 = R.id.loading_view_old_versions;
                View viewFindChildViewById8 = ViewBindings.findChildViewById(viewInflate5, R.id.loading_view_old_versions);
                if (viewFindChildViewById8 != null) {
                    i20 = R.id.rv_old_versions;
                    RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(viewInflate5, R.id.rv_old_versions);
                    if (recyclerView3 != null) {
                        i20 = R.id.toolbar_old_versions;
                        if (((Toolbar) ViewBindings.findChildViewById(viewInflate5, R.id.toolbar_old_versions)) != null) {
                            i20 = R.id.tv_no_data_old_version;
                            TextView textView74 = (TextView) ViewBindings.findChildViewById(viewInflate5, R.id.tv_no_data_old_version);
                            if (textView74 != null) {
                                i20 = R.id.tv_toolbar_old_versions;
                                if (((TextView) ViewBindings.findChildViewById(viewInflate5, R.id.tv_toolbar_old_versions)) != null) {
                                    return new d5.f0((RelativeLayout) viewInflate5, viewFindChildViewById8, recyclerView3, textView74);
                                }
                            }
                        }
                    }
                }
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate5.getResources().getResourceName(i20)));
                return null;
            case 5:
                int i21 = OrganizationActivity.K;
                View viewInflate6 = ((OrganizationActivity) obj).getLayoutInflater().inflate(R.layout.organization_activity, (ViewGroup) null, false);
                int i22 = R.id.iv_feature_organization;
                FullWidthImageView fullWidthImageView = (FullWidthImageView) ViewBindings.findChildViewById(viewInflate6, R.id.iv_feature_organization);
                if (fullWidthImageView != null) {
                    i22 = R.id.iv_instagram_organization;
                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(viewInflate6, R.id.iv_instagram_organization);
                    if (imageView6 != null) {
                        i22 = R.id.iv_logo_organization;
                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(viewInflate6, R.id.iv_logo_organization);
                        if (imageView7 != null) {
                            i22 = R.id.iv_tiktok_organization;
                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(viewInflate6, R.id.iv_tiktok_organization);
                            if (imageView8 != null) {
                                i22 = R.id.iv_twitter_organization;
                                ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(viewInflate6, R.id.iv_twitter_organization);
                                if (imageView9 != null) {
                                    i22 = R.id.loading_view_organization;
                                    View viewFindChildViewById9 = ViewBindings.findChildViewById(viewInflate6, R.id.loading_view_organization);
                                    if (viewFindChildViewById9 != null) {
                                        i22 = R.id.rl_description_organization;
                                        if (((RelativeLayout) ViewBindings.findChildViewById(viewInflate6, R.id.rl_description_organization)) != null) {
                                            i22 = R.id.rl_details_organization;
                                            RelativeLayout relativeLayout19 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate6, R.id.rl_details_organization);
                                            if (relativeLayout19 != null) {
                                                i22 = R.id.rv_organization;
                                                RecyclerView recyclerView4 = (RecyclerView) ViewBindings.findChildViewById(viewInflate6, R.id.rv_organization);
                                                if (recyclerView4 != null) {
                                                    i22 = R.id.sv_organization;
                                                    ScrollView scrollView2 = (ScrollView) ViewBindings.findChildViewById(viewInflate6, R.id.sv_organization);
                                                    if (scrollView2 != null) {
                                                        i22 = R.id.toolbar_organization;
                                                        Toolbar toolbar5 = (Toolbar) ViewBindings.findChildViewById(viewInflate6, R.id.toolbar_organization);
                                                        if (toolbar5 != null) {
                                                            i22 = R.id.tv_description_organization;
                                                            TextView textView75 = (TextView) ViewBindings.findChildViewById(viewInflate6, R.id.tv_description_organization);
                                                            if (textView75 != null) {
                                                                i22 = R.id.tv_name_organization;
                                                                TextView textView76 = (TextView) ViewBindings.findChildViewById(viewInflate6, R.id.tv_name_organization);
                                                                if (textView76 != null) {
                                                                    i22 = R.id.tv_read_more_organization;
                                                                    TextView textView77 = (TextView) ViewBindings.findChildViewById(viewInflate6, R.id.tv_read_more_organization);
                                                                    if (textView77 != null) {
                                                                        i22 = R.id.tv_toolbar_title_organization;
                                                                        TextView textView78 = (TextView) ViewBindings.findChildViewById(viewInflate6, R.id.tv_toolbar_title_organization);
                                                                        if (textView78 != null) {
                                                                            i22 = R.id.tv_web_organization;
                                                                            TextView textView79 = (TextView) ViewBindings.findChildViewById(viewInflate6, R.id.tv_web_organization);
                                                                            if (textView79 != null) {
                                                                                i22 = R.id.v_description_shadow_organization;
                                                                                View viewFindChildViewById10 = ViewBindings.findChildViewById(viewInflate6, R.id.v_description_shadow_organization);
                                                                                if (viewFindChildViewById10 != null) {
                                                                                    return new d5.g0((RelativeLayout) viewInflate6, fullWidthImageView, imageView6, imageView7, imageView8, imageView9, viewFindChildViewById9, relativeLayout19, recyclerView4, scrollView2, toolbar5, textView75, textView76, textView77, textView78, textView79, viewFindChildViewById10);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate6.getResources().getResourceName(i22)));
                return null;
            case 6:
                int i23 = PasswordEditActivity.J;
                View viewInflate7 = ((PasswordEditActivity) obj).getLayoutInflater().inflate(R.layout.password_edit, (ViewGroup) null, false);
                int i24 = R.id.et_confirm_password_edit;
                EditText editText = (EditText) ViewBindings.findChildViewById(viewInflate7, R.id.et_confirm_password_edit);
                if (editText != null) {
                    i24 = R.id.et_password_edit;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(viewInflate7, R.id.et_password_edit);
                    if (editText2 != null) {
                        i24 = R.id.iv_confirm_password_edit;
                        ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(viewInflate7, R.id.iv_confirm_password_edit);
                        if (imageView10 != null) {
                            i24 = R.id.iv_password_edit;
                            ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(viewInflate7, R.id.iv_password_edit);
                            if (imageView11 != null) {
                                i24 = R.id.loading_view_password_edit;
                                View viewFindChildViewById11 = ViewBindings.findChildViewById(viewInflate7, R.id.loading_view_password_edit);
                                if (viewFindChildViewById11 != null) {
                                    i24 = R.id.toolbar_password_edit;
                                    Toolbar toolbar6 = (Toolbar) ViewBindings.findChildViewById(viewInflate7, R.id.toolbar_password_edit);
                                    if (toolbar6 != null) {
                                        i24 = R.id.tv_equals_password_edit;
                                        TextView textView80 = (TextView) ViewBindings.findChildViewById(viewInflate7, R.id.tv_equals_password_edit);
                                        if (textView80 != null) {
                                            i24 = R.id.tv_max_chars_password_edit;
                                            TextView textView81 = (TextView) ViewBindings.findChildViewById(viewInflate7, R.id.tv_max_chars_password_edit);
                                            if (textView81 != null) {
                                                i24 = R.id.tv_min_chars_password_edit;
                                                TextView textView82 = (TextView) ViewBindings.findChildViewById(viewInflate7, R.id.tv_min_chars_password_edit);
                                                if (textView82 != null) {
                                                    i24 = R.id.tv_password_edit_change;
                                                    TextView textView83 = (TextView) ViewBindings.findChildViewById(viewInflate7, R.id.tv_password_edit_change);
                                                    if (textView83 != null) {
                                                        i24 = R.id.tv_title_toolbar_password_edit;
                                                        TextView textView84 = (TextView) ViewBindings.findChildViewById(viewInflate7, R.id.tv_title_toolbar_password_edit);
                                                        if (textView84 != null) {
                                                            return new d5.h0((RelativeLayout) viewInflate7, editText, editText2, imageView10, imageView11, viewFindChildViewById11, toolbar6, textView80, textView81, textView82, textView83, textView84);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate7.getResources().getResourceName(i24)));
                return null;
            case 7:
                int i25 = PasswordRecoveryActivity.I;
                View viewInflate8 = ((PasswordRecoveryActivity) obj).getLayoutInflater().inflate(R.layout.password_recovery, (ViewGroup) null, false);
                int i26 = R.id.et_email_confirm_pass_recovery;
                EditText editText3 = (EditText) ViewBindings.findChildViewById(viewInflate8, R.id.et_email_confirm_pass_recovery);
                if (editText3 != null) {
                    i26 = R.id.et_email_pass_recovery;
                    EditText editText4 = (EditText) ViewBindings.findChildViewById(viewInflate8, R.id.et_email_pass_recovery);
                    if (editText4 != null) {
                        i26 = R.id.loading_view_password_recovery;
                        View viewFindChildViewById12 = ViewBindings.findChildViewById(viewInflate8, R.id.loading_view_password_recovery);
                        if (viewFindChildViewById12 != null) {
                            i26 = R.id.toolbar_password_recovery;
                            if (((Toolbar) ViewBindings.findChildViewById(viewInflate8, R.id.toolbar_password_recovery)) != null) {
                                i26 = R.id.tv_recover;
                                TextView textView85 = (TextView) ViewBindings.findChildViewById(viewInflate8, R.id.tv_recover);
                                if (textView85 != null) {
                                    i26 = R.id.tv_title_toolbar_password_recovery;
                                    if (((TextView) ViewBindings.findChildViewById(viewInflate8, R.id.tv_title_toolbar_password_recovery)) != null) {
                                        return new d5.i0((RelativeLayout) viewInflate8, editText3, editText4, viewFindChildViewById12, textView85);
                                    }
                                }
                            }
                        }
                    }
                }
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate8.getResources().getResourceName(i26)));
                return null;
            case 8:
                int i27 = PublicListActivity.Y;
                View viewInflate9 = ((PublicListActivity) obj).getLayoutInflater().inflate(R.layout.public_list_activity, (ViewGroup) null, false);
                int i28 = R.id.loading_view_public_list;
                View viewFindChildViewById13 = ViewBindings.findChildViewById(viewInflate9, R.id.loading_view_public_list);
                if (viewFindChildViewById13 != null) {
                    i28 = R.id.rv_public_list;
                    RecyclerView recyclerView5 = (RecyclerView) ViewBindings.findChildViewById(viewInflate9, R.id.rv_public_list);
                    if (recyclerView5 != null) {
                        i28 = R.id.toolbar_public_list;
                        Toolbar toolbar7 = (Toolbar) ViewBindings.findChildViewById(viewInflate9, R.id.toolbar_public_list);
                        if (toolbar7 != null) {
                            i28 = R.id.tv_no_items_public_list;
                            TextView textView86 = (TextView) ViewBindings.findChildViewById(viewInflate9, R.id.tv_no_items_public_list);
                            if (textView86 != null) {
                                i28 = R.id.tv_title_public_list;
                                TextView textView87 = (TextView) ViewBindings.findChildViewById(viewInflate9, R.id.tv_title_public_list);
                                if (textView87 != null) {
                                    return new d5.m0((RelativeLayout) viewInflate9, viewFindChildViewById13, recyclerView5, toolbar7, textView86, textView87);
                                }
                            }
                        }
                    }
                }
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate9.getResources().getResourceName(i28)));
                return null;
            case 9:
                int i29 = PublicProfileActivity.K;
                View viewInflate10 = ((PublicProfileActivity) obj).getLayoutInflater().inflate(R.layout.public_profile_activity, (ViewGroup) null, false);
                int i30 = R.id.iv_bg_public_profile;
                ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(viewInflate10, R.id.iv_bg_public_profile);
                if (imageView12 != null) {
                    i30 = R.id.iv_icon_public_profile;
                    ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(viewInflate10, R.id.iv_icon_public_profile);
                    if (imageView13 != null) {
                        i30 = R.id.iv_turbo_mark_public_profile;
                        ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(viewInflate10, R.id.iv_turbo_mark_public_profile);
                        if (imageView14 != null) {
                            i30 = R.id.ll_actions_public_profile;
                            if (((LinearLayout) ViewBindings.findChildViewById(viewInflate10, R.id.ll_actions_public_profile)) != null) {
                                i30 = R.id.ll_followers_public_profile;
                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(viewInflate10, R.id.ll_followers_public_profile);
                                if (linearLayout5 != null) {
                                    i30 = R.id.ll_followings_public_profile;
                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(viewInflate10, R.id.ll_followings_public_profile);
                                    if (linearLayout6 != null) {
                                        i30 = R.id.ll_reviews_public_profile;
                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(viewInflate10, R.id.ll_reviews_public_profile);
                                        if (linearLayout7 != null) {
                                            i30 = R.id.ll_user_stats_public_profile;
                                            if (((RelativeLayout) ViewBindings.findChildViewById(viewInflate10, R.id.ll_user_stats_public_profile)) != null) {
                                                i30 = R.id.loading_view_public_profile;
                                                View viewFindChildViewById14 = ViewBindings.findChildViewById(viewInflate10, R.id.loading_view_public_profile);
                                                if (viewFindChildViewById14 != null) {
                                                    i30 = R.id.recommended_apps_public_profile;
                                                    View viewFindChildViewById15 = ViewBindings.findChildViewById(viewInflate10, R.id.recommended_apps_public_profile);
                                                    if (viewFindChildViewById15 != null) {
                                                        c2.d dVarD = c2.d.d(viewFindChildViewById15);
                                                        i30 = R.id.reviews_public_profile;
                                                        View viewFindChildViewById16 = ViewBindings.findChildViewById(viewInflate10, R.id.reviews_public_profile);
                                                        if (viewFindChildViewById16 != null) {
                                                            c2.d dVarD2 = c2.d.d(viewFindChildViewById16);
                                                            i30 = R.id.s_public_profile;
                                                            ScrollView scrollView3 = (ScrollView) ViewBindings.findChildViewById(viewInflate10, R.id.s_public_profile);
                                                            if (scrollView3 != null) {
                                                                i30 = R.id.toolbar_public_profile;
                                                                Toolbar toolbar8 = (Toolbar) ViewBindings.findChildViewById(viewInflate10, R.id.toolbar_public_profile);
                                                                if (toolbar8 != null) {
                                                                    i30 = R.id.tv_edit_public_profile;
                                                                    TextView textView88 = (TextView) ViewBindings.findChildViewById(viewInflate10, R.id.tv_edit_public_profile);
                                                                    if (textView88 != null) {
                                                                        i30 = R.id.tv_feed_public_profile;
                                                                        TextView textView89 = (TextView) ViewBindings.findChildViewById(viewInflate10, R.id.tv_feed_public_profile);
                                                                        if (textView89 != null) {
                                                                            i30 = R.id.tv_follow_public_profile;
                                                                            TextView textView90 = (TextView) ViewBindings.findChildViewById(viewInflate10, R.id.tv_follow_public_profile);
                                                                            if (textView90 != null) {
                                                                                i30 = R.id.tv_followers_label_public_profile;
                                                                                TextView textView91 = (TextView) ViewBindings.findChildViewById(viewInflate10, R.id.tv_followers_label_public_profile);
                                                                                if (textView91 != null) {
                                                                                    i30 = R.id.tv_followers_value_public_profile;
                                                                                    TextView textView92 = (TextView) ViewBindings.findChildViewById(viewInflate10, R.id.tv_followers_value_public_profile);
                                                                                    if (textView92 != null) {
                                                                                        i30 = R.id.tv_followings_label_public_profile;
                                                                                        TextView textView93 = (TextView) ViewBindings.findChildViewById(viewInflate10, R.id.tv_followings_label_public_profile);
                                                                                        if (textView93 != null) {
                                                                                            i30 = R.id.tv_followings_value_public_profile;
                                                                                            TextView textView94 = (TextView) ViewBindings.findChildViewById(viewInflate10, R.id.tv_followings_value_public_profile);
                                                                                            if (textView94 != null) {
                                                                                                i30 = R.id.tv_name_public_profile;
                                                                                                UsernameTextView usernameTextView = (UsernameTextView) ViewBindings.findChildViewById(viewInflate10, R.id.tv_name_public_profile);
                                                                                                if (usernameTextView != null) {
                                                                                                    i30 = R.id.tv_registered_public_profile;
                                                                                                    TextView textView95 = (TextView) ViewBindings.findChildViewById(viewInflate10, R.id.tv_registered_public_profile);
                                                                                                    if (textView95 != null) {
                                                                                                        i30 = R.id.tv_reviews_label_public_profile;
                                                                                                        TextView textView96 = (TextView) ViewBindings.findChildViewById(viewInflate10, R.id.tv_reviews_label_public_profile);
                                                                                                        if (textView96 != null) {
                                                                                                            i30 = R.id.tv_reviews_value_public_profile;
                                                                                                            TextView textView97 = (TextView) ViewBindings.findChildViewById(viewInflate10, R.id.tv_reviews_value_public_profile);
                                                                                                            if (textView97 != null) {
                                                                                                                i30 = R.id.wishlist_public_profile;
                                                                                                                View viewFindChildViewById17 = ViewBindings.findChildViewById(viewInflate10, R.id.wishlist_public_profile);
                                                                                                                if (viewFindChildViewById17 != null) {
                                                                                                                    return new d5.n0((RelativeLayout) viewInflate10, imageView12, imageView13, imageView14, linearLayout5, linearLayout6, linearLayout7, viewFindChildViewById14, dVarD, dVarD2, scrollView3, toolbar8, textView88, textView89, textView90, textView91, textView92, textView93, textView94, usernameTextView, textView95, textView96, textView97, c2.d.d(viewFindChildViewById17));
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate10.getResources().getResourceName(i30)));
                return null;
            case 10:
                int i31 = RepliesActivity.L;
                View viewInflate11 = ((RepliesActivity) obj).getLayoutInflater().inflate(R.layout.replies_activity, (ViewGroup) null, false);
                int i32 = R.id.et_reply;
                EditText editText5 = (EditText) ViewBindings.findChildViewById(viewInflate11, R.id.et_reply);
                if (editText5 != null) {
                    i32 = R.id.iv_icon_app_replies_activity;
                    ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(viewInflate11, R.id.iv_icon_app_replies_activity);
                    if (imageView15 != null) {
                        i32 = R.id.iv_send_reply;
                        ImageView imageView16 = (ImageView) ViewBindings.findChildViewById(viewInflate11, R.id.iv_send_reply);
                        if (imageView16 != null) {
                            i32 = R.id.iv_user_avatar_reply;
                            ImageView imageView17 = (ImageView) ViewBindings.findChildViewById(viewInflate11, R.id.iv_user_avatar_reply);
                            if (imageView17 != null) {
                                i32 = R.id.ll_about_replies_activity;
                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(viewInflate11, R.id.ll_about_replies_activity);
                                if (linearLayout8 != null) {
                                    i32 = R.id.ll_app_replies_activity;
                                    LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(viewInflate11, R.id.ll_app_replies_activity);
                                    if (linearLayout9 != null) {
                                        i32 = R.id.loading_view_replies;
                                        View viewFindChildViewById18 = ViewBindings.findChildViewById(viewInflate11, R.id.loading_view_replies);
                                        if (viewFindChildViewById18 != null) {
                                            i32 = R.id.login_wall;
                                            View viewFindChildViewById19 = ViewBindings.findChildViewById(viewInflate11, R.id.login_wall);
                                            if (viewFindChildViewById19 != null) {
                                                i32 = R.id.nsv_replies;
                                                NestedScrollView nestedScrollView3 = (NestedScrollView) ViewBindings.findChildViewById(viewInflate11, R.id.nsv_replies);
                                                if (nestedScrollView3 != null) {
                                                    i32 = R.id.review;
                                                    View viewFindChildViewById20 = ViewBindings.findChildViewById(viewInflate11, R.id.review);
                                                    if (viewFindChildViewById20 != null) {
                                                        d5.q0 q0VarA = d5.q0.a(viewFindChildViewById20);
                                                        i32 = R.id.review_turbo;
                                                        View viewFindChildViewById21 = ViewBindings.findChildViewById(viewInflate11, R.id.review_turbo);
                                                        if (viewFindChildViewById21 != null) {
                                                            d5.s0 s0VarA = d5.s0.a(viewFindChildViewById21);
                                                            i32 = R.id.rl_bottom_box_shadow;
                                                            if (((RelativeLayout) ViewBindings.findChildViewById(viewInflate11, R.id.rl_bottom_box_shadow)) != null) {
                                                                i32 = R.id.rl_box_user_reply;
                                                                if (((RelativeLayout) ViewBindings.findChildViewById(viewInflate11, R.id.rl_box_user_reply)) != null) {
                                                                    i32 = R.id.rl_user_reply;
                                                                    if (((RelativeLayout) ViewBindings.findChildViewById(viewInflate11, R.id.rl_user_reply)) != null) {
                                                                        i32 = R.id.rv_reply;
                                                                        RecyclerView recyclerView6 = (RecyclerView) ViewBindings.findChildViewById(viewInflate11, R.id.rv_reply);
                                                                        if (recyclerView6 != null) {
                                                                            i32 = R.id.shadow_description_app_detail;
                                                                            if (ViewBindings.findChildViewById(viewInflate11, R.id.shadow_description_app_detail) != null) {
                                                                                i32 = R.id.toolbar_reply;
                                                                                Toolbar toolbar9 = (Toolbar) ViewBindings.findChildViewById(viewInflate11, R.id.toolbar_reply);
                                                                                if (toolbar9 != null) {
                                                                                    i32 = R.id.tv_about_label_replies_activity;
                                                                                    TextView textView98 = (TextView) ViewBindings.findChildViewById(viewInflate11, R.id.tv_about_label_replies_activity);
                                                                                    if (textView98 != null) {
                                                                                        i32 = R.id.tv_app_name_replies_activity;
                                                                                        TextView textView99 = (TextView) ViewBindings.findChildViewById(viewInflate11, R.id.tv_app_name_replies_activity);
                                                                                        if (textView99 != null) {
                                                                                            i32 = R.id.tv_no_answer;
                                                                                            TextView textView100 = (TextView) ViewBindings.findChildViewById(viewInflate11, R.id.tv_no_answer);
                                                                                            if (textView100 != null) {
                                                                                                i32 = R.id.tv_title_reply;
                                                                                                TextView textView101 = (TextView) ViewBindings.findChildViewById(viewInflate11, R.id.tv_title_reply);
                                                                                                if (textView101 != null) {
                                                                                                    return new d5.p0((RelativeLayout) viewInflate11, editText5, imageView15, imageView16, imageView17, linearLayout8, linearLayout9, viewFindChildViewById18, viewFindChildViewById19, nestedScrollView3, q0VarA, s0VarA, recyclerView6, toolbar9, textView98, textView99, textView100, textView101);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate11.getResources().getResourceName(i32)));
                return null;
            case 11:
                return a();
            case 12:
                int i33 = RollbackActivity.Y;
                View viewInflate12 = ((RollbackActivity) obj).getLayoutInflater().inflate(R.layout.rollback_activity, (ViewGroup) null, false);
                int i34 = R.id.loading_view_rollback;
                View viewFindChildViewById22 = ViewBindings.findChildViewById(viewInflate12, R.id.loading_view_rollback);
                if (viewFindChildViewById22 != null) {
                    i34 = R.id.recyclerview;
                    RecyclerView recyclerView7 = (RecyclerView) ViewBindings.findChildViewById(viewInflate12, R.id.recyclerview);
                    if (recyclerView7 != null) {
                        i34 = R.id.toolbar_rollback;
                        Toolbar toolbar10 = (Toolbar) ViewBindings.findChildViewById(viewInflate12, R.id.toolbar_rollback);
                        if (toolbar10 != null) {
                            i34 = R.id.tv_gdpr_button_rollback;
                            TextView textView102 = (TextView) ViewBindings.findChildViewById(viewInflate12, R.id.tv_gdpr_button_rollback);
                            if (textView102 != null) {
                                i34 = R.id.tv_no_items;
                                TextView textView103 = (TextView) ViewBindings.findChildViewById(viewInflate12, R.id.tv_no_items);
                                if (textView103 != null) {
                                    i34 = R.id.tv_subtitle_rollback;
                                    TextView textView104 = (TextView) ViewBindings.findChildViewById(viewInflate12, R.id.tv_subtitle_rollback);
                                    if (textView104 != null) {
                                        i34 = R.id.tv_title_rollback;
                                        TextView textView105 = (TextView) ViewBindings.findChildViewById(viewInflate12, R.id.tv_title_rollback);
                                        if (textView105 != null) {
                                            return new d5.u0((RelativeLayout) viewInflate12, viewFindChildViewById22, recyclerView7, toolbar10, textView102, textView103, textView104, textView105);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate12.getResources().getResourceName(i34)));
                return null;
            case 13:
                int i35 = SearchActivity.Q;
                View viewInflate13 = ((SearchActivity) obj).getLayoutInflater().inflate(R.layout.search_activity, (ViewGroup) null, false);
                int i36 = R.id.include_search_bar;
                View viewFindChildViewById23 = ViewBindings.findChildViewById(viewInflate13, R.id.include_search_bar);
                if (viewFindChildViewById23 != null) {
                    int i37 = R.id.actv_search_bar;
                    InstantAutoCompleteTextView instantAutoCompleteTextView = (InstantAutoCompleteTextView) ViewBindings.findChildViewById(viewFindChildViewById23, R.id.actv_search_bar);
                    if (instantAutoCompleteTextView != null) {
                        i37 = R.id.iv_back_search_bar;
                        if (((ImageView) ViewBindings.findChildViewById(viewFindChildViewById23, R.id.iv_back_search_bar)) != null) {
                            i37 = R.id.iv_delete_search_bar;
                            ImageView imageView18 = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById23, R.id.iv_delete_search_bar);
                            if (imageView18 != null) {
                                i37 = R.id.iv_voice_search_bar;
                                ImageView imageView19 = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById23, R.id.iv_voice_search_bar);
                                if (imageView19 != null) {
                                    i37 = R.id.rl_options_search_bar;
                                    if (((RelativeLayout) ViewBindings.findChildViewById(viewFindChildViewById23, R.id.rl_options_search_bar)) != null) {
                                        w2.r rVar = new w2.r((RelativeLayout) viewFindChildViewById23, instantAutoCompleteTextView, imageView18, imageView19, 13);
                                        i36 = R.id.loading_view_search;
                                        View viewFindChildViewById24 = ViewBindings.findChildViewById(viewInflate13, R.id.loading_view_search);
                                        if (viewFindChildViewById24 != null) {
                                            i36 = R.id.rv_search_activity;
                                            RecyclerView recyclerView8 = (RecyclerView) ViewBindings.findChildViewById(viewInflate13, R.id.rv_search_activity);
                                            if (recyclerView8 != null) {
                                                i36 = R.id.tv_msg_search_activity;
                                                TextView textView106 = (TextView) ViewBindings.findChildViewById(viewInflate13, R.id.tv_msg_search_activity);
                                                if (textView106 != null) {
                                                    return new d5.v0((RelativeLayout) viewInflate13, rVar, viewFindChildViewById24, recyclerView8, textView106);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    androidx.window.layout.c.k("Missing required view with ID: ".concat(viewFindChildViewById23.getResources().getResourceName(i37)));
                    return null;
                }
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate13.getResources().getResourceName(i36)));
                return null;
            case 14:
                return b();
            case 15:
                return c();
            case 16:
                return d();
            case 17:
                return e();
            case 18:
                return f();
            case 19:
                return g();
            case 20:
                return h();
            case 21:
                return i();
            case 22:
                return j();
            case 23:
                return k();
            case 24:
                return l();
            case 25:
                return m();
            case 26:
                return n();
            case 27:
                return obj;
            case 28:
                return kotlin.jvm.internal.a0.d((Object[]) obj);
            default:
                ((ProgressBar) obj).setVisibility(8);
                return s6.w.f12711a;
        }
    }
}
