package no.hvl.dat109.grensefjes;

import junit.framework.TestCase;
import no.hvl.dat109.Terning;
import org.junit.jupiter.api.Test;

public class TerningFjesTest extends TestCase {

	  @Test
	  public void testTrill() {
			for (int iterasjon = 0; iterasjon < 1000; iterasjon++) {
				  int s = Terning.trill();
				  assertTrue(1 <= s && s <= 6);
			}
	  }
}