package com.gandroid.customalertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.gandroid.customalertdialog.databinding.ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btnCallAlertDialog.setOnClickListener(view ->
                callAlertDialog()
        );
        binding.btnCustomDialog.setOnClickListener(view -> callCustomDialog2());
    }

    private void callCustomDialog2() {
        View view = getLayoutInflater().inflate(R.layout.custom_alert_dialog, null);
        Button btn_ok = view.findViewById(R.id.btn_ok);
        Button btn_cancel = view.findViewById(R.id.btn_cancel);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Custom Alert Dialog");
        builder.setView(view);
        AlertDialog dialog = builder.create();

        btn_cancel.setOnClickListener(view1 -> {
            dialog.dismiss();
            Toast.makeText(this, "Alert dialog cancelled", Toast.LENGTH_SHORT).show();
        });
        btn_ok.setOnClickListener(view1 -> {
            dialog.dismiss();
            Toast.makeText(this, "OK Called", Toast.LENGTH_SHORT).show();
        });
        dialog.show();
    }

    private void callAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Regular Alert Dialog");
        builder.setMessage("Called Regular alert dialog");
        builder.setCancelable(false);
        builder.setPositiveButton("Cancel", (dialogInterface, i) -> dialogInterface.dismiss());

        builder.setNegativeButton("OK", (dialogInterface, i) -> {
            dialogInterface.dismiss();
            Toast.makeText(MainActivity.this, "OK called", Toast.LENGTH_SHORT).show();
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}