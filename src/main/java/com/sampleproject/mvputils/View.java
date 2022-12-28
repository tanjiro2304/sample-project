package com.sampleproject.mvputils;

public interface View<P extends Presenter> {
    P getPresenter();
}
