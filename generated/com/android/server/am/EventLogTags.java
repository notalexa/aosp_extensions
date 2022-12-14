/* This file is auto-generated.  DO NOT MODIFY.
 * Source file: frameworks/base/services/core/java/com/android/server/am/EventLogTags.logtags
 */

package com.android.server.am;

/**
 * @hide
 */
public class EventLogTags {
  private EventLogTags() { }  // don't instantiate

  /** 2719 configuration_changed (config mask|1|5) */
  public static final int CONFIGURATION_CHANGED = 2719;

  /** 2721 cpu (total|1|6),(user|1|6),(system|1|6),(iowait|1|6),(irq|1|6),(softirq|1|6) */
  public static final int CPU = 2721;

  /** 3040 boot_progress_ams_ready (time|2|3) */
  public static final int BOOT_PROGRESS_AMS_READY = 3040;

  /** 3050 boot_progress_enable_screen (time|2|3) */
  public static final int BOOT_PROGRESS_ENABLE_SCREEN = 3050;

  /** 30001 am_finish_activity (User|1|5),(Token|1|5),(Task ID|1|5),(Component Name|3),(Reason|3) */
  public static final int AM_FINISH_ACTIVITY = 30001;

  /** 30002 am_task_to_front (User|1|5),(Task|1|5) */
  public static final int AM_TASK_TO_FRONT = 30002;

  /** 30003 am_new_intent (User|1|5),(Token|1|5),(Task ID|1|5),(Component Name|3),(Action|3),(MIME Type|3),(URI|3),(Flags|1|5) */
  public static final int AM_NEW_INTENT = 30003;

  /** 30004 am_create_task (User|1|5),(Task ID|1|5) */
  public static final int AM_CREATE_TASK = 30004;

  /** 30005 am_create_activity (User|1|5),(Token|1|5),(Task ID|1|5),(Component Name|3),(Action|3),(MIME Type|3),(URI|3),(Flags|1|5) */
  public static final int AM_CREATE_ACTIVITY = 30005;

  /** 30006 am_restart_activity (User|1|5),(Token|1|5),(Task ID|1|5),(Component Name|3) */
  public static final int AM_RESTART_ACTIVITY = 30006;

  /** 30007 am_resume_activity (User|1|5),(Token|1|5),(Task ID|1|5),(Component Name|3) */
  public static final int AM_RESUME_ACTIVITY = 30007;

  /** 30008 am_anr (User|1|5),(pid|1|5),(Package Name|3),(Flags|1|5),(reason|3) */
  public static final int AM_ANR = 30008;

  /** 30009 am_activity_launch_time (User|1|5),(Token|1|5),(Component Name|3),(time|2|3) */
  public static final int AM_ACTIVITY_LAUNCH_TIME = 30009;

  /** 30010 am_proc_bound (User|1|5),(PID|1|5),(Process Name|3) */
  public static final int AM_PROC_BOUND = 30010;

  /** 30011 am_proc_died (User|1|5),(PID|1|5),(Process Name|3),(OomAdj|1|5),(ProcState|1|5) */
  public static final int AM_PROC_DIED = 30011;

  /** 30012 am_failed_to_pause (User|1|5),(Token|1|5),(Wanting to pause|3),(Currently pausing|3) */
  public static final int AM_FAILED_TO_PAUSE = 30012;

  /** 30013 am_pause_activity (User|1|5),(Token|1|5),(Component Name|3),(User Leaving|3) */
  public static final int AM_PAUSE_ACTIVITY = 30013;

  /** 30014 am_proc_start (User|1|5),(PID|1|5),(UID|1|5),(Process Name|3),(Type|3),(Component|3) */
  public static final int AM_PROC_START = 30014;

  /** 30015 am_proc_bad (User|1|5),(UID|1|5),(Process Name|3) */
  public static final int AM_PROC_BAD = 30015;

  /** 30016 am_proc_good (User|1|5),(UID|1|5),(Process Name|3) */
  public static final int AM_PROC_GOOD = 30016;

  /** 30017 am_low_memory (Num Processes|1|1) */
  public static final int AM_LOW_MEMORY = 30017;

