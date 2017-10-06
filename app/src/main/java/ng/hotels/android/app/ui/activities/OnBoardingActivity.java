package ng.hotels.android.app.ui.activities;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import ng.hotels.android.app.R;
import ng.hotels.android.app.adapters.OnBoardingPagerAdapter;
import ng.hotels.android.app.utils.PreferenceUtils;

/**
 * Created by idee on 9/29/17.
 */

public class OnBoardingActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    private static final String TAG = OnBoardingActivity.class.getSimpleName();
    ImageView[] indicators;
    @Inject
    OnBoardingPagerAdapter mSectionsPagerAdapter;
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @BindView(R.id.button_skip_on_boarding)
    Button mSkipBtn;
    @BindView(R.id.button_finish_on_boarding)
    Button mFinishBtn;
    @BindView(R.id.image_indicator_0)
    ImageView zero;
    @BindView(R.id.image_indicator_1)
    ImageView one;
    @BindView(R.id.image_indicator_2)
    ImageView two;
    @BindView(R.id.view_pager_on_boarding)
    ViewPager mViewPager;
    private int page = 0; //  to track page position
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_onboarding);
        ButterKnife.bind(this);

        indicators = new ImageView[]{zero, one, two};
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(page);
        updateIndicators(page);

        intent = new Intent(this, MainActivity.class);

        final int color1 = ContextCompat.getColor(this, R.color.white);
        final int color2 = ContextCompat.getColor(this, R.color.white);
        final int color3 = ContextCompat.getColor(this, R.color.white);

        final int[] colorList = new int[]{color1, color2, color3};

        final ArgbEvaluator evaluator = new ArgbEvaluator();

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int colorUpdate = (Integer) evaluator.evaluate(positionOffset, colorList[position], colorList[position == 2 ? position : position + 1]);
                mViewPager.setBackgroundColor(colorUpdate);
            }

            @Override
            public void onPageSelected(int position) {
                page = position;
                updateIndicators(page);
                mViewPager.setBackgroundColor(color1);
                mSkipBtn.setVisibility(position == 2 ? View.GONE : View.VISIBLE);
                mFinishBtn.setVisibility(position == 2 ? View.VISIBLE : View.GONE);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @OnClick({R.id.button_finish_on_boarding, R.id.button_skip_on_boarding})
    public void finishOnBoarding() {
        startActivity(intent);
        PreferenceUtils.storeUserFirstTime(this);
        finish();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    private void updateIndicators(int position) {
        for (int i = 0; i < indicators.length; i++) {
            indicators[i].setBackgroundResource(
                    i == position ? R.drawable.indicator_selected : R.drawable.indicator_unselected
            );
        }
    }

}