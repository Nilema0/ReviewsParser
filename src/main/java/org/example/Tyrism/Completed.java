package org.example.Tyrism;

public class Completed implements OnCompleted {
    @Override
    public void OnCompleted(Object sender) {
        System.out.println("Загрузка закончена");
    }
}

