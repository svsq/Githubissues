package com.paulsoja.githubissues.domain.interactor.base

import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class MaybeUseCaseWithoutParams<T> constructor() {

  protected abstract fun buildMaybeUseCase(): Maybe<T>

  fun executeWithSubscription(onSuccess: (T) -> Unit, onFailure: (Throwable) -> Unit): Disposable {
    return buildMaybeUseCase()
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe({
        onSuccess(it)
      }, {
        onFailure(it)
      })
  }

  fun execute(): Maybe<T> {
    return buildMaybeUseCase()
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }
}