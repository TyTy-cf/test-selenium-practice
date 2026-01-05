# TP Selenium


Formation Selenium – Java / Maven / JUnit 5 / Allure  
Site web sur lequel seront effectués les tests : **OrangeHRM Demo** – https://opensource-demo.orangehrmlive.com/


# Jour 1 – Fondamentaux Selenium


## Objectifs pédagogiques globaux


- Mettre en place un projet de tests automatisés Selenium en Java
- Manipuler les sélecteurs (XPath & CSS), actions complexes et attentes


## Prérequis


- Projet Spring Boot Java **basique** fourni (avec Maven)
- Java 25 installé
- Maven installé
- Navigateur Chrome installé (?)
- (IntelliJ ?)


## Étape 1 – Préparation du projet


### 1.1. Création / récupération du projet


1. Vous trouverez le TP à partir duquel nous allons travailler sur ce dépôt Git : https://github.com/TyTy-cf/test-selenium-practice


### 1.2. Ajout des dépendances de base


Dans le `pom.xml`, ajouter les dépendances nécessaires pour utiliser Selenium


## Étape 2 – Premier test Selenium : connexion à OrangeHRM


### 2.1. Classe de base de test


Créer une classe `BaseTest` dans `src/test/java/tests` :

- Méthode `@BeforeEach` pour :
  - Configurer WebDriverManager
  - Instancier un `WebDriver`
  - Configurer une fenêtre (maximisée) et éventuellement une **attente implicite** (10s).

- Méthode `@AfterEach` pour fermer le navigateur (`driver.quit()`).


### 2.2. Exercice : classe `LoginTest`


Créer une classe `LoginTest` dans `src/test/java/tests/page` :


- Créer un test `testLoginWithValidCredentials()` qui :
  1. Ouvre la page de login
  2. Renseigne le username `Admin`
  3. Renseigne le password `admin123`
  4. Clique sur le bouton de connexion
  5. Vérifie que le dashboard est affiché (ex: présence d’un élément spécifique, ou texte "Dashboard")

- Exécuter votre test


## Étape 3 – Sélection d’éléments : XPath vs CSS


### 3.1. Locators multiples


Dans une nouvelle classe `SelectorTest` (ou dans `LoginTest`) :

Sur la page de login, définir plusieurs locators pour chaque élément :

- Champ `username` :
	- Par name
	- Par CSS selector
	- Par XPath

- Champ `password` :
	- Par name
	- Par CSS
	- Par XPath

- Bouton `login` :
	- Par CSS
	- Par XPath (par attribut, puis par texte)
	
	
Le but est de voir toutes les manières de récupération des éléments du DOM


Écrire un test qui utilise différents locators pour remplir les champs, puis :
	- Se connecte
	- Vérifie que la page dashboard est affichée

Posez vous les questions suivantes :

Quels locators sont les plus lisibles ?
Quels locators sont les plus robustes si le HTML change ?


## Étape 4 – Actions complexes


### 4.1. Navigation dans le menu Admin


Créer une classe `AdminTest` dans `src/test/java/tests/admin`, avec une méthode de test, par exemple `testNavigateToAdmin()` :

- Réutiliser la logique de login (ou la dupliquer pour le moment)
- Une fois connecté :
	- Accéder au menu Admin
	- Afficher la page Admin (liste des utilisateurs)
	- Vérifier que la page Admin est bien affichée (Ex : tire “Admin”)


### 4.2. Formulaire d’ajout d’utilisateur (simplifié)


Dans le même test ou un nouveau :

- Cliquer sur le bouton Add (ajout d’utilisateur)
- Repérer quelques champs du formulaire
- Remplir les champs (sans obligation de sauvegarder)

- (Optionnel) Utiliser la classe Actions pour :
	- Faire un double-clic sur un champ
	- Utiliser sendKeys + TAB pour changer de champ


## Étape 5 – Attentes implicites & explicites


### 5.1. Attentes explicites


Ajouter une mécanique d’attente explicite, idéalement dans le `BaseTest`
- Méthode pour attendre la visibilité d’un élément
- Méthode pour attendre qu’un élément soit cliquable

Créer un test `testLoginWithExplicitWaits()` qui :
- Utilise les attentes explicites pour :
- Attendre que les champs de login soient visibles
- Attendre que le bouton de login soit cliquable
- Attendre que le dashboard soit visible après connexion

- Créer un test qui échoue volontairement en mettant un timeout trop court, puis le corriger

