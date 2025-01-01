package christmas.domain.benefit;

public enum Badges {

    NONE("없음", 0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String name;
    private final int price;

    Badges(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public static Badges getBadge(int price) {
        if(price >= SANTA.price) {
            return SANTA;
        }
        if(price >= TREE.price) {
            return TREE;
        }
        if(price >= STAR.price) {
            return STAR;
        }
        return NONE;
    }
}
