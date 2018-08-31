package com.example.wender.kotlinmessage

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.wender.kotlinmessage.Config.Config
import com.example.wender.kotlinmessage.model.User

class MainActivity : AppCompatActivity() {

    var mRegistrationBroadcastReceiver: BroadcastReceiver? = null

    override fun onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver!!)
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver!!, IntentFilter("registrationComplete"))
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver!!, IntentFilter(Config.STR_PUSH))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRegistrationBroadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(p0: Context?, p1: Intent?) {
                if (intent.action == Config.STR_PUSH) {
                    val message = intent.getStringExtra("message")
                    showNotification("EDMTDev", message)
                }
            }
        }


        val user = User()
        user.idade = 21
        user.nome = "Jose Farias"
        user.sexo = "Masculino"
        if (user.saveData()) {
            Toast.makeText(applicationContext, "Salvo com sucesso", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(applicationContext, "Erro ao salvar", Toast.LENGTH_LONG).show()
        }
    }

    private fun showNotification(title: String, message: String?) {
        val intent = Intent(applicationContext, MainActivity::class.java)
        val contentIntent = PendingIntent.getActivity(applicationContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val builder = NotificationCompat.Builder(applicationContext)
        builder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(message)
                .setContentIntent(contentIntent)
        val notificationManager = baseContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify(1, builder.build())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }
}
