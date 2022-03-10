package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridViewClass extends AppCompatActivity {

    List<ItemModel> lista=new ArrayList<>();
    //crear objeto customAdapter
    //crear items

    ItemModel item1=new ItemModel(R.drawable.berrytail_ic, R.drawable.berrytail_min, R.drawable.berrytail_big, "Berrytail", "Cat","Dark forest warrior","Small cat with short legs and long tail.\n\nAlways showing emotions with his face, bad at hidding them. Because of that, he\'s easly read by others. Rancorous and very inteligent, with an excelent memory. Silent but snaps easly at others when he\'s doing something. Irritable, unable to show respect and rebel; but he knows he must shut up with the ones who has more powers than him (something that left when he went to the dark forest and attacks everyone, weaker or stronger than him). He looks for fight whenever he can, no matter the reason");
    ItemModel item2=new ItemModel(R.drawable.bush_ic, R.drawable.bush_min, R.drawable.bush_big, "Bush", "Cat","Dark forest warrior","Small cat with short fur but with a plump belly. Short tail and kinda big, tufted ears\n\n Arrogant, strong, agile. Rather intelligent but prefers to attack before thinking and doesn\'t care if that makes them enter into a bigger fight. Passive-aggressive but always alert and their claws are always out. Cruel, gets angry easly.\nLikes to watch others train difficult moves.");
    ItemModel item3=new ItemModel(R.drawable.fish_ic, R.drawable.fish_min, R.drawable.darkbois_big,"Fish", "Cat","Dark forest warrior","Giant, fluffy boy with a thin, rather short tail and long ears. He can be seen always smiling, but not in a bad way\n\nHe\'s stupid,he\'s more muscule than brain, so don\'t try to explain him something, even if it\'s simple. Just teach him with the body (the moves he has to do) and he will learn that way.\n Rather passive, isn\'t always looking for a fight (like Berrytail or Bush) and prefers talking. He can\'t stand training for a long time since he gets bored easly.\nSkilled, smug, likes to pressume about his skills but in a way that attracts as many cats as possible, reason that most of the cats hate him. He also it\'s the type of cat that does dad jokes too, but aren\'t funny. Likes to mess with others and most of the times it gets him into trouble");
    ItemModel item4=new ItemModel(R.drawable.forest_ic, R.drawable.forest_min, R.drawable.forest_big, "Forest", "Cat","Dark forest leader","Normal sized cat with short fur\n\nManipulative and cruel, he could act without hestiation even if means to hurt someone and do not expect that he resents for it. He has no appreciation to anyone, not even his family. Intelligent than he looks, easly can escape of a situation with mostly violence. Very jealous and always wants to be the center of the attention, something that bothers him a lot if he\'s not.");
    ItemModel item5=new ItemModel(R.drawable.hoot_ic, R.drawable.hoot_min, R.drawable.darkbois_big, "Hoot", "Cat","Dark forest warrior","Big she-cat with droppy, long fur. Skinny legs with a bushy tail\n\nDoesn\'t like to fight or do bad actions, she always wanted to be some pacifist hero. But she\'s easy to convince and manipulate, that\'s how Forest made her end in the dark forest, making her believe that killing will do good since they won\'t bother good cats. She despises that part of herself.\nEmpathic, weak minded, intelligent, she regrets doing something after doing it and seeing the consequences, not before. Acts weak in the training so she can escape from them, and more than one time she had an alone, intense session with Forest. She\'s usually seen with a sad face");
    ItemModel item6=new ItemModel(R.drawable.liontail_ic, R.drawable.liontail_min, R.drawable.liontail_big, "Liontail", "Cat","Dark forest warrior","Slightly big tom with short fur and a very long tail. Sharp, curved claws. Small eyes. Long, tufted ears and a broad head.\n\nHe\'s a natural genious when comes to learn; he\'s more than a quick learner.\nProud and agresive, won\'t hestiate if he got a reason to do whatever he has to do. But has a little heart with the ones he bound (his family and mentor basically) and it\'s hard to think he will ever hurt them; something that dissappeard when became Forest\'s peon. But because he\'s very, very easy to manipulate, others used to use that to make him the dirty job.\nSerious and never has time for a joke, since he thinks that are a waste of time and has a direct attack to someone. He\'s also very impulsive when someone attacks him directly (mostly with words) and won\'t take back even if he\'s wrong.");
    ItemModel item7=new ItemModel(R.drawable.moon_ic, R.drawable.moon_min, R.drawable.darkbois_big, "Moon", "Cat","Dark forest warrior","Small she-cat with long, unkept fur (usually she has stick leaves or twigs on it), small ears and long tail\n\nHer hearing is very good and get offensed easly if called \'blind\'. Passive, doesn\'t like to fight and it\'s quite lazy; she\'s grateful that dead she doesn\'t have to eat (because she will die again). She takes things personal so after she was blinded she took advantage of others. She\'s quite confident and more than one time you have to approach her to see that she\'s really blind. Usually she\'s quiet and it\'s very fast");
    ItemModel item8=new ItemModel(R.drawable.orangestar_ic, R.drawable.orangestar_min, R.drawable.orangestar_big, "Orangestar", "Cat","Dark forest warrior","Innusual big tom with short fur\n\nRancorous, he\'s unable to accept things. Because of his \'blessing\' his usual clam, brilliant character become a darker, crazy attitude that was the one that was with him until he died");
    ItemModel item9=new ItemModel(R.drawable.silverthorn_ic, R.drawable.silverthorn_min, R.drawable.darkbois_big, "Silverthorn", "Cat","Dark forest warrior","Big, fluffy tom with a fluffy tail and tired eyes.\n\nRancorous (more after he was kicked by Guide) and very intelligent (even if he usually doesn\'t show it), he\'s very proud of his strenght. Alive and in StarClan he was very friendly and always was in a conversation with a cat. He isn\'t very formal and treats everyone as some sort of old friend.\nOn the Dark Forest he\'s not very social and prefers to be by himself. He also only showed his power to change his fur in StarClan, so in the DF only Forest knows about his power. He\'s usually seen in a bad mood, remembering how he was kicked and doesn\'t have much interest in training but more in getting back in the starry place.");
    ItemModel item10=new ItemModel(R.drawable.zilian_ic, R.drawable.zilian_min, R.drawable.darkbois_big, "Zilian", "Cat","Dark forest warrior","Very small cat with short fur and tail. They have a twisted paw because training and they can\'t move it properly\n\nSad kitty, they only wanted to impress their family and ended in a creepy place where they got their paw twisted. They managed to keep going, but usually they hides until the training is over, other times Forest forces him to analytze moves since they can\'t fight. Even that, they has excellent observation qualities if they can\'t express properly what they\'re actually seeing. They admires cats easly");

    CustomAdapter customAdapter=new CustomAdapter(this, lista);
    private GridView gridView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_class);

        gridView=findViewById(R.id.gridClass);



        //añadir
        lista.add(item1);
        lista.add(item2);
        lista.add(item3);
        lista.add(item4);
        lista.add(item5);
        lista.add(item6);
        lista.add(item7);
        lista.add(item8);
        lista.add(item9);
        lista.add(item10);



        //damos el adapter
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(GridViewClass.this, SecondActivity.class);
                ItemModel item= (ItemModel) adapterView.getItemAtPosition(i);//con esto pillas el pbjeto que estas haciendo click
                //parent es la array


                //ESTO ES LO QUE SE ENVIA
                ///pillas los datos
                String tittle = item.getTittle();
                String subtitle = item.getSubtittle();
                String descript = item.getDesript();
                String details = item.getDetail();
                int iconoClass= item.getIconoClass();
                int imgGrande= item.getImgGrande();
                //iconolist no se envia porque no sale

                //los envias
                intent.putExtra(MainActivity.TITULO_PROD, tittle);
                intent.putExtra(MainActivity.SUBTITULO_PROD, subtitle);
                intent.putExtra(MainActivity.DESC_PROD, descript);
                intent.putExtra(MainActivity.DETAIL_PROD, details);
                intent.putExtra(MainActivity.ICONOClASS_PROD, iconoClass);
                intent.putExtra(MainActivity.IMG_PROD, imgGrande);


                startActivity(intent);

                //MANERA 2:
                //displayInfo(i);> metodo

            }
        });

    }

    private class CustomAdapter extends BaseAdapter {
        private Context context;//esto siempre
        private List<ItemModel> itemModels;//the     lost android studio.app xdd

        public CustomAdapter(Context context, List<ItemModel> itemModels) {
            this.context = context;
            this.itemModels = itemModels;
        }

        @Override
        public int getCount() {return itemModels.size();}//el numero de objetos en la lista

        @Override
        public Object getItem(int position) {return itemModels.get(position);}//pilla el obj del item seleccionado

        @Override
        public long getItemId(int position) {return position;}//dame la posicion del item con ese id

        @Override//esto es lo que va a salir en el listview/gridview
        public View getView(int position, View convertView, ViewGroup parent) {
            View vista= getLayoutInflater().inflate(R.layout.grid_view_row, null);
            //en el inflate (1a) se pasa el list_row

            //ahora se linkean los elements del layout
            //como findViewById es para vistas, usas la vista del metodo
            TextView titulo=vista.findViewById(R.id.gridRowTxt);
            ImageView img=vista.findViewById(R.id.gridRowImg);

            //de la array, que se refiere a items de arriba.
            titulo.setText(itemModels.get(position).getTittle());
            img.setImageResource(itemModels.get(position).getIconoList());

            return vista;///si es null es que lo hace en otro momento
        }
    }
/*//METODO. Hace lo mismo que lo del arriba pero en meodo y enviando posicion
    private void displayInfo(int position) {
        Intent i = new Intent(getApplicationContext(), DetailActivity.class);
        i.putExtra(EXTRA_TEXT_TITLE,items.get(position).getItemName());
        i.putExtra(EXTRA_TEXT_SUBTITLE,items.get(position).getItemSubtitle());
        i.putExtra(EXTRA_TEXT_DESC,items.get(position).getItemDesc());
        i.putExtra(EXTRA_TEXT_FROM,items.get(position).getItemFrom());
        i.putExtra(EXTRA_IMAGE, items.get(position).getImageName());
        i.putExtra(EXTRA_IMAGE_BIG, items.get(position).getImageBig());
        startActivity(i);
    }*/
}