  /** 30018 am_destroy_activity (User|1|5),(Token|1|5),(Task ID|1|5),(Component Name|3),(Reason|3) */
  public static final int AM_DESTROY_ACTIVITY = 30018;

  /** 30019 am_relaunch_resume_activity (User|1|5),(Token|1|5),(Task ID|1|5),(Component Name|3) */
  public static final int AM_RELAUNCH_RESUME_ACTIVITY = 30019;

  /** 30020 am_relaunch_activity (User|1|5),(Token|1|5),(Task ID|1|5),(Component Name|3) */
  public static final int AM_RELAUNCH_ACTIVITY = 30020;

  /** 30021 am_on_paused_called (User|1|5),(Component Name|3),(Reason|3) */
  public static final int AM_ON_PAUSED_CALLED = 30021;

  /** 30022 am_on_resume_called (User|1|5),(Component Name|3),(Reason|3) */
  public static final int AM_ON_RESUME_CALLED = 30022;

  /** 30023 am_kill (User|1|5),(PID|1|5),(Process Name|3),(OomAdj|1|5),(Reason|3) */
  public static final int AM_KILL = 30023;

  /** 30024 am_broadcast_discard_filter (User|1|5),(Broadcast|1|5),(Action|3),(Receiver Number|1|1),(BroadcastFilter|1|5) */
  public static final int AM_BROADCAST_DISCARD_FILTER = 30024;

  /** 30025 am_broadcast_discard_app (User|1|5),(Broadcast|1|5),(Action|3),(Receiver Number|1|1),(App|3) */
  public static final int AM_BROADCAST_DISCARD_APP = 30025;

  /** 30030 am_create_service (User|1|5),(Service Record|1|5),(Name|3),(UID|1|5),(PID|1|5) */
  public static final int AM_CREATE_SERVICE = 30030;

  /** 30031 am_destroy_service (User|1|5),(Service Record|1|5),(PID|1|5) */
  public static final int AM_DESTROY_SERVICE = 30031;

  /** 30032 am_process_crashed_too_much (User|1|5),(Name|3),(PID|1|5) */
  public static final int AM_PROCESS_CRASHED_TOO_MUCH = 30032;

  /** 30033 am_drop_process (PID|1|5) */
  public static final int AM_DROP_PROCESS = 30033;

  /** 30034 am_service_crashed_too_much (User|1|5),(Crash Count|1|1),(Component Name|3),(PID|1|5) */
  public static final int AM_SERVICE_CRASHED_TOO_MUCH = 30034;

  /** 30035 am_schedule_service_restart (User|1|5),(Component Name|3),(Time|2|3) */
  public static final int AM_SCHEDULE_SERVICE_RESTART = 30035;

  /** 30036 am_provider_lost_process (User|1|5),(Package Name|3),(UID|1|5),(Name|3) */
  public static final int AM_PROVIDER_LOST_PROCESS = 30036;

  /** 30037 am_process_start_timeout (User|1|5),(PID|1|5),(UID|1|5),(Process Name|3) */
  public static final int AM_PROCESS_START_TIMEOUT = 30037;

  /** 30039 am_crash (User|1|5),(PID|1|5),(Process Name|3),(Flags|1|5),(Exception|3),(Message|3),(File|3),(Line|1|5) */
  public static final int AM_CRASH = 30039;

  /** 30040 am_wtf (User|1|5),(PID|1|5),(Process Name|3),(Flags|1|5),(Tag|3),(Message|3) */
  public static final int AM_WTF = 30040;

  /** 30041 am_switch_user (id|1|5) */
  public static final int AM_SWITCH_USER = 30041;

  /** 30043 am_set_resumed_activity (User|1|5),(Component Name|3),(Reason|3) */
  public static final int AM_SET_RESUMED_ACTIVITY = 30043;

  /** 30044 am_focused_stack (User|1|5),(Display Id|1|5),(Focused Stack Id|1|5),(Last Focused Stack Id|1|5),(Reason|3) */
  public static final int AM_FOCUSED_STACK = 30044;

  /** 30045 am_pre_boot (User|1|5),(Package|3) */
  public static final int AM_PRE_BOOT = 30045;

  /** 30046 am_meminfo (Cached|2|2),(Free|2|2),(Zram|2|2),(Kernel|2|2),(Native|2|2) */
  public static final int AM_MEMINFO = 30046;

