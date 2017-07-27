package com.example.shramona.uihackathon;
               import android.content.Context;
               import android.content.DialogInterface;
               import android.content.Intent;
               import android.database.sqlite.SQLiteDatabase;
               import android.support.v7.app.ActionBarActivity;
               import android.os.Bundle;
               import android.support.v7.app.AlertDialog;
               import android.view.Menu;
               import android.view.MenuItem;
               import android.view.View;
               import android.widget.Button;
               import android.widget.EditText;
               import android.widget.Toast;


public class empadd extends ActionBarActivity implements View.OnClickListener {

    private EditText editTextID;
    private EditText editTextName;
    private EditText editTextDesig;
    private Button btnAdd;
    private Button btnView;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empadd);

        createDatabase();

        editTextID = (EditText) findViewById(R.id.editTextID);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextDesig = (EditText) findViewById(R.id.editTextDesig);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);

        btnAdd.setOnClickListener(this);
        btnView.setOnClickListener(this);
    }


    protected void createDatabase(){
        db=openOrCreateDatabase("PersonDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS persons(ID INTEGER PRIMARY KEY, name VARCHAR,desig VARCHAR);");
    }

    protected void insertIntoDB(){
        String ID = editTextID.getText().toString().trim();
        String name = editTextName.getText().toString().trim();
        String desig = editTextDesig.getText().toString().trim();
        if(ID.equals("") ||name.equals("") || desig.equals("")){
            Toast.makeText(getApplicationContext(),"Please fill all fields", Toast.LENGTH_LONG).show();
            return;
        }

        String query = "INSERT INTO persons (ID,name,desig) VALUES('"+ID+"','"+name+"', '"+desig+"');";
        db.execSQL(query);
        Toast.makeText(getApplicationContext(),"Saved Successfully", Toast.LENGTH_LONG).show();
    }


    /* @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         // Inflate the menu; this adds items to the action bar if it is present.
         getMenuInflater().inflate(R.menu.sqlite, menu);
         return true;
     }
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void showPeople(){
        Intent intent = new Intent(this,viewpeople.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if(v == btnAdd){
            insertIntoDB();
        }
        if(v==btnView){
            showPeople();
        }
    }
}
