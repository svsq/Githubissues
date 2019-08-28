package com.paulsoja.githubissues.domain.interactor.base

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class ObservableUseCaseWithoutParams<T> {

  protected abstract fun buildObservableUseCase(): Observable<T>

  fun executeWithSubscription(onSuccess: (T) -> Unit, onFailure: (Throwable) -> Unit): Disposable {
    return buildObservableUseCase()
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe({
        onSuccess(it)
      }, {
        onFailure(it)
      })
  }

  fun execute(): Observable<T> {
    return buildObservableUseCase()
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }
}