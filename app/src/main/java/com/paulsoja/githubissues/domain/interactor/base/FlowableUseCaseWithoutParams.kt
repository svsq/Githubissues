package com.paulsoja.githubissues.domain.interactor.base

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class FlowableUseCaseWithoutParams<T> constructor() {

  protected abstract fun buildFlowableUseCase(): Flowable<T>

  fun executeWithSubscription(onSuccess: (T) -> Unit, onFailure: (Throwable) -> Unit): Disposable {
    return buildFlowableUseCase()
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe({
        onSuccess(it)
      }, {
        onFailure(it)
      })
  }

  fun execute(): Flowable<T> {
    return buildFlowableUseCase()
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }

  fun executePure(): Flowable<T> {
    return buildFlowableUseCase()
  }
}