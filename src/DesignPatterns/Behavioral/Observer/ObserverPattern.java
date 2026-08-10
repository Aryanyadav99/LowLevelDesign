
package DesignPatterns.Behavioral.Observer;


import java.util.*;
public class ObserverPattern {

    // Observer
    interface Observer {
        void update(String video);
    }

    // Concrete Observers
    static class User implements Observer {
        private String name;
        public User(String name) {
            this.name = name;
        }

        @Override
        public void update(String video) {
            System.out.println(name + " got notification: " + video);
        }
    }

    // Subject
    static class YouTubeChannel {

        private List<Observer> subscribers = new ArrayList<>();
        public void subscribe(Observer observer) {
            subscribers.add(observer);
        }
        public void unsubscribe(Observer observer) {
            subscribers.remove(observer);
        }
        public void uploadVideo(String video) {
            System.out.println("\nNew video uploaded: " + video);
            notifySubscribers(video);
        }
        private void notifySubscribers(String video) {
            for (Observer observer : subscribers) {
                observer.update(video);
            }
        }
    }

    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();
        User user1 = new User("Kalia");
        User user2 = new User("Dholu");
        User user3 = new User("Bholu");
        channel.subscribe(user1);
        channel.subscribe(user2);
        channel.subscribe(user3);
        channel.uploadVideo("Design Patterns Explained");
        channel.unsubscribe(user2);
        channel.uploadVideo("Observer Pattern Explained");
    }
}