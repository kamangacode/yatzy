# Implémentation du Kata Yatzy en BDD-TDD-DDD et SOLID
Source code of this video: https://github.com/emilybache/Yatzy-Refactoring-Kata

# Lancement des tests d'acceptance
Run src/test/java/acceptance.AllAcceptanceTest.java
Les résultats sont visibles en regardant la page: /yatzy-herve/target/FeaturesReport.html

# Pour plus de détail sur le scénario de test voir le gherkin
src/test/resources/any-player_playyatzi.feature

# Architecture core
* src/main/java/fr/muludiki/yatzy/adapter : Implémentation du pattern adapter, je fais abstraction des l'implémentation concrète.
* src/main/java/fr/muludiki/yatzy/domain : les objets métiers de l'application
* src/main/java/fr/muludiki/yatzy/usecase : les cas d'utilisation du jeu

# Architecture test
* src/test/java/acceptance/configurarion : la configiration spring/cucumber utiliser pour les tests
* src/test/java/acceptance/steps : l'implémentation du gherkin
* ssrc/test/java/unit : les tests unitaires du cas d'utilisation



