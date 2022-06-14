package basic.Enum;

public enum Color {
    red{
        public void print(){
            System.out.println(red);
        }
    },
    yellow{
        @Override
        public void print() {
            System.out.println(yellow);
        }
    },blue {
        @Override
        public void print() {
            System.out.println(blue);
        }
    };

    abstract public void print();
}
