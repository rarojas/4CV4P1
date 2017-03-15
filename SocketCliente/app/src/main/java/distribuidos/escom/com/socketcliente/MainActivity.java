package distribuidos.escom.com.socketcliente;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AndroidException;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {


    private Button sendButton;
    private EditText cmdText;
    private EditText responseText;
    private EditText ipText;

    private static final int PUERTO = 5000;
    private String IP_SERVER = "192.168.1.1";
    private static final String MENSAJE = "MENSAJE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = (Button) findViewById(R.id.button);
        cmdText = (EditText) findViewById(R.id.editText);
        responseText = (EditText) findViewById(R.id.editText2);
        ipText = (EditText) findViewById(R.id.ipText);


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = MainActivity.this.getCurrentFocus();
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                String cmd = cmdText.getText().toString();
                if(ipText.getText().length() > 0){
                    IP_SERVER = ipText.getText().toString();
                }
                if (cmd.length() > 0) {
                        TareaAsincrona tareaAsincrona = new TareaAsincrona();
                        tareaAsincrona.execute(cmd);
                        if(cmd.equals("salir")){
                            finish();
                        }
                }
                else{
                    Toast.makeText(MainActivity.this, "Acciones permitidad \"frase\" o \"libro\" ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

     class TareaAsincrona extends AsyncTask<String,Integer,String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setTitle("Conectando con el servidor");
            progressDialog.setMessage("Espere por favor");
            progressDialog.show();

        }

        @Override
        protected String doInBackground(String... values) {

            try {
                InetAddress inetAddress = InetAddress.getByName(IP_SERVER);
                Log.i(MENSAJE, "Conectando...");
                Socket socket = new Socket(inetAddress, PUERTO);
                Log.i(MENSAJE, "Conectado  al servidor...");

                Log.i(MENSAJE, "Enviar datos  al servidor...");
                PrintStream printStream = new PrintStream(socket.getOutputStream());
                String peticion = values[0];
                printStream.println(peticion);


                Log.i(MENSAJE, "Recibiendo datos del servidor...");

                InputStream inputStream = socket.getInputStream();
                byte[] lenBytes = new byte[256];
                inputStream.read(lenBytes, 0, 256);
                String recibido = new String(lenBytes, "UTF-8").trim();
                socket.close();
                return recibido;
            } catch (UnknownHostException e) {
                e.printStackTrace();
                Log.i(MENSAJE, e.getMessage());
                return e.getMessage();

            } catch (IOException e) {
                e.printStackTrace();
                Log.i(MENSAJE, e.getMessage());
                return e.getMessage();
            }
        }

         @Override
         protected void onPostExecute(String s) {
             super.onPostExecute(s);
             progressDialog.dismiss();
             MainActivity.this.responseText.setText(s);
         }
     }

}



