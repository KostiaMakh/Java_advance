public class Mobile {
    private int id;
    private String model;
    private int weight;
    private int height;
    private int width;
    private int thickness;
    Manufacture manufacture;
    Screen screen;

    public Mobile(int id,
                  String model,
                  int weight,
                  int height,
                  int width,
                  int thickness,
                  String brande,
                  String country,
                  String assemble,
                  float screen_diagonal,
                  int screen_width,
                  int screen_height,
                  String screen_type) {
        this.id = id;
        this.model = model;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.thickness = thickness;
        manufacture = new Manufacture(brande, country, assemble);
        screen = new Screen(screen_diagonal, screen_width, screen_height, screen_type);
    }



    public static class Manufacture {
        private String brande;
        private String country;
        private String assemble;

        public Manufacture(String brande,
                           String country,
                           String assemble) {
            this.brande = brande;
            this.country = country;
            this.assemble = assemble;
        }

        public String getBrande() {
            return brande;
        }

        public void setBrande(String brande){
            this.brande = brande;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country){
            this.country = country;
        }

        public String getAssemble() {
            return assemble;
        }

        public void setAssemble(String assemble) {
            this.assemble = assemble;
        }

        public String getFatcoryDet() {
            return String.format("%s (%s - %s)", brande, country, assemble);
        }
    }

    public static class Screen {
        private float diagonal;
        private int width;
        private int height;
        private String type;

        public Screen(float diagonal,
                      int width,
                      int height,
                      String type
        ) {
            this.diagonal = diagonal;
            this.height = height;
            this.width = width;
            this.type = type;
        }

        public float getDiagonal() {
            return diagonal;
        }

        public void setDiagonal(float diagonal){
            this.diagonal = diagonal;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width){
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height){
            this.height = height;
        }

        public String getType(){
            return type;
        }

        public void setType(String type){
            this.type = type;
        }

        public String getDetails() {
            return String.format("%s %.2f` %dx%d", type, diagonal, width, height);
        }

    }


    private static class Memory {
        private int volume;
    }


    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness){
        this.thickness = thickness;
    }

    public String getSize() {
        return String.format("%dx%dx%d", height, width, thickness);
    }
}
