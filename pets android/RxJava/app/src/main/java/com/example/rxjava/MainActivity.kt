package com.example.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.Observable

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val observable = Observable.just(1,2,3) //??
        val single = Single.just(1)
        val flowable = Flowable.just(1,2,2)

        btntest.setOnClickListener {
            Log.e(TAG , "click click")
        }

        // subscribe для фонового потока а abserve для наблю.дения на другом потоке
//        val dispose = dataSource()
//                .subscribeOn(Schedulers.newThread())
//                .observeoOn(AndroidSchedulers.mainThread())
//                .subscribe ({
//                    btntest.text = "Next int $it"
//                    Log.e(TAG, "next int $it")
//                }, {
//                    Log.e(TAG, "it ${it.localizedMessage}")
//                },{
//                })

        val dispose = dataSource()
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            },{
    })
    }


/*
fun dataSource () : Observable <Int> {
return Observable.create ({ subscriber - >
for (i in 0..100){
Thread.sleep(1000)
subscriber.onNext (i)
}
subscriber.onComplete()
} , BackpressureStrategy.DROP) //стратегии - MISSING,ERROR,BUFFER,DROP,LATEST
}
fun dataSource () : Single <List<Int>> {
return Single.create {subscriber - >
val list = listOf (1,2,3,4,5,6,7)
subscriber.onSuccess(list)
}
}
аналог булеан (прописывать логи в круглых скобках субскрайб )
fun dataSource () : Completable {
return Completable.create { subscriber ->
val list = listOf(1, 2, 3, 4, 5, 6, 7)
subscriber.onComplete(list)
}
}
*/


    fun dataSource () : Maybe <List<Int>> {
        return Maybe.create { subscriber ->
            val list = listOf(1, 2, 3, 4, 5, 6, 7)
            subscriber.onSuccess(list)
            subscriber.onComplete()
        }
    }

