package com.example.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.databinding.LayoutGalleryViewBinding;
import com.example.myapplication.databinding.LayoutStickerViewBinding;

public class LayoutStickerView extends FrameLayout {
    public LayoutStickerView(@NonNull Context context) {
        super(context);
        initView();
    }

    public LayoutStickerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LayoutStickerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private LayoutStickerViewBinding binding;

    private void initView(){
        binding = LayoutStickerViewBinding.inflate(LayoutInflater.from(getContext()));
        addView(binding.getRoot(), LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        bindAction();
    }

    private void bindAction() {

    }

    public boolean isStickerShow() {
        return binding.layoutSticker.getVisibility() == VISIBLE;
    }


}
