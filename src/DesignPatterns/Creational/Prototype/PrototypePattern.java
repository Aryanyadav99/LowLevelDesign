package DesignPatterns.Creational.Prototype;

public class PrototypePattern {

    static class Zombie {
        private String model;
        private int health;
        private String weapon;

        // Expensive Constructor
        public Zombie() {

            System.out.println("Loading 3D Model...");
            System.out.println("Loading Texture...");
            System.out.println("Loading Animation...");
            System.out.println("Loading Sounds...");

            this.model = "Zombie Model";
            this.health = 100;
            this.weapon = "Knife";

            System.out.println("Zombie Created\n");
        }

        // Copy Constructor (Prototype)
        public Zombie(Zombie other) {
            this.model = other.model;
            this.health = other.health;
            this.weapon = other.weapon;
        }

        // Prototype Method
        public Zombie cloneZombie() {
            return new Zombie(this);
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public void setWeapon(String weapon) {
            this.weapon = weapon;
        }

        public void display() {
            System.out.println("Model  : " + model +"\nHealth : " + health + "\nWeapon : " + weapon
            );
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Expensive Object Creation (Only Once)
        Zombie original = new Zombie();

        // Cheap Cloning
        Zombie zombie1 = original.cloneZombie();
        zombie1.setHealth(80);

        Zombie zombie2 = original.cloneZombie();
        zombie2.setWeapon("Gun");

        System.out.println("Original Zombie");
        original.display();

        System.out.println("Clone 1");
        zombie1.display();

        System.out.println("Clone 2");
        zombie2.display();
    }
}