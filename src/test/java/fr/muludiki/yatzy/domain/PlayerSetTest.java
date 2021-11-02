package fr.muludiki.yatzy.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PlayerSetTest {

  @Test
  public void shouldThrowExceptionWhenDesGreaterThan6() {
    assertThrows(IllegalArgumentException.class, () -> new PlayerSet(1, 1, 2, 2, 8));
  }
}
