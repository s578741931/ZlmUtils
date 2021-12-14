package com.noahcrt.zlmutils.modules;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskService {
    private static volatile TaskService sTaskService;
    private final ExecutorService mExecutorService;
    private final Handler mHandler;

    private TaskService() {
        mExecutorService = Executors.newCachedThreadPool();
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static TaskService getInstance() {
        if (sTaskService == null) {
            synchronized (TaskService.class) {
                if (sTaskService == null) {
                    sTaskService = new TaskService();
                }
            }
        }
        return sTaskService;
    }

    public void doBackTask(Runnable runnable) {
        if (runnable != null) {
            mExecutorService.submit(runnable);
        }
    }

    public void doBackTaskDelay(final Runnable runnable, long delay) {
        if (runnable != null) {
            if (delay < 0) {
                delay = 0;
            }
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mExecutorService.submit(runnable);
                }
            }, delay);
        }
    }

    public void postTaskInMain(Runnable runnable) {
        if (runnable != null) {
            mHandler.post(runnable);
        }
    }
    public void postTaskInMainDelay(Runnable runnable , long delaytime) {
        if (runnable != null) {
            mHandler.postDelayed(runnable,delaytime);
        }
    }

    public Handler getHandler() {
        return mHandler;
    }
}
