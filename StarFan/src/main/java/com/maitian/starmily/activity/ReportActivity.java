package com.maitian.starmily.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.maitian.starmily.R;
import com.rey.material.widget.CheckBox;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;

public class ReportActivity extends BaseActivity {
    private CheckBox mCheckBox1, mCheckBox2, mCheckBox3, mCheckBox4, mCheckBox5, mCheckBox6, mCheckBox7;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.report_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("举报");

    }

    @Override
    public void bindViewsListener() {

    }

    @Override
    public void getData() {
        showView();
    }

    @Override
    public void hasData(BaseVO vo) {

    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    public void commit() {
        if (mCheckBox1.isChecked()) {

        }
        if (mCheckBox2.isChecked()) {

        }
        if (mCheckBox3.isChecked()) {

        }
        if (mCheckBox4.isChecked()) {

        }
        if (mCheckBox5.isChecked()) {

        }
        if (mCheckBox6.isChecked()) {

        }
        if (mCheckBox7.isChecked()) {

        }
    }
}
