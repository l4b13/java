class Troll extends Creature {
	String color;

    Shorty(String n, APlace p) {
        super(n, p);
    }

    @Override
    public String toString() {
        return (super.toString() + ", цвет: " + color + ".");
    }

    void leanforward(){
        System.out.println(this.getName() + " наклонился вперед.");
    }


    void whisper(ICreature smn, String s) {
    	System.out.println(this.getName() + " прошептал " + smn.getName.case("R") + s + ".");
    }


    void lookatthing(AThing t) {
        System.out.println(this.getName() + " посмотрел на " + t.getName.case("V") + ".");
    }

    void lookatsmn(ACreature c) {
    	System.out.println(this.getName() + " посмотрел на " + c.getName.case("V") + ".");
    }


}