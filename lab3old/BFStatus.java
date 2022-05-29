enum BFStatus {
    Blazing("Бледно-зеленый"), ;

    private final String Type;
    Colors(String t) {
        Type = t;
    }

    @Override
    public String toString() {
        return Type;
    }
}