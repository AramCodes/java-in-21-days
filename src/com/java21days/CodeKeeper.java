package com.java21days;

import java.util.*;

public class CodeKeeper {
//    arrayList grow or shrink unlike regular arrays in java
//    syntax isArrayList golfer = new ArrayList(); you can also add a number to set size
//    but if size is set and max is met list will grow by another 50%
//    list also cannot be accessed using  square brackets like normal arrays or javascript
//    golfer.add(*item to be added*, *optional index where*), .lastElement(), .get(*ind*), .remove(*ind*) , .set(*ind*, what to replace index with)
//    .clear(), .contains(*what to search for*), .indexOf(*what to search for*), .remove(*what needs to be removed*) ,.size() replaces .length,
//    .capacity(), trimToSize() to adjust capacity

//    .iterator() to loop through data structures

    ArrayList list;
    String[] codes = {"alpha", "lambda", "gamma", "delta", "zeta"};

    public CodeKeeper(String[] userCodes) {
        list = new ArrayList();
//    load built in codes
        for (int i = 0; i < codes.length; i++) {
            addCode(codes[i]);
        }
//        load user codes
        for (int j = 0; j < userCodes.length; j++) {
            addCode(userCodes[j]);
        }
//        display all code
        for ( Iterator ite = list.iterator(); ite.hasNext();) {
            String output = (String) ite.next();
            System.out.println(output);
        }

    }
    private void addCode(String code) {
        if (!list.contains(code)) {
            list.add(code);
        }
    }

    public static void main(String[] arguments) {
        CodeKeeper keeper = new CodeKeeper(arguments);
    }
}
