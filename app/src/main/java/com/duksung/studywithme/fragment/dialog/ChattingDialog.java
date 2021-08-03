package com.duksung.studywithme.fragment.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.duksung.studywithme.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ChattingDialog extends BottomSheetDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        BottomSheetDialog bottomSheet = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);


        View view = View.inflate(getContext(), R.layout.dialog_chatting, null);

        bottomSheet.setContentView(view);

        return bottomSheet;

    }
}
