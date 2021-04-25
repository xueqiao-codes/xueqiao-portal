package com.longsheng.xueqiao.admin.module;

import com.google.gson.Gson;
import org.apache.thrift.TException;
import xueqiao.hosting.machine.SyncOperation;
import xueqiao.hosting.taskqueue.SyncInitHostingTask;
import xueqiao.hosting.taskqueue.SyncOperateCompanyUserTask;
import xueqiao.hosting.taskqueue.TSyncTaskQueue;
import xueqiao.hosting.taskqueue.TaskType;
import xueqiao.hosting.taskqueue.dao.client.HostingSyncTaskQueueDaoStub;

public class MHostingSyncTaskQueueHelper {
    private static MHostingSyncTaskQueueHelper mInstance;

//    private HostingMachineDaoStub mHostingMachineDaoStub;
    private HostingSyncTaskQueueDaoStub hostingSyncTaskQueueDaoStub;

    public static MHostingSyncTaskQueueHelper getInstance() {
        if (mInstance == null) {
            mInstance = new MHostingSyncTaskQueueHelper();
        }
        return mInstance;
    }

    private MHostingSyncTaskQueueHelper(){
        hostingSyncTaskQueueDaoStub = new HostingSyncTaskQueueDaoStub();
    }

    /**
     *  提交初始化托管机任务到任务队列
     * */
    public void submitInitHostingTask(SyncInitHostingTask task) throws TException {

        TSyncTaskQueue taskQueue = new TSyncTaskQueue();
        // 设置任务类型为 初始化托管机
        taskQueue.setTaskType(TaskType.INIT_HOSTING.getValue());
        task.setTaskType(TaskType.INIT_HOSTING);
        // 系列化任务信息
        taskQueue.setQueueMessage(new Gson().toJson(task));
        hostingSyncTaskQueueDaoStub.addSyncTaskQueue(taskQueue);
    }

    /**
     *  提交公司成员操作任务到任务队列
     * */
    public void submitAddGroupUserTask(SyncOperateCompanyUserTask task) throws TException {

        TSyncTaskQueue taskQueue = new TSyncTaskQueue();

        // 设置任务类型为 公司用户操作
        taskQueue.setTaskType(TaskType.OPERATE_COMPANY_USER.getValue());
        task.setTaskType(TaskType.OPERATE_COMPANY_USER);

        // 设置用户操作类型
        task.setSyncPeration(SyncOperation.REGISTER_USER.name());

        // 系列化任务信息
        taskQueue.setQueueMessage(new Gson().toJson(task));
        hostingSyncTaskQueueDaoStub.addSyncTaskQueue(taskQueue);
    }

}
