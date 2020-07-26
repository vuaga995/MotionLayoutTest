package com.example.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.databinding.LayoutGalleryViewBinding;
import com.example.myapplication.databinding.LayoutInputViewBinding;

public class LayoutGalleryView extends FrameLayout {
    public LayoutGalleryView(@NonNull Context context) {
        super(context);
        initView();
    }

    public LayoutGalleryView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LayoutGalleryView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private LayoutGalleryViewBinding binding;

    private void initView() {
        binding = LayoutGalleryViewBinding.inflate(LayoutInflater.from(getContext()));
        addView(binding.getRoot(), LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        bindAction();
    }

    private void bindAction() {

    }

    public boolean isGalleryShow(){
        return binding.layoutGallery.getVisibility() == View.VISIBLE;
    }

    public void showGallery(boolean show){
        binding.layoutGallery.setVisibility(show?View.VISIBLE: View.GONE);
    }

    public Listener listener;


    public interface  Listener{


    }
}
