package com.stunningcoders.puredependencyinjection.screens.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import com.stunningcoders.puredependencyinjection.R;

public class ServerErrorDialogFragment extends DialogFragment {


    public static ServerErrorDialogFragment newInstance() {
        return new ServerErrorDialogFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

        alertDialogBuilder.setTitle(R.string.server_error_dialog_title);

        alertDialogBuilder.setMessage(R.string.server_error_dialog_message);

        alertDialogBuilder.setPositiveButton(
                R.string.server_error_dialog_button_caption,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                }
        );

        return alertDialogBuilder.create();

    }
}
