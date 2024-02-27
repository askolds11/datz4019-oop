package jtm.activity06;

public class Human implements Humanoid {
    private boolean isAlive;
    private int stomachWeight;

    public Human() {
        this.isAlive = true;
        this.stomachWeight = 0;
    }

    /**
     * @param food
     */
    @Override
    public void eat(Integer food) {
        if (food != null) {
            stomachWeight = food;
        }
    }

    /**
     * @return eaten food from the stomach
     */
    @Override
    public Integer vomit() {
        int vomittedWeight = stomachWeight;
        stomachWeight -= vomittedWeight;
        return vomittedWeight;
    }

    /**
     * @return "Alive" or "Dead" depending on his status
     */
    @Override
    public String isAlive() {
        return this.isAlive ? "Alive" : "Dead";
    }

    /**
     * @return "Dead" if humanoid successfully killed himself
     */
    @Override
    public String killHimself() {
        this.isAlive = false;
        return "Dead";
    }

    /**
     * @return current weight = BirthWeight + weight of the stomach of the current
     * humanoid.
     */
    @Override
    public int getWeight() {
        return Humanoid.BirthWeight + stomachWeight;
    }

    @Override
    public String toString() {
        return Human.class.getSimpleName() + ": " + getWeight() + " [" + stomachWeight + "]";
    }
}
