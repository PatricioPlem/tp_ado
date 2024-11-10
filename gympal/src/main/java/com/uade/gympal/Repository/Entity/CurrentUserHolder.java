package com.uade.gympal.Repository.Entity;

public class CurrentUserHolder {
        private static Socio currentUser;

        public static Socio getCurrentUser() {
            return currentUser;
        }

        public static void setCurrentUser(Socio user) {
            currentUser = user;
        }

        public static void clear() {
            currentUser = null;
        }
}
