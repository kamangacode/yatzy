Feature: Tout joueur - Jouer au Yatzi

  Un joueur souhaite marquer un jet DONNÉ dans une catégorie DONNÉE.

  Background:
    Given des joueurs existent:
      | id  | firstName | score |
      | abc | Herve     | 0     |
      | def | Jamal     | 0     |
      | ghi | Francis   | 0     |

  Scenario Outline: Jouer avec une catégorie donné
    Given Le joueur "<prénom_joueur>"
    And les dés "<dés_1>" "<dés_2>" "<dés_3>" "<dés_4>" "<dés_5>"
    And toutes les catégories sont disponibles
    When le joueur place le jet dans la catégorie "<categorie>"
    Then le score du joueur est "<score_attendu>"
    And la catégorie "<categorie>" ne peut plus être utilisé
    Examples:
      | prénom_joueur | dés_1 | dés_2 | dés_3 | dés_4 | dés_5 | categorie    | score_attendu |
      | Herve         | 1     | 1     | 3     | 3     | 6     | chance       | 14            |
      | Francis       | 1     | 1     | 1     | 1     | 1     | yatzy        | 50            |
      | Jamal         | 2     | 3     | 1     | 1     | 1     | ones         | 3             |
      | Jamal         | 2     | 3     | 2     | 5     | 1     | twos         | 4             |
      | Jamal         | 2     | 3     | 2     | 5     | 1     | threes       | 3             |
      | Herve         | 1     | 1     | 2     | 4     | 4     | fours        | 8             |
      | Jamal         | 2     | 3     | 2     | 5     | 1     | fives        | 5             |
      | Jamal         | 2     | 3     | 2     | 6     | 6     | sixes        | 12            |
      | Francis       | 3     | 3     | 3     | 3     | 1     | paire        | 6             |
      | Francis       | 1     | 1     | 2     | 2     | 2     | deux paires  | 6             |
      | Jamal         | 3     | 3     | 3     | 3     | 1     | brelan       | 9             |
      | Jamal         | 2     | 2     | 2     | 2     | 2     | carre        | 8             |
      | Jamal         | 1     | 2     | 3     | 4     | 5     | petite suite | 15            |
      | Jamal         | 2     | 3     | 4     | 5     | 6     | grande suite | 20            |
      | Jamal         | 1     | 1     | 2     | 2     | 2     | full house   | 8             |
      | Francis       | 1     | 1     | 1     | 2     | 1     | yatzy        | 0             |
      | Herve         | 3     | 3     | 3     | 4     | 5     | ones         | 0             |
      | Francis       | 1     | 1     | 2     | 3     | 4     | deux paires  | 0             |
      | Jamal         | 3     | 3     | 4     | 5     | 6     | brelan       | 0             |
      | Herve         | 2     | 2     | 2     | 5     | 5     | carre        | 0             |
      | Jamal         | 2     | 2     | 3     | 3     | 4     | full house   | 0             |
      | Jamal         | 4     | 4     | 4     | 4     | 4     | full house   | 0             |

