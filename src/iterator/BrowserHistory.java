package iterator;

public class BrowserHistory {
    private String[] urls = new String[10];
    private int count;
    public void push(String url){
        urls[count++] = url;
    }

    public String pop(){
        return urls[--count];
//        var lastIndex = urls.size() -1;
//        var lastUrl = urls.get(lastIndex);
//        return lastUrl;
    }

    public Iterator createIterator(){
        return new ArrayIterator(this);
    }

    public class ArrayIterator implements Iterator<String>{
        private BrowserHistory history;
        private int index;
        public ArrayIterator(BrowserHistory history) {
            this.history = history;
        }

        @Override
        public boolean hasNext() {
            return (index < history.count);
        }

        @Override
        public String current() {
            return history.urls[index];
        }

        @Override
        public void next() {
            index++;

        }
    }

//    public class ListIterator implements Iterator<String>{
//        private BrowserHistory history;
//        private int index;
//        public ListIterator(BrowserHistory history){
//            this.history = history;
//        }
//        @Override
//        public boolean hasNext() {
//            return (index < history.urls.size());
//        }
//
//        @Override
//        public String current() {
//            return history.urls.get(index);
//        }
//
//
//        @Override
//        public void next() {
//            index++;
//        }
//    }
}
