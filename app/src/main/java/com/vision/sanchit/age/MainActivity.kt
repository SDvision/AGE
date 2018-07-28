/*   Made by SD on 30/5/2018   */

package com.vision.sanchit.age

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Clock
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // ageCalculator()
        btnGetMyAge.setOnClickListener {
            /*
            * test code for month return
                this returns 0 for january and then cont so plus 1 done in month calculation
            */

            //for year //we need single case
            var year: Int = txtEnterYear.text.toString().toInt()
            var yourYear: Int = Calendar.getInstance().get(Calendar.YEAR) - year
            //txtGetMyAge.setText("Your Age : $yourAge")

            //for month //we need two cases
            var month:Int = txtEnterMonth.text.toString().toInt()
            //case 1
            var yourMonth: Int = Calendar.getInstance().get(Calendar.MONTH) - month
            //else ie if not case 1
            if(yourMonth<0){
                yourYear = yourYear -1
                yourMonth = 1 + 12 - month + Calendar.getInstance().get(Calendar.MONTH)
            }
            //txtGetMyAge.setText("Your Age(months) : $yourMonth")

            //for days // we need 2 cases
            var day: Int = txtEnterDay.text.toString().toInt()
            //CASE 1
            var yourDay: Int = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) - day
            //else ie if not case 1
            if(yourDay<0) {
                yourMonth = yourMonth - 1
                if (month / 2 == 0) {
                    yourDay = 30 - day + Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                }else{
                    yourDay = 31 - day + Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                }
            }

            //For time hour
            var timeHr: Int = txtEnterTime.text.toString().toInt()
            var yourHr: Int = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) - timeHr
            if(yourHr<0){
                yourDay = yourDay-1
                yourHr = 24 - timeHr + Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
            }

            //for timr minute
            //var timeMinute: Int = txtEnterMinute.text.toString().toInt()
            //var yourMinute: Int = Calendar.getInstance().get(Calendar.MINUTE) - timeMinute
            //if(yourMinute<0){
            //    yourHr = yourHr- 1
            //   yourMinute = 60 - timeMinute + Calendar.getInstance().get(Calendar.MINUTE)
            //}


            txtGetMyAge.setText("$yourYear YEAR, $yourMonth MONTH,\n $yourDay DAY," +
                    " $yourHr HOURS")
        }

    }
/* public fun ageCalculator(view: View){

              //  btnGetMyAge.setOnClickListener {
                    var year: Int = txtEnterAge.text.toString().toInt()
                    var yourAge: Int = Calendar.getInstance().get(Calendar.YEAR) - year
                    txtGetMyAge.setText("Your Age : $yourAge")
                }

            }
    }*/
}
