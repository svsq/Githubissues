package com.paulsoja.githubissues.domain.interactor.base

import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class MaybeUseCase<T, in Params> {

  protected abstract fun buildMaybeUseCase(params: Params): Maybe<T>

  fun executeWithSubscription(params: Params, onSuccess: (T) -> Unit, onFailure: (Throwable) -> Unit): Disposable {
    return buildMaybeUseCase(params)
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe({
        onSuccess(it)
      }, {
        onFailure(it)
      })
  }

  fun execute(params: Params): Maybe<T> {
    return buildMaybeUseCase(params)
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }
}