package com.training.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.getSystemService

class MainActivity : AppCompatActivity() {
    val CHANNEL_ID="1"
    val NOTIFICATION_ID=101
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()
    }
private fun createNotificationChannel(){
    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
       val n_channel=NotificationChannel(CHANNEL_ID,"CHANNEL-1",NotificationManager.IMPORTANCE_HIGH)
        n_channel.description="App Description"
        n_channel.setShowBadge(true)
       //now register this channel to manager
        val n_manager= getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        n_manager.createNotificationChannel(n_channel)
    }
}
fun getNotification(view:View){
val i= Intent(this,MainActivity::class.java)
    val p_intent=PendingIntent.getActivity(this,0,i,0)

    var builder=NotificationCompat.Builder(this,CHANNEL_ID)
    builder.setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
    builder.setTicker("This is ticker")
    builder.setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.image))
    builder.setContentTitle("Title")
    builder.setContentText("Message")
    builder.setContentIntent(p_intent)
    builder.setAutoCancel(true)
val managerCompat=NotificationManagerCompat.from(this)
    managerCompat.notify(NOTIFICATION_ID,builder.build())

}
}