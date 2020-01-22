package net.prodigylabs.test;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

public class Runner {

  public static void main(final String[] args) {
    final JUnitCore jUnitCore = new JUnitCore();
    jUnitCore.addListener(new TextListener(System.out));
    jUnitCore.run(ConsoleSmokeTest.class);
  }
}
