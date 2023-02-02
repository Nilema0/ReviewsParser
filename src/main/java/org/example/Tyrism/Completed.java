package org.example.Tyrism;

public class Completed implements OnCompleted {
    @Override
    public void onCompleted(final Object sender) {
        System.out.println("Загрузка закончена");
    }
}

