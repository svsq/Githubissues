package com.paulsoja.githubissues.domain.interactor.base

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCaseWithoutParams<T> constructor() {

  protected abstract fun buildSingleUseCase(): Single<T>

  fun executeWithSubscription(onSuccess: (T) -> Unit, onFailure: (Throwable) -> Unit): Disposable {
    return buildSingleUseCase()
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe({
        onSuccess(it)
      }, {
        onFailure(it)
      })
  }

  fun execute(): Single<T> {
    return buildSingleUseCase()
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }

  fun executePure(): Single<T> {
    return buildSingleUseCase()
  }
}