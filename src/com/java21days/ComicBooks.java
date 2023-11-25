package com.java21days;

import java.util.*;
public class ComicBooks {
//    simpler for loop syntax for (variable : structure)
//    .push(*what to push*) can be used to push an element on top of a stack or .pop() removes last
//    .peek() can be used to check out the top of the stack or .search(*what to find in stack*) returns distance from top of stack or -1 for no find
//    .empty() indicates whether a stack is empty
//    like arrayList, hash maps have a capacity, or an amount of allocated memory, if the size of the hash map exceeds this product, the map increases
//    its capacity by rehashing itself.
//    Load factor closer to 1.0(on a scale of 0.0 - 1.0) result in a more efficient use of memory at the expense of a longer lookup time for  each
//    element the opposite is true of load factors closer to 0.0.
//    determining the load factor involves considering if your priority is performance or memory efficiency.
//    three ways to create hash maps Hashmap hash = new HashMap(), which default contains 16 elements and has a load factor of .75, the second is to
//    set the amount of element as an argument, HashMap hash = new Hashmap(20), which creates a specified element of 20 with a load of .75, and the
//    third way is to set amount of elements as first argument, and load as second(most be a float), HashMap hash = new HashMap(20, 0.5F).

    public ComicBooks () {

    }

    public static void main(String[] arguments) {
        //sets up hash map
        HashMap quality = new HashMap();
        float price1 = 3.00F;
        quality.put("mint", price1);
        float price2 = 2.00F;
        quality.put("near mint", price2);
        float price3 = 1.50F;
        quality.put("very fine", price3);
        float price4 = 1.0F;
        quality.put("fine", price4);
        float price5 = .5F;
        quality.put("good", price5);
        float price6 = .25F;
        quality.put("poor", price6);

//    sets up collection
        Comic[] comix = new Comic[4];
        comix[0] = new Comic ("Amazing Spider-Man", "1A", "very fine", 12_000.00F);
        comix[0].setPrice( (Float) quality.get(comix[0].condition));

        comix[1] = new Comic("Incredible Hulk", "181", "near mint", 680.00F);
        comix[1].setPrice( (Float) quality.get(comix[1].condition));

        comix[2] = new Comic("Cerberus", "1A", "good", 190.00F);
        comix[2].setPrice( (Float) quality.get(comix[2].condition));

        comix[3] = new Comic("Black Panther", "1A", "mint", 16_980.00F);
        comix[3].setPrice( (Float) quality.get(comix[3].condition));

        for (int i = 0; i < comix.length; i++) {
            System.out.println("Title: " + comix[i].title);
            System.out.println("Issue: " + comix[i].issueNumber);
            System.out.println("Condition: " + comix[i].condition);
            System.out.println("Price: $" + comix[i].price + "\n");
        }

    }
}
