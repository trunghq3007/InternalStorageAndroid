package com.imic.admin.internalstorageandroid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * @author Hà Quang Trung
 * @version 1.0.0
 * @description
 * @desc Technical Director, FPT-Software.
 * @created 7/2/2018
 * @updated 7/2/2018
 * @modified by
 * @updated on 7/2/2018
 * @since 1.0
 */
public class SharedPreferenceActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText editText;
    CheckBox checkBox;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_shared);
        editText = findViewById(R.id.edt_TenDangNhap);
        checkBox = findViewById(R.id.checkbox);

        // tiến hành đọc
        sharedPreferences = getSharedPreferences("file_luu_tru_ten_dang_nhap", MODE_PRIVATE);
        String tenDangNhap = sharedPreferences.getString("KEY_TEN_DANG_NHAP", "");

        // xử lí cho checkbox

        boolean nho = sharedPreferences.getBoolean("CO_NHO_KHONG", false);
        if (!nho) {
            checkBox.setChecked(false);
        } else {
            checkBox.setChecked(true);
            editText.setText(tenDangNhap);
        }


    }

    public void dangnhap(View view) {
        sharedPreferences = getSharedPreferences("file_luu_tru_ten_dang_nhap", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (checkBox.isChecked()) {
            editor.putString("KEY_TEN_DANG_NHAP", editText.getText().toString().trim());
            editor.putBoolean("CO_NHO_KHONG", true);
            // sharedPreferences.edit();
            editor.commit();
        } else {
            editor.putBoolean("CO_NHO_KHONG", false);
            editor.commit();
        }


    }
}
