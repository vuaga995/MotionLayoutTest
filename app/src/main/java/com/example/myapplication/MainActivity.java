package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.inputmethod.InputMethodManager;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.view.LayoutGalleryHeaderView;
import com.example.myapplication.view.LayoutInputView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.layoutKeybroad.getLayoutParams().height = 874;
        bindView();
    }

    private void bindView() {
        binding.layoutInput.listener = new LayoutInputView.Listener() {
            @Override
            public void onClickSticker() {
                if (binding.layoutSticker.getVisibility() ==View.VISIBLE) {
                    onShowSticker(false);
                    showlayoutKeyBroad(false);
                } else {
                    binding.layoutGalleryCroller.setVisibility(View.GONE);
                    onShowSticker(true);
                    showlayoutKeyBroad(true);
                }
                enableTransitionGallery(false);
                onShowGallery(false);
                hideKeybroad();
            }

            @Override
            public void onClickGallery() {
                if (binding.layoutGallery.isGalleryShow()) {
                    onShowGallery(false);
                    showlayoutKeyBroad(false);
                    enableTransitionGallery(false);
                } else {
                    binding.layoutGalleryCroller.setVisibility(View.VISIBLE);
                    onShowGallery(true);
                    showlayoutKeyBroad(true);
                    enableTransitionGallery(true);
                }
                onShowSticker(false);
                hideKeybroad();
            }

            @Override
            public void onClickGif() {
                binding.layoutGalleryCroller.setVisibility(View.GONE);
                onShowSticker(false);
                onShowGallery(false);
                showlayoutKeyBroad(true);
                hideKeybroad();
                binding.layoutGalleryCroller.setVisibility(View.GONE);
                enableTransitionGallery(false);
                binding.layoutGalleryCroller.setVisibility(View.GONE);
            }

            @Override
            public void onFocusInput(boolean focus) {
                if (focus){
                    showlayoutKeyBroad(true);
                    onShowSticker(false);
                    onShowGallery(false);
                    enableTransitionGallery(false);
                }else {

                }
            }
        };

        binding.layoutGalleryHeader.listener = new LayoutGalleryHeaderView.Listener() {
            @Override
            public void onCloseGallery() {
                enableTransitionGallery(true);
                binding.layoutMotion.transitionToStart();
            }
        };

        binding.layoutMotion.addTransitionListener(new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int i, int i1) {
            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int i, int i1, float v) {
            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int i) {
                if (i == R.id.start) {
                    enableTransitionGallery(true);
                }
                if (i == R.id.end) {
                    enableTransitionGallery(false);
                }
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean b, float v) {
            }
        });
    }

    private void onShowSticker(boolean show) {
        binding.layoutSticker.setVisibility(show?View.VISIBLE:View.GONE);
    }

    private void onShowGallery(boolean show) {
        binding.layoutGallery.showGallery(show);
    }

    private void enableTransitionGallery(boolean enable) {
        binding.layoutMotion.enableTransition(R.id.transition_gallery_expanable, enable);
    }

    private void showlayoutKeyBroad(boolean show) {
        binding.layoutKeybroad.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    private void hideKeybroad() {
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = this.getCurrentFocus();
        if (view == null) {
            view = new View(this);
        }
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}