package com.example.personal.gatitos.Activities;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.personal.gatitos.R;

public class llamada extends AppCompatActivity {
    private EditText PHONE;
    private Button BTNPHONE;
    private final int phonecode = 100;
    private final String phoneNumber="9831069810";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamada);

        BTNPHONE=(Button) findViewById(R.id.BTNPHONE);


        BTNPHONE.setOnClickListener(new View.OnClickListener() {

            //botón para la llamada
            @Override
            public void onClick(View v) {

                if(phoneNumber!=null && !phoneNumber.isEmpty()) {
                    //comprobar version actual de android
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        //Comprobar si ha aceptado, no ha aceptado, o nunca se le ha preguntado
                        if(CheckPermission(Manifest.permission.CALL_PHONE)){
                            //Ha aceptado
                            Intent i=new Intent(Intent.ACTION_CALL, Uri.parse("tel: "+phoneNumber));
                            if(ActivityCompat.checkSelfPermission(llamada.this, Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)return;
                            startActivity(i);
                        }else{
                            if(!shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)){
                                //No se le ha preguntado aún
                                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, phonecode);



                            }else{
                                //Ha denegado
                                Toast.makeText(llamada.this, "Please, enable the request permisssion",Toast.LENGTH_SHORT).show();
                                Intent i= new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                i.addCategory(Intent.CATEGORY_DEFAULT);
                                i.setData(Uri.parse("package:"+ getPackageName()));
                                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                                startActivity(i);





                            }

                        }


                    } else {
                        OldersVersions(phoneNumber);
                    }
                }
            }
            private void OldersVersions(String phoneNumber) {
                Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + phoneNumber));
                startActivity(intentCall);
                if (CheckPermission(Manifest.permission.CALL_PHONE)) {
                    startActivity(intentCall);
                } else {
                    Toast.makeText(llamada.this, "You declined the access", Toast.LENGTH_SHORT).show();
                }

            }


        });}










    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //caso del telefono
        switch (requestCode){
            case phonecode:
                String permission= permissions[0];
                int result=grantResults[0];
                if(permission.equals(Manifest.permission.CALL_PHONE)){
                    //comprobar la situacion del permiso
                    if(result==PackageManager.PERMISSION_GRANTED){
                        //concedió el permiso

                        Intent intentCall=new Intent(Intent.ACTION_CALL, Uri.parse("tel: "+phoneNumber));
                        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)return;
                        startActivity(intentCall);
                    }else{
                        //No concedió su permiso
                        Toast.makeText(llamada.this, "You declined the access",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;

        }


    }

    private boolean CheckPermission(String permission){
        int result=this.checkCallingOrSelfPermission(permission);
        return result==PackageManager.PERMISSION_GRANTED;



    }

}
