package HW1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start of Main");
        
        // Create an instance of the Pyramid class and call the makePyramid method (see Pyramid.java for more info)
        Pyramid p = new Pyramid();
        p.Output();

        // Create an instance of the Adlibs class and call the story method (see Adlibs.java for more info)
        Adlibs ad = new Adlibs();
        System.out.println(ad.story("Rogue, the dog,", 3, "brown"));

        // Create an instance of the Replace class and call the c "harReplace method (see Replace.java for more info)
        Replace r = new Replace();
        System.out.println(r.charReplace("I MAKE BREAD", 2, 'T'));

    }
}