  /** 30047 am_pss (Pid|1|5),(UID|1|5),(Process Name|3),(Pss|2|2),(Uss|2|2),(SwapPss|2|2),(Rss|2|2),(StatType|1|5),(ProcState|1|5),(TimeToCollect|2|2) */
  public static final int AM_PSS = 30047;

  /** 30048 am_stop_activity (User|1|5),(Token|1|5),(Component Name|3) */
  public static final int AM_STOP_ACTIVITY = 30048;

  /** 30049 am_on_stop_called (User|1|5),(Component Name|3),(Reason|3) */
  public static final int AM_ON_STOP_CALLED = 30049;

  /** 30050 am_mem_factor (Current|1|5),(Previous|1|5) */
  public static final int AM_MEM_FACTOR = 30050;

  /** 30051 am_user_state_changed (id|1|5),(state|1|5) */
  public static final int AM_USER_STATE_CHANGED = 30051;

  /** 30052 am_uid_running (UID|1|5) */
  public static final int AM_UID_RUNNING = 30052;

  /** 30053 am_uid_stopped (UID|1|5) */
  public static final int AM_UID_STOPPED = 30053;

  /** 30054 am_uid_active (UID|1|5) */
  public static final int AM_UID_ACTIVE = 30054;

  /** 30055 am_uid_idle (UID|1|5) */
  public static final int AM_UID_IDLE = 30055;

  /** 30056 am_stop_idle_service (UID|1|5),(Component Name|3) */
  public static final int AM_STOP_IDLE_SERVICE = 30056;

  /** 30057 am_on_create_called (User|1|5),(Component Name|3),(Reason|3) */
  public static final int AM_ON_CREATE_CALLED = 30057;

  /** 30058 am_on_restart_called (User|1|5),(Component Name|3),(Reason|3) */
  public static final int AM_ON_RESTART_CALLED = 30058;

  /** 30059 am_on_start_called (User|1|5),(Component Name|3),(Reason|3) */
  public static final int AM_ON_START_CALLED = 30059;

  /** 30060 am_on_destroy_called (User|1|5),(Component Name|3),(Reason|3) */
  public static final int AM_ON_DESTROY_CALLED = 30060;

  /** 30062 am_on_activity_result_called (User|1|5),(Component Name|3),(Reason|3) */
  public static final int AM_ON_ACTIVITY_RESULT_CALLED = 30062;

  /** 30061 am_remove_task (Task ID|1|5), (Stack ID|1|5) */
  public static final int AM_REMOVE_TASK = 30061;

  /** 30063 am_compact (Pid|1|5),(Process Name|3),(Action|3),(BeforeRssTotal|2|2),(BeforeRssFile|2|2),(BeforeRssAnon|2|2),(BeforeRssSwap|2|2),(DeltaRssTotal|2|2),(DeltaRssFile|2|2),(DeltaRssAnon|2|2),(DeltaRssSwap|2|2),(Time|2|3),(LastAction|1|2),(LastActionTimestamp|2|3),(setAdj|1|2),(procState|1|2),(BeforeZRAMFree|2|2),(DeltaZRAMFree|2|2) */
  public static final int AM_COMPACT = 30063;

  /** 30064 am_on_top_resumed_gained_called (User|1|5),(Component Name|3),(Reason|3) */
  public static final int AM_ON_TOP_RESUMED_GAINED_CALLED = 30064;

  /** 30065 am_on_top_resumed_lost_called (User|1|5),(Component Name|3),(Reason|3) */
  public static final int AM_ON_TOP_RESUMED_LOST_CALLED = 30065;

  /** 30066 am_add_to_stopping (User|1|5),(Token|1|5),(Component Name|3),(Reason|3) */
  public static final int AM_ADD_TO_STOPPING = 30066;

  public static void writeConfigurationChanged(int configMask) {
    android.util.EventLog.writeEvent(CONFIGURATION_CHANGED, configMask);
  }

  public static void writeCpu(int total, int user, int system, int iowait, int irq, int softirq) {
    android.util.EventLog.writeEvent(CPU, total, user, system, iowait, irq, softirq);
  }

  public static void writeBootProgressAmsReady(long time) {
    android.util.EventLog.writeEvent(BOOT_PROGRESS_AMS_READY, time);
  }

