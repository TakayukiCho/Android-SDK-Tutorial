package com.example.androidsdktutorial

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import io.karte.android.KarteApp
import io.karte.android.notifications.MessageHandler
import io.karte.android.notifications.registerFCMToken

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")
        KarteApp.registerFCMToken(token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // handled の値が `true` の場合は KARTE を起点に送信されたプッシュ通知
        // `false` の場合は KARTE 以外を起点に送信されたプッシュ通知
        val handled = MessageHandler.handleMessage(this, remoteMessage)
        if (!handled) {
            // KARTE以外のシステムを起点に送信されたプッシュ通知の場合の処理を書く
        }
    }

}