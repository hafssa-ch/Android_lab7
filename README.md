# 🌟 LAB 7 - Galerie de Stars – RecyclerView, Animations et Filtrage
Lab7 est une application Android interactive permettant de gérer une galerie de célébrités.
Ce projet met en pratique les concepts avancés de l'UI Android, la gestion des données avec le pattern DAO, et l'interactivité utilisateur.

## 🚀 Fonctionnalités
**Écran de démarrage animé :**  Une SplashActivity avec des animations fluides (rotation, mise à l'échelle, transparence).

**Liste dynamique :** Affichage des stars via un RecyclerView optimisé.

**Recherche en temps réel :** Filtrage instantané de la liste grâce à une SearchView intégrée.

**Gestion des notes :** Popup personnalisé pour modifier la note (RatingBar) d'une star au clic.

**Partage social :** Partagez l'application ou vos stars préférées via le menu système.

**Design circulaire :** Utilisation de CircleImageView et Glide pour un rendu visuel moderne.

## 🏗️ Architecture du Projet
Le projet suit une structure MVC (Modèle-Vue-Contrôleur) organisée en packages :

**beans :** Contient la classe de données Star.

**dao :** Interface générique IDao pour les opérations CRUD.

**service :** Implémentation du pattern Singleton avec StarService.

**adapter :** Logique de liaison des données avec StarAdapter.

**ui :** Les activités de l'interface utilisateur (SplashActivity, ListActivity).

## 🛠️ Technologies & Librairies
Java : Langage principal du projet.

Glide : Chargement et mise en cache efficace des images distantes.

CircleImageView : Pour des avatars circulaires élégants.

RecyclerView : Gestion performante des listes volumineuses.

AndroidX : Composants de support modernes.

## Resultat attendu


https://github.com/user-attachments/assets/2d917730-c6eb-4498-83e7-0cedffd9101f




