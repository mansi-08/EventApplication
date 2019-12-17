package com.ssb.eventorganizer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ssb.eventorganizer.Database.DatabaseHelper;
import com.ssb.eventorganizer.Database.PhoneNumberTable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
public class Login extends AppCompatActivity  {

  //  private Button msubmit;
    private EditText mob;
    private SharedPreferences sharedPreferences;
 Handler handler;

//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        mob=findViewById(R.id.mobile_number);
//       Button  msubmit = (Button)findViewById(R.id.submit);
//        msubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(view.getId()==R.id.submit) {
//              //  Toast.makeText(this,"Login Successsful !!",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Login.this,NavigationDrawer.class);
//                startActivity(intent);
//                finish();}
//            }
//        });
//    }

    // ALTERNATE WAY FOR VERIFICATION

    int view = R.layout.activity_login;
    Button text;
    EditText enterNumber;
    String pattern = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$";
    Matcher m;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**sharedPreferences=getSharedPreferences("malwa_fest",Context.MODE_PRIVATE);
        if(!sharedPreferences.getString("id","").isEmpty())
        {
            To
        }*/
        super.onCreate(savedInstanceState);
        setContentView(view);




//set activity_executed inside insert() method.



       /* SharedPreferences sharedPref = getSharedPreferences("data",MODE_PRIVATE);
        int number = sharedPref.getInt("isLogged", 0);
        if(number == 0) {
            //Open the login activity and set this so that next it value is 1 then this conditin will be false.
            SharedPreferences.Editor prefEditor = sharedPref.edit();
            prefEditor.putInt("isLogged",1);
            prefEditor.commit();
        } else {



            //Open this Home activity
        }*/

        //Adding details in Database
//        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(this);
//        PhoneNumberTable phoneNumberTable = new PhoneNumberTable(enterNumber.getText().toString());


//    @Override
        text = findViewById(R.id.submit);
        enterNumber = findViewById(R.id.mobile_number);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                // database + validation

                DatabaseHelper databaseHelper=DatabaseHelper.getInstance(getApplicationContext());
                PhoneNumberTable phoneNumberTable = new PhoneNumberTable(enterNumber.getText().toString());

                Pattern r = Pattern.compile(pattern);
                if (!enterNumber.getText().toString().isEmpty()) {
                    m = r.matcher(enterNumber.getText().toString().trim());
                } else {
                    Toast.makeText(Login.this, "Please enter mobile number ", Toast.LENGTH_LONG).show();
                }
                if (m.find()) {


//                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(Login.this,NavigationDrawer.class);
//                    startActivity(intent);

                    if(!databaseHelper.AddPhoneNumber(phoneNumberTable))
                    {
                        Toast.makeText(getApplicationContext(),"Error writing to registration table",Toast.LENGTH_LONG).show();
                    }
                    else

                    {
                        Toast.makeText(getApplicationContext(),"Property Posted Successfully !!",Toast.LENGTH_SHORT).show();
                        sendMail();
                        handler = new Handler();
                        handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(getApplicationContext(),NavigationDrawer.class);
                            startActivity(intent);

                            finish();
                        }
                    },8000);





                    }


                } else {
                    Toast.makeText(getApplicationContext(), "Enter Valid Number", Toast.LENGTH_LONG).show();
                }
               /* Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"mansiv100@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "subject of email"+enterNumber.getText().toString());
                i.putExtra(Intent.EXTRA_TEXT   , "body of email");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(Login.this, "There are no email clients installed.", Toast.LENGTH_SHORT);
                }*/



                // no Validation, only database store

//                if(v.getId()==R.id.mobile_number)
//                {
//                    //Adding property details to database
//                   DatabaseHelper databaseHelper=DatabaseHelper.getInstance(Login.this);
//                   // PropertyTable propertyTable =new PropertyTable(mflat_no.getText().toString(),mlocation.getText().toString(),mcity.getText().toString(),mpincode.getText().toString(),mprice.getText().toString(),type,msize.getText().toString(),mbhk.getText().toString(),mspecialities.getText().toString());
//
//                    PhoneNumberTable phoneNumberTable = new PhoneNumberTable(enterNumber.getText().toString());
//
//                    if(!databaseHelper.AddPhoneNumber(phoneNumberTable))
//                    {
//                        Toast.makeText(getApplicationContext(),"Error writing to registration table",Toast.LENGTH_LONG).show();
//                    }
//                    else
//                    {
//                        Toast.makeText(getApplicationContext(),"Property Posted Successfully !!",Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(getApplicationContext(),NavigationDrawer.class);
//                        startActivity(intent);
//                        finish();
//                    }
//
//                }

            }
        });

    }
private void sendMail()
{
    JavaMailAPI javaMailAPI=new JavaMailAPI(this,"mansiv100@gmail.com","User logged in ","  User with phone number  "+enterNumber.getText().toString()+"  has logged in");
    javaMailAPI.execute();
}

//        public void submit(View view) {
//
//
////               Toast.makeText(this,"Login Successsful !!",Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(this,MainActivity.class);
//            startActivity(intent);
//            finish();
//
//        }

//    @Override
//    public void onClick(View view) {
//
//        if(view.getId()==R.id.submit) {
//            Toast.makeText(this,"Login Successsful !!",Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(this,MainActivity.class);
//            startActivity(intent);
//            finish();
//        }
//    }


//    public void submit(View view) {
//        Toast.makeText(this,"Login Successsful !!",Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(this,MainActivity.class);
//        startActivity(intent);
//        finish();
//    }
//


}
