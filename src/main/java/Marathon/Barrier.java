package Marathon;

public abstract class Barrier {
    public abstract void doIt(Competitor competitor);
}

class Wall extends Barrier {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }
}

class Water extends Barrier {
    int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(length);
    }
}

class Cross extends Barrier {
    int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(length);
    }
}

class MainCross {
    public static void main(String[] args) {
        Competitor[] competitors = {new Human("Bob"), new Cat("Vaska"), new Dog("Sharik")};
        Barrier[] barriers = {new Cross(80), new Wall(5), new Water(3)};

        for (Competitor c : competitors) {
            for (Barrier b : barriers) {
                b.doIt(c);
                if (!c.isOnDistance()) {
                    break;
                }
            }
        }
        for (Competitor c : competitors) {
            c.info();
        }

        System.out.println("------------------------------------");

        Competitor[] peopleCompetitors = {new Human("Иван"), new Human("Саша"), new Human("Петр")};
        Competitor[] catsCompetitors = {new Cat("Мурзик"), new Cat("Муся"), new Cat("Рыжик")};
        Competitor[] animalsCompetitors = {new Human("Вася"), new Cat("Володя"), new Dog("Шарик"), new Dog("Барбос")};

        Team people = new Team("Люди", peopleCompetitors);
        Team cats = new Team("Кошаки", catsCompetitors);
        Team animals = new Team("ANIMALS", animalsCompetitors);

        Course course = new Course("Полоса", barriers);
        course.doIt(people);
        course.doIt(cats);
        course.doIt(animals);

        animals.showResults();
        animals.showWhoPassedDistance();
    }
}