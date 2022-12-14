
public class Rectangle {
    private int left;
    private int top;
    private int right;
    private int bottom;
    private int ang_left_top;
    private int ang_top_right;
    private int ang_right_bottom;
    private int ang_bottom_left;
    private String type;
    private float square;
    private int perimeter;

    public Rectangle(
            int left,
            int top,
            int right,
            int bottom,
            int ang_left_top,
            int ang_top_right,
            int ang_right_bottom,
            int ang_bottom_left
    ) {
        if (left < 1 | top < 1 | right < 1 | bottom < 1) {
            System.err.println("Wrong side size");
        }
        if (ang_left_top < 1 | ang_top_right < 1 | ang_right_bottom < 1 | ang_bottom_left < 1) {
            System.err.println("Wrong angle. Angle should be > 0");
        }
        if (ang_left_top > 179 | ang_top_right > 179 | ang_right_bottom > 179 | ang_bottom_left > 179) {
            System.err.println("Wrong angle. Angle should be < 180");
        }
        if (ang_left_top + ang_top_right + ang_right_bottom + ang_bottom_left > 360) {
            System.err.println("Wrong angle. Angles sum should = 360");
        }
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.ang_left_top = ang_left_top;
        this.ang_top_right = ang_top_right;
        this.ang_right_bottom = ang_right_bottom;
        this.ang_bottom_left = ang_bottom_left;

        this.set_type();
        this.set_perimeter();
        this.set_square();

    }

    private void set_perimeter() {
        this.perimeter = this.left + this.top + this.right + this.bottom;
    }

    private void set_square() {
        String type_f = this.get_type();
        if ("Square".equals(type_f) | "Rectangle".equals(type_f)) {
            this.square = (float) this.left * (float) this.top;
        } else if ("Rum".equals(type_f)) {
            this.square = (float) this.left * (float) this.top;
        }
        else{
            this.square = 0;
        }
    }

    private void set_type() {
        boolean angles_equals = this.ang_left_top == this.ang_top_right
                && this.ang_top_right == this.ang_right_bottom
                && this.ang_right_bottom == this.ang_bottom_left;
        if (angles_equals) {
            if (this.check_square()) {
                this.type = "Square";
            } else if (this.check_rectangle()) {
                this.type = "Rectangle";
            }
        }
        else if (this.ang_left_top == this.ang_right_bottom && this.ang_bottom_left == this.ang_top_right) {
            if (this.check_rectangle()) {
                this.type = "Rum";
            }
        }
        else {
            this.type = "Other type";
        }
    }

    public String get_type(){
        return this.type;
    }

    public Float get_square(){
        return this.square;
    }

    public int get_perimeter(){
        return this.perimeter;
    }

    private boolean check_square() {
        return this.left == this.top && this.bottom == this.right && this.left == this.bottom;
    }

    private boolean check_rectangle() {
        return this.left == this.right && this.top == this.bottom && this.left != this.top;
    }
}
