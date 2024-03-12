package jtm.activity06;

public class Martian implements Alien, Humanoid, Cloneable {
    private Object stomach;

    public Martian() {
        this.stomach = null;
    }

    /**
     * @param item
     */
    @Override
    public void eat(Object item) {
        if (
                stomach == null || item != null && !stomach.getClass().getSimpleName().equals(item.getClass().getSimpleName())
        ) {
            if (item instanceof Human) {
                ((Human) item).killHimself();
            }
            stomach = item;
        }
    }

    /**
     * @return content of the Alien stomach
     */
    @Override
    public Object vomit() {
        Object beforeVomit = stomach;
        stomach = null;
        return beforeVomit;
    }

    /**
     * @return weight of the alien
     */
    @Override
    public int getWeight() {
        int weight = Alien.BirthWeight;
        if (stomach instanceof Integer) {
            weight += (Integer) stomach;
        } else if (stomach instanceof Human) {
            weight += ((Human) stomach).getWeight();
        } else if (stomach instanceof Martian) {
            weight += ((Martian) stomach).getWeight();
        }
        return weight;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return clone(this);
    }

    private Object clone(Object current) {
        // cloning of current object
        // and its stomach
        Object cloned = null;
        if (current instanceof Human) {
            cloned = new Human();
            ((Human) cloned).eat(((Human) current).getWeight() - Humanoid.BirthWeight);
            ((Human) cloned).killHimself();
        } else if (current instanceof Martian) {
            cloned = new Martian();
            ((Martian) cloned).eat(
                clone(
                    ((Martian) current).stomach
                )
            );
        } else if (current instanceof Integer) {
            cloned = current;
        }
        return cloned;
    }

    /**
     * @return "I AM IMMORTAL!" because alien is immortal
     */
    @Override
    public String isAlive() {
        return "I AM IMMORTAL!";
    }

    /**
     * @return "I AM IMMORTAL!" because alien is immortal
     */
    @Override
    public String killHimself() {
        return "I AM IMMORTAL!";
    }

    /**
     * @param food
     */
    @Override
    public void eat(Integer food) {
        if (food != null) {
            stomach = food;
        }
    }

    @Override
    public String toString() {
        String printStomach = "";
        if (stomach instanceof Integer) {
            printStomach = String.valueOf(getWeight() - Alien.BirthWeight);
        } else if (stomach instanceof Human) {
            printStomach = stomach.toString();
        } else if (stomach instanceof Martian) {
            printStomach = stomach.toString();
        }
        return Martian.class.getSimpleName() + ": " + getWeight() + " [" + printStomach + "]";
    }
}
