package com.example.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.databinding.LayoutInputViewBinding;

public class LayoutInputView extends FrameLayout {
    public LayoutInputView(@NonNull Context context) {
        super(context);
        initView();
    }

    public LayoutInputView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LayoutInputView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private LayoutInputViewBinding binding;

    private void initView() {
        binding = LayoutInputViewBinding.inflate(LayoutInflater.from(getContext()));
        addView(binding.getRoot(), LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        bindAction();
    }

    private void bindAction() {
        binding.btnGallery.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null)listener.onClickGallery();
            }
        });

        binding.btnSticker.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null)listener.onClickSticker();
            }
        });

        binding.inputView.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (listener!=null) listener.onFocusInput(hasFocus);
            }
        });

        binding.btnGif.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null)listener.onClickGif();
            }
        });
    }

    public Listener listener;

    public interface  Listener{

        void onClickSticker();
        void onClickGallery();
        void onClickGif();

        void onFocusInput(boolean focus);

    }
}
