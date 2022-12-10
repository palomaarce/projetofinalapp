package com.example.projetofinal.view;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.projetofinal.R;
import com.example.projetofinal.repository.BancoController;
import com.example.projetofinal.repository.CriaBanco;

import java.util.ArrayList;

public class ConsultaSQLite extends Activity {
    private SQLiteDatabase bancoDados;
    ListView lista;
    ArrayList<Integer> arrayIds;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_receita_por_refeicao);
        lista = findViewById(R.id.listView);

        criarBancoDados();

        BancoController crud = new BancoController(getBaseContext());
        Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[] {CriaBanco.NOME, CriaBanco.INGREDIENTES, CriaBanco.MODOPREPARO};
        int[] idViews = new int[] {R.id.tituloReceita, R.id.ingredientesReceita};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.item_receita_por_refeicao,cursor,nomeCampos,idViews, 0);
        lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(adaptador);
    }

    public void criarBancoDados(){
        try{
            bancoDados = openOrCreateDatabase("receitas", MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS receitas(" +
                    " id INTEGER PRIMARY KEY AUTOINCREMENT" +
                    " , nome VARCHAR)");
            bancoDados.close();

        } catch(Exception e){
            e.printStackTrace();

        }
    }
}