  public static void writeBootProgressEnableScreen(long time) {
    android.util.EventLog.writeEvent(BOOT_PROGRESS_ENABLE_SCREEN, time);
  }

  public static void writeAmFinishActivity(int user, int token, int taskId, String componentName, String reason) {
    android.util.EventLog.writeEvent(AM_FINISH_ACTIVITY, user, token, taskId, componentName, reason);
  }

  public static void writeAmTaskToFront(int user, int task) {
    android.util.EventLog.writeEvent(AM_TASK_TO_FRONT, user, task);
  }

  public static void writeAmNewIntent(int user, int token, int taskId, String componentName, String action, String mimeType, String uri, int flags) {
    android.util.EventLog.writeEvent(AM_NEW_INTENT, user, token, taskId, componentName, action, mimeType, uri, flags);
  }

  public static void writeAmCreateTask(int user, int taskId) {
    android.util.EventLog.writeEvent(AM_CREATE_TASK, user, taskId);
  }

  public static void writeAmCreateActivity(int user, int token, int taskId, String componentName, String action, String mimeType, String uri, int flags) {
    android.util.EventLog.writeEvent(AM_CREATE_ACTIVITY, user, token, taskId, componentName, action, mimeType, uri, flags);
  }

  public static void writeAmRestartActivity(int user, int token, int taskId, String componentName) {
    android.util.EventLog.writeEvent(AM_RESTART_ACTIVITY, user, token, taskId, componentName);
  }

  public static void writeAmResumeActivity(int user, int token, int taskId, String componentName) {
    android.util.EventLog.writeEvent(AM_RESUME_ACTIVITY, user, token, taskId, componentName);
  }

  public static void writeAmAnr(int user, int pid, String packageName, int flags, String reason) {
    android.util.EventLog.writeEvent(AM_ANR, user, pid, packageName, flags, reason);
  }

  public static void writeAmActivityLaunchTime(int user, int token, String componentName, long time) {
    android.util.EventLog.writeEvent(AM_ACTIVITY_LAUNCH_TIME, user, token, componentName, time);
  }

  public static void writeAmProcBound(int user, int pid, String processName) {
    android.util.EventLog.writeEvent(AM_PROC_BOUND, user, pid, processName);
  }

  public static void writeAmProcDied(int user, int pid, String processName, int oomadj, int procstate) {
    android.util.EventLog.writeEvent(AM_PROC_DIED, user, pid, processName, oomadj, procstate);
  }

  public static void writeAmFailedToPause(int user, int token, String wantingToPause, String currentlyPausing) {
    android.util.EventLog.writeEvent(AM_FAILED_TO_PAUSE, user, token, wantingToPause, currentlyPausing);
  }

  public static void writeAmPauseActivity(int user, int token, String componentName, String userLeaving) {
    android.util.EventLog.writeEvent(AM_PAUSE_ACTIVITY, user, token, componentName, userLeaving);
  }

  public static void writeAmProcStart(int user, int pid, int uid, String processName, String type, String component) {
    android.util.EventLog.writeEvent(AM_PROC_START, user, pid, uid, processName, type, component);
  }

  public static void writeAmProcBad(int user, int uid, String processName) {
    android.util.EventLog.writeEvent(AM_PROC_BAD, user, uid, processName);
  }

  public static void writeAmProcGood(int user, int uid, String processName) {
    android.util.EventLog.writeEvent(AM_PROC_GOOD, user, uid, processName);
  }

  public static void writeAmLowMemory(int numProcesses) {
    android.util.EventLog.writeEvent(AM_LOW_MEMORY, numProcesses);
  }

  public static void writeAmDestroyActivity(int user, int token, int taskId, String componentName, String reason) {
    android.util.EventLog.writeEvent(AM_DESTROY_ACTIVITY, user, token, taskId, componentName, reason);
  }

  public static void writeAmRelaunchResumeActivity(int user, int token, int taskId, String componentName) {
    android.util.EventLog.writeEvent(AM_RELAUNCH_RESUME_ACTIVITY, user, token, taskId, componentName);
  }

  public static void writeAmRelaunchActivity(int user, int token, int taskId, String componentName) {
    android.util.EventLog.writeEvent(AM_RELAUNCH_ACTIVITY, user, token, taskId, componentName);
  }

