package elmeniawy.eslam.daggermvp.rx;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * SchedulersFacade
 * <p>
 * Created by Eslam El-Meniawy on 19-Feb-2018.
 * CITC - Mansoura University
 * <p>
 * Provides various threading schedulers.
 */

public class SchedulersFacade {
    @Inject
    public SchedulersFacade() {
    }

    /**
     * IO thread pool scheduler
     */
    public Scheduler io() {
        return Schedulers.io();
    }

    /**
     * Computation thread pool scheduler
     */
    public Scheduler computation() {
        return Schedulers.computation();
    }

    /**
     * Main Thread scheduler
     */
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
