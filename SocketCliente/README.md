
# Socket App Android
## Requisitos

- Java SDK 7
- Android Studio 2.2


## Build

La construcción nos genera un apk en la siguiente ruta

    app/build/outputs/

El comando de construcción

    ./gradlew assembleDebug


# Instalación  

Para instalar el apk resultado se ejecuta el siguiente comando

    adb install <device>

El dispositivo se obtiene por medio de

    adb list devices


## Cliente Implementación

```java
public class MainActivity extends AppCompatActivity {

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

```
