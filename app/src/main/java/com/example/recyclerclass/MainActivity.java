package com.example.recyclerclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    List<Animals> animalsList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler);

        initData();

        MyAdapter myAdapter=new MyAdapter(this, animalsList);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));//que layour quiere que muestre (en este caso linear)



    }

    private void initData() {
        String[] meals={"Meal1","Meal2","Meal3"};
        Animals animal1=new Animals(
                "https://i.picsum.photos/id/1024/1920/1280.jpg?hmac=-PIpG7j_fRwN8Qtfnsc3M8-kC3yb0XYOBfVzlPSuVII",
                "Bird",
                "Birdo",
                13,
                2002,
                meals,
                "big birdo"
        );

        Animals animal2=new Animals(
                "https://i.picsum.photos/id/1020/4288/2848.jpg?hmac=Jo3ofatg0fee3HGOliAIIkcg4KGXC8UOTO1dm5qIIPc",
                "Bear",
                "Beardo",
                10,
                2022,
                meals,
                "big bear"
        );

        Animals animal3=new Animals(
                "https://i.picsum.photos/id/1074/5472/3648.jpg?hmac=w-Fbv9bl0KpEUgZugbsiGk3Y2-LGAuiLZOYsRk0zo4A",
                "Lioness",
                "Queen lion",
                20,
                2005,
                meals,
                "big cat"
        );

        Animals animal4=new Animals(
                "https://i.picsum.photos/id/1084/4579/3271.jpg?hmac=YblMazviSugJVfZsFPaFI_Vp6lBeQin62qpm8rxHruo",
                "Walrus",
                "Morsa",
                52,
                2050,
                meals,
                "big walrus"
        );

        Animals animal5=new Animals(
                "https://i.picsum.photos/id/169/2500/1662.jpg?hmac=3DBeyQbiPxO88hBdhIuFPbvy2ff7cm9vmnq8lPIL9Ug",
                "Dog",
                "doggo",
                13,
                2002,
                meals,
                "big dog"
        );

        Animals animal6=new Animals(
                "https://i.picsum.photos/id/200/1920/1280.jpg?hmac=-eKjMC8-UrbLMpy1A4OWrK0feVPB3Ka5KNOGibQzpRU",
                "Mountain cow",
                "Vaca",
                13,
                2002,
                meals,
                "big vaca"
        );

        Animals animal7=new Animals(
                "https://i.picsum.photos/id/219/5184/3456.jpg?hmac=2LU7i3c6fykd_J0T6rZm1aBoBmK4ivkH1Oc459aRUU0",
                "Cheetah",
                "Spotted cat",
                13,
                2002,
                meals,
                "big spotted cat"
        );

        Animals animal8=new Animals(
                "https://i.picsum.photos/id/275/4288/2848.jpg?hmac=DHPZUN0qLc6KRiIP21_mfYCi-BxH9JKNYPPJRhG8t40",
                "Seagull",
                "Sea Birdo",
                13,
                2002,
                meals,
                "big sea birdo"
        );

        Animals animal9=new Animals(
                "https://i.picsum.photos/id/244/4288/2848.jpg?hmac=R6j9PBP4aBk2vcEIoOPU4R_nuknizryn2Vq8GGtWTrM",
                "Picozapato",
                "picozapato",
                13,
                2002,
                meals,
                "big birdo"
        );

        Animals animal10=new Animals(
                "https://i.picsum.photos/id/433/4752/3168.jpg?hmac=Og-twcmaH_j-JNExl5FsJk1pFA7o3-F0qeOblQiJm4s",
                "Bear",
                "Beardo",
                13,
                2002,
                meals,
                "big bear"
        );

        animalsList.add(animal1);
        animalsList.add(animal2);
        animalsList.add(animal3);
        animalsList.add(animal4);
        animalsList.add(animal5);
        animalsList.add(animal6);
        animalsList.add(animal7);
        animalsList.add(animal8);
        animalsList.add(animal9);
        animalsList.add(animal10);
    }
}