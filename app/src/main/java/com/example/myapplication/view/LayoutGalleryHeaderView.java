package com.example.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.databinding.LayoutGalleryHeaderViewBinding;
import com.example.myapplication.databinding.LayoutGalleryViewBinding;

public class LayoutGalleryHeaderView extends FrameLayout {
    public LayoutGalleryHeaderView(@NonNull Context context) {
        super(context);
        initView();
    }

    public LayoutGalleryHeaderView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LayoutGalleryHeaderView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    LayoutGalleryHeaderViewBinding binding;

    private void initView(){
        binding = LayoutGalleryHeaderViewBinding.inflate(LayoutInflater.from(getContext()));
        addView(binding.getRoot(), LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        bindAction();
    }

    private void bindAction() {
        binding.btnClose.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null) listener.onCloseGallery();
            }
        });
    }

    public Listener listener;

    public interface Listener{
        void onCloseGallery();
    }
}
