package com.hohoxc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.hohoxc.R;
import com.hohoxc.view.TextSliderView;

import java.util.HashMap;

import butterknife.Bind;

/**
 * Created by cloud_wang on 16/4/2.
 */
public class HomeFragment extends BaseFragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    @Bind(R.id.slider)
    SliderLayout bannerSlider;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getFragmentLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        //模拟请求的图片地址
        HashMap<String, String> url_maps = new HashMap<>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
        //循环载入数据
        for (String name : url_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this.getActivity());
            textSliderView.description(name).image(url_maps.get(name)).setScaleType(BaseSliderView.ScaleType.Fit).setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            //可以增加额外传值
            textSliderView.getBundle().putString("extra", name);
            bannerSlider.addSlider(textSliderView);
        }
        //banner属性设置
        bannerSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        bannerSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        bannerSlider.setCustomAnimation(new DescriptionAnimation());
        bannerSlider.setDuration(5000);
        bannerSlider.addOnPageChangeListener(this);
        bannerSlider.setPresetTransformer("CubeIn");
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        //处理点击事件
        Toast.makeText(this.getActivity(), slider.getBundle().get("extra") + "处理点击事件", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onStop() {
        bannerSlider.stopAutoCycle();
        super.onStop();
    }
}
