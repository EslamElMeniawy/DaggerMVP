package elmeniawy.eslam.daggermvp.mvp;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * BasePresenter
 * <p>
 * Created by Eslam El-Meniawy on 19-Feb-2018.
 * CITC - Mansoura University
 */

public abstract class BasePresenter<V> {
    public enum RequestState {
        IDLE,
        LOADING,
        COMPLETE,
        ERROR
    }

    protected final V view;

    private CompositeDisposable disposables = new CompositeDisposable();

    protected BasePresenter(V view) {
        this.view = view;
    }

    /**
     * Contains common setup actions needed for all presenters, if any.
     * Subclasses may override this.
     */
    public void start() {
    }

    /**
     * Contains common cleanup actions needed for all presenters, if any.
     * Subclasses may override this.
     */
    public void stop() {
        disposables.clear();
    }

    protected void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }
}
