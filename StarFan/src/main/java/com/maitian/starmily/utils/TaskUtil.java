package com.maitian.starmily.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.maitian.starmily.application.AppApplication;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.MyIdolsVO;
import com.maitian.starmily.model.MyTaskBean;
import com.maitian.starmily.model.TaskShowBean;
import com.maitian.starmily.view.StarmilyToast;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;
import com.tamic.novate.callback.RxStringCallback;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.http.StartHttpUtils;

import java.util.HashMap;

public class TaskUtil {

    public void taskShow(final Context context, String taskId) {
        HashMap<String, Object> idolMap = new HashMap<>();
        idolMap.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        idolMap.put("taskId", taskId);
        final Gson gson = new Gson();
        new Novate.Builder(context)
                .baseUrl(BaseConstant.DOMAIN_NAME)
                .addCache(false)
                .build()
                .rxGet(Constant.GET_TASK_MSG, idolMap, new RxStringCallback() {
                    @Override
                    public void onError(Object tag, Throwable e) {
                        System.out.println();
                    }

                    @Override
                    public void onCancel(Object tag, Throwable e) {
                        System.out.println();
                    }

                    @Override
                    public void onNext(Object o, String s) {
                        TaskShowBean vo = gson.fromJson(s, TaskShowBean.class);
                        StarmilyToast.showTaskToast(context, vo.getObj().getTaskName(), "+" + vo.getObj().getExp() + "经验", "+" + vo.getObj().getMily() + "米粒");
                    }
                });
    }
}
