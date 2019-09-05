package com.example.spring.study.task.trigger;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;

import java.util.Date;

/**
 * Created by jianglei on 2019/9/4.
 */
public class CustomTrigger implements Trigger {

    @Override
    public Date nextExecutionTime(TriggerContext triggerContext) {
        Date date = triggerContext.lastCompletionTime();
        // 这里面有个处理：如果data为null，相当于任务已经完成了
        if (date != null) {
            // 拿到上一次预定执行的时间
            Date scheduled = triggerContext.lastScheduledExecutionTime();
            // 如果预定执行的时间为null（比如第一次）或者上一次还在data之后，那就取当前时间嘛
            if (scheduled != null && date.before(scheduled)) {
                // Previous task apparently executed too early...
                // Let's simply use the last calculated execution time then,
                // in order to prevent accidental re-fires in the same second.
                date = scheduled;
            }
        }
        // 如果任务还没有完成，那就以当前时间去计算下一个时间
        else {
            date = new Date();
        }
        return date;
    }
}