  public static void writeAmOnPausedCalled(int user, String componentName, String reason) {
    android.util.EventLog.writeEvent(AM_ON_PAUSED_CALLED, user, componentName, reason);
  }

  public static void writeAmOnResumeCalled(int user, String componentName, String reason) {
    android.util.EventLog.writeEvent(AM_ON_RESUME_CALLED, user, componentName, reason);
  }

  public static void writeAmKill(int user, int pid, String processName, int oomadj, String reason) {
    android.util.EventLog.writeEvent(AM_KILL, user, pid, processName, oomadj, reason);
  }

  public static void writeAmBroadcastDiscardFilter(int user, int broadcast, String action, int receiverNumber, int broadcastfilter) {
    android.util.EventLog.writeEvent(AM_BROADCAST_DISCARD_FILTER, user, broadcast, action, receiverNumber, broadcastfilter);
  }

  public static void writeAmBroadcastDiscardApp(int user, int broadcast, String action, int receiverNumber, String app) {
    android.util.EventLog.writeEvent(AM_BROADCAST_DISCARD_APP, user, broadcast, action, receiverNumber, app);
  }

  public static void writeAmCreateService(int user, int serviceRecord, String name, int uid, int pid) {
    android.util.EventLog.writeEvent(AM_CREATE_SERVICE, user, serviceRecord, name, uid, pid);
  }

  public static void writeAmDestroyService(int user, int serviceRecord, int pid) {
    android.util.EventLog.writeEvent(AM_DESTROY_SERVICE, user, serviceRecord, pid);
  }

  public static void writeAmProcessCrashedTooMuch(int user, String name, int pid) {
    android.util.EventLog.writeEvent(AM_PROCESS_CRASHED_TOO_MUCH, user, name, pid);
  }

  public static void writeAmDropProcess(int pid) {
    android.util.EventLog.writeEvent(AM_DROP_PROCESS, pid);
  }

  public static void writeAmServiceCrashedTooMuch(int user, int crashCount, String componentName, int pid) {
    android.util.EventLog.writeEvent(AM_SERVICE_CRASHED_TOO_MUCH, user, crashCount, componentName, pid);
  }

  public static void writeAmScheduleServiceRestart(int user, String componentName, long time) {
    android.util.EventLog.writeEvent(AM_SCHEDULE_SERVICE_RESTART, user, componentName, time);
  }

  public static void writeAmProviderLostProcess(int user, String packageName, int uid, String name) {
    android.util.EventLog.writeEvent(AM_PROVIDER_LOST_PROCESS, user, packageName, uid, name);
  }

  public static void writeAmProcessStartTimeout(int user, int pid, int uid, String processName) {
    android.util.EventLog.writeEvent(AM_PROCESS_START_TIMEOUT, user, pid, uid, processName);
  }

  public static void writeAmCrash(int user, int pid, String processName, int flags, String exception, String message, String file, int line) {
    android.util.EventLog.writeEvent(AM_CRASH, user, pid, processName, flags, exception, message, file, line);
  }

  public static void writeAmWtf(int user, int pid, String processName, int flags, String tag, String message) {
    android.util.EventLog.writeEvent(AM_WTF, user, pid, processName, flags, tag, message);
  }

  public static void writeAmSwitchUser(int id) {
    android.util.EventLog.writeEvent(AM_SWITCH_USER, id);
  }

  public static void writeAmSetResumedActivity(int user, String componentName, String reason) {
    android.util.EventLog.writeEvent(AM_SET_RESUMED_ACTIVITY, user, componentName, reason);
  }

  public static void writeAmFocusedStack(int user, int displayId, int focusedStackId, int lastFocusedStackId, String reason) {
    android.util.EventLog.writeEvent(AM_FOCUSED_STACK, user, displayId, focusedStackId, lastFocusedStackId, reason);
  }

  public static void writeAmPreBoot(int user, String package_) {
    android.util.EventLog.writeEvent(AM_PRE_BOOT, user, package_);
  }

  public static void writeAmMeminfo(long cached, long free, long zram, long kernel, long native_) {
    android.util.EventLog.writeEvent(AM_MEMINFO, cached, free, zram, kernel, native_);
  }

