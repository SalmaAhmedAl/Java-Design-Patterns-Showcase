package strategy;

public class ImageStorage {
    //We wanna Image Storage behave differently based on the compressor and filter type

    public void store(String fileName, Compressor compressor, Filter filter){
        compressor.compress(fileName);
        filter.apply(fileName);
    }
}
