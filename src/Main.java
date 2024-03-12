import iterator.BrowserHistory;
import iterator.Iterator;
import memento.Editor;
import memento.History;
import state.Canvas;
import state.SelectionTool;
import strategy.BlackAndWhiteFilter;
import strategy.ImageStorage;
import strategy.JpegCompressor;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

         //Strategy Pattern
        var imageStorage = new ImageStorage();
        imageStorage.store("a", new JpegCompressor(), new BlackAndWhiteFilter());
         

        /** //Iterator Pattern
        var history = new BrowserHistory();
        history.push("A");
        history.push("B");
        history.push("C");

        Iterator iterator = history.createIterator();

        while (iterator.hasNext()){
            var url = iterator.current();
            System.out.println(url);
            iterator.next();
        } //if u change the internal code of the browser history, this code will not changed
        */

        /** //State Pattern//
        var canvas = new Canvas();
        canvas.setCurrentTool(new SelectionTool());
        canvas.mouseDown();
        canvas.mouseUp();*/


        /** //Memento Pattern//
        var editor =  new Editor();
        var history = new History();
        editor.setContent("A");
        history.push(editor.createState());
        editor.setContent("B");
        history.push(editor.createState());

        editor.setContent("C");
        editor.restore(history.pop());
        editor.restore(history.pop());
        System.out.println(editor.getContent());
        */


    }

    public static boolean isPrime(int number){
        if(number<1) return false;
        return !IntStream.rangeClosed(2, number/2).anyMatch(i -> number % i == 0);
    }
}