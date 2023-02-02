package org.example.Tyrism;

import java.util.ArrayList;

public class NewData implements OnNewDataHandler {
    @Override
    public void onNewData(final Object sender,final ArrayList<String> args) {
        for (String s : args) {
            System.out.println(s);
        }
    }
}