  public static void writeAmPss(int pid, int uid, String processName, long pss, long uss, long swappss, long rss, int stattype, int procstate, long timetocollect) {
    android.util.EventLog.writeEvent(AM_PSS, pid, uid, processName, pss, uss, swappss, rss, stattype, procstate, timetocollect);
  }

  public static void writeAmStopActivity(int user, int token, String componentName) {
    android.util.EventLog.writeEvent(AM_STOP_ACTIVITY, user, token, componentName);
  }

  public static void writeAmOnStopCalled(int user, String componentName, String reason) {
    android.util.EventLog.writeEvent(AM_ON_STOP_CALLED, user, componentName, reason);
  }

  public static void writeAmMemFactor(int current, int previous) {
    android.util.EventLog.writeEvent(AM_MEM_FACTOR, current, previous);
  }

  public static void writeAmUserStateChanged(int id, int state) {
    android.util.EventLog.writeEvent(AM_USER_STATE_CHANGED, id, state);
  }

  public static void writeAmUidRunning(int uid) {
    android.util.EventLog.writeEvent(AM_UID_RUNNING, uid);
  }

  public static void writeAmUidStopped(int uid) {
    android.util.EventLog.writeEvent(AM_UID_STOPPED, uid);
  }

  public static void writeAmUidActive(int uid) {
    android.util.EventLog.writeEvent(AM_UID_ACTIVE, uid);
  }

  public static void writeAmUidIdle(int uid) {
    android.util.EventLog.writeEvent(AM_UID_IDLE, uid);
  }

  public static void writeAmStopIdleService(int uid, String componentName) {
    android.util.EventLog.writeEvent(AM_STOP_IDLE_SERVICE, uid, componentName);
  }

  public static void writeAmOnCreateCalled(int user, String componentName, String reason) {
    android.util.EventLog.writeEvent(AM_ON_CREATE_CALLED, user, componentName, reason);
  }

  public static void writeAmOnRestartCalled(int user, String componentName, String reason) {
    android.util.EventLog.writeEvent(AM_ON_RESTART_CALLED, user, componentName, reason);
  }

  public static void writeAmOnStartCalled(int user, String componentName, String reason) {
    android.util.EventLog.writeEvent(AM_ON_START_CALLED, user, componentName, reason);
  }

  public static void writeAmOnDestroyCalled(int user, String componentName, String reason) {
    android.util.EventLog.writeEvent(AM_ON_DESTROY_CALLED, user, componentName, reason);
  }

  public static void writeAmOnActivityResultCalled(int user, String componentName, String reason) {
    android.util.EventLog.writeEvent(AM_ON_ACTIVITY_RESULT_CALLED, user, componentName, reason);
  }

  public static void writeAmRemoveTask(int taskId, int stackId) {
    android.util.EventLog.writeEvent(AM_REMOVE_TASK, taskId, stackId);
  }

  public static void writeAmCompact(int pid, String processName, String action, long beforersstotal, long beforerssfile, long beforerssanon, long beforerssswap, long deltarsstotal, long deltarssfile, long deltarssanon, long deltarssswap, long time, int lastaction, long lastactiontimestamp, int setadj, int procstate, long beforezramfree, long deltazramfree) {
    android.util.EventLog.writeEvent(AM_COMPACT, pid, processName, action, beforersstotal, beforerssfile, beforerssanon, beforerssswap, deltarsstotal, deltarssfile, deltarssanon, deltarssswap, time, lastaction, lastactiontimestamp, setadj, procstate, beforezramfree, deltazramfree);
  }

  public static void writeAmOnTopResumedGainedCalled(int user, String componentName, String reason) {
    android.util.EventLog.writeEvent(AM_ON_TOP_RESUMED_GAINED_CALLED, user, componentName, reason);
  }

  public static void writeAmOnTopResumedLostCalled(int user, String componentName, String reason) {
    android.util.EventLog.writeEvent(AM_ON_TOP_RESUMED_LOST_CALLED, user, componentName, reason);
  }

  public static void writeAmAddToStopping(int user, int token, String componentName, String reason) {
    android.util.EventLog.writeEvent(AM_ADD_TO_STOPPING, user, token, componentName, reason);
  }
}